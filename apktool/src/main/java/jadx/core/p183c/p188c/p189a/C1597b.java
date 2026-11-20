package jadx.core.p183c.p188c.p189a;

import jadx.core.p183c.p187b.C1592d;

/* compiled from: FieldArg.java */
/* renamed from: jadx.core.c.c.a.b */
/* loaded from: classes.dex */
public final class C1597b extends C1604i {

    /* renamed from: c */
    private final C1592d f10155c;

    /* renamed from: e */
    private final AbstractC1598c f10156e;

    public C1597b(C1592d c1592d, AbstractC1598c abstractC1598c) {
        super(-1);
        this.f10156e = abstractC1598c;
        this.f10155c = c1592d;
    }

    /* renamed from: d */
    public C1592d m12294d() {
        return this.f10155c;
    }

    /* renamed from: e */
    public AbstractC1598c m12295e() {
        return this.f10156e;
    }

    /* renamed from: f */
    public boolean m12296f() {
        return this.f10156e == null;
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: g */
    public boolean mo12297g() {
        return true;
    }

    @Override // jadx.core.p183c.p188c.p189a.C1604i, jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: h */
    public boolean mo12298h() {
        return false;
    }

    @Override // jadx.core.p183c.p188c.p189a.C1604i, jadx.core.p183c.p188c.p189a.AbstractC1607l
    /* renamed from: a */
    public void mo12293a(AbstractC1596a abstractC1596a) {
        this.f10191d = abstractC1596a;
    }

    @Override // jadx.core.p183c.p188c.p189a.C1604i
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1597b) || !super.equals(obj)) {
            return false;
        }
        C1597b c1597b = (C1597b) obj;
        if (this.f10155c.equals(c1597b.f10155c)) {
            return this.f10156e != null ? this.f10156e.equals(c1597b.f10156e) : c1597b.f10156e == null;
        }
        return false;
    }

    @Override // jadx.core.p183c.p188c.p189a.C1604i
    public int hashCode() {
        return (this.f10156e != null ? this.f10156e.hashCode() : 0) + (((super.hashCode() * 31) + this.f10155c.hashCode()) * 31);
    }

    @Override // jadx.core.p183c.p188c.p189a.C1604i
    public String toString() {
        return "(" + this.f10155c + ")";
    }
}
