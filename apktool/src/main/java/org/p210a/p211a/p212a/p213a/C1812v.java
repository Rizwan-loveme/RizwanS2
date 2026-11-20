package org.p210a.p211a.p212a.p213a;

import java.util.Iterator;
import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.C1871s;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p214b.C1827a;
import org.p210a.p211a.p212a.p214b.C1829c;
import org.p210a.p211a.p212a.p215c.C1839i;

/* compiled from: LexerATNSimulator.java */
/* renamed from: org.a.a.a.a.v */
/* loaded from: classes.dex */
public class C1812v extends AbstractC1796f {

    /* renamed from: m */
    public static int f10821m;

    /* renamed from: n */
    static final /* synthetic */ boolean f10822n;

    /* renamed from: f */
    protected final AbstractC1870r f10823f;

    /* renamed from: g */
    protected int f10824g;

    /* renamed from: h */
    protected int f10825h;

    /* renamed from: i */
    protected int f10826i;

    /* renamed from: j */
    public final C1827a[] f10827j;

    /* renamed from: k */
    protected int f10828k;

    /* renamed from: l */
    protected final a f10829l;

    static {
        f10822n = !C1812v.class.desiredAssertionStatus();
        f10821m = 0;
    }

    /* compiled from: LexerATNSimulator.java */
    /* renamed from: org.a.a.a.a.v$a */
    protected static class a {

        /* renamed from: a */
        protected int f10830a = -1;

        /* renamed from: b */
        protected int f10831b = 0;

        /* renamed from: c */
        protected int f10832c = -1;

        /* renamed from: d */
        protected C1829c f10833d;

        protected a() {
        }

        /* renamed from: a */
        protected void m13665a() {
            this.f10830a = -1;
            this.f10831b = 0;
            this.f10832c = -1;
            this.f10833d = null;
        }
    }

    public C1812v(AbstractC1870r abstractC1870r, C1759a c1759a, C1827a[] c1827aArr, C1777ar c1777ar) {
        super(c1759a, c1777ar);
        this.f10824g = -1;
        this.f10825h = 1;
        this.f10826i = 0;
        this.f10828k = 0;
        this.f10829l = new a();
        this.f10827j = c1827aArr;
        this.f10823f = abstractC1870r;
    }

