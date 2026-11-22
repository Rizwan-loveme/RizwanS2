package com.srizwan.YouTube.data

import android.os.Handler
import android.os.Looper
import org.schabi.newpipe.extractor.InfoItem
import org.schabi.newpipe.extractor.Image
import org.schabi.newpipe.extractor.ListExtractor
import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.Page
import org.schabi.newpipe.extractor.ServiceList
import org.schabi.newpipe.extractor.channel.ChannelInfo
import org.schabi.newpipe.extractor.channel.ChannelInfoItem
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabInfo
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler
import org.schabi.newpipe.extractor.localization.ContentCountry
import org.schabi.newpipe.extractor.localization.Localization
import org.schabi.newpipe.extractor.playlist.PlaylistInfo
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItem
import org.schabi.newpipe.extractor.search.SearchInfo
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeSearchQueryHandlerFactory
import org.schabi.newpipe.extractor.stream.StreamInfo
import org.schabi.newpipe.extractor.stream.StreamInfoItem
import org.schabi.newpipe.extractor.stream.StreamType
import java.util.concurrent.Executors

/**
 * All YouTube data access. Every function here blocks, so call it through [async]
 * (runs on a background thread and returns the result on the main thread).
 */
object YtRepository {

    enum class Filter(val value: String?) {
        ALL(null),
        VIDEOS(YoutubeSearchQueryHandlerFactory.VIDEOS),
        CHANNELS(YoutubeSearchQueryHandlerFactory.CHANNELS),
        PLAYLISTS(YoutubeSearchQueryHandlerFactory.PLAYLISTS)
    }

    private val io = Executors.newFixedThreadPool(3)
    private val main = Handler(Looper.getMainLooper())
    private val yt get() = ServiceList.YouTube
    @Volatile private var inited = false

    @Synchronized
    fun init(language: String = "en", country: String = "US") {
        if (inited) return
        NewPipe.init(YtDownloader.instance, Localization(language, country), ContentCountry(country))
        inited = true
    }

    /** Runs [block] off the main thread, then calls [cb] on the main thread. */
    fun <T> async(block: () -> T, cb: (Result<T>) -> Unit) {
        io.execute {
            val r = runCatching { init(); block() }
            main.post { cb(r) }
        }
    }

    // ───────────── Home feed ─────────────

    /** The Videos tab of the home channel while the feed comes from it (null = the feed is a search). */
    @Volatile private var homeTab: ListLinkHandler? = null

    /**
     * Step 4: the home feed is the uploads of [HomeChannel] ("Afnan the horror world"), newest first, no longer the
     * trending list. If the channel cannot be found or loaded, it falls back to a video search for its name so the
     * home screen is never empty.
     */
    fun home(): PageResult {
        val channelUrl = runCatching { HomeChannel.resolve() }.getOrNull()
        if (channelUrl != null) {
            var failed = false
            val page = runCatching {
                val info = ChannelInfo.getInfo(yt, channelUrl)
                val tab = info.tabs.firstOrNull { it.contentFilters.contains(ChannelTabs.VIDEOS) }
                val first = tab?.let { channelTab(it) }
                if (tab != null && first != null && first.items.isNotEmpty()) { homeTab = tab; first } else null
            }.onFailure { failed = true }.getOrNull()
            if (page != null) return page
            if (failed) HomeChannel.forgetFound()
        }
        homeTab = null
        return search(HomeChannel.NAME, Filter.VIDEOS)
    }

    fun homeMore(page: Page): PageResult {
        val tab = homeTab
        return if (tab != null) channelTabMore(tab, page) else searchMore(HomeChannel.NAME, Filter.VIDEOS, page)
    }

    // ───────────── Search ─────────────

    fun suggestions(query: String): List<String> =
        if (query.isBlank()) emptyList() else yt.suggestionExtractor.suggestionList(query)

    fun search(query: String, filter: Filter = Filter.ALL): PageResult {
        val handler = yt.searchQHFactory.fromQuery(query, filters(filter), "")
        val info = SearchInfo.getInfo(yt, handler)
        return PageResult(mapAll(info.relatedItems), info.nextPage)
    }

    fun searchMore(query: String, filter: Filter, page: Page): PageResult {
        val handler = yt.searchQHFactory.fromQuery(query, filters(filter), "")
        val more: ListExtractor.InfoItemsPage<InfoItem> = SearchInfo.getMoreItems(yt, handler, page)
        return PageResult(mapAll(more.items), more.nextPage)
    }

    private fun filters(f: Filter): List<String> = f.value?.let { listOf(it) } ?: emptyList()

    // ───────────── Video ─────────────

