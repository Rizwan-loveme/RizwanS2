package androidx.appcompat.widget;

import android.C0012R;
import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.p008os.Build;
import androidx.appcompat.p016b.p017a.C0086c;
import androidx.core.graphics.drawable.InterfaceC0317c;

/* compiled from: DrawableUtils.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.ag */
/* loaded from: classes.dex */
public class C0165ag {

    /* renamed from: d */
    private static Class<?> f1413d;

    /* renamed from: b */
    private static final int[] f1411b = {C0012R.attr.state_checked};

    /* renamed from: c */
    private static final int[] f1412c = new int[0];

    /* renamed from: a */
    public static final Rect f1410a = new Rect();

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1413d = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e2) {
            }
        }
    }

    /* renamed from: a */
    static void m1262a(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m1264c(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static boolean m1263b(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
                for (Drawable drawable2 : children) {
                    if (!m1263b(drawable2)) {
                        return false;
                    }
                }
            }
        } else {
            if (drawable instanceof InterfaceC0317c) {
                return m1263b(((InterfaceC0317c) drawable).mo2371a());
            }
            if (drawable instanceof C0086c) {
                return m1263b(((C0086c) drawable).m731a());
            }
            if (drawable instanceof ScaleDrawable) {
                return m1263b(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    /* renamed from: c */
    private static void m1264c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1411b);
        } else {
            drawable.setState(f1412c);
        }
        drawable.setState(state);
    }

    /* renamed from: a */
    public static PorterDuff.Mode m1261a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }
}
