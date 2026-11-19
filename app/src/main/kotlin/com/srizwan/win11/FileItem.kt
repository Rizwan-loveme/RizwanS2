package com.srizwan.win11

import android.system.Os
import android.system.OsConstants
import java.io.File
import java.util.Locale

// =====================================================================
// FILE ITEM MODEL  (step 4.1 – list engine groundwork)
// One immutable row of the file explorer. Every value that costs a disk
// stat (isDirectory, length, lastModified) is read ONCE here, on the
// background loader thread, so the RecyclerView adapter (step 4.3+) never
// has to touch the file system while the user scrolls.
// =====================================================================

internal data class FileItem(
    val file: File,
    val name: String,
    val path: String,
    val isDir: Boolean,
    /** Lower-case extension without the dot; empty for folders / no extension. */
    val ext: String,
    val hidden: Boolean,
    /** Size in bytes; always 0 for folders (their item count is loaded lazily). */
    val size: Long,
    val modified: Long
) {
    companion object {
        /**
         * Build an item from [file]. Call from a background thread only (does disk I/O).
         * 4.15.2: ONE stat call ([Os.stat]) gives type + size + date. Before it were three
         * (isDirectory, length, lastModified) - on a 20000-file folder that was 60000 system calls.
         * The old File calls stay as the fallback (broken link, permission, odd file system).
         */
        fun from(file: File): FileItem {
            val n = file.name
            var isDir: Boolean
            var size = 0L
            var modified = 0L
            try {
                val st = Os.stat(file.path)
                isDir = OsConstants.S_ISDIR(st.st_mode)
                if (!isDir) size = st.st_size
                modified = st.st_mtime * 1000L
            } catch (e: Exception) {
                isDir = try { file.isDirectory } catch (e2: Exception) { false }
                if (!isDir) size = try { file.length() } catch (e2: Exception) { 0L }
                modified = try { file.lastModified() } catch (e2: Exception) { 0L }
            }
            return FileItem(
                file = file,
                name = n,
                path = file.absolutePath,
                isDir = isDir,
                ext = if (isDir) "" else file.extension.lowercase(Locale.ROOT),
                hidden = n.startsWith("."),
                size = size,
                modified = modified
            )
        }
    }
}
