package androidx.p011a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet.java */
/* renamed from: androidx.a.b */
/* loaded from: classes.dex */
public final class C0037b<E> implements Collection<E>, Set<E> {

    /* renamed from: c */
    private static final int[] f292c = new int[0];

    /* renamed from: d */
    private static final Object[] f293d = new Object[0];

    /* renamed from: e */
    private static Object[] f294e;

    /* renamed from: f */
    private static int f295f;

    /* renamed from: g */
    private static Object[] f296g;

    /* renamed from: h */
    private static int f297h;

    /* renamed from: a */
    Object[] f298a;

    /* renamed from: b */
    int f299b;

    /* renamed from: i */
    private int[] f300i;

    /* renamed from: j */
    private AbstractC0041f<E, E> f301j;

    /* renamed from: a */
    private int m219a(Object obj, int i) {
        int i2 = this.f299b;
        if (i2 == 0) {
            return -1;
        }
        int m228a = C0038c.m228a(this.f300i, i2, i);
        if (m228a >= 0 && !obj.equals(this.f298a[m228a])) {
            int i3 = m228a + 1;
            while (i3 < i2 && this.f300i[i3] == i) {
                if (obj.equals(this.f298a[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = m228a - 1; i4 >= 0 && this.f300i[i4] == i; i4--) {
                if (obj.equals(this.f298a[i4])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return m228a;
    }

    /* renamed from: a */
    private int m218a() {
        int i = this.f299b;
        if (i == 0) {
            return -1;
        }
        int m228a = C0038c.m228a(this.f300i, i, 0);
        if (m228a >= 0 && this.f298a[m228a] != null) {
            int i2 = m228a + 1;
            while (i2 < i && this.f300i[i2] == 0) {
                if (this.f298a[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = m228a - 1; i3 >= 0 && this.f300i[i3] == 0; i3--) {
                if (this.f298a[i3] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return m228a;
    }

    /* renamed from: d */
    private void m222d(int i) {
        if (i == 8) {
            synchronized (C0037b.class) {
                if (f296g != null) {
                    Object[] objArr = f296g;
                    this.f298a = objArr;
                    f296g = (Object[]) objArr[0];
                    this.f300i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f297h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0037b.class) {
                if (f294e != null) {
                    Object[] objArr2 = f294e;
                    this.f298a = objArr2;
                    f294e = (Object[]) objArr2[0];
                    this.f300i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f295f--;
                    return;
                }
            }
        }
        this.f300i = new int[i];
        this.f298a = new Object[i];
    }

    /* renamed from: a */
    private static void m220a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0037b.class) {
                if (f297h < 10) {
                    objArr[0] = f296g;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f296g = objArr;
                    f297h++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0037b.class) {
                if (f295f < 10) {
                    objArr[0] = f294e;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f294e = objArr;
                    f295f++;
                }
            }
        }
    }

    public C0037b() {
        this(0);
    }

    public C0037b(int i) {
        if (i == 0) {
            this.f300i = f292c;
            this.f298a = f293d;
        } else {
            m222d(i);
        }
        this.f299b = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (this.f299b != 0) {
            m220a(this.f300i, this.f298a, this.f299b);
            this.f300i = f292c;
            this.f298a = f293d;
            this.f299b = 0;
        }
    }

    /* renamed from: a */
    public void m224a(int i) {
        if (this.f300i.length < i) {
            int[] iArr = this.f300i;
            Object[] objArr = this.f298a;
            m222d(i);
            if (this.f299b > 0) {
                System.arraycopy(iArr, 0, this.f300i, 0, this.f299b);
                System.arraycopy(objArr, 0, this.f298a, 0, this.f299b);
            }
            m220a(iArr, objArr, this.f299b);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return m223a(obj) >= 0;
    }

    /* renamed from: a */
    public int m223a(Object obj) {
        return obj == null ? m218a() : m219a(obj, obj.hashCode());
    }

    /* renamed from: b */
    public E m225b(int i) {
        return (E) this.f298a[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f299b <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int hashCode;
        int m219a;
        int i = 8;
        if (e2 == null) {
            m219a = m218a();
            hashCode = 0;
        } else {
            hashCode = e2.hashCode();
            m219a = m219a(e2, hashCode);
        }
        if (m219a >= 0) {
            return false;
        }
        int i2 = m219a ^ (-1);
        if (this.f299b >= this.f300i.length) {
            if (this.f299b >= 8) {
                i = this.f299b + (this.f299b >> 1);
            } else if (this.f299b < 4) {
                i = 4;
            }
            int[] iArr = this.f300i;
            Object[] objArr = this.f298a;
            m222d(i);
            if (this.f300i.length > 0) {
                System.arraycopy(iArr, 0, this.f300i, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f298a, 0, objArr.length);
            }
            m220a(iArr, objArr, this.f299b);
        }
        if (i2 < this.f299b) {
            System.arraycopy(this.f300i, i2, this.f300i, i2 + 1, this.f299b - i2);
            System.arraycopy(this.f298a, i2, this.f298a, i2 + 1, this.f299b - i2);
        }
        this.f300i[i2] = hashCode;
        this.f298a[i2] = e2;
        this.f299b++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int m223a = m223a(obj);
        if (m223a < 0) {
            return false;
        }
        m226c(m223a);
        return true;
    }

    /* renamed from: c */
    public E m226c(int i) {
        E e2 = (E) this.f298a[i];
        if (this.f299b <= 1) {
            m220a(this.f300i, this.f298a, this.f299b);
            this.f300i = f292c;
            this.f298a = f293d;
            this.f299b = 0;
        } else if (this.f300i.length > 8 && this.f299b < this.f300i.length / 3) {
            int i2 = this.f299b > 8 ? this.f299b + (this.f299b >> 1) : 8;
            int[] iArr = this.f300i;
            Object[] objArr = this.f298a;
            m222d(i2);
            this.f299b--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f300i, 0, i);
                System.arraycopy(objArr, 0, this.f298a, 0, i);
            }
            if (i < this.f299b) {
                System.arraycopy(iArr, i + 1, this.f300i, i, this.f299b - i);
                System.arraycopy(objArr, i + 1, this.f298a, i, this.f299b - i);
            }
        } else {
            this.f299b--;
            if (i < this.f299b) {
                System.arraycopy(this.f300i, i + 1, this.f300i, i, this.f299b - i);
                System.arraycopy(this.f298a, i + 1, this.f298a, i, this.f299b - i);
            }
            this.f298a[this.f299b] = null;
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f299b;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[this.f299b];
        System.arraycopy(this.f298a, 0, objArr, 0, this.f299b);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = tArr.length < this.f299b ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f299b)) : tArr;
        System.arraycopy(this.f298a, 0, objArr, 0, this.f299b);
        if (objArr.length > this.f299b) {
            objArr[this.f299b] = null;
        }
        return (T[]) objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        for (int i = 0; i < this.f299b; i++) {
            try {
                if (!set.contains(m225b(i))) {
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

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f300i;
        int i = this.f299b;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = iArr[i2] + i3;
            i2++;
            i3 = i4;
        }
        return i3;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f299b * 14);
        sb.append('{');
        for (int i = 0; i < this.f299b; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E m225b = m225b(i);
            if (m225b != this) {
                sb.append(m225b);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: b */
    private AbstractC0041f<E, E> m221b() {
        if (this.f301j == null) {
            this.f301j = new AbstractC0041f<E, E>() { // from class: androidx.a.b.1
                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected int mo209a() {
                    return C0037b.this.f299b;
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected Object mo211a(int i, int i2) {
                    return C0037b.this.f298a[i];
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected int mo210a(Object obj) {
                    return C0037b.this.m223a(obj);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: b */
                protected int mo215b(Object obj) {
                    return C0037b.this.m223a(obj);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: b */
                protected Map<E, E> mo216b() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected void mo214a(E e2, E e3) {
                    C0037b.this.add(e2);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected E mo212a(int i, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: a */
                protected void mo213a(int i) {
                    C0037b.this.m226c(i);
                }

                @Override // androidx.p011a.AbstractC0041f
                /* renamed from: c */
                protected void mo217c() {
                    C0037b.this.clear();
                }
            };
        }
        return this.f301j;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return m221b().m258e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        m224a(this.f299b + collection.size());
        boolean z = false;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f299b - 1; i >= 0; i--) {
            if (!collection.contains(this.f298a[i])) {
                m226c(i);
                z = true;
            }
        }
        return z;
    }
}
