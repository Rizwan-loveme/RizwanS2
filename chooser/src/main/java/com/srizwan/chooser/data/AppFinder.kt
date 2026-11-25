package com.srizwan.chooser.data

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale

/**
 * Finds the apps that can open or receive something, with `PackageManager.queryIntentActivities`: the list the system chooser would
 * build, but under our control (the sheets of steps 3 and 6 show it, step 4 starts the chosen [Target] with an explicit intent).
 *
 *  - [queryView] / [findView]: apps that can open a file (`ACTION_VIEW` with a uri and a MIME type).
 *  - [querySend] / [findSend]: apps that can receive a file, files or text (`ACTION_SEND` / `ACTION_SEND_MULTIPLE`).
 *
 * The `query*` functions block (package manager calls plus loading the icons): call them from a background thread, or use the
 * suspending `find*` twins, which switch to `Dispatchers.IO` themselves.
 *
 * Only activities that declare `CATEGORY_DEFAULT` are matched (what an implicit intent needs), disabled activities are dropped, and
 * so are activities that are not exported (unless they are ours). Each activity appears once; two entries of one app with the
 * same name collapse into one. The result is sorted: the apps chosen before for this kind and MIME family first (most recent
 * first, see [ChooserPrefs]), then the rest by name.
 *
 * Package visibility (API 30+): :app declares QUERY_ALL_PACKAGES, so every app stays visible at the targetSdk 37 of part 8 without a `<queries>` block. If that permission is
 * ever removed, the `:app` manifest needs `<queries>` entries for `VIEW` and `SEND`, or this list comes back (nearly) empty.
 */
object AppFinder {

    private const val TAG = "AppFinder"

    /**
     * The package manager could not answer (step 12). The plain `query*` / `find*` functions hide this and return an empty list, which the
     * sheets would show as "no app can open this"; the `*Strict` twins throw it instead, so a sheet can tell "none" from "failed" and
     * hand over to the system chooser.
     */
    class QueryFailedException(cause: Throwable) : Exception("the app list could not be read", cause)

    /** Our own receive screen (step 10) and its aliases: never offered in our own lists (it would only open a sheet inside a sheet). */
    private const val RECEIVE_CLASS = "com.srizwan.chooser.receive.ReceiveActivity"

    /**
     * Never offered: the system's own choosers / resolvers (a chooser inside our chooser would only open another chooser, and that
     * is the screen this module exists to avoid). `com.transsion.resolver` is the "TranResolver" of Tecno / Infinix / itel phones.
     */
    private val BLOCKED_PACKAGES = setOf(
        "android",
        "com.android.intentresolver",
        "com.google.android.intentresolver",
        "com.transsion.resolver"
    )

    /**
     * A stand-in uri for "some file of this type": matching an `ACTION_VIEW` filter only looks at the scheme and the MIME type, never
     * at the provider, so the list can be built without touching a file. `content` is the scheme step 4 opens files with (FileProvider).
     */
    private val PROBE_URI: Uri = Uri.parse("content://com.srizwan.chooser.probe/file")

    // ── intents ─────────────────────────────────────────────────────────────

    /** The `ACTION_VIEW` intent used for matching: [uri] (or the stand-in) with [mime]. */
    fun viewIntent(uri: Uri?, mime: String?): Intent =
        Intent(Intent.ACTION_VIEW).setDataAndType(uri ?: PROBE_URI, mime ?: MimeTypes.ANY)

    /** The `ACTION_SEND` intent used for matching (one file or text), or `ACTION_SEND_MULTIPLE` for a [count] above one. */
    fun sendIntent(mime: String?, count: Int = 1): Intent =
        Intent(if (count > 1) Intent.ACTION_SEND_MULTIPLE else Intent.ACTION_SEND).setType(mime ?: MimeTypes.ANY)

    // ── blocking queries (background thread) ────────────────────────────────

    /** Apps that can open a file of type [mime] ([uri] when the exact uri matters; `null` = any file of that type). */
    fun queryView(context: Context, uri: Uri?, mime: String?, includeSelf: Boolean = true): List<Target> =
        try { queryViewStrict(context, uri, mime, includeSelf) } catch (e: QueryFailedException) { emptyList() }

    /** Like [queryView], but throws [QueryFailedException] when the package manager fails (an empty list then really means "none"). */
    fun queryViewStrict(context: Context, uri: Uri?, mime: String?, includeSelf: Boolean = true): List<Target> {
        val m = mime ?: MimeTypes.ANY
        return sorted(context, query(context, viewIntent(uri, m), includeSelf), ChooserKind.VIEW, m)
    }

