package p165d.p167b.p173f;

import java.p209io.IOException;
import java.util.Arrays;
import p165d.p167b.p172e.C1440c;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: DistributionPoint.java */
/* renamed from: d.b.f.ad */
/* loaded from: classes.dex */
public class C1459ad {

    /* renamed from: a */
    private static final String[] f9386a;

    /* renamed from: b */
    private C1467al f9387b;

    /* renamed from: c */
    private C1467al f9388c;

    /* renamed from: d */
    private volatile int f9389d;

    /* renamed from: e */
    private boolean[] f9390e;

    /* renamed from: f */
    private C1487be f9391f;

    static {
        String[] strArr = new String[9];
        strArr[1] = "key compromise";
        strArr[2] = "CA compromise";
        strArr[3] = "affiliation changed";
        strArr[4] = "superseded";
        strArr[5] = "cessation of operation";
        strArr[6] = "certificate hold";
        strArr[7] = "privilege withdrawn";
        strArr[8] = "AA compromise";
        f9386a = strArr;
    }

    public C1459ad(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding of DistributionPoint.");
        }
        while (c1450m.f9356b != null && c1450m.f9356b.m11362a() != 0) {
            C1450m m11371d = c1450m.f9356b.m11371d();
            if (m11371d.m11420b((byte) 0) && m11371d.m11437r()) {
                if (this.f9388c != null || this.f9391f != null) {
                    throw new IOException("Duplicate DistributionPointName in DistributionPoint.");
                }
                C1450m m11371d2 = m11371d.f9356b.m11371d();
                if (m11371d2.m11420b((byte) 0) && m11371d2.m11437r()) {
                    m11371d2.m11422c((byte) 48);
                    this.f9388c = new C1467al(m11371d2);
                } else if (m11371d2.m11420b((byte) 1) && m11371d2.m11437r()) {
                    m11371d2.m11422c((byte) 49);
                    this.f9391f = new C1487be(m11371d2);
                } else {
                    throw new IOException("Invalid DistributionPointName in DistributionPoint");
                }
            } else if (m11371d.m11420b((byte) 1) && !m11371d.m11437r()) {
                if (this.f9390e != null) {
                    throw new IOException("Duplicate Reasons in DistributionPoint.");
                }
                m11371d.m11422c((byte) 3);
                this.f9390e = m11371d.m11436q().m11322b();
            } else if (m11371d.m11420b((byte) 2) && m11371d.m11437r()) {
                if (this.f9387b != null) {
                    throw new IOException("Duplicate CRLIssuer in DistributionPoint.");
                }
                m11371d.m11422c((byte) 48);
                this.f9387b = new C1467al(m11371d);
            } else {
                throw new IOException("Invalid encoding of DistributionPoint.");
            }
        }
        if (this.f9387b == null && this.f9388c == null && this.f9391f == null) {
            throw new IOException("One of fullName, relativeName,  and crlIssuer has to be set");
        }
    }

    /* renamed from: a */
    public void m11483a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        if (this.f9388c != null || this.f9391f != null) {
            C1449l c1449l3 = new C1449l();
            if (this.f9388c != null) {
                C1449l c1449l4 = new C1449l();
                this.f9388c.m11496a(c1449l4);
                c1449l3.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l4);
            } else if (this.f9391f != null) {
                C1449l c1449l5 = new C1449l();
                this.f9391f.m11537a(c1449l5);
                c1449l3.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 1), c1449l5);
            }
            c1449l2.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l3);
        }
        if (this.f9390e != null) {
            C1449l c1449l6 = new C1449l();
            c1449l6.m11392a(new C1440c(this.f9390e));
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 1), c1449l6);
        }
        if (this.f9387b != null) {
            C1449l c1449l7 = new C1449l();
            this.f9387b.m11496a(c1449l7);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 2), c1449l7);
        }
        c1449l.m11388a((byte) 48, c1449l2);
    }

    /* renamed from: a */
    private static boolean m11482a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1459ad)) {
            return false;
        }
        C1459ad c1459ad = (C1459ad) obj;
        return m11482a(this.f9388c, c1459ad.f9388c) && m11482a(this.f9391f, c1459ad.f9391f) && m11482a(this.f9387b, c1459ad.f9387b) && Arrays.equals(this.f9390e, c1459ad.f9390e);
    }

    public int hashCode() {
        int i = this.f9389d;
        if (i == 0) {
            int i2 = 1;
            if (this.f9388c != null) {
                i2 = this.f9388c.hashCode() + 1;
            }
            if (this.f9391f != null) {
                i2 += this.f9391f.hashCode();
            }
            if (this.f9387b != null) {
                i2 += this.f9387b.hashCode();
            }
            if (this.f9390e != null) {
                i = i2;
                for (int i3 = 0; i3 < this.f9390e.length; i3++) {
                    if (this.f9390e[i3]) {
                        i += i3;
                    }
                }
            } else {
                i = i2;
            }
            this.f9389d = i;
        }
        return i;
    }

    /* renamed from: a */
    private static String m11481a(int i) {
        return (i <= 0 || i >= f9386a.length) ? "Unknown reason " + i : f9386a[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f9388c != null) {
            sb.append("DistributionPoint:\n     " + this.f9388c + "\n");
        }
        if (this.f9391f != null) {
            sb.append("DistributionPoint:\n     " + this.f9391f + "\n");
        }
        if (this.f9390e != null) {
            sb.append("   ReasonFlags:\n");
            for (int i = 0; i < this.f9390e.length; i++) {
                if (this.f9390e[i]) {
                    sb.append("    " + m11481a(i) + "\n");
                }
            }
        }
        if (this.f9387b != null) {
            sb.append("   CRLIssuer:" + this.f9387b + "\n");
        }
        return sb.toString();
    }
}
