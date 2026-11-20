package com.p126e.p127a.p128a;

import android.annotation.TargetApi;
import android.p008os.Build;
import android.view.View;

/* compiled from: Compat.java */
/* renamed from: com.e.a.a.a */
/* loaded from: classes.dex */
class C1093a {
    /* renamed from: a */
    public static void m9403a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            m9404b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    /* renamed from: b */
    private static void m9404b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
