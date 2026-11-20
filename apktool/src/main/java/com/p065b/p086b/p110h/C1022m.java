package com.p065b.p086b.p110h;

/* compiled from: Hex.java */
/* renamed from: com.b.b.h.m */
/* loaded from: classes.dex */
public final class C1022m {
    /* renamed from: a */
    public static String m8553a(long j) {
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m8552a(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static String m8555b(int i) {
        char[] cArr = new char[6];
        for (int i2 = 0; i2 < 6; i2++) {
            cArr[5 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public static String m8557c(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[3 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: d */
    public static String m8558d(int i) {
        return i == ((char) i) ? m8557c(i) : m8552a(i);
    }

    /* renamed from: e */
    public static String m8559e(int i) {
        char[] cArr = new char[2];
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[1 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: f */
    public static String m8560f(int i) {
        return new String(new char[]{Character.forDigit(i & 15, 16)});
    }

    /* renamed from: b */
    public static String m8556b(long j) {
        char[] cArr = new char[17];
        if (j < 0) {
            cArr[0] = '-';
            j = -j;
        } else {
            cArr[0] = '+';
        }
        for (int i = 0; i < 16; i++) {
            cArr[16 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: g */
    public static String m8561g(int i) {
        char[] cArr = new char[9];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[8 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: h */
    public static String m8562h(int i) {
        char[] cArr = new char[5];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[4 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: i */
    public static String m8563i(int i) {
        char[] cArr = new char[3];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[2 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m8554a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        String m8555b;
        int i6 = i + i2;
        if ((i | i2 | i6) < 0 || i6 > bArr.length) {
            throw new IndexOutOfBoundsException("arr.length " + bArr.length + "; " + i + "..!" + i6);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("outOffset < 0");
        }
        if (i2 == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer((i2 * 4) + 6);
        int i7 = 0;
        while (i2 > 0) {
            if (i7 == 0) {
                switch (i5) {
                    case 2:
                        m8555b = m8559e(i3);
                        break;
                    case 3:
                    case 5:
                    default:
                        m8555b = m8552a(i3);
                        break;
                    case 4:
                        m8555b = m8557c(i3);
                        break;
                    case 6:
                        m8555b = m8555b(i3);
                        break;
                }
                stringBuffer.append(m8555b);
                stringBuffer.append(": ");
            } else if ((i7 & 1) == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(m8559e(bArr[i]));
            i3++;
            i++;
            int i8 = i7 + 1;
            if (i8 == i4) {
                stringBuffer.append('\n');
                i8 = 0;
            }
            i2--;
            i7 = i8;
        }
        if (i7 != 0) {
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
