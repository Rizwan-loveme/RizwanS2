package com.srizwan.gallery.loader

import android.content.ComponentCallbacks2
import android.content.Context
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.graphics.Matrix
import android.media.ExifInterface
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.util.Log
import android.util.LruCache
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryImage
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest
import java.util.concurrent.Future
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * Loads pictures into ImageViews without blocking the screen and without running out of memory.
 *
 *  - **Downsampled decoding**: a 12 MP photo is decoded straight to the size of its grid cell (ImageDecoder on
 *    Android 9+, BitmapFactory `inSampleSize` + EXIF orientation before that), never at full size. Android 9+ also
 *    opens HEIC / HEIF; older phones show the error icon for those.
 *  - **Memory cache**: an LruCache sized in bytes (1/8 of the heap, at most 96 MB); trimmed on low memory.
 *  - **Disk cache**: thumbnails are kept as small JPEG / PNG files in the app cache folder (`gallery_thumbs`, at
 *    most ~96 MB, oldest files removed first), so the grid is instant the second time and after a restart.
 *  - **Sizes are bucketed** (128, 192, 256, 384, 512, 768 px) so the grid at 2 to 5 columns reuses the same files.
 *    A thumbnail is decoded so its SHORT side fills the bucket (sharp under CENTER_CROP).
 *  - **Scrolling**: every ImageView remembers the request that owns it. A row that was rebound or scrolled away
 *    cancels its request, a late result is never put into the wrong row, and the newest request is decoded first
 *    (the rows you are looking at, not the ones you flew past). Pictures fade in when they arrive from disk / decode.
 *
 * Use [load] from adapters. [decodeFull] (blocking, no cache) is for the full-screen viewer.
 */
object ImageLoader {

    private const val TAG = "ImageLoader"
    private val BUCKETS = intArrayOf(128, 192, 256, 384, 512, 768)
    private const val DISK_MAX_BYTES = 96L * 1024 * 1024
    private const val DISK_TRIM_TO_BYTES = 72L * 1024 * 1024
    private const val TRIM_EVERY_WRITES = 100
    private const val QUALITY = 85
    private const val FADE_MS = 160L

    private class Request(val key: String) {
        @Volatile var done = false
        @Volatile var future: Future<*>? = null
    }

    /** A queue that hands out the NEWEST task first (the ThreadPoolExecutor calls offer() to queue a task). */
    private class NewestFirstQueue : LinkedBlockingDeque<Runnable>() {
        override fun offer(e: Runnable): Boolean = offerFirst(e)
    }

    private val main = Handler(Looper.getMainLooper())
    private val versions = HashMap<String, Int>()
    private val writes = AtomicInteger()
    private val cancels = AtomicInteger()
    private val trimming = AtomicBoolean(false)
    @Volatile private var app: Context? = null

