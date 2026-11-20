package com.p065b.p086b.p103f.p106c;

/* compiled from: CstMemberRef.java */
/* renamed from: com.b.b.f.c.t */
/* loaded from: classes.dex */
public abstract class AbstractC0966t extends AbstractC0946aa {

    /* renamed from: a */
    private final C0971y f6163a;

    /* renamed from: b */
    private final C0968v f6164b;

    AbstractC0966t(C0971y c0971y, C0968v c0968v) {
        if (c0971y == null) {
            throw new NullPointerException("definingClass == null");
        }
        if (c0968v == null) {
            throw new NullPointerException("nat == null");
        }
        this.f6163a = c0971y;
        this.f6164b = c0968v;
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC0966t abstractC0966t = (AbstractC0966t) obj;
        return this.f6163a.equals(abstractC0966t.f6163a) && this.f6164b.equals(abstractC0966t.f6164b);
    }

    public final int hashCode() {
        return (this.f6163a.hashCode() * 31) ^ this.f6164b.hashCode();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        AbstractC0966t abstractC0966t = (AbstractC0966t) abstractC0945a;
        int a2 = this.f6163a.compareTo(abstractC0966t.f6163a);
        return a2 != 0 ? a2 : this.f6164b.m8072a().compareTo(abstractC0966t.f6164b.m8072a());
    }

    public final String toString() {
        return mo8036h() + '{' + mo6681d() + '}';
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public final boolean mo8035g() {
        return false;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public final String mo6681d() {
        return this.f6163a.mo6681d() + '.' + this.f6164b.mo6681d();
    }

    /* renamed from: m */
    public final C0971y m8070m() {
        return this.f6163a;
    }

    /* renamed from: n */
    public final C0968v m8071n() {
        return this.f6164b;
    }
}
