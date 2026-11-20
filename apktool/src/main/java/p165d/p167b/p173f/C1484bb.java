package p165d.p167b.p173f;

import java.io.IOException;
import java.security.cert.PolicyQualifierInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: PolicyInformation.java */
/* renamed from: d.b.f.bb */
/* loaded from: classes.dex */
public class C1484bb {

    /* renamed from: a */
    private C1520t f9511a;

    /* renamed from: b */
    private Set<PolicyQualifierInfo> f9512b;

    public C1484bb(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding of PolicyInformation");
        }
        this.f9511a = new C1520t(c1450m.f9356b.m11371d());
        if (c1450m.f9356b.m11362a() != 0) {
            this.f9512b = new LinkedHashSet();
            C1450m m11371d = c1450m.f9356b.m11371d();
            if (m11371d.f9357c != 48) {
                throw new IOException("Invalid encoding of PolicyInformation");
            }
            if (m11371d.f9356b.m11362a() == 0) {
                throw new IOException("No data available in policyQualifiers");
            }
            while (m11371d.f9356b.m11362a() != 0) {
                this.f9512b.add(new PolicyQualifierInfo(m11371d.f9356b.m11371d().m11440u()));
            }
            return;
        }
        this.f9512b = Collections.emptySet();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1484bb)) {
            return false;
        }
        C1484bb c1484bb = (C1484bb) obj;
        if (this.f9511a.equals(c1484bb.m11529a())) {
            return this.f9512b.equals(c1484bb.m11531b());
        }
        return false;
    }

    public int hashCode() {
        return ((this.f9511a.hashCode() + 37) * 37) + this.f9512b.hashCode();
    }

    /* renamed from: a */
    public C1520t m11529a() {
        return this.f9511a;
    }

    /* renamed from: b */
    public Set<PolicyQualifierInfo> m11531b() {
        return this.f9512b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("  [" + this.f9511a.toString());
        sb.append(this.f9512b + "  ]\n");
        return sb.toString();
    }

    /* renamed from: a */
    public void m11530a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        this.f9511a.m11681a(c1449l2);
        if (!this.f9512b.isEmpty()) {
            C1449l c1449l3 = new C1449l();
            Iterator<PolicyQualifierInfo> it = this.f9512b.iterator();
            while (it.hasNext()) {
                c1449l3.write(it.next().getEncoded());
            }
            c1449l2.m11388a((byte) 48, c1449l3);
        }
        c1449l.m11388a((byte) 48, c1449l2);
    }
}
