package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.p291v1.XmlPullParser;

/* compiled from: DrawableCompat.java */
/* renamed from: androidx.core.graphics.drawable.a */
/* loaded from: classes.dex */
public final class C0315a {

    /* renamed from: a */
    private static Method f2258a;

    /* renamed from: b */
    private static boolean f2259b;

    /* renamed from: c */
    private static Method f2260c;

    /* renamed from: d */
    private static boolean f2261d;

    @Deprecated
    /* renamed from: a */
    public static void m2355a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* renamed from: a */
    public static void m2363a(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    /* renamed from: b */
    public static boolean m2364b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    /* renamed from: a */
    public static void m2356a(Drawable drawable, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    /* renamed from: a */
    public static void m2358a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2357a(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof InterfaceC0316b) {
            ((InterfaceC0316b) drawable).setTint(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2359a(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof InterfaceC0316b) {
            ((InterfaceC0316b) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2362a(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof InterfaceC0316b) {
            ((InterfaceC0316b) drawable).setTintMode(mode);
        }
    }

    /* renamed from: c */
    public static int m2366c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m2360a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    /* renamed from: d */
    public static boolean m2367d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* renamed from: e */
    public static ColorFilter m2368e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* renamed from: a */
    public static void m2361a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* renamed from: f */
    public static Drawable m2369f(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (!(drawable instanceof InterfaceC0316b)) {
                    return new C0319e(drawable);
                }
                return drawable;
            }
            if (!(drawable instanceof InterfaceC0316b)) {
                return new C0318d(drawable);
            }
            return drawable;
        }
        return drawable;
    }

    /* renamed from: b */
    public static boolean m2365b(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!f2259b) {
            try {
                f2258a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f2258a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.m187i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e2);
            }
            f2259b = true;
        }
        if (f2258a != null) {
            try {
                f2258a.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception e3) {
                Log.m187i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                f2258a = null;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static int m2370g(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        if (!f2261d) {
            try {
                f2260c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f2260c.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.m187i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e2);
            }
            f2261d = true;
        }
        if (f2260c != null) {
            try {
                return ((Integer) f2260c.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e3) {
                Log.m187i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e3);
                f2260c = null;
            }
        }
        return 0;
    }
}
