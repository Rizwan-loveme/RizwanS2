package com.srizwan.camera

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.camera.core.ImageCapture
import androidx.camera.video.FileOutputOptions
import androidx.camera.video.MediaStoreOutputOptions
import androidx.core.content.ContextCompat
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Where the Camera saves (step 5): the `DCIM/Camera` folder, so the Gallery and Video apps (and every other gallery) show the
 * new photos and videos.
 *
 *  - Android 10+ : MediaStore (`RELATIVE_PATH = DCIM/Camera`), no storage permission needed.
 *  - Android 8 / 9 : a plain file in `DCIM/Camera` (needs WRITE_EXTERNAL_STORAGE, asked together with the camera), then the
 *    media scanner is told about it ([scan]). When that permission is denied the file goes to the app's own folder
 *    (`Android/data/<app>/files/DCIM/Camera`): still saved, only not shown by other apps.
 */
internal object CameraStorage {

    private const val FOLDER = "Camera"
    private const val MIME_JPEG = "image/jpeg"
    private const val MIME_MP4 = "video/mp4"

    /** A photo destination: [file] is set for the Android 8 / 9 file case (scan it after saving), null for MediaStore. */
    class PhotoTarget(val options: ImageCapture.OutputFileOptions, val file: File?)

    /** A video destination: either [store] (MediaStore, Android 10+) or [disk] + [file] (Android 8 / 9). */
    class VideoTarget(val store: MediaStoreOutputOptions?, val disk: FileOutputOptions?, val file: File?)

    /** True when this Android version still needs WRITE_EXTERNAL_STORAGE to write into DCIM. */
    fun needsLegacyWrite(): Boolean = Build.VERSION.SDK_INT < Build.VERSION_CODES.Q

    fun hasLegacyWrite(context: Context): Boolean =
        ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    fun photo(context: Context): PhotoTarget {
        val name = "IMG_${stamp()}"
        if (!needsLegacyWrite()) {
            val values = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, name)
                put(MediaStore.MediaColumns.MIME_TYPE, MIME_JPEG)
                put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DCIM}/$FOLDER")
            }
            val options = ImageCapture.OutputFileOptions.Builder(
                context.contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values,
            ).build()
            return PhotoTarget(options, null)
        }
        val file = File(legacyDir(context), "$name.jpg")
        return PhotoTarget(ImageCapture.OutputFileOptions.Builder(file).build(), file)
    }

    fun video(context: Context): VideoTarget {
        val name = "VID_${stamp()}"
        if (!needsLegacyWrite()) {
            val values = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, name)
                put(MediaStore.MediaColumns.MIME_TYPE, MIME_MP4)
                put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DCIM}/$FOLDER")
            }
            val options = MediaStoreOutputOptions.Builder(context.contentResolver, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
                .setContentValues(values)
                .build()
            return VideoTarget(options, null, null)
        }
        val file = File(legacyDir(context), "$name.mp4")
        return VideoTarget(null, FileOutputOptions.Builder(file).build(), file)
    }

    /**
     * Tells the media scanner about a file written by the Android 8 / 9 path, so the Gallery lists it at once. [onDone] gets the
     * `content://` uri of the new entry (null when the scanner did not list it, e.g. in the app's own folder); it runs on a
     * background thread.
     */
    fun scan(context: Context, file: File, video: Boolean, onDone: ((Uri?) -> Unit)? = null) {
        MediaScannerConnection.scanFile(
            context, arrayOf(file.absolutePath), arrayOf(if (video) MIME_MP4 else MIME_JPEG),
        ) { _, uri -> onDone?.invoke(uri) }
    }

    /** Removes a half-written result (a recording that ended with an error). Never throws. */
    fun discard(context: Context, uri: Uri?) {
        if (uri == null || uri == Uri.EMPTY) return
        try {
            if (uri.scheme == "file") {
                uri.path?.let { File(it).delete() }
            } else {
                context.contentResolver.delete(uri, null, null)
            }
        } catch (e: Exception) {
            Log.w("CameraStorage", "discard failed", e)
        }
    }

    /** DCIM/Camera when we may write there, otherwise the app's own folder. Created if missing. */
    private fun legacyDir(context: Context): File {
        if (hasLegacyWrite(context)) {
            val dir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), FOLDER)
            if (dir.isDirectory || dir.mkdirs()) return dir
        }
        val own = File(context.getExternalFilesDir(Environment.DIRECTORY_DCIM) ?: context.filesDir, FOLDER)
        own.mkdirs()
        return own
    }

    private fun stamp(): String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
}
