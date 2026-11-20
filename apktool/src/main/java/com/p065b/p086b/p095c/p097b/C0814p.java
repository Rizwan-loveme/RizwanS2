package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;

/* compiled from: LocalEnd.java */
/* renamed from: com.b.b.c.b.p */
/* loaded from: classes.dex */
public final class C0814p extends AbstractC0799ae {

    /* renamed from: a */
    private final C0934p f5064a;

    public C0814p(C0940v c0940v, C0934p c0934p) {
        super(c0940v);
        if (c0934p == null) {
            throw new NullPointerException("local == null");
        }
        this.f5064a = c0934p;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0799ae, com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: d */
    public AbstractC0807i mo6995d(int i) {
        return new C0814p(m7042i(), this.f5064a.m7930c(i));
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0814p(m7042i(), this.f5064a);
    }

    /* renamed from: c */
    public C0934p m7098c() {
        return this.f5064a;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        return this.f5064a.toString();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    protected String mo6966a(boolean z) {
        return "local-end " + C0817s.m7125a(this.f5064a);
    }
}
