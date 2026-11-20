package org.p226d.p233b.p244d.p248d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;

/* compiled from: VariableSizeIterator.java */
/* renamed from: org.d.b.d.d.g */
/* loaded from: classes.dex */
public abstract class AbstractC2136g<T> implements Iterator<T> {

    /* renamed from: a */
    private final C2161o f11908a;

    /* renamed from: b */
    protected final int f11909b;

    /* renamed from: c */
    private int f11910c;

    /* renamed from: b */
    protected abstract T mo14716b(C2161o c2161o, int i);

    protected AbstractC2136g(C2153g c2153g, int i, int i2) {
        this.f11908a = c2153g.m14783v(i);
        this.f11909b = i2;
    }

    protected AbstractC2136g(C2161o c2161o, int i) {
        this.f11908a = c2161o;
        this.f11909b = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11910c < this.f11909b;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f11910c >= this.f11909b) {
            throw new NoSuchElementException();
        }
        C2161o c2161o = this.f11908a;
        int i = this.f11910c;
        this.f11910c = i + 1;
        return mo14716b(c2161o, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
