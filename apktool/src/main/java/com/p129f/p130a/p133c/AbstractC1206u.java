package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import java.p209io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableCollection.java */
/* renamed from: com.f.a.c.u */
/* loaded from: classes.dex */
public abstract class AbstractC1206u<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a */
    private static final Object[] f7953a = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public abstract AbstractC1185bk<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: f */
    abstract boolean mo9838f();

    AbstractC1206u() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return toArray(f7953a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        C1120o.m9547a(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] mo9987b = mo9987b();
            if (mo9987b != null) {
                return (T[]) C1165ar.m9965a(mo9987b, mo9988c(), mo9989d(), tArr);
            }
            tArr = (T[]) C1162ao.m9954a((Object[]) tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        mo9986a(tArr, 0);
        return tArr;
    }

    /* renamed from: b */
    Object[] mo9987b() {
        return null;
    }

    /* renamed from: c */
    int mo9988c() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: d */
    int mo9989d() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public AbstractC1208w<E> mo9804e() {
        return isEmpty() ? AbstractC1208w.m10138g() : AbstractC1208w.m10135a(toArray());
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    int mo9986a(Object[] objArr, int i) {
        AbstractC1185bk<E> it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    /* compiled from: ImmutableCollection.java */
    /* renamed from: com.f.a.c.u$b */
    public static abstract class b<E> {
        @CanIgnoreReturnValue
        /* renamed from: b */
        public abstract b<E> mo9812b(E e2);

        /* renamed from: a */
        static int m10128a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = (i >> 1) + i + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        b() {
        }

        @CanIgnoreReturnValue
        /* renamed from: a */
        public b<E> mo9810a(Iterator<? extends E> it) {
            while (it.hasNext()) {
                mo9812b(it.next());
            }
            return this;
        }
    }

    /* compiled from: ImmutableCollection.java */
    /* renamed from: com.f.a.c.u$a */
    static abstract class a<E> extends b<E> {

        /* renamed from: a */
        Object[] f7954a;

        /* renamed from: b */
        int f7955b;

        /* renamed from: c */
        boolean f7956c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p129f.p130a.p133c.AbstractC1206u.b
        @CanIgnoreReturnValue
        /* renamed from: b */
        public /* synthetic */ b mo9812b(Object obj) {
            return mo9812b((a<E>) obj);
        }

        a(int i) {
            C1197l.m10052a(i, "initialCapacity");
            this.f7954a = new Object[i];
            this.f7955b = 0;
        }

        /* renamed from: a */
        private void m10127a(int i) {
            if (this.f7954a.length < i) {
                this.f7954a = Arrays.copyOf(this.f7954a, m10128a(this.f7954a.length, i));
                this.f7956c = false;
            } else if (this.f7956c) {
                this.f7954a = (Object[]) this.f7954a.clone();
                this.f7956c = false;
            }
        }

        @CanIgnoreReturnValue
        /* renamed from: a */
        public a<E> mo9812b(E e2) {
            C1120o.m9547a(e2);
            m10127a(this.f7955b + 1);
            Object[] objArr = this.f7954a;
            int i = this.f7955b;
            this.f7955b = i + 1;
            objArr[i] = e2;
            return this;
        }
    }
}
