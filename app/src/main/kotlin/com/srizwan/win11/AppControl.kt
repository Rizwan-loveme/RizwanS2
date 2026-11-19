package com.srizwan.win11

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build

// =====================================================================
// PER-APP CONTROLS: "Hide app" and "Black box (default opener)".
//
// They sit next to the pop-up notification switch of every app in
// Notifications > Apps (NotificationSettingsActivity). That screen is also
// opened by a long-press on the device name in the Start menu footer.
//
//  - Hide app: the same hidden list the Start menu already uses ("start_menu" / "hidden",
//    one "package/class" key per line). Hiding by package hides every launcher entry of the
//    app and removes it from Pinned (like the long-press "Hide app"); the app then lives
//    under "Hidden apps" in All apps, where "Unhide app" brings it back.
//    [AppRepository.reloadPrefs] re-reads the list when Start opens.
//  - Black box (default opener): when on, tapping the app in Start (Pinned, Recent, All apps,
//    search) opens it in the BlackBox virtual space (see ParallelApps.kt) instead of the real
//    app. The copy is made the first time. Stored in "app_control" / "blackbox_default".
// =====================================================================

object AppControl {

    private const val FILE_MENU = "start_menu"
    private const val KEY_HIDDEN = "hidden"
    private const val KEY_PINNED = "pinned"
    private const val FILE_CTRL = "app_control"
    private const val KEY_BB = "blackbox_default"

    // ── Black box (default opener) ──

    private fun bbSet(ctx: Context): Set<String> =
        ctx.getSharedPreferences(FILE_CTRL, Context.MODE_PRIVATE).getStringSet(KEY_BB, emptySet()) ?: emptySet()

    fun isBlackBoxDefault(ctx: Context, pkg: String): Boolean = pkg in bbSet(ctx)

    fun setBlackBoxDefault(ctx: Context, pkg: String, on: Boolean) {
        // getStringSet returns a set that must not be changed in place: always save a copy.
        val next = HashSet(bbSet(ctx))
        if (on) next.add(pkg) else next.remove(pkg)
        ctx.getSharedPreferences(FILE_CTRL, Context.MODE_PRIVATE).edit().putStringSet(KEY_BB, next).apply()
    }

    // ── Hide app ──

    private fun lines(ctx: Context, key: String): List<String> =
        ctx.getSharedPreferences(FILE_MENU, Context.MODE_PRIVATE).getString(key, null)
            ?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()

    /** true when at least one launcher entry of [pkg] is in the Start menu's hidden list. */
    fun isHidden(ctx: Context, pkg: String): Boolean {
        val prefix = "$pkg/"
        return lines(ctx, KEY_HIDDEN).any { it.startsWith(prefix) }
    }

    @Suppress("DEPRECATION")
    private fun launcherKeys(ctx: Context, pkg: String): List<String> = try {
        val i = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER).setPackage(pkg)
        val pm = ctx.packageManager
        val res = if (Build.VERSION.SDK_INT >= 33)
            pm.queryIntentActivities(i, PackageManager.ResolveInfoFlags.of(0L))
        else pm.queryIntentActivities(i, 0)
        res.mapNotNull { r -> r.activityInfo?.let { "${it.packageName}/${it.name}" } }
    } catch (e: Throwable) { emptyList() }

    /** Hides / unhides every launcher entry of [pkg]. Hiding also removes it from Pinned. */
    fun setHidden(ctx: Context, pkg: String, hidden: Boolean) {
        val prefix = "$pkg/"
        val sp = ctx.getSharedPreferences(FILE_MENU, Context.MODE_PRIVATE)
        val hid = LinkedHashSet(lines(ctx, KEY_HIDDEN))
        val e = sp.edit()
        if (hidden) {
            hid.addAll(launcherKeys(ctx, pkg))
            val pinned = lines(ctx, KEY_PINNED).filterNot { it.startsWith(prefix) }
            e.putString(KEY_PINNED, pinned.joinToString("\n"))
        } else {
            hid.removeAll { it.startsWith(prefix) }
        }
        e.putString(KEY_HIDDEN, hid.joinToString("\n")).apply()
    }
}
