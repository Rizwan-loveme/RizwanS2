package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1568b;
import jadx.core.p183c.p184a.p186b.C1578l;
import jadx.core.p183c.p184a.p186b.C1579m;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.C1626q;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1638d;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1643i;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.C1656b;
import jadx.core.p183c.p193e.C1661c;
import jadx.core.p183c.p193e.C1662d;
import jadx.core.p183c.p193e.p194a.C1654c;
import jadx.core.p183c.p193e.p194a.C1655d;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p196f.C1665b;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p183c.p196f.C1667d;
import jadx.core.p183c.p196f.C1668e;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1740i;
import jadx.core.p203d.C1741j;
import jadx.core.p203d.C1743l;
import jadx.core.p203d.InterfaceC1736e;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: RegionMaker.java */
/* renamed from: jadx.core.c.g.b.l */
/* loaded from: classes.dex */
public class C1689l {

    /* renamed from: a */
    private static final InterfaceC2558b f10513a = C2568c.m15995a((Class<?>) C1689l.class);

    /* renamed from: f */
    private static /* synthetic */ int[] f10514f;

    /* renamed from: b */
    private final C1648n f10515b;

    /* renamed from: c */
    private final int f10516c;

    /* renamed from: d */
    private int f10517d;

    /* renamed from: e */
    private BitSet f10518e;

