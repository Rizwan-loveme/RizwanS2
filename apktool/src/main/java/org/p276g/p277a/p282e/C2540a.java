package org.p276g.p277a.p282e;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.p276g.C2548c;

/* compiled from: SunReflectionFactoryHelper.java */
/* renamed from: org.g.a.e.a */
/* loaded from: classes.dex */
class C2540a {
    /* renamed from: a */
    public static <T> Constructor<T> m15917a(Class<T> cls, Constructor<?> constructor) {
        Class<?> m15915a = m15915a();
        try {
            return (Constructor) m15918b(m15915a).invoke(m15916a(m15915a), cls, constructor);
        } catch (IllegalAccessException e2) {
            throw new C2548c(e2);
        } catch (IllegalArgumentException e3) {
            throw new C2548c(e3);
        } catch (InvocationTargetException e4) {
            throw new C2548c(e4);
        }
    }

    /* renamed from: a */
    private static Class<?> m15915a() {
        try {
            return Class.forName("sun.reflect.ReflectionFactory");
        } catch (ClassNotFoundException e2) {
            throw new C2548c(e2);
        }
    }

    /* renamed from: a */
    private static Object m15916a(Class<?> cls) {
        try {
            return cls.getDeclaredMethod("getReflectionFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new C2548c(e2);
        } catch (IllegalArgumentException e3) {
            throw new C2548c(e3);
        } catch (NoSuchMethodException e4) {
            throw new C2548c(e4);
        } catch (InvocationTargetException e5) {
            throw new C2548c(e5);
        }
    }

    /* renamed from: b */
    private static Method m15918b(Class<?> cls) {
        try {
            return cls.getDeclaredMethod("newConstructorForSerialization", Class.class, Constructor.class);
        } catch (NoSuchMethodException e2) {
            throw new C2548c(e2);
        }
    }
}
