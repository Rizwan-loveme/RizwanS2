package com.p129f.p130a.p133c;

import android.widget.ExpandableListView;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p131a.C1120o;
import java.p209io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: CompactHashMap.java */
/* renamed from: com.f.a.c.n */
/* loaded from: classes.dex */
class C1199n<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a */
    @MonotonicNonNullDecl
    transient long[] f7916a;

    /* renamed from: b */
    @MonotonicNonNullDecl
    transient Object[] f7917b;

    /* renamed from: c */
    @MonotonicNonNullDecl
    transient Object[] f7918c;

    /* renamed from: d */
    transient float f7919d;

    /* renamed from: e */
    transient int f7920e;

    /* renamed from: f */
    @MonotonicNonNullDecl
    private transient int[] f7921f;

    /* renamed from: g */
    private transient int f7922g;

    /* renamed from: h */
    private transient int f7923h;

    /* renamed from: i */
    @MonotonicNonNullDecl
    private transient Set<K> f7924i;

    /* renamed from: j */
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> f7925j;

    /* renamed from: k */
    @MonotonicNonNullDecl
    private transient Collection<V> f7926k;

    /* renamed from: a */
    public static <K, V> C1199n<K, V> m10063a(int i) {
        return new C1199n<>(i);
    }

    C1199n() {
        m10075a(3, 1.0f);
    }

    C1199n(int i) {
        this(i, 1.0f);
    }

    C1199n(int i, float f2) {
        m10075a(i, f2);
    }

    /* renamed from: a */
    void m10075a(int i, float f2) {
        C1120o.m9551a(i >= 0, "Initial capacity must be non-negative");
        C1120o.m9551a(f2 > 0.0f, "Illegal load factor");
        int m10118a = C1204s.m10118a(i, f2);
        this.f7921f = m10067f(m10118a);
        this.f7919d = f2;
        this.f7917b = new Object[i];
        this.f7918c = new Object[i];
        this.f7916a = m10068g(i);
        this.f7922g = Math.max(1, (int) (m10118a * f2));
    }

    /* renamed from: f */
    private static int[] m10067f(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* renamed from: g */
    private static long[] m10068g(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    /* renamed from: h */
    private int m10069h() {
        return this.f7921f.length - 1;
    }

    /* renamed from: a */
    private static int m10058a(long j) {
        return (int) (j >>> 32);
    }

    /* renamed from: b */
    private static int m10066b(long j) {
        return (int) j;
    }

    /* renamed from: a */
    private static long m10062a(long j, int i) {
        return ((-4294967296L) & j) | (ExpandableListView.PACKED_POSITION_VALUE_NULL & i);
    }

    /* renamed from: b */
    void m10078b(int i) {
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v) {
        long[] jArr = this.f7916a;
        Object[] objArr = this.f7917b;
        Object[] objArr2 = this.f7918c;
        int m10119a = C1204s.m10119a(k);
        int m10069h = m10119a & m10069h();
        int i = this.f7923h;
        int i2 = this.f7921f[m10069h];
        if (i2 == -1) {
            this.f7921f[m10069h] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (m10058a(j) == m10119a && C1116k.m9538a(k, objArr[i2])) {
                    V v2 = (V) objArr2[i2];
                    objArr2[i2] = v;
                    m10078b(i2);
                    return v2;
                }
                int m10066b = m10066b(j);
                if (m10066b == -1) {
                    jArr[i2] = m10062a(j, i);
                    break;
                }
                i2 = m10066b;
            }
        }
        if (i == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i3 = i + 1;
        m10070h(i3);
        m10076a(i, k, v, m10119a);
        this.f7923h = i3;
        if (i >= this.f7922g) {
            m10071i(this.f7921f.length * 2);
        }
        this.f7920e++;
        return null;
    }

    /* renamed from: a */
    void m10076a(int i, @NullableDecl K k, @NullableDecl V v, int i2) {
        this.f7916a[i] = (i2 << 32) | ExpandableListView.PACKED_POSITION_VALUE_NULL;
        this.f7917b[i] = k;
        this.f7918c[i] = v;
    }

    /* renamed from: h */
    private void m10070h(int i) {
        int length = this.f7916a.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                m10080c(max);
            }
        }
    }

    /* renamed from: c */
    void m10080c(int i) {
        this.f7917b = Arrays.copyOf(this.f7917b, i);
        this.f7918c = Arrays.copyOf(this.f7918c, i);
        long[] jArr = this.f7916a;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f7916a = copyOf;
    }

    /* renamed from: i */
    private void m10071i(int i) {
        if (this.f7921f.length >= 1073741824) {
            this.f7922g = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.f7919d)) + 1;
        int[] m10067f = m10067f(i);
        long[] jArr = this.f7916a;
        int length = m10067f.length - 1;
        for (int i3 = 0; i3 < this.f7923h; i3++) {
            int m10058a = m10058a(jArr[i3]);
            int i4 = m10058a & length;
            int i5 = m10067f[i4];
            m10067f[i4] = i3;
            jArr[i3] = (i5 & ExpandableListView.PACKED_POSITION_VALUE_NULL) | (m10058a << 32);
        }
        this.f7922g = i2;
        this.f7921f = m10067f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m10061a(@NullableDecl Object obj) {
        int m10119a = C1204s.m10119a(obj);
        int i = this.f7921f[m10069h() & m10119a];
        while (i != -1) {
            long j = this.f7916a[i];
            if (m10058a(j) != m10119a || !C1116k.m9538a(obj, this.f7917b[i])) {
                i = m10066b(j);
            } else {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return m10061a(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int m10061a = m10061a(obj);
        m10078b(m10061a);
        if (m10061a == -1) {
            return null;
        }
        return (V) this.f7918c[m10061a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return m10065a(obj, C1204s.m10119a(obj));
    }

    @NullableDecl
    /* renamed from: a */
    private V m10065a(@NullableDecl Object obj, int i) {
        int m10069h = i & m10069h();
        int i2 = this.f7921f[m10069h];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (m10058a(this.f7916a[i2]) == i && C1116k.m9538a(obj, this.f7917b[i2])) {
                V v = (V) this.f7918c[i2];
                if (i3 == -1) {
                    this.f7921f[m10069h] = m10066b(this.f7916a[i2]);
                } else {
                    this.f7916a[i3] = m10062a(this.f7916a[i3], m10066b(this.f7916a[i2]));
                }
                m10082d(i2);
                this.f7923h--;
                this.f7920e++;
                return v;
            }
            int m10066b = m10066b(this.f7916a[i2]);
            if (m10066b == -1) {
                return null;
            }
            i3 = i2;
            i2 = m10066b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    /* renamed from: j */
    public V m10072j(int i) {
        return m10065a(this.f7917b[i], m10058a(this.f7916a[i]));
    }

    /* renamed from: d */
    void m10082d(int i) {
        int size = size() - 1;
        if (i < size) {
            this.f7917b[i] = this.f7917b[size];
            this.f7918c[i] = this.f7918c[size];
            this.f7917b[size] = null;
            this.f7918c[size] = null;
            long j = this.f7916a[size];
            this.f7916a[i] = j;
            this.f7916a[size] = -1;
            int m10069h = m10069h() & m10058a(j);
            int i2 = this.f7921f[m10069h];
            if (i2 == size) {
                this.f7921f[m10069h] = i;
                return;
            }
            while (true) {
                long j2 = this.f7916a[i2];
                int m10066b = m10066b(j2);
                if (m10066b == size) {
                    this.f7916a[i2] = m10062a(j2, i);
                    return;
                }
                i2 = m10066b;
            }
        } else {
            this.f7917b[i] = null;
            this.f7918c[i] = null;
            this.f7916a[i] = -1;
        }
    }

    /* renamed from: a */
    int m10073a() {
        return isEmpty() ? -1 : 0;
    }

    /* renamed from: e */
    int m10083e(int i) {
        if (i + 1 < this.f7923h) {
            return i + 1;
        }
        return -1;
    }

    /* renamed from: a */
    int m10074a(int i, int i2) {
        return i - 1;
    }

    /* compiled from: CompactHashMap.java */
    /* renamed from: com.f.a.c.n$b */
    private abstract class b<T> implements Iterator<T> {

        /* renamed from: b */
        int f7931b;

        /* renamed from: c */
        int f7932c;

        /* renamed from: d */
        int f7933d;

        /* renamed from: a */
        abstract T mo10087a(int i);

        private b() {
            this.f7931b = C1199n.this.f7920e;
            this.f7932c = C1199n.this.m10073a();
            this.f7933d = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7932c >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            m10089a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f7933d = this.f7932c;
            T mo10087a = mo10087a(this.f7932c);
            this.f7932c = C1199n.this.m10083e(this.f7932c);
            return mo10087a;
        }

        @Override // java.util.Iterator
        public void remove() {
            m10089a();
            C1197l.m10054a(this.f7933d >= 0);
            this.f7931b++;
            C1199n.this.m10072j(this.f7933d);
            this.f7932c = C1199n.this.m10074a(this.f7932c, this.f7933d);
            this.f7933d = -1;
        }

        /* renamed from: a */
        private void m10089a() {
            if (C1199n.this.f7920e != this.f7931b) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        if (this.f7924i != null) {
            return this.f7924i;
        }
        Set<K> m10077b = m10077b();
        this.f7924i = m10077b;
        return m10077b;
    }

    /* renamed from: b */
    Set<K> m10077b() {
        return new c();
    }

    /* compiled from: CompactHashMap.java */
    /* renamed from: com.f.a.c.n$c */
    class c extends AbstractSet<K> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1199n.this.f7923h;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C1199n.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int m10061a = C1199n.this.m10061a(obj);
            if (m10061a != -1) {
                C1199n.this.m10072j(m10061a);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return C1199n.this.m10079c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1199n.this.clear();
        }
    }

    /* renamed from: c */
    Iterator<K> m10079c() {
        return new C1199n<K, V>.b<K>() { // from class: com.f.a.c.n.1
            @Override // com.p129f.p130a.p133c.C1199n.b
            /* renamed from: a */
            K mo10087a(int i) {
                return (K) C1199n.this.f7917b[i];
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f7925j != null) {
            return this.f7925j;
        }
        Set<Map.Entry<K, V>> m10081d = m10081d();
        this.f7925j = m10081d;
        return m10081d;
    }

    /* renamed from: d */
    Set<Map.Entry<K, V>> m10081d() {
        return new a();
    }

    /* compiled from: CompactHashMap.java */
    /* renamed from: com.f.a.c.n$a */
    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1199n.this.f7923h;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1199n.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return C1199n.this.m10084e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int m10061a = C1199n.this.m10061a(entry.getKey());
            return m10061a != -1 && C1116k.m9538a(C1199n.this.f7918c[m10061a], entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int m10061a = C1199n.this.m10061a(entry.getKey());
                if (m10061a != -1 && C1116k.m9538a(C1199n.this.f7918c[m10061a], entry.getValue())) {
                    C1199n.this.m10072j(m10061a);
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: e */
    Iterator<Map.Entry<K, V>> m10084e() {
        return new C1199n<K, V>.b<Map.Entry<K, V>>() { // from class: com.f.a.c.n.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p129f.p130a.p133c.C1199n.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> mo10087a(int i) {
                return new d(i);
            }
        };
    }

    /* compiled from: CompactHashMap.java */
    /* renamed from: com.f.a.c.n$d */
    final class d extends AbstractC1190e<K, V> {

        /* renamed from: b */
        @NullableDecl
        private final K f7937b;

        /* renamed from: c */
        private int f7938c;

        d(int i) {
            this.f7937b = (K) C1199n.this.f7917b[i];
            this.f7938c = i;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1190e, java.util.Map.Entry
        public K getKey() {
            return this.f7937b;
        }

        /* renamed from: a */
        private void m10090a() {
            if (this.f7938c == -1 || this.f7938c >= C1199n.this.size() || !C1116k.m9538a(this.f7937b, C1199n.this.f7917b[this.f7938c])) {
                this.f7938c = C1199n.this.m10061a(this.f7937b);
            }
        }

        @Override // com.p129f.p130a.p133c.AbstractC1190e, java.util.Map.Entry
        public V getValue() {
            m10090a();
            if (this.f7938c == -1) {
                return null;
            }
            return (V) C1199n.this.f7918c[this.f7938c];
        }

        @Override // com.p129f.p130a.p133c.AbstractC1190e, java.util.Map.Entry
        public V setValue(V v) {
            m10090a();
            if (this.f7938c == -1) {
                C1199n.this.put(this.f7937b, v);
                return null;
            }
            V v2 = (V) C1199n.this.f7918c[this.f7938c];
            C1199n.this.f7918c[this.f7938c] = v;
            return v2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f7923h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f7923h == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i = 0; i < this.f7923h; i++) {
            if (C1116k.m9538a(obj, this.f7918c[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        if (this.f7926k != null) {
            return this.f7926k;
        }
        Collection<V> m10085f = m10085f();
        this.f7926k = m10085f;
        return m10085f;
    }

    /* renamed from: f */
    Collection<V> m10085f() {
        return new e();
    }

    /* compiled from: CompactHashMap.java */
    /* renamed from: com.f.a.c.n$e */
    class e extends AbstractCollection<V> {
        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1199n.this.f7923h;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1199n.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return C1199n.this.m10086g();
        }
    }

    /* renamed from: g */
    Iterator<V> m10086g() {
        return new C1199n<K, V>.b<V>() { // from class: com.f.a.c.n.3
            @Override // com.p129f.p130a.p133c.C1199n.b
            /* renamed from: a */
            V mo10087a(int i) {
                return (V) C1199n.this.f7918c[i];
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f7920e++;
        Arrays.fill(this.f7917b, 0, this.f7923h, (Object) null);
        Arrays.fill(this.f7918c, 0, this.f7923h, (Object) null);
        Arrays.fill(this.f7921f, -1);
        Arrays.fill(this.f7916a, -1L);
        this.f7923h = 0;
    }
}