    /** Apps that can open a file with this [fileName] (its type comes from the extension). */
    fun queryViewName(context: Context, fileName: String, includeSelf: Boolean = true): List<Target> =
        queryView(context, null, MimeTypes.forName(fileName), includeSelf)

    /** Apps that can receive [count] file(s) or text of type [mime] (`text/plain` for text). */
    fun querySend(context: Context, mime: String?, count: Int = 1, includeSelf: Boolean = true): List<Target> =
        try { querySendStrict(context, mime, count, includeSelf) } catch (e: QueryFailedException) { emptyList() }

    /** Like [querySend], but throws [QueryFailedException] when the package manager fails. */
    fun querySendStrict(context: Context, mime: String?, count: Int = 1, includeSelf: Boolean = true): List<Target> {
        val m = mime ?: MimeTypes.ANY
        val base = query(context, sendIntent(m, count), includeSelf)
        return sorted(context, withBluetooth(context, base, count), ChooserKind.SEND, m)
    }

    /**
     * Bluetooth in the Share sheet. The matching by intent filter (`queryIntentActivities`) did not return the system Bluetooth sender on
     * some phones even for pictures, videos and audio, so the sheet had no Bluetooth entry. When the normal query has none, the sender is
     * looked up directly: every installed package with "bluetooth" in its name (com.android.bluetooth, com.google.android.bluetooth ...)
     * is asked for its `BluetoothOppLauncherActivity` (the "Share via Bluetooth" screen), whatever its filters say. The entry is only added when
     * that activity is exported, not switched off, and the same package manager call can start it; it takes any file handed to it as a
     * stream. The outcome is written to the log (tag AppFinder) so a phone without it can be diagnosed.
     */
    @Suppress("DEPRECATION")
    private fun withBluetooth(context: Context, base: List<Target>, count: Int): List<Target> {
        if (base.any { isBluetooth(it.packageName) }) return base
        val pm = context.packageManager
        val found = ArrayList<Target>()
        try {
            val pkgs = LinkedHashSet<String>()
            pkgs.add("com.android.bluetooth")
            pkgs.add("com.google.android.bluetooth")
            for (pi in pm.getInstalledPackages(0)) if (isBluetooth(pi.packageName)) pkgs.add(pi.packageName)
            for (pkg in pkgs) {
                val info = try { pm.getPackageInfo(pkg, PackageManager.GET_ACTIVITIES) } catch (e: Exception) { null } ?: continue
                for (a in info.activities.orEmpty()) {
                    if (!a.name.endsWith("BluetoothOppLauncherActivity") && !a.name.endsWith("OppLauncherActivity")) continue
                    val component = ComponentName(pkg, a.name)
                    val ai = try { pm.getActivityInfo(component, 0) } catch (e: Exception) { null }
                    if (ai == null || !ai.enabled || !ai.exported || ai.permission != null) {
                        Log.i(TAG, "Bluetooth sender $component skipped (enabled=${ai?.enabled}, exported=${ai?.exported}, permission=${ai?.permission})")
                        continue
                    }
                    val loaded: CharSequence? = try { ai.loadLabel(pm) } catch (e: Exception) { null }
                    val label = loaded?.toString()?.trim().orEmpty().ifEmpty { "Bluetooth" }
                    val icon = try { ai.loadIcon(pm) } catch (e: Exception) { pm.defaultActivityIcon }
                    found.add(Target(label, component, icon, false))
                    Log.i(TAG, "Bluetooth sender added: $component")
                }
            }
            if (found.isEmpty()) Log.i(TAG, "no Bluetooth sender found in: $pkgs")
        } catch (e: Exception) {
            Log.w(TAG, "Bluetooth lookup failed", e)
        }
        return if (found.isEmpty()) base else base + found.first()
    }

    private fun isBluetooth(pkg: String): Boolean = pkg.contains("bluetooth", ignoreCase = true)

