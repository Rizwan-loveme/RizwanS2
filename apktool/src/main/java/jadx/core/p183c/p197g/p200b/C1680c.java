package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.C1656b;
import java.util.Iterator;

/* compiled from: CleanRegions.java */
/* renamed from: jadx.core.c.g.b.c */
/* loaded from: classes.dex */
public class C1680c {
    /* renamed from: a */
    public static void m12885a(C1648n c1648n) {
        if (!c1648n.m12641p() && !c1648n.m12647y().isEmpty()) {
            C1681d.m12888a(c1648n, new AbstractC1678a() { // from class: jadx.core.c.g.b.c.1
                @Override // jadx.core.p183c.p197g.p200b.AbstractC1678a, jadx.core.p183c.p197g.p200b.InterfaceC1683f
                /* renamed from: a */
                public boolean mo12881a(C1648n c1648n2, InterfaceC1644j interfaceC1644j) {
                    if (interfaceC1644j instanceof C1656b) {
                        Iterator<InterfaceC1642h> it = interfaceC1644j.mo12575d().iterator();
                        while (it.hasNext()) {
                            if (m12886a(it.next())) {
                                it.remove();
                            }
                        }
                        return true;
                    }
                    return true;
                }

                /* renamed from: a */
                private boolean m12886a(InterfaceC1642h interfaceC1642h) {
                    if (interfaceC1642h instanceof C1628a) {
                        return ((C1628a) interfaceC1642h).mo12446j().isEmpty();
                    }
                    return false;
                }
            });
        }
    }
}
