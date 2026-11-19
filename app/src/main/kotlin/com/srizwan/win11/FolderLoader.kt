package com.srizwan.win11

import android.os.Handler
import android.os.Looper
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.Future

// =====================================================================
// BACKGROUND FOLDER LOADER  (step 4.1)
// listFiles(), sorting and the free/total space lookup used to run on the
// main thread inside loadFiles(). They now run on a worker thread; the
// result is delivered back on the main thread. Starting a new load (or
// calling cancel()) invalidates every load that is still running, so a
// slow folder can never overwrite the folder the user opened afterwards.
// =====================================================================

/** Outcome of reading one folder. */
internal sealed class FolderResult {
    /** Folder read fine. [files] is already sorted (folders first, then A-Z). */
    class Content(
        val dir: File,
        /** Step 4.1: same order as [files], with size/date/type already read. */
        val items: List<FileItem>,
        val free: Long,
        val total: Long
    ) : FolderResult() {
        /** Plain files, kept so existing callers keep working unchanged. */
        val files: List<File> by lazy(LazyThreadSafetyMode.NONE) { items.map { it.file } }   // 4.15.2: built only if asked
    }

    /** Folder exists but Android refused to list it (permission). */
    class Denied(val dir: File) : FolderResult()

    /** Anything else: folder vanished, I/O error, unexpected exception. */
    class Failed(val dir: File, val message: String) : FolderResult()
}

/** 4.15.2: from this many entries on, the stat work is split over [STAT_THREADS] threads. */
private const val PARALLEL_FROM = 1500
private const val STAT_THREADS = 3

internal class FolderLoader {

    private val main = Handler(Looper.getMainLooper())
    private val pool = Executors.newCachedThreadPool { r ->
        Thread(r, "folder-loader").apply { isDaemon = true }
    }

    // Only touched from the main thread.
    private var generation = 0
    private var running: Future<*>? = null

    /**
     * Read [dir] on a worker thread and call [onResult] on the main thread.
     * Any load started earlier is cancelled and its result is dropped.
     */
    fun load(dir: File, onResult: (FolderResult) -> Unit) {
        val gen = ++generation
        running?.cancel(true)
        running = try {
            pool.submit {
                val result = read(dir)
                if (Thread.currentThread().isInterrupted) return@submit
                main.post { if (gen == generation) onResult(result) }
            }
        } catch (e: java.util.concurrent.RejectedExecutionException) {
            null                                   // shut down: the screen is gone, nobody to tell
        }
    }

    /** Drop the running load (if any); its result will never be delivered. */
    fun cancel() {
        generation++
        running?.cancel(true)
        running = null
    }

    /** Cancel everything and stop the worker threads (Activity.onDestroy). */
    fun shutdown() {
        cancel()
        main.removeCallbacksAndMessages(null)   // 4.15.3: a result already posted never reaches the dead screen
        pool.shutdownNow()
    }

    private class Entry(val item: FileItem, val key: String)

    /** Folders first, then A-Z by the lower-case name (plain comparator: no boxing per comparison). */
    private val order = Comparator<Entry> { a, b ->
        val da = a.item.isDir
        val db = b.item.isDir
        if (da != db) (if (da) -1 else 1) else a.key.compareTo(b.key)
    }

    private fun entryOf(f: File): Entry = Entry(FileItem.from(f), f.name.lowercase())

    private fun read(dir: File): FolderResult {
        return try {
            val t0 = android.os.SystemClock.uptimeMillis()
            val raw = dir.listFiles()
            if (raw == null) {
                // listFiles() returns null for "not a directory" and for I/O / permission errors.
                return if (dir.exists() && dir.isDirectory) FolderResult.Denied(dir)
                else FolderResult.Failed(dir, "Folder not found")
            }
            if (Thread.currentThread().isInterrupted) return FolderResult.Failed(dir, "Cancelled")
            val t1 = android.os.SystemClock.uptimeMillis()

            // stat each file once (FileItem.from, a single Os.stat) instead of once per comparison /
            // per row bind. 4.15.2: a big folder is statted by a few threads at once - on phone
            // storage a stat mostly waits, so the threads overlap that waiting.
            val n = raw.size
            val slots = arrayOfNulls<Entry>(n)
            if (n < PARALLEL_FROM) {
                for (i in 0 until n) {
                    if (Thread.currentThread().isInterrupted) return FolderResult.Failed(dir, "Cancelled")
                    slots[i] = entryOf(raw[i])
                }
            } else {
                val stop = java.util.concurrent.atomic.AtomicBoolean(false)
                val workers = List(STAT_THREADS) { t ->
                    Thread({
                        var i = t
                        while (i < n && !stop.get()) {
                            // 4.15.3: a plain Thread that throws would crash the whole app; skip the file instead
                            try { slots[i] = entryOf(raw[i]) } catch (e: Throwable) { }
                            i += STAT_THREADS
                        }
                    }, "folder-stat-$t").apply { isDaemon = true; start() }
                }
                try {
                    for (w in workers) w.join()
                } catch (e: InterruptedException) {
                    stop.set(true)                      // a newer load cancelled this one
                    Thread.currentThread().interrupt()
                    return FolderResult.Failed(dir, "Cancelled")
                }
            }
            val entries = ArrayList<Entry>(n)
            for (e in slots) if (e != null) entries.add(e)
            val t2 = android.os.SystemClock.uptimeMillis()

            entries.sortWith(order)
            val items = ArrayList<FileItem>(n)
            for (e in entries) items.add(e.item)
            val t3 = android.os.SystemClock.uptimeMillis()
            if (n >= 1000) {
                try { AppLog.d("FolderLoader", "$n files: list ${t1 - t0} ms, stat ${t2 - t1} ms, sort ${t3 - t2} ms") }
                catch (e: Throwable) { }
            }

            val free = try { dir.freeSpace } catch (e: Exception) { 0L }
            val total = try { dir.totalSpace } catch (e: Exception) { 0L }
            FolderResult.Content(dir, items, free, total)
        } catch (e: SecurityException) {
            FolderResult.Denied(dir)
        } catch (e: Exception) {
            FolderResult.Failed(dir, e.message ?: e.javaClass.simpleName)
        }
    }
}
