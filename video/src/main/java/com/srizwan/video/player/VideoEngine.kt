@file:androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)

package com.srizwan.video.player

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.Player
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import java.io.File

/**
 * The one ExoPlayer of the Video app (process wide).
 *
 * It is a singleton on purpose: the player screen, the background service and the floating popup must all
 * talk to the same player, so leaving the screen does not restart the video. Always touch it on the main thread.
 *
 * 4K: the player is built so nothing limits the picture on the way to the screen.
 *  - the track selector has no viewport / size / bitrate cap (by default Media3 limits the picture to the size
 *    of the display, which would turn a 4K video into 1080p on a Full HD phone),
 *  - decoder fallback is on: when the first (hardware) decoder of a codec fails, the next one is tried
 *    (HEVC, VP9 and AV1 4K files play as far as the phone's own codecs allow),
 *  - [resolutionLabel] turns the size into "4K", "2K", "1080p" ... for the resolution chip.
 */
object VideoEngine {

    private var exo: ExoPlayer? = null
    private var appContext: Context? = null

    /** True while the player screen is on screen (set by [VideoPlayerActivity] in onStart / onStop). */
    @Volatile
    var screenVisible: Boolean = false

    /** True while the floating popup ([FloatingPlayer]) shows the video. */
    @Volatile
    var floating: Boolean = false

    /** Key of the video that is loaded now (its uri as text); used to avoid reloading the same video. */
    var currentKey: String? = null
        private set

    /** The source (file path / uri / link) of the loaded video, as it was given to [load]. */
    var currentSource: String? = null
        private set

    // ---- queue: the videos of the folder / list the viewer opened this one from ----
    /** Sources of the list the loaded video belongs to (empty = a single video). Set with [setQueue]. */
    var queue: List<String> = emptyList()
        private set
    private var queueIndex = -1

    /**
     * Remembers the list [current] was opened from, so next / previous and "play the next one when this ends" work.
     * Call it BEFORE [load]. A list with fewer than two videos, or without [current], clears the queue.
     */
    fun setQueue(list: List<String>, current: String) {
        val at = list.indexOf(current)
        if (list.size < 2 || at < 0) {
            queue = emptyList()
            queueIndex = -1
        } else {
            queue = list.toList()
            queueIndex = at
        }
    }

    fun hasNext(): Boolean = queueIndex >= 0 && queueIndex < queue.size - 1
    fun hasPrevious(): Boolean = queueIndex > 0

    /** Plays the next video of the queue from its start. False when there is none. */
    fun playNext(): Boolean = playQueueAt(queueIndex + 1)

    /** Plays the previous video of the queue from its start. False when there is none. */
    fun playPrevious(): Boolean = playQueueAt(queueIndex - 1)

    private fun playQueueAt(i: Int): Boolean {
        val ctx = appContext ?: return false
        if (i < 0 || i >= queue.size) return false
        val src = queue[i]
        return try {
            load(ctx, src, null, startPositionMs = 0L, playWhenReady = true)
            true
        } catch (e: Throwable) {
            false
        }
    }

    /** Title of the loaded video (the file name), for the notification and the player screen. */
    var title: String? = null
        private set

    /** Cap of the picture height: [AUTO] (no cap) or a height such as 1080. Only matters for adaptive (HLS / DASH) videos. */
    const val AUTO = 0
    var maxHeight: Int = AUTO
        private set

    // ---- resume position ----
    /** [load] uses this as "start where the video was left last time" */
    const val RESUME = -1L

    /**
     * Where the last [load] continued a saved position (ms), or 0 when it started from the beginning.
     * The player screen reads it to show "Continuing from 12:34 | Start over".
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
            if (playbackState == Player.STATE_ENDED) {
                saveResume()
                // the next video of the folder / list starts by itself
                if (hasNext()) playNext()
            }
        }
    }

    /** What the viewer gave to the player: a path of a file, or a link / content uri. Returns the uri and its key. */
    fun uriOf(source: String): Uri {
        val s = source.trim()
        return if (s.startsWith("/")) Uri.fromFile(File(s)) else Uri.parse(s)
    }

    /** The key a source is stored under (resume position, "is it loaded"). */
    fun keyOf(source: String): String = uriOf(source).toString()

    /**
     * Writes the position of the loaded video to [VideoPrefs]. Called every 5 s while the player exists
     * (also in the background), when the screen is left, when the video ends and when the player is freed.
     * Live streams are not saved.
     */
    fun saveResume() {
        val player = exo ?: return
        val ctx = appContext ?: return
        val key = currentKey ?: return
        if (player.isCurrentMediaItemLive) return
        // still preparing: the position is 0 and would erase the saved one
        if (player.playbackState == Player.STATE_IDLE) return
        val duration = player.duration.takeIf { it != C.TIME_UNSET } ?: 0L
        val position = if (player.playbackState == Player.STATE_ENDED) duration else player.currentPosition
        VideoPrefs.setResumePosition(ctx, key, position, duration)
    }

    /** The player; created on first use. */
    fun get(context: Context): ExoPlayer {
        exo?.let { return it }
        val app = context.applicationContext
        appContext = app

        // Renderers: decoder fallback on, no extension (software) renderers.
        val renderers = DefaultRenderersFactory(app)
            .setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF)
            .setEnableDecoderFallback(true)

        // Track selection: no viewport, size or bitrate cap, so 4K (3840x2160 and above) reaches the decoder.
        val selector = DefaultTrackSelector(app)
        selector.setParameters(
            selector.buildUponParameters()
                .clearViewportSizeConstraints()
                .clearVideoSizeConstraints()
                .setMaxVideoBitrate(Int.MAX_VALUE)
                .build()
        )

