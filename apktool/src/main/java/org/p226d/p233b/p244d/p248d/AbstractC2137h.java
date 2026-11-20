package org.p226d.p233b.p244d.p248d;

import java.util.AbstractSequentialList;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;

/* compiled from: VariableSizeList.java */
/* renamed from: org.d.b.d.d.h */
/* loaded from: classes.dex */
public abstract class AbstractC2137h<T> extends AbstractSequentialList<T> {

    /* renamed from: a */
    private final C2153g f11911a;

    /* renamed from: b */
    private final int f11912b;

    /* renamed from: c */
    private final int f11913c;

    /* renamed from: b */
    protected abstract T mo14725b(C2161o c2161o, int i);

    public AbstractC2137h(C2153g c2153g, int i, int i2) {
        this.f11911a = c2153g;
        this.f11912b = i;
        this.f11913c = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC2138i<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f11913c;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC2138i<T> listIterator(int i) {
        AbstractC2138i<T> abstractC2138i = new AbstractC2138i<T>(this.f11911a, this.f11912b, this.f11913c) { // from class: org.d.b.d.d.h.1
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2138i
            /* renamed from: a */
            protected T mo14726a(C2161o c2161o, int i2) {
                return (T) AbstractC2137h.this.mo14725b(c2161o, i2);
            }
        };
        for (int i2 = 0; i2 < i; i2++) {
            abstractC2138i.next();
        }
        return abstractC2138i;
    }
}
