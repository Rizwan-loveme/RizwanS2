package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p131a.InterfaceC1121p;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Iterables.java */
/* renamed from: com.f.a.c.af */
/* loaded from: classes.dex */
public final class C1153af {
    /* renamed from: a */
    public static int m9865a(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return C1154ag.m9880a(iterable.iterator());
    }

    /* renamed from: b */
    public static String m9873b(Iterable<?> iterable) {
        return C1154ag.m9894b(iterable.iterator());
    }

    /* renamed from: c */
    static Object[] m9875c(Iterable<?> iterable) {
        return m9878f(iterable).toArray();
    }

    /* renamed from: f */
    private static <E> Collection<E> m9878f(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : C1156ai.m9911a(iterable.iterator());
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public static <T> boolean m9872a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll(C1198m.m10056a(iterable)) : C1154ag.m9890a(collection, ((Iterable) C1120o.m9547a(iterable)).iterator());
    }

    /* renamed from: a */
    public static <T> Iterable<T> m9870a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return AbstractC1203r.m10109a(iterable, iterable2);
    }

    /* renamed from: d */
    public static <T> Iterable<T> m9876d(Iterable<? extends Iterable<? extends T>> iterable) {
        return AbstractC1203r.m10112b(iterable);
    }

    /* renamed from: a */
    public static <T> Iterable<T> m9869a(final Iterable<T> iterable, final InterfaceC1121p<? super T> interfaceC1121p) {
        C1120o.m9547a(iterable);
        C1120o.m9547a(interfaceC1121p);
        return new AbstractC1203r<T>() { // from class: com.f.a.c.af.2
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return C1154ag.m9884a((Iterator) Iterable.this.iterator(), interfaceC1121p);
            }
        };
    }

    /* renamed from: b */
    public static <T> boolean m9874b(Iterable<T> iterable, InterfaceC1121p<? super T> interfaceC1121p) {
        return C1154ag.m9897b(iterable.iterator(), interfaceC1121p);
    }

    /* renamed from: a */
    public static <F, T> Iterable<T> m9868a(final Iterable<F> iterable, final InterfaceC1112g<? super F, ? extends T> interfaceC1112g) {
        C1120o.m9547a(iterable);
        C1120o.m9547a(interfaceC1112g);
        return new AbstractC1203r<T>() { // from class: com.f.a.c.af.3
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return C1154ag.m9889a((Iterator) Iterable.this.iterator(), interfaceC1112g);
            }
        };
    }

    @NullableDecl
    /* renamed from: a */
    public static <T> T m9871a(Iterable<? extends T> iterable, @NullableDecl T t) {
        return (T) C1154ag.m9887a(iterable.iterator(), t);
    }

    /* renamed from: a */
    public static <T> Iterable<T> m9867a(final Iterable<T> iterable, final int i) {
        C1120o.m9547a(iterable);
        C1120o.m9551a(i >= 0, "limit is negative");
        return new AbstractC1203r<T>() { // from class: com.f.a.c.af.4
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return C1154ag.m9888a(Iterable.this.iterator(), i);
            }
        };
    }

    /* renamed from: e */
    public static boolean m9877e(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    /* renamed from: a */
    static <T> InterfaceC1112g<Iterable<? extends T>, Iterator<? extends T>> m9866a() {
        return new InterfaceC1112g<Iterable<? extends T>, Iterator<? extends T>>() { // from class: com.f.a.c.af.1
            @Override // com.p129f.p130a.p131a.InterfaceC1112g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> mo9517a(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }
}
