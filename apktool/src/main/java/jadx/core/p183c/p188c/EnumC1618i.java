package jadx.core.p183c.p188c;

import jadx.core.p203d.p205b.C1729f;

/* compiled from: IfOp.java */
/* renamed from: jadx.core.c.c.i */
/* loaded from: classes.dex */
public enum EnumC1618i {
    EQ("=="),
    NE("!="),
    LT("<"),
    LE("<="),
    GT(">"),
    GE(">=");


    /* renamed from: h */
    private static /* synthetic */ int[] f10232h;

    /* renamed from: g */
    private final String f10234g;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1618i[] valuesCustom() {
        EnumC1618i[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1618i[] enumC1618iArr = new EnumC1618i[length];
        System.arraycopy(valuesCustom, 0, enumC1618iArr, 0, length);
        return enumC1618iArr;
    }

    /* renamed from: c */
    static /* synthetic */ int[] m12391c() {
        int[] iArr = f10232h;
        if (iArr == null) {
            iArr = new int[valuesCustom().length];
            try {
                iArr[EQ.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[GE.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[GT.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[LT.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[NE.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            f10232h = iArr;
        }
        return iArr;
    }

    EnumC1618i(String str) {
        this.f10234g = str;
    }

    /* renamed from: a */
    public String m12392a() {
        return this.f10234g;
    }

    /* renamed from: b */
    public EnumC1618i m12393b() {
        switch (m12391c()[ordinal()]) {
            case 1:
                return NE;
            case 2:
                return EQ;
            case 3:
                return GE;
            case 4:
                return GT;
            case 5:
                return LE;
            case 6:
                return LT;
            default:
                throw new C1729f("Unknown if operations type: " + this);
        }
    }
}
