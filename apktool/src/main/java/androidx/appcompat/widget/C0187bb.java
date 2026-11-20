package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* compiled from: TooltipCompat.java */
/* renamed from: androidx.appcompat.widget.bb */
/* loaded from: classes.dex */
public class C0187bb {
    /* renamed from: a */
    public static void m1463a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            ViewOnAttachStateChangeListenerC0188bc.m1464a(view, charSequence);
        }
    }
}
