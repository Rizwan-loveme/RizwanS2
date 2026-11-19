package com.srizwan.win11

import android.content.ComponentCallbacks2
import android.content.Context
import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.SystemClock
import android.util.LruCache
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.atomic.AtomicBoolean

// =====================================================================
// THUMBNAIL CACHE ENGINE  (step 4.8 - list engine)
//
// The engine only: memory cache + worker threads + request cancelling +
// placeholder handling. It knows NOTHING about how to turn a file into a
// picture; that is done by a [ThumbDecoder]. Decoders are added in the
// next parts and plug in with ThumbLoader.register(...):
//   4.9  images      (inSampleSize, EXIF rotation)            ImageThumbs.kt
//   4.10 videos      (MediaMetadataRetriever frame, duration)  VideoThumbs.kt
//   4.11 APK / audio / PDF                                    ApkAudioPdfThumbs.kt
// With no decoder registered nothing is requested and every row keeps
// its normal file icon, so this part changes nothing on screen by itself.
//
//  ThumbMemory   one shared LruCache of bitmaps (+ a small "no picture" list)
//  ThumbDecoder  turns one FileItem into a Bitmap (runs on a worker thread)
//  ThumbRequest  handle of one queued / running job, can be cancelled
//  ThumbLoader   the thread pool (newest request first), one per ExplorerUi
//  ThumbSlot     glue of ONE row / cell / card: bind() asks, clear() cancels
// =====================================================================

/** Makes the picture of one file. Always called on a worker thread, never on the main thread. */
internal interface ThumbDecoder {
    /** Cheap check (extension only, no disk access): can this decoder make a picture of [item]? */
    fun supports(item: FileItem): Boolean

    /**
     * Return a bitmap whose SHORT side is about [edgePx] (the views use CENTER_CROP; the long side
     * should stay within 2 x [edgePx] so memory stays small), or null when the
     * file has no picture (the file icon stays). Check [req].cancelled between the heavy steps and
     * return null early when it is true. Never recycle the returned bitmap; the cache owns it.
     */
    fun decode(item: FileItem, edgePx: Int, req: ThumbRequest): Bitmap?
}

/** One queued / running thumbnail job. [cancel] is safe from any thread. */
internal class ThumbRequest(
    val key: String,
    val item: FileItem,
    val edgePx: Int,
    internal val callback: (Bitmap?) -> Unit
) {
    @Volatile var cancelled = false
        private set

    internal fun markCancelled() { cancelled = true }
}

/**
 * The shared bitmap memory. Size: 1/6 of the app heap, at least 12 MB and at most 64 MB, counted in
 * real bitmap bytes (not in entries). It is shared by every [ThumbLoader], so a new ExplorerUi (or a
 * rotation) starts with the pictures that were already made. It shrinks by itself when Android asks
 * for memory (see [install]). Bitmaps are never recycled by hand: a view may still be drawing one.
 */
internal object ThumbMemory {
    private val maxBytes: Int = run {
        val heap = Runtime.getRuntime().maxMemory()
        (heap / 6).coerceIn(12L * 1024 * 1024, 64L * 1024 * 1024).toInt()
    }

    val bitmaps: LruCache<String, Bitmap> = object : LruCache<String, Bitmap>(maxBytes) {
        override fun sizeOf(key: String, value: Bitmap): Int = value.allocationByteCount
    }

    /** Keys whose decoder said "no picture" (broken / unsupported file): not retried on every scroll. */
    val misses: LruCache<String, Boolean> = LruCache(1024)

    /**
     * 4.10: duration (ms) of a video, stored by the video decoder under the same key as its picture
     * and shown as the badge in the corner. Tiny (a Long per file), so it is not trimmed with the bitmaps.
     */
    val durations: LruCache<String, Long> = LruCache(4096)

    private val installed = AtomicBoolean(false)

    /** Hook the low-memory callbacks once per process. */
    fun install(ctx: Context) {
        if (!installed.compareAndSet(false, true)) return
        ctx.applicationContext.registerComponentCallbacks(object : ComponentCallbacks2 {
            override fun onTrimMemory(level: Int) {
                // 4.15.3: levels are 5 / 10 / 15 (app in front), 20 (UI hidden), 40 / 60 / 80 (in the
                // background list). Before: every level from 10 to 39 only halved the cache, so
                // RUNNING_CRITICAL (15, the system is nearly out of memory) did no more than RUNNING_LOW.
                when {
                    level >= ComponentCallbacks2.TRIM_MEMORY_BACKGROUND -> bitmaps.evictAll()
                    level >= ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN -> bitmaps.trimToSize(maxBytes / 2)
                    level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL -> bitmaps.trimToSize(maxBytes / 4)
                    level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW -> bitmaps.trimToSize(maxBytes / 2)
                }
            }
            override fun onConfigurationChanged(newConfig: Configuration) {}
            override fun onLowMemory() { bitmaps.evictAll() }
        })
    }

