package com.srizwan.video.home

import android.graphics.Bitmap
import android.media.ThumbnailUtils
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.LruCache
import android.util.Size
import android.widget.ImageView
import java.io.File
import java.util.concurrent.Executors

/**
 * Tiny video thumbnail loader for the Video app list: a frame of the file is decoded on a worker thread, kept
 * in an in-memory LRU cache (1/8 of the app heap). A recycled ImageView never gets a stale picture: the path is
 * kept in the view's tag and checked before the bitmap is set.
 */
object VideoThumbLoader {

    private val main = Handler(Looper.getMainLooper())
    private val pool = Executors.newFixedThreadPool(3)
    private val cache = object : LruCache<String, Bitmap>((Runtime.getRuntime().maxMemory() / 8L).toInt()) {
        override fun sizeOf(key: String, value: Bitmap): Int = value.byteCount
    }

    /** Shows the thumbnail of the video file [path] in [view]. */
    fun load(view: ImageView, path: String) {
        view.tag = path
        val hit = cache.get(path)
        if (hit != null) {
            view.setImageBitmap(hit)
            return
        }
        view.setImageDrawable(null)
        pool.execute {
            val bmp = decode(path)
            if (bmp != null) cache.put(path, bmp)
            main.post {
                if (view.tag == path) {
                    if (bmp != null) view.setImageBitmap(bmp) else view.setImageDrawable(null)
                }
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun decode(path: String): Bitmap? = try {
        if (Build.VERSION.SDK_INT >= 29) {
            ThumbnailUtils.createVideoThumbnail(File(path), Size(480, 270), null)
        } else {
            ThumbnailUtils.createVideoThumbnail(path, MediaStore.Images.Thumbnails.MINI_KIND)
        }
    } catch (e: Throwable) {
        null
    }
}
