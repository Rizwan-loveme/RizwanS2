package jadx.core.p183c.p197g.p198a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p196f.C1665b;
import jadx.core.p183c.p196f.C1667d;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1721a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: BlockFinish.java */
/* renamed from: jadx.core.c.g.a.c */
/* loaded from: classes.dex */
public class C1674c extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10490a = C2568c.m15995a((Class<?>) C1674c.class);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            for (C1628a c1628a : c1648n.m12647y()) {
                c1628a.m12444h();
                m12822a(c1628a);
            }
            c1648n.m12646x();
        }
    }

    /* renamed from: a */
    private static void m12822a(C1628a c1628a) {
        C1665b c1665b = (C1665b) c1628a.mo12146b(C1566b.f10033g);
        if (c1665b != null) {
            C1628a m12759d = c1665b.m12749c().m12759d();
            if (m12759d.m12441e().size() >= 2) {
                HashMap hashMap = new HashMap();
                Iterator<C1628a> it = m12759d.m12441e().iterator();
                while (it.hasNext()) {
                    C1628a m13220g = C1721a.m13220g(it.next());
                    C1667d c1667d = (C1667d) m13220g.mo12146b(C1566b.f10035i);
                    if (c1667d != null && m13220g == c1667d.m12765a()) {
                        hashMap.put(m13220g, c1667d);
                    }
                }
                if (hashMap.size() >= 2) {
                    C1628a m13193a = C1721a.m13193a((Collection<C1628a>) hashMap.keySet());
                    if (m13193a == null) {
                        f10490a.mo15942c("Unknown top splitter block from list: {}", hashMap);
                        return;
                    }
                    for (Map.Entry entry : hashMap.entrySet()) {
                        C1628a c1628a2 = (C1628a) entry.getKey();
                        C1667d c1667d2 = (C1667d) entry.getValue();
                        if (c1628a2 == m13193a) {
                            c1628a.mo12144a(c1667d2);
                        } else {
                            c1628a2.m12152d(C1566b.f10035i);
                            Iterator<C1628a> it2 = c1628a2.m12443g().iterator();
                            while (it2.hasNext()) {
                                it2.next().m12152d(C1566b.f10035i);
                            }
                        }
                    }
                }
            }
        }
    }
}
