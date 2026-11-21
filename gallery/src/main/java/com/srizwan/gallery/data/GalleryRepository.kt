package com.srizwan.gallery.data

import android.content.Context
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.io.File
import java.time.Instant
import java.time.ZoneId

/**
 * Where the Gallery gets its pictures from.
 *
 *  1. **MediaStore** (fast, has width / height / date taken) is the main source.
 *  2. A **folder scan** adds the pictures MediaStore does not know yet (files a file manager just copied, folders that
 *     were never indexed). It needs "all files access" ([GalleryPermission.canScanFolders]) and skips hidden folders,
 *     folders with a `.nomedia` file and `Android/data|obb`.
 *
 * The list is kept in memory ([cached]) so the home screen, an album and the viewer share one load; [invalidate]
 * drops it (after a delete / rename / pull-to-refresh). All loading runs on a background thread.
 */
object GalleryRepository {

    private const val TAG = "GalleryRepository"

    /** Picture file types the Gallery shows. */
    val EXTENSIONS: Set<String> = setOf("jpg", "jpeg", "png", "webp", "gif", "bmp", "heic", "heif")

    private const val MAX_SCAN_DEPTH = 12
    private const val MAX_SCAN_DIRS = 20_000
    private const val MAX_SCAN_FOUND = 20_000

    private val lock = Mutex()
    @Volatile private var cache: List<GalleryImage>? = null

    private val primaryRoot: String by lazy {
        runCatching { Environment.getExternalStorageDirectory().absolutePath }.getOrDefault("")
    }

    // ── names and types ──────────────────────────────────────────────────────

    fun isImageName(name: String): Boolean {
        val dot = name.lastIndexOf('.')
        if (dot < 0 || dot == name.length - 1) return false
        return name.substring(dot + 1).lowercase() in EXTENSIONS
    }

    private fun mimeFor(name: String): String = when (name.substringAfterLast('.', "").lowercase()) {
        "jpg", "jpeg" -> "image/jpeg"
        "png" -> "image/png"
        "webp" -> "image/webp"
        "gif" -> "image/gif"
        "bmp" -> "image/bmp"
        "heic" -> "image/heic"
        "heif" -> "image/heif"
        else -> "image/*"
    }

    /** Hidden files / folders (".thumbnails", ".trash") and other apps' private folders are not pictures to show. */
    private fun isHiddenPath(path: String): Boolean =
        path.contains("/.") || path.contains("/Android/data/") || path.contains("/Android/obb/")

    private fun folderLabel(folderPath: String, parentName: String?): String =
        if (folderPath == primaryRoot) "Internal storage" else (parentName ?: folderPath)

    // ── loading ──────────────────────────────────────────────────────────────

    /** The last loaded list, or null when nothing was loaded yet (or after [invalidate]). */
    fun cached(): List<GalleryImage>? = cache

    fun invalidate() {
        cache = null
    }

    /**
     * The viewer deleted [path]: drop it from the shared list without a reload. The list is replaced, not changed in
     * place (screens compare it by identity to notice that something changed, and may be reading the old one).
     */
    @Synchronized
    fun removeFromCache(path: String) {
        val list = cache ?: return
        if (list.none { it.path == path }) return
        cache = list.filter { it.path != path }
    }

    /** Several pictures were deleted at once (multi-select, step 9): one pass over the list instead of one per picture. */
    @Synchronized
    fun removeAllFromCache(paths: Set<String>) {
        val list = cache ?: return
        if (paths.isEmpty() || list.none { it.path in paths }) return
        cache = list.filter { it.path !in paths }
    }

    /** The viewer renamed / rewrote the picture that was at [oldPath]: put [image] in its place in the shared list. */
    @Synchronized
    fun replaceInCache(oldPath: String, image: GalleryImage) {
        val list = cache ?: return
        val index = list.indexOfFirst { it.path == oldPath }
        if (index < 0) return
        val copy = ArrayList(list)
        copy[index] = image
        cache = copy
    }

