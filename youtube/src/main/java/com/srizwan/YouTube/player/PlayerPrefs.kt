package com.srizwan.YouTube.player

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

/**
 * Small saved settings of the player (SharedPreferences `yt_player`): speed, background playback,
 * notification permission asked, preferred quality and the resume position of watched videos (part 9).
 */
object PlayerPrefs {
    private const val FILE = "yt_player"
    private const val KEY_SPEED = "speed"
    private const val KEY_BACKGROUND = "background_play"
    private const val KEY_NOTIF_ASKED = "notif_permission_asked"
    private const val KEY_QUALITY = "quality"
    private const val KEY_RESUME = "resume_positions"

    /** at most this many videos keep a resume position (oldest are dropped) */
    private const val RESUME_MAX = 100
    /** shorter than this is not worth resuming; closer than [RESUME_END_MS] to the end counts as finished */
    const val RESUME_MIN_MS = 5_000L
    const val RESUME_END_MS = 10_000L

    /** The speeds offered in the speed menu. */
    val SPEEDS = floatArrayOf(0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f)

    fun speed(context: Context): Float {
        val v = context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .getFloat(KEY_SPEED, 1f)
        return if (v in 0.1f..4f) v else 1f
    }

    fun setSpeed(context: Context, speed: Float) {
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .edit().putFloat(KEY_SPEED, speed).apply()
    }

    /** "1x", "1.5x", "0.25x" */
    fun speedLabel(speed: Float): String {
        val s = if (speed == speed.toInt().toFloat()) speed.toInt().toString()
        else speed.toString().trimEnd('0')
        return "${s}x"
    }

    /** Background playback (part 5): keep playing when the screen is left. On by default. */
    fun backgroundPlay(context: Context): Boolean =
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .getBoolean(KEY_BACKGROUND, true)

    fun setBackgroundPlay(context: Context, on: Boolean) {
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .edit().putBoolean(KEY_BACKGROUND, on).apply()
    }

    /** Preferred quality: [com.srizwan.YouTube.player.StreamSources.AUTO] (0) or a height such as 720 (part 3 saves it; it is a cap: a video without that height plays the nearest lower one). */
    fun quality(context: Context): Int =
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .getInt(KEY_QUALITY, StreamSources.AUTO).let { if (it >= 0) it else StreamSources.AUTO }

    fun setQuality(context: Context, height: Int) {
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .edit().putInt(KEY_QUALITY, height).apply()
    }

    // ---- resume position (part 9): url -> position in ms, newest last, capped at RESUME_MAX ----

    private fun readResume(context: Context): JSONArray = runCatching {
        JSONArray(
            context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
                .getString(KEY_RESUME, "[]")
        )
    }.getOrDefault(JSONArray())

    /** Saved position of [url] in ms, or 0 when there is none. */
    fun resumePosition(context: Context, url: String): Long {
        val arr = readResume(context)
        for (i in 0 until arr.length()) {
            val o = arr.optJSONObject(i) ?: continue
            if (o.optString("u") == url) return o.optLong("p", 0L).coerceAtLeast(0L)
        }
        return 0L
    }

    /** Saves [positionMs] for [url]; a position that is too small / too close to the end removes the entry. */
    fun setResumePosition(context: Context, url: String, positionMs: Long, durationMs: Long) {
        val finished = durationMs > 0 && positionMs >= durationMs - RESUME_END_MS
        val keep = positionMs >= RESUME_MIN_MS && !finished
        val old = readResume(context)
        val out = JSONArray()
        for (i in 0 until old.length()) {
            val o = old.optJSONObject(i) ?: continue
            if (o.optString("u") != url) out.put(o)
        }
        if (keep) out.put(JSONObject().put("u", url).put("p", positionMs))
        // drop the oldest entries above the cap
        val trimmed = JSONArray()
        for (i in maxOf(0, out.length() - RESUME_MAX) until out.length()) trimmed.put(out.get(i))
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .edit().putString(KEY_RESUME, trimmed.toString()).apply()
    }

    fun clearResumePosition(context: Context, url: String) = setResumePosition(context, url, 0L, 0L)

    /** The notification permission (Android 13+) is asked once only. */
    fun notificationPermissionAsked(context: Context): Boolean =
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .getBoolean(KEY_NOTIF_ASKED, false)

    fun setNotificationPermissionAsked(context: Context) {
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .edit().putBoolean(KEY_NOTIF_ASKED, true).apply()
    }
}
