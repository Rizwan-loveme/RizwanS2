package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p110h.C1031v;

/* compiled from: RegisterSpecSet.java */
/* renamed from: com.b.b.f.b.r */
/* loaded from: classes.dex */
public final class C0936r extends C1031v {

    /* renamed from: a */
    public static final C0936r f5907a = new C0936r(0);

    /* renamed from: b */
    private final C0934p[] f5908b;

    /* renamed from: c */
    private int f5909c;

    public C0936r(int i) {
        super(i != 0);
        this.f5908b = new C0934p[i];
        this.f5909c = 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0936r)) {
            return false;
        }
        C0936r c0936r = (C0936r) obj;
        C0934p[] c0934pArr = c0936r.f5908b;
        int length = this.f5908b.length;
        if (length != c0934pArr.length || m7965d() != c0936r.m7965d()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            C0934p c0934p = this.f5908b[i];
            Object obj2 = c0934pArr[i];
            if (c0934p != obj2 && (c0934p == null || !c0934p.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int length = this.f5908b.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            C0934p c0934p = this.f5908b[i2];
            i = (i * 31) + (c0934p == null ? 0 : c0934p.hashCode());
        }
        return i;
    }

    public String toString() {
        int length = this.f5908b.length;
        StringBuffer stringBuffer = new StringBuffer(length * 25);
        stringBuffer.append('{');
        boolean z = false;
        for (int i = 0; i < length; i++) {
            C0934p c0934p = this.f5908b[i];
            if (c0934p != null) {
                if (z) {
                    stringBuffer.append(", ");
                } else {
                    z = true;
                }
                stringBuffer.append(c0934p);
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public int m7961b() {
        return this.f5908b.length;
    }

    /* renamed from: d */
    public int m7965d() {
        int i = this.f5909c;
        if (i < 0) {
            int length = this.f5908b.length;
            i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f5908b[i2] != null) {
                    i++;
                }
            }
            this.f5909c = i;
        }
        return i;
    }

    /* renamed from: a */
    public C0934p m7956a(int i) {
        try {
            return this.f5908b[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    /* renamed from: a */
    public C0934p m7958a(C0934p c0934p) {
        return m7956a(c0934p.m7931g());
    }

    /* renamed from: b */
    public C0934p m7962b(C0934p c0934p) {
        int length = this.f5908b.length;
        for (int i = 0; i < length; i++) {
            C0934p c0934p2 = this.f5908b[i];
            if (c0934p2 != null && c0934p.m7928b(c0934p2)) {
                return c0934p2;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C0934p m7957a(C0928j c0928j) {
        int length = this.f5908b.length;
        for (int i = 0; i < length; i++) {
            C0934p c0934p = this.f5908b[i];
            if (c0934p != null && c0928j.equals(c0934p.m7933i())) {
                return c0934p;
            }
        }
        return null;
    }

    /* renamed from: c */
    public void m7964c(C0934p c0934p) {
        try {
            this.f5908b[c0934p.m7931g()] = null;
            this.f5909c = -1;
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    /* renamed from: d */
    public void m7966d(C0934p c0934p) {
        int i;
        C0934p c0934p2;
        m8595l();
        if (c0934p == null) {
            throw new NullPointerException("spec == null");
        }
        this.f5909c = -1;
        try {
            int m7931g = c0934p.m7931g();
            this.f5908b[m7931g] = c0934p;
            if (m7931g > 0 && (c0934p2 = this.f5908b[m7931g - 1]) != null && c0934p2.m7935k() == 2) {
                this.f5908b[i] = null;
            }
            if (c0934p.m7935k() == 2) {
                this.f5908b[m7931g + 1] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("spec.getReg() out of range");
        }
    }

    /* renamed from: a */
    public void m7959a(C0936r c0936r) {
        int m7961b = c0936r.m7961b();
        for (int i = 0; i < m7961b; i++) {
            C0934p m7956a = c0936r.m7956a(i);
            if (m7956a != null) {
                m7966d(m7956a);
            }
        }
    }

    /* renamed from: a */
    public void m7960a(C0936r c0936r, boolean z) {
        C0934p m7924a;
        m8595l();
        C0934p[] c0934pArr = c0936r.f5908b;
        int length = this.f5908b.length;
        int min = Math.min(length, c0934pArr.length);
        this.f5909c = -1;
        for (int i = 0; i < min; i++) {
            C0934p c0934p = this.f5908b[i];
            if (c0934p != null && (m7924a = c0934p.m7924a(c0934pArr[i], z)) != c0934p) {
                this.f5908b[i] = m7924a;
            }
        }
        while (min < length) {
            this.f5908b[min] = null;
            min++;
        }
    }

    /* renamed from: b */
    public C0936r m7963b(int i) {
        int length = this.f5908b.length;
        C0936r c0936r = new C0936r(length + i);
        for (int i2 = 0; i2 < length; i2++) {
            C0934p c0934p = this.f5908b[i2];
            if (c0934p != null) {
                c0936r.m7966d(c0934p.m7930c(i));
            }
        }
        c0936r.f5909c = this.f5909c;
        if (m8594k()) {
            c0936r.mo6683e_();
        }
        return c0936r;
    }

    /* renamed from: e */
    public C0936r m7967e() {
        int length = this.f5908b.length;
        C0936r c0936r = new C0936r(length);
        for (int i = 0; i < length; i++) {
            C0934p c0934p = this.f5908b[i];
            if (c0934p != null) {
                c0936r.m7966d(c0934p);
            }
        }
        c0936r.f5909c = this.f5909c;
        return c0936r;
    }
}
