package org.p226d.p233b.p244d.p248d;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: FixedSizeSet.java */
/* renamed from: org.d.b.d.d.e */
/* loaded from: classes.dex */
public abstract class AbstractC2134e<T> extends AbstractSet<T> {
    /* renamed from: b */
    public abstract T mo14702b(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: org.d.b.d.d.e.1

            /* renamed from: a */
            int f11899a = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f11899a < AbstractC2134e.this.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                AbstractC2134e abstractC2134e = AbstractC2134e.this;
                int i = this.f11899a;
                this.f11899a = i + 1;
                return (T) abstractC2134e.mo14702b(i);
            }
        };
    }
}
