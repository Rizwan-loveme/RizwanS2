package com.srizwan.video.player

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

/**
 * Small saved settings of the video player (SharedPreferences `vp_player`): speed, background playback,
 * notification permission asked and the resume position of watched videos.
 */
object VideoPrefs {
    private const val FILE = "vp_player"
    private const val KEY_SPEED = "speed"
    private const val KEY_BACKGROUND = "background_play"
    private const val KEY_NOTIF_ASKED = "notif_permission_asked"
    private const val KEY_RESUME = "resume_positions"

    /** at most this many videos keep a resume position (oldest are dropped) */
    private const val RESUME_MAX = 200
    /** shorter than this is not worth resuming; closer than [RESUME_END_MS] to the end counts as finished */
    const val RESUME_MIN_MS = 5_000L
    const val RESUME_END_MS = 10_000L

    /** The speeds offered in the speed menu. */
    val SPEEDS = floatArrayOf(0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f)

    private fun prefs(context: Context) =
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)

    fun speed(context: Context): Float {
        val v = prefs(context).getFloat(KEY_SPEED, 1f)
        return if (v in 0.1f..4f) v else 1f
    }

    fun setSpeed(context: Context, speed: Float) {
        prefs(context).edit().putFloat(KEY_SPEED, speed).apply()
    }

    /** "1x", "1.5x", "0.25x" */
    fun speedLabel(speed: Float): String {
        val s = if (speed == speed.toInt().toFloat()) speed.toInt().toString()
        else speed.toString().trimEnd('0')
        return "${s}x"
    }

    /** Background playback: keep playing when the screen is left. On by default. */
    fun backgroundPlay(context: Context): Boolean = prefs(context).getBoolean(KEY_BACKGROUND, true)

    fun setBackgroundPlay(context: Context, on: Boolean) {
        prefs(context).edit().putBoolean(KEY_BACKGROUND, on).apply()
    }

    // ---- resume position: key (file / link) -> position in ms, newest last, capped at RESUME_MAX ----

    private fun readResume(context: Context): JSONArray = runCatching {
        JSONArray(prefs(context).getString(KEY_RESUME, "[]"))
    }.getOrDefault(JSONArray())

    /** Saved position of [key] in ms, or 0 when there is none. */
    fun resumePosition(context: Context, key: String): Long {
        val arr = readResume(context)
        for (i in 0 until arr.length()) {
            val o = arr.optJSONObject(i) ?: continue
            if (o.optString("u") == key) return o.optLong("p", 0L).coerceAtLeast(0L)
        }
        return 0L
    }

    /** True when the video of [key] has a saved position worth continuing (used for the badge in the Video app). */
    fun hasResume(context: Context, key: String): Boolean = resumePosition(context, key) >= RESUME_MIN_MS

    /** Saves [positionMs] for [key]; a position that is too small / too close to the end removes the entry. */
    fun setResumePosition(context: Context, key: String, positionMs: Long, durationMs: Long) {
        val finished = durationMs > 0 && positionMs >= durationMs - RESUME_END_MS
        val keep = positionMs >= RESUME_MIN_MS && !finished
        val old = readResume(context)
        val out = JSONArray()
        for (i in 0 until old.length()) {
            val o = old.optJSONObject(i) ?: continue
            if (o.optString("u") != key) out.put(o)
        }
        if (keep) out.put(JSONObject().put("u", key).put("p", positionMs))
        // drop the oldest entries above the cap
        val trimmed = JSONArray()
        for (i in maxOf(0, out.length() - RESUME_MAX) until out.length()) trimmed.put(out.get(i))
        prefs(context).edit().putString(KEY_RESUME, trimmed.toString()).apply()
    }

    /** The notification permission (Android 13+) is asked once only. */
    fun notificationPermissionAsked(context: Context): Boolean = prefs(context).getBoolean(KEY_NOTIF_ASKED, false)

    fun setNotificationPermissionAsked(context: Context) {
        prefs(context).edit().putBoolean(KEY_NOTIF_ASKED, true).apply()
    }
}
