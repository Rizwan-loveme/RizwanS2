package com.srizwan.win11

import android.content.Intent
import android.widget.Toast

// =====================================================================
// Built-in Terminal screen = the :tui module (T-UI / TUI-ConsoleLauncher, package ohi.andre.consolelauncher, MIT + GPL / Apache file headers, see NOTICE-TUI.md).
// Step 8 of the "Two launcher themes" plan (README.md): the terminal is a NORMAL activity of this app (no HOME / LAUNCHER filter, not exported),
// opened here with an explicit intent. It lives in this app's task: Back / the `exit` command return to the Win11 screen below.
// Opened from: the deep link rizwans2://terminal (also: adb shell am start -a android.intent.action.VIEW -d rizwans2://terminal).
// Later steps: theme routing + HOME / Back / boot (step 9), the switch UI (step 10: ThemeSwitchUi.kt + the `win11` command), share features (step 11: TerminalShare.kt), polish + first-run choice (step 12).
// =====================================================================

private const val TERMINAL_LOGT = "Terminal"

/** Opens the terminal screen (T-UI). It asks for its own storage / notification permissions on the first start. */
internal fun MainActivity.openTerminal() {
    try {
        startActivity(Intent(this, ohi.andre.consolelauncher.LauncherActivity::class.java))
    } catch (e: Throwable) {
        AppLog.e(TERMINAL_LOGT, "cannot open the terminal screen (LauncherActivity)", e)
        Toast.makeText(this, "Terminal error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}
