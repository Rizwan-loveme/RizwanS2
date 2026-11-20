package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.p209io.Serializable;

/* compiled from: ReverseNaturalOrdering.java */
/* renamed from: com.f.a.c.ba */
/* loaded from: classes.dex */
final class C1175ba extends AbstractC1163ap<Comparable> implements Serializable {

    /* renamed from: a */
    static final C1175ba f7871a = new C1175ba();

    @Override // com.p129f.p130a.p133c.AbstractC1163ap, java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        C1120o.m9547a(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1163ap
    /* renamed from: a */
    public <S extends Comparable> AbstractC1163ap<S> mo9951a() {
        return AbstractC1163ap.m9957b();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private C1175ba() {
    }
}
