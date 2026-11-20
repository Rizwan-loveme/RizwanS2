package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p110h.C1021l;

/* compiled from: LineNumberList.java */
/* renamed from: com.b.b.a.b.k */
/* loaded from: classes.dex */
public final class C0715k extends C1021l {

    /* renamed from: a */
    public static final C0715k f4543a = new C0715k(0);

    /* renamed from: a */
    public static C0715k m6646a(C0715k c0715k, C0715k c0715k2) {
        if (c0715k != f4543a) {
            int f_ = c0715k.m8550f_();
            int f_2 = c0715k2.m8550f_();
            C0715k c0715k3 = new C0715k(f_ + f_2);
            for (int i = 0; i < f_; i++) {
                c0715k3.m6649a(i, c0715k.m6647a(i));
            }
            for (int i2 = 0; i2 < f_2; i2++) {
                c0715k3.m6649a(f_ + i2, c0715k2.m6647a(i2));
            }
            return c0715k3;
        }
        return c0715k2;
    }

    public C0715k(int i) {
        super(i);
    }

    /* renamed from: a */
    public a m6647a(int i) {
        return (a) m8548e(i);
    }

    /* renamed from: a */
    public void m6649a(int i, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("item == null");
        }
        m8546a(i, (Object) aVar);
    }

    /* renamed from: a */
    public void m6648a(int i, int i2, int i3) {
        m8546a(i, (Object) new a(i2, i3));
    }

    /* renamed from: b */
    public int m6650b(int i) {
        int f_ = m8550f_();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (i2 < f_) {
            a m6647a = m6647a(i2);
            int m6651a = m6647a.m6651a();
            if (m6651a > i || m6651a <= i4) {
                m6651a = i4;
            } else {
                i3 = m6647a.m6652b();
                if (m6651a == i) {
                    break;
                }
            }
            i2++;
            i4 = m6651a;
        }
        return i3;
    }

    /* compiled from: LineNumberList.java */
    /* renamed from: com.b.b.a.b.k$a */
    public static class a {

        /* renamed from: a */
        private final int f4544a;

        /* renamed from: b */
        private final int f4545b;

        public a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("startPc < 0");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("lineNumber < 0");
            }
            this.f4544a = i;
            this.f4545b = i2;
        }

        /* renamed from: a */
        public int m6651a() {
            return this.f4544a;
        }

        /* renamed from: b */
        public int m6652b() {
            return this.f4545b;
        }
    }
}
