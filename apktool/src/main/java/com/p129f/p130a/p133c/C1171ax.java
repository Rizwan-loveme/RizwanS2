package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: RegularImmutableMap.java */
/* renamed from: com.f.a.c.ax */
/* loaded from: classes.dex */
final class C1171ax<K, V> extends AbstractC1209x<K, V> {

    /* renamed from: b */
    static final AbstractC1209x<Object, Object> f7841b = new C1171ax(null, new Object[0], 0);

    /* renamed from: c */
    final transient Object[] f7842c;

    /* renamed from: d */
    private final transient int[] f7843d;

    /* renamed from: e */
    private final transient int f7844e;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        r1[r0] = (r2 * 2) + r12;
        r2 = r2 + 1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static int[] m9991a(Object[] objArr, int i, int i2, int i3) {
        if (i == 1) {
            C1197l.m10053a(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        int i5 = 0;
        while (i5 < i) {
            Object obj = objArr[(i5 * 2) + i3];
            Object obj2 = objArr[(i5 * 2) + (i3 ^ 1)];
            C1197l.m10053a(obj, obj2);
            int m10117a = C1204s.m10117a(obj.hashCode());
            while (true) {
                int i6 = m10117a & i4;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    break;
                }
                if (!objArr[i7].equals(obj)) {
                    m10117a = i6 + 1;
                } else {
                    throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i7] + "=" + objArr[i7 ^ 1]);
                }
            }
        }
        return iArr;
    }

    private C1171ax(int[] iArr, Object[] objArr, int i) {
        this.f7843d = iArr;
        this.f7842c = objArr;
        this.f7844e = i;
    }

    @Override // java.util.Map
    public int size() {
        return this.f7844e;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) m9990a(this.f7843d, this.f7842c, this.f7844e, 0, obj);
    }

    /* renamed from: a */
    static Object m9990a(@NullableDecl int[] iArr, @NullableDecl Object[] objArr, int i, int i2, @NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                return objArr[i2 ^ 1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int m10117a = C1204s.m10117a(obj.hashCode());
        while (true) {
            int i3 = m10117a & length;
            int i4 = iArr[i3];
            if (i4 == -1) {
                return null;
            }
            if (!objArr[i4].equals(obj)) {
                m10117a = i3 + 1;
            } else {
                return objArr[i4 ^ 1];
            }
        }
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: k */
    AbstractC1148aa<Map.Entry<K, V>> mo9832k() {
        return new a(this, this.f7842c, 0, this.f7844e);
    }

    /* compiled from: RegularImmutableMap.java */
    /* renamed from: com.f.a.c.ax$a */
    static class a<K, V> extends AbstractC1148aa<Map.Entry<K, V>> {

        /* renamed from: a */
        private final transient AbstractC1209x<K, V> f7845a;

        /* renamed from: b */
        private final transient Object[] f7846b;

        /* renamed from: c */
        private final transient int f7847c;

        /* renamed from: d */
        private final transient int f7848d;

        a(AbstractC1209x<K, V> abstractC1209x, Object[] objArr, int i, int i2) {
            this.f7845a = abstractC1209x;
            this.f7846b = objArr;
            this.f7847c = i;
            this.f7848d = i2;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: a */
        public AbstractC1185bk<Map.Entry<K, V>> iterator() {
            return mo9804e().iterator();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: a */
        int mo9986a(Object[] objArr, int i) {
            return mo9804e().mo9986a(objArr, i);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa
        /* renamed from: j */
        AbstractC1208w<Map.Entry<K, V>> mo9806j() {
            return new AbstractC1208w<Map.Entry<K, V>>() { // from class: com.f.a.c.ax.a.1
                @Override // java.util.List
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> get(int i) {
                    C1120o.m9545a(i, a.this.f7848d);
                    return new AbstractMap.SimpleImmutableEntry(a.this.f7846b[(i * 2) + a.this.f7847c], a.this.f7846b[(i * 2) + (a.this.f7847c ^ 1)]);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return a.this.f7848d;
                }

                @Override // com.p129f.p130a.p133c.AbstractC1206u
                /* renamed from: f */
                public boolean mo9838f() {
                    return true;
                }
            };
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f7845a.get(key));
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: f */
        boolean mo9838f() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7848d;
        }
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: m */
    AbstractC1148aa<K> mo9834m() {
        return new b(this, new c(this.f7842c, 0, this.f7844e));
    }

    /* compiled from: RegularImmutableMap.java */
    /* renamed from: com.f.a.c.ax$c */
    static final class c extends AbstractC1208w<Object> {

        /* renamed from: a */
        private final transient Object[] f7852a;

        /* renamed from: b */
        private final transient int f7853b;

        /* renamed from: c */
        private final transient int f7854c;

        c(Object[] objArr, int i, int i2) {
            this.f7852a = objArr;
            this.f7853b = i;
            this.f7854c = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            C1120o.m9545a(i, this.f7854c);
            return this.f7852a[(i * 2) + this.f7853b];
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: f */
        boolean mo9838f() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7854c;
        }
    }

    /* compiled from: RegularImmutableMap.java */
    /* renamed from: com.f.a.c.ax$b */
    static final class b<K> extends AbstractC1148aa<K> {

        /* renamed from: a */
        private final transient AbstractC1209x<K, ?> f7850a;

        /* renamed from: b */
        private final transient AbstractC1208w<K> f7851b;

        b(AbstractC1209x<K, ?> abstractC1209x, AbstractC1208w<K> abstractC1208w) {
            this.f7850a = abstractC1209x;
            this.f7851b = abstractC1208w;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: a */
        public AbstractC1185bk<K> iterator() {
            return mo9804e().iterator();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: a */
        int mo9986a(Object[] objArr, int i) {
            return mo9804e().mo9986a(objArr, i);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: e */
        public AbstractC1208w<K> mo9804e() {
            return this.f7851b;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.f7850a.get(obj) != null;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: f */
        boolean mo9838f() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7850a.size();
        }
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: g */
    AbstractC1206u<V> mo9829g() {
        return new c(this.f7842c, 1, this.f7844e);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: n */
    boolean mo9835n() {
        return false;
    }
}
