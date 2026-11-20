package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1025p;

/* compiled from: SwitchInsn.java */
/* renamed from: com.b.b.f.b.w */
/* loaded from: classes.dex */
public final class C0941w extends AbstractC0926h {

    /* renamed from: a */
    private final C1025p f6132a;

    public C0941w(C0937s c0937s, C0940v c0940v, C0934p c0934p, C0935q c0935q, C1025p c1025p) {
        super(c0937s, c0940v, c0934p, c0935q);
        if (c0937s.m7971d() != 5) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (c1025p == null) {
            throw new NullPointerException("cases == null");
        }
        this.f6132a = c1025p;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public String mo7866a() {
        return this.f6132a.toString();
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: b */
    public InterfaceC0977e mo7876b() {
        return C0974b.f6209a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public void mo7875a(AbstractC0926h.b bVar) {
        bVar.mo7179a(this);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7874a(C0975c c0975c) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public boolean mo7867a(AbstractC0926h abstractC0926h) {
        return false;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7873a(C0934p c0934p, C0935q c0935q) {
        return new C0941w(m7882f(), m7883g(), c0934p, c0935q, this.f6132a);
    }

    /* renamed from: c */
    public C1025p m8031c() {
        return this.f6132a;
    }
}
