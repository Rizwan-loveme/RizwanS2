package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* compiled from: CompoundButtonCompat.java */
/* renamed from: androidx.core.widget.c */
/* loaded from: classes.dex */
public final class C0333c {

    /* renamed from: a */
    private static Field f2353a;

    /* renamed from: b */
    private static boolean f2354b;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2497a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof InterfaceC0341k) {
            ((InterfaceC0341k) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2498a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof InterfaceC0341k) {
            ((InterfaceC0341k) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    /* renamed from: a */
    public static Drawable m2496a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f2354b) {
            try {
                f2353a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f2353a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.m187i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e2);
            }
            f2354b = true;
        }
        if (f2353a != null) {
            try {
                return (Drawable) f2353a.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Log.m187i("CompoundButtonCompat", "Failed to get button drawable via reflection", e3);
                f2353a = null;
            }
        }
        return null;
    }
}
