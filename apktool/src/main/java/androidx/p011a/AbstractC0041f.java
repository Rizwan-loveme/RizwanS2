package androidx.p011a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: MapCollections.java */
/* renamed from: androidx.a.f */
/* loaded from: classes.dex */
abstract class AbstractC0041f<K, V> {

    /* renamed from: b */
    AbstractC0041f<K, V>.b f319b;

    /* renamed from: c */
    AbstractC0041f<K, V>.c f320c;

    /* renamed from: d */
    AbstractC0041f<K, V>.e f321d;

    /* renamed from: a */
    protected abstract int mo209a();

    /* renamed from: a */
    protected abstract int mo210a(Object obj);

    /* renamed from: a */
    protected abstract Object mo211a(int i, int i2);

    /* renamed from: a */
    protected abstract V mo212a(int i, V v);

    /* renamed from: a */
    protected abstract void mo213a(int i);

    /* renamed from: a */
    protected abstract void mo214a(K k, V v);

    /* renamed from: b */
    protected abstract int mo215b(Object obj);

    /* renamed from: b */
    protected abstract Map<K, V> mo216b();

    /* renamed from: c */
    protected abstract void mo217c();

    AbstractC0041f() {
    }

    /* compiled from: MapCollections.java */
    /* renamed from: androidx.a.f$a */
    final class a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f322a;

        /* renamed from: b */
        int f323b;

        /* renamed from: c */
        int f324c;

        /* renamed from: d */
        boolean f325d = false;

