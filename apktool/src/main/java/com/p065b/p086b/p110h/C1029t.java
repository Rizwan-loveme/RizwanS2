package com.p065b.p086b.p110h;

/* compiled from: Leb128Utils.java */
/* renamed from: com.b.b.h.t */
/* loaded from: classes.dex */
public final class C1029t {
    /* renamed from: a */
    public static int m8588a(int i) {
        int i2 = i >> 7;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>= 7;
            i3++;
        }
        return i3 + 1;
    }

    /* renamed from: a */
    public static int m8589a(InterfaceC1016g interfaceC1016g) {
        int mo7634e;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        do {
            mo7634e = interfaceC1016g.mo7634e() & 255;
            i = ((mo7634e & 127) << (i3 * 7)) | i;
            i2 <<= 7;
            i3++;
            if ((mo7634e & 128) != 128) {
                break;
            }
        } while (i3 < 5);
        if ((mo7634e & 128) == 128) {
            throw new C1018i("invalid LEB128 sequence");
        }
        if (((i2 >> 1) & i) != 0) {
            return i | i2;
        }
        return i;
    }

    /* renamed from: b */
    public static int m8591b(InterfaceC1016g interfaceC1016g) {
        int mo7634e;
        int i = 0;
        int i2 = 0;
        do {
            mo7634e = interfaceC1016g.mo7634e() & 255;
            i = ((mo7634e & 127) << (i2 * 7)) | i;
            i2++;
            if ((mo7634e & 128) != 128) {
                break;
            }
        } while (i2 < 5);
        if ((mo7634e & 128) == 128) {
            throw new C1018i("invalid LEB128 sequence");
        }
        return i;
    }

    /* renamed from: a */
    public static void m8590a(InterfaceC1017h interfaceC1017h, int i) {
        for (int i2 = i >>> 7; i2 != 0; i2 >>>= 7) {
            interfaceC1017h.mo7631c((byte) ((i & 127) | 128));
            i = i2;
        }
        interfaceC1017h.mo7631c((byte) (i & 127));
    }

    /* renamed from: b */
    public static void m8592b(InterfaceC1017h interfaceC1017h, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        boolean z = true;
        int i4 = i2;
        while (z) {
            z = (i4 == i3 && (i4 & 1) == ((i >> 6) & 1)) ? false : true;
            interfaceC1017h.mo7631c((byte) ((z ? 128 : 0) | (i & 127)));
            i = i4;
            i4 >>= 7;
        }
    }
}
