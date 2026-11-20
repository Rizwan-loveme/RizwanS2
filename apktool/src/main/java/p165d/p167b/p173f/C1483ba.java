package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: PolicyConstraintsExtension.java */
/* renamed from: d.b.f.ba */
/* loaded from: classes.dex */
public class C1483ba extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private int f9509d;

    /* renamed from: e */
    private int f9510e;

    /* renamed from: b */
    private void m11528b() {
        if (this.f9510e == -1 && this.f9509d == -1) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        if (this.f9510e != -1) {
            C1449l c1449l3 = new C1449l();
            c1449l3.m11401b(this.f9510e);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 0), c1449l3);
        }
        if (this.f9509d != -1) {
            C1449l c1449l4 = new C1449l();
            c1449l4.m11401b(this.f9509d);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 1), c1449l4);
        }
        c1449l2.m11388a((byte) 48, c1449l);
        this.f9412c = c1449l2.toByteArray();
    }

    public C1483ba(int i, int i2) {
        this(Boolean.FALSE, i, i2);
    }

    public C1483ba(Boolean bool, int i, int i2) {
        this.f9510e = -1;
        this.f9509d = -1;
        this.f9510e = i;
        this.f9509d = i2;
        this.f9411b = C1481az.f9499r;
        this.f9410a = bool.booleanValue();
        m11528b();
    }

    public C1483ba(Boolean bool, Object obj) {
        this.f9510e = -1;
        this.f9509d = -1;
        this.f9411b = C1481az.f9499r;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Sequence tag missing for PolicyConstraint.");
        }
        C1448k c1448k = c1450m.f9356b;
        while (c1448k != null && c1448k.m11362a() != 0) {
            C1450m m11371d = c1448k.m11371d();
            if (m11371d.m11420b((byte) 0) && !m11371d.m11437r()) {
                if (this.f9510e != -1) {
                    throw new IOException("Duplicate requireExplicitPolicyfound in the PolicyConstraintsExtension");
                }
                m11371d.m11422c((byte) 2);
                this.f9510e = m11371d.m11430k();
            } else if (m11371d.m11420b((byte) 1) && !m11371d.m11437r()) {
                if (this.f9509d != -1) {
                    throw new IOException("Duplicate inhibitPolicyMappingfound in the PolicyConstraintsExtension");
                }
                m11371d.m11422c((byte) 2);
                this.f9509d = m11371d.m11430k();
            } else {
                throw new IOException("Invalid encoding of PolicyConstraint");
            }
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        String str;
        String str2;
        String str3 = String.valueOf(super.toString()) + "PolicyConstraints: [  Require: ";
        if (this.f9510e == -1) {
            str = String.valueOf(str3) + "unspecified;";
        } else {
            str = String.valueOf(str3) + this.f9510e + ";";
        }
        String str4 = String.valueOf(str) + "\tInhibit: ";
        if (this.f9509d == -1) {
            str2 = String.valueOf(str4) + "unspecified";
        } else {
            str2 = String.valueOf(str4) + this.f9509d;
        }
        return String.valueOf(str2) + " ]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9499r;
            this.f9410a = false;
            m11528b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "PolicyConstraints";
    }
}
