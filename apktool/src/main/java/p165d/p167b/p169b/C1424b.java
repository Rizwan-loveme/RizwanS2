package p165d.p167b.p169b;

import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p173f.C1467al;
import p165d.p167b.p173f.C1490bh;

/* compiled from: SigningCertificateInfo.java */
/* renamed from: d.b.b.b */
/* loaded from: classes.dex */
class C1424b {

    /* renamed from: a */
    private static volatile C1420b f9214a;

    /* renamed from: b */
    private byte[] f9215b;

    /* renamed from: c */
    private C1467al f9216c;

    /* renamed from: d */
    private C1490bh f9217d;

    C1424b(C1450m c1450m) {
        this.f9215b = c1450m.f9356b.m11371d().m11440u();
        if (c1450m.f9356b.m11362a() > 0) {
            C1450m m11371d = c1450m.f9356b.m11371d();
            this.f9216c = new C1467al(m11371d.f9356b.m11371d());
            this.f9217d = new C1490bh(m11371d.f9356b.m11371d());
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[\n\tCertificate hash (SHA-1):\n");
        if (f9214a == null) {
            f9214a = new C1420b();
        }
        stringBuffer.append(f9214a.m11228a(this.f9215b));
        if (this.f9216c != null && this.f9217d != null) {
            stringBuffer.append("\n\tIssuer: " + this.f9216c + "\n");
            stringBuffer.append("\t" + this.f9217d);
        }
        stringBuffer.append("\n]");
        return stringBuffer.toString();
    }
}
