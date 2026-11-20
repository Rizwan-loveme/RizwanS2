package jadx.p180a;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1639e;

/* compiled from: JavaField.java */
/* renamed from: jadx.a.f */
/* loaded from: classes.dex */
public final class C1538f implements InterfaceC1540h {

    /* renamed from: a */
    private final C1639e f9877a;

    /* renamed from: b */
    private final C1537e f9878b;

    C1538f(C1639e c1639e, C1537e c1537e) {
        this.f9877a = c1639e;
        this.f9878b = c1537e;
    }

    @Override // jadx.p180a.InterfaceC1540h
    /* renamed from: c */
    public String mo11806c() {
        return this.f9877a.m12568i();
    }

    /* renamed from: a */
    public AbstractC1596a m11810a() {
        return this.f9877a.m12569j();
    }

    /* renamed from: b */
    public int m11811b() {
        return this.f9877a.m12123e();
    }

    public int hashCode() {
        return this.f9877a.hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof C1538f) && this.f9877a.equals(((C1538f) obj).f9877a));
    }

    public String toString() {
        return this.f9877a.toString();
    }
}
