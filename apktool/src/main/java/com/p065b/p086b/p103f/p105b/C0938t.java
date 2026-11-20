package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;

/* compiled from: RopMethod.java */
/* renamed from: com.b.b.f.b.t */
/* loaded from: classes.dex */
public final class C0938t {

    /* renamed from: a */
    private final C0921c f5917a;

    /* renamed from: b */
    private final int f5918b;

    /* renamed from: c */
    private C1025p[] f5919c;

    /* renamed from: d */
    private C1025p f5920d;

    public C0938t(C0921c c0921c, int i) {
        if (c0921c == null) {
            throw new NullPointerException("blocks == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("firstLabel < 0");
        }
        this.f5917a = c0921c;
        this.f5918b = i;
        this.f5919c = null;
        this.f5920d = null;
    }

    /* renamed from: a */
    public C0921c m7977a() {
        return this.f5917a;
    }

    /* renamed from: b */
    public int m7979b() {
        return this.f5918b;
    }

    /* renamed from: a */
    public C1025p m7978a(int i) {
        if (this.f5920d == null) {
            m7976c();
        }
        C1025p c1025p = this.f5919c[i];
        if (c1025p == null) {
            throw new RuntimeException("no such block: " + C1022m.m8557c(i));
        }
        return c1025p;
    }

    /* renamed from: c */
    private void m7976c() {
        int j = this.f5917a.m8587j();
        C1025p[] c1025pArr = new C1025p[j];
        C1025p c1025p = new C1025p(10);
        int f_ = this.f5917a.m8550f_();
        for (int i = 0; i < f_; i++) {
            C0920b m7854a = this.f5917a.m7854a(i);
            int mo6568a = m7854a.mo6568a();
            C1025p m7847c = m7854a.m7847c();
            int m8568b = m7847c.m8568b();
            if (m8568b == 0) {
                c1025p.m8571c(mo6568a);
            } else {
                for (int i2 = 0; i2 < m8568b; i2++) {
                    int m8569b = m7847c.m8569b(i2);
                    C1025p c1025p2 = c1025pArr[m8569b];
                    if (c1025p2 == null) {
                        c1025p2 = new C1025p(10);
                        c1025pArr[m8569b] = c1025p2;
                    }
                    c1025p2.m8571c(mo6568a);
                }
            }
        }
        for (int i3 = 0; i3 < j; i3++) {
            C1025p c1025p3 = c1025pArr[i3];
            if (c1025p3 != null) {
                c1025p3.m8580g();
                c1025p3.mo6683e_();
            }
        }
        c1025p.m8580g();
        c1025p.mo6683e_();
        if (c1025pArr[this.f5918b] == null) {
            c1025pArr[this.f5918b] = C1025p.f6502a;
        }
        this.f5919c = c1025pArr;
        this.f5920d = c1025p;
    }
}
