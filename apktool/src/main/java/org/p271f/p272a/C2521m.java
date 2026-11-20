package org.p271f.p272a;

/* compiled from: Frame.java */
/* renamed from: org.f.a.m */
/* loaded from: classes.dex */
final class C2521m {

    /* renamed from: a */
    static final int[] f13173a;

    /* renamed from: b */
    C2525q f13174b;

    /* renamed from: c */
    int[] f13175c;

    /* renamed from: d */
    int[] f13176d;

    /* renamed from: e */
    private int[] f13177e;

    /* renamed from: f */
    private int[] f13178f;

    /* renamed from: g */
    private int f13179g;

    /* renamed from: h */
    private int f13180h;

    /* renamed from: i */
    private int[] f13181i;

    C2521m() {
    }

    static {
        int[] iArr = new int[202];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i) - 'E';
        }
        f13173a = iArr;
    }

    /* renamed from: a */
    private int m15835a(int i) {
        if (this.f13177e == null || i >= this.f13177e.length) {
            return 33554432 | i;
        }
        int i2 = this.f13177e[i];
        if (i2 == 0) {
            int i3 = 33554432 | i;
            this.f13177e[i] = i3;
            return i3;
        }
        return i2;
    }

    /* renamed from: a */
    private void m15837a(int i, int i2) {
        if (this.f13177e == null) {
            this.f13177e = new int[10];
        }
        int length = this.f13177e.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.f13177e, 0, iArr, 0, length);
            this.f13177e = iArr;
        }
        this.f13177e[i] = i2;
    }

    /* renamed from: b */
    private void m15842b(int i) {
        if (this.f13178f == null) {
            this.f13178f = new int[10];
        }
        int length = this.f13178f.length;
        if (this.f13179g >= length) {
            int[] iArr = new int[Math.max(this.f13179g + 1, length * 2)];
            System.arraycopy(this.f13178f, 0, iArr, 0, length);
            this.f13178f = iArr;
        }
        int[] iArr2 = this.f13178f;
        int i2 = this.f13179g;
        this.f13179g = i2 + 1;
        iArr2[i2] = i;
        int i3 = this.f13174b.f13205e + this.f13179g;
        if (i3 > this.f13174b.f13206f) {
            this.f13174b.f13206f = i3;
        }
    }

    /* renamed from: a */
    private void m15839a(C2516h c2516h, String str) {
        int m15841b = m15841b(c2516h, str);
        if (m15841b != 0) {
            m15842b(m15841b);
            if (m15841b == 16777220 || m15841b == 16777219) {
                m15842b(16777216);
            }
        }
    }

    /* renamed from: b */
    private static int m15841b(C2516h c2516h, String str) {
        int i = 16777217;
        int indexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        switch (str.charAt(indexOf)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                return 16777217;
            case 'D':
                return 16777219;
            case 'F':
                return 16777218;
            case 'J':
                return 16777220;
            case 'L':
                return 24117248 | c2516h.m15829e(str.substring(indexOf + 1, str.length() - 1));
            case 'V':
                return 0;
            default:
                int i2 = indexOf + 1;
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                switch (str.charAt(i2)) {
                    case 'B':
                        i = 16777226;
                        break;
                    case 'C':
                        i = 16777227;
                        break;
                    case 'D':
                        i = 16777219;
                        break;
                    case 'F':
                        i = 16777218;
                        break;
                    case 'I':
                        break;
                    case 'J':
                        i = 16777220;
                        break;
                    case 'S':
                        i = 16777228;
                        break;
                    case 'Z':
                        i = 16777225;
                        break;
                    default:
                        i = c2516h.m15829e(str.substring(i2 + 1, str.length() - 1)) | 24117248;
                        break;
                }
                return ((i2 - indexOf) << 28) | i;
        }
    }

    /* renamed from: a */
    private int m15834a() {
        if (this.f13179g > 0) {
            int[] iArr = this.f13178f;
            int i = this.f13179g - 1;
            this.f13179g = i;
            return iArr[i];
        }
        C2525q c2525q = this.f13174b;
        int i2 = c2525q.f13205e - 1;
        c2525q.f13205e = i2;
        return 50331648 | (-i2);
    }

    /* renamed from: c */
    private void m15843c(int i) {
        if (this.f13179g >= i) {
            this.f13179g -= i;
            return;
        }
        this.f13174b.f13205e -= i - this.f13179g;
        this.f13179g = 0;
    }

    /* renamed from: a */
    private void m15838a(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            m15843c((C2529u.m15895f(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            m15843c(2);
        } else {
            m15843c(1);
        }
    }

    /* renamed from: d */
    private void m15844d(int i) {
        if (this.f13181i == null) {
            this.f13181i = new int[2];
        }
        int length = this.f13181i.length;
        if (this.f13180h >= length) {
            int[] iArr = new int[Math.max(this.f13180h + 1, length * 2)];
            System.arraycopy(this.f13181i, 0, iArr, 0, length);
            this.f13181i = iArr;
        }
        int[] iArr2 = this.f13181i;
        int i2 = this.f13180h;
        this.f13180h = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: a */
    private int m15836a(C2516h c2516h, int i) {
        int m15829e;
        if (i == 16777222) {
            m15829e = c2516h.m15829e(c2516h.f13125o) | 24117248;
        } else if (((-1048576) & i) == 25165824) {
            m15829e = c2516h.m15829e(c2516h.f13124n[1048575 & i].f13196e) | 24117248;
        } else {
            return i;
        }
        for (int i2 = 0; i2 < this.f13180h; i2++) {
            int i3 = this.f13181i[i2];
            int i4 = (-268435456) & i3;
            int i5 = 251658240 & i3;
            if (i5 == 33554432) {
                i3 = this.f13175c[i3 & 8388607] + i4;
            } else if (i5 == 50331648) {
                i3 = this.f13176d[this.f13176d.length - (i3 & 8388607)] + i4;
            }
            if (i == i3) {
                return m15829e;
            }
        }
        return i;
    }

    /* renamed from: a */
    void m15846a(C2516h c2516h, int i, C2529u[] c2529uArr, int i2) {
        int i3 = 1;
        this.f13175c = new int[i2];
        this.f13176d = new int[0];
        if ((i & 8) != 0) {
            i3 = 0;
        } else if ((524288 & i) == 0) {
            this.f13175c[0] = 24117248 | c2516h.m15829e(c2516h.f13125o);
        } else {
            this.f13175c[0] = 16777222;
        }
        for (C2529u c2529u : c2529uArr) {
            int m15841b = m15841b(c2516h, c2529u.m15901e());
            int i4 = i3 + 1;
            this.f13175c[i3] = m15841b;
            if (m15841b == 16777220 || m15841b == 16777219) {
                i3 = i4 + 1;
                this.f13175c[i4] = 16777216;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.f13175c[i3] = 16777216;
            i3++;
        }
    }

    /* renamed from: a */
    void m15845a(int i, int i2, C2516h c2516h, C2524p c2524p) {
        switch (i) {
            case 0:
            case 116:
            case 117:
            case 118:
            case 119:
            case 145:
            case 146:
            case 147:
            case 167:
            case 177:
                return;
            case 1:
                m15842b(16777221);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
            case 21:
                m15842b(16777217);
                return;
            case 9:
            case 10:
            case 22:
                m15842b(16777220);
                m15842b(16777216);
                return;
            case 11:
            case 12:
            case 13:
            case 23:
                m15842b(16777218);
                return;
            case 14:
            case 15:
            case 24:
                m15842b(16777219);
                m15842b(16777216);
                return;
            case 18:
                switch (c2524p.f13193b) {
                    case 3:
                        m15842b(16777217);
                        return;
                    case 4:
                        m15842b(16777218);
                        return;
                    case 5:
                        m15842b(16777220);
                        m15842b(16777216);
                        return;
                    case 6:
                        m15842b(16777219);
                        m15842b(16777216);
                        return;
                    case 7:
                        m15842b(24117248 | c2516h.m15829e("java/lang/Class"));
                        return;
                    case 8:
                        m15842b(24117248 | c2516h.m15829e("java/lang/String"));
                        return;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        m15842b(24117248 | c2516h.m15829e("java/lang/invoke/MethodHandle"));
                        return;
                    case 16:
                        m15842b(24117248 | c2516h.m15829e("java/lang/invoke/MethodType"));
                        return;
                }
            case 19:
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 196:
            case 197:
            default:
                m15843c(i2);
                m15839a(c2516h, c2524p.f13196e);
                return;
            case 25:
                m15842b(m15835a(i2));
                return;
            case 46:
            case 51:
            case 52:
            case 53:
                m15843c(2);
                m15842b(16777217);
                return;
            case 47:
            case 143:
                m15843c(2);
                m15842b(16777220);
                m15842b(16777216);
                return;
            case 48:
                m15843c(2);
                m15842b(16777218);
                return;
            case 49:
            case 138:
                m15843c(2);
                m15842b(16777219);
                m15842b(16777216);
                return;
            case 50:
                m15843c(1);
                m15842b(m15834a() - 268435456);
                return;
            case 54:
            case 56:
            case 58:
                m15837a(i2, m15834a());
                if (i2 > 0) {
                    int m15835a = m15835a(i2 - 1);
                    if (m15835a == 16777220 || m15835a == 16777219) {
                        m15837a(i2 - 1, 16777216);
                        return;
                    } else {
                        if ((251658240 & m15835a) != 16777216) {
                            m15837a(i2 - 1, m15835a | 8388608);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 55:
            case 57:
                m15843c(1);
                m15837a(i2, m15834a());
                m15837a(i2 + 1, 16777216);
                if (i2 > 0) {
                    int m15835a2 = m15835a(i2 - 1);
                    if (m15835a2 == 16777220 || m15835a2 == 16777219) {
                        m15837a(i2 - 1, 16777216);
                        return;
                    } else {
                        if ((251658240 & m15835a2) != 16777216) {
                            m15837a(i2 - 1, m15835a2 | 8388608);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
                m15843c(3);
                return;
            case 80:
            case 82:
                m15843c(4);
                return;
            case 87:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case 171:
            case 172:
            case 174:
            case 176:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                m15843c(1);
                return;
            case 88:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 173:
            case 175:
                m15843c(2);
                return;
            case 89:
                int m15834a = m15834a();
                m15842b(m15834a);
                m15842b(m15834a);
                return;
            case 90:
                int m15834a2 = m15834a();
                int m15834a3 = m15834a();
                m15842b(m15834a2);
                m15842b(m15834a3);
                m15842b(m15834a2);
                return;
            case 91:
                int m15834a4 = m15834a();
                int m15834a5 = m15834a();
                int m15834a6 = m15834a();
                m15842b(m15834a4);
                m15842b(m15834a6);
                m15842b(m15834a5);
                m15842b(m15834a4);
                return;
            case 92:
                int m15834a7 = m15834a();
                int m15834a8 = m15834a();
                m15842b(m15834a8);
                m15842b(m15834a7);
                m15842b(m15834a8);
                m15842b(m15834a7);
                return;
            case 93:
                int m15834a9 = m15834a();
                int m15834a10 = m15834a();
                int m15834a11 = m15834a();
                m15842b(m15834a10);
                m15842b(m15834a9);
                m15842b(m15834a11);
                m15842b(m15834a10);
                m15842b(m15834a9);
                return;
            case 94:
                int m15834a12 = m15834a();
                int m15834a13 = m15834a();
                int m15834a14 = m15834a();
                int m15834a15 = m15834a();
                m15842b(m15834a13);
                m15842b(m15834a12);
                m15842b(m15834a15);
                m15842b(m15834a14);
                m15842b(m15834a13);
                m15842b(m15834a12);
                return;
            case 95:
                int m15834a16 = m15834a();
                int m15834a17 = m15834a();
                m15842b(m15834a16);
                m15842b(m15834a17);
                return;
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 120:
            case 122:
            case 124:
            case 126:
            case 128:
            case 130:
            case 136:
            case 142:
            case 149:
            case 150:
                m15843c(2);
                m15842b(16777217);
                return;
            case 97:
            case 101:
            case 105:
            case 109:
            case 113:
            case 127:
            case 129:
            case 131:
                m15843c(4);
                m15842b(16777220);
                m15842b(16777216);
                return;
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
            case 137:
            case 144:
                m15843c(2);
                m15842b(16777218);
                return;
            case 99:
            case 103:
            case 107:
            case 111:
            case 115:
                m15843c(4);
                m15842b(16777219);
                m15842b(16777216);
                return;
            case 121:
            case 123:
            case 125:
                m15843c(3);
                m15842b(16777220);
                m15842b(16777216);
                return;
            case 132:
                m15837a(i2, 16777217);
                return;
            case 133:
            case 140:
                m15843c(1);
                m15842b(16777220);
                m15842b(16777216);
                return;
            case 134:
                m15843c(1);
                m15842b(16777218);
                return;
            case 135:
            case 141:
                m15843c(1);
                m15842b(16777219);
                m15842b(16777216);
                return;
            case 139:
            case 190:
            case 193:
                m15843c(1);
                m15842b(16777217);
                return;
            case 148:
            case 151:
            case 152:
                m15843c(4);
                m15842b(16777217);
                return;
            case 168:
            case 169:
                throw new RuntimeException("JSR/RET are not supported with computeFrames option");
            case 178:
                m15839a(c2516h, c2524p.f13198g);
                return;
            case 179:
                m15838a(c2524p.f13198g);
                return;
            case 180:
                m15843c(1);
                m15839a(c2516h, c2524p.f13198g);
                return;
            case 181:
                m15838a(c2524p.f13198g);
                m15834a();
                return;
            case 182:
            case 183:
            case 184:
            case 185:
                m15838a(c2524p.f13198g);
                if (i != 184) {
                    int m15834a18 = m15834a();
                    if (i == 183 && c2524p.f13197f.charAt(0) == '<') {
                        m15844d(m15834a18);
                    }
                }
                m15839a(c2516h, c2524p.f13198g);
                return;
            case 186:
                m15838a(c2524p.f13197f);
                m15839a(c2516h, c2524p.f13197f);
                return;
            case 187:
                m15842b(25165824 | c2516h.m15808a(c2524p.f13196e, i2));
                return;
            case 188:
                m15834a();
                switch (i2) {
                    case 4:
                        m15842b(285212681);
                        return;
                    case 5:
                        m15842b(285212683);
                        return;
                    case 6:
                        m15842b(285212674);
                        return;
                    case 7:
                        m15842b(285212675);
                        return;
                    case 8:
                        m15842b(285212682);
                        return;
                    case 9:
                        m15842b(285212684);
                        return;
                    case 10:
                        m15842b(285212673);
                        return;
                    default:
                        m15842b(285212676);
                        return;
                }
            case 189:
                String str = c2524p.f13196e;
                m15834a();
                if (str.charAt(0) == '[') {
                    m15839a(c2516h, '[' + str);
                    return;
                } else {
                    m15842b(c2516h.m15829e(str) | 292552704);
                    return;
                }
            case 192:
                String str2 = c2524p.f13196e;
                m15834a();
                if (str2.charAt(0) == '[') {
                    m15839a(c2516h, str2);
                    return;
                } else {
                    m15842b(c2516h.m15829e(str2) | 24117248);
                    return;
                }
        }
    }

    /* renamed from: a */
    boolean m15847a(C2516h c2516h, C2521m c2521m, int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2 = false;
        int length = this.f13175c.length;
        int length2 = this.f13176d.length;
        if (c2521m.f13175c == null) {
            c2521m.f13175c = new int[length];
            z2 = true;
        }
        boolean z3 = z2;
        for (int i5 = 0; i5 < length; i5++) {
            if (this.f13177e != null && i5 < this.f13177e.length) {
                i3 = this.f13177e[i5];
                if (i3 == 0) {
                    i3 = this.f13175c[i5];
                } else {
                    int i6 = (-268435456) & i3;
                    int i7 = 251658240 & i3;
                    if (i7 != 16777216) {
                        if (i7 == 33554432) {
                            i4 = i6 + this.f13175c[8388607 & i3];
                        } else {
                            i4 = i6 + this.f13176d[length2 - (8388607 & i3)];
                        }
                        i3 = ((i3 & 8388608) == 0 || !(i4 == 16777220 || i4 == 16777219)) ? i4 : 16777216;
                    }
                }
            } else {
                i3 = this.f13175c[i5];
            }
            if (this.f13181i != null) {
                i3 = m15836a(c2516h, i3);
            }
            z3 |= m15840a(c2516h, i3, c2521m.f13175c, i5);
        }
        if (i > 0) {
            boolean z4 = z3;
            for (int i8 = 0; i8 < length; i8++) {
                z4 |= m15840a(c2516h, this.f13175c[i8], c2521m.f13175c, i8);
            }
            if (c2521m.f13176d == null) {
                c2521m.f13176d = new int[1];
                z4 = true;
            }
            return m15840a(c2516h, i, c2521m.f13176d, 0) | z4;
        }
        int length3 = this.f13176d.length + this.f13174b.f13205e;
        if (c2521m.f13176d == null) {
            c2521m.f13176d = new int[this.f13179g + length3];
            z = true;
        } else {
            z = z3;
        }
        boolean z5 = z;
        for (int i9 = 0; i9 < length3; i9++) {
            int i10 = this.f13176d[i9];
            if (this.f13181i != null) {
                i10 = m15836a(c2516h, i10);
            }
            z5 |= m15840a(c2516h, i10, c2521m.f13176d, i9);
        }
        for (int i11 = 0; i11 < this.f13179g; i11++) {
            int i12 = this.f13178f[i11];
            int i13 = (-268435456) & i12;
            int i14 = 251658240 & i12;
            if (i14 != 16777216) {
                if (i14 == 33554432) {
                    i2 = i13 + this.f13175c[8388607 & i12];
                } else {
                    i2 = i13 + this.f13176d[length2 - (8388607 & i12)];
                }
                i12 = ((i12 & 8388608) == 0 || !(i2 == 16777220 || i2 == 16777219)) ? i2 : 16777216;
            }
            if (this.f13181i != null) {
                i12 = m15836a(c2516h, i12);
            }
            z5 |= m15840a(c2516h, i12, c2521m.f13176d, length3 + i11);
        }
        return z5;
    }

    /* renamed from: a */
    private static boolean m15840a(C2516h c2516h, int i, int[] iArr, int i2) {
        int i3;
        int i4 = iArr[i2];
        if (i4 == i) {
            return false;
        }
        if ((268435455 & i) != 16777221) {
            i3 = i;
        } else {
            if (i4 == 16777221) {
                return false;
            }
            i3 = 16777221;
        }
        if (i4 == 0) {
            iArr[i2] = i3;
            return true;
        }
        if ((i4 & 267386880) == 24117248 || (i4 & (-268435456)) != 0) {
            if (i3 == 16777221) {
                return false;
            }
            if (((-1048576) & i3) == ((-1048576) & i4)) {
                if ((i4 & 267386880) == 24117248) {
                    i3 = c2516h.m15806a(i3 & 1048575, 1048575 & i4) | ((-268435456) & i3) | 24117248;
                } else {
                    i3 = ((i4 & (-268435456)) - 268435456) | 24117248 | c2516h.m15829e("java/lang/Object");
                }
            } else if ((i3 & 267386880) == 24117248 || (i3 & (-268435456)) != 0) {
                i3 = Math.min((((i3 & (-268435456)) == 0 || (i3 & 267386880) == 24117248) ? 0 : -268435456) + (i3 & (-268435456)), (((i4 & (-268435456)) == 0 || (i4 & 267386880) == 24117248) ? 0 : -268435456) + ((-268435456) & i4)) | 24117248 | c2516h.m15829e("java/lang/Object");
            } else {
                i3 = 16777216;
            }
        } else if (i4 == 16777221) {
            if ((i3 & 267386880) != 24117248 && ((-268435456) & i3) == 0) {
                i3 = 16777216;
            }
        } else {
            i3 = 16777216;
        }
        if (i4 == i3) {
            return false;
        }
        iArr[i2] = i3;
        return true;
    }
}
