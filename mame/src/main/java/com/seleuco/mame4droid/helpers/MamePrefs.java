package com.seleuco.mame4droid.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Win11: MAME's settings live in their own file ("mame4droid_settings") instead of the app-wide default
 * SharedPreferences file (&lt;package&gt;_preferences). MAME runs in its own process (":mame"); SharedPreferences is not
 * multi-process safe, so two processes writing the same file would overwrite each other's changes (the ROM folder
 * path, the SAF permission URI, the button layout ...). Upstream used PreferenceManager.getDefaultSharedPreferences()
 * everywhere; all those calls now go through this class. Keys and values are unchanged.
 */
public final class MamePrefs {
    public static final String NAME = "mame4droid_settings";

    private MamePrefs() {}

    public static SharedPreferences get(Context context) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }
}
