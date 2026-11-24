package com.srizwan.win11

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import ohi.andre.consolelauncher.TuiHost

// =====================================================================
// Two launcher themes (README.md, "Two launcher themes", step 11): what the Win11 launcher shares with the terminal (:tui, T-UI).
// :tui sees only TuiHost.Share; this object is the implementation. It is registered once in App.onCreate() (launcher process only).
//
//  * Hidden / pinned apps: the Start menu's own lists, read and written directly in the preferences file "start_menu" (keys "hidden" and "pinned", one
//    "package/activity" per line: the same text as AppEntry.key; the same file and format AppRepository and AppControl use). Nothing is copied: there is one list.
//    A change made here is read by the Start menu the next time AppRepository.load() runs (it re-reads both lists, see reloadPrefs()); a change made in
//    Win11 reaches the terminal at its next start or `refresh` (AppsManager.fill()).
//    Hiding also unpins, like AppRepository.hide(). Pinned built-in apps are keys of the form "<app package>/builtin.<name>".
//  * Built-in apps (the entries of AppRepository.builtInApps() that make sense as a command): name, label and key below. The keys MUST stay equal to the
//    BUILTIN_CLS_* constants of StartApps.kt; the label is the name shown in the Start menu. Notifications is left out (a settings screen, no deep link).
//  * Opening one: Gallery, Video, YouTube, Camera, Calculator and Parallel are separate activities: started directly from the terminal screen (the terminal stays
//    under them, Back returns). Files, Browser, Messages, Winlator, J2ME, PPSSPP, MAME, RetroArch and the Downloader are screens / launchers of MainActivity, so
//    they go through its deep link (rizwans2://<name>, an explicit start of MainActivity, which is never forwarded back to the terminal): in the TERMINAL theme
//    MainActivity is created on top of the terminal (Back returns to it; a Home press shows the terminal again, step 9); in the Win11 theme MainActivity is already
//    there (singleTask), so Android brings it to the front and closes the terminal above it (it can be opened again with the Terminal card / rizwans2://terminal).
// =====================================================================

object TerminalShare : TuiHost.Share {

    private const val LOGT = "TerminalShare"
    private const val FILE = "start_menu"
    private const val KEY_HIDDEN = "hidden"
    private const val KEY_PINNED = "pinned"

    private lateinit var app: Context

    /** Called once from App.onCreate(). */
    fun register(context: Context) {
        app = context.applicationContext
        TuiHost.setShare(this)
    }

    private class BuiltIn(val name: String, val label: String, val cls: String)

    private fun builtInList(): List<BuiltIn> = buildList {
        add(BuiltIn("files", "Files", "builtin.files"))
        add(BuiltIn("browser", "Browser", "builtin.browser"))
        add(BuiltIn("sms", "Messages", "builtin.sms"))
        add(BuiltIn("calculator", "Calculator", "builtin.calculator"))
        add(BuiltIn("parallel", "Parallel", "builtin.parallel"))
        add(BuiltIn("youtube", "YouTube", "builtin.youtube"))
        add(BuiltIn("video", "Video", "builtin.video"))
        add(BuiltIn("gallery", "Gallery", "builtin.gallery"))
        add(BuiltIn("camera", "Camera", "builtin.camera"))
        add(BuiltIn("j2me", "J2ME", "builtin.j2me"))
        add(BuiltIn("ppsspp", "PPSSPP", "builtin.ppsspp"))
        add(BuiltIn("seal", SEAL_NAME, "builtin.seal"))
        // like the Start menu: Winlator only on the phones that can run it
        if (WinlatorLauncher.isSupported()) add(BuiltIn(WinlatorLauncher.SECTION, "Winlator", "builtin.winlator"))
        add(BuiltIn("mame", "MAME", "builtin.mame"))
        add(BuiltIn("retroarch", "RetroArch", "builtin.retroarch"))
    }

    // ── lists (the Start menu's preferences) ─────────────────────────

    private fun prefs() = app.getSharedPreferences(FILE, Context.MODE_PRIVATE)

    private fun lines(key: String): List<String> =
        prefs().getString(key, null)?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()

    override fun hiddenKeys(): Set<String> = lines(KEY_HIDDEN).toSet()

    override fun pinnedKeys(): List<String> {
        val hidden = hiddenKeys()
        return lines(KEY_PINNED).filter { it !in hidden }
    }

    @Synchronized
    override fun setHidden(key: String, hidden: Boolean) {
        val hid = LinkedHashSet(lines(KEY_HIDDEN))
        val e = prefs().edit()
        if (hidden) {
            hid.add(key)
            e.putString(KEY_PINNED, lines(KEY_PINNED).filterNot { it == key }.joinToString("\n")) // hiding also unpins
        } else {
            hid.remove(key)
        }
        e.putString(KEY_HIDDEN, hid.joinToString("\n")).apply()
        AppLog.i(LOGT, "terminal: ${if (hidden) "hid" else "showed"} $key")
    }

    @Synchronized
    override fun setPinned(key: String, pinned: Boolean) {
        val pins = lines(KEY_PINNED).toMutableList()
        val changed = if (pinned) { if (key in pins) false else pins.add(key) } else pins.remove(key)
        if (changed) prefs().edit().putString(KEY_PINNED, pins.joinToString("\n")).apply()
        AppLog.i(LOGT, "terminal: ${if (pinned) "pinned" else "unpinned"} $key")
    }

    // ── built-in apps ───────────────────────────────────────────────

    override fun builtIns(): List<Array<String>> =
        builtInList().map { arrayOf(it.name, it.label, "${app.packageName}/${it.cls}") }

    override fun openBuiltIn(from: Activity, name: String): Boolean {
        val b = builtInList().firstOrNull { it.name.equals(name, ignoreCase = true) } ?: return false
        return try {
            when (b.name) {
                "gallery" -> from.startActivity(Intent(from, com.srizwan.gallery.home.GalleryHomeActivity::class.java))
                "video" -> from.startActivity(Intent(from, com.srizwan.video.home.VideoHomeActivity::class.java))
                "youtube" -> from.startActivity(Intent(from, com.srizwan.YouTube.YouTubeActivity::class.java))
                "calculator" -> from.startActivity(Intent(from, CalculatorActivity::class.java))
                "parallel" -> from.startActivity(Intent(from, com.srizwan.win11.parallel.ParallelActivity::class.java))
                "camera" -> com.srizwan.camera.CameraActivity.start(from, com.srizwan.camera.CameraActivity.MODE_PHOTO)
                else -> from.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("rizwans2://${b.name}"), from, MainActivity::class.java))
            }
            true
        } catch (e: Throwable) {
            AppLog.e(LOGT, "cannot open the built-in app ${b.name}", e)
            false
        }
    }
}
