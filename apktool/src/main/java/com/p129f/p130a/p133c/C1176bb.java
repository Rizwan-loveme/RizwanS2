package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ReverseOrdering.java */
/* renamed from: com.f.a.c.bb */
/* loaded from: classes.dex */
final class C1176bb<T> extends AbstractC1163ap<T> implements Serializable {

    /* renamed from: a */
    final AbstractC1163ap<? super T> f7872a;

    C1176bb(AbstractC1163ap<? super T> abstractC1163ap) {
        this.f7872a = (AbstractC1163ap) C1120o.m9547a(abstractC1163ap);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1163ap, java.util.Comparator
    public int compare(T t, T t2) {
        return this.f7872a.compare(t2, t);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1163ap
    /* renamed from: a */
    public <S extends T> AbstractC1163ap<S> mo9951a() {
        return this.f7872a;
    }

    public int hashCode() {
        return -this.f7872a.hashCode();
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1176bb) {
            return this.f7872a.equals(((C1176bb) obj).f7872a);
        }
        return false;
    }

    public String toString() {
        return this.f7872a + ".reverse()";
    }
}
