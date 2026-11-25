package com.srizwan.win11

import android.content.Context
import android.content.Intent
import android.widget.Toast

// =====================================================================
// Built-in "Rizwan" assistant = the :mika module (Mika 0.1.52 by wangzan101, Apache-2.0, package com.wangzan101.mika), see mika/README.md step 8 and NOTICE-Mika.md.
// Opened from: the Start menu (section "rizwan"), the Home screen icon, the deep link rizwans2://rizwan (alias rizwans2://assistant) and the terminal theme's `builtin` list.
//
// Rizwan's screens run in the launcher's own process (Mika's code needs the Application to be a MikaApp, see AppBase.kt) but in their own task
// (taskAffinity "${applicationId}.rizwan", part 7), so Recents shows Rizwan as a separate window and Back from it never closes the Win11 shell.
//
// This file and AppBase.kt are the ONLY places of :app that name a Mika class. The "without Rizwan" build (UltimateBuild_WithoutMe.yml, part 9) replaces this file by
// mika/tools/stub/MikaLauncher.kt.stub with the same members, so keep them in step: SECTION, NAME, isSupported(), open().
//
// Not here on purpose: the wake word "Hey Rizwan" (part 14, voice engine decision first) and any change of what Rizwan says (prompts, part 14).
// =====================================================================

object MikaLauncher {

    private const val TAG = "Rizwan"

    /** Section name used by the shell (Start menu entry, Home screen icon, taskbar callback). The Start menu class is "builtin.rizwan". */
    const val SECTION = "rizwan"

    /** The name Mika is shown under (Start menu, Home screen, toasts). Mika's own name and logo are not used (Apache-2.0 section 6), see NOTICE-Mika.md. */
    const val NAME = "Rizwan"

    /**
     * True when this phone can run Rizwan: Android 10+ (Mika's minSdk is 29; the library is compiled with minSdk 26) and 64-bit ARM (its Linux sandbox and the
     * prebuilt libraries are arm64-v8a only). Phone control (the wireless-debugging helper) needs Android 11+ and can only be judged on a real phone.
     * The Start menu entry and the Home icon are hidden on a phone that fails this, the same way Winlator's are.
     */
    fun isSupported(): Boolean = AppBase.isMikaSupported()

    /**
     * Opens Rizwan's chat screen in its own task. Must be called on the main thread (every hook is a click or a deep link, so it is).
     * It first remembers that Rizwan is in use and starts Mika if it is not running yet ([AppBase.startMikaNow]: after a process restart the launcher then starts Mika
     * again by itself, see AppBase.startMikaIfUsed). Returns false, with a short message, when the phone cannot run Rizwan or the start failed.
     */
    fun open(ctx: Context): Boolean {
        if (!isSupported()) {
            Toast.makeText(ctx, "$NAME needs Android 10+ on a 64-bit ARM phone", Toast.LENGTH_LONG).show()
            return false
        }
        return try {
            val app = ctx.applicationContext as? AppBase
            if (app == null || !app.startMikaNow()) {
                Toast.makeText(ctx, "$NAME needs Android 10+ on a 64-bit ARM phone", Toast.LENGTH_LONG).show()
                return false
            }
            ctx.startActivity(Intent(ctx, com.wangzan101.mika.ui.MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            AppLog.i(TAG, "Rizwan opened")
            true
        } catch (e: Throwable) {
            AppLog.e(TAG, "cannot open Rizwan", e)
            Toast.makeText(ctx, "$NAME error: ${e.message}", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
