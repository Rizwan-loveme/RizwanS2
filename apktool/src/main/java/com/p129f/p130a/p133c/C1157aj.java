package com.p129f.p130a.p133c;

import com.google.j2objc.annotations.Weak;
import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p133c.C1177bc;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Maps.java */
/* renamed from: com.f.a.c.aj */
/* loaded from: classes.dex */
public final class C1157aj {

    /* compiled from: Maps.java */
    /* renamed from: com.f.a.c.aj$a */
    private enum a implements InterfaceC1112g<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.f.a.c.aj.a.1
            @Override // com.p129f.p130a.p131a.InterfaceC1112g
            @NullableDecl
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public Object mo9517a(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.f.a.c.aj.a.2
            @Override // com.p129f.p130a.p131a.InterfaceC1112g
            @NullableDecl
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public Object mo9517a(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    /* renamed from: a */
    static <K> InterfaceC1112g<Map.Entry<K, ?>, K> m9925a() {
        return a.KEY;
    }

    /* renamed from: b */
    static <V> InterfaceC1112g<Map.Entry<?, V>, V> m9931b() {
        return a.VALUE;
    }

    /* renamed from: a */
    static <K, V> Iterator<K> m9929a(Iterator<Map.Entry<K, V>> it) {
        return new AbstractC1182bh<Map.Entry<K, V>, K>(it) { // from class: com.f.a.c.aj.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p129f.p130a.p133c.AbstractC1182bh
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public K mo9904a(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    /* renamed from: b */
    static <K, V> Iterator<V> m9932b(Iterator<Map.Entry<K, V>> it) {
        return new AbstractC1182bh<Map.Entry<K, V>, V>(it) { // from class: com.f.a.c.aj.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p129f.p130a.p133c.AbstractC1182bh
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public V mo9904a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }

    /* renamed from: c */
    public static <K, V> HashMap<K, V> m9935c() {
        return new HashMap<>();
    }

    /* renamed from: a */
    static int m9924a(int i) {
        if (i < 3) {
            C1197l.m10052a(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: d */
    public static <K, V> LinkedHashMap<K, V> m9936d() {
        return new LinkedHashMap<>();
    }

    /* renamed from: a */
    public static <K, V> Map.Entry<K, V> m9930a(@NullableDecl K k, @NullableDecl V v) {
        return new C1207v(k, v);
    }

    /* compiled from: Maps.java */
    /* renamed from: com.f.a.c.aj$e */
    static abstract class e<K, V> extends AbstractMap<K, V> {

        /* renamed from: a */
        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> f7823a;

        /* renamed from: b */
        @MonotonicNonNullDecl
        private transient Set<K> f7824b;

        /* renamed from: c */
        @MonotonicNonNullDecl
        private transient Collection<V> f7825c;

        /* renamed from: a */
        abstract Set<Map.Entry<K, V>> mo9943a();

        e() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f7823a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> mo9943a = mo9943a();
            this.f7823a = mo9943a;
            return mo9943a;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f7824b;
            if (set != null) {
                return set;
            }
            Set<K> m9944b = m9944b();
            this.f7824b = m9944b;
            return m9944b;
        }

        /* renamed from: b */
        Set<K> m9944b() {
            return new c(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f7825c;
            if (collection != null) {
                return collection;
            }
            Collection<V> m9945c = m9945c();
            this.f7825c = m9945c;
            return m9945c;
        }

        /* renamed from: c */
        Collection<V> m9945c() {
            return new d(this);
        }
    }

    /* renamed from: a */
    static <V> V m9927a(Map<?, V> map, @NullableDecl Object obj) {
        C1120o.m9547a(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: b */
    static boolean m9933b(Map<?, ?> map, Object obj) {
        C1120o.m9547a(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return false;
        }
    }

    /* renamed from: c */
    static <V> V m9934c(Map<?, V> map, Object obj) {
        C1120o.m9547a(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: d */
    static boolean m9937d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* renamed from: a */
    static String m9928a(Map<?, ?> map) {
        StringBuilder append = C1198m.m10055a(map.size()).append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                append.append(", ");
            }
            z = false;
            append.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return append.append('}').toString();
    }

    /* compiled from: Maps.java */
    /* renamed from: com.f.a.c.aj$c */
    static class c<K, V> extends C1177bc.a<K> {

        /* renamed from: b */
        @Weak
        final Map<K, V> f7821b;

        c(Map<K, V> map) {
            this.f7821b = (Map) C1120o.m9547a(map);
        }

        /* renamed from: a */
        Map<K, V> m9941a() {
            return this.f7821b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return C1157aj.m9929a(m9941a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m9941a().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return m9941a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return m9941a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            m9941a().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            m9941a().clear();
        }
    }

    @NullableDecl
    /* renamed from: a */
    static <K> K m9926a(@NullableDecl Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* compiled from: Maps.java */
    /* renamed from: com.f.a.c.aj$d */
    static class d<K, V> extends AbstractCollection<V> {

        /* renamed from: a */
        @Weak
        final Map<K, V> f7822a;

        d(Map<K, V> map) {
            this.f7822a = (Map) C1120o.m9547a(map);
        }

        /* renamed from: a */
        final Map<K, V> m9942a() {
            return this.f7822a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return C1157aj.m9932b(m9942a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException e2) {
                for (Map.Entry<K, V> entry : m9942a().entrySet()) {
                    if (C1116k.m9538a(obj, entry.getValue())) {
                        m9942a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) C1120o.m9547a(collection));
            } catch (UnsupportedOperationException e2) {
                HashSet m10005a = C1177bc.m10005a();
                for (Map.Entry<K, V> entry : m9942a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        m10005a.add(entry.getKey());
                    }
                }
                return m9942a().keySet().removeAll(m10005a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) C1120o.m9547a(collection));
            } catch (UnsupportedOperationException e2) {
                HashSet m10005a = C1177bc.m10005a();
                for (Map.Entry<K, V> entry : m9942a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        m10005a.add(entry.getKey());
                    }
                }
                return m9942a().keySet().retainAll(m10005a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m9942a().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return m9942a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return m9942a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            m9942a().clear();
        }
    }

    /* compiled from: Maps.java */
    /* renamed from: com.f.a.c.aj$b */
    static abstract class b<K, V> extends C1177bc.a<Map.Entry<K, V>> {
        /* renamed from: a */
        abstract Map<K, V> mo9940a();

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return mo9940a().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            mo9940a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object m9927a = C1157aj.m9927a((Map<?, Object>) mo9940a(), key);
            if (C1116k.m9538a(m9927a, entry.getValue())) {
                return m9927a != null || mo9940a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return mo9940a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return mo9940a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.p129f.p130a.p133c.C1177bc.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) C1120o.m9547a(collection));
            } catch (UnsupportedOperationException e2) {
                return C1177bc.m10009a((Set<?>) this, collection.iterator());
            }
        }

        @Override // com.p129f.p130a.p133c.C1177bc.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) C1120o.m9547a(collection));
            } catch (UnsupportedOperationException e2) {
                HashSet m10006a = C1177bc.m10006a(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        m10006a.add(((Map.Entry) obj).getKey());
                    }
                }
                return mo9940a().keySet().retainAll(m10006a);
            }
        }
    }
}
