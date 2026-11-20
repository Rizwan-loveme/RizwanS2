package com.p129f.p130a.p137g;

/* compiled from: Ints.java */
/* renamed from: com.f.a.g.c */
/* loaded from: classes.dex */
public final class C1219c {
    /* renamed from: a */
    public static int m10174a(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    /* renamed from: a */
    public static int m10173a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m10172a(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }
}
