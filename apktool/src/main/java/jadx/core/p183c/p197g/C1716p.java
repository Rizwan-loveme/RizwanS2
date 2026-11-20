package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p184a.p186b.C1570d;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.C1615f;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.C1624o;
import jadx.core.p183c.p188c.C1626q;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1740i;
import java.util.Iterator;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ReSugarCode.java */
/* renamed from: jadx.core.c.g.p */
/* loaded from: classes.dex */
public class C1716p extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10560a = C2568c.m15995a((Class<?>) C1716p.class);

    /* renamed from: b */
    private static /* synthetic */ int[] f10561b;

    /* renamed from: a */
    static /* synthetic */ int[] m13148a() {
        int[] iArr = f10561b;
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
            f10561b = iArr;
        }
        return iArr;
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public boolean mo12781a(C1636b c1636b) {
        m13150b(c1636b);
        return true;
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            C1740i c1740i = new C1740i(c1648n);
            for (C1628a c1628a : c1648n.m12647y()) {
                c1740i.m13283a(c1628a);
                List<C1646l> mo12446j = c1628a.mo12446j();
                int size = mo12446j.size();
                for (int i = 0; i < size; i++) {
                    C1646l m13144a = m13144a(c1648n, mo12446j, i, c1740i);
                    if (m13144a != null) {
                        mo12446j.set(i, m13144a);
                    }
                }
                c1740i.m13282a();
            }
        }
    }

    /* renamed from: a */
    private static C1646l m13144a(C1648n c1648n, List<C1646l> list, int i, C1740i c1740i) {
        C1646l c1646l = list.get(i);
        switch (m13148a()[c1646l.m12587o().ordinal()]) {
            case 16:
                m13147a(c1648n, (C1626q) c1646l);
                return null;
            case 26:
                return m13149b(c1648n, list, i, c1740i);
            default:
                return null;
        }
    }

    /* renamed from: b */
    private static C1646l m13149b(C1648n c1648n, List<C1646l> list, int i, C1740i c1740i) {
        C1624o c1624o = (C1624o) list.get(i);
        AbstractC1598c d2 = c1624o.mo12426d(0);
        if (!d2.mo12311i()) {
            return null;
        }
        int m12317d = (int) ((C1600e) d2).m12317d();
        int size = list.size();
        if (m12317d <= 0 || i + m12317d >= size || list.get(i + m12317d).m12587o() != EnumC1621l.APUT) {
            return null;
        }
        C1615f c1615f = new C1615f(c1624o.m12418f().mo12288n(), m12317d);
        c1615f.m12581b(c1624o.m12588p());
        for (int i2 = 0; i2 < m12317d; i2++) {
            C1646l c1646l = list.get(i + 1 + i2);
            if (c1646l.m12587o() != EnumC1621l.APUT) {
                f10560a.mo15932a("Not a APUT in expected new filled array: {}, method: {}", c1646l, c1648n);
                return null;
            }
            c1615f.m12584c(c1646l.mo12426d(2));
            c1740i.m13284a(c1646l);
        }
        return c1615f;
    }

    /* renamed from: a */
    private static void m13147a(C1648n c1648n, C1626q c1626q) {
        a m13145a;
        AbstractC1598c d2 = c1626q.mo12426d(0);
        if (d2.mo12312j()) {
            C1646l m12316d = ((C1599d) d2).m12316d();
            if (m12316d.m12587o() == EnumC1621l.AGET && (m13145a = m13145a(c1648n.mo12540t(), m12316d)) != null) {
                C1639e m13153b = m13145a.m13153b();
                AbstractC1598c m13152a = m13145a.m13152a();
                C1570d.a m13143a = m13143a(c1648n, m13153b);
                if (m13143a != null) {
                    Object[] m12428h = c1626q.m12428h();
                    for (Object obj : m12428h) {
                        if (m13143a.m12105a(obj) == null) {
                            return;
                        }
                    }
                    if (c1626q.mo12424a(d2, m13152a)) {
                        for (int i = 0; i < m12428h.length; i++) {
                            m12428h[i] = m13143a.m12105a(m12428h[i]);
                        }
                        m13153b.mo12141a(EnumC1562a.DONT_GENERATE);
                        m13151c(m13153b.m12570k());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static void m13150b(C1636b c1636b) {
        C1648n m12537q = c1636b.m12537q();
        if (m12537q != null && !m12537q.m12641p()) {
            C1570d c1570d = new C1570d();
            Iterator<C1628a> it = m12537q.m12647y().iterator();
            while (it.hasNext()) {
                for (C1646l c1646l : it.next().mo12446j()) {
                    if (c1646l.m12587o() == EnumC1621l.APUT) {
                        m13146a(c1636b.mo12540t(), c1570d, c1646l);
                    }
                }
            }
            if (!c1570d.m12104a()) {
                c1636b.mo12144a((InterfaceC1587g) c1570d);
            }
        }
    }

    /* renamed from: a */
    private static C1570d.a m13143a(C1648n c1648n, C1639e c1639e) {
        C1570d c1570d = (C1570d) c1639e.m12570k().mo12146b(C1566b.f10041o);
        if (c1570d == null) {
            return null;
        }
        return c1570d.m12102a(c1639e);
    }

    /* renamed from: a */
    private static void m13146a(C1637c c1637c, C1570d c1570d, C1646l c1646l) {
        a m13145a;
        C1639e m12551a;
        AbstractC1598c mo12426d = c1646l.mo12426d(2);
        if (mo12426d.mo12311i() && (m13145a = m13145a(c1637c, c1646l)) != null) {
            AbstractC1598c m13152a = m13145a.m13152a();
            C1639e m13153b = m13145a.m13153b();
            if (m13153b != null && m13152a.mo12312j()) {
                C1646l m12316d = ((C1599d) m13152a).m12316d();
                if (m12316d instanceof C1619j) {
                    Object m12394f = ((C1619j) m12316d).m12394f();
                    if ((m12394f instanceof C1592d) && (m12551a = c1637c.m12551a((C1592d) m12394f)) != null) {
                        c1570d.m12103a(m13153b, Integer.valueOf((int) ((C1600e) mo12426d).m12317d()), m12551a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static a m13145a(C1637c c1637c, C1646l c1646l) {
        AbstractC1598c mo12426d = c1646l.mo12426d(0);
        AbstractC1598c mo12426d2 = c1646l.mo12426d(1);
        if (!mo12426d.mo12312j() || !mo12426d2.mo12312j()) {
            return null;
        }
        C1646l m12316d = ((C1599d) mo12426d2).m12316d();
        C1646l m12316d2 = ((C1599d) mo12426d).m12316d();
        if (m12316d.m12587o() != EnumC1621l.INVOKE || m12316d2.m12587o() != EnumC1621l.SGET) {
            return null;
        }
        C1622m c1622m = (C1622m) m12316d;
        if (!c1622m.m12417h().m12244c().equals("ordinal()I")) {
            return null;
        }
        C1636b m12557b = c1637c.m12557b(c1622m.m12417h().m12245d());
        if (m12557b == null || !m12557b.m12535o()) {
            return null;
        }
        Object m12394f = ((C1619j) m12316d2).m12394f();
        if (!(m12394f instanceof C1592d)) {
            return null;
        }
        C1639e m12551a = c1637c.m12551a((C1592d) m12394f);
        if (m12551a == null || !m12551a.m12566g().m12183l()) {
            return null;
        }
        return new a(c1622m.mo12426d(0), m12551a);
    }

    /* renamed from: c */
    private static void m13151c(C1636b c1636b) {
        for (C1639e c1639e : c1636b.m12531k()) {
            C1589a m12566g = c1639e.m12566g();
            if (m12566g.m12183l() && m12566g.m12179h() && m12566g.m12180i() && !c1639e.mo12149b(EnumC1562a.DONT_GENERATE)) {
                return;
            }
        }
        c1636b.mo12141a(EnumC1562a.DONT_GENERATE);
    }

    /* compiled from: ReSugarCode.java */
    /* renamed from: jadx.core.c.g.p$a */
    private static class a {

        /* renamed from: a */
        private final AbstractC1598c f10562a;

        /* renamed from: b */
        private final C1639e f10563b;

        public a(AbstractC1598c abstractC1598c, C1639e c1639e) {
            this.f10562a = abstractC1598c;
            this.f10563b = c1639e;
        }

        /* renamed from: a */
        public AbstractC1598c m13152a() {
            return this.f10562a;
        }

        /* renamed from: b */
        public C1639e m13153b() {
            return this.f10563b;
        }
    }
}