    /**
     * Is [component] still an app that can be started with an explicit `ACTION_VIEW` (installed, enabled, exported or ours, not a system
     * chooser)? One package manager call, no icons: the launcher (step 4) uses it to check a saved "Always" choice before using it.
     */
    @Suppress("DEPRECATION")
    fun canStartView(context: Context, component: ComponentName, mime: String?): Boolean {
        if (component.packageName in BLOCKED_PACKAGES) return false
        if (component.packageName == context.packageName && component.className.startsWith(RECEIVE_CLASS)) return false
        val intent = viewIntent(null, mime).setComponent(component)
        return try {
            val ri = if (Build.VERSION.SDK_INT >= 33) {
                context.packageManager.resolveActivity(intent, PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY.toLong()))
            } else {
                context.packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
            }
            val ai = ri?.activityInfo
            ai != null && ai.enabled && (ai.exported || ai.packageName == context.packageName)
        } catch (e: Exception) {
            Log.w(TAG, "canStartView failed for $component", e)
            false
        }
    }

    // ── suspending twins (safe to call from the main thread) ────────────────

    suspend fun findView(context: Context, uri: Uri?, mime: String?, includeSelf: Boolean = true): List<Target> =
        withContext(Dispatchers.IO) { queryView(context, uri, mime, includeSelf) }

    /** The sheets use this one: a failed query is an exception, not an empty list (step 12). */
    suspend fun findViewStrict(context: Context, uri: Uri?, mime: String?, includeSelf: Boolean = true): List<Target> =
        withContext(Dispatchers.IO) { queryViewStrict(context, uri, mime, includeSelf) }

    suspend fun findSendStrict(context: Context, mime: String?, count: Int = 1, includeSelf: Boolean = true): List<Target> =
        withContext(Dispatchers.IO) { querySendStrict(context, mime, count, includeSelf) }

    suspend fun findViewName(context: Context, fileName: String, includeSelf: Boolean = true): List<Target> =
        withContext(Dispatchers.IO) { queryViewName(context, fileName, includeSelf) }

    suspend fun findSend(context: Context, mime: String?, count: Int = 1, includeSelf: Boolean = true): List<Target> =
        withContext(Dispatchers.IO) { querySend(context, mime, count, includeSelf) }

    // ── the query itself ────────────────────────────────────────────────────

    /** Throws [QueryFailedException] when the package manager fails; the public functions decide what that means. */
    @Suppress("DEPRECATION")
    private fun query(context: Context, intent: Intent, includeSelf: Boolean): List<Target> {
        val pm = context.packageManager
        val found = try {
            if (Build.VERSION.SDK_INT >= 33) {
                pm.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY.toLong()))
            } else {
                pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
            }
        } catch (e: Exception) {
            Log.w(TAG, "queryIntentActivities failed for $intent", e)
            throw QueryFailedException(e)
        }

        val mine = context.packageName
        val myUid = context.applicationInfo.uid
        val seenComponents = HashSet<String>()
        val seenNames = HashSet<String>()
        val list = ArrayList<Target>()
        for (ri in found) {
            val ai = ri.activityInfo ?: continue
            val pkg = ai.packageName ?: continue
            if (pkg in BLOCKED_PACKAGES) continue
            val self = pkg == mine
            if (self && !includeSelf) continue
            if (self && isReceiver(ai)) continue
            if (!ai.enabled) continue
            if (!ai.exported && ai.applicationInfo?.uid != myUid) continue

            val component = ComponentName(pkg, ai.name)
            if (!seenComponents.add(component.flattenToString())) continue

            val loaded: CharSequence? = try { ri.loadLabel(pm) } catch (e: Exception) { null }
            val label = loaded?.toString()?.trim().orEmpty().ifEmpty { pkg }
            if (!seenNames.add(pkg + "|" + label)) continue

            val icon = try { ri.loadIcon(pm) } catch (e: Exception) { pm.defaultActivityIcon }
            list.add(Target(label, component, icon, self))
        }
        return list
    }

    /** The receive screen of step 10 or one of its aliases (an alias has its own name, the real class is in `targetActivity`). */
    private fun isReceiver(ai: android.content.pm.ActivityInfo): Boolean =
        ai.name.startsWith(RECEIVE_CLASS) || ai.targetActivity?.startsWith(RECEIVE_CLASS) == true

    /** The apps chosen before first (most recent first), then the others by name. */
    private fun sorted(context: Context, list: List<Target>, kind: ChooserKind, mime: String): List<Target> {
        val rank = HashMap<String, Int>()
        ChooserPrefs.recent(context, kind, mime).forEachIndexed { i, key -> rank[key] = i }
        return list.sortedWith(
            compareBy<Target>({ rank[it.key] ?: Int.MAX_VALUE }, { it.label.lowercase(Locale.ROOT) })
        )
    }
}
