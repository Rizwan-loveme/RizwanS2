package jadx.core.p203d;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.C1625p;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: InstructionRemover.java */
/* renamed from: jadx.core.d.i */
/* loaded from: classes.dex */
public class C1740i {

    /* renamed from: a */
    private final C1648n f10602a;

    /* renamed from: b */
    private final List<C1646l> f10603b;

    /* renamed from: c */
    private List<C1646l> f10604c;

    public C1740i(C1648n c1648n) {
        this(c1648n, null);
    }

    public C1740i(C1648n c1648n, C1628a c1628a) {
        this.f10602a = c1648n;
        this.f10603b = new ArrayList();
        if (c1628a != null) {
            this.f10604c = c1628a.mo12446j();
        }
    }

    /* renamed from: a */
    public void m13283a(C1628a c1628a) {
        this.f10604c = c1628a.mo12446j();
    }

    /* renamed from: a */
    public void m13284a(C1646l c1646l) {
        this.f10603b.add(c1646l);
    }

    /* renamed from: a */
    public void m13282a() {
        if (!this.f10603b.isEmpty()) {
            m13279a(this.f10602a, this.f10604c, this.f10603b);
            this.f10603b.clear();
        }
    }

    /* renamed from: a */
    public static void m13278a(C1648n c1648n, C1646l c1646l) {
        m13280b(c1648n, c1646l);
        Iterator<AbstractC1598c> it = c1646l.m12589q().iterator();
        while (it.hasNext()) {
            m13275a(c1648n, it.next());
        }
        if (c1646l.m12587o() == EnumC1621l.PHI) {
            for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
                if (abstractC1598c instanceof C1604i) {
                    m13274a((C1604i) abstractC1598c);
                }
            }
        }
        c1646l.mo12141a(EnumC1562a.INCONSISTENT_CODE);
    }

    /* renamed from: a */
    public static void m13274a(C1604i c1604i) {
        Iterator<C1604i> it = c1604i.m12331p().m12348i().iterator();
        C1625p c1625p = null;
        while (it.hasNext()) {
            C1646l l = it.next().m12314l();
            if (l != null && l.m12587o() == EnumC1621l.PHI && l.m12585c(c1604i)) {
                c1625p = (C1625p) l;
            }
        }
        c1604i.m12331p().m12338a(c1625p);
    }

    /* renamed from: b */
    public static void m13280b(C1648n c1648n, C1646l c1646l) {
        C1604i m12588p = c1646l.m12588p();
        if (m12588p != null && m12588p.m12331p() != null) {
            c1648n.m12622a(m12588p.m12331p());
        }
    }

    /* renamed from: a */
    public static void m13275a(C1648n c1648n, AbstractC1598c abstractC1598c) {
        if (abstractC1598c instanceof C1604i) {
            C1604i c1604i = (C1604i) abstractC1598c;
            C1605j m12331p = c1604i.m12331p();
            if (m12331p != null) {
                m12331p.m12342c(c1604i);
                return;
            }
            return;
        }
        if (abstractC1598c instanceof C1599d) {
            m13278a(c1648n, ((C1599d) abstractC1598c).m12316d());
        }
    }

    /* renamed from: a */
    private static void m13279a(C1648n c1648n, List<C1646l> list, List<C1646l> list2) {
        for (C1646l c1646l : list2) {
            m13278a(c1648n, c1646l);
            int size = list.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (list.get(i) != c1646l) {
                    i++;
                } else {
                    list.remove(i);
                    break;
                }
            }
        }
    }

    /* renamed from: c */
    public static void m13281c(C1648n c1648n, C1646l c1646l) {
        C1628a m13192a = C1721a.m13192a(c1648n, c1646l);
        if (m13192a != null) {
            m13276a(c1648n, m13192a, c1646l);
        }
    }

    /* renamed from: a */
    public static void m13276a(C1648n c1648n, C1628a c1628a, C1646l c1646l) {
        m13278a(c1648n, c1646l);
        Iterator<C1646l> it = c1628a.mo12446j().iterator();
        while (it.hasNext()) {
            if (it.next() == c1646l) {
                it.remove();
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m13277a(C1648n c1648n, C1628a c1628a, List<C1646l> list) {
        if (!list.isEmpty()) {
            m13279a(c1648n, c1628a.mo12446j(), list);
        }
    }
}
