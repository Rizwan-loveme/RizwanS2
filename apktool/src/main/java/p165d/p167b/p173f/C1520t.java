package p165d.p167b.p173f;

import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: CertificatePolicyId.java */
/* renamed from: d.b.f.t */
/* loaded from: classes.dex */
public class C1520t {

    /* renamed from: a */
    private C1454q f9729a;

    public C1520t(C1450m c1450m) {
        this.f9729a = c1450m.m11431l();
    }

    /* renamed from: a */
    public C1454q m11680a() {
        return this.f9729a;
    }

    public String toString() {
        return "CertificatePolicyId: [" + this.f9729a.toString() + "]\n";
    }

    /* renamed from: a */
    public void m11681a(C1449l c1449l) {
        c1449l.m11394a(this.f9729a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1520t) {
            return this.f9729a.equals(((C1520t) obj).m11680a());
        }
        return false;
    }

    public int hashCode() {
        return this.f9729a.hashCode();
    }
}
