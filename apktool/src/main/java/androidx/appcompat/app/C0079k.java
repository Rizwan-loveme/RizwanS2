package androidx.appcompat.app;

import android.content.res.Resources;
import android.p008os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: ResourcesFlusher.java */
/* renamed from: androidx.appcompat.app.k */
/* loaded from: classes.dex */
class C0079k {

    /* renamed from: a */
    private static Field f665a;

    /* renamed from: b */
    private static boolean f666b;

    /* renamed from: c */
    private static Class<?> f667c;

    /* renamed from: d */
    private static boolean f668d;

    /* renamed from: e */
    private static Field f669e;

    /* renamed from: f */
    private static boolean f670f;

    /* renamed from: g */
    private static Field f671g;

    /* renamed from: h */
    private static boolean f672h;

    /* renamed from: a */
    static void m614a(Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                m618d(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                m617c(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                m616b(resources);
            }
        }
    }

    /* renamed from: b */
    private static void m616b(Resources resources) {
        Map map;
        if (!f666b) {
            try {
                f665a = Resources.class.getDeclaredField("mDrawableCache");
                f665a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.m185e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f666b = true;
        }
        if (f665a != null) {
            try {
                map = (Map) f665a.get(resources);
            } catch (IllegalAccessException e3) {
                Log.m185e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m617c(Resources resources) {
        Object obj;
        if (!f666b) {
            try {
                f665a = Resources.class.getDeclaredField("mDrawableCache");
                f665a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.m185e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f666b = true;
        }
        if (f665a != null) {
            try {
                obj = f665a.get(resources);
            } catch (IllegalAccessException e3) {
                Log.m185e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
            if (obj == null) {
                m615a(obj);
                return;
            }
            return;
        }
        obj = null;
        if (obj == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m618d(Resources resources) {
        Object obj;
        Object obj2;
        if (!f672h) {
            try {
                f671g = Resources.class.getDeclaredField("mResourcesImpl");
                f671g.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.m185e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f672h = true;
        }
        if (f671g != null) {
            try {
                obj = f671g.get(resources);
            } catch (IllegalAccessException e3) {
                Log.m185e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f666b) {
                    try {
                        f665a = obj.getClass().getDeclaredField("mDrawableCache");
                        f665a.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.m185e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f666b = true;
                }
                if (f665a != null) {
                    try {
                        obj2 = f665a.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.m185e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                    if (obj2 == null) {
                        m615a(obj2);
                        return;
                    }
                    return;
                }
                obj2 = null;
                if (obj2 == null) {
                }
            }
        }
    }

    /* renamed from: a */
    private static void m615a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f668d) {
            try {
                f667c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.m185e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f668d = true;
        }
        if (f667c != null) {
            if (!f670f) {
                try {
                    f669e = f667c.getDeclaredField("mUnthemedEntries");
                    f669e.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.m185e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f670f = true;
            }
            if (f669e != null) {
                try {
                    longSparseArray = (LongSparseArray) f669e.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.m185e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
