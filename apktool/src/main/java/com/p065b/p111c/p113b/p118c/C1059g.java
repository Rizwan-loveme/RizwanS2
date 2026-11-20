package com.p065b.p111c.p113b.p118c;

/* compiled from: Pair.java */
/* renamed from: com.b.c.b.c.g */
/* loaded from: classes.dex */
public final class C1059g<A, B> {

    /* renamed from: a */
    private final A f6700a;

    /* renamed from: b */
    private final B f6701b;

    private C1059g(A a2, B b2) {
        this.f6700a = a2;
        this.f6701b = b2;
    }

    /* renamed from: a */
    public static <A, B> C1059g<A, B> m8851a(A a2, B b2) {
        return new C1059g<>(a2, b2);
    }

    /* renamed from: a */
    public A m8852a() {
        return this.f6700a;
    }

    /* renamed from: b */
    public B m8853b() {
        return this.f6701b;
    }

    public int hashCode() {
        return (((this.f6700a == null ? 0 : this.f6700a.hashCode()) + 31) * 31) + (this.f6701b != null ? this.f6701b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1059g c1059g = (C1059g) obj;
            if (this.f6700a == null) {
                if (c1059g.f6700a != null) {
                    return false;
                }
            } else if (!this.f6700a.equals(c1059g.f6700a)) {
                return false;
            }
            if (this.f6701b == null) {
                if (c1059g.f6701b != null) {
                    return false;
                }
            } else if (!this.f6701b.equals(c1059g.f6701b)) {
                return false;
            }
        }
        return true;
    }
}
