package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificateIssuerExtension.java */
/* renamed from: d.b.f.p */
/* loaded from: classes.dex */
public class C1516p extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private C1467al f9724d;

    /* renamed from: b */
    private void m11673b() {
        if (this.f9724d == null || this.f9724d.m11497a()) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        this.f9724d.m11496a(c1449l);
        this.f9412c = c1449l.toByteArray();
    }

    public C1516p(C1467al c1467al) {
        this.f9411b = C1481az.f9487f;
        this.f9410a = true;
        this.f9724d = c1467al;
        m11673b();
    }

    public C1516p(Boolean bool, Object obj) {
        this.f9411b = C1481az.f9487f;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        this.f9724d = new C1467al(new C1450m(this.f9412c));
    }

    /* renamed from: a */
    public C1467al m11674a(String str) {
        if (str.equalsIgnoreCase("issuer")) {
            return this.f9724d;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateIssuer");
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + "Certificate Issuer [\n" + String.valueOf(this.f9724d) + "]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9487f;
            this.f9410a = true;
            m11673b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "CertificateIssuer";
    }
}
