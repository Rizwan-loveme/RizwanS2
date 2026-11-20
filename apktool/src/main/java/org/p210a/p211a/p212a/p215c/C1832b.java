package org.p210a.p211a.p212a.p215c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: Array2DHashSet.java */
/* renamed from: org.a.a.a.c.b */
/* loaded from: classes.dex */
public class C1832b<T> implements Set<T> {

    /* renamed from: g */
    static final /* synthetic */ boolean f10876g;

    /* renamed from: a */
    protected final AbstractC1831a<? super T> f10877a;

    /* renamed from: b */
    protected T[][] f10878b;

    /* renamed from: c */
    protected int f10879c;

    /* renamed from: d */
    protected int f10880d;

    /* renamed from: e */
    protected int f10881e;

    /* renamed from: f */
    protected int f10882f;

    static {
        f10876g = !C1832b.class.desiredAssertionStatus();
    }

    public C1832b() {
        this(null, 16, 8);
    }

    public C1832b(AbstractC1831a<? super T> abstractC1831a, int i, int i2) {
        this.f10879c = 0;
        this.f10880d = (int) Math.floor(12.0d);
        this.f10881e = 1;
        this.f10882f = 8;
        this.f10877a = abstractC1831a == null ? C1842l.f10911a : abstractC1831a;
        this.f10878b = mo13604d(i);
        this.f10882f = i2;
    }

    /* renamed from: c */
    public final T m13722c(T t) {
        if (this.f10879c > this.f10880d) {
            m13721a();
        }
        return m13723d((C1832b<T>) t);
    }

