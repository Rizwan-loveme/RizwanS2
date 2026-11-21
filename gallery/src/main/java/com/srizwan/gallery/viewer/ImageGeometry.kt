package com.srizwan.gallery.viewer

import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.RectF
import android.media.ExifInterface

/**
 * Orientation helpers of the viewer: the EXIF orientation of a file and the matrix that turns a picture as it is
 * STORED into the picture as it is meant to be SEEN (same maths as `ImageLoader.applyOrientation`, plus the
 * translation back to the origin so the matrix can also map rectangles, which the tiled decoder needs).
 */
internal object ImageGeometry {

    /** The EXIF orientation of [path] ([ExifInterface.ORIENTATION_NORMAL] when there is none or it cannot be read). */
    fun readOrientation(path: String): Int = try {
        ExifInterface(path).getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
    } catch (e: Throwable) {
        ExifInterface.ORIENTATION_NORMAL
    }

    /** `[width, height]` of the file as it is stored (EXIF not applied), or null when it cannot be read. */
    fun readStoredSize(path: String): IntArray? {
        val o = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(path, o)
        return if (o.outWidth > 0 && o.outHeight > 0) intArrayOf(o.outWidth, o.outHeight) else null
    }

    /** True when the orientation turns the picture by 90 / 270 degrees (width and height swap). */
    fun swapsAxes(orientation: Int): Boolean =
        orientation == ExifInterface.ORIENTATION_TRANSPOSE ||
            orientation == ExifInterface.ORIENTATION_ROTATE_90 ||
            orientation == ExifInterface.ORIENTATION_TRANSVERSE ||
            orientation == ExifInterface.ORIENTATION_ROTATE_270

    /** True when the orientation changes nothing. */
    fun isIdentity(orientation: Int): Boolean = when (orientation) {
        ExifInterface.ORIENTATION_FLIP_HORIZONTAL,
        ExifInterface.ORIENTATION_ROTATE_180,
        ExifInterface.ORIENTATION_FLIP_VERTICAL,
        ExifInterface.ORIENTATION_TRANSPOSE,
        ExifInterface.ORIENTATION_ROTATE_90,
        ExifInterface.ORIENTATION_TRANSVERSE,
        ExifInterface.ORIENTATION_ROTATE_270 -> false
        else -> true
    }

    /**
     * Maps a stored [w] x [h] picture to the oriented picture, with its top-left corner at the origin (so
     * `mapRect` of `(0, 0, w, h)` gives `(0, 0, orientedW, orientedH)`). Identity for a normal picture.
     */
    fun orientationMatrix(orientation: Int, w: Int, h: Int): Matrix {
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
            else -> return m
        }
        val r = RectF(0f, 0f, w.toFloat(), h.toFloat())
        m.mapRect(r)
        m.postTranslate(-r.left, -r.top)
        return m
    }
}
