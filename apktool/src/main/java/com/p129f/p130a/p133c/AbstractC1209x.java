package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.p129f.p130a.p133c.AbstractC1206u;
import java.p209io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableMap.java */
/* renamed from: com.f.a.c.x */
/* loaded from: classes.dex */
public abstract class AbstractC1209x<K, V> implements Serializable, Map<K, V> {

    /* renamed from: a */
    static final Map.Entry<?, ?>[] f7965a = new Map.Entry[0];

    /* renamed from: b */
    @LazyInit
    private transient AbstractC1148aa<Map.Entry<K, V>> f7966b;

    /* renamed from: c */
    @RetainedWith
    @LazyInit
    private transient AbstractC1148aa<K> f7967c;

    /* renamed from: d */
    @RetainedWith
    @LazyInit
    private transient AbstractC1206u<V> f7968d;

    /* renamed from: g */
    abstract AbstractC1206u<V> mo9829g();

    public abstract V get(@NullableDecl Object obj);

    /* renamed from: k */
    abstract AbstractC1148aa<Map.Entry<K, V>> mo9832k();

    /* renamed from: m */
    abstract AbstractC1148aa<K> mo9834m();

    /* renamed from: n */
    abstract boolean mo9835n();

    /* renamed from: i */
    public static <K, V> AbstractC1209x<K, V> m10149i() {
        return (AbstractC1209x<K, V>) C1171ax.f7841b;
    }

    /* compiled from: ImmutableMap.java */
    /* renamed from: com.f.a.c.x$a */
    public static class a<K, V> {

        /* renamed from: a */
        @MonotonicNonNullDecl
        Comparator<? super V> f7969a;

        /* renamed from: b */
        Object[] f7970b;

        /* renamed from: c */
        int f7971c;

        /* renamed from: d */
        boolean f7972d;

        public a() {
            this(4);
        }

        a(int i) {
            this.f7970b = new Object[i * 2];
            this.f7971c = 0;
            this.f7972d = false;
        }

        /* renamed from: a */
        private void m10151a(int i) {
            if (i * 2 > this.f7970b.length) {
                this.f7970b = Arrays.copyOf(this.f7970b, AbstractC1206u.b.m10128a(this.f7970b.length, i * 2));
                this.f7972d = false;
            }
        }

        @CanIgnoreReturnValue
        /* renamed from: b */
        public a<K, V> mo10126b(K k, V v) {
            m10151a(this.f7971c + 1);
            C1197l.m10053a(k, v);
            this.f7970b[this.f7971c * 2] = k;
            this.f7970b[(this.f7971c * 2) + 1] = v;
            this.f7971c++;
            return this;
        }

        /* renamed from: b */
        void m10152b() {
            if (this.f7969a != null) {
                if (this.f7972d) {
                    this.f7970b = Arrays.copyOf(this.f7970b, this.f7971c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f7971c];
                for (int i = 0; i < this.f7971c; i++) {
                    entryArr[i] = new AbstractMap.SimpleImmutableEntry(this.f7970b[i * 2], this.f7970b[(i * 2) + 1]);
                }
                Arrays.sort(entryArr, 0, this.f7971c, AbstractC1163ap.m9956a(this.f7969a).m9959a(C1157aj.m9931b()));
                for (int i2 = 0; i2 < this.f7971c; i2++) {
                    this.f7970b[i2 * 2] = entryArr[i2].getKey();
                    this.f7970b[(i2 * 2) + 1] = entryArr[i2].getValue();
                }
            }
        }
    }

    AbstractC1209x() {
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<Map.Entry<K, V>> entrySet() {
        AbstractC1148aa<Map.Entry<K, V>> abstractC1148aa = this.f7966b;
        if (abstractC1148aa != null) {
            return abstractC1148aa;
        }
        AbstractC1148aa<Map.Entry<K, V>> mo9832k = mo9832k();
        this.f7966b = mo9832k;
        return mo9832k;
    }

    @Override // java.util.Map
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<K> keySet() {
        AbstractC1148aa<K> abstractC1148aa = this.f7967c;
        if (abstractC1148aa != null) {
            return abstractC1148aa;
        }
        AbstractC1148aa<K> mo9834m = mo9834m();
        this.f7967c = mo9834m;
        return mo9834m;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC1206u<V> values() {
        AbstractC1206u<V> abstractC1206u = this.f7968d;
        if (abstractC1206u != null) {
            return abstractC1206u;
        }
        AbstractC1206u<V> mo9829g = mo9829g();
        this.f7968d = mo9829g;
        return mo9829g;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return C1157aj.m9937d(this, obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return C1177bc.m10004a(entrySet());
    }

    /* renamed from: o */
    boolean m10150o() {
        return false;
    }

    public String toString() {
        return C1157aj.m9928a(this);
    }
}
