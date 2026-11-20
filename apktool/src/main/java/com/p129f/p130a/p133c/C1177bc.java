package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Sets.java */
/* renamed from: com.f.a.c.bc */
/* loaded from: classes.dex */
public final class C1177bc {

    /* compiled from: Sets.java */
    /* renamed from: com.f.a.c.bc$a */
    static abstract class a<E> extends AbstractSet<E> {
        a() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return C1177bc.m10008a((Set<?>) this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) C1120o.m9547a(collection));
        }
    }

    /* renamed from: a */
    public static <E> HashSet<E> m10005a() {
        return new HashSet<>();
    }

    /* renamed from: a */
    public static <E> HashSet<E> m10006a(int i) {
        return new HashSet<>(C1157aj.m9924a(i));
    }

    /* renamed from: a */
    static int m10004a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ((i + (next != null ? next.hashCode() : 0)) ^ (-1)) ^ (-1);
        }
        return i;
    }

    /* renamed from: a */
    static boolean m10007a(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                if (set.containsAll(set2)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException | NullPointerException e2) {
            return false;
        }
    }

    /* renamed from: a */
    static boolean m10009a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    /* renamed from: a */
    static boolean m10008a(Set<?> set, Collection<?> collection) {
        C1120o.m9547a(collection);
        if (collection instanceof InterfaceC1160am) {
            collection = ((InterfaceC1160am) collection).m9949a();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? m10009a(set, collection.iterator()) : C1154ag.m9891a(set.iterator(), collection);
    }
}
