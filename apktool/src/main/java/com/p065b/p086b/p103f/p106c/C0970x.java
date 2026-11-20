package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CstString.java */
/* renamed from: com.b.b.f.c.x */
/* loaded from: classes.dex */
public final class C0970x extends AbstractC0946aa {

    /* renamed from: a */
    public static final C0970x f6169a = new C0970x("");

    /* renamed from: b */
    private final String f6170b;

    /* renamed from: c */
    private final C1013d f6171c;

    /* renamed from: a */
    public static byte[] m8081a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length * 3];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt != 0 && charAt < 128) {
                bArr[i] = (byte) charAt;
                i++;
            } else if (charAt < 2048) {
                bArr[i] = (byte) (((charAt >> 6) & 31) | 192);
                bArr[i + 1] = (byte) ((charAt & '?') | 128);
                i += 2;
            } else {
                bArr[i] = (byte) (((charAt >> '\f') & 15) | 224);
                bArr[i + 1] = (byte) (((charAt >> 6) & 63) | 128);
                bArr[i + 2] = (byte) ((charAt & '?') | 128);
                i += 3;
            }
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: a */
    public static String m8080a(C1013d c1013d) {
        char c2;
        int m8502a = c1013d.m8502a();
        char[] cArr = new char[m8502a];
        int i = 0;
        int i2 = 0;
        while (m8502a > 0) {
            int m8511e = c1013d.m8511e(i);
            switch (m8511e >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    m8502a--;
                    if (m8511e == 0) {
                        return m8079a(m8511e, i);
                    }
                    c2 = (char) m8511e;
                    i++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return m8079a(m8511e, i);
                case 12:
                case 13:
                    m8502a -= 2;
                    if (m8502a < 0) {
                        return m8079a(m8511e, i);
                    }
                    int m8511e2 = c1013d.m8511e(i + 1);
                    if ((m8511e2 & 192) != 128) {
                        return m8079a(m8511e2, i + 1);
                    }
                    int i3 = ((m8511e & 31) << 6) | (m8511e2 & 63);
                    if (i3 != 0 && i3 < 128) {
                        return m8079a(m8511e2, i + 1);
                    }
                    c2 = (char) i3;
                    i += 2;
                    break;
                case 14:
                    m8502a -= 3;
                    if (m8502a < 0) {
                        return m8079a(m8511e, i);
                    }
                    int m8511e3 = c1013d.m8511e(i + 1);
                    if ((m8511e3 & 192) != 128) {
                        return m8079a(m8511e3, i + 1);
                    }
                    int m8511e4 = c1013d.m8511e(i + 2);
                    if ((m8511e3 & 192) != 128) {
                        return m8079a(m8511e4, i + 2);
                    }
                    int i4 = ((m8511e & 15) << 12) | ((m8511e3 & 63) << 6) | (m8511e4 & 63);
                    if (i4 < 2048) {
                        return m8079a(m8511e4, i + 2);
                    }
                    c2 = (char) i4;
                    i += 3;
                    break;
            }
            cArr[i2] = c2;
            i2++;
        }
        return new String(cArr, 0, i2);
    }

    /* renamed from: a */
    private static String m8079a(int i, int i2) {
        throw new IllegalArgumentException("bad utf-8 byte " + C1022m.m8559e(i) + " at offset " + C1022m.m8552a(i2));
    }

    public C0970x(String str) {
        if (str == null) {
            throw new NullPointerException("string == null");
        }
        this.f6170b = str.intern();
        this.f6171c = new C1013d(m8081a(str));
    }

    public C0970x(C1013d c1013d) {
        if (c1013d == null) {
            throw new NullPointerException("bytes == null");
        }
        this.f6171c = c1013d;
        this.f6170b = m8080a(c1013d).intern();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0970x) {
            return this.f6170b.equals(((C0970x) obj).f6170b);
        }
        return false;
    }

    public int hashCode() {
        return this.f6170b.hashCode();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        return this.f6170b.compareTo(((C0970x) abstractC0945a).f6170b);
    }

    public String toString() {
        return "string{\"" + mo6681d() + "\"}";
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "utf8";
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public boolean mo8035g() {
        return false;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        int length = this.f6170b.length();
        StringBuilder sb = new StringBuilder((length * 3) / 2);
        int i = 0;
        while (i < length) {
            char charAt = this.f6170b.charAt(i);
            if (charAt >= ' ' && charAt < 127) {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    sb.append('\\');
                }
                sb.append(charAt);
            } else if (charAt <= 127) {
                switch (charAt) {
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    case 11:
                    case '\f':
                    default:
                        char charAt2 = i < length + (-1) ? this.f6170b.charAt(i + 1) : (char) 0;
                        boolean z = charAt2 >= '0' && charAt2 <= '7';
                        sb.append('\\');
                        for (int i2 = 6; i2 >= 0; i2 -= 3) {
                            char c2 = (char) (((charAt >> i2) & 7) + 48);
                            if (c2 != '0' || z) {
                                sb.append(c2);
                                z = true;
                            }
                        }
                        if (z) {
                            break;
                        } else {
                            sb.append('0');
                            break;
                        }
                        break;
                    case '\r':
                        sb.append("\\r");
                        break;
                }
            } else {
                sb.append("\\u");
                sb.append(Character.forDigit(charAt >> '\f', 16));
                sb.append(Character.forDigit((charAt >> '\b') & 15, 16));
                sb.append(Character.forDigit((charAt >> 4) & 15, 16));
                sb.append(Character.forDigit(charAt & 15, 16));
            }
            i++;
        }
        return sb.toString();
    }

    /* renamed from: i */
    public String m8083i() {
        return '\"' + mo6681d() + '\"';
    }

    /* renamed from: a */
    public String m8082a(int i) {
        String str;
        String mo6681d = mo6681d();
        if (mo6681d.length() <= i - 2) {
            str = "";
        } else {
            mo6681d = mo6681d.substring(0, i - 5);
            str = "...";
        }
        return '\"' + mo6681d + str + '\"';
    }

    /* renamed from: j */
    public String m8084j() {
        return this.f6170b;
    }

    /* renamed from: k */
    public C1013d m8085k() {
        return this.f6171c;
    }

    /* renamed from: l */
    public int m8086l() {
        return this.f6171c.m8502a();
    }

    /* renamed from: m */
    public int m8087m() {
        return this.f6170b.length();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6262q;
    }
}
