package com.srizwan.YouTube.data

import android.content.Context
import android.content.SharedPreferences
import com.srizwan.YouTube.LinkDetector
import com.srizwan.YouTube.LinkType

/**
 * Step 4: the channel whose uploads fill the home feed ("Afnan the horror world"), instead of trending videos.
 *
 * To pin the exact channel, put its link or @handle into [PINNED] (for example "https://www.youtube.com/@yourhandle"
 * or "@yourhandle"). While [PINNED] is empty the channel is found once by searching [NAME] among channels; the
 * match is accepted only if the channel's name really is (or contains) the name, so a wrong channel is never
 * taken. The found address is remembered, so later starts do not search again.
 * If no channel can be found or loaded, the home feed falls back to a video search for [NAME] (see [YtRepository.home]).
 */
object HomeChannel {

    const val NAME = "Afnan the horror world"

    /** Link or @handle of the channel. Leave empty to find it by name. */
    val PINNED: String = ""

    private const val FILE = "yt_home_channel"
    private const val KEY_URL = "url"

    private var prefs: SharedPreferences? = null

    /** The channel address in use (set by [resolve]); read it from any thread. */
    @Volatile var url: String? = null
        private set

    @Synchronized
    fun init(context: Context) {
        if (prefs != null) return
        prefs = context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
        if (url == null) url = pinnedUrl() ?: prefs?.getString(KEY_URL, null)?.takeIf { it.isNotBlank() }
    }

    /** The channel address, or null when it cannot be found. Blocks (network): call it off the main thread. */
    fun resolve(): String? {
        url?.let { return it }
        pinnedUrl()?.let { url = it; return it }
        prefs?.getString(KEY_URL, null)?.takeIf { it.isNotBlank() }?.let { url = it; return it }
        val found = findByName() ?: return null
        url = found
        prefs?.edit()?.putString(KEY_URL, found)?.apply()
        return found
    }

    /** A remembered (found, not pinned) address that stopped working is dropped so the next start searches again. */
    fun forgetFound() {
        if (pinnedUrl() != null) return
        url = null
        prefs?.edit()?.remove(KEY_URL)?.apply()
    }

    private fun pinnedUrl(): String? {
        val p = PINNED.trim()
        if (p.isEmpty()) return null
        val d = LinkDetector.detect(p)
        if (d.type == LinkType.CHANNEL) return d.url
        val handle = if (p.startsWith("@")) p else "@$p"
        return LinkDetector.detect("https://www.youtube.com/$handle").url
    }

    private fun findByName(): String? {
        val want = norm(NAME)
        val channels = YtRepository.search(NAME, YtRepository.Filter.CHANNELS)
            .items.filterIsInstance<YtItem.Channel>()
        channels.firstOrNull { norm(it.title) == want }?.let { return it.url }
        return channels.firstOrNull { val t = norm(it.title); t.contains("afnan") && t.contains("horror") }?.url
    }

    private fun norm(s: String) = s.lowercase().filter { it.isLetterOrDigit() }
}
