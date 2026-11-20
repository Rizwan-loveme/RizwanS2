package org.p226d.p233b.p244d.p248d;

import java.util.AbstractList;

/* compiled from: FixedSizeList.java */
/* renamed from: org.d.b.d.d.d */
/* loaded from: classes.dex */
public abstract class AbstractC2133d<T> extends AbstractList<T> {
    /* renamed from: b */
    public abstract T mo14625b(int i);

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return mo14625b(i);
    }
}
