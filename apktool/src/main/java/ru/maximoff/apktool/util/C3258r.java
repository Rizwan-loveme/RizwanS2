package ru.maximoff.apktool.util;

import java.p209io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FileChecker.java */
/* renamed from: ru.maximoff.apktool.util.r */
/* loaded from: classes.dex */
public class C3258r {
    /* renamed from: a */
    public static boolean m19522a(String str, File[] fileArr, int i) {
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (File file : fileArr) {
            try {
                try {
                    if (file != null && file.exists()) {
                        newFixedThreadPool.submit(new Runnable(atomicBoolean, str, file, i) { // from class: ru.maximoff.apktool.util.r.1

                            /* renamed from: a */
                            private final AtomicBoolean f19673a;

                            /* renamed from: b */
                            private final String f19674b;

                            /* renamed from: c */
                            private final File f19675c;

                            /* renamed from: d */
                            private final int f19676d;

                            {
                                this.f19673a = atomicBoolean;
                                this.f19674b = str;
                                this.f19675c = file;
                                this.f19676d = i;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (!this.f19673a.get() && new File(new StringBuffer().append(new StringBuffer().append(this.f19674b).append(File.separator).toString()).append(this.f19675c.getAbsolutePath().substring(this.f19676d + 1)).toString()).exists()) {
                                    this.f19673a.set(true);
                                }
                            }
                        });
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } finally {
                if (!newFixedThreadPool.isShutdown()) {
                    newFixedThreadPool.shutdownNow();
                }
            }
        }
        newFixedThreadPool.shutdown();
        while (!newFixedThreadPool.isTerminated() && !atomicBoolean.get()) {
            Thread.sleep(10);
        }
        return atomicBoolean.get();
    }
}
