package com.srizwan.win11

import android.app.Activity
import android.content.Context
import android.content.Intent
import ohi.andre.consolelauncher.LauncherActivity
import ohi.andre.consolelauncher.TuiHost

// =====================================================================
// Two launcher themes (README.md, "Two launcher themes", step 9): Win11 (the shell of this app) and TERMINAL (the :tui module, T-UI).
// This file = which theme is saved + how the entry points follow it. Not to be confused with upstream T-UI's own colour-theme manager
// (ohi.andre.consolelauncher.managers.ThemeManager, the `tuitheme` command): that one is about terminal colours and lives in :tui.
//
// Rules (all of them go through the functions below):
//  * Saved in the private preferences file "launcher_theme", key "theme" (WIN11 by default). Survives restarts and updates. Key "chosen" (step 12): the first-run
//    choice was seen / a theme was switched, see hasChosen().
//  * Only MainActivity has the HOME + LAUNCHER filters. When TERMINAL is saved, a plain launcher start of MainActivity (action MAIN with the HOME or the
//    LAUNCHER category: the Home button, the launcher icon, "recent apps" restore) is forwarded to the terminal screen and MainActivity closes:
//    forwardIfTerminal(). Deep links (rizwans2://...), notification taps and every other explicit start of MainActivity are NOT forwarded: they ask for Win11.
//  * Boot: BootReceiver starts homeIntent(), i.e. the terminal directly when TERMINAL is saved (the Win11 UI is not built for nothing).
//  * Back: the terminal screen closes on Back when it is only a screen opened from Win11; as the home screen it keeps upstream's Back handling.
//    That is TuiHost.homeMode, kept equal to the saved theme by set() / syncHost() (App.kt calls syncHost() at process start).
//  * Switching (switchTo()): saves, opens the target and closes the other. Entry points (step 10): the two theme cards of ThemeSwitchUi.kt (Start menu > user menu >
//    Launcher theme, or rizwans2://theme/choose), the terminal command `win11` (TuiHost.Switcher, registered by registerHostSwitcher() from App.kt) and the deep links
//    rizwans2://theme/terminal | win11.
//    Win11 is never left under the terminal in the TERMINAL theme (a HOME press would clear the terminal above it and rebuild it).
// =====================================================================

enum class LauncherTheme { WIN11, TERMINAL }

object ThemeManager {
    private const val LOGT = "ThemeManager"
    private const val PREFS = "launcher_theme"
    private const val KEY = "theme"
    private const val KEY_CHOSEN = "chosen"

    private fun prefs(context: Context) = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    /** The saved theme (WIN11 when nothing is saved or the value is unknown). */
    fun get(context: Context): LauncherTheme = try {
        LauncherTheme.valueOf(prefs(context).getString(KEY, null) ?: LauncherTheme.WIN11.name)
    } catch (e: Throwable) {
        LauncherTheme.WIN11
    }

    /**
     * Step 12: true once the person has seen the first-run choice (ThemeSwitchUi.show(firstRun = true)) or has switched the theme by any way. The saved theme alone
     * cannot tell: WIN11 is also what a fresh install reads. Also false after an update from a build without the choice, so everybody gets it once.
     */
    fun hasChosen(context: Context): Boolean = prefs(context).getBoolean(KEY_CHOSEN, false)

    fun markChosen(context: Context) {
        if (!hasChosen(context)) prefs(context).edit().putBoolean(KEY_CHOSEN, true).apply()
    }

    fun isTerminal(context: Context): Boolean = get(context) == LauncherTheme.TERMINAL

    /** Saves the theme and tells the terminal screen whether it is the home screen. Does not open or close anything: see switchTo(). */
    fun set(context: Context, theme: LauncherTheme) {
        prefs(context).edit().putString(KEY, theme.name).putBoolean(KEY_CHOSEN, true).apply()
        TuiHost.setHomeMode(theme == LauncherTheme.TERMINAL)
        AppLog.i(LOGT, "theme saved: $theme")
    }

    /** Makes the terminal screen's home flag equal to the saved theme (process start). */
    fun syncHost(context: Context) {
        TuiHost.setHomeMode(isTerminal(context))
    }

    /** Step 10: gives the terminal's `win11` command the way to switch (the terminal screen is the `from` context, so switchTo() starts MainActivity from it). Called once from App.onCreate. */
    fun registerHostSwitcher() {
        TuiHost.setSwitcher { from -> switchTo(from, LauncherTheme.WIN11) }
    }

    fun terminalIntent(context: Context): Intent = Intent(context, LauncherActivity::class.java)

    /** The activity that is "home" for the saved theme: the terminal screen (TERMINAL) or MainActivity (WIN11). Add NEW_TASK when it is not started from an activity. */
    fun homeIntent(context: Context): Intent =
        if (isTerminal(context)) terminalIntent(context) else Intent(context, MainActivity::class.java)

    /** True for the start that the system makes for a launcher: action MAIN + HOME or LAUNCHER, no data. Anything else is a request for Win11 itself. */
    fun isLauncherEntry(intent: Intent?): Boolean {
        if (intent == null) return false
        if (intent.action != Intent.ACTION_MAIN || intent.data != null) return false
        return intent.hasCategory(Intent.CATEGORY_HOME) || intent.hasCategory(Intent.CATEGORY_LAUNCHER)
    }

    /**
     * Called first in MainActivity.onCreate() and onNewIntent(). When TERMINAL is saved and [intent] is a launcher start, opens the terminal screen and returns true
     * (the caller closes MainActivity and does nothing else). Returns false when Win11 has to be shown (also when the terminal could not be started).
     */
    fun forwardIfTerminal(activity: Activity, intent: Intent?): Boolean {
        if (!isTerminal(activity) || !isLauncherEntry(intent)) return false
        return try {
            activity.startActivity(terminalIntent(activity).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
            @Suppress("DEPRECATION")
            activity.overridePendingTransition(0, 0)
            AppLog.i(LOGT, "launcher start forwarded to the terminal screen")
            true
        } catch (e: Throwable) {
            AppLog.e(LOGT, "cannot forward to the terminal screen, showing Win11", e)
            false
        }
    }

    /**
     * Saves [theme], opens its home screen and closes the other one. From MainActivity (TERMINAL: the Win11 screen finishes) or from the terminal screen (WIN11:
     * MainActivity is started, the terminal finishes). Safe to call when the target is already shown (it only saves).
     */
    fun switchTo(context: Context, theme: LauncherTheme) {
        set(context, theme)
        try {
            when (theme) {
                LauncherTheme.TERMINAL -> {
                    // Step 10: no early return when the screen is already open (it is singleTask: startActivity only brings it to the front),
                    // so MainActivity still finishes below and Win11 is never left under the terminal.
                    val i = terminalIntent(context)
                    if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(i)
                    if (context is MainActivity) context.finish()
                }
                LauncherTheme.WIN11 -> {
                    if (context !is MainActivity) {
                        val i = Intent(context, MainActivity::class.java)
                        if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(i)
                    }
                    TuiHost.closeTerminal()
                }
            }
        } catch (e: Throwable) {
            AppLog.e(LOGT, "cannot switch to $theme", e)
        }
    }
}
