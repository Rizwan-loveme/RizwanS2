package com.srizwan.gallery.data

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

/**
 * Own subclass of the AndroidX FileProvider (same reason as `WinlatorFileProvider`: the app and other libraries may
 * declare the plain `androidx.core.content.FileProvider` too, and two providers with one class name clash in the manifest
 * merge). Authority: `${applicationId}.gallery.fileprovider`, paths in `res/xml/gl_file_paths.xml`.
 *
 * Used by the viewer's Share action (step 8) and, later, by the multi-select share (step 9).
 */
class GalleryFileProvider : FileProvider() {
    companion object {
        fun authority(context: Context): String = context.packageName + ".gallery.fileprovider"

        /** The `content://` uri other apps can read [file] through (needs the read-grant flag on the intent). */
        fun uriFor(context: Context, file: File): Uri = getUriForFile(context, authority(context), file)
    }
}
