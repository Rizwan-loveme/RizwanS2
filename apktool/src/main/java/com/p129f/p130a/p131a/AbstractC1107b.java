package com.p129f.p130a.p131a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractIterator.java */
/* renamed from: com.f.a.a.b */
/* loaded from: classes.dex */
abstract class AbstractC1107b<T> implements Iterator<T> {

    /* renamed from: a */
    private a f7513a = a.NOT_READY;

    /* renamed from: b */
    @NullableDecl
    private T f7514b;

    /* compiled from: AbstractIterator.java */
    /* renamed from: com.f.a.a.b$a */
    private enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* renamed from: a */
    protected abstract T mo9500a();

    protected AbstractC1107b() {
    }

    @CanIgnoreReturnValue
    @NullableDecl
    /* renamed from: b */
    protected final T m9501b() {
        this.f7513a = a.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        C1120o.m9558b(this.f7513a != a.FAILED);
        switch (this.f7513a) {
            case READY:
                return true;
            case DONE:
                return false;
            default:
                return m9499c();
        }
    }

    /* renamed from: c */
    private boolean m9499c() {
        this.f7513a = a.FAILED;
        this.f7514b = mo9500a();
        if (this.f7513a == a.DONE) {
            return false;
        }
        this.f7513a = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f7513a = a.NOT_READY;
        T t = this.f7514b;
        this.f7514b = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
