package com.p065b.p086b.p110h;

/* compiled from: Bits.java */
/* renamed from: com.b.b.h.c */
/* loaded from: classes.dex */
public final class C1012c {
    /* renamed from: a */
    public static int[] m8489a(int i) {
        return new int[(i + 31) >> 5];
    }

    /* renamed from: a */
    public static int m8484a(int[] iArr) {
        return iArr.length * 32;
    }

    /* renamed from: a */
    public static boolean m8487a(int[] iArr, int i) {
        return (iArr[i >> 5] & (1 << (i & 31))) != 0;
    }

    /* renamed from: a */
    public static void m8485a(int[] iArr, int i, boolean z) {
        int i2 = i >> 5;
        int i3 = 1 << (i & 31);
        if (z) {
            iArr[i2] = i3 | iArr[i2];
        } else {
            iArr[i2] = (i3 ^ (-1)) & iArr[i2];
        }
    }

    /* renamed from: b */
    public static void m8490b(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    /* renamed from: c */
    public static void m8493c(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = ((1 << (i & 31)) ^ (-1)) & iArr[i2];
    }

    /* renamed from: b */
    public static boolean m8491b(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static int m8492c(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int bitCount = Integer.bitCount(iArr[i]) + i2;
            i++;
            i2 = bitCount;
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m8488a(int[] iArr, int i, int i2) {
        int m8494d = m8494d(iArr, i);
        return m8494d >= 0 && m8494d < i2;
    }

    /* renamed from: d */
    public static int m8494d(int[] iArr, int i) {
        int m8483a;
        int length = iArr.length;
        int i2 = i & 31;
        for (int i3 = i >> 5; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i4 != 0 && (m8483a = m8483a(i4, i2)) >= 0) {
                return (i3 << 5) + m8483a;
            }
            i2 = 0;
        }
        return -1;
    }

    /* renamed from: a */
    public static int m8483a(int i, int i2) {
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros((((1 << i2) - 1) ^ (-1)) & i);
        if (numberOfTrailingZeros == 32) {
            return -1;
        }
        return numberOfTrailingZeros;
    }

    /* renamed from: a */
    public static void m8486a(int[] iArr, int[] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            iArr[i] = iArr[i] | iArr2[i];
        }
    }
}
