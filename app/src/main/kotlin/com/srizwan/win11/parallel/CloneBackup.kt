package com.srizwan.win11.parallel

import android.content.Context
import android.os.Environment
import org.json.JSONObject
import top.niunaijun.blackbox.BlackBoxCore
import top.niunaijun.blackbox.core.env.BEnvironment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

/**
 * Part 30: backup and restore of the data of one clone.
 *
 * A backup is one zip file (`*.rzbak`) with a `meta.json` and three folders that mirror the clone's data:
 * `i/` = internal data, `d/` = device-encrypted data, `e/` = Android/data on the virtual storage.
 * Left out on purpose: `cache`, `code_cache` (can be rebuilt) and `lib` (native libraries belong to the
 * installed APK, a restored old copy could be wrong). The APK itself is not saved, so the app must be
 * installed in the target space before a restore.
 */
object CloneBackup {

    const val EXT = ".rzbak"
    private const val META = "meta.json"
    private val SKIP = setOf("cache", "code_cache")

    data class Info(
        val file: File,
        val packageName: String,
        val label: String,
        val userId: Int,
        val versionName: String,
        val createdAt: Long,
        val size: Long
    )

    private class Root(val key: String, val dir: File, val keepLib: Boolean)

    private fun roots(pkg: String, userId: Int) = listOf(
        Root("i", BEnvironment.getDataDir(pkg, userId), true),
        Root("d", BEnvironment.getDeDataDir(pkg, userId), false),
        Root("e", BEnvironment.getExternalDataDir(pkg, userId), false)
    )

    /** Where new backups go: /sdcard/RizwanS2/Backups when writable, otherwise the app's own external folder. */
    fun primaryDir(ctx: Context): File {
        try {
            val d = File(Environment.getExternalStorageDirectory(), "RizwanS2/Backups")
            if ((d.isDirectory || d.mkdirs()) && d.canWrite()) return d
        } catch (_: Throwable) { }
        val f = ctx.getExternalFilesDir("backups") ?: File(ctx.filesDir, "backups")
        f.mkdirs()
        return f
    }

    private fun searchDirs(ctx: Context): List<File> {
        val out = ArrayList<File>()
        out += File(Environment.getExternalStorageDirectory(), "RizwanS2/Backups")
        ctx.getExternalFilesDir("backups")?.let { out += it }
        out += File(ctx.filesDir, "backups")
        return out.distinctBy { it.absolutePath }
    }

    private fun isLink(f: File): Boolean = try {
        java.nio.file.Files.isSymbolicLink(f.toPath())
    } catch (_: Throwable) {
        false
    }

    /** Every regular file below [root] that should be saved, as (file, path relative to root). */
    private fun collect(root: File): List<Pair<File, String>> {
        val out = ArrayList<Pair<File, String>>()
        fun walk(dir: File, rel: String) {
            val kids = dir.listFiles() ?: return
            for (k in kids) {
                if (isLink(k)) continue
                val r = if (rel.isEmpty()) k.name else rel + "/" + k.name
                if (rel.isEmpty() && (k.name in SKIP || k.name == "lib")) continue
                if (k.isDirectory) walk(k, r) else if (k.isFile) out += k to r
            }
        }
        if (root.isDirectory) walk(root, "")
        return out
    }

    private fun versionOf(pkg: String, userId: Int): Pair<String, Long> = try {
        val pi = BlackBoxCore.getBPackageManager().getPackageInfo(pkg, 0, userId)
        @Suppress("DEPRECATION")
        (pi?.versionName ?: "?") to (pi?.versionCode?.toLong() ?: 0L)
    } catch (_: Throwable) {
        "?" to 0L
    }

