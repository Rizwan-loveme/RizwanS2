package com.p129f.p130a.p138h.p139a;

import com.p129f.p130a.p131a.C1120o;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: MoreExecutors.java */
/* renamed from: com.f.a.h.a.k */
/* loaded from: classes.dex */
public final class C1232k {
    /* renamed from: a */
    public static Executor m10225a() {
        return EnumC1224c.INSTANCE;
    }

    /* renamed from: a */
    static Executor m10226a(Executor executor, AbstractC1222a<?> abstractC1222a) {
        C1120o.m9547a(executor);
        C1120o.m9547a(abstractC1222a);
        return executor == m10225a() ? executor : new AnonymousClass1(executor, abstractC1222a);
    }

    /* compiled from: MoreExecutors.java */
    /* renamed from: com.f.a.h.a.k$1, reason: invalid class name */
    static class AnonymousClass1 implements Executor {

        /* renamed from: a */
        boolean f8025a = true;

        /* renamed from: b */
        final /* synthetic */ Executor f8026b;

        /* renamed from: c */
        final /* synthetic */ AbstractC1222a f8027c;

        AnonymousClass1(Executor executor, AbstractC1222a abstractC1222a) {
            this.f8026b = executor;
            this.f8027c = abstractC1222a;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            try {
                this.f8026b.execute(new Runnable() { // from class: com.f.a.h.a.k.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.f8025a = false;
                        runnable.run();
                    }
                });
            } catch (RejectedExecutionException e2) {
                if (this.f8025a) {
                    this.f8027c.mo10204a((Throwable) e2);
                }
            }
        }
    }
}
