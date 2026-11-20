package jadx.core.p203d;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1641g;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p196f.C1664a;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p203d.p205b.C1729f;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: RegionUtils.java */
/* renamed from: jadx.core.d.l */
/* loaded from: classes.dex */
public class C1743l {
    /* renamed from: a */
    public static boolean m13290a(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            C1646l m13194a = C1721a.m13194a((InterfaceC1640f) interfaceC1642h);
            if (m13194a == null) {
                return false;
            }
            EnumC1621l m12587o = m13194a.m12587o();
            return m12587o == EnumC1621l.RETURN || m12587o == EnumC1621l.CONTINUE || m12587o == EnumC1621l.BREAK || m12587o == EnumC1621l.THROW;
        }
        if (interfaceC1642h instanceof InterfaceC1641g) {
            for (InterfaceC1642h interfaceC1642h2 : ((InterfaceC1641g) interfaceC1642h).mo12571p_()) {
                if (interfaceC1642h2 == null || !m13290a(interfaceC1642h2)) {
                    return false;
                }
            }
            return true;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            List<InterfaceC1642h> mo12575d = ((InterfaceC1644j) interfaceC1642h).mo12575d();
            return !mo12575d.isEmpty() && m13290a(mo12575d.get(mo12575d.size() + (-1)));
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: b */
    public static C1646l m13294b(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            List<C1646l> mo12446j = ((InterfaceC1640f) interfaceC1642h).mo12446j();
            if (mo12446j.isEmpty()) {
                return null;
            }
            return mo12446j.get(mo12446j.size() - 1);
        }
        if (interfaceC1642h instanceof InterfaceC1641g) {
            return null;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            List<InterfaceC1642h> mo12575d = ((InterfaceC1644j) interfaceC1642h).mo12575d();
            if (mo12575d.isEmpty()) {
                return null;
            }
            return m13294b(mo12575d.get(mo12575d.size() - 1));
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: c */
    public static InterfaceC1640f m13296c(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            return (InterfaceC1640f) interfaceC1642h;
        }
        if (interfaceC1642h instanceof InterfaceC1641g) {
            return null;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            List<InterfaceC1642h> mo12575d = ((InterfaceC1644j) interfaceC1642h).mo12575d();
            if (mo12575d.isEmpty()) {
                return null;
            }
            return m13296c(mo12575d.get(mo12575d.size() - 1));
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: d */
    public static boolean m13297d(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof C1628a) {
            return ((C1628a) interfaceC1642h).m12442f().isEmpty();
        }
        if (interfaceC1642h instanceof InterfaceC1640f) {
            return true;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            List<InterfaceC1642h> mo12575d = ((InterfaceC1644j) interfaceC1642h).mo12575d();
            return !mo12575d.isEmpty() && m13297d(mo12575d.get(mo12575d.size() + (-1)));
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: e */
    public static boolean m13298e(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            return C1721a.m13202a((InterfaceC1640f) interfaceC1642h, EnumC1621l.BREAK);
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            List<InterfaceC1642h> mo12575d = ((InterfaceC1644j) interfaceC1642h).mo12575d();
            return !mo12575d.isEmpty() && m13298e(mo12575d.get(mo12575d.size() + (-1)));
        }
        throw new C1729f("Unknown container type: " + interfaceC1642h);
    }

    /* renamed from: f */
    public static int m13299f(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            return ((InterfaceC1640f) interfaceC1642h).mo12446j().size();
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            int i = 0;
            Iterator<InterfaceC1642h> it = ((InterfaceC1644j) interfaceC1642h).mo12575d().iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    i = m13299f(it.next()) + i2;
                } else {
                    return i2;
                }
            }
        } else {
            throw new C1729f(m13302i(interfaceC1642h));
        }
    }

    /* renamed from: g */
    public static boolean m13300g(InterfaceC1642h interfaceC1642h) {
        return !m13301h(interfaceC1642h);
    }

