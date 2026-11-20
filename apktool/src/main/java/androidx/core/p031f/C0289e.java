package androidx.core.p031f;

import android.os.Build;
import android.view.Gravity;

/* compiled from: GravityCompat.java */
/* renamed from: androidx.core.f.e */
/* loaded from: classes.dex */
public final class C0289e {
    /* renamed from: a */
    public static int m2167a(int i, int i2) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i, i2) : (-8388609) & i;
    }
}
