package p165d.p167b.p173f;

import java.p209io.IOException;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificatePolicyMap.java */
/* renamed from: d.b.f.u */
/* loaded from: classes.dex */
public class C1521u {

    /* renamed from: a */
    private C1520t f9730a;

    /* renamed from: b */
    private C1520t f9731b;

    public C1521u(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for CertificatePolicyMap");
        }
        this.f9730a = new C1520t(c1450m.f9356b.m11371d());
        this.f9731b = new C1520t(c1450m.f9356b.m11371d());
    }

    public String toString() {
        return "CertificatePolicyMap: [\nIssuerDomain:" + this.f9730a.toString() + "SubjectDomain:" + this.f9731b.toString() + "]\n";
    }

    /* renamed from: a */
    public void m11682a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        this.f9730a.m11681a(c1449l2);
        this.f9731b.m11681a(c1449l2);
        c1449l.m11388a((byte) 48, c1449l2);
    }
}
