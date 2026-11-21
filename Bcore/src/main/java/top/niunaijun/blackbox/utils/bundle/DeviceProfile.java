package top.niunaijun.blackbox.utils.bundle;

import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import top.niunaijun.blackbox.BlackBoxCore;

/**
 * What the split picker needs to know about the phone: the ABIs the box can run, the screen
 * density and the preferred languages. Kept apart from {@link SplitPicker} so the picker itself
 * has no Android dependency and can be tested on a plain JVM.
 */
public final class DeviceProfile {

    /** ABI names in priority order, for example [arm64-v8a, armeabi-v7a]. */
    public final List<String> abis;
    /** Screen density in dpi, for example 440. */
    public final int densityDpi;
    /** Preferred languages in priority order, for example [bn-BD, en-US]. */
    public final List<String> locales;

    public DeviceProfile(List<String> abis, int densityDpi, List<String> locales) {
        this.abis = abis == null ? new ArrayList<String>() : new ArrayList<>(abis);
        this.densityDpi = densityDpi;
        this.locales = locales == null ? new ArrayList<String>() : new ArrayList<>(locales);
    }

    /**
     * Profile of this phone. The ABI list only holds ABIs with the same bitness as the process
     * that hosts the box: a 64-bit box cannot load 32-bit .so files and the other way round
     * (same rule as AbiUtils.isSupport).
     */
    public static DeviceProfile fromSystem() {
        String[] abiArray;
        boolean is64 = BlackBoxCore.is64Bit();
        if (Build.VERSION.SDK_INT >= 21) {
            abiArray = is64 ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS;
            if (abiArray == null || abiArray.length == 0) {
                abiArray = Build.SUPPORTED_ABIS;
            }
        } else {
            abiArray = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }

        int dpi = 0;
        try {
            dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        } catch (Throwable ignored) {
        }
        if (dpi <= 0) {
            dpi = 320;
        }

        List<String> locales = new ArrayList<>();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleList list = LocaleList.getDefault();
                for (int i = 0; i < list.size(); i++) {
                    locales.add(list.get(i).toLanguageTag());
                }
            }
        } catch (Throwable ignored) {
        }
        if (locales.isEmpty()) {
            locales.add(Locale.getDefault().toLanguageTag());
        }
        return new DeviceProfile(Arrays.asList(abiArray), dpi, locales);
    }

    @Override
    public String toString() {
        return "DeviceProfile{abis=" + abis + ", dpi=" + densityDpi + ", locales=" + locales + "}";
    }
}
