package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0973a;
import com.p065b.p086b.p103f.p107d.C0975c;

/* compiled from: CstBaseMethodRef.java */
/* renamed from: com.b.b.f.c.e */
/* loaded from: classes.dex */
public abstract class AbstractC0951e extends AbstractC0966t {

    /* renamed from: a */
    private final C0973a f6137a;

    /* renamed from: b */
    private C0973a f6138b;

    AbstractC0951e(C0971y c0971y, C0968v c0968v) {
        super(c0971y, c0968v);
        this.f6137a = C0973a.m8096a(m8071n().m8073b().m8084j());
        this.f6138b = null;
    }

    /* renamed from: i */
    public final C0973a m8047i() {
        return this.f6137a;
    }

    /* renamed from: a */
    public final C0973a m8045a(boolean z) {
        if (z) {
            return this.f6137a;
        }
        if (this.f6138b == null) {
            this.f6138b = this.f6137a.m8101a(m8070m().m8090i());
        }
        return this.f6138b;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0966t, com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected final int mo8034b(AbstractC0945a abstractC0945a) {
        int mo8034b = super.mo8034b(abstractC0945a);
        if (mo8034b == 0) {
            return this.f6137a.compareTo(((AbstractC0951e) abstractC0945a).f6137a);
        }
        return mo8034b;
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public final C0975c mo6695a() {
        return this.f6137a.m8103b();
    }

    /* renamed from: b */
    public final int m8046b(boolean z) {
        return m8045a(z).m8104c().m8117e();
    }

    /* renamed from: j */
    public final boolean m8048j() {
        return m8071n().m8075e();
    }

    /* renamed from: k */
    public final boolean m8049k() {
        return m8071n().m8076f();
    }
}
