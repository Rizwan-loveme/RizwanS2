package com.srizwan.YouTube.data

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray
import org.json.JSONObject

/**
 * Local watch history and search history of the YouTube app (SharedPreferences `yt_history`, JSON).
 * No account, no sync: everything stays on the phone.
 *
 *  - watch history: newest first, one row per video (watching it again moves it to the top), max [MAX_WATCH]
 *  - search history: newest first, one row per query (case-insensitive), max [MAX_SEARCH]
 *
 * Call [init] once (the YouTube screen does it); every function is safe to call from any thread.
 */
object YtHistory {

    private const val FILE = "yt_history"
    private const val KEY_WATCH = "watch"
    private const val KEY_SEARCH = "search"
    const val MAX_WATCH = 300
    const val MAX_SEARCH = 50

    /** One watched video. Same fields the list cards need, plus when it was watched. */
    data class Entry(
        val url: String,
        val title: String,
        val thumb: String?,
        val channel: String,
        val channelUrl: String?,
        val duration: Long,
        val watchedAt: Long
    ) {
        fun toVideo() = YtItem.Video(
            url = url, title = title, thumb = thumb, channel = channel, channelUrl = channelUrl,
            duration = duration, views = -1L, uploaded = null, isLive = false
        )
    }

    private var prefs: SharedPreferences? = null
    private val watch = ArrayList<Entry>()
    private val searches = ArrayList<String>()

    @Synchronized
    fun init(context: Context) {
        if (prefs != null) return
        val p = context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
        prefs = p
        watch.clear()
        searches.clear()
        runCatching {
            val a = JSONArray(p.getString(KEY_WATCH, "[]"))
            for (i in 0 until a.length()) {
                val o = a.getJSONObject(i)
                watch.add(
                    Entry(
                        url = o.getString("url"),
                        title = o.optString("title"),
                        thumb = o.optString("thumb").ifEmpty { null },
                        channel = o.optString("channel"),
                        channelUrl = o.optString("channelUrl").ifEmpty { null },
                        duration = o.optLong("duration", -1L),
                        watchedAt = o.optLong("at", 0L)
                    )
                )
            }
        }
        runCatching {
            val a = JSONArray(p.getString(KEY_SEARCH, "[]"))
            for (i in 0 until a.length()) searches.add(a.getString(i))
        }
    }

    // ---- watch history ----

    /** Records a watched video (moves it to the top when it is already there). */
    @Synchronized
    fun addWatch(
        url: String, title: String, thumb: String?, channel: String,
        channelUrl: String?, duration: Long
    ) {
        if (url.isBlank()) return
        watch.removeAll { it.url == url }
        watch.add(0, Entry(url, title, thumb, channel, channelUrl, duration, System.currentTimeMillis()))
        while (watch.size > MAX_WATCH) watch.removeAt(watch.size - 1)
        saveWatch()
    }

    @Synchronized
    fun watched(): List<Entry> = ArrayList(watch)

    @Synchronized
    fun removeWatch(url: String) {
        if (watch.removeAll { it.url == url }) saveWatch()
    }

    @Synchronized
    fun clearWatch() {
        watch.clear()
        saveWatch()
    }

    // ---- search history ----

    @Synchronized
    fun addSearch(query: String) {
        val q = query.trim()
        if (q.isEmpty()) return
        searches.removeAll { it.equals(q, ignoreCase = true) }
        searches.add(0, q)
        while (searches.size > MAX_SEARCH) searches.removeAt(searches.size - 1)
        saveSearch()
    }

    /** Past searches, newest first; with [prefix] only the ones that start with it (for the suggestion list). */
    @Synchronized
    fun searchHistory(prefix: String = ""): List<String> {
        val p = prefix.trim()
        return if (p.isEmpty()) ArrayList(searches)
        else searches.filter { it.startsWith(p, ignoreCase = true) }
    }

    @Synchronized
    fun removeSearch(query: String) {
        if (searches.removeAll { it.equals(query, ignoreCase = true) }) saveSearch()
    }

    @Synchronized
    fun clearSearches() {
        searches.clear()
        saveSearch()
    }

    // ---- storage ----

    private fun saveWatch() {
        val a = JSONArray()
        for (e in watch) {
            a.put(
                JSONObject()
                    .put("url", e.url)
                    .put("title", e.title)
                    .put("thumb", e.thumb ?: "")
                    .put("channel", e.channel)
                    .put("channelUrl", e.channelUrl ?: "")
                    .put("duration", e.duration)
                    .put("at", e.watchedAt)
            )
        }
        prefs?.edit()?.putString(KEY_WATCH, a.toString())?.apply()
    }

    private fun saveSearch() {
        val a = JSONArray()
        for (q in searches) a.put(q)
        prefs?.edit()?.putString(KEY_SEARCH, a.toString())?.apply()
    }
}
