package org.p226d.p269d;

import com.p129f.p130a.p131a.InterfaceC1121p;
import com.p129f.p130a.p133c.AbstractC1151ad;
import com.p129f.p130a.p133c.AbstractC1163ap;
import com.p129f.p130a.p137g.C1219c;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* compiled from: CollectionUtils.java */
/* renamed from: org.d.d.f */
/* loaded from: classes.dex */
public class C2452f {
    /* renamed from: a */
    public static <T> int m15513a(Iterable<T> iterable, InterfaceC1121p<? super T> interfaceC1121p) {
        int i = 0;
        int i2 = -1;
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (interfaceC1121p.mo9509a(it.next())) {
                i2 = i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static <T extends Comparable<? super T>> int m15514a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        int m10173a = C1219c.m10173a(collection.size(), collection2.size());
        if (m10173a == 0) {
            Iterator<? extends T> it = collection2.iterator();
            Iterator<? extends T> it2 = collection.iterator();
            while (it2.hasNext()) {
                int compareTo = it2.next().compareTo(it.next());
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return 0;
        }
        return m10173a;
    }

    /* renamed from: a */
    public static <T> int m15515a(Comparator<? super T> comparator, Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Iterator<? extends T> it = iterable2.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            try {
                int compare = comparator.compare(it2.next(), it.next());
                if (compare != 0) {
                    return compare;
                }
            } catch (NoSuchElementException e2) {
                return 1;
            }
        }
        if (it.hasNext()) {
            return -1;
        }
        return 0;
    }

    /* renamed from: a */
    public static <T> boolean m15517a(Iterable<? extends T> iterable) {
        if (!(iterable instanceof SortedSet)) {
            return false;
        }
        Comparator comparator = ((SortedSet) iterable).comparator();
        return comparator == null || comparator.equals(AbstractC1163ap.m9957b());
    }

    /* renamed from: a */
    private static <T> SortedSet<? extends T> m15516a(Collection<? extends T> collection) {
        return m15517a((Iterable) collection) ? (SortedSet) collection : AbstractC1151ad.m9841a((Collection) collection);
    }

    /* renamed from: b */
    public static <T extends Comparable<T>> int m15518b(Collection<? extends T> collection, Collection<? extends T> collection2) {
        int m10173a = C1219c.m10173a(collection.size(), collection2.size());
        if (m10173a == 0) {
            m15516a((Collection) collection);
            m15516a((Collection) collection2);
            Iterator<? extends T> it = collection2.iterator();
            Iterator<? extends T> it2 = collection.iterator();
            while (it2.hasNext()) {
                int compareTo = it2.next().compareTo(it.next());
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return 0;
        }
        return m10173a;
    }
}
