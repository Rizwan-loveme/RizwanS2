package androidx.core.p027c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.p006pm.PackageManager;
import android.graphics.Typeface;
import android.p008os.CancellationSignal;
import androidx.core.graphics.C0314d;
import androidx.core.p027c.C0251f;
import androidx.core.p030e.InterfaceC0266a;
import androidx.p011a.C0040e;
import androidx.p011a.C0042g;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: FontRequestWorker.java */
/* renamed from: androidx.core.c.e */
/* loaded from: classes.dex */
class C0250e {

    /* renamed from: a */
    static final C0040e<String, Typeface> f1976a = new C0040e<>(16);

    /* renamed from: d */
    private static final ExecutorService f1979d = C0252g.m1835a("fonts-androidx", 10, 10000);

    /* renamed from: b */
    static final Object f1977b = new Object();

    /* renamed from: c */
    static final C0042g<String, ArrayList<InterfaceC0266a<a>>> f1978c = new C0042g<>();

    /* renamed from: a */
    static Typeface m1815a(final Context context, final C0249d c0249d, C0246a c0246a, final int i, int i2) {
        final String m1817a = m1817a(c0249d, i);
        Typeface m245a = f1976a.m245a((C0040e<String, Typeface>) m1817a);
        if (m245a != null) {
            c0246a.m1797a(new a(m245a));
            return m245a;
        }
        if (i2 == -1) {
            a m1816a = m1816a(m1817a, context, c0249d, i);
            c0246a.m1797a(m1816a);
            return m1816a.f1990a;
        }
        try {
            a aVar = (a) C0252g.m1834a(f1979d, new Callable<a>() { // from class: androidx.core.c.e.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a call() {
                    return C0250e.m1816a(String.this, context, c0249d, i);
                }
            }, i2);
            c0246a.m1797a(aVar);
            return aVar.f1990a;
        } catch (InterruptedException e2) {
            c0246a.m1797a(new a(-3));
            return null;
        }
    }

    /* renamed from: a */
    static Typeface m1814a(final Context context, final C0249d c0249d, final int i, Executor executor, final C0246a c0246a) {
        final String m1817a = m1817a(c0249d, i);
        Typeface m245a = f1976a.m245a((C0040e<String, Typeface>) m1817a);
        if (m245a != null) {
            c0246a.m1797a(new a(m245a));
        } else {
            InterfaceC0266a<a> interfaceC0266a = new InterfaceC0266a<a>() { // from class: androidx.core.c.e.2
                @Override // androidx.core.p030e.InterfaceC0266a
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo1819a(a aVar) {
                    C0246a.this.m1797a(aVar);
                }
            };
            synchronized (f1977b) {
                ArrayList<InterfaceC0266a<a>> arrayList = f1978c.get(m1817a);
                if (arrayList != null) {
                    arrayList.add(interfaceC0266a);
                    m245a = null;
                } else {
                    ArrayList<InterfaceC0266a<a>> arrayList2 = new ArrayList<>();
                    arrayList2.add(interfaceC0266a);
                    f1978c.put(m1817a, arrayList2);
                    Callable<a> callable = new Callable<a>() { // from class: androidx.core.c.e.3
                        @Override // java.util.concurrent.Callable
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public a call() {
                            return C0250e.m1816a(String.this, context, c0249d, i);
                        }
                    };
                    if (executor == null) {
                        executor = f1979d;
                    }
                    C0252g.m1836a(executor, callable, new InterfaceC0266a<a>() { // from class: androidx.core.c.e.4
                        @Override // androidx.core.p030e.InterfaceC0266a
                        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                        public void mo1819a(a aVar) {
                            synchronized (C0250e.f1977b) {
                                ArrayList<InterfaceC0266a<a>> arrayList3 = C0250e.f1978c.get(String.this);
                                if (arrayList3 != null) {
                                    C0250e.f1978c.remove(String.this);
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2;
                                        if (i3 < arrayList3.size()) {
                                            arrayList3.get(i3).mo1819a(aVar);
                                            i2 = i3 + 1;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    });
                    m245a = null;
                }
            }
        }
        return m245a;
    }

    /* renamed from: a */
    private static String m1817a(C0249d c0249d, int i) {
        return c0249d.m1812f() + "-" + i;
    }

    /* renamed from: a */
    static a m1816a(String str, Context context, C0249d c0249d, int i) {
        Typeface m245a = f1976a.m245a((C0040e<String, Typeface>) str);
        if (m245a != null) {
            return new a(m245a);
        }
        try {
            C0251f.a m1800a = C0248c.m1800a(context, c0249d, (CancellationSignal) null);
            int m1813a = m1813a(m1800a);
            if (m1813a != 0) {
                return new a(m1813a);
            }
            Typeface m2333a = C0314d.m2333a(context, null, m1800a.m1825b(), i);
            if (m2333a != null) {
                f1976a.m246a(str, m2333a);
                return new a(m2333a);
            }
            return new a(-3);
        } catch (PackageManager.NameNotFoundException e2) {
            return new a(-1);
        }
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    private static int m1813a(C0251f.a aVar) {
        if (aVar.m1824a() != 0) {
            switch (aVar.m1824a()) {
            }
            return -3;
        }
        C0251f.b[] m1825b = aVar.m1825b();
        if (m1825b == null || m1825b.length == 0) {
            return 1;
        }
        for (C0251f.b bVar : m1825b) {
            int m1831e = bVar.m1831e();
            if (m1831e != 0) {
                if (m1831e >= 0) {
                    return m1831e;
                }
                return -3;
            }
        }
        return 0;
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: androidx.core.c.e$a */
    static final class a {

        /* renamed from: a */
        final Typeface f1990a;

        /* renamed from: b */
        final int f1991b;

        a(int i) {
            this.f1990a = null;
            this.f1991b = i;
        }

        @SuppressLint({"WrongConstant"})
        a(Typeface typeface) {
            this.f1990a = typeface;
            this.f1991b = 0;
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: a */
        boolean m1821a() {
            return this.f1991b == 0;
        }
    }
}
