package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0920b;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p105b.C0940v;

/* compiled from: BlockAddresses.java */
/* renamed from: com.b.b.c.b.b */
/* loaded from: classes.dex */
public final class C0800b {

    /* renamed from: a */
    private final C0804f[] f4773a;

    /* renamed from: b */
    private final C0804f[] f4774b;

    /* renamed from: c */
    private final C0804f[] f4775c;

    public C0800b(C0938t c0938t) {
        int j = c0938t.m7977a().m8587j();
        this.f4773a = new C0804f[j];
        this.f4774b = new C0804f[j];
        this.f4775c = new C0804f[j];
        m6996a(c0938t);
    }

    /* renamed from: a */
    public C0804f m6998a(C0920b c0920b) {
        return this.f4773a[c0920b.mo6568a()];
    }

    /* renamed from: a */
    public C0804f m6997a(int i) {
        return this.f4773a[i];
    }

    /* renamed from: b */
    public C0804f m6999b(C0920b c0920b) {
        return this.f4774b[c0920b.mo6568a()];
    }

    /* renamed from: c */
    public C0804f m7000c(C0920b c0920b) {
        return this.f4775c[c0920b.mo6568a()];
    }

    /* renamed from: a */
    private void m6996a(C0938t c0938t) {
        C0921c m7977a = c0938t.m7977a();
        int f_ = m7977a.m8550f_();
        for (int i = 0; i < f_; i++) {
            C0920b m7854a = m7977a.m7854a(i);
            int mo6568a = m7854a.mo6568a();
            this.f4773a[mo6568a] = new C0804f(m7854a.m7846b().m7889a(0).m7883g());
            C0940v m7883g = m7854a.m7851g().m7883g();
            this.f4774b[mo6568a] = new C0804f(m7883g);
            this.f4775c[mo6568a] = new C0804f(m7883g);
        }
    }
}
