package org.p226d.p233b.p244d.p246b;

import java.p209io.ObjectStreamConstants;
import org.p226d.p233b.p244d.C2077a;

/* compiled from: OdexHeaderItem.java */
/* renamed from: org.d.b.d.b.c */
/* loaded from: classes.dex */
public class C2119c {

    /* renamed from: a */
    private static final byte[] f11833a = {100, 101, ObjectStreamConstants.TC_RESET, 10, 0, 0, 0, 0};

    /* renamed from: b */
    private static final int[] f11834b = {35, 36};

    /* renamed from: a */
    public static boolean m14667a(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            return false;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            if (bArr[i + i2] != f11833a[i2]) {
                return false;
            }
        }
        for (int i3 = 4; i3 < 7; i3++) {
            if (bArr[i + i3] < 48 || bArr[i + i3] > 57) {
                return false;
            }
        }
        return bArr[i + 7] == f11833a[7];
    }

    /* renamed from: b */
    public static int m14669b(byte[] bArr, int i) {
        if (m14667a(bArr, i)) {
            return m14670c(bArr, i);
        }
        return -1;
    }

    /* renamed from: c */
    private static int m14670c(byte[] bArr, int i) {
        return ((bArr[i + 4] - 48) * 100) + ((bArr[i + 5] - 48) * 10) + (bArr[i + 6] - 48);
    }

    /* renamed from: a */
    public static boolean m14666a(int i) {
        for (int i2 = 0; i2 < f11834b.length; i2++) {
            if (f11834b[i2] == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m14665a(byte[] bArr) {
        return new C2077a(bArr).m14615a(8);
    }

    /* renamed from: b */
    public static int m14668b(byte[] bArr) {
        return new C2077a(bArr).m14615a(16);
    }
}
