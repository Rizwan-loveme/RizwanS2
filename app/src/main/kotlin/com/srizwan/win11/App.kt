package com.srizwan.win11

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import top.niunaijun.blackbox.BlackBoxCore
import top.niunaijun.blackbox.app.configuration.ClientConfiguration
import java.io.File

/**
 * Starts the BlackBox engine, then logging + crash capture before any Activity / Service / Receiver runs.
 *
 * This class also runs in every virtual-app process (":black", ":p0", ...), so the engine is attached
 * in attachBaseContext (before anything else). Logging and the crash handler are only for the launcher's
 * own process: a crash inside a cloned app must not show this launcher's crash screen.
 */
class App : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        try {
            BlackBoxCore.get().doAttachBaseContext(base, object : ClientConfiguration() {
                override fun getHostPackageName(): String = base.packageName
                override fun isEnableDaemonService(): Boolean = false
                // Never upload logcat to any server.
                override fun getLogSenderChatId(): String = ""
            })
        } catch (e: Throwable) {
            Log.e("App", "engine attach failed", e)
        }
    }

    override fun onCreate() {
        super.onCreate()
        try {
            BlackBoxCore.get().doCreate()
        } catch (e: Throwable) {
            Log.e("App", "engine create failed", e)
        }
        if (!isLauncherProcess()) return
        AppLog.init(this)
        AppLog.installCrashHandler()
        AppLog.i("App", "process start | ${Build.MANUFACTURER} ${Build.MODEL} | Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})")
    }

    /** true in the launcher's main process (process name == package name), false in engine / cloned-app processes. */
    private fun isLauncherProcess(): Boolean {
        val name: String? = try {
            if (Build.VERSION.SDK_INT >= 28) getProcessName()
            else File("/proc/self/cmdline").readText().trim { it <= ' ' || it == '\u0000' }
        } catch (_: Throwable) { null }
        return name == null || name == packageName
    }
}
