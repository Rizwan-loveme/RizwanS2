package org.p276g.p277a.p278a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.p209io.ObjectStreamClass;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;

/* compiled from: Android18Instantiator.java */
/* renamed from: org.g.a.a.c */
/* loaded from: classes.dex */
public class C2535c<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    private final Class<T> f13293a;

    /* renamed from: b */
    private final Method f13294b = m15911b();

    /* renamed from: c */
    private final Long f13295c = m15912c();

    public C2535c(Class<T> cls) {
        this.f13293a = cls;
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return this.f13293a.cast(this.f13294b.invoke(null, this.f13293a, this.f13295c));
        } catch (Exception e2) {
            throw new C2548c(e2);
        }
    }

    /* renamed from: b */
    private static Method m15911b() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Long.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e2) {
            throw new C2548c(e2);
        } catch (RuntimeException e3) {
            throw new C2548c(e3);
        }
    }

    /* renamed from: c */
    private static Long m15912c() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod.setAccessible(true);
            return (Long) declaredMethod.invoke(null, Object.class);
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
