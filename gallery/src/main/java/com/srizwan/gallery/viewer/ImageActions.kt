package com.srizwan.gallery.viewer

import android.app.Activity
import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.media.MediaScannerConnection
import android.os.Build
import android.util.Log
import com.srizwan.chooser.share.Share
import com.srizwan.gallery.data.GalleryFileProvider
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.data.GalleryPrefs
import com.srizwan.gallery.data.GalleryRepository
import com.srizwan.gallery.loader.ImageLoader
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.math.max
import kotlin.math.min

/**
 * The file work behind the viewer's action buttons (step 8). Everything here is blocking except [share] (it only starts
 * the chooser): call [delete], [rename], [saveRotation] and [setWallpaper] from a background thread, as the viewer does.
 *
 * A plain `File` works on every folder (the app holds "all files access", MANAGE_EXTERNAL_STORAGE, so scoped storage does not apply even at the targetSdk 37 of part 8) once the storage permission / "all files access" is
 * granted (the same way the File Manager deletes and renames). After a change, MediaStore is told about it
 * ([MediaScannerConnection]), the thumbnails of the old file are dropped ([ImageLoader.invalidate]) and the shared list
 * ([GalleryRepository.cached]) is edited, so the home grid and the album screens show the change when they come back.
 */
internal object ImageActions {

    private const val TAG = "ImageActions"

    /** Pictures with more pixels than this are not rotated by decoding them again (about 64 MB as ARGB). */
    private const val MAX_ROTATE_PIXELS = 16_000_000L

    /** How a rename / rotate-save ended. */
    enum class Outcome { OK, BAD_NAME, EXISTS, FAILED, UNSUPPORTED, TOO_BIG }

    /** [image] is the picture as it is after the change (same as before when nothing changed). */
    class Changed(val outcome: Outcome, val image: GalleryImage?)

    /** Most pictures one share intent carries (a bigger list can overflow the binder transaction limit). */
    const val MAX_SHARE = 300

    /** Result of [deleteMany]: the paths that are gone and how many could not be deleted. */
    class BatchDelete(val deleted: List<String>, val failed: Int)

    // ── share ────────────────────────────────────────────────────────────────

    /**
     * Opens the Chooser's own Share sheet for [image] (the file goes out as a `content://` uri from [GalleryFileProvider]; the apps are
     * started with an explicit intent, no system chooser). False when the file is gone. Errors after the sheet opened are reported by the
     * sheet's own glass toast. Same signature as before the Chooser module (step 7).
     */
    fun share(activity: Activity, image: GalleryImage): Boolean {
        val file = File(image.path)
        if (!file.isFile) return false
        return try {
            Share.file(activity, file, image.mime, authority = GalleryFileProvider.authority(activity))
            true
        } catch (e: Exception) {
            Log.w(TAG, "share failed: ${image.path}", e)
            false
        }
    }

    /**
     * Shares several pictures at once (multi-select, step 9) with the Chooser's Share sheet (`ACTION_SEND_MULTIPLE`). One usable picture is
     * shared like [share]. False when nothing can be shared or more than [MAX_SHARE] pictures were picked.
     */
    fun shareMany(activity: Activity, images: List<GalleryImage>): Boolean {
        val usable = images.filter { File(it.path).isFile }
        if (usable.isEmpty() || usable.size > MAX_SHARE) return false
        if (usable.size == 1) return share(activity, usable[0])
        return try {
            val mimes = usable.map { it.mime }.toSet()
            Share.files(
                activity, usable.map { File(it.path) },
                mime = if (mimes.size == 1) mimes.first() else "image/*",
                authority = GalleryFileProvider.authority(activity)
            )
            true
        } catch (e: Exception) {
            Log.w(TAG, "share many failed (${usable.size} pictures)", e)
            false
        }
    }

    // ── delete ───────────────────────────────────────────────────────────────

