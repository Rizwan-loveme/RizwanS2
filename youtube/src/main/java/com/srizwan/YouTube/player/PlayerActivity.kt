package com.srizwan.YouTube.player

import android.Manifest
import android.app.Activity
import android.app.PendingIntent
import android.app.PictureInPictureParams
import android.app.RemoteAction
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.util.Rational
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Lifecycle
import androidx.media3.common.C
import androidx.media3.common.PlaybackException
import androidx.media3.common.PlaybackParameters
import androidx.media3.common.Player
import androidx.media3.common.Tracks
import androidx.media3.common.VideoSize
import androidx.media3.ui.PlayerView
import com.srizwan.YouTube.R
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.databinding.ActivityPlayerBinding
import java.io.IOException

/**
 * Player screen of the built-in YouTube app. Open it with [start].
 *
 * Part 1 of the player plan: fetch the streams, play them with the shared [YtPlayer] and show
 * Media3's standard controls. Part 2: speed chip (top right, 0.25x - 2x, saved in [PlayerPrefs]).
 * Part 3: quality chip ("Auto" or the playing height, list of the heights the video has, saved in [PlayerPrefs]).
 * Part 5: background playback ([PlaybackService]); a "Background" chip turns it on / off (saved).
 * Part 7: picture-in-picture. A "PiP" chip, automatic PiP when you leave the screen while a video plays
 * (home gesture), and play/pause and -10s/+10s buttons inside the PiP window. Closing the PiP window stops
 * the video; tapping it brings the player screen back.
 * Part 4: fullscreen. The button in the player controls (or turning the phone sideways) hides the status and
 * navigation bars and, for a wide video, turns the screen to landscape; Back or the button leaves it.
 * Part 8: touch gestures ([PlayerGestures]): double-tap seek, volume / brightness swipes, tap for controls.
 * Part 9: remembered settings and resume position ([PlayerPrefs]): speed, quality and background playback are
 * saved when changed; the position of each video is saved every 5 s and when the screen is left, and the video
 * continues from it ("Continuing from 12:34 | Start over" hint for a few seconds).
 * The other parts are added on top of this screen.
 */
class PlayerActivity : AppCompatActivity() {

    private lateinit var b: ActivityPlayerBinding
    private var url: String = ""
    private var started = false
    private var fetching = false

    /** set in onStop: the video goes on in the background, so onDestroy must not release the player */
    private var keepAlive = false

    // ---- Part 4: fullscreen ----
    /** system bars hidden (immersive); the button state of the controls follows it */
    private var fullscreen = false