    fun clear() {
        bitmaps.evictAll()
        misses.evictAll()
        durations.evictAll()
    }

    /** 4.15.3: one line for the debug log: bitmap bytes in use / limit, entries, "no picture" keys. */
    fun describe(): String =
        "bitmaps ${bitmaps.size() / 1024} KB of ${maxBytes / 1024} KB, " +
            "hits ${bitmaps.hitCount()} misses ${bitmaps.missCount()} evicted ${bitmaps.evictionCount()}, " +
            "noPicture ${misses.size()}, durations ${durations.size()}"
}

/**
 * Worker pool of the thumbnail engine. 2 - 4 background-priority threads. The queue is **newest
 * first**: while the user flings through a folder the rows that are on screen now are made before
 * the ones that were scrolled past. A request that is cancelled (its row was recycled or re-bound)
 * is removed from the queue and, if it is already decoding, its result is dropped.
 */
internal class ThumbLoader(ctx: Context) {

    companion object {
        /** Decoders are asked in the order they were added; the first one that supports a file wins. */
        private val decoders = CopyOnWriteArrayList<ThumbDecoder>()

        fun register(decoder: ThumbDecoder) {
            if (!decoders.contains(decoder)) decoders.add(decoder)
        }

        /** Key of a picture: file + its date + its size + the wanted edge, so an edited file is made again. */
        fun keyOf(item: FileItem, edgePx: Int): String =
            "${item.path}|${item.modified}|${item.size}|$edgePx"
    }

    private val main = Handler(Looper.getMainLooper())
    private val queue = LinkedBlockingDeque<ThumbRequest>()
    /** 4.15.3: jobs a worker is decoding right now, so cancelAll() / shutdown() can mark them cancelled too. */
    private val inFlight: MutableSet<ThumbRequest> =
        java.util.Collections.newSetFromMap(java.util.concurrent.ConcurrentHashMap<ThumbRequest, Boolean>())
    @Volatile private var down = false
    /** 4.15.1: while the list is flinging / being fast-scrolled the workers take no NEW job (see [hold]). */
    @Volatile private var holdUntil = 0L
    private val workers: List<Thread>

    init {
        ThumbMemory.install(ctx)
        val n = (Runtime.getRuntime().availableProcessors() - 1).coerceIn(2, 4)
        workers = List(n) { i ->
            Thread({ workLoop() }, "thumb-$i").apply { isDaemon = true; start() }
        }
    }

    fun supports(item: FileItem): Boolean = !item.isDir && decoders.any { it.supports(item) }

    /** Picture already in memory (main thread, instant) or null. */
    fun peek(key: String): Bitmap? = ThumbMemory.bitmaps.get(key)

    fun isMiss(key: String): Boolean = ThumbMemory.misses.get(key) == true

    /** Queue a job. [onDone] runs on the main thread, only if the request was not cancelled. */
    fun request(item: FileItem, edgePx: Int, key: String, onDone: (Bitmap?) -> Unit): ThumbRequest? {
        if (down) return null
        val r = ThumbRequest(key, item, edgePx, onDone)
        queue.addFirst(r)
        return r
    }

    fun cancel(r: ThumbRequest?) {
        if (r == null) return
        r.markCancelled()
        queue.remove(r)
    }

    /**
     * 4.15.1: stop starting new decodes for [ms] (a job already decoding finishes). Called while the
     * list flings or the fast-scroll thumb is dragged, so the CPU goes to scrolling, not to pictures
     * that are scrolled past before they appear. It always expires by itself, so nothing can stay stuck.
     */
    fun hold(ms: Long) { holdUntil = SystemClock.uptimeMillis() + ms }

    /** 4.15.1: scrolling stopped: start the waiting jobs now (the newest = the visible ones first). */
    fun release() { holdUntil = 0L }

    /** Drop every queued job (a job that is already decoding finishes, its result is only cached). */
    fun cancelAll() {
        for (r in queue) r.markCancelled()
        queue.clear()
        for (r in inFlight) r.markCancelled()   // 4.15.3: a decode that fails now is not "no picture"
    }

    /**
     * Stop the threads for good. The shared bitmap memory stays for the next ExplorerUi.
     * 4.15.3: also removes the results already posted to the main thread, so no callback (which
     * reaches a row view and so the Activity) runs after the screen is gone.
     */
    fun shutdown() {
        down = true
        cancelAll()
        main.removeCallbacksAndMessages(null)
        for (t in workers) t.interrupt()
    }

