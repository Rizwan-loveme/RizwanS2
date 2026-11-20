package ru.maximoff.apktool.service;

import jadx.core.p203d.C1741j;
import jadx.core.p203d.InterfaceC1736e;
import java.p209io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.C2986e;
import ru.maximoff.apktool.p296a.C2890j;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: Project.java */
/* renamed from: ru.maximoff.apktool.service.d */
/* loaded from: classes.dex */
public class C3058d {

    /* renamed from: a */
    private String f17161a;

    /* renamed from: b */
    private final ExecutorService f17162b;

    /* renamed from: c */
    private final C3056b f17163c;

    /* renamed from: e */
    private final Map<String, C3055a> f17165e;

    /* renamed from: f */
    private final File f17166f;

    /* renamed from: d */
    private boolean f17164d = false;

    /* renamed from: g */
    private final Runnable f17167g = new Runnable(this) { // from class: ru.maximoff.apktool.service.d.2

        /* renamed from: a */
        private final C3058d f17169a;

        {
            this.f17169a = this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
        
            m18217a(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
        
            if (r9.f17169a.f17164d != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x009b, code lost:
        
            r9.f17169a.f17163c.m18192a("Analysis", "Parsing Done");
            ru.maximoff.apktool.fragment.p301a.C2978b.f16135a.m17713g();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void run() {
            int i = 0;
            synchronized (this) {
                this.f17169a.f17164d = false;
                this.f17169a.f17165e.clear();
                C2978b.f16135a.m17713g();
                String str = this.f17169a.f17161a;
                if (!C3112bn.m19040o(str)) {
                    this.f17169a.f17163c.m18192a("Find fields and methods", str);
                    File file = new File(str);
                    LinkedList linkedList = new LinkedList();
                    if (!C2890j.m16916a(this.f17169a.f17166f, str)) {
                        if (file.exists() && file.isDirectory()) {
                            this.f17169a.f17165e.clear();
                            C2890j.m16909a();
                            File[] listFiles = file.listFiles();
                            int i2 = 0;
                            while (true) {
                                if (i2 < listFiles.length) {
                                    File file2 = listFiles[i2];
                                    if (this.f17169a.f17164d) {
                                        break;
                                    }
                                    if (file2.isDirectory() && file2.getName().startsWith("smali")) {
                                        this.f17169a.m18214a(file2, 0, linkedList);
                                    }
                                    i2++;
                                } else {
                                    m18217a(linkedList);
                                    if (!this.f17169a.f17164d) {
                                        C2890j.m16919b(this.f17169a.f17166f, str);
                                        C2890j.m16920c();
                                    }
                                }
                            }
                        }
                    }
                    this.f17169a.f17163c.m18192a("Analysis code", "Analysis all fields and methods");
                    File[] listFiles2 = file.listFiles();
                    while (true) {
                        if (i < listFiles2.length) {
                            File file3 = listFiles2[i];
                            if (this.f17169a.f17164d) {
                                break;
                            }
                            if (file3.isDirectory() && file3.getName().startsWith("smali")) {
                                this.f17169a.m18214a(file3, 1, linkedList);
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        private void m18217a(List<Future<Object>> list) {
            Iterator<Future<Object>> it = list.iterator();
            while (it.hasNext()) {
                m18218a(it.next());
                it.remove();
            }
        }

        /* renamed from: a */
        private void m18218a(Future<Object> future) {
            if (this.f17169a.f17164d) {
                future.cancel(false);
            } else {
                while (true) {
                    try {
                        future.get();
                        return;
                    } catch (InterruptedException e2) {
                    } catch (ExecutionException e3) {
                        return;
                    }
                }
            }
        }
    };

    public C3058d(C3056b c3056b, File file) {
        this.f17166f = new File(file, "cache");
        this.f17166f.mkdirs();
        this.f17163c = c3056b;
        this.f17165e = new HashMap();
        this.f17162b = Executors.newFixedThreadPool(C3102bd.f18297ae);
        m18215a("");
    }

    /* renamed from: a */
    public void m18215a(String str) {
        this.f17161a = str;
        m18207a();
    }

    /* renamed from: a */
    private void m18207a() {
        this.f17164d = true;
        this.f17162b.execute(this.f17167g);
    }

    /* renamed from: a */
    public synchronized C3055a m18213a(File file) {
        return file.getAbsolutePath().startsWith(this.f17161a) ? (C3055a) C1741j.m13285a(this.f17165e, file.getAbsolutePath(), new InterfaceC1736e<String, C3055a>(this) { // from class: ru.maximoff.apktool.service.d.1

            /* renamed from: a */
            private final C3058d f17168a;

            {
                this.f17168a = this;
            }

            @Override // jadx.core.p203d.InterfaceC1736e
            /* renamed from: a */
            public /* bridge */ C3055a mo12561a(String str) {
                return a2(str);
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public C3055a a2(String str) {
                return new C3055a(str);
            }
        }) : (C3055a) null;
    }

    /* renamed from: a */
    protected void m18214a(File file, int i, List<Future<Object>> list) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m18214a(file2, i, list);
            }
            return;
        }
        if (file.getName().endsWith(".smali")) {
            list.add(this.f17162b.submit(new Callable<Object>(this, file, i) { // from class: ru.maximoff.apktool.service.d.3

                /* renamed from: a */
                private final C3058d f17170a;

                /* renamed from: b */
                private final File f17171b;

                /* renamed from: c */
                private final int f17172c;

                {
                    this.f17170a = this;
                    this.f17171b = file;
                    this.f17172c = i;
                }

                @Override // java.util.concurrent.Callable
                public Object call() {
                    C3057c.m18204a(this.f17170a.m18213a(this.f17171b), this.f17172c, C3102bd.f18340w);
                    return (Object) null;
                }
            }));
        }
    }

    /* renamed from: a */
    public void m18216a(C2986e c2986e) {
        try {
            for (C3055a c3055a : this.f17165e.values()) {
                if (c3055a.m17889g() > 0) {
                    c2986e.mo17883a(c3055a);
                }
            }
        } catch (Exception e2) {
        }
    }
}
