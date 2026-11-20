package jadx.core.p183c.p197g.p198a.p199a;

import jadx.core.p183c.p191d.C1628a;

/* compiled from: BlocksPair.java */
/* renamed from: jadx.core.c.g.a.a.a */
/* loaded from: classes.dex */
public final class C1671a {

    /* renamed from: a */
    private final C1628a f10478a;

    /* renamed from: b */
    private final C1628a f10479b;

    public C1671a(C1628a c1628a, C1628a c1628a2) {
        this.f10478a = c1628a;
        this.f10479b = c1628a2;
    }

    /* renamed from: a */
    public C1628a m12786a() {
        return this.f10478a;
    }

    /* renamed from: b */
    public C1628a m12787b() {
        return this.f10479b;
    }

    public int hashCode() {
        return (this.f10478a.hashCode() * 31) + this.f10479b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1671a)) {
            return false;
        }
        C1671a c1671a = (C1671a) obj;
        return this.f10478a.equals(c1671a.f10478a) && this.f10479b.equals(c1671a.f10479b);
    }

    public String toString() {
        return "(" + this.f10478a + ", " + this.f10479b + ")";
    }
}
