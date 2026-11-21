package com.srizwan.chooser.data

import android.content.Context
import java.util.Locale

/**
 * What the Chooser remembers (file `chooser_prefs`). Step 2: the **recent choices**, per kind (open / share) and per MIME family,
 * so the app that was picked last for pictures comes first the next time pictures are opened (and so on for videos, text ...).
 * Step 3 adds the saved **"Always"** choices (one app per kind and exact MIME type, set from the "Open with" sheet).
 * Step 11 adds the settings: sheet style (grid / list), apps per row, remembering recent apps on or off, listing and clearing the
 * saved choices and the recent lists, and resetting the picker. Keys of the settings start with `opt_`, so they never clash with
 * the `recent_`, `always_` and `picker_` families that the clear functions walk through.
 */
object ChooserPrefs {

    private const val FILE = "chooser_prefs"
    private const val MAX_RECENT = 12

    private fun prefs(context: Context) = context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)

    private fun recentKey(kind: ChooserKind, mime: String): String =
        "recent_" + kind.name.lowercase() + "_" + MimeTypes.family(mime)

    /** Component keys ([Target.key]) chosen before for this kind and MIME family, the most recent first. */
    fun recent(context: Context, kind: ChooserKind, mime: String): List<String> =
        if (!recentEnabled(context)) emptyList() else readRecent(context, recentKey(kind, mime))

    private fun readRecent(context: Context, key: String): List<String> =
        prefs(context).getString(key, null)?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()

    /** Remembers that [target] was chosen: it moves to the front of its list (at most [MAX_RECENT] are kept). */
    fun recordChoice(context: Context, kind: ChooserKind, mime: String, target: Target) = recordChoice(context, kind, mime, target.key)

    /** The same for a component key (a saved "Always" app is started without a [Target]). */
    fun recordChoice(context: Context, kind: ChooserKind, mime: String, key: String) {
        if (!recentEnabled(context)) return
        val list = recent(context, kind, mime).toMutableList()
        list.remove(key)
        list.add(0, key)
        while (list.size > MAX_RECENT) list.removeAt(list.size - 1)
        prefs(context).edit().putString(recentKey(kind, mime), list.joinToString("\n")).apply()
    }

    /** Drops one component from the recent list (for example when it can no longer be started). */
    fun forget(context: Context, kind: ChooserKind, mime: String, key: String) {
        // reads the stored list even when remembering is switched off, so a dead app is dropped from it either way
        val rk = recentKey(kind, mime)
        val list = readRecent(context, rk).toMutableList()
        if (list.remove(key)) prefs(context).edit().putString(rk, list.joinToString("\n")).apply()
    }

    // ── Settings (step 11) ───────────────────────────────────────────────

    private const val RECENT_PREFIX = "recent_"
    private const val OPT_RECENT = "opt_recent_on"
    private const val OPT_SHEET_LIST = "opt_sheet_list"
    private const val OPT_SHEET_COLUMNS = "opt_sheet_columns"

    /** Are the apps chosen before remembered and shown first? On by default. Switching it off keeps the stored lists but hides them. */
    fun recentEnabled(context: Context): Boolean = prefs(context).getBoolean(OPT_RECENT, true)

    fun setRecentEnabled(context: Context, on: Boolean) {
        prefs(context).edit().putBoolean(OPT_RECENT, on).apply()
    }

    /** `true` = the Open with / Share sheets list the apps one per row, `false` (default) = a grid of icons. */
    fun sheetList(context: Context): Boolean = prefs(context).getBoolean(OPT_SHEET_LIST, false)

    fun setSheetList(context: Context, list: Boolean) {
        prefs(context).edit().putBoolean(OPT_SHEET_LIST, list).apply()
    }

    /** Apps per row of the grid: 0 = as many as fit (default), else 3 to 6. [AppGrid] never uses more than fit the screen. */
    fun sheetColumns(context: Context): Int = prefs(context).getInt(OPT_SHEET_COLUMNS, 0).let { if (it in 3..6) it else 0 }

    fun setSheetColumns(context: Context, columns: Int) {
        prefs(context).edit().putInt(OPT_SHEET_COLUMNS, if (columns in 3..6) columns else 0).apply()
    }

    /** How many apps are in all the recent lists together (an app that is in two lists counts twice). */
    fun recentCount(context: Context): Int =
        prefs(context).all.entries
            .filter { it.key.startsWith(RECENT_PREFIX) && it.value is String }
            .sumOf { (it.value as String).split("\n").count { k -> k.isNotBlank() } }

    /** Empties every recent list (the on / off switch and the saved "Always" choices stay). */
    fun clearAllRecent(context: Context) {
        val p = prefs(context)
        val e = p.edit()
        p.all.keys.filter { it.startsWith(RECENT_PREFIX) }.forEach { e.remove(it) }
        e.apply()
    }

    // ── "Always use this app" (step 3) ──────────────────────────────────────

    private const val ALWAYS_PREFIX = "always_"

    private fun alwaysKey(kind: ChooserKind, mime: String): String =
        ALWAYS_PREFIX + kind.name.lowercase() + "_" + mime.trim().lowercase(Locale.ROOT)

    /** The component key ([Target.key]) saved with "Always" for this kind and exact MIME type, or null. */
    fun always(context: Context, kind: ChooserKind, mime: String): String? =
        prefs(context).getString(alwaysKey(kind, mime), null)?.takeIf { it.isNotBlank() }

    /** Saves [target] as the app to use for [mime] without asking. The launcher (step 4) calls this only after the app started. */
    fun setAlways(context: Context, kind: ChooserKind, mime: String, target: Target) = setAlways(context, kind, mime, target.key)

    fun setAlways(context: Context, kind: ChooserKind, mime: String, key: String) {
        prefs(context).edit().putString(alwaysKey(kind, mime), key).apply()
    }

    /** Removes the saved choice for one kind and MIME type (for example when that app was uninstalled, or from the settings of step 11). */
    fun clearAlways(context: Context, kind: ChooserKind, mime: String) {
        prefs(context).edit().remove(alwaysKey(kind, mime)).apply()
    }

    /** Every saved "Always" choice: the preference key (`always_<kind>_<mime>`) mapped to the component key. */
    fun allAlways(context: Context): Map<String, String> =
        prefs(context).all.entries
            .filter { it.key.startsWith(ALWAYS_PREFIX) && it.value is String }
            .associate { it.key to it.value as String }

    /** One saved "Always" choice, for the settings list. */
    class AlwaysEntry(val kind: ChooserKind, val mime: String, val key: String)

    /** The saved "Always" choices with the kind and MIME type taken out of the preference key, sorted by MIME type. */
    fun alwaysEntries(context: Context): List<AlwaysEntry> =
        allAlways(context).mapNotNull { (prefKey, value) ->
            val rest = prefKey.removePrefix(ALWAYS_PREFIX)
            val cut = rest.indexOf('_')
            if (cut <= 0) return@mapNotNull null
            val kind = try { ChooserKind.valueOf(rest.substring(0, cut).uppercase(Locale.ROOT)) } catch (e: IllegalArgumentException) { return@mapNotNull null }
            val mime = rest.substring(cut + 1)
            if (mime.isBlank() || value.isBlank()) null else AlwaysEntry(kind, mime, value)
        }.sortedWith(compareBy({ it.kind.ordinal }, { it.mime }))

    /** Forgets every saved "Always" choice. */
    fun clearAllAlways(context: Context) {
        val p = prefs(context)
        val e = p.edit()
        p.all.keys.filter { it.startsWith(ALWAYS_PREFIX) }.forEach { e.remove(it) }
        e.apply()
    }

    // ── File picker (step 8) ─────────────────────────────────────────────

    private const val PICKER_DIR = "picker_last_dir"
    private const val PICKER_GRID = "picker_grid"
    private const val PICKER_SORT = "picker_sort"
    private const val PICKER_HIDDEN = "picker_hidden"

    /** The folder the picker was last in (a path), or null. The picker checks that it still exists. */
    fun pickerDir(context: Context): String? = prefs(context).getString(PICKER_DIR, null)?.takeIf { it.isNotBlank() }

    fun setPickerDir(context: Context, path: String) {
        prefs(context).edit().putString(PICKER_DIR, path).apply()
    }

    /** `true` = grid of tiles, `false` = list. */
    fun pickerGrid(context: Context): Boolean = prefs(context).getBoolean(PICKER_GRID, false)

    fun setPickerGrid(context: Context, grid: Boolean) {
        prefs(context).edit().putBoolean(PICKER_GRID, grid).apply()
    }

    /** The sort order of the picker as its enum name (`NAME`, `DATE`, `SIZE`, `TYPE`). */
    fun pickerSort(context: Context): String? = prefs(context).getString(PICKER_SORT, null)

    fun setPickerSort(context: Context, name: String) {
        prefs(context).edit().putString(PICKER_SORT, name).apply()
    }

    fun pickerShowHidden(context: Context): Boolean = prefs(context).getBoolean(PICKER_HIDDEN, false)

    fun setPickerShowHidden(context: Context, show: Boolean) {
        prefs(context).edit().putBoolean(PICKER_HIDDEN, show).apply()
    }

    /** Forgets the picker's last folder, sort order, hidden-files switch and list / grid choice (the next start is as the first one). */
    fun resetPicker(context: Context) {
        prefs(context).edit().remove(PICKER_DIR).remove(PICKER_GRID).remove(PICKER_SORT).remove(PICKER_HIDDEN).apply()
    }
}
