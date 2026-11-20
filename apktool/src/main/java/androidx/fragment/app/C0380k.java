package androidx.fragment.app;

import androidx.fragment.app.ComponentCallbacksC0374e;
import androidx.p011a.C0042g;
import java.lang.reflect.InvocationTargetException;

/* compiled from: FragmentFactory.java */
/* renamed from: androidx.fragment.app.k */
/* loaded from: classes.dex */
public class C0380k {

    /* renamed from: a */
    private static final C0042g<ClassLoader, C0042g<String, Class<?>>> f2724a = new C0042g<>();

    /* renamed from: d */
    private static Class<?> m2940d(ClassLoader classLoader, String str) {
        C0042g<String, Class<?>> c0042g;
        C0042g<String, Class<?>> c0042g2 = f2724a.get(classLoader);
        if (c0042g2 == null) {
            C0042g<String, Class<?>> c0042g3 = new C0042g<>();
            f2724a.put(classLoader, c0042g3);
            c0042g = c0042g3;
        } else {
            c0042g = c0042g2;
        }
        Class<?> cls = c0042g.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            c0042g.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    /* renamed from: a */
    static boolean m2938a(ClassLoader classLoader, String str) {
        try {
            return ComponentCallbacksC0374e.class.isAssignableFrom(m2940d(classLoader, str));
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    /* renamed from: b */
    public static Class<? extends ComponentCallbacksC0374e> m2939b(ClassLoader classLoader, String str) {
        try {
            return m2940d(classLoader, str);
        } catch (ClassCastException e2) {
            throw new ComponentCallbacksC0374e.b("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        } catch (ClassNotFoundException e3) {
            throw new ComponentCallbacksC0374e.b("Unable to instantiate fragment " + str + ": make sure class name exists", e3);
        }
    }

    /* renamed from: c */
    public ComponentCallbacksC0374e mo2941c(ClassLoader classLoader, String str) {
        try {
            return m2939b(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new ComponentCallbacksC0374e.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new ComponentCallbacksC0374e.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new ComponentCallbacksC0374e.b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new ComponentCallbacksC0374e.b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }
}
