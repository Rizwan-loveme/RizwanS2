package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;

/* compiled from: CertificateAlgorithmId.java */
/* renamed from: d.b.f.n */
/* loaded from: classes.dex */
public class C1514n implements InterfaceC1513m<String> {

    /* renamed from: a */
    private C1505e f9718a;

    public C1514n(C1505e c1505e) {
        this.f9718a = c1505e;
    }

    public C1514n(C1448k c1448k) {
        this.f9718a = C1505e.m11630a(c1448k.m11371d());
    }

    public String toString() {
        return this.f9718a == null ? "" : String.valueOf(this.f9718a.toString()) + ", OID = " + this.f9718a.m11643e().toString() + "\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        this.f9718a.m11637a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11663a(String str, Object obj) {
        if (!(obj instanceof C1505e)) {
            throw new IOException("Attribute must be of type AlgorithmId.");
        }
        if (str.equalsIgnoreCase("algorithm")) {
            this.f9718a = (C1505e) obj;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateAlgorithmId.");
    }

    /* renamed from: a */
    public C1505e m11662a(String str) {
        if (str.equalsIgnoreCase("algorithm")) {
            return this.f9718a;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateAlgorithmId.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "algorithmID";
    }
}