    /**
     * Deletes the pictures one by one (blocking, call it off the main thread). A picture that cannot be deleted does not
     * stop the others. The shared list is edited once at the end.
     */
    fun deleteMany(context: Context, images: List<GalleryImage>): BatchDelete {
        val done = ArrayList<String>(images.size)
        var failed = 0
        for (image in images) {
            if (delete(context, image, updateCache = false)) done.add(image.path) else failed++
        }
        GalleryRepository.removeAllFromCache(done.toHashSet())
        return BatchDelete(done, failed)
    }

    /** Deletes the file and its MediaStore row. True when the file is gone. */
    fun delete(context: Context, image: GalleryImage, updateCache: Boolean = true): Boolean {
        val app = context.applicationContext
        val file = File(image.path)
        var gone = !file.exists() || file.delete()
        if (!gone && image.id > 0L) { // not ours to delete as a file: let MediaStore try
            try {
                app.contentResolver.delete(image.uri, null, null)
            } catch (e: Exception) {
                Log.w(TAG, "MediaStore delete refused: ${image.path}", e)
            }
            gone = !file.exists()
        }
        if (!gone) return false
        if (image.id > 0L) { // drop the row of a file that is gone (the scan below does it too, this is just quicker)
            try {
                app.contentResolver.delete(image.uri, null, null)
            } catch (e: Exception) {
                // already gone, or not allowed: the scan below settles it
            }
        }
        scan(app, arrayOf(image.path), wait = false)
        ImageLoader.invalidate(image.path)
        GalleryPrefs.setFavorite(app, image.path, false)
        if (updateCache) GalleryRepository.removeFromCache(image.path)
        return true
    }

    // ── rename ───────────────────────────────────────────────────────────────

    /**
     * Renames the file to [typed] inside the same folder. The extension is kept: a name typed without it gets it
     * appended. Names with `/ \ : * ? " < > |`, control characters, a leading dot or more than 255 bytes are refused
     * ([Outcome.BAD_NAME]); a name that is taken gives [Outcome.EXISTS].
     */
    fun rename(context: Context, image: GalleryImage, typed: String): Changed {
        val app = context.applicationContext
        val src = File(image.path)
        val oldName = src.name
        val ext = oldName.substringAfterLast('.', "")
        var name = typed.trim()
        if (name.isEmpty() || name.startsWith(".")) return Changed(Outcome.BAD_NAME, image)
        if (name.any { it in "/\\:*?\"<>|" || it.code < 32 }) return Changed(Outcome.BAD_NAME, image)
        if (ext.isNotEmpty() && !name.endsWith(".$ext", ignoreCase = true)) name += ".$ext"
        if (name.toByteArray(Charsets.UTF_8).size > 255) return Changed(Outcome.BAD_NAME, image)
        if (name == oldName) return Changed(Outcome.OK, image) // nothing to do

        if (!src.isFile) return Changed(Outcome.FAILED, image)
        val dst = File(src.parentFile, name)
        val caseOnly = name.equals(oldName, ignoreCase = true) // "IMG.jpg" -> "img.jpg": the same file on some storage
        if (!caseOnly && dst.exists()) return Changed(Outcome.EXISTS, image)
        if (!src.renameTo(dst)) return Changed(Outcome.FAILED, image)

        scan(app, arrayOf(src.absolutePath, dst.absolutePath), wait = true)
        ImageLoader.invalidate(image.path)
        GalleryPrefs.moveFavorite(app, image.path, dst.absolutePath)
        // id 0: the MediaStore row is a new one after the scan, so the picture is addressed by its file for now
        val renamed = image.copy(id = 0L, path = dst.absolutePath, name = name)
        GalleryRepository.replaceInCache(image.path, renamed)
        return Changed(Outcome.OK, renamed)
    }

    // ── rotate: save to the file ─────────────────────────────────────────────

