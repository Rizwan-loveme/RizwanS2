package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p110h.C1012c;
import com.p065b.p086b.p110h.C1025p;

/* compiled from: LocalVariableExtractor.java */
/* renamed from: com.b.b.f.b.k */
/* loaded from: classes.dex */
public final class C0929k {

    /* renamed from: a */
    private final C0938t f5890a;

    /* renamed from: b */
    private final C0921c f5891b;

    /* renamed from: c */
    private final C0930l f5892c;

    /* renamed from: d */
    private final int[] f5893d;

    /* renamed from: a */
    public static C0930l m7900a(C0938t c0938t) {
        return new C0929k(c0938t).m7899a();
    }

    private C0929k(C0938t c0938t) {
        if (c0938t == null) {
            throw new NullPointerException("method == null");
        }
        C0921c m7977a = c0938t.m7977a();
        int j = m7977a.m8587j();
        this.f5890a = c0938t;
        this.f5891b = m7977a;
        this.f5892c = new C0930l(c0938t);
        this.f5893d = C1012c.m8489a(j);
    }

    /* renamed from: a */
    private C0930l m7899a() {
        int m7979b = this.f5890a.m7979b();
        while (m7979b >= 0) {
            C1012c.m8493c(this.f5893d, m7979b);
            m7901a(m7979b);
            m7979b = C1012c.m8494d(this.f5893d, 0);
        }
        this.f5892c.mo6683e_();
        return this.f5892c;
    }

    /* renamed from: a */
    private void m7901a(int i) {
        C0936r m7909b = this.f5892c.m7909b(i);
        C0920b m7858b = this.f5891b.m7858b(i);
        C0927i m7846b = m7858b.m7846b();
        int f_ = m7846b.m8550f_();
        boolean z = m7858b.m7853i() && m7846b.m7893e().m7884h() != null;
        int i2 = f_ - 1;
        C0936r c0936r = m7909b;
        for (int i3 = 0; i3 < f_; i3++) {
            if (z && i3 == i2) {
                c0936r.mo6683e_();
                c0936r = c0936r.m7967e();
            }
            AbstractC0926h m7889a = m7846b.m7889a(i3);
            C0934p m7885i = m7889a.m7885i();
            if (m7885i == null) {
                C0934p m7884h = m7889a.m7884h();
                if (m7884h != null && c0936r.m7956a(m7884h.m7931g()) != null) {
                    c0936r.m7964c(c0936r.m7956a(m7884h.m7931g()));
                }
            } else {
                C0934p m7938n = m7885i.m7938n();
                if (!m7938n.equals(c0936r.m7958a(m7938n))) {
                    C0934p m7957a = c0936r.m7957a(m7938n.m7933i());
                    if (m7957a != null && m7957a.m7931g() != m7938n.m7931g()) {
                        c0936r.m7964c(m7957a);
                    }
                    this.f5892c.m7907a(m7889a, m7938n);
                    c0936r.m7966d(m7938n);
                }
            }
        }
        c0936r.mo6683e_();
        C1025p m7847c = m7858b.m7847c();
        int m8568b = m7847c.m8568b();
        int m7848d = m7858b.m7848d();
        for (int i4 = 0; i4 < m8568b; i4++) {
            int m8569b = m7847c.m8569b(i4);
            if (this.f5892c.m7910b(m8569b, m8569b == m7848d ? c0936r : m7909b)) {
                C1012c.m8490b(this.f5893d, m8569b);
            }
        }
    }
}