    /** Creates a backup. Returns the file, or throws with a readable message. [progress] gets (done, total) files. */
    fun backup(ctx: Context, pkg: String, userId: Int, label: String, progress: (Int, Int) -> Unit): File {
        val rs = roots(pkg, userId)
        val files = rs.map { r -> r to collect(r.dir) }
        val total = files.sumOf { it.second.size }
        if (total == 0) throw IllegalStateException("এই ক্লোনে এখনো কোনো ডেটা নেই")
        val bytes = files.sumOf { (_, l) -> l.sumOf { it.first.length() } }
        val dir = primaryDir(ctx)
        if (dir.usableSpace < bytes + 8L * 1024 * 1024) throw IllegalStateException("ফোনে জায়গা কম (লাগবে প্রায় ${bytes / 1048576} MB)")
        val stamp = SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US).format(Date())
        val out = File(dir, "${pkg}_space${userId + 1}_$stamp$EXT")
        val part = File(dir, out.name + ".part")
        val (vName, vCode) = versionOf(pkg, userId)
        var done = 0
        try {
            ZipOutputStream(FileOutputStream(part).buffered()).use { zip ->
                val meta = JSONObject()
                    .put("app", "RizwanS2").put("format", 1)
                    .put("package", pkg).put("label", label).put("userId", userId)
                    .put("versionName", vName).put("versionCode", vCode)
                    .put("createdAt", System.currentTimeMillis())
                zip.putNextEntry(ZipEntry(META))
                zip.write(meta.toString().toByteArray(Charsets.UTF_8))
                zip.closeEntry()
                val buf = ByteArray(64 * 1024)
                for ((root, list) in files) {
                    for ((f, rel) in list) {
                        val e = ZipEntry(root.key + "/" + rel)
                        e.time = f.lastModified()
                        zip.putNextEntry(e)
                        try {
                            FileInputStream(f).use { ins ->
                                while (true) {
                                    val n = ins.read(buf)
                                    if (n < 0) break
                                    zip.write(buf, 0, n)
                                }
                            }
                        } catch (_: java.io.FileNotFoundException) {
                            // a file that vanished while saving is simply left out
                        }
                        zip.closeEntry()
                        done++
                        if (done % 20 == 0 || done == total) progress(done, total)
                    }
                }
            }
            if (!part.renameTo(out)) throw IllegalStateException("ব্যাকআপ ফাইল সেভ করা যায়নি")
        } catch (t: Throwable) {
            part.delete()
            out.delete()
            throw t
        }
        return out
    }

    private fun readInfo(f: File): Info? = try {
        ZipFile(f).use { z ->
            val e = z.getEntry(META) ?: return null
            val j = JSONObject(z.getInputStream(e).bufferedReader(Charsets.UTF_8).readText())
            if (j.optString("app") != "RizwanS2") return null
            Info(
                f, j.getString("package"), j.optString("label", j.getString("package")),
                j.optInt("userId", 0), j.optString("versionName", "?"), j.optLong("createdAt", f.lastModified()), f.length()
            )
        }
    } catch (_: Throwable) {
        null
    }

    /** All backups of [pkg] (any space), newest first. */
    fun list(ctx: Context, pkg: String): List<Info> =
        searchDirs(ctx)
            .flatMap { d -> d.listFiles { f -> f.isFile && f.name.startsWith(pkg + "_") && f.name.endsWith(EXT) }?.toList() ?: emptyList() }
            .mapNotNull { readInfo(it) }
            .filter { it.packageName == pkg }
            .sortedByDescending { it.createdAt }

    fun delete(info: Info): Boolean = info.file.delete()

    /**
     * Puts the backup into space [userId]. The clone must be stopped first (the caller does that).
     * The data is first unpacked beside the real folders; only when that worked completely the old data is replaced,
     * so a failure (full disk, damaged file) leaves the current data untouched. Returns null on success, else a message.
     */
    fun restore(info: Info, pkg: String, userId: Int, progress: (Int, Int) -> Unit): String? {
        if (info.packageName != pkg) return "এই ব্যাকআপ অন্য অ্যাপের"
        val rs = roots(pkg, userId).associateBy { it.key }
        val stages = HashMap<String, File>()
        try {
            ZipFile(info.file).use { z ->
                val entries = z.entries().toList().filter { !it.isDirectory && it.name != META }
                val bytes = entries.sumOf { maxOf(it.size, 0L) }
                val probe = BEnvironment.getUserDir(userId).apply { mkdirs() }
                if (probe.usableSpace < bytes + 8L * 1024 * 1024) return "ফোনে জায়গা কম (লাগবে প্রায় ${bytes / 1048576} MB)"
                for (r in rs.values) {
                    val st = File(r.dir.parentFile, r.dir.name + ".rzstage")
                    st.deleteRecursively()
                    stages[r.key] = st
                }
                var done = 0
                val buf = ByteArray(64 * 1024)
                for (e in entries) {
                    val slash = e.name.indexOf('/')
                    if (slash < 1) continue
                    val st = stages[e.name.substring(0, slash)] ?: continue
                    val target = File(st, e.name.substring(slash + 1))
                    // zip-slip guard: the file must stay inside its stage folder
                    if (!target.canonicalPath.startsWith(st.canonicalPath + File.separator)) return "ব্যাকআপ ফাইলটি নিরাপদ নয়"
                    target.parentFile?.mkdirs()
                    z.getInputStream(e).use { ins ->
                        FileOutputStream(target).use { os ->
                            while (true) {
                                val n = ins.read(buf)
                                if (n < 0) break
                                os.write(buf, 0, n)
                            }
                        }
                    }
                    if (e.time > 0) target.setLastModified(e.time)
                    done++
                    if (done % 20 == 0 || done == entries.size) progress(done, entries.size)
                }
            }
            // swap: remove the old data (but not lib), move the unpacked data in
            for (r in rs.values) {
                val st = stages[r.key] ?: continue
                r.dir.mkdirs()
                r.dir.listFiles()?.forEach { k ->
                    if (r.keepLib && k.name == "lib") return@forEach
                    if (isLink(k)) k.delete() else k.deleteRecursively()
                }
                st.listFiles()?.forEach { k ->
                    val dest = File(r.dir, k.name)
                    if (!k.renameTo(dest)) {
                        k.copyRecursively(dest, overwrite = true)
                        k.deleteRecursively()
                    }
                }
                st.deleteRecursively()
            }
            return null
        } catch (t: Throwable) {
            return "রিস্টোর হয়নি: ${t.message ?: t.javaClass.simpleName}"
        } finally {
            stages.values.forEach { it.deleteRecursively() }
        }
    }
}
