package org.p210a.p211a.p212a.p215c;

/* compiled from: Interval.java */
/* renamed from: org.a.a.a.c.i */
/* loaded from: classes.dex */
public class C1839i {

    /* renamed from: a */
    public static final C1839i f10899a = new C1839i(-1, -2);

    /* renamed from: b */
    static C1839i[] f10900b = new C1839i[1001];

    /* renamed from: e */
    public static int f10901e = 0;

    /* renamed from: f */
    public static int f10902f = 0;

    /* renamed from: g */
    public static int f10903g = 0;

    /* renamed from: h */
    public static int f10904h = 0;

    /* renamed from: c */
    public int f10905c;

    /* renamed from: d */
    public int f10906d;

    public C1839i(int i, int i2) {
        this.f10905c = i;
        this.f10906d = i2;
    }

    /* renamed from: a */
    public static C1839i m13746a(int i, int i2) {
        if (i != i2 || i < 0 || i > 1000) {
            return new C1839i(i, i2);
        }
        if (f10900b[i] == null) {
            f10900b[i] = new C1839i(i, i);
        }
        return f10900b[i];
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1839i)) {
            return false;
        }
        C1839i c1839i = (C1839i) obj;
        return this.f10905c == c1839i.f10905c && this.f10906d == c1839i.f10906d;
    }

    public int hashCode() {
        return ((this.f10905c + 713) * 31) + this.f10906d;
    }

    /* renamed from: a */
    public boolean m13747a(C1839i c1839i) {
        return this.f10905c < c1839i.f10905c && this.f10906d < c1839i.f10905c;
    }

    /* renamed from: b */
    public boolean m13748b(C1839i c1839i) {
        return this.f10905c > c1839i.f10906d;
    }

    /* renamed from: c */
    public boolean m13749c(C1839i c1839i) {
        return m13747a(c1839i) || m13748b(c1839i);
    }

    /* renamed from: d */
    public boolean m13750d(C1839i c1839i) {
        return this.f10905c == c1839i.f10906d + 1 || this.f10906d == c1839i.f10905c + (-1);
    }

    /* renamed from: e */
    public C1839i m13751e(C1839i c1839i) {
        return m13746a(Math.min(this.f10905c, c1839i.f10905c), Math.max(this.f10906d, c1839i.f10906d));
    }

    public String toString() {
        return String.valueOf(this.f10905c) + ".." + this.f10906d;
    }
}
