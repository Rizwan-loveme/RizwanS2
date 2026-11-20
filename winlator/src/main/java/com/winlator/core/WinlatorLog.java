package com.winlator.core;

import android.util.Log;

/**
 * Win11 part 9: one place for Winlator's own messages and errors.
 *
 * The :winlator module cannot see the Win11 logger (AppLog lives in :app), so messages go through a
 * replaceable {@link Sink}. Without a sink they only go to Logcat (tag "Winlator/..."). The Win11 app
 * installs a sink in App.onCreate (WinlatorLauncher.installLogBridge) that forwards everything to AppLog,
 * so Winlator problems show up in the on-device Debug log (Quick Settings -> Debug log) next to the rest.
 * Logging never throws.
 */
public abstract class WinlatorLog {
    public interface Sink {
        /** level: 'D', 'I', 'W' or 'E'. */
        void log(char level, String tag, String message, Throwable error);
    }

    private static volatile Sink sink;

    public static void setSink(Sink newSink) {
        sink = newSink;
    }

    public static void d(String tag, String message) {
        log('D', tag, message, null);
    }

    public static void i(String tag, String message) {
        log('I', tag, message, null);
    }

    public static void w(String tag, String message) {
        log('W', tag, message, null);
    }

    public static void e(String tag, String message, Throwable error) {
        log('E', tag, message, error);
    }

    private static void log(char level, String tag, String message, Throwable error) {
        try {
            Sink s = sink;
            if (s != null) {
                s.log(level, tag, message, error);
                return;
            }
            String fullTag = "Winlator/"+tag;
            if (level == 'E') Log.e(fullTag, message, error);
            else if (level == 'W') Log.w(fullTag, message);
            else if (level == 'D') Log.d(fullTag, message);
            else Log.i(fullTag, message);
        }
        catch (Throwable ignored) {}
    }
}
