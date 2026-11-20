package com.p065b.p086b.p110h;

import java.util.Arrays;

/* compiled from: IntList.java */
/* renamed from: com.b.b.h.p */
/* loaded from: classes.dex */
public final class C1025p extends C1031v {

    /* renamed from: a */
    public static final C1025p f6502a = new C1025p(0);

    /* renamed from: b */
    private int[] f6503b;

    /* renamed from: c */
    private int f6504c;

    /* renamed from: d */
    private boolean f6505d;

    static {
        f6502a.mo6683e_();
    }

    /* renamed from: a */
    public static C1025p m8565a(int i) {
        C1025p c1025p = new C1025p(1);
        c1025p.m8571c(i);
        c1025p.mo6683e_();
        return c1025p;
    }

    /* renamed from: a */
    public static C1025p m8566a(int i, int i2) {
        C1025p c1025p = new C1025p(2);
        c1025p.m8571c(i);
        c1025p.m8571c(i2);
        c1025p.mo6683e_();
        return c1025p;
    }

    public C1025p() {
        this(4);
    }

    public C1025p(int i) {
        super(true);
        try {
            this.f6503b = new int[i];
            this.f6504c = 0;
            this.f6505d = true;
        } catch (NegativeArraySizeException e2) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.f6504c) {
                i = (i3 * 31) + this.f6503b[i2];
                i2++;
            } else {
                return i3;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1025p)) {
            return false;
        }
        C1025p c1025p = (C1025p) obj;
        if (this.f6505d != c1025p.f6505d || this.f6504c != c1025p.f6504c) {
            return false;
        }
        for (int i = 0; i < this.f6504c; i++) {
            if (this.f6503b[i] != c1025p.f6503b[i]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f6504c * 5) + 10);
        stringBuffer.append('{');
        for (int i = 0; i < this.f6504c; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.f6503b[i]);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public int m8568b() {
        return this.f6504c;
    }

    /* renamed from: b */
    public int m8569b(int i) {
        if (i >= this.f6504c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        try {
            return this.f6503b[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IndexOutOfBoundsException("n < 0");
        }
    }

    /* renamed from: b */
    public void m8570b(int i, int i2) {
        m8595l();
        if (i >= this.f6504c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        try {
            this.f6503b[i] = i2;
            this.f6505d = false;
        } catch (ArrayIndexOutOfBoundsException e2) {
            if (i < 0) {
                throw new IllegalArgumentException("n < 0");
            }
        }
    }

    /* renamed from: c */
    public void m8571c(int i) {
        m8595l();
        m8567h();
        int[] iArr = this.f6503b;
        int i2 = this.f6504c;
        this.f6504c = i2 + 1;
        iArr[i2] = i;
        if (this.f6505d && this.f6504c > 1) {
            this.f6505d = i >= this.f6503b[this.f6504c + (-2)];
        }
    }

    /* renamed from: c */
    public void m8572c(int i, int i2) {
        if (i > this.f6504c) {
            throw new IndexOutOfBoundsException("n > size()");
        }
        m8567h();
        System.arraycopy(this.f6503b, i, this.f6503b, i + 1, this.f6504c - i);
        this.f6503b[i] = i2;
        this.f6504c++;
        this.f6505d = this.f6505d && (i == 0 || i2 > this.f6503b[i + (-1)]) && (i == this.f6504c + (-1) || i2 < this.f6503b[i + 1]);
    }

    /* renamed from: d */
    public void m8574d(int i) {
        if (i >= this.f6504c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        System.arraycopy(this.f6503b, i + 1, this.f6503b, i, (this.f6504c - i) - 1);
        this.f6504c--;
    }

    /* renamed from: h */
    private void m8567h() {
        if (this.f6504c == this.f6503b.length) {
            int[] iArr = new int[((this.f6504c * 3) / 2) + 10];
            System.arraycopy(this.f6503b, 0, iArr, 0, this.f6504c);
            this.f6503b = iArr;
        }
    }

    /* renamed from: d */
    public int m8573d() {
        return m8569b(this.f6504c - 1);
    }

    /* renamed from: e */
    public int m8575e() {
        m8595l();
        this.f6504c--;
        return m8569b(this.f6504c - 1);
    }

    /* renamed from: e */
    public void m8576e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("newSize < 0");
        }
        if (i > this.f6504c) {
            throw new IllegalArgumentException("newSize > size");
        }
        m8595l();
        this.f6504c = i;
    }

    /* renamed from: f */
    public C1025p m8578f() {
        int i = this.f6504c;
        C1025p c1025p = new C1025p(i);
        for (int i2 = 0; i2 < i; i2++) {
            c1025p.m8571c(this.f6503b[i2]);
        }
        return c1025p;
    }

    /* renamed from: g */
    public void m8580g() {
        m8595l();
        if (!this.f6505d) {
            Arrays.sort(this.f6503b, 0, this.f6504c);
            this.f6505d = true;
        }
    }

    /* renamed from: f */
    public int m8577f(int i) {
        int m8579g = m8579g(i);
        if (m8579g >= 0) {
            return m8579g;
        }
        return -1;
    }

    /* renamed from: g */
    public int m8579g(int i) {
        int i2 = this.f6504c;
        if (!this.f6505d) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.f6503b[i3] == i) {
                    return i3;
                }
            }
            return -i2;
        }
        int i4 = -1;
        int i5 = i2;
        while (i5 > i4 + 1) {
            int i6 = ((i5 - i4) >> 1) + i4;
            if (i <= this.f6503b[i6]) {
                i5 = i6;
            } else {
                i4 = i6;
            }
        }
        if (i5 != i2) {
            return i != this.f6503b[i5] ? (-i5) - 1 : i5;
        }
        return (-i2) - 1;
    }

    /* renamed from: h */
    public boolean m8581h(int i) {
        return m8577f(i) >= 0;
    }
}
