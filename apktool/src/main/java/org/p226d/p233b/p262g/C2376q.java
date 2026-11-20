package org.p226d.p233b.p262g;

import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: RewriterUtils.java */
/* renamed from: org.d.b.g.q */
/* loaded from: classes.dex */
public class C2376q {
    /* renamed from: a */
    public static <T> T m15063a(InterfaceC2374o<T> interfaceC2374o, T t) {
        if (t == null) {
            return null;
        }
        return interfaceC2374o.mo15030a(t);
    }

    /* renamed from: a */
    public static <T> Set<T> m15065a(final InterfaceC2374o<T> interfaceC2374o, final Set<? extends T> set) {
        return new AbstractSet<T>() { // from class: org.d.b.g.q.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<T> iterator() {
                final Iterator it = Set.this.iterator();
                return new Iterator<T>() { // from class: org.d.b.g.q.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        return (T) C2376q.m15063a((InterfaceC2374o<Object>) interfaceC2374o, it.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        it.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Set.this.size();
            }
        };
    }

    /* renamed from: a */
    public static <T> List<T> m15064a(final InterfaceC2374o<T> interfaceC2374o, final List<? extends T> list) {
        return new AbstractList<T>() { // from class: org.d.b.g.q.2
            @Override // java.util.AbstractList, java.util.List
            public T get(int i) {
                return (T) C2376q.m15063a((InterfaceC2374o<Object>) InterfaceC2374o.this, list.get(i));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return list.size();
            }
        };
    }

    /* renamed from: a */
    public static <T> Iterable<T> m15062a(final InterfaceC2374o<T> interfaceC2374o, final Iterable<? extends T> iterable) {
        return new Iterable<T>() { // from class: org.d.b.g.q.3
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                final Iterator<T> it = Iterable.this.iterator();
                return new Iterator<T>() { // from class: org.d.b.g.q.3.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        return (T) C2376q.m15063a((InterfaceC2374o<Object>) interfaceC2374o, it.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        it.remove();
                    }
                };
            }
        };
    }

    /* renamed from: a */
    public static InterfaceC2243h m15066a(final InterfaceC2374o<String> interfaceC2374o, final InterfaceC2243h interfaceC2243h) {
        return new AbstractC1993g() { // from class: org.d.b.g.q.4
            @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
            /* renamed from: l */
            public String mo14205l() {
                return (String) InterfaceC2374o.this.mo15030a(interfaceC2243h.mo14205l());
            }
        };
    }
}
