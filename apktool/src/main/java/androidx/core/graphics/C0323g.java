package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.p028a.C0258c;
import androidx.core.p027c.C0251f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.util.Map;

/* compiled from: TypefaceCompatApi26Impl.java */
/* renamed from: androidx.core.graphics.g */
/* loaded from: classes.dex */
public class C0323g extends C0321e {

    /* renamed from: a */
    protected final Class<?> f2283a;

    /* renamed from: b */
    protected final Constructor<?> f2284b;

    /* renamed from: c */
    protected final Method f2285c;

    /* renamed from: d */
    protected final Method f2286d;

    /* renamed from: e */
    protected final Method f2287e;

    /* renamed from: f */
    protected final Method f2288f;

    /* renamed from: g */
    protected final Method f2289g;

    public C0323g() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = m2398a();
            constructor = m2399a(cls);
            method5 = m2400b(cls);
            method4 = m2401c(cls);
            method3 = m2402d(cls);
            method2 = m2403e(cls);
            method = mo2404f(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.m185e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
            constructor = null;
            cls = null;
        }
        this.f2283a = cls;
        this.f2284b = constructor;
        this.f2285c = method5;
        this.f2286d = method4;
        this.f2287e = method3;
        this.f2288f = method2;
        this.f2289g = method;
    }

    /* renamed from: b */
    private boolean m2392b() {
        if (this.f2285c == null) {
            Log.m190w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f2285c != null;
    }

    /* renamed from: c */
    private Object m2394c() {
        try {
            return this.f2284b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m2390a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2285c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2391a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.f2286d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return false;
        }
    }

    /* renamed from: a */
    protected Typeface mo2397a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2283a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f2289g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return null;
        }
    }

    /* renamed from: b */
    private boolean m2393b(Object obj) {
        try {
            return ((Boolean) this.f2287e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return false;
        }
    }

    /* renamed from: c */
    private void m2395c(Object obj) {
        try {
            this.f2288f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e2) {
        } catch (InvocationTargetException e3) {
        }
    }

    @Override // androidx.core.graphics.C0321e, androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2385a(Context context, C0258c.b bVar, Resources resources, int i) {
        if (!m2392b()) {
            return super.mo2385a(context, bVar, resources, i);
        }
        Object m2394c = m2394c();
        if (m2394c == null) {
            return null;
        }
        for (C0258c.c cVar : bVar.m1889a()) {
            if (!m2390a(context, m2394c, cVar.m1890a(), cVar.m1894e(), cVar.m1891b(), cVar.m1892c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.m1893d()))) {
                m2395c(m2394c);
                return null;
            }
        }
        if (!m2393b(m2394c)) {
            return null;
        }
        return mo2397a(m2394c);
    }

    @Override // androidx.core.graphics.C0321e, androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2384a(Context context, CancellationSignal cancellationSignal, C0251f.b[] bVarArr, int i) {
        Typeface mo2397a;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!m2392b()) {
            C0251f.b a2 = mo2406a(bVarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.m1827a(), "r", cancellationSignal);
                if (openFileDescriptor != null) {
                    try {
                        Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.m1829c()).setItalic(a2.m1830d()).build();
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                            return build;
                        }
                        return build;
                    } finally {
                    }
                }
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                    return null;
                }
                return null;
            } catch (IOException e2) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> m2418a = C0327k.m2418a(context, bVarArr, cancellationSignal);
        Object m2394c = m2394c();
        if (m2394c == null) {
            return null;
        }
        boolean z = false;
        for (C0251f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = m2418a.get(bVar.m1827a());
            if (byteBuffer != null) {
                if (!m2391a(m2394c, byteBuffer, bVar.m1828b(), bVar.m1829c(), bVar.m1830d() ? 1 : 0)) {
                    m2395c(m2394c);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            m2395c(m2394c);
            return null;
        }
        if (!m2393b(m2394c) || (mo2397a = mo2397a(m2394c)) == null) {
            return null;
        }
        return Typeface.create(mo2397a, i);
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2396a(Context context, Resources resources, int i, String str, int i2) {
        if (!m2392b()) {
            return super.mo2396a(context, resources, i, str, i2);
        }
        Object m2394c = m2394c();
        if (m2394c == null) {
            return null;
        }
        if (!m2390a(context, m2394c, str, 0, -1, -1, null)) {
            m2395c(m2394c);
            return null;
        }
        if (m2393b(m2394c)) {
            return mo2397a(m2394c);
        }
        return null;
    }

    /* renamed from: a */
    protected Class<?> m2398a() {
        return Class.forName("android.graphics.FontFamily");
    }

    /* renamed from: a */
    protected Constructor<?> m2399a(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    /* renamed from: b */
    protected Method m2400b(Class<?> cls) {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    /* renamed from: c */
    protected Method m2401c(Class<?> cls) {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    /* renamed from: d */
    protected Method m2402d(Class<?> cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* renamed from: e */
    protected Method m2403e(Class<?> cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* renamed from: f */
    protected Method mo2404f(Class<?> cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
