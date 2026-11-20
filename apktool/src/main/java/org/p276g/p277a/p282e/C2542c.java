package org.p276g.p277a.p282e;

import java.lang.reflect.Field;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;
import sun.misc.Unsafe;

/* compiled from: UnsafeFactoryInstantiator.java */
/* renamed from: org.g.a.e.c */
/* loaded from: classes.dex */
public class C2542c<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    private static Unsafe f13304a;

    /* renamed from: b */
    private final Class<T> f13305b;

    public C2542c(Class<T> cls) {
        if (f13304a == null) {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                try {
                    f13304a = (Unsafe) declaredField.get(null);
                } catch (IllegalAccessException e2) {
                    throw new C2548c(e2);
                }
            } catch (NoSuchFieldException e3) {
                throw new C2548c(e3);
            }
        }
        this.f13305b = cls;
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return this.f13305b.cast(f13304a.allocateInstance(this.f13305b));
        } catch (InstantiationException e2) {
            throw new C2548c(e2);
        }
    }
}
