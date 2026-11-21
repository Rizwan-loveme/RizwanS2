package com.srizwan.YouTube.ui

import java.util.Locale

/** Number / time formatting shared by the list screens (home feed, search, later channel / playlist / history). */
object Format {

    /** 1234 -> "1.2K", 3_400_000 -> "3.4M"; null when the count is unknown (negative). */
    fun count(n: Long): String? = when {
        n < 0 -> null
        n < 1_000 -> n.toString()
        n < 1_000_000 -> trim(n / 1_000.0) + "K"
        n < 1_000_000_000 -> trim(n / 1_000_000.0) + "M"
        else -> trim(n / 1_000_000_000.0) + "B"
    }

    /** Seconds -> "4:05" or "1:02:03". */
    fun duration(sec: Long): String {
        val h = sec / 3600
        val m = (sec % 3600) / 60
        val s = sec % 60
        return if (h > 0) String.format(Locale.US, "%d:%02d:%02d", h, m, s)
        else String.format(Locale.US, "%d:%02d", m, s)
    }

    /** "Just now", "5 min ago", "3 h ago", "Yesterday", "4 days ago", then a date like "12 Mar 2026". */
    fun ago(millis: Long, now: Long = System.currentTimeMillis()): String {
        val diff = (now - millis).coerceAtLeast(0L)
        val min = diff / 60_000L
        val hour = min / 60
        val day = hour / 24
        return when {
            min < 1 -> "Just now"
            min < 60 -> "$min min ago"
            hour < 24 -> "$hour h ago"
            day == 1L -> "Yesterday"
            day < 7 -> "$day days ago"
            else -> java.text.SimpleDateFormat("d MMM yyyy", Locale.US).format(java.util.Date(millis))
        }
    }

    private fun trim(x: Double): String {
        val s = String.format(Locale.US, "%.1f", x)
        return if (s.endsWith(".0")) s.dropLast(2) else s
    }
}
