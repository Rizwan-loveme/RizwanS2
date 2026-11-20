package jadx.core.p203d;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.C1612c;
import jadx.core.p183c.p188c.C1613d;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.p192a.C1632d;
import jadx.core.p203d.p205b.C1729f;
import org.p226d.p233b.p250e.p252b.InterfaceC2215c;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2223k;
import org.p226d.p233b.p250e.p252b.InterfaceC2229q;
import org.p226d.p233b.p250e.p252b.InterfaceC2230r;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: InsnUtils.java */
/* renamed from: jadx.core.d.h */
/* loaded from: classes.dex */
public class C1739h {

    /* renamed from: a */
    private static final InterfaceC2558b f10600a = C2568c.m15995a((Class<?>) C1739h.class);

    /* renamed from: b */
    private static /* synthetic */ int[] f10601b;

    /* renamed from: a */
    static /* synthetic */ int[] m13273a() {
        int[] iArr = f10601b;
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
            f10601b = iArr;
        }
        return iArr;
    }

    private C1739h() {
    }

    /* renamed from: a */
    public static int m13268a(InterfaceC2218f interfaceC2218f, int i) {
        switch (i) {
            case 0:
                if (interfaceC2218f instanceof InterfaceC2223k) {
                    return ((InterfaceC2223k) interfaceC2218f).mo14495q_();
                }
                return ((InterfaceC2215c) interfaceC2218f).mo14483h();
            case 1:
                if (interfaceC2218f instanceof InterfaceC2230r) {
                    return ((InterfaceC2230r) interfaceC2218f).mo14500r_();
                }
                return ((InterfaceC2215c) interfaceC2218f).mo14484i();
            case 2:
                if (interfaceC2218f instanceof InterfaceC2229q) {
                    return ((InterfaceC2229q) interfaceC2218f).mo14504g();
                }
                return ((InterfaceC2215c) interfaceC2218f).mo14485j();
            case 3:
                return ((InterfaceC2215c) interfaceC2218f).mo14486k();
            case 4:
                return ((InterfaceC2215c) interfaceC2218f).mo14487l();
            default:
                throw new C1729f("Wrong argument number: " + i);
        }
    }

    /* renamed from: a */
    public static String m13270a(int i) {
        return i < 0 ? "?" : String.format("0x%04x", Integer.valueOf(i));
    }

    /* renamed from: a */
    public static String m13271a(EnumC1621l enumC1621l) {
        return enumC1621l + "  ";
    }

    /* renamed from: a */
    public static String m13272a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return "\"" + obj + "\"";
        }
        return obj.toString();
    }

    /* renamed from: a */
    public static Object m13269a(C1637c c1637c, C1646l c1646l) {
        switch (m13273a()[c1646l.m12587o().ordinal()]) {
            case 1:
                return c1646l.mo12426d(0);
            case 2:
                return ((C1613d) c1646l).m12377f();
            case 3:
                return ((C1612c) c1646l).m12375f();
            case 30:
                C1592d c1592d = (C1592d) ((C1619j) c1646l).m12394f();
                C1639e m12652a = c1637c.mo12541u().m12652a(c1592d);
                if (m12652a == null) {
                    f10600a.mo15937b("Field {} not found in dex {}", c1592d, c1637c);
                    return null;
                }
                C1632d c1632d = (C1632d) m12652a.mo12146b(C1566b.f10037k);
                return c1632d != null ? c1632d.m12470a() : null;
            default:
                return null;
        }
    }
}
