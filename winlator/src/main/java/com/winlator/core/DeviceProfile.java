package com.winlator.core;

import android.app.ActivityManager;
import android.content.Context;

import com.winlator.box64.Box64Preset;
import com.winlator.container.Container;
import com.winlator.container.DXWrappers;

import java.util.Locale;

/**
 * Win11 part 8: defaults tuned for weak phones such as the Tecno Spark Go 3
 * (Unisoc T7250, Mali-G57 MP1, 4 GB RAM, 720x1600). Nothing here checks a phone model; it looks at the
 * hardware, so the same defaults help every Mali / 4 GB phone.
 *
 *   Mali GPU      -> no Turnip (it only runs on Adreno); OpenGL driver VirGL; Direct3D through WineD3D.
 *   Mali or <5 GB -> "light" device: small Wine screen (854x480), Box64 "Stability" preset.
 *   < 5 GB RAM    -> smaller shader cache, no GL thread, fewer glibc malloc arenas.
 *
 * Only the DEFAULTS of NEW containers (and the "+" screen of Winlator) change. A saved container,
 * shortcut or preference keeps what the user chose.
 */
public abstract class DeviceProfile {
    /** A "4 GB" phone reports about 3.6 - 3.9 GiB as total memory, an "6 GB" phone about 5.4 GiB. */
    private static final long LOW_RAM_LIMIT_BYTES = 5L * 1024 * 1024 * 1024;

    public static final String LIGHT_SCREEN_SIZE = "854x480";

    private static Boolean mali;
    private static Boolean lowRam;

    public static synchronized boolean isMali(Context context) {
        if (mali == null) {
            try {
                String renderer = GPUHelper.glGetRenderer(context);
                mali = renderer != null && renderer.toLowerCase(Locale.ENGLISH).contains("mali");
            }
            catch (Throwable e) {
                return false; // not cached: try again next time
            }
        }
        return mali;
    }

    /** Turnip is the Adreno driver. It is hidden when the GPU is known and is not an Adreno (Mali, PowerVR, ...). */
    public static boolean isTurnipAvailable(Context context) {
        try {
            String renderer = GPUHelper.glGetRenderer(context);
            if (renderer == null || renderer.isEmpty()) return true; // unknown GPU: do not hide anything
            return GPUHelper.getAdrenoModelId(context) > 0;
        }
        catch (Throwable e) {
            return true;
        }
    }

    public static synchronized boolean isLowRam(Context context) {
        if (lowRam == null) {
            try {
                ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
                ((ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(info);
                lowRam = info.totalMem > 0 && info.totalMem < LOW_RAM_LIMIT_BYTES;
            }
            catch (Throwable e) {
                return false;
            }
        }
        return lowRam;
    }

    /** Mali GPU or little RAM. */
    public static boolean isLight(Context context) {
        return isMali(context) || isLowRam(context);
    }

    public static String defaultScreenSize(Context context) {
        return isLight(context) ? LIGHT_SCREEN_SIZE : Container.DEFAULT_SCREEN_SIZE;
    }

    public static String defaultBox64Preset(Context context) {
        return isLight(context) ? Box64Preset.STABILITY : Box64Preset.DEFAULT;
    }

    /** Mali: WineD3D (OpenGL, so VirGL) is the safe choice; DXVK needs a good Vulkan driver. */
    public static String defaultDXWrapper(Context context) {
        return isMali(context) ? DXWrappers.WINED3D : Container.DEFAULT_DXWRAPPER;
    }

    public static String defaultEnvVars(Context context) {
        if (!isLowRam(context)) return Container.DEFAULT_ENV_VARS;
        EnvVars envVars = new EnvVars(Container.DEFAULT_ENV_VARS);
        envVars.put("MESA_SHADER_CACHE_MAX_SIZE", "128MB");
        envVars.put("mesa_glthread", "false");
        envVars.put("MALLOC_ARENA_MAX", "2");
        return envVars.toString();
    }
}
