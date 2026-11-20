package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0925g;
import com.p065b.p086b.p103f.p105b.C0931m;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p105b.C0941w;
import com.p065b.p086b.p103f.p105b.C0942x;
import com.p065b.p086b.p103f.p105b.C0943y;
import com.p065b.p086b.p103f.p105b.InterfaceC0944z;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;

/* compiled from: RopperMachine.java */
/* renamed from: com.b.b.a.b.t */
/* loaded from: classes.dex */
final class C0724t extends C0728x {

    /* renamed from: a */
    private static final C0971y f4586a = new C0971y(C0975c.m8121c("java/lang/reflect/Array"));

    /* renamed from: b */
    private static final C0967u f4587b = new C0967u(f4586a, new C0968v(new C0970x("newInstance"), new C0970x("(Ljava/lang/Class;[I)Ljava/lang/Object;")));

    /* renamed from: c */
    private final C0723s f4588c;

    /* renamed from: d */
    private final C0712h f4589d;

    /* renamed from: e */
    private final InterfaceC0944z f4590e;

    /* renamed from: f */
    private final int f4591f;

    /* renamed from: g */
    private final ArrayList<AbstractC0926h> f4592g;

    /* renamed from: h */
    private InterfaceC0977e f4593h;

    /* renamed from: i */
    private boolean f4594i;

    /* renamed from: j */
    private boolean f4595j;

    /* renamed from: k */
    private int f4596k;

    /* renamed from: l */
    private int f4597l;

    /* renamed from: m */
    private boolean f4598m;

    /* renamed from: n */
    private boolean f4599n;

    /* renamed from: o */
    private C0722r f4600o;

    /* renamed from: p */
    private C0937s f4601p;

    /* renamed from: q */
    private C0940v f4602q;

    public C0724t(C0723s c0723s, C0712h c0712h, InterfaceC0944z interfaceC0944z) {
        super(c0712h.mo6609g());
        if (c0723s == null) {
            throw new NullPointerException("ropper == null");
        }
        if (interfaceC0944z == null) {
            throw new NullPointerException("advice == null");
        }
        this.f4588c = c0723s;
        this.f4589d = c0712h;
        this.f4590e = interfaceC0944z;
        this.f4591f = c0712h.m6612j();
        this.f4592g = new ArrayList<>(25);
        this.f4593h = null;
        this.f4594i = false;
        this.f4595j = false;
        this.f4596k = -1;
        this.f4597l = 0;
        this.f4599n = false;
        this.f4601p = null;
        this.f4602q = null;
    }

    /* renamed from: m */
    public ArrayList<AbstractC0926h> m6759m() {
        return this.f4592g;
    }

    /* renamed from: n */
    public C0937s m6760n() {
        return this.f4601p;
    }

    /* renamed from: o */
    public C0940v m6761o() {
        return this.f4602q;
    }

    /* renamed from: a */
    public void m6758a(InterfaceC0977e interfaceC0977e) {
        this.f4593h = interfaceC0977e;
        this.f4592g.clear();
        this.f4594i = false;
        this.f4595j = false;
        this.f4596k = 0;
        this.f4597l = 0;
        this.f4599n = false;
        this.f4598m = false;
        this.f4600o = null;
    }

    /* renamed from: p */
    public boolean m6762p() {
        return this.f4594i;
    }

    /* renamed from: q */
    public boolean m6763q() {
        return this.f4595j;
    }

    /* renamed from: r */
    public int m6764r() {
        return this.f4596k;
    }

    /* renamed from: s */
    public int m6765s() {
        return this.f4597l;
    }

    /* renamed from: t */
    public boolean m6766t() {
        return this.f4599n;
    }

    /* renamed from: u */
    public boolean m6767u() {
        return this.f4598m;
    }

    /* renamed from: v */
    public boolean m6768v() {
        return this.f4600o != null;
    }

