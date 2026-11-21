package com.srizwan.chooser.picker

import com.srizwan.chooser.data.MimeTypes
import java.io.File
import java.nio.file.Files
import java.util.Locale

/**
 * Lists folders for the picker (blocking: call it off the main thread). Folders always come first, in every sort order.
 * Nothing here throws: a folder that cannot be read gives `null` (so the screen can say so), a file that vanishes is skipped.
 */
object PickerLister {

    private const val SEARCH_MAX_RESULTS = 400
    private const val SEARCH_MAX_DEPTH = 8
    private const val SEARCH_MAX_FOLDERS = 20_000

    /** Does [name] fit the filters of the caller (MIME types, families, extensions)? Empty filters accept everything. */
    fun matches(name: String, filters: List<String>): Boolean {
        if (filters.isEmpty()) return true
        val mime = MimeTypes.forName(name)
        val ext = name.substringAfterLast('.', "").lowercase(Locale.ROOT)
        return filters.any { raw ->
            val f = raw.trim().lowercase(Locale.ROOT)
            when {
                f.isEmpty() || f == "*/*" || f == "*" -> true
                f.startsWith(".") -> ext.isNotEmpty() && ext == f.substring(1)
                f.endsWith("/*") -> mime.startsWith(f.dropLast(1))
                else -> mime == f
            }
        }
    }

    /**
     * The content of [dir], or null when it cannot be read.
     * [filters] are applied to files only when [applyFilters] is true; [foldersOnly] leaves files out.
     */
    fun list(
        dir: File,
        filters: List<String>,
        applyFilters: Boolean,
        foldersOnly: Boolean,
        showHidden: Boolean,
        sort: PickerSort
    ): List<PickerEntry>? {
        val children = try { dir.listFiles() } catch (e: Exception) { null } ?: return null
        val out = ArrayList<PickerEntry>(children.size)
        for (f in children) {
            val name = f.name
            if (!showHidden && name.startsWith(".")) continue
            val entry = entryOf(f, filters, applyFilters, foldersOnly, null) ?: continue
            out.add(entry)
        }
        return sorted(out, sort)
    }

    /**
     * A recursive name search below [base] (at most [SEARCH_MAX_RESULTS] hits, [SEARCH_MAX_DEPTH] levels, [SEARCH_MAX_FOLDERS] folders;
     * symbolic links are not followed). [cancelled] is polled so a new keystroke can stop an old search. Hits show their parent folder as [PickerEntry.sub].
     */
    fun search(
        base: File,
        query: String,
        filters: List<String>,
        applyFilters: Boolean,
        foldersOnly: Boolean,
        showHidden: Boolean,
        sort: PickerSort,
        cancelled: () -> Boolean
    ): List<PickerEntry> {
        val q = query.trim().lowercase(Locale.ROOT)
        if (q.isEmpty()) return emptyList()
        val out = ArrayList<PickerEntry>()
        val prefix = base.absolutePath.trimEnd('/')
        // iterative walk: (folder, depth)
        val stack = ArrayDeque<Pair<File, Int>>()
        stack.addLast(base to 0)
        var visited = 0
        while (stack.isNotEmpty() && out.size < SEARCH_MAX_RESULTS && visited < SEARCH_MAX_FOLDERS) {
            if (cancelled()) return emptyList()
            val (dir, depth) = stack.removeLast()
            visited++
            val children = try { dir.listFiles() } catch (e: Exception) { null } ?: continue
            for (f in children) {
                if (out.size >= SEARCH_MAX_RESULTS) break
                val name = f.name
                if (!showHidden && name.startsWith(".")) continue
                val isDir = try { f.isDirectory } catch (e: Exception) { false }
                if (name.lowercase(Locale.ROOT).contains(q)) {
                    val parent = f.parentFile?.absolutePath.orEmpty()
                    val rel = if (parent.startsWith(prefix)) parent.removePrefix(prefix).trimStart('/') else parent
                    val where = if (rel.isEmpty()) base.name else rel
                    entryOf(f, filters, applyFilters, foldersOnly, where)?.let { out.add(it) }
                }
                if (isDir && depth < SEARCH_MAX_DEPTH && !isLink(f)) stack.addLast(f to depth + 1)
            }
        }
        return sorted(out, sort)
    }

    private fun isLink(f: File): Boolean = try { Files.isSymbolicLink(f.toPath()) } catch (e: Throwable) { false }

    private fun entryOf(f: File, filters: List<String>, applyFilters: Boolean, foldersOnly: Boolean, sub: String?): PickerEntry? {
        return try {
            val name = f.name
            if (f.isDirectory) {
                PickerEntry(f, name, PickerEntry.Kind.FOLDER, 0L, f.lastModified(), "", sub)
            } else {
                if (foldersOnly) return null
                if (applyFilters && !matches(name, filters)) return null
                if (!f.isFile) return null
                PickerEntry(f, name, PickerEntry.Kind.FILE, f.length(), f.lastModified(), MimeTypes.forName(name), sub)
            }
        } catch (e: Exception) {
            null
        }
    }

    fun sorted(list: MutableList<PickerEntry>, sort: PickerSort): List<PickerEntry> {
        val byName = Comparator<PickerEntry> { a, b -> naturalCompare(a.name, b.name) }
        val inner: Comparator<PickerEntry> = when (sort) {
            PickerSort.NAME -> byName
            PickerSort.DATE -> Comparator<PickerEntry> { a, b -> b.modified.compareTo(a.modified) }.thenComparing(byName)
            PickerSort.SIZE -> Comparator<PickerEntry> { a, b -> b.size.compareTo(a.size) }.thenComparing(byName)
            PickerSort.TYPE -> Comparator<PickerEntry> { a, b -> a.extension.compareTo(b.extension) }.thenComparing(byName)
        }
        // folders first; folders are never sorted by size / type (they have none), so they use the name order
        val cmp = Comparator<PickerEntry> { a, b ->
            when {
                a.isDir && !b.isDir -> -1
                !a.isDir && b.isDir -> 1
                a.isDir && b.isDir -> if (sort == PickerSort.DATE) inner.compare(a, b) else byName.compare(a, b)
                else -> inner.compare(a, b)
            }
        }
        list.sortWith(cmp)
        return list
    }

    /** "file2" before "file10": digit runs compare as numbers, the rest ignores case. */
    fun naturalCompare(a: String, b: String): Int {
        var i = 0
        var j = 0
        while (i < a.length && j < b.length) {
            val ca = a[i]
            val cb = b[j]
            if (ca.isDigit() && cb.isDigit()) {
                var ei = i
                while (ei < a.length && a[ei].isDigit()) ei++
                var ej = j
                while (ej < b.length && b[ej].isDigit()) ej++
                val na = a.substring(i, ei).trimStart('0')
                val nb = b.substring(j, ej).trimStart('0')
                if (na.length != nb.length) return na.length - nb.length
                val c = na.compareTo(nb)
                if (c != 0) return c
                i = ei
                j = ej
            } else {
                val c = ca.lowercaseChar().compareTo(cb.lowercaseChar())
                if (c != 0) return c
                i++
                j++
            }
        }
        return (a.length - i) - (b.length - j)
    }
}
