package com.srizwan.win11

import android.content.Context
import android.os.Build
import com.wangzan101.mika.MikaApp

// =====================================================================
// Base class of [App]: the built-in "Rizwan" assistant (the :mika module, Mika 0.1.52, Apache-2.0), see mika/README.md step 6.
//
// Why a base class and not `App : MikaApp()` directly: Mika's code does `context.applicationContext as MikaApp` in ten places, so the Application of
// this app HAS to be a MikaApp. All Mika-specific code of the Application lives in this one file; the "without Mika" build (UltimateBuild_WithoutMe.yml,
// step 9) replaces just this file by a plain `Application` with the same members that do nothing.
//
// What this class decides (nothing else in the app touches Mika's start-up):
//   1. Mika never starts by itself: MikaApp.onCreate (patched, mika/tools/patch-upstream.py edit 7) only calls startOnCreate(), and this class answers false.
//      Reason: App also runs in every engine / cloned-app process (":black", ":p0" ...) and in the ":midlet", ":mame" and ":retroarch" processes. Mika must run in
//      the launcher's own process only, so [App.onCreate] starts it there (after BlackBox, logging and Seal), through [startMikaIfUsed].
//   2. Mika starts at process start only after Rizwan was opened once on this phone (flag [KEY_USED]). Its start-up is not small: it prepares the Linux
//      sandbox (about 58 MB of assets, unpacked in the background), starts the floating capsule, the phone helper watcher, the recovery of unfinished runs, the
//      proactive listener and the MCP / WeChat links when they are switched on. A user who never opens Rizwan must not pay for that at every launch.
//      [startMikaNow] (called by the Start menu / Home icon / deep link, step 8) sets the flag and starts Mika before its screen opens.
//   3. "Quit Mika" (capsule, Settings, backup import) must not end the process: that is the Win11 launcher.
// =====================================================================

abstract class AppBase : MikaApp() {

    /** Mika is started by [App.onCreate] (launcher process only), never by MikaApp.onCreate. */
    final override fun startOnCreate(): Boolean = false

    /** Upstream ends the whole process on "Quit Mika". Here that would be the Win11 launcher, so nothing happens: the services are already stopped by then. */
    final override fun onQuitExit() {}

    /**
     * Launcher process only (called at the end of [App.onCreate]): starts Mika again after a process restart when Rizwan was opened before on this phone
     * (its capsule, scheduled tasks, recovery of unfinished runs need the process to be set up again). Does nothing on a phone that cannot run it. Main thread.
     */
    protected fun startMikaIfUsed() {
        if (!isMikaSupported() || !wasMikaUsed(this)) return
        startMika()
    }

    /**
     * Called by the hooks (step 8) before Rizwan's screen opens, on the main thread: remembers that Rizwan is in use and starts Mika if it is not running yet.
     * Returns false (and starts nothing) on a phone that cannot run it.
     */
    fun startMikaNow(): Boolean {
        if (!isMikaSupported()) return false
        if (!wasMikaUsed(this)) {
            try {
                getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putBoolean(KEY_USED, true).apply()
            } catch (_: Throwable) { /* the flag only decides the start-up after a restart */ }
        }
        startMika()
        return true
    }

    companion object {
        private const val PREFS = "win11_rizwan_state"
        private const val KEY_USED = "mika_used"

        /** True when this phone can run Rizwan: Android 10+ (Mika's minSdk 29) and 64-bit ARM (its Linux sandbox and the prebuilt libraries are arm64-v8a only). */
        @JvmStatic
        fun isMikaSupported(): Boolean =
            Build.VERSION.SDK_INT >= 29 && Build.SUPPORTED_64_BIT_ABIS.any { it == "arm64-v8a" }

        private fun wasMikaUsed(ctx: Context): Boolean = try {
            ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean(KEY_USED, false)
        } catch (_: Throwable) { false }
    }
}
