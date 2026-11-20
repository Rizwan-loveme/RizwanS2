@file:androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)

package com.srizwan.YouTube.player

import androidx.media3.common.MediaItem
import androidx.media3.datasource.DataSource
import androidx.media3.exoplayer.dash.DashMediaSource
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.MergingMediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import com.srizwan.YouTube.data.AudioQuality
import com.srizwan.YouTube.data.StreamDetails
import com.srizwan.YouTube.data.VideoQuality

/**
 * Turns the stream lists of [StreamDetails] into one Media3 [MediaSource].
 *
 * Plan order (first that exists wins):
 *  1. live stream            -> HLS
 *  2. video-only + audio     -> merged (this is where 1080p and above live)
 *  3. muxed (audio + video)  -> progressive (usually up to 720p)
 *  4. HLS manifest, 5. DASH manifest
 *
 * [maxHeight] caps the picture height. [AUTO] means "best up to [AUTO_CAP]" (360p, light on data).
 * On a weak network [YtPlayer] drops an Auto video to the lowest height by itself (manifest videos
 * adapt by themselves inside the cap). Part 3 (quality menu) passes the height the user picked.
 */
object StreamSources {

    const val AUTO = 0
    const val AUTO_CAP = 360

    sealed class Plan {
        data class Hls(val url: String) : Plan()
        data class Dash(val url: String) : Plan()
        data class Progressive(val video: VideoQuality, val audio: AudioQuality?) : Plan() {
            /** label shown in the quality menu later, e.g. "720p" */
            val label: String get() = video.label
            val height: Int get() = video.height
        }
    }

    class NoStreamException : Exception("No playable stream found for this video")

    fun plan(d: StreamDetails, maxHeight: Int = AUTO): Plan {
        val cap = if (maxHeight == AUTO) AUTO_CAP else maxHeight
        if (d.isLive) {
            d.hlsUrl?.let { return Plan.Hls(it) }
        }
        val audio = d.audio.firstOrNull()
        if (audio != null) {
            pick(d.videoOnly, cap)?.let { return Plan.Progressive(it, audio) }
        }
        pick(d.muxed, cap)?.let { return Plan.Progressive(it, null) }
        d.hlsUrl?.let { return Plan.Hls(it) }
        d.dashUrl?.let { return Plan.Dash(it) }
        throw NoStreamException()
    }

    /**
     * Heights the viewer can choose for [d], best first (part 3, quality menu). It matches [plan]: when
     * video-only streams and an audio stream exist those are played, otherwise the muxed ones.
     * Empty when the video only has a manifest (live / HLS / DASH); [YtPlayer.availableHeights] then reads
     * the heights of the manifest's tracks.
     */
    fun heights(d: StreamDetails): List<Int> {
        val list = if (d.audio.isNotEmpty() && d.videoOnly.isNotEmpty()) d.videoOnly else d.muxed
        return list.map { it.height }.filter { it > 0 }.distinct().sortedDescending()
    }

    /** The height that is played for a cap: the best one <= [cap], else the smallest. [heights] is best first. */
    fun nearest(heights: List<Int>, cap: Int): Int? =
        heights.firstOrNull { it <= cap } ?: heights.lastOrNull()

    /** Best stream with height <= [cap]; if every stream is taller than the cap, the smallest one. */
    private fun pick(list: List<VideoQuality>, cap: Int): VideoQuality? {
        if (list.isEmpty()) return null
        val ok = list.filter { it.height in 1..cap }
        if (ok.isNotEmpty()) return ok.maxByOrNull { it.height }
        return list.filter { it.height > 0 }.minByOrNull { it.height } ?: list.first()
    }

    fun mediaSource(factory: DataSource.Factory, plan: Plan, title: String? = null): MediaSource = when (plan) {
        is Plan.Hls -> HlsMediaSource.Factory(factory).createMediaSource(item(plan.url, title))
        is Plan.Dash -> DashMediaSource.Factory(factory).createMediaSource(item(plan.url, title))
        is Plan.Progressive -> {
            val video = ProgressiveMediaSource.Factory(factory).createMediaSource(item(plan.video.url, title))
            val audio = plan.audio
            if (audio == null) video
            else MergingMediaSource(
                video,
                ProgressiveMediaSource.Factory(factory).createMediaSource(item(audio.url, title))
            )
        }
    }

    private fun item(url: String, title: String?): MediaItem {
        val b = MediaItem.Builder().setUri(url)
        if (title != null) {
            b.setMediaMetadata(androidx.media3.common.MediaMetadata.Builder().setTitle(title).build())
        }
        return b.build()
    }
}
