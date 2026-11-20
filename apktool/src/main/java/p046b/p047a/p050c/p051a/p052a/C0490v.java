package p046b.p047a.p050c.p051a.p052a;

import p046b.p047a.C0461b;
import p046b.p047a.p050c.C0467a;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0497h;
import p046b.p058c.InterfaceC0528c;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResValueFactory.java */
/* renamed from: b.a.c.a.a.v */
/* loaded from: classes.dex */
public class C0490v {

    /* renamed from: a */
    private final C0492c f3410a;

    /* renamed from: b */
    private final InterfaceC0541f f3411b;

    /* renamed from: c */
    private boolean f3412c;

    public C0490v(C0492c c0492c, boolean z, InterfaceC0541f interfaceC0541f) {
        this.f3410a = c0492c;
        this.f3411b = interfaceC0541f;
        this.f3412c = z;
    }

    /* renamed from: a */
    public AbstractC0486r m3660a(int i, int i2, String str) {
        switch (i) {
            case 0:
                if (i2 == 1) {
                    return new C0475g(i2, str, i);
                }
                return new C0485q(this.f3410a, 0, (String) null);
            case 1:
                return m3658a(i2, (String) null);
            case 2:
            case 8:
                return m3659a(i2, str, true);
            case 3:
                return new C0487s(str, i2);
            case 4:
                return new C0479k(Float.intBitsToFloat(i2), i2, str);
            case 5:
                return new C0474f(i2, str);
            case 6:
                return new C0480l(i2, str);
            case 7:
                return m3658a(i2, str);
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            default:
                if (i >= 28 && i <= 31) {
                    return new C0473e(i2, str);
                }
                if (i >= 16 && i <= 31) {
                    return new C0483o(i2, str, i);
                }
                throw new C0461b(new StringBuffer().append("Invalid value type: ").append(i).toString());
            case 18:
                return new C0472d(i2 != 0, i2, str);
        }
    }

    /* renamed from: a */
    public C0482n m3657a(String str, int i, C0467a c0467a) {
        if (str == null) {
            return new C0477i("", i);
        }
        if (str.indexOf(47) >= 0) {
            if (c0467a != null) {
                c0467a.m3596a(str);
            }
            return new C0477i(str, i);
        }
        if (c0467a != null) {
            String replace = str.replace('\\', '/');
            InterfaceC0528c m3613e = c0467a.m3613e();
            if (m3613e != null && m3613e.mo3916a(replace)) {
                c0467a.m3596a(replace);
                return new C0477i(replace, i);
            }
        }
        return new C0487s(str, i);
    }

    /* renamed from: a */
    public C0471c m3656a(int i, C0538c<Integer, AbstractC0486r>[] c0538cArr, C0497h c0497h) {
        C0485q m3658a = m3658a(i, (String) null);
        if (c0538cArr.length == 0) {
            return new C0471c(m3658a, this.f3412c, this.f3411b);
        }
        int intValue = c0538cArr[0].f3632a.intValue();
        if (intValue == 16777216 && (c0538cArr[0].f3633b instanceof C0483o)) {
            return C0470b.m3627a(m3658a, c0538cArr, this, this.f3410a, this.f3411b);
        }
        String m3740a = c0497h.m3740a();
        if (m3740a.equals("array") || intValue == 33554432 || intValue == 0) {
            return new C0469a(m3658a, c0538cArr, this.f3412c, this.f3411b);
        }
        if (m3740a.equals("plurals") || (intValue >= 16777220 && intValue <= 16777225)) {
            return new C0484p(m3658a, c0538cArr, this.f3412c, this.f3411b);
        }
        if (C0497h.f3457a.equals(m3740a)) {
            return new C0470b(m3658a, 0, (Integer) null, (Integer) null, (Boolean) null, this.f3412c, this.f3411b);
        }
        if (m3740a.startsWith("style")) {
            return new C0488t(m3658a, c0538cArr, this, this.f3412c, this.f3411b);
        }
        throw new C0461b(new StringBuffer().append("unsupported res type name for bags. Found: ").append(m3740a).toString());
    }

    /* renamed from: a */
    public C0485q m3658a(int i, String str) {
        return m3659a(i, str, false);
    }

    /* renamed from: a */
    public C0485q m3659a(int i, String str, boolean z) {
        return new C0485q(this.f3410a, i, str, z);
    }
}
