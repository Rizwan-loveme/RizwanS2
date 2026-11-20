package org.p210a.p211a.p212a.p215c;

import java.p209io.Serializable;

/* compiled from: Pair.java */
/* renamed from: org.a.a.a.c.m */
/* loaded from: classes.dex */
public class C1843m<A, B> implements Serializable {

    /* renamed from: a */
    public final A f10912a;

    /* renamed from: b */
    public final B f10913b;

    public C1843m(A a2, B b2) {
        this.f10912a = a2;
        this.f10913b = b2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1843m)) {
            return false;
        }
        C1843m c1843m = (C1843m) obj;
        return C1842l.f10911a.mo13575a(this.f10912a, c1843m.f10912a) && C1842l.f10911a.mo13575a(this.f10913b, c1843m.f10913b);
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13773a(C1841k.m13773a(C1841k.m13770a(), this.f10912a), this.f10913b), 2);
    }

    public String toString() {
        return String.format("(%s, %s)", this.f10912a, this.f10913b);
    }
}
