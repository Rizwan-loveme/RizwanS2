package com.srizwan.win11

import java.io.File

// =====================================================================
// Which downloaded RetroArch core opens a game file? (step 7 of the RetroArch plan, see retroarch/README.md)
//
// Cores are NOT bundled: the person downloads them in RetroArch (Online Updater -> Core Downloader) into <dataDir>/cores/, and the matching
// core info files (Online Updater -> Update Core Info Files) into <dataDir>/info/. Upstream's native code starts a game only when it is given
// BOTH a game path and a core file (extras ROM + LIBRETRO); with a game and no core it fails to load a core and shows its menu instead.
// So the File Manager must name the core itself. No Android classes here on purpose (java.io only), so the logic is easy to test.
// =====================================================================

internal object RetroarchCores {

    /**
     * Core names (the part of the file name before "_libretro") to try first for an extension, best first. Names are the ones used on
     * libretro's buildbot (fceumm_libretro_android.so -> "fceumm"). A name that is not downloaded is simply skipped.
     * Anything not listed here is found through the core info files (see [pick]).
     */
    private val PREFERRED: Map<String, List<String>> = mapOf(
        // Nintendo
        "nes" to listOf("fceumm", "nestopia", "mesen"),
        "fds" to listOf("fceumm", "nestopia", "mesen"),
        "sfc" to listOf("snes9x", "bsnes_mercury_balanced", "bsnes"),
        "smc" to listOf("snes9x", "bsnes_mercury_balanced", "bsnes"),
        "gb" to listOf("gambatte", "mgba", "sameboy"),
        "gbc" to listOf("gambatte", "mgba", "sameboy"),
        "gba" to listOf("mgba", "gpsp", "vba_next"),
        "n64" to listOf("mupen64plus_next_gles3", "mupen64plus_next_gles2", "parallel_n64"),
        "z64" to listOf("mupen64plus_next_gles3", "mupen64plus_next_gles2", "parallel_n64"),
        "v64" to listOf("mupen64plus_next_gles3", "mupen64plus_next_gles2", "parallel_n64"),
        "nds" to listOf("melonds", "desmume", "melondsds"),
        // Sega
        "gen" to listOf("genesis_plus_gx", "picodrive"),
        "smd" to listOf("genesis_plus_gx", "picodrive"),
        "32x" to listOf("picodrive"),
        "sms" to listOf("genesis_plus_gx", "smsplus", "gearsystem"),
        "gg" to listOf("genesis_plus_gx", "smsplus", "gearsystem"),
        // NEC, Atari, SNK
        "pce" to listOf("mednafen_pce_fast", "mednafen_pce"),
        "sgx" to listOf("mednafen_supergrafx", "mednafen_pce"),
        "a26" to listOf("stella", "stella2014"),
        "a78" to listOf("prosystem"),
        "lnx" to listOf("handy", "mednafen_lynx"),
        "ngp" to listOf("mednafen_ngp", "race"),
    )

    /** "fceumm_libretro_android.so" -> "fceumm"; null when [fileName] is not a core file (no ".so" or no "_libretro" in the name). */
    fun stemOf(fileName: String): String? {
        if (!fileName.endsWith(".so", ignoreCase = true)) return null
        val i = fileName.indexOf("_libretro")
        return if (i > 0) fileName.substring(0, i) else null
    }

    /** The extensions (lower case, no dot) a core info file lists in `supported_extensions = "nes|fds|unf"`; empty when the file is missing or has none. */
    fun infoExtensions(infoFile: File): Set<String> = try {
        if (!infoFile.isFile) emptySet() else infoFile.useLines { lines ->
            lines.map { it.trim() }
                .firstOrNull { it.startsWith("supported_extensions") && it.substringAfter("supported_extensions", "").trimStart().startsWith("=") }
                ?.substringAfter('=')?.trim()?.trim('"')
                ?.split('|')?.map { it.trim().lowercase() }?.filter { it.isNotEmpty() }?.toSet()
                ?: emptySet()
        }
    } catch (_: Throwable) { emptySet() }

    /**
     * The downloaded core that should open a game with extension [ext] (no dot, any case), or null when none fits.
     *  1. the first PREFERRED core for the extension that is downloaded (works even before the core info files are downloaded),
     *  2. otherwise the first downloaded core (by file name) whose info file lists the extension.
     * [coresDir] = <dataDir>/cores, [infoDir] = <dataDir>/info (the folders upstream's MainMenuActivity / native code use).
     */
    fun pick(ext: String, coresDir: File, infoDir: File): File? {
        val e = ext.lowercase()
        val cores: List<Pair<String, File>> = (coresDir.listFiles() ?: return null)
            .filter { it.isFile }
            .sortedBy { it.name }
            .mapNotNull { f -> stemOf(f.name)?.let { it to f } }
        if (cores.isEmpty()) return null
        for (pref in PREFERRED[e].orEmpty()) cores.firstOrNull { it.first == pref }?.let { return it.second }
        return cores.firstOrNull { (stem, _) -> e in infoExtensions(File(infoDir, "${stem}_libretro.info")) }?.second
    }
}
