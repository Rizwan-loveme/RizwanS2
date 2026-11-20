package org.p276g.p277a.p281d;

import java.lang.reflect.Method;
import java.io.ObjectInputStream;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;

/* compiled from: PercInstantiator.java */
/* renamed from: org.g.a.d.a */
/* loaded from: classes.dex */
public class C2539a<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    private final Method f13301a;

    /* renamed from: b */
    private final Object[] f13302b = {null, Boolean.FALSE};

    public C2539a(Class<T> cls) {
        this.f13302b[0] = cls;
        try {
            this.f13301a = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Boolean.TYPE);
            this.f13301a.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            throw new C2548c(e2);
        } catch (RuntimeException e3) {
            throw new C2548c(e3);
        }
    }

    @Override // org.p276g.p277a.InterfaceC2532a
    /* renamed from: a */
    public T mo15907a() {
        try {
            return (T) this.f13301a.invoke(null, this.f13302b);
        } catch (Exception e2) {
            throw new C2548c(e2);
        }
    }
}
