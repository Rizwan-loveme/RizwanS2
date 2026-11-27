package com.srizwan.win11

import android.content.Context
import android.os.Build
import android.util.Log
import com.junkfood.seal.SealInit
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
 *
 * The built-in MAME app (:mame, MAME4droid) runs all its screens in its own process (":mame", see mame/README.md step 4).
 * Like ":midlet" it is neither the launcher nor an engine process, so nothing is started there at all: no BlackBox attach
 * (it would hook the system services of the emulator), no J2ME start-up, no launcher log / crash handler (step 7).
 *
 * The built-in RetroArch app (:retroarch) runs its two activities in its own process (":retroarch", see retroarch/README.md step 6):
 * upstream ends it with System.exit(0) / exit(0), which must not close the launcher. Same treatment as ":mame": nothing is started there.
 *
 * The built-in Seal downloader (:seal, package com.junkfood.seal) runs in the launcher's own process: SealInit.init(this) is called at the end of
 * onCreate (launcher process only). Seal has no Application of its own and no second crash handler: the launcher's crash handler covers it.
 *
 * The Clone App (:cloneapp, prebuilt AAR, see cloneapp/README.md): its engine processes are ":chs" and ":cp0" .. ":cp49" (renamed from the original ":hs" / ":p0" .. so they cannot clash
 * with BlackBox's ":p0" ..). There only CloneAppEngine runs (no BlackBox, no J2ME); in the launcher process it starts after BlackBox. It is opened from Settings only.
 *
 * The built-in Rizwan assistant (:mika, Mika 0.1.52, see mika/README.md step 6): Mika's code needs the Application to be a MikaApp (ten `applicationContext as MikaApp`
 * casts), so App extends [AppBase], which extends MikaApp. MikaApp.onCreate is patched so that it starts nothing by itself: the Win11 processes listed above (all but the
 * launcher's) never run any Mika code, and in the launcher process Mika is started at the very end of onCreate, after BlackBox, logging and Seal, by startMikaIfUsed()
 * (only when Rizwan was opened before on this phone; the first start comes from the hooks of step 8 through startMikaNow()). A failure only gets logged.
 */
class App : AppBase() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        if (isMameProcess()) return // step 7: MAME has no need of the Win11 engines
        if (isRetroarchProcess()) return // RetroArch (step 6) neither
        if (isMidletProcess()) {
            ru.playsoftware.j2meloader.EmulatorApplication.attachMidletProcess(this)
            return
        }
        // Clone App engine processes (:chs, :cp0 .. :cp49, see CloneAppEngine.kt): only the Clone App's engine runs there, never BlackBox (its own processes are :black, :p0 ..).
        if (CloneAppEngine.isCloneProcess(packageName, currentProcessName())) {
            CloneAppEngine.attach(this, base)
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
        // Clone App (:cloneapp): the launcher process is its "manager" role (screens, databases). Does nothing when its native libraries are not in the APK.
        if (isLauncherProcess()) CloneAppEngine.attach(this, base)
    }

    override fun onCreate() {
        super.onCreate()
        if (isMameProcess() || isMidletProcess() || isRetroarchProcess()) return
        if (CloneAppEngine.isCloneProcess(packageName, currentProcessName())) { CloneAppEngine.create(); return }
        try {
            BlackBoxCore.get().doCreate()
        } catch (e: Throwable) {
            Log.e("App", "engine create failed", e)
        }
        if (!isLauncherProcess()) return
        AppLog.init(this)
        AppLog.installCrashHandler()
        // Clone App (:cloneapp): second half of its engine start-up; only reached in the launcher process. A failure is only logged.
        try { CloneAppEngine.create() } catch (e: Throwable) { AppLog.e("App", "Clone App start failed", e) }
        // Terminal step 9: the terminal screen must know at once whether it is the home screen (Back handling), also after a process restart.
        try { ThemeManager.syncHost(this) } catch (e: Throwable) { AppLog.e("App", "theme sync failed", e) }
        // Terminal step 10: the terminal's `win11` command switches the launcher theme through this.
        try { ThemeManager.registerHostSwitcher() } catch (e: Throwable) { AppLog.e("App", "theme switcher failed", e) }
        // Terminal step 11: the terminal's `pinned` / `builtin` / `files` ... commands and its hidden-apps list use the launcher's lists through this.
        try { TerminalShare.register(this) } catch (e: Throwable) { AppLog.e("App", "terminal share failed", e) }
        WinlatorLauncher.installLogBridge()
        AppLog.i("App", "process start | ${Build.MANUFACTURER} ${Build.MODEL} | Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})")
        // Seal (:seal, part 4): MMKV, Koin, download folders, notification channels; the yt-dlp engine unpacks in the background.
        // A failure here must never stop the launcher, so it is only logged.
        try {
            SealInit.init(this) { AppLog.e("Seal", "yt-dlp engine init failed", it) }
        } catch (e: Throwable) {
            AppLog.e("App", "Seal init failed", e)
        }
        // Rizwan (:mika, part 6): launcher process only (the early returns above and isLauncherProcess() keep it out of every other process). Must stay after the Seal block.
        try {
            startMikaIfUsed()
        } catch (e: Throwable) {
            AppLog.e("App", "Rizwan (Mika) start failed", e)
        }
    }

    /** true in the J2ME game process (process name == package name + ":midlet"). */
    private fun isMidletProcess(): Boolean = currentProcessName() == "$packageName:midlet"

    /** true in the MAME process (process name == package name + ":mame"; every activity of :mame has android:process=":mame"). */
    private fun isMameProcess(): Boolean = currentProcessName() == "$packageName:mame"

    /** true in the RetroArch process (process name == package name + ":retroarch"; both activities of :retroarch have android:process=":retroarch"). */
    private fun isRetroarchProcess(): Boolean = currentProcessName() == "$packageName:retroarch"

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
