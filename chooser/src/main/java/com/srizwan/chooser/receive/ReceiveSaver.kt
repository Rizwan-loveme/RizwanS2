package com.srizwan.chooser.receive

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.os.Environment
import android.provider.OpenableColumns
import android.util.Log
import android.webkit.MimeTypeMap
import com.srizwan.chooser.data.MimeTypes
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.Locale

/**
 * The file work of the receive screen (step 10). Everything here blocks: call it from `Dispatchers.IO`.
 *
 *  - [describe]: name, size and type of a received file, asked from the sender's provider.
 *  - [cleanName]: a file name from a stranger is never used as it is (no path, no control characters, no leading dot, at most 120 characters).
 *  - [destination] and [copy]: "Save to Files" streams the file into `Download/Received` (or, when that cannot be written, this app's own
 *    folder). An existing file is never overwritten: a free name `name (1).ext` is taken. A failed or cancelled copy leaves nothing behind.
 *  - [stage]: a private copy in the cache folder, for "Open with" and "Share" (the sender's grant ends with this screen). Old copies are
 *    removed by [trimCache].
 */
internal object ReceiveSaver {

    private const val TAG = "ReceiveSaver"
    private const val MAX_NAME = 120
    private const val CACHE_DIR = "received"
    private const val CACHE_MAX_AGE_MS = 24L * 60 * 60 * 1000
    private const val BUFFER = 64 * 1024
    private const val SPACE_MARGIN = 8L * 1024 * 1024
    private const val THUMB_MAX_BYTES = 64L * 1024 * 1024

    /** Where "Save to Files" puts files. [shared] = a public folder every app can see; [label] is shown to the user. */
    class Dest(val dir: File, val shared: Boolean, val label: String)

    // ── describing ──────────────────────────────────────────────────────────

    /** Fills name, size and type of [item]. Never throws: a provider that refuses the query leaves the defaults (name from the uri, type by name). */
    fun describe(context: Context, item: ReceivedItem, hint: String?) {
        var rawName: String? = null
        try {
            context.contentResolver.query(item.uri, arrayOf(OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE), null, null, null)?.use { c ->
                if (c.moveToFirst()) {
                    rawName = stringAt(c, OpenableColumns.DISPLAY_NAME)
                    val i = c.getColumnIndex(OpenableColumns.SIZE)
                    if (i >= 0 && !c.isNull(i)) item.size = c.getLong(i)
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "no details for ${item.uri}", e)
        }
        val byProvider = try { ReceiveParser.cleanMime(context.contentResolver.getType(item.uri)) } catch (e: Exception) { null }
        val name0 = rawName ?: item.uri.lastPathSegment
        val byName = name0?.let { MimeTypes.forName(it) }?.takeIf { it != MimeTypes.ANY }
        item.mime = byProvider?.takeIf { it != MimeTypes.ANY } ?: hint?.takeIf { it != MimeTypes.ANY && !it.endsWith("/*") } ?: byName ?: MimeTypes.ANY
        item.name = cleanName(name0, item.mime)
    }

    private fun stringAt(c: Cursor, column: String): String? {
        val i = c.getColumnIndex(column)
        return if (i >= 0 && !c.isNull(i)) c.getString(i) else null
    }

    /** A safe file name made from what a stranger sent. */
    fun cleanName(raw: String?, mime: String?): String {
        var n = raw.orEmpty().substringAfterLast('/').substringAfterLast('\\')
        n = n.filter { it >= ' ' && it != '\u007f' && "\"*:<>?|".indexOf(it) < 0 }
        n = n.trim().trimStart('.').trimEnd('.', ' ')
        if (n.isEmpty()) n = "file"
        if (!n.contains('.') && mime != null) {
            val ext = MimeTypeMap.getSingleton().getExtensionFromMimeType(mime)
            if (!ext.isNullOrEmpty()) n = "$n.$ext"
        }
        if (n.length > MAX_NAME) {
            val ext = n.substringAfterLast('.', "").takeIf { it.length in 1..12 }?.let { ".$it" }.orEmpty()
            n = n.substringBeforeLast('.', n).take(MAX_NAME - ext.length) + ext
        }
        return n
    }

    // ── saving ──────────────────────────────────────────────────────────────

    /** `Download/Received` when it can be written, else the app's own `Received` folder (always possible). */
    fun destination(context: Context): Dest {
        try {
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                val downloads = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                val pub = File(downloads, "Received")
                if ((pub.isDirectory || pub.mkdirs()) && canWrite(pub)) return Dest(pub, true, downloads.name + "/Received")
            }
        } catch (e: Exception) {
            Log.w(TAG, "public folder not available", e)
        }
        try {
            context.getExternalFilesDir("Received")?.let { if (it.isDirectory || it.mkdirs()) return Dest(it, false, "Received") }
        } catch (e: Exception) {
            Log.w(TAG, "app folder on shared storage not available", e)
        }
        val inner = File(context.filesDir, "Received").also { it.mkdirs() }
        return Dest(inner, false, "Received")
    }

