package jadx.core.p183c.p197g.p202d;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1646l;

/* compiled from: SelectTypeVisitor.java */
/* renamed from: jadx.core.c.g.d.d */
/* loaded from: classes.dex */
public class C1703d {
    /* renamed from: a */
    public static void m13074a(C1637c c1637c, C1646l c1646l) {
        C1604i m12588p = c1646l.m12588p();
        if (m12588p != null && !m12588p.m12359s().mo12276b()) {
            m13073a(c1637c, m12588p);
        }
        for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
            if (!abstractC1598c.m12359s().mo12276b()) {
                m13073a(c1637c, abstractC1598c);
            }
        }
    }

    /* renamed from: a */
    private static void m13073a(C1637c c1637c, AbstractC1598c abstractC1598c) {
        AbstractC1596a s = abstractC1598c.m12359s();
        abstractC1598c.mo12293a(AbstractC1596a.m12262a(c1637c, s, s.mo12290p()));
    }
}