        a(int i) {
            this.f322a = i;
            this.f323b = AbstractC0041f.this.mo209a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f324c < this.f323b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) AbstractC0041f.this.mo211a(this.f324c, this.f322a);
            this.f324c++;
            this.f325d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f325d) {
                throw new IllegalStateException();
            }
            this.f324c--;
            this.f323b--;
            this.f325d = false;
            AbstractC0041f.this.mo213a(this.f324c);
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: androidx.a.f$d */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f329a;

        /* renamed from: c */
        boolean f331c = false;

        /* renamed from: b */
        int f330b = -1;

        d() {
            this.f329a = AbstractC0041f.this.mo209a() - 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f330b < this.f329a;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f330b++;
            this.f331c = true;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f331c) {
                throw new IllegalStateException();
            }
            AbstractC0041f.this.mo213a(this.f330b);
            this.f330b--;
            this.f329a--;
            this.f331c = false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.f331c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) AbstractC0041f.this.mo211a(this.f330b, 0);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.f331c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) AbstractC0041f.this.mo211a(this.f330b, 1);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (!this.f331c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) AbstractC0041f.this.mo212a(this.f330b, (int) v);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f331c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return C0038c.m230a(entry.getKey(), AbstractC0041f.this.mo211a(this.f330b, 0)) && C0038c.m230a(entry.getValue(), AbstractC0041f.this.mo211a(this.f330b, 1));
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f331c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object mo211a = AbstractC0041f.this.mo211a(this.f330b, 0);
            Object mo211a2 = AbstractC0041f.this.mo211a(this.f330b, 1);
            return (mo211a2 != null ? mo211a2.hashCode() : 0) ^ (mo211a == null ? 0 : mo211a.hashCode());
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: androidx.a.f$b */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int mo209a = AbstractC0041f.this.mo209a();
            for (Map.Entry<K, V> entry : collection) {
                AbstractC0041f.this.mo214a((AbstractC0041f) entry.getKey(), (K) entry.getValue());
            }
            return mo209a != AbstractC0041f.this.mo209a();
        }

        @Override // java.util.Set
        public void clear() {
            AbstractC0041f.this.mo217c();
        }

        @Override // java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int mo210a = AbstractC0041f.this.mo210a(entry.getKey());
            if (mo210a >= 0) {
                return C0038c.m230a(AbstractC0041f.this.mo211a(mo210a, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return AbstractC0041f.this.mo209a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public int size() {
            return AbstractC0041f.this.mo209a();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean equals(Object obj) {
            return AbstractC0041f.m252a((Set) this, obj);
        }

        @Override // java.util.Set
        public int hashCode() {
            int mo209a = AbstractC0041f.this.mo209a() - 1;
            int i = 0;
            while (mo209a >= 0) {
                Object mo211a = AbstractC0041f.this.mo211a(mo209a, 0);
                Object mo211a2 = AbstractC0041f.this.mo211a(mo209a, 1);
                mo209a--;
                i += (mo211a2 == null ? 0 : mo211a2.hashCode()) ^ (mo211a == null ? 0 : mo211a.hashCode());
            }
            return i;
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: androidx.a.f$c */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public void clear() {
            AbstractC0041f.this.mo217c();
        }

        @Override // java.util.Set
        public boolean contains(Object obj) {
            return AbstractC0041f.this.mo210a(obj) >= 0;
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return AbstractC0041f.m251a((Map) AbstractC0041f.this.mo216b(), collection);
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return AbstractC0041f.this.mo209a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set
        public boolean remove(Object obj) {
            int mo210a = AbstractC0041f.this.mo210a(obj);
            if (mo210a < 0) {
                return false;
            }
            AbstractC0041f.this.mo213a(mo210a);
            return true;
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return AbstractC0041f.m253b(AbstractC0041f.this.mo216b(), collection);
        }

        @Override // java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return AbstractC0041f.m254c(AbstractC0041f.this.mo216b(), collection);
        }

        @Override // java.util.Set
        public int size() {
            return AbstractC0041f.this.mo209a();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            return AbstractC0041f.this.m256b(0);
        }

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0041f.this.m255a(tArr, 0);
        }

        @Override // java.util.Set
        public boolean equals(Object obj) {
            return AbstractC0041f.m252a((Set) this, obj);
        }

        @Override // java.util.Set
        public int hashCode() {
            int i = 0;
            for (int mo209a = AbstractC0041f.this.mo209a() - 1; mo209a >= 0; mo209a--) {
                Object mo211a = AbstractC0041f.this.mo211a(mo209a, 0);
                i += mo211a == null ? 0 : mo211a.hashCode();
            }
            return i;
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: androidx.a.f$e */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            AbstractC0041f.this.mo217c();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AbstractC0041f.this.mo215b(obj) >= 0;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return AbstractC0041f.this.mo209a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int mo215b = AbstractC0041f.this.mo215b(obj);
            if (mo215b < 0) {
                return false;
            }
            AbstractC0041f.this.mo213a(mo215b);
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            int mo209a = AbstractC0041f.this.mo209a();
            int i = 0;
            boolean z = false;
            while (i < mo209a) {
                if (collection.contains(AbstractC0041f.this.mo211a(i, 1))) {
                    AbstractC0041f.this.mo213a(i);
                    i--;
                    mo209a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            int mo209a = AbstractC0041f.this.mo209a();
            int i = 0;
            boolean z = false;
            while (i < mo209a) {
                if (!collection.contains(AbstractC0041f.this.mo211a(i, 1))) {
                    AbstractC0041f.this.mo213a(i);
                    i--;
                    mo209a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return AbstractC0041f.this.mo209a();
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            return AbstractC0041f.this.m256b(1);
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0041f.this.m255a(tArr, 1);
        }
    }

    /* renamed from: a */
    public static <K, V> boolean m251a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m253b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m254c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: b */
    public Object[] m256b(int i) {
        int mo209a = mo209a();
        Object[] objArr = new Object[mo209a];
        for (int i2 = 0; i2 < mo209a; i2++) {
            objArr[i2] = mo211a(i2, i);
        }
        return objArr;
    }

    /* renamed from: a */
    public <T> T[] m255a(T[] tArr, int i) {
        int mo209a = mo209a();
        Object[] objArr = tArr.length < mo209a ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), mo209a)) : tArr;
        for (int i2 = 0; i2 < mo209a; i2++) {
            objArr[i2] = mo211a(i2, i);
        }
        if (objArr.length > mo209a) {
            objArr[mo209a] = null;
        }
        return (T[]) objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        if (r4.containsAll(r5) != false) goto L13;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> boolean m252a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
            }
            z = false;
            return z;
        } catch (ClassCastException e2) {
            return false;
        } catch (NullPointerException e3) {
            return false;
        }
    }

    /* renamed from: d */
    public Set<Map.Entry<K, V>> m257d() {
        if (this.f319b == null) {
            this.f319b = new b();
        }
        return this.f319b;
    }

    /* renamed from: e */
    public Set<K> m258e() {
        if (this.f320c == null) {
            this.f320c = new c();
        }
        return this.f320c;
    }

    /* renamed from: f */
    public Collection<V> m259f() {
        if (this.f321d == null) {
            this.f321d = new e();
        }
        return this.f321d;
    }
}
