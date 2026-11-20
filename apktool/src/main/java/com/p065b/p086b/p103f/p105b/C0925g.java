package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import java.util.ArrayList;

/* compiled from: FillArrayDataInsn.java */
/* renamed from: com.b.b.f.b.g */
/* loaded from: classes.dex */
public final class C0925g extends AbstractC0926h {

    /* renamed from: a */
    private final ArrayList<AbstractC0945a> f5882a;

    /* renamed from: b */
    private final AbstractC0945a f5883b;

    public C0925g(C0937s c0937s, C0940v c0940v, C0935q c0935q, ArrayList<AbstractC0945a> arrayList, AbstractC0945a abstractC0945a) {
        super(c0937s, c0940v, null, c0935q);
        if (c0937s.m7971d() != 1) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        this.f5882a = arrayList;
        this.f5883b = abstractC0945a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: b */
    public InterfaceC0977e mo7876b() {
        return C0974b.f6209a;
    }

    /* renamed from: c */
    public ArrayList<AbstractC0945a> m7877c() {
        return this.f5882a;
    }

    /* renamed from: e */
    public AbstractC0945a m7878e() {
        return this.f5883b;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public void mo7875a(AbstractC0926h.b bVar) {
        bVar.mo7185a(this);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7874a(C0975c c0975c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7873a(C0934p c0934p, C0935q c0935q) {
        return new C0925g(m7882f(), m7883g(), c0935q, this.f5882a, this.f5883b);
    }
}
