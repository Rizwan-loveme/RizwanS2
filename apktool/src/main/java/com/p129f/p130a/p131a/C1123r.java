package com.p129f.p130a.p131a;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Present.java */
/* renamed from: com.f.a.a.r */
/* loaded from: classes.dex */
final class C1123r<T> extends AbstractC1117l<T> {

    /* renamed from: a */
    private final T f7543a;

    C1123r(T t) {
        this.f7543a = t;
    }

    @Override // com.p129f.p130a.p131a.AbstractC1117l
    /* renamed from: a */
    public T mo9498a(T t) {
        C1120o.m9548a(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.f7543a;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof C1123r) {
            return this.f7543a.equals(((C1123r) obj).f7543a);
        }
        return false;
    }

    public int hashCode() {
        return 1502476572 + this.f7543a.hashCode();
    }

    public String toString() {
        return "Optional.of(" + this.f7543a + ")";
    }
}
