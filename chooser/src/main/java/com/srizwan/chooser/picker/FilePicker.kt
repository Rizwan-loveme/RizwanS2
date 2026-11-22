package com.srizwan.chooser.picker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import java.io.File

/**
 * The own file picker (step 8): a glass screen with folders, a breadcrumb, a list or grid, search and the storage roots, instead of the
 * system's `ACTION_GET_CONTENT` screen. This is the small API the rest of the app uses; the screen itself is [FilePickerActivity].
 *
 * ```
 * // start it with the caller's own ActivityResult launcher (StartActivityForResult)
 * launcher.launch(FilePicker.intent(activity, multiple = true, mimeTypes = listOf("image/png", ".jpg")))
 *
 * // in the result callback
 * val uris = FilePicker.uris(result.data)      // content:// uris with a read grant (empty when cancelled)
 * ```
 *
 *  - A chosen file is handed back as a `content://` uri from [com.srizwan.chooser.data.ChooserFileProvider] with `FLAG_GRANT_READ_URI_PERMISSION`
 *    and a `ClipData` (so the grant covers every uri when several files are chosen). `data` is the first uri.
 *  - Only for this app's own callers ([paths]): the result also carries the plain file paths, and a folder pick returns just the path.
 *    A foreign caller (step 9: other apps that ask for a file) never gets a path, a start folder or the folder mode.
 */
object FilePicker {

    /** Extras understood from this app's own callers only (see [PickerOptions.fromIntent]). */
    const val EXTRA_FOLDERS_ONLY = "com.srizwan.chooser.extra.FOLDERS_ONLY"
    const val EXTRA_START_DIR = "com.srizwan.chooser.extra.START_DIR"
    const val EXTRA_TITLE = "com.srizwan.chooser.extra.TITLE"

    /** Own callers only: show a Camera button in the top bar. Tapping it ends the picker with [RESULT_CAMERA] (no data). */
    const val EXTRA_CAMERA_BUTTON = "com.srizwan.chooser.extra.CAMERA_BUTTON"

    /** Result code of the picker when the user tapped the Camera button (`Activity.RESULT_FIRST_USER`). */
    const val RESULT_CAMERA = Activity.RESULT_FIRST_USER

    /** Result extra (this app's own callers only): the chosen paths, in the order they were chosen. */
    const val EXTRA_RESULT_PATHS = "com.srizwan.chooser.extra.RESULT_PATHS"

    /**
     * The explicit intent that opens the picker (no resolver, no chooser). [mimeTypes] may hold MIME types, families or extensions like `.pdf`
     * (what a web page's `accept` attribute gives); empty = any file.
     */
    fun intent(
        context: Context,
        multiple: Boolean = false,
        mimeTypes: List<String> = emptyList(),
        foldersOnly: Boolean = false,
        startDir: File? = null,
        title: String? = null,
        cameraButton: Boolean = false
    ): Intent = Intent(context, FilePickerActivity::class.java).apply {
        putExtra(Intent.EXTRA_ALLOW_MULTIPLE, multiple)
        val types = mimeTypes.map { it.trim() }.filter { it.isNotEmpty() }
        if (types.isNotEmpty()) putExtra(Intent.EXTRA_MIME_TYPES, types.toTypedArray())
        if (foldersOnly) putExtra(EXTRA_FOLDERS_ONLY, true)
        if (startDir != null) putExtra(EXTRA_START_DIR, startDir.absolutePath)
        if (!title.isNullOrBlank()) putExtra(EXTRA_TITLE, title)
        if (cameraButton) putExtra(EXTRA_CAMERA_BUTTON, true)
    }

    /** Every uri in a picker result: the clip first, else `data`; empty when nothing was chosen. */
    fun uris(data: Intent?): List<Uri> {
        if (data == null) return emptyList()
        val out = ArrayList<Uri>()
        val clip = data.clipData
        if (clip != null) {
            for (i in 0 until clip.itemCount) clip.getItemAt(i).uri?.let { out.add(it) }
        }
        if (out.isEmpty()) data.data?.let { out.add(it) }
        return out
    }

    /** The chosen paths (this app's own callers only; empty otherwise). */
    fun paths(data: Intent?): List<String> = data?.getStringArrayListExtra(EXTRA_RESULT_PATHS).orEmpty()
}
