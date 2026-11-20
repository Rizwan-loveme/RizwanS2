package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1021l;
import com.p065b.p086b.p110h.C1025p;

/* compiled from: ByteCatchList.java */
/* renamed from: com.b.b.a.b.e */
/* loaded from: classes.dex */
public final class C0709e extends C1021l {

    /* renamed from: a */
    public static final C0709e f4516a = new C0709e(0);

    public C0709e(int i) {
        super(i);
    }

    /* renamed from: a */
    public int m6577a() {
        return (m8550f_() * 8) + 2;
    }

    /* renamed from: a */
    public a m6578a(int i) {
        return (a) m8548e(i);
    }

    /* renamed from: a */
    public void m6580a(int i, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("item == null");
        }
        m8546a(i, (Object) aVar);
    }

    /* renamed from: a */
    public void m6579a(int i, int i2, int i3, int i4, C0971y c0971y) {
        m8546a(i, (Object) new a(i2, i3, i4, c0971y));
    }

    /* renamed from: b */
    public C0709e m6581b(int i) {
        int f_ = m8550f_();
        a[] aVarArr = new a[f_];
        int i2 = 0;
        for (int i3 = 0; i3 < f_; i3++) {
            a m6578a = m6578a(i3);
            if (m6578a.m6585a(i) && m6576a(m6578a, aVarArr, i2)) {
                aVarArr[i2] = m6578a;
                i2++;
            }
        }
        if (i2 == 0) {
            return f4516a;
        }
        C0709e c0709e = new C0709e(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            c0709e.m6580a(i4, aVarArr[i4]);
        }
        c0709e.mo6683e_();
        return c0709e;
    }

    /* renamed from: a */
    private static boolean m6576a(a aVar, a[] aVarArr, int i) {
        C0971y m6588d = aVar.m6588d();
        for (int i2 = 0; i2 < i; i2++) {
            C0971y m6588d2 = aVarArr[i2].m6588d();
            if (m6588d2 == m6588d || m6588d2 == C0971y.f6172a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public C1025p m6582c(int i) {
        if (i < -1) {
            throw new IllegalArgumentException("noException < -1");
        }
        boolean z = i >= 0;
        int f_ = m8550f_();
        if (f_ == 0) {
            if (z) {
                return C1025p.m8565a(i);
            }
            return C1025p.f6502a;
        }
        C1025p c1025p = new C1025p((z ? 1 : 0) + f_);
        for (int i2 = 0; i2 < f_; i2++) {
            c1025p.m8571c(m6578a(i2).m6587c());
        }
        if (z) {
            c1025p.m8571c(i);
        }
        c1025p.mo6683e_();
        return c1025p;
    }

    /* renamed from: c_ */
    public InterfaceC0977e m6583c_() {
        int f_ = m8550f_();
        if (f_ == 0) {
            return C0974b.f6209a;
        }
        C0974b c0974b = new C0974b(f_);
        for (int i = 0; i < f_; i++) {
            c0974b.m8114a(i, m6578a(i).m6588d().m8090i());
        }
        c0974b.mo6683e_();
        return c0974b;
    }

    /* compiled from: ByteCatchList.java */
    /* renamed from: com.b.b.a.b.e$a */
    public static class a {

        /* renamed from: a */
        private final int f4517a;

        /* renamed from: b */
        private final int f4518b;

        /* renamed from: c */
        private final int f4519c;

        /* renamed from: d */
        private final C0971y f4520d;

        public a(int i, int i2, int i3, C0971y c0971y) {
            if (i < 0) {
                throw new IllegalArgumentException("startPc < 0");
            }
            if (i2 < i) {
                throw new IllegalArgumentException("endPc < startPc");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("handlerPc < 0");
            }
            this.f4517a = i;
            this.f4518b = i2;
            this.f4519c = i3;
            this.f4520d = c0971y;
        }

        /* renamed from: a */
        public int m6584a() {
            return this.f4517a;
        }

        /* renamed from: b */
        public int m6586b() {
            return this.f4518b;
        }

        /* renamed from: c */
        public int m6587c() {
            return this.f4519c;
        }

        /* renamed from: d */
        public C0971y m6588d() {
            return this.f4520d != null ? this.f4520d : C0971y.f6172a;
        }

        /* renamed from: a */
        public boolean m6585a(int i) {
            return i >= this.f4517a && i < this.f4518b;
        }
    }
}
