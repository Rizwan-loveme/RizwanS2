package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;

/* compiled from: LocalStart.java */
/* renamed from: com.b.b.c.b.s */
/* loaded from: classes.dex */
public final class C0817s extends AbstractC0799ae {

    /* renamed from: a */
    private final C0934p f5083a;

    /* renamed from: a */
    public static String m7125a(C0934p c0934p) {
        return c0934p.m7937m() + ' ' + c0934p.m7933i().toString() + ": " + c0934p.m7932h().mo6681d();
    }

    public C0817s(C0940v c0940v, C0934p c0934p) {
        super(c0940v);
        if (c0934p == null) {
            throw new NullPointerException("local == null");
        }
        this.f5083a = c0934p;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0799ae, com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: d */
    public AbstractC0807i mo6995d(int i) {
        return new C0817s(m7042i(), this.f5083a.m7930c(i));
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0817s(m7042i(), this.f5083a);
    }

    /* renamed from: c */
    public C0934p m7126c() {
        return this.f5083a;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        return this.f5083a.toString();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    protected String mo6966a(boolean z) {
        return "local-start " + m7125a(this.f5083a);
    }
}
