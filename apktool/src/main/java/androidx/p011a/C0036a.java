package androidx.p011a;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* renamed from: androidx.a.a */
/* loaded from: classes.dex */
public class C0036a<K, V> extends C0042g<K, V> implements Map<K, V> {

    /* renamed from: a */
    AbstractC0041f<K, V> f290a;

    public C0036a() {
    }

    public C0036a(int i) {
        super(i);
    }

    /* renamed from: b */
    private AbstractC0041f<K, V> m207b() {
        if (this.f290a == null) {
            this.f290a = new AbstractC0041f<K, V>() { // from class: androidx.a.a.1
                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected int mo209a() {
                    return C0036a.this.f340h;
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected Object mo211a(int i, int i2) {
                    return C0036a.this.f339g[(i << 1) + i2];
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected int mo210a(Object obj) {
                    return C0036a.this.m266a(obj);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: b */
                protected int mo215b(Object obj) {
                    return C0036a.this.m270b(obj);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: b */
                protected Map<K, V> mo216b() {
                    return C0036a.this;
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected void mo214a(K k, V v) {
                    C0036a.this.put(k, v);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected V mo212a(int i, V v) {
                    return C0036a.this.m268a(i, (int) v);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected void mo213a(int i) {
                    C0036a.this.m273d(i);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: c */
                protected void mo217c() {
                    C0036a.this.clear();
                }
            };
        }
        return this.f290a;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m269a(this.f340h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public boolean m208a(Collection<?> collection) {
        return AbstractC0041f.m254c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m207b().m257d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m207b().m258e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m207b().m259f();
    }
}
