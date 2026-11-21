package com.srizwan.win11.parallel

import android.content.Context
import android.content.pm.ApplicationInfo
import android.graphics.drawable.Drawable
import android.net.Uri
import top.niunaijun.blackbox.BlackBoxCore
import top.niunaijun.blackbox.core.GmsCore
import top.niunaijun.blackbox.utils.AbiUtils
import top.niunaijun.blackbox.utils.SpaceLimit
import top.niunaijun.blackbox.utils.bundle.BundleInstaller
import top.niunaijun.blackbox.utils.bundle.IndependentCopy
import java.io.File
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/** A cloned app living inside the virtual space [userId]. */
/**
 * [independent] = the clone has its own copy of the APK files (survives update/removal of the original);
 * false = it points at the phone's files and follows updates.
 */
data class CloneItem(
    val label: String,
    val icon: Drawable?,
    val packageName: String,
    val userId: Int,
    val independent: Boolean = false,
    /** The same app is cloned in more than one space. */
    val duplicate: Boolean = false
) {
    /** The name shown in the list: the app name, plus "(স্পেস N)" when the app is in several spaces. */
    val title: String get() = if (duplicate) "$label (স্পেস ${userId + 1})" else label
}

/** An app installed on the phone that can be cloned. */
data class DeviceApp(val label: String, val icon: Drawable?, val packageName: String)

/** Thin wrapper around BlackBoxCore. Every call is safe to use from a background thread. */
object Engine {
    /** What a new install starts with; the real limit is [maxSpaces]. */
    const val MAX_SPACES = SpaceLimit.DEFAULT_MAX

    /** One background thread for all engine work (lives longer than any Activity). */
    val io = Executors.newSingleThreadExecutor()

    private val core: BlackBoxCore get() = BlackBoxCore.get()

    private fun labelOf(ai: ApplicationInfo): String = try {
        BlackBoxCore.getPackageManager().getApplicationLabel(ai).toString()
    } catch (e: Throwable) {
        ai.packageName ?: "?"
    }

    private fun iconOf(ai: ApplicationInfo): Drawable? = try {
        BlackBoxCore.getPackageManager().getApplicationIcon(ai)
    } catch (e: Throwable) {
        null
    }

    fun onReady(callback: () -> Unit) {
        try {
            core.addServiceAvailableCallback(Runnable { callback() })
        } catch (e: Throwable) {
            // refresh() is also called directly, so a missing callback is not fatal
        }
    }

    fun listClones(): List<CloneItem> {
        val out = ArrayList<CloneItem>()
        val users = try { core.users } catch (e: Throwable) { null } ?: return out
        for (u in users) {
            val apps = try { core.getInstalledApplications(0, u.id) } catch (e: Throwable) { null } ?: continue
            for (ai in apps) {
                val pkg = ai.packageName ?: continue
                // Google Play Services / Play Store / GSF / ConfigUpdater / etc. get
                // auto-installed into a space as background support for the app the
                // user actually cloned there (see clone()). They are real, needed
                // packages, but they are not something the user asked to clone, so
                // don't show them as their own entries in the clone list.
                if (GmsCore.isGoogleAppOrService(pkg)) continue
                out.add(CloneItem(labelOf(ai), iconOf(ai), pkg, u.id, IndependentCopy.isIndependent(ai.sourceDir)))
            }
        }
        val dup = SpaceLimit.duplicates(out.map { it.packageName })
        return if (dup.isEmpty()) out else out.map { if (it.packageName in dup) it.copy(duplicate = true) else it }
    }

    fun deviceApps(): List<DeviceApp> {
        val pm = BlackBoxCore.getPackageManager()
        val host = BlackBoxCore.getHostPkg()
        val out = ArrayList<DeviceApp>()
        for (ai in pm.getInstalledApplications(0)) {
            val pkg = ai.packageName ?: continue
            if ((ai.flags and ApplicationInfo.FLAG_SYSTEM) != 0) continue
            if (pkg == host) continue
            if (ai.sourceDir == null) continue
            try {
                if (!AbiUtils.isSupport(ai)) continue
                if (core.isBlackBoxApp(pkg)) continue
            } catch (e: Throwable) {
                continue
            }
            out.add(DeviceApp(labelOf(ai), iconOf(ai), pkg))
        }
        out.sortBy { it.label.lowercase() }
        return out
    }

