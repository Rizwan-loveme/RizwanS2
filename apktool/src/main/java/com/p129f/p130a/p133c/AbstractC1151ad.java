package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1206u;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p000a.p002b.p003a.p004a.C0007b;

/* compiled from: ImmutableSortedSet.java */
/* renamed from: com.f.a.c.ad */
/* loaded from: classes.dex */
public abstract class AbstractC1151ad<E> extends AbstractC1152ae<E> implements InterfaceC1179be<E>, NavigableSet<E> {

    /* renamed from: a */
    final transient Comparator<? super E> f7776a;

    /* renamed from: b */
    @LazyInit
    transient AbstractC1151ad<E> f7777b;

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public abstract AbstractC1185bk<E> iterator();

    /* renamed from: b */
    abstract AbstractC1151ad<E> mo9854b(E e2, boolean z, E e3, boolean z2);

    /* renamed from: c */
    abstract AbstractC1151ad<E> mo9856c(E e2, boolean z);

    /* renamed from: d */
    abstract int mo9857d(@NullableDecl Object obj);

    /* renamed from: d */
    abstract AbstractC1151ad<E> mo9858d(E e2, boolean z);

    /* renamed from: l */
    abstract AbstractC1151ad<E> mo9860l();

    @Override // java.util.NavigableSet
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public abstract AbstractC1185bk<E> descendingIterator();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return m9849a((AbstractC1151ad<E>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return m9853b((AbstractC1151ad<E>) obj, z);
    }

    /* renamed from: a */
    static <E> C1173az<E> m9846a(Comparator<? super E> comparator) {
        return AbstractC1163ap.m9957b().equals(comparator) ? (C1173az<E>) C1173az.f7861c : new C1173az<>(AbstractC1208w.m10138g(), comparator);
    }

    /* renamed from: g */
    public static <E> AbstractC1151ad<E> m9847g() {
        return C1173az.f7861c;
    }

    /* renamed from: a */
    public static <E> AbstractC1151ad<E> m9840a(Iterable<? extends E> iterable) {
        return m9843a((Comparator) AbstractC1163ap.m9957b(), (Iterable) iterable);
    }

    /* renamed from: a */
    public static <E> AbstractC1151ad<E> m9841a(Collection<? extends E> collection) {
        return m9844a((Comparator) AbstractC1163ap.m9957b(), (Collection) collection);
    }

    /* renamed from: a */
    public static <E> AbstractC1151ad<E> m9845a(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new a(comparator).mo9810a((Iterator) it).mo9808a();
    }

    /* renamed from: a */
    public static <E> AbstractC1151ad<E> m9843a(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        C1120o.m9547a(comparator);
        if (C1180bf.m10011a(comparator, iterable) && (iterable instanceof AbstractC1151ad)) {
            AbstractC1151ad<E> abstractC1151ad = (AbstractC1151ad) iterable;
            if (!abstractC1151ad.mo9838f()) {
                return abstractC1151ad;
            }
        }
        Object[] m9875c = C1153af.m9875c(iterable);
        return m9842a(comparator, m9875c.length, m9875c);
    }

    /* renamed from: a */
    public static <E> AbstractC1151ad<E> m9844a(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return m9843a((Comparator) comparator, (Iterable) collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    static <E> AbstractC1151ad<E> m9842a(Comparator<? super E> comparator, int i, E... eArr) {
        int i2;
        if (i == 0) {
            return m9846a((Comparator) comparator);
        }
        C1162ao.m9955b(eArr, i);
        Arrays.sort(eArr, 0, i, comparator);
        int i3 = 1;
        int i4 = 1;
        while (i3 < i) {
            C0007b.AnonymousClass1 anonymousClass1 = (Object) eArr[i3];
            if (comparator.compare(anonymousClass1, (Object) eArr[i4 - 1]) != 0) {
                i2 = i4 + 1;
                eArr[i4] = anonymousClass1;
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        Arrays.fill(eArr, i4, i, (Object) null);
        if (i4 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i4);
        }
        return new C1173az(AbstractC1208w.m10137b(eArr, i4), comparator);
    }

    /* compiled from: ImmutableSortedSet.java */
    /* renamed from: com.f.a.c.ad$a */
    public static final class a<E> extends AbstractC1148aa.a<E> {

        /* renamed from: e */
        private final Comparator<? super E> f7778e;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p129f.p130a.p133c.AbstractC1148aa.a, com.p129f.p130a.p133c.AbstractC1206u.a
        @CanIgnoreReturnValue
        /* renamed from: a */
        public /* synthetic */ AbstractC1206u.a mo9812b(Object obj) {
            return m9864d((a<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p129f.p130a.p133c.AbstractC1148aa.a, com.p129f.p130a.p133c.AbstractC1206u.a, com.p129f.p130a.p133c.AbstractC1206u.b
        @CanIgnoreReturnValue
        /* renamed from: b */
        public /* synthetic */ AbstractC1206u.b mo9812b(Object obj) {
            return m9864d((a<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p129f.p130a.p133c.AbstractC1148aa.a
        @CanIgnoreReturnValue
        /* renamed from: c */
        public /* synthetic */ AbstractC1148aa.a mo9812b(Object obj) {
            return m9864d((a<E>) obj);
        }

        public a(Comparator<? super E> comparator) {
            this.f7778e = (Comparator) C1120o.m9547a(comparator);
        }

        @CanIgnoreReturnValue
        /* renamed from: d */
        public a<E> m9864d(E e2) {
            super.mo9812b((a<E>) e2);
            return this;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa.a
        @CanIgnoreReturnValue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a<E> mo9810a(Iterator<? extends E> it) {
            super.mo9810a((Iterator) it);
            return this;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1148aa.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbstractC1151ad<E> mo9808a() {
            AbstractC1151ad<E> m9842a = AbstractC1151ad.m9842a(this.f7778e, this.f7955b, this.f7954a);
            this.f7955b = m9842a.size();
            this.f7956c = true;
            return m9842a;
        }
    }

    /* renamed from: a */
    int m9848a(Object obj, Object obj2) {
        return m9839a(this.f7776a, obj, obj2);
    }

    /* renamed from: a */
    static int m9839a(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    AbstractC1151ad(Comparator<? super E> comparator) {
        this.f7776a = comparator;
    }

    @Override // com.p129f.p130a.p133c.InterfaceC1179be, java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.f7776a;
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<E> headSet(E e2) {
        return m9849a((AbstractC1151ad<E>) e2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public AbstractC1151ad<E> m9849a(E e2, boolean z) {
        return mo9856c(C1120o.m9547a(e2), z);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<E> subSet(E e2, E e3) {
        return subSet(e2, true, e3, false);
    }

    @Override // java.util.NavigableSet
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<E> subSet(E e2, boolean z, E e3, boolean z2) {
        C1120o.m9547a(e2);
        C1120o.m9547a(e3);
        C1120o.m9550a(this.f7776a.compare(e2, e3) <= 0);
        return mo9854b(e2, z, e3, z2);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<E> tailSet(E e2) {
        return m9853b((AbstractC1151ad<E>) e2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public AbstractC1151ad<E> m9853b(E e2, boolean z) {
        return mo9858d(C1120o.m9547a(e2), z);
    }

    @Override // java.util.NavigableSet
    public E lower(E e2) {
        return (E) C1154ag.m9887a(m9849a((AbstractC1151ad<E>) e2, false).descendingIterator(), (Object) null);
    }

    @Override // java.util.NavigableSet
    public E floor(E e2) {
        return (E) C1154ag.m9887a(m9849a((AbstractC1151ad<E>) e2, true).descendingIterator(), (Object) null);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e2) {
        return (E) C1153af.m9871a(m9853b((AbstractC1151ad<E>) e2, true), (Object) null);
    }

    @Override // java.util.NavigableSet
    public E higher(E e2) {
        return (E) C1153af.m9871a(m9853b((AbstractC1151ad<E>) e2, false), (Object) null);
    }

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC1151ad<E> descendingSet() {
        AbstractC1151ad<E> abstractC1151ad = this.f7777b;
        if (abstractC1151ad == null) {
            AbstractC1151ad<E> mo9860l = mo9860l();
            this.f7777b = mo9860l;
            mo9860l.f7777b = this;
            return mo9860l;
        }
        return abstractC1151ad;
    }
}
