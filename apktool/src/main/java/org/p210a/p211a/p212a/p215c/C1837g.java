package org.p210a.p211a.p212a.p215c;

import java.util.Arrays;

/* compiled from: IntegerList.java */
/* renamed from: org.a.a.a.c.g */
/* loaded from: classes.dex */
public class C1837g {

    /* renamed from: a */
    private static int[] f10896a = new int[0];

    /* renamed from: b */
    private int[] f10897b = f10896a;

    /* renamed from: c */
    private int f10898c;

    /* renamed from: a */
    public final void m13736a(int i) {
        if (this.f10897b.length == this.f10898c) {
            m13735d(this.f10898c + 1);
        }
        this.f10897b[this.f10898c] = i;
        this.f10898c++;
    }

    /* renamed from: b */
    public final int m13739b(int i) {
        if (i < 0 || i >= this.f10898c) {
            throw new IndexOutOfBoundsException();
        }
        return this.f10897b[i];
    }

    /* renamed from: c */
    public final int m13740c(int i) {
        int m13739b = m13739b(i);
        System.arraycopy(this.f10897b, i + 1, this.f10897b, i, (this.f10898c - i) - 1);
        this.f10897b[this.f10898c - 1] = 0;
        this.f10898c--;
        return m13739b;
    }

    /* renamed from: a */
    public final boolean m13737a() {
        return this.f10898c == 0;
    }

    /* renamed from: b */
    public final int m13738b() {
        return this.f10898c;
    }

    /* renamed from: c */
    public final void m13741c() {
        Arrays.fill(this.f10897b, 0, this.f10898c, 0);
        this.f10898c = 0;
    }

    /* renamed from: d */
    public final int[] m13742d() {
        return this.f10898c == 0 ? f10896a : Arrays.copyOf(this.f10897b, this.f10898c);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1837g)) {
            return false;
        }
        C1837g c1837g = (C1837g) obj;
        if (this.f10898c != c1837g.f10898c) {
            return false;
        }
        for (int i = 0; i < this.f10898c; i++) {
            if (this.f10897b[i] != c1837g.f10897b[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f10898c; i2++) {
            i = (i * 31) + this.f10897b[i2];
        }
        return i;
    }

    public String toString() {
        return Arrays.toString(m13742d());
    }

    /* renamed from: d */
    private void m13735d(int i) {
        int length;
        if (i < 0 || i > 2147483639) {
            throw new OutOfMemoryError();
        }
        if (this.f10897b.length == 0) {
            length = 4;
        } else {
            length = this.f10897b.length;
        }
        while (length < i) {
            length *= 2;
            if (length < 0 || length > 2147483639) {
                length = 2147483639;
            }
        }
        this.f10897b = Arrays.copyOf(this.f10897b, length);
    }
}