    /* renamed from: a */
    public int m13646a(InterfaceC1858f interfaceC1858f, int i) {
        f10821m++;
        this.f10828k = i;
        int e2 = interfaceC1858f.mo13720e();
        try {
            this.f10824g = interfaceC1858f.mo13717c();
            this.f10829l.m13665a();
            C1827a c1827a = this.f10827j[i];
            return c1827a.f10855b == null ? m13645a(interfaceC1858f) : m13647a(interfaceC1858f, c1827a.f10855b);
        } finally {
            interfaceC1858f.mo13716b(e2);
        }
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1796f
    /* renamed from: a */
    public void mo13524a() {
        this.f10829l.m13665a();
        this.f10824g = -1;
        this.f10825h = 1;
        this.f10826i = 0;
        this.f10828k = 0;
    }

    /* renamed from: a */
    protected int m13645a(InterfaceC1858f interfaceC1858f) {
        C1790bd c1790bd = this.f10794d.f10699j.get(this.f10828k);
        int i = this.f10828k;
        C1793c m13648a = m13648a(interfaceC1858f, c1790bd);
        boolean z = m13648a.f10770f;
        m13648a.f10770f = false;
        C1829c m13651a = m13651a(m13648a);
        if (!z) {
            this.f10827j[this.f10828k].f10855b = m13651a;
        }
        return m13647a(interfaceC1858f, m13651a);
    }

    /* renamed from: a */
    protected int m13647a(InterfaceC1858f interfaceC1858f, C1829c c1829c) {
        if (c1829c.f10865d) {
            m13655a(this.f10829l, interfaceC1858f, c1829c);
        }
        int a2 = interfaceC1858f.mo13711a(1);
        while (true) {
            C1829c m13652a = m13652a(c1829c, a2);
            if (m13652a == null) {
                m13652a = m13654a(interfaceC1858f, c1829c, a2);
            }
            if (m13652a == f10793c) {
                break;
            }
            if (a2 != -1) {
                m13664c(interfaceC1858f);
            }
            if (m13652a.f10865d) {
                m13655a(this.f10829l, interfaceC1858f, m13652a);
                if (a2 == -1) {
                    break;
                }
            }
            a2 = interfaceC1858f.mo13711a(1);
            c1829c = m13652a;
        }
        return m13644a(this.f10829l, interfaceC1858f, c1829c.f10863b, a2);
    }

    /* renamed from: a */
    protected C1829c m13652a(C1829c c1829c, int i) {
        if (c1829c.f10864c == null || i < 0 || i > 127) {
            return null;
        }
        return c1829c.f10864c[i + 0];
    }

    /* renamed from: a */
    protected C1829c m13654a(InterfaceC1858f interfaceC1858f, C1829c c1829c, int i) {
        C1770ak c1770ak = new C1770ak();
        m13657a(interfaceC1858f, c1829c.f10863b, c1770ak, i);
        if (!c1770ak.isEmpty()) {
            return m13653a(c1829c, i, c1770ak);
        }
        if (!c1770ak.f10770f) {
            m13656a(c1829c, i, f10793c);
        }
        return f10793c;
    }

    /* renamed from: a */
    protected int m13644a(a aVar, InterfaceC1858f interfaceC1858f, C1793c c1793c, int i) {
        if (aVar.f10833d != null) {
            m13658a(interfaceC1858f, aVar.f10833d.f10867f, this.f10824g, aVar.f10830a, aVar.f10831b, aVar.f10832c);
            return aVar.f10833d.f10866e;
        }
        if (i == -1 && interfaceC1858f.mo13717c() == this.f10824g) {
            return -1;
        }
        throw new C1871s(this.f10823f, interfaceC1858f, this.f10824g, c1793c);
    }

    /* renamed from: a */
    protected void m13657a(InterfaceC1858f interfaceC1858f, C1793c c1793c, C1793c c1793c2, int i) {
        Iterator<C1786b> it = c1793c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C1786b next = it.next();
            boolean z = next.f10756b == i2;
            if (!z || !((C1811u) next).m13643d()) {
                int m13630a = next.f10755a.m13630a();
                int i3 = 0;
                while (true) {
                    if (i3 >= m13630a) {
                        break;
                    }
                    AbstractC1797g m13649a = m13649a(next.f10755a.m13631a(i3), i);
                    if (m13649a != null) {
                        C1814x m13642c = ((C1811u) next).m13642c();
                        if (m13660a(interfaceC1858f, new C1811u((C1811u) next, m13649a, m13642c != null ? m13642c.m13667a(interfaceC1858f.mo13717c() - this.f10824g) : m13642c), c1793c2, z, true, i == -1)) {
                            i2 = next.f10756b;
                            break;
                        }
                    }
                    i3++;
                }
            }
        }
    }

    /* renamed from: a */
    protected void m13658a(InterfaceC1858f interfaceC1858f, C1814x c1814x, int i, int i2, int i3, int i4) {
        interfaceC1858f.mo13718c(i2);
        this.f10825h = i3;
        this.f10826i = i4;
        if (c1814x != null && this.f10823f != null) {
            c1814x.m13668a(this.f10823f, interfaceC1858f, i);
        }
    }

    /* renamed from: a */
    protected AbstractC1797g m13649a(AbstractC1791be abstractC1791be, int i) {
        if (abstractC1791be.mo13501a(i, 0, 1114111)) {
            return abstractC1791be.f10764f;
        }
        return null;
    }

