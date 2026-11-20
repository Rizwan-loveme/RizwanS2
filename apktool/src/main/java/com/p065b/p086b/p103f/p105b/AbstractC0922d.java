package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;

/* compiled from: CstInsn.java */
/* renamed from: com.b.b.f.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC0922d extends AbstractC0926h {

    /* renamed from: a */
    private final AbstractC0945a f5862a;

    public AbstractC0922d(C0937s c0937s, C0940v c0940v, C0934p c0934p, C0935q c0935q, AbstractC0945a abstractC0945a) {
        super(c0937s, c0940v, c0934p, c0935q);
        if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
        this.f5862a = abstractC0945a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public String mo7866a() {
        return this.f5862a.mo6681d();
    }

    /* renamed from: i_ */
    public AbstractC0945a m7868i_() {
        return this.f5862a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public boolean mo7867a(AbstractC0926h abstractC0926h) {
        return super.mo7867a(abstractC0926h) && this.f5862a.equals(((AbstractC0922d) abstractC0926h).m7868i_());
    }
}