        val player = ExoPlayer.Builder(app, renderers)
            .setTrackSelector(selector)
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(C.USAGE_MEDIA)
                    .setContentType(C.AUDIO_CONTENT_TYPE_MOVIE)
                    .build(),
                /* handleAudioFocus = */ true
            )
            .setHandleAudioBecomingNoisy(true)
            .setWakeMode(C.WAKE_MODE_LOCAL)
            .build()
        player.setPlaybackSpeed(VideoPrefs.speed(app))
        player.addListener(endListener)
        exo = player
        handler.removeCallbacks(saveTick)
        handler.postDelayed(saveTick, SAVE_INTERVAL_MS)
        return player
    }

    /** The player if it exists, without creating it. */
    fun peek(): ExoPlayer? = exo

    /** True when [source] is already the loaded video (screen re-opened, came back from background). */
    fun isLoaded(source: String): Boolean = exo != null && currentKey == keyOf(source)

    /**
     * Loads the video of [source] (a file path, a content uri or a link) and starts playing at [startPositionMs];
     * [RESUME] (default) continues where the video was left last time, 0 or more starts at that position.
     * [name] is shown in the notification (the file name when null).
     */
    fun load(
        context: Context,
        source: String,
        name: String? = null,
        startPositionMs: Long = RESUME,
        playWhenReady: Boolean = true
    ) {
        val player = get(context)
        val uri = uriOf(source)
        val key = uri.toString()
        // the queue only goes on while the video belongs to it
        val inQueue = queue.indexOf(source)
        if (inQueue >= 0) queueIndex = inQueue else { queue = emptyList(); queueIndex = -1 }
        // the video that was playing keeps its position before the new one replaces it
        if (currentKey != null && currentKey != key) saveResume()
        val start = if (startPositionMs != RESUME) startPositionMs else VideoPrefs.resumePosition(context, key)
        val shownName = name?.takeIf { it.isNotBlank() }
            ?: uri.lastPathSegment?.substringAfterLast('/')?.takeIf { it.isNotBlank() }
            ?: "Video"
        val item = MediaItem.Builder()
            .setUri(uri)
            .setMediaMetadata(MediaMetadata.Builder().setTitle(shownName).build())
            .build()
        maxHeight = AUTO
        applyHeightLimit(player, AUTO)
        // The state is set BEFORE the item goes into the player: ExoPlayer calls its listeners from inside
        // setMediaItem() (onMediaItemTransition), and they read currentSource / title / resumedFromMs.
        resumedFromMs = if (startPositionMs == RESUME && start >= VideoPrefs.RESUME_MIN_MS) start else 0L
        currentKey = key
        currentSource = source
        title = shownName
        player.setMediaItem(item, start.coerceAtLeast(0L))
        player.prepare()
        player.playWhenReady = playWhenReady
    }

    // ---------------------------------------------------------------------------------------------
    // Resolution (4K) and picture height
    // ---------------------------------------------------------------------------------------------

    /**
     * "4K", "2K", "1080p", "720p" ... for a picture of [width] x [height]. The short side decides, so a tall
     * (phone) video is named like a wide one. 8K: 7680 wide; 4K: 3840 / 2160; 2K (1440p): 2560 / 1440.
     */
    fun resolutionLabel(width: Int, height: Int): String {
        val longSide = maxOf(width, height)
        val shortSide = minOf(width, height)
        return when {
            shortSide >= 4320 || longSide >= 7680 -> "8K"
            shortSide >= 2160 || longSide >= 3840 -> "4K"
            shortSide >= 1440 || longSide >= 2560 -> "2K"
            else -> "${shortSide}p"
        }
    }

    /** Label of the picture that plays now, or null while the size is not known yet. */
    fun currentResolutionLabel(): String? {
        val size = exo?.videoSize ?: return null
        if (size.width <= 0 || size.height <= 0) return null
        return resolutionLabel(size.width, size.height)
    }

    /**
     * Picture heights the loaded video offers, best first (e.g. 2160, 1080, 720): the heights of its video tracks.
     * A plain file has one; an adaptive (HLS / DASH) link has several. Empty until the tracks are known.
     */
    fun availableHeights(): List<Int> {
        val player = exo ?: return emptyList()
        val out = sortedSetOf<Int>()
        for (group in player.currentTracks.groups) {
            if (group.type != C.TRACK_TYPE_VIDEO) continue
            for (i in 0 until group.length) {
                val f = group.getTrackFormat(i)
                val h = minOf(f.width, f.height).takeIf { f.width > 0 && f.height > 0 } ?: f.height
                if (h > 0) out.add(h)
            }
        }
        return out.toList().sortedDescending()
    }

    /** Picture height cap for an adaptive video: [AUTO] or a height. A plain file has one track, so nothing changes. */
    fun setMaxHeight(height: Int) {
        val player = exo ?: return
        maxHeight = height
        applyHeightLimit(player, height)
    }

    private fun applyHeightLimit(player: ExoPlayer, height: Int) {
        val b = player.trackSelectionParameters.buildUpon()
        if (height == AUTO) {
            b.clearVideoSizeConstraints()
        } else {
            // the cap is on the short side of the picture too (1080 keeps a 1080x1920 phone video), so
            // limit the long side generously and the short side exactly
            b.setMaxVideoSize(Int.MAX_VALUE, height)
        }
        player.trackSelectionParameters = b.build()
    }

    /**
     * Video picture on / off. Switched off while playing in the background (screen off, other app):
     * the audio goes on and the video is not decoded. Switched on again when the player screen comes back.
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
        exo?.release()
        exo = null
        ctx?.let { PlaybackService.stop(it) }
        currentKey = null
        currentSource = null
        queue = emptyList()
        queueIndex = -1
        title = null
        maxHeight = AUTO
        resumedFromMs = 0L
    }
}
