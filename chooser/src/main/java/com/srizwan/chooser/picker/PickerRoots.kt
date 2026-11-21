package com.srizwan.chooser.picker

import android.content.Context
import android.os.Environment
import android.os.StatFs
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R
import java.io.File

/**
 * The places the picker starts from: the internal storage, removable cards / USB drives, and the usual folders on the internal storage
 * (Downloads, DCIM, Pictures, Movies, Music, Documents) when they exist. Blocking (it stats folders): call it off the main thread.
 */
object PickerRoots {

    /** The shared (internal) storage folder. */
    @Suppress("DEPRECATION")
    fun internal(): File = try {
        Environment.getExternalStorageDirectory()
    } catch (e: Exception) {
        File("/storage/emulated/0")
    }

    /** Storage roots: the internal storage first, then each removable volume the app can see. */
    fun storages(context: Context): List<PickerEntry> {
        val out = ArrayList<PickerEntry>()
        val internal = internal()
        out.add(root(internal, context.getString(R.string.ch_picker_internal)))
        val seen = HashSet<String>()
        seen.add(internal.absolutePath)
        var n = 0
        val dirs = try { ContextCompat.getExternalFilesDirs(context, null) } catch (e: Exception) { emptyArray<File?>() }
        for (d in dirs) {
            if (d == null) continue
            val p = d.absolutePath
            val cut = p.indexOf("/Android/data")
            if (cut <= 0) continue
            val rootPath = p.substring(0, cut)
            if (!seen.add(rootPath)) continue
            val f = File(rootPath)
            if (!f.exists()) continue
            n++
            out.add(root(f, context.getString(R.string.ch_picker_sd)))
        }
        // number the cards only when there is more than one
        if (n > 1) {
            var k = 0
            for (i in out.indices) {
                if (i == 0) continue
                k++
                val e = out[i]
                out[i] = PickerEntry(e.file, context.getString(R.string.ch_picker_sd_n, k), e.kind, e.size, e.modified, e.mime, e.sub, e.iconOverride)
            }
        }
        return out
    }

    /** The common folders of the internal storage that exist. */
    @Suppress("DEPRECATION")
    fun shortcuts(context: Context): List<PickerEntry> {
        val out = ArrayList<PickerEntry>()
        val wanted = listOf(
            Environment.DIRECTORY_DOWNLOADS to context.getString(R.string.ch_picker_downloads),
            Environment.DIRECTORY_DCIM to null,
            Environment.DIRECTORY_PICTURES to null,
            Environment.DIRECTORY_MOVIES to null,
            Environment.DIRECTORY_MUSIC to null,
            Environment.DIRECTORY_DOCUMENTS to null
        )
        for ((type, label) in wanted) {
            val f = try { Environment.getExternalStoragePublicDirectory(type) } catch (e: Exception) { null } ?: continue
            if (!f.isDirectory) continue
            out.add(PickerEntry(f, label ?: f.name, PickerEntry.Kind.FOLDER, 0L, f.lastModified(), ""))
        }
        return out
    }

    /** The root (of [storages]) that contains [dir], the deepest one when roots are nested; null when none does. */
    fun rootOf(dir: File, roots: List<PickerEntry>): PickerEntry? {
        val p = dir.absolutePath
        return roots
            .filter { p == it.path || p.startsWith(it.path.trimEnd('/') + "/") }
            .maxByOrNull { it.path.length }
    }

    private fun root(f: File, label: String): PickerEntry {
        val free = try { StatFs(f.absolutePath).availableBytes } catch (e: Exception) { -1L }
        return PickerEntry(f, label, PickerEntry.Kind.ROOT, free, 0L, "", null, R.drawable.ch_ic_storage)
    }
}
