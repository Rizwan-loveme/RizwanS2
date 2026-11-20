package org.p285i.p287b;

/* compiled from: Util.java */
/* renamed from: org.i.b.i */
/* loaded from: classes.dex */
public final class C2567i {

    /* renamed from: a */
    private static a f13351a;

    /* renamed from: b */
    private static boolean f13352b = false;

    private C2567i() {
    }

    /* renamed from: a */
    public static String m15988a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException e2) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m15991b(String str) {
        String m15988a = m15988a(str);
        if (m15988a == null) {
            return false;
        }
        return m15988a.equalsIgnoreCase("true");
    }

    /* compiled from: Util.java */
    /* renamed from: org.i.b.i$a */
    private static final class a extends SecurityManager {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    /* renamed from: b */
    private static a m15990b() {
        if (f13351a != null) {
            return f13351a;
        }
        if (f13352b) {
            return null;
        }
        f13351a = m15992c();
        f13352b = true;
        return f13351a;
    }

    /* renamed from: c */
    private static a m15992c() {
        try {
            return new a(null);
        } catch (SecurityException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m15987a() {
        a m15990b = m15990b();
        if (m15990b == null) {
            return null;
        }
        Class<?>[] classContext = m15990b.getClassContext();
        String name = C2567i.class.getName();
        int i = 0;
        while (i < classContext.length && !name.equals(classContext[i].getName())) {
            i++;
        }
        if (i >= classContext.length || i + 2 >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i + 2];
    }

    /* renamed from: a */
    public static final void m15989a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* renamed from: c */
    public static final void m15993c(String str) {
        System.err.println("SLF4J: " + str);
    }
}
