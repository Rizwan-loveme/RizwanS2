package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: SortedLists.java */
/* renamed from: com.f.a.c.bg */
/* loaded from: classes.dex */
final class C1181bg {

    /* compiled from: SortedLists.java */
    /* renamed from: com.f.a.c.bg$a */
    enum a {
        NEXT_LOWER { // from class: com.f.a.c.bg.a.1
            @Override // com.p129f.p130a.p133c.C1181bg.a
            /* renamed from: a */
            int mo10015a(int i) {
                return i - 1;
            }
        },
        NEXT_HIGHER { // from class: com.f.a.c.bg.a.2
            @Override // com.p129f.p130a.p133c.C1181bg.a
            /* renamed from: a */
            public int mo10015a(int i) {
                return i;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.f.a.c.bg.a.3
            @Override // com.p129f.p130a.p133c.C1181bg.a
            /* renamed from: a */
            public int mo10015a(int i) {
                return i ^ (-1);
            }
        };

        /* renamed from: a */
        abstract int mo10015a(int i);
    }

    /* compiled from: SortedLists.java */
    /* renamed from: com.f.a.c.bg$b */
    enum b {
        ANY_PRESENT { // from class: com.f.a.c.bg.b.1
            @Override // com.p129f.p130a.p133c.C1181bg.b
            /* renamed from: a */
            <E> int mo10016a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                return i;
            }
        },
        LAST_PRESENT { // from class: com.f.a.c.bg.b.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.p129f.p130a.p133c.C1181bg.b
            /* renamed from: a */
            <E> int mo10016a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                int size = list.size() - 1;
                int i2 = i;
                while (i2 < size) {
                    int i3 = ((i2 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i3), e2) > 0) {
                        size = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_PRESENT { // from class: com.f.a.c.bg.b.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.p129f.p130a.p133c.C1181bg.b
            /* renamed from: a */
            <E> int mo10016a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                int i2 = 0;
                int i3 = i;
                while (i2 < i3) {
                    int i4 = (i2 + i3) >>> 1;
                    if (comparator.compare(list.get(i4), e2) < 0) {
                        i2 = i4 + 1;
                    } else {
                        i3 = i4;
                    }
                }
                return i2;
            }
        },
        FIRST_AFTER { // from class: com.f.a.c.bg.b.4
            @Override // com.p129f.p130a.p133c.C1181bg.b
            /* renamed from: a */
            public <E> int mo10016a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                return LAST_PRESENT.mo10016a(comparator, e2, list, i) + 1;
            }
        },
        LAST_BEFORE { // from class: com.f.a.c.bg.b.5
            @Override // com.p129f.p130a.p133c.C1181bg.b
            /* renamed from: a */
            public <E> int mo10016a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i) {
                return FIRST_PRESENT.mo10016a(comparator, e2, list, i) - 1;
            }
        };

        /* renamed from: a */
        abstract <E> int mo10016a(Comparator<? super E> comparator, E e2, List<? extends E> list, int i);
    }

    /* renamed from: a */
    public static <E, K extends Comparable> int m10012a(List<E> list, InterfaceC1112g<? super E, K> interfaceC1112g, @NullableDecl K k, b bVar, a aVar) {
        return m10013a(list, interfaceC1112g, k, AbstractC1163ap.m9957b(), bVar, aVar);
    }

    /* renamed from: a */
    public static <E, K> int m10013a(List<E> list, InterfaceC1112g<? super E, K> interfaceC1112g, @NullableDecl K k, Comparator<? super K> comparator, b bVar, a aVar) {
        return m10014a((List<? extends K>) C1156ai.m9914a(list, interfaceC1112g), k, comparator, bVar, aVar);
    }

    /* renamed from: a */
    public static <E> int m10014a(List<? extends E> list, @NullableDecl E e2, Comparator<? super E> comparator, b bVar, a aVar) {
        C1120o.m9547a(comparator);
        C1120o.m9547a(list);
        C1120o.m9547a(bVar);
        C1120o.m9547a(aVar);
        if (!(list instanceof RandomAccess)) {
            list = C1156ai.m9910a((Iterable) list);
        }
        int i = 0;
        int size = list.size() - 1;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(e2, list.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare > 0) {
                i = i2 + 1;
            } else {
                return bVar.mo10016a(comparator, e2, list.subList(i, size + 1), i2 - i) + i;
            }
        }
        return aVar.mo10015a(i);
    }
}
