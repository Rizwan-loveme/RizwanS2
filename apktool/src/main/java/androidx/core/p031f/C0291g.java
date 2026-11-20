package androidx.core.p031f;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompat.java */
/* renamed from: androidx.core.f.g */
/* loaded from: classes.dex */
public final class C0291g {

    /* renamed from: a */
    private static Field f2197a;

    /* renamed from: b */
    private static boolean f2198b;

    /* renamed from: b */
    private static void m2175b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f2198b) {
            try {
                f2197a = LayoutInflater.class.getDeclaredField("mFactory2");
                f2197a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.m185e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e2);
            }
            f2198b = true;
        }
        if (f2197a != null) {
            try {
                f2197a.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.m185e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }

    /* renamed from: a */
    public static void m2174a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                m2175b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                m2175b(layoutInflater, factory2);
            }
        }
    }
}
