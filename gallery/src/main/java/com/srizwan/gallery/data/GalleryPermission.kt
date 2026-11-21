package com.srizwan.gallery.data

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import androidx.core.content.ContextCompat

/**
 * What the Gallery needs to read the pictures.
 *
 * The launcher already holds "all files access" (MANAGE_EXTERNAL_STORAGE) once the user allowed it in the File
 * Manager; that is enough for everything, including the folder scan. Otherwise the media permission is needed:
 * READ_MEDIA_IMAGES when the app targets Android 13+, READ_EXTERNAL_STORAGE below that (the app targets 28, so
 * Android 13+ phones show their normal photos prompt for it).
 */
object GalleryPermission {

    /** The runtime permission to ask for (pass it to `requestPermissions`). */
    fun toRequest(context: Context): String =
        if (Build.VERSION.SDK_INT >= 33 && context.applicationInfo.targetSdkVersion >= 33) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

    /** True when the pictures can be read now. */
    fun has(context: Context): Boolean {
        if (hasAllFilesAccess()) return true
        return ContextCompat.checkSelfPermission(context, toRequest(context)) == PackageManager.PERMISSION_GRANTED
    }

    /** "All files access" (Android 11+) or, before that, plain storage permission is the same thing as [has]. */
    fun hasAllFilesAccess(): Boolean =
        Build.VERSION.SDK_INT >= 30 && Environment.isExternalStorageManager()

    /** The folder scan (pictures MediaStore has not indexed) needs to see every folder. */
    fun canScanFolders(context: Context): Boolean =
        if (Build.VERSION.SDK_INT >= 30) hasAllFilesAccess() else has(context)
}
