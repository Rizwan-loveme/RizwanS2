package com.p129f.p130a.p133c;

import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractSequentialIterator.java */
/* renamed from: com.f.a.c.g */
/* loaded from: classes.dex */
public abstract class AbstractC1192g<T> extends AbstractC1185bk<T> {

    /* renamed from: a */
    @NullableDecl
    private T f7912a;

    @NullableDecl
    /* renamed from: a */
    protected abstract T mo9695a(T t);

    protected AbstractC1192g(@NullableDecl T t) {
        this.f7912a = t;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7912a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return this.f7912a;
        } finally {
            this.f7912a = mo9695a(this.f7912a);
        }
    }
}
