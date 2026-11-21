package com.srizwan.gallery.viewer

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import android.webkit.MimeTypeMap
import com.srizwan.gallery.data.GalleryRepository
import java.io.File
import java.io.FileOutputStream

/**
 * Turns the uri of an `ACTION_VIEW` intent from another app (step 10) into a file path the viewer can show.
 * Blocking: call it from a background thread.
 *
 *  - `file://` -> the path, when the file exists.
 *  - `content://` -> the real path from the `_data` column when the provider has one (MediaStore, most file managers) and
 *    the file is readable and not inside this app's private data; otherwise the picture is copied into
 *    `cache/gallery_view/` (one picture at a time: the folder is emptied first, at most 256 MB) and that copy is shown.
 *    Deleting or renaming a copy therefore changes only the copy.
 */
internal object ViewUri {

    private const val TAG = "ViewUri"
    private const val DIR = "gallery_view"
    private const val MAX_COPY_BYTES = 256L * 1024 * 1024

    fun resolve(context: Context, uri: Uri): String? = try {
        when (uri.scheme) {
            ContentResolver.SCHEME_FILE -> uri.path?.takeIf { File(it).isFile && !isPrivate(context, it) }
            ContentResolver.SCHEME_CONTENT -> realPath(context, uri) ?: copy(context, uri)
            else -> null
        }
    } catch (e: Exception) {
        Log.w(TAG, "cannot resolve $uri", e)
        null
    }

    /** True for a copy made by [resolve]: its folder holds nothing else worth swiping through. */
    fun isTemp(context: Context, path: String): Boolean =
        path.startsWith(File(context.cacheDir, DIR).absolutePath + File.separator)

    private fun isPrivate(context: Context, path: String): Boolean {
        val data = context.applicationInfo.dataDir ?: return false
        return path.startsWith(data + File.separator) || path == data
    }

    @Suppress("DEPRECATION")
    private fun realPath(context: Context, uri: Uri): String? {
        val found = context.contentResolver.query(uri, arrayOf(MediaStore.MediaColumns.DATA), null, null, null)?.use { c ->
            val col = c.getColumnIndex(MediaStore.MediaColumns.DATA)
            if (col >= 0 && c.moveToFirst()) c.getString(col) else null
        } ?: return null
        val file = File(found)
        return if (file.isFile && file.canRead() && !isPrivate(context, found)) found else null
    }

    private fun copy(context: Context, uri: Uri): String? {
        val resolver = context.contentResolver
        val mime = resolver.getType(uri)
        if (mime != null && !mime.startsWith("image/")) return null

        var name = resolver.query(uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use { c ->
            if (c.moveToFirst()) c.getString(0) else null
        } ?: uri.lastPathSegment ?: "image"
        name = name.substringAfterLast('/').replace(Regex("[\\\\/:*?\"<>|\\u0000-\\u001f]"), "_").takeLast(100).trim('.', ' ')
        if (name.isEmpty()) name = "image"
        if (!GalleryRepository.isImageName(name)) {
            val ext = mime?.let { MimeTypeMap.getSingleton().getExtensionFromMimeType(it) } ?: "jpg"
            name = "$name.$ext"
        }

        val dir = File(context.cacheDir, DIR)
        dir.mkdirs()
        dir.listFiles()?.forEach { it.delete() }
        val out = File(dir, name)
        var total = 0L
        try {
            val input = resolver.openInputStream(uri) ?: return null
            input.use { src ->
                FileOutputStream(out).use { dst ->
                    val buf = ByteArray(64 * 1024)
                    while (true) {
                        val n = src.read(buf)
                        if (n < 0) break
                        total += n
                        if (total > MAX_COPY_BYTES) {
                            out.delete()
                            return null
                        }
                        dst.write(buf, 0, n)
                    }
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "copy failed: $uri", e)
            out.delete()
            return null
        }
        if (total <= 0L) {
            out.delete()
            return null
        }
        return out.absolutePath
    }
}
