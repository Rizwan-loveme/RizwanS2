package androidx.core.p027c;

import android.p008os.Handler;
import android.p008os.Process;
import androidx.core.p030e.InterfaceC0266a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestExecutor.java */
/* renamed from: androidx.core.c.g */
/* loaded from: classes.dex */
class C0252g {
    /* renamed from: a */
    static <T> void m1836a(Executor executor, Callable<T> callable, InterfaceC0266a<T> interfaceC0266a) {
        executor.execute(new b(C0247b.m1798a(), callable, interfaceC0266a));
    }

    /* renamed from: a */
    static <T> T m1834a(ExecutorService executorService, Callable<T> callable, int i) {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        } catch (TimeoutException e4) {
            throw new InterruptedException("timeout");
        }
    }

    /* renamed from: a */
    static ThreadPoolExecutor m1835a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* compiled from: RequestExecutor.java */
    /* renamed from: androidx.core.c.g$b */
    private static class b<T> implements Runnable {

        /* renamed from: a */
        private Callable<T> f2002a;

        /* renamed from: b */
        private InterfaceC0266a<T> f2003b;

        /* renamed from: c */
        private Handler f2004c;

        b(Handler handler, Callable<T> callable, InterfaceC0266a<T> interfaceC0266a) {
            this.f2002a = callable;
            this.f2003b = interfaceC0266a;
            this.f2004c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T t;
            try {
                t = this.f2002a.call();
            } catch (Exception e2) {
                t = null;
            }
            final InterfaceC0266a<T> interfaceC0266a = this.f2003b;
            this.f2004c.post(new Runnable() { // from class: androidx.core.c.g.b.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    interfaceC0266a.mo1819a(t);
                }
            });
        }
    }

    /* compiled from: RequestExecutor.java */
    /* renamed from: androidx.core.c.g$a */
    private static class a implements ThreadFactory {

        /* renamed from: a */
        private String f1999a;

        /* renamed from: b */
        private int f2000b;

        a(String str, int i) {
            this.f1999a = str;
            this.f2000b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C3324a(runnable, this.f1999a, this.f2000b);
        }

        /* compiled from: RequestExecutor.java */
        /* renamed from: androidx.core.c.g$a$a, reason: collision with other inner class name */
        private static class C3324a extends Thread {

            /* renamed from: a */
            private final int f2001a;

            C3324a(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.f2001a = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f2001a);
                super.run();
            }
        }
    }
}
