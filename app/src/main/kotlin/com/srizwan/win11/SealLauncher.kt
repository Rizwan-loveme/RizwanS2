package com.srizwan.win11

import android.content.Intent
import android.widget.Toast

// =====================================================================
// Built-in downloader app = the :seal module (Seal v2.0.0-alpha.5, package com.junkfood.seal, GPL-3.0; yt-dlp / FFmpeg / aria2c engine).
// Shown to the user as "Downloader": Seal's README forbids other parties from using the name "Seal" for a downloader app
// (derivatives included), see NOTICE-Seal.md and seal/README.md. Credit to Seal stays in the About page of the app and in NOTICE-Seal.md.
// Opened from: the Start menu (section "seal"), the Home screen icon, the deep link rizwans2://seal (optional ?url=<link>
// opens its download sheet for that link) and the Browser (Media Grabber, long-press menu of a link: "Download with Downloader").
// =====================================================================

private const val SEAL_LOGT = "Seal"

/** The name the built-in Seal app is shown under (Start menu, Home screen, Browser menus, toasts). */
internal const val SEAL_NAME = "Downloader"

/** True for an address the downloader can take (yt-dlp handles http / https pages and files, also .m3u8 / .mpd streams). */
internal fun isSealUrl(url: String?): Boolean {
    val u = url?.trim().orEmpty()
    return u.startsWith("http://", ignoreCase = true) || u.startsWith("https://", ignoreCase = true)
}

/** Opens the downloader app (its own home screen: link box, download list, settings). */
internal fun MainActivity.openSeal() {
    try {
        startActivity(Intent(this, com.junkfood.seal.MainActivity::class.java))
    } catch (e: Throwable) {
        AppLog.e(SEAL_LOGT, "cannot open Seal MainActivity", e)
        Toast.makeText(this, "$SEAL_NAME error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

/**
 * Opens the downloader app with its download sheet for [url]. The link goes as ACTION_SEND + EXTRA_TEXT, an explicit intent to
 * Seal's own MainActivity, which reads it in onCreate (cold start, Win11 patch) and in onNewIntent (already open, singleTask).
 * Seal has no intent filter in this project (part 5), so no other app can be reached by this and nothing else receives it.
 * Not http / https: nothing is started, a short toast says so.
 */
internal fun MainActivity.openSealWithUrl(url: String?) {
    val link = url?.trim().orEmpty()
    if (!isSealUrl(link)) {
        Toast.makeText(this, "$SEAL_NAME needs an http or https link", Toast.LENGTH_SHORT).show()
        return
    }
    try {
        val intent = Intent(this, com.junkfood.seal.MainActivity::class.java).apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, link)
        }
        startActivity(intent)
    } catch (e: Throwable) {
        AppLog.e(SEAL_LOGT, "cannot hand the link to Seal", e)
        Toast.makeText(this, "$SEAL_NAME error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}
