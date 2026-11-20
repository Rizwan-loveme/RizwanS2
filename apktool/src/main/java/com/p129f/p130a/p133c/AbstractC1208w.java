package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p133c.AbstractC1206u;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableList.java */
/* renamed from: com.f.a.c.w */
/* loaded from: classes.dex */
public abstract class AbstractC1208w<E> extends AbstractC1206u<E> implements List<E>, RandomAccess {

    /* renamed from: a */
    private static final AbstractC1186bl<Object> f7959a = new b(C1170aw.f7838a, 0);

    /* renamed from: g */
    public static <E> AbstractC1208w<E> m10138g() {
        return (AbstractC1208w<E>) C1170aw.f7838a;
    }

    /* renamed from: a */
    public static <E> AbstractC1208w<E> m10130a(E e2) {
        return m10136b(e2);
    }

    /* renamed from: a */
    public static <E> AbstractC1208w<E> m10131a(E e2, E e3) {
        return m10136b(e2, e3);
    }

    /* renamed from: a */
    public static <E> AbstractC1208w<E> m10129a(Iterable<? extends E> iterable) {
        C1120o.m9547a(iterable);
        if (iterable instanceof Collection) {
            return m10132a((Collection) iterable);
        }
        return m10134a((Iterator) iterable.iterator());
    }

    /* renamed from: a */
    public static <E> AbstractC1208w<E> m10132a(Collection<? extends E> collection) {
        if (!(collection instanceof AbstractC1206u)) {
            return m10136b(collection.toArray());
        }
        AbstractC1208w<E> mo9804e = ((AbstractC1206u) collection).mo9804e();
        return mo9804e.mo9838f() ? m10135a(mo9804e.toArray()) : mo9804e;
    }