    private fun workLoop() {
        try { Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND) } catch (e: Exception) { }
        while (!down) {
            try {
                while (!down && SystemClock.uptimeMillis() < holdUntil) Thread.sleep(40L)
            } catch (e: InterruptedException) { return }
            val r = try { queue.takeFirst() } catch (e: InterruptedException) { return }
            if (r.cancelled) continue
            inFlight.add(r)
            try {
                // may have been made by another request while this one waited
                var bmp: Bitmap? = ThumbMemory.bitmaps.get(r.key)
                if (bmp == null && ThumbMemory.misses.get(r.key) != true) {
                    var failedForMemory = false
                    try {
                        val d = decoders.firstOrNull { it.supports(r.item) }
                        bmp = d?.decode(r.item, r.edgePx, r)
                    } catch (e: OutOfMemoryError) {
                        failedForMemory = true
                        ThumbMemory.bitmaps.evictAll()
                    } catch (e: Throwable) {
                        bmp = null
                    }
                    // a cancelled job may return a half result, and a decode stopped by shutdown()
                    // (thread interrupted) failed because of the stop, not because of the file:
                    // never cache either as "no picture" (4.15.3: this used to mark good files as broken)
                    val stopped = down || r.cancelled || Thread.currentThread().isInterrupted
                    if (bmp != null) {
                        ThumbMemory.bitmaps.put(r.key, bmp)
                    } else if (!failedForMemory && !stopped) {
                        ThumbMemory.misses.put(r.key, true)
                    }
                }
                if (r.cancelled || down) continue
                val result = bmp
                main.post { if (!r.cancelled && !down) r.callback(result) }
            } finally {
                inFlight.remove(r)
            }
        }
    }
}

/**
 * The thumbnail side of ONE row / cell / card (one per ViewHolder view).
 *
 *  - [bind] is called from the holder's bind(): folders and unsupported files clear the slot; a
 *    picture in memory is shown at once; otherwise the file icon (the placeholder) stays and a
 *    request is queued; when it arrives the picture fades in (150 ms) and the icon is hidden.
 *  - [clear] cancels the request and removes the picture. It is called when the holder is recycled,
 *    so a recycled row never shows (or receives) the picture of the file it showed before.
 *
 * [image] is the ImageView on top of the icon; [onShown] tells the holder to hide / show the icon
 * (and, for the grid, to switch its more button to the dark round style).
 */
internal class ThumbSlot(
    private val loader: ThumbLoader,
    private val image: ImageView,
    /** 4.10: small text badge in the corner for the video duration; null = this view has none. */
    private val badge: TextView? = null,
    private val onShown: (Boolean) -> Unit
) {
    private var req: ThumbRequest? = null
    private var shownKey: String? = null

    fun bind(item: FileItem, edgePx: Int) {
        if (!loader.supports(item)) { clear(); return }
        val key = ThumbLoader.keyOf(item, edgePx)
        // same picture already on screen (a payload re-bind): nothing to do, no flicker
        if (key == shownKey && image.drawable != null) return

        cancelRequest()
        val hit = loader.peek(key)
        if (hit != null) { show(key, hit, false); return }

        hide()                                   // placeholder = the normal file icon
        if (loader.isMiss(key)) return
        req = loader.request(item, edgePx, key) { bmp ->
            req = null
            if (bmp != null) show(key, bmp, true)
        }
    }

    fun clear() {
        cancelRequest()
        hide()
    }

    private fun cancelRequest() {
        loader.cancel(req)
        req = null
    }

    private fun hide() {
        image.animate().cancel()
        image.setImageDrawable(null)
        image.visibility = View.GONE
        badge?.animate()?.cancel()
        badge?.visibility = View.GONE
        shownKey = null
        onShown(false)
    }

    private fun show(key: String, bmp: Bitmap, fade: Boolean) {
        shownKey = key
        image.animate().cancel()
        image.setImageBitmap(bmp)
        image.visibility = View.VISIBLE
        // 4.10: duration badge (only videos have an entry; for everything else the badge stays hidden)
        val dur = ThumbMemory.durations.get(key)
        val b = badge
        if (b != null) {
            b.animate().cancel()
            if (dur != null && dur > 0L) {
                b.text = formatDuration(dur)
                b.visibility = View.VISIBLE
            } else {
                b.visibility = View.GONE
            }
        }
        if (fade) {
            image.alpha = 0f
            image.animate().alpha(1f).setDuration(150L).start()
            if (b != null && b.visibility == View.VISIBLE) {
                b.alpha = 0f
                b.animate().alpha(1f).setDuration(150L).start()
            }
        } else {
            image.alpha = 1f
            b?.alpha = 1f
        }
        onShown(true)
    }
}

/** 4.10: video length as m:ss, or h:mm:ss from one hour on (rounded to the nearest second, at least 0:01). */
internal fun formatDuration(ms: Long): String {
    val total = ((ms + 500L) / 1000L).coerceAtLeast(1L)
    val h = total / 3600
    val m = (total % 3600) / 60
    val sec = total % 60
    return if (h > 0) String.format(java.util.Locale.US, "%d:%02d:%02d", h, m, sec)
    else String.format(java.util.Locale.US, "%d:%02d", m, sec)
}
