package com.p129f.p130a.p133c;

import java.p209io.Serializable;

/* compiled from: UsingToStringOrdering.java */
/* renamed from: com.f.a.c.bm */
/* loaded from: classes.dex */
final class C1187bm extends AbstractC1163ap<Object> implements Serializable {

    /* renamed from: a */
    static final C1187bm f7886a = new C1187bm();

    @Override // com.p129f.p130a.p133c.AbstractC1163ap, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }

    private C1187bm() {
    }
}