    /* renamed from: a */
    protected C1793c m13648a(InterfaceC1858f interfaceC1858f, AbstractC1797g abstractC1797g) {
        C1808r c1808r = AbstractC1776aq.f10726d;
        C1770ak c1770ak = new C1770ak();
        for (int i = 0; i < abstractC1797g.m13630a(); i++) {
            m13660a(interfaceC1858f, new C1811u(abstractC1797g.m13631a(i).f10764f, i + 1, c1808r), (C1793c) c1770ak, false, false, false);
        }
        return c1770ak;
    }

    /* renamed from: a */
    protected boolean m13660a(InterfaceC1858f interfaceC1858f, C1811u c1811u, C1793c c1793c, boolean z, boolean z2, boolean z3) {
        int i = 0;
        if (c1811u.f10755a instanceof C1781av) {
            if (c1811u.f10757c == null || c1811u.f10757c.m13557c()) {
                if (c1811u.f10757c == null || c1811u.f10757c.mo13554a()) {
                    c1793c.add(c1811u);
                    return true;
                }
                c1793c.add(new C1811u(c1811u, c1811u.f10755a, AbstractC1776aq.f10726d));
                z = true;
            }
            if (c1811u.f10757c != null && !c1811u.f10757c.mo13554a()) {
                boolean z4 = z;
                for (int i2 = 0; i2 < c1811u.f10757c.mo13555b(); i2++) {
                    if (c1811u.f10757c.mo13556b(i2) != Integer.MAX_VALUE) {
                        z4 = m13660a(interfaceC1858f, new C1811u(c1811u, this.f10794d.f10690a.get(c1811u.f10757c.mo13556b(i2)), c1811u.f10757c.mo13553a(i2)), c1793c, z4, z2, z3);
                    }
                }
                return z4;
            }
            return z;
        }
        if (!c1811u.f10755a.m13636c() && (!z || !c1811u.m13643d())) {
            c1793c.add(c1811u);
        }
        AbstractC1797g abstractC1797g = c1811u.f10755a;
        while (true) {
            int i3 = i;
            if (i3 < abstractC1797g.m13630a()) {
                C1811u m13650a = m13650a(interfaceC1858f, c1811u, abstractC1797g.m13631a(i3), c1793c, z2, z3);
                if (m13650a != null) {
                    z = m13660a(interfaceC1858f, m13650a, c1793c, z, z2, z3);
                }
                i = i3 + 1;
            } else {
                return z;
            }
        }
    }

    /* renamed from: a */
    protected C1811u m13650a(InterfaceC1858f interfaceC1858f, C1811u c1811u, AbstractC1791be abstractC1791be, C1793c c1793c, boolean z, boolean z2) {
        switch (abstractC1791be.mo13500a()) {
            case 1:
                return new C1811u(c1811u, abstractC1791be.f10764f);
            case 2:
            case 5:
            case 7:
                if (z2 && abstractC1791be.mo13501a(-1, 0, 1114111)) {
                    return new C1811u(c1811u, abstractC1791be.f10764f);
                }
                break;
            case 3:
                return new C1811u(c1811u, abstractC1791be.f10764f, C1785az.m13585b(c1811u.f10757c, ((C1782aw) abstractC1791be).f10743c.f10798c));
            case 4:
                C1775ap c1775ap = (C1775ap) abstractC1791be;
                c1793c.f10770f = true;
                if (m13659a(interfaceC1858f, c1775ap.f10723a, c1775ap.f10724b, z)) {
                    return new C1811u(c1811u, abstractC1791be.f10764f);
                }
                break;
            case 6:
                if (c1811u.f10757c == null || c1811u.f10757c.m13557c()) {
                    return new C1811u(c1811u, abstractC1791be.f10764f, C1814x.m13666a(c1811u.m13642c(), this.f10794d.f10698i[((C1800j) abstractC1791be).f10807b]));
                }
                return new C1811u(c1811u, abstractC1791be.f10764f);
            case 10:
                throw new UnsupportedOperationException("Precedence predicates are not supported in lexers.");
        }
        return null;
    }

