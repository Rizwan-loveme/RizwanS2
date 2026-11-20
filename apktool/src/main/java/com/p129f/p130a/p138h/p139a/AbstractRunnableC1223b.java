package com.p129f.p130a.p138h.p139a;

import com.google.errorprone.annotations.ForOverride;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p138h.p139a.AbstractC1226e;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractTransformFuture.java */
/* renamed from: com.f.a.h.a.b */
/* loaded from: classes.dex */
abstract class AbstractRunnableC1223b<I, O, F, T> extends AbstractC1226e.a<O> implements Runnable {

    /* renamed from: a */
    @NullableDecl
    InterfaceFutureC1231j<? extends I> f8018a;

    /* renamed from: b */
    @NullableDecl
    F f8019b;

    @NullableDecl
    @ForOverride
    /* renamed from: a */
    abstract T mo10218a(F f2, @NullableDecl I i);

    @ForOverride
    /* renamed from: b */
    abstract void mo10219b(@NullableDecl T t);

    /* renamed from: a */
    static <I, O> InterfaceFutureC1231j<O> m10217a(InterfaceFutureC1231j<I> interfaceFutureC1231j, InterfaceC1112g<? super I, ? extends O> interfaceC1112g, Executor executor) {
        C1120o.m9547a(interfaceC1112g);
        a aVar = new a(interfaceFutureC1231j, interfaceC1112g);
        interfaceFutureC1231j.mo10200a(aVar, C1232k.m10226a(executor, aVar));
        return aVar;
    }

    AbstractRunnableC1223b(InterfaceFutureC1231j<? extends I> interfaceFutureC1231j, F f2) {
        this.f8018a = (InterfaceFutureC1231j) C1120o.m9547a(interfaceFutureC1231j);
        this.f8019b = (F) C1120o.m9547a(f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        InterfaceFutureC1231j<? extends I> interfaceFutureC1231j = this.f8018a;
        F f2 = this.f8019b;
        if (!((f2 == null) | (interfaceFutureC1231j == null) | isCancelled())) {
            this.f8018a = null;
            if (interfaceFutureC1231j.isCancelled()) {
                mo10202a((InterfaceFutureC1231j) interfaceFutureC1231j);
                return;
            }
            try {
                try {
                    try {
                        Object mo10218a = mo10218a((AbstractRunnableC1223b<I, O, F, T>) f2, (F) C1227f.m10224a((Future) interfaceFutureC1231j));
                        this.f8019b = null;
                        mo10219b((AbstractRunnableC1223b<I, O, F, T>) mo10218a);
                    } catch (Throwable th) {
                        mo10204a(th);
                        this.f8019b = null;
                    }
                } catch (Throwable th2) {
                    this.f8019b = null;
                    throw th2;
                }
            } catch (Error e2) {
                mo10204a((Throwable) e2);
            } catch (CancellationException e3) {
                cancel(false);
            } catch (RuntimeException e4) {
                mo10204a((Throwable) e4);
            } catch (ExecutionException e5) {
                mo10204a(e5.getCause());
            }
        }
    }

    @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a
    /* renamed from: c */
    protected final void mo10206c() {
        m10201a((Future<?>) this.f8018a);
        this.f8018a = null;
        this.f8019b = null;
    }

    @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a
    /* renamed from: e */
    protected String mo10208e() {
        InterfaceFutureC1231j<? extends I> interfaceFutureC1231j = this.f8018a;
        F f2 = this.f8019b;
        String e2 = super.mo10208e();
        String str = "";
        if (interfaceFutureC1231j != null) {
            str = "inputFuture=[" + interfaceFutureC1231j + "], ";
        }
        if (f2 != null) {
            return str + "function=[" + f2 + "]";
        }
        if (e2 != null) {
            return str + e2;
        }
        return null;
    }

    /* compiled from: AbstractTransformFuture.java */
    /* renamed from: com.f.a.h.a.b$a */
    private static final class a<I, O> extends AbstractRunnableC1223b<I, O, InterfaceC1112g<? super I, ? extends O>, O> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p129f.p130a.p138h.p139a.AbstractRunnableC1223b
        @NullableDecl
        /* renamed from: a */
        /* bridge */ /* synthetic */ Object mo10218a(Object obj, @NullableDecl Object obj2) {
            return m10220a((InterfaceC1112g<? super InterfaceC1112g<? super I, ? extends O>, ? extends O>) obj, (InterfaceC1112g<? super I, ? extends O>) obj2);
        }

        a(InterfaceFutureC1231j<? extends I> interfaceFutureC1231j, InterfaceC1112g<? super I, ? extends O> interfaceC1112g) {
            super(interfaceFutureC1231j, interfaceC1112g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        /* renamed from: a */
        O m10220a(InterfaceC1112g<? super I, ? extends O> interfaceC1112g, @NullableDecl I i) {
            return interfaceC1112g.mo9517a(i);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractRunnableC1223b
        /* renamed from: b */
        void mo10219b(@NullableDecl O o) {
            mo10203a((a<I, O>) o);
        }
    }
}
