package com.p129f.p130a.p131a;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Absent.java */
/* renamed from: com.f.a.a.a */
/* loaded from: classes.dex */
final class C1106a<T> extends AbstractC1117l<T> {

    /* renamed from: a */
    static final C1106a<Object> f7512a = new C1106a<>();

    /* renamed from: a */
    static <T> AbstractC1117l<T> m9497a() {
        return f7512a;
    }

    private C1106a() {
    }

    @Override // com.p129f.p130a.p131a.AbstractC1117l
    /* renamed from: a */
    public T mo9498a(T t) {
        return (T) C1120o.m9548a(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    public boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
