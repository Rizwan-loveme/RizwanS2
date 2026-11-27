package com.srizwan.win11

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.bly.chaosapp.application.BLYApplication

// =====================================================================
// Clone App = the :cloneapp module (prebuilt AAR, package com.pengyou.cloneapp), see cloneapp/README.md and NOTICE-CloneApp.md.
//
// This file and App.kt are the ONLY places of :app that name a Clone App class. What it does:
//
//   1. Engine start-up. The Clone App's own Application (com.bly.chaosapp.application.BLYApplication) fills the engine's global state (CRuntime: context, process role,
//      ABI, hidden-API whitelist ...) in attachBaseContext and opens its databases in onCreate. :app's Application is [App] (a MikaApp, see AppBase.kt), so [App] cannot extend
//      BLYApplication; instead it creates one BLYApplication as a plain ContextWrapper around the real base context and calls the same two methods, at the same moments
//      (attach -> [attach], onCreate -> [create]). Nothing else of BLYApplication is used.
//   2. Processes. The Clone App runs its engine in its own processes. They are renamed by cloneapp/tools/patch-processes.py so they cannot clash with BlackBox (:Bcore):
//         Clone App :chs, :cp0 ... :cp49      BlackBox :black, :p0 ... :p49
//      In a Clone App process [App] starts ONLY this engine (no BlackBox, no J2ME); in the launcher process both engines run side by side (the Clone App there is the
//      "manager" role: its screens and databases, no app hooking, that happens in the :cp processes).
//   3. Native libraries. The engine needs libchaos.so (and the ad SDK libraries). If they are not in the APK ([nativeReady] = false, see cloneapp/README.md "Native libraries"),
//      the engine is NOT started (a missing library would otherwise crash every process start) and [open] tells the user instead of opening a half-working screen.
//   4. The one entry: Settings (the user menu of the Start menu, Win11Shell.showUserMenu) -> "Clone App" -> [open]. There is deliberately no Start menu entry, Home icon or deep link.
//
// A failure anywhere here is only logged: it must never stop the launcher.
// =====================================================================

object CloneAppEngine {

    private const val TAG = "CloneApp"

    /** The Clone App's launcher activity (its MAIN/LAUNCHER filter was removed from the merged manifest, so it is started with an explicit intent). */
    private const val ENTRY = "com.pengyou.cloneapp.SplashActivity"
    private const val ENTRY_FALLBACK = "com.pengyou.cloneapp.MainActivity"

    /** Text of the Settings menu item. */
    const val NAME = "Clone App"

    @Volatile private var bly: BLYApplication? = null
    @Volatile private var attached = false
    @Volatile private var created = false
    @Volatile private var nativeOk: Boolean? = null

    /** True in a process that belongs to the Clone App engine (host service ":chs" or a cloned-app slot ":cp0" .. ":cp49"); BlackBox must stay out of it. */
    @JvmStatic
    fun isCloneProcess(pkg: String, processName: String?): Boolean {
        if (processName == null) return false
        if (processName == "$pkg:chs") return true
        val prefix = "$pkg:cp"
        if (!processName.startsWith(prefix)) return false
        val rest = processName.substring(prefix.length)
        return rest.isNotEmpty() && rest.all { it.isDigit() }
    }

    /** True when the engine's main native library can be loaded (it is not in the APK until the lib/ folder of the original Clone App is added with cloneapp/tools/add-jni.py). */
    @JvmStatic
    fun nativeReady(): Boolean {
        nativeOk?.let { return it }
        val ok = try {
            System.loadLibrary("chaos")
            true
        } catch (_: Throwable) {
            false
        }
        nativeOk = ok
        return ok
    }

    /** [App.attachBaseContext]: first half of the engine start-up, every Clone App process and the launcher process. */
    @JvmStatic
    @Synchronized
    fun attach(app: Application, base: Context) {
        if (attached) return
        if (!nativeReady()) {
            Log.w(TAG, "engine not started: libchaos.so is not in the APK (see cloneapp/README.md, Native libraries)")
            return
        }
        try {
            val b = BLYApplication()
            b.attachBaseContext(base)
            bly = b
            attached = true
        } catch (e: Throwable) {
            Log.e(TAG, "engine attach failed", e)
        }
    }

    /** [App.onCreate]: second half (databases, managers). Only after a successful [attach]. */
    @JvmStatic
    @Synchronized
    fun create() {
        if (created || !attached) return
        try {
            bly?.onCreate()
            created = true
        } catch (e: Throwable) {
            Log.e(TAG, "engine create failed", e)
        }
    }

    /** True when the engine is started in this process, so the Clone App screens can be opened. */
    @JvmStatic
    fun isRunning(): Boolean = attached && created

    /** Settings -> "Clone App": opens the Clone App's own screen (its own task), or says why it cannot. Main thread. */
    @JvmStatic
    fun open(ctx: Context) {
        if (!nativeReady()) {
            tell(ctx, "$NAME needs its engine files",
                "The $NAME engine (libchaos.so and the other native libraries) is not inside this build yet, so it cannot start.\n\n" +
                    "Add the lib/ folder of the original Clone App with cloneapp/tools/add-jni.py and build again (see cloneapp/README.md).")
            return
        }
        if (!isRunning()) {
            tell(ctx, "$NAME did not start", "The engine could not start. Open Quick Settings > Debug log for the reason (tag \"CloneApp\").")
            return
        }
        try {
            val pm = ctx.packageManager
            val name = listOf(ENTRY, ENTRY_FALLBACK).firstOrNull {
                try { pm.getActivityInfo(ComponentName(ctx.packageName, it), 0); true } catch (_: Throwable) { false }
            } ?: run { Toast.makeText(ctx, "$NAME is not available in this build", Toast.LENGTH_LONG).show(); return }
            val i = Intent().setComponent(ComponentName(ctx.packageName, name))
            if (ctx !is android.app.Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ctx.startActivity(i)
        } catch (e: Throwable) {
            AppLog.e(TAG, "cannot open the Clone App", e)
            Toast.makeText(ctx, "$NAME could not open", Toast.LENGTH_LONG).show()
        }
    }

    private fun tell(ctx: Context, title: String, message: String) {
        try {
            W11Dialog.confirm(ctx, title, message, "OK") { }
        } catch (_: Throwable) {
            Toast.makeText(ctx, "$title. $message", Toast.LENGTH_LONG).show()
        }
    }
}
