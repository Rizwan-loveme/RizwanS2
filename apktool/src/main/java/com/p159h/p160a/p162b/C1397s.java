package com.p159h.p160a.p162b;

/* compiled from: Pair.java */
/* renamed from: com.h.a.b.s */
/* loaded from: classes.dex */
public final class C1397s<T> implements Comparable<C1397s<T>> {

    /* renamed from: a */
    private int f9140a;

    /* renamed from: b */
    private T f9141b;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return m11131a((C1397s) obj);
    }

    public C1397s(int i, T t) {
        this.f9140a = i;
        this.f9141b = t;
    }

    /* renamed from: a */
    public final int m11130a() {
        return this.f9140a;
    }

    /* renamed from: b */
    public final T m11134b() {
        return this.f9141b;
    }

    /* renamed from: a */
    public final void m11132a(int i) {
        this.f9140a = i;
    }

    /* renamed from: a */
    public final void m11133a(T t) {
        this.f9141b = t;
    }

    /* renamed from: a */
    public int m11131a(C1397s<T> c1397s) {
        return this.f9140a - c1397s.f9140a;
    }
}
