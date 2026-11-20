package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.C0034Os;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.p028a.C0258c;
import androidx.core.p027c.C0251f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: TypefaceCompatApi21Impl.java */
/* renamed from: androidx.core.graphics.e */
/* loaded from: classes.dex */
class C0321e extends C0326j {

    /* renamed from: a */
    private static Class<?> f2274a;

    /* renamed from: b */
    private static Constructor<?> f2275b;

    /* renamed from: c */
    private static Method f2276c;

    /* renamed from: d */
    private static Method f2277d;

    /* renamed from: e */
    private static boolean f2278e = false;

    C0321e() {
    }

    /* renamed from: a */
    private static void m2381a() {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Class<?> cls;
        if (!f2278e) {
            f2278e = true;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                constructor = cls.getConstructor(new Class[0]);
                method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                Log.m185e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
                method = null;
                method2 = null;
                constructor = null;
                cls = null;
            }
            f2275b = constructor;
            f2274a = cls;
            f2276c = method2;
            f2277d = method;
        }
    }

    /* renamed from: a */
    private File m2380a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = C0034Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(C0034Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException e2) {
            return null;
        }
    }

    /* renamed from: b */
    private static Object m2383b() {
        m2381a();
        try {
            return f2275b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    private static Typeface m2379a(Object obj) {
        m2381a();
        try {
            Object newInstance = Array.newInstance(f2274a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2277d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    private static boolean m2382a(Object obj, String str, int i, boolean z) {
        m2381a();
        try {
            return ((Boolean) f2276c.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2384a(Context context, CancellationSignal cancellationSignal, C0251f.b[] bVarArr, int i) {
        if (bVarArr.length < 1) {
            return null;
        }
        C0251f.b a2 = mo2406a(bVarArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.m1827a(), "r", cancellationSignal);
            if (openFileDescriptor != null) {
                try {
                    File m2380a = m2380a(openFileDescriptor);
                    if (m2380a == null || !m2380a.canRead()) {
                        FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                        try {
                            Typeface mo2405a = super.mo2405a(context, fileInputStream);
                            fileInputStream.close();
                            if (openFileDescriptor != null) {
                                openFileDescriptor.close();
                            }
                            return mo2405a;
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    Typeface createFromFile = Typeface.createFromFile(m2380a);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromFile;
                } finally {
                }
            }
            if (openFileDescriptor == null) {
                return null;
            }
            openFileDescriptor.close();
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2385a(Context context, C0258c.b bVar, Resources resources, int i) {
        Object m2383b = m2383b();
        for (C0258c.c cVar : bVar.m1889a()) {
            File m2414a = C0327k.m2414a(context);
            if (m2414a == null) {
                return null;
            }
            try {
                if (!C0327k.m2420a(m2414a, resources, cVar.m1895f())) {
                    return null;
                }
                if (!m2382a(m2383b, m2414a.getPath(), cVar.m1891b(), cVar.m1892c())) {
                    return null;
                }
                m2414a.delete();
            } catch (RuntimeException e2) {
                return null;
            } finally {
                m2414a.delete();
            }
        }
        return m2379a(m2383b);
    }
}
