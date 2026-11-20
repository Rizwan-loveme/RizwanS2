package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.C1625p;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p190b.C1611b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p193e.C1656b;
import jadx.core.p183c.p193e.p194a.C1655d;
import jadx.core.p183c.p197g.C1695c;
import jadx.core.p203d.C1738g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TernaryMod.java */
/* renamed from: jadx.core.c.g.b.p */
/* loaded from: classes.dex */
public class C1693p {
    /* renamed from: a */
    static boolean m13011a(C1648n c1648n, C1655d c1655d) {
        C1604i m12588p;
        if (c1655d.mo12149b(EnumC1562a.ELSE_IF_CHAIN)) {
            return false;
        }
        InterfaceC1642h m12709f = c1655d.m12709f();
        InterfaceC1642h m12710g = c1655d.m12710g();
        if (m12709f == null || m12710g == null) {
            return false;
        }
        C1628a m13008a = m13008a(m12709f);
        C1628a m13008a2 = m13008a(m12710g);
        if (m13008a == null || m13008a2 == null) {
            return false;
        }
        C1628a m12711h = c1655d.m12711h();
        C1646l c1646l = m13008a.mo12446j().get(0);
        C1646l c1646l2 = m13008a2.mo12446j().get(0);
        if (c1646l.m12122d() != c1646l2.m12122d()) {
            if (c1646l.m12122d() != 0 && c1646l2.m12122d() != 0) {
                if (!m13010a(c1646l, c1646l2)) {
                    return false;
                }
            } else if (m13009a(c1646l) || m13009a(c1646l2)) {
                return false;
            }
        }
        if (c1646l.m12588p() != null && c1646l2.m12588p() != null) {
            C1625p m12350k = c1646l.m12588p().m12331p().m12350k();
            if (m12350k == null || !c1646l.m12588p().m12328a(c1646l2.m12588p())) {
                return false;
            }
            if (!c1655d.mo12574c().mo12573a(c1655d, m12711h)) {
                return false;
            }
            C1738g.m13262a(m13008a, c1646l);
            C1738g.m13262a(m13008a2, c1646l2);
            if (m12350k.m12590r() == 2) {
                m12588p = m12350k.m12588p();
            } else {
                m12588p = c1646l.m12588p();
                m12350k.mo12423a((AbstractC1598c) c1646l2.m12588p());
            }
            C1611b c1611b = new C1611b(c1655d.m12708e(), m12588p, AbstractC1598c.m12306c(c1646l), AbstractC1598c.m12306c(c1646l2));
            c1611b.m12118a(c1646l.m12122d());
            m12711h.mo12446j().clear();
            m12711h.mo12446j().add(c1611b);
            C1695c.m13016b(c1648n);
            return true;
        }
        if (c1648n.m12636k().equals(AbstractC1596a.f10133i) || c1646l.m12587o() != EnumC1621l.RETURN || c1646l2.m12587o() != EnumC1621l.RETURN) {
            return false;
        }
        if (!c1655d.mo12574c().mo12573a(c1655d, m12711h)) {
            return false;
        }
        C1738g.m13262a(m13008a, c1646l);
        C1738g.m13262a(m13008a2, c1646l2);
        m13008a.mo12151c(EnumC1562a.RETURN);
        m13008a2.mo12151c(EnumC1562a.RETURN);
        C1611b c1611b2 = new C1611b(c1655d.m12708e(), null, c1646l.mo12426d(0), c1646l2.mo12426d(0));
        c1611b2.m12118a(c1646l.m12122d());
        C1646l c1646l3 = new C1646l(EnumC1621l.RETURN, 1);
        c1646l3.m12584c(AbstractC1598c.m12306c(c1611b2));
        m12711h.mo12446j().clear();
        m12711h.mo12446j().add(c1646l3);
        m12711h.mo12141a(EnumC1562a.RETURN);
        C1695c.m13016b(c1648n);
        return true;
    }

    /* renamed from: a */
    private static C1628a m13008a(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof C1656b) {
            C1656b c1656b = (C1656b) interfaceC1642h;
            if (c1656b.mo12575d().size() == 1) {
                InterfaceC1642h interfaceC1642h2 = c1656b.mo12575d().get(0);
                if (interfaceC1642h2 instanceof C1628a) {
                    C1628a c1628a = (C1628a) interfaceC1642h2;
                    if (c1628a.mo12446j().size() == 1) {
                        return c1628a;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m13009a(C1646l c1646l) {
        if (c1646l.m12587o() == EnumC1621l.TERNARY) {
            return true;
        }
        for (int i = 0; i < c1646l.m12590r(); i++) {
            AbstractC1598c mo12426d = c1646l.mo12426d(i);
            if (mo12426d.mo12312j() && m13009a(((C1599d) mo12426d).m12316d())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static boolean m13010a(C1646l c1646l, C1646l c1646l2) {
        C1646l m12333r;
        int d2;
        if (c1646l.m12588p() == null || c1646l2.m12588p() == null) {
            return false;
        }
        C1625p m12350k = c1646l.m12588p().m12331p().m12350k();
        C1625p m12350k2 = c1646l2.m12588p().m12331p().m12350k();
        if (m12350k == null || m12350k2 == null || m12350k != m12350k2) {
            return false;
        }
        HashMap hashMap = new HashMap(m12350k.m12590r());
        for (AbstractC1598c abstractC1598c : m12350k.m12589q()) {
            if (abstractC1598c.mo12298h() && (m12333r = ((C1604i) abstractC1598c).m12333r()) != null && (d2 = m12333r.m12122d()) != 0) {
                Integer num = (Integer) hashMap.get(Integer.valueOf(d2));
                if (num != null) {
                    hashMap.put(Integer.valueOf(d2), Integer.valueOf(num.intValue() + 1));
                } else {
                    hashMap.put(Integer.valueOf(d2), 1);
                }
            }
        }
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            if (((Integer) ((Map.Entry) it.next()).getValue()).intValue() >= 2) {
                return true;
            }
        }
        return false;
    }
}
