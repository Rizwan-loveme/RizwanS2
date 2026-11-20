package org.p226d.p269d;

/* compiled from: Hex.java */
/* renamed from: org.d.d.h */
/* loaded from: classes.dex */
public final class C2454h {
    /* renamed from: a */
    public static String m15522a(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static String m15523b(int i) {
        char[] cArr = new char[2];
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[1 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }
}
