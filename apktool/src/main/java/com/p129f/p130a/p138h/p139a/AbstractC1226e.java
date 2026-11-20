package com.p129f.p130a.p138h.p139a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p138h.p139a.AbstractC1222a;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: FluentFuture.java */
/* renamed from: com.f.a.h.a.e */
/* loaded from: classes.dex */
public abstract class AbstractC1226e<V> extends AbstractC1228g<V> {

    /* compiled from: FluentFuture.java */
    /* renamed from: com.f.a.h.a.e$a */
    static abstract class a<V> extends AbstractC1226e<V> implements AbstractC1222a.h<V> {
        a() {
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() {
            return (V) super.get();
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) {
            return (V) super.get(j, timeUnit);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, com.p129f.p130a.p138h.p139a.InterfaceFutureC1231j
        /* renamed from: a */
        public final void mo10200a(Runnable runnable, Executor executor) {
            super.mo10200a(runnable, executor);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }
    }

    AbstractC1226e() {
    }
}
