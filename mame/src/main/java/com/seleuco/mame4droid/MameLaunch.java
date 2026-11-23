package com.seleuco.mame4droid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import java.util.Locale;

/**
 * Win11: the only entry point the Win11 app (:app) needs to start MAME (written for step 4, used by the hooks of step 7).
 * Not part of upstream MAME4droid. Plain Java, no dependencies, safe to call from Kotlin.
 *
 * MAME runs in its own process (":mame") and its own task, so these intents always use FLAG_ACTIVITY_NEW_TASK.
 * The ROM folder itself is chosen inside MAME (first start: dialog "app folder" / "choose folder" with the system folder picker, SAF;
 * the permission is kept with takePersistableUriPermission, upstream SAFHelper / MainHelper) and MAME shows its own game list.
 */
public final class MameLaunch {
    /** Full class name of MAME's main activity (kept from upstream; the JNI names depend on this package). */
    public static final String ACTIVITY = "com.seleuco.mame4droid.MAME4droid";

    /**
     * Version of MAME4droid (Current) this module was taken from; keep it equal to mame/UPSTREAM_VERSION (without the "v").
     * Upstream read the host app's versionName; inside Win11 that would be Win11's version (2.5.x), which would (1) re-unpack MAME's
     * support files (files.zip, marker "dont-delete-&lt;version&gt;.bin") on every Win11 update and never when MAME is updated, and (2) tell the
     * core and the NetPlay lobby a wrong version, which peers compare. So MainHelper.getVersion() and LobbySession.appVersion() return this.
     */
    public static final String UPSTREAM_VERSION = "1.41.2";

    private MameLaunch() {}

    /** True when this phone can run the MAME core: 64-bit ARM (the core is arm64-v8a only) and Android 8.0+ (module minSdk 26). */
    public static boolean isSupported() {
        if (Build.VERSION.SDK_INT < 26) return false;
        String[] abis = Build.SUPPORTED_64_BIT_ABIS;
        if (abis == null) return false;
        for (String a : abis) if ("arm64-v8a".equals(a)) return true;
        return false;
    }

    /** Opens MAME's game list (first start: asks for the ROM folder first). */
    public static Intent frontend(Context context) {
        return base(context);
    }

    /**
     * Starts one ROM straight away. {@code rom} is a content:// Uri of a MAME ROM set ({@code .zip} or {@code .7z}, name = MAME short name, e.g. pacman.zip).
     * {@code cliParams} is optional extra MAME command line (null for none), passed as upstream's "cli_params" extra.
     * The read permission for the Uri is granted to MAME with the intent.
     */
    public static Intent rom(Context context, Uri rom, String cliParams) {
        Intent i = base(context);
        i.setAction(Intent.ACTION_VIEW);
        i.setData(rom);
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (cliParams != null && cliParams.length() > 0) i.putExtra("cli_params", cliParams);
        return i;
    }

    /** True for the file names MAME can open as a ROM set ({@code .zip}, {@code .7z}), case-insensitive. */
    public static boolean isRomFileName(String name) {
        if (name == null) return false;
        String n = name.toLowerCase(Locale.ROOT);
        return n.endsWith(".zip") || n.endsWith(".7z");
    }

    private static Intent base(Context context) {
        Intent i = new Intent();
        i.setComponent(new ComponentName(context.getPackageName(), ACTIVITY));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return i;
    }
}