    /* renamed from: d */
    protected T m13723d(T t) {
        int m13725f = m13725f(t);
        T[] tArr = this.f10878b[m13725f];
        if (tArr == null) {
            T[] mo13603c = mo13603c(this.f10882f);
            mo13603c[0] = t;
            this.f10878b[m13725f] = mo13603c;
            this.f10879c++;
            return t;
        }
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == null) {
                tArr[i] = t;
                this.f10879c++;
                return t;
            }
            if (this.f10877a.mo13575a(t2, t)) {
                return t2;
            }
        }
        int length = tArr.length;
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length * 2);
        ((T[][]) this.f10878b)[m13725f] = copyOf;
        copyOf[length] = t;
        this.f10879c++;
        return t;
    }

    /* renamed from: e */
    public T m13724e(T t) {
        if (t != null) {
            T[] tArr = this.f10878b[m13725f(t)];
            if (tArr == null) {
                return null;
            }
            for (T t2 : tArr) {
                if (t2 == null) {
                    return null;
                }
                if (this.f10877a.mo13575a(t2, t)) {
                    return t2;
                }
            }
            return null;
        }
        return t;
    }

    /* renamed from: f */
    protected final int m13725f(T t) {
        return this.f10877a.mo13573a(t) & (this.f10878b.length - 1);
    }

    @Override // java.util.Set
    public int hashCode() {
        int m13770a = C1841k.m13770a();
        for (T[] tArr : this.f10878b) {
            if (tArr != null) {
                for (T t : tArr) {
                    if (t != null) {
                        m13770a = C1841k.m13772a(m13770a, this.f10877a.mo13573a(t));
                    }
                }
            }
        }
        return C1841k.m13775b(m13770a, size());
    }

    @Override // java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1832b)) {
            return false;
        }
        C1832b c1832b = (C1832b) obj;
        if (c1832b.size() == size()) {
            return containsAll(c1832b);
        }
        return false;
    }

    /* renamed from: a */
    protected void m13721a() {
        T[] tArr;
        T[][] tArr2 = this.f10878b;
        this.f10881e += 4;
        int length = this.f10878b.length * 2;
        T[][] mo13604d = mo13604d(length);
        int[] iArr = new int[mo13604d.length];
        this.f10878b = mo13604d;
        this.f10880d = (int) (length * 0.75d);
        int size = size();
        for (T[] tArr3 : tArr2) {
            if (tArr3 != null) {
                for (T t : tArr3) {
                    if (t != null) {
                        int m13725f = m13725f(t);
                        int i = iArr[m13725f];
                        if (i == 0) {
                            tArr = mo13603c(this.f10882f);
                            mo13604d[m13725f] = tArr;
                        } else {
                            tArr = mo13604d[m13725f];
                            if (i == tArr.length) {
                                tArr = (T[]) Arrays.copyOf(tArr, tArr.length * 2);
                                mo13604d[m13725f] = tArr;
                            }
                        }
                        tArr[i] = t;
                        iArr[m13725f] = iArr[m13725f] + 1;
                    }
                }
            }
        }
        if (!f10876g && this.f10879c != size) {
            throw new AssertionError();
        }
    }

    @Override // java.util.Set
    public final boolean add(T t) {
        return m13722c((C1832b<T>) t) == t;
    }

    @Override // java.util.Set
    public final int size() {
        return this.f10879c;
    }

    @Override // java.util.Set
    public final boolean isEmpty() {
        return this.f10879c == 0;
    }

    @Override // java.util.Set
    public final boolean contains(Object obj) {
        return m13726g(mo13601b(obj));
    }

    /* renamed from: g */
    public boolean m13726g(T t) {
        return (t == null || m13724e(t) == null) ? false : true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(toArray());
    }

    @Override // java.util.Set
    public T[] toArray() {
        T[] mo13603c = mo13603c(size());
        int i = 0;
        for (T[] tArr : this.f10878b) {
            if (tArr != null) {
                int length = tArr.length;
                int i2 = 0;
                while (i2 < length) {
                    T t = tArr[i2];
                    if (t != null) {
                        mo13603c[i] = t;
                        i2++;
                        i++;
                    }
                }
            }
        }
        return mo13603c;
    }

    @Override // java.util.Set
    public <U> U[] toArray(U[] uArr) {
        if (uArr.length < size()) {
            uArr = (U[]) Arrays.copyOf(uArr, size());
        }
        int i = 0;
        for (T[] tArr : this.f10878b) {
            if (tArr != null) {
                int length = tArr.length;
                int i2 = 0;
                while (i2 < length) {
                    T t = tArr[i2];
                    if (t != null) {
                        uArr[i] = t;
                        i2++;
                        i++;
                    }
                }
            }
        }
        return uArr;
    }

    @Override // java.util.Set
    public final boolean remove(Object obj) {
        return m13727h(mo13601b(obj));
    }

    /* renamed from: h */
    public boolean m13727h(T t) {
        T t2;
        if (t == null) {
            return false;
        }
        T[] tArr = this.f10878b[m13725f(t)];
        if (tArr == null) {
            return false;
        }
        for (int i = 0; i < tArr.length && (t2 = tArr[i]) != null; i++) {
            if (this.f10877a.mo13575a(t2, t)) {
                System.arraycopy(tArr, i + 1, tArr, i, (tArr.length - i) - 1);
                tArr[tArr.length - 1] = null;
                this.f10879c--;
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0013, code lost:
    
        continue;
     */
    @Override // java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof C1832b) {
            for (T[] tArr : ((C1832b) collection).f10878b) {
                if (tArr != null) {
                    for (T t : tArr) {
                        if (t != null) {
                            if (!m13726g(mo13601b(t))) {
                                return false;
                            }
                        }
                    }
                }
            }
        } else {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!m13726g(mo13601b(it.next()))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.util.Set
    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        for (T t : collection) {
            if (m13722c((C1832b<T>) t) != t) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Set
    public boolean retainAll(Collection<?> collection) {
        int i = 0;
        for (T[] tArr : this.f10878b) {
            if (tArr != null) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < tArr.length && tArr[i3] != null) {
                    if (collection.contains(tArr[i3])) {
                        if (i3 != i2) {
                            tArr[i2] = tArr[i3];
                        }
                        i2++;
                        i++;
                    }
                    i3++;
                }
                i += i2;
                while (i2 < i3) {
                    tArr[i2] = null;
                    i2++;
                }
            }
        }
        boolean z = i != this.f10879c;
        this.f10879c = i;
        return z;
    }

    @Override // java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            z |= m13727h(mo13601b(it.next()));
        }
        return z;
    }

    @Override // java.util.Set
    public void clear() {
        this.f10878b = mo13604d(16);
        this.f10879c = 0;
        this.f10880d = (int) Math.floor(12.0d);
    }

    public String toString() {
        if (size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean z = true;
        for (T[] tArr : this.f10878b) {
            if (tArr != null) {
                for (T t : tArr) {
                    if (t != null) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(", ");
                        }
                        sb.append(t.toString());
                    }
                }
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    protected T mo13601b(Object obj) {
        return obj;
    }

    /* renamed from: d */
    protected T[][] mo13604d(int i) {
        return (T[][]) new Object[i][];
    }

    /* renamed from: c */
    protected T[] mo13603c(int i) {
        return (T[]) new Object[i];
    }

    /* compiled from: Array2DHashSet.java */
    /* renamed from: org.a.a.a.c.b$a */
    protected class a implements Iterator<T> {

        /* renamed from: a */
        final T[] f10883a;

        /* renamed from: b */
        int f10884b = 0;

        /* renamed from: c */
        boolean f10885c = true;

        public a(T[] tArr) {
            this.f10883a = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10884b < this.f10883a.length;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f10885c = false;
            T[] tArr = this.f10883a;
            int i = this.f10884b;
            this.f10884b = i + 1;
            return tArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f10885c) {
                throw new IllegalStateException();
            }
            C1832b.this.remove(this.f10883a[this.f10884b - 1]);
            this.f10885c = true;
        }
    }
}
