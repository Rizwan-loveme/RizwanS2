package com.srizwan.YouTube.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.widget.ImageView
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.Executors

/**
 * Tiny thumbnail loader for the feed (no image library in the module): OkHttp download, down-sampled decode,
 * an in-memory LRU cache (1/8 of the app heap), three worker threads. A recycled ImageView is never given a
 * stale picture: the url is kept in the view's tag and checked before the bitmap is set.
 */
object ThumbLoader {

    private val main = Handler(Looper.getMainLooper())
    private val pool = Executors.newFixedThreadPool(3)
    private val client by lazy { OkHttpClient() }
    private val cache = object : LruCache<String, Bitmap>((Runtime.getRuntime().maxMemory() / 8L).toInt()) {
        override fun sizeOf(key: String, value: Bitmap): Int = value.byteCount
    }

    /** Shows [url] in [view] (decoded to about [targetWidthPx] wide). A null url just clears the picture. */
    fun load(view: ImageView, url: String?, targetWidthPx: Int) {
        view.tag = url
        view.setImageDrawable(null)
        if (url.isNullOrEmpty()) return
        cache.get(url)?.let { view.setImageBitmap(it); return }
        pool.execute {
            val bmp = runCatching { download(url, targetWidthPx) }.getOrNull() ?: return@execute
            cache.put(url, bmp)
            main.post { if (view.tag == url) view.setImageBitmap(bmp) }
        }
    }

    private fun download(url: String, targetWidthPx: Int): Bitmap? {
        val bytes = client.newCall(Request.Builder().url(url).build()).execute().use { r ->
            if (!r.isSuccessful) null else r.body?.bytes()
        } ?: return null
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size, bounds)
        var sample = 1
        while (bounds.outWidth / (sample * 2) >= targetWidthPx) sample *= 2
        val opts = BitmapFactory.Options().apply { inSampleSize = sample }
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size, opts)
    }
}