    /**
     * All pictures, newest first. Uses the in-memory list unless [forceRefresh] (or nothing is cached).
     * Returns an empty list without the storage permission.
     */
    suspend fun load(
        context: Context,
        forceRefresh: Boolean = false,
        scanFolders: Boolean = true
    ): List<GalleryImage> = withContext(Dispatchers.IO) {
        lock.withLock {
            val have = cache
            if (!forceRefresh && have != null) return@withLock have
            val app = context.applicationContext
            if (!GalleryPermission.has(app)) return@withLock emptyList<GalleryImage>()

            val result = ArrayList<GalleryImage>(queryMediaStore(app))
            if (scanFolders && GalleryPermission.canScanFolders(app)) {
                val known = HashSet<String>(result.size * 2)
                for (img in result) known.add(img.path)
                scanFolders(known, result)
            }
            result.sortWith(GallerySort().comparator)
            cache = result
            result
        }
    }

    @Suppress("DEPRECATION") // MediaStore DATA (the real path) is what the File Manager and the viewer work with
    private suspend fun queryMediaStore(context: Context): List<GalleryImage> {
        val out = ArrayList<GalleryImage>()
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.Media.DATE_MODIFIED,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT,
            MediaStore.Images.Media.MIME_TYPE
        )
        try {
            context.contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection, null, null,
                MediaStore.Images.Media.DATE_MODIFIED + " DESC"
            )?.use { c ->
                val iId = c.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                val iData = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                val iName = c.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                val iSize = c.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
                val iTaken = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN)
                val iModified = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED)
                val iWidth = c.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)
                val iHeight = c.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)
                val iMime = c.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE)
                val seen = HashSet<String>()
                var n = 0
                while (c.moveToNext()) {
                    if (++n % 500 == 0) currentCoroutineContext().ensureActive()
                    val path = c.getString(iData) ?: continue
                    if (isHiddenPath(path) || !seen.add(path)) continue
                    val size = c.getLong(iSize)
                    if (size <= 0L) continue
                    val file = File(path)
                    val name = c.getString(iName)?.takeIf { it.isNotEmpty() } ?: file.name
                    val taken = c.getLong(iTaken)
                    val modified = c.getLong(iModified) * 1000L
                    val parent = file.parentFile
                    val folderPath = parent?.absolutePath ?: ""
                    val mime = c.getString(iMime)?.takeIf { it.startsWith("image/") } ?: mimeFor(name)
                    out.add(
                        GalleryImage(
                            id = c.getLong(iId),
                            path = path,
                            name = name,
                            folderPath = folderPath,
                            folderName = folderLabel(folderPath, parent?.name),
                            size = size,
                            dateMillis = if (taken > 0L) taken else modified,
                            width = c.getInt(iWidth),
                            height = c.getInt(iHeight),
                            mime = mime
                        )
                    )
                }
            }
        } catch (e: SecurityException) {
            Log.w(TAG, "no permission to read MediaStore", e)
        } catch (e: RuntimeException) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            Log.w(TAG, "MediaStore query failed", e)
        }
        return out
    }

    /** Adds pictures that are on the storage but not in [known] (paths MediaStore returned) to [out]. */
    private suspend fun scanFolders(known: Set<String>, out: MutableList<GalleryImage>) {
        val root = runCatching { Environment.getExternalStorageDirectory() }.getOrNull() ?: return
        val stack = ArrayDeque<Pair<File, Int>>()
        stack.addLast(root to 0)
        var dirs = 0
        var found = 0
        while (stack.isNotEmpty() && dirs < MAX_SCAN_DIRS && found < MAX_SCAN_FOUND) {
            val (dir, depth) = stack.removeLast()
            dirs++
            if (dirs % 50 == 0) currentCoroutineContext().ensureActive()
            val children = try { dir.listFiles() } catch (e: SecurityException) { null } ?: continue
            if (children.any { it.name == ".nomedia" }) continue
            for (child in children) {
                val name = child.name
                if (name.startsWith(".")) continue
                if (child.isDirectory) {
                    if (depth == 0 && name == "Android") continue
                    if (depth < MAX_SCAN_DEPTH) stack.addLast(child to depth + 1)
                } else if (isImageName(name) && child.absolutePath !in known) {
                    val img = fromFile(child)
                    if (img.size > 0L) {
                        out.add(img)
                        found++
                    }
                }
            }
        }
    }

    // ── helpers for the screens ──────────────────────────────────────────────

    /** A picture described by its file alone (no MediaStore): used for files handed over by the File Manager. */
    fun fromFile(file: File): GalleryImage {
        val parent = file.parentFile
        val folderPath = parent?.absolutePath ?: ""
        return GalleryImage(
            id = 0L,
            path = file.absolutePath,
            name = file.name,
            folderPath = folderPath,
            folderName = folderLabel(folderPath, parent?.name),
            size = file.length(),
            dateMillis = file.lastModified(),
            width = 0,
            height = 0,
            mime = mimeFor(file.name)
        )
    }

    /** [fromFile] for a list of paths, in the same order; paths that are not pictures or do not exist are dropped. */
    fun fromPaths(paths: List<String>): List<GalleryImage> =
        paths.asSequence()
            .map { File(it) }
            .filter { isImageName(it.name) && it.isFile }
            .map { fromFile(it) }
            .toList()

    fun sorted(images: List<GalleryImage>, sort: GallerySort): List<GalleryImage> =
        images.sortedWith(sort.comparator)

    /** The pictures of one folder, in the order of [images]. */
    fun imagesInFolder(images: List<GalleryImage>, folderPath: String): List<GalleryImage> =
        images.filter { it.folderPath == folderPath }

    /** Case-insensitive search in the picture name and its folder name. A blank [query] returns [images]. */
    fun search(images: List<GalleryImage>, query: String): List<GalleryImage> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return images
        return images.filter { it.name.lowercase().contains(q) || it.folderName.lowercase().contains(q) }
    }

    /**
     * One [GalleryAlbum] per folder that holds pictures. [ascending] = false (default): newest first, Z to A, most
     * pictures first; true: oldest first, A to Z, fewest first (same meaning as [GallerySort]).
     */
    fun albums(
        images: List<GalleryImage>,
        by: AlbumSortBy = AlbumSortBy.DATE,
        ascending: Boolean = false
    ): List<GalleryAlbum> {
        val byFolder = LinkedHashMap<String, MutableList<GalleryImage>>()
        for (img in images) byFolder.getOrPut(img.folderPath) { ArrayList() }.add(img)
        val list = ArrayList<GalleryAlbum>(byFolder.size)
        for ((path, items) in byFolder) {
            var cover = items[0]
            var total = 0L
            for (img in items) {
                if (img.dateMillis > cover.dateMillis) cover = img
                total += img.size
            }
            list.add(GalleryAlbum(path, items[0].folderName, items.size, cover, cover.dateMillis, total))
        }
        val base: Comparator<GalleryAlbum> = when (by) {
            AlbumSortBy.DATE -> compareBy<GalleryAlbum> { it.newestMillis }
            AlbumSortBy.NAME -> Comparator<GalleryAlbum> { a, b -> naturalCompare(a.name, b.name) }
            AlbumSortBy.COUNT -> compareBy<GalleryAlbum> { it.count }
        }
        list.sortWith(if (ascending) base else base.reversed())
        return list
    }

    /**
     * Groups pictures by calendar day for the date headers of the Photos grid. The order of [images] is kept
     * (day groups appear in the order their first picture appears), so pass a list sorted by date.
     */
    fun groupByDay(images: List<GalleryImage>): List<DayGroup> {
        val zone = ZoneId.systemDefault()
        val groups = LinkedHashMap<Long, MutableList<GalleryImage>>()
        for (img in images) {
            val day = Instant.ofEpochMilli(img.dateMillis).atZone(zone).toLocalDate().toEpochDay()
            groups.getOrPut(day) { ArrayList() }.add(img)
        }
        return groups.map { (day, items) -> DayGroup(day, items) }
    }
}
