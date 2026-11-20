package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.p209io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ComparatorOrdering.java */
/* renamed from: com.f.a.c.o */
/* loaded from: classes.dex */
final class C1200o<T> extends AbstractC1163ap<T> implements Serializable {

    /* renamed from: a */
    final Comparator<T> f7940a;

    C1200o(Comparator<T> comparator) {
        this.f7940a = (Comparator) C1120o.m9547a(comparator);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1163ap, java.util.Comparator
    public int compare(T t, T t2) {
        return this.f7940a.compare(t, t2);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1200o) {
            return this.f7940a.equals(((C1200o) obj).f7940a);
        }
        return false;
    }

    public int hashCode() {
        return this.f7940a.hashCode();
    }

    public String toString() {
        return this.f7940a.toString();
    }
}
