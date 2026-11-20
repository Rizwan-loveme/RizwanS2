package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* compiled from: Insets.java */
/* renamed from: androidx.core.graphics.b */
/* loaded from: classes.dex */
public final class C0312b {

    /* renamed from: a */
    public static final C0312b f2235a = new C0312b(0, 0, 0, 0);

    /* renamed from: b */
    public final int f2236b;

    /* renamed from: c */
    public final int f2237c;

    /* renamed from: d */
    public final int f2238d;

    /* renamed from: e */
    public final int f2239e;

    private C0312b(int i, int i2, int i3, int i4) {
        this.f2236b = i;
        this.f2237c = i2;
        this.f2238d = i3;
        this.f2239e = i4;
    }

    /* renamed from: a */
    public static C0312b m2311a(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f2235a : new C0312b(i, i2, i3, i4);
    }

    /* renamed from: a */
    public static C0312b m2313a(Rect rect) {
        return m2311a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    public static C0312b m2314a(C0312b c0312b, C0312b c0312b2) {
        return m2311a(Math.max(c0312b.f2236b, c0312b2.f2236b), Math.max(c0312b.f2237c, c0312b2.f2237c), Math.max(c0312b.f2238d, c0312b2.f2238d), Math.max(c0312b.f2239e, c0312b2.f2239e));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0312b c0312b = (C0312b) obj;
        return this.f2239e == c0312b.f2239e && this.f2236b == c0312b.f2236b && this.f2238d == c0312b.f2238d && this.f2237c == c0312b.f2237c;
    }

    public int hashCode() {
        return (((((this.f2236b * 31) + this.f2237c) * 31) + this.f2238d) * 31) + this.f2239e;
    }

    public String toString() {
        return "Insets{left=" + this.f2236b + ", top=" + this.f2237c + ", right=" + this.f2238d + ", bottom=" + this.f2239e + '}';
    }

    /* renamed from: a */
    public static C0312b m2312a(Insets insets) {
        return m2311a(insets.left, insets.top, insets.right, insets.bottom);
    }

    /* renamed from: a */
    public Insets m2315a() {
        return Insets.m51of(this.f2236b, this.f2237c, this.f2238d, this.f2239e);
    }
}
