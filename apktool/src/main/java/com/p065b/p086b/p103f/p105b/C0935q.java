package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1021l;
import java.util.BitSet;

/* compiled from: RegisterSpecList.java */
/* renamed from: com.b.b.f.b.q */
/* loaded from: classes.dex */
public final class C0935q extends C1021l implements InterfaceC0977e {

    /* renamed from: a */
    public static final C0935q f5906a = new C0935q(0);

    /* renamed from: a */
    public static C0935q m7944a(C0934p c0934p) {
        C0935q c0935q = new C0935q(1);
        c0935q.m7948a(0, c0934p);
        return c0935q;
    }

    /* renamed from: a */
    public static C0935q m7945a(C0934p c0934p, C0934p c0934p2) {
        C0935q c0935q = new C0935q(2);
        c0935q.m7948a(0, c0934p);
        c0935q.m7948a(1, c0934p2);
        return c0935q;
    }

    public C0935q(int i) {
        super(i);
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0977e
    /* renamed from: a */
    public C0975c mo6853a(int i) {
        return m7949b(i).mo6695a().mo6695a();
    }

    /* renamed from: e */
    public int m7953e() {
        int f_ = m8550f_();
        int i = 0;
        int i2 = 0;
        while (i < f_) {
            int m8127j = mo6853a(i).m8127j() + i2;
            i++;
            i2 = m8127j;
        }
        return i2;
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0977e
    /* renamed from: a */
    public InterfaceC0977e mo6854a(C0975c c0975c) {
        throw new UnsupportedOperationException("unsupported");
    }

    /* renamed from: b */
    public C0934p m7949b(int i) {
        return (C0934p) m8548e(i);
    }

    /* renamed from: c */
    public int m7951c(int i) {
        int f_ = m8550f_();
        for (int i2 = 0; i2 < f_; i2++) {
            if (m7949b(i2).m7931g() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void m7948a(int i, C0934p c0934p) {
        m8546a(i, (Object) c0934p);
    }

    /* renamed from: b */
    public C0935q m7950b(C0934p c0934p) {
        int f_ = m8550f_();
        C0935q c0935q = new C0935q(f_ + 1);
        for (int i = 0; i < f_; i++) {
            c0935q.m8546a(i + 1, m8548e(i));
        }
        c0935q.m8546a(0, (Object) c0934p);
        if (m8594k()) {
            c0935q.mo6683e_();
        }
        return c0935q;
    }

    /* renamed from: f */
    public C0935q m7954f() {
        int f_ = m8550f_() - 1;
        if (f_ == 0) {
            return f5906a;
        }
        C0935q c0935q = new C0935q(f_);
        for (int i = 0; i < f_; i++) {
            c0935q.m8546a(i, m8548e(i + 1));
        }
        if (m8594k()) {
            c0935q.mo6683e_();
            return c0935q;
        }
        return c0935q;
    }

    /* renamed from: g */
    public C0935q m7955g() {
        int f_ = m8550f_() - 1;
        if (f_ == 0) {
            return f5906a;
        }
        C0935q c0935q = new C0935q(f_);
        for (int i = 0; i < f_; i++) {
            c0935q.m8546a(i, m8548e(i));
        }
        if (m8594k()) {
            c0935q.mo6683e_();
            return c0935q;
        }
        return c0935q;
    }

    /* renamed from: a */
    public C0935q m7947a(BitSet bitSet) {
        int i = 0;
        int f_ = m8550f_() - bitSet.cardinality();
        if (f_ == 0) {
            return f5906a;
        }
        C0935q c0935q = new C0935q(f_);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= m8550f_()) {
                break;
            }
            if (bitSet.get(i2)) {
                i = i3;
            } else {
                c0935q.m8546a(i3, m8548e(i2));
                i = i3 + 1;
            }
            i2++;
        }
        if (m8594k()) {
            c0935q.mo6683e_();
        }
        return c0935q;
    }

    /* renamed from: d */
    public C0935q m7952d(int i) {
        int f_ = m8550f_();
        if (f_ != 0) {
            C0935q c0935q = new C0935q(f_);
            for (int i2 = 0; i2 < f_; i2++) {
                C0934p c0934p = (C0934p) m8548e(i2);
                if (c0934p != null) {
                    c0935q.m8546a(i2, (Object) c0934p.m7930c(i));
                }
            }
            if (m8594k()) {
                c0935q.mo6683e_();
            }
            return c0935q;
        }
        return this;
    }

    /* renamed from: a */
    public C0935q m7946a(int i, boolean z, BitSet bitSet) {
        boolean z2;
        int f_ = m8550f_();
        if (f_ != 0) {
            C0935q c0935q = new C0935q(f_);
            int i2 = 0;
            boolean z3 = z;
            int i3 = i;
            while (i2 < f_) {
                C0934p c0934p = (C0934p) m8548e(i2);
                if (bitSet == null) {
                    z2 = true;
                } else {
                    z2 = !bitSet.get(i2);
                }
                if (z2) {
                    c0935q.m8546a(i2, (Object) c0934p.m7927b(i3));
                    if (!z3) {
                        i3 = c0934p.m7935k() + i3;
                    }
                } else {
                    c0935q.m8546a(i2, (Object) c0934p);
                }
                i2++;
                z3 = z3 ? false : z3;
            }
            if (m8594k()) {
                c0935q.mo6683e_();
            }
            return c0935q;
        }
        return this;
    }
}
