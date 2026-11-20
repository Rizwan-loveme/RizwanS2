package com.p065b.p086b.p103f.p106c;

/* compiled from: CstLiteral32.java */
/* renamed from: com.b.b.f.c.p */
/* loaded from: classes.dex */
public abstract class AbstractC0962p extends AbstractC0964r {

    /* renamed from: a */
    private final int f6159a;

    AbstractC0962p(int i) {
        this.f6159a = i;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f6159a == ((AbstractC0962p) obj).f6159a;
    }

    public final int hashCode() {
        return this.f6159a;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        int i = ((AbstractC0962p) abstractC0945a).f6159a;
        if (this.f6159a < i) {
            return -1;
        }
        if (this.f6159a > i) {
            return 1;
        }
        return 0;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public final boolean mo8035g() {
        return false;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0964r
    /* renamed from: i */
    public final boolean mo8063i() {
        return true;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0964r
    /* renamed from: j */
    public final int mo8064j() {
        return this.f6159a;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0964r
    /* renamed from: k */
    public final long mo8065k() {
        return this.f6159a;
    }
}