    /**
     * The first space that does not hold [pkg] yet, or -1 when all [maxSpaces] have it.
     * NOTE: core.isInstalled() falls back to the HOST package manager when the engine
     * service is not ready, and then answers "true" for every space (=> false "max 10"
     * error). So we ask the engine's own per-space app list instead.
     */
    fun freeSpaceFor(pkg: String): Int {
        val used = HashSet<Int>()
        for (i in 0 until maxSpaces) {
            val has = try {
                core.getInstalledApplications(0, i)?.any { it.packageName == pkg } ?: false
            } catch (e: Throwable) { false }
            if (has) used += i
        }
        return SpaceLimit.firstFree(used, maxSpaces)
    }

    /**
     * Best-effort: clone (fake) Google Play Services into [space] too.
     * Apps like Facebook Lite fall back to broken/legacy code paths when
     * they can't find com.google.android.gms (e.g. a PendingIntent created
     * without FLAG_IMMUTABLE/FLAG_MUTABLE from their Firebase InstanceID
     * fallback, which throws IllegalArgumentException on Android 12+ and
     * crashes the whole cloned app). This only works if the HOST device
     * itself actually has real Google Play Services installed — if not,
     * isSupportGms() is false and this is a no-op.
     */
    private fun installGmsBestEffort(space: Int) {
        try {
            if (core.isSupportGms() && !core.isInstallGms(space)) {
                core.installGms(space)
            }
        } catch (e: Throwable) {
            // Non-fatal: the app itself was already installed.
        }
    }

    private val settings by lazy { BlackBoxCore.getContext().getSharedPreferences("parallel_settings", Context.MODE_PRIVATE) }

    /**
     * Independent copy mode for new clones of phone apps: the APK files are copied into the box, so the
     * clone keeps working when the original is updated or removed. Needs more storage. Default off.
     */
    /**
     * How many spaces one app can be cloned into (1..[SpaceLimit.HARD_MAX], default [MAX_SPACES]).
     * Lowering it never removes clones that already exist: they stay listed and work, it only stops
     * new clones beyond the limit.
     */
    var maxSpaces: Int
        get() = SpaceLimit.clamp(settings.getInt("max_spaces", MAX_SPACES))
        set(value) { settings.edit().putInt("max_spaces", SpaceLimit.clamp(value)).apply() }

    var independentCopy: Boolean
        get() = settings.getBoolean("independent_copy", false)
        set(value) { settings.edit().putBoolean("independent_copy", value).apply() }

    /** Clones [pkg] into the first free space. Returns null on success, else an error text. */
    fun clone(pkg: String, independent: Boolean = independentCopy): String? {
        val space = freeSpaceFor(pkg)
        if (space < 0) return "সর্বোচ্চ $maxSpaces টি কপি তৈরি করা যায়"
        return try {
            val r = core.installPackageAsUser(pkg, space, independent)
            if (r != null && r.success) {
                installGmsBestEffort(space)
                null
            } else (r?.msg ?: "ইনস্টল ব্যর্থ হয়েছে")
        } catch (e: Throwable) {
            e.message ?: "ইনস্টল ব্যর্থ হয়েছে"
        }
    }

    private val firstFreeSpace = BundleInstaller.SpaceChooser { pkg -> freeSpaceFor(pkg) }

    /**
     * "Install from file" for a file on storage (.apk / .apks / .xapk / .apkm). The file is only read.
     * Blocking: call from [io]. Never throws.
     */
    fun installFile(file: File, listener: BundleInstaller.Listener): BundleInstaller.Result {
        awaitReady()
        val r = BundleInstaller.install(file, firstFreeSpace, listener)
        if (r.success && r.userId >= 0) installGmsBestEffort(r.userId)
        return r
    }

