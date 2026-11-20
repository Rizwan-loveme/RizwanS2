package com.rmdir;

import java.io.File;

/* loaded from: classes.dex */
public class Rmdir {
    public static native boolean nativeRmdir(String str);

    static {
        System.loadLibrary("rmdir");
    }

    /* renamed from: a */
    public static boolean m11225a(File file) {
        return nativeRmdir(file.getAbsolutePath());
    }
}
