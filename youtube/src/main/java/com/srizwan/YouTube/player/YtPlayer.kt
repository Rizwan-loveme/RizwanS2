@file:androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)

package com.srizwan.YouTube.player

import android.content.Context
import android.os.Handler
import android.os.SystemClock
import android.os.Looper
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import com.srizwan.YouTube.R
import com.srizwan.YouTube.ui.GlassToast
import com.srizwan.YouTube.data.StreamDetails
import com.srizwan.YouTube.data.YtDownloader

/**
 * The one ExoPlayer of the YouTube app (process wide).
 *
 * It is a singleton on purpose: the player screen, the background service (part 5) and
 * picture-in-picture (part 7) must all talk to the same player, so leaving the screen
 * does not restart the video. Always touch it on the main thread.
 */
object YtPlayer {

    private var exo: ExoPlayer? = null
    private var appContext: Context? = null

    /**
     * True while the player screen is on screen (set by [PlayerActivity] in onStart / onStop).
     * [PlaybackService] reads it to know whether it may free the player when it ends.
     */
    @Volatile
    var screenVisible: Boolean = false

    /**
     * True while the floating popup ([FloatingPlayer]) shows the video. [PlaybackService] then does not
     * free the player, because the popup is a screen too.
     */
    @Volatile
    var floating: Boolean = false

    /** page url of the video that is loaded now (used to avoid reloading the same video) */
    var currentUrl: String? = null
        private set

    /** details of the loaded video, later parts read it for the quality menu / notification */
    var details: StreamDetails? = null
        private set

    /** the plan that is playing now (shows which quality is active) */
    var plan: StreamSources.Plan? = null
        private set

    /** the cap used for [plan]: [StreamSources.AUTO] or a height such as 720 */
    var maxHeight: Int = StreamSources.AUTO
        private set

    // ---- weak network: Auto drops to the lowest height ----
    /** True after an Auto video was switched to its lowest height because the network is weak. */
    var autoLowered: Boolean = false
        private set
    private var readyOnce = false
    private var seeking = false
    private val stallTimes = ArrayList<Long>()
    private const val STALL_WINDOW_MS = 40_000L
    private const val STALLS_TO_LOWER = 2

    private val stallListener = object : Player.Listener {
        override fun onPositionDiscontinuity(
            oldPosition: Player.PositionInfo, newPosition: Player.PositionInfo, reason: Int
        ) {
            if (reason == Player.DISCONTINUITY_REASON_SEEK) seeking = true
        }

        override fun onPlaybackStateChanged(playbackState: Int) {
            val p = exo ?: return
            when (playbackState) {
                Player.STATE_READY -> { readyOnce = true; seeking = false }
                // a stall = buffering again after playing, not caused by a seek, while the viewer wants to play
                Player.STATE_BUFFERING -> if (readyOnce && !seeking && p.playWhenReady) onStall()
            }
        }
    }

    private fun onStall() {
        val ctx = appContext ?: return
        val d = details ?: return
        val player = exo ?: return
        val p = plan as? StreamSources.Plan.Progressive ?: return // manifests adapt by themselves
        if (maxHeight != StreamSources.AUTO || autoLowered || d.isLive) return
        val now = SystemClock.elapsedRealtime()
        stallTimes.removeAll { now - it > STALL_WINDOW_MS }
        stallTimes.add(now)
        if (stallTimes.size < STALLS_TO_LOWER) return
        val lowest = StreamSources.heights(d).lastOrNull() ?: return
        if (lowest >= p.height) return // already the lowest
        try {
            load(ctx, d, lowest, startPositionMs = player.currentPosition, playWhenReady = player.playWhenReady)
            maxHeight = StreamSources.AUTO // still "Auto" for the menu; only the picture got smaller
            autoLowered = true
            GlassToast.show(ctx, R.drawable.ic_signal_low) // weak network: glass toast, icon only
        } catch (e: Exception) {
            // keep playing what plays now
        }
    }

