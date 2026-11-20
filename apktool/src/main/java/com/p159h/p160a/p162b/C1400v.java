package com.p159h.p160a.p162b;

/* compiled from: TextBufferCache.java */
/* renamed from: com.h.a.b.v */
/* loaded from: classes.dex */
public class C1400v {

    /* renamed from: a */
    private C1397s<Integer>[] f9151a = new C1397s[4];

    public C1400v() {
        this.f9151a[0] = new C1397s<>(0, new Integer(0));
        for (int i = 1; i < 4; i++) {
            this.f9151a[i] = new C1397s<>(-1, new Integer(-1));
        }
    }

    /* renamed from: a */
    public C1397s<Integer> m11169a(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        while (i3 < 4) {
            int abs = Math.abs(i - this.f9151a[i3].m11130a());
            if (abs < i2) {
                i4 = i3;
            } else {
                abs = i2;
            }
            i3++;
            i2 = abs;
        }
        C1397s<Integer> c1397s = this.f9151a[i4];
        m11168d(i4);
        return c1397s;
    }

    /* renamed from: b */
    public C1397s<Integer> m11171b(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        while (i3 < 4) {
            int abs = Math.abs(i - this.f9151a[i3].m11134b().intValue());
            if (abs < i2) {
                i4 = i3;
            } else {
                abs = i2;
            }
            i3++;
            i2 = abs;
        }
        C1397s<Integer> c1397s = this.f9151a[i4];
        m11168d(i4);
        return c1397s;
    }

    /* renamed from: d */
    private void m11168d(int i) {
        if (i != 0) {
            C1397s<Integer> c1397s = this.f9151a[i];
            while (i > 1) {
                this.f9151a[i] = this.f9151a[i - 1];
                i--;
            }
            this.f9151a[1] = c1397s;
        }
    }

    /* renamed from: a */
    public void m11170a(int i, int i2) {
        if (i > 0 && !m11166b(i, i2)) {
            m11167c(i, i2);
        }
    }

    /* renamed from: b */
    private boolean m11166b(int i, int i2) {
        for (int i3 = 1; i3 < 4; i3++) {
            if (this.f9151a[i3].m11130a() == i) {
                this.f9151a[i3].m11133a((C1397s<Integer>) new Integer(i2));
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m11167c(int i, int i2) {
        m11168d(3);
        this.f9151a[1] = new C1397s<>(i, new Integer(i2));
    }

    /* renamed from: c */
    protected final void m11172c(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return;
            }
            if (this.f9151a[i3].m11134b().intValue() >= i) {
                this.f9151a[i3] = new C1397s<>(-1, new Integer(-1));
            }
            i2 = i3 + 1;
        }
    }
}
