package org.p226d.p233b.p244d.p248d;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;

/* compiled from: VariableSizeListIterator.java */
/* renamed from: org.d.b.d.d.i */
/* loaded from: classes.dex */
public abstract class AbstractC2138i<T> implements ListIterator<T> {

    /* renamed from: a */
    private C2161o f11915a;

    /* renamed from: b */
    protected final int f11916b;

    /* renamed from: c */
    private final int f11917c;

    /* renamed from: d */
    private int f11918d;

    /* renamed from: a */
    protected abstract T mo14726a(C2161o c2161o, int i);

    protected AbstractC2138i(C2153g c2153g, int i, int i2) {
        this.f11915a = c2153g.m14783v(i);
        this.f11917c = i;
        this.f11916b = i2;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f11918d < this.f11916b;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        if (this.f11918d >= this.f11916b) {
            throw new NoSuchElementException();
        }
        C2161o c2161o = this.f11915a;
        int i = this.f11918d;
        this.f11918d = i + 1;
        return mo14726a(c2161o, i);
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f11918d > 0;
    }

    @Override // java.util.ListIterator
    public T previous() {
        int i = this.f11918d - 1;
        this.f11915a.m14636a(this.f11917c);
        this.f11918d = 0;
        while (this.f11918d < i) {
            C2161o c2161o = this.f11915a;
            int i2 = this.f11918d;
            this.f11918d = i2 + 1;
            mo14726a(c2161o, i2);
        }
        C2161o c2161o2 = this.f11915a;
        int i3 = this.f11918d;
        this.f11918d = i3 + 1;
        return mo14726a(c2161o2, i3);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f11918d;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f11918d - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
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
