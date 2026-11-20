package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;

/* compiled from: TargetInsn.java */
/* renamed from: com.b.b.c.b.ac */
/* loaded from: classes.dex */
public final class C0797ac extends AbstractC0811m {

    /* renamed from: a */
    private C0804f f4772a;

    public C0797ac(C0809k c0809k, C0940v c0940v, C0935q c0935q, C0804f c0804f) {
        super(c0809k, c0940v, c0935q);
        if (c0804f == null) {
            throw new NullPointerException("target == null");
        }
        this.f4772a = c0804f;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6990a(C0809k c0809k) {
        return new C0797ac(c0809k, m7042i(), m7043j(), this.f4772a);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0797ac(m7041h(), m7042i(), c0935q, this.f4772a);
    }

    /* renamed from: a */
    public C0797ac m6989a(C0804f c0804f) {
        return new C0797ac(m7041h().m7062g(), m7042i(), m7043j(), c0804f);
    }

    /* renamed from: c */
    public C0804f m6991c() {
        return this.f4772a;
    }

    /* renamed from: d */
    public int m6992d() {
        return this.f4772a.m7040g();
    }

    /* renamed from: e */
    public int m6993e() {
        return this.f4772a.m7040g() - m7040g();
    }

    /* renamed from: o */
    public boolean m6994o() {
        return m7039f() && this.f4772a.m7039f();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        return this.f4772a == null ? "????" : this.f4772a.m7046m();
    }
}
