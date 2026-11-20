package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.EnumC1623n;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p188c.p189a.EnumC1603h;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p197g.p202d.C1702c;
import jadx.core.p203d.C1740i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ConstInlineVisitor.java */
/* renamed from: jadx.core.c.g.d */
/* loaded from: classes.dex */
public class C1699d extends C1669a {

    /* renamed from: a */
    private static /* synthetic */ int[] f10545a;

    /* renamed from: a */
    static /* synthetic */ int[] m13066a() {
        int[] iArr = f10545a;
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
            f10545a = iArr;
        }
        return iArr;
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            ArrayList arrayList = new ArrayList();
            for (C1628a c1628a : c1648n.m12647y()) {
                arrayList.clear();
                for (C1646l c1646l : c1628a.mo12446j()) {
                    if (m13064a(c1648n, c1646l)) {
                        arrayList.add(c1646l);
                    }
                }
                C1740i.m13277a(c1648n, c1628a, arrayList);
            }
        }
    }

    /* renamed from: a */
    private static boolean m13064a(C1648n c1648n, C1646l c1646l) {
        C1646l m12333r;
        if (c1646l.m12587o() != EnumC1621l.CONST || c1646l.mo12149b(EnumC1562a.DONT_INLINE)) {
            return false;
        }
        AbstractC1598c mo12426d = c1646l.mo12426d(0);
        if (!mo12426d.mo12311i()) {
            return false;
        }
        long m12317d = ((C1600e) mo12426d).m12317d();
        C1605j m12331p = c1646l.m12588p().m12331p();
        if (m12317d == 0 && m13063a(m12331p)) {
            if (m12331p.m12349j() == 1 && (m12333r = c1646l.m12588p().m12333r()) != null) {
                m12333r.mo12141a(EnumC1562a.DONT_INLINE);
            }
            return false;
        }
        AbstractC1596a s = c1646l.m12588p().m12359s();
        if (!mo12426d.m12359s().mo12276b()) {
            mo12426d.m12357a(c1648n.mo12540t(), s);
        }
        return m13065a(c1648n, c1646l, m12317d);
    }

    /* renamed from: a */
    private static boolean m13063a(C1605j c1605j) {
        for (C1604i c1604i : c1605j.m12348i()) {
            C1646l l = c1604i.m12314l();
            if (l != null) {
                EnumC1621l m12587o = l.m12587o();
                if (m12587o == EnumC1621l.INVOKE) {
                    C1622m c1622m = (C1622m) l;
                    if (c1622m.m12416f() != EnumC1623n.STATIC && c1622m.mo12426d(0) == c1604i) {
                        return true;
                    }
                } else if (m12587o == EnumC1621l.ARRAY_LENGTH && l.mo12426d(0) == c1604i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m13065a(C1648n c1648n, C1646l c1646l, long j) {
        C1600e m12300a;
        ArrayList<AbstractC1598c> arrayList = new ArrayList(c1646l.m12588p().m12331p().m12348i());
        int i = 0;
        for (AbstractC1598c abstractC1598c : arrayList) {
            C1646l l = abstractC1598c.m12314l();
            if (l != null && l.m12587o() != EnumC1621l.PHI && l.m12587o() != EnumC1621l.MERGE) {
                AbstractC1596a s = abstractC1598c.m12359s();
                if (s.mo12280f() && j != 0) {
                    s = AbstractC1596a.f10142r;
                }
                if (arrayList.size() == 1 || abstractC1598c.mo12356n_()) {
                    m12300a = AbstractC1598c.m12300a(j, s);
                } else if (l.m12587o() == EnumC1621l.MOVE && !l.m12588p().m12359s().mo12276b()) {
                    m12300a = AbstractC1598c.m12300a(j, s);
                } else {
                    m12300a = AbstractC1598c.m12300a(j, AbstractC1596a.f10139o);
                }
                if (l.mo12424a(abstractC1598c, m12300a)) {
                    m13062a(c1648n, l, m12300a);
                    int i2 = i + 1;
                    if (l.m12587o() == EnumC1621l.RETURN) {
                        l.m12118a(c1646l.m12122d());
                    }
                    C1639e c1639e = null;
                    AbstractC1596a s2 = m12300a.m12359s();
                    if (s2.mo12276b()) {
                        c1639e = c1648n.m12640o().m12515a(m12300a);
                    } else if (s2.mo12274a(EnumC1603h.INT)) {
                        c1639e = c1648n.m12640o().m12517a((Object) Integer.valueOf((int) j), false);
                    }
                    if (c1639e != null) {
                        m12300a.m12310b(new C1619j(EnumC1621l.SGET, c1639e.m12565f(), 0));
                    }
                    i = i2;
                }
            }
        }
        return i == arrayList.size();
    }

    /* renamed from: a */
    private static void m13062a(C1648n c1648n, C1646l c1646l, C1600e c1600e) {
        AbstractC1596a m12211m;
        int i = 0;
        C1637c mo12540t = c1648n.mo12540t();
        C1702c.m13071a(c1648n, c1646l);
        switch (m13066a()[c1646l.m12587o().ordinal()]) {
            case 1:
                c1646l.mo12426d(0).m12358a(mo12540t, c1646l.m12588p());
                break;
            case 4:
                c1600e.m12358a(mo12540t, c1646l.m12588p());
                break;
            case 7:
                c1646l.m12588p().m12358a(mo12540t, c1646l.mo12426d(0));
                c1646l.mo12426d(0).m12358a(mo12540t, c1646l.m12588p());
                break;
            case 9:
                if (c1646l.m12590r() != 0) {
                    c1646l.mo12426d(0).m12357a(mo12540t, c1648n.m12636k());
                    break;
                }
                break;
            case 13:
            case 14:
                AbstractC1598c mo12426d = c1646l.mo12426d(0);
                AbstractC1598c mo12426d2 = c1646l.mo12426d(1);
                if (mo12426d == c1600e) {
                    mo12426d.m12358a(mo12540t, mo12426d2);
                    break;
                } else {
                    mo12426d2.m12358a(mo12540t, mo12426d);
                    break;
                }
            case 15:
                AbstractC1598c mo12426d3 = c1646l.mo12426d(0);
                AbstractC1598c mo12426d4 = c1646l.mo12426d(1);
                if (mo12426d3 == c1600e) {
                    mo12426d3.m12358a(mo12540t, mo12426d4);
                    break;
                } else {
                    mo12426d4.m12358a(mo12540t, mo12426d3);
                    break;
                }
            case 24:
            case 25:
                if (c1600e == c1646l.mo12426d(1)) {
                    c1600e.m12357a(mo12540t, AbstractC1596a.f10125a);
                    break;
                }
                break;
            case 26:
                if (c1600e == c1646l.mo12426d(0)) {
                    c1600e.m12357a(mo12540t, AbstractC1596a.f10125a);
                    break;
                }
                break;
            case 29:
            case 31:
                c1646l.mo12426d(0).m12357a(mo12540t, ((C1592d) ((C1619j) c1646l).m12394f()).m12227b());
                break;
            case 32:
                List<AbstractC1596a> m12247f = ((C1622m) c1646l).m12417h().m12247f();
                int m12590r = c1646l.m12590r();
                int i2 = m12247f.size() == m12590r ? 0 : -1;
                while (i < m12590r) {
                    AbstractC1598c mo12426d5 = c1646l.mo12426d(i);
                    if (!mo12426d5.m12359s().mo12276b()) {
                        if (i2 >= 0) {
                            m12211m = m12247f.get(i2);
                        } else {
                            m12211m = c1648n.m12640o().m12544x().m12211m();
                        }
                        mo12426d5.m12357a(mo12540t, m12211m);
                    }
                    i++;
                    i2++;
                }
                break;
        }
    }
}
