package p165d.p167b.p173f;

import java.io.IOException;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: GeneralSubtree.java */
/* renamed from: d.b.f.am */
/* loaded from: classes.dex */
public class C1468am {

    /* renamed from: a */
    private int f9415a;

    /* renamed from: b */
    private int f9416b;

    /* renamed from: c */
    private int f9417c = -1;

    /* renamed from: d */
    private C1465aj f9418d;

    public C1468am(C1450m c1450m) {
        this.f9416b = 0;
        this.f9415a = -1;
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for GeneralSubtree.");
        }
        this.f9418d = new C1465aj(c1450m.f9356b.m11371d(), true);
        while (c1450m.f9356b.m11362a() != 0) {
            C1450m m11371d = c1450m.f9356b.m11371d();
            if (m11371d.m11420b((byte) 0) && !m11371d.m11437r()) {
                m11371d.m11422c((byte) 2);
                this.f9416b = m11371d.m11430k();
            } else if (m11371d.m11420b((byte) 1) && !m11371d.m11437r()) {
                m11371d.m11422c((byte) 2);
                this.f9415a = m11371d.m11430k();
            } else {
                throw new IOException("Invalid encoding of GeneralSubtree.");
            }
        }
    }

    public String toString() {
        String str;
        String str2 = "\n   GeneralSubtree: [\n    GeneralName: " + (this.f9418d == null ? "" : this.f9418d.toString()) + "\n    Minimum: " + this.f9416b;
        if (this.f9415a == -1) {
            str = String.valueOf(str2) + "\t    Maximum: undefined";
        } else {
            str = String.valueOf(str2) + "\t    Maximum: " + this.f9415a;
        }
        return String.valueOf(str) + "    ]\n";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1468am)) {
            return false;
        }
        C1468am c1468am = (C1468am) obj;
        if (this.f9418d == null) {
            if (c1468am.f9418d != null) {
                return false;
            }
        } else if (!this.f9418d.equals(c1468am.f9418d)) {
            return false;
        }
        return this.f9416b == c1468am.f9416b && this.f9415a == c1468am.f9415a;
    }

    public int hashCode() {
        if (this.f9417c == -1) {
            this.f9417c = 17;
            if (this.f9418d != null) {
                this.f9417c = (this.f9417c * 37) + this.f9418d.hashCode();
            }
            if (this.f9416b != 0) {
                this.f9417c = (this.f9417c * 37) + this.f9416b;
            }
            if (this.f9415a != -1) {
                this.f9417c = (this.f9417c * 37) + this.f9415a;
            }
        }
        return this.f9417c;
    }

    /* renamed from: a */
    public void m11499a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        this.f9418d.m11493a(c1449l2);
        if (this.f9416b != 0) {
            C1449l c1449l3 = new C1449l();
            c1449l3.m11401b(this.f9416b);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 0), c1449l3);
        }
        if (this.f9415a != -1) {
            C1449l c1449l4 = new C1449l();
            c1449l4.m11401b(this.f9415a);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 1), c1449l4);
        }
        c1449l.m11388a((byte) 48, c1449l2);
    }
}
