package com.srizwan.win11

import android.app.Activity
import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast

// =====================================================================
// Built-in Shizuku manager = the :shizuku module (Shizuku v13.6.0 by RikkaApps, Apache-2.0; Shizuku-API MIT), see shizuku/README.md and NOTICE-Shizuku.md.
// Opened from: the Start menu (section "shizuku", hook 6B-2), the Home screen icon (6C) and the deep link rizwans2://shizuku (6D).
//
// :shizuku is in the build only with -PincludeShizuku=true (app/build.gradle.kts `shizukuIncluded`; off by default until step 8F). So this file names NO Shizuku class
// at compile time: the manager's screen is found by its class name at run time. With :shizuku out of the build, isAvailable() is false and open() does nothing but say so,
// and :app compiles and runs exactly as before. (The same reason Mika has its own stub in the "without Rizwan" build; Shizuku does not need a stub file.)
//
// Process and task (finding 9, shizuku/README.md): the manager's activities have no taskAffinity, no launchMode and no android:process, so they run in the launcher's own
// process and join the task of the activity that starts them. Called from MainActivity (every hook is a click or a deep link) this is a plain startActivity without
// FLAG_ACTIVITY_NEW_TASK: Back from Shizuku returns to the Win11 screen. FLAG_ACTIVITY_NEW_TASK is added only when the context is not an Activity (Android needs it then).
// The manager's MainActivity is not exported (4D-1), so only this app can start it, and it has no LAUNCHER filter, so no second "Shizuku" icon appears in the system launcher.
//
// Init (6E): initApplication(app) calls the patched object ShizukuApplication.onCreate(app) (a @JvmStatic fun) by name, once, from App.onCreate (launcher process only, after the
// "process start" log line, before the Seal block). It must run before any Shizuku receiver / screen of this process: the boot receiver needs ShizukuSettings and `application`
// (finding 13, shizuku/README.md). With :shizuku out of the build it finds no class and does nothing. It lives here and not in AppBase on purpose: the "without Rizwan" build
// replaces AppBase.kt by a stub, and Shizuku must keep its init there.
//
// Not here on purpose: the Start menu entry (6B-2), the Home icon (6C), the deep link (6D): they only call open() / isAvailable().
// =====================================================================

object ShizukuLauncher {

    private const val TAG = "Shizuku"

    /** Section name used by the shell (Start menu entry, Home screen icon, taskbar callback). The Start menu class is "builtin.shizuku". */
    const val SECTION = "shizuku"

    /** The name Shizuku is shown under (Start menu, Home screen, toasts). */
    const val NAME = "Shizuku"

    /** The manager's start screen, looked up by name (its package stays moe.shizuku.manager, the patch script only changes the host package strings and the resource prefix). */
    private const val MANAGER_ACTIVITY = "moe.shizuku.manager.MainActivity"

    /** The patched `object ShizukuApplication` of :shizuku (patch-upstream.py, part B): `@JvmStatic fun onCreate(app: Application)` is a static method of this class. */
    private const val MANAGER_APPLICATION = "moe.shizuku.manager.ShizukuApplication"

    /** Set after the first call: the init runs once per process (it only ever runs in the launcher process, see App.onCreate). */
    @Volatile
    private var initDone = false

    /** The manager's start screen class, or null when :shizuku is not in this build (or the class is gone). Never throws. */
    private fun managerClass(): Class<*>? =
        try {
            Class.forName(MANAGER_ACTIVITY)
        } catch (e: Throwable) {
            null
        }

    /**
     * True when the built-in manager is in this build: its class is there AND its activity is in the merged manifest of the installed app
     * (a class without a manifest entry would end in ActivityNotFoundException at the click). The Start menu entry and the Home icon are hidden when this is false.
     */
    fun isAvailable(ctx: Context): Boolean {
        val cls = managerClass() ?: return false
        return try {
            ctx.packageManager.getActivityInfo(ComponentName(ctx, cls), 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        } catch (e: Throwable) {
            false
        }
    }

    /**
     * Opens the Shizuku manager's start screen. Must be called on the main thread (every hook is a click or a deep link, so it is).
     * Returns false, with a short message, when Shizuku is not in this build or the start failed. Never throws.
     */
    fun open(ctx: Context): Boolean {
        val cls = managerClass()
        if (cls == null || !isAvailable(ctx)) {
            Toast.makeText(ctx, "$NAME is not included in this build", Toast.LENGTH_SHORT).show()
            return false
        }
        return try {
            val intent = Intent().setComponent(ComponentName(ctx, cls))
            if (ctx !is Activity) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ctx.startActivity(intent)
            AppLog.i(TAG, "Shizuku opened")
            true
        } catch (e: Throwable) {
            AppLog.e(TAG, "cannot open Shizuku", e)
            Toast.makeText(ctx, "$NAME error: ${e.message}", Toast.LENGTH_SHORT).show()
            false
        }
    }

    /**
     * Step 6E: runs upstream's `Application.onCreate` work for the built-in manager: `application = app`, `ShizukuSettings.initialize(app)` (device-protected storage) and
     * the locale. Called once from [App.onCreate], launcher process only, on the main thread, before any receiver / service / activity of the process runs.
     * Does nothing (returns false) when :shizuku is not in this build (no class), or when it already ran. Never throws: a failure (including an `Error` from the object's
     * `init`, e.g. a missing native library) is logged and the launcher goes on; the Shizuku screens then do not work, nothing else is affected.
     * Returns true only when the init ran through.
     */
    fun initApplication(app: Application): Boolean {
        if (initDone) return false
        val cls = try {
            Class.forName(MANAGER_APPLICATION)
        } catch (e: ClassNotFoundException) {
            return false // :shizuku is not in this build: nothing to start
        } catch (e: Throwable) {
            AppLog.e(TAG, "cannot load $MANAGER_APPLICATION", e)
            return false
        }
        return try {
            cls.getMethod("onCreate", Application::class.java).invoke(null, app)
            initDone = true
            AppLog.i(TAG, "Shizuku init done")
            true
        } catch (e: Throwable) {
            AppLog.e(TAG, "Shizuku init failed", e.cause ?: e)
            false
        }
    }
}
