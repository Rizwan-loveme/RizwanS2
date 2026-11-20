package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import javax.security.auth.x500.X500Principal;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;

/* compiled from: CertificateIssuerName.java */
/* renamed from: d.b.f.q */
/* loaded from: classes.dex */
public class C1517q implements InterfaceC1513m<String> {

    /* renamed from: a */
    private C1496bn f9725a;

    /* renamed from: b */
    private X500Principal f9726b;

    public C1517q(C1496bn c1496bn) {
        this.f9725a = c1496bn;
    }

    public C1517q(C1448k c1448k) {
        this.f9725a = new C1496bn(c1448k);
    }

    public String toString() {
        return this.f9725a == null ? "" : this.f9725a.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        this.f9725a.mo11479a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11676a(String str, Object obj) {
        if (!(obj instanceof C1496bn)) {
            throw new IOException("Attribute must be of type X500Name.");
        }
        if (str.equalsIgnoreCase("dname")) {
            this.f9725a = (C1496bn) obj;
            this.f9726b = null;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateIssuerName.");
    }

    /* renamed from: a */
    public Object m11675a(String str) {
        if (str.equalsIgnoreCase("dname")) {
            return this.f9725a;
        }
        if (str.equalsIgnoreCase("x500principal")) {
            if (this.f9726b == null && this.f9725a != null) {
                this.f9726b = this.f9725a.m11564a();
            }
            return this.f9726b;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateIssuerName.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "issuer";
    }
}
