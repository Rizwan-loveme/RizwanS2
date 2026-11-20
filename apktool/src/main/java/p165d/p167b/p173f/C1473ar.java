package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: IssuingDistributionPointExtension.java */
/* renamed from: d.b.f.ar */
/* loaded from: classes.dex */
public class C1473ar extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private C1460ae f9427d;

    /* renamed from: e */
    private boolean f9428e;

    /* renamed from: f */
    private boolean f9429f;

    /* renamed from: g */
    private boolean f9430g;

    /* renamed from: h */
    private boolean f9431h;

    /* renamed from: i */
    private C1489bg f9432i;

    public C1473ar(C1460ae c1460ae, C1489bg c1489bg, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f9427d = null;
        this.f9432i = null;
        this.f9430g = false;
        this.f9429f = false;
        this.f9428e = false;
        this.f9431h = false;
        if ((z && (z2 || z3)) || ((z2 && (z || z3)) || (z3 && (z || z2)))) {
            throw new IllegalArgumentException("Only one of hasOnlyUserCerts, hasOnlyCACerts, hasOnlyAttributeCerts may be set to true");
        }
        this.f9411b = C1481az.f9496o;
        this.f9410a = true;
        this.f9427d = c1460ae;
        this.f9432i = c1489bg;
        this.f9430g = z;
        this.f9429f = z2;
        this.f9428e = z3;
        this.f9431h = z4;
        m11510b();
    }

    public C1473ar(Boolean bool, Object obj) {
        this.f9427d = null;
        this.f9432i = null;
        this.f9430g = false;
        this.f9429f = false;
        this.f9428e = false;
        this.f9431h = false;
        this.f9411b = C1481az.f9496o;
        this.f9410a = bool.booleanValue();
        if (!(obj instanceof byte[])) {
            throw new IOException("Illegal argument type");
        }
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for IssuingDistributionPointExtension.");
        }
        if (c1450m.f9356b != null && c1450m.f9356b.m11362a() != 0) {
            C1448k c1448k = c1450m.f9356b;
            while (c1448k != null && c1448k.m11362a() != 0) {
                C1450m m11371d = c1448k.m11371d();
                if (m11371d.m11420b((byte) 0) && m11371d.m11437r()) {
                    this.f9427d = new C1460ae(m11371d.f9356b.m11371d());
                } else if (m11371d.m11420b((byte) 1) && !m11371d.m11437r()) {
                    m11371d.m11422c((byte) 1);
                    this.f9430g = m11371d.m11424e();
                } else if (m11371d.m11420b((byte) 2) && !m11371d.m11437r()) {
                    m11371d.m11422c((byte) 1);
                    this.f9429f = m11371d.m11424e();
                } else if (m11371d.m11420b((byte) 3) && !m11371d.m11437r()) {
                    this.f9432i = new C1489bg(m11371d);
                } else if (m11371d.m11420b((byte) 4) && !m11371d.m11437r()) {
                    m11371d.m11422c((byte) 1);
                    this.f9431h = m11371d.m11424e();
                } else if (m11371d.m11420b((byte) 5) && !m11371d.m11437r()) {
                    m11371d.m11422c((byte) 1);
                    this.f9428e = m11371d.m11424e();
                } else {
                    throw new IOException("Invalid encoding of IssuingDistributionPoint");
                }
            }
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "IssuingDistributionPoint";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9496o;
            this.f9410a = false;
            m11510b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: b */
    private void m11510b() {
        if (this.f9427d == null && this.f9432i == null && !this.f9430g && !this.f9429f && !this.f9428e && !this.f9431h) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        if (this.f9427d != null) {
            C1449l c1449l2 = new C1449l();
            this.f9427d.m11485a(c1449l2);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l2);
        }
        if (this.f9430g) {
            C1449l c1449l3 = new C1449l();
            c1449l3.m11398a(this.f9430g);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 1), c1449l3);
        }
        if (this.f9429f) {
            C1449l c1449l4 = new C1449l();
            c1449l4.m11398a(this.f9429f);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 2), c1449l4);
        }
        if (this.f9432i != null) {
            C1449l c1449l5 = new C1449l();
            this.f9432i.m11541a(c1449l5);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 3), c1449l5);
        }
        if (this.f9431h) {
            C1449l c1449l6 = new C1449l();
            c1449l6.m11398a(this.f9431h);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 4), c1449l6);
        }
        if (this.f9428e) {
            C1449l c1449l7 = new C1449l();
            c1449l7.m11398a(this.f9428e);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 5), c1449l7);
        }
        C1449l c1449l8 = new C1449l();
        c1449l8.m11388a((byte) 48, c1449l);
        this.f9412c = c1449l8.toByteArray();
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("IssuingDistributionPoint [\n  ");
        if (this.f9427d != null) {
            sb.append(this.f9427d);
        }
        if (this.f9432i != null) {
            sb.append(this.f9432i);
        }
        if (this.f9430g) {
            str = "  Only contains user certs: true";
        } else {
            str = "  Only contains user certs: false";
        }
        sb.append(str).append("\n");
        if (this.f9429f) {
            str2 = "  Only contains CA certs: true";
        } else {
            str2 = "  Only contains CA certs: false";
        }
        sb.append(str2).append("\n");
        if (this.f9428e) {
            str3 = "  Only contains attribute certs: true";
        } else {
            str3 = "  Only contains attribute certs: false";
        }
        sb.append(str3).append("\n");
        if (this.f9431h) {
            str4 = "  Indirect CRL: true";
        } else {
            str4 = "  Indirect CRL: false";
        }
        sb.append(str4).append("\n");
        sb.append("]\n");
        return sb.toString();
    }
}
