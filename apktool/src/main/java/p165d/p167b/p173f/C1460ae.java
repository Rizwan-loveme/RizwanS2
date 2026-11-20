package p165d.p167b.p173f;

import java.io.IOException;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: DistributionPointName.java */
/* renamed from: d.b.f.ae */
/* loaded from: classes.dex */
public class C1460ae {

    /* renamed from: a */
    private C1467al f9392a;

    /* renamed from: b */
    private volatile int f9393b;

    /* renamed from: c */
    private C1487be f9394c;

    public C1460ae(C1450m c1450m) {
        this.f9392a = null;
        this.f9394c = null;
        if (c1450m.m11420b((byte) 0) && c1450m.m11437r()) {
            c1450m.m11422c((byte) 48);
            this.f9392a = new C1467al(c1450m);
        } else {
            if (c1450m.m11420b((byte) 1) && c1450m.m11437r()) {
                c1450m.m11422c((byte) 49);
                this.f9394c = new C1487be(c1450m);
                return;
            }
            throw new IOException("Invalid encoding for DistributionPointName");
        }
    }

    /* renamed from: a */
    public void m11485a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        if (this.f9392a != null) {
            this.f9392a.m11496a(c1449l2);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l2);
        } else {
            this.f9394c.m11537a(c1449l2);
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 1), c1449l2);
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof C1460ae)) {
                return false;
            }
            C1460ae c1460ae = (C1460ae) obj;
            if (!m11484a(this.f9392a, c1460ae.f9392a) || !m11484a(this.f9394c, c1460ae.f9394c)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f9393b;
        if (i == 0) {
            if (this.f9392a != null) {
                i = this.f9392a.hashCode() + 1;
            } else {
                i = this.f9394c.hashCode() + 1;
            }
            this.f9393b = i;
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f9392a != null) {
            sb.append("DistributionPointName:\n     " + this.f9392a + "\n");
        } else {
            sb.append("DistributionPointName:\n     " + this.f9394c + "\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m11484a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
