package com.p065b.p066a.p084c;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: RunnablesExecutor.java */
/* renamed from: com.b.a.c.e */
/* loaded from: classes.dex */
public interface InterfaceC0673e {
    public static final InterfaceC0673e SINGLE_THREADED = new InterfaceC0673e() { // from class: com.b.a.c.e.1
        @Override // com.p065b.p066a.p084c.InterfaceC0673e
        /* renamed from: a */
        public void mo6340a(InterfaceC0674f interfaceC0674f) {
            interfaceC0674f.mo5975a().run();
        }
    };
    public static final InterfaceC0673e MULTI_THREADED = new InterfaceC0673e() { // from class: com.b.a.c.e.2

        /* renamed from: a */
        private final int f4298a = Math.min(32, Runtime.getRuntime().availableProcessors());

        /* renamed from: b */
        private final int f4299b = 4;

        @Override // com.p065b.p066a.p084c.InterfaceC0673e
        /* renamed from: a */
        public void mo6340a(InterfaceC0674f interfaceC0674f) {
            int i = this.f4298a;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(4), new ThreadPoolExecutor.CallerRunsPolicy());
            for (int i2 = 0; i2 < this.f4298a; i2++) {
                threadPoolExecutor.execute(new Runnable(this, interfaceC0674f) { // from class: com.b.a.c.e.2.1

                    /* renamed from: a */
                    final AnonymousClass2 f4300a;

                    /* renamed from: b */
                    final InterfaceC0674f f4301b;

                    {
                        this.f4300a = this;
                        this.f4301b = interfaceC0674f;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4301b.mo5975a().run();
                    }
                });
            }
            threadPoolExecutor.shutdown();
            do {
                try {
                } catch (InterruptedException e2) {
                    return;
                }
            } while (!threadPoolExecutor.awaitTermination(1L, TimeUnit.SECONDS));
        }
    };

    /* renamed from: a */
    void mo6340a(InterfaceC0674f interfaceC0674f);
}
