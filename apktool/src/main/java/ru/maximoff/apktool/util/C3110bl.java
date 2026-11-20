package ru.maximoff.apktool.util;

import android.os.Build;
import android.os.StatFs;

/* compiled from: StatUtils.java */
/* renamed from: ru.maximoff.apktool.util.bl */
/* loaded from: classes.dex */
public final class C3110bl {
    /* renamed from: a */
    public static long m18984a(String str) {
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT < 18) {
            return statFs.getBlockSize() * statFs.getBlockCount();
        }
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: b */
    public static long m18985b(String str) {
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT < 18) {
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        }
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }
}
