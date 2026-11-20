package com.p129f.p130a.p133c;

import java.util.ListIterator;

/* compiled from: TransformedListIterator.java */
/* renamed from: com.f.a.c.bi */
/* loaded from: classes.dex */
abstract class AbstractC1183bi<F, T> extends AbstractC1182bh<F, T> implements ListIterator<T> {
    AbstractC1183bi(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    /* renamed from: a */
    private ListIterator<? extends F> m10017a() {
        return C1154ag.m9902f(this.f7885b);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return m10017a().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return mo9904a(m10017a().previous());
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return m10017a().nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return m10017a().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
