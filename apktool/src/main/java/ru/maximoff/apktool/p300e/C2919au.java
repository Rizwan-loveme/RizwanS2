package ru.maximoff.apktool.p300e;

import android.p008os.AsyncTask;
import android.p008os.Handler;
import android.p008os.HandlerThread;
import java.p209io.File;
import java.util.LinkedList;

/* compiled from: SimpleIconTaskQueue.java */
/* renamed from: ru.maximoff.apktool.e.au */
/* loaded from: classes.dex */
public class C2919au {

    /* renamed from: a */
    private static int f15401a = 0;

    /* renamed from: b */
    private static final LinkedList<b> f15402b = new LinkedList<>();

    /* renamed from: c */
    private static final HandlerThread f15403c = new HandlerThread("IconTaskQueue");

    /* renamed from: d */
    private static final Handler f15404d;

    /* compiled from: SimpleIconTaskQueue.java */
    /* renamed from: ru.maximoff.apktool.e.au$a */
    public interface a {
        /* renamed from: a */
        AsyncTaskC2954y mo17349a();
    }

    static {
        f15403c.start();
        f15404d = new Handler(f15403c.getLooper());
    }

    /* renamed from: a */
    public static void m17340a(File file, a aVar) {
        if (file == null || aVar == null) {
            return;
        }
        f15404d.post(new Runnable(file, aVar) { // from class: ru.maximoff.apktool.e.au.1

            /* renamed from: a */
            private final File f15405a;

            /* renamed from: b */
            private final a f15406b;

            {
                this.f15405a = file;
                this.f15406b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = new b(this.f15405a, this.f15406b);
                if (C2919au.f15401a < 3) {
                    C2919au.m17343b(bVar);
                } else {
                    C2919au.f15402b.addLast(bVar);
                }
            }
        });
    }

    /* renamed from: d */
    public static void m17345d() {
        f15404d.post(new Runnable() { // from class: ru.maximoff.apktool.e.au.2
            @Override // java.lang.Runnable
            public void run() {
                if (C2919au.f15401a > 0) {
                    C2919au.f15401a--;
                }
                C2919au.m17348g();
            }
        });
    }

    /* renamed from: e */
    public static void m17346e() {
        f15404d.post(new Runnable() { // from class: ru.maximoff.apktool.e.au.3
            @Override // java.lang.Runnable
            public void run() {
                C2919au.f15402b.clear();
                C2919au.f15401a = 0;
                C2919au.f15404d.removeCallbacksAndMessages((Object) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m17343b(b bVar) {
        if (bVar != null) {
            f15401a++;
            try {
                AsyncTaskC2954y mo17349a = bVar.f15408b.mo17349a();
                if (mo17349a == null) {
                    if (f15401a > 0) {
                        f15401a--;
                    }
                    m17348g();
                    return;
                }
                mo17349a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bVar.f15407a);
            } catch (Throwable th) {
                if (f15401a > 0) {
                    f15401a--;
                }
                m17348g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m17348g() {
        b poll;
        while (f15401a < 3 && !f15402b.isEmpty() && (poll = f15402b.poll()) != null) {
            m17343b(poll);
        }
    }

    /* compiled from: SimpleIconTaskQueue.java */
    /* renamed from: ru.maximoff.apktool.e.au$b */
    private static class b {

        /* renamed from: a */
        final File f15407a;

        /* renamed from: b */
        final a f15408b;

        b(File file, a aVar) {
            this.f15407a = file;
            this.f15408b = aVar;
        }
    }
}