    /* renamed from: h */
    public static boolean m13301h(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            return !((InterfaceC1640f) interfaceC1642h).mo12446j().isEmpty();
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            Iterator<InterfaceC1642h> it = ((InterfaceC1644j) interfaceC1642h).mo12575d().iterator();
            while (it.hasNext()) {
                if (m13301h(it.next())) {
                    return true;
                }
            }
            return false;
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: a */
    public static void m13288a(InterfaceC1642h interfaceC1642h, Set<InterfaceC1640f> set) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            set.add((InterfaceC1640f) interfaceC1642h);
        } else {
            if (interfaceC1642h instanceof InterfaceC1644j) {
                Iterator<InterfaceC1642h> it = ((InterfaceC1644j) interfaceC1642h).mo12575d().iterator();
                while (it.hasNext()) {
                    m13288a(it.next(), set);
                }
                return;
            }
            throw new C1729f(m13302i(interfaceC1642h));
        }
    }

    /* renamed from: a */
    public static boolean m13291a(InterfaceC1642h interfaceC1642h, C1628a c1628a) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            return interfaceC1642h == c1628a;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            Iterator<InterfaceC1642h> it = ((InterfaceC1644j) interfaceC1642h).mo12575d().iterator();
            while (it.hasNext()) {
                if (m13291a(it.next(), c1628a)) {
                    return true;
                }
            }
            return false;
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: b */
    private static boolean m13295b(InterfaceC1642h interfaceC1642h, InterfaceC1644j interfaceC1644j) {
        if (interfaceC1642h == interfaceC1644j) {
            return true;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            for (InterfaceC1642h interfaceC1642h2 : ((InterfaceC1644j) interfaceC1642h).mo12575d()) {
                C1664a c1664a = (C1664a) interfaceC1642h2.mo12146b(C1566b.f10034h);
                if (c1664a != null && (interfaceC1642h2 instanceof InterfaceC1644j)) {
                    Iterator<C1666c> it = c1664a.m12747a().m12769a().iterator();
                    while (it.hasNext()) {
                        if (m13292a(it.next().m12761f(), interfaceC1644j)) {
                            return true;
                        }
                    }
                }
                if (m13292a(interfaceC1642h2, interfaceC1644j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m13292a(InterfaceC1642h interfaceC1642h, InterfaceC1644j interfaceC1644j) {
        if (interfaceC1642h == interfaceC1644j) {
            return true;
        }
        if (interfaceC1644j == null) {
            return false;
        }
        for (InterfaceC1644j mo12574c = interfaceC1644j.mo12574c(); interfaceC1642h != mo12574c; mo12574c = mo12574c.mo12574c()) {
            if (mo12574c == null) {
                if (interfaceC1644j.mo12145a(C1566b.f10033g)) {
                    return m13295b(interfaceC1642h, interfaceC1644j);
                }
                return false;
            }
            interfaceC1644j = mo12574c;
        }
        return true;
    }

    /* renamed from: b */
    public static InterfaceC1642h m13293b(InterfaceC1642h interfaceC1642h, C1628a c1628a) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            if (interfaceC1642h == c1628a) {
                return interfaceC1642h;
            }
            return null;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            InterfaceC1644j interfaceC1644j = (InterfaceC1644j) interfaceC1642h;
            Iterator<InterfaceC1642h> it = interfaceC1644j.mo12575d().iterator();
            while (it.hasNext()) {
                InterfaceC1642h m13293b = m13293b(it.next(), c1628a);
                if (m13293b != null) {
                    return !(m13293b instanceof InterfaceC1640f) ? m13293b : interfaceC1644j;
                }
            }
            return null;
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: a */
    public static boolean m13289a(C1628a c1628a, InterfaceC1642h interfaceC1642h) {
        if (c1628a == interfaceC1642h) {
            return true;
        }
        if (interfaceC1642h instanceof C1628a) {
            return C1721a.m13213c(c1628a, (C1628a) interfaceC1642h);
        }
        if (interfaceC1642h instanceof InterfaceC1640f) {
            return false;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            Iterator<InterfaceC1642h> it = ((InterfaceC1644j) interfaceC1642h).mo12575d().iterator();
            while (it.hasNext()) {
                if (!m13289a(c1628a, it.next())) {
                    return false;
                }
            }
            return true;
        }
        throw new C1729f(m13302i(interfaceC1642h));
    }

    /* renamed from: i */
    protected static String m13302i(InterfaceC1642h interfaceC1642h) {
        return interfaceC1642h == null ? "Null container variable" : "Unknown container type: " + interfaceC1642h.getClass();
    }
}