    /**
     * Writes a clockwise rotation of [quarterTurns] x 90 degrees into the file.
     *  - **JPEG**: lossless, only the EXIF orientation tag is changed (no re-encoding, no memory use, works for any size).
     *  - **PNG / WebP**: the pixels are rotated and the file is written again (refused above 16 megapixels,
     *    [Outcome.TOO_BIG]; WebP is written lossless on Android 11+, quality 100 before that).
     *  - GIF (animated), BMP, HEIC / HEIF: [Outcome.UNSUPPORTED], the picture can still be turned in the viewer.
     */
    fun saveRotation(context: Context, image: GalleryImage, quarterTurns: Int): Changed {
        val app = context.applicationContext
        val t = ((quarterTurns % 4) + 4) % 4
        if (t == 0) return Changed(Outcome.OK, image)
        val file = File(image.path)
        if (!file.isFile || !file.canWrite()) return Changed(Outcome.FAILED, image)

        val outcome = try {
            when (image.mime) {
                "image/jpeg", "image/jpg" -> rotateJpegTag(file, t * 90)
                "image/png" -> rotatePixels(file, t, Bitmap.CompressFormat.PNG)
                "image/webp" -> rotatePixels(file, t, webpFormat())
                else -> Outcome.UNSUPPORTED
            }
        } catch (e: OutOfMemoryError) {
            Log.w(TAG, "rotate: out of memory ${image.path}", e)
            Outcome.TOO_BIG
        } catch (e: Exception) {
            Log.w(TAG, "rotate failed: ${image.path}", e)
            Outcome.FAILED
        }
        if (outcome != Outcome.OK) return Changed(outcome, image)

        scan(app, arrayOf(file.absolutePath), wait = true)
        ImageLoader.invalidate(image.path)
        val odd = t % 2 == 1
        val updated = image.copy(
            size = file.length(),
            width = if (odd) image.height else image.width,
            height = if (odd) image.width else image.height
        )
        GalleryRepository.replaceInCache(image.path, updated)
        return Changed(Outcome.OK, updated)
    }

    private fun rotateJpegTag(file: File, degrees: Int): Outcome {
        val exif = ExifInterface(file.absolutePath)
        val current = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
        exif.setAttribute(ExifInterface.TAG_ORIENTATION, turnOrientation(current, degrees).toString())
        exif.saveAttributes()
        return Outcome.OK
    }

