package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.p008os.Build;

/* compiled from: AppOpsManagerCompat.java */
/* renamed from: androidx.core.app.d */
/* loaded from: classes.dex */
public final class C0233d {
    /* renamed from: a */
    public static String m1698a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    /* renamed from: a */
    public static int m1697a(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }
}
