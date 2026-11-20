package com.p065b.p086b.p110h;

import java.io.UTFDataFormatException;

/* compiled from: Mutf8.java */
/* renamed from: com.b.b.h.x */
/* loaded from: classes.dex */
public final class C1033x {
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        throw new java.io.UTFDataFormatException("bad second or third byte");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m8598a(InterfaceC1016g interfaceC1016g, char[] cArr) {
        int i = 0;
        while (true) {
            char mo7634e = (char) (interfaceC1016g.mo7634e() & 255);
            if (mo7634e == 0) {
                return new String(cArr, 0, i);
            }
            cArr[i] = mo7634e;
            if (mo7634e < 128) {
                i++;
            } else if ((mo7634e & 224) == 192) {
                int mo7634e2 = interfaceC1016g.mo7634e() & 255;
                if ((mo7634e2 & 192) != 128) {
                    throw new UTFDataFormatException("bad second byte");
                }
                cArr[i] = (char) (((mo7634e & 31) << 6) | (mo7634e2 & 63));
                i++;
            } else if ((mo7634e & 240) == 224) {
                int mo7634e3 = interfaceC1016g.mo7634e() & 255;
                int mo7634e4 = interfaceC1016g.mo7634e() & 255;
                if ((mo7634e3 & 192) != 128 || (mo7634e4 & 192) != 128) {
                    break;
                }
                cArr[i] = (char) (((mo7634e & 15) << 12) | ((mo7634e3 & 63) << 6) | (mo7634e4 & 63));
                i++;
            } else {
                throw new UTFDataFormatException("bad byte");
            }
        }
    }

    /* renamed from: a */
    private static long m8597a(String str, boolean z) {
        long j;
        long j2 = 0;
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != 0 && charAt <= 127) {
                j = 1 + j2;
            } else if (charAt <= 2047) {
                j = 2 + j2;
            } else {
                j = 3 + j2;
            }
            if (!z || j <= 65535) {
                i++;
                j2 = j;
            } else {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        return j2;
    }

    /* renamed from: a */
    public static void m8599a(byte[] bArr, int i, String str) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt != 0 && charAt <= 127) {
                i2 = i + 1;
                bArr[i] = (byte) charAt;
            } else if (charAt <= 2047) {
                int i4 = i + 1;
                bArr[i] = (byte) (((charAt >> 6) & 31) | 192);
                i2 = i4 + 1;
                bArr[i4] = (byte) ((charAt & '?') | 128);
            } else {
                int i5 = i + 1;
                bArr[i] = (byte) (((charAt >> '\f') & 15) | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((charAt >> 6) & 63) | 128);
                i2 = i6 + 1;
                bArr[i6] = (byte) ((charAt & '?') | 128);
            }
            i3++;
            i = i2;
        }
    }

    /* renamed from: a */
    public static byte[] m8600a(String str) {
        byte[] bArr = new byte[(int) m8597a(str, true)];
        m8599a(bArr, 0, str);
        return bArr;
    }
}
