package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificateSerialNumber.java */
/* renamed from: d.b.f.v */
/* loaded from: classes.dex */
public class C1522v implements InterfaceC1513m<String> {

    /* renamed from: a */
    private C1490bh f9732a;

    public C1522v(int i) {
        this.f9732a = new C1490bh(i);
    }

    public C1522v(C1450m c1450m) {
        this.f9732a = new C1490bh(c1450m);
    }

    public String toString() {
        return this.f9732a == null ? "" : this.f9732a.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        this.f9732a.m11544a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11684a(String str, Object obj) {
        if (!(obj instanceof C1490bh)) {
            throw new IOException("Attribute must be of type SerialNumber.");
        }
        if (str.equalsIgnoreCase("number")) {
            this.f9732a = (C1490bh) obj;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateSerialNumber.");
    }

    /* renamed from: a */
    public C1490bh m11683a(String str) {
        if (str.equalsIgnoreCase("number")) {
            return this.f9732a;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateSerialNumber.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "serialNumber";
    }
}
