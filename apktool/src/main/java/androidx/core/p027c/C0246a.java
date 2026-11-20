package androidx.core.p027c;

import android.graphics.Typeface;
import android.p008os.Handler;
import androidx.core.p027c.C0250e;
import androidx.core.p027c.C0251f;

/* compiled from: CallbackWithHandler.java */
/* renamed from: androidx.core.c.a */
/* loaded from: classes.dex */
class C0246a {

    /* renamed from: a */
    private final C0251f.c f1961a;

    /* renamed from: b */
    private final Handler f1962b;

    C0246a(C0251f.c cVar, Handler handler) {
        this.f1961a = cVar;
        this.f1962b = handler;
    }

    /* renamed from: a */
    private void m1796a(final Typeface typeface) {
        final C0251f.c cVar = this.f1961a;
        this.f1962b.post(new Runnable() { // from class: androidx.core.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.mo1833a(typeface);
            }
        });
    }

    /* renamed from: a */
    private void m1795a(final int i) {
        final C0251f.c cVar = this.f1961a;
        this.f1962b.post(new Runnable() { // from class: androidx.core.c.a.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.mo1832a(i);
            }
        });
    }

    /* renamed from: a */
    void m1797a(C0250e.a aVar) {
        if (aVar.m1821a()) {
            m1796a(aVar.f1990a);
        } else {
            m1795a(aVar.f1991b);
        }
    }
}
