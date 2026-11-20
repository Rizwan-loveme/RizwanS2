package org.p276g.p277a.p279b;

import java.lang.reflect.Method;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.p276g.C2548c;
import org.p276g.p277a.InterfaceC2532a;

/* compiled from: GCJInstantiatorBase.java */
/* renamed from: org.g.a.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC2537b<T> implements InterfaceC2532a<T> {

    /* renamed from: a */
    static Method f13296a = null;

    /* renamed from: b */
    static ObjectInputStream f13297b;

    /* renamed from: c */
    protected final Class<T> f13298c;

    /* compiled from: GCJInstantiatorBase.java */
    /* renamed from: org.g.a.b.b$a */
    private static class a extends ObjectInputStream {
    }

    /* renamed from: b */
    private static void m15913b() {
        if (f13296a == null) {
            try {
                f13296a = ObjectInputStream.class.getDeclaredMethod("newObject", Class.class, Class.class);
                f13296a.setAccessible(true);
                f13297b = new a();
            } catch (IOException e2) {
                throw new C2548c(e2);
            } catch (NoSuchMethodException e3) {
                throw new C2548c(e3);
            } catch (RuntimeException e4) {
                throw new C2548c(e4);
            }
        }
    }

    public AbstractC2537b(Class<T> cls) {
        this.f13298c = cls;
        m15913b();
    }
}
