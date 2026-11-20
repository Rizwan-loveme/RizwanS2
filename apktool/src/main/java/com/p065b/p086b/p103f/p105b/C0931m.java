package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;

/* compiled from: PlainCstInsn.java */
/* renamed from: com.b.b.f.b.m */
/* loaded from: classes.dex */
public final class C0931m extends AbstractC0922d {
    public C0931m(C0937s c0937s, C0940v c0940v, C0934p c0934p, C0935q c0935q, AbstractC0945a abstractC0945a) {
        super(c0937s, c0940v, c0934p, c0935q, abstractC0945a);
        if (c0937s.m7971d() != 1) {
            throw new IllegalArgumentException("bogus branchingness");
        }
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: b */
    public InterfaceC0977e mo7876b() {
        return C0974b.f6209a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public void mo7875a(AbstractC0926h.b bVar) {
        bVar.mo7176a(this);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7874a(C0975c c0975c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7873a(C0934p c0934p, C0935q c0935q) {
        return new C0931m(m7882f(), m7883g(), c0934p, c0935q, m7868i_());
    }
}
