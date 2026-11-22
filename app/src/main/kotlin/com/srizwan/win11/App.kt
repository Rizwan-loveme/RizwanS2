package com.srizwan.win11

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import com.srizwan.win11.parallel.DaemonSetting
import com.srizwan.win11.parallel.InstallInBoxSetting
import top.niunaijun.blackbox.BlackBoxCore
import top.niunaijun.blackbox.app.configuration.ClientConfiguration
import java.io.File

/**
 * Starts the BlackBox engine, then logging + crash capture before any Activity / Service / Receiver runs.
 *
 * This class also runs in every virtual-app process (":black", ":p0", ...), so the engine is attached
 * in attachBaseContext (before anything else). Logging and the crash handler are only for the launcher's
 * own process: a crash inside a cloned app must not show this launcher's crash screen.
 *
 * The built-in J2ME app (:j2me, J2ME Loader) runs each Java game in its own process (":midlet"). That process is
 * neither the launcher nor an engine process, so BlackBox is NOT attached there (it would treat the process as a
 * cloned app and hook the system services). It only gets J2ME's own start-up (crash dialog, saved theme).
 */
class App : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        if (isMidletProcess()) {
            ru.playsoftware.j2meloader.EmulatorApplication.attachMidletProcess(this)
            return
        }
        // J2ME screens in the launcher process need the Application (Room database, MIDlet list); nothing else happens here.
        ru.playsoftware.j2meloader.EmulatorApplication.attach(this)
        try {
            BlackBoxCore.get().doAttachBaseContext(base, object : ClientConfiguration() {
                override fun getHostPackageName(): String = base.packageName
                // the "background service" switch on the Parallel screen (read again on every call)
                override fun isEnableDaemonService(): Boolean = DaemonSetting.isEnabled(base)
                // part 31: the "install inside the box" switch on the Parallel screen (read in the cloned app's process)
                override fun isInstallInsideBox(): Boolean = InstallInBoxSetting.isEnabled(base)
                // Never upload logcat to any server.
                override fun getLogSenderChatId(): String = ""
            })
        } catch (e: Throwable) {
            Log.e("App", "engine attach failed", e)
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (isMidletProcess()) return
        try {
            BlackBoxCore.get().doCreate()
        } catch (e: Throwable) {
            Log.e("App", "engine create failed", e)
        }
        if (!isLauncherProcess()) return
        AppLog.init(this)
        AppLog.installCrashHandler()
        WinlatorLauncher.installLogBridge()
        AppLog.i("App", "process start | ${Build.MANUFACTURER} ${Build.MODEL} | Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})")
    }

    /** true in the J2ME game process (process name == package name + ":midlet"). */
    private fun isMidletProcess(): Boolean = currentProcessName() == "$packageName:midlet"

    private fun currentProcessName(): String? = try {
        if (Build.VERSION.SDK_INT >= 28) getProcessName()
        else File("/proc/self/cmdline").readText().trim { it <= ' ' || it == '\u0000' }
    } catch (_: Throwable) { null }

    /** true in the launcher's main process (process name == package name), false in engine / cloned-app processes. */
    private fun isLauncherProcess(): Boolean {
        val name = currentProcessName()
        return name == null || name == packageName
    }
}
