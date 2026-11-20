package org.p224c.p225a;

/* compiled from: IntReader.java */
/* renamed from: org.c.a.i */
/* loaded from: classes.dex */
final class C1907i {

    /* renamed from: a */
    private byte[] f11198a;

    /* renamed from: b */
    private int[] f11199b;

    C1907i() {
    }

    /* renamed from: a */
    static void m14072a(C1907i c1907i, byte[] bArr, int[] iArr) {
        c1907i.f11198a = bArr;
        c1907i.f11199b = iArr;
    }

    /* renamed from: a */
    static void m14071a(C1907i c1907i, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            c1907i.f11199b[i2] = (c1907i.f11198a[i2 * 4] & 255) | ((c1907i.f11198a[(i2 * 4) + 1] & 255) << 8) | ((c1907i.f11198a[(i2 * 4) + 2] & 255) << 16) | ((c1907i.f11198a[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
