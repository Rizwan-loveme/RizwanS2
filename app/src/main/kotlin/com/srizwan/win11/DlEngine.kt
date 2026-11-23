package com.srizwan.win11

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ServiceInfo
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.SystemClock
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Base64
import android.webkit.JavascriptInterface
import android.webkit.MimeTypeMap
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL
import java.text.DecimalFormat
import java.util.Collections
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

// =====================================================================
// 1DM-style download engine
//  • multi-connection (segmented) downloads with pause / resume
//  • survives app restarts (progress is persisted)
//  • queue with N simultaneous downloads
//  • blob: / data: URL support (blob data is streamed out of the page)
//  • foreground service + progress notification
// =====================================================================

internal fun dlFmtSize(size: Long): String {
    if (size <= 0) return "0 B"
    val units = arrayOf("B", "KB", "MB", "GB", "TB")
    val dg = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt().coerceIn(0, units.size - 1)
    return DecimalFormat("#,##0.#").format(size / Math.pow(1024.0, dg.toDouble())) + " " + units[dg]
}

internal fun dlFmtEta(seconds: Long): String {
    if (seconds < 0) return ""
    val h = seconds / 3600
    val m = (seconds % 3600) / 60
    val s = seconds % 60
    return if (h > 0) String.format("%d:%02d:%02d", h, m, s) else String.format("%d:%02d", m, s)
}

class DlTask(val id: Long) {
    var url = ""
    var fileName = ""
    var mime = ""
    var cookie = ""
    var ua = ""
    var referer = ""
    var isBlob = false
    @Volatile var status = DlEngine.QUEUED
    @Volatile var total = -1L
    val downloaded = AtomicLong(0)
    @Volatile var segStart = LongArray(0)
    @Volatile var segEnd = LongArray(0)
    @Volatile var segPos = LongArray(0)
    @Volatile var rangeOk = false
    @Volatile var error = ""
    var createdAt = System.currentTimeMillis()
    var savedUri = ""
    var savedPath = ""
    /** Folder chosen by the user (SAF tree uri) when this download was queued; "" = the Downloads folder. */
    var destTree = ""
    /** The user chose "Overwrite" for a file name that already exists: the old file is replaced when this one is saved. */
    var overwrite = false
    @Volatile var speed = 0L
    @Volatile var gen = 0

    // transient
    var lastBytes = 0L
    var lastTime = 0L
    @Volatile var finalUrl = ""
    val conns: MutableList<HttpURLConnection> = Collections.synchronizedList(ArrayList())
    var blobOut: FileOutputStream? = null

    val connectionCount: Int get() = segStart.size

    fun etaSeconds(): Long {
        if (total <= 0 || speed <= 0) return -1
        return (total - downloaded.get()) / speed
    }
}

object DlEngine {
    const val QUEUED = 0
    const val RUNNING = 1
    const val PAUSED = 2
    const val DONE = 3
    const val FAILED = 4
    const val SAVING = 5
    const val CANCELED = 6

    const val NOTIF_ONGOING = 7001
    private const val CH_PROGRESS = "dl_progress"
    private const val CH_DONE = "dl_done"
    private const val MIN_SEGMENT = 512L * 1024L

    private lateinit var app: Context
    private lateinit var prefs: SharedPreferences
    @Volatile private var inited = false

    val isReady: Boolean get() = inited

    val tasks = CopyOnWriteArrayList<DlTask>()
    private val pool = Executors.newCachedThreadPool()
    private val main = Handler(Looper.getMainLooper())
    private val listeners = CopyOnWriteArrayList<() -> Unit>()
    private val pendingUi = AtomicBoolean(false)
    private var nextId = 1L
    private var serviceOn = false
    private var lastNotif = 0L
    private var lastPersist = 0L

    var connections: Int
        get() = prefs.getInt("conns", 4)
        set(v) { prefs.edit().putInt("conns", v.coerceIn(1, 8)).apply() }

    var maxParallel: Int
        get() = prefs.getInt("parallel", 3)
        set(v) { prefs.edit().putInt("parallel", v.coerceIn(1, 5)).apply(); pump() }

    // ── Save folder + batch numbering (settings kept between runs) ──

