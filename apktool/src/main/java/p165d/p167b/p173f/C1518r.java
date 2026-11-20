package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificateIssuerUniqueIdentity.java */
/* renamed from: d.b.f.r */
/* loaded from: classes.dex */
public class C1518r implements InterfaceC1513m<String> {

    /* renamed from: a */
    private C1494bl f9727a;

    public C1518r(C1450m c1450m) {
        this.f9727a = new C1494bl(c1450m);
    }

    public String toString() {
        return this.f9727a == null ? "" : this.f9727a.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        this.f9727a.m11553a(c1449l, C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 1));
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11678a(String str, Object obj) {
        if (!(obj instanceof C1494bl)) {
            throw new IOException("Attribute must be of type UniqueIdentity.");
        }
        if (str.equalsIgnoreCase("id")) {
            this.f9727a = (C1494bl) obj;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateIssuerUniqueIdentity.");
    }

    /* renamed from: a */
    public C1494bl m11677a(String str) {
        if (str.equalsIgnoreCase("id")) {
            return this.f9727a;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateIssuerUniqueIdentity.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "issuerID";
    }
}