    private val executor: ThreadPoolExecutor by lazy {
        val n = (Runtime.getRuntime().availableProcessors() - 1).coerceIn(2, 4)
        ThreadPoolExecutor(n, n, 30L, TimeUnit.SECONDS, NewestFirstQueue(), ThreadFactory { r ->
            Thread({
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)
                r.run()
            }, "gallery-image").apply { isDaemon = true }
        }).apply { allowCoreThreadTimeOut(true) }
    }

    private val memory: LruCache<String, Bitmap> by lazy {
        val bytes = (Runtime.getRuntime().maxMemory() / 8).coerceAtMost(96L * 1024 * 1024).toInt()
        object : LruCache<String, Bitmap>(bytes) {
            override fun sizeOf(key: String, value: Bitmap): Int = value.allocationByteCount
        }
    }

    // ── public API ───────────────────────────────────────────────────────────

    /**
     * Puts the thumbnail of [image] into [view], about [sizePx] pixels (the size of the cell). Safe to call for every
     * bind of a RecyclerView row. [placeholderColor] is the view's background until the picture arrives (0 = none).
     */
    fun load(view: ImageView, image: GalleryImage, sizePx: Int, placeholderColor: Int = 0x1FFFFFFF) {
        val context = ensureInit(view.context)
        val bucket = bucketFor(sizePx)
        val key = keyOf(image, bucket)
        val old = view.getTag(R.id.gl_tag_request) as? Request
        if (old != null && old.key == key) return // the same picture is already there / on its way
        cancelRequest(old)
        view.animate().cancel()
        view.alpha = 1f

        val hit = memory.get(key)
        if (hit != null) {
            view.setTag(R.id.gl_tag_request, Request(key).also { it.done = true })
            view.setImageBitmap(hit)
            return
        }

        val req = Request(key)
        view.setTag(R.id.gl_tag_request, req)
        view.setImageDrawable(null)
        if (placeholderColor != 0) view.setBackgroundColor(placeholderColor)
        req.future = executor.submit(Runnable {
            val bmp = try {
                thumb(context, image, bucket)
            } catch (e: Throwable) {
                Log.w(TAG, "thumbnail failed: ${image.path}", e)
                null
            }
            main.post {
                if (view.getTag(R.id.gl_tag_request) !== req) return@post // rebound or scrolled away meanwhile
                req.done = true
                if (bmp != null) {
                    view.setImageBitmap(bmp)
                    view.alpha = 0f
                    view.animate().alpha(1f).setDuration(FADE_MS).start()
                } else {
                    view.setImageDrawable(IconPlaceholder(context, R.drawable.gl_ic_error))
                }
            }
        })
    }

    /** Stops the request of [view] (a row that is recycled) and forgets it. */
    fun cancel(view: ImageView) {
        cancelRequest(view.getTag(R.id.gl_tag_request) as? Request)
        view.setTag(R.id.gl_tag_request, null)
    }

    /**
     * The thumbnail of [image] as a bitmap (memory cache, then disk cache, then decode). Blocking: call it from a
     * background thread. Null when the file cannot be decoded.
     */
    fun thumb(context: Context, image: GalleryImage, sizePx: Int): Bitmap? {
        val appContext = ensureInit(context)
        val bucket = bucketFor(sizePx)
        val key = keyOf(image, bucket)
        memory.get(key)?.let { return it }
        val file = diskFile(appContext, key)
        readDisk(file)?.let {
            memory.put(key, it)
            return it
        }
        val bmp = decode(image.path, targetShort = bucket, maxLong = bucket * 3) ?: return null
        memory.put(key, bmp)
        writeDisk(file, bmp)
        return bmp
    }

    /** The thumbnail if it is already in memory (no work), else null. */
    fun cachedThumb(image: GalleryImage, sizePx: Int): Bitmap? = memory.get(keyOf(image, bucketFor(sizePx)))

    /**
     * Decodes [path] so that its longest side is at most [maxSide] (never enlarged), EXIF orientation applied.
     * Blocking, nothing is cached: for the full-screen viewer. Null when the file cannot be decoded.
     */
    fun decodeFull(path: String, maxSide: Int): Bitmap? = decode(path, targetShort = 0, maxLong = maxSide)

    /**
     * Call after a picture was changed or replaced on disk (rotate saved, edited): its old thumbnails are dropped
     * from memory and the next load decodes it again.
     */
    fun invalidate(path: String) {
        synchronized(versions) { versions[path] = (versions[path] ?: 0) + 1 }
        val prefix = "$path|"
        for (k in memory.snapshot().keys) if (k.startsWith(prefix)) memory.remove(k)
    }

    fun clearMemory() {
        memory.evictAll()
    }

    /** Deletes every thumbnail file. */
    fun clearDisk(context: Context) {
        val appContext = ensureInit(context)
        cacheDir(appContext).listFiles()?.forEach { it.delete() }
    }

    /** Size of the thumbnail files, in bytes. */
    fun diskBytes(context: Context): Long {
        val appContext = ensureInit(context)
        return cacheDir(appContext).listFiles()?.sumOf { it.length() } ?: 0L
    }

    @Suppress("DEPRECATION")
    fun trimMemory(level: Int) {
        if (level >= ComponentCallbacks2.TRIM_MEMORY_BACKGROUND) {
            memory.evictAll()
        } else if (level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW) {
            memory.trimToSize(memory.size() / 2)
        }
    }

    /** The bucket (128 ... 768 px) a cell of [sizePx] pixels uses. */
    fun bucketFor(sizePx: Int): Int {
        for (b in BUCKETS) if (sizePx <= b) return b
        return BUCKETS[BUCKETS.size - 1]
    }

    // ── set-up and keys ──────────────────────────────────────────────────────

    private fun ensureInit(context: Context): Context {
        app?.let { return it }
        return synchronized(this) {
            app ?: context.applicationContext.also { a ->
                a.registerComponentCallbacks(object : ComponentCallbacks2 {
                    override fun onTrimMemory(level: Int) {
                        trimMemory(level)
                    }

                    override fun onConfigurationChanged(newConfig: Configuration) {}

                    override fun onLowMemory() {
                        memory.evictAll()
                    }
                })
                app = a
            }
        }
    }

    private fun keyOf(image: GalleryImage, bucket: Int): String {
        val v = synchronized(versions) { versions[image.path] ?: 0 }
        return "${image.path}|${image.size}|${image.dateMillis}|$v|$bucket"
    }

    private fun cancelRequest(req: Request?) {
        if (req == null || req.done) return
        req.future?.cancel(false)
        if (cancels.incrementAndGet() % 64 == 0) executor.purge() // drop cancelled tasks from the queue
    }

    // ── disk cache ───────────────────────────────────────────────────────────

    private fun cacheDir(context: Context): File = File(context.cacheDir, "gallery_thumbs").also { it.mkdirs() }

    private fun diskFile(context: Context, key: String): File {
        val digest = MessageDigest.getInstance("SHA-1").digest(key.toByteArray())
        val name = StringBuilder(digest.size * 2)
        for (b in digest) name.append(String.format("%02x", b))
        return File(cacheDir(context), name.toString())
    }

    private fun readDisk(file: File): Bitmap? {
        if (!file.isFile) return null
        return try {
            val bmp = BitmapFactory.decodeFile(file.absolutePath)
            if (bmp != null) file.setLastModified(System.currentTimeMillis()) // newest use = last to be trimmed
            bmp
        } catch (e: Throwable) {
            null
        }
    }

    private fun writeDisk(file: File, bmp: Bitmap) {
        try {
            val tmp = File(file.parentFile, file.name + ".tmp")
            FileOutputStream(tmp).use { out ->
                val format = if (bmp.hasAlpha()) Bitmap.CompressFormat.PNG else Bitmap.CompressFormat.JPEG
                bmp.compress(format, QUALITY, out)
            }
            if (!tmp.renameTo(file)) tmp.delete()
        } catch (e: Throwable) {
            Log.w(TAG, "cannot write thumbnail", e)
        }
        if (writes.incrementAndGet() % TRIM_EVERY_WRITES == 0) trimDisk(file.parentFile)
    }

    /** Removes the oldest thumbnail files once the folder is over its limit. */
    private fun trimDisk(dir: File?) {
        if (dir == null || !trimming.compareAndSet(false, true)) return
        try {
            val files = dir.listFiles() ?: return
            var total = 0L
            for (f in files) total += f.length()
            if (total <= DISK_MAX_BYTES) return
            for (f in files.sortedBy { it.lastModified() }) {
                if (total <= DISK_TRIM_TO_BYTES) break
                val len = f.length()
                if (f.delete()) total -= len
            }
        } finally {
            trimming.set(false)
        }
    }

    // ── decoding ─────────────────────────────────────────────────────────────

    /**
     * How much to shrink a [w] x [h] picture: so the short side is [targetShort] (0 = no such wish), but the long
     * side stays within [maxLong]; never above 1 (a small picture is not enlarged).
     */
    private fun scaleFor(w: Int, h: Int, targetShort: Int, maxLong: Int): Float {
        val short = min(w, h).toFloat()
        val long = max(w, h).toFloat()
        var s = if (targetShort > 0) targetShort / short else 1f
        if (maxLong > 0) s = min(s, maxLong / long)
        return min(s, 1f)
    }

    private fun decode(path: String, targetShort: Int, maxLong: Int): Bitmap? {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return decodeWithImageDecoder(path, targetShort, maxLong)
            } catch (e: Throwable) {
                Log.w(TAG, "ImageDecoder failed, trying BitmapFactory: $path", e)
            }
        }
        return try {
            decodeWithFactory(path, targetShort, maxLong)
        } catch (e: Throwable) {
            Log.w(TAG, "decode failed: $path", e)
            null
        }
    }

    /** Android 9+: also reads HEIC / HEIF and animated images (first frame), and applies the EXIF orientation. */
    @RequiresApi(28)
    private fun decodeWithImageDecoder(path: String, targetShort: Int, maxLong: Int): Bitmap {
        val source = ImageDecoder.createSource(File(path))
        return ImageDecoder.decodeBitmap(source) { decoder, info, _ ->
            decoder.allocator = ImageDecoder.ALLOCATOR_SOFTWARE // a bitmap we can also compress to the disk cache
            val w = info.size.width
            val h = info.size.height
            val s = scaleFor(w, h, targetShort, maxLong)
            if (s < 1f) {
                decoder.setTargetSize(max(1, (w * s).roundToInt()), max(1, (h * s).roundToInt()))
            }
        }
    }

    private fun decodeWithFactory(path: String, targetShort: Int, maxLong: Int): Bitmap? {
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(path, bounds)
        val w = bounds.outWidth
        val h = bounds.outHeight
        if (w <= 0 || h <= 0) return null
        val s = scaleFor(w, h, targetShort, maxLong)
        var sample = 1
        while (1f / (sample * 2) >= s) sample *= 2 // the biggest power of two that still keeps the wanted size
        val opts = BitmapFactory.Options().apply {
            inSampleSize = sample
            inPreferredConfig = Bitmap.Config.ARGB_8888
        }
        val raw = BitmapFactory.decodeFile(path, opts) ?: return null
        val orientation = try {
            ExifInterface(path).getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
        } catch (e: Throwable) {
            ExifInterface.ORIENTATION_NORMAL
        }
        var bmp = applyOrientation(raw, orientation)
        // inSampleSize only halves: bring a result that is still too big down to the limit
        if (maxLong > 0 && max(bmp.width, bmp.height) > maxLong) {
            val k = maxLong.toFloat() / max(bmp.width, bmp.height)
            val scaled = Bitmap.createScaledBitmap(
                bmp, max(1, (bmp.width * k).roundToInt()), max(1, (bmp.height * k).roundToInt()), true
            )
            if (scaled !== bmp) bmp.recycle()
            bmp = scaled
        }
        return bmp
    }

    private fun applyOrientation(bmp: Bitmap, orientation: Int): Bitmap {
        val m = Matrix()
        when (orientation) {
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> m.postScale(-1f, 1f)
            ExifInterface.ORIENTATION_ROTATE_180 -> m.postRotate(180f)
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> m.postScale(1f, -1f)
            ExifInterface.ORIENTATION_TRANSPOSE -> {
                m.postRotate(90f)
                m.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_ROTATE_90 -> m.postRotate(90f)
            ExifInterface.ORIENTATION_TRANSVERSE -> {
                m.postRotate(-90f)
                m.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_ROTATE_270 -> m.postRotate(-90f)
            else -> return bmp
        }
        val out = Bitmap.createBitmap(bmp, 0, 0, bmp.width, bmp.height, m, true)
        if (out !== bmp) bmp.recycle()
        return out
    }
}
