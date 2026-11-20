package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: PrivateKeyUsageExtension.java */
/* renamed from: d.b.f.bd */
/* loaded from: classes.dex */
public class C1486bd extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private Date f9514d;

    /* renamed from: e */
    private Date f9515e;

    /* renamed from: b */
    private void m11533b() {
        if (this.f9515e == null && this.f9514d == null) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        if (this.f9515e != null) {
            C1449l c1449l3 = new C1449l();
            c1449l3.m11397a(this.f9515e);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 0), c1449l3);
        }
        if (this.f9514d != null) {
            C1449l c1449l4 = new C1449l();
            c1449l4.m11397a(this.f9514d);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 1), c1449l4);
        }
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9412c = c1449l.toByteArray();
    }

    public C1486bd(Date date, Date date2) {
        this.f9515e = null;
        this.f9514d = null;
        this.f9515e = date;
        this.f9514d = date2;
        this.f9411b = C1481az.f9501t;
        this.f9410a = false;
        m11533b();
    }

    public C1486bd(Boolean bool, Object obj) {
        this.f9515e = null;
        this.f9514d = null;
        this.f9411b = C1481az.f9501t;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        for (C1450m c1450m : new C1448k(this.f9412c).m11364a(2)) {
            if (c1450m.m11420b((byte) 0) && !c1450m.m11437r()) {
                if (this.f9515e != null) {
                    throw new CertificateParsingException("Duplicate notBefore in PrivateKeyUsage.");
                }
                c1450m.m11422c((byte) 24);
                this.f9515e = new C1448k(c1450m.m11440u()).m11373e();
            } else if (c1450m.m11420b((byte) 1) && !c1450m.m11437r()) {
                if (this.f9514d != null) {
                    throw new CertificateParsingException("Duplicate notAfter in PrivateKeyUsage.");
                }
                c1450m.m11422c((byte) 24);
                this.f9514d = new C1448k(c1450m.m11440u()).m11373e();
            } else {
                throw new IOException("Invalid encoding of PrivateKeyUsageExtension");
            }
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + "PrivateKeyUsage: [\n" + (this.f9515e == null ? "" : "From: " + this.f9515e.toString() + ", ") + (this.f9514d == null ? "" : "To: " + this.f9514d.toString()) + "]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9501t;
            this.f9410a = false;
            m11533b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "PrivateKeyUsage";
    }
}
