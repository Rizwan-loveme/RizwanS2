package com.srizwan.win11

import android.os.Handler
import android.os.Looper
import android.os.Process
import android.util.LruCache
import java.util.concurrent.LinkedBlockingDeque

// =====================================================================
// FOLDER ITEM COUNT ENGINE  (step 4.12 - list engine)
//
// The "12 items" of a folder row / cell / card, counted in the background.
// Before 4.12 this was a private single-thread queue inside ExplorerUi that
// forgot every number on each reload and kept counting folders that had
// already scrolled out of the screen. Now it works like the thumbnail
// engine (4.8):
//
//  FolderCountMemory  one shared LruCache, so rotation / a new ExplorerUi /
//                     coming back to a folder shows the numbers at once. The
//                     key holds the folder's date (path|modified): a folder's
//                     date changes when something is added to it or removed
//                     from it, so a stale number is never shown.
//  FolderCounter      one low-priority worker, NEWEST request first (the rows
//                     on screen are counted before the ones scrolled past), a
//                     request can be cancelled (row recycled), results come
//                     back on the main thread.
//  FolderCountSlot    glue of ONE row / cell / card: bind() answers at once
//                     from memory or queues a request, clear() cancels it.
//
// Count rules: every entry of the folder (hidden ones too, the explorer shows
// them), no recursion. [UNREADABLE] (-1) = Android refused to list the folder.
// A folder with 0 entries is "Empty" and keeps the plain folder icon; a folder
// with entries gets the paper sheet in its icon (FileIconView.setFolder).
// =====================================================================

internal const val COUNT_UNREADABLE = -1

internal object FolderCountMemory {
    val counts: LruCache<String, Int> = LruCache(4096)

    fun keyOf(item: FileItem): String = "${item.path}|${item.modified}"

    fun clear() = counts.evictAll()
}

/** One queued / running count job. */
internal class FolderCountRequest(
    val key: String,
    val item: FileItem,
    internal val callback: (Int) -> Unit
) {
    @Volatile var cancelled = false
        private set

    internal fun markCancelled() { cancelled = true }
}

internal class FolderCounter {

    private val main = Handler(Looper.getMainLooper())
    private val queue = LinkedBlockingDeque<FolderCountRequest>()
    @Volatile private var down = false
    private val worker: Thread = Thread({ workLoop() }, "folder-count").apply {
        isDaemon = true
        start()
    }

    /** Count already known (main thread, instant) or null. */
    fun peek(item: FileItem): Int? = FolderCountMemory.counts.get(FolderCountMemory.keyOf(item))

    /** Queue a job. [onDone] runs on the main thread, only if the request was not cancelled. */
    fun request(item: FileItem, onDone: (Int) -> Unit): FolderCountRequest? {
        if (down) return null
        val r = FolderCountRequest(FolderCountMemory.keyOf(item), item, onDone)
        queue.addFirst(r)
        return r
    }

    fun cancel(r: FolderCountRequest?) {
        if (r == null) return
        r.markCancelled()
        queue.remove(r)
    }

    /** Drop every queued job (a job that is already counting finishes, its number is only cached). */
    fun cancelAll() {
        for (r in queue) r.markCancelled()
        queue.clear()
    }

    /** Stop the thread for good. The shared memory stays for the next ExplorerUi. */
    fun shutdown() {
        down = true
        cancelAll()
        main.removeCallbacksAndMessages(null)   // 4.15.3: no result may reach a row after the screen is gone
        worker.interrupt()
    }

    private fun workLoop() {
        try { Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND) } catch (e: Exception) { }
        while (!down) {
            val r = try { queue.takeFirst() } catch (e: InterruptedException) { return }
            if (r.cancelled) continue

            // may have been counted by another request while this one waited
            val known: Int? = FolderCountMemory.counts.get(r.key)
            val c: Int = known ?: try {
                r.item.file.list()?.size ?: COUNT_UNREADABLE
            } catch (e: Exception) {
                COUNT_UNREADABLE
            }
            if (down) return                         // 4.15.3: stopped meanwhile, store nothing
            // a finished number is valid even if the row left meanwhile: keep it for later
            if (known == null) FolderCountMemory.counts.put(r.key, c)
            if (r.cancelled) continue
            val result = c
            main.post { if (!r.cancelled && !down) r.callback(result) }
        }
    }
}

/**
 * The count side of ONE row / cell / card (one per ViewHolder view).
 *  - [bind] returns the count at once when it is known; otherwise it returns null, queues a
 *    request and calls [onArrived] (main thread) when the number is there. The holder then
 *    re-binds its text with the light "meta" payload, which reads [FolderCounter.peek].
 *  - [clear] cancels the request; called when the holder is recycled or shows a file.
 */
internal class FolderCountSlot(
    private val counter: FolderCounter,
    private val onArrived: () -> Unit
) {
    private var req: FolderCountRequest? = null

    fun bind(item: FileItem): Int? {
        counter.cancel(req)
        req = null
        val hit = counter.peek(item)
        if (hit != null) return hit
        req = counter.request(item) {
            req = null
            onArrived()
        }
        return null
    }

    fun clear() {
        counter.cancel(req)
        req = null
    }
}

/** Text of a folder's item count; "" while it is unknown or unreadable. Shared by List / Grid / Large. */
internal fun folderCountLabel(count: Int?): String = when {
    count == null || count < 0 -> ""
    count == 0 -> "Empty"
    count == 1 -> "1 item"
    else -> "$count items"
}
