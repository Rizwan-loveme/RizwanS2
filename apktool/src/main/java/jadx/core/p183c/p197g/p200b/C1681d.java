package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p203d.p205b.C1728e;
import java.util.Iterator;

/* compiled from: DepthRegionTraversal.java */
/* renamed from: jadx.core.c.g.b.d */
/* loaded from: classes.dex */
public class C1681d {
    /* renamed from: a */
    public static void m12888a(C1648n c1648n, InterfaceC1683f interfaceC1683f) {
        m12889a(c1648n, interfaceC1683f, c1648n.m12616N());
    }

    /* renamed from: a */
    public static void m12887a(C1648n c1648n, InterfaceC1682e interfaceC1682e) {
        int i = 0;
        while (true) {
            boolean m12890a = m12890a(c1648n, interfaceC1682e, c1648n.m12616N());
            int i2 = i + 1;
            if (i > 500) {
                throw new C1728e("Iterative traversal limit reached, method: " + c1648n);
            }
            if (!m12890a) {
                return;
            } else {
                i = i2;
            }
        }
    }

    /* renamed from: b */
    public static void m12891b(C1648n c1648n, InterfaceC1682e interfaceC1682e) {
        boolean z;
        int i = 0;
        do {
            int i2 = i;
            boolean m12890a = m12890a(c1648n, interfaceC1682e, c1648n.m12616N());
            if (!m12890a) {
                Iterator<C1666c> it = c1648n.m12606D().iterator();
                while (it.hasNext()) {
                    m12890a = m12890a(c1648n, interfaceC1682e, it.next().m12761f());
                    if (m12890a) {
                        z = m12890a;
                        break;
                    }
                }
            }
            z = m12890a;
            i = i2 + 1;
            if (i2 > 500) {
                throw new C1728e("Iterative traversal limit reached, method: " + c1648n);
            }
        } while (z);
    }

    /* renamed from: a */
    private static void m12889a(C1648n c1648n, InterfaceC1683f interfaceC1683f, InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            interfaceC1683f.mo12880a(c1648n, (InterfaceC1640f) interfaceC1642h);
            return;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            InterfaceC1644j interfaceC1644j = (InterfaceC1644j) interfaceC1642h;
            if (interfaceC1683f.mo12881a(c1648n, interfaceC1644j)) {
                Iterator<InterfaceC1642h> it = interfaceC1644j.mo12575d().iterator();
                while (it.hasNext()) {
                    m12889a(c1648n, interfaceC1683f, it.next());
                }
            }
            interfaceC1683f.mo12882b(c1648n, interfaceC1644j);
        }
    }

    /* renamed from: a */
    private static boolean m12890a(C1648n c1648n, InterfaceC1682e interfaceC1682e, InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1644j) {
            InterfaceC1644j interfaceC1644j = (InterfaceC1644j) interfaceC1642h;
            if (interfaceC1682e.mo12892a(c1648n, interfaceC1644j)) {
                return true;
            }
            Iterator<InterfaceC1642h> it = interfaceC1644j.mo12575d().iterator();
            while (it.hasNext()) {
                if (m12890a(c1648n, interfaceC1682e, it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
