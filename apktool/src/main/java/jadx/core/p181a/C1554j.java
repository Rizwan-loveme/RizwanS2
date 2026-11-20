package jadx.core.p181a;

import android.icu.text.DateFormat;
import jadx.core.p182b.C1559d;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.EnumC1603h;
import jadx.core.p183c.p191d.InterfaceC1643i;
import jadx.core.p203d.C1744m;
import jadx.core.p203d.C1745n;
import jadx.core.p203d.p205b.C1729f;
import jadx.p180a.C1534b;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: TypeGen.java */
/* renamed from: jadx.core.a.j */
/* loaded from: classes.dex */
public class C1554j {

    /* renamed from: a */
    private static final InterfaceC2558b f9950a = C2568c.m15995a((Class<?>) C1554j.class);

    /* renamed from: b */
    private static /* synthetic */ int[] f9951b;

    /* renamed from: a */
    static /* synthetic */ int[] m12007a() {
        int[] iArr = f9951b;
        if (iArr == null) {
            iArr = new int[EnumC1603h.valuesCustom().length];
            try {
                iArr[EnumC1603h.ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1603h.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC1603h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC1603h.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC1603h.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumC1603h.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EnumC1603h.INT.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EnumC1603h.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EnumC1603h.OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EnumC1603h.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EnumC1603h.VOID.ordinal()] = 11;
            } catch (NoSuchFieldError e12) {
            }
            f9951b = iArr;
        }
        return iArr;
    }

    private C1554j() {
    }

    /* renamed from: a */
    public static String m12005a(AbstractC1596a abstractC1596a) {
        EnumC1603h mo12277c = abstractC1596a.mo12277c();
        if (mo12277c == EnumC1603h.OBJECT) {
            return C1745n.m13317b(abstractC1596a.mo12279e());
        }
        if (mo12277c == EnumC1603h.ARRAY) {
            return String.valueOf('[') + m12005a(abstractC1596a.mo12288n());
        }
        return mo12277c.m12322a();
    }

    /* renamed from: a */
    public static String m12003a(long j, AbstractC1596a abstractC1596a, InterfaceC1643i interfaceC1643i) {
        return m12004a(j, abstractC1596a, interfaceC1643i.mo12541u().m12665g());
    }

    @Deprecated
    /* renamed from: a */
    public static String m12002a(long j, AbstractC1596a abstractC1596a) {
        return m12004a(j, abstractC1596a, new C1744m(new C1534b()));
    }

    /* renamed from: a */
    private static String m12004a(long j, AbstractC1596a abstractC1596a, C1744m c1744m) {
        if (abstractC1596a == null || !abstractC1596a.mo12276b()) {
            String l = Long.toString(j);
            if (Math.abs(j) > 100) {
                return String.valueOf(l) + "; // 0x" + Long.toHexString(j) + " float:" + Float.intBitsToFloat((int) j) + " double:" + Double.longBitsToDouble(j);
            }
            return l;
        }
        switch (m12007a()[abstractC1596a.mo12277c().ordinal()]) {
            case 1:
                return j == 0 ? "false" : "true";
            case 2:
                char c2 = (char) j;
                if (!C1559d.m12062a(c2)) {
                    return Integer.toString(c2);
                }
                return c1744m.m13307a(c2);
            case 3:
                return m11997a((byte) j);
            case 4:
                return m12006a((short) j);
            case 5:
                return m12000a((int) j);
            case 6:
                return m11999a(Float.intBitsToFloat((int) j));
            case 7:
                return m12001a(j);
            case 8:
                return m11998a(Double.longBitsToDouble(j));
            case 9:
            case 10:
                if (j != 0) {
                    f9950a.mo15937b("Wrong object literal: {} for type: {}", Long.valueOf(j), abstractC1596a);
                    return Long.toString(j);
                }
                return "null";
            default:
                throw new C1729f("Unknown type in literalToString: " + abstractC1596a);
        }
    }

    /* renamed from: a */
    public static String m12006a(short s) {
        if (s == Short.MAX_VALUE) {
            return "Short.MAX_VALUE";
        }
        if (s == Short.MIN_VALUE) {
            return "Short.MIN_VALUE";
        }
        return "(short) " + Short.toString(s);
    }

    /* renamed from: a */
    public static String m11997a(byte b2) {
        if (b2 == Byte.MAX_VALUE) {
            return "Byte.MAX_VALUE";
        }
        if (b2 == Byte.MIN_VALUE) {
            return "Byte.MIN_VALUE";
        }
        return "(byte) " + Byte.toString(b2);
    }

    /* renamed from: a */
    public static String m12000a(int i) {
        if (i == Integer.MAX_VALUE) {
            return "Integer.MAX_VALUE";
        }
        if (i == Integer.MIN_VALUE) {
            return "Integer.MIN_VALUE";
        }
        return Integer.toString(i);
    }

    /* renamed from: a */
    public static String m12001a(long j) {
        if (j == Long.MAX_VALUE) {
            return "Long.MAX_VALUE";
        }
        if (j == Long.MIN_VALUE) {
            return "Long.MIN_VALUE";
        }
        String l = Long.toString(j);
        if (Math.abs(j) >= 2147483647L) {
            return String.valueOf(l) + "L";
        }
        return l;
    }

    /* renamed from: a */
    public static String m11998a(double d2) {
        if (Double.isNaN(d2)) {
            return "Double.NaN";
        }
        if (d2 == Double.NEGATIVE_INFINITY) {
            return "Double.NEGATIVE_INFINITY";
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return "Double.POSITIVE_INFINITY";
        }
        if (d2 == Double.MIN_VALUE) {
            return "Double.MIN_VALUE";
        }
        if (d2 == Double.MAX_VALUE) {
            return "Double.MAX_VALUE";
        }
        if (d2 == Double.MIN_NORMAL) {
            return "Double.MIN_NORMAL";
        }
        return String.valueOf(Double.toString(d2)) + DateFormat.DAY;
    }

    /* renamed from: a */
    public static String m11999a(float f2) {
        if (Float.isNaN(f2)) {
            return "Float.NaN";
        }
        if (f2 == Float.NEGATIVE_INFINITY) {
            return "Float.NEGATIVE_INFINITY";
        }
        if (f2 == Float.POSITIVE_INFINITY) {
            return "Float.POSITIVE_INFINITY";
        }
        if (f2 == Float.MIN_VALUE) {
            return "Float.MIN_VALUE";
        }
        if (f2 == Float.MAX_VALUE) {
            return "Float.MAX_VALUE";
        }
        if (f2 == Float.MIN_NORMAL) {
            return "Float.MIN_NORMAL";
        }
        return String.valueOf(Float.toString(f2)) + "f";
    }
}
