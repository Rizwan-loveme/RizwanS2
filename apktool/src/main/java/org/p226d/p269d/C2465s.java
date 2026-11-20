package org.p226d.p269d;

/* compiled from: Utf8Utils.java */
/* renamed from: org.d.d.s */
/* loaded from: classes.dex */
public final class C2465s {

    /* renamed from: a */
    private static final ThreadLocal<char[]> f12951a = new ThreadLocal<char[]>() { // from class: org.d.d.s.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[256];
        }
    };

    /* renamed from: a */
    public static String m15563a(byte[] bArr, int i, int i2, int[] iArr) {
        char c2;
        char[] cArr = f12951a.get();
        if (cArr == null || cArr.length < i2) {
            cArr = new char[i2];
            f12951a.set(cArr);
        }
        int i3 = i;
        int i4 = 0;
        while (i2 > 0) {
            int i5 = bArr[i3] & 255;
            switch (i5 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (i5 == 0) {
                        return m15562a(i5, i3);
                    }
                    c2 = (char) i5;
                    i3++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return m15562a(i5, i3);
                case 12:
                case 13:
                    int i6 = bArr[i3 + 1] & 255;
                    if ((i6 & 192) != 128) {
                        return m15562a(i6, i3 + 1);
                    }
                    int i7 = ((i5 & 31) << 6) | (i6 & 63);
                    if (i7 != 0 && i7 < 128) {
                        return m15562a(i6, i3 + 1);
                    }
                    c2 = (char) i7;
                    i3 += 2;
                    break;
                case 14:
                    int i8 = bArr[i3 + 1] & 255;
                    if ((i8 & 192) != 128) {
                        return m15562a(i8, i3 + 1);
                    }
                    int i9 = bArr[i3 + 2] & 255;
                    if ((i9 & 192) != 128) {
                        return m15562a(i9, i3 + 2);
                    }
                    int i10 = ((i5 & 15) << 12) | ((i8 & 63) << 6) | (i9 & 63);
                    if (i10 < 2048) {
                        return m15562a(i9, i3 + 2);
                    }
                    c2 = (char) i10;
                    i3 += 3;
                    break;
            }
            cArr[i4] = c2;
            i2--;
            i4++;
        }
        if (iArr != null && iArr.length > 0) {
            iArr[0] = i3 - i;
            iArr[0] = i3 - i;
        }
        return new String(cArr, 0, i4);
    }

    /* renamed from: a */
    private static String m15562a(int i, int i2) {
        throw new IllegalArgumentException("bad utf-8 byte " + C2454h.m15523b(i) + " at offset " + C2454h.m15522a(i2));
    }
}
