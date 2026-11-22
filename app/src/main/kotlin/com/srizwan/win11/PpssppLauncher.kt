package com.srizwan.win11

import android.content.Intent
import android.widget.Toast
import java.io.File

// =====================================================================
// Built-in PPSSPP app = the :ppsspp module (PPSSPP v1.20.4, package org.ppsspp.ppsspp, GPL-2.0-or-later).
// Opened from: the Start menu (section "ppsspp"), the Home screen icon, the deep link rizwans2://ppsspp and
// the File Manager (.iso / .cso / .chd / .pbp / .elf / .ppdmp files start the game).
// =====================================================================

private const val PPSSPP_LOGT = "Ppsspp"

/** Opens the PPSSPP app (its own game browser). */
internal fun MainActivity.openPpsspp() {
    try {
        startActivity(Intent(this, org.ppsspp.ppsspp.PpssppActivity::class.java))
    } catch (e: Throwable) {
        AppLog.e(PPSSPP_LOGT, "cannot open PpssppActivity", e)
        Toast.makeText(this, "PPSSPP error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

/** PSP files the File Manager hands to PPSSPP (the same list as the open-with filter in :ppsspp's manifest). */
internal fun isPpssppFile(name: String): Boolean {
    return when (name.substringAfterLast('.', "").lowercase()) {
        "iso", "cso", "chd", "pbp", "elf", "ppdmp" -> true
        else -> false
    }
}

/**
 * Starts [file] in PPSSPP. The path goes in PPSSPP's own shortcut extra (what its shortcuts use), not as a file:// uri
 * (the app targets API 28, where a file:// uri in an intent throws) and not as a content:// uri (PPSSPP then has no real path).
 * The app has the all-files permission, so PPSSPP reads the path directly.
 */
internal fun MainActivity.openPpssppFile(file: File) {
    try {
        val intent = Intent(this, org.ppsspp.ppsspp.PpssppActivity::class.java)
        intent.putExtra(org.ppsspp.ppsspp.PpssppActivity.SHORTCUT_EXTRA_KEY, file.absolutePath)
        startActivity(intent)
    } catch (e: Throwable) {
        AppLog.e(PPSSPP_LOGT, "cannot open ${file.name} in PPSSPP", e)
        Toast.makeText(this, "PPSSPP error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}
