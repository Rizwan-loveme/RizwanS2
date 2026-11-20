package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;

/* compiled from: ThrowingCstInsn.java */
/* renamed from: com.b.b.f.b.x */
/* loaded from: classes.dex */
public final class C0942x extends AbstractC0922d {

    /* renamed from: a */
    private final InterfaceC0977e f6133a;

    public C0942x(C0937s c0937s, C0940v c0940v, C0935q c0935q, InterfaceC0977e interfaceC0977e, AbstractC0945a abstractC0945a) {
        super(c0937s, c0940v, null, c0935q, abstractC0945a);
        if (c0937s.m7971d() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (interfaceC0977e == null) {
            throw new NullPointerException("catches == null");
        }
        this.f6133a = interfaceC0977e;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0922d, com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public String mo7866a() {
        AbstractC0945a i_ = m7868i_();
        return (i_ instanceof C0970x ? ((C0970x) i_).m8083i() : i_.mo6681d()) + " " + C0943y.m8032a(this.f6133a);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: b */
    public InterfaceC0977e mo7876b() {
        return this.f6133a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public void mo7875a(AbstractC0926h.b bVar) {
        bVar.mo7180a(this);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7874a(C0975c c0975c) {
        return new C0942x(m7882f(), m7883g(), m7886j(), this.f6133a.mo6854a(c0975c), m7868i_());
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7873a(C0934p c0934p, C0935q c0935q) {
        return new C0942x(m7882f(), m7883g(), c0935q, this.f6133a, m7868i_());
    }
}
