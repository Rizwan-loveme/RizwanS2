package com.p129f.p130a.p137g;

/* compiled from: Longs.java */
/* renamed from: com.f.a.g.d */
/* loaded from: classes.dex */
public final class C1220d {
    /* renamed from: a */
    public static int m10175a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    /* renamed from: a */
    public static long m10176a(byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9) {
        return ((b2 & 255) << 56) | ((b3 & 255) << 48) | ((b4 & 255) << 40) | ((b5 & 255) << 32) | ((b6 & 255) << 24) | ((b7 & 255) << 16) | ((b8 & 255) << 8) | (b9 & 255);
    }
}
