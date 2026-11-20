package p165d.p167b.p173f;

import java.io.IOException;
import java.util.Arrays;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: Extension.java */
/* renamed from: d.b.f.ah */
/* loaded from: classes.dex */
public class C1463ah {

    /* renamed from: a */
    protected boolean f9410a;

    /* renamed from: b */
    protected C1454q f9411b;

    /* renamed from: c */
    protected byte[] f9412c;

    public C1463ah() {
        this.f9411b = null;
        this.f9410a = false;
        this.f9412c = null;
    }

    public C1463ah(C1450m c1450m) {
        this.f9411b = null;
        this.f9410a = false;
        this.f9412c = null;
        C1448k m11441v = c1450m.m11441v();
        this.f9411b = m11441v.m11376h();
        C1450m m11371d = m11441v.m11371d();
        if (m11371d.f9357c == 1) {
            this.f9410a = m11371d.m11424e();
            this.f9412c = m11441v.m11371d().m11432m();
        } else {
            this.f9410a = false;
            this.f9412c = m11371d.m11432m();
        }
    }

    public C1463ah(C1454q c1454q, boolean z, byte[] bArr) {
        this.f9411b = null;
        this.f9410a = false;
        this.f9412c = null;
        this.f9411b = c1454q;
        this.f9410a = z;
        this.f9412c = new C1450m(bArr).m11432m();
    }

    public C1463ah(C1463ah c1463ah) {
        this.f9411b = null;
        this.f9410a = false;
        this.f9412c = null;
        this.f9411b = c1463ah.f9411b;
        this.f9410a = c1463ah.f9410a;
        this.f9412c = c1463ah.f9412c;
    }

    /* renamed from: a */
    public void m11488a(C1449l c1449l) {
        if (this.f9411b == null) {
            throw new IOException("Null OID to encode for the extension!");
        }
        if (this.f9412c == null) {
            throw new IOException("No value to encode for the extension!");
        }
        C1449l c1449l2 = new C1449l();
        c1449l2.m11394a(this.f9411b);
        if (this.f9410a) {
            c1449l2.m11398a(this.f9410a);
        }
        c1449l2.m11405b(this.f9412c);
        c1449l.m11388a((byte) 48, c1449l2);
    }

    /* renamed from: e */
    public boolean m11491e() {
        return this.f9410a;
    }

    /* renamed from: c */
    public C1454q m11489c() {
        return this.f9411b;
    }

    /* renamed from: d */
    public byte[] m11490d() {
        return this.f9412c;
    }

    public String toString() {
        String str = "ObjectId: " + this.f9411b.toString();
        if (this.f9410a) {
            return String.valueOf(str) + " Criticality=true\n";
        }
        return String.valueOf(str) + " Criticality=false\n";
    }

    public int hashCode() {
        int i = 0;
        if (this.f9412c != null) {
            byte[] bArr = this.f9412c;
            int length = bArr.length;
            while (length > 0) {
                int i2 = length - 1;
                i += length * bArr[i2];
                length = i2;
            }
        }
        return (((i * 31) + this.f9411b.hashCode()) * 31) + (this.f9410a ? 1231 : 1237);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1463ah)) {
            return false;
        }
        C1463ah c1463ah = (C1463ah) obj;
        if (this.f9410a == c1463ah.f9410a && this.f9411b.equals(c1463ah.f9411b)) {
            return Arrays.equals(this.f9412c, c1463ah.f9412c);
        }
        return false;
    }
}
