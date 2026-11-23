package com.srizwan.win11

import android.content.Intent
import android.widget.Toast
import com.seleuco.mame4droid.MameLaunch

// =====================================================================
// Built-in MAME app = the :mame module (MAME4droid (Current) v1.41.2, MAME core 0.289, package com.seleuco.mame4droid, GPL-2.0-or-later).
// Opened from: the Start menu (section "mame"), the Home screen icon and the deep link rizwans2://mame.
// MAME runs in its own process ":mame" and its own task (see mame/README.md step 4), so it never closes the Win11 shell.
// The File Manager does NOT hand .zip / .7z files to MAME on purpose: almost every zip on a phone is not a ROM set.
// =====================================================================

private const val MAME_LOGT = "Mame"

/** True when this phone can run MAME: 64-bit ARM and Android 8.0+ (the core libMAME4droid.so is arm64-v8a only). */
internal fun isMameSupported(): Boolean = MameLaunch.isSupported()

/** Opens MAME's game list (first start: MAME asks for the ROM folder itself). Does nothing but a short message on an unsupported phone. */
internal fun MainActivity.openMame() {
    if (!MameLaunch.isSupported()) {
        Toast.makeText(this, "MAME needs a 64-bit ARM phone (Android 8.0+)", Toast.LENGTH_SHORT).show()
        return
    }
    try {
        startActivity(MameLaunch.frontend(this).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    } catch (e: Throwable) {
        AppLog.e(MAME_LOGT, "cannot open MAME4droid", e)
        Toast.makeText(this, "MAME error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}
