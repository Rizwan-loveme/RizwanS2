package com.srizwan.video.player

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.PlaybackParameters
import androidx.media3.common.Player
import androidx.media3.common.Tracks
import androidx.media3.common.VideoSize
import com.srizwan.video.R
import com.srizwan.video.databinding.VpActivityPlayerBinding
import com.srizwan.video.ui.GlassDrawable
import com.srizwan.video.ui.GlassSheet
import com.srizwan.video.ui.GlassToast
import com.srizwan.video.ui.VectorLabelDrawable
import java.io.IOException

/**
 * Player screen of the Video app (the File Manager, the Video app and other apps open it with [start]).
 *
 * Same player as the built-in YouTube app: no text views (controls are vector icons, numbers are glyph outlines),
 * glass chips and sheets, touch gestures ([PlayerGestures]), fullscreen, floating popup window ([FloatingPlayer]),
 * background playback ([PlaybackService]), saved speed and resume position ([VideoPrefs]).
 * The resolution chip shows what plays ("4K", "1080p" ...); an adaptive link lets you cap it.
 */
class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var b: VpActivityPlayerBinding

    /** file path, content uri or link of the video */
    private var source: String = ""
    private var started = false

    /** set in onStop: the video goes on in the background / in the popup, so onDestroy must not release the player */
    private var keepAlive = false

    // ---- fullscreen ----
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
            if (isPlaying && started && VideoPrefs.backgroundPlay(this@VideoPlayerActivity)) {
                PlaybackService.start(this@VideoPlayerActivity)
            }
        }

        // the next / previous video of the list started (button, or the last one ended): follow it
        override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
            VideoEngine.currentSource?.let { source = it }
            hideResumeHint()
            updateTitle()
            updateQualityChip()
            updateSkipChips()
        }

        override fun onTracksChanged(tracks: Tracks) {
            updateQualityChip()
        }

        override fun onVideoSizeChanged(videoSize: VideoSize) {
            updateQualityChip()
        }

        // fires for the speed chip
        override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {
            VideoPrefs.setSpeed(this@VideoPlayerActivity, playbackParameters.speed)
            updateSpeedChip(playbackParameters.speed)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = VpActivityPlayerBinding.inflate(layoutInflater)
        setContentView(b.root)

        // no source = opened from the playback notification: use the video that is loaded
        source = sourceOf(intent).ifBlank { VideoEngine.currentSource ?: VideoEngine.currentKey.orEmpty() }
        if (source.isBlank()) {
            finish()
            return
        }
        styleGlass()
        b.retryButton.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.vp_ic_retry, iconSizeDp = 24f))
        b.resumeRestart.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.vp_ic_restart, iconSizeDp = 20f))
        b.retryButton.setOnClickListener { loadVideo() }
        b.resumeRestart.setOnClickListener {
            VideoEngine.peek()?.seekTo(0L)
            hideResumeHint()
        }
        b.speedButton.setOnClickListener { showSpeedSheet() }
        onBackPressedDispatcher.addCallback(this, fullscreenBack)
        PlayerGestures(
            this, b.playerView, b.gestureHint, b.seekHintLeft, b.seekHintRight,
            player = { VideoEngine.peek() },
            toggleControls = { b.controls.toggle() }
        ).attach()
        b.controls.onFullscreenClick = { setFullscreen(!fullscreen) }
        b.controls.onVisibilityChanged = { shown ->
            val v = if (shown) View.VISIBLE else View.GONE
            b.chipRow.visibility = v
            b.titleView.visibility = v
        }
        b.qualityButton.setOnClickListener { showQualitySheet() }
        b.backgroundButton.setOnClickListener { toggleBackground() }
        b.prevButton.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.vp_ic_skip_prev, iconSizeDp = 20f))
        b.nextButton.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.vp_ic_skip_next, iconSizeDp = 20f))
        b.prevButton.setOnClickListener { VideoEngine.playPrevious() }
        b.nextButton.setOnClickListener { VideoEngine.playNext() }
        updateSkipChips()
        b.floatButton.setImageDrawable(VectorLabelDrawable(this, null, R.drawable.vp_ic_float, iconSizeDp = 20f))
        b.floatButton.setOnClickListener { startFloating(auto = false) }
        updateSpeedChip(VideoPrefs.speed(this))
        updateQualityChip()
        updateBackgroundChip()
        updateTitle()
        askNotificationPermissionOnce()
        // opened while the phone is already sideways: start in fullscreen
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) setFullscreen(true, rotate = false)
    }

    /** File path / uri of the intent: our own extra first, then the data of a VIEW intent from another app. */
    private fun sourceOf(i: Intent?): String =
        i?.getStringExtra(EXTRA_SOURCE)?.takeIf { it.isNotBlank() }
            ?: i?.data?.let { d -> if (d.scheme == "file") d.path else d.toString() }.orEmpty()

    /** Glass background for every chip and hint (the look is code, so there is no shape xml). */
    private fun styleGlass() {
        listOf(b.prevButton, b.nextButton, b.floatButton, b.backgroundButton, b.qualityButton, b.speedButton).forEach {
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
        val newSource = sourceOf(intent)
        if (newSource.isBlank() || newSource == source) return
        source = newSource
        if (started) attachPlayer()
        if (!VideoEngine.isLoaded(source)) loadVideo()
    }

    override fun onStart() {
        super.onStart()
        started = true
        VideoEngine.screenVisible = true
        keepAlive = false
        GlassToast.host = this
        // the popup window gives the picture back to this screen
        FloatingPlayer.hide()
        // the video picture was switched off while playing in the background: back on
        VideoEngine.setVideoEnabled(true)
        // the list went on while we were away (the video ended in the background): show the one that plays now
        if (VideoEngine.queue.contains(source)) VideoEngine.currentSource?.let { source = it }
        // not loaded yet (first open) or freed while we were away (notification dismissed, popup closed)
        if (!VideoEngine.isLoaded(source)) loadVideo() else attachPlayer()
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
        VideoEngine.screenVisible = false
        if (GlassToast.host === this) GlassToast.host = null
        VideoEngine.saveResume() // remember where the video was left
        hideResumeHint()
        val player = VideoEngine.peek()
        if (player != null) {
            val floating = FloatingPlayer.isShowing
            // The popup window keeps playing with its picture. Otherwise, with background playback on, a playing
            // video keeps playing (audio only, the picture is switched off) and PlaybackService keeps the app
            // alive; else pause.
            keepAlive = floating || (VideoPrefs.backgroundPlay(this) && PlaybackService.isPlaying(player))
            if (floating) {
                PlaybackService.start(this) // no-op for an already running service
            } else if (keepAlive) {
                VideoEngine.setVideoEnabled(false)
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
        if (isFinishing && !keepAlive) VideoEngine.release()
        super.onDestroy()
    }

    // ---------------------------------------------------------------------------------------------
    // Fullscreen
    // ---------------------------------------------------------------------------------------------

    /** A landscape video (or one that is not known yet) fills the screen best when the phone is sideways. */
    private fun isWideVideo(): Boolean {
        val size = VideoEngine.peek()?.videoSize
        return size == null || size.width <= 0 || size.width >= size.height
    }

    /**
     * Fullscreen on / off. On: status + navigation bars hidden (swipe from the edge shows them for a moment)
     * and a wide video turns the screen to landscape. Off: bars back, the screen may turn upright again.
     * A tall video only hides the bars and stays upright. [rotate] is false when the user already
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
    // Floating popup window
    // ---------------------------------------------------------------------------------------------

    /** A video is playing (or about to), the popup is allowed and nothing is wrong: leaving the app may float it. */
    private fun canFloat(): Boolean =
        !isFinishing && FloatingPlayer.canDraw(this) && PlaybackService.isPlaying(VideoEngine.peek()) &&
            b.errorBox.visibility != View.VISIBLE

    /**
     * Shows the video in the floating popup over any app. [auto] = leaving the app by itself (the screen stays
     * where it is); the float chip ([auto] false) also closes this screen so the app behind it is shown.
     * Without the "Display over other apps" permission the chip opens that settings page (once granted, tap again).
     */
    private fun startFloating(auto: Boolean) {
        if (VideoEngine.peek() == null) return
        if (!FloatingPlayer.canDraw(this)) {
            if (!auto) {
                GlassToast.show(this, R.drawable.vp_ic_lock)
                runCatching {
                    startActivity(
                        Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
                    )
                }
            }
            return
        }
        PlaybackService.start(this) // keeps the app alive while the popup is on screen
        VideoEngine.setVideoEnabled(true)
        if (!FloatingPlayer.show(applicationContext)) {
            if (!auto) GlassToast.show(this, R.drawable.vp_ic_error)
            return
        }
        if (!auto) finish() // onStop sees the popup and keeps the player alive
    }

    // ---------------------------------------------------------------------------------------------
    // Background playback
    // ---------------------------------------------------------------------------------------------

    private fun updateBackgroundChip() {
        val on = VideoPrefs.backgroundPlay(this)
        b.backgroundButton.setImageDrawable(
            VectorLabelDrawable(
                this, null,
                if (on) R.drawable.vp_ic_headphones else R.drawable.vp_ic_headphones_off,
                iconSizeDp = 20f
            )
        )
        b.backgroundButton.alpha = if (on) 1f else 0.6f
    }

    /** Background playback on / off (saved). Off also removes the notification of a running service. */
    private fun toggleBackground() {
        val on = !VideoPrefs.backgroundPlay(this)
        VideoPrefs.setBackgroundPlay(this, on)
        updateBackgroundChip()
        if (on) {
            if (PlaybackService.isPlaying(VideoEngine.peek())) PlaybackService.start(this)
            askNotificationPermissionOnce()
        } else {
            PlaybackService.stop(this)
        }
    }

    private fun askNotificationPermissionOnce() {
        if (Build.VERSION.SDK_INT < 33 || !VideoPrefs.backgroundPlay(this)) return
        if (VideoPrefs.notificationPermissionAsked(this)) return
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
            PackageManager.PERMISSION_GRANTED
        ) return
        VideoPrefs.setNotificationPermissionAsked(this)
        notificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
    }

    // ---------------------------------------------------------------------------------------------
    // Player, chips, sheets
    // ---------------------------------------------------------------------------------------------

    private fun attachPlayer() {
        val player = VideoEngine.get(this)
        player.removeListener(listener)
        player.addListener(listener)
        b.playerView.player = player
        b.controls.bind(player)
        updateSpeedChip(player.playbackParameters.speed)
        updateQualityChip()
        updateTitle()
    }

    /** Previous / next chips: only for a video opened from a list; a chip with nothing to go to is dimmed. */
    private fun updateSkipChips() {
        val inList = VideoEngine.queue.size > 1
        val v = if (inList) View.VISIBLE else View.GONE
        b.prevButton.visibility = v
        b.nextButton.visibility = v
        b.prevButton.alpha = if (VideoEngine.hasPrevious()) 1f else 0.4f
        b.nextButton.alpha = if (VideoEngine.hasNext()) 1f else 0.4f
    }

    private fun updateTitle() {
        val t = VideoEngine.title
        if (t.isNullOrBlank()) {
            b.titleView.visibility = View.GONE
        } else {
            b.titleView.set(t, 15f, Color.WHITE, bold = true, maxLines = 1)
            b.titleView.visibility = if (b.controls.isOpen) View.VISIBLE else View.GONE
        }
    }

    /** "4K", "2K", "1080p" ... of a picture height (16:9 is assumed for the long side). */
    private fun heightLabel(h: Int): String = VideoEngine.resolutionLabel(h * 16 / 9, h)

    /** The resolution chip: the label of the picture that plays now. Hidden until the size is known. */
    private fun updateQualityChip() {
        val label = VideoEngine.currentResolutionLabel()
        if (label == null) {
            b.qualityButton.visibility = View.GONE
            return
        }
        b.qualityButton.visibility = View.VISIBLE
        val drawable = if (VideoEngine.maxHeight == VideoEngine.AUTO || VideoEngine.availableHeights().size < 2) {
            VectorLabelDrawable(this, label, R.drawable.vp_ic_quality, textSizeDp = 13f, iconSizeDp = 18f)
        } else {
            VectorLabelDrawable(this, heightLabel(VideoEngine.maxHeight), R.drawable.vp_ic_quality, textSizeDp = 13f, iconSizeDp = 18f)
        }
        b.qualityButton.setImageDrawable(drawable)
    }

    /**
     * Resolution sheet. A plain file has one picture size: the sheet shows it (checked). An adaptive (HLS / DASH)
     * link lists Auto + every height; the choice caps the picture height at once.
     */
    private fun showQualitySheet() {
        val current = VideoEngine.currentResolutionLabel() ?: return
        val heights = VideoEngine.availableHeights()
        if (heights.size < 2) {
            GlassSheet.show(this, listOf(GlassSheet.Row(R.drawable.vp_ic_quality, current, true))) { }
            return
        }
        val cap = VideoEngine.maxHeight
        val rows = ArrayList<GlassSheet.Row>(heights.size + 1)
        rows.add(GlassSheet.Row(R.drawable.vp_ic_auto_quality, null, cap == VideoEngine.AUTO))
        heights.forEach { h -> rows.add(GlassSheet.Row(R.drawable.vp_ic_quality, heightLabel(h), cap == h)) }
        GlassSheet.show(this, rows) { which ->
            VideoEngine.setMaxHeight(if (which == 0) VideoEngine.AUTO else heights[which - 1])
            updateQualityChip()
        }
    }

    private fun updateSpeedChip(speed: Float) {
        b.speedButton.setImageDrawable(
            VectorLabelDrawable(this, VideoPrefs.speedLabel(speed), R.drawable.vp_ic_speed, textSizeDp = 13f, iconSizeDp = 18f)
        )
    }

    /** Speed sheet (0.25x - 2x); the choice is applied at once and saved for the next video. */
    private fun showSpeedSheet() {
        val player = VideoEngine.peek() ?: return
        val current = player.playbackParameters.speed
        val speeds = VideoPrefs.SPEEDS
        val rows = speeds.map {
            GlassSheet.Row(R.drawable.vp_ic_speed, VideoPrefs.speedLabel(it), Math.abs(it - current) < 0.001f)
        }
        GlassSheet.show(this, rows) { which -> player.setPlaybackSpeed(speeds[which]) }
    }

    /** Loads the video into the shared player (continues where it was left) and shows it. */
    private fun loadVideo() {
        b.errorBox.visibility = View.GONE
        b.fetchProgress.visibility = View.GONE
        try {
            // the title extra belongs to the video the intent opened; after next / previous the file name is used
            val title = if (sourceOf(intent) == source) intent?.getStringExtra(EXTRA_TITLE) else null
            VideoEngine.load(this, source, title, playWhenReady = started)
        } catch (e: Throwable) {
            showError(R.drawable.vp_ic_error)
            return
        }
        if (started) attachPlayer()
        updateTitle()
        updateSkipChips()
        if (started && VideoEngine.resumedFromMs > 0L) showResumeHint(VideoEngine.resumedFromMs)
    }

    // ---------------------------------------------------------------------------------------------
    // Resume hint (clock icon + saved time + start-over icon)
    // ---------------------------------------------------------------------------------------------

    private val hideResume = Runnable { b.resumeBox.visibility = View.GONE }

    private fun showResumeHint(positionMs: Long) {
        b.resumeText.setImageDrawable(
            VectorLabelDrawable(this, formatTime(positionMs), R.drawable.vp_ic_resume, textSizeDp = 13f, iconSizeDp = 18f)
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

    private fun showError(iconRes: Int) {
        b.fetchProgress.visibility = View.GONE
        b.errorIcon.setImageDrawable(VectorLabelDrawable(this, null, iconRes, iconSizeDp = 48f))
        b.errorBox.visibility = View.VISIBLE
    }

    /** No connection (a link) = the wifi-off icon; anything else (cannot decode, file missing) = the error icon. */
    private fun iconFor(t: Throwable): Int = when {
        t is PlaybackException && t.cause is IOException &&
            VideoEngine.currentKey?.startsWith("http", ignoreCase = true) == true -> R.drawable.vp_ic_wifi_off
        else -> R.drawable.vp_ic_error
    }

    companion object {
        const val EXTRA_SOURCE = "com.srizwan.video.player.SOURCE"
        const val EXTRA_TITLE = "com.srizwan.video.player.TITLE"

        private const val RESUME_HINT_MS = 7_000L

        /** Opens the player for a file path, a content uri or a link. [title] defaults to the file name. [playlist] = the videos around it (same folder / list). */
        fun start(context: Context, source: String, title: String? = null, playlist: List<String>? = null) {
            // the list the video belongs to (its folder): next / previous and auto-play of the next one
            VideoEngine.setQueue(playlist ?: emptyList(), source)
            val i = Intent(context, VideoPlayerActivity::class.java)
                .putExtra(EXTRA_SOURCE, source)
                .putExtra(EXTRA_TITLE, title)
            if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}
