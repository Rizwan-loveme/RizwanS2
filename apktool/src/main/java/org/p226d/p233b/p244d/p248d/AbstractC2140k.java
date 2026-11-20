package org.p226d.p233b.p244d.p248d;

import java.util.AbstractSet;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;

/* compiled from: VariableSizeSet.java */
/* renamed from: org.d.b.d.d.k */
/* loaded from: classes.dex */
public abstract class AbstractC2140k<T> extends AbstractSet<T> {

    /* renamed from: a */
    private final C2153g f11920a;

    /* renamed from: b */
    private final int f11921b;

    /* renamed from: c */
    private final int f11922c;

    /* renamed from: b */
    protected abstract T mo14675b(C2161o c2161o, int i);

    public AbstractC2140k(C2153g c2153g, int i, int i2) {
        this.f11920a = c2153g;
        this.f11921b = i;
        this.f11922c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC2136g<T> iterator() {
        return new AbstractC2136g<T>(this.f11920a, this.f11921b, this.f11922c) { // from class: org.d.b.d.d.k.1
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2136g
            /* renamed from: b */
            protected T mo14716b(C2161o c2161o, int i) {
                return (T) AbstractC2140k.this.mo14675b(c2161o, i);
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f11922c;
    }
}
