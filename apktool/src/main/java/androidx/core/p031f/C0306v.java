package androidx.core.p031f;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* renamed from: androidx.core.f.v */
/* loaded from: classes.dex */
public final class C0306v {

    /* renamed from: a */
    private Object f2209a;

    private C0306v(Object obj) {
        this.f2209a = obj;
    }

    /* renamed from: a */
    public Object m2212a() {
        return this.f2209a;
    }

    /* renamed from: a */
    public static C0306v m2211a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new C0306v(PointerIcon.getSystemIcon(context, i)) : new C0306v(null);
    }
}
