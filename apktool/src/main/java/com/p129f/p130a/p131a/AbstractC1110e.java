package com.p129f.p130a.p131a;

import com.google.errorprone.annotations.ForOverride;
import java.p209io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Equivalence.java */
/* renamed from: com.f.a.a.e */
/* loaded from: classes.dex */
public abstract class AbstractC1110e<T> {
    @ForOverride
    /* renamed from: b */
    protected abstract int mo9515b(T t);

    @ForOverride
    /* renamed from: b */
    protected abstract boolean mo9516b(T t, T t2);

    protected AbstractC1110e() {
    }

    /* renamed from: a */
    public final boolean m9514a(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return mo9516b(t, t2);
    }

    /* renamed from: a */
    public final int m9513a(@NullableDecl T t) {
        if (t == null) {
            return 0;
        }
        return mo9515b(t);
    }

    /* renamed from: a */
    public static AbstractC1110e<Object> m9511a() {
        return a.f7524a;
    }

    /* renamed from: b */
    public static AbstractC1110e<Object> m9512b() {
        return b.f7525a;
    }

    /* compiled from: Equivalence.java */
    /* renamed from: com.f.a.a.e$a */
    static final class a extends AbstractC1110e<Object> implements Serializable {

        /* renamed from: a */
        static final a f7524a = new a();

        a() {
        }

        @Override // com.p129f.p130a.p131a.AbstractC1110e
        /* renamed from: b */
        protected boolean mo9516b(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.p129f.p130a.p131a.AbstractC1110e
        /* renamed from: b */
        protected int mo9515b(Object obj) {
            return obj.hashCode();
        }
    }

    /* compiled from: Equivalence.java */
    /* renamed from: com.f.a.a.e$b */
    static final class b extends AbstractC1110e<Object> implements Serializable {

        /* renamed from: a */
        static final b f7525a = new b();

        b() {
        }

        @Override // com.p129f.p130a.p131a.AbstractC1110e
        /* renamed from: b */
        protected boolean mo9516b(Object obj, Object obj2) {
            return false;
        }

        @Override // com.p129f.p130a.p131a.AbstractC1110e
        /* renamed from: b */
        protected int mo9515b(Object obj) {
            return System.identityHashCode(obj);
        }
    }
}
