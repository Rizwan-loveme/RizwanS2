package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.util.Iterator;

/* compiled from: TransformedIterator.java */
/* renamed from: com.f.a.c.bh */
/* loaded from: classes.dex */
abstract class AbstractC1182bh<F, T> implements Iterator<T> {

    /* renamed from: b */
    final Iterator<? extends F> f7885b;

    /* renamed from: a */
    abstract T mo9904a(F f2);

    AbstractC1182bh(Iterator<? extends F> it) {
        this.f7885b = (Iterator) C1120o.m9547a(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7885b.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return mo9904a(this.f7885b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f7885b.remove();
    }
}
