package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.p008os.CancellationSignal;
import android.util.Log;
import androidx.core.content.p028a.C0258c;
import androidx.core.p027c.C0251f;
import androidx.p011a.C0042g;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl.java */
/* renamed from: androidx.core.graphics.f */
/* loaded from: classes.dex */
class C0322f extends C0326j {

    /* renamed from: a */
    private static final Class<?> f2279a;

    /* renamed from: b */
    private static final Constructor<?> f2280b;

    /* renamed from: c */
    private static final Method f2281c;

    /* renamed from: d */
    private static final Method f2282d;

    C0322f() {
    }

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.m185e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            method = null;
            method2 = null;
            constructor = null;
            cls = null;
        }
        f2280b = constructor;
        f2279a = cls;
        f2281c = method2;
        f2282d = method;
    }

    /* renamed from: a */
    public static boolean m2387a() {
        if (f2281c == null) {
            Log.m190w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f2281c != null;
    }

    /* renamed from: b */
    private static Object m2389b() {
        try {
            return f2280b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m2388a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f2281c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private static Typeface m2386a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2279a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2282d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2384a(Context context, CancellationSignal cancellationSignal, C0251f.b[] bVarArr, int i) {
        int i2;
        Object m2389b = m2389b();
        if (m2389b == null) {
            return null;
        }
        C0042g c0042g = new C0042g();
        for (C0251f.b bVar : bVarArr) {
            Uri m1827a = bVar.m1827a();
            ByteBuffer byteBuffer = (ByteBuffer) c0042g.get(m1827a);
            if (byteBuffer == null) {
                byteBuffer = C0327k.m2416a(context, cancellationSignal, m1827a);
                c0042g.put(m1827a, byteBuffer);
            }
            i2 = (byteBuffer != null && m2388a(m2389b, byteBuffer, bVar.m1828b(), bVar.m1829c(), bVar.m1830d())) ? i2 + 1 : 0;
            return null;
        }
        Typeface m2386a = m2386a(m2389b);
        if (m2386a == null) {
            return null;
        }
        return Typeface.create(m2386a, i);
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2385a(Context context, C0258c.b bVar, Resources resources, int i) {
        Object m2389b = m2389b();
        if (m2389b == null) {
            return null;
        }
        for (C0258c.c cVar : bVar.m1889a()) {
            ByteBuffer m2415a = C0327k.m2415a(context, resources, cVar.m1895f());
            if (m2415a == null || !m2388a(m2389b, m2415a, cVar.m1894e(), cVar.m1891b(), cVar.m1892c())) {
                return null;
            }
        }
        return m2386a(m2389b);
    }
}
