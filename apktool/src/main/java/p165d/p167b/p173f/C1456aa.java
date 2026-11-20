package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import java.security.PublicKey;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;

/* compiled from: CertificateX509Key.java */
/* renamed from: d.b.f.aa */
/* loaded from: classes.dex */
public class C1456aa implements InterfaceC1513m<String> {

    /* renamed from: a */
    private PublicKey f9384a;

    public C1456aa(PublicKey publicKey) {
        this.f9384a = publicKey;
    }

    public C1456aa(C1448k c1448k) {
        this.f9384a = C1502bt.m11613a(c1448k.m11371d());
    }

    public String toString() {
        return this.f9384a == null ? "" : this.f9384a.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        c1449l.write(this.f9384a.getEncoded());
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11476a(String str, Object obj) {
        if (str.equalsIgnoreCase("value")) {
            this.f9384a = (PublicKey) obj;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateX509Key.");
    }

    /* renamed from: a */
    public PublicKey m11474a(String str) {
        if (str.equalsIgnoreCase("value")) {
            return this.f9384a;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateX509Key.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "key";
    }
}
