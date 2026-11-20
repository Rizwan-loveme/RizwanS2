package org.p210a.p211a.p212a.p215c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* compiled from: FlexibleHashMap.java */
/* renamed from: org.a.a.a.c.e */
/* loaded from: classes.dex */
public class C1835e<K, V> implements Map<K, V> {

    /* renamed from: a */
    protected final AbstractC1831a<? super K> f10888a;

    /* renamed from: b */
    protected LinkedList<a<K, V>>[] f10889b;

    /* renamed from: c */
    protected int f10890c;

    /* renamed from: d */
    protected int f10891d;

    /* renamed from: e */
    protected int f10892e;

    /* renamed from: f */
    protected int f10893f;

    /* compiled from: FlexibleHashMap.java */
    /* renamed from: org.a.a.a.c.e$a */
    public static class a<K, V> {

        /* renamed from: a */
        public final K f10894a;

        /* renamed from: b */
        public V f10895b;

        public a(K k, V v) {
            this.f10894a = k;
            this.f10895b = v;
        }

        public String toString() {
            return String.valueOf(this.f10894a.toString()) + ":" + this.f10895b.toString();
        }
    }

    public C1835e(AbstractC1831a<? super K> abstractC1831a) {
        this(abstractC1831a, 16, 8);
    }

    public C1835e(AbstractC1831a<? super K> abstractC1831a, int i, int i2) {
        this.f10890c = 0;
        this.f10891d = 12;
        this.f10892e = 1;
        this.f10893f = 8;
        this.f10888a = abstractC1831a == null ? C1842l.f10911a : abstractC1831a;
        this.f10889b = m13730a(i2);
        this.f10893f = i2;
    }

    /* renamed from: a */
    private static <K, V> LinkedList<a<K, V>>[] m13730a(int i) {
        return new LinkedList[i];
    }

    /* renamed from: a */
    protected int m13731a(K k) {
        return this.f10888a.mo13573a(k) & (this.f10889b.length - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        if (obj == 0) {
            return null;
        }
        LinkedList<a<K, V>> linkedList = this.f10889b[m13731a((C1835e<K, V>) obj)];
        if (linkedList == null) {
            return null;
        }
        Iterator<a<K, V>> it = linkedList.iterator();
        while (it.hasNext()) {
            a<K, V> next = it.next();
            if (this.f10888a.mo13575a(next.f10894a, obj)) {
                return next.f10895b;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        LinkedList<a<K, V>> linkedList;
        if (k == null) {
            return null;
        }
        if (this.f10890c > this.f10891d) {
            m13732a();
        }
        int m13731a = m13731a((C1835e<K, V>) k);
        LinkedList<a<K, V>> linkedList2 = this.f10889b[m13731a];
        if (linkedList2 == null) {
            LinkedList<a<K, V>>[] linkedListArr = this.f10889b;
            LinkedList<a<K, V>> linkedList3 = new LinkedList<>();
            linkedListArr[m13731a] = linkedList3;
            linkedList = linkedList3;
        } else {
            linkedList = linkedList2;
        }
        Iterator<a<K, V>> it = linkedList.iterator();
        while (it.hasNext()) {
            a<K, V> next = it.next();
            if (this.f10888a.mo13575a(next.f10894a, k)) {
                V v2 = next.f10895b;
                next.f10895b = v;
                this.f10890c++;
                return v2;
            }
        }
        linkedList.add(new a<>(k, v));
        this.f10890c++;
        return null;
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ArrayList arrayList = new ArrayList(size());
        for (LinkedList<a<K, V>> linkedList : this.f10889b) {
            if (linkedList != null) {
                Iterator<a<K, V>> it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f10895b);
                }
            }
        }
        return arrayList;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int hashCode() {
        int i;
        a<K, V> next;
        int m13770a = C1841k.m13770a();
        LinkedList<a<K, V>>[] linkedListArr = this.f10889b;
        int length = linkedListArr.length;
        int i2 = 0;
        while (i2 < length) {
            LinkedList<a<K, V>> linkedList = linkedListArr[i2];
            if (linkedList == null) {
                i = m13770a;
            } else {
                Iterator<a<K, V>> it = linkedList.iterator();
                while (true) {
                    i = m13770a;
                    if (it.hasNext() && (next = it.next()) != null) {
                        m13770a = C1841k.m13772a(i, this.f10888a.mo13573a(next.f10894a));
                    }
                }
            }
            i2++;
            m13770a = i;
        }
        return C1841k.m13775b(m13770a, size());
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    protected void m13732a() {
        a<K, V> next;
        LinkedList<a<K, V>>[] linkedListArr = this.f10889b;
        this.f10892e += 4;
        int length = this.f10889b.length * 2;
        this.f10889b = m13730a(length);
        this.f10891d = (int) (length * 0.75d);
        int size = size();
        for (LinkedList<a<K, V>> linkedList : linkedListArr) {
            if (linkedList != null) {
                Iterator<a<K, V>> it = linkedList.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    put(next.f10894a, next.f10895b);
                }
            }
        }
        this.f10890c = size;
    }

    @Override // java.util.Map
    public int size() {
        return this.f10890c;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f10890c == 0;
    }

    @Override // java.util.Map
    public void clear() {
        this.f10889b = m13730a(16);
        this.f10890c = 0;
    }

    public String toString() {
        boolean z;
        a<K, V> next;
        if (size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean z2 = true;
        LinkedList<a<K, V>>[] linkedListArr = this.f10889b;
        int length = linkedListArr.length;
        int i = 0;
        while (i < length) {
            LinkedList<a<K, V>> linkedList = linkedListArr[i];
            if (linkedList == null) {
                z = z2;
            } else {
                Iterator<a<K, V>> it = linkedList.iterator();
                z = z2;
                while (it.hasNext() && (next = it.next()) != null) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(next.toString());
                }
            }
            i++;
            z2 = z;
        }
        sb.append('}');
        return sb.toString();
    }
}
