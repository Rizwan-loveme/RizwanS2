package com.p065b.p086b.p100d;

/* compiled from: Opcodes.java */
/* renamed from: com.b.b.d.n */
/* loaded from: classes.dex */
public final class C0906n {
    /* renamed from: a */
    public static boolean m7693a(int i) {
        int i2;
        if (i < -1) {
            return false;
        }
        return i == -1 || (i2 = i & 255) == 0 || i2 == 255 || (65280 & i) == 0;
    }

    /* renamed from: b */
    public static boolean m7694b(int i) {
        return i >= 255;
    }

    /* renamed from: c */
    public static int m7695c(int i) {
        int i2 = i & 255;
        return (i2 == 0 || i2 == 255) ? i : i2;
    }
}