    /** SAF tree uri of the folder the user picked for new downloads; "" = Downloads. */
    var destTree: String
        get() = if (inited) prefs.getString("dest_tree", "") ?: "" else ""
        set(v) {
            if (!inited) return
            val old = prefs.getString("dest_tree", "") ?: ""
            if (old.isNotEmpty() && old != v) {
                try {
                    app.contentResolver.releasePersistableUriPermission(
                        Uri.parse(old), android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION or android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                } catch (e: Exception) { }
            }
            prefs.edit().putString("dest_tree", v).apply()
        }

    /** The picked folder, or "" when none is set or the permission for it is gone (then Downloads is used). */
    fun activeDestTree(): String {
        val s = destTree
        if (s.isEmpty()) return ""
        return try {
            val u = Uri.parse(s)
            if (app.contentResolver.persistedUriPermissions.any { it.uri == u && it.isWritePermission }) s else ""
        } catch (e: Exception) { "" }
    }

    /** Readable name of the save folder for the dialog: "Downloads", "Internal storage/Music/Audio", "SD card (1A2B-3C4D)/..." */
    fun folderLabel(): String {
        val s = activeDestTree()
        if (s.isEmpty()) return "Downloads"
        return try {
            val id = DocumentsContract.getTreeDocumentId(Uri.parse(s))
            val vol = id.substringBefore(':')
            val path = id.substringAfter(':', "")
            val root = if (vol == "primary") "Internal storage" else "SD card ($vol)"
            if (path.isEmpty()) root else "$root/$path"
        } catch (e: Exception) { "Custom folder" }
    }

    var batchOn: Boolean
        get() = inited && prefs.getBoolean("batch_on", false)
        set(v) { if (inited) prefs.edit().putBoolean("batch_on", v).apply() }
    /** The number the next batch download starts with (moves on after every confirmed download). */
    var batchNext: Long
        get() = if (inited) prefs.getLong("batch_next", 0L) else 0L
        set(v) { if (inited) prefs.edit().putLong("batch_next", v).apply() }
    /** Zero padding of the batch number: 3 = 000, 001, 002 ... */
    var batchPad: Int
        get() = if (inited) prefs.getInt("batch_pad", 3).coerceIn(1, 9) else 3
        set(v) { if (inited) prefs.edit().putInt("batch_pad", v.coerceIn(1, 9)).apply() }
    var batchPrefix: String
        get() = if (inited) prefs.getString("batch_prefix", "") ?: "" else ""
        set(v) { if (inited) prefs.edit().putString("batch_prefix", v).apply() }

    /**
     * Set by the "file already exists" dialog right before a download is queued: the next [enqueue] / [beginBlob]
     * takes it (and clears it), so the new task replaces the old file instead of getting a " (1)" name.
     */
    @Volatile var overwriteOnce = false

    private fun treePermOk(tree: String): Boolean = try {
        val u = Uri.parse(tree)
        app.contentResolver.persistedUriPermissions.any { it.uri == u && it.isWritePermission }
    } catch (e: Exception) { false }

    /** (document id, display name) of every file in the picked folder. */
    private fun treeChildren(tree: Uri): List<Pair<String, String>> {
        val out = ArrayList<Pair<String, String>>()
        try {
            val children = DocumentsContract.buildChildDocumentsUriUsingTree(tree, DocumentsContract.getTreeDocumentId(tree))
            app.contentResolver.query(
                children,
                arrayOf(DocumentsContract.Document.COLUMN_DOCUMENT_ID, DocumentsContract.Document.COLUMN_DISPLAY_NAME),
                null, null, null
            )?.use {
                while (it.moveToNext()) {
                    val id = it.getString(0) ?: continue
                    out.add(id to (it.getString(1) ?: ""))
                }
            }
        } catch (e: Exception) { }
        return out
    }

    private fun existsInTarget(name: String, tree: String): Boolean {
        if (tree.isNotEmpty() && treePermOk(tree)) {
            return treeChildren(Uri.parse(tree)).any { it.second.equals(name, true) }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                app.contentResolver.query(
                    MediaStore.Downloads.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.MediaColumns._ID),
                    "${MediaStore.MediaColumns.RELATIVE_PATH}=? AND ${MediaStore.MediaColumns.DISPLAY_NAME}=?",
                    arrayOf(Environment.DIRECTORY_DOWNLOADS + "/", name), null
                )?.use { if (it.count > 0) return true }
            } catch (e: Exception) { }
        }
        return try { File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name).exists() }
        catch (e: Exception) { false }
    }

    /**
     * true when a file with this name is already in the save folder, or another download that is not finished
     * yet is going to be saved under this name. Does file / provider work: call it on a background thread.
     */
    fun nameTaken(name: String): Boolean {
        if (!inited) return false
        val tree = activeDestTree()
        val pending = tasks.any {
            (it.status == QUEUED || it.status == RUNNING || it.status == PAUSED || it.status == SAVING) &&
                it.fileName.equals(name, true) && (if (it.destTree.isNotEmpty() && !treePermOk(it.destTree)) "" else it.destTree) == tree
        }
        return pending || existsInTarget(name, tree)
    }

    /** "name (1).ext", "name (2).ext" ... : the first variant of [name] that is free (background thread). */
    fun freeName(name: String): String {
        val base = name.substringBeforeLast('.', name)
        val ext = if (name.contains('.')) "." + name.substringAfterLast('.') else ""
        var i = 1
        while (i < 1000) {
            val cand = "$base ($i)$ext"
            if (!nameTaken(cand)) return cand
            i++
        }
        return "$base (${System.currentTimeMillis()})$ext"
    }

    /** Deletes the old file(s) called [name] in the save folder (for "Overwrite"). Best effort. */
    private fun deleteExisting(name: String, tree: String) {
        val cr = app.contentResolver
        if (tree.isNotEmpty()) {
            val t = Uri.parse(tree)
            for ((id, n) in treeChildren(t)) {
                if (!n.equals(name, true)) continue
                try { DocumentsContract.deleteDocument(cr, DocumentsContract.buildDocumentUriUsingTree(t, id)) } catch (e: Exception) { }
            }
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                val ids = ArrayList<Long>()
                cr.query(
                    MediaStore.Downloads.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.MediaColumns._ID),
                    "${MediaStore.MediaColumns.RELATIVE_PATH}=? AND ${MediaStore.MediaColumns.DISPLAY_NAME}=?",
                    arrayOf(Environment.DIRECTORY_DOWNLOADS + "/", name), null
                )?.use { while (it.moveToNext()) ids.add(it.getLong(0)) }
                for (id in ids) {
                    try { cr.delete(ContentUris.withAppendedId(MediaStore.Downloads.EXTERNAL_CONTENT_URI, id), null, null) }
                    catch (e: Exception) { }   // a file of another app cannot be deleted: the new one then gets a " (1)" name
                }
            } catch (e: Exception) { }
        }
        try {
            val f = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name)
            if (f.exists()) f.delete()
        } catch (e: Exception) { }
    }

    private fun isDocUri(u: Uri): Boolean = try { DocumentsContract.isDocumentUri(app, u) } catch (e: Exception) { false }

    /** Deletes the finished file: SAF document or MediaStore row. */
    private fun deleteSaved(t: DlTask) {
        val u = Uri.parse(t.savedUri)
        if (isDocUri(u)) DocumentsContract.deleteDocument(app.contentResolver, u)
        else app.contentResolver.delete(u, null, null)
    }

    // ── Init / persistence ──────────────────────────────────────

    @Synchronized
    fun init(ctx: Context) {
        if (inited) return
        app = ctx.applicationContext
        prefs = app.getSharedPreferences("dl_engine", Context.MODE_PRIVATE)
        try {
            val arr = JSONArray(prefs.getString("tasks", "[]"))
            for (i in 0 until arr.length()) {
                try { fromJson(arr.getJSONObject(i))?.let { tasks.add(it); nextId = maxOf(nextId, it.id + 1) } }
                catch (e: Exception) { }
            }
        } catch (e: Exception) { }
        inited = true
    }

    private fun toJson(t: DlTask): JSONObject = JSONObject().apply {
        put("id", t.id); put("url", t.url); put("name", t.fileName); put("mime", t.mime)
        put("cookie", t.cookie); put("ua", t.ua); put("ref", t.referer)
        put("blob", t.isBlob); put("status", t.status); put("total", t.total)
        put("range", t.rangeOk); put("created", t.createdAt)
        put("uri", t.savedUri); put("path", t.savedPath); put("err", t.error); put("tree", t.destTree); put("ow", t.overwrite)
        put("ss", JSONArray(t.segStart.toList()))
        put("se", JSONArray(t.segEnd.toList()))
        put("sp", JSONArray(t.segPos.toList()))
    }

    private fun longs(a: JSONArray?): LongArray =
        if (a == null) LongArray(0) else LongArray(a.length()) { a.getLong(it) }

    private fun fromJson(o: JSONObject): DlTask? {
        val t = DlTask(o.getLong("id"))
        t.url = o.optString("url"); t.fileName = o.optString("name"); t.mime = o.optString("mime")
        t.cookie = o.optString("cookie"); t.ua = o.optString("ua"); t.referer = o.optString("ref")
        t.isBlob = o.optBoolean("blob"); t.total = o.optLong("total", -1)
        t.rangeOk = o.optBoolean("range"); t.createdAt = o.optLong("created", System.currentTimeMillis())
        t.savedUri = o.optString("uri"); t.savedPath = o.optString("path"); t.error = o.optString("err")
        t.destTree = o.optString("tree"); t.overwrite = o.optBoolean("ow")
        t.segStart = longs(o.optJSONArray("ss")); t.segEnd = longs(o.optJSONArray("se"))
        t.segPos = longs(o.optJSONArray("sp"))
        var st = o.optInt("status", FAILED)
        if (st == DONE) {
            t.downloaded.set(if (t.total > 0) t.total else 0)
        } else {
            if (t.isBlob) { st = FAILED; t.error = "Interrupted" }
            else if (st == RUNNING || st == QUEUED || st == SAVING) st = PAUSED
            recalc(t)
        }
        t.status = st
        return t
    }

    private fun recalc(t: DlTask) {
        var s = 0L
        val n = minOf(t.segStart.size, t.segPos.size)
        for (i in 0 until n) s += maxOf(0L, t.segPos[i] - t.segStart[i])
        t.downloaded.set(s)
    }

    private fun persist() {
        try {
            val arr = JSONArray()
            for (t in tasks) arr.put(toJson(t))
            prefs.edit().putString("tasks", arr.toString()).apply()
        } catch (e: Exception) { }
    }

    // ── Listeners ───────────────────────────────────────────────

    fun addListener(l: () -> Unit) { listeners.addIfAbsent(l) }
    fun removeListener(l: () -> Unit) { listeners.remove(l) }

    fun changed() {
        if (pendingUi.compareAndSet(false, true)) {
            main.postDelayed({
                pendingUi.set(false)
                for (l in listeners) try { l() } catch (e: Exception) { }
                updateNotification()
            }, 300)
        }
    }

    fun find(id: Long): DlTask? = tasks.firstOrNull { it.id == id }

    // ── Public API ──────────────────────────────────────────────

    fun guessMime(name: String): String {
        val ext = name.substringAfterLast('.', "").lowercase()
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext) ?: "application/octet-stream"
    }

    @Synchronized
    fun enqueue(
        url: String, fileName: String, mime: String, cookie: String,
        ua: String, referer: String, totalHint: Long = -1L
    ): DlTask {
        val t = DlTask(nextId++)
        t.url = url; t.fileName = fileName
        t.destTree = activeDestTree()
        t.overwrite = overwriteOnce; overwriteOnce = false
        t.mime = if (mime.isBlank() || mime.endsWith("/*")) guessMime(fileName) else mime
        t.cookie = cookie; t.ua = ua; t.referer = referer
        t.total = totalHint
        t.status = QUEUED
        tasks.add(t)
        persist(); changed(); pump()
        return t
    }

    fun pause(id: Long) {
        val t = find(id) ?: return
        if (t.status != RUNNING && t.status != QUEUED) return
        if (t.isBlob) return
        t.status = PAUSED
        t.speed = 0
        closeConns(t)
        persist(); changed(); pump()
    }

    fun resume(id: Long) {
        val t = find(id) ?: return
        if (t.status != PAUSED && t.status != FAILED) return
        if (t.isBlob) return
        t.error = ""
        t.status = QUEUED
        persist(); changed(); pump()
    }

    /** Cancels a download and removes its temp data. Finished files are not touched. */
    fun cancel(id: Long) {
        val t = find(id) ?: return
        val wasDone = t.status == DONE
        t.status = CANCELED
        closeConns(t)
        try { t.blobOut?.close() } catch (e: Exception) { }
        tasks.remove(t)
        if (!wasDone) try { tempFile(t).delete() } catch (e: Exception) { }
        persist(); changed(); pump()
    }

    fun deleteFinishedFile(id: Long) {
        val t = find(id) ?: return
        try {
            if (t.savedUri.isNotEmpty()) deleteSaved(t)
            else if (t.savedPath.startsWith("/")) File(t.savedPath).delete()
        } catch (e: Exception) { }
        cancel(id)
    }

    /**
     * Removes many downloads at once (Step 4: multi-select). The list is saved ONCE for the whole batch instead of
     * once per item. Running / queued downloads are stopped first. With [deleteFiles] the finished files are deleted
     * from storage too (MediaStore / SAF uri or plain path); without it only the list entries go.
     * File work runs on a background thread; [onDone] runs on the main thread with the number of entries removed.
     */
    fun deleteMany(ids: Collection<Long>, deleteFiles: Boolean, onDone: ((removed: Int) -> Unit)? = null) {
        if (!inited) { onDone?.let { main.post { it(0) } }; return }
        val victims = ArrayList<DlTask>()
        for (id in ids.toSet()) find(id)?.let { victims.add(it) }
        for (t in victims) {
            val wasDone = t.status == DONE
            t.status = CANCELED
            closeConns(t)
            try { t.blobOut?.close() } catch (e: Exception) { }
            tasks.remove(t)
            if (!wasDone) try { tempFile(t).delete() } catch (e: Exception) { }
        }
        persist(); changed(); pump()
        if (victims.isEmpty() || !deleteFiles) { onDone?.let { cb -> main.post { cb(victims.size) } }; return }
        pool.execute {
            for (t in victims) {
                if (t.savedUri.isEmpty() && t.savedPath.isEmpty()) continue
                try {
                    if (t.savedUri.isNotEmpty()) deleteSaved(t)
                    fileFor(t)?.let { if (it.exists()) it.delete() }
                } catch (e: Exception) { }
            }
            main.post { changed(); onDone?.invoke(victims.size) }
        }
    }

    // ── Step 5: sort mode, rename, re-download ──────────────────

    const val SORT_NEWEST = 0
    const val SORT_OLDEST = 1
    const val SORT_NAME_AZ = 2
    const val SORT_NAME_ZA = 3
    const val SORT_SIZE_DESC = 4
    const val SORT_SIZE_ASC = 5

    /** How the Downloads screen orders its list (kept between runs). */
    var sortMode: Int
        get() = if (inited) prefs.getInt("sort", SORT_NEWEST).coerceIn(0, 5) else SORT_NEWEST
        set(v) { if (inited) prefs.edit().putInt("sort", v.coerceIn(0, 5)).apply() }

    /** Invalid file-name characters (\\ / : * ? " < > | and control characters) become "_"; dots / spaces at the ends go; max 200 chars, extension kept. */
    fun cleanFileName(raw: String): String {
        var n = raw.replace(Regex("[\\\\/:*?\"<>|\\p{Cntrl}]"), "_").trim().trim('.', ' ')
        if (n.length > 200) {
            val ext = n.substringAfterLast('.', "")
            n = if (ext.length in 1..10) n.substringBeforeLast('.').take(200 - ext.length - 1) + "." + ext else n.take(200)
        }
        return n
    }

    /**
     * Renames the finished file of download [id] (MediaStore / SAF [DlTask.savedUri], or a plain [DlTask.savedPath]).
     * A name that already exists gets " (1)", " (2)" ...; a name typed without an extension keeps the old one.
     * Runs on a background thread; [onDone] runs on the main thread with (success, new name or error text).
     */
    fun rename(id: Long, newName: String, onDone: (ok: Boolean, info: String) -> Unit) {
        val t = find(id)
        if (!inited || t == null || t.status != DONE) { main.post { onDone(false, "Only finished downloads can be renamed") }; return }
        var name = cleanFileName(newName)
        if (name.isBlank()) { main.post { onDone(false, "Type a file name") }; return }
        val oldExt = t.fileName.substringAfterLast('.', "")
        if (!name.contains('.') && oldExt.isNotEmpty()) name += ".$oldExt"
        if (name == t.fileName) { main.post { onDone(true, t.fileName) }; return }
        val wanted = name
        pool.execute {
            val r = try { doRename(t, wanted) } catch (e: Exception) { false to (e.message ?: "Rename failed") }
            main.post { onDone(r.first, r.second) }
        }
    }

    private fun doRename(t: DlTask, wanted: String): Pair<Boolean, String> {
        if (t.savedUri.isNotEmpty() && isDocUri(Uri.parse(t.savedUri))) {   // file in a folder the user picked (SAF)
            val cr = app.contentResolver
            val renamed = DocumentsContract.renameDocument(cr, Uri.parse(t.savedUri), wanted)
                ?: return false to "Cannot rename in this folder"
            var real = wanted
            try {
                cr.query(renamed, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use {
                    if (it.moveToFirst()) it.getString(0)?.let { v -> real = v }
                }
            } catch (e: Exception) { }
            t.savedUri = renamed.toString()
            t.savedPath = t.savedPath.substringBeforeLast('/', "") .let { if (it.isEmpty()) real else "$it/$real" }
            applyRenamed(t, real)
            return true to real
        }
        if (t.savedUri.isNotEmpty() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val uri = Uri.parse(t.savedUri)
            val cr = app.contentResolver
            val finalName = uniqueMediaName(uri, wanted)
            val cv = ContentValues().apply { put(MediaStore.MediaColumns.DISPLAY_NAME, finalName) }
            val n = try { cr.update(uri, cv, null, null) } catch (e: SecurityException) { 0 }
            if (n <= 0) return false to "Cannot rename: this file belongs to another app"
            var real = finalName
            try {
                cr.query(uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use {
                    if (it.moveToFirst()) it.getString(0)?.let { v -> real = v }
                }
            } catch (e: Exception) { }
            t.savedPath = t.savedPath.substringBeforeLast('/', "Download") + "/" + real
            applyRenamed(t, real)
            return true to real
        }
        val f = fileFor(t) ?: return false to "File not found"
        if (!f.exists()) return false to "File is no longer in storage"
        val dir = f.parentFile ?: return false to "File not found"
        val dest = uniqueFile(dir, wanted)
        if (!f.renameTo(dest)) return false to "Rename failed"
        t.savedPath = dest.absolutePath
        try {
            MediaScannerConnection.scanFile(app, arrayOf(f.absolutePath, dest.absolutePath), null) { path, uri ->
                if (path == dest.absolutePath && uri != null) { t.savedUri = uri.toString(); persist(); changed() }
            }
        } catch (e: Exception) { }
        applyRenamed(t, dest.name)
        return true to dest.name
    }

    /** A display name that no other file in the same MediaStore folder uses. */
    private fun uniqueMediaName(uri: Uri, wanted: String): String {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) return wanted
        val cr = app.contentResolver
        var rel = "Download/"
        var selfId = -1L
        try {
            cr.query(uri, arrayOf(MediaStore.MediaColumns.RELATIVE_PATH, MediaStore.MediaColumns._ID), null, null, null)?.use {
                if (it.moveToFirst()) { it.getString(0)?.let { v -> rel = v }; selfId = it.getLong(1) }
            }
        } catch (e: Exception) { }
        val base = wanted.substringBeforeLast('.', wanted)
        val ext = if (wanted.contains('.')) "." + wanted.substringAfterLast('.') else ""
        var cand = wanted
        var i = 1
        while (i < 1000) {
            var taken = false
            try {
                cr.query(
                    MediaStore.Downloads.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.MediaColumns._ID),
                    "${MediaStore.MediaColumns.RELATIVE_PATH}=? AND ${MediaStore.MediaColumns.DISPLAY_NAME}=? AND ${MediaStore.MediaColumns._ID}!=?",
                    arrayOf(rel, cand, selfId.toString()), null
                )?.use { taken = it.count > 0 }
            } catch (e: Exception) { }
            if (!taken) return cand
            cand = "$base ($i)$ext"; i++
        }
        return cand
    }

    private fun applyRenamed(t: DlTask, name: String) {
        val extChanged = !name.substringAfterLast('.', "").equals(t.fileName.substringAfterLast('.', ""), true)
        t.fileName = name
        if (extChanged) t.mime = guessMime(name)
        persist(); changed()
    }

    /** Starts the same download again as a new entry (a finished or failed one). Null for blob / data downloads. */
    fun redownload(id: Long): DlTask? {
        val t = find(id) ?: return null
        if (t.isBlob || t.url.isBlank()) return null
        return enqueue(t.url, t.fileName, t.mime, t.cookie, t.ua, t.referer)
    }

    // ── Storage sync (Step 3) ───────────────────────────────────
    //
    // The list is kept in SharedPreferences, but the files live in the phone's storage, where the user can
    // rename, move or delete them (file manager, gallery, adb ...). refreshFromStorage() compares every finished
    // download with what is really there: entries whose file is gone are dropped from the list, and renamed /
    // resized files get their real name and size.

    private val syncing = AtomicBoolean(false)

    /** exists: true = file is there, false = file is gone, null = cannot tell (nothing is changed then). */
    private class StoragePoint(val exists: Boolean?, val name: String? = null, val size: Long = -1L, val path: String? = null)

    private fun fileFor(t: DlTask): File? {
        val p = t.savedPath
        return when {
            p.startsWith("/") -> File(p)
            p.isNotEmpty() -> File(Environment.getExternalStorageDirectory(), p) // "Download/name.ext"
            else -> null
        }
    }

    private fun probeStorage(t: DlTask): StoragePoint {
        var uriAnswered = false
        if (t.savedUri.isNotEmpty()) {
            try {
                val uri = Uri.parse(t.savedUri)
                val proj = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && !isDocUri(uri))
                    arrayOf(OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE, MediaStore.MediaColumns.RELATIVE_PATH)
                else arrayOf(OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE)
                val cr = app.contentResolver
                cr.query(uri, proj, null, null, null)?.use { c ->
                    uriAnswered = true
                    if (c.moveToFirst()) {
                        val name = c.getString(0)
                        val size = if (c.isNull(1)) -1L else c.getLong(1)
                        val rel = if (proj.size > 2) c.getString(2) else null
                        // a media row can outlive its file: make sure the bytes can really be opened
                        val openable = try {
                            cr.openFileDescriptor(uri, "r")?.use { true } ?: true
                        } catch (e: FileNotFoundException) { false } catch (e: Exception) { true }
                        if (openable) {
                            val path = if (!rel.isNullOrEmpty() && !name.isNullOrEmpty()) rel.trimEnd('/') + "/" + name else null
                            return StoragePoint(true, name, size, path)
                        }
                    }
                }
            } catch (e: Exception) {
                return StoragePoint(null) // no permission / provider trouble: do not guess
            }
        }
        val f = fileFor(t)
        if (f != null && f.exists()) return StoragePoint(true, f.name, f.length(), null)
        if (t.savedUri.isEmpty() && f == null) return StoragePoint(null)
        if (t.savedUri.isNotEmpty() && !uriAnswered) return StoragePoint(null)
        return StoragePoint(false)
    }

    /** true when the finished file of [t] is no longer in storage (quick check, used before opening a file). */
    fun isFileMissing(t: DlTask): Boolean = t.status == DONE && probeStorage(t).exists == false

    /**
     * Syncs the finished downloads with the storage on a background thread.
     * [onDone] runs on the main thread with (entries removed, entries updated); it is also called when a sync is
     * already running (with 0, 0), so a spinner that waits for it never hangs.
     */
    fun refreshFromStorage(onDone: ((removed: Int, updated: Int) -> Unit)? = null) {
        if (!inited) { onDone?.let { main.post { it(0, 0) } }; return }
        if (!syncing.compareAndSet(false, true)) { onDone?.let { main.post { it(0, 0) } }; return }
        pool.execute {
            var removed = 0
            var updated = 0
            try {
                for (t in tasks.toList()) {
                    if (t.status != DONE) continue
                    val p = probeStorage(t)
                    when (p.exists) {
                        false -> { tasks.remove(t); removed++ }
                        true -> {
                            var ch = false
                            if (!p.name.isNullOrBlank() && p.name != t.fileName) { t.fileName = p.name; ch = true }
                            if (!p.path.isNullOrBlank() && p.path != t.savedPath) { t.savedPath = p.path; ch = true }
                            if (p.size >= 0 && p.size != t.total) { t.total = p.size; t.downloaded.set(p.size); ch = true }
                            if (ch) updated++
                        }
                        else -> { }
                    }
                }
                if (removed > 0 || updated > 0) persist()
            } catch (e: Exception) {
            } finally {
                syncing.set(false)
            }
            main.post {
                if (removed > 0 || updated > 0) changed()
                onDone?.invoke(removed, updated)
            }
        }
    }

    fun clearFinished() {
        for (t in tasks.toList()) if (t.status == DONE || t.status == FAILED) cancel(t.id)
    }

    fun activeCount(): Int = tasks.count { it.status == RUNNING || it.status == QUEUED || it.status == SAVING }

    private fun closeConns(t: DlTask) {
        synchronized(t.conns) {
            for (c in t.conns) try { c.disconnect() } catch (e: Exception) { }
            t.conns.clear()
        }
    }

    private fun tempFile(t: DlTask): File {
        val dir = app.getExternalFilesDir("dl") ?: File(app.filesDir, "dl")
        dir.mkdirs()
        return File(dir, "${t.id}.part")
    }

    // ── Queue ───────────────────────────────────────────────────

    @Synchronized
    private fun pump() {
        var running = tasks.count { it.status == RUNNING && !it.isBlob }
        for (t in tasks) {
            if (running >= maxParallel) break
            if (t.status == QUEUED && !t.isBlob) {
                t.status = RUNNING
                t.speed = 0; t.lastTime = 0L; t.lastBytes = t.downloaded.get()
                t.gen++
                val g = t.gen
                running++
                pool.execute { runTask(t, g) }
            }
        }
    }

    private fun ok(t: DlTask, g: Int) = t.status == RUNNING && t.gen == g

    private fun fail(t: DlTask, g: Int, msg: String) {
        synchronized(t) {
            if (t.gen == g && (t.status == RUNNING || t.status == SAVING)) {
                t.status = FAILED
                t.error = msg
            }
        }
    }

    private fun runTask(t: DlTask, g: Int) {
        try {
            prepare(t, g)
            if (!ok(t, g)) return
            download(t, g)
            if (!ok(t, g)) return
            finish(t)
        } catch (e: Exception) {
            fail(t, g, e.message ?: e.javaClass.simpleName)
        } finally {
            if (t.gen == g) closeConns(t)
            if (t.gen == g && (t.status == DONE || t.status == FAILED)) notifyTerminal(t)
            persist(); changed(); pump()
        }
    }

    // ── HTTP ────────────────────────────────────────────────────

    private fun open(t: DlTask, start: Long, end: Long, ranged: Boolean): HttpURLConnection {
        var url = t.finalUrl.ifBlank { t.url }
        for (hop in 0 until 8) {
            val c = URL(url).openConnection() as HttpURLConnection
            c.connectTimeout = 20_000
            c.readTimeout = 30_000
            c.instanceFollowRedirects = false
            c.setRequestProperty(
                "User-Agent",
                t.ua.ifBlank { "Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36" }
            )
            if (t.cookie.isNotBlank()) c.setRequestProperty("Cookie", t.cookie)
            if (t.referer.isNotBlank()) c.setRequestProperty("Referer", t.referer)
            c.setRequestProperty("Accept", "*/*")
            c.setRequestProperty("Accept-Encoding", "identity")
            if (ranged) c.setRequestProperty("Range", "bytes=$start-" + (if (end >= 0) end.toString() else ""))
            t.conns.add(c)
            val code = c.responseCode
            if (code in 300..399 && code != 304) {
                val loc = c.getHeaderField("Location")
                t.conns.remove(c)
                c.disconnect()
                if (loc.isNullOrBlank()) throw IOException("Bad redirect")
                url = URL(URL(url), loc).toString()
                continue
            }
            t.finalUrl = url
            return c
        }
        throw IOException("Too many redirects")
    }

    private fun probe(t: DlTask) {
        val c = open(t, 0, 0, true)
        try {
            val code = c.responseCode
            if (code == 206) {
                val cr = c.getHeaderField("Content-Range") ?: ""
                val total = cr.substringAfter('/', "").trim().toLongOrNull() ?: -1L
                t.total = total
                t.rangeOk = total > 0
            } else if (code in 200..299) {
                t.total = c.contentLengthLong
                t.rangeOk = false
            } else {
                throw IOException("HTTP $code")
            }
        } finally {
            t.conns.remove(c)
            try { c.disconnect() } catch (e: Exception) { }
        }
    }

    private fun prepare(t: DlTask, g: Int) {
        val temp = tempFile(t)
        if (t.segStart.isEmpty()) {
            probe(t)
            if (!ok(t, g)) return
            val n = if (t.rangeOk && t.total >= 2 * MIN_SEGMENT)
                minOf(connections.toLong(), t.total / MIN_SEGMENT).toInt().coerceAtLeast(1) else 1
            val ss = LongArray(n); val se = LongArray(n); val sp = LongArray(n)
            if (t.total > 0) {
                val size = t.total / n
                for (i in 0 until n) {
                    ss[i] = i * size
                    se[i] = if (i == n - 1) t.total - 1 else ss[i] + size - 1
                    sp[i] = ss[i]
                }
            } else {
                ss[0] = 0; se[0] = -1; sp[0] = 0
            }
            t.segStart = ss; t.segEnd = se; t.segPos = sp
            t.downloaded.set(0)
            try { temp.delete() } catch (e: Exception) { }
        } else {
            // resuming: make sure the partial file is still there
            val progressed = t.downloaded.get() > 0
            if (!temp.exists() || (progressed && !t.rangeOk)) {
                for (i in t.segPos.indices) t.segPos[i] = t.segStart[i]
                t.downloaded.set(0)
                try { temp.delete() } catch (e: Exception) { }
            }
        }
        t.lastBytes = t.downloaded.get(); t.lastTime = 0L
        persist(); changed()
    }

    private fun download(t: DlTask, g: Int) {
        val temp = tempFile(t)
        RandomAccessFile(temp, "rw").use { r ->
            if (t.total > 0 && r.length() != t.total) r.setLength(t.total)
        }
        val n = t.segStart.size
        val threads = ArrayList<Thread>()
        for (i in 0 until n) {
            val th = Thread {
                try { runSegment(t, g, i, temp) }
                catch (e: Exception) { fail(t, g, e.message ?: e.javaClass.simpleName) }
            }
            th.isDaemon = true
            threads.add(th)
            th.start()
        }
        while (threads.any { it.isAlive }) {
            try { Thread.sleep(400) } catch (e: InterruptedException) { }
            tick(t)
        }
        if (!ok(t, g)) return
        for (i in 0 until n) {
            if (t.segEnd[i] >= 0 && t.segPos[i] <= t.segEnd[i]) throw IOException("Incomplete download")
        }
    }

    private fun runSegment(t: DlTask, g: Int, i: Int, temp: File) {
        val raf = RandomAccessFile(temp, "rw")
        val buf = ByteArray(64 * 1024)
        var attempt = 0
        try {
            while (ok(t, g)) {
                val end = t.segEnd[i]
                var pos = t.segPos[i]
                if (end >= 0 && pos > end) break
                var conn: HttpURLConnection? = null
                try {
                    conn = open(t, pos, end, t.rangeOk)
                    val code = conn.responseCode
                    if (t.rangeOk && code != 206) throw IOException("Server rejected range (HTTP $code)")
                    if (!t.rangeOk && code !in 200..299) throw IOException("HTTP $code")
                    val ins = conn.inputStream
                    raf.seek(pos)
                    while (ok(t, g)) {
                        var want = buf.size
                        if (end >= 0) {
                            val rem = end - pos + 1
                            if (rem <= 0) break
                            if (rem < want) want = rem.toInt()
                        }
                        val n = ins.read(buf, 0, want)
                        if (n < 0) break
                        raf.write(buf, 0, n)
                        pos += n
                        t.segPos[i] = pos
                        t.downloaded.addAndGet(n.toLong())
                        attempt = 0
                    }
                    if (!ok(t, g)) return
                    if (end < 0) {
                        t.segEnd[i] = pos - 1
                        t.total = pos
                        break
                    }
                    if (pos <= end) throw IOException("Connection closed early")
                    break
                } catch (e: IOException) {
                    if (!ok(t, g)) return
                    attempt++
                    if (attempt > 6) throw e
                    if (!t.rangeOk && t.segPos[i] > t.segStart[i]) {
                        t.downloaded.addAndGet(-(t.segPos[i] - t.segStart[i]))
                        t.segPos[i] = t.segStart[i]
                        raf.setLength(0)
                    }
                    try { Thread.sleep(800L * attempt) } catch (ie: InterruptedException) { }
                } finally {
                    if (conn != null) {
                        t.conns.remove(conn)
                        try { conn.disconnect() } catch (e: Exception) { }
                    }
                }
            }
        } finally {
            try { raf.close() } catch (e: Exception) { }
        }
    }

    private fun tick(t: DlTask) {
        val now = SystemClock.elapsedRealtime()
        val d = t.downloaded.get()
        if (t.lastTime == 0L) { t.lastTime = now; t.lastBytes = d }
        val dt = now - t.lastTime
        if (dt >= 800) {
            val inst = (d - t.lastBytes) * 1000 / dt
            t.speed = if (t.speed == 0L) inst else (t.speed * 0.6 + inst * 0.4).toLong()
            t.lastBytes = d; t.lastTime = now
        }
        if (now - lastPersist > 3000) { lastPersist = now; persist() }
        changed()
    }

    // ── Save finished file to Downloads ────────────────────────

    private fun uniqueFile(dir: File, name: String): File {
        var f = File(dir, name)
        if (!f.exists()) return f
        val base = name.substringBeforeLast('.', name)
        val ext = if (name.contains('.')) "." + name.substringAfterLast('.') else ""
        var i = 1
        while (f.exists()) { f = File(dir, "$base ($i)$ext"); i++ }
        return f
    }

    /** A name that does not exist yet in the picked folder: "name.ext", "name (1).ext", "name (2).ext" ... */
    private fun uniqueTreeName(tree: Uri, wanted: String): String {
        val used = HashSet<String>()
        for ((_, n) in treeChildren(tree)) used.add(n.lowercase())
        if (wanted.lowercase() !in used) return wanted
        val base = wanted.substringBeforeLast('.', wanted)
        val ext = if (wanted.contains('.')) "." + wanted.substringAfterLast('.') else ""
        var i = 1
        while ("$base ($i)$ext".lowercase() in used) i++
        return "$base ($i)$ext"
    }

    /**
     * Copies the finished temp file into the folder the user picked (Storage Access Framework).
     * Returns false when that is not possible (permission gone, folder deleted ...): the caller then uses Downloads.
     */
    private fun saveToTree(t: DlTask, temp: File, name: String): Boolean {
        val tree = Uri.parse(t.destTree)
        val cr = app.contentResolver
        if (cr.persistedUriPermissions.none { it.uri == tree && it.isWritePermission }) return false
        val parent = DocumentsContract.buildDocumentUriUsingTree(tree, DocumentsContract.getTreeDocumentId(tree))
        val finalName = uniqueTreeName(tree, name)
        var doc = DocumentsContract.createDocument(cr, parent, guessMime(finalName), finalName) ?: return false
        try {
            cr.openOutputStream(doc, "w")?.use { out ->
                temp.inputStream().use { it.copyTo(out, 128 * 1024) }
            } ?: throw IOException("Cannot write file")
        } catch (e: Exception) {
            try { DocumentsContract.deleteDocument(cr, doc) } catch (x: Exception) { }
            throw e
        }
        var real = finalName
        try {
            cr.query(doc, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use {
                if (it.moveToFirst()) it.getString(0)?.let { v -> real = v }
            }
        } catch (e: Exception) { }
        // some providers add an extension of their own (name.xyz -> name.xyz.bin): put the wanted name back
        if (real != finalName) {
            try { DocumentsContract.renameDocument(cr, doc, finalName)?.let { doc = it; real = finalName } } catch (e: Exception) { }
        }
        t.fileName = real
        t.savedUri = doc.toString()
        t.savedPath = folderLabel() + "/" + real
        return true
    }

    private fun finish(t: DlTask) {
        t.status = SAVING
        t.speed = 0
        changed()
        val temp = tempFile(t)
        val name = t.fileName.ifBlank { "download_${t.id}" }
        val mime = t.mime.ifBlank { guessMime(name) }
        if (t.overwrite) {   // "Overwrite": the old file goes only now, after the new one was downloaded completely
            try {
                deleteExisting(name, if (t.destTree.isNotEmpty() && treePermOk(t.destTree)) t.destTree else "")
                tasks.removeAll { it !== t && it.status == DONE && it.fileName.equals(name, true) && it.destTree == t.destTree }
            } catch (e: Exception) { }
        }
        val savedToTree = t.destTree.isNotEmpty() && try { saveToTree(t, temp, name) } catch (e: Exception) { false }
        if (savedToTree) {
            // saved into the folder the user picked
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val cv = ContentValues().apply {
                put(MediaStore.Downloads.DISPLAY_NAME, name)
                put(MediaStore.Downloads.MIME_TYPE, mime)
                put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
                put(MediaStore.Downloads.IS_PENDING, 1)
            }
            val cr = app.contentResolver
            val uri = cr.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, cv)
                ?: throw IOException("Cannot create file in Downloads")
            cr.openOutputStream(uri)?.use { out ->
                temp.inputStream().use { it.copyTo(out, 128 * 1024) }
            } ?: throw IOException("Cannot write file")
            cv.clear()
            cv.put(MediaStore.Downloads.IS_PENDING, 0)
            cr.update(uri, cv, null, null)
            try {
                cr.query(uri, arrayOf(MediaStore.Downloads.DISPLAY_NAME), null, null, null)?.use {
                    if (it.moveToFirst()) t.fileName = it.getString(0) ?: name
                }
            } catch (e: Exception) { }
            t.savedUri = uri.toString()
            t.savedPath = "Download/" + t.fileName
        } else {
            val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            dir.mkdirs()
            val dest = uniqueFile(dir, name)
            temp.copyTo(dest, true)
            t.fileName = dest.name
            t.savedPath = dest.absolutePath
            try {
                MediaScannerConnection.scanFile(app, arrayOf(dest.absolutePath), arrayOf(mime)) { _, uri ->
                    if (uri != null) { t.savedUri = uri.toString(); persist(); changed() }
                }
            } catch (e: Exception) { }
        }
        try { temp.delete() } catch (e: Exception) { }
        t.downloaded.set(if (t.total > 0) t.total else t.downloaded.get())
        t.status = DONE
    }

    // ── Blob / data support (bytes are pushed in by the page) ──

    @Synchronized
    fun beginBlob(fileName: String, mime: String, size: Long): DlTask {
        val t = DlTask(nextId++)
        t.fileName = fileName
        t.destTree = activeDestTree()
        t.overwrite = overwriteOnce; overwriteOnce = false
        t.mime = if (mime.isBlank()) guessMime(fileName) else mime
        t.isBlob = true
        t.total = size
        t.status = RUNNING
        t.lastTime = 0L
        try { tempFile(t).delete() } catch (e: Exception) { }
        try { t.blobOut = FileOutputStream(tempFile(t)) } catch (e: Exception) {
            t.status = FAILED; t.error = e.message ?: "Cannot create file"
        }
        tasks.add(t)
        persist(); changed()
        return t
    }

    fun blobChunk(t: DlTask, bytes: ByteArray): Boolean {
        if (t.status != RUNNING) {
            try { t.blobOut?.close() } catch (e: Exception) { }
            return false
        }
        return try {
            t.blobOut?.write(bytes)
            t.downloaded.addAndGet(bytes.size.toLong())
            if (t.total < t.downloaded.get()) t.total = t.downloaded.get()
            tick(t)
            true
        } catch (e: Exception) {
            t.status = FAILED; t.error = e.message ?: "Write failed"
            try { t.blobOut?.close() } catch (x: Exception) { }
            notifyTerminal(t); persist(); changed()
            false
        }
    }

    fun blobDone(t: DlTask) {
        try { t.blobOut?.close() } catch (e: Exception) { }
        t.blobOut = null
        if (t.status != RUNNING) return
        pool.execute {
            try { finish(t) } catch (e: Exception) {
                t.status = FAILED; t.error = e.message ?: "Save failed"
            }
            notifyTerminal(t); persist(); changed()
        }
    }

    fun blobFail(t: DlTask, msg: String) {
        try { t.blobOut?.close() } catch (e: Exception) { }
        if (t.status == RUNNING) {
            t.status = FAILED; t.error = msg
            try { tempFile(t).delete() } catch (e: Exception) { }
            notifyTerminal(t)
        }
        persist(); changed()
    }

    fun saveBytes(fileName: String, mime: String, bytes: ByteArray): DlTask {
        val t = beginBlob(fileName, mime, bytes.size.toLong())
        if (blobChunk(t, bytes)) blobDone(t)
        return t
    }

    // ── Notifications / service ────────────────────────────────

    private fun ensureChannels() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val nm = app.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.createNotificationChannel(
            NotificationChannel(CH_PROGRESS, "Download progress", NotificationManager.IMPORTANCE_LOW)
        )
        nm.createNotificationChannel(
            NotificationChannel(CH_DONE, "Download finished", NotificationManager.IMPORTANCE_DEFAULT)
        )
    }

    private fun openIntent(): PendingIntent {
        val i = Intent(app, MainActivity::class.java)
            .putExtra("open_downloads", true)
            .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        return PendingIntent.getActivity(app, 0, i, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
    }

    fun buildOngoing(): Notification {
        ensureChannels()
        val active = tasks.filter { it.status == RUNNING || it.status == QUEUED || it.status == SAVING }
        var total = 0L; var done = 0L; var speed = 0L
        for (t in active) {
            if (t.total > 0) { total += t.total; done += t.downloaded.get() }
            speed += t.speed
        }
        val title = when {
            active.isEmpty() -> "Downloads"
            active.size == 1 -> active[0].fileName
            else -> "${active.size} downloads"
        }
        val text = if (total > 0) "${dlFmtSize(done)} / ${dlFmtSize(total)}" + (if (speed > 0) "  •  ${dlFmtSize(speed)}/s" else "")
        else if (speed > 0) "${dlFmtSize(speed)}/s" else "Preparing…"
        val b = NotificationCompat.Builder(app, CH_PROGRESS)
            .setSmallIcon(R.drawable.ic_stat_download)
            .setContentTitle(title)
            .setContentText(text)
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setContentIntent(openIntent())
        if (total > 0) b.setProgress(100, (done * 100 / total).toInt().coerceIn(0, 100), false)
        else b.setProgress(0, 0, true)
        return b.build()
    }

    private fun updateNotification() {
        if (!inited) return
        try {
            val nm = app.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (activeCount() == 0) {
                if (serviceOn) { app.stopService(Intent(app, DownloadService::class.java)); serviceOn = false }
                nm.cancel(NOTIF_ONGOING)
                return
            }
            val now = SystemClock.elapsedRealtime()
            if (serviceOn && now - lastNotif < 1000) return
            lastNotif = now
            if (!serviceOn) {
                try {
                    ContextCompat.startForegroundService(app, Intent(app, DownloadService::class.java))
                    serviceOn = true
                } catch (e: Exception) { }
            }
            nm.notify(NOTIF_ONGOING, buildOngoing())
        } catch (e: Exception) { }
    }

    private fun notifyTerminal(t: DlTask) {
        try {
            ensureChannels()
            val nm = app.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val ok = t.status == DONE
            val n = NotificationCompat.Builder(app, CH_DONE)
                .setSmallIcon(if (ok) R.drawable.ic_stat_done else R.drawable.ic_stat_error)
                .setContentTitle(t.fileName)
                .setContentText(if (ok) "Download complete" else "Download failed: ${t.error}")
                .setAutoCancel(true)
                .setContentIntent(openIntent())
                .build()
            nm.notify(10000 + (t.id % 80000).toInt(), n)
        } catch (e: Exception) { }
    }
}

