package org.p226d.p269d;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: AbstractForwardSequentialList.java */
/* renamed from: org.d.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC2447a<T> extends AbstractSequentialList<T> {
    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract Iterator<T> iterator();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Iterator<T> m15485a(int i) {
        if (i < 0) {
            throw new NoSuchElementException();
        }
        Iterator<T> it = iterator();
        for (int i2 = 0; i2 < i; i2++) {
            it.next();
        }
        return it;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(final int i) {
        try {
            final Iterator<T> m15485a = m15485a(i);
            return new AbstractC2448b<T>() { // from class: org.d.d.a.1

                /* renamed from: d */
                private int f12896d;

                /* renamed from: e */
                private Iterator<T> f12897e;

                {
                    this.f12896d = i - 1;
                    this.f12897e = m15485a;
                }

                /* renamed from: a */
                private Iterator<T> m15487a() {
                    if (this.f12897e == null) {
                        try {
                            this.f12897e = AbstractC2447a.this.m15485a(this.f12896d + 1);
                        } catch (IndexOutOfBoundsException e2) {
                            throw new NoSuchElementException();
                        }
                    }
                    return this.f12897e;
                }

                @Override // org.p226d.p269d.AbstractC2448b, java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return m15487a().hasNext();
                }

                @Override // org.p226d.p269d.AbstractC2448b, java.util.ListIterator
                public boolean hasPrevious() {
                    return this.f12896d >= 0;
                }

                @Override // org.p226d.p269d.AbstractC2448b, java.util.ListIterator, java.util.Iterator
                public T next() {
                    T next = m15487a().next();
                    this.f12896d++;
                    return next;
                }

                @Override // org.p226d.p269d.AbstractC2448b, java.util.ListIterator
                public int nextIndex() {
                    return this.f12896d + 1;
                }

                @Override // org.p226d.p269d.AbstractC2448b, java.util.ListIterator
                public T previous() {
                    this.f12897e = null;
                    try {
                        AbstractC2447a abstractC2447a = AbstractC2447a.this;
                        int i2 = this.f12896d;
                        this.f12896d = i2 - 1;
                        return (T) abstractC2447a.m15485a(i2).next();
                    } catch (IndexOutOfBoundsException e2) {
                        throw new NoSuchElementException();
                    }
                }

                @Override // org.p226d.p269d.AbstractC2448b, java.util.ListIterator
                public int previousIndex() {
                    return this.f12896d;
                }
            };
        } catch (NoSuchElementException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }
}
