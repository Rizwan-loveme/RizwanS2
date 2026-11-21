package com.srizwan.YouTube.player

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.PlaybackException
import androidx.media3.common.PlaybackParameters
import androidx.media3.common.Player
import androidx.media3.common.Tracks
import com.srizwan.YouTube.R
import com.srizwan.YouTube.data.YtHistory
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.databinding.ActivityPlayerBinding
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.GlassSheet
import com.srizwan.YouTube.ui.GlassToast
import com.srizwan.YouTube.ui.VectorLabelDrawable
import java.io.IOException

/**
 * Player screen of the built-in YouTube app. Open it with [start].
 *
 * It shows no text: controls are vector icons ([com.srizwan.YouTube.ui.GlassControls]), numbers such as the
 * speed are drawn as glyph outlines ([VectorLabelDrawable]), lists are a glass sheet ([GlassSheet]) and
 * messages are glass toasts ([GlassToast]).
 *
 * Part 1: fetch the streams, play them with the shared [YtPlayer]. Part 2: speed chip (0.25x - 2x).
 * Part 3: quality chip (Auto or the playing height). Part 4: fullscreen. Part 5: background playback
 * ([PlaybackService]), a chip turns it on / off. Part 7 (now): the floating popup window instead of
 * picture-in-picture ([FloatingPlayer]): the float chip, or leaving the app while a video plays, shows the video
 * in a small glass window over any app; its cross closes it. Part 8: touch gestures ([PlayerGestures]).
 * Part 9: remembered settings and resume position ([PlayerPrefs]).
 */
class PlayerActivity : AppCompatActivity() {

    private lateinit var b: ActivityPlayerBinding
    private var url: String = ""
    private var started = false
    private var fetching = false

    /** set in onStop: the video goes on in the background / in the popup, so onDestroy must not release the player */
    private var keepAlive = false

    // ---- Part 4: fullscreen ----
    /** system bars hidden (immersive); the button state of the controls follows it */
    private var fullscreen = false

