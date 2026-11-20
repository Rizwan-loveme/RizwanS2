package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: InhibitAnyPolicyExtension.java */
/* renamed from: d.b.f.ap */
/* loaded from: classes.dex */
public class C1471ap extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    public static C1454q f9423d;

    /* renamed from: e */
    private static final C1444g f9424e = C1444g.m11327a("certpath");

    /* renamed from: f */
    private int f9425f;

    static {
        try {
            f9423d = new C1454q("2.5.29.32.0");
        } catch (IOException e2) {
        }
    }

    /* renamed from: b */
    private void m11507b() {
        C1449l c1449l = new C1449l();
        c1449l.m11401b(this.f9425f);
        this.f9412c = c1449l.toByteArray();
    }

    public C1471ap(int i) {
        this.f9425f = Integer.MAX_VALUE;
        if (i < -1) {
            throw new IOException("Invalid value for skipCerts");
        }
        if (i == -1) {
            this.f9425f = Integer.MAX_VALUE;
        } else {
            this.f9425f = i;
        }
        this.f9411b = C1481az.f9493l;
        this.f9410a = true;
        m11507b();
    }

    public C1471ap(Boolean bool, Object obj) {
        this.f9425f = Integer.MAX_VALUE;
        this.f9411b = C1481az.f9493l;
        if (!bool.booleanValue()) {
            throw new IOException("Criticality cannot be false for InhibitAnyPolicy");
        }
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 2) {
            throw new IOException("Invalid encoding of InhibitAnyPolicy: data not integer");
        }
        if (c1450m.f9356b == null) {
            throw new IOException("Invalid encoding of InhibitAnyPolicy: null data");
        }
        int m11430k = c1450m.m11430k();
        if (m11430k < -1) {
            throw new IOException("Invalid value for skipCerts");
        }
        if (m11430k == -1) {
            this.f9425f = Integer.MAX_VALUE;
        } else {
            this.f9425f = m11430k;
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + "InhibitAnyPolicy: " + this.f9425f + "\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9493l;
            this.f9410a = true;
            m11507b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "InhibitAnyPolicy";
    }
}
