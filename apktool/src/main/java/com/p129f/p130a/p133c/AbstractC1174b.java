package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractIterator.java */
/* renamed from: com.f.a.c.b */
/* loaded from: classes.dex */
public abstract class AbstractC1174b<T> extends AbstractC1185bk<T> {

    /* renamed from: a */
    private a f7863a = a.NOT_READY;

    /* renamed from: b */
    @NullableDecl
    private T f7864b;

    /* compiled from: AbstractIterator.java */
    /* renamed from: com.f.a.c.b$a */
    private enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* renamed from: a */
    protected abstract T mo9903a();

    protected AbstractC1174b() {
    }

    @CanIgnoreReturnValue
    /* renamed from: b */
    protected final T m10002b() {
        this.f7863a = a.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        C1120o.m9558b(this.f7863a != a.FAILED);
        switch (this.f7863a) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return m10001c();
        }
    }

    /* renamed from: c */
    private boolean m10001c() {
        this.f7863a = a.FAILED;
        this.f7864b = mo9903a();
        if (this.f7863a == a.DONE) {
            return false;
        }
        this.f7863a = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f7863a = a.NOT_READY;
        T t = this.f7864b;
        this.f7864b = null;
        return t;
    }
}
