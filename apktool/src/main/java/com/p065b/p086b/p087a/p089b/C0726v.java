package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p087a.p089b.C0711g;
import com.p065b.p086b.p087a.p089b.C0716l;
import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0960n;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0973a;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;
import java.util.ArrayList;

/* compiled from: Simulator.java */
/* renamed from: com.b.b.a.b.v */
/* loaded from: classes.dex */
public class C0726v {

    /* renamed from: a */
    private final InterfaceC0719o f4603a;

    /* renamed from: b */
    private final C0711g f4604b;

    /* renamed from: c */
    private final C0716l f4605c;

    /* renamed from: d */
    private final a f4606d;

    public C0726v(InterfaceC0719o interfaceC0719o, C0712h c0712h) {
        if (interfaceC0719o == null) {
            throw new NullPointerException("machine == null");
        }
        if (c0712h == null) {
            throw new NullPointerException("method == null");
        }
        this.f4603a = interfaceC0719o;
        this.f4604b = c0712h.m6613k();
        this.f4605c = c0712h.m6615m();
        this.f4606d = new a();
    }

    /* renamed from: a */
    public void m6776a(C0707c c0707c, C0714j c0714j) {
        int m6570c = c0707c.m6570c();
        this.f4606d.m6778a(c0714j);
        try {
            int m6569b = c0707c.m6569b();
            while (m6569b < m6570c) {
                int m6595a = this.f4604b.m6595a(m6569b, this.f4606d);
                this.f4606d.mo6560a(m6569b);
                m6569b += m6595a;
            }
        } catch (C0725u e2) {
            c0714j.m6640a(e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C0725u m6774b() {
        return new C0725u("stack mismatch: illegal top-of-stack for opcode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C0975c m6775b(C0975c c0975c, C0975c c0975c2) {
        if (c0975c2 == C0975c.f6255j) {
            return c0975c.m8137t();
        }
        if (c0975c != C0975c.f6260o || !c0975c2.m8133p() || !c0975c2.m8138u().m8132o()) {
            if (c0975c == C0975c.f6247b && c0975c2 == C0975c.f6236B) {
                return C0975c.f6236B;
            }
            return c0975c.m8137t();
        }
        return c0975c2;
    }

    /* compiled from: Simulator.java */
    /* renamed from: com.b.b.a.b.v$a */
    private class a implements C0711g.c {

        /* renamed from: b */
        private final InterfaceC0719o f4608b;

        /* renamed from: c */
        private C0714j f4609c = null;

        /* renamed from: d */
        private int f4610d;

        public a() {
            this.f4608b = C0726v.this.f4603a;
        }

        /* renamed from: a */
        public void m6778a(C0714j c0714j) {
            if (c0714j == null) {
                throw new NullPointerException("frame == null");
            }
            this.f4609c = c0714j;
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6561a(int i, int i2, int i3) {
            throw new C0725u("invalid opcode " + C1022m.m8559e(i));
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6566a(int i, int i2, int i3, C0975c c0975c) {
            int i4;
            switch (i) {
                case 0:
                    this.f4608b.mo6537b();
                    break;
                case 46:
                    C0975c m6775b = C0726v.m6775b(c0975c, this.f4609c.m6644d().m6627c(1));
                    c0975c = m6775b.m8138u();
                    this.f4608b.mo6528a(this.f4609c, m6775b, C0975c.f6251f);
                    break;
                case 79:
                    C0713i m6644d = this.f4609c.m6644d();
                    int i5 = c0975c.m8128k() ? 2 : 3;
                    C0975c m6627c = m6644d.m6627c(i5);
                    boolean m6626b = m6644d.m6626b(i5);
                    C0975c m6775b2 = C0726v.m6775b(c0975c, m6627c);
                    if (m6626b) {
                        c0975c = m6775b2.m8138u();
                    }
                    this.f4608b.mo6529a(this.f4609c, m6775b2, C0975c.f6251f, c0975c);
                    break;
                case 87:
                    if (this.f4609c.m6644d().m6627c(0).m8129l()) {
                        throw C0726v.m6774b();
                    }
                    this.f4608b.mo6525a(this.f4609c, 1);
                    break;
                case 88:
                case 92:
                    C0713i m6644d2 = this.f4609c.m6644d();
                    if (m6644d2.m6627c(0).m8129l()) {
                        this.f4608b.mo6525a(this.f4609c, 1);
                        i4 = 17;
                    } else {
                        if (!m6644d2.m6627c(1).m8128k()) {
                            throw C0726v.m6774b();
                        }
                        this.f4608b.mo6525a(this.f4609c, 2);
                        i4 = 8481;
                    }
                    if (i == 92) {
                        this.f4608b.mo6522a(i4);
                        break;
                    }
                    break;
                case 89:
                    if (this.f4609c.m6644d().m6627c(0).m8129l()) {
                        throw C0726v.m6774b();
                    }
                    this.f4608b.mo6525a(this.f4609c, 1);
                    this.f4608b.mo6522a(17);
                    break;
                case 90:
                    C0713i m6644d3 = this.f4609c.m6644d();
                    if (!m6644d3.m6627c(0).m8128k() || !m6644d3.m6627c(1).m8128k()) {
                        throw C0726v.m6774b();
                    }
                    this.f4608b.mo6525a(this.f4609c, 2);
                    this.f4608b.mo6522a(530);
                    break;
                    break;
                case 91:
                    C0713i m6644d4 = this.f4609c.m6644d();
                    if (m6644d4.m6627c(0).m8129l()) {
                        throw C0726v.m6774b();
                    }
                    if (m6644d4.m6627c(1).m8129l()) {
                        this.f4608b.mo6525a(this.f4609c, 2);
                        this.f4608b.mo6522a(530);
                        break;
                    } else {
                        if (!m6644d4.m6627c(2).m8128k()) {
                            throw C0726v.m6774b();
                        }
                        this.f4608b.mo6525a(this.f4609c, 3);
                        this.f4608b.mo6522a(12819);
                        break;
                    }
                case 93:
                    C0713i m6644d5 = this.f4609c.m6644d();
                    if (m6644d5.m6627c(0).m8129l()) {
                        if (m6644d5.m6627c(2).m8129l()) {
                            throw C0726v.m6774b();
                        }
                        this.f4608b.mo6525a(this.f4609c, 2);
                        this.f4608b.mo6522a(530);
                        break;
                    } else {
                        if (m6644d5.m6627c(1).m8129l() || m6644d5.m6627c(2).m8129l()) {
                            throw C0726v.m6774b();
                        }
                        this.f4608b.mo6525a(this.f4609c, 3);
                        this.f4608b.mo6522a(205106);
                        break;
                    }
                    break;
                case 94:
                    C0713i m6644d6 = this.f4609c.m6644d();
                    if (m6644d6.m6627c(0).m8129l()) {
                        if (m6644d6.m6627c(2).m8129l()) {
                            this.f4608b.mo6525a(this.f4609c, 2);
                            this.f4608b.mo6522a(530);
                            break;
                        } else {
                            if (!m6644d6.m6627c(3).m8128k()) {
                                throw C0726v.m6774b();
                            }
                            this.f4608b.mo6525a(this.f4609c, 3);
                            this.f4608b.mo6522a(12819);
                            break;
                        }
                    } else {
                        if (!m6644d6.m6627c(1).m8128k()) {
                            throw C0726v.m6774b();
                        }
                        if (m6644d6.m6627c(2).m8129l()) {
                            this.f4608b.mo6525a(this.f4609c, 3);
                            this.f4608b.mo6522a(205106);
                            break;
                        } else {
                            if (!m6644d6.m6627c(3).m8128k()) {
                                throw C0726v.m6774b();
                            }
                            this.f4608b.mo6525a(this.f4609c, 4);
                            this.f4608b.mo6522a(4399427);
                            break;
                        }
                    }
                case 95:
                    C0713i m6644d7 = this.f4609c.m6644d();
                    if (!m6644d7.m6627c(0).m8128k() || !m6644d7.m6627c(1).m8128k()) {
                        throw C0726v.m6774b();
                    }
                    this.f4608b.mo6525a(this.f4609c, 2);
                    this.f4608b.mo6522a(18);
                    break;
                    break;
                case 96:
                case 100:
                case 104:
                case 108:
                case 112:
                case 126:
                case 128:
                case 130:
                    this.f4608b.mo6528a(this.f4609c, c0975c, c0975c);
                    break;
                case 116:
                    this.f4608b.mo6527a(this.f4609c, c0975c);
                    break;
                case 120:
                case 122:
                case 124:
                    this.f4608b.mo6528a(this.f4609c, c0975c, C0975c.f6251f);
                    break;
                case 133:
                case 134:
                case 135:
                case 145:
                case 146:
                case 147:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6251f);
                    break;
                case 136:
                case 137:
                case 138:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6252g);
                    break;
                case 139:
                case 140:
                case 141:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6250e);
                    break;
                case 142:
                case 143:
                case 144:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6249d);
                    break;
                case 148:
                    this.f4608b.mo6528a(this.f4609c, C0975c.f6252g, C0975c.f6252g);
                    break;
                case 149:
                case 150:
                    this.f4608b.mo6528a(this.f4609c, C0975c.f6250e, C0975c.f6250e);
                    break;
                case 151:
                case 152:
                    this.f4608b.mo6528a(this.f4609c, C0975c.f6249d, C0975c.f6249d);
                    break;
                case 172:
                    C0975c m6627c2 = c0975c == C0975c.f6260o ? this.f4609c.m6644d().m6627c(0) : c0975c;
                    this.f4608b.mo6527a(this.f4609c, c0975c);
                    m6777a(m6627c2);
                    break;
                case 177:
                    this.f4608b.mo6537b();
                    m6777a(C0975c.f6254i);
                    break;
                case 190:
                    C0975c m6627c3 = this.f4609c.m6644d().m6627c(0);
                    if (!m6627c3.m8134q()) {
                        throw new C0725u("type mismatch: expected array type but encountered " + m6627c3.mo6681d());
                    }
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6260o);
                    break;
                case 191:
                case 194:
                case 195:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6260o);
                    break;
                default:
                    mo6561a(i, i2, i3);
                    return;
            }
            this.f4608b.mo6532a(c0975c);
            this.f4608b.mo6684a(this.f4609c, i2, i);
        }

        /* renamed from: a */
        private void m6777a(C0975c c0975c) {
            C0975c m8103b = this.f4608b.mo6521a().m8103b();
            if (!C0720p.m6688b(m8103b, c0975c)) {
                throw new C0725u("return type mismatch: prototype indicates " + m8103b.mo6681d() + ", but encountered type " + c0975c.mo6681d());
            }
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6563a(int i, int i2, int i3, int i4, C0975c c0975c, int i5) {
            C0975c c0975c2;
            C0716l.a m6656a = C0726v.this.f4605c.m6656a(i == 54 ? i2 + i3 : i2, i4);
            if (m6656a != null) {
                C0975c m6666b = m6656a.m6666b();
                if (m6666b.mo6698e() != c0975c.mo6698e()) {
                    AbstractC0705a.m6520a(c0975c, m6666b);
                    return;
                }
                c0975c2 = m6666b;
            } else {
                c0975c2 = c0975c;
            }
            switch (i) {
                case 21:
                case 169:
                    this.f4608b.mo6539b(this.f4609c, i4);
                    this.f4608b.mo6535a(m6656a != null);
                    this.f4608b.mo6532a(c0975c);
                    break;
                case 54:
                    C0928j m6663a = m6656a == null ? null : m6656a.m6663a();
                    this.f4608b.mo6527a(this.f4609c, c0975c);
                    this.f4608b.mo6532a(c0975c);
                    this.f4608b.mo6523a(i4, c0975c2, m6663a);
                    break;
                case 132:
                    C0928j m6663a2 = m6656a != null ? m6656a.m6663a() : null;
                    this.f4608b.mo6539b(this.f4609c, i4);
                    this.f4608b.mo6523a(i4, c0975c2, m6663a2);
                    this.f4608b.mo6532a(c0975c);
                    this.f4608b.mo6522a(i5);
                    this.f4608b.mo6531a(C0959m.m8060a(i5));
                    break;
                default:
                    mo6561a(i, i2, i3);
                    return;
            }
            this.f4608b.mo6684a(this.f4609c, i2, i);
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6565a(int i, int i2, int i3, AbstractC0945a abstractC0945a, int i4) {
            AbstractC0945a abstractC0945a2;
            switch (i) {
                case 179:
                    this.f4608b.mo6527a(this.f4609c, ((C0957k) abstractC0945a).mo6695a());
                    break;
                case 180:
                case 192:
                case 193:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6260o);
                    break;
                case 181:
                    this.f4608b.mo6528a(this.f4609c, C0975c.f6260o, ((C0957k) abstractC0945a).mo6695a());
                    break;
                case 182:
                case 183:
                    abstractC0945a2 = abstractC0945a;
                    this.f4608b.mo6526a(this.f4609c, ((C0967u) abstractC0945a2).m8045a(false));
                    abstractC0945a = abstractC0945a2;
                    break;
                case 184:
                    this.f4608b.mo6526a(this.f4609c, ((C0967u) abstractC0945a).m8045a(true));
                    break;
                case 185:
                    abstractC0945a2 = ((C0960n) abstractC0945a).m8062l();
                    this.f4608b.mo6526a(this.f4609c, ((C0967u) abstractC0945a2).m8045a(false));
                    abstractC0945a = abstractC0945a2;
                    break;
                case 186:
                case 187:
                case 188:
                case 190:
                case 191:
                case 194:
                case 195:
                case 196:
                default:
                    this.f4608b.mo6537b();
                    break;
                case 189:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6251f);
                    break;
                case 197:
                    this.f4608b.mo6526a(this.f4609c, C0973a.m8095a(C0975c.f6254i, i4));
                    break;
            }
            this.f4608b.mo6522a(i4);
            this.f4608b.mo6531a(abstractC0945a);
            this.f4608b.mo6684a(this.f4609c, i2, i);
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6562a(int i, int i2, int i3, int i4) {
            switch (i) {
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6251f);
                    break;
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                    this.f4608b.mo6528a(this.f4609c, C0975c.f6251f, C0975c.f6251f);
                    break;
                case 165:
                case 166:
                    this.f4608b.mo6528a(this.f4609c, C0975c.f6260o, C0975c.f6260o);
                    break;
                case 167:
                case 168:
                case 200:
                case 201:
                    this.f4608b.mo6537b();
                    break;
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case 190:
                case 191:
                case 192:
                case 193:
                case 194:
                case 195:
                case 196:
                case 197:
                default:
                    mo6561a(i, i2, i3);
                    return;
                case 198:
                case 199:
                    this.f4608b.mo6527a(this.f4609c, C0975c.f6260o);
                    break;
            }
            this.f4608b.mo6538b(i4);
            this.f4608b.mo6684a(this.f4609c, i2, i);
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6564a(int i, int i2, int i3, C0727w c0727w, int i4) {
            this.f4608b.mo6527a(this.f4609c, C0975c.f6251f);
            this.f4608b.mo6522a(i4);
            this.f4608b.mo6530a(c0727w);
            this.f4608b.mo6684a(this.f4609c, i2, i);
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6567a(int i, int i2, C0971y c0971y, ArrayList<AbstractC0945a> arrayList) {
            this.f4608b.mo6527a(this.f4609c, C0975c.f6251f);
            this.f4608b.mo6534a(arrayList);
            this.f4608b.mo6531a(c0971y);
            this.f4608b.mo6684a(this.f4609c, i, 188);
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6560a(int i) {
            this.f4610d = i;
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public int mo6559a() {
            return this.f4610d;
        }
    }
}
