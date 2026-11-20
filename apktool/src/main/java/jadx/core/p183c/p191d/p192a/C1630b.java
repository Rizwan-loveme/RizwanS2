package jadx.core.p183c.p191d.p192a;

import jadx.core.p182b.C1559d;
import jadx.core.p183c.p184a.p186b.C1582p;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.p205b.C1725b;
import java.util.Iterator;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p251a.InterfaceC2167b;
import org.p226d.p233b.p250e.p251a.InterfaceC2169d;
import org.p226d.p233b.p250e.p251a.InterfaceC2172g;
import org.p226d.p233b.p250e.p251a.InterfaceC2173h;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;

/* compiled from: DebugInfoParser.java */
/* renamed from: jadx.core.c.d.a.b */
/* loaded from: classes.dex */
public class C1630b {

    /* renamed from: a */
    private final C1648n f10312a;

    /* renamed from: b */
    private final Iterable<? extends InterfaceC2166a> f10313b;

    /* renamed from: c */
    private final C1637c f10314c;

    /* renamed from: d */
    private final C1633e[] f10315d;

    /* renamed from: e */
    private final AbstractC1598c[] f10316e;

    /* renamed from: f */
    private final C1646l[] f10317f;

    public C1630b(C1648n c1648n, Iterable<? extends InterfaceC2166a> iterable, C1646l[] c1646lArr) {
        this.f10312a = c1648n;
        this.f10314c = c1648n.mo12540t();
        this.f10313b = iterable;
        int m12612J = c1648n.m12612J();
        this.f10315d = new C1633e[m12612J];
        this.f10316e = new AbstractC1598c[m12612J];
        this.f10317f = c1646lArr;
    }

    /* renamed from: a */
    public void m12466a() {
        for (C1604i c1604i : this.f10312a.m12620a(false)) {
            int m12330o = c1604i.m12330o();
            this.f10315d[m12330o] = new C1633e(c1604i);
            this.f10316e[m12330o] = c1604i;
        }
        m12458a(-1, 1, 0);
        m12459a(0, 0);
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (InterfaceC2166a interfaceC2166a : this.f10313b) {
            int mo14464f = interfaceC2166a.mo14464f();
            switch (mo14464f) {
                case 1:
                    int m12458a = m12458a(i2, interfaceC2166a.mo14461a(), i);
                    m12459a(m12458a, i);
                    i2 = m12458a;
                    break;
                case 2:
                    i = ((InterfaceC2169d) interfaceC2166a).mo14466b();
                    break;
                case 3:
                case 4:
                    InterfaceC2174i interfaceC2174i = (InterfaceC2174i) interfaceC2166a;
                    m12463a(new C1633e(this.f10314c, interfaceC2174i.mo14470e(), interfaceC2174i.mo14220b(), interfaceC2174i.mo14465l(), interfaceC2174i.mo14452c()), i2, i);
                    z = true;
                    break;
                case 5:
                    C1633e c1633e = this.f10315d[((InterfaceC2167b) interfaceC2166a).mo14463e()];
                    if (c1633e != null) {
                        c1633e.m12479b(i2, i);
                        m12462a(c1633e);
                    }
                    z = true;
                    break;
                case 6:
                    C1633e c1633e2 = this.f10315d[((InterfaceC2172g) interfaceC2166a).mo14467e()];
                    if (c1633e2 != null) {
                        if (c1633e2.m12479b(i2, i)) {
                            m12462a(c1633e2);
                        }
                        c1633e2.m12477a(i2, i);
                    }
                    z = true;
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    String mo14468b = ((InterfaceC2173h) interfaceC2166a).mo14468b();
                    if (mo14468b != null) {
                        this.f10312a.mo12144a(new C1582p(mo14468b));
                        break;
                    } else {
                        break;
                    }
                default:
                    if (mo14464f >= 10) {
                        int m12458a2 = m12458a(i2, (mo14464f - 10) / 15, i);
                        int i3 = ((r0 % 15) - 4) + i;
                        m12459a(m12458a2, i3);
                        i = i3;
                        i2 = m12458a2;
                        break;
                    } else {
                        throw new C1725b("Unknown debug insn code: " + mo14464f);
                    }
            }
        }
        if (z) {
            for (C1633e c1633e3 : this.f10315d) {
                if (c1633e3 != null && !c1633e3.m12481d()) {
                    c1633e3.m12479b(this.f10312a.m12642q() - 1, i);
                    m12462a(c1633e3);
                }
            }
        }
        m12465b(i2, this.f10317f.length, i);
    }

