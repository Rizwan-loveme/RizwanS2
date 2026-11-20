package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificateVersion.java */
/* renamed from: d.b.f.z */
/* loaded from: classes.dex */
public class C1526z implements InterfaceC1513m<String> {

    /* renamed from: a */
    int f9738a;

    /* renamed from: b */
    private int m11696b() {
        return this.f9738a;
    }

    /* renamed from: a */
    private void m11695a(C1450m c1450m) {
        if (c1450m.m11437r() && c1450m.m11438s()) {
            C1450m m11371d = c1450m.f9356b.m11371d();
            this.f9738a = m11371d.m11430k();
            if (m11371d.f9356b.m11362a() != 0) {
                throw new IOException("X.509 version, bad format");
            }
        }
    }

    public C1526z() {
        this.f9738a = 0;
        this.f9738a = 0;
    }

    public C1526z(int i) {
        this.f9738a = 0;
        if (i == 0 || i == 1 || i == 2) {
            this.f9738a = i;
            return;
        }
        throw new IOException("X.509 Certificate version " + i + " not supported.\n");
    }

    public C1526z(C1450m c1450m) {
        this.f9738a = 0;
        this.f9738a = 0;
        m11695a(c1450m);
    }

    public String toString() {
        return "Version: V" + (this.f9738a + 1);
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        if (this.f9738a != 0) {
            C1449l c1449l = new C1449l();
            c1449l.m11401b(this.f9738a);
            C1449l c1449l2 = new C1449l();
            c1449l2.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l);
            outputStream.write(c1449l2.toByteArray());
        }
    }

    /* renamed from: a */
    public void m11699a(String str, Object obj) {
        if (!(obj instanceof Integer)) {
            throw new IOException("Attribute must be of type Integer.");
        }
        if (str.equalsIgnoreCase("number")) {
            this.f9738a = ((Integer) obj).intValue();
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateVersion.");
    }

    /* renamed from: a */
    public Integer m11698a(String str) {
        if (str.equalsIgnoreCase("number")) {
            return new Integer(m11696b());
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateVersion.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "version";
    }

    /* renamed from: a */
    public int m11697a(int i) {
        return this.f9738a - i;
    }
}
