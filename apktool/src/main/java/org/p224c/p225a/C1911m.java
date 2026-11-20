package org.p224c.p225a;

/* compiled from: Utils.java */
/* renamed from: org.c.a.m */
/* loaded from: classes.dex */
final class C1911m {

    /* renamed from: a */
    private static final byte[] f11264a = new byte[1024];

    /* renamed from: b */
    private static final int[] f11265b = new int[1024];

    /* renamed from: a */
    static void m14078a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(f11264a, 0, bArr, i + i3, min);
            i3 += min;
        }
    }

    /* renamed from: a */
    static void m14079a(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(f11265b, 0, iArr, i + i3, min);
            i3 += min;
        }
    }
}
