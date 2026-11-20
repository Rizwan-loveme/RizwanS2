package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import java.util.Iterator;
import java.util.List;

/* compiled from: PrepareForCodeGen.java */
/* renamed from: jadx.core.c.g.o */
/* loaded from: classes.dex */
public class C1715o extends C1669a {

    /* renamed from: a */
    private static /* synthetic */ int[] f10559a;

    /* renamed from: a */
    static /* synthetic */ int[] m13140a() {
        int[] iArr = f10559a;
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
            f10559a = iArr;
        }
        return iArr;
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        List<C1628a> m12647y = c1648n.m12647y();
        if (m12647y != null) {
            for (C1628a c1628a : m12647y) {
                m13139a(c1628a);
                m13141b(c1628a);
                m13142c(c1628a);
            }
        }
    }

    /* renamed from: a */
    private static void m13139a(C1628a c1628a) {
        Iterator<C1646l> it = c1628a.mo12446j().iterator();
        while (it.hasNext()) {
            C1646l next = it.next();
            switch (m13140a()[next.m12587o().ordinal()]) {
                case 7:
                    C1604i m12588p = next.m12588p();
                    if (m12588p.m12331p().m12349j() == 0 && m12588p.m12327a(next.mo12426d(0))) {
                        it.remove();
                        break;
                    }
                    break;
                case 12:
                case 17:
                case 18:
                case 33:
                    it.remove();
                    break;
                case 35:
                    if (!((C1610a) next).m12370n()) {
                        break;
                    } else {
                        it.remove();
                        break;
                    }
            }
        }
    }

    /* renamed from: b */
    private static void m13141b(C1628a c1628a) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        for (int i = 0; i < mo12446j.size(); i++) {
            C1646l c1646l = mo12446j.get(i);
            if (c1646l.m12587o() == EnumC1621l.MOVE && c1646l.mo12426d(0).mo12312j()) {
                C1646l m12316d = ((C1599d) c1646l.mo12426d(0)).m12316d();
                m12316d.m12581b(c1646l.m12588p());
                m12316d.m12143a((AbstractC1584d) c1646l);
                mo12446j.set(i, m12316d);
            }
        }
    }

    /* renamed from: c */
    private static void m13142c(C1628a c1628a) {
        boolean m12328a;
        for (C1646l c1646l : c1628a.mo12446j()) {
            if (c1646l.m12587o() == EnumC1621l.ARITH) {
                C1604i m12588p = c1646l.m12588p();
                AbstractC1598c mo12426d = c1646l.mo12426d(0);
                if (m12588p.equals(mo12426d)) {
                    m12328a = true;
                } else {
                    m12328a = mo12426d.mo12298h() ? m12588p.m12328a((C1604i) mo12426d) : false;
                }
                if (m12328a) {
                    c1646l.mo12141a(EnumC1562a.ARITH_ONEARG);
                    c1646l.m12588p().m12329b(mo12426d);
                }
            }
        }
    }
}
