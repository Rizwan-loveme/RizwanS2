package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1735d;
import java.util.Iterator;

/* compiled from: DepthTraversal.java */
/* renamed from: jadx.core.c.g.g */
/* loaded from: classes.dex */
public class C1707g {
    /* renamed from: a */
    public static void m13089a(InterfaceC1712l interfaceC1712l, C1636b c1636b) {
        try {
            if (interfaceC1712l.mo12781a(c1636b)) {
                Iterator<C1636b> it = c1636b.m12534n().iterator();
                while (it.hasNext()) {
                    m13089a(interfaceC1712l, it.next());
                }
                Iterator<C1648n> it2 = c1636b.m12530j().iterator();
                while (it2.hasNext()) {
                    m13090a(interfaceC1712l, it2.next());
                }
            }
        } catch (Exception e2) {
            C1735d.m13255a(c1636b, String.valueOf(e2.getClass().getSimpleName()) + " in pass: " + interfaceC1712l.getClass().getSimpleName(), (Throwable) e2);
        }
    }

    /* renamed from: a */
    public static void m13090a(InterfaceC1712l interfaceC1712l, C1648n c1648n) {
        if (!c1648n.mo12145a(C1566b.f10030d)) {
            try {
                interfaceC1712l.mo12779a(c1648n);
            } catch (Exception e2) {
                C1735d.m13259a(c1648n, String.valueOf(e2.getClass().getSimpleName()) + " in pass: " + interfaceC1712l.getClass().getSimpleName(), (Throwable) e2);
            }
        }
    }
}
