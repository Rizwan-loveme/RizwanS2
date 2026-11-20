package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p106c.C0970x;

/* compiled from: LocalItem.java */
/* renamed from: com.b.b.f.b.j */
/* loaded from: classes.dex */
public class C0928j implements Comparable<C0928j> {

    /* renamed from: a */
    private final C0970x f5888a;

    /* renamed from: b */
    private final C0970x f5889b;

    /* renamed from: a */
    public static C0928j m7894a(C0970x c0970x, C0970x c0970x2) {
        if (c0970x == null && c0970x2 == null) {
            return null;
        }
        return new C0928j(c0970x, c0970x2);
    }

    private C0928j(C0970x c0970x, C0970x c0970x2) {
        this.f5888a = c0970x;
        this.f5889b = c0970x2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0928j) && compareTo((C0928j) obj) == 0;
    }

    /* renamed from: b */
    private static int m7895b(C0970x c0970x, C0970x c0970x2) {
        if (c0970x == c0970x2) {
            return 0;
        }
        if (c0970x == null) {
            return -1;
        }
        if (c0970x2 == null) {
            return 1;
        }
        return c0970x.compareTo(c0970x2);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0928j c0928j) {
        int m7895b = m7895b(this.f5888a, c0928j.f5888a);
        if (m7895b == 0) {
            return m7895b(this.f5889b, c0928j.f5889b);
        }
        return m7895b;
    }

    public int hashCode() {
        return ((this.f5888a == null ? 0 : this.f5888a.hashCode()) * 31) + (this.f5889b != null ? this.f5889b.hashCode() : 0);
    }

    public String toString() {
        if (this.f5888a != null && this.f5889b == null) {
            return this.f5888a.m8083i();
        }
        if (this.f5888a == null && this.f5889b == null) {
            return "";
        }
        return "[" + (this.f5888a == null ? "" : this.f5888a.m8083i()) + "|" + (this.f5889b == null ? "" : this.f5889b.m8083i());
    }

    /* renamed from: a */
    public C0970x m7897a() {
        return this.f5888a;
    }

    /* renamed from: b */
    public C0970x m7898b() {
        return this.f5889b;
    }
}
