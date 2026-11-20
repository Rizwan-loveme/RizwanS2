package androidx.core.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi28Impl.java */
/* renamed from: androidx.core.graphics.h */
/* loaded from: classes.dex */
public class C0324h extends C0323g {
    @Override // androidx.core.graphics.C0323g
    /* renamed from: a */
    protected Typeface mo2397a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2283a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f2289g.invoke(null, newInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.core.graphics.C0323g
    /* renamed from: f */
    protected Method mo2404f(Class<?> cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
