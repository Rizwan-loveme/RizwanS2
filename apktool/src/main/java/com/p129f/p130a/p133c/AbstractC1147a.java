package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
/* renamed from: com.f.a.c.a */
/* loaded from: classes.dex */
abstract class AbstractC1147a<E> extends AbstractC1186bl<E> {

    /* renamed from: a */
    private final int f7764a;

    /* renamed from: b */
    private int f7765b;

    /* renamed from: a */
    protected abstract E mo9793a(int i);

    protected AbstractC1147a(int i) {
        this(i, 0);
    }

    protected AbstractC1147a(int i, int i2) {
        C1120o.m9555b(i2, i);
        this.f7764a = i;
        this.f7765b = i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7765b < this.f7764a;
    }

    @Override // java.util.Iterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f7765b;
        this.f7765b = i + 1;
        return mo9793a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7765b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7765b > 0;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f7765b - 1;
        this.f7765b = i;
        return mo9793a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7765b - 1;
    }
}