// ---------------------------------------------------------------------
// Foreground service – keeps downloads alive while the app is in background
// ---------------------------------------------------------------------

class DownloadService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!DlEngine.isReady) { stopSelf(); return START_NOT_STICKY }
        try {
            val n = DlEngine.buildOngoing()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
                startForeground(DlEngine.NOTIF_ONGOING, n, ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC)
            else startForeground(DlEngine.NOTIF_ONGOING, n)
        } catch (e: Exception) { stopSelf() }
        return START_NOT_STICKY
    }
}

// ---------------------------------------------------------------------
// JS bridge used to stream blob: contents out of the web page
// ---------------------------------------------------------------------

class BlobBridge {
    @JavascriptInterface
    fun chunk(id: String, b64: String): Boolean {
        val t = DlEngine.find(id.toLongOrNull() ?: return false) ?: return false
        return try { DlEngine.blobChunk(t, Base64.decode(b64, Base64.DEFAULT)) } catch (e: Exception) {
            DlEngine.blobFail(t, "Decode error"); false
        }
    }

    @JavascriptInterface
    fun done(id: String) {
        val t = DlEngine.find(id.toLongOrNull() ?: return) ?: return
        DlEngine.blobDone(t)
    }

    @JavascriptInterface
    fun fail(id: String, msg: String) {
        val t = DlEngine.find(id.toLongOrNull() ?: return) ?: return
        DlEngine.blobFail(t, msg)
    }
}

