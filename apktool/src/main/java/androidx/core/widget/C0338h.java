package androidx.core.widget;

import android.p008os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.p031f.C0289e;
import androidx.core.p031f.C0308x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompat.java */
/* renamed from: androidx.core.widget.h */
/* loaded from: classes.dex */
public final class C0338h {

    /* renamed from: a */
    private static Method f2356a;

    /* renamed from: b */
    private static boolean f2357b;

    /* renamed from: c */
    private static Field f2358c;

    /* renamed from: d */
    private static boolean f2359d;

    /* renamed from: a */
    public static void m2507a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((C0289e.m2167a(i3, C0308x.m2257f(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    /* renamed from: a */
    public static void m2508a(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (!f2359d) {
                try {
                    f2358c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f2358c.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.m187i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f2359d = true;
            }
            if (f2358c != null) {
                try {
                    f2358c.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.m187i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2506a(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!f2357b) {
            try {
                f2356a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f2356a.setAccessible(true);
            } catch (Exception e2) {
            }
            f2357b = true;
        }
        if (f2356a != null) {
            try {
                f2356a.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception e3) {
            }
        }
    }
}
