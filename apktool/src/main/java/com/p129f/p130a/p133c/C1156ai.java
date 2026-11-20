package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p137g.C1219c;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Lists.java */
/* renamed from: com.f.a.c.ai */
/* loaded from: classes.dex */
public final class C1156ai {
    /* renamed from: a */
    public static <E> ArrayList<E> m9909a() {
        return new ArrayList<>();
    }

    @SafeVarargs
    /* renamed from: a */
    public static <E> ArrayList<E> m9912a(E... eArr) {
        C1120o.m9547a(eArr);
        ArrayList<E> arrayList = new ArrayList<>(m9908a(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    /* renamed from: a */
    public static <E> ArrayList<E> m9910a(Iterable<? extends E> iterable) {
        C1120o.m9547a(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(C1198m.m10056a(iterable));
        }
        return m9911a(iterable.iterator());
    }

    /* renamed from: a */
    public static <E> ArrayList<E> m9911a(Iterator<? extends E> it) {
        ArrayList<E> m9909a = m9909a();
        C1154ag.m9890a(m9909a, it);
        return m9909a;
    }

    /* renamed from: a */
    static int m9908a(int i) {
        C1197l.m10052a(i, "arraySize");
        return C1219c.m10174a(5 + i + (i / 10));
    }

    /* renamed from: a */
    public static <F, T> List<T> m9914a(List<F> list, InterfaceC1112g<? super F, ? extends T> interfaceC1112g) {
        return list instanceof RandomAccess ? new c(list, interfaceC1112g) : new d(list, interfaceC1112g);
    }

    /* compiled from: Lists.java */
    /* renamed from: com.f.a.c.ai$d */
    private static class d<F, T> extends AbstractSequentialList<T> implements Serializable {

        /* renamed from: a */
        final List<F> f7815a;

        /* renamed from: b */
        final InterfaceC1112g<? super F, ? extends T> f7816b;

        d(List<F> list, InterfaceC1112g<? super F, ? extends T> interfaceC1112g) {
            this.f7815a = (List) C1120o.m9547a(list);
            this.f7816b = (InterfaceC1112g) C1120o.m9547a(interfaceC1112g);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f7815a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7815a.size();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new AbstractC1183bi<F, T>(this.f7815a.listIterator(i)) { // from class: com.f.a.c.ai.d.1
                @Override // com.p129f.p130a.p133c.AbstractC1182bh
                /* renamed from: a */
                T mo9904a(F f2) {
                    return d.this.f7816b.mo9517a(f2);
                }
            };
        }
    }

    /* compiled from: Lists.java */
    /* renamed from: com.f.a.c.ai$c */
    private static class c<F, T> extends AbstractList<T> implements Serializable, RandomAccess {

        /* renamed from: a */
        final List<F> f7812a;

        /* renamed from: b */
        final InterfaceC1112g<? super F, ? extends T> f7813b;

        c(List<F> list, InterfaceC1112g<? super F, ? extends T> interfaceC1112g) {
            this.f7812a = (List) C1120o.m9547a(list);
            this.f7813b = (InterfaceC1112g) C1120o.m9547a(interfaceC1112g);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f7812a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.f7813b.mo9517a(this.f7812a.get(i));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new AbstractC1183bi<F, T>(this.f7812a.listIterator(i)) { // from class: com.f.a.c.ai.c.1
                @Override // com.p129f.p130a.p133c.AbstractC1182bh
                /* renamed from: a */
                T mo9904a(F f2) {
                    return c.this.f7813b.mo9517a(f2);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f7812a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.f7813b.mo9517a(this.f7812a.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7812a.size();
        }
    }

    /* renamed from: a */
    public static <T> List<T> m9913a(List<T> list) {
        if (list instanceof AbstractC1208w) {
            return ((AbstractC1208w) list).mo10143i();
        }
        if (list instanceof b) {
            return ((b) list).m9923a();
        }
        if (list instanceof RandomAccess) {
            return new a(list);
        }
        return new b(list);
    }

    /* compiled from: Lists.java */
    /* renamed from: com.f.a.c.ai$b */
    private static class b<T> extends AbstractList<T> {

        /* renamed from: a */
        private final List<T> f7808a;

        b(List<T> list) {
            this.f7808a = (List) C1120o.m9547a(list);
        }

        /* renamed from: a */
        List<T> m9923a() {
            return this.f7808a;
        }

        /* renamed from: a */
        private int m9920a(int i) {
            int size = size();
            C1120o.m9545a(i, size);
            return (size - 1) - i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public int m9922b(int i) {
            int size = size();
            C1120o.m9555b(i, size);
            return size - i;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, @NullableDecl T t) {
            this.f7808a.add(m9922b(i), t);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f7808a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.f7808a.remove(m9920a(i));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int i, @NullableDecl T t) {
            return this.f7808a.set(m9920a(i), t);
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.f7808a.get(m9920a(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7808a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i, int i2) {
            C1120o.m9549a(i, i2, size());
            return C1156ai.m9913a((List) this.f7808a.subList(m9922b(i2), m9922b(i)));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            final ListIterator<T> listIterator = this.f7808a.listIterator(m9922b(i));
            return new ListIterator<T>() { // from class: com.f.a.c.ai.b.1

                /* renamed from: a */
                boolean f7809a;

                @Override // java.util.ListIterator
                public void add(T t) {
                    listIterator.add(t);
                    listIterator.previous();
                    this.f7809a = false;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.f7809a = true;
                    return (T) listIterator.previous();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return b.this.m9922b(listIterator.nextIndex());
                }

                @Override // java.util.ListIterator
                public T previous() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    this.f7809a = true;
                    return (T) listIterator.next();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return nextIndex() - 1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    C1197l.m10054a(this.f7809a);
                    listIterator.remove();
                    this.f7809a = false;
                }

                @Override // java.util.ListIterator
                public void set(T t) {
                    C1120o.m9558b(this.f7809a);
                    listIterator.set(t);
                }
            };
        }
    }

    /* compiled from: Lists.java */
    /* renamed from: com.f.a.c.ai$a */
    private static class a<T> extends b<T> implements RandomAccess {
        a(List<T> list) {
            super(list);
        }
    }

    /* renamed from: a */
    static boolean m9915a(List<?> list, @NullableDecl Object obj) {
        if (obj == C1120o.m9547a(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i = 0; i < size; i++) {
                if (!C1116k.m9538a(list.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return C1154ag.m9892a(list.iterator(), (Iterator<?>) list2.iterator());
    }

    /* renamed from: b */
    static int m9916b(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return m9918d(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (C1116k.m9538a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    /* renamed from: d */
    private static int m9918d(List<?> list, @NullableDecl Object obj) {
        int i = 0;
        int size = list.size();
        if (obj == null) {
            while (i < size) {
                if (list.get(i) != null) {
                    i++;
                } else {
                    return i;
                }
            }
        } else {
            while (i < size) {
                if (!obj.equals(list.get(i))) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }

    /* renamed from: c */
    static int m9917c(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return m9919e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (C1116k.m9538a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    /* renamed from: e */
    private static int m9919e(List<?> list, @NullableDecl Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (obj.equals(list.get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }
}
