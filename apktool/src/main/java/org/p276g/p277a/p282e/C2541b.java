package org.p276g.p277a.p282e;

import java.lang.reflect.Constructor;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;

/* compiled from: SunReflectionFactoryInstantiator.java */
/* renamed from: org.g.a.e.b */
/* loaded from: classes.dex */
public class C2541b<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    private final Constructor<T> f13303a;

    public C2541b(Class<T> cls) {
        this.f13303a = C2540a.m15917a(cls, m15919b());
        this.f13303a.setAccessible(true);
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return this.f13303a.newInstance((Object[]) null);
        } catch (Exception e2) {
            throw new C2548c(e2);
        }
    }

    /* renamed from: b */
    private static Constructor<Object> m15919b() {
        try {
            return Object.class.getConstructor((Class[]) null);
        } catch (NoSuchMethodException e2) {
            throw new C2548c(e2);
        }
    }
}
