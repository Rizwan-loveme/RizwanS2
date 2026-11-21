package com.srizwan.chooser.picker

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.media.MediaMetadataRetriever
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.widget.ImageView
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory

/**
 * Small pictures for the picker: a decoded, down-sized thumbnail of an image or the first frame of a video, drawn instead of the file icon.
 * Decoding runs on three background threads; a memory cache (an eighth of the app's heap at most 24 MB) keeps what was seen. A thumbnail
 * is set on its view only when the view still shows the same file (the list recycles views), and a file that cannot be decoded keeps its icon.
 */
class PickerThumbs {

    private val main = Handler(Looper.getMainLooper())
    private val pool = Executors.newFixedThreadPool(3, ThreadFactory { r ->
        Thread(r, "picker-thumbs").apply { isDaemon = true; priority = Thread.MIN_PRIORITY }
    })
    private val cache = object : LruCache<String, Bitmap>(cacheKb()) {
        override fun sizeOf(key: String, value: Bitmap): Int = value.byteCount / 1024
    }
    private val failed = HashSet<String>()

    /** Cached picture for [key], or null. Main thread. */
    fun cached(key: String): Bitmap? = cache.get(key)

    /**
     * Loads the thumbnail of [file] (about [sizePx] on its longer side) and calls [onReady] on the main thread, but only when
     * `view.tag` still equals [key]. Call it only for pictures and videos ([isThumbnailType]).
     */
    fun load(file: File, key: String, sizePx: Int, view: ImageView, video: Boolean, onReady: (Bitmap) -> Unit) {
        cache.get(key)?.let { onReady(it); return }
        if (failed.contains(key)) return
        try {
            pool.execute {
                val bmp = try {
                    if (video) decodeVideo(file, sizePx) else decodeImage(file, sizePx)
                } catch (e: Throwable) {
                    null
                }
                main.post {
                    if (bmp == null) {
                        failed.add(key)
                    } else {
                        cache.put(key, bmp)
                        if (view.tag == key) onReady(bmp)
                    }
                }
            }
        } catch (e: Exception) {
            // the pool was shut down: nothing to do
        }
    }

    /** Stops the threads (the screen is closing). Pending work is dropped. */
    fun shutdown() {
        pool.shutdownNow()
        cache.evictAll()
    }

    private fun decodeImage(file: File, sizePx: Int): Bitmap? {
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(file.absolutePath, bounds)
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return null
        var sample = 1
        while (bounds.outWidth / (sample * 2) >= sizePx && bounds.outHeight / (sample * 2) >= sizePx) sample *= 2
        val opts = BitmapFactory.Options().apply {
            inSampleSize = sample
            inPreferredConfig = Bitmap.Config.RGB_565
        }
        val raw = BitmapFactory.decodeFile(file.absolutePath, opts) ?: return null
        val rotation = try {
            when (ExifInterface(file.absolutePath).getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)) {
                ExifInterface.ORIENTATION_ROTATE_90 -> 90f
                ExifInterface.ORIENTATION_ROTATE_180 -> 180f
                ExifInterface.ORIENTATION_ROTATE_270 -> 270f
                else -> 0f
            }
        } catch (e: Exception) {
            0f
        }
        if (rotation == 0f) return raw
        val m = Matrix().apply { postRotate(rotation) }
        return try {
            Bitmap.createBitmap(raw, 0, 0, raw.width, raw.height, m, true).also { if (it !== raw) raw.recycle() }
        } catch (e: Throwable) {
            raw
        }
    }

    private fun decodeVideo(file: File, sizePx: Int): Bitmap? {
        val r = MediaMetadataRetriever()
        return try {
            r.setDataSource(file.absolutePath)
            val frame = r.getFrameAtTime(-1L, MediaMetadataRetriever.OPTION_CLOSEST_SYNC) ?: return null
            val longest = maxOf(frame.width, frame.height)
            if (longest <= sizePx) frame else {
                val scale = sizePx.toFloat() / longest
                Bitmap.createScaledBitmap(frame, (frame.width * scale).toInt().coerceAtLeast(1), (frame.height * scale).toInt().coerceAtLeast(1), true)
                    .also { if (it !== frame) frame.recycle() }
            }
        } finally {
            try { r.release() } catch (e: Throwable) { /* ignore */ }
        }
    }

    companion object {
        /** Pictures the decoder handles and videos. (SVG and the like keep their icon.) */
        fun isThumbnailType(mime: String): Boolean =
            (mime.startsWith("image/") && mime != "image/svg+xml") || mime.startsWith("video/")

        private fun cacheKb(): Int {
            val maxKb = (Runtime.getRuntime().maxMemory() / 1024L).toInt()
            return (maxKb / 8).coerceIn(2048, 24 * 1024)
        }
    }
}