    fun stream(url: String): StreamDetails {
        val i = StreamInfo.getInfo(yt, url)
        fun q(s: org.schabi.newpipe.extractor.stream.VideoStream) = VideoQuality(
            url = s.content,
            label = s.resolution ?: "",
            height = s.resolution?.takeWhile { it.isDigit() }?.toIntOrNull() ?: 0,
            format = s.format?.getName(),
            videoOnly = s.isVideoOnly
        )
        return StreamDetails(
            url = url,
            title = i.name,
            uploader = i.uploaderName ?: "",
            uploaderUrl = i.uploaderUrl,
            uploaderAvatar = bestImage(i.uploaderAvatars),
            subscribers = i.uploaderSubscriberCount,
            views = i.viewCount,
            likes = i.likeCount,
            uploaded = i.textualUploadDate,
            description = i.description?.content ?: "",
            duration = i.duration,
            isLive = i.streamType == StreamType.LIVE_STREAM,
            thumb = bestImage(i.thumbnails),
            hlsUrl = i.hlsUrl?.takeIf { it.isNotBlank() },
            dashUrl = i.dashMpdUrl?.takeIf { it.isNotBlank() },
            muxed = i.videoStreams.map(::q).sortedByDescending { it.height },
            videoOnly = i.videoOnlyStreams.map(::q).sortedByDescending { it.height },
            audio = i.audioStreams.map { AudioQuality(it.content, it.averageBitrate, it.format?.getName()) }
                .sortedByDescending { it.bitrate },
            related = mapAll(i.relatedItems)
        )
    }

    // ───────────── Channel ─────────────

    fun channel(url: String): ChannelDetails {
        val info = ChannelInfo.getInfo(yt, url)
        val tabs = LinkedHashMap<String, Any>()
        info.tabs.firstOrNull { it.contentFilters.contains(ChannelTabs.VIDEOS) }?.let { tabs["videos"] = it }
        info.tabs.firstOrNull { it.contentFilters.contains(ChannelTabs.PLAYLISTS) }?.let { tabs["playlists"] = it }
        val firstKey = tabs.keys.firstOrNull()
        val first = firstKey?.let { channelTab(tabs[it] as ListLinkHandler) } ?: PageResult(emptyList(), null)
        return ChannelDetails(
            url = url,
            name = info.name,
            avatar = bestImage(info.avatars),
            banner = bestImage(info.banners),
            subscribers = info.subscriberCount,
            description = info.description,
            verified = info.isVerified,
            tabs = tabs,
            firstPage = first,
            firstTab = firstKey
        )
    }

    fun channelTab(tab: ListLinkHandler): PageResult {
        val ti = ChannelTabInfo.getInfo(yt, tab)
        return PageResult(mapAll(ti.relatedItems), ti.nextPage)
    }

    fun channelTabMore(tab: Any, page: Page): PageResult {
        val more = ChannelTabInfo.getMoreItems(yt, tab as ListLinkHandler, page)
        return PageResult(mapAll(more.items), more.nextPage)
    }

    // ───────────── Playlist ─────────────

    fun playlist(url: String): PlaylistDetails {
        val p = PlaylistInfo.getInfo(yt, url)
        return PlaylistDetails(
            url = url,
            name = p.name,
            owner = p.uploaderName ?: "",
            videoCount = p.streamCount,
            thumb = bestImage(p.thumbnails),
            firstPage = PageResult(mapAll(p.relatedItems), p.nextPage)
        )
    }

    fun playlistMore(url: String, page: Page): PageResult {
        val more = PlaylistInfo.getMoreItems(yt, url, page)
        return PageResult(mapAll(more.items), more.nextPage)
    }

    // ───────────── Helpers ─────────────

    private fun mapAll(list: List<InfoItem>?): List<YtItem> = list.orEmpty().mapNotNull(::map)

    private fun map(item: InfoItem): YtItem? = when (item) {
        is StreamInfoItem -> YtItem.Video(
            url = item.url,
            title = item.name,
            thumb = bestImage(item.thumbnails),
            channel = item.uploaderName ?: "",
            channelUrl = item.uploaderUrl,
            duration = item.duration,
            views = item.viewCount,
            uploaded = item.textualUploadDate,
            isLive = item.streamType == StreamType.LIVE_STREAM
        )
        is ChannelInfoItem -> YtItem.Channel(
            url = item.url,
            title = item.name,
            thumb = bestImage(item.thumbnails),
            subscribers = item.subscriberCount,
            description = item.description
        )
        is PlaylistInfoItem -> YtItem.Playlist(
            url = item.url,
            title = item.name,
            thumb = bestImage(item.thumbnails),
            owner = item.uploaderName ?: "",
            videoCount = item.streamCount
        )
        else -> null
    }

    /** The largest image of a list (avatars / thumbnails come in several sizes). */
    private fun bestImage(list: List<Image>?): String? =
        list?.maxByOrNull { it.height.coerceAtLeast(0) * 10000 + it.width.coerceAtLeast(0) }?.url
}