    /* renamed from: w */
    public C0722r m6769w() {
        return this.f4600o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p065b.p086b.p087a.p089b.C0728x, com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public void mo6684a(C0714j c0714j, int i, int i2) {
        C0935q c0935q;
        C0932n c0932n;
        C0934p c0934p;
        C0937s c0937s;
        AbstractC0945a abstractC0945a;
        AbstractC0945a abstractC0945a2;
        AbstractC0926h c0932n2;
        C0942x c0942x;
        int m6625b = c0714j.m6644d().m6625b() + this.f4591f;
        C0935q m6756a = m6756a(i2, m6625b);
        int f_ = m6756a.m8550f_();
        super.mo6684a(c0714j, i, i2);
        C0940v m6602a = this.f4589d.m6602a(i);
        C0934p b2 = m6536b(i2 == 54);
        int l = m6552l();
        if (l == 0) {
            b2 = null;
            switch (i2) {
                case 87:
                case 88:
                    return;
            }
        }
        if (b2 == null) {
            if (l == 1) {
                b2 = C0934p.m7913a(m6625b, m6544d(0));
            } else {
                int m6741a = this.f4588c.m6741a();
                C0934p[] c0934pArr = new C0934p[f_];
                for (int i3 = 0; i3 < f_; i3++) {
                    C0934p m7949b = m6756a.m7949b(i3);
                    InterfaceC0976d m7932h = m7949b.m7932h();
                    C0934p m7927b = m7949b.m7927b(m6741a);
                    this.f4592g.add(new C0932n(C0939u.m7982a(m7932h), m6602a, m7927b, m7949b));
                    c0934pArr[i3] = m7927b;
                    m6741a += m7949b.m7935k();
                }
                for (int e2 = m6545e(); e2 != 0; e2 >>= 4) {
                    C0934p c0934p2 = c0934pArr[(e2 & 15) - 1];
                    InterfaceC0976d m7932h2 = c0934p2.m7932h();
                    this.f4592g.add(new C0932n(C0939u.m7982a(m7932h2), m6602a, c0934p2.m7927b(m6625b), c0934p2));
                    m6625b += m7932h2.mo6695a().m8127j();
                }
                return;
            }
        }
        InterfaceC0976d interfaceC0976d = b2 != null ? b2 : C0975c.f6254i;
        AbstractC0945a f2 = m6546f();
        if (i2 == 197) {
            this.f4599n = true;
            this.f4597l = 6;
            C0934p m7913a = C0934p.m7913a(b2.m7934j(), C0975c.f6241G);
            this.f4592g.add(new C0942x(C0939u.m7983a(C0975c.f6241G, f_), m6602a, m6756a, this.f4593h, C0971y.f6188q));
            this.f4592g.add(new C0932n(C0939u.m7995d(C0975c.f6241G), m6602a, m7913a, C0935q.f5906a));
            int i4 = 0;
            C0975c m8090i = ((C0971y) f2).m8090i();
            while (i4 < f_) {
                i4++;
                m8090i = m8090i.m8138u();
            }
            C0934p m7913a2 = C0934p.m7913a(b2.m7931g(), C0975c.f6258m);
            if (m8090i.m8131n()) {
                c0942x = new C0942x(C0939u.f6101cw, m6602a, C0935q.f5906a, this.f4593h, C0957k.m8058a(m8090i));
            } else {
                c0942x = new C0942x(C0939u.f6118q, m6602a, C0935q.f5906a, this.f4593h, new C0971y(m8090i));
            }
            this.f4592g.add(c0942x);
            this.f4592g.add(new C0932n(C0939u.m7998e(m7913a2.mo6695a()), m6602a, m7913a2, C0935q.f5906a));
            C0934p m7913a3 = C0934p.m7913a(b2.m7931g(), C0975c.f6260o);
            this.f4592g.add(new C0942x(C0939u.m7981a(f4587b.m8047i()), m6602a, C0935q.m7945a(m7913a2, m7913a), this.f4593h, f4587b));
            this.f4592g.add(new C0932n(C0939u.m7995d(f4587b.m8047i().m8103b()), m6602a, m7913a3, C0935q.f5906a));
            i2 = 192;
            c0935q = C0935q.m7944a(m7913a3);
        } else if (i2 == 168) {
            this.f4598m = true;
            return;
        } else {
            if (i2 == 169) {
                try {
                    this.f4600o = (C0722r) m6542c(0);
                    return;
                } catch (ClassCastException e3) {
                    throw new RuntimeException("Argument to RET was not a ReturnAddress", e3);
                }
            }
            c0935q = m6756a;
        }
        int m6755a = m6755a(i2, f2);
        C0937s m7980a = C0939u.m7980a(m6755a, interfaceC0976d, c0935q, f2);
        if (b2 != null && m7980a.m7972e()) {
            this.f4597l++;
            c0932n = new C0932n(C0939u.m7995d(((C0967u) f2).m8047i().m8103b()), m6602a, b2, C0935q.f5906a);
            c0934p = null;
        } else if (b2 == null || !m7980a.m7975h()) {
            c0932n = null;
            c0934p = b2;
        } else {
            this.f4597l++;
            c0932n = new C0932n(C0939u.m7998e(b2.m7932h()), m6602a, b2, C0935q.f5906a);
            c0934p = null;
        }
        if (m6755a == 41) {
            c0937s = m7980a;
            abstractC0945a = C0971y.m8089b(m7980a.m7969b());
        } else {
            if (f2 == null && f_ == 2) {
                InterfaceC0976d m7932h3 = c0935q.m7949b(0).m7932h();
                InterfaceC0976d m7932h4 = c0935q.m7949b(1).m7932h();
                if ((m7932h4.mo6699f() || m7932h3.mo6699f()) && this.f4590e.mo7871a(m7980a, c0935q.m7949b(0), c0935q.m7949b(1))) {
                    if (m7932h4.mo6699f()) {
                        AbstractC0945a abstractC0945a3 = (AbstractC0945a) m7932h4;
                        c0935q = c0935q.m7955g();
                        if (m7980a.m7968a() == 15) {
                            m6755a = 14;
                            abstractC0945a2 = C0959m.m8060a(-((C0959m) m7932h4).m8061k_());
                        } else {
                            abstractC0945a2 = abstractC0945a3;
                        }
                    } else {
                        abstractC0945a2 = (AbstractC0945a) m7932h3;
                        c0935q = c0935q.m7954f();
                    }
                    c0937s = C0939u.m7980a(m6755a, interfaceC0976d, c0935q, abstractC0945a2);
                    abstractC0945a = abstractC0945a2;
                }
            }
            c0937s = m7980a;
            abstractC0945a = f2;
        }
        C0727w h = m6548h();
        ArrayList<AbstractC0945a> i5 = m6549i();
        boolean m7975h = c0937s.m7975h();
        this.f4599n |= m7975h;
        if (h != null) {
            if (h.m6779a() == 0) {
                c0932n2 = new C0932n(C0939u.f6120s, m6602a, (C0934p) null, C0935q.f5906a);
                this.f4596k = 0;
            } else {
                C1025p m6786e = h.m6786e();
                c0932n2 = new C0941w(c0937s, m6602a, c0934p, c0935q, m6786e);
                this.f4596k = m6786e.m8568b();
            }
        } else if (m6755a == 33) {
            if (c0935q.m8550f_() != 0) {
                C0934p m7949b2 = c0935q.m7949b(0);
                InterfaceC0976d m7932h5 = m7949b2.m7932h();
                if (m7949b2.m7931g() != 0) {
                    this.f4592g.add(new C0932n(C0939u.m7982a(m7932h5), m6602a, C0934p.m7913a(0, m7932h5), m7949b2));
                }
            }
            c0932n2 = new C0932n(C0939u.f6120s, m6602a, (C0934p) null, C0935q.f5906a);
            this.f4596k = 0;
            m6757a(c0937s, m6602a);
            this.f4595j = true;
        } else if (abstractC0945a != null) {
            if (m7975h) {
                C0942x c0942x2 = new C0942x(c0937s, m6602a, c0935q, this.f4593h, abstractC0945a);
                this.f4594i = true;
                this.f4596k = this.f4593h.mo6856f_();
                c0932n2 = c0942x2;
            } else {
                c0932n2 = new C0931m(c0937s, m6602a, c0934p, c0935q, abstractC0945a);
            }
        } else if (m7975h) {
            c0932n2 = new C0943y(c0937s, m6602a, c0935q, this.f4593h);
            this.f4594i = true;
            if (i2 == 191) {
                this.f4596k = -1;
            } else {
                this.f4596k = this.f4593h.mo6856f_();
            }
        } else {
            c0932n2 = new C0932n(c0937s, m6602a, c0934p, c0935q);
        }
        this.f4592g.add(c0932n2);
        if (c0932n != null) {
            this.f4592g.add(c0932n);
        }
        if (i5 != null) {
            this.f4597l++;
            this.f4592g.add(new C0925g(C0939u.f6078cY, m6602a, C0935q.m7944a(c0932n.m7884h()), i5, abstractC0945a));
        }
    }

    /* renamed from: a */
    private C0935q m6756a(int i, int i2) {
        C0935q c0935q;
        int c2 = m6541c();
        if (c2 == 0) {
            return C0935q.f5906a;
        }
        int j = m6550j();
        if (j >= 0) {
            c0935q = new C0935q(1);
            c0935q.m7948a(0, C0934p.m7913a(j, m6542c(0)));
        } else {
            c0935q = new C0935q(c2);
            for (int i3 = 0; i3 < c2; i3++) {
                C0934p m7913a = C0934p.m7913a(i2, m6542c(i3));
                c0935q.m7948a(i3, m7913a);
                i2 += m7913a.m7935k();
            }
            switch (i) {
                case 79:
                    if (c2 != 3) {
                        throw new RuntimeException("shouldn't happen");
                    }
                    C0934p m7949b = c0935q.m7949b(0);
                    C0934p m7949b2 = c0935q.m7949b(1);
                    c0935q.m7948a(0, c0935q.m7949b(2));
                    c0935q.m7948a(1, m7949b);
                    c0935q.m7948a(2, m7949b2);
                    break;
                case 181:
                    if (c2 != 2) {
                        throw new RuntimeException("shouldn't happen");
                    }
                    C0934p m7949b3 = c0935q.m7949b(0);
                    c0935q.m7948a(0, c0935q.m7949b(1));
                    c0935q.m7948a(1, m7949b3);
                    break;
            }
        }
        c0935q.mo6683e_();
        return c0935q;
    }

    /* renamed from: a */
    private void m6757a(C0937s c0937s, C0940v c0940v) {
        if (c0937s == null) {
            throw new NullPointerException("op == null");
        }
        if (c0940v == null) {
            throw new NullPointerException("pos == null");
        }
        if (this.f4601p == null) {
            this.f4601p = c0937s;
            this.f4602q = c0940v;
        } else {
            if (this.f4601p != c0937s) {
                throw new C0725u("return op mismatch: " + c0937s + ", " + this.f4601p);
            }
            if (c0940v.m8028a() > this.f4602q.m8028a()) {
                this.f4602q = c0940v;
            }
        }
    }

    /* renamed from: a */
    private int m6755a(int i, AbstractC0945a abstractC0945a) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
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
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
            case 56:
            case 57:
            case 58:
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
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 98:
            case 99:
            case 101:
            case 102:
            case 103:
            case 105:
            case 106:
            case 107:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 117:
            case 118:
            case 119:
            case 121:
            case 123:
            case 125:
            case 127:
            case 129:
            case 131:
            case 168:
            case 169:
            case 170:
            case 173:
            case 174:
            case 175:
            case 176:
            case 186:
            case 196:
            case 197:
            default:
                throw new RuntimeException("shouldn't happen");
            case 18:
            case 20:
                return 5;
            case 21:
            case 54:
                return 2;
            case 46:
                return 38;
            case 79:
                return 39;
            case 96:
            case 132:
                return 14;
            case 100:
                return 15;
            case 104:
                return 16;
            case 108:
                return 17;
            case 112:
                return 18;
            case 116:
                return 19;
            case 120:
                return 23;
            case 122:
                return 24;
            case 124:
                return 25;
            case 126:
                return 20;
            case 128:
                return 21;
            case 130:
                return 22;
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
                return 29;
            case 145:
                return 30;
            case 146:
                return 31;
            case 147:
                return 32;
            case 148:
            case 149:
            case 151:
                return 27;
            case 150:
            case 152:
                return 28;
            case 153:
            case 159:
            case 165:
            case 198:
                return 7;
            case 154:
            case 160:
            case 166:
            case 199:
                return 8;
            case 155:
            case 161:
                return 9;
            case 156:
            case 162:
                return 10;
            case 157:
            case 163:
                return 12;
            case 158:
            case 164:
                return 11;
            case 167:
                return 6;
            case 171:
                return 13;
            case 172:
            case 177:
                return 33;
            case 178:
                return 46;
            case 179:
                return 48;
            case 180:
                return 45;
            case 181:
                return 47;
            case 182:
                return 50;
            case 183:
                C0967u c0967u = (C0967u) abstractC0945a;
                if (c0967u.m8048j() || c0967u.m8070m() == this.f4589d.mo6608f() || !this.f4589d.m6610h()) {
                    return 52;
                }
                return 51;
            case 184:
                return 49;
            case 185:
                return 53;
            case 187:
                return 40;
            case 188:
            case 189:
                return 41;
            case 190:
                return 34;
            case 191:
                return 35;
            case 192:
                return 43;
            case 193:
                return 44;
            case 194:
                return 36;
            case 195:
                return 37;
        }
    }
}
