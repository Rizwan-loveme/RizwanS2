package com.p140g.p152b.p153a.p156c;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: UniqueQueue.java */
/* renamed from: com.g.b.a.c.p */
/* loaded from: classes.dex */
public class C1360p<T> extends LinkedList<T> {

    /* renamed from: a */
    Set<T> f8795a = new HashSet();

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        if (this.f8795a.add(t)) {
            super.add(t);
            return true;
        }
        return true;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public T poll() {
        T t = (T) super.poll();
        this.f8795a.remove(t);
        return t;
    }

    @Override // java.util.LinkedList, java.util.Deque
    public T pop() {
        T t = (T) super.pop();
        this.f8795a.remove(t);
        return t;
    }
}
