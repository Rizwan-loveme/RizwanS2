package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: RegularImmutableSortedSet.java */
/* renamed from: com.f.a.c.az */
/* loaded from: classes.dex */
final class C1173az<E> extends AbstractC1151ad<E> {

    /* renamed from: c */
    static final C1173az<Comparable> f7861c = new C1173az<>(AbstractC1208w.m10138g(), AbstractC1163ap.m9957b());

    /* renamed from: d */
    final transient AbstractC1208w<E> f7862d;

    C1173az(AbstractC1208w<E> abstractC1208w, Comparator<? super E> comparator) {
        super(comparator);
        this.f7862d = abstractC1208w;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: b */
    Object[] mo9987b() {
        return this.f7862d.mo9987b();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: c */
    int mo9988c() {
        return this.f7862d.mo9988c();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: d */
    int mo9989d() {
        return this.f7862d.mo9989d();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public AbstractC1185bk<E> iterator() {
        return this.f7862d.iterator();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, java.util.NavigableSet
    /* renamed from: m */
    public AbstractC1185bk<E> descendingIterator() {
        return this.f7862d.mo10143i().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f7862d.size();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m9996e(obj) >= 0;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof InterfaceC1160am) {
            collection = ((InterfaceC1160am) collection).m9949a();
        }
        if (!C1180bf.m10011a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        AbstractC1185bk<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int a2 = m9848a(next2, next);
                if (a2 < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (a2 == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (a2 > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException e2) {
                return false;
            }
        }
    }

    /* renamed from: e */
    private int m9996e(Object obj) {
        return Collections.binarySearch(this.f7862d, obj, m10000n());
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: f */
    boolean mo9838f() {
        return this.f7862d.mo9838f();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: a */
    int mo9986a(Object[] objArr, int i) {
        return this.f7862d.mo9986a(objArr, i);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (C1180bf.m10011a(this.f7776a, set)) {
            Iterator<E> it = set.iterator();
            try {
                AbstractC1185bk<E> it2 = iterator();
                while (it2.hasNext()) {
                    E next = it2.next();
                    E next2 = it.next();
                    if (next2 == null || m9848a(next, next2) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (ClassCastException e2) {
                return false;
            } catch (NoSuchElementException e3) {
                return false;
            }
        }
        return containsAll(set);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, java.util.SortedSet
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f7862d.get(0);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, java.util.SortedSet
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f7862d.get(size() - 1);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, java.util.NavigableSet
    public E lower(E e2) {
        int m9998e = m9998e(e2, false) - 1;
        if (m9998e == -1) {
            return null;
        }
        return this.f7862d.get(m9998e);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, java.util.NavigableSet
    public E floor(E e2) {
        int m9998e = m9998e(e2, true) - 1;
        if (m9998e == -1) {
            return null;
        }
        return this.f7862d.get(m9998e);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, java.util.NavigableSet
    public E ceiling(E e2) {
        int m9999f = m9999f(e2, true);
        if (m9999f == size()) {
            return null;
        }
        return this.f7862d.get(m9999f);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad, java.util.NavigableSet
    public E higher(E e2) {
        int m9999f = m9999f(e2, false);
        if (m9999f == size()) {
            return null;
        }
        return this.f7862d.get(m9999f);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad
    /* renamed from: c */
    AbstractC1151ad<E> mo9856c(E e2, boolean z) {
        return m9997b(0, m9998e(e2, z));
    }

    /* renamed from: e */
    int m9998e(E e2, boolean z) {
        int binarySearch = Collections.binarySearch(this.f7862d, C1120o.m9547a(e2), comparator());
        return binarySearch >= 0 ? z ? binarySearch + 1 : binarySearch : binarySearch ^ (-1);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad
    /* renamed from: b */
    AbstractC1151ad<E> mo9854b(E e2, boolean z, E e3, boolean z2) {
        return mo9858d(e2, z).mo9856c(e3, z2);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad
    /* renamed from: d */
    AbstractC1151ad<E> mo9858d(E e2, boolean z) {
        return m9997b(m9999f(e2, z), size());
    }

    /* renamed from: f */
    int m9999f(E e2, boolean z) {
        int binarySearch = Collections.binarySearch(this.f7862d, C1120o.m9547a(e2), comparator());
        if (binarySearch >= 0) {
            if (!z) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return binarySearch ^ (-1);
    }

    /* renamed from: n */
    Comparator<Object> m10000n() {
        return this.f7776a;
    }

    /* renamed from: b */
    C1173az<E> m9997b(int i, int i2) {
        if (i != 0 || i2 != size()) {
            if (i < i2) {
                return new C1173az<>(this.f7862d.subList(i, i2), this.f7776a);
            }
            return m9846a((Comparator) this.f7776a);
        }
        return this;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad
    /* renamed from: d */
    int mo9857d(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.f7862d, obj, m10000n());
            if (binarySearch < 0) {
                binarySearch = -1;
            }
            return binarySearch;
        } catch (ClassCastException e2) {
            return -1;
        }
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: e */
    public AbstractC1208w<E> mo9804e() {
        return this.f7862d;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1151ad
    /* renamed from: l */
    AbstractC1151ad<E> mo9860l() {
        Comparator reverseOrder = Collections.reverseOrder(this.f7776a);
        return isEmpty() ? m9846a(reverseOrder) : new C1173az(this.f7862d.mo10143i(), reverseOrder);
    }
}
