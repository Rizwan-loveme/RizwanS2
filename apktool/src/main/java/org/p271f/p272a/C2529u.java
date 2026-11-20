package org.p271f.p272a;

import android.text.Spanned;

/* compiled from: Type.java */
/* renamed from: org.f.a.u */
/* loaded from: classes.dex */
public class C2529u {

    /* renamed from: a */
    public static final C2529u f13273a = new C2529u(0, null, 1443168256, 1);

    /* renamed from: b */
    public static final C2529u f13274b = new C2529u(1, null, 1509950721, 1);

    /* renamed from: c */
    public static final C2529u f13275c = new C2529u(2, null, 1124075009, 1);

    /* renamed from: d */
    public static final C2529u f13276d = new C2529u(3, null, 1107297537, 1);

    /* renamed from: e */
    public static final C2529u f13277e = new C2529u(4, null, 1392510721, 1);

    /* renamed from: f */
    public static final C2529u f13278f = new C2529u(5, null, 1224736769, 1);

    /* renamed from: g */
    public static final C2529u f13279g = new C2529u(6, null, 1174536705, 1);

    /* renamed from: h */
    public static final C2529u f13280h = new C2529u(7, null, 1241579778, 1);

    /* renamed from: i */
    public static final C2529u f13281i = new C2529u(8, null, 1141048066, 1);

    /* renamed from: j */
    private final int f13282j;

    /* renamed from: k */
    private final char[] f13283k;

    /* renamed from: l */
    private final int f13284l;

    /* renamed from: m */
    private final int f13285m;

    private C2529u(int i, char[] cArr, int i2, int i3) {
        this.f13282j = i;
        this.f13283k = cArr;
        this.f13284l = i2;
        this.f13285m = i3;
    }

    /* renamed from: a */
    public static C2529u m15888a(String str) {
        return m15889a(str.toCharArray(), 0);
    }

    /* renamed from: b */
    public static C2529u m15891b(String str) {
        char[] charArray = str.toCharArray();
        return new C2529u(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
    }

    /* renamed from: c */
    public static C2529u m15892c(String str) {
        return m15889a(str.toCharArray(), 0);
    }

    /* renamed from: d */
    public static C2529u[] m15893d(String str) {
        int i;
        int i2 = 1;
        char[] charArray = str.toCharArray();
        int i3 = 0;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char c2 = charArray[i4];
            if (c2 == ')') {
                break;
            }
            if (c2 == 'L') {
                do {
                    i = i5;
                    i5 = i + 1;
                } while (charArray[i] != ';');
                i3++;
                i4 = i5;
            } else if (c2 != '[') {
                i3++;
                i4 = i5;
            } else {
                i4 = i5;
            }
        }
        C2529u[] c2529uArr = new C2529u[i3];
        int i6 = 0;
        while (charArray[i2] != ')') {
            c2529uArr[i6] = m15889a(charArray, i2);
            i2 += (c2529uArr[i6].f13282j == 10 ? 2 : 0) + c2529uArr[i6].f13285m;
            i6++;
        }
        return c2529uArr;
    }

    /* renamed from: e */
    public static C2529u m15894e(String str) {
        return m15889a(str.toCharArray(), str.indexOf(41) + 1);
    }

    /* renamed from: f */
    public static int m15895f(String str) {
        int i;
        char charAt;
        int i2;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            i = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 == ')') {
                break;
            }
            if (charAt2 == 'L') {
                do {
                    i2 = i;
                    i = i2 + 1;
                } while (str.charAt(i2) != ';');
                i5++;
                i4 = i;
            } else if (charAt2 == '[') {
                while (true) {
                    charAt = str.charAt(i);
                    if (charAt != '[') {
                        break;
                    }
                    i++;
                }
                if (charAt == 'D' || charAt == 'J') {
                    i5--;
                    i4 = i;
                } else {
                    i4 = i;
                }
            } else if (charAt2 == 'D' || charAt2 == 'J') {
                i5 += 2;
                i4 = i;
            } else {
                i5++;
                i4 = i;
            }
        }
        char charAt3 = str.charAt(i);
        int i6 = i5 << 2;
        if (charAt3 == 'V') {
            i3 = 0;
        } else if (charAt3 == 'D' || charAt3 == 'J') {
            i3 = 2;
        }
        return i6 | i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private static C2529u m15889a(char[] cArr, int i) {
        int i2 = 1;
        switch (cArr[i]) {
            case 'B':
                return f13276d;
            case 'C':
                return f13275c;
            case 'D':
                return f13281i;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                return new C2529u(11, cArr, i, cArr.length - i);
            case 'F':
                return f13279g;
            case 'I':
                return f13278f;
            case 'J':
                return f13280h;
            case 'L':
                while (cArr[i + i2] != ';') {
                    i2++;
                }
                return new C2529u(10, cArr, i + 1, i2 - 1);
            case 'S':
                return f13277e;
            case 'V':
                return f13273a;
            case 'Z':
                return f13274b;
            case '[':
                while (cArr[i + i2] == '[') {
                    i2++;
                }
                if (cArr[i + i2] == 'L') {
                    do {
                        i2++;
                    } while (cArr[i + i2] != ';');
                }
                return new C2529u(9, cArr, i, i2 + 1);
        }
    }

    /* renamed from: a */
    public int m15896a() {
        return this.f13282j;
    }

    /* renamed from: b */
    public int m15898b() {
        int i = 1;
        while (this.f13283k[this.f13284l + i] == '[') {
            i++;
        }
        return i;
    }

    /* renamed from: c */
    public C2529u m15899c() {
        return m15889a(this.f13283k, this.f13284l + m15898b());
    }

    /* renamed from: d */
    public String m15900d() {
        return new String(this.f13283k, this.f13284l, this.f13285m);
    }

    /* renamed from: e */
    public String m15901e() {
        StringBuffer stringBuffer = new StringBuffer();
        m15890a(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m15890a(StringBuffer stringBuffer) {
        if (this.f13283k == null) {
            stringBuffer.append((char) ((this.f13284l & (-16777216)) >>> 24));
        } else {
            if (this.f13282j == 10) {
                stringBuffer.append('L');
                stringBuffer.append(this.f13283k, this.f13284l, this.f13285m);
                stringBuffer.append(';');
                return;
            }
            stringBuffer.append(this.f13283k, this.f13284l, this.f13285m);
        }
    }

    /* renamed from: f */
    public int m15902f() {
        if (this.f13283k == null) {
            return this.f13284l & 255;
        }
        return 1;
    }

    /* renamed from: a */
    public int m15897a(int i) {
        if (i == 46 || i == 79) {
            return (this.f13283k == null ? (this.f13284l & 65280) >> 8 : 4) + i;
        }
        return (this.f13283k == null ? (this.f13284l & Spanned.SPAN_PRIORITY) >> 16 : 4) + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2529u)) {
            return false;
        }
        C2529u c2529u = (C2529u) obj;
        if (this.f13282j != c2529u.f13282j) {
            return false;
        }
        if (this.f13282j < 9) {
            return true;
        }
        if (this.f13285m != c2529u.f13285m) {
            return false;
        }
        int i = this.f13284l;
        int i2 = c2529u.f13284l;
        int i3 = this.f13285m + i;
        while (i < i3) {
            if (this.f13283k[i] != c2529u.f13283k[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f13282j * 13;
        if (this.f13282j >= 9) {
            int i2 = this.f13284l;
            int i3 = this.f13285m + i2;
            while (i2 < i3) {
                i = (i + this.f13283k[i2]) * 17;
                i2++;
            }
        }
        return i;
    }

    public String toString() {
        return m15901e();
    }
}
