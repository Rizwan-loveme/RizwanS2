package com.p065b.p086b.p108g.p109a;

import com.p065b.p086b.p103f.p105b.C0920b;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p110h.C1025p;
import java.util.BitSet;

/* compiled from: IdenticalBlockCombiner.java */
/* renamed from: com.b.b.g.a.b */
/* loaded from: classes.dex */
public class C0980b {

    /* renamed from: a */
    private final C0938t f6295a;

    /* renamed from: b */
    private final C0921c f6296b;

    /* renamed from: c */
    private final C0921c f6297c;

    public C0980b(C0938t c0938t) {
        this.f6295a = c0938t;
        this.f6296b = this.f6295a.m7977a();
        this.f6297c = this.f6296b.m7862h();
    }

    /* renamed from: a */
    public C0938t m8185a() {
        int f_ = this.f6296b.m8550f_();
        BitSet bitSet = new BitSet(this.f6296b.m8587j());
        for (int i = 0; i < f_; i++) {
            C0920b m7854a = this.f6296b.m7854a(i);
            if (!bitSet.get(m7854a.mo6568a())) {
                C1025p m7978a = this.f6295a.m7978a(m7854a.mo6568a());
                int m8568b = m7978a.m8568b();
                for (int i2 = 0; i2 < m8568b; i2++) {
                    int m8569b = m7978a.m8569b(i2);
                    C0920b m7858b = this.f6296b.m7858b(m8569b);
                    if (!bitSet.get(m8569b) && m7858b.m7847c().m8568b() <= 1 && m7858b.m7850f().m7882f().m7968a() != 55) {
                        C1025p c1025p = new C1025p();
                        for (int i3 = i2 + 1; i3 < m8568b; i3++) {
                            int m8569b2 = m7978a.m8569b(i3);
                            C0920b m7858b2 = this.f6296b.m7858b(m8569b2);
                            if (m7858b2.m7847c().m8568b() == 1 && m8184a(m7858b, m7858b2)) {
                                c1025p.m8571c(m8569b2);
                                bitSet.set(m8569b2);
                            }
                        }
                        m8182a(m8569b, c1025p);
                    }
                }
            }
        }
        for (int i4 = f_ - 1; i4 >= 0; i4--) {
            if (bitSet.get(this.f6297c.m7854a(i4).mo6568a())) {
                this.f6297c.m7856a(i4, (C0920b) null);
            }
        }
        this.f6297c.mo8551i();
        this.f6297c.mo6683e_();
        return new C0938t(this.f6297c, this.f6295a.m7979b());
    }

    /* renamed from: a */
    private static boolean m8184a(C0920b c0920b, C0920b c0920b2) {
        return c0920b.m7846b().m7892a(c0920b2.m7846b());
    }

    /* renamed from: a */
    private void m8182a(int i, C1025p c1025p) {
        int m8568b = c1025p.m8568b();
        for (int i2 = 0; i2 < m8568b; i2++) {
            int m8569b = c1025p.m8569b(i2);
            C1025p m7978a = this.f6295a.m7978a(this.f6296b.m7858b(m8569b).mo6568a());
            int m8568b2 = m7978a.m8568b();
            for (int i3 = 0; i3 < m8568b2; i3++) {
                m8183a(this.f6297c.m7858b(m7978a.m8569b(i3)), m8569b, i);
            }
        }
    }

    /* renamed from: a */
    private void m8183a(C0920b c0920b, int i, int i2) {
        C1025p m8578f = c0920b.m7847c().m8578f();
        m8578f.m8570b(m8578f.m8577f(i), i2);
        int m7848d = c0920b.m7848d();
        if (m7848d != i) {
            i2 = m7848d;
        }
        m8578f.mo6683e_();
        this.f6297c.m7856a(this.f6297c.m8586c(c0920b.mo6568a()), new C0920b(c0920b.mo6568a(), c0920b.m7846b(), m8578f, i2));
    }
}
