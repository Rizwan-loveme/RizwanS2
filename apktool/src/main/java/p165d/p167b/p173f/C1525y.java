package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.Date;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificateValidity.java */
/* renamed from: d.b.f.y */
/* loaded from: classes.dex */
public class C1525y implements InterfaceC1513m<String> {

    /* renamed from: a */
    private Date f9736a;

    /* renamed from: b */
    private Date f9737b;

    /* renamed from: c */
    private Date m11691c() {
        return new Date(this.f9737b.getTime());
    }

    /* renamed from: b */
    private Date m11690b() {
        return new Date(this.f9736a.getTime());
    }

    /* renamed from: a */
    private void m11689a(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoded CertificateValidity, starting sequence tag missing.");
        }
        if (c1450m.f9356b.m11362a() == 0) {
            throw new IOException("No data encoded for CertificateValidity");
        }
        C1450m[] m11364a = new C1448k(c1450m.m11440u()).m11364a(2);
        if (m11364a.length != 2) {
            throw new IOException("Invalid encoding for CertificateValidity");
        }
        if (m11364a[0].f9357c == 23) {
            this.f9737b = c1450m.f9356b.m11378j();
        } else if (m11364a[0].f9357c == 24) {
            this.f9737b = c1450m.f9356b.m11373e();
        } else {
            throw new IOException("Invalid encoding for CertificateValidity");
        }
        if (m11364a[1].f9357c == 23) {
            this.f9736a = c1450m.f9356b.m11378j();
        } else {
            if (m11364a[1].f9357c == 24) {
                this.f9736a = c1450m.f9356b.m11373e();
                return;
            }
            throw new IOException("Invalid encoding for CertificateValidity");
        }
    }

    public C1525y() {
    }

    public C1525y(Date date, Date date2) {
        this.f9737b = date;
        this.f9736a = date2;
    }

    public C1525y(C1448k c1448k) {
        m11689a(c1448k.m11371d());
    }

    public String toString() {
        if (this.f9737b == null || this.f9736a == null) {
            return "";
        }
        return "Validity: [From: " + this.f9737b.toString() + ",\n               To: " + this.f9736a.toString() + "]";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        if (this.f9737b == null || this.f9736a == null) {
            throw new IOException("CertAttrSet:CertificateValidity: null values to encode.\n");
        }
        C1449l c1449l = new C1449l();
        if (this.f9737b.getTime() < 2524636800000L) {
            c1449l.m11404b(this.f9737b);
        } else {
            c1449l.m11397a(this.f9737b);
        }
        if (this.f9736a.getTime() < 2524636800000L) {
            c1449l.m11404b(this.f9736a);
        } else {
            c1449l.m11397a(this.f9736a);
        }
        C1449l c1449l2 = new C1449l();
        c1449l2.m11388a((byte) 48, c1449l);
        outputStream.write(c1449l2.toByteArray());
    }

    /* renamed from: a */
    public void m11693a(String str, Object obj) {
        if (!(obj instanceof Date)) {
            throw new IOException("Attribute must be of type Date.");
        }
        if (str.equalsIgnoreCase("notBefore")) {
            this.f9737b = (Date) obj;
        } else {
            if (str.equalsIgnoreCase("notAfter")) {
                this.f9736a = (Date) obj;
                return;
            }
            throw new IOException("Attribute name not recognized by CertAttrSet: CertificateValidity.");
        }
    }

    /* renamed from: a */
    public Date m11692a(String str) {
        if (str.equalsIgnoreCase("notBefore")) {
            return m11691c();
        }
        if (str.equalsIgnoreCase("notAfter")) {
            return m11690b();
        }
        throw new IOException("Attribute name not recognized by CertAttrSet: CertificateValidity.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "validity";
    }

    /* renamed from: a */
    public void m11694a(Date date) {
        if (this.f9737b.after(date)) {
            throw new CertificateNotYetValidException("NotBefore: " + this.f9737b.toString());
        }
        if (this.f9736a.before(date)) {
            throw new CertificateExpiredException("NotAfter: " + this.f9736a.toString());
        }
    }
}