/** JS injected into every page: remembers blob objects + download names. */
internal const val BLOB_HOOK_JS = """
(function(){
  if (window.__w11hook) return; window.__w11hook = true;
  window.__w11names = {}; window.__w11types = {}; window.__w11blobs = {};
  try {
    var oc = URL.createObjectURL, orv = URL.revokeObjectURL;
    URL.createObjectURL = function(o){
      var u = oc.apply(this, arguments);
      try { window.__w11blobs[u] = o; window.__w11types[u] = {type: o.type || '', size: o.size || 0}; } catch(e){}
      return u;
    };
    URL.revokeObjectURL = function(u){
      setTimeout(function(){ try{ delete window.__w11blobs[u]; }catch(e){} }, 120000);
      return orv.apply(this, arguments);
    };
    var ac = HTMLAnchorElement.prototype.click;
    HTMLAnchorElement.prototype.click = function(){
      try { if (this.download && this.href) window.__w11names[this.href] = this.download; } catch(e){}
      return ac.apply(this, arguments);
    };
    document.addEventListener('click', function(e){
      try {
        var a = e.target && e.target.closest ? e.target.closest('a') : null;
        if (a && a.download && a.href) window.__w11names[a.href] = a.download;
      } catch(x){}
    }, true);
  } catch(e){}
})();
"""

/** JS that streams a blob to Android in 256 KB chunks. */
internal fun blobTransferJs(blobUrlJson: String, taskId: Long): String = """
(function(u, id){
  function go(blob){
    var CH = 262144, off = 0;
    function next(){
      if (off >= blob.size) { AndroidBlobDl.done(id); return; }
      var end = Math.min(off + CH, blob.size);
      var r = new FileReader();
      r.onload = function(){
        var s = r.result, i = s.indexOf(',');
        var ok = AndroidBlobDl.chunk(id, s.substring(i + 1));
        off = end;
        if (ok === false) return;
        setTimeout(next, 0);
      };
      r.onerror = function(){ AndroidBlobDl.fail(id, 'read error'); };
      r.readAsDataURL(blob.slice(off, end));
    }
    next();
  }
  var b = (window.__w11blobs || {})[u];
  if (b && b.slice) { go(b); }
  else {
    fetch(u).then(function(r){ return r.blob(); }).then(go)
      .catch(function(e){ AndroidBlobDl.fail(id, String(e)); });
  }
})($blobUrlJson, "$taskId");
"""
