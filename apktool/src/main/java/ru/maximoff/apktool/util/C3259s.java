package ru.maximoff.apktool.util;

import java.p209io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FileLister.java */
/* renamed from: ru.maximoff.apktool.util.s */
/* loaded from: classes.dex */
public class C3259s {
    /* renamed from: a */
    public static List<File> m19523a(File[] fileArr) {
        if (fileArr == null || fileArr.length == 0) {
            return new ArrayList();
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(C3102bd.f18297ae);
        List<File> synchronizedList = Collections.synchronizedList(new ArrayList());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (File file : fileArr) {
            try {
                try {
                    atomicInteger.incrementAndGet();
                    newFixedThreadPool.submit(new a(file, synchronizedList, newFixedThreadPool, atomicInteger));
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } finally {
                newFixedThreadPool.shutdown();
            }
        }
        while (atomicInteger.get() > 0) {
            Thread.sleep(10);
        }
        return synchronizedList;
    }

    /* compiled from: FileLister.java */
    /* renamed from: ru.maximoff.apktool.util.s$a */
    static class a implements Runnable {

        /* renamed from: a */
        private final File f19677a;

        /* renamed from: b */
        private final List<File> f19678b;

        /* renamed from: c */
        private final ExecutorService f19679c;

        /* renamed from: d */
        private final AtomicInteger f19680d;

        public a(File file, List<File> list, ExecutorService executorService, AtomicInteger atomicInteger) {
            this.f19677a = file;
            this.f19678b = list;
            this.f19679c = executorService;
            this.f19680d = atomicInteger;
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            try {
                this.f19678b.add(this.f19677a);
                if (this.f19677a.isDirectory() && (listFiles = this.f19677a.listFiles()) != null) {
                    for (File file : listFiles) {
                        this.f19680d.incrementAndGet();
                        this.f19679c.submit(new a(file, this.f19678b, this.f19679c, this.f19680d));
                    }
                }
            } finally {
                this.f19680d.decrementAndGet();
            }
        }
    }
}
