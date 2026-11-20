package jadx.core.p203d;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* compiled from: ImmutableList.java */
/* renamed from: jadx.core.d.f */
/* loaded from: classes.dex */
public final class C1737f<E> implements List<E>, RandomAccess {

    /* renamed from: a */
    private final E[] f10595a;

    public C1737f(Collection<E> collection) {
        this(((Collection) C1742k.m13286a(collection)).toArray());
    }

    public C1737f(E[] eArr) {
        this.f10595a = (E[]) ((Object[]) C1742k.m13286a(eArr));
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int size() {
        return this.f10595a.length;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f10595a.length == 0;
    }

    @Override // java.util.List
    public E get(int i) {
        return this.f10595a[i];
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int length = this.f10595a.length;
        for (int i = 0; i < length; i++) {
            if (C1742k.m13287a(this.f10595a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        for (int length = this.f10595a.length - 1; length > 0; length--) {
            if (C1742k.m13287a(this.f10595a[length], obj)) {
                return length;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: jadx.core.d.f.1

            /* renamed from: b */
            private int f10597b = 0;

            /* renamed from: c */
            private int f10598c;

            {
                this.f10598c = C1737f.this.f10595a.length;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f10597b < this.f10598c;
            }

            @Override // java.util.Iterator
            public E next() {
                try {
                    Object[] objArr = C1737f.this.f10595a;
                    int i = this.f10597b;
                    this.f10597b = i + 1;
                    return (E) objArr[i];
                } catch (IndexOutOfBoundsException e2) {
                    throw new NoSuchElementException(e2.getMessage());
                }
            }
        };
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.f10595a, this.f10595a.length);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) Arrays.copyOf(this.f10595a, this.f10595a.length);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f10595a, ((C1737f) obj).f10595a);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int hashCode() {
        return Arrays.hashCode(this.f10595a);
    }

    public String toString() {
        return "ImmutableList{" + Arrays.toString(this.f10595a) + '}';
    }
}
