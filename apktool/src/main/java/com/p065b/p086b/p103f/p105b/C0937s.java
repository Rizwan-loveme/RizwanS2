package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: Rop.java */
/* renamed from: com.b.b.f.b.s */
/* loaded from: classes.dex */
public final class C0937s {

    /* renamed from: a */
    private final int f5910a;

    /* renamed from: b */
    private final C0975c f5911b;

    /* renamed from: c */
    private final InterfaceC0977e f5912c;

    /* renamed from: d */
    private final InterfaceC0977e f5913d;

    /* renamed from: e */
    private final int f5914e;

    /* renamed from: f */
    private final boolean f5915f;

    /* renamed from: g */
    private final String f5916g;

    public C0937s(int i, C0975c c0975c, InterfaceC0977e interfaceC0977e, InterfaceC0977e interfaceC0977e2, int i2, boolean z, String str) {
        if (c0975c == null) {
            throw new NullPointerException("result == null");
        }
        if (interfaceC0977e == null) {
            throw new NullPointerException("sources == null");
        }
        if (interfaceC0977e2 == null) {
            throw new NullPointerException("exceptions == null");
        }
        if (i2 < 1 || i2 > 6) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (interfaceC0977e2.mo6856f_() != 0 && i2 != 6) {
            throw new IllegalArgumentException("exceptions / branchingness mismatch");
        }
        this.f5910a = i;
        this.f5911b = c0975c;
        this.f5912c = interfaceC0977e;
        this.f5913d = interfaceC0977e2;
        this.f5914e = i2;
        this.f5915f = z;
        this.f5916g = str;
    }

    public C0937s(int i, C0975c c0975c, InterfaceC0977e interfaceC0977e, int i2, String str) {
        this(i, c0975c, interfaceC0977e, C0974b.f6209a, i2, false, str);
    }

    public C0937s(int i, C0975c c0975c, InterfaceC0977e interfaceC0977e, String str) {
        this(i, c0975c, interfaceC0977e, C0974b.f6209a, 1, false, str);
    }

    public C0937s(int i, C0975c c0975c, InterfaceC0977e interfaceC0977e, InterfaceC0977e interfaceC0977e2, String str) {
        this(i, c0975c, interfaceC0977e, interfaceC0977e2, 6, false, str);
    }

    public C0937s(int i, InterfaceC0977e interfaceC0977e, InterfaceC0977e interfaceC0977e2) {
        this(i, C0975c.f6254i, interfaceC0977e, interfaceC0977e2, 6, true, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0937s)) {
            return false;
        }
        C0937s c0937s = (C0937s) obj;
        return this.f5910a == c0937s.f5910a && this.f5914e == c0937s.f5914e && this.f5911b == c0937s.f5911b && this.f5912c.equals(c0937s.f5912c) && this.f5913d.equals(c0937s.f5913d);
    }

    public int hashCode() {
        return (((((((this.f5910a * 31) + this.f5914e) * 31) + this.f5911b.hashCode()) * 31) + this.f5912c.hashCode()) * 31) + this.f5913d.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append("Rop{");
        stringBuffer.append(C0933o.m7911a(this.f5910a));
        if (this.f5911b != C0975c.f6254i) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f5911b);
        } else {
            stringBuffer.append(" .");
        }
        stringBuffer.append(" <-");
        int mo6856f_ = this.f5912c.mo6856f_();
        if (mo6856f_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < mo6856f_; i++) {
                stringBuffer.append(' ');
                stringBuffer.append(this.f5912c.mo6853a(i));
            }
        }
        if (this.f5915f) {
            stringBuffer.append(" call");
        }
        int mo6856f_2 = this.f5913d.mo6856f_();
        if (mo6856f_2 != 0) {
            stringBuffer.append(" throws");
            for (int i2 = 0; i2 < mo6856f_2; i2++) {
                stringBuffer.append(' ');
                if (this.f5913d.mo6853a(i2) == C0975c.f6263r) {
                    stringBuffer.append("<any>");
                } else {
                    stringBuffer.append(this.f5913d.mo6853a(i2));
                }
            }
        } else {
            switch (this.f5914e) {
                case 1:
                    stringBuffer.append(" flows");
                    break;
                case 2:
                    stringBuffer.append(" returns");
                    break;
                case 3:
                    stringBuffer.append(" gotos");
                    break;
                case 4:
                    stringBuffer.append(" ifs");
                    break;
                case 5:
                    stringBuffer.append(" switches");
                    break;
                default:
                    stringBuffer.append(" " + C1022m.m8559e(this.f5914e));
                    break;
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public int m7968a() {
        return this.f5910a;
    }

    /* renamed from: b */
    public C0975c m7969b() {
        return this.f5911b;
    }

    /* renamed from: c */
    public InterfaceC0977e m7970c() {
        return this.f5912c;
    }

    /* renamed from: d */
    public int m7971d() {
        return this.f5914e;
    }

    /* renamed from: e */
    public boolean m7972e() {
        return this.f5915f;
    }

    /* renamed from: f */
    public boolean m7973f() {
        switch (this.f5910a) {
            case 14:
            case 16:
            case 20:
            case 21:
            case 22:
                return true;
            case 15:
            case 17:
            case 18:
            case 19:
            default:
                return false;
        }
    }

    /* renamed from: g */
    public String m7974g() {
        return this.f5916g != null ? this.f5916g : toString();
    }

    /* renamed from: h */
    public final boolean m7975h() {
        return this.f5913d.mo6856f_() != 0;
    }
}
