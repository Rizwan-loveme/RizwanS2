package com.srizwan.win11

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

// =====================================================================
// IMAGE THUMBNAILS  (step 4.9 - list engine)
//
// A [ThumbDecoder] for picture files. It plugs into the 4.8 engine with
// ThumbLoader.register(ImageThumbDecoder) (done once in ExplorerUi).
//
//  1. Read only the picture size (inJustDecodeBounds, no pixels).
//  2. Work out the wanted size: the SHORT side is about edgePx (the views
//     use CENTER_CROP, so the short side must fill the tile), the long
//     side is capped at 2 x edgePx so a panorama cannot eat the memory.
//     A picture smaller than that is never enlarged.
//  3. Decode with inSampleSize (a power of two, never below the wanted
//     size), so a 12 MP photo is never fully loaded into memory.
//  4. Scale to the exact wanted size (bilinear), then fix the EXIF
//     rotation / mirroring. Scaling comes first because it is cheaper
//     to rotate the small bitmap.
// The worker thread checks req.cancelled between the steps and stops
// early when the row was recycled.
// =====================================================================

/**
 * The size rule shared by all picture decoders (images 4.9, video 4.10): the SHORT side is about
 * [edgePx] (the tiles are CENTER_CROP), the long side is at most 2 x [edgePx], and a picture that is
 * already smaller is never enlarged. Returns [width, height].
 */
internal fun thumbTargetSize(w: Int, h: Int, edgePx: Int): IntArray {
    val shortSide = min(w, h).toFloat()
    val longSide = max(w, h).toFloat()
    val scale = min(edgePx / shortSide, (edgePx * 2) / longSide).coerceAtMost(1f)
    return intArrayOf(max(1, (w * scale).roundToInt()), max(1, (h * scale).roundToInt()))
}

internal object ImageThumbDecoder : ThumbDecoder {

    /** Extensions BitmapFactory can read. (SVG and RAW are not supported: they keep the file icon.) */
    private val EXTS = hashSetOf("jpg", "jpeg", "jpe", "png", "webp", "gif", "bmp", "heic", "heif")

    /** Formats that can carry an EXIF orientation tag. */
    private val EXIF_EXTS = hashSetOf("jpg", "jpeg", "jpe", "webp", "heic", "heif", "png")

    override fun supports(item: FileItem): Boolean = !item.isDir && item.ext in EXTS

    override fun decode(item: FileItem, edgePx: Int, req: ThumbRequest): Bitmap? {
        if (edgePx <= 0 || item.size <= 0L) return null
        val path = item.path

        // 1. size only
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(path, bounds)
        val w = bounds.outWidth
        val h = bounds.outHeight
        if (w <= 0 || h <= 0) return null
        if (req.cancelled) return null

        // 2. wanted size
        val target = thumbTargetSize(w, h, edgePx)
        val tw = target[0]
        val th = target[1]

        // 3. decode with the biggest power-of-two sample that is still >= the wanted size
        var sample = 1
        while (w / (sample * 2) >= tw && h / (sample * 2) >= th) sample *= 2
        val opts = BitmapFactory.Options().apply {
            inSampleSize = sample
            inPreferredConfig = Bitmap.Config.ARGB_8888
        }
        var bmp = BitmapFactory.decodeFile(path, opts) ?: return null
        if (req.cancelled) { bmp.recycle(); return null }

        // 4a. exact size
        if (bmp.width != tw || bmp.height != th) {
            // the sampled bitmap is never bigger than 2x the wanted size, so this is cheap
            if (bmp.width > tw || bmp.height > th) {
                val scaled = try { Bitmap.createScaledBitmap(bmp, tw, th, true) } catch (e: Exception) { bmp }
                if (scaled !== bmp) { bmp.recycle(); bmp = scaled }
            }
        }
        if (req.cancelled) { bmp.recycle(); return null }

        // 4b. EXIF rotation / mirroring
        if (item.ext in EXIF_EXTS) {
            val m = exifMatrix(path)
            if (m != null) {
                val turned = try {
                    Bitmap.createBitmap(bmp, 0, 0, bmp.width, bmp.height, m, true)
                } catch (e: Exception) { bmp }
                if (turned !== bmp) { bmp.recycle(); bmp = turned }
            }
        }
        return bmp
    }

    /** Matrix that makes the picture upright, or null when it already is (or has no EXIF). */
    private fun exifMatrix(path: String): Matrix? {
        val orientation = try {
            ExifInterface(path).getAttributeInt(
                ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL
            )
        } catch (e: Exception) {
            return null
        }
        val m = Matrix()
        when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> m.postRotate(90f)
            ExifInterface.ORIENTATION_ROTATE_180 -> m.postRotate(180f)
            ExifInterface.ORIENTATION_ROTATE_270 -> m.postRotate(270f)
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> m.postScale(-1f, 1f)
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> m.postScale(1f, -1f)
            ExifInterface.ORIENTATION_TRANSPOSE -> { m.postRotate(90f); m.postScale(-1f, 1f) }
            ExifInterface.ORIENTATION_TRANSVERSE -> { m.postRotate(270f); m.postScale(-1f, 1f) }
            else -> return null
        }
        return m
    }
}
