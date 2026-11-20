package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1641g;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.AbstractC1651a;
import jadx.core.p183c.p193e.C1656b;
import jadx.core.p183c.p193e.C1663e;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p196f.C1664a;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p183c.p196f.C1667d;
import jadx.core.p183c.p196f.C1668e;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1743l;
import jadx.core.p203d.p205b.C1729f;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ProcessTryCatchRegions.java */
/* renamed from: jadx.core.c.g.b.j */
/* loaded from: classes.dex */
public class C1687j extends AbstractC1678a {

    /* renamed from: a */
    private static final InterfaceC2558b f10502a = C2568c.m15995a((Class<?>) C1687j.class);

    /* renamed from: a */
    public static void m12936a(C1648n c1648n) {
        if (!c1648n.m12641p() && !c1648n.m12607E()) {
            final HashMap hashMap = new HashMap(2);
            m12937a(c1648n, hashMap);
            C1681d.m12891b(c1648n, new InterfaceC1682e() { // from class: jadx.core.c.g.b.j.1
                @Override // jadx.core.p183c.p197g.p200b.InterfaceC1682e
                /* renamed from: a */
                public boolean mo12892a(C1648n c1648n2, InterfaceC1644j interfaceC1644j) {
                    return C1687j.m12941b(c1648n2, Map.this, interfaceC1644j) && !Map.this.isEmpty();
                }
            });
        }
    }

    /* renamed from: a */
    private static void m12937a(C1648n c1648n, Map<C1628a, C1668e> map) {
        C1628a c1628a;
        C1667d c1667d;
        HashSet<C1668e> hashSet = new HashSet();
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        while (it.hasNext()) {
            C1664a c1664a = (C1664a) it.next().mo12146b(C1566b.f10034h);
            if (c1664a != null) {
                hashSet.add(c1664a.m12747a());
            }
        }
        for (C1668e c1668e : hashSet) {
            if (c1668e.m12776b() == 0) {
                f10502a.mo15942c("No exception handlers in catch block, method: {}", c1648n);
            } else {
                BitSet bitSet = new BitSet(c1648n.m12647y().size());
                Iterator<C1666c> it2 = c1668e.m12769a().iterator();
                while (it2.hasNext()) {
                    C1628a m12759d = it2.next().m12759d();
                    if (m12759d != null && (c1667d = (C1667d) m12759d.mo12146b(C1566b.f10035i)) != null) {
                        bitSet.set(c1667d.m12765a().m12440d());
                    }
                }
                List<C1628a> m13207b = C1721a.m13207b(c1648n, bitSet);
                if (m13207b.size() != 1) {
                    c1628a = C1721a.m13193a((Collection<C1628a>) m13207b);
                    if (c1628a == null) {
                        throw new C1729f("Exception block dominator not found, method:" + c1648n + ", dom blocks: " + m13207b);
                    }
                } else {
                    c1628a = m13207b.get(0);
                }
                if (map.put(c1628a, c1668e) != null) {
                    C1735d.m13258a(c1648n, "Failed to process nested try/catch");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m12941b(C1648n c1648n, Map<C1628a, C1668e> map, InterfaceC1644j interfaceC1644j) {
        Iterator<Map.Entry<C1628a, C1668e>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            C1628a key = it.next().getKey();
            if (interfaceC1644j.mo12575d().contains(key)) {
                if (!m12938a(interfaceC1644j, map.get(key), key)) {
                    C1735d.m13258a(c1648n, "Can't wrap try/catch for " + interfaceC1644j);
                }
                map.remove(key);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m12938a(InterfaceC1644j interfaceC1644j, C1668e c1668e, C1628a c1628a) {
        if (interfaceC1644j == null) {
            return false;
        }
        if (interfaceC1644j instanceof C1659c) {
            return m12938a(((C1659c) interfaceC1644j).m12728h(), c1668e, c1628a);
        }
        if (interfaceC1644j instanceof InterfaceC1641g) {
            return m12938a(interfaceC1644j.mo12574c(), c1668e, c1628a);
        }
        InterfaceC1644j c1656b = new C1656b(interfaceC1644j);
        List<InterfaceC1642h> mo12575d = interfaceC1644j.mo12575d();
        for (InterfaceC1642h interfaceC1642h : mo12575d) {
            if (C1743l.m13289a(c1628a, interfaceC1642h)) {
                if (m12940a(c1668e, interfaceC1642h)) {
                    break;
                }
                c1656b.mo12575d().add(interfaceC1642h);
            }
        }
        if (c1656b.mo12575d().isEmpty()) {
            return false;
        }
        C1663e c1663e = new C1663e(interfaceC1644j, c1656b);
        c1656b.mo12572a(c1663e);
        c1663e.m12743a(c1668e.m12778d().m12747a());
        if (!interfaceC1644j.mo12573a(c1656b.mo12575d().get(0), c1663e)) {
            return false;
        }
        mo12575d.removeAll(c1656b.mo12575d());
        for (InterfaceC1642h interfaceC1642h2 : c1656b.mo12575d()) {
            if (interfaceC1642h2 instanceof AbstractC1651a) {
                ((AbstractC1651a) interfaceC1642h2).mo12572a(c1656b);
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m12940a(C1668e c1668e, InterfaceC1642h interfaceC1642h) {
        Iterator<C1666c> it = c1668e.m12769a().iterator();
        while (it.hasNext()) {
            C1628a m12759d = it.next().m12759d();
            if (m12759d != null && C1743l.m13289a(m12759d, interfaceC1642h)) {
                return true;
            }
        }
        return false;
    }
}
