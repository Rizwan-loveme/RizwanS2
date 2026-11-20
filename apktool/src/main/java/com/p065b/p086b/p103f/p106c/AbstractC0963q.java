package com.p065b.p086b.p103f.p106c;

/* compiled from: CstLiteral64.java */
/* renamed from: com.b.b.f.c.q */
/* loaded from: classes.dex */
public abstract class AbstractC0963q extends AbstractC0964r {

    /* renamed from: a */
    private final long f6160a;

    AbstractC0963q(long j) {
        this.f6160a = j;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f6160a == ((AbstractC0963q) obj).f6160a;
    }

    public final int hashCode() {
        return ((int) this.f6160a) ^ ((int) (this.f6160a >> 32));
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        long j = ((AbstractC0963q) abstractC0945a).f6160a;
        if (this.f6160a < j) {
            return -1;
        }
        if (this.f6160a > j) {
            return 1;
        }
        return 0;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public final boolean mo8035g() {
        return true;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0964r
    /* renamed from: i */
    public final boolean mo8063i() {
        return ((long) ((int) this.f6160a)) == this.f6160a;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0964r
    /* renamed from: j */
    public final int mo8064j() {
        return (int) this.f6160a;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0964r
    /* renamed from: k */
    public final long mo8065k() {
        return this.f6160a;
    }
}
