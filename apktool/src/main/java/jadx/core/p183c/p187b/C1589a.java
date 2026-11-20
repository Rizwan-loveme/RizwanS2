package jadx.core.p183c.p187b;

import org.p226d.p233b.EnumC1959a;

/* compiled from: AccessInfo.java */
/* renamed from: jadx.core.c.b.a */
/* loaded from: classes.dex */
public class C1589a {

    /* renamed from: c */
    private static /* synthetic */ int[] f10090c;

    /* renamed from: a */
    private final int f10091a;

    /* renamed from: b */
    private final a f10092b;

    /* compiled from: AccessInfo.java */
    /* renamed from: jadx.core.c.b.a$a */
    public enum a {
        CLASS,
        FIELD,
        METHOD;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            int length = valuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    /* renamed from: t */
    static /* synthetic */ int[] m12168t() {
        int[] iArr = f10090c;
        if (iArr == null) {
            iArr = new int[a.valuesCustom().length];
            try {
                iArr[a.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[a.METHOD.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            f10090c = iArr;
        }
        return iArr;
    }

    public C1589a(int i, a aVar) {
        this.f10091a = i;
        this.f10092b = aVar;
    }

    /* renamed from: a */
    public boolean m12171a(int i) {
        return (this.f10091a & i) != 0;
    }

    /* renamed from: a */
    public C1589a m12169a(EnumC1959a enumC1959a) {
        return m12172b(enumC1959a.m14191a());
    }

    /* renamed from: b */
    public C1589a m12172b(int i) {
        if (m12171a(i)) {
            return new C1589a(this.f10091a & (i ^ (-1)), this.f10092b);
        }
        return this;
    }

    /* renamed from: a */
    public boolean m12170a() {
        return (this.f10091a & EnumC1959a.PUBLIC.m14191a()) != 0;
    }

    /* renamed from: b */
    public boolean m12173b() {
        return (this.f10091a & EnumC1959a.PROTECTED.m14191a()) != 0;
    }

    /* renamed from: c */
    public boolean m12174c() {
        return (this.f10091a & EnumC1959a.PRIVATE.m14191a()) != 0;
    }

    /* renamed from: d */
    public boolean m12175d() {
        return (this.f10091a & EnumC1959a.ABSTRACT.m14191a()) != 0;
    }

    /* renamed from: e */
    public boolean m12176e() {
        return (this.f10091a & EnumC1959a.INTERFACE.m14191a()) != 0;
    }

    /* renamed from: f */
    public boolean m12177f() {
        return (this.f10091a & EnumC1959a.ANNOTATION.m14191a()) != 0;
    }

    /* renamed from: g */
    public boolean m12178g() {
        return (this.f10091a & EnumC1959a.NATIVE.m14191a()) != 0;
    }

    /* renamed from: h */
    public boolean m12179h() {
        return (this.f10091a & EnumC1959a.STATIC.m14191a()) != 0;
    }

    /* renamed from: i */
    public boolean m12180i() {
        return (this.f10091a & EnumC1959a.FINAL.m14191a()) != 0;
    }

    /* renamed from: j */
    public boolean m12181j() {
        return (this.f10091a & EnumC1959a.CONSTRUCTOR.m14191a()) != 0;
    }

    /* renamed from: k */
    public boolean m12182k() {
        return (this.f10091a & EnumC1959a.ENUM.m14191a()) != 0;
    }

    /* renamed from: l */
    public boolean m12183l() {
        return (this.f10091a & EnumC1959a.SYNTHETIC.m14191a()) != 0;
    }

    /* renamed from: m */
    public boolean m12184m() {
        return (this.f10091a & EnumC1959a.BRIDGE.m14191a()) != 0;
    }

    /* renamed from: n */
    public boolean m12185n() {
        return (this.f10091a & EnumC1959a.VARARGS.m14191a()) != 0;
    }

    /* renamed from: o */
    public boolean m12186o() {
        return (this.f10091a & (EnumC1959a.SYNCHRONIZED.m14191a() | EnumC1959a.DECLARED_SYNCHRONIZED.m14191a())) != 0;
    }

    /* renamed from: p */
    public boolean m12187p() {
        return (this.f10091a & EnumC1959a.TRANSIENT.m14191a()) != 0;
    }

    /* renamed from: q */
    public boolean m12188q() {
        return (this.f10091a & EnumC1959a.VOLATILE.m14191a()) != 0;
    }

    /* renamed from: r */
    public String m12189r() {
        StringBuilder sb = new StringBuilder();
        if (m12170a()) {
            sb.append("public ");
        }
        if (m12174c()) {
            sb.append("private ");
        }
        if (m12173b()) {
            sb.append("protected ");
        }
        if (m12179h()) {
            sb.append("static ");
        }
        if (m12180i()) {
            sb.append("final ");
        }
        if (m12175d()) {
            sb.append("abstract ");
        }
        if (m12178g()) {
            sb.append("native ");
        }
        switch (m12168t()[this.f10092b.ordinal()]) {
            case 1:
                if ((this.f10091a & EnumC1959a.STRICTFP.m14191a()) != 0) {
                    sb.append("strictfp ");
                    break;
                }
                break;
            case 2:
                if (m12188q()) {
                    sb.append("volatile ");
                }
                if (m12187p()) {
                    sb.append("transient ");
                    break;
                }
                break;
            case 3:
                if (m12186o()) {
                    sb.append("synchronized ");
                }
                if (m12184m()) {
                    sb.append("/* bridge */ ");
                    break;
                }
                break;
        }
        if (m12183l()) {
            sb.append("/* synthetic */ ");
        }
        return sb.toString();
    }

    /* renamed from: s */
    public String m12190s() {
        switch (m12168t()[this.f10092b.ordinal()]) {
            case 1:
                return EnumC1959a.m14186c(this.f10091a);
            case 2:
                return EnumC1959a.m14190g(this.f10091a);
            case 3:
                return EnumC1959a.m14188e(this.f10091a);
            default:
                return "?";
        }
    }

    public String toString() {
        return "AccessInfo: " + this.f10092b + " 0x" + Integer.toHexString(this.f10091a) + " (" + m12190s() + ")";
    }
}
