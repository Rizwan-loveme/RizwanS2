package com.p129f.p130a.p138h.p139a;

import java.util.concurrent.Executor;

/* compiled from: DirectExecutor.java */
/* renamed from: com.f.a.h.a.c */
/* loaded from: classes.dex */
enum EnumC1224c implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
