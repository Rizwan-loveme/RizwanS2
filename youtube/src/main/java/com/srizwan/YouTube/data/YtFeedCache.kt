package com.srizwan.YouTube.data

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

/**
 * Step 5 (offline and speed): the last home feed page kept on the device. The home screen shows it at once when
 * it opens (also without a connection) and replaces it as soon as the fresh feed has loaded.
 */
object YtFeedCache {

    private const val FILE = "yt_feed_cache"
    private const val KEY = "home"
    private const val MAX = 30

    fun save(context: Context, videos: List<YtItem.Video>) {
        if (videos.isEmpty()) return
        runCatching {
            val a = JSONArray()
            for (v in videos.take(MAX)) {
                a.put(JSONObject().apply {
                    put("url", v.url)
                    put("title", v.title)
                    put("thumb", v.thumb ?: "")
                    put("channel", v.channel)
                    put("channelUrl", v.channelUrl ?: "")
                    put("duration", v.duration)
                    put("views", v.views)
                    put("uploaded", v.uploaded ?: "")
                    put("live", v.isLive)
                })
            }
            context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
                .edit().putString(KEY, a.toString()).apply()
        }
    }

    fun load(context: Context): List<YtItem.Video> = runCatching {
        val text = context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .getString(KEY, null) ?: return@runCatching emptyList<YtItem.Video>()
        val a = JSONArray(text)
        (0 until a.length()).map { i ->
            val o = a.getJSONObject(i)
            YtItem.Video(
                url = o.getString("url"),
                title = o.optString("title"),
                thumb = o.optString("thumb").ifEmpty { null },
                channel = o.optString("channel"),
                channelUrl = o.optString("channelUrl").ifEmpty { null },
                duration = o.optLong("duration", -1L),
                views = o.optLong("views", -1L),
                uploaded = o.optString("uploaded").ifEmpty { null },
                isLive = o.optBoolean("live", false)
            )
        }
    }.getOrDefault(emptyList())
}
