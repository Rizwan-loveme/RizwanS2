package com.srizwan.gallery.data

import android.content.Context
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.text.format.Formatter
import com.srizwan.gallery.R
import java.io.File
import java.text.DateFormat
import java.util.Date
import java.util.Locale

/**
 * What the info sheet of the viewer shows about one picture (step 8): name, path, size, resolution, date and, when the
 * file has them, the camera, ISO, aperture, exposure, focal length and the GPS location.
 * [rows] are (label, value) pairs in display order; [latitude] / [longitude] are set when the picture has a location
 * (the sheet then offers to open it on a map).
 */
class ImageInfo(
    val rows: List<Pair<String, String>>,
    val latitude: Double?,
    val longitude: Double?
) {
    /** Index of the location row in [rows], or -1. */
    val locationRow: Int get() = if (latitude != null && longitude != null) rows.size - 1 else -1

    companion object {

        /** Reads the file (blocking: call it from a background thread). Every EXIF part is optional. */
        @Suppress("DEPRECATION") // android.media.ExifInterface: the same class the loader uses for the orientation
        fun read(context: Context, image: GalleryImage): ImageInfo {
            val rows = ArrayList<Pair<String, String>>()
            fun add(labelRes: Int, value: String?) {
                if (!value.isNullOrBlank()) rows.add(context.getString(labelRes) to value)
            }

            val file = File(image.path)
            add(R.string.gl_info_name, image.name)
            add(R.string.gl_info_path, image.path)
            add(R.string.gl_info_size, Formatter.formatFileSize(context, if (file.isFile) file.length() else image.size))

            var exif: ExifInterface? = null
            try {
                if (file.isFile) exif = ExifInterface(file.absolutePath)
            } catch (e: Throwable) {
                // not a format ExifInterface reads: the sheet just has no camera rows
            }

            add(R.string.gl_info_resolution, resolution(image, file, exif))
            add(R.string.gl_info_date, DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(Date(image.dateMillis)))

            var lat: Double? = null
            var lon: Double? = null
            if (exif != null) {
                try {
                    val make = exif.getAttribute(ExifInterface.TAG_MAKE)?.trim().orEmpty()
                    val model = exif.getAttribute(ExifInterface.TAG_MODEL)?.trim().orEmpty()
                    // many phones repeat the maker inside the model ("samsung" / "samsung SM-G991B")
                    val camera = when {
                        make.isEmpty() -> model
                        model.isEmpty() -> make
                        model.startsWith(make, ignoreCase = true) -> model
                        else -> "$make $model"
                    }
                    add(R.string.gl_info_camera, camera)

                    // string names instead of the constants: the ISO tag was renamed between API levels
                    val iso = exif.getAttribute("ISOSpeedRatings") ?: exif.getAttribute("PhotographicSensitivity")
                    add(R.string.gl_info_iso, iso?.trim()?.takeIf { it.isNotEmpty() && it != "0" })

                    val f = exif.getAttributeDouble(ExifInterface.TAG_F_NUMBER, 0.0)
                    if (f > 0.0) add(R.string.gl_info_aperture, "f/" + trimNumber(f))

                    val t = exif.getAttributeDouble(ExifInterface.TAG_EXPOSURE_TIME, 0.0)
                    if (t > 0.0) add(R.string.gl_info_exposure, exposure(t))

                    val fl = exif.getAttributeDouble(ExifInterface.TAG_FOCAL_LENGTH, 0.0)
                    if (fl > 0.0) add(R.string.gl_info_focal, trimNumber(fl) + " mm")

                    val out = FloatArray(2)
                    if (exif.getLatLong(out)) {
                        lat = out[0].toDouble()
                        lon = out[1].toDouble()
                    }
                } catch (e: Throwable) {
                    // a damaged EXIF block: show what was read so far
                }
            }
            if (lat != null && lon != null) {
                rows.add(context.getString(R.string.gl_info_location) to String.format(Locale.US, "%.5f, %.5f", lat, lon))
            }
            return ImageInfo(rows, lat, lon)
        }

        /** "4000 x 3000 (12.0 MP)", read from the file (EXIF orientation applied), else from MediaStore's numbers. */
        private fun resolution(image: GalleryImage, file: File, exif: ExifInterface?): String? {
            var w = 0
            var h = 0
            try {
                val o = BitmapFactory.Options().apply { inJustDecodeBounds = true }
                BitmapFactory.decodeFile(file.absolutePath, o)
                w = o.outWidth
                h = o.outHeight
                val orientation = exif?.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
                    ?: ExifInterface.ORIENTATION_NORMAL
                val sideways = orientation == ExifInterface.ORIENTATION_ROTATE_90 ||
                    orientation == ExifInterface.ORIENTATION_ROTATE_270 ||
                    orientation == ExifInterface.ORIENTATION_TRANSPOSE ||
                    orientation == ExifInterface.ORIENTATION_TRANSVERSE
                if (sideways && w > 0 && h > 0) {
                    val tmp = w
                    w = h
                    h = tmp
                }
            } catch (e: Throwable) {
                w = 0
                h = 0
            }
            if (w <= 0 || h <= 0) {
                w = image.width
                h = image.height
            }
            if (w <= 0 || h <= 0) return null
            val mp = w.toLong() * h / 1_000_000.0
            return if (mp >= 0.1) String.format(Locale.US, "%d × %d (%.1f MP)", w, h, mp) else "$w × $h"
        }

        private fun exposure(seconds: Double): String =
            if (seconds >= 1.0) trimNumber(seconds) + " s" else "1/" + Math.round(1.0 / seconds) + " s"

        /** 1.8 -> "1.8", 4.0 -> "4", 5.4321 -> "5.4". */
        private fun trimNumber(v: Double): String {
            val one = String.format(Locale.US, "%.1f", v)
            return if (one.endsWith(".0")) one.dropLast(2) else one
        }
    }
}
