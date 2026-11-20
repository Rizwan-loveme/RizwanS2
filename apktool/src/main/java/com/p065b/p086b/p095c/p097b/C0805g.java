package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;

/* compiled from: CstInsn.java */
/* renamed from: com.b.b.c.b.g */
/* loaded from: classes.dex */
public final class C0805g extends AbstractC0811m {

    /* renamed from: a */
    private final AbstractC0945a f4783a;

    /* renamed from: b */
    private int f4784b;

    /* renamed from: c */
    private int f4785c;

    public C0805g(C0809k c0809k, C0940v c0940v, C0935q c0935q, AbstractC0945a abstractC0945a) {
        super(c0809k, c0940v, c0935q);
        if (abstractC0945a == null) {
            throw new NullPointerException("constant == null");
        }
        this.f4783a = abstractC0945a;
        this.f4784b = -1;
        this.f4785c = -1;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6990a(C0809k c0809k) {
        C0805g c0805g = new C0805g(c0809k, m7042i(), m7043j(), this.f4783a);
        if (this.f4784b >= 0) {
            c0805g.m7016a(this.f4784b);
        }
        if (this.f4785c >= 0) {
            c0805g.m7017b(this.f4785c);
        }
        return c0805g;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        C0805g c0805g = new C0805g(m7041h(), m7042i(), c0935q, this.f4783a);
        if (this.f4784b >= 0) {
            c0805g.m7016a(this.f4784b);
        }
        if (this.f4785c >= 0) {
            c0805g.m7017b(this.f4785c);
        }
        return c0805g;
    }

    /* renamed from: c */
    public AbstractC0945a m7018c() {
        return this.f4783a;
    }

    /* renamed from: d */
    public int m7019d() {
        if (this.f4784b < 0) {
            throw new RuntimeException("index not yet set for " + this.f4783a);
        }
        return this.f4784b;
    }

    /* renamed from: e */
    public boolean m7020e() {
        return this.f4784b >= 0;
    }

    /* renamed from: a */
    public void m7016a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (this.f4784b >= 0) {
            throw new RuntimeException("index already set");
        }
        this.f4784b = i;
    }

    /* renamed from: b */
    public void m7017b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (this.f4785c >= 0) {
            throw new RuntimeException("class index already set");
        }
        this.f4785c = i;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        return this.f4783a.mo6681d();
    }
}
