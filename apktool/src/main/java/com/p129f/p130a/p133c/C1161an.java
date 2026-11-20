package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.io.Serializable;

/* compiled from: NaturalOrdering.java */
/* renamed from: com.f.a.c.an */
/* loaded from: classes.dex */
final class C1161an extends AbstractC1163ap<Comparable> implements Serializable {

    /* renamed from: a */
    static final C1161an f7826a = new C1161an();

    @Override // com.p129f.p130a.p133c.AbstractC1163ap, java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        C1120o.m9547a(comparable);
        C1120o.m9547a(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1163ap
    /* renamed from: a */
    public <S extends Comparable> AbstractC1163ap<S> mo9951a() {
        return C1175ba.f7871a;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private C1161an() {
    }
}
