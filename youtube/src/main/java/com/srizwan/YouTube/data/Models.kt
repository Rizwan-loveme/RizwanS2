package com.srizwan.YouTube.data

import org.schabi.newpipe.extractor.Page

/** One row of a list: a video, a channel or a playlist. */
sealed class YtItem {
    abstract val url: String
    abstract val title: String
    abstract val thumb: String?

    data class Video(
        override val url: String,
        override val title: String,
        override val thumb: String?,
        val channel: String,
        val channelUrl: String?,
        /** seconds, -1 = unknown */
        val duration: Long,
        /** -1 = unknown */
        val views: Long,
        val uploaded: String?,
        val isLive: Boolean
    ) : YtItem()

    data class Channel(
        override val url: String,
        override val title: String,
        override val thumb: String?,
        val subscribers: Long,
        val description: String?
    ) : YtItem()

    data class Playlist(
        override val url: String,
        override val title: String,
        override val thumb: String?,
        val owner: String,
        val videoCount: Long
    ) : YtItem()
}

/** A page of items + the cursor for the next page (null = end of list). */
class PageResult(val items: List<YtItem>, val next: Page?)

class VideoQuality(
    val url: String,
    /** e.g. "720p" */
    val label: String,
    val height: Int,
    val format: String?,
    val videoOnly: Boolean
)

class AudioQuality(
    val url: String,
    val bitrate: Int,
    val format: String?
)

class StreamDetails(
    val url: String,
    val title: String,
    val uploader: String,
    val uploaderUrl: String?,
    val uploaderAvatar: String?,
    val subscribers: Long,
    val views: Long,
    val likes: Long,
    val uploaded: String?,
    val description: String,
    val duration: Long,
    val isLive: Boolean,
    val thumb: String?,
    val hlsUrl: String?,
    val dashUrl: String?,
    /** audio + video in one stream (usually up to 720p) */
    val muxed: List<VideoQuality>,
    /** video only (1080p and above), must be merged with an audio stream by the player */
    val videoOnly: List<VideoQuality>,
    val audio: List<AudioQuality>,
    val related: List<YtItem>
)

class ChannelDetails(
    val url: String,
    val name: String,
    val avatar: String?,
    val banner: String?,
    val subscribers: Long,
    val description: String?,
    val verified: Boolean,
    /** tab handle objects used by [YtRepository.channelTabMore]; keys: "videos", "playlists" */
    val tabs: Map<String, Any>,
    val firstPage: PageResult,
    val firstTab: String?
)

class PlaylistDetails(
    val url: String,
    val name: String,
    val owner: String,
    val videoCount: Long,
    val thumb: String?,
    val firstPage: PageResult
)
