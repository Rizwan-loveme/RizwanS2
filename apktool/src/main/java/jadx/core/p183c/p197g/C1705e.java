package jadx.core.p183c.p197g;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1643i;
import jadx.core.p183c.p191d.p192a.C1630b;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1735d;
import java.util.Iterator;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: DebugInfoVisitor.java */
/* renamed from: jadx.core.c.g.e */
/* loaded from: classes.dex */
public class C1705e extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10547a = C2568c.m15995a((Class<?>) C1705e.class);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        try {
            Iterable<? extends InterfaceC2166a> m12613K = c1648n.m12613K();
            if (m12613K.iterator().hasNext()) {
                m13079a(c1648n, m12613K);
            }
        } catch (Exception e2) {
            f10547a.mo15943c("Error in debug info parser: {}", C1735d.m13256a((InterfaceC1643i) c1648n, e2.getMessage()), e2);
        } finally {
            c1648n.m12644s();
        }
    }

    /* renamed from: a */
    private void m13079a(C1648n c1648n, Iterable<? extends InterfaceC2166a> iterable) {
        C1646l[] m12643r = c1648n.m12643r();
        new C1630b(c1648n, iterable, m12643r).m12466a();
        if (m12643r.length != 0) {
            m13081b(c1648n, m12643r);
        }
        if (!c1648n.m12636k().equals(AbstractC1596a.f10133i)) {
            m13080a(c1648n, m12643r);
        }
    }

    /* renamed from: a */
    private void m13080a(C1648n c1648n, C1646l[] c1646lArr) {
        C1646l c1646l;
        Iterator<C1628a> it = c1648n.m12603A().iterator();
        while (it.hasNext()) {
            C1646l m13194a = C1721a.m13194a((InterfaceC1640f) it.next());
            if (m13194a != null && (c1646l = c1646lArr[m13194a.m12591s()]) != m13194a) {
                C1604i c1604i = (C1604i) c1646l.mo12426d(0);
                ((C1604i) m13194a.mo12426d(0)).m12325a(c1604i.m12359s(), c1604i.mo12320m_());
                m13194a.m12118a(c1646l.m12122d());
            }
        }
    }

    /* renamed from: b */
    private void m13081b(C1648n c1648n, C1646l[] c1646lArr) {
        for (C1646l c1646l : c1646lArr) {
            if (c1646l != null) {
                int d2 = c1646l.m12122d();
                if (d2 != 0) {
                    c1648n.m12118a(d2 - 1);
                    return;
                }
                return;
            }
        }
    }
}
