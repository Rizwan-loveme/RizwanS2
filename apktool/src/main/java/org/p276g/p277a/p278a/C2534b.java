package org.p276g.p277a.p278a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.ObjectStreamClass;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;

/* compiled from: Android17Instantiator.java */
/* renamed from: org.g.a.a.b */
/* loaded from: classes.dex */
public class C2534b<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    private final Class<T> f13290a;

    /* renamed from: b */
    private final Method f13291b = m15909b();

    /* renamed from: c */
    private final Integer f13292c = m15910c();

    public C2534b(Class<T> cls) {
        this.f13290a = cls;
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return this.f13290a.cast(this.f13291b.invoke(null, this.f13290a, this.f13292c));
        } catch (Exception e2) {
            throw new C2548c(e2);
        }
    }

    /* renamed from: b */
    private static Method m15909b() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e2) {
            throw new C2548c(e2);
        } catch (RuntimeException e3) {
            throw new C2548c(e3);
        }
    }

    /* renamed from: c */
    private static Integer m15910c() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod.setAccessible(true);
            return (Integer) declaredMethod.invoke(null, Object.class);
        } catch (IllegalAccessException e2) {
            throw new C2548c(e2);
        } catch (NoSuchMethodException e3) {
            throw new C2548c(e3);
        } catch (RuntimeException e4) {
            throw new C2548c(e4);
        } catch (InvocationTargetException e5) {
            throw new C2548c(e5);
        }
    }
}
