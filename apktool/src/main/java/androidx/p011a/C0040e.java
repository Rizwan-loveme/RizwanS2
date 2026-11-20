package androidx.p011a;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: LruCache.java */
/* renamed from: androidx.a.e */
/* loaded from: classes.dex */
public class C0040e<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f311a;

    /* renamed from: b */
    private int f312b;

    /* renamed from: c */
    private int f313c;

    /* renamed from: d */
    private int f314d;

    /* renamed from: e */
    private int f315e;

    /* renamed from: f */
    private int f316f;

    /* renamed from: g */
    private int f317g;

    /* renamed from: h */
    private int f318h;

    public C0040e(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f313c = i;
        this.f311a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: a */
    public final V m245a(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v2 = this.f311a.get(k);
            if (v2 != null) {
                this.f317g++;
                return v2;
            }
            this.f318h++;
            V m250b = m250b(k);
            if (m250b == null) {
                return null;
            }
            synchronized (this) {
                this.f315e++;
                v = (V) this.f311a.put(k, m250b);
                if (v != null) {
                    this.f311a.put(k, v);
                } else {
                    this.f312b += m244c(k, m250b);
                }
            }
            if (v != null) {
                m248a(false, k, m250b, v);
                return v;
            }
            m247a(this.f313c);
            return m250b;
        }
    }

    /* renamed from: a */
    public final V m246a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f314d++;
            this.f312b += m244c(k, v);
            put = this.f311a.put(k, v);
            if (put != null) {
                this.f312b -= m244c(k, put);
            }
        }
        if (put != null) {
            m248a(false, k, put, v);
        }
        m247a(this.f313c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m247a(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f312b < 0 || (this.f311a.isEmpty() && this.f312b != 0)) {
                    break;
                }
                if (this.f312b <= i || this.f311a.isEmpty()) {
                    break;
                }
                Map.Entry<K, V> next = this.f311a.entrySet().iterator().next();
                key = next.getKey();
                value = next.getValue();
                this.f311a.remove(key);
                this.f312b -= m244c(key, value);
                this.f316f++;
            }
            m248a(true, key, value, null);
        }
    }

    /* renamed from: a */
    protected void m248a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    protected V m250b(K k) {
        return null;
    }

    /* renamed from: c */
    private int m244c(K k, V v) {
        int m249b = m249b(k, v);
        if (m249b < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return m249b;
    }

    /* renamed from: b */
    protected int m249b(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        synchronized (this) {
            int i = this.f317g + this.f318h;
            format = String.format(Locale.f10688US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f313c), Integer.valueOf(this.f317g), Integer.valueOf(this.f318h), Integer.valueOf(i != 0 ? (this.f317g * 100) / i : 0));
        }
        return format;
    }
}
