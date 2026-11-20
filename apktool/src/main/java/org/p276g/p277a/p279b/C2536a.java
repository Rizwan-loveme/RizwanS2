package org.p276g.p277a.p279b;

import java.lang.reflect.InvocationTargetException;
import org.p276g.C2548c;

/* compiled from: GCJInstantiator.java */
/* renamed from: org.g.a.b.a */
/* loaded from: classes.dex */
public class C2536a<T> extends AbstractC2537b<T> {
    public C2536a(Class<T> cls) {
        super(cls);
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return this.f13298c.cast(f13296a.invoke(f13297b, this.f13298c, Object.class));
        } catch (IllegalAccessException e2) {
            throw new C2548c(e2);
        } catch (RuntimeException e3) {
            throw new C2548c(e3);
        } catch (InvocationTargetException e4) {
            throw new C2548c(e4);
        }
    }
}
