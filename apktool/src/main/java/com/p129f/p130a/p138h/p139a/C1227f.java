package com.p129f.p130a.p138h.p139a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p138h.p139a.AbstractC1230i;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Futures.java */
/* renamed from: com.f.a.h.a.f */
/* loaded from: classes.dex */
public final class C1227f extends AbstractC1229h {
    /* renamed from: a */
    public static <V> InterfaceFutureC1231j<V> m10222a(@NullableDecl V v) {
        return v == null ? AbstractC1230i.b.f8023a : new AbstractC1230i.b(v);
    }

    /* renamed from: a */
    public static <V> InterfaceFutureC1231j<V> m10223a(Throwable th) {
        C1120o.m9547a(th);
        return new AbstractC1230i.a(th);
    }

    /* renamed from: a */
    public static <I, O> InterfaceFutureC1231j<O> m10221a(InterfaceFutureC1231j<I> interfaceFutureC1231j, InterfaceC1112g<? super I, ? extends O> interfaceC1112g, Executor executor) {
        return AbstractRunnableC1223b.m10217a(interfaceFutureC1231j, interfaceC1112g, executor);
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public static <V> V m10224a(Future<V> future) {
        C1120o.m9560b(future.isDone(), "Future was expected to be done: %s", future);
        return (V) C1235n.m10228a(future);
    }
}
