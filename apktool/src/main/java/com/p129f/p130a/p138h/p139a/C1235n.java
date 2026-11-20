package com.p129f.p130a.p138h.p139a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Future;

/* compiled from: Uninterruptibles.java */
/* renamed from: com.f.a.h.a.n */
/* loaded from: classes.dex */
public final class C1235n {
    @CanIgnoreReturnValue
    /* renamed from: a */
    public static <V> V m10228a(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException e2) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }
}