    /**
     * The EXIF orientation after the picture, shown as [current] says, is turned [degrees] clockwise. An orientation is
     * "turn by r, then mirror left-right when flipped" (the order the loaders apply it in); a turn after a mirror runs the
     * other way round, hence `-degrees` for the flipped ones.
     */
    internal fun turnOrientation(current: Int, degrees: Int): Int {
        val r: Int
        val flipped: Boolean
        when (current) {
            ExifInterface.ORIENTATION_ROTATE_90 -> { r = 90; flipped = false }
            ExifInterface.ORIENTATION_ROTATE_180 -> { r = 180; flipped = false }
            ExifInterface.ORIENTATION_ROTATE_270 -> { r = 270; flipped = false }
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> { r = 0; flipped = true }
            ExifInterface.ORIENTATION_TRANSPOSE -> { r = 90; flipped = true }
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> { r = 180; flipped = true }
            ExifInterface.ORIENTATION_TRANSVERSE -> { r = 270; flipped = true }
            else -> { r = 0; flipped = false }
        }
        val next = (((r + if (flipped) -degrees else degrees) % 360) + 360) % 360
        return if (!flipped) {
            when (next) {
                90 -> ExifInterface.ORIENTATION_ROTATE_90
                180 -> ExifInterface.ORIENTATION_ROTATE_180
                270 -> ExifInterface.ORIENTATION_ROTATE_270
                else -> ExifInterface.ORIENTATION_NORMAL
            }
        } else {
            when (next) {
                90 -> ExifInterface.ORIENTATION_TRANSPOSE
                180 -> ExifInterface.ORIENTATION_FLIP_VERTICAL
                270 -> ExifInterface.ORIENTATION_TRANSVERSE
                else -> ExifInterface.ORIENTATION_FLIP_HORIZONTAL
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun webpFormat(): Bitmap.CompressFormat =
        if (Build.VERSION.SDK_INT >= 30) Bitmap.CompressFormat.WEBP_LOSSLESS else Bitmap.CompressFormat.WEBP

    private fun rotatePixels(file: File, quarterTurns: Int, format: Bitmap.CompressFormat): Outcome {
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(file.absolutePath, bounds)
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return Outcome.FAILED
        if (bounds.outWidth.toLong() * bounds.outHeight > MAX_ROTATE_PIXELS) return Outcome.TOO_BIG

        val decoded = ImageLoader.decodeFull(file.absolutePath, 0) ?: return Outcome.FAILED // full size, EXIF applied
        val rotated = rotateBitmap(decoded, quarterTurns)
        // written next to the original first, so a failed write never leaves a half picture in its place
        val temp = File(file.parentFile, ".gl_rotate_" + file.name)
        try {
            FileOutputStream(temp).use { out ->
                if (!rotated.compress(format, 100, out)) return Outcome.FAILED
                out.flush()
            }
            if (!temp.renameTo(file)) {
                temp.inputStream().use { input -> FileOutputStream(file).use { out -> input.copyTo(out) } }
            }
        } finally {
            temp.delete()
            rotated.recycle()
        }
        return Outcome.OK
    }

    /** [src] turned [quarterTurns] x 90 degrees clockwise (the source bitmap is recycled when a new one was made). */
    fun rotateBitmap(src: Bitmap, quarterTurns: Int): Bitmap {
        val t = ((quarterTurns % 4) + 4) % 4
        if (t == 0) return src
        val m = Matrix().apply { postRotate(90f * t) }
        val out = Bitmap.createBitmap(src, 0, 0, src.width, src.height, m, true)
        if (out !== src) src.recycle()
        return out
    }

    // ── wallpaper ────────────────────────────────────────────────────────────

    /**
     * Sets [image] as the wallpaper of [which] (`WallpaperManager.FLAG_SYSTEM`, `FLAG_LOCK` or both or-ed), turned
     * [quarterTurns] when the user turned it in the viewer. The picture is decoded at most twice the screen size
     * (and at most 4096 px) so the wallpaper is sharp but never too big for the GPU. Needs `SET_WALLPAPER`.
     */
    fun setWallpaper(context: Context, image: GalleryImage, quarterTurns: Int, which: Int): Boolean {
        val app = context.applicationContext
        return try {
            val dm = app.resources.displayMetrics
            val side = min(4096, max(dm.widthPixels, dm.heightPixels) * 2)
            val decoded = ImageLoader.decodeFull(image.path, side) ?: return false
            val bmp = rotateBitmap(decoded, quarterTurns)
            try {
                WallpaperManager.getInstance(app).setBitmap(bmp, null, true, which)
            } finally {
                bmp.recycle()
            }
            true
        } catch (e: Exception) {
            Log.w(TAG, "wallpaper failed: ${image.path}", e)
            false
        } catch (e: OutOfMemoryError) {
            Log.w(TAG, "wallpaper: out of memory ${image.path}", e)
            false
        }
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    /** Tells MediaStore about changed / removed files. [wait] blocks (at most 2.5 s) until the scan is done. */
    private fun scan(context: Context, paths: Array<String>, wait: Boolean) {
        try {
            val latch = CountDownLatch(paths.size)
            MediaScannerConnection.scanFile(context, paths, null) { _, _ -> latch.countDown() }
            if (wait) latch.await(2500, TimeUnit.MILLISECONDS)
        } catch (e: Exception) {
            Log.w(TAG, "scan failed", e)
        }
    }
}
