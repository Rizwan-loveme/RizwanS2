package androidx.core.p027c;

import android.os.Handler;
import android.os.Looper;

/* compiled from: CalleeHandler.java */
/* renamed from: androidx.core.c.b */
/* loaded from: classes.dex */
class C0247b {
    /* renamed from: a */
    static Handler m1798a() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
