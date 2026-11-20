package p165d.p167b.p173f;

import java.math.BigInteger;
import java.p209io.IOException;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: SerialNumber.java */
/* renamed from: d.b.f.bh */
/* loaded from: classes.dex */
public class C1490bh {

    /* renamed from: a */
    private BigInteger f9521a;

    /* renamed from: a */
    private void m11542a(C1450m c1450m) {
        this.f9521a = c1450m.m11421c();
        if (c1450m.f9356b.m11362a() != 0) {
            throw new IOException("Excess SerialNumber data");
        }
    }

    public C1490bh(int i) {
        this.f9521a = BigInteger.valueOf(i);
    }

    public C1490bh(C1450m c1450m) {
        m11542a(c1450m);
    }

    public String toString() {
        return "SerialNumber: [" + C1444g.m11329a(this.f9521a) + "]";
    }

    /* renamed from: a */
    public void m11544a(C1449l c1449l) {
        c1449l.m11396a(this.f9521a);
    }

    /* renamed from: a */
    public BigInteger m11543a() {
        return this.f9521a;
    }
}