    /** Does a real write work here? (`File.canWrite` is not reliable on newer Android versions.) */
    private fun canWrite(dir: File): Boolean = try {
        File.createTempFile(".probe", null, dir).delete()
    } catch (e: Exception) {
        false
    }

    /** Streams [item] into [dir] under a free name; returns the new file. On any failure (also cancellation) the partial file is deleted. */
    suspend fun copy(context: Context, item: ReceivedItem, dir: File): File {
        val target = freeFile(dir, item.name)
        try {
            val input = context.contentResolver.openInputStream(item.uri) ?: throw FileNotFoundException("cannot open ${item.uri}")
            input.use { src ->
                if (item.size > 0 && dir.usableSpace < item.size + SPACE_MARGIN) throw IOException("not enough free space")
                target.outputStream().use { out ->
                    val buffer = ByteArray(BUFFER)
                    while (true) {
                        currentCoroutineContext().ensureActive()
                        val n = src.read(buffer)
                        if (n < 0) break
                        out.write(buffer, 0, n)
                    }
                }
            }
        } catch (t: Throwable) {
            target.delete()
            throw t
        }
        return target
    }

    /** Saves shared text as `Shared text.txt` (or a free variant). */
    fun saveText(dir: File, text: String): File {
        val target = freeFile(dir, "Shared text.txt")
        try {
            target.writeText(text, Charsets.UTF_8)
        } catch (t: Throwable) {
            target.delete()
            throw t
        }
        return target
    }

    /** Lets the gallery and other apps see files saved in a public folder. Failures are ignored. */
    fun scan(context: Context, files: List<File>) {
        if (files.isEmpty()) return
        try {
            MediaScannerConnection.scanFile(context.applicationContext, files.map { it.absolutePath }.toTypedArray(), null, null)
        } catch (e: Exception) {
            Log.w(TAG, "media scan failed", e)
        }
    }

    /** Creates an empty file with a free name in [dir] (never overwrites; the name stays inside [dir]). */
    private fun freeFile(dir: File, name: String): File {
        val base = if (name.contains('.')) name.substringBeforeLast('.') else name
        val ext = if (name.contains('.')) "." + name.substringAfterLast('.') else ""
        val root = dir.canonicalFile
        var candidate = File(dir, name)
        var i = 0
        while (true) {
            if (candidate.canonicalFile.parentFile != root) throw IOException("name leaves the folder")
            if (candidate.createNewFile()) return candidate
            i++
            if (i > 999) throw IOException("no free name for $name")
            candidate = File(dir, "$base ($i)$ext")
        }
    }

    // ── staging (Open with, Share) ──────────────────────────────────────────

    /** A private copy of [item] in the cache folder (its own sub-folder, so equal names never clash). */
    suspend fun stage(context: Context, item: ReceivedItem): File {
        val dir = File(context.cacheDir, "$CACHE_DIR/${System.nanoTime()}")
        if (!dir.mkdirs() && !dir.isDirectory) throw IOException("cache folder not available")
        return copy(context, item, dir)
    }

    /** Staged text for sharing is not needed (text goes out as text); this removes staged copies older than a day. */
    fun trimCache(context: Context) {
        try {
            val root = File(context.cacheDir, CACHE_DIR)
            val limit = System.currentTimeMillis() - CACHE_MAX_AGE_MS
            root.listFiles()?.forEach { if (it.lastModified() < limit) it.deleteRecursively() }
        } catch (e: Exception) {
            Log.w(TAG, "cache cleanup failed", e)
        }
    }

    // ── thumbnail ───────────────────────────────────────────────────────────

    /** A small bitmap of a received picture (about [targetPx] on the short side), or null. Blocking. */
    fun thumbnail(context: Context, item: ReceivedItem, targetPx: Int): Bitmap? {
        if (!item.mime.startsWith("image/") || item.size > THUMB_MAX_BYTES) return null
        return try {
            val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            context.contentResolver.openInputStream(item.uri)?.use { BitmapFactory.decodeStream(it, null, bounds) }
            if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return null
            var sample = 1
            while (bounds.outWidth / (sample * 2) >= targetPx && bounds.outHeight / (sample * 2) >= targetPx) sample *= 2
            context.contentResolver.openInputStream(item.uri)?.use {
                BitmapFactory.decodeStream(it, null, BitmapFactory.Options().apply { inSampleSize = sample })
            }
        } catch (e: Exception) {
            null
        } catch (e: OutOfMemoryError) {
            null
        }
    }

    /** Readable size for the header: `2.4 MB`. */
    fun sizeText(context: Context, bytes: Long): String = android.text.format.Formatter.formatShortFileSize(context, bytes.coerceAtLeast(0))

    /** Lower-case extension helper for labels. */
    fun extOf(name: String): String = name.substringAfterLast('.', "").lowercase(Locale.ROOT)
}
