package com.nicdahlquist.pngquant;

import java.p209io.File;

/* loaded from: classes.dex */
public class LibPngQuant {
    private static native boolean nativePngQuantFile(String str, String str2);

    /* renamed from: a */
    public boolean m11224a(File file, File file2) {
        if (file == null) {
            throw new NullPointerException();
        }
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }
        if (file2 == null) {
            throw new NullPointerException();
        }
        if (file2.length() != 0) {
            throw new IllegalArgumentException();
        }
        return nativePngQuantFile(file.getAbsolutePath(), file2.getAbsolutePath());
    }

    static {
        System.loadLibrary("pngquantandroid");
    }
}
