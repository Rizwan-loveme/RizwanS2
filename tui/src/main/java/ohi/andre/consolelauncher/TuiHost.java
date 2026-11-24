package ohi.andre.consolelauncher;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Win11 addition (step 9), not part of upstream T-UI: the few things the host app (:app, the Win11 launcher) and the terminal screen must agree on.
 * <p>
 * homeMode: true when the saved launcher theme is TERMINAL, i.e. the terminal screen IS the home screen (it was opened by the HOME button / the launcher icon /
 * the boot receiver and Back must not close it, like on upstream's launcher). false when the terminal is only a screen opened from Win11 (the Win11 theme is
 * saved): Back and `exit` close it and the Win11 screen below comes back. :app sets it at process start and whenever the saved theme changes
 * (ThemeManager.kt); the value is not stored here, so :tui has no knowledge of :app's preferences.
 * <p>
 * closeTerminal(): lets :app close an open terminal screen (for example when the theme is switched back to Win11 from outside the terminal).
 * <p>
 * Step 10: switchToWin11() + Switcher. The terminal's `win11` command asks the host to switch the launcher theme back to Win11. :tui does not know how
 * (the saved theme and MainActivity belong to :app), so :app registers a Switcher at process start (App.kt) and the command only calls it.
 * <p>
 * Step 11: Share + setShare() / getShare() / openBuiltIn(). The launcher's lists and built-in apps, offered to the terminal by :app (TerminalShare.kt):
 * the hidden and the pinned apps of the Start menu (keys "package/activity", the same text as AppEntry.key), the names of the built-in apps (Files, Browser,
 * Messages, Gallery, ...) and a way to open one. :tui only sees this interface; the data stays in :app's preferences, so :tui still stores nothing of it.
 */
public final class TuiHost {

    private static volatile boolean homeMode = false;
    private static WeakReference<Activity> terminal = null;

    /** Step 10: implemented by :app (ThemeManager.switchTo(from, WIN11)). */
    public interface Switcher {
        void toWin11(Activity from);
    }

    private static volatile Switcher switcher = null;

    /** Step 11: implemented by :app (TerminalShare.kt). Every method may be called from any thread. */
    public interface Share {
        /** Hidden apps of the launcher, as "package/activity". */
        Set<String> hiddenKeys();

        /** Pinned apps of the launcher in their order, as "package/activity" (built-in apps: "<app package>/builtin.<name>"). Hidden apps are not in it. */
        List<String> pinnedKeys();

        /** Hides / shows an app in the launcher (hiding also unpins it, like the Start menu). */
        void setHidden(String key, boolean hidden);

        /** Pins / unpins an app in the launcher. */
        void setPinned(String key, boolean pinned);

        /** The built-in apps of Win11, in the order of the Start menu: each entry is {command name, label, key}. */
        List<String[]> builtIns();

        /** Opens the built-in app with this command name (see builtIns()). Returns false when there is none or it cannot be started. */
        boolean openBuiltIn(Activity from, String name);
    }

    private static volatile Share share = null;

    private TuiHost() {}

    public static void setHomeMode(boolean home) {
        homeMode = home;
    }

    public static boolean isHomeMode() {
        return homeMode;
    }

    public static void setShare(Share s) {
        share = s;
    }

    /** The launcher's shared lists, or null when the host registered none (then the terminal behaves exactly like upstream). */
    public static Share getShare() {
        return share;
    }

    /** Hidden apps of the launcher ("package/activity"); empty when nothing is shared. */
    public static Set<String> hiddenKeys() {
        Share s = share;
        if (s == null) return Collections.emptySet();
        try {
            Set<String> k = s.hiddenKeys();
            return k == null ? Collections.<String>emptySet() : k;
        } catch (Throwable t) {
            return Collections.emptySet();
        }
    }

    /** Hides / shows an app in the launcher too (no-op when nothing is shared). */
    public static void setHidden(String key, boolean hidden) {
        Share s = share;
        if (s == null || key == null) return;
        try {
            s.setHidden(key, hidden);
        } catch (Throwable ignored) {
        }
    }

    /** Opens a built-in app of Win11 from the terminal (UI thread). Returns false when nothing is shared or the name is unknown. */
    public static boolean openBuiltIn(final Activity from, final String name) {
        final Share s = share;
        if (s == null || from == null || name == null) return false;
        for (String[] b : s.builtIns()) {
            if (b[0].equalsIgnoreCase(name)) {
                from.runOnUiThread(() -> {
                    hideKeyboard(from);
                    s.openBuiltIn(from, b[0]);
                });
                return true;
            }
        }
        return false;
    }

    /**
     * Step 12: closes the soft keyboard of [a] before the terminal hands the screen to another one (the `win11` command, the built-in app commands), so the keyboard
     * does not hang over the next screen for a moment. The terminal's window is `stateAlwaysVisible`, so it also would come back with the screen; nothing else changes.
     */
    public static void hideKeyboard(Activity a) {
        try {
            View v = a.getCurrentFocus();
            if (v == null) v = a.getWindow().getDecorView();
            InputMethodManager imm = (InputMethodManager) a.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } catch (Throwable ignored) {
        }
    }

    public static void setSwitcher(Switcher s) {
        switcher = s;
    }

    /**
     * Asks the host app to make Win11 the launcher theme (the `win11` command). Runs on the UI thread (commands may run off the main thread).
     * Returns false when the host registered no Switcher, so the command can say so.
     */
    public static boolean switchToWin11(final Activity from) {
        final Switcher s = switcher;
        if (s == null || from == null) return false;
        from.runOnUiThread(() -> {
            hideKeyboard(from);
            s.toWin11(from);
        });
        return true;
    }

    static synchronized void attach(Activity activity) {
        terminal = new WeakReference<>(activity);
    }

    static synchronized void detach(Activity activity) {
        if (terminal != null && terminal.get() == activity) terminal = null;
    }

    public static synchronized boolean isTerminalOpen() {
        Activity a = terminal == null ? null : terminal.get();
        return a != null && !a.isFinishing();
    }

    /** Finishes the open terminal screen, if there is one (safe to call from any thread). */
    public static synchronized void closeTerminal() {
        final Activity a = terminal == null ? null : terminal.get();
        if (a == null || a.isFinishing()) return;
        a.runOnUiThread(a::finish);
    }
}
