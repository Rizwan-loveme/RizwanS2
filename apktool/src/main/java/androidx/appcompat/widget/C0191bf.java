package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.p031f.C0308x;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtils.java */
/* renamed from: androidx.appcompat.widget.bf */
/* loaded from: classes.dex */
public class C0191bf {

    /* renamed from: a */
    private static Method f1637a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1637a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                if (!f1637a.isAccessible()) {
                    f1637a.setAccessible(true);
                }
            } catch (NoSuchMethodException e2) {
                Log.m182d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    /* renamed from: a */
    public static boolean m1481a(View view) {
        return C0308x.m2257f(view) == 1;
    }

    /* renamed from: a */
    public static void m1480a(View view, Rect rect, Rect rect2) {
        if (f1637a != null) {
            try {
                f1637a.invoke(view, rect, rect2);
            } catch (Exception e2) {
                Log.m183d("ViewUtils", "Could not invoke computeFitSystemWindows", e2);
            }
        }
    }

    /* renamed from: b */
    public static void m1482b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.m183d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            } catch (NoSuchMethodException e3) {
                Log.m182d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e4) {
                Log.m183d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e4);
            }
        }
    }
}
