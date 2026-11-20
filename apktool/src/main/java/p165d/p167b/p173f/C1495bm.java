package p165d.p167b.p173f;

import p165d.p166a.C1420b;

/* compiled from: CertificateExtensions.java */
/* renamed from: d.b.f.bm */
/* loaded from: classes.dex */
class C1495bm extends C1463ah {

    /* renamed from: d */
    private String f9529d;

    /* renamed from: e */
    private Throwable f9530e;

    public C1495bm(C1463ah c1463ah, Throwable th) {
        super(c1463ah);
        this.f9529d = "";
        try {
            Class<?> m11520a = C1478aw.m11520a(c1463ah.m11489c());
            if (m11520a != null) {
                this.f9529d = String.valueOf((String) m11520a.getDeclaredField("NAME").get(null)) + " ";
            }
        } catch (Exception e2) {
        }
        this.f9530e = th;
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + "Unparseable " + this.f9529d + "extension due to\n" + this.f9530e + "\n\n" + new C1420b().m11234b(m11490d());
    }
}
