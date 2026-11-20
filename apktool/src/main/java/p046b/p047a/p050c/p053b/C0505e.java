package p046b.p047a.p050c.p053b;

import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0460e;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0493d;
import p046b.p047a.p050c.p051a.C0495f;
import p046b.p047a.p050c.p051a.p052a.AbstractC0486r;
import p046b.p047a.p050c.p051a.p052a.C0470b;

/* compiled from: ResAttrDecoder.java */
/* renamed from: b.a.c.b.e */
/* loaded from: classes.dex */
public class C0505e {

    /* renamed from: a */
    private C0495f f3545a;

    /* renamed from: a */
    public String m3827a(int i, int i2, String str, int i3) {
        AbstractC0486r m3660a = this.f3545a.m3724f().m3680i().m3660a(i, i2, str);
        String str2 = (String) null;
        if (i3 > 0) {
            try {
                str2 = ((C0470b) m3825a().m3704a(i3).m3689b().m3701d()).mo3629a(m3660a);
            } catch (C0460e e2) {
            } catch (ClassCastException e3) {
            }
        }
        return str2 != null ? str2 : m3660a.mo3649g();
    }

    /* renamed from: a */
    public String m3826a(int i) {
        C0493d m3704a;
        return (i == 0 || (m3704a = m3825a().m3704a(i)) == null) ? (String) null : m3704a.m3693e();
    }

    /* renamed from: a */
    public void m3828a(C0495f c0495f) {
        this.f3545a = c0495f;
    }

    /* renamed from: a */
    public C0495f m3825a() {
        if (this.f3545a == null) {
            throw new C0461b("Current resTable not set.");
        }
        return this.f3545a;
    }

    /* renamed from: b */
    public C0492c m3829b() {
        if (this.f3545a == null) {
            throw new C0461b("Current package not set");
        }
        return this.f3545a.m3724f();
    }
}
