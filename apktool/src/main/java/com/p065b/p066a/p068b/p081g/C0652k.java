package com.p065b.p066a.p068b.p081g;

/* compiled from: Pair.java */
/* renamed from: com.b.a.b.g.k */
/* loaded from: classes.dex */
public final class C0652k<A, B> {

    /* renamed from: a */
    private final A f4251a;

    /* renamed from: b */
    private final B f4252b;

    private C0652k(A a2, B b2) {
        this.f4251a = a2;
        this.f4252b = b2;
    }

    /* renamed from: a */
    public static <A, B> C0652k<A, B> m6250a(A a2, B b2) {
        return new C0652k<>(a2, b2);
    }

    /* renamed from: a */
    public A m6251a() {
        return this.f4251a;
    }

    /* renamed from: b */
    public B m6252b() {
        return this.f4252b;
    }

    public int hashCode() {
        A a2 = this.f4251a;
        int hashCode = a2 == null ? 0 : a2.hashCode();
        B b2 = this.f4252b;
        return ((hashCode + 31) * 31) + (b2 != null ? b2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0652k c0652k = (C0652k) obj;
            A a2 = this.f4251a;
            if (a2 == null) {
                if (c0652k.f4251a != null) {
                    return false;
                }
            } else if (!a2.equals(c0652k.f4251a)) {
                return false;
            }
            B b2 = this.f4252b;
            return b2 == null ? c0652k.f4252b == null : b2.equals(c0652k.f4252b);
        }
        return false;
    }
}
