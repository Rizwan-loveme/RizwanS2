package com.srizwan.chooser.data

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

/**
 * Own subclass of the AndroidX FileProvider (same reason as `GalleryFileProvider` / `WinlatorFileProvider`: two providers with one class
 * name clash in the manifest merge). Authority: `${applicationId}.chooser.fileprovider`, paths in `res/xml/ch_file_paths.xml`.
 *
 * Used by the open-with launcher (step 4) and, later, by the Share sheet (step 6) when its caller does not bring a provider of its own.
 */
class ChooserFileProvider : FileProvider() {
    companion object {
        fun authority(context: Context): String = context.packageName + ".chooser.fileprovider"

        /** The `content://` uri other apps can read [file] through (needs the read-grant flag on the intent). */
        fun uriFor(context: Context, file: File): Uri = getUriForFile(context, authority(context), file)
    }
}
