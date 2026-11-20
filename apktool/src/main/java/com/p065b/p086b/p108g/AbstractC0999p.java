package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;

/* compiled from: RegisterMapper.java */
/* renamed from: com.b.b.g.p */
/* loaded from: classes.dex */
public abstract class AbstractC0999p {
    /* renamed from: a */
    public abstract int mo8139a();

    /* renamed from: a */
    public abstract C0934p mo8141a(C0934p c0934p);

    /* renamed from: a */
    public final C0935q m8316a(C0935q c0935q) {
        int f_ = c0935q.m8550f_();
        C0935q c0935q2 = new C0935q(f_);
        for (int i = 0; i < f_; i++) {
            c0935q2.m7948a(i, mo8141a(c0935q.m7949b(i)));
        }
        c0935q2.mo6683e_();
        return c0935q2.equals(c0935q) ? c0935q : c0935q2;
    }
}