    /* renamed from: a */
    private int m12458a(int i, int i2, int i3) {
        int min = Math.min(i + i2, this.f10317f.length - 1);
        for (int i4 = i + 1; i4 <= min; i4++) {
            C1646l c1646l = this.f10317f[i4];
            if (c1646l != null) {
                for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
                    if (abstractC1598c.mo12298h()) {
                        this.f10316e[((C1604i) abstractC1598c).m12330o()] = abstractC1598c;
                    }
                }
                C1604i m12588p = c1646l.m12588p();
                if (m12588p != null) {
                    this.f10316e[m12588p.m12330o()] = m12588p;
                }
            }
        }
        m12465b(i, min, i3);
        return min;
    }

    /* renamed from: b */
    private void m12465b(int i, int i2, int i3) {
        for (int i4 = i + 1; i4 < i2; i4++) {
            m12459a(i4, i3);
        }
    }

    /* renamed from: a */
    private void m12459a(int i, int i2) {
        C1646l c1646l = this.f10317f[i];
        if (c1646l != null) {
            c1646l.m12118a(i2);
        }
    }

    /* renamed from: a */
    private void m12463a(C1633e c1633e, int i, int i2) {
        C1605j m12331p;
        C1646l l;
        int m12476a = c1633e.m12476a();
        C1633e c1633e2 = this.f10315d[m12476a];
        if (c1633e2 != null && !c1633e2.m12481d()) {
            c1633e2.m12479b(i, i2);
            m12462a(c1633e2);
        }
        AbstractC1598c abstractC1598c = this.f10316e[c1633e.m12476a()];
        if ((abstractC1598c instanceof C1604i) && (m12331p = ((C1604i) abstractC1598c).m12331p()) != null && m12331p.m12343d() != -1 && (l = m12331p.m12347h().m12314l()) != null && l.m12591s() >= 0) {
            i = l.m12591s();
        }
        c1633e.m12477a(i, i2);
        this.f10315d[m12476a] = c1633e;
    }

    /* renamed from: a */
    private void m12462a(C1633e c1633e) {
        int m12483f = c1633e.m12483f();
        for (int m12482e = c1633e.m12482e(); m12482e <= m12483f; m12482e++) {
            C1646l c1646l = this.f10317f[m12482e];
            if (c1646l != null) {
                m12464a(c1646l, c1633e);
            }
        }
        m12460a(this.f10316e[c1633e.m12476a()], c1633e);
    }

    /* renamed from: a */
    private static void m12464a(C1646l c1646l, C1633e c1633e) {
        m12460a((AbstractC1598c) c1646l.m12588p(), c1633e);
        Iterator<AbstractC1598c> it = c1646l.m12589q().iterator();
        while (it.hasNext()) {
            m12460a(it.next(), c1633e);
        }
    }

    /* renamed from: a */
    private static void m12460a(AbstractC1598c abstractC1598c, C1633e c1633e) {
        boolean z = true;
        if (abstractC1598c != null && abstractC1598c.mo12298h()) {
            C1604i c1604i = (C1604i) abstractC1598c;
            if (c1633e.m12476a() == c1604i.m12330o()) {
                C1605j m12331p = c1604i.m12331p();
                if (m12331p != null) {
                    int m12344e = m12331p.m12344e();
                    int m12343d = m12331p.m12343d();
                    int m12482e = c1633e.m12482e();
                    int m12483f = c1633e.m12483f();
                    if (!(m12483f >= m12343d && m12344e >= m12482e) || m12344e > m12483f) {
                        z = false;
                    }
                }
                if (z) {
                    m12461a(c1604i, c1633e);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12461a(C1604i c1604i, C1633e c1633e) {
        String m12478b = c1633e.m12478b();
        if (C1559d.m12064b(m12478b)) {
            c1604i.m12325a(c1633e.m12480c(), m12478b);
        }
    }
}
