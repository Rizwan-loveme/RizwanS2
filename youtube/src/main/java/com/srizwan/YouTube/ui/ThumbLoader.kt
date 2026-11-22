package com.srizwan.YouTube.ui

import android.graphics.Bitmap
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.widget.ImageView
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.security.MessageDigest
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

/**
 * Tiny thumbnail loader for the feed (no image library in the module): OkHttp download, down-sampled decode,
 * an in-memory LRU cache (1/8 of the app heap) and (step 5) a disk cache in the app's cache folder (up to about 80 MB,
 * oldest files go first), so thumbnails also show without a connection and load faster the second time; three worker threads. A recycled ImageView is never given a
 * stale picture: the url is kept in the view's tag and checked before the bitmap is set.
 */
object ThumbLoader {

    private val main = Handler(Looper.getMainLooper())
    private val pool = Executors.newFixedThreadPool(3)
    private val client by lazy { OkHttpClient() }
    private val writes = AtomicInteger()
    private const val MAX_DISK = 80L * 1024 * 1024
    private val cache = object : LruCache<String, Bitmap>((Runtime.getRuntime().maxMemory() / 8L).toInt()) {
        override fun sizeOf(key: String, value: Bitmap): Int = value.byteCount
    }

    /** Shows [url] in [view] (decoded to about [targetWidthPx] wide). A null url just clears the picture. */
    fun load(view: ImageView, url: String?, targetWidthPx: Int) {
        view.tag = url
        view.setImageDrawable(null)
        if (url.isNullOrEmpty()) return
        cache.get(url)?.let { view.setImageBitmap(it); return }
        val ctx = view.context.applicationContext
        pool.execute {
            val bmp = runCatching { download(ctx, url, targetWidthPx) }.getOrNull() ?: return@execute
            cache.put(url, bmp)
            main.post { if (view.tag == url) view.setImageBitmap(bmp) }
        }
    }

    private fun download(ctx: Context, url: String, targetWidthPx: Int): Bitmap? {
        val bytes = bytesFor(ctx, url) ?: return null
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size, bounds)
        var sample = 1
        while (bounds.outWidth / (sample * 2) >= targetWidthPx) sample *= 2
        val opts = BitmapFactory.Options().apply { inSampleSize = sample }
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size, opts)
    }

    // ---- disk cache (step 5) ----

    private fun key(url: String): String =
        MessageDigest.getInstance("SHA-1").digest(url.toByteArray()).joinToString("") { "%02x".format(it) }

    /** The picture's bytes: from the disk cache when they are there, otherwise from the network (and kept). */
    private fun bytesFor(ctx: Context, url: String): ByteArray? {
        val dir = File(ctx.cacheDir, "yt_thumbs").apply { mkdirs() }
        val file = File(dir, key(url))
        if (file.isFile && file.length() > 0) {
            runCatching { file.setLastModified(System.currentTimeMillis()) }
            runCatching { return file.readBytes() }
        }
        val bytes = client.newCall(Request.Builder().url(url).build()).execute().use { r ->
            if (!r.isSuccessful) null else r.body?.bytes()
        } ?: return null
        runCatching { file.writeBytes(bytes) }
        if (writes.incrementAndGet() % 60 == 0) prune(dir)
        return bytes
    }

    /** Over the limit: the oldest files are deleted until about three quarters of it is left. */
    private fun prune(dir: File) {
        val files = dir.listFiles() ?: return
        var total = files.sumOf { it.length() }
        if (total <= MAX_DISK) return
        for (f in files.sortedBy { it.lastModified() }) {
            total -= f.length()
            f.delete()
            if (total <= MAX_DISK * 3 / 4) break
        }
    }
}
