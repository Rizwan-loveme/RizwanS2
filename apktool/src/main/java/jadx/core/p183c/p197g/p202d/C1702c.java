package jadx.core.p183c.p197g.p202d;

import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import java.util.Iterator;
import java.util.List;

/* compiled from: PostTypeInference.java */
/* renamed from: jadx.core.c.g.d.c */
/* loaded from: classes.dex */
public class C1702c {

    /* renamed from: a */
    private static /* synthetic */ int[] f10546a;

    /* renamed from: a */
    static /* synthetic */ int[] m13072a() {
        int[] iArr = f10546a;
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
            f10546a = iArr;
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static boolean m13071a(C1648n c1648n, C1646l c1646l) {
        int i;
        boolean z;
        int i2 = 0;
        C1637c mo12540t = c1648n.mo12540t();
        switch (m13072a()[c1646l.m12587o().ordinal()]) {
            case 1:
                C1604i m12588p = c1646l.m12588p();
                C1600e c1600e = (C1600e) c1646l.mo12426d(0);
                if (m12588p.m12359s().mo12280f()) {
                    long m12317d = c1600e.m12317d();
                    if (m12317d != 0) {
                        AbstractC1596a abstractC1596a = m12317d == 1 ? AbstractC1596a.f10126b : AbstractC1596a.f10125a;
                        c1600e.mo12293a(abstractC1596a);
                        m12588p.m12331p().m12335a(abstractC1596a);
                        return true;
                    }
                }
                return c1600e.m12358a(mo12540t, m12588p);
            case 7:
                z = c1646l.m12588p().m12358a(mo12540t, c1646l.mo12426d(0));
                if (c1646l.mo12426d(0).m12358a(mo12540t, c1646l.m12588p())) {
                    return true;
                }
                break;
            case 15:
                z = c1646l.mo12426d(1).m12358a(mo12540t, c1646l.mo12426d(0));
                if (c1646l.mo12426d(0).m12358a(mo12540t, c1646l.mo12426d(1))) {
                    return true;
                }
                break;
            case 19:
                AbstractC1596a abstractC1596a2 = (AbstractC1596a) ((C1619j) c1646l).m12394f();
                C1604i m12588p2 = c1646l.m12588p();
                AbstractC1596a s = m12588p2.m12359s();
                if (abstractC1596a2.mo12280f() && s.mo12280f() && abstractC1596a2.mo12279e().equals(s.mo12279e())) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return true;
                }
                m12588p2.m12331p().m12335a(abstractC1596a2);
                return true;
            case 24:
                return m13070a(mo12540t, c1646l.mo12426d(0), c1646l.m12588p());
            case 25:
                return m13070a(mo12540t, c1646l.mo12426d(0), c1646l.mo12426d(2));
            case 32:
                C1622m c1622m = (C1622m) c1646l;
                C1594f m12417h = c1622m.m12417h();
                C1648n m12553a = c1648n.mo12540t().m12553a(m12417h);
                if (m12553a != null && m12553a.m12609G()) {
                    List<AbstractC1596a> m12247f = m12417h.m12247f();
                    int r = c1622m.m12590r() - 1;
                    int size = m12247f.size() - 1;
                    while (size >= 0) {
                        AbstractC1596a abstractC1596a3 = m12247f.get(size);
                        int i3 = r - 1;
                        AbstractC1598c d2 = c1622m.mo12426d(r);
                        if (!d2.mo12298h() || abstractC1596a3.equals(d2.m12359s())) {
                            i = i2;
                        } else {
                            d2.mo12293a(abstractC1596a3);
                            i = 1;
                        }
                        size--;
                        r = i3;
                        i2 = i;
                    }
                }
                return i2;
            case 40:
            case 41:
                AbstractC1596a s2 = c1646l.m12588p().m12359s();
                if (!s2.mo12276b()) {
                    Iterator<AbstractC1598c> it = c1646l.m12589q().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            AbstractC1598c next = it.next();
                            if (next.m12359s().mo12276b()) {
                                s2 = next.m12359s();
                            }
                        }
                    }
                }
                boolean z2 = m13069a(c1646l.m12588p(), s2);
                while (true) {
                    boolean z3 = z2;
                    if (i2 >= c1646l.m12590r()) {
                        return z3;
                    }
                    z2 = m13069a((C1604i) c1646l.mo12426d(i2), s2) ? true : z3;
                    i2++;
                }
            default:
                return false;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m13069a(C1604i c1604i, AbstractC1596a abstractC1596a) {
        AbstractC1596a s = c1604i.m12359s();
        if (s != null && s.equals(abstractC1596a)) {
            return false;
        }
        c1604i.mo12293a(abstractC1596a);
        return true;
    }

    /* renamed from: a */
    private static boolean m13070a(C1637c c1637c, AbstractC1598c abstractC1598c, AbstractC1598c abstractC1598c2) {
        boolean z = false;
        if (!abstractC1598c2.m12359s().mo12276b() && abstractC1598c2.m12357a(c1637c, abstractC1598c.m12359s().mo12288n())) {
            z = true;
        }
        if (abstractC1598c.m12359s().mo12276b() || !abstractC1598c.m12357a(c1637c, AbstractC1596a.m12258a(abstractC1598c2.m12359s()))) {
            return z;
        }
        return true;
    }
}