    /* renamed from: a */
    public static <E> AbstractC1208w<E> m10134a(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return m10138g();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return m10130a(next);
        }
        return new a().mo9809a(next).mo9810a((Iterator) it).m10144a();
    }

    /* renamed from: a */
    public static <E> AbstractC1208w<E> m10133a(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        C1120o.m9547a(comparator);
        Object[] m9875c = C1153af.m9875c(iterable);
        C1162ao.m9953a(m9875c);
        Arrays.sort(m9875c, comparator);
        return m10135a(m9875c);
    }

    /* renamed from: b */
    private static <E> AbstractC1208w<E> m10136b(Object... objArr) {
        return m10135a(C1162ao.m9953a(objArr));
    }

    /* renamed from: a */
    static <E> AbstractC1208w<E> m10135a(Object[] objArr) {
        return m10137b(objArr, objArr.length);
    }

    /* renamed from: b */
    static <E> AbstractC1208w<E> m10137b(Object[] objArr, int i) {
        return i == 0 ? m10138g() : new C1170aw(objArr, i);
    }

    AbstractC1208w() {
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public AbstractC1185bk<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC1186bl<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1186bl<E> listIterator(int i) {
        C1120o.m9555b(i, size());
        return isEmpty() ? (AbstractC1186bl<E>) f7959a : new b(this, i);
    }

    /* compiled from: ImmutableList.java */
    /* renamed from: com.f.a.c.w$b */
    static class b<E> extends AbstractC1147a<E> {

        /* renamed from: a */
        private final AbstractC1208w<E> f7960a;

        b(AbstractC1208w<E> abstractC1208w, int i) {
            super(abstractC1208w.size(), i);
            this.f7960a = abstractC1208w;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1147a
        /* renamed from: a */
        protected E mo9793a(int i) {
            return this.f7960a.get(i);
        }
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return C1156ai.m9916b(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return C1156ai.m9917c(this, obj);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List
    /* renamed from: a */
    public AbstractC1208w<E> subList(int i, int i2) {
        C1120o.m9549a(i, i2, size());
        int i3 = i2 - i;
        if (i3 != size()) {
            if (i3 == 0) {
                return m10138g();
            }
            return m10141b(i, i2);
        }
        return this;
    }

    /* renamed from: b */
    AbstractC1208w<E> m10141b(int i, int i2) {
        return new d(i, i2 - i);
    }

    /* compiled from: ImmutableList.java */
    /* renamed from: com.f.a.c.w$d */
    class d extends AbstractC1208w<E> {

        /* renamed from: a */
        final transient int f7962a;

        /* renamed from: b */
        final transient int f7963b;

        @Override // com.p129f.p130a.p133c.AbstractC1208w, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        public /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        public /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        d(int i, int i2) {
            this.f7962a = i;
            this.f7963b = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7963b;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: b */
        Object[] mo9987b() {
            return AbstractC1208w.this.mo9987b();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: c */
        int mo9988c() {
            return AbstractC1208w.this.mo9988c() + this.f7962a;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: d */
        int mo9989d() {
            return AbstractC1208w.this.mo9988c() + this.f7962a + this.f7963b;
        }

        @Override // java.util.List
        public E get(int i) {
            C1120o.m9545a(i, this.f7963b);
            return AbstractC1208w.this.get(this.f7962a + i);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        /* renamed from: a */
        public AbstractC1208w<E> subList(int i, int i2) {
            C1120o.m9549a(i, i2, this.f7963b);
            return AbstractC1208w.this.subList(this.f7962a + i, this.f7962a + i2);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: f */
        boolean mo9838f() {
            return true;
        }
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: e */
    public final AbstractC1208w<E> mo9804e() {
        return this;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: a */
    int mo9986a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    /* renamed from: i */
    public AbstractC1208w<E> mo10143i() {
        return size() <= 1 ? this : new c(this);
    }

    /* compiled from: ImmutableList.java */
    /* renamed from: com.f.a.c.w$c */
    private static class c<E> extends AbstractC1208w<E> {

        /* renamed from: a */
        private final transient AbstractC1208w<E> f7961a;

        @Override // com.p129f.p130a.p133c.AbstractC1208w, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        public /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        public /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        c(AbstractC1208w<E> abstractC1208w) {
            this.f7961a = abstractC1208w;
        }

        /* renamed from: b */
        private int m10147b(int i) {
            return (size() - 1) - i;
        }

        /* renamed from: c */
        private int m10148c(int i) {
            return size() - i;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w
        /* renamed from: i */
        public AbstractC1208w<E> mo10143i() {
            return this.f7961a;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.f7961a.contains(obj);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int lastIndexOf = this.f7961a.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return m10147b(lastIndexOf);
            }
            return -1;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int indexOf = this.f7961a.indexOf(obj);
            if (indexOf >= 0) {
                return m10147b(indexOf);
            }
            return -1;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1208w, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC1208w<E> subList(int i, int i2) {
            C1120o.m9549a(i, i2, size());
            return this.f7961a.subList(m10148c(i2), m10148c(i)).mo10143i();
        }

        @Override // java.util.List
        public E get(int i) {
            C1120o.m9545a(i, size());
            return this.f7961a.get(m10147b(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7961a.size();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u
        /* renamed from: f */
        boolean mo9838f() {
            return this.f7961a.mo9838f();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        return C1156ai.m9915a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int i = 1;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ (-1)) ^ (-1);
        }
        return i;
    }

    /* compiled from: ImmutableList.java */
    /* renamed from: com.f.a.c.w$a */
    public static final class a<E> extends AbstractC1206u.a<E> {
        public a() {
            this(4);
        }

        a(int i) {
            super(i);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u.a, com.p129f.p130a.p133c.AbstractC1206u.b
        @CanIgnoreReturnValue
        /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a<E> mo9812b(E e2) {
            super.mo9812b((a<E>) e2);
            return this;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u.b
        @CanIgnoreReturnValue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a<E> mo9810a(Iterator<? extends E> it) {
            super.mo9810a((Iterator) it);
            return this;
        }

        /* renamed from: a */
        public AbstractC1208w<E> m10144a() {
            this.f7956c = true;
            return AbstractC1208w.m10137b(this.f7954a, this.f7955b);
        }
    }
}
