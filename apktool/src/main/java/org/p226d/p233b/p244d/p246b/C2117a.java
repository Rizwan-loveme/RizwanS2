package org.p226d.p233b.p244d.p246b;

import java.io.ObjectStreamConstants;
import org.p226d.p233b.C2445j;
import org.p226d.p233b.p244d.C2077a;

/* compiled from: HeaderItem.java */
/* renamed from: org.d.b.d.b.a */
/* loaded from: classes.dex */
public class C2117a {

    /* renamed from: a */
    private static final byte[] f11830a = {100, 101, ObjectStreamConstants.TC_ENDBLOCKDATA, 10, 0, 0, 0, 0};

    /* renamed from: a */
    public static byte[] m14656a(int i) {
        return m14658b(C2445j.m15476b(i));
    }

    /* renamed from: b */
    public static byte[] m14658b(int i) {
        byte[] bArr = (byte[]) f11830a.clone();
        if (i < 0 || i > 999) {
            throw new IllegalArgumentException("dexVersion must be within [0, 999]");
        }
        for (int i2 = 6; i2 >= 4; i2--) {
            bArr[i2] = (byte) ((i % 10) + 48);
            i /= 10;
        }
        return bArr;
    }

    /* renamed from: a */
    public static boolean m14655a(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            return false;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            if (bArr[i + i2] != f11830a[i2]) {
                return false;
            }
        }
        for (int i3 = 4; i3 < 7; i3++) {
            if (bArr[i + i3] < 48 || bArr[i + i3] > 57) {
                return false;
            }
        }
        return bArr[i + 7] == f11830a[7];
    }

    /* renamed from: b */
    public static int m14657b(byte[] bArr, int i) {
        if (m14655a(bArr, i)) {
            return m14661d(bArr, i);
        }
        return -1;
    }

    /* renamed from: d */
    private static int m14661d(byte[] bArr, int i) {
        return ((bArr[i + 4] - 48) * 100) + ((bArr[i + 5] - 48) * 10) + (bArr[i + 6] - 48);
    }

    /* renamed from: c */
    public static boolean m14660c(int i) {
        return C2445j.m15475a(i) != -1;
    }

    /* renamed from: c */
    public static int m14659c(byte[] bArr, int i) {
        return new C2077a(bArr).m14621g(i + 40);
    }
}
