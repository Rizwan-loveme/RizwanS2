package com.p129f.p130a.p138h.p139a;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p138h.p139a.AbstractC1222a;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmediateFuture.java */
/* renamed from: com.f.a.h.a.i */
/* loaded from: classes.dex */
abstract class AbstractC1230i<V> implements InterfaceFutureC1231j<V> {

    /* renamed from: a */
    private static final Logger f8022a = Logger.getLogger(AbstractC1230i.class.getName());

    @Override // java.util.concurrent.Future
    public abstract V get();

    AbstractC1230i() {
    }

    @Override // com.p129f.p130a.p138h.p139a.InterfaceFutureC1231j
    /* renamed from: a */
    public void mo10200a(Runnable runnable, Executor executor) {
        C1120o.m9548a(runnable, "Runnable was null.");
        C1120o.m9548a(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f8022a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        C1120o.m9547a(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    /* compiled from: ImmediateFuture.java */
    /* renamed from: com.f.a.h.a.i$b */
    static class b<V> extends AbstractC1230i<V> {

        /* renamed from: a */
        static final b<Object> f8023a = new b<>(null);

        /* renamed from: b */
        @NullableDecl
        private final V f8024b;

        b(@NullableDecl V v) {
            this.f8024b = v;
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1230i, java.util.concurrent.Future
        public V get() {
            return this.f8024b;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f8024b + "]]";
        }
    }

    /* compiled from: ImmediateFuture.java */
    /* renamed from: com.f.a.h.a.i$a */
    static final class a<V> extends AbstractC1222a.i<V> {
        a(Throwable th) {
            mo10204a(th);
        }
    }
}
