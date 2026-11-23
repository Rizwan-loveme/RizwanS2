package com.srizwan.win11

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.retroarch.browser.mainmenu.MainMenuActivity
import java.io.File

// =====================================================================
// Built-in RetroArch app = the :retroarch module (RetroArch v1.22.2, libretro frontend, package com.retroarch, GPL-3.0).
// Opened from: the Start menu (section "retroarch"), the Home screen icon, the deep link rizwans2://retroarch and
// the File Manager (a game file with an unambiguous extension, see isRetroarchFile()).
// RetroArch runs in its own process ":retroarch" and its own task (see retroarch/README.md step 6), so it never closes the Win11 shell.
// Cores are NOT bundled: the person downloads them in RetroArch (Online Updater -> Core Downloader, plus Update Core Info Files). That works because
// :app keeps targetSdk 28. For a game from the File Manager the launcher picks the downloaded core itself (RetroArchCores.kt), because upstream starts a
// game only when it gets a game path AND a core file.
// =====================================================================

private const val RA_LOGT = "RetroArch"

/** Name of RetroArch's process (every activity of :retroarch has android:process=":retroarch"). */
private fun Context.retroarchProcessName() = "$packageName:retroarch"

/**
 * True when this phone can run RetroArch: the native library of :retroarch is in the app's lib folder. That is only the case on a 64-bit ARM phone
 * (the module is built for arm64-v8a only) and when the build was not made with -PretroarchNative=false. Same idea as isMameSupported().
 */
internal fun isRetroarchSupported(ctx: Context): Boolean = try {
    Build.SUPPORTED_ABIS.contains("arm64-v8a") && File(ctx.applicationInfo.nativeLibraryDir, "libretroarch-activity.so").exists()
} catch (_: Throwable) { false }

/** True while the ":retroarch" process is alive (it is the only way to know from the launcher process: RetroActivityFuture.isRunning lives in that process). */
private fun Context.isRetroarchRunning(): Boolean = try {
    (getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).runningAppProcesses
        ?.any { it.processName == retroarchProcessName() } == true
} catch (_: Throwable) { false }

/** RetroArch's core folder (<dataDir>/cores): upstream's MainMenuActivity passes it as libretro_directory, the Core Downloader saves there. */
private fun Context.retroarchCoresDir() = File(applicationInfo.dataDir, "cores")

/** RetroArch's core info folder (<dataDir>/info): where "Update Core Info Files" saves the *.info files (native default for the DATADIR extra). */
private fun Context.retroarchInfoDir() = File(applicationInfo.dataDir, "info")

/** True when at least one core (*.so) was already downloaded into RetroArch's core folder. */
private fun Context.hasRetroarchCores(): Boolean = try {
    retroarchCoresDir().list()?.any { it.endsWith(".so", ignoreCase = true) } == true
} catch (_: Throwable) { false }

/** Opens RetroArch's own menu (or brings the running game back to the front). Does nothing but a short message on an unsupported phone. */
internal fun MainActivity.openRetroarch() {
    if (!isRetroarchSupported(this)) {
        Toast.makeText(this, "RetroArch needs a 64-bit ARM phone (Android 8.0+)", Toast.LENGTH_SHORT).show()
        return
    }
    try {
        startActivity(Intent(this, MainMenuActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    } catch (e: Throwable) {
        AppLog.e(RA_LOGT, "cannot open RetroArch", e)
        Toast.makeText(this, "RetroArch error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

/**
 * Game files the File Manager hands to RetroArch: only extensions that are (nearly) always a console ROM. Left out on purpose:
 *  - .bin .cue .iso .chd .cso .elf .pbp (disc images / ambiguous; .iso .cso .chd .pbp .elf already open in PPSSPP),
 *  - .zip .7z (almost every archive on a phone is not a ROM set),
 *  - .md (Markdown text, also the Mega Drive extension; Mega Drive games use .gen / .smd here), .vb (Visual Basic), .ws / .wsc (script files), .ngc, .col, .int.
 */
internal fun isRetroarchFile(name: String): Boolean = when (name.substringAfterLast('.', "").lowercase()) {
    // Nintendo
    "nes", "fds", "sfc", "smc", "gb", "gbc", "gba", "n64", "z64", "v64", "nds",
    // Sega
    "gen", "smd", "32x", "sms", "gg",
    // NEC, Atari, SNK
    "pce", "sgx", "a26", "a78", "lnx", "ngp" -> true
    else -> false
}

/**
 * Starts [file] in RetroArch: the path goes to MainMenuActivity as the extra "ROM" and the core as the extra "LIBRETRO" (the one change in upstream's Java,
 * see retroarch/README.md step 8), which adds RetroArch's usual extras (config, data dir, ...) and starts the game. The core is chosen by
 * [RetroarchCores.pick] from the cores the person downloaded (RetroArch itself starts a game only with a game AND a core; with only a game it
 * would fail to load a core and show its menu). The app has the all-files permission, so RetroArch reads the path directly
 * (a file:// uri would throw at targetSdk 28 and a content:// uri has no real path).
 * Without a downloaded core that opens this extension RetroArch's menu opens instead, with a hint (the game could not start anyway).
 * If RetroArch is already running, upstream's RetroActivityFuture.onNewIntent keeps the same game, or for another game ends the ":retroarch" process
 * (System.exit); then the same Intent is sent again from here once the process is gone (about 3 seconds at most).
 */
internal fun MainActivity.openRetroarchFile(file: File) {
    if (!isRetroarchSupported(this)) {
        Toast.makeText(this, "RetroArch needs a 64-bit ARM phone (Android 8.0+)", Toast.LENGTH_SHORT).show()
        return
    }
    val ext = file.extension.lowercase()
    val core = try { RetroarchCores.pick(ext, retroarchCoresDir(), retroarchInfoDir()) } catch (_: Throwable) { null }
    if (core == null) {
        val hint = if (hasRetroarchCores()) "RetroArch has no downloaded core for .$ext files: Online Updater -> Core Downloader (then Update Core Info Files)"
        else "RetroArch has no cores yet: Online Updater -> Core Downloader (then Update Core Info Files)"
        Toast.makeText(this, hint, Toast.LENGTH_LONG).show()
        openRetroarch()
        return
    }
    try {
        fun intent() = Intent(this, MainMenuActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .putExtra("ROM", file.absolutePath)
            .putExtra("LIBRETRO", core.absolutePath)
        val wasRunning = isRetroarchRunning()
        startActivity(intent())
        if (wasRunning) relaunchWhenRetroarchEnded(::intent, 0)
    } catch (e: Throwable) {
        AppLog.e(RA_LOGT, "cannot open ${file.name} in RetroArch", e)
        Toast.makeText(this, "RetroArch error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

/** Polls every 150 ms (20 times) for the end of the ":retroarch" process and then starts [intent] once. A game that stayed (same file) simply times out. */
private fun MainActivity.relaunchWhenRetroarchEnded(intent: () -> Intent, attempt: Int) {
    if (attempt >= 20 || isFinishing) return
    Handler(Looper.getMainLooper()).postDelayed({
        if (isRetroarchRunning()) {
            relaunchWhenRetroarchEnded(intent, attempt + 1)
        } else try {
            startActivity(intent())
        } catch (e: Throwable) {
            AppLog.e(RA_LOGT, "cannot restart RetroArch with the new game", e)
        }
    }, 150)
}
