package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p131a.InterfaceC1121p;
import com.p129f.p130a.p137g.C1219c;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Iterators.java */
/* renamed from: com.f.a.c.ag */
/* loaded from: classes.dex */
public final class C1154ag {
    /* renamed from: a */
    static <T> AbstractC1185bk<T> m9881a() {
        return m9893b();
    }

    /* renamed from: b */
    static <T> AbstractC1186bl<T> m9893b() {
        return (AbstractC1186bl<T>) a.f7795a;
    }

    /* renamed from: a */
    public static int m9880a(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return C1219c.m10174a(j);
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public static boolean m9891a(Iterator<?> it, Collection<?> collection) {
        C1120o.m9547a(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m9892a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !C1116k.m9538a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    /* renamed from: b */
    public static String m9894b(Iterator<?> it) {
        StringBuilder append = new StringBuilder().append('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                append.append(", ");
            }
            z = false;
            append.append(it.next());
        }
        return append.append(']').toString();
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public static <T> boolean m9890a(Collection<T> collection, Iterator<? extends T> it) {
        C1120o.m9547a(collection);
        C1120o.m9547a(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    /* renamed from: b */
    private static <T> Iterator<T> m9896b(final T... tArr) {
        return new AbstractC1185bk<T>() { // from class: com.f.a.c.ag.1

            /* renamed from: a */
            int f7785a = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f7785a < tArr.length;
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T t = (T) tArr[this.f7785a];
                tArr[this.f7785a] = null;
                this.f7785a++;
                return t;
            }
        };
    }

    /* renamed from: b */
    public static <T> Iterator<T> m9895b(Iterator<? extends T> it, Iterator<? extends T> it2) {
        C1120o.m9547a(it);
        C1120o.m9547a(it2);
        return m9899c(m9896b(it, it2));
    }

    /* renamed from: c */
    public static <T> Iterator<T> m9899c(Iterator<? extends Iterator<? extends T>> it) {
        return new b(it);
    }

    /* renamed from: a */
    public static <T> AbstractC1185bk<T> m9884a(final Iterator<T> it, final InterfaceC1121p<? super T> interfaceC1121p) {
        C1120o.m9547a(it);
        C1120o.m9547a(interfaceC1121p);
        return new AbstractC1174b<T>() { // from class: com.f.a.c.ag.2
            @Override // com.p129f.p130a.p133c.AbstractC1174b
            /* renamed from: a */
            protected T mo9903a() {
                while (Iterator.this.hasNext()) {
                    T t = (T) Iterator.this.next();
                    if (interfaceC1121p.mo9509a(t)) {
                        return t;
                    }
                }
                return m10002b();
            }
        };
    }

    /* renamed from: b */
    public static <T> boolean m9897b(Iterator<T> it, InterfaceC1121p<? super T> interfaceC1121p) {
        return m9898c(it, interfaceC1121p) != -1;
    }

    /* renamed from: c */
    public static <T> int m9898c(Iterator<T> it, InterfaceC1121p<? super T> interfaceC1121p) {
        C1120o.m9548a(interfaceC1121p, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (!interfaceC1121p.mo9509a(it.next())) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static <F, T> Iterator<T> m9889a(Iterator<F> it, final InterfaceC1112g<? super F, ? extends T> interfaceC1112g) {
        C1120o.m9547a(interfaceC1112g);
        return new AbstractC1182bh<F, T>(it) { // from class: com.f.a.c.ag.3
            @Override // com.p129f.p130a.p133c.AbstractC1182bh
            /* renamed from: a */
            T mo9904a(F f2) {
                return (T) interfaceC1112g.mo9517a(f2);
            }
        };
    }

    @NullableDecl
    /* renamed from: a */
    public static <T> T m9887a(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? it.next() : t;
    }

    /* renamed from: a */
    public static <T> Iterator<T> m9888a(final Iterator<T> it, final int i) {
        C1120o.m9547a(it);
        C1120o.m9551a(i >= 0, "limit is negative");
        return new Iterator<T>() { // from class: com.f.a.c.ag.4

            /* renamed from: c */
            private int f7792c;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f7792c < i && it.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f7792c++;
                return (T) it.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }
        };
    }

    /* renamed from: d */
    static void m9900d(Iterator<?> it) {
        C1120o.m9547a(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @SafeVarargs
    /* renamed from: a */
    public static <T> AbstractC1185bk<T> m9885a(T... tArr) {
        return m9886a(tArr, 0, tArr.length, 0);
    }

    /* renamed from: a */
    static <T> AbstractC1186bl<T> m9886a(T[] tArr, int i, int i2, int i3) {
        C1120o.m9550a(i2 >= 0);
        C1120o.m9549a(i, i + i2, tArr.length);
        C1120o.m9555b(i3, i2);
        if (i2 == 0) {
            return m9893b();
        }
        return new a(tArr, i, i2, i3);
    }

    /* compiled from: Iterators.java */
    /* renamed from: com.f.a.c.ag$a */
    private static final class a<T> extends AbstractC1147a<T> {

        /* renamed from: a */
        static final AbstractC1186bl<Object> f7795a = new a(new Object[0], 0, 0, 0);

        /* renamed from: b */
        private final T[] f7796b;

        /* renamed from: c */
        private final int f7797c;

        a(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.f7796b = tArr;
            this.f7797c = i;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1147a
        /* renamed from: a */
        protected T mo9793a(int i) {
            return this.f7796b[this.f7797c + i];
        }
    }

    /* renamed from: a */
    public static <T> AbstractC1185bk<T> m9883a(@NullableDecl final T t) {
        return new AbstractC1185bk<T>() { // from class: com.f.a.c.ag.5

            /* renamed from: a */
            boolean f7793a;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.f7793a;
            }

            @Override // java.util.Iterator
            public T next() {
                if (this.f7793a) {
                    throw new NoSuchElementException();
                }
                this.f7793a = true;
                return (T) Object.this;
            }
        };
    }

    /* compiled from: Iterators.java */
    /* renamed from: com.f.a.c.ag$d */
    private static class d<E> implements InterfaceC1164aq<E> {

        /* renamed from: a */
        private final Iterator<? extends E> f7805a;

        /* renamed from: b */
        private boolean f7806b;

        /* renamed from: c */
        @NullableDecl
        private E f7807c;

        public d(Iterator<? extends E> it) {
            this.f7805a = (Iterator) C1120o.m9547a(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7806b || this.f7805a.hasNext();
        }

        @Override // com.p129f.p130a.p133c.InterfaceC1164aq, java.util.Iterator
        public E next() {
            if (!this.f7806b) {
                return this.f7805a.next();
            }
            E e2 = this.f7807c;
            this.f7806b = false;
            this.f7807c = null;
            return e2;
        }

        @Override // java.util.Iterator
        public void remove() {
            C1120o.m9559b(!this.f7806b, "Can't remove after you've peeked at next");
            this.f7805a.remove();
        }

        @Override // com.p129f.p130a.p133c.InterfaceC1164aq
        /* renamed from: a */
        public E mo9907a() {
            if (!this.f7806b) {
                this.f7807c = this.f7805a.next();
                this.f7806b = true;
            }
            return this.f7807c;
        }
    }

    /* renamed from: e */
    public static <T> InterfaceC1164aq<T> m9901e(Iterator<? extends T> it) {
        return it instanceof d ? (d) it : new d(it);
    }

    /* renamed from: a */
    public static <T> AbstractC1185bk<T> m9882a(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        C1120o.m9548a(iterable, "iterators");
        C1120o.m9548a(comparator, "comparator");
        return new c(iterable, comparator);
    }

    /* compiled from: Iterators.java */
    /* renamed from: com.f.a.c.ag$c */
    private static class c<T> extends AbstractC1185bk<T> {

        /* renamed from: a */
        final Queue<InterfaceC1164aq<T>> f7802a;

        public c(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.f7802a = new PriorityQueue(2, new Comparator<InterfaceC1164aq<T>>() { // from class: com.f.a.c.ag.c.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(InterfaceC1164aq<T> interfaceC1164aq, InterfaceC1164aq<T> interfaceC1164aq2) {
                    return comparator.compare(interfaceC1164aq.mo9907a(), interfaceC1164aq2.mo9907a());
                }
            });
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f7802a.add(C1154ag.m9901e(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f7802a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            InterfaceC1164aq<T> remove = this.f7802a.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f7802a.add(remove);
            }
            return next;
        }
    }

    /* compiled from: Iterators.java */
    /* renamed from: com.f.a.c.ag$b */
    private static class b<T> implements Iterator<T> {

        /* renamed from: a */
        @NullableDecl
        private Iterator<? extends T> f7798a;

        /* renamed from: b */
        private Iterator<? extends T> f7799b = C1154ag.m9881a();

        /* renamed from: c */
        private Iterator<? extends Iterator<? extends T>> f7800c;

        /* renamed from: d */
        @NullableDecl
        private Deque<Iterator<? extends Iterator<? extends T>>> f7801d;

        b(Iterator<? extends Iterator<? extends T>> it) {
            this.f7800c = (Iterator) C1120o.m9547a(it);
        }

        @NullableDecl
        /* renamed from: a */
        private Iterator<? extends Iterator<? extends T>> m9905a() {
            while (true) {
                if (this.f7800c != null && this.f7800c.hasNext()) {
                    return this.f7800c;
                }
                if (this.f7801d == null || this.f7801d.isEmpty()) {
                    break;
                }
                this.f7800c = this.f7801d.removeFirst();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) C1120o.m9547a(this.f7799b)).hasNext()) {
                this.f7800c = m9905a();
                if (this.f7800c == null) {
                    return false;
                }
                this.f7799b = this.f7800c.next();
                if (this.f7799b instanceof b) {
                    b bVar = (b) this.f7799b;
                    this.f7799b = bVar.f7799b;
                    if (this.f7801d == null) {
                        this.f7801d = new ArrayDeque();
                    }
                    this.f7801d.addFirst(this.f7800c);
                    if (bVar.f7801d != null) {
                        while (!bVar.f7801d.isEmpty()) {
                            this.f7801d.addFirst(bVar.f7801d.removeLast());
                        }
                    }
                    this.f7800c = bVar.f7800c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                this.f7798a = this.f7799b;
                return this.f7799b.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            C1197l.m10054a(this.f7798a != null);
            this.f7798a.remove();
            this.f7798a = null;
        }
    }

    /* renamed from: f */
    static <T> ListIterator<T> m9902f(Iterator<T> it) {
        return (ListIterator) it;
    }
}
