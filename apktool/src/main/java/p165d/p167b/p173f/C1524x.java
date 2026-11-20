package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificateSubjectUniqueIdentity.java */
/* renamed from: d.b.f.x */
/* loaded from: classes.dex */
public class C1524x implements InterfaceC1513m<String> {

    /* renamed from: a */
    private C1494bl f9735a;

    public C1524x(C1450m c1450m) {
        this.f9735a = new C1494bl(c1450m);
    }

    public String toString() {
        return this.f9735a == null ? "" : this.f9735a.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        this.f9735a.m11553a(c1449l, C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 2));
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11688a(String str, Object obj) {
        if (!(obj instanceof C1494bl)) {
            throw new IOException("Attribute must be of type UniqueIdentity.");
        }
        if (str.equalsIgnoreCase("id")) {
            this.f9735a = (C1494bl) obj;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateSubjectUniqueIdentity.");
    }

    /* renamed from: a */
    public C1494bl m11687a(String str) {
        if (str.equalsIgnoreCase("id")) {
            return this.f9735a;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateSubjectUniqueIdentity.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "subjectID";
    }
}
