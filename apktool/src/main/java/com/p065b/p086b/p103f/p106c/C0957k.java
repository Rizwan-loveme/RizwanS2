package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;

/* compiled from: CstFieldRef.java */
/* renamed from: com.b.b.f.c.k */
/* loaded from: classes.dex */
public final class C0957k extends AbstractC0966t {
    /* renamed from: a */
    public static C0957k m8058a(C0975c c0975c) {
        return new C0957k(C0971y.m8088a(c0975c), C0968v.f6165a);
    }

    public C0957k(C0971y c0971y, C0968v c0968v) {
        super(c0971y, c0968v);
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "field";
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return m8071n().m8074c();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0966t, com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        int mo8034b = super.mo8034b(abstractC0945a);
        return mo8034b != 0 ? mo8034b : m8071n().m8073b().compareTo(((C0957k) abstractC0945a).m8071n().m8073b());
    }
}
