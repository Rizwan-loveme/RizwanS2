package com.srizwan.win11

import android.content.Intent
import android.widget.Toast
import com.srizwan.chooser.data.ChooserFileProvider
import java.io.File

// =====================================================================
// Built-in J2ME app = the :j2me module (J2ME Loader, package ru.playsoftware.j2meloader).
// The list of installed Java games is its MainActivity; a game runs in its own ":midlet" process (see App.kt).
// Opened from: the Start menu (section "j2me"), the Home screen icon, the deep link rizwans2://j2me and
// the File Manager (.jar / .jad / .kjx files open the J2ME installer).
// =====================================================================

private const val J2ME_LOGT = "J2me"

/** Opens the J2ME app (the list of installed Java games). */
internal fun MainActivity.openJ2me() {
    try {
        startActivity(Intent(this, ru.playsoftware.j2meloader.MainActivity::class.java))
    } catch (e: Throwable) {
        AppLog.e(J2ME_LOGT, "cannot open J2ME MainActivity", e)
    }
}

/** Java ME files the File Manager hands to the J2ME app: .jar and .jad (MIDlet / descriptor), .kjx (KDDI). */
internal fun isJ2meFile(name: String): Boolean {
    val lower = name.lowercase()
    return lower.endsWith(".jar") || lower.endsWith(".jad") || lower.endsWith(".kjx")
}

/**
 * Opens the J2ME installer for [file]. A file:// uri in an intent throws (FileUriExposedException, since API 24; the app targets 37 since part 8 of the Mika plan), so the file goes
 * through the own FileProvider of :chooser as a content:// uri with a read grant (J2ME's installer reads both).
 */
internal fun MainActivity.openJ2meFile(file: File) {
    try {
        val uri = ChooserFileProvider.uriFor(this, file)
        val intent = Intent(Intent.ACTION_VIEW, uri, this, ru.playsoftware.j2meloader.MainActivity::class.java)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(intent)
    } catch (e: Throwable) {
        AppLog.e(J2ME_LOGT, "cannot open ${file.name} in J2ME", e)
        Toast.makeText(this, "J2ME error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}
