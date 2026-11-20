package androidx.p011a;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap.java */
/* renamed from: androidx.a.g */
/* loaded from: classes.dex */
public class C0042g<K, V> {

    /* renamed from: b */
    static Object[] f334b;

    /* renamed from: c */
    static int f335c;

    /* renamed from: d */
    static Object[] f336d;

    /* renamed from: e */
    static int f337e;

    /* renamed from: f */
    int[] f338f;

    /* renamed from: g */
    Object[] f339g;

    /* renamed from: h */
    int f340h;

    /* renamed from: a */
    private static int m262a(int[] iArr, int i, int i2) {
        try {
            return C0038c.m228a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    int m267a(Object obj, int i) {
        int i2 = this.f340h;
        if (i2 == 0) {
            return -1;
        }
        int m262a = m262a(this.f338f, i2, i);
        if (m262a >= 0 && !obj.equals(this.f339g[m262a << 1])) {
            int i3 = m262a + 1;
            while (i3 < i2 && this.f338f[i3] == i) {
                if (obj.equals(this.f339g[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = m262a - 1; i4 >= 0 && this.f338f[i4] == i; i4--) {
                if (obj.equals(this.f339g[i4 << 1])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return m262a;
    }

    /* renamed from: a */
    int m265a() {
        int i = this.f340h;
        if (i == 0) {
            return -1;
        }
        int m262a = m262a(this.f338f, i, 0);
        if (m262a >= 0 && this.f339g[m262a << 1] != null) {
            int i2 = m262a + 1;
            while (i2 < i && this.f338f[i2] == 0) {
                if (this.f339g[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = m262a - 1; i3 >= 0 && this.f338f[i3] == 0; i3--) {
                if (this.f339g[i3 << 1] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return m262a;
    }

    /* renamed from: e */
    private void m264e(int i) {
        if (i == 8) {
            synchronized (C0042g.class) {
                if (f336d != null) {
                    Object[] objArr = f336d;
                    this.f339g = objArr;
                    f336d = (Object[]) objArr[0];
                    this.f338f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f337e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0042g.class) {
                if (f334b != null) {
                    Object[] objArr2 = f334b;
                    this.f339g = objArr2;
                    f334b = (Object[]) objArr2[0];
                    this.f338f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f335c--;
                    return;
                }
            }
        }
        this.f338f = new int[i];
        this.f339g = new Object[i << 1];
    }

    /* renamed from: a */
    private static void m263a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0042g.class) {
                if (f337e < 10) {
                    objArr[0] = f336d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f336d = objArr;
                    f337e++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0042g.class) {
                if (f335c < 10) {
                    objArr[0] = f334b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f334b = objArr;
                    f335c++;
                }
            }
        }
    }

    public C0042g() {
        this.f338f = C0038c.f303a;
        this.f339g = C0038c.f305c;
        this.f340h = 0;
    }

    public C0042g(int i) {
        if (i == 0) {
            this.f338f = C0038c.f303a;
            this.f339g = C0038c.f305c;
        } else {
            m264e(i);
        }
        this.f340h = 0;
    }

    public void clear() {
        if (this.f340h > 0) {
            int[] iArr = this.f338f;
            Object[] objArr = this.f339g;
            int i = this.f340h;
            this.f338f = C0038c.f303a;
            this.f339g = C0038c.f305c;
            this.f340h = 0;
            m263a(iArr, objArr, i);
        }
        if (this.f340h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    public void m269a(int i) {
        int i2 = this.f340h;
        if (this.f338f.length < i) {
            int[] iArr = this.f338f;
            Object[] objArr = this.f339g;
            m264e(i);
            if (this.f340h > 0) {
                System.arraycopy(iArr, 0, this.f338f, 0, i2);
                System.arraycopy(objArr, 0, this.f339g, 0, i2 << 1);
            }
            m263a(iArr, objArr, i2);
        }
        if (this.f340h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m266a(obj) >= 0;
    }

    /* renamed from: a */
    public int m266a(Object obj) {
        return obj == null ? m265a() : m267a(obj, obj.hashCode());
    }

    /* renamed from: b */
    int m270b(Object obj) {
        int i = 1;
        int i2 = this.f340h * 2;
        Object[] objArr = this.f339g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] != null) {
                    i += 2;
                } else {
                    return i >> 1;
                }
            }
        } else {
            while (i < i2) {
                if (!obj.equals(objArr[i])) {
                    i += 2;
                } else {
                    return i >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m270b(obj) >= 0;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int m266a = m266a(obj);
        return m266a >= 0 ? (V) this.f339g[(m266a << 1) + 1] : v;
    }

    /* renamed from: b */
    public K m271b(int i) {
        return (K) this.f339g[i << 1];
    }

    /* renamed from: c */
    public V m272c(int i) {
        return (V) this.f339g[(i << 1) + 1];
    }

    /* renamed from: a */
    public V m268a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.f339g[i2];
        this.f339g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f340h <= 0;
    }

    public V put(K k, V v) {
        int hashCode;
        int m267a;
        int i = 8;
        int i2 = this.f340h;
        if (k == null) {
            m267a = m265a();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            m267a = m267a(k, hashCode);
        }
        if (m267a >= 0) {
            int i3 = (m267a << 1) + 1;
            V v2 = (V) this.f339g[i3];
            this.f339g[i3] = v;
            return v2;
        }
        int i4 = m267a ^ (-1);
        if (i2 >= this.f338f.length) {
            if (i2 >= 8) {
                i = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i = 4;
            }
            int[] iArr = this.f338f;
            Object[] objArr = this.f339g;
            m264e(i);
            if (i2 != this.f340h) {
                throw new ConcurrentModificationException();
            }
            if (this.f338f.length > 0) {
                System.arraycopy(iArr, 0, this.f338f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f339g, 0, objArr.length);
            }
            m263a(iArr, objArr, i2);
        }
        if (i4 < i2) {
            System.arraycopy(this.f338f, i4, this.f338f, i4 + 1, i2 - i4);
            System.arraycopy(this.f339g, i4 << 1, this.f339g, (i4 + 1) << 1, (this.f340h - i4) << 1);
        }
        if (i2 != this.f340h || i4 >= this.f338f.length) {
            throw new ConcurrentModificationException();
        }
        this.f338f[i4] = hashCode;
        this.f339g[i4 << 1] = k;
        this.f339g[(i4 << 1) + 1] = v;
        this.f340h++;
        return null;
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        if (v2 == null) {
            return put(k, v);
        }
        return v2;
    }

    public V remove(Object obj) {
        int m266a = m266a(obj);
        if (m266a >= 0) {
            return m273d(m266a);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        V m272c;
        int m266a = m266a(obj);
        if (m266a < 0 || (obj2 != (m272c = m272c(m266a)) && (obj2 == null || !obj2.equals(m272c)))) {
            return false;
        }
        m273d(m266a);
        return true;
    }

    /* renamed from: d */
    public V m273d(int i) {
        int i2;
        V v = (V) this.f339g[(i << 1) + 1];
        int i3 = this.f340h;
        if (i3 <= 1) {
            m263a(this.f338f, this.f339g, i3);
            this.f338f = C0038c.f303a;
            this.f339g = C0038c.f305c;
            i2 = 0;
        } else {
            int i4 = i3 - 1;
            if (this.f338f.length > 8 && this.f340h < this.f338f.length / 3) {
                int i5 = i3 > 8 ? (i3 >> 1) + i3 : 8;
                int[] iArr = this.f338f;
                Object[] objArr = this.f339g;
                m264e(i5);
                if (i3 != this.f340h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f338f, 0, i);
                    System.arraycopy(objArr, 0, this.f339g, 0, i << 1);
                }
                if (i < i4) {
                    System.arraycopy(iArr, i + 1, this.f338f, i, i4 - i);
                    System.arraycopy(objArr, (i + 1) << 1, this.f339g, i << 1, (i4 - i) << 1);
                }
                i2 = i4;
            } else {
                if (i < i4) {
                    System.arraycopy(this.f338f, i + 1, this.f338f, i, i4 - i);
                    System.arraycopy(this.f339g, (i + 1) << 1, this.f339g, i << 1, (i4 - i) << 1);
                }
                this.f339g[i4 << 1] = null;
                this.f339g[(i4 << 1) + 1] = null;
                i2 = i4;
            }
        }
        if (i3 != this.f340h) {
            throw new ConcurrentModificationException();
        }
        this.f340h = i2;
        return v;
    }

    public V replace(K k, V v) {
        int m266a = m266a(k);
        if (m266a >= 0) {
            return m268a(m266a, (int) v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        V m272c;
        int m266a = m266a(k);
        if (m266a < 0 || ((m272c = m272c(m266a)) != v && (v == null || !v.equals(m272c)))) {
            return false;
        }
        m268a(m266a, (int) v2);
        return true;
    }

    public int size() {
        return this.f340h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0042g) {
            C0042g c0042g = (C0042g) obj;
            if (size() != c0042g.size()) {
                return false;
            }
            for (int i = 0; i < this.f340h; i++) {
                try {
                    K m271b = m271b(i);
                    V m272c = m272c(i);
                    Object obj2 = c0042g.get(m271b);
                    if (m272c == null) {
                        if (obj2 != null || !c0042g.containsKey(m271b)) {
                            return false;
                        }
                    } else if (!m272c.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException e2) {
                    return false;
                } catch (NullPointerException e3) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f340h; i2++) {
            try {
                K m271b2 = m271b(i2);
                V m272c2 = m272c(i2);
                Object obj3 = map.get(m271b2);
                if (m272c2 == null) {
                    if (obj3 != null || !map.containsKey(m271b2)) {
                        return false;
                    }
                } else if (!m272c2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException e4) {
                return false;
            } catch (NullPointerException e5) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f338f;
        Object[] objArr = this.f339g;
        int i = this.f340h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f340h * 28);
        sb.append('{');
        for (int i = 0; i < this.f340h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K m271b = m271b(i);
            if (m271b != this) {
                sb.append(m271b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V m272c = m272c(i);
            if (m272c != this) {
                sb.append(m272c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
