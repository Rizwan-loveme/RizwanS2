package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1595a;
import jadx.core.p183c.p188c.C1613d;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.EnumC1609b;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1597b;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p188c.p190b.C1611b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p193e.p194a.C1653b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: SimplifyVisitor.java */
/* renamed from: jadx.core.c.g.r */
/* loaded from: classes.dex */
public class C1718r extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10565a = C2568c.m15995a((Class<?>) C1718r.class);

    /* renamed from: b */
    private static /* synthetic */ int[] f10566b;

    /* renamed from: a */
    static /* synthetic */ int[] m13162a() {
        int[] iArr = f10566b;
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
            f10566b = iArr;
        }
        return iArr;
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            Iterator<C1628a> it = c1648n.m12647y().iterator();
            while (it.hasNext()) {
                List<C1646l> mo12446j = it.next().mo12446j();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < mo12446j.size()) {
                        C1646l m13159a = m13159a(c1648n, mo12446j.get(i2));
                        if (m13159a != null) {
                            mo12446j.set(i2, m13159a);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private static C1646l m13159a(C1648n c1648n, C1646l c1646l) {
        C1646l m13159a;
        for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
            if (abstractC1598c.mo12312j() && (m13159a = m13159a(c1648n, ((C1599d) abstractC1598c).m12316d())) != null) {
                abstractC1598c.m12310b(m13159a);
            }
        }
        switch (m13162a()[c1646l.m12587o().ordinal()]) {
            case 4:
                return m13158a(c1646l);
            case 7:
                AbstractC1598c mo12426d = c1646l.mo12426d(0);
                if (mo12426d.mo12311i()) {
                    C1646l c1646l2 = new C1646l(EnumC1621l.CONST, 1);
                    c1646l2.m12581b(c1646l.m12588p());
                    c1646l2.m12584c(mo12426d);
                    c1646l2.m12143a((AbstractC1584d) c1646l);
                    return c1646l2;
                }
                return null;
            case 15:
                m13161a((C1617h) c1646l);
                return null;
            case 19:
                return m13163b(c1648n, c1646l);
            case 29:
            case 31:
                return m13166d(c1648n, c1646l);
            case 32:
                return m13165c(c1648n, c1646l);
            case 34:
                m13160a((C1611b) c1646l);
                return null;
            default:
                return null;
        }
    }

    /* renamed from: b */
    private static C1646l m13163b(C1648n c1648n, C1646l c1646l) {
        AbstractC1598c mo12426d = c1646l.mo12426d(0);
        AbstractC1596a s = mo12426d.m12359s();
        if (mo12426d.mo12312j()) {
            C1646l m12316d = ((C1599d) mo12426d).m12316d();
            if (m12316d.m12587o() == EnumC1621l.INVOKE) {
                s = ((C1622m) m12316d).m12417h().m12246e();
            }
        }
        if (AbstractC1596a.m12268b(c1648n.mo12540t(), s, (AbstractC1596a) ((C1619j) c1646l).m12394f())) {
            return null;
        }
        C1646l c1646l2 = new C1646l(EnumC1621l.MOVE, 1);
        c1646l2.m12586e(c1646l.m12591s());
        c1646l2.m12581b(c1646l.m12588p());
        c1646l2.m12584c(mo12426d);
        return c1646l2;
    }

    /* renamed from: a */
    private static void m13161a(C1617h c1617h) {
        AbstractC1598c d2 = c1617h.mo12426d(0);
        if (d2.mo12312j()) {
            C1646l m12316d = ((C1599d) d2).m12316d();
            if (m12316d.m12587o() == EnumC1621l.CMP_L || m12316d.m12587o() == EnumC1621l.CMP_G) {
                if (c1617h.mo12426d(1).mo12311i() && ((C1600e) c1617h.mo12426d(1)).m12317d() == 0) {
                    c1617h.m12384a(c1617h.m12387h(), m12316d.mo12426d(0), m12316d.mo12426d(1));
                } else {
                    f10565a.mo15942c("TODO: cmp {}", c1617h);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m13160a(C1611b c1611b) {
        C1653b m12373f = c1611b.m12373f();
        if (m12373f.m12691f()) {
            m13161a(m12373f.m12692g().m12673d());
        } else {
            c1611b.m12374h();
        }
    }

    /* renamed from: c */
    private static C1646l m13165c(C1648n c1648n, C1646l c1646l) {
        int i;
        int i2;
        C1599d c1599d;
        C1594f m12417h = ((C1622m) c1646l).m12417h();
        if (m12417h.m12245d().m12202d().equals("java.lang.StringBuilder") && m12417h.m12244c().equals("toString()Ljava/lang/String;") && c1646l.mo12426d(0).mo12312j()) {
            try {
                List<C1646l> m13164b = m13164b(c1646l);
                if (m13164b.size() <= 1 || m13164b.get(0).m12587o() != EnumC1621l.CONSTRUCTOR) {
                    i = (m13164b.size() <= 2 || m13164b.get(1).m12587o() != EnumC1621l.CONSTRUCTOR) ? (m13164b.size() <= 3 || m13164b.get(2).m12587o() != EnumC1621l.CONSTRUCTOR) ? -1 : 2 : 1;
                } else {
                    i = 0;
                }
                if (i != -1 && ((C1610a) m13164b.get(i)).m12365i().m12202d().equals("java.lang.StringBuilder")) {
                    int size = m13164b.size();
                    C1646l c1646l2 = new C1646l(EnumC1621l.STR_CONCAT, size - 1);
                    if (i > 0) {
                        if (i == 2) {
                            C1646l c1646l3 = m13164b.get(1);
                            if (c1646l3.m12587o() == EnumC1621l.INVOKE && ((C1622m) c1646l3).m12417h().m12239a().compareTo("valueOf") == 0) {
                                c1599d = (C1599d) c1646l3.mo12426d(0);
                                i2 = 3;
                                c1646l2.m12584c(c1599d);
                            }
                        }
                        C1646l c1646l4 = m13164b.get(0);
                        if (c1646l4 instanceof C1613d) {
                            c1599d = new C1599d((C1613d) c1646l4);
                            i2 = 2;
                            c1646l2.m12584c(c1599d);
                        } else {
                            return null;
                        }
                    } else {
                        i2 = 1;
                    }
                    while (i2 < size) {
                        c1646l2.m12584c(m13164b.get(i2).mo12426d(1));
                        i2++;
                    }
                    c1646l2.m12581b(c1646l.m12588p());
                    return c1646l2;
                }
            } catch (Exception e2) {
                f10565a.mo15939b("Can't convert string concatenation: {} insn: {}", c1648n, c1646l, e2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C1646l m13158a(C1646l c1646l) {
        AbstractC1598c abstractC1598c;
        C1595a c1595a = (C1595a) c1646l;
        if (c1595a.m12590r() != 2) {
            return null;
        }
        AbstractC1598c d2 = c1595a.mo12426d(1);
        if (d2.mo12312j()) {
            C1646l m12316d = ((C1599d) d2).m12316d();
            if (m12316d.m12587o() == EnumC1621l.CONST) {
                abstractC1598c = m12316d.mo12426d(0);
            }
            abstractC1598c = null;
        } else {
            if (d2.mo12311i()) {
                abstractC1598c = d2;
            }
            abstractC1598c = null;
        }
        if (abstractC1598c != null) {
            long m12317d = ((C1600e) abstractC1598c).m12317d();
            if (c1595a.m12255f() == EnumC1609b.ADD && m12317d < 0) {
                return new C1595a(EnumC1609b.SUB, c1595a.m12588p(), c1646l.mo12426d(0), AbstractC1598c.m12300a(-m12317d, abstractC1598c.m12359s()));
            }
        }
        return null;
    }

    /* renamed from: d */
    private static C1646l m13166d(C1648n c1648n, C1646l c1646l) {
        AbstractC1598c abstractC1598c;
        AbstractC1598c mo12426d = c1646l.mo12426d(0);
        if (!mo12426d.mo12312j()) {
            return null;
        }
        C1646l m12316d = ((C1599d) mo12426d).m12316d();
        EnumC1621l m12587o = m12316d.m12587o();
        if ((m12587o != EnumC1621l.ARITH && m12587o != EnumC1621l.STR_CONCAT) || !m12316d.mo12426d(0).mo12312j()) {
            return null;
        }
        C1646l m12316d2 = ((C1599d) m12316d.mo12426d(0)).m12316d();
        EnumC1621l m12587o2 = m12316d2.m12587o();
        if (m12587o2 != EnumC1621l.IGET && m12587o2 != EnumC1621l.SGET) {
            return null;
        }
        C1592d c1592d = (C1592d) ((C1619j) c1646l).m12394f();
        if (!c1592d.equals((C1592d) ((C1619j) m12316d2).m12394f())) {
            return null;
        }
        try {
            if (m12587o2 == EnumC1621l.IGET) {
                abstractC1598c = m12316d2.mo12426d(0);
                if (!abstractC1598c.equals(c1646l.mo12426d(1))) {
                    return null;
                }
            } else {
                abstractC1598c = null;
            }
            C1597b c1597b = new C1597b(c1592d, abstractC1598c);
            if (abstractC1598c != null) {
                c1597b.mo12293a(m12316d2.mo12426d(0).m12359s());
            }
            if (m12587o == EnumC1621l.ARITH) {
                C1595a c1595a = (C1595a) m12316d;
                return new C1595a(c1595a.m12255f(), c1597b, c1595a.mo12426d(1));
            }
            int m12590r = m12316d.m12590r();
            C1646l c1646l2 = new C1646l(EnumC1621l.STR_CONCAT, m12590r - 1);
            for (int i = 1; i < m12590r; i++) {
                c1646l2.m12584c(m12316d.mo12426d(i));
            }
            return new C1595a(EnumC1609b.ADD, c1597b, AbstractC1598c.m12306c(c1646l2));
        } catch (Exception e2) {
            f10565a.mo15934a("Can't convert field arith insn: {}, mth: {}", c1646l, c1648n, e2);
            return null;
        }
    }

    /* renamed from: b */
    private static List<C1646l> m13164b(C1646l c1646l) {
        ArrayList arrayList = new ArrayList();
        AbstractC1598c mo12426d = c1646l.mo12426d(0);
        while (mo12426d.mo12312j()) {
            C1646l m12316d = ((C1599d) mo12426d).m12316d();
            arrayList.add(m12316d);
            if (m12316d.m12590r() == 0) {
                break;
            }
            mo12426d = m12316d.mo12426d(0);
        }
        Collections.reverse(arrayList);
        return arrayList;
    }
}
