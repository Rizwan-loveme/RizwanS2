package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator.java */
/* renamed from: androidx.core.app.c */
/* loaded from: classes.dex */
final class C0232c {

    /* renamed from: g */
    private static final Handler f1845g = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    protected static final Class<?> f1839a = m1696d();

    /* renamed from: b */
    protected static final Field f1840b = m1692b();

    /* renamed from: c */
    protected static final Field f1841c = m1694c();

    /* renamed from: d */
    protected static final Method f1842d = m1688a(f1839a);

    /* renamed from: e */
    protected static final Method f1843e = m1693b(f1839a);

    /* renamed from: f */
    protected static final Method f1844f = m1695c(f1839a);

    /* renamed from: a */
    static boolean m1690a(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (m1689a() && f1844f == null) {
            return false;
        }
        if (f1843e == null && f1842d == null) {
            return false;
        }
        try {
            final Object obj2 = f1841c.get(activity);
            if (obj2 != null && (obj = f1840b.get(activity)) != null) {
                final Application application = activity.getApplication();
                final a aVar = new a(activity);
                application.registerActivityLifecycleCallbacks(aVar);
                f1845g.post(new Runnable() { // from class: androidx.core.app.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f1852a = obj2;
                    }
                });
                try {
                    if (m1689a()) {
                        f1844f.invoke(obj, obj2, null, null, 0, false, null, null, false, false);
                    } else {
                        activity.recreate();
                    }
                    return true;
                } finally {
                    f1845g.post(new Runnable() { // from class: androidx.core.app.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Application.this.unregisterActivityLifecycleCallbacks(aVar);
                        }
                    });
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* renamed from: androidx.core.app.c$a */
    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        Object f1852a;

        /* renamed from: b */
        private Activity f1853b;

        /* renamed from: c */
        private final int f1854c;

        /* renamed from: d */
        private boolean f1855d = false;

        /* renamed from: e */
        private boolean f1856e = false;

        /* renamed from: f */
        private boolean f1857f = false;

        a(Activity activity) {
            this.f1853b = activity;
            this.f1854c = this.f1853b.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f1853b == activity) {
                this.f1855d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (this.f1856e && !this.f1857f && !this.f1855d && C0232c.m1691a(this.f1852a, this.f1854c, activity)) {
                this.f1857f = true;
                this.f1852a = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f1853b == activity) {
                this.f1853b = null;
                this.f1856e = true;
            }
        }
    }

    /* renamed from: a */
    protected static boolean m1691a(Object obj, int i, Activity activity) {
        try {
            final Object obj2 = f1841c.get(activity);
            if (obj2 != obj || activity.hashCode() != i) {
                return false;
            }
            final Object obj3 = f1840b.get(activity);
            f1845g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.c.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (C0232c.f1842d != null) {
                            C0232c.f1842d.invoke(Object.this, obj2, false, "AppCompat recreation");
                        } else {
                            C0232c.f1843e.invoke(Object.this, obj2, false);
                        }
                    } catch (RuntimeException e2) {
                        if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                    } catch (Throwable th) {
                        Log.m185e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.m185e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* renamed from: a */
    private static Method m1688a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: b */
    private static Method m1693b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m1689a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    /* renamed from: c */
    private static Method m1695c(Class<?> cls) {
        if (!m1689a() || cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: b */
    private static Field m1692b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: c */
    private static Field m1694c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: d */
    private static Class<?> m1696d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable th) {
            return null;
        }
    }
}
