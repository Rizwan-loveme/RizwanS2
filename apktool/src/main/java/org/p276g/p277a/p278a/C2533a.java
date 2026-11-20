package org.p276g.p277a.p278a;

import java.lang.reflect.Method;
import java.io.ObjectInputStream;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;

/* compiled from: Android10Instantiator.java */
/* renamed from: org.g.a.a.a */
/* loaded from: classes.dex */
public class C2533a<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    private final Class<T> f13288a;

    /* renamed from: b */
    private final Method f13289b = m15908b();

    public C2533a(Class<T> cls) {
        this.f13288a = cls;
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return this.f13288a.cast(this.f13289b.invoke(null, this.f13288a, Object.class));
        } catch (Exception e2) {
            throw new C2548c(e2);
        }
    }

    /* renamed from: b */
    private static Method m15908b() {
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e2) {
            throw new C2548c(e2);
        } catch (RuntimeException e3) {
            throw new C2548c(e3);
        }
    }
}
