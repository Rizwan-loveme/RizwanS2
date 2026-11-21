package com.srizwan.gallery.viewer

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapRegionDecoder
import android.graphics.Matrix
import android.graphics.Rect
import android.graphics.RectF
import kotlin.math.roundToInt

/**
 * Tiled (subsampled) decoding for pictures that are bigger than the base bitmap of the viewer (12 MP photos, 4K
 * screenshots): a [BitmapRegionDecoder] reads ONLY the part of the file that is on screen, at the sharpness the
 * current zoom needs, so the full picture never sits in memory.
 *
 * Rectangles are in the ORIENTED picture (what the user sees, EXIF applied). The decoder works on the stored picture,
 * so a requested rectangle is mapped back through the EXIF orientation and the decoded tile is turned the same way
 * as the picture. One decoder is not thread safe: every call locks it.
 */
internal class TileSource private constructor(
    private val decoder: BitmapRegionDecoder,
    private val orientation: Int,
    private val sourceW: Int,
    private val sourceH: Int,
    private val rgb565: Boolean
) {

    /** A decoded piece: [rect] is where it belongs in the oriented picture (picture pixels). */
    class Tile(val bitmap: Bitmap, val rect: RectF)

    private val identity = ImageGeometry.isIdentity(orientation)
    private val toOriented: Matrix = ImageGeometry.orientationMatrix(orientation, sourceW, sourceH)
    private val toSource: Matrix = Matrix().also { toOriented.invert(it) }

    /**
     * Decodes the oriented rectangle ([left], [top]) - ([right], [bottom]) with `inSampleSize = [sample]`
     * (1 = full sharpness, 2 = half, 4 = quarter ...). Null when the rectangle is empty or the decoder is closed.
     */
    fun decode(left: Int, top: Int, right: Int, bottom: Int, sample: Int): Tile? {
        val r = RectF(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
        toSource.mapRect(r)
        val src = Rect(
            r.left.roundToInt().coerceIn(0, sourceW),
            r.top.roundToInt().coerceIn(0, sourceH),
            r.right.roundToInt().coerceIn(0, sourceW),
            r.bottom.roundToInt().coerceIn(0, sourceH)
        )
        if (src.width() <= 0 || src.height() <= 0) return null
        val opts = BitmapFactory.Options().apply {
            inSampleSize = sample.coerceAtLeast(1)
            inPreferredConfig = if (rgb565) Bitmap.Config.RGB_565 else Bitmap.Config.ARGB_8888
        }
        val raw = synchronized(decoder) {
            if (decoder.isRecycled) null else decoder.decodeRegion(src, opts)
        } ?: return null
        val bmp = if (identity) {
            raw
        } else {
            val m = ImageGeometry.orientationMatrix(orientation, raw.width, raw.height)
            val out = Bitmap.createBitmap(raw, 0, 0, raw.width, raw.height, m, true)
            if (out !== raw) raw.recycle() // a temporary that was never drawn
            out
        }
        val placed = RectF(src)
        toOriented.mapRect(placed)
        return Tile(bmp, placed)
    }

    /** Releases the decoder. Safe to call twice and while a tile is being decoded on another thread. */
    fun close() {
        synchronized(decoder) {
            if (!decoder.isRecycled) decoder.recycle()
        }
    }

    companion object {
        /**
         * Opens [path] for tiled decoding. [sourceW] x [sourceH] is the stored size (EXIF not applied). Null when the
         * format has no region decoder on this device (e.g. HEIC on older Android): the viewer then shows the base
         * bitmap only.
         */
        @Suppress("DEPRECATION") // the (path, isShareable) overload is the one that exists on API 26
        fun open(path: String, orientation: Int, sourceW: Int, sourceH: Int): TileSource? = try {
            val d = BitmapRegionDecoder.newInstance(path, false)
            if (d == null) {
                null
            } else if (d.width != sourceW || d.height != sourceH) {
                d.recycle()
                null
            } else {
                val lower = path.lowercase()
                TileSource(d, orientation, sourceW, sourceH, lower.endsWith(".jpg") || lower.endsWith(".jpeg"))
            }
        } catch (e: Throwable) {
            null
        }
    }
}