    private val fullscreenBack = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            setFullscreen(false)
        }
    }

    // Android 13+: the playback notification needs this permission to be visible (asked once)
    private val notificationPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { }

    private val listener = object : Player.Listener {
        override fun onPlayerError(error: PlaybackException) {
            showError(iconFor(error))
        }

        // playback began while this screen is visible: start the background service now
        // (a foreground service may only be started from a visible app on Android 12+)
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            if (isPlaying && started && PlayerPrefs.backgroundPlay(this@PlayerActivity)) {
                PlaybackService.start(this@PlayerActivity)
            }
        }

        // part 3: the heights of a manifest video (live / HLS) are known only once its tracks are parsed
        override fun onTracksChanged(tracks: Tracks) {
            updateQualityChip()
        }

        // fires for the speed chip
        override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {
            PlayerPrefs.setSpeed(this@PlayerActivity, playbackParameters.speed)
            updateSpeedChip(playbackParameters.speed)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(b.root)

        // no url = opened from the playback notification: use the video that is loaded
        url = intent?.getStringExtra(EXTRA_URL).orEmpty().ifBlank { YtPlayer.currentUrl.orEmpty() }
        if (url.isBlank()) {
            finish()
            return
        }
        styleGlass()
        b.retryButton.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.ic_retry, iconSizeDp = 24f))
        b.resumeRestart.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.ic_restart, iconSizeDp = 20f))
        b.retryButton.setOnClickListener { fetchAndPlay() }
        b.resumeRestart.setOnClickListener {
            YtPlayer.peek()?.seekTo(0L)
            hideResumeHint()
        }
        b.speedButton.setOnClickListener { showSpeedSheet() }
        onBackPressedDispatcher.addCallback(this, fullscreenBack)
        PlayerGestures(
            this, b.playerView, b.gestureHint, b.seekHintLeft, b.seekHintRight,
            player = { YtPlayer.peek() },
            toggleControls = { b.controls.toggle() }
        ).attach()
        b.controls.onFullscreenClick = { setFullscreen(!fullscreen) }
        b.controls.onVisibilityChanged = { shown -> b.chipRow.visibility = if (shown) View.VISIBLE else View.GONE }
        b.qualityButton.setOnClickListener { showQualitySheet() }
        b.backgroundButton.setOnClickListener { toggleBackground() }
        b.floatButton.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.ic_float, iconSizeDp = 20f))
        b.floatButton.setOnClickListener { startFloating(auto = false) }
        updateSpeedChip(PlayerPrefs.speed(this))
        updateQualityChip()
        updateBackgroundChip()
        askNotificationPermissionOnce()
        // opened while the phone is already sideways: start in fullscreen
        if (intent?.getBooleanExtra(EXTRA_FULLSCREEN, false) == true) setFullscreen(true)
        else if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) setFullscreen(true, rotate = false)
        if (!YtPlayer.isLoaded(url)) fetchAndPlay()
    }

    /** Glass background for every chip and hint (the look is code, so there is no shape xml). */
    private fun styleGlass() {
        listOf(b.floatButton, b.backgroundButton, b.qualityButton, b.speedButton).forEach {
            it.background = GlassDrawable(this, 20f)
        }
        listOf(b.seekHintLeft, b.seekHintRight, b.gestureHint).forEach {
            it.background = GlassDrawable(this, 18f)
        }
        b.resumeBox.background = GlassDrawable(this, 20f)
        b.retryButton.background = GlassDrawable(this, 28f, strong = true)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        if (intent.getBooleanExtra(EXTRA_FULLSCREEN, false)) setFullscreen(true)
        val newUrl = intent.getStringExtra(EXTRA_URL).orEmpty()
        if (newUrl.isBlank() || newUrl == url) return
        url = newUrl
        if (started) attachPlayer()
        if (!YtPlayer.isLoaded(url)) fetchAndPlay()
    }

    override fun onStart() {
        super.onStart()
        started = true
        YtPlayer.screenVisible = true
        keepAlive = false
        GlassToast.host = this
        // the popup window gives the picture back to this screen
        FloatingPlayer.hide()
        // the video picture was switched off while playing in the background: back on
        YtPlayer.setVideoEnabled(true)
        attachPlayer()
        // the player was freed while we were away (notification dismissed, popup closed): load the video again
        if (!YtPlayer.isLoaded(url) && !fetching) fetchAndPlay()
    }

    /** Bars come back after a sheet, the keyboard or a swipe; keep them hidden while in fullscreen. */
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && fullscreen) applyFullscreen()
    }

    /** Turning the phone sideways = fullscreen, back upright = normal (for a video that was not forced). */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val landscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        if (landscape && !fullscreen) setFullscreen(true, rotate = false)
        else if (!landscape && fullscreen && isWideVideo()) setFullscreen(false)
    }

    /** Home gesture / home button while a video plays: it goes on in the floating popup (if allowed). */
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (canFloat()) startFloating(auto = true)
    }

    override fun onStop() {
        started = false
        YtPlayer.screenVisible = false
        if (GlassToast.host === this) GlassToast.host = null
        YtPlayer.saveResume() // part 9: remember where the video was left
        hideResumeHint()
        val player = YtPlayer.peek()
        if (player != null) {
            val floating = FloatingPlayer.isShowing
            // The popup window keeps playing with its picture. Otherwise, with background playback on, a playing
            // video keeps playing (audio only, the picture is switched off) and PlaybackService keeps the app
            // alive; else pause.
            keepAlive = floating || (PlayerPrefs.backgroundPlay(this) && PlaybackService.isPlaying(player))
            if (floating) {
                PlaybackService.start(this) // no-op for an already running service
            } else if (keepAlive) {
                YtPlayer.setVideoEnabled(false)
                PlaybackService.start(this)
            } else {
                player.pause()
            }
            player.removeListener(listener)
        }
        b.controls.bind(null)
        b.playerView.player = null
        super.onStop()
    }

    override fun onDestroy() {
        // finishing while it plays in the background / popup: leave the player to the service
        if (isFinishing && !keepAlive) YtPlayer.release()
        super.onDestroy()
    }

    // ---------------------------------------------------------------------------------------------
    // Part 4: fullscreen
    // ---------------------------------------------------------------------------------------------

    /** A landscape video (or one that is not known yet) fills the screen best when the phone is sideways. */
    private fun isWideVideo(): Boolean {
        val size = YtPlayer.peek()?.videoSize
        return size == null || size.width <= 0 || size.width >= size.height
    }

    /**
     * Fullscreen on / off. On: status + navigation bars hidden (swipe from the edge shows them for a moment)
     * and a wide video turns the screen to landscape. Off: bars back, the screen may turn upright again.
     * A tall video (Shorts) only hides the bars and stays upright. [rotate] is false when the user already
     * turned the phone sideways: the screen is then not locked, so turning it back upright leaves fullscreen.
     */
    private fun setFullscreen(on: Boolean, rotate: Boolean = true) {
        fullscreen = on
        requestedOrientation = when {
            on && rotate && isWideVideo() -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
            else -> ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
        applyFullscreen()
        fullscreenBack.isEnabled = on
        b.controls.setFullscreen(on)
    }

    private fun applyFullscreen() {
        val controller = WindowInsetsControllerCompat(window, b.root)
        WindowCompat.setDecorFitsSystemWindows(window, !fullscreen)
        if (fullscreen) {
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            controller.hide(WindowInsetsCompat.Type.systemBars())
            if (Build.VERSION.SDK_INT >= 28) {
                // use the area beside a camera cut-out in landscape
                window.attributes = window.attributes.also {
                    it.layoutInDisplayCutoutMode =
                        android.view.WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
                }
            }
        } else {
            controller.show(WindowInsetsCompat.Type.systemBars())
            if (Build.VERSION.SDK_INT >= 28) {
                window.attributes = window.attributes.also {
                    it.layoutInDisplayCutoutMode =
                        android.view.WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
                }
            }
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Part 7: floating popup window (replaces picture-in-picture)
    // ---------------------------------------------------------------------------------------------

    /** A video is playing (or about to), the popup is allowed and nothing is wrong: leaving the app may float it. */
    private fun canFloat(): Boolean =
        !isFinishing && FloatingPlayer.canDraw(this) && PlaybackService.isPlaying(YtPlayer.peek()) &&
            b.errorBox.visibility != View.VISIBLE

    /**
     * Shows the video in the floating popup over any app. [auto] = leaving the app by itself (the screen stays
     * where it is); the float chip ([auto] false) also closes this screen so the app behind it is shown.
     * Without the "Display over other apps" permission the chip opens that settings page (once granted, tap again).
     */
    private fun startFloating(auto: Boolean) {
        if (YtPlayer.peek() == null) return
        if (!FloatingPlayer.canDraw(this)) {
            if (!auto) {
                GlassToast.show(this, R.drawable.ic_lock)
                runCatching {
                    startActivity(
                        Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
                    )
                }
            }
            return
        }
        PlaybackService.start(this) // keeps the app alive while the popup is on screen
        YtPlayer.setVideoEnabled(true)
        if (!FloatingPlayer.show(applicationContext)) {
            if (!auto) GlassToast.show(this, R.drawable.ic_error)
            return
        }
        if (!auto) finish() // onStop sees the popup and keeps the player alive
    }

    // ---------------------------------------------------------------------------------------------

    private fun updateBackgroundChip() {
        val on = PlayerPrefs.backgroundPlay(this)
        b.backgroundButton.setImageDrawable(
            VectorLabelDrawable(
                this, null,
                if (on) R.drawable.ic_headphones else R.drawable.ic_headphones_off,
                iconSizeDp = 20f
            )
        )
        b.backgroundButton.alpha = if (on) 1f else 0.6f
    }

    /** Background playback on / off (saved). Off also removes the notification of a running service. */
    private fun toggleBackground() {
        val on = !PlayerPrefs.backgroundPlay(this)
        PlayerPrefs.setBackgroundPlay(this, on)
        updateBackgroundChip()
        if (on) {
            if (PlaybackService.isPlaying(YtPlayer.peek())) PlaybackService.start(this)
            askNotificationPermissionOnce()
        } else {
            PlaybackService.stop(this)
        }
    }

    private fun askNotificationPermissionOnce() {
        if (Build.VERSION.SDK_INT < 33 || !PlayerPrefs.backgroundPlay(this)) return
        if (PlayerPrefs.notificationPermissionAsked(this)) return
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
            PackageManager.PERMISSION_GRANTED
        ) return
        PlayerPrefs.setNotificationPermissionAsked(this)
        notificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
    }

    private fun attachPlayer() {
        val player = YtPlayer.get(this)
        player.removeListener(listener)
        player.addListener(listener)
        b.playerView.player = player
        b.controls.bind(player)
        updateSpeedChip(player.playbackParameters.speed)
        updateQualityChip()
    }

    /**
     * The quality chip: the auto icon, or the height that plays now. Hidden while there is nothing to choose
     * (nothing loaded yet, or the video has a single quality).
     */
    private fun updateQualityChip() {
        val heights = YtPlayer.availableHeights()
        if (heights.size < 2) {
            b.qualityButton.visibility = View.GONE
            return
        }
        b.qualityButton.visibility = View.VISIBLE
        val cap = YtPlayer.maxHeight
        val drawable = if (cap == StreamSources.AUTO) {
            VectorLabelDrawable(this, null, R.drawable.ic_auto_quality, iconSizeDp = 20f)
        } else {
            VectorLabelDrawable(
                this, "${StreamSources.nearest(heights, cap) ?: cap}p", R.drawable.ic_quality,
                textSizeDp = 13f, iconSizeDp = 18f
            )
        }
        b.qualityButton.setImageDrawable(drawable)
    }

    /**
     * Quality sheet: Auto + every height of the video, best first. The choice is applied at once and saved
     * for the next videos. A video that does not have the saved height plays the nearest lower one.
     */
    private fun showQualitySheet() {
        val heights = YtPlayer.availableHeights()
        if (heights.isEmpty()) return
        val cap = YtPlayer.maxHeight
        val isMerged = YtPlayer.plan is StreamSources.Plan.Progressive
        // merged streams: Auto is a known height; manifests change height by themselves, so just the icon
        val autoHeight = if (YtPlayer.autoLowered) heights.lastOrNull()
            else StreamSources.nearest(heights, StreamSources.AUTO_CAP)
        val checked = if (cap == StreamSources.AUTO) 0 else {
            val idx = heights.indexOf(StreamSources.nearest(heights, cap))
            if (idx >= 0) idx + 1 else -1
        }
        val rows = ArrayList<GlassSheet.Row>(heights.size + 1)
        rows.add(
            GlassSheet.Row(
                R.drawable.ic_auto_quality,
                if (isMerged && autoHeight != null) "${autoHeight}p" else null,
                checked == 0
            )
        )
        heights.forEachIndexed { i, h -> rows.add(GlassSheet.Row(R.drawable.ic_quality, "${h}p", checked == i + 1)) }
        GlassSheet.show(this, rows) { which ->
            val wanted = if (which == 0) StreamSources.AUTO else heights[which - 1]
            PlayerPrefs.setQuality(this, wanted)
            runCatching { YtPlayer.setQuality(this, wanted) }
                .onFailure { showError(iconFor(it)) }
            updateQualityChip()
        }
    }

    private fun updateSpeedChip(speed: Float) {
        b.speedButton.setImageDrawable(
            VectorLabelDrawable(this, PlayerPrefs.speedLabel(speed), R.drawable.ic_speed, textSizeDp = 13f, iconSizeDp = 18f)
        )
    }

    /** Speed sheet (0.25x - 2x); the choice is applied at once and saved for the next video. */
    private fun showSpeedSheet() {
        val player = YtPlayer.peek() ?: return
        val current = player.playbackParameters.speed
        val speeds = PlayerPrefs.SPEEDS
        val rows = speeds.map {
            GlassSheet.Row(R.drawable.ic_speed, PlayerPrefs.speedLabel(it), Math.abs(it - current) < 0.001f)
        }
        GlassSheet.show(this, rows) { which -> player.setPlaybackSpeed(speeds[which]) }
    }

    /** Fetches the stream list on a background thread, then starts playback on the main thread. */
    private fun fetchAndPlay() {
        val wanted = url
        fetching = true
        showFetching()
        YtRepository.async({ YtRepository.stream(wanted) }) { result ->
            fetching = false
            if (isDestroyed || wanted != url) return@async
            result.onSuccess { details ->
                // saved quality (part 9) and the position where this video was left (YtPlayer.RESUME)
                runCatching {
                    YtPlayer.load(
                        this, details,
                        height = PlayerPrefs.quality(this),
                        playWhenReady = started
                    )
                }
                    .onSuccess {
                        // step 7: the video is in the local watch history (newest first; watching it again moves it up)
                        YtHistory.init(this)
                        YtHistory.addWatch(
                            url = wanted, title = details.title, thumb = details.thumb,
                            channel = details.uploader, channelUrl = details.uploaderUrl,
                            duration = details.duration
                        )
                        b.fetchProgress.visibility = View.GONE
                        b.errorBox.visibility = View.GONE
                        if (started) attachPlayer()
                        updateQualityChip()
                        if (started && YtPlayer.resumedFromMs > 0L) showResumeHint(YtPlayer.resumedFromMs)
                    }
                    .onFailure { showError(iconFor(it)) }
            }.onFailure { showError(iconFor(it)) }
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Part 9: resume hint (clock icon + saved time + start-over icon)
    // ---------------------------------------------------------------------------------------------

    private val hideResume = Runnable { b.resumeBox.visibility = View.GONE }

    private fun showResumeHint(positionMs: Long) {
        b.resumeText.setImageDrawable(
            VectorLabelDrawable(this, formatTime(positionMs), R.drawable.ic_resume, textSizeDp = 13f, iconSizeDp = 18f)
        )
        b.resumeBox.visibility = View.VISIBLE
        b.resumeBox.removeCallbacks(hideResume)
        b.resumeBox.postDelayed(hideResume, RESUME_HINT_MS)
    }

    private fun hideResumeHint() {
        if (!::b.isInitialized) return
        b.resumeBox.removeCallbacks(hideResume)
        b.resumeBox.visibility = View.GONE
    }

    /** 754000 -> "12:34", 3723000 -> "1:02:03" */
    private fun formatTime(ms: Long): String {
        val total = ms / 1000
        val h = total / 3600
        val m = (total % 3600) / 60
        val s = total % 60
        return if (h > 0) String.format(java.util.Locale.US, "%d:%02d:%02d", h, m, s)
        else String.format(java.util.Locale.US, "%d:%02d", m, s)
    }

    private fun showFetching() {
        b.errorBox.visibility = View.GONE
        b.fetchProgress.visibility = View.VISIBLE
    }

    private fun showError(iconRes: Int) {
        b.fetchProgress.visibility = View.GONE
        b.errorIcon.setImageDrawable(VectorLabelDrawable(this, null, iconRes, iconSizeDp = 48f))
        b.errorBox.visibility = View.VISIBLE
    }

    /** No connection = the wifi-off icon; anything else (no stream, cannot decode) = the error icon. */
    private fun iconFor(t: Throwable): Int = when {
        t is IOException || t.cause is IOException -> R.drawable.ic_wifi_off
        t is PlaybackException && t.cause is IOException -> R.drawable.ic_wifi_off
        else -> R.drawable.ic_error
    }

    companion object {
        const val EXTRA_URL = "com.srizwan.YouTube.player.URL"
        /** true = open in fullscreen (the popup's expand button) */
        const val EXTRA_FULLSCREEN = "com.srizwan.YouTube.player.FULLSCREEN"

        /**
         * Intent that brings the player screen back in fullscreen for the video that is loaded (the popup window's
         * expand button). No url: the screen uses the loaded video, and its onStart takes the picture from the popup.
         */
        fun fullscreenIntent(context: Context): Intent =
            Intent(context, PlayerActivity::class.java)
                .putExtra(EXTRA_FULLSCREEN, true)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)

        private const val RESUME_HINT_MS = 7_000L

        /** Opens the player for a YouTube page url (the `url` of a [com.srizwan.YouTube.data.YtItem.Video]). */
        fun start(context: Context, videoUrl: String) {
            val i = Intent(context, PlayerActivity::class.java).putExtra(EXTRA_URL, videoUrl)
            if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}
