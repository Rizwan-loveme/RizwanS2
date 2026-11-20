package jadx.core.p183c.p197g;

import jadx.core.p181a.C1554j;
import jadx.core.p182b.C1559d;
import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1571e;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1595a;
import jadx.core.p183c.p188c.C1612c;
import jadx.core.p183c.p188c.C1613d;
import jadx.core.p183c.p188c.C1614e;
import jadx.core.p183c.p188c.C1615f;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.C1624o;
import jadx.core.p183c.p188c.C1626q;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1602g;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p196f.C1665b;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.C1740i;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ModVisitor.java */
/* renamed from: jadx.core.c.g.n */
/* loaded from: classes.dex */
public class C1714n extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10557a = C2568c.m15995a((Class<?>) C1714n.class);

    /* renamed from: b */
    private static /* synthetic */ int[] f10558b;

    /* renamed from: a */
    static /* synthetic */ int[] m13134a() {
        int[] iArr = f10558b;
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
            f10558b = iArr;
        }
        return iArr;
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            C1740i c1740i = new C1740i(c1648n);
            m13132a(c1648n, c1740i);
            m13137b(c1648n, c1740i);
            m13136b(c1648n);
        }
    }

    /* renamed from: a */
    private static void m13132a(C1648n c1648n, C1740i c1740i) {
        C1639e m12515a;
        C1639e m12515a2;
        C1636b m12640o = c1648n.m12640o();
        for (C1628a c1628a : c1648n.m12647y()) {
            c1740i.m13283a(c1628a);
            int size = c1628a.mo12446j().size();
            for (int i = 0; i < size; i++) {
                C1646l c1646l = c1628a.mo12446j().get(i);
                switch (m13134a()[c1646l.m12587o().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        if (c1646l.m12587o() == EnumC1621l.CONST_STR) {
                            m12515a2 = m12640o.m12516a((Object) ((C1613d) c1646l).m12377f());
                        } else if (c1646l.m12587o() == EnumC1621l.CONST_CLASS) {
                            m12515a2 = m12640o.m12516a(((C1612c) c1646l).m12375f());
                        } else {
                            m12515a2 = m12640o.m12515a((C1600e) c1646l.mo12426d(0));
                        }
                        if (m12515a2 != null) {
                            C1619j c1619j = new C1619j(EnumC1621l.SGET, m12515a2.m12565f(), 0);
                            c1619j.m12581b(c1646l.m12588p());
                            m13128a(c1628a, i, c1619j);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        C1595a c1595a = (C1595a) c1646l;
                        if (c1595a.m12590r() == 2) {
                            AbstractC1598c d2 = c1595a.mo12426d(1);
                            if (d2.mo12311i() && (m12515a = m12640o.m12515a((C1600e) d2)) != null) {
                                c1646l.mo12424a(d2, AbstractC1598c.m12306c(new C1619j(EnumC1621l.SGET, m12515a.m12565f(), 0)));
                                break;
                            }
                        } else {
                            break;
                        }
                        break;
                    case 12:
                        m13129a(c1628a, c1646l, c1740i);
                        break;
                    case 16:
                        C1626q c1626q = (C1626q) c1646l;
                        for (int i2 = 0; i2 < c1626q.m12427f(); i2++) {
                            C1639e m12516a = m12640o.m12516a(c1626q.m12428h()[i2]);
                            if (m12516a != null) {
                                c1626q.m12428h()[i2] = m12516a;
                            }
                        }
                        break;
                    case 22:
                        m13128a(c1628a, i, m13127a(c1648n, (C1614e) c1646l));
                        break;
                    case 26:
                        int i3 = i + 1;
                        if (i3 < size) {
                            C1646l c1646l2 = c1628a.mo12446j().get(i3);
                            if (c1646l2.m12587o() == EnumC1621l.FILL_ARRAY) {
                                c1646l2.m12588p().m12358a(c1648n.mo12540t(), c1646l.m12588p());
                                ((C1614e) c1646l2).m12378a(c1648n.mo12540t(), ((C1624o) c1646l).m12418f().mo12288n());
                                c1740i.m13284a(c1646l);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 32:
                        m13131a(c1648n, c1628a, i, c1740i);
                        break;
                }
            }
            c1740i.m13282a();
        }
    }

    /* renamed from: b */
    private static void m13137b(C1648n c1648n, C1740i c1740i) {
        for (C1628a c1628a : c1648n.m12647y()) {
            c1740i.m13283a(c1628a);
            for (C1646l c1646l : c1628a.mo12446j()) {
                switch (m13134a()[c1646l.m12587o().ordinal()]) {
                    case 10:
                    case 27:
                    case 33:
                        c1740i.m13284a(c1646l);
                        break;
                }
            }
            c1740i.m13282a();
        }
    }

    /* renamed from: a */
    private static void m13131a(C1648n c1648n, C1628a c1628a, int i, C1740i c1740i) {
        boolean z;
        C1648n m12525c;
        C1646l m13126a;
        C1636b m12640o = c1648n.m12640o();
        C1646l c1646l = c1628a.mo12446j().get(i);
        C1622m c1622m = (C1622m) c1646l;
        C1594f m12417h = c1622m.m12417h();
        if (m12417h.m12249h()) {
            C1646l m12333r = ((C1604i) c1622m.mo12426d(0)).m12333r();
            C1610a c1610a = new C1610a(c1648n, c1622m);
            if (c1610a.m12368l() && (c1610a.m12590r() == 0 || m12640o.m12535o())) {
                z = true;
            } else {
                z = c1610a.m12369m() && c1610a.m12590r() == 0 && ((m12525c = m12640o.m12525c(m12417h.m12244c())) == null || m12525c.m12641p());
            }
            if (m12640o.m12536p() && c1648n.m12610H() && c1610a.m12368l()) {
                z = true;
            }
            if (z) {
                c1740i.m13284a(c1646l);
                return;
            }
            if (c1610a.m12367k() && (m13126a = m13126a(m12333r, c1740i, EnumC1621l.NEW_INSTANCE)) != null) {
                C1604i m12588p = m13126a.m12588p();
                C1604i p = c1610a.m12588p();
                if (!p.equals(m12588p)) {
                    Iterator it = new ArrayList(m12588p.m12331p().m12348i()).iterator();
                    while (it.hasNext()) {
                        C1604i c1604i = (C1604i) it.next();
                        C1604i m12332q = p.m12332q();
                        C1646l l = c1604i.m12314l();
                        l.mo12424a(c1604i, m12332q);
                        m12332q.mo12309a(l);
                        p.m12331p().m12340b(m12332q);
                    }
                }
            }
            C1610a m13138c = m13138c(c1648n, c1610a);
            if (m13138c == null) {
                m13138c = c1610a;
            }
            m13128a(c1628a, i, m13138c);
            m13130a(c1648n, m13138c);
        }
    }

    /* renamed from: a */
    private static void m13130a(C1648n c1648n, C1610a c1610a) {
        C1648n m12553a = c1648n.mo12540t().m12553a(c1610a.m12363f());
        if (m12553a != null) {
            C1636b m12640o = m12553a.m12640o();
            C1590b m12544x = m12640o.m12544x();
            C1636b m12640o2 = c1648n.m12640o();
            if (m12544x.m12210l() && Character.isDigit(m12544x.m12203e().charAt(0)) && m12640o2.m12534n().contains(m12640o)) {
                Map<AbstractC1598c, C1639e> m13135b = m13135b(m12553a, c1610a);
                if (!m13135b.isEmpty() || m12553a.m12620a(true).isEmpty()) {
                    m12640o.mo12141a(EnumC1562a.ANONYMOUS_CLASS);
                    m12553a.mo12141a(EnumC1562a.DONT_GENERATE);
                    for (Map.Entry<AbstractC1598c, C1639e> entry : m13135b.entrySet()) {
                        C1639e value = entry.getValue();
                        if (value != null) {
                            AbstractC1598c key = entry.getKey();
                            value.mo12144a(new C1571e(key));
                            value.mo12141a(EnumC1562a.DONT_GENERATE);
                            if (key.mo12298h()) {
                                C1604i c1604i = (C1604i) key;
                                C1605j m12331p = c1604i.m12331p();
                                if (m12331p != null) {
                                    m12331p.mo12141a(EnumC1562a.FINAL);
                                    m12331p.mo12141a(EnumC1562a.DONT_INLINE);
                                }
                                c1604i.mo12141a(EnumC1562a.SKIP_ARG);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static Map<AbstractC1598c, C1639e> m13135b(C1648n c1648n, C1610a c1610a) {
        C1639e c1639e;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C1594f m12617O = c1648n.m12617O();
        C1636b m12640o = c1648n.m12640o();
        C1636b m12532l = m12640o.m12532l();
        List<C1604i> m12620a = c1648n.m12620a(false);
        int i = (m12617O.m12248g() == 0 || !m12617O.m12247f().get(0).equals(m12532l.m12544x().m12211m())) ? 0 : 1;
        int size = m12620a.size();
        for (int i2 = i; i2 < size; i2++) {
            C1646l m13125a = m13125a(m12620a.get(i2));
            if (m13125a == null) {
                return Collections.emptyMap();
            }
            if (m13125a.m12587o() == EnumC1621l.IPUT) {
                c1639e = m12640o.m12514a((C1592d) ((C1619j) m13125a).m12394f());
                if (c1639e == null || !c1639e.m12566g().m12183l()) {
                    return Collections.emptyMap();
                }
            } else if (m13125a.m12587o() == EnumC1621l.CONSTRUCTOR) {
                if (((C1610a) m13125a).m12368l()) {
                    c1639e = null;
                } else {
                    return Collections.emptyMap();
                }
            } else {
                return Collections.emptyMap();
            }
            linkedHashMap.put(c1610a.mo12426d(i2), c1639e);
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private static C1646l m13125a(C1604i c1604i) {
        C1646l l;
        C1605j m12331p = c1604i.m12331p();
        if (m12331p.m12349j() == 1 && (l = m12331p.m12348i().get(0).m12314l()) != null) {
            if (l.m12587o() == EnumC1621l.MOVE) {
                return m13125a(l.m12588p());
            }
            return l;
        }
        return null;
    }

    /* renamed from: c */
    private static C1610a m13138c(C1648n c1648n, C1610a c1610a) {
        C1648n m12553a = c1648n.mo12540t().m12553a(c1610a.m12363f());
        if (m12553a == null || !m12553a.m12615M().m12183l() || !m13133a(c1610a)) {
            return null;
        }
        C1636b m12557b = c1648n.mo12540t().m12557b(m12553a.m12640o().m12544x());
        if (m12557b == null) {
            return null;
        }
        C1648n m12525c = m12557b.m12525c("<init>(" + (c1610a.m12590r() >= 1 && c1610a.mo12426d(0).m12315m() ? C1554j.m12005a(c1610a.mo12426d(0).m12359s()) : "") + ")V");
        if (m12525c == null) {
            return null;
        }
        C1610a c1610a2 = new C1610a(m12525c.m12617O(), c1610a.m12366j(), c1610a.m12364h());
        c1610a2.m12581b(c1610a.m12588p());
        return c1610a2;
    }

    /* renamed from: a */
    private static C1646l m13127a(C1648n c1648n, C1614e c1614e) {
        AbstractC1596a s = c1614e.m12588p().m12359s();
        AbstractC1596a mo12288n = s.mo12288n();
        AbstractC1596a m12380h = c1614e.m12380h();
        if (!m12380h.mo12276b() && mo12288n.mo12278d() && m12380h.mo12274a(mo12288n.mo12277c())) {
            m12380h = mo12288n;
        }
        if (!m12380h.equals(mo12288n) && !s.equals(AbstractC1596a.f10134j)) {
            C1735d.m13258a(c1648n, "Incorrect type for fill-array insn " + C1739h.m13270a(c1614e.m12591s()) + ", element type: " + m12380h + ", insn element type: " + mo12288n);
        }
        if (!m12380h.mo12276b()) {
            f10557a.mo15937b("Unknown array element type: {} in mth: {}", m12380h, c1648n);
            m12380h = mo12288n.mo12276b() ? mo12288n : m12380h.mo12290p();
            if (m12380h == null) {
                throw new C1729f("Null array element type");
            }
        }
        c1614e.m12378a(c1648n.mo12540t(), m12380h);
        AbstractC1596a m12380h2 = c1614e.m12380h();
        List<C1600e> m12381i = c1614e.m12381i();
        C1615f c1615f = new C1615f(m12380h2, m12381i.size());
        c1615f.m12581b(c1614e.m12588p());
        for (C1600e c1600e : m12381i) {
            C1639e m12515a = c1648n.m12640o().m12515a(c1600e);
            if (m12515a != null) {
                c1615f.m12584c(AbstractC1598c.m12306c(new C1619j(EnumC1621l.SGET, m12515a.m12565f(), 0)));
            } else {
                c1615f.m12584c(c1600e);
            }
        }
        return c1615f;
    }

    /* renamed from: a */
    private static boolean m13133a(C1610a c1610a) {
        for (AbstractC1598c abstractC1598c : c1610a.m12589q()) {
            if (abstractC1598c.mo12311i() && ((C1600e) abstractC1598c).m12317d() == 0) {
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static C1646l m13126a(C1646l c1646l, C1740i c1740i, EnumC1621l enumC1621l) {
        if (c1646l == null) {
            return null;
        }
        c1740i.m13284a(c1646l);
        EnumC1621l m12587o = c1646l.m12587o();
        if (m12587o != enumC1621l) {
            if (m12587o == EnumC1621l.MOVE) {
                return m13126a(((C1604i) c1646l.mo12426d(0)).m12333r(), c1740i, enumC1621l);
            }
            return null;
        }
        return c1646l;
    }

    /* renamed from: a */
    private static void m13129a(C1628a c1628a, C1646l c1646l, C1740i c1740i) {
        C1665b c1665b = (C1665b) c1628a.mo12146b(C1566b.f10033g);
        if (c1665b != null) {
            C1666c m12749c = c1665b.m12749c();
            C1604i m12588p = c1646l.m12588p();
            AbstractC1596a m12211m = m12749c.m12757b() ? AbstractC1596a.f10138n : m12749c.m12750a().m12211m();
            String str = m12749c.m12757b() ? "th" : "e";
            if (m12588p.mo12320m_() == null) {
                m12588p.mo12319a_(str);
            }
            C1605j m12331p = c1646l.m12588p().m12331p();
            if (m12331p.m12349j() == 0) {
                m12749c.m12751a(new C1602g(str, m12211m));
                c1740i.m13284a(c1646l);
            } else if (m12331p.m12351l()) {
                C1646l c1646l2 = new C1646l(EnumC1621l.MOVE, 1);
                c1646l2.m12581b(c1646l.m12588p());
                C1602g c1602g = new C1602g(str, m12211m);
                c1646l2.m12584c(c1602g);
                m12749c.m12751a(c1602g);
                m13128a(c1628a, 0, c1646l2);
            }
        }
    }

    /* renamed from: a */
    private static void m13128a(C1628a c1628a, int i, C1646l c1646l) {
        C1646l c1646l2 = c1628a.mo12446j().get(i);
        c1646l.m12143a((AbstractC1584d) c1646l2);
        c1646l.m12118a(c1646l2.m12122d());
        c1628a.mo12446j().set(i, c1646l);
    }

    /* renamed from: b */
    private static void m13136b(C1648n c1648n) {
        for (C1604i c1604i : c1648n.m12620a(false)) {
            String mo12320m_ = c1604i.mo12320m_();
            if (mo12320m_ != null && C1559d.m12063a(mo12320m_)) {
                c1604i.m12331p().m12341b(String.valueOf(mo12320m_) + "_");
            }
        }
    }
}
