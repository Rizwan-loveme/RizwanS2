package jadx.core.p183c.p188c.p189a;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1739h;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2234v;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: InsnArg.java */
/* renamed from: jadx.core.c.c.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC1598c extends AbstractC1607l {

    /* renamed from: b */
    private static final InterfaceC2558b f10157b = C2568c.m15995a((Class<?>) AbstractC1598c.class);

    /* renamed from: c */
    private static /* synthetic */ int[] f10158c;

    /* renamed from: a */
    protected C1646l f10159a;

    /* renamed from: n */
    static /* synthetic */ int[] m12308n() {
        int[] iArr = f10158c;
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
            f10158c = iArr;
        }
        return iArr;
    }

    /* renamed from: a */
    public static C1604i m12302a(int i, AbstractC1596a abstractC1596a) {
        return new C1604i(i, abstractC1596a);
    }

    /* renamed from: a */
    public static C1604i m12304a(InterfaceC2218f interfaceC2218f, int i, AbstractC1596a abstractC1596a) {
        return m12302a(C1739h.m13268a(interfaceC2218f, i), abstractC1596a);
    }

    /* renamed from: b */
    public static C1606k m12305b(int i, AbstractC1596a abstractC1596a) {
        return new C1606k(i, abstractC1596a);
    }

    /* renamed from: a */
    public static C1604i m12303a(int i, AbstractC1596a abstractC1596a, boolean z) {
        return z ? new C1606k(i, abstractC1596a) : new C1604i(i, abstractC1596a);
    }

    /* renamed from: a */
    public static C1600e m12300a(long j, AbstractC1596a abstractC1596a) {
        return new C1600e(j, abstractC1596a);
    }

    /* renamed from: a */
    public static C1600e m12301a(InterfaceC2218f interfaceC2218f, AbstractC1596a abstractC1596a) {
        return m12300a(((InterfaceC2234v) interfaceC2218f).mo14494g(), abstractC1596a);
    }

    /* renamed from: d */
    private static C1599d m12307d(C1646l c1646l) {
        return new C1599d(c1646l);
    }

    /* renamed from: h */
    public boolean mo12298h() {
        return false;
    }

    /* renamed from: i */
    public boolean mo12311i() {
        return false;
    }

    /* renamed from: j */
    public boolean mo12312j() {
        return false;
    }

    /* renamed from: k */
    public boolean mo12313k() {
        return false;
    }

    /* renamed from: g */
    public boolean mo12297g() {
        return false;
    }

    /* renamed from: l */
    public C1646l m12314l() {
        return this.f10159a;
    }

    /* renamed from: a */
    public void mo12309a(C1646l c1646l) {
        this.f10159a = c1646l;
    }

    /* renamed from: b */
    public AbstractC1598c m12310b(C1646l c1646l) {
        C1646l c1646l2 = this.f10159a;
        if (c1646l2 == null) {
            return null;
        }
        if (c1646l2 == c1646l) {
            f10157b.mo15931a("Can't wrap instruction info itself: {}", c1646l);
            return null;
        }
        int m12299a = m12299a(c1646l2, this);
        if (m12299a == -1) {
            return null;
        }
        c1646l.mo12141a(EnumC1562a.WRAPPED);
        AbstractC1598c m12306c = m12306c(c1646l);
        c1646l2.mo12421a(m12299a, m12306c);
        return m12306c;
    }

    /* renamed from: a */
    private static int m12299a(C1646l c1646l, AbstractC1598c abstractC1598c) {
        int m12590r = c1646l.m12590r();
        for (int i = 0; i < m12590r; i++) {
            if (c1646l.mo12426d(i) == abstractC1598c) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static AbstractC1598c m12306c(C1646l c1646l) {
        switch (m12308n()[c1646l.m12587o().ordinal()]) {
            case 1:
            case 7:
                return c1646l.mo12426d(0);
            case 2:
                C1599d m12307d = m12307d(c1646l);
                m12307d.mo12293a(AbstractC1596a.f10136l);
                return m12307d;
            case 3:
                C1599d m12307d2 = m12307d(c1646l);
                m12307d2.mo12293a(AbstractC1596a.f10135k);
                return m12307d2;
            case 4:
            case 5:
            case 6:
            default:
                return m12307d(c1646l);
        }
    }

    /* renamed from: m */
    public boolean m12315m() {
        return mo12149b(EnumC1562a.THIS);
    }
}
