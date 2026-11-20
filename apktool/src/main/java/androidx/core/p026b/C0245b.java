package androidx.core.p026b;

import android.p008os.Build;
import android.p008os.CancellationSignal;

/* compiled from: CancellationSignal.java */
/* renamed from: androidx.core.b.b */
/* loaded from: classes.dex */
public final class C0245b {

    /* renamed from: a */
    private boolean f1957a;

    /* renamed from: b */
    private a f1958b;

    /* renamed from: c */
    private Object f1959c;

    /* renamed from: d */
    private boolean f1960d;

    /* compiled from: CancellationSignal.java */
    /* renamed from: androidx.core.b.b$a */
    public interface a {
        /* renamed from: a */
        void mo1794a();
    }

    /* renamed from: a */
    public boolean m1792a() {
        boolean z;
        synchronized (this) {
            z = this.f1957a;
        }
        return z;
    }

    /* renamed from: b */
    public void m1793b() {
        synchronized (this) {
            if (!this.f1957a) {
                this.f1957a = true;
                this.f1960d = true;
                a aVar = this.f1958b;
                Object obj = this.f1959c;
                if (aVar != null) {
                    try {
                        aVar.mo1794a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f1960d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null && Build.VERSION.SDK_INT >= 16) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f1960d = false;
                    notifyAll();
                }
            }
        }
    }

    /* renamed from: a */
    public void m1791a(a aVar) {
        synchronized (this) {
            m1790c();
            if (this.f1958b != aVar) {
                this.f1958b = aVar;
                if (this.f1957a && aVar != null) {
                    aVar.mo1794a();
                }
            }
        }
    }

    /* renamed from: c */
    private void m1790c() {
        while (this.f1960d) {
            try {
                wait();
            } catch (InterruptedException e2) {
            }
        }
    }
}
