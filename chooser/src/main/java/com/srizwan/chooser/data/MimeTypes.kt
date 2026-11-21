package com.srizwan.chooser.data

import android.webkit.MimeTypeMap
import java.util.Locale

/** MIME type helpers: the type of a file name, the common type of several files, and the "family" (`image`, `video` ...) used to remember choices. */
object MimeTypes {

    const val ANY = "*/*"

    /** Extensions the platform table may not know (or knows under another name on older versions). */
    private val EXTRA = mapOf(
        "apk" to "application/vnd.android.package-archive",
        "mkv" to "video/x-matroska",
        "heic" to "image/heic",
        "heif" to "image/heif",
        "webp" to "image/webp",
        "opus" to "audio/ogg",
        "m4a" to "audio/mp4",
        "flac" to "audio/flac",
        "7z" to "application/x-7z-compressed",
        "rar" to "application/vnd.rar",
        "exe" to "application/vnd.microsoft.portable-executable",
        "msi" to "application/x-msi",
        "bat" to "application/x-msdos-program",
        "lnk" to "application/x-ms-shortcut",
        "json" to "application/json",
        "md" to "text/markdown",
        "log" to "text/plain"
    )

    /** The MIME type of a file name (or path), by its extension; [ANY] when it has none or is unknown. */
    fun forName(name: String): String {
        val ext = name.substringAfterLast('.', "").lowercase(Locale.ROOT)
        if (ext.isEmpty() || ext.length > 10) return ANY
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext) ?: EXTRA[ext] ?: ANY
    }

    /**
     * The one type that fits all of [names]: their type when it is the same for all, the family with a wildcard subtype when only the
     * family is shared (pictures and a GIF: `image` + slash + star), otherwise [ANY]. This is the type `ACTION_SEND_MULTIPLE` needs.
     */
    fun forNames(names: List<String>): String {
        if (names.isEmpty()) return ANY
        val all = names.map { forName(it) }.distinct()
        if (all.size == 1) return all[0]
        val families = all.map { family(it) }.distinct()
        return if (families.size == 1 && families[0] != "*") families[0] + "/*" else ANY
    }

    /** `image` for `image/png`, `*` for [ANY] or an empty type. */
    fun family(mime: String): String =
        mime.substringBefore('/').trim().lowercase(Locale.ROOT).ifEmpty { "*" }
}
