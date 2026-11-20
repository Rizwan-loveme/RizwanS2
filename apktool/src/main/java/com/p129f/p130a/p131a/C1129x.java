package com.p129f.p130a.p131a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Throwables.java */
/* renamed from: com.f.a.a.x */
/* loaded from: classes.dex */
public final class C1129x {

    /* renamed from: a */
    @NullableDecl
    private static final Object f7571a = m9595a();

    /* renamed from: b */
    @NullableDecl
    private static final Method f7572b;

    /* renamed from: c */
    @NullableDecl
    private static final Method f7573c;

    /* renamed from: a */
    public static void m9597a(Throwable th) {
        C1120o.m9547a(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    static {
        f7572b = f7571a == null ? null : m9598b();
        f7573c = f7571a != null ? m9599c() : null;
    }

    @NullableDecl
    /* renamed from: a */
    private static Object m9595a() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            return null;
        }
    }

    @NullableDecl
    /* renamed from: b */
    private static Method m9598b() {
        return m9596a("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @NullableDecl
    /* renamed from: c */
    private static Method m9599c() {
        try {
            Method m9596a = m9596a("getStackTraceDepth", Throwable.class);
            if (m9596a == null) {
                return null;
            }
            m9596a.invoke(m9595a(), new Throwable());
            return m9596a;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (UnsupportedOperationException e3) {
            return null;
        } catch (InvocationTargetException e4) {
            return null;
        }
    }

    @NullableDecl
    /* renamed from: a */
    private static Method m9596a(String str, Class<?>... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            return null;
        }
    }
}