    private val fullscreenBack = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            setFullscreen(false)
        }
    }

    // ---- Part 7: picture-in-picture ----
    /** this device can show PiP windows (API 26+ is guaranteed by minSdk, the feature flag is not) */
    private val pipSupported: Boolean by lazy {
        packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)
    }

    /** the PiP window was just left (expanded or closed); cleared in onResume, which only an expand reaches */
    private var pipExitPending = false
    private var pipReceiverRegistered = false

    private val pipReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val p = YtPlayer.peek() ?: return
            when (intent.action) {
                ACTION_PIP_PLAY_PAUSE ->
                    if (p.playWhenReady && p.playbackState != Player.STATE_ENDED) {
                        p.pause()
                    } else {
                        if (p.playbackState == Player.STATE_ENDED) p.seekTo(0)
                        p.play()
                    }
                ACTION_PIP_REWIND -> p.seekTo((p.currentPosition - PIP_SEEK_MS).coerceAtLeast(0L))
                ACTION_PIP_FORWARD -> {
                    val target = p.currentPosition + PIP_SEEK_MS
                    val d = p.duration
                    p.seekTo(if (d != C.TIME_UNSET) target.coerceAtMost(d) else target)
                }
            }
            updatePipParams()
        }
    }

    // Android 13+: the playback notification needs this permission to be visible (asked once)
    private val notificationPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { }

    private val listener = object : Player.Listener {
        override fun onPlayerError(error: PlaybackException) {
            showError(messageFor(error))
        }

        // playback began while this screen is visible: start the background service now
        // (a foreground service may only be started from a visible app on Android 12+)
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            if (isPlaying && started && PlayerPrefs.backgroundPlay(this@PlayerActivity)) {
                PlaybackService.start(this@PlayerActivity)
            }
            updatePipParams() // auto-enter only while playing; play / pause button
        }

        override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
            updatePipParams()
        }

        // the PiP window takes the shape of the video (portrait, 16:9, ultra-wide)
        override fun onVideoSizeChanged(videoSize: VideoSize) {
            updatePipParams()
        }

        // part 3: the heights of a manifest video (live / HLS) are known only once its tracks are parsed
        override fun onTracksChanged(tracks: Tracks) {
            updateQualityChip()
        }

        // fires for the speed chip, and also for Media3's own settings menu
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
        b.retryButton.setOnClickListener { fetchAndPlay() }
        b.resumeRestart.setOnClickListener {
            YtPlayer.peek()?.seekTo(0L)
            hideResumeHint()
        }
        b.speedButton.setOnClickListener { showSpeedDialog() }
        onBackPressedDispatcher.addCallback(this, fullscreenBack)
        PlayerGestures(
            this, b.playerView, b.gestureHint, b.seekHintLeft, b.seekHintRight,
            player = { YtPlayer.peek() },
            toggleControls = {
                if (b.playerView.isControllerFullyVisible) b.playerView.hideController()
                else b.playerView.showController()
            }
        ).attach()
        b.playerView.setFullscreenButtonClickListener { toFullscreen -> setFullscreen(toFullscreen) }
        b.qualityButton.setOnClickListener { showQualityDialog() }
        b.backgroundButton.setOnClickListener { toggleBackground() }
        b.pipButton.visibility = if (pipSupported) View.VISIBLE else View.GONE
        b.pipButton.setOnClickListener { enterPip() }
        b.playerView.setControllerVisibilityListener(
            PlayerView.ControllerVisibilityListener { visibility -> b.chipRow.visibility = visibility }
        )
        updateSpeedChip(PlayerPrefs.speed(this))
        updateQualityChip()
        updateBackgroundChip()
        askNotificationPermissionOnce()
        // opened while the phone is already sideways: start in fullscreen
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) setFullscreen(true, rotate = false)
        if (!YtPlayer.isLoaded(url)) fetchAndPlay()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
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
        // the video picture was switched off while playing in the background: back on
        YtPlayer.setVideoEnabled(true)
        attachPlayer()
        // the player was freed while we were away (notification dismissed): load the video again
        if (!YtPlayer.isLoaded(url) && !fetching) fetchAndPlay()
        updatePipParams()
    }

    /** Bars come back after a dialog, the keyboard or a swipe; keep them hidden while in fullscreen. */
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && fullscreen && !isInPictureInPictureMode) applyFullscreen()
    }

    /** Turning the phone sideways = fullscreen, back upright = normal (for a video that was not forced). */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (isInPictureInPictureMode) return
        val landscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        if (landscape && !fullscreen) setFullscreen(true, rotate = false)
        else if (!landscape && fullscreen && isWideVideo()) setFullscreen(false)
    }

    override fun onResume() {
        super.onResume()
        // back from PiP by tapping the window: the screen is shown again, so it was not closed
        pipExitPending = false
    }

    /** Home gesture / home button while a video plays: Android 12+ enters PiP by itself (auto-enter), older ones here. */
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        // all versions: harmless when Android 12+ already entered PiP by itself (auto-enter)
        if (canEnterPip() && !isInPictureInPictureMode) enterPip(fromUser = false)
    }

    override fun onStop() {
        started = false
        YtPlayer.screenVisible = false
        YtPlayer.saveResume() // part 9: remember where the video was left
        hideResumeHint()
        val player = YtPlayer.peek()
        // Part 7: stopped while the PiP window was on screen and the screen is still on = the user closed
        // the PiP window. That ends the video (a screen-off in PiP is not a close: background playback decides).
        val pipClosed = (isInPictureInPictureMode || pipExitPending) && isScreenOn()
        if (pipClosed) {
            player?.pause()
            PlaybackService.stop(this)
        }
        if (player != null) {
            // Part 5: with background playback on, a playing video keeps playing (audio only, the
            // picture is switched off) and PlaybackService keeps the app alive. Otherwise pause.
            keepAlive = !pipClosed && PlayerPrefs.backgroundPlay(this) && PlaybackService.isPlaying(player)
            if (keepAlive) {
                YtPlayer.setVideoEnabled(false)
                PlaybackService.start(this) // no-op for an already running service
            } else {
                player.pause()
            }
            player.removeListener(listener)
        }
        b.playerView.player = null
        unregisterPipReceiver()
        super.onStop()
        if (pipClosed && !isFinishing) finish() // onDestroy then frees the player
    }

    override fun onDestroy() {
        unregisterPipReceiver()
        // finishing while it plays in the background: leave the player to the service
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
        b.playerView.setFullscreenButtonState(on)
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
    // Part 7: picture-in-picture
    // ---------------------------------------------------------------------------------------------

    private fun isScreenOn(): Boolean =
        (getSystemService(Context.POWER_SERVICE) as PowerManager).isInteractive

    /** A video is loaded and playing (or about to), so a PiP window makes sense. */
    private fun canEnterPip(): Boolean =
        pipSupported && !isFinishing && PlaybackService.isPlaying(YtPlayer.peek()) &&
            b.errorBox.visibility != View.VISIBLE

    /** The PiP chip: shrink the video into a floating window. */
    private fun enterPip(fromUser: Boolean = true) {
        if (!pipSupported || YtPlayer.peek() == null || isInPictureInPictureMode) return
        var error: Throwable? = null
        val entered = try {
            enterPictureInPictureMode(buildPipParams())
        } catch (e: Throwable) {
            error = e
            android.util.Log.w("PlayerActivity", "enterPictureInPictureMode failed, retrying without buttons", e)
            // a bad button / icon must not block PiP: try again with the picture only
            try { enterPictureInPictureMode(buildPipParams(withActions = false)) }
            catch (e2: Throwable) { error = e2; false }
        }
        if (!entered && !isInPictureInPictureMode && fromUser) {
            val why = error?.let { "${it.javaClass.simpleName}: ${it.message}" }
            val text = if (why != null) "PiP failed: $why" else getString(R.string.yt_player_pip_unavailable)
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }

    /** Keeps the system's PiP params current (aspect ratio, buttons, auto-enter). Cheap; safe to call often. */
    private fun updatePipParams() {
        if (!pipSupported || isFinishing || isDestroyed) return
        try {
            setPictureInPictureParams(buildPipParams())
        } catch (e: Throwable) {
            // before, this was swallowed silently and auto-enter was never switched on
            android.util.Log.w("PlayerActivity", "setPictureInPictureParams failed, retrying without buttons", e)
            try { setPictureInPictureParams(buildPipParams(withActions = false)) }
            catch (e2: Throwable) { android.util.Log.w("PlayerActivity", "PiP params rejected", e2) }
        }
    }

    private fun buildPipParams(withActions: Boolean = true): PictureInPictureParams {
        val player = YtPlayer.peek()
        val builder = PictureInPictureParams.Builder()
            .setAspectRatio(pipAspect(player?.videoSize))
        if (withActions) builder.setActions(pipActions(player))
        if (Build.VERSION.SDK_INT >= 31) {
            // leaving the app while a video plays opens PiP without any extra code; no zoom animation glitch
            builder.setAutoEnterEnabled(canEnterPip())
            builder.setSeamlessResizeEnabled(false)
        }
        return builder.build()
    }

    /** Video shape for the PiP window; the system only accepts 1:2.39 ... 2.39:1. */
    private fun pipAspect(size: VideoSize?): Rational {
        var ratio = 16f / 9f
        if (size != null && size.width > 0 && size.height > 0) {
            ratio = size.width * size.pixelWidthHeightRatio / size.height
        }
        ratio = ratio.coerceIn(0.42f, 2.38f)
        return Rational((ratio * 1000).toInt(), 1000)
    }

    private fun pipActions(player: Player?): List<RemoteAction> {
        val playing = player != null && player.playWhenReady && player.playbackState != Player.STATE_ENDED
        return listOf(
            pipAction(R.drawable.ic_pip_rewind, R.string.yt_player_pip_rewind, ACTION_PIP_REWIND, 1),
            if (playing) pipAction(R.drawable.ic_pip_pause, R.string.yt_player_pip_pause, ACTION_PIP_PLAY_PAUSE, 2)
            else pipAction(R.drawable.ic_pip_play, R.string.yt_player_pip_play, ACTION_PIP_PLAY_PAUSE, 2),
            pipAction(R.drawable.ic_pip_forward, R.string.yt_player_pip_forward, ACTION_PIP_FORWARD, 3)
        )
    }

    private fun pipAction(icon: Int, title: Int, action: String, requestCode: Int): RemoteAction {
        val pi = PendingIntent.getBroadcast(
            this, requestCode,
            Intent(action).setPackage(packageName),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val text = getString(title)
        return RemoteAction(Icon.createWithResource(this, icon), text, text, pi)
    }

    /** In the PiP window the screen's own chips and controls are hidden; they come back on expand. */
    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode) {
            pipExitPending = false
            b.playerView.useController = false
            b.chipRow.visibility = View.GONE
            hideResumeHint()
            registerPipReceiver()
        } else {
            pipExitPending = true
            unregisterPipReceiver()
            b.playerView.useController = true
            b.playerView.showController()
            if (fullscreen) applyFullscreen()
            // closed (not expanded): the activity is already stopped by now, onStop ends the video; if
            // the callback comes after onStop (older Android), do it here
            if (lifecycle.currentState == Lifecycle.State.CREATED && !isFinishing) {
                keepAlive = false
                YtPlayer.peek()?.pause()
                PlaybackService.stop(this)
                finish()
            }
        }
    }

    private fun registerPipReceiver() {
        if (pipReceiverRegistered) return
        val filter = IntentFilter().apply {
            addAction(ACTION_PIP_PLAY_PAUSE)
            addAction(ACTION_PIP_REWIND)
            addAction(ACTION_PIP_FORWARD)
        }
        ContextCompat.registerReceiver(this, pipReceiver, filter, ContextCompat.RECEIVER_NOT_EXPORTED)
        pipReceiverRegistered = true
    }

    private fun unregisterPipReceiver() {
        if (!pipReceiverRegistered) return
        runCatching { unregisterReceiver(pipReceiver) }
        pipReceiverRegistered = false
    }

    private fun updateBackgroundChip() {
        val on = PlayerPrefs.backgroundPlay(this)
        b.backgroundButton.setText(
            if (on) R.string.yt_player_background_on else R.string.yt_player_background_off
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
        updateSpeedChip(player.playbackParameters.speed)
        updateQualityChip()
    }

    /**
     * The quality chip: "Auto" or the height that plays now. Hidden while there is nothing to choose
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
        b.qualityButton.text = if (cap == StreamSources.AUTO) {
            getString(R.string.yt_player_quality_auto)
        } else {
            getString(R.string.yt_player_quality_height, StreamSources.nearest(heights, cap) ?: cap)
        }
    }

    /**
     * Quality list: Auto + every height of the video, best first. The choice is applied at once and saved
     * for the next videos. A video that does not have the saved height plays the nearest lower one.
     */
    private fun showQualityDialog() {
        val heights = YtPlayer.availableHeights()
        if (heights.isEmpty()) return
        val cap = YtPlayer.maxHeight
        val isMerged = YtPlayer.plan is StreamSources.Plan.Progressive
        val labels = ArrayList<String>(heights.size + 1)
        // merged streams: Auto is a known height; manifests change height by themselves, so just "Auto"
        val autoHeight = if (YtPlayer.autoLowered) heights.lastOrNull()
            else StreamSources.nearest(heights, StreamSources.AUTO_CAP)
        labels.add(
            if (isMerged && autoHeight != null) getString(R.string.yt_player_quality_auto_height, autoHeight)
            else getString(R.string.yt_player_quality_auto)
        )
        heights.forEach { labels.add(getString(R.string.yt_player_quality_height, it)) }
        val checked = if (cap == StreamSources.AUTO) 0 else {
            val idx = heights.indexOf(StreamSources.nearest(heights, cap))
            if (idx >= 0) idx + 1 else -1
        }
        AlertDialog.Builder(this)
            .setTitle(R.string.yt_player_quality_title)
            .setSingleChoiceItems(labels.toTypedArray(), checked) { dialog, which ->
                dialog.dismiss()
                val wanted = if (which == 0) StreamSources.AUTO else heights[which - 1]
                PlayerPrefs.setQuality(this, wanted)
                runCatching { YtPlayer.setQuality(this, wanted) }
                    .onFailure { showError(messageFor(it)) }
                updateQualityChip()
            }
            .show()
    }

    private fun updateSpeedChip(speed: Float) {
        b.speedButton.text = PlayerPrefs.speedLabel(speed)
    }

    /** Speed list (0.25x - 2x); the choice is applied at once and saved for the next video. */
    private fun showSpeedDialog() {
        val player = YtPlayer.peek() ?: return
        val current = player.playbackParameters.speed
        val speeds = PlayerPrefs.SPEEDS
        val labels = speeds.map {
            if (it == 1f) getString(R.string.yt_player_speed_normal) else PlayerPrefs.speedLabel(it)
        }.toTypedArray()
        val checked = speeds.indexOfFirst { Math.abs(it - current) < 0.001f }
        AlertDialog.Builder(this)
            .setTitle(R.string.yt_player_speed_title)
            .setSingleChoiceItems(labels, checked) { dialog, which ->
                player.setPlaybackSpeed(speeds[which])
                dialog.dismiss()
            }
            .show()
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
                        b.fetchProgress.visibility = View.GONE
                        b.errorBox.visibility = View.GONE
                        if (started) attachPlayer()
                        updateQualityChip()
                        if (started && YtPlayer.resumedFromMs > 0L) showResumeHint(YtPlayer.resumedFromMs)
                    }
                    .onFailure { showError(messageFor(it)) }
            }.onFailure { showError(messageFor(it)) }
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Part 9: resume hint ("Continuing from 12:34 | Start over")
    // ---------------------------------------------------------------------------------------------

    private val hideResume = Runnable { b.resumeBox.visibility = View.GONE }

    private fun showResumeHint(positionMs: Long) {
        b.resumeText.text = getString(R.string.yt_player_resume_hint, formatTime(positionMs))
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

    private fun showError(text: String) {
        b.fetchProgress.visibility = View.GONE
        b.errorText.text = text
        b.errorBox.visibility = View.VISIBLE
    }

    private fun messageFor(t: Throwable): String = getString(
        when {
            t is StreamSources.NoStreamException -> R.string.yt_player_error_no_stream
            t is IOException || t.cause is IOException -> R.string.yt_player_error_network
            t is PlaybackException && t.cause is IOException -> R.string.yt_player_error_network
            else -> R.string.yt_player_error_generic
        }
    )

    companion object {
        const val EXTRA_URL = "com.srizwan.YouTube.player.URL"

        private const val ACTION_PIP_PLAY_PAUSE = "com.srizwan.YouTube.player.PIP_PLAY_PAUSE"
        private const val ACTION_PIP_REWIND = "com.srizwan.YouTube.player.PIP_REWIND"
        private const val ACTION_PIP_FORWARD = "com.srizwan.YouTube.player.PIP_FORWARD"
        private const val PIP_SEEK_MS = 10_000L
        private const val RESUME_HINT_MS = 7_000L

        /** Opens the player for a YouTube page url (the `url` of a [com.srizwan.YouTube.data.YtItem.Video]). */
        fun start(context: Context, videoUrl: String) {
            val i = Intent(context, PlayerActivity::class.java).putExtra(EXTRA_URL, videoUrl)
            if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}
