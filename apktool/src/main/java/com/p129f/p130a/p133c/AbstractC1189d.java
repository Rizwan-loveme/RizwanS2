package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p133c.C1157aj;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractMapBasedMultimap.java */
/* renamed from: com.f.a.c.d */
/* loaded from: classes.dex */
abstract class AbstractC1189d<K, V> extends AbstractC1191f<K, V> implements Serializable {

    /* renamed from: a */
    private transient Map<K, Collection<V>> f7887a;

    /* renamed from: b */
    private transient int f7888b;

    /* renamed from: c */
    abstract Collection<V> mo10021c();

    /* renamed from: b */
    static /* synthetic */ int m10027b(AbstractC1189d abstractC1189d) {
        int i = abstractC1189d.f7888b;
        abstractC1189d.f7888b = i - 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m10029c(AbstractC1189d abstractC1189d) {
        int i = abstractC1189d.f7888b;
        abstractC1189d.f7888b = i + 1;
        return i;
    }

    protected AbstractC1189d(Map<K, Collection<V>> map) {
        C1120o.m9550a(map.isEmpty());
        this.f7887a = map;
    }

    /* renamed from: c */
    Collection<V> m10032c(@NullableDecl K k) {
        return mo10021c();
    }

    /* renamed from: d */
    public void mo10033d() {
        Iterator<Collection<V>> it = this.f7887a.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f7887a.clear();
        this.f7888b = 0;
    }

    @Override // com.p129f.p130a.p133c.InterfaceC1158ak
    /* renamed from: b */
    public Collection<V> mo9946b(@NullableDecl K k) {
        Collection<V> collection = this.f7887a.get(k);
        if (collection == null) {
            collection = m10032c((AbstractC1189d<K, V>) k);
        }
        return mo10018a((AbstractC1189d<K, V>) k, (Collection) collection);
    }

    /* renamed from: a */
    Collection<V> mo10018a(@NullableDecl K k, Collection<V> collection) {
        return new d(k, collection, null);
    }

    /* renamed from: a */
    final List<V> m10031a(@NullableDecl K k, List<V> list, @NullableDecl AbstractC1189d<K, V>.d dVar) {
        return list instanceof RandomAccess ? new c(k, list, dVar) : new e(k, list, dVar);
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: com.f.a.c.d$d */
    class d extends AbstractCollection<V> {

        /* renamed from: b */
        @NullableDecl
        final K f7900b;

        /* renamed from: c */
        Collection<V> f7901c;

        /* renamed from: d */
        @NullableDecl
        final AbstractC1189d<K, V>.d f7902d;

        /* renamed from: e */
        @NullableDecl
        final Collection<V> f7903e;

        d(K k, @NullableDecl Collection<V> collection, AbstractC1189d<K, V>.d dVar) {
            this.f7900b = k;
            this.f7901c = collection;
            this.f7902d = dVar;
            this.f7903e = dVar == null ? null : dVar.m10044e();
        }

        /* renamed from: a */
        void m10040a() {
            Collection<V> collection;
            if (this.f7902d != null) {
                this.f7902d.m10040a();
                if (this.f7902d.m10044e() != this.f7903e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f7901c.isEmpty() && (collection = (Collection) AbstractC1189d.this.f7887a.get(this.f7900b)) != null) {
                this.f7901c = collection;
            }
        }

        /* renamed from: b */
        void m10041b() {
            if (this.f7902d != null) {
                this.f7902d.m10041b();
            } else if (this.f7901c.isEmpty()) {
                AbstractC1189d.this.f7887a.remove(this.f7900b);
            }
        }

        /* renamed from: c */
        K m10042c() {
            return this.f7900b;
        }

        /* renamed from: d */
        void m10043d() {
            if (this.f7902d == null) {
                AbstractC1189d.this.f7887a.put(this.f7900b, this.f7901c);
            } else {
                this.f7902d.m10043d();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            m10040a();
            return this.f7901c.size();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            m10040a();
            return this.f7901c.equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            m10040a();
            return this.f7901c.hashCode();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            m10040a();
            return this.f7901c.toString();
        }

        /* renamed from: e */
        Collection<V> m10044e() {
            return this.f7901c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            m10040a();
            return new a();
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        /* renamed from: com.f.a.c.d$d$a */
        class a implements Iterator<V> {

            /* renamed from: a */
            final Iterator<V> f7905a;

            /* renamed from: b */
            final Collection<V> f7906b;

            a() {
                this.f7906b = d.this.f7901c;
                this.f7905a = AbstractC1189d.m10028b((Collection) d.this.f7901c);
            }

            a(Iterator<V> it) {
                this.f7906b = d.this.f7901c;
                this.f7905a = it;
            }

            /* renamed from: a */
            void m10046a() {
                d.this.m10040a();
                if (d.this.f7901c != this.f7906b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                m10046a();
                return this.f7905a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                m10046a();
                return this.f7905a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f7905a.remove();
                AbstractC1189d.m10027b(AbstractC1189d.this);
                d.this.m10041b();
            }

            /* renamed from: b */
            Iterator<V> m10047b() {
                m10046a();
                return this.f7905a;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v) {
            m10040a();
            boolean isEmpty = this.f7901c.isEmpty();
            boolean add = this.f7901c.add(v);
            if (add) {
                AbstractC1189d.m10029c(AbstractC1189d.this);
                if (isEmpty) {
                    m10043d();
                }
            }
            return add;
        }

        /* renamed from: f */
        AbstractC1189d<K, V>.d m10045f() {
            return this.f7902d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f7901c.addAll(collection);
            if (addAll) {
                int size2 = this.f7901c.size();
                AbstractC1189d.this.f7888b = (size2 - size) + AbstractC1189d.this.f7888b;
                if (size == 0) {
                    m10043d();
                    return addAll;
                }
                return addAll;
            }
            return addAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            m10040a();
            return this.f7901c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            m10040a();
            return this.f7901c.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            int size = size();
            if (size != 0) {
                this.f7901c.clear();
                AbstractC1189d.this.f7888b -= size;
                m10041b();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            m10040a();
            boolean remove = this.f7901c.remove(obj);
            if (remove) {
                AbstractC1189d.m10027b(AbstractC1189d.this);
                m10041b();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f7901c.removeAll(collection);
            if (removeAll) {
                int size2 = this.f7901c.size();
                AbstractC1189d.this.f7888b = (size2 - size) + AbstractC1189d.this.f7888b;
                m10041b();
                return removeAll;
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            C1120o.m9547a(collection);
            int size = size();
            boolean retainAll = this.f7901c.retainAll(collection);
            if (retainAll) {
                int size2 = this.f7901c.size();
                AbstractC1189d.this.f7888b = (size2 - size) + AbstractC1189d.this.f7888b;
                m10041b();
            }
            return retainAll;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <E> Iterator<E> m10028b(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: com.f.a.c.d$e */
    class e extends AbstractC1189d<K, V>.d implements List<V> {
        e(K k, @NullableDecl List<V> list, AbstractC1189d<K, V>.d dVar) {
            super(k, list, dVar);
        }

        /* renamed from: g */
        List<V> m10048g() {
            return (List) m10044e();
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = m10048g().addAll(i, collection);
            if (addAll) {
                int size2 = m10044e().size();
                AbstractC1189d.this.f7888b = (size2 - size) + AbstractC1189d.this.f7888b;
                if (size == 0) {
                    m10043d();
                    return addAll;
                }
                return addAll;
            }
            return addAll;
        }

        @Override // java.util.List
        public V get(int i) {
            m10040a();
            return m10048g().get(i);
        }

        @Override // java.util.List
        public V set(int i, V v) {
            m10040a();
            return m10048g().set(i, v);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            m10040a();
            boolean isEmpty = m10044e().isEmpty();
            m10048g().add(i, v);
            AbstractC1189d.m10029c(AbstractC1189d.this);
            if (isEmpty) {
                m10043d();
            }
        }

        @Override // java.util.List
        public V remove(int i) {
            m10040a();
            V remove = m10048g().remove(i);
            AbstractC1189d.m10027b(AbstractC1189d.this);
            m10041b();
            return remove;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            m10040a();
            return m10048g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            m10040a();
            return m10048g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            m10040a();
            return new a();
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            m10040a();
            return new a(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.f.a.c.d] */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.f.a.c.d$d] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            m10040a();
            AbstractC1189d<K, V> r0 = AbstractC1189d.this;
            Object c2 = m10042c();
            List<V> subList = m10048g().subList(i, i2);
            AbstractC1189d<K, V>.d f2 = m10045f();
            AbstractC1189d<K, V>.d r4 = this;
            if (f2 != null) {
                r4 = m10045f();
            }
            return r0.m10031a(c2, subList, r4);
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        /* renamed from: com.f.a.c.d$e$a */
        private class a extends AbstractC1189d<K, V>.d.a implements ListIterator<V> {
            a() {
                super();
            }

            public a(int i) {
                super(e.this.m10048g().listIterator(i));
            }

            /* renamed from: c */
            private ListIterator<V> m10049c() {
                return (ListIterator) m10047b();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return m10049c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return m10049c().previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return m10049c().nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return m10049c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                m10049c().set(v);
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = e.this.isEmpty();
                m10049c().add(v);
                AbstractC1189d.m10029c(AbstractC1189d.this);
                if (isEmpty) {
                    e.this.m10043d();
                }
            }
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: com.f.a.c.d$c */
    private class c extends AbstractC1189d<K, V>.e implements RandomAccess {
        c(K k, @NullableDecl List<V> list, AbstractC1189d<K, V>.d dVar) {
            super(k, list, dVar);
        }
    }

    @Override // com.p129f.p130a.p133c.AbstractC1191f
    /* renamed from: e */
    Set<K> mo10034e() {
        return new b(this.f7887a);
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: com.f.a.c.d$b */
    private class b extends C1157aj.c<K, Collection<V>> {
        b(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.p129f.p130a.p133c.C1157aj.c, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> it = m9941a().entrySet().iterator();
            return new Iterator<K>() { // from class: com.f.a.c.d.b.1

                /* renamed from: a */
                @NullableDecl
                Map.Entry<K, Collection<V>> f7896a;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public K next() {
                    this.f7896a = (Map.Entry) it.next();
                    return this.f7896a.getKey();
                }

                @Override // java.util.Iterator
                public void remove() {
                    C1197l.m10054a(this.f7896a != null);
                    Collection<V> value = this.f7896a.getValue();
                    it.remove();
                    AbstractC1189d.this.f7888b -= value.size();
                    value.clear();
                    this.f7896a = null;
                }
            };
        }

        @Override // com.p129f.p130a.p133c.C1157aj.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            Collection<V> remove = m9941a().remove(obj);
            if (remove != null) {
                int size = remove.size();
                remove.clear();
                AbstractC1189d.this.f7888b -= size;
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        @Override // com.p129f.p130a.p133c.C1157aj.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1154ag.m9900d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return m9941a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || m9941a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return m9941a().keySet().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10026a(Object obj) {
        Collection collection = (Collection) C1157aj.m9934c(this.f7887a, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f7888b -= size;
        }
    }

    @Override // com.p129f.p130a.p133c.AbstractC1191f
    /* renamed from: f */
    Map<K, Collection<V>> mo10035f() {
        return new a(this.f7887a);
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: com.f.a.c.d$a */
    private class a extends C1157aj.e<K, Collection<V>> {

        /* renamed from: a */
        final transient Map<K, Collection<V>> f7889a;

        a(Map<K, Collection<V>> map) {
            this.f7889a = map;
        }

        @Override // com.p129f.p130a.p133c.C1157aj.e
        /* renamed from: a */
        protected Set<Map.Entry<K, Collection<V>>> mo9943a() {
            return new C3339a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return C1157aj.m9933b(this.f7889a, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) C1157aj.m9927a((Map) this.f7889a, obj);
            if (collection == null) {
                return null;
            }
            return AbstractC1189d.this.mo10018a((AbstractC1189d) obj, (Collection) collection);
        }

        @Override // com.p129f.p130a.p133c.C1157aj.e, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractC1189d.this.mo10050g();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f7889a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f7889a.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> mo10021c = AbstractC1189d.this.mo10021c();
            mo10021c.addAll(remove);
            AbstractC1189d.this.f7888b -= remove.size();
            remove.clear();
            return mo10021c;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.f7889a.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f7889a.hashCode();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f7889a.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f7889a == AbstractC1189d.this.f7887a) {
                AbstractC1189d.this.mo10033d();
            } else {
                C1154ag.m9900d(new b());
            }
        }

        /* renamed from: a */
        Map.Entry<K, Collection<V>> m10037a(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return C1157aj.m9930a(key, AbstractC1189d.this.mo10018a((AbstractC1189d) key, (Collection) entry.getValue()));
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        /* renamed from: com.f.a.c.d$a$a, reason: collision with other inner class name */
        class C3339a extends C1157aj.b<K, Collection<V>> {
            C3339a() {
            }

            @Override // com.p129f.p130a.p133c.C1157aj.b
            /* renamed from: a */
            Map<K, Collection<V>> mo9940a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return a.this.new b();
            }

            @Override // com.p129f.p130a.p133c.C1157aj.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return C1198m.m10057a(a.this.f7889a.entrySet(), obj);
            }

            @Override // com.p129f.p130a.p133c.C1157aj.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    AbstractC1189d.this.m10026a(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        /* renamed from: com.f.a.c.d$a$b */
        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a */
            final Iterator<Map.Entry<K, Collection<V>>> f7892a;

            /* renamed from: b */
            @NullableDecl
            Collection<V> f7893b;

            b() {
                this.f7892a = a.this.f7889a.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f7892a.hasNext();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f7892a.next();
                this.f7893b = next.getValue();
                return a.this.m10037a((Map.Entry) next);
            }

            @Override // java.util.Iterator
            public void remove() {
                C1197l.m10054a(this.f7893b != null);
                this.f7892a.remove();
                AbstractC1189d.this.f7888b -= this.f7893b.size();
                this.f7893b.clear();
                this.f7893b = null;
            }
        }
    }
}
