package org.p276g.p283b;

import org.p276g.C2548c;

/* compiled from: PlatformDescription.java */
/* renamed from: org.g.b.c */
/* loaded from: classes.dex */
public final class C2546c {

    /* renamed from: a */
    public static final String f13308a = System.getProperty("java.specification.version");

    /* renamed from: b */
    public static final String f13309b = System.getProperty("java.runtime.version");

    /* renamed from: c */
    public static final String f13310c = System.getProperty("java.vm.info");

    /* renamed from: d */
    public static final String f13311d = System.getProperty("java.vm.version");

    /* renamed from: e */
    public static final String f13312e = System.getProperty("java.vm.vendor");

    /* renamed from: f */
    public static final String f13313f = System.getProperty("java.vm.name");

    /* renamed from: g */
    public static final int f13314g = m15922a();

    /* renamed from: a */
    public static boolean m15924a(String str) {
        return f13313f.startsWith(str);
    }

    /* renamed from: a */
    private static int m15922a() {
        if (m15924a("Dalvik")) {
            return m15925b();
        }
        return 0;
    }

    /* renamed from: b */
    private static int m15925b() {
        try {
            Class<?> cls = Class.forName("android.os.Build$VERSION");
            try {
                try {
                    return ((Integer) cls.getField("SDK_INT").get(null)).intValue();
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (NoSuchFieldException e3) {
                return m15923a(cls);
            }
        } catch (ClassNotFoundException e4) {
            throw new C2548c(e4);
        }
    }

    /* renamed from: a */
    private static int m15923a(Class<?> cls) {
        try {
            try {
                return Integer.parseInt((String) cls.getField("SDK").get(null));
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchFieldException e3) {
            throw new C2548c(e3);
        }
    }
}
