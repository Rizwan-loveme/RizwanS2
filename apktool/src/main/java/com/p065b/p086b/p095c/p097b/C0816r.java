package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0936r;
import com.p065b.p086b.p103f.p105b.C0940v;

/* compiled from: LocalSnapshot.java */
/* renamed from: com.b.b.c.b.r */
/* loaded from: classes.dex */
public final class C0816r extends AbstractC0799ae {

    /* renamed from: a */
    private final C0936r f5082a;

    public C0816r(C0940v c0940v, C0936r c0936r) {
        super(c0940v);
        if (c0936r == null) {
            throw new NullPointerException("locals == null");
        }
        this.f5082a = c0936r;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0799ae, com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: d */
    public AbstractC0807i mo6995d(int i) {
        return new C0816r(m7042i(), this.f5082a.m7963b(i));
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0816r(m7042i(), this.f5082a);
    }

    /* renamed from: c */
    public C0936r m7124c() {
        return this.f5082a;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        return this.f5082a.toString();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    protected String mo6966a(boolean z) {
        int m7965d = this.f5082a.m7965d();
        int m7961b = this.f5082a.m7961b();
        StringBuffer stringBuffer = new StringBuffer((m7965d * 40) + 100);
        stringBuffer.append("local-snapshot");
        for (int i = 0; i < m7961b; i++) {
            C0934p m7956a = this.f5082a.m7956a(i);
            if (m7956a != null) {
                stringBuffer.append("\n  ");
                stringBuffer.append(C0817s.m7125a(m7956a));
            }
        }
        return stringBuffer.toString();
    }
}
