package org.p276g.p277a.p280c;

import java.lang.reflect.Method;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;

/* compiled from: JRockitLegacyInstantiator.java */
/* renamed from: org.g.a.c.a */
/* loaded from: classes.dex */
public class C2538a<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    private static Method f13299a = null;

    /* renamed from: b */
    private final Class<T> f13300b;

    /* renamed from: b */
    private static void m15914b() {
        if (f13299a == null) {
            try {
                f13299a = Class.forName("jrockit.vm.MemSystem").getDeclaredMethod("safeAllocObject", Class.class);
                f13299a.setAccessible(true);
            } catch (ClassNotFoundException e2) {
                throw new C2548c(e2);
            } catch (NoSuchMethodException e3) {
                throw new C2548c(e3);
            } catch (RuntimeException e4) {
                throw new C2548c(e4);
            }
        }
    }

    public C2538a(Class<T> cls) {
        m15914b();
        this.f13300b = cls;
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return this.f13300b.cast(f13299a.invoke(null, this.f13300b));
        } catch (Exception e2) {
            throw new C2548c(e2);
        }
    }
}
