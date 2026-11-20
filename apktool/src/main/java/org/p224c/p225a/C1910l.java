package org.p224c.p225a;

/* compiled from: Transform.java */
/* renamed from: org.c.a.l */
/* loaded from: classes.dex */
final class C1910l {

    /* renamed from: a */
    static final C1910l[] f11260a = {new C1910l("", 0, ""), new C1910l("", 0, " "), new C1910l(" ", 0, " "), new C1910l("", 12, ""), new C1910l("", 10, " "), new C1910l("", 0, " the "), new C1910l(" ", 0, ""), new C1910l("s ", 0, " "), new C1910l("", 0, " of "), new C1910l("", 10, ""), new C1910l("", 0, " and "), new C1910l("", 13, ""), new C1910l("", 1, ""), new C1910l(", ", 0, " "), new C1910l("", 0, ", "), new C1910l(" ", 10, " "), new C1910l("", 0, " in "), new C1910l("", 0, " to "), new C1910l("e ", 0, " "), new C1910l("", 0, "\""), new C1910l("", 0, "."), new C1910l("", 0, "\">"), new C1910l("", 0, "\n"), new C1910l("", 3, ""), new C1910l("", 0, "]"), new C1910l("", 0, " for "), new C1910l("", 14, ""), new C1910l("", 2, ""), new C1910l("", 0, " a "), new C1910l("", 0, " that "), new C1910l(" ", 10, ""), new C1910l("", 0, ". "), new C1910l(".", 0, ""), new C1910l(" ", 0, ", "), new C1910l("", 15, ""), new C1910l("", 0, " with "), new C1910l("", 0, "'"), new C1910l("", 0, " from "), new C1910l("", 0, " by "), new C1910l("", 16, ""), new C1910l("", 17, ""), new C1910l(" the ", 0, ""), new C1910l("", 4, ""), new C1910l("", 0, ". The "), new C1910l("", 11, ""), new C1910l("", 0, " on "), new C1910l("", 0, " as "), new C1910l("", 0, " is "), new C1910l("", 7, ""), new C1910l("", 1, "ing "), new C1910l("", 0, "\n\t"), new C1910l("", 0, ":"), new C1910l(" ", 0, ". "), new C1910l("", 0, "ed "), new C1910l("", 20, ""), new C1910l("", 18, ""), new C1910l("", 6, ""), new C1910l("", 0, "("), new C1910l("", 10, ", "), new C1910l("", 8, ""), new C1910l("", 0, " at "), new C1910l("", 0, "ly "), new C1910l(" the ", 0, " of "), new C1910l("", 5, ""), new C1910l("", 9, ""), new C1910l(" ", 10, ", "), new C1910l("", 10, "\""), new C1910l(".", 0, "("), new C1910l("", 11, " "), new C1910l("", 10, "\">"), new C1910l("", 0, "=\""), new C1910l(" ", 0, "."), new C1910l(".com/", 0, ""), new C1910l(" the ", 0, " of the "), new C1910l("", 10, "'"), new C1910l("", 0, ". This "), new C1910l("", 0, ","), new C1910l(".", 0, " "), new C1910l("", 10, "("), new C1910l("", 10, "."), new C1910l("", 0, " not "), new C1910l(" ", 0, "=\""), new C1910l("", 0, "er "), new C1910l(" ", 11, " "), new C1910l("", 0, "al "), new C1910l(" ", 11, ""), new C1910l("", 0, "='"), new C1910l("", 11, "\""), new C1910l("", 10, ". "), new C1910l(" ", 0, "("), new C1910l("", 0, "ful "), new C1910l(" ", 10, ". "), new C1910l("", 0, "ive "), new C1910l("", 0, "less "), new C1910l("", 11, "'"), new C1910l("", 0, "est "), new C1910l(" ", 10, "."), new C1910l("", 11, "\">"), new C1910l(" ", 0, "='"), new C1910l("", 10, ","), new C1910l("", 0, "ize "), new C1910l("", 11, "."), new C1910l("Â ", 0, ""), new C1910l(" ", 0, ","), new C1910l("", 10, "=\""), new C1910l("", 11, "=\""), new C1910l("", 0, "ous "), new C1910l("", 11, ", "), new C1910l("", 10, "='"), new C1910l(" ", 10, ","), new C1910l(" ", 11, "=\""), new C1910l(" ", 11, ", "), new C1910l("", 11, ","), new C1910l("", 11, "("), new C1910l("", 11, ". "), new C1910l(" ", 11, "."), new C1910l("", 11, "='"), new C1910l(" ", 11, ". "), new C1910l(" ", 10, "=\""), new C1910l(" ", 11, "='"), new C1910l(" ", 10, "='")};

    /* renamed from: b */
    private final byte[] f11261b;

    /* renamed from: c */
    private final int f11262c;

    /* renamed from: d */
    private final byte[] f11263d;

    C1910l(String str, int i, String str2) {
        this.f11261b = m14077a(str);
        this.f11262c = i;
        this.f11263d = m14077a(str2);
    }

    /* renamed from: a */
    static byte[] m14077a(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    /* renamed from: a */
    static int m14076a(byte[] bArr, int i, byte[] bArr2, int i2, int i3, C1910l c1910l) {
        byte[] bArr3 = c1910l.f11261b;
        int length = bArr3.length;
        int i4 = 0;
        int i5 = i;
        while (i4 < length) {
            bArr[i5] = bArr3[i4];
            i4++;
            i5++;
        }
        int i6 = c1910l.f11262c;
        int m14080a = C1912n.m14080a(i6);
        if (m14080a > i3) {
            m14080a = i3;
        }
        int i7 = i2 + m14080a;
        int m14081b = (i3 - m14080a) - C1912n.m14081b(i6);
        int i8 = m14081b;
        int i9 = i7;
        while (i8 > 0) {
            bArr[i5] = bArr2[i9];
            i8--;
            i5++;
            i9++;
        }
        if (i6 == 11 || i6 == 10) {
            int i10 = i5 - m14081b;
            if (i6 == 10) {
                m14081b = 1;
            }
            while (m14081b > 0) {
                int i11 = bArr[i10] & 255;
                if (i11 < 192) {
                    if (i11 >= 97 && i11 <= 122) {
                        bArr[i10] = (byte) (bArr[i10] ^ 32);
                    }
                    i10++;
                    m14081b--;
                } else if (i11 < 224) {
                    int i12 = i10 + 1;
                    bArr[i12] = (byte) (bArr[i12] ^ 32);
                    i10 += 2;
                    m14081b -= 2;
                } else {
                    int i13 = i10 + 2;
                    bArr[i13] = (byte) (bArr[i13] ^ 5);
                    i10 += 3;
                    m14081b -= 3;
                }
            }
        }
        byte[] bArr4 = c1910l.f11263d;
        int length2 = bArr4.length;
        int i14 = 0;
        while (i14 < length2) {
            bArr[i5] = bArr4[i14];
            i14++;
            i5++;
        }
        return i5 - i;
    }
}
