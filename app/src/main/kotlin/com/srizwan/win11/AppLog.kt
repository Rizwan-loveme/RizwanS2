package com.srizwan.win11

import android.content.Context
import android.os.Build
import android.util.Log
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.ArrayDeque
import java.util.Date
import java.util.Locale

/**
 * App-wide logger (debug helper).
 *
 * - Writes to Logcat AND to a file: Android/data/<pkg>/files/logs/app.log
 *   (so the log can be read on the phone itself, no PC / second device needed).
 * - Keeps the last lines in memory too (works even if the file cannot be written).
 * - Installs a crash handler: any uncaught exception is saved to last_crash.txt and the
 *   next app start shows it on screen (see MainActivity.showLastCrashIfAny).
 * - Open the viewer from: Quick Settings -> Debug log tile (or the crash dialog).
 */
object AppLog {
    private const val TAG = "Win11"
    private const val MAX_FILE_BYTES = 512 * 1024L
    private const val MAX_MEMORY_LINES = 600

    private val memory = ArrayDeque<String>()
    private var logFile: File? = null
    private var crashFile: File? = null
    private var started = false
    private var handlerInstalled = false
    private val fmt = SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US)

    @Synchronized
    fun init(ctx: Context) {
        if (started) return
        started = true
        try {
            val app = ctx.applicationContext ?: ctx
            var dir: File? = try { app.getExternalFilesDir("logs") } catch (_: Throwable) { null }
            if (dir == null) dir = File(app.filesDir, "logs")
            dir.mkdirs()
            logFile = File(dir, "app.log")
            crashFile = File(dir, "last_crash.txt")
        } catch (t: Throwable) {
            Log.e(TAG, "AppLog.init failed (memory-only logging)", t)
        }
    }

    // ── public logging API ───────────────────────────────────────────
    fun d(tag: String, msg: String) = write("D", tag, msg, null)
    fun i(tag: String, msg: String) = write("I", tag, msg, null)
    fun w(tag: String, msg: String, t: Throwable? = null) = write("W", tag, msg, t)
    fun e(tag: String, msg: String, t: Throwable? = null) = write("E", tag, msg, t)

    @Synchronized
    private fun write(level: String, tag: String, msg: String, t: Throwable?) {
        try {
            when (level) {
                "D" -> Log.d("$TAG/$tag", msg)
                "I" -> Log.i("$TAG/$tag", msg)
                "W" -> Log.w("$TAG/$tag", msg, t)
                else -> Log.e("$TAG/$tag", msg, t)
            }
            val sb = StringBuilder()
            sb.append(fmt.format(Date())).append(' ').append(level).append('/').append(tag).append(": ").append(msg)
            if (t != null) sb.append('\n').append(stack(t))
            val line = sb.toString()
            memory.addLast(line)
            while (memory.size > MAX_MEMORY_LINES) memory.removeFirst()
            val f = logFile
            if (f != null) {
                if (f.length() > MAX_FILE_BYTES) {
                    val old = File(f.parentFile, "app.old.log")
                    old.delete()
                    f.renameTo(old)
                }
                f.appendText(line + "\n")
            }
        } catch (_: Throwable) {
            // logging must never crash the app
        }
    }

    fun stack(t: Throwable): String {
        val sw = StringWriter()
        t.printStackTrace(PrintWriter(sw))
        return sw.toString()
    }

    fun deviceInfo(): String =
        "Device: ${Build.MANUFACTURER} ${Build.MODEL}\n" +
            "Android: ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})\n" +
            "ABI: ${Build.SUPPORTED_ABIS.joinToString()}\n" +
            "Time: ${Date()}"

    /** Whole log (file + memory fallback), newest at the bottom. */
    @Synchronized
    fun readAll(): String {
        val f = logFile
        val fromFile = try {
            if (f != null && f.exists()) {
                val text = f.readText()
                if (text.length > 200_000) text.takeLast(200_000) else text
            } else ""
        } catch (_: Throwable) { "" }
        return if (fromFile.isNotEmpty()) fromFile else memory.joinToString("\n")
    }

    @Synchronized
    fun clear() {
        memory.clear()
        try { logFile?.delete() } catch (_: Throwable) {}
    }

    fun logPath(): String = logFile?.absolutePath ?: "(memory only)"

    // ── crash handling ───────────────────────────────────────────────
    @Synchronized
    fun installCrashHandler() {
        if (handlerInstalled) return
        handlerInstalled = true
        val previous = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, error ->
            try {
                val report = deviceInfo() + "\nThread: " + thread.name + "\n\n" + stack(error)
                crashFile?.writeText(report)
                write("F", "CRASH", "Uncaught exception in thread '" + thread.name + "'", error)
            } catch (_: Throwable) {
            }
            previous?.uncaughtException(thread, error)
        }
    }

    /** Returns the crash report of the previous run (once), or null. */
    @Synchronized
    fun takeLastCrash(): String? {
        return try {
            val f = crashFile
            if (f != null && f.exists()) {
                val text = f.readText()
                f.delete()
                if (text.isBlank()) null else text
            } else null
        } catch (_: Throwable) { null }
    }
}
