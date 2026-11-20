package p165d.p167b.p173f;

import java.math.BigInteger;
import java.io.OutputStream;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: CRLNumberExtension.java */
/* renamed from: d.b.f.k */
/* loaded from: classes.dex */
public class C1511k extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private BigInteger f9714d;

    /* renamed from: e */
    private String f9715e;

    /* renamed from: f */
    private String f9716f;

    /* renamed from: b */
    private void m11659b() {
        if (this.f9714d == null) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        c1449l.m11396a(this.f9714d);
        this.f9412c = c1449l.toByteArray();
    }

    public C1511k(int i) {
        this(C1481az.f9486e, false, BigInteger.valueOf(i), "CRLNumber", "CRL Number");
    }

    public C1511k(BigInteger bigInteger) {
        this(C1481az.f9486e, false, bigInteger, "CRLNumber", "CRL Number");
    }

    protected C1511k(C1454q c1454q, boolean z, BigInteger bigInteger, String str, String str2) {
        this.f9714d = null;
        this.f9411b = c1454q;
        this.f9410a = z;
        this.f9714d = bigInteger;
        this.f9716f = str;
        this.f9715e = str2;
        m11659b();
    }

    public C1511k(Boolean bool, Object obj) {
        this(C1481az.f9486e, bool, obj, "CRLNumber", "CRL Number");
    }

    protected C1511k(C1454q c1454q, Boolean bool, Object obj, String str, String str2) {
        this.f9714d = null;
        this.f9411b = c1454q;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        this.f9714d = new C1450m(this.f9412c).m11421c();
        this.f9716f = str;
        this.f9715e = str2;
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + this.f9715e + ": " + (this.f9714d == null ? "" : C1444g.m11329a(this.f9714d)) + "\n";
    }

    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        new C1449l();
        m11660a(outputStream, C1481az.f9486e, true);
    }

    /* renamed from: a */
    protected void m11660a(OutputStream outputStream, C1454q c1454q, boolean z) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = c1454q;
            this.f9410a = z;
            m11659b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return this.f9716f;
    }
}
