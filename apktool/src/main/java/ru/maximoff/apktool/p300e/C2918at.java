package ru.maximoff.apktool.p300e;

import android.p008os.AsyncTask;
import android.p008os.Handler;
import android.p008os.HandlerThread;
import java.p209io.File;
import java.util.LinkedList;

/* compiled from: SimpleFsTaskQueue.java */
/* renamed from: ru.maximoff.apktool.e.at */
/* loaded from: classes.dex */
public class C2918at {

    /* renamed from: a */
    private static int f15393a = 0;

    /* renamed from: b */
    private static final LinkedList<b> f15394b = new LinkedList<>();

    /* renamed from: c */
    private static final HandlerThread f15395c = new HandlerThread("FSizeTaskQueue");

    /* renamed from: d */
    private static final Handler f15396d;

    /* compiled from: SimpleFsTaskQueue.java */
    /* renamed from: ru.maximoff.apktool.e.at$a */
    public interface a {
        /* renamed from: a */
        AsyncTaskC2952w mo17337a();
    }

    static {
        f15395c.start();
        f15396d = new Handler(f15395c.getLooper());
    }

    /* renamed from: a */
    public static void m17328a(File file, a aVar) {
        if (file == null || aVar == null) {
            return;
        }
        f15396d.post(new Runnable(file, aVar) { // from class: ru.maximoff.apktool.e.at.1

            /* renamed from: a */
            private final File f15397a;

            /* renamed from: b */
            private final a f15398b;

            {
                this.f15397a = file;
                this.f15398b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = new b(this.f15397a, this.f15398b);
                if (C2918at.f15393a < 3) {
                    C2918at.m17331b(bVar);
                } else {
                    C2918at.f15394b.addLast(bVar);
                }
            }
        });
    }

    /* renamed from: d */
    public static void m17333d() {
        f15396d.post(new Runnable() { // from class: ru.maximoff.apktool.e.at.2
            @Override // java.lang.Runnable
            public void run() {
                if (C2918at.f15393a > 0) {
                    C2918at.f15393a--;
                }
                C2918at.m17336g();
            }
        });
    }

    /* renamed from: e */
    public static void m17334e() {
        f15396d.post(new Runnable() { // from class: ru.maximoff.apktool.e.at.3
            @Override // java.lang.Runnable
            public void run() {
                C2918at.f15394b.clear();
                C2918at.f15393a = 0;
                C2918at.f15396d.removeCallbacksAndMessages((Object) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m17331b(b bVar) {
        if (bVar != null) {
            f15393a++;
            try {
                AsyncTaskC2952w mo17337a = bVar.f15400b.mo17337a();
                if (mo17337a == null) {
                    if (f15393a > 0) {
                        f15393a--;
                    }
                    m17336g();
                    return;
                }
                mo17337a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bVar.f15399a);
            } catch (Throwable th) {
                if (f15393a > 0) {
                    f15393a--;
                }
                m17336g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m17336g() {
        b poll;
        while (f15393a < 3 && !f15394b.isEmpty() && (poll = f15394b.poll()) != null) {
            m17331b(poll);
        }
    }

    /* compiled from: SimpleFsTaskQueue.java */
    /* renamed from: ru.maximoff.apktool.e.at$b */
    private static class b {

        /* renamed from: a */
        final File f15399a;

        /* renamed from: b */
        final a f15400b;

        b(File file, a aVar) {
            this.f15399a = file;
            this.f15400b = aVar;
        }
    }
}
