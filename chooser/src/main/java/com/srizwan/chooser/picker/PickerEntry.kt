package com.srizwan.chooser.picker

import androidx.annotation.DrawableRes
import java.io.File
import java.util.Locale

/**
 * One row of the picker: a file, a folder, or (on the storage screen) a storage root.
 * [size] is the length of a file, or the free bytes of a root. [sub] replaces the size / date line (the parent folder of a search hit).
 */
class PickerEntry(
    val file: File,
    val name: String,
    val kind: Kind,
    val size: Long,
    val modified: Long,
    val mime: String,
    val sub: String? = null,
    @DrawableRes val iconOverride: Int = 0
) {
    enum class Kind { FILE, FOLDER, ROOT }

    val isDir: Boolean get() = kind != Kind.FILE
    val path: String get() = file.absolutePath
    val extension: String get() = name.substringAfterLast('.', "").lowercase(Locale.ROOT)
}

enum class PickerSort { NAME, DATE, SIZE, TYPE }
