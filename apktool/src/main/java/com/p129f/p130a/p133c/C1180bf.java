package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: SortedIterables.java */
/* renamed from: com.f.a.c.bf */
/* loaded from: classes.dex */
final class C1180bf {
    /* renamed from: a */
    public static boolean m10011a(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        C1120o.m9547a(comparator);
        C1120o.m9547a(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = m10010a((SortedSet) iterable);
        } else if (iterable instanceof InterfaceC1179be) {
            comparator2 = ((InterfaceC1179be) iterable).comparator();
        } else {
            return false;
        }
        return comparator.equals(comparator2);
    }

    /* renamed from: a */
    public static <E> Comparator<? super E> m10010a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return AbstractC1163ap.m9957b();
        }
        return comparator;
    }
}
