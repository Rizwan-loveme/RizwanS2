package androidx.p040f;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Trace.java */
/* renamed from: androidx.f.a */
/* loaded from: classes.dex */
public final class C0360a {

    /* renamed from: a */
    private static long f2458a;

    /* renamed from: b */
    private static Method f2459b;

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static boolean m2626a() {
        try {
            if (f2459b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError e2) {
        } catch (NoSuchMethodError e3) {
        }
        return m2628c();
    }

    /* renamed from: a */
    public static void m2624a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            C0361b.m2630a(str);
        }
    }

    /* renamed from: b */
    public static void m2627b() {
        if (Build.VERSION.SDK_INT >= 18) {
            C0361b.m2629a();
        }
    }

    /* renamed from: c */
    private static boolean m2628c() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f2459b == null) {
                    f2458a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    f2459b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) f2459b.invoke(null, Long.valueOf(f2458a))).booleanValue();
            } catch (Exception e2) {
                m2625a("isTagEnabled", e2);
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m2625a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.m189v("Trace", "Unable to call " + str + " via reflection", exc);
    }
}