    /* renamed from: a */
    static /* synthetic */ int[] m12979a() {
        int[] iArr = f10514f;
        if (iArr == null) {
            iArr = new int[EnumC1621l.valuesCustom().length];
            try {
                iArr[EnumC1621l.AGET.ordinal()] = 24;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1621l.APUT.ordinal()] = 25;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC1621l.ARITH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC1621l.ARRAY_LENGTH.ordinal()] = 21;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC1621l.BREAK.ordinal()] = 36;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumC1621l.CAST.ordinal()] = 8;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EnumC1621l.CHECK_CAST.ordinal()] = 19;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EnumC1621l.CMP_G.ordinal()] = 14;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EnumC1621l.CMP_L.ordinal()] = 13;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EnumC1621l.CONST.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EnumC1621l.CONSTRUCTOR.ordinal()] = 35;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[EnumC1621l.CONST_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[EnumC1621l.CONST_STR.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[EnumC1621l.CONTINUE.ordinal()] = 37;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[EnumC1621l.FILLED_NEW_ARRAY.ordinal()] = 23;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[EnumC1621l.FILL_ARRAY.ordinal()] = 22;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[EnumC1621l.GOTO.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[EnumC1621l.IF.ordinal()] = 15;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[EnumC1621l.IGET.ordinal()] = 28;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[EnumC1621l.INSTANCE_OF.ordinal()] = 20;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[EnumC1621l.INVOKE.ordinal()] = 32;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[EnumC1621l.IPUT.ordinal()] = 29;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[EnumC1621l.MERGE.ordinal()] = 41;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[EnumC1621l.MONITOR_ENTER.ordinal()] = 17;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[EnumC1621l.MONITOR_EXIT.ordinal()] = 18;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[EnumC1621l.MOVE.ordinal()] = 7;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[EnumC1621l.MOVE_EXCEPTION.ordinal()] = 12;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[EnumC1621l.NEG.ordinal()] = 5;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[EnumC1621l.NEW_ARRAY.ordinal()] = 26;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[EnumC1621l.NEW_INSTANCE.ordinal()] = 27;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[EnumC1621l.NEW_MULTIDIM_ARRAY.ordinal()] = 42;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr[EnumC1621l.NOP.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr[EnumC1621l.NOT.ordinal()] = 6;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr[EnumC1621l.ONE_ARG.ordinal()] = 39;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr[EnumC1621l.PHI.ordinal()] = 40;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr[EnumC1621l.RETURN.ordinal()] = 9;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr[EnumC1621l.SGET.ordinal()] = 30;
            } catch (NoSuchFieldError e38) {
            }
            try {
                iArr[EnumC1621l.SPUT.ordinal()] = 31;
            } catch (NoSuchFieldError e39) {
            }
            try {
                iArr[EnumC1621l.STR_CONCAT.ordinal()] = 38;
            } catch (NoSuchFieldError e40) {
            }
            try {
                iArr[EnumC1621l.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError e41) {
            }
            try {
                iArr[EnumC1621l.TERNARY.ordinal()] = 34;
            } catch (NoSuchFieldError e42) {
            }
            try {
                iArr[EnumC1621l.THROW.ordinal()] = 11;
            } catch (NoSuchFieldError e43) {
            }
            f10514f = iArr;
        }
        return iArr;
    }

    public C1689l(C1648n c1648n) {
        this.f10515b = c1648n;
        int size = c1648n.m12647y().size();
        this.f10518e = new BitSet(size);
        this.f10516c = size * 100;
    }

    /* renamed from: a */
    public C1656b m12986a(C1628a c1628a, C1691n c1691n) {
        C1656b c1656b = new C1656b(c1691n.m13000b());
        if (c1628a != null) {
            int m12440d = c1628a.m12440d();
            if (this.f10518e.get(m12440d)) {
                this.f10515b.m12627b("Removed duplicated region for block: " + c1628a + " " + c1628a.m12147b());
            } else {
                this.f10518e.set(m12440d);
                while (c1628a != null) {
                    c1628a = m12964a(c1656b, c1628a, c1691n);
                    this.f10517d++;
                    if (this.f10517d > this.f10516c) {
                        throw new C1729f("Regions count limit reached");
                    }
                }
            }
        }
        return c1656b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C1628a m12964a(InterfaceC1644j interfaceC1644j, C1628a c1628a, C1691n c1691n) {
        boolean z;
        C1628a c1628a2;
        C1628a c1628a3;
        C1646l c1646l;
        boolean z2 = true;
        List<C1578l> c2 = c1628a.mo12150c(C1566b.f10028b);
        int size = c2.size();
        if (size != 0 && c1628a.mo12149b(EnumC1562a.LOOP_START)) {
            if (size == 1) {
                c1628a2 = m12960a(interfaceC1644j, (C1578l) c2.get(0), c1691n);
                z = true;
            } else {
                for (C1578l c1578l : c2) {
                    if (c1578l.m12124a() == c1628a) {
                        c1628a2 = m12960a(interfaceC1644j, c1578l, c1691n);
                        z = true;
                        break;
                    }
                }
            }
            if (!z && c1628a.mo12446j().size() == 1) {
                c1646l = c1628a.mo12446j().get(0);
                switch (m12979a()[c1646l.m12587o().ordinal()]) {
                    case 15:
                        c1628a3 = m12961a(interfaceC1644j, c1628a, (C1617h) c1646l, c1691n);
                        break;
                    case 16:
                        c1628a3 = m12962a(interfaceC1644j, c1628a, (C1626q) c1646l, c1691n);
                        break;
                    case 17:
                        c1628a3 = m12963a(interfaceC1644j, c1628a, c1646l, c1691n);
                        break;
                }
                if (!z2) {
                    interfaceC1644j.mo12575d().add(c1628a);
                    c1628a3 = C1721a.m13210c(c1628a);
                }
                if (c1628a3 != null || c1691n.m13003c(c1628a) || c1691n.m13003c(c1628a3)) {
                    return null;
                }
                return c1628a3;
            }
            z2 = z;
            c1628a3 = c1628a2;
            if (!z2) {
            }
            if (c1628a3 != null) {
            }
            return null;
        }
        z = false;
        c1628a2 = null;
        if (!z) {
            c1646l = c1628a.mo12446j().get(0);
            switch (m12979a()[c1646l.m12587o().ordinal()]) {
            }
            if (!z2) {
            }
            if (c1628a3 != null) {
            }
            return null;
        }
        z2 = z;
        c1628a3 = c1628a2;
        if (!z2) {
        }
        if (c1628a3 != null) {
        }
        return null;
    }

    /* renamed from: a */
    private C1628a m12960a(InterfaceC1644j interfaceC1644j, C1578l c1578l, C1691n c1691n) {
        C1628a c1628a;
        C1628a m12702e;
        C1628a m12124a = c1578l.m12124a();
        Set<C1628a> m12129d = c1578l.m12129d();
        ArrayList arrayList = new ArrayList(m12129d.size());
        C1628a m13210c = C1721a.m13210c(m12124a);
        if (m13210c != null && m12129d.remove(m13210c)) {
            arrayList.add(m13210c);
        }
        if (m12129d.remove(m12124a)) {
            arrayList.add(m12124a);
        }
        if (m12129d.remove(c1578l.m12127b())) {
            arrayList.add(c1578l.m12127b());
        }
        arrayList.addAll(m12129d);
        C1659c m12966a = m12966a(interfaceC1644j, c1578l, arrayList);
        if (m12966a == null) {
            C1628a m12965a = m12965a(interfaceC1644j, c1691n, c1578l, m12124a);
            m12967a(c1578l);
            return m12965a;
        }
        interfaceC1644j.mo12575d().add(m12966a);
        InterfaceC1644j m13000b = c1691n.m13000b();
        c1691n.m12998a(m12966a);
        C1654c m12895a = C1684g.m12895a(C1684g.m12893a(m12966a.m12727g()));
        C1684g.m12909c(m12895a);
        C1654c m12694a = !c1578l.m12128c().contains(m12895a.m12701d()) ? C1654c.m12694a(m12895a) : m12895a;
        m12966a.m12722a(m12694a.m12695a());
        arrayList.removeAll(m12694a.m12698b());
        if (!arrayList.isEmpty() && (m12702e = m12694a.m12702e()) != null) {
            for (C1638d c1638d : c1578l.m12130e()) {
                if (arrayList.contains(c1638d.m12562a())) {
                    m12977a(c1691n, m12702e, c1638d);
                }
            }
        }
        if (m12966a.m12729i()) {
            c1628a = m12694a.m12701d();
            if (c1628a == m12124a) {
                c1628a = m12694a.m12702e();
            }
            m12124a.m12152d(C1566b.f10028b);
            c1578l.m12127b().mo12141a(EnumC1562a.SKIP);
            c1691n.m12997a(c1578l.m12127b());
            this.f10518e.clear(m12124a.m12440d());
            m12966a.m12724b(m12986a(m12124a, c1691n));
            m12124a.mo12142a(C1566b.f10028b, c1578l);
            c1578l.m12127b().mo12151c(EnumC1562a.SKIP);
        } else {
            C1628a m12702e2 = m12694a.m12702e();
            C1628a c1628a2 = (m13000b == null || !m12702e2.mo12149b(EnumC1562a.LOOP_START) || m12702e2.mo12150c(C1566b.f10028b).contains(c1578l) || !C1743l.m13291a(m13000b, m12702e2)) ? m12702e2 : null;
            c1691n.m12997a(c1628a2);
            C1656b m12986a = m12986a(m12694a.m12701d(), c1691n);
            C1628a m12704g = m12694a.m12704g();
            if (m12124a != m12704g) {
                Set<C1628a> m13209b = C1721a.m13209b(m12124a, m12704g);
                m13209b.remove(m12704g);
                for (C1628a c1628a3 : m13209b) {
                    if (c1628a3.mo12446j().isEmpty() && !c1628a3.mo12149b(EnumC1562a.SKIP) && !C1743l.m13291a(m12986a, c1628a3)) {
                        m12986a.m12715a((InterfaceC1642h) c1628a3);
                    }
                }
            }
            m12966a.m12724b(m12986a);
            c1628a = c1628a2;
        }
        c1691n.m12996a();
        m12967a(c1578l);
        return c1628a;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0006 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C1659c m12966a(InterfaceC1644j interfaceC1644j, C1578l c1578l, List<C1628a> list) {
        boolean z;
        boolean z2;
        boolean z3;
        Iterator<C1628a> it = list.iterator();
        while (it.hasNext()) {
            C1628a next = it.next();
            if (!next.mo12145a(C1566b.f10033g) && next.mo12446j().size() == 1 && next.mo12446j().get(0).m12587o() == EnumC1621l.IF) {
                List c2 = next.mo12150c(C1566b.f10028b);
                if (c2.isEmpty() || c2.get(0) == c1578l) {
                    C1659c c1659c = new C1659c(interfaceC1644j, c1578l, next, next == c1578l.m12127b());
                    if (next == c1578l.m12124a() || next == c1578l.m12127b() || C1721a.m13219f(c1578l.m12124a(), next)) {
                        z = true;
                    } else if (next.m12441e().contains(c1578l.m12124a())) {
                        c1659c.m12721a(c1578l.m12124a());
                        z = c1659c.m12730j();
                    } else {
                        z = false;
                    }
                    if (z && this.f10515b.m12630d(next).size() >= 2) {
                        Iterator<C1628a> it2 = next.m12443g().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z3 = true;
                                break;
                            }
                            List<C1578l> m12630d = this.f10515b.m12630d(it2.next());
                            m12630d.remove(c1578l);
                            if (!m12630d.isEmpty()) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            z2 = false;
                            if (!z2) {
                                return c1659c;
                            }
                        }
                    }
                    z2 = z;
                    if (!z2) {
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private C1628a m12965a(InterfaceC1644j interfaceC1644j, C1691n c1691n, C1578l c1578l, C1628a c1628a) {
        C1628a c1628a2;
        C1628a c1628a3 = null;
        C1659c c1659c = new C1659c(interfaceC1644j, c1578l, null, false);
        interfaceC1644j.mo12575d().add(c1659c);
        c1628a.m12152d(C1566b.f10028b);
        this.f10518e.clear(c1628a.m12440d());
        c1691n.m12998a(c1659c);
        List<C1638d> m12130e = c1578l.m12130e();
        if (m12130e.size() == 1) {
            C1638d c1638d = m12130e.get(0);
            C1628a m12563b = c1638d.m12563b();
            if (!m12977a(c1691n, m12563b, c1638d) || (c1628a2 = C1721a.m13210c(m12563b)) == null) {
                c1628a2 = null;
            } else {
                c1691n.m12997a(c1628a2);
            }
        } else {
            c1628a2 = null;
            for (C1638d c1638d2 : m12130e) {
                C1628a m12563b2 = c1638d2.m12563b();
                for (C1628a c1628a4 : C1721a.m13207b(this.f10515b, m12563b2.m12449m())) {
                    if (C1721a.m13213c(m12563b2, c1628a4)) {
                        c1691n.m12997a(c1628a4);
                        m12977a(c1691n, c1628a4, c1638d2);
                        c1628a2 = c1628a4;
                    } else {
                        m12977a(c1691n, m12563b2, c1638d2);
                    }
                }
            }
        }
        C1656b m12986a = m12986a(c1628a, c1691n);
        C1628a m12127b = c1578l.m12127b();
        if (!C1743l.m13291a(m12986a, m12127b) && !m12127b.mo12145a(C1566b.f10033g) && !m12973a(m12127b)) {
            m12986a.mo12575d().add(m12127b);
        }
        c1659c.m12724b(m12986a);
        if (c1628a2 == null) {
            C1628a m13210c = C1721a.m13210c(m12127b);
            if (!C1743l.m13291a(m12986a, m13210c)) {
                c1628a3 = m13210c;
            }
        } else {
            c1628a3 = c1628a2;
        }
        c1691n.m12996a();
        c1628a.mo12142a(C1566b.f10028b, c1578l);
        return c1628a3;
    }

    /* renamed from: a */
    private boolean m12973a(C1628a c1628a) {
        if (this.f10515b.m12608F() == 0) {
            return false;
        }
        Iterator<C1666c> it = this.f10515b.m12606D().iterator();
        while (it.hasNext()) {
            if (it.next().m12760e().contains(c1628a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m12981b(C1628a c1628a) {
        if (c1628a.mo12149b(EnumC1562a.RETURN) || C1721a.m13202a(c1628a, EnumC1621l.BREAK)) {
            return false;
        }
        List<C1628a> m13214d = C1721a.m13214d(c1628a);
        if (!m13214d.isEmpty()) {
            C1628a c1628a2 = m13214d.get(m13214d.size() - 1);
            if (c1628a2.mo12149b(EnumC1562a.RETURN) || c1628a2.m12442f().isEmpty()) {
                return false;
            }
        }
        Iterator<C1628a> it = C1721a.m13209b(this.f10515b.m12648z(), c1628a).iterator();
        while (it.hasNext()) {
            if (C1721a.m13202a(it.next(), EnumC1621l.SWITCH)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[ADDED_TO_REGION, LOOP:0: B:13:0x0039->B:33:0x0064, LOOP_START, PHI: r5 r6
      0x0039: PHI (r5v3 jadx.core.c.d.a) = (r5v1 jadx.core.c.d.a), (r5v5 jadx.core.c.d.a) binds: [B:12:0x0037, B:33:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0039: PHI (r6v3 jadx.core.c.d.a) = (r6v0 jadx.core.c.d.a), (r6v4 jadx.core.c.d.a) binds: [B:12:0x0037, B:33:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m12977a(C1691n c1691n, C1628a c1628a, C1638d c1638d) {
        boolean z;
        C1628a c1628a2;
        boolean z2;
        C1628a c1628a3;
        C1628a m13189a;
        C1628a m12563b = c1638d.m12563b();
        if (c1628a == m12563b) {
            c1628a2 = c1638d.m12562a();
            if (c1628a2.mo12145a(C1566b.f10034h) && c1628a2.m12442f().size() == 2 && (m13189a = C1721a.m13189a(c1628a, c1628a2.m12442f())) != null && C1721a.m13218f(m13189a).mo12145a(C1566b.f10033g)) {
                z = true;
                if (!z) {
                    while (m12563b != null) {
                        if (c1628a2 != null && C1721a.m13213c(c1628a, m12563b)) {
                            if (!m12981b(c1628a2)) {
                                return false;
                            }
                            z2 = true;
                            c1628a3 = c1628a2;
                            if (!z2) {
                                return false;
                            }
                            C1646l c1646l = new C1646l(EnumC1621l.BREAK, 0);
                            C1568b.m12090a(c1628a3, c1628a3.m12442f().get(0), c1646l);
                            c1691n.m12997a(m12563b);
                            m12969a(c1638d, m12563b, c1646l);
                            return true;
                        }
                        List<C1628a> m12443g = m12563b.m12443g();
                        c1628a2 = m12563b;
                        m12563b = m12443g.size() == 1 ? m12443g.get(0) : null;
                    }
                }
                z2 = z;
                c1628a3 = c1628a2;
                if (!z2) {
                }
            }
        }
        z = false;
        c1628a2 = null;
        if (!z) {
        }
        z2 = z;
        c1628a3 = c1628a2;
        if (!z2) {
        }
    }

    /* renamed from: a */
    private void m12969a(C1638d c1638d, C1628a c1628a, C1646l c1646l) {
        C1578l c1578l;
        C1628a m13210c = C1721a.m13210c(c1638d.m12563b());
        if (m13210c != null && this.f10515b.m12630d(m13210c).isEmpty()) {
            List<C1578l> m12630d = this.f10515b.m12630d(c1638d.m12562a());
            if (m12630d.size() >= 2) {
                Iterator<C1578l> it = m12630d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        c1578l = null;
                        break;
                    } else {
                        c1578l = it.next();
                        if (c1578l.m12132g() == null) {
                            break;
                        }
                    }
                }
                if (c1578l != null && c1578l.m12127b() != c1628a && !c1578l.m12129d().contains(c1628a)) {
                    C1579m c1579m = new C1579m(c1578l);
                    c1646l.mo12144a(c1579m);
                    c1578l.m12124a().mo12144a(c1579m);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12967a(C1578l c1578l) {
        C1628a m12127b = c1578l.m12127b();
        List<C1628a> m12441e = m12127b.m12441e();
        if (m12441e.size() > 1) {
            Set<C1628a> m12129d = c1578l.m12129d();
            for (C1628a c1628a : m12441e) {
                if (m12976a(c1628a, m12441e, m12127b, m12129d)) {
                    c1628a.mo12446j().add(new C1646l(EnumC1621l.CONTINUE, 0));
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m12976a(C1628a c1628a, List<C1628a> list, C1628a c1628a2, Set<C1628a> set) {
        boolean z;
        if (!c1628a.mo12149b(EnumC1562a.SYNTHETIC) || C1721a.m13202a(c1628a, EnumC1621l.CONTINUE)) {
            return false;
        }
        List<C1628a> m12441e = c1628a.m12441e();
        if (m12441e.isEmpty()) {
            return false;
        }
        C1628a c1628a3 = m12441e.get(0);
        if (c1628a3.mo12149b(EnumC1562a.SKIP) || c1628a2.m12436a(c1628a3) || set.contains(c1628a3) || m12975a(c1628a3, list)) {
            return false;
        }
        Iterator<C1628a> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (C1721a.m13213c(c1628a3, it.next())) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m12975a(C1628a c1628a, List<C1628a> list) {
        Iterator<C1628a> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().m12436a(c1628a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private C1628a m12963a(InterfaceC1644j interfaceC1644j, C1628a c1628a, C1646l c1646l, C1691n c1691n) {
        C1628a c1628a2;
        C1662d c1662d = new C1662d(interfaceC1644j, c1646l);
        c1662d.mo12575d().add(c1628a);
        interfaceC1644j.mo12575d().add(c1662d);
        HashSet<C1628a> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        m12971a(c1662d, c1646l.mo12426d(0), c1628a, hashSet, hashSet2);
        for (C1646l c1646l2 : c1662d.m12741f()) {
            C1628a m13192a = C1721a.m13192a(this.f10515b, c1646l2);
            if (m13192a != null) {
                m13192a.mo12141a(EnumC1562a.SKIP);
            }
            c1646l2.mo12141a(EnumC1562a.SKIP);
            C1740i.m13278a(this.f10515b, c1646l2);
        }
        C1628a m13210c = C1721a.m13210c(c1628a);
        if (m13210c == null) {
            C1735d.m13258a(this.f10515b, "Unexpected end of synchronized block");
            return null;
        }
        if (hashSet.size() == 1) {
            c1628a2 = C1721a.m13210c((C1628a) hashSet.iterator().next());
        } else if (hashSet.size() > 1) {
            hashSet2.clear();
            c1628a2 = m12959a(m13210c, hashSet, hashSet2);
        } else {
            c1628a2 = null;
        }
        c1691n.m12998a(c1662d);
        if (c1628a2 != null) {
            c1691n.m12997a(c1628a2);
        } else {
            for (C1628a c1628a3 : hashSet) {
                List<C1628a> m13214d = C1721a.m13214d(c1628a3);
                if (m13214d.isEmpty() || !m13214d.get(m13214d.size() - 1).m12442f().isEmpty()) {
                    c1691n.m12997a(c1628a3);
                }
            }
        }
        c1662d.mo12575d().add(m12986a(m13210c, c1691n));
        c1691n.m12996a();
        return c1628a2;
    }

    /* renamed from: a */
    private static void m12971a(C1662d c1662d, AbstractC1598c abstractC1598c, C1628a c1628a, Set<C1628a> set, Set<C1628a> set2) {
        set2.add(c1628a);
        for (C1646l c1646l : c1628a.mo12446j()) {
            if (c1646l.m12587o() == EnumC1621l.MONITOR_EXIT && c1646l.mo12426d(0).equals(abstractC1598c)) {
                set.add(c1628a);
                c1662d.m12741f().add(c1646l);
                return;
            }
        }
        for (C1628a c1628a2 : c1628a.m12442f()) {
            if (!set2.contains(c1628a2)) {
                m12971a(c1662d, abstractC1598c, c1628a2, set, set2);
            }
        }
    }

    /* renamed from: a */
    private static C1628a m12959a(C1628a c1628a, Set<C1628a> set, Set<C1628a> set2) {
        boolean z;
        C1628a m12959a;
        set2.add(c1628a);
        for (C1628a c1628a2 : c1628a.m12443g()) {
            Iterator<C1628a> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!C1721a.m13213c(it.next(), c1628a2)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return c1628a2;
            }
            if (!set2.contains(c1628a2) && (m12959a = m12959a(c1628a2, set, set2)) != null) {
                return m12959a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private C1628a m12961a(InterfaceC1644j interfaceC1644j, C1628a c1628a, C1617h c1617h, C1691n c1691n) {
        if (c1628a.mo12149b(EnumC1562a.SKIP)) {
            return c1617h.m12389j();
        }
        C1654c m12893a = C1684g.m12893a(c1628a);
        C1654c m12906b = C1684g.m12906b(m12893a);
        if (m12906b == null) {
            m12906b = C1654c.m12694a(m12893a);
        }
        C1654c m12894a = C1684g.m12894a(this.f10515b, c1628a, m12906b);
        if (m12894a == null) {
            if (m12906b.m12698b().size() <= 1) {
                return null;
            }
            C1654c m12894a2 = C1684g.m12894a(this.f10515b, c1628a, C1684g.m12893a(c1628a));
            if (m12894a2 == null) {
                return null;
            }
            m12894a = m12894a2;
        }
        C1684g.m12909c(m12894a);
        C1655d c1655d = new C1655d(interfaceC1644j, c1628a);
        c1655d.m12706a(m12894a.m12695a());
        interfaceC1644j.mo12575d().add(c1655d);
        C1628a m12703f = m12894a.m12703f();
        c1691n.m12998a(c1655d);
        c1691n.m12997a(m12703f);
        c1655d.m12705a((InterfaceC1642h) m12986a(m12894a.m12701d(), c1691n));
        C1628a m12702e = m12894a.m12702e();
        if (m12702e == null || c1691n.m13003c(m12702e)) {
            c1655d.m12707b((InterfaceC1642h) null);
        } else {
            c1655d.m12707b(m12986a(m12702e, c1691n));
        }
        if (c1655d.m12710g() == null && m12703f != null) {
            List<C1568b> c2 = m12703f.mo12150c(C1566b.f10029c);
            if (!c2.isEmpty()) {
                C1656b c1656b = new C1656b(c1655d);
                for (C1568b c1568b : c2) {
                    if (c1568b.m12092c().equals(m12703f)) {
                        m12970a(m12894a, c1656b, c1568b);
                    }
                }
                c1655d.m12707b(c1656b);
            }
        }
        c1691n.m12996a();
        return m12703f;
    }

    /* renamed from: a */
    private void m12970a(C1654c c1654c, C1656b c1656b, C1568b c1568b) {
        boolean z;
        C1628a m12091a = c1568b.m12091a();
        if (!m12091a.mo12149b(EnumC1562a.SKIP)) {
            Iterator<C1628a> it = c1654c.m12698b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().m12442f().contains(m12091a)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                c1656b.m12715a((InterfaceC1642h) m12091a);
            }
        }
    }

    /* renamed from: a */
    private C1628a m12962a(InterfaceC1644j interfaceC1644j, C1628a c1628a, C1626q c1626q, C1691n c1691n) {
        Map<C1628a, List<Object>> map;
        C1628a c1628a2;
        C1628a m12127b;
        boolean z;
        BitSet bitSet;
        C1661c c1661c = new C1661c(interfaceC1644j, c1628a);
        interfaceC1644j.mo12575d().add(c1661c);
        int length = c1626q.m12429i().length;
        LinkedHashMap linkedHashMap = new LinkedHashMap(length);
        for (int i = 0; i < length; i++) {
            ((List) C1741j.m13285a(linkedHashMap, c1626q.m12431k()[i], new InterfaceC1736e<C1628a, List<Object>>() { // from class: jadx.core.c.g.b.l.1
                @Override // jadx.core.p203d.InterfaceC1736e
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public List<Object> mo12561a(C1628a c1628a3) {
                    return new ArrayList(2);
                }
            })).add(c1626q.m12428h()[i]);
        }
        C1628a m12432l = c1626q.m12432l();
        if (m12432l != null) {
            linkedHashMap.remove(m12432l);
        }
        C1578l m12629c = this.f10515b.m12629c(c1628a);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        List<C1628a> m12647y = this.f10515b.m12647y();
        BitSet bitSet2 = new BitSet(m12647y.size());
        bitSet2.mo13226or(c1628a.m12449m());
        for (C1628a c1628a3 : c1628a.m12443g()) {
            BitSet m12449m = c1628a3.m12449m();
            if (m12449m.cardinality() > 1) {
                if (m12449m.cardinality() > 2) {
                    f10513a.mo15932a("Unexpected case pattern, block: {}, mth: {}", c1628a3, this.f10515b);
                    bitSet = m12449m;
                } else {
                    C1628a c1628a4 = m12647y.get(m12449m.nextSetBit(0));
                    C1628a c1628a5 = m12647y.get(m12449m.nextSetBit(c1628a4.m12440d() + 1));
                    if (c1628a5.m12449m().get(c1628a4.m12440d())) {
                        linkedHashMap2.put(c1628a3, c1628a5);
                        bitSet = new BitSet(m12449m.size());
                        bitSet.set(c1628a4.m12440d());
                    } else if (c1628a4.m12449m().get(c1628a5.m12440d())) {
                        linkedHashMap2.put(c1628a3, c1628a4);
                        bitSet = new BitSet(m12449m.size());
                        bitSet.set(c1628a5.m12440d());
                    }
                }
                bitSet2.mo13226or(bitSet);
            }
            bitSet = m12449m;
            bitSet2.mo13226or(bitSet);
        }
        bitSet2.clear(c1628a.m12440d());
        if (m12629c != null) {
            bitSet2.clear(m12629c.m12124a().m12440d());
        }
        c1691n.m12998a(c1661c);
        c1691n.m12999a(C1721a.m13207b(this.f10515b, bitSet2));
        if (linkedHashMap2.isEmpty() || !m12978a(linkedHashMap, linkedHashMap2)) {
            map = linkedHashMap;
        } else {
            f10513a.mo15931a("Fixing incorrect switch cases order, method: {}", this.f10515b);
            Map<C1628a, List<Object>> m12980b = m12980b(linkedHashMap, linkedHashMap2);
            if (m12978a(m12980b, linkedHashMap2)) {
                f10513a.mo15946d("Can't fix incorrect switch cases order, method: {}", this.f10515b);
                this.f10515b.mo12141a(EnumC1562a.INCONSISTENT_CODE);
            }
            map = m12980b;
        }
        if (bitSet2.cardinality() > 1) {
            C1721a.m13196a(this.f10515b, bitSet2);
        }
        if (bitSet2.cardinality() > 1) {
            for (int nextSetBit = bitSet2.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet2.nextSetBit(nextSetBit + 1)) {
                C1628a c1628a6 = m12647y.get(nextSetBit);
                bitSet2.andNot(c1628a6.m12449m());
                if (c1628a6.mo12149b(EnumC1562a.LOOP_START)) {
                    bitSet2.clear(c1628a6.m12440d());
                } else {
                    Iterator<C1628a> it = c1628a6.m12443g().iterator();
                    while (it.hasNext()) {
                        bitSet2.clear(it.next().m12440d());
                    }
                }
            }
        }
        if (m12629c != null && bitSet2.cardinality() > 1) {
            bitSet2.clear(m12629c.m12127b().m12440d());
        }
        if (bitSet2.cardinality() == 0) {
            Iterator<C1628a> it2 = c1628a.m12442f().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                C1628a next = it2.next();
                Iterator<C1628a> it3 = c1628a.m12442f().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = true;
                        break;
                    }
                    if (!C1721a.m13213c(it3.next(), next)) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    bitSet2.set(next.m12440d());
                    break;
                }
            }
        }
        if (bitSet2.cardinality() == 1) {
            C1628a c1628a7 = m12647y.get(bitSet2.nextSetBit(0));
            c1691n.m12997a(c1628a7);
            c1628a2 = c1628a7;
        } else {
            if (m12629c == null && bitSet2.cardinality() > 1) {
                f10513a.mo15937b("Can't detect out node for switch block: {} in {}", c1628a, this.f10515b);
            }
            c1628a2 = null;
        }
        if (m12629c != null && c1628a2 != (m12127b = m12629c.m12127b()) && c1628a2 != null) {
            m12968a(c1628a, c1628a2, m12127b);
        }
        if (!c1691n.m13003c(m12432l)) {
            c1661c.m12734a((InterfaceC1642h) m12986a(m12432l, c1691n));
        }
        for (Map.Entry<C1628a, List<Object>> entry : map.entrySet()) {
            C1628a key = entry.getKey();
            if (c1691n.m13003c(key)) {
                c1661c.m12735a(entry.getValue(), new C1656b(c1691n.m13000b()));
            } else {
                C1628a c1628a8 = linkedHashMap2.get(key);
                c1691n.m12997a(c1628a8);
                C1656b m12986a = m12986a(key, c1691n);
                c1691n.m13001b(c1628a8);
                if (c1628a8 != null) {
                    c1628a8.mo12141a(EnumC1562a.FALL_THROUGH);
                    m12986a.mo12141a(EnumC1562a.FALL_THROUGH);
                }
                c1661c.m12735a(entry.getValue(), m12986a);
            }
        }
        c1691n.m12996a();
        return c1628a2;
    }

    /* renamed from: a */
    private boolean m12978a(Map<C1628a, List<Object>> map, Map<C1628a, C1628a> map2) {
        C1628a c1628a = null;
        Iterator<C1628a> it = map.keySet().iterator();
        while (true) {
            C1628a c1628a2 = c1628a;
            if (!it.hasNext()) {
                return c1628a2 != null;
            }
            C1628a next = it.next();
            if (c1628a2 != null && !next.equals(c1628a2)) {
                return true;
            }
            c1628a = map2.get(next);
        }
    }

    /* renamed from: b */
    private Map<C1628a, List<Object>> m12980b(Map<C1628a, List<Object>> map, final Map<C1628a, C1628a> map2) {
        ArrayList<C1628a> arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList, new Comparator<C1628a>() { // from class: jadx.core.c.g.b.l.2
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C1628a c1628a, C1628a c1628a2) {
                C1628a c1628a3 = (C1628a) map2.get(c1628a);
                if (c1628a3 != null) {
                    if (c1628a2.equals(c1628a3)) {
                        return -1;
                    }
                } else if (c1628a.equals(map2.get(c1628a2))) {
                    return 1;
                }
                return 0;
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (C1628a c1628a : arrayList) {
            linkedHashMap.put(c1628a, map.get(c1628a));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private static void m12968a(C1628a c1628a, C1628a c1628a2, C1628a c1628a3) {
        int m12440d = c1628a3.m12440d();
        for (C1628a c1628a4 : c1628a.m12443g()) {
            if (c1628a4.m12449m().get(m12440d) && c1628a4 != c1628a2) {
                List<C1628a> m13216e = C1721a.m13216e(c1628a4, c1628a4);
                Iterator<C1628a> it = c1628a3.m12441e().iterator();
                while (true) {
                    if (it.hasNext()) {
                        C1628a next = it.next();
                        if (m13216e.contains(next)) {
                            if (next.m12452p()) {
                                next.mo12446j().add(new C1646l(EnumC1621l.CONTINUE, 0));
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public InterfaceC1644j m12984a(C1648n c1648n) {
        HashSet hashSet = new HashSet();
        Iterator<C1666c> it = c1648n.m12606D().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().m12763h());
        }
        for (C1668e c1668e : hashSet) {
            ArrayList<C1628a> arrayList = new ArrayList(c1668e.m12776b());
            HashSet<C1628a> hashSet2 = new HashSet();
            for (C1666c c1666c : c1668e.m12769a()) {
                C1628a m12759d = c1666c.m12759d();
                if (m12759d != null) {
                    arrayList.add(m12759d);
                    hashSet2.addAll(m12759d.m12441e());
                } else {
                    f10513a.mo15930a(C1735d.m13256a((InterfaceC1643i) c1648n, "No exception handler block: " + c1666c));
                }
            }
            HashSet hashSet3 = new HashSet();
            for (C1628a c1628a : hashSet2) {
                for (C1628a c1628a2 : arrayList) {
                    List<C1628a> m12442f = c1628a.m12442f();
                    if (m12442f.isEmpty()) {
                        f10513a.mo15930a(C1735d.m13256a((InterfaceC1643i) c1648n, "No successors for splitter: " + c1628a));
                    } else {
                        C1628a c1628a3 = m12442f.get(0);
                        C1628a m13191a = C1721a.m13191a(c1648n, c1628a3, c1628a2);
                        if (m13191a != null && m13191a != c1628a3 && m13191a != c1628a2) {
                            hashSet3.add(m13191a);
                        }
                    }
                }
            }
            Iterator<C1666c> it2 = c1668e.m12769a().iterator();
            while (it2.hasNext()) {
                m12972a(it2.next(), hashSet3);
            }
        }
        return m12985a(c1648n, hashSet);
    }

    /* renamed from: a */
    protected InterfaceC1644j m12985a(C1648n c1648n, Set<C1668e> set) {
        HashSet hashSet = new HashSet();
        C1743l.m13288a(c1648n.m12616N(), hashSet);
        HashSet<InterfaceC1640f> hashSet2 = new HashSet();
        Iterator<C1668e> it = set.iterator();
        while (it.hasNext()) {
            Iterator<C1666c> it2 = it.next().m12769a().iterator();
            while (it2.hasNext()) {
                InterfaceC1642h m12761f = it2.next().m12761f();
                if (m12761f != null) {
                    InterfaceC1640f m13296c = C1743l.m13296c(m12761f);
                    if (m13296c instanceof C1628a) {
                        hashSet2.addAll(((C1628a) m13296c).m12442f());
                    }
                    C1743l.m13288a(m12761f, hashSet);
                }
            }
        }
        hashSet2.removeAll(hashSet);
        if (hashSet2.isEmpty()) {
            return null;
        }
        C1656b c1656b = new C1656b(c1648n.m12616N());
        for (InterfaceC1640f interfaceC1640f : hashSet2) {
            if (interfaceC1640f instanceof C1628a) {
                c1656b.m12715a((InterfaceC1642h) m12986a((C1628a) interfaceC1640f, new C1691n(c1648n)));
            }
        }
        return c1656b;
    }

    /* renamed from: a */
    private void m12972a(C1666c c1666c, Set<C1628a> set) {
        C1628a c1628a;
        C1628a m12759d = c1666c.m12759d();
        if (m12759d != null) {
            C1691n c1691n = new C1691n(this.f10515b);
            if (c1666c.m12764i()) {
                C1667d c1667d = (C1667d) m12759d.mo12146b(C1566b.f10035i);
                if (c1667d != null) {
                    c1628a = c1667d.m12765a();
                } else {
                    return;
                }
            } else {
                c1691n.m12999a(set);
                c1628a = m12759d;
            }
            List<C1628a> m13207b = C1721a.m13207b(this.f10515b, c1628a.m12449m());
            boolean z = this.f10515b.m12629c(m12759d) != null;
            for (C1628a c1628a2 : m13207b) {
                if (!z || C1721a.m13213c(m12759d, c1628a2)) {
                    if (C1743l.m13291a(this.f10515b.m12616N(), c1628a2)) {
                        c1691n.m12997a(c1628a2);
                    }
                }
            }
            c1666c.m12753a(m12986a(m12759d, c1691n));
            C1665b c1665b = (C1665b) m12759d.mo12146b(C1566b.f10033g);
            if (c1665b == null) {
                f10513a.mo15941c("Missing exception handler attribute for start block");
            } else {
                c1666c.m12761f().mo12144a(c1665b);
            }
        }
    }

    /* renamed from: a */
    static boolean m12974a(C1628a c1628a, C1628a c1628a2) {
        if (c1628a == c1628a2) {
            return true;
        }
        if (c1628a == null || c1628a2 == null) {
            return false;
        }
        return m12982b(c1628a, c1628a2) || m12983c(c1628a, c1628a2);
    }

    /* renamed from: c */
    private static boolean m12983c(C1628a c1628a, C1628a c1628a2) {
        C1628a m13218f = C1721a.m13218f(c1628a);
        C1628a m13218f2 = C1721a.m13218f(c1628a2);
        return !(m13218f == c1628a && m13218f2 == c1628a2) && m12974a(m13218f, m13218f2);
    }

    /* renamed from: b */
    public static boolean m12982b(C1628a c1628a, C1628a c1628a2) {
        if (!c1628a.m12453q() || !c1628a2.m12453q()) {
            return false;
        }
        List<C1646l> mo12446j = c1628a.mo12446j();
        List<C1646l> mo12446j2 = c1628a2.mo12446j();
        if (mo12446j.size() != 1 || mo12446j2.size() != 1) {
            return false;
        }
        C1646l c1646l = mo12446j.get(0);
        C1646l c1646l2 = mo12446j2.get(0);
        if (c1646l.m12590r() != c1646l2.m12590r()) {
            return false;
        }
        return c1646l.m12590r() == 0 || c1646l.mo12426d(0).equals(c1646l2.mo12426d(0));
    }
}