    // ---- part 9: resume position ----
    /** [load] uses this as "start where the video was left last time" */
    const val RESUME = -1L

    /**
     * Where the last [load] continued a saved position (ms), or 0 when it started from the beginning.
     * The player screen reads it to show "Continuing from 12:34 · Start over".
     */
    var resumedFromMs: Long = 0L
        private set
    private const val SAVE_INTERVAL_MS = 5_000L
    private val handler = Handler(Looper.getMainLooper())
    private val saveTick = object : Runnable {
        override fun run() {
            saveResume()
            if (exo != null) handler.postDelayed(this, SAVE_INTERVAL_MS)
        }
    }
    private val endListener = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            // finished: the next time it starts from the beginning
            if (playbackState == Player.STATE_ENDED) saveResume()
        }
    }

    /**
     * Writes the position of the loaded video to [PlayerPrefs]. Called every 5 s while the player exists
     * (also in the background), when the screen is left, when the video ends and when the player is freed.
     * Live streams are not saved.
     */
    fun saveResume() {
        val player = exo ?: return
        val ctx = appContext ?: return
        val u = currentUrl ?: return
        if (details?.isLive == true || player.isCurrentMediaItemLive) return
        // still preparing: the position is 0 and would erase the saved one
        if (player.playbackState == Player.STATE_IDLE) return
        val duration = player.duration.takeIf { it != C.TIME_UNSET } ?: 0L
        val position = if (player.playbackState == Player.STATE_ENDED) duration else player.currentPosition
        PlayerPrefs.setResumePosition(ctx, u, position, duration)
    }

    /** The player; created on first use. */
    fun get(context: Context): ExoPlayer {
        exo?.let { return it }
        appContext = context.applicationContext
        val player = ExoPlayer.Builder(context.applicationContext)
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(C.USAGE_MEDIA)
                    .setContentType(C.AUDIO_CONTENT_TYPE_MOVIE)
                    .build(),
                /* handleAudioFocus = */ true
            )
            .setHandleAudioBecomingNoisy(true)
            .setWakeMode(C.WAKE_MODE_NETWORK)
            .build()
        player.setPlaybackSpeed(PlayerPrefs.speed(context))
        player.addListener(endListener)
        player.addListener(stallListener)
        exo = player
        handler.removeCallbacks(saveTick)
        handler.postDelayed(saveTick, SAVE_INTERVAL_MS)
        return player
    }

    /** HTTP with the extractor's user agent; redirects across http/https are allowed (googlevideo does this). */
    private fun dataSourceFactory(context: Context): DefaultDataSource.Factory {
        val http = DefaultHttpDataSource.Factory()
            .setUserAgent(YtDownloader.USER_AGENT)
            .setAllowCrossProtocolRedirects(true)
            .setConnectTimeoutMs(20_000)
            .setReadTimeoutMs(30_000)
        return DefaultDataSource.Factory(context.applicationContext, http)
    }

    /** The player if it exists, without creating it. */
    fun peek(): ExoPlayer? = exo

    /** True when [url] is already the loaded video (screen re-opened, came back from background). */
    fun isLoaded(url: String): Boolean = exo != null && currentUrl == url && details != null

    /**
     * Loads [d] and starts playing at [startPositionMs]; [RESUME] (default) continues where the video was
     * left last time, 0 or more starts at that position.
     * [height] is [StreamSources.AUTO] or the cap in pixels (the screen passes the saved quality).
     * Throws [StreamSources.NoStreamException] when the video has no playable stream.
     */
    fun load(
        context: Context,
        d: StreamDetails,
        height: Int = StreamSources.AUTO,
        startPositionMs: Long = RESUME,
        playWhenReady: Boolean = true
    ) {
        val player = get(context)
        autoLowered = false
        readyOnce = false
        seeking = false
        stallTimes.clear()
        // the video that was playing keeps its position before the new one replaces it
        if (currentUrl != null && currentUrl != d.url) saveResume()
        val start = when {
            startPositionMs != RESUME -> startPositionMs
            d.isLive -> 0L
            else -> PlayerPrefs.resumePosition(context, d.url)
        }
        val newPlan = StreamSources.plan(d, height)
        applyHeightLimit(player, newPlan, height)
        val source = StreamSources.mediaSource(dataSourceFactory(context), newPlan, d.title)
        player.setMediaSource(source, start.coerceAtLeast(0L))
        player.prepare()
        player.playWhenReady = playWhenReady
        resumedFromMs = if (startPositionMs == RESUME && start >= PlayerPrefs.RESUME_MIN_MS) start else 0L
        currentUrl = d.url
        details = d
        plan = newPlan
        maxHeight = height
    }

    // ---------------------------------------------------------------------------------------------
    // Part 3: quality
    // ---------------------------------------------------------------------------------------------

    /**
     * A manifest (HLS / DASH, live streams) chooses its own tracks, so the cap is a track-selection limit.
     * A merged stream already is the chosen height, so a limit left over from a manifest video is removed.
     */
    private fun applyHeightLimit(player: ExoPlayer, p: StreamSources.Plan, height: Int) {
        val b = player.trackSelectionParameters.buildUpon()
        if (p is StreamSources.Plan.Progressive) {
            b.clearVideoSizeConstraints()
        } else {
            b.setMaxVideoSize(Int.MAX_VALUE, if (height == StreamSources.AUTO) StreamSources.AUTO_CAP else height)
        }
        player.trackSelectionParameters = b.build()
    }

    /**
     * Picture heights the viewer can choose for the loaded video, best first (e.g. 1080, 720, 360).
     * Separate / muxed streams: the heights of the stream list. Manifest videos: the heights of the video
     * tracks the player found (empty until the manifest is parsed). Empty = nothing to choose.
     */
    fun availableHeights(): List<Int> {
        val d = details ?: return emptyList()
        if (plan is StreamSources.Plan.Progressive) return StreamSources.heights(d)
        val player = exo ?: return emptyList()
        val out = sortedSetOf<Int>()
        for (group in player.currentTracks.groups) {
            if (group.type != C.TRACK_TYPE_VIDEO) continue
            for (i in 0 until group.length) {
                val h = group.getTrackFormat(i).height
                if (h > 0) out.add(h)
            }
        }
        return out.toList().sortedDescending()
    }

    /**
     * Quality change for the loaded video: [height] is [StreamSources.AUTO] or a height such as 720.
     * Merged streams are loaded again at the same position (keeps playing or stays paused, speed stays);
     * manifests only get a new track limit, with no reload. Throws like [load].
     */
    fun setQuality(context: Context, height: Int) {
        val d = details ?: return
        val player = exo ?: return
        if (plan is StreamSources.Plan.Progressive) {
            if (height == maxHeight && !autoLowered) return
            load(context, d, height, startPositionMs = player.currentPosition, playWhenReady = player.playWhenReady)
        } else {
            applyHeightLimit(player, plan ?: return, height)
            maxHeight = height
        }
    }

    /**
     * Video picture on / off. Switched off while playing in the background (screen off, other app):
     * the audio goes on, the video stream is not decoded and, with separate streams, not downloaded.
     * Switched on again when the player screen comes back.
     */
    fun setVideoEnabled(enabled: Boolean) {
        val player = exo ?: return
        player.trackSelectionParameters = player.trackSelectionParameters.buildUpon()
            .setTrackTypeDisabled(C.TRACK_TYPE_VIDEO, !enabled)
            .build()
    }

    /** Stops playback and frees the player (and the background service that shows it). */
    fun release() {
        FloatingPlayer.hide() // the popup shows this player: it goes with it
        val ctx = appContext
        saveResume()
        handler.removeCallbacks(saveTick)
        exo?.removeListener(endListener)
        exo?.removeListener(stallListener)
        exo?.release()
        exo = null
        ctx?.let { PlaybackService.stop(it) }
        currentUrl = null
        details = null
        plan = null
        maxHeight = StreamSources.AUTO
        autoLowered = false
        resumedFromMs = 0L
    }
}