    /** Same for a content:// uri (copied to a temp file first). [size] may be 0 when unknown. */
    fun installUri(context: Context, uri: Uri, size: Long, listener: BundleInstaller.Listener): BundleInstaller.Result {
        awaitReady()
        val r = BundleInstaller.install(context, uri, size, firstFreeSpace, listener)
        if (r.success && r.userId >= 0) installGmsBestEffort(r.userId)
        return r
    }

    /**
     * Deletes temp files that an install left behind when the app was killed in the middle of it
     * (unpacked bundle folders, copies of chosen files). Blocking: call from [io]. Never throws.
     */
    fun cleanTemp() {
        try {
            awaitReady()
            BundleInstaller.cleanLeftovers()
        } catch (e: Throwable) {
            // only a bonus cleanup
        }
    }

    /** The label of an app that is installed in a space, or the package name. */
    fun labelOfInstalled(pkg: String, userId: Int): String = try {
        val ai = core.getInstalledApplications(0, userId)?.firstOrNull { it.packageName == pkg }
        if (ai != null) labelOf(ai) else pkg
    } catch (e: Throwable) {
        pkg
    }

    /** Blocks (max [timeoutMs]) until the engine services are available. Call from a background thread. */
    fun awaitReady(timeoutMs: Long = 6000L) {
        val latch = CountDownLatch(1)
        try {
            // runs the callback at once when the engine is already up
            core.addServiceAvailableCallback(Runnable { latch.countDown() })
        } catch (e: Throwable) {
            return
        }
        try { latch.await(timeoutMs, TimeUnit.MILLISECONDS) } catch (_: InterruptedException) { }
    }

    /** The space that already holds a copy of [pkg], or -1. */
    fun spaceOf(pkg: String): Int {
        // all spaces that exist, also those above a lowered limit
        val ids = try { core.users?.map { it.id }?.sorted() } catch (e: Throwable) { null } ?: (0 until maxSpaces).toList()
        for (i in ids) {
            val has = try {
                core.getInstalledApplications(0, i)?.any { it.packageName == pkg } ?: false
            } catch (e: Throwable) { false }
            if (has) return i
        }
        return -1
    }

    /**
     * "Open in black box (parallel)": starts the copy of [pkg] that lives in the virtual space; when there
     * is none yet it is cloned first. Returns null on success, else an error text. Background thread only.
     */
    fun openOrClone(pkg: String): String? {
        awaitReady()
        var space = spaceOf(pkg)
        if (space < 0) {
            val err = clone(pkg)
            if (err != null) return err
            space = spaceOf(pkg)
        }
        if (space < 0) return "Copy was not created"
        return if (launch(pkg, space)) null else "Can't start the app"
    }

    fun launch(pkg: String, userId: Int): Boolean = try {
        core.launchApk(pkg, userId)
    } catch (e: Throwable) {
        false
    }

    /** Part 26: true while the clone has a live process (also when it only runs in the background). */
    fun isRunning(pkg: String, userId: Int): Boolean = try {
        core.isPackageRunning(pkg, userId)
    } catch (e: Throwable) {
        false
    }

    /** Part 26: force-stops the clone (kills every process of it). Data is kept. */
    fun forceStop(pkg: String, userId: Int) {
        try { core.killApp(pkg, userId) } catch (e: Throwable) { }
    }

    fun clearData(pkg: String, userId: Int) {
        try { core.clearPackage(pkg, userId) } catch (e: Throwable) { }
    }

    fun remove(pkg: String, userId: Int) {
        try { core.uninstallPackageAsUser(pkg, userId) } catch (e: Throwable) { }
        trimEmptySpaces()
    }

    /** Drops trailing spaces that no longer hold any app. */
    private fun trimEmptySpaces() {
        try {
            while (true) {
                val users = core.users
                if (users.isNullOrEmpty()) return
                val last = users.last().id
                val apps = core.getInstalledApplications(0, last)
                // Ignore the auto-installed Google support packages here too, otherwise
                // a space whose real app was removed never gets trimmed because it
                // still "contains" GMS/Play Store/etc.
                val realApps = apps?.filter { !GmsCore.isGoogleAppOrService(it.packageName ?: "") }
                if (!realApps.isNullOrEmpty()) return
                core.deleteUser(last)
            }
        } catch (e: Throwable) {
            // best effort
        }
    }
}
