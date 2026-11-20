package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableSortedMap.java */
/* renamed from: com.f.a.c.ab */
/* loaded from: classes.dex */
public final class C1149ab<K, V> extends AbstractC1150ac<K, V> implements NavigableMap<K, V> {

    /* renamed from: b */
    private static final Comparator<Comparable> f7769b = AbstractC1163ap.m9957b();

    /* renamed from: c */
    private static final C1149ab<Comparable, Object> f7770c = new C1149ab<>(AbstractC1151ad.m9846a((Comparator) AbstractC1163ap.m9957b()), AbstractC1208w.m10138g());

    /* renamed from: d */
    private final transient C1173az<K> f7771d;

    /* renamed from: e */
    private final transient AbstractC1208w<V> f7772e;

    /* renamed from: f */
    private transient C1149ab<K, V> f7773f;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* synthetic */ NavigableMap headMap(Object obj, boolean z) {
        return m9821a((C1149ab<K, V>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* synthetic */ SortedMap headMap(Object obj) {
        return m9819a((C1149ab<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* synthetic */ SortedMap tailMap(Object obj) {
        return m9823b((C1149ab<K, V>) obj);
    }

    /* renamed from: a */
    static <K, V> C1149ab<K, V> m9816a(Comparator<? super K> comparator) {
        if (AbstractC1163ap.m9957b().equals(comparator)) {
            return m9814a();
        }
        return new C1149ab<>(AbstractC1151ad.m9846a((Comparator) comparator), AbstractC1208w.m10138g());
    }

    /* renamed from: a */
    public static <K, V> C1149ab<K, V> m9814a() {
        return (C1149ab<K, V>) f7770c;
    }

    C1149ab(C1173az<K> c1173az, AbstractC1208w<V> abstractC1208w) {
        this(c1173az, abstractC1208w, null);
    }

    C1149ab(C1173az<K> c1173az, AbstractC1208w<V> abstractC1208w, C1149ab<K, V> c1149ab) {
        this.f7771d = c1173az;
        this.f7772e = abstractC1208w;
        this.f7773f = c1149ab;
    }

    @Override // java.util.Map
    public int size() {
        return this.f7772e.size();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x, java.util.Map
    public V get(@NullableDecl Object obj) {
        int mo9857d = this.f7771d.mo9857d(obj);
        if (mo9857d == -1) {
            return null;
        }
        return this.f7772e.get(mo9857d);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: n */
    boolean mo9835n() {
        return this.f7771d.mo9838f() || this.f7772e.mo9838f();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x, java.util.Map
    /* renamed from: j */
    public AbstractC1148aa<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* compiled from: ImmutableSortedMap.java */
    /* renamed from: com.f.a.c.ab$a */
    class a extends AbstractC1210y<K, V> {
        a() {
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: a */
        public AbstractC1185bk<Map.Entry<K, V>> iterator() {
            return mo9804e().iterator();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa
        /* renamed from: j */
        AbstractC1208w<Map.Entry<K, V>> mo9806j() {
            return new AbstractC1208w<Map.Entry<K, V>>() { // from class: com.f.a.c.ab.a.1
                @Override // java.util.List
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> get(int i) {
                    return new AbstractMap.SimpleImmutableEntry(C1149ab.this.f7771d.mo9804e().get(i), C1149ab.this.f7772e.get(i));
                }

                @Override // com.p129f.p130a.p133c.AbstractC1206u
                /* renamed from: f */
                boolean mo9838f() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return C1149ab.this.size();
                }
            };
        }

        @Override // com.p129f.p130a.p133c.AbstractC1210y
        /* renamed from: g */
        AbstractC1209x<K, V> mo9836g() {
            return C1149ab.this;
        }
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: k */
    AbstractC1148aa<Map.Entry<K, V>> mo9832k() {
        return isEmpty() ? AbstractC1148aa.m9802i() : new a();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<K> keySet() {
        return this.f7771d;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: m */
    AbstractC1148aa<K> mo9834m() {
        throw new AssertionError("should never be called");
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x, java.util.Map
    /* renamed from: h */
    public AbstractC1206u<V> values() {
        return this.f7772e;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: g */
    AbstractC1206u<V> mo9829g() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    /* renamed from: a */
    private C1149ab<K, V> m9815a(int i, int i2) {
        if (i != 0 || i2 != size()) {
            if (i == i2) {
                return m9816a((Comparator) comparator());
            }
            return new C1149ab<>(this.f7771d.m9997b(i, i2), this.f7772e.subList(i, i2));
        }
        return this;
    }

    /* renamed from: a */
    public C1149ab<K, V> m9819a(K k) {
        return m9821a((C1149ab<K, V>) k, false);
    }

    /* renamed from: a */
    public C1149ab<K, V> m9821a(K k, boolean z) {
        return m9815a(0, this.f7771d.m9998e(C1120o.m9547a(k), z));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1149ab<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1149ab<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        C1120o.m9547a(k);
        C1120o.m9547a(k2);
        C1120o.m9554a(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return m9821a((C1149ab<K, V>) k2, z2).tailMap(k, z);
    }

    /* renamed from: b */
    public C1149ab<K, V> m9823b(K k) {
        return tailMap(k, true);
    }

    @Override // java.util.NavigableMap
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1149ab<K, V> tailMap(K k, boolean z) {
        return m9815a(this.f7771d.m9999f(C1120o.m9547a(k), z), size());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return m9821a((C1149ab<K, V>) k, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return (K) C1157aj.m9926a(lowerEntry(k));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return m9821a((C1149ab<K, V>) k, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return (K) C1157aj.m9926a(floorEntry(k));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return (K) C1157aj.m9926a(ceilingEntry(k));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return (K) C1157aj.m9926a(higherEntry(k));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().mo9804e().get(0);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().mo9804e().get(size() - 1);
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C1149ab<K, V> descendingMap() {
        C1149ab<K, V> c1149ab = this.f7773f;
        if (c1149ab == null) {
            if (isEmpty()) {
                return m9816a((Comparator) AbstractC1163ap.m9956a(comparator()).mo9951a());
            }
            return new C1149ab<>((C1173az) this.f7771d.descendingSet(), this.f7772e.mo10143i(), this);
        }
        return c1149ab;
    }

    @Override // java.util.NavigableMap
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<K> navigableKeySet() {
        return this.f7771d;
    }

    @Override // java.util.NavigableMap
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<K> descendingKeySet() {
        return this.f7771d.descendingSet();
    }
}
