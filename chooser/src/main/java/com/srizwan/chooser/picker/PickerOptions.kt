package com.srizwan.chooser.picker

import android.content.Intent
import java.io.File

/**
 * What a picker screen has been asked to do (step 8). Built by the caller with [FilePicker.intent], or read back from an incoming intent
 * with [fromIntent] (step 9 uses that for `GET_CONTENT` / `OPEN_DOCUMENT` from other apps).
 *
 *  - [multiple]    : the user may tick several files (`EXTRA_ALLOW_MULTIPLE`).
 *  - [mimeTypes]   : what may be chosen. Entries are MIME types (`image/png`), families (`image/` + star) or, like a web page's `accept`
 *                    attribute, extensions (`.pdf`). Empty = anything.
 *  - [foldersOnly] : the user picks a folder, not a file. Only for this app's own screens (the result carries a path, not a uri).
 *  - [startDir]    : the folder to open first. Only honoured for this app's own screens; the last folder is used otherwise.
 *  - [title]       : replaces the default heading.
 */
class PickerOptions(
    val multiple: Boolean = false,
    val mimeTypes: List<String> = emptyList(),
    val foldersOnly: Boolean = false,
    val startDir: File? = null,
    val title: String? = null
) {
    companion object {

        /** A type as other apps may send it, checked: a MIME type, a family or a `.ext`; the media-store directory types become families. Anything else is dropped. */
        private val TYPE_SHAPE = Regex("[A-Za-z0-9.+_*-]{1,60}/[A-Za-z0-9.+_*-]{1,60}|\\.[A-Za-z0-9]{1,10}")

        private fun clean(raw: String?): String? {
            val t = raw?.trim()?.lowercase() ?: return null
            if (t.isEmpty()) return null
            when (t) {
                "vnd.android.cursor.dir/image", "vnd.android.cursor.item/image" -> return "image/*"
                "vnd.android.cursor.dir/video", "vnd.android.cursor.item/video" -> return "video/*"
                "vnd.android.cursor.dir/audio", "vnd.android.cursor.item/audio" -> return "audio/*"
            }
            return if (TYPE_SHAPE.matches(t)) t else null
        }

        /**
         * [trusted] is true only when the caller is this app. A foreign caller can set `multiple` and the types, nothing else:
         * no start folder (it could probe the file system) and no folder mode (the result of that is a path).
         */
        fun fromIntent(intent: Intent?, trusted: Boolean): PickerOptions {
            if (intent == null) return PickerOptions()
            val multiple = intent.getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
            val fromExtra = intent.getStringArrayExtra(Intent.EXTRA_MIME_TYPES)
                ?.take(256)?.mapNotNull { clean(it) }.orEmpty()
            val fromType = clean(intent.type)?.let { listOf(it) }.orEmpty()
            val types = (if (fromExtra.isNotEmpty()) fromExtra else fromType)
                .filterNot { it == "*/*" || it == "*" }
                .distinct()
                .take(64)
            if (!trusted) return PickerOptions(multiple = multiple, mimeTypes = types)
            return PickerOptions(
                multiple = multiple,
                mimeTypes = types,
                foldersOnly = intent.getBooleanExtra(FilePicker.EXTRA_FOLDERS_ONLY, false),
                startDir = intent.getStringExtra(FilePicker.EXTRA_START_DIR)?.takeIf { it.isNotBlank() }?.let { File(it) },
                title = intent.getStringExtra(FilePicker.EXTRA_TITLE)?.takeIf { it.isNotBlank() }?.take(80)
            )
        }
    }
}
