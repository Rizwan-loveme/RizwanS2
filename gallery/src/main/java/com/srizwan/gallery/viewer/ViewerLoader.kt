package com.srizwan.gallery.viewer

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.Movie
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Process
import android.util.Log
import androidx.annotation.RequiresApi
import com.srizwan.gallery.loader.ImageLoader
import java.io.File
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import kotlin.math.max
import kotlin.math.roundToInt

/**
 * Loads ONE picture for the full-screen viewer (blocking, call it from [pageExecutor]).
 *
 *  - **Still pictures**: a base bitmap whose long side is at most [BASE_MAX_SIDE] (EXIF orientation applied, via
 *    [ImageLoader.decodeFull]). When the real picture is bigger than that, a [TileSource] is opened as well, so zooming
 *    in decodes sharp tiles of just the visible part (see [ZoomImageView]). 4K / 12 MP photos never sit in memory
 *    at full size.
 *  - **Animated GIF**: `AnimatedImageDrawable` on Android 9+, [MovieDrawable] on Android 8. If the GIF turns out
 *    to have a single frame, it is loaded as a still picture.
 */
internal object ViewerLoader {

    private const val TAG = "ViewerLoader"

    /** Longest side of the base bitmap (about 12 MB at 4:3). */
    const val BASE_MAX_SIDE = 2048

    /** Longest side an animated GIF is decoded at (frames are the memory cost, so it is kept smaller). */
    private const val GIF_MAX_SIDE = 1600

    /**
     * What [load] returns. [width] x [height] is the size of the whole picture as it is SEEN (EXIF applied), in picture
     * pixels; it can be bigger than [bitmap] when [tiles] is set. Exactly one of [bitmap] / [animated] is set.
     */
    class Result(
        val bitmap: Bitmap?,
        val animated: Drawable?,
        val width: Int,
        val height: Int,
        val tiles: TileSource?
    )

    private fun pool(name: String, threads: Int) = ThreadPoolExecutor(
        threads, threads, 30L, TimeUnit.SECONDS, LinkedBlockingQueue<Runnable>(),
        ThreadFactory { r ->
            Thread({
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)
                r.run()
            }, name).apply { isDaemon = true }
        }
    ).apply { allowCoreThreadTimeOut(true) }

    /** Page loads (one picture each). */
    val pageExecutor: ThreadPoolExecutor by lazy { pool("gallery-viewer", 2) }

    /** Tile decoding while zoomed in. */
    val tileExecutor: ThreadPoolExecutor by lazy { pool("gallery-tiles", 2) }

    /** Blocking. Null when the file cannot be decoded at all. */
    fun load(path: String, isGif: Boolean): Result? {
        if (isGif) {
            val animated = try {
                if (Build.VERSION.SDK_INT >= 28) loadAnimated(path) else loadMovie(path)
            } catch (e: Throwable) {
                Log.w(TAG, "animated decode failed, showing the first frame: $path", e)
                null
            }
            if (animated != null) return animated
        }
        val base = ImageLoader.decodeFull(path, BASE_MAX_SIDE) ?: return null
        var fullW = base.width
        var fullH = base.height
        var tiles: TileSource? = null
        try {
            val stored = ImageGeometry.readStoredSize(path)
            if (stored != null) {
                val orientation = ImageGeometry.readOrientation(path)
                val swap = ImageGeometry.swapsAxes(orientation)
                val seenW = if (swap) stored[1] else stored[0]
                val seenH = if (swap) stored[0] else stored[1]
                // The decoder must agree with EXIF about which way the picture stands, else the tile maths would be wrong.
                val agrees = seenW == seenH || (seenW > seenH) == (base.width > base.height)
                if (agrees && max(seenW, seenH) > max(base.width, base.height) * 1.05f) {
                    tiles = TileSource.open(path, orientation, stored[0], stored[1])
                    if (tiles != null) {
                        fullW = seenW
                        fullH = seenH
                    }
                }
            }
        } catch (e: Throwable) {
            Log.w(TAG, "tiling not available: $path", e)
            tiles?.close()
            tiles = null
            fullW = base.width
            fullH = base.height
        }
        return Result(base, null, fullW, fullH, tiles)
    }

    @RequiresApi(28)
    private fun loadAnimated(path: String): Result? {
        val drawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(File(path))) { decoder, info, _ ->
            val w = info.size.width
            val h = info.size.height
            val longSide = max(w, h)
            if (longSide > GIF_MAX_SIDE) {
                val k = GIF_MAX_SIDE.toFloat() / longSide
                decoder.setTargetSize(max(1, (w * k).roundToInt()), max(1, (h * k).roundToInt()))
            }
        }
        if (drawable !is AnimatedImageDrawable) return null // a one-frame GIF: shown as a still picture
        drawable.repeatCount = AnimatedImageDrawable.REPEAT_INFINITE
        return Result(null, drawable, drawable.intrinsicWidth, drawable.intrinsicHeight, null)
    }

    @Suppress("DEPRECATION")
    private fun loadMovie(path: String): Result? {
        val movie = Movie.decodeFile(path) ?: return null
        if (movie.duration() <= 0 || movie.width() <= 0 || movie.height() <= 0) return null
        return Result(null, MovieDrawable(movie), movie.width(), movie.height(), null)
    }
}