    /* renamed from: a */
    protected boolean m13659a(InterfaceC1858f interfaceC1858f, int i, int i2, boolean z) {
        if (this.f10823f == null) {
            return true;
        }
        if (!z) {
            return this.f10823f.mo4147a(null, i, i2);
        }
        int i3 = this.f10826i;
        int i4 = this.f10825h;
        int c2 = interfaceC1858f.mo13717c();
        int e2 = interfaceC1858f.mo13720e();
        try {
            m13664c(interfaceC1858f);
            return this.f10823f.mo4147a(null, i, i2);
        } finally {
            this.f10826i = i3;
            this.f10825h = i4;
            interfaceC1858f.mo13718c(c2);
            interfaceC1858f.mo13716b(e2);
        }
    }

    /* renamed from: a */
    protected void m13655a(a aVar, InterfaceC1858f interfaceC1858f, C1829c c1829c) {
        aVar.f10830a = interfaceC1858f.mo13717c();
        aVar.f10831b = this.f10825h;
        aVar.f10832c = this.f10826i;
        aVar.f10833d = c1829c;
    }

    /* renamed from: a */
    protected C1829c m13653a(C1829c c1829c, int i, C1793c c1793c) {
        boolean z = c1793c.f10770f;
        c1793c.f10770f = false;
        C1829c m13651a = m13651a(c1793c);
        if (!z) {
            m13656a(c1829c, i, m13651a);
        }
        return m13651a;
    }

    /* renamed from: a */
    protected void m13656a(C1829c c1829c, int i, C1829c c1829c2) {
        if (i >= 0 && i <= 127) {
            synchronized (c1829c) {
                if (c1829c.f10864c == null) {
                    c1829c.f10864c = new C1829c[128];
                }
                c1829c.f10864c[i + 0] = c1829c2;
            }
        }
    }

    /* renamed from: a */
    protected C1829c m13651a(C1793c c1793c) {
        if (!f10822n && c1793c.f10770f) {
            throw new AssertionError();
        }
        C1829c c1829c = new C1829c(c1793c);
        C1786b c1786b = null;
        Iterator<C1786b> it = c1793c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1786b next = it.next();
            if (next.f10755a instanceof C1781av) {
                c1786b = next;
                break;
            }
        }
        if (c1786b != null) {
            c1829c.f10865d = true;
            c1829c.f10867f = ((C1811u) c1786b).m13642c();
            c1829c.f10866e = this.f10794d.f10697h[c1786b.f10755a.f10799d];
        }
        C1827a c1827a = this.f10827j[this.f10828k];
        synchronized (c1827a.f10854a) {
            C1829c c1829c2 = c1827a.f10854a.get(c1829c);
            if (c1829c2 == null) {
                c1829c.f10862a = c1827a.f10854a.size();
                c1793c.m13593a(true);
                c1829c.f10863b = c1793c;
                c1827a.f10854a.put(c1829c, c1829c);
                return c1829c;
            }
            return c1829c2;
        }
    }

    /* renamed from: b */
    public String m13662b(InterfaceC1858f interfaceC1858f) {
        return interfaceC1858f.mo13712a(C1839i.m13746a(this.f10824g, interfaceC1858f.mo13717c() - 1));
    }

    /* renamed from: b */
    public int m13661b() {
        return this.f10825h;
    }

    /* renamed from: c */
    public int m13663c() {
        return this.f10826i;
    }

    /* renamed from: c */
    public void m13664c(InterfaceC1858f interfaceC1858f) {
        if (interfaceC1858f.mo13711a(1) == 10) {
            this.f10825h++;
            this.f10826i = 0;
        } else {
            this.f10826i++;
        }
        interfaceC1858f.mo13715b();
    }
}
