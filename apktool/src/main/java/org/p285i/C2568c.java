package org.p285i;

import java.net.URL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.p285i.p286a.C2557d;
import org.p285i.p287b.C2563e;
import org.p285i.p287b.C2565g;
import org.p285i.p287b.C2566h;
import org.p285i.p287b.C2567i;
import org.p285i.p288c.C2571c;

/* compiled from: LoggerFactory.java */
/* renamed from: org.i.c */
/* loaded from: classes.dex */
public final class C2568c {

    /* renamed from: a */
    static volatile int f13353a = 0;

    /* renamed from: b */
    static final C2566h f13354b = new C2566h();

    /* renamed from: c */
    static final C2563e f13355c = new C2563e();

    /* renamed from: d */
    static boolean f13356d = C2567i.m15991b("slf4j.detectLoggerNameMismatch");

    /* renamed from: e */
    private static final String[] f13357e = {"1.6", "1.7"};

    /* renamed from: f */
    private static String f13358f = "org/slf4j/impl/StaticLoggerBinder.class";

    private C2568c() {
    }

    /* renamed from: c */
    private static final void m16006c() {
        m16008d();
        if (f13353a == 3) {
            m16012h();
        }
    }

    /* renamed from: b */
    private static boolean m16005b(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    /* renamed from: d */
    private static final void m16008d() {
        Set<URL> set = null;
        try {
            if (!m16013i()) {
                set = m15994a();
                m16004b(set);
            }
            C2571c.m16020a();
            f13353a = 3;
            m16007c(set);
            m16009e();
            m16010f();
            f13354b.m15986d();
        } catch (Exception e2) {
            m15998a(e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        } catch (NoClassDefFoundError e3) {
            if (m16005b(e3.getMessage())) {
                f13353a = 4;
                C2567i.m15993c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                C2567i.m15993c("Defaulting to no-operation (NOP) logger implementation");
                C2567i.m15993c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            m15998a(e3);
            throw e3;
        } catch (NoSuchMethodError e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f13353a = 2;
                C2567i.m15993c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                C2567i.m15993c("Your binding is version 1.5.5 or earlier.");
                C2567i.m15993c("Upgrade your binding to version 1.6.x.");
            }
            throw e4;
        }
    }

    /* renamed from: e */
    private static void m16009e() {
        synchronized (f13354b) {
            f13354b.m15985c();
            for (C2565g c2565g : f13354b.m15983a()) {
                c2565g.m15978a(m15996a(c2565g.mo15929a()));
            }
        }
    }

    /* renamed from: a */
    static void m15998a(Throwable th) {
        f13353a = 2;
        C2567i.m15989a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* renamed from: f */
    private static void m16010f() {
        LinkedBlockingQueue<C2557d> m15984b = f13354b.m15984b();
        int size = m15984b.size();
        int i = 0;
        ArrayList<C2557d> arrayList = new ArrayList(128);
        while (m15984b.drainTo(arrayList, 128) != 0) {
            int i2 = i;
            for (C2557d c2557d : arrayList) {
                m15999a(c2557d);
                int i3 = i2 + 1;
                if (i2 == 0) {
                    m16000a(c2557d, size);
                }
                i2 = i3;
            }
            arrayList.clear();
            i = i2;
        }
    }

    /* renamed from: a */
    private static void m16000a(C2557d c2557d, int i) {
        if (c2557d.m15947a().m15980d()) {
            m15997a(i);
        } else if (!c2557d.m15947a().m15982f()) {
            m16011g();
        }
    }

    /* renamed from: a */
    private static void m15999a(C2557d c2557d) {
        if (c2557d != null) {
            C2565g m15947a = c2557d.m15947a();
            String mo15929a = m15947a.mo15929a();
            if (m15947a.m15981e()) {
                throw new IllegalStateException("Delegate logger cannot be null at this state.");
            }
            if (!m15947a.m15982f()) {
                if (m15947a.m15980d()) {
                    m15947a.m15977a(c2557d);
                } else {
                    C2567i.m15993c(mo15929a);
                }
            }
        }
    }

    /* renamed from: g */
    private static void m16011g() {
        C2567i.m15993c("The following set of substitute loggers may have been accessed");
        C2567i.m15993c("during the initialization phase. Logging calls during this");
        C2567i.m15993c("phase were not honored. However, subsequent logging calls to these");
        C2567i.m15993c("loggers will work as normally expected.");
        C2567i.m15993c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* renamed from: a */
    private static void m15997a(int i) {
        C2567i.m15993c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        C2567i.m15993c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        C2567i.m15993c("See also http://www.slf4j.org/codes.html#replay");
    }

    /* renamed from: h */
    private static final void m16012h() {
        try {
            String str = C2571c.f13360a;
            boolean z = false;
            for (String str2 : f13357e) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (!z) {
                C2567i.m15993c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f13357e).toString());
                C2567i.m15993c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError e2) {
        } catch (Throwable th) {
            C2567i.m15989a("Unexpected problem occured during version sanity check", th);
        }
    }

    /* renamed from: a */
    static Set<URL> m15994a() {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = C2568c.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(f13358f);
            } else {
                resources = classLoader.getResources(f13358f);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e2) {
            C2567i.m15989a("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    private static boolean m16002a(Set<URL> set) {
        return set.size() > 1;
    }

    /* renamed from: b */
    private static void m16004b(Set<URL> set) {
        if (m16002a(set)) {
            C2567i.m15993c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                C2567i.m15993c("Found binding in [" + it.next() + "]");
            }
            C2567i.m15993c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /* renamed from: i */
    private static boolean m16013i() {
        String m15988a = C2567i.m15988a("java.vendor.url");
        if (m15988a == null) {
            return false;
        }
        return m15988a.toLowerCase().contains("android");
    }

    /* renamed from: c */
    private static void m16007c(Set<URL> set) {
        if (set != null && m16002a(set)) {
            C2567i.m15993c("Actual binding is of type [" + C2571c.m16020a().m16022c() + "]");
        }
    }

    /* renamed from: a */
    public static InterfaceC2558b m15996a(String str) {
        return m16003b().mo15926a(str);
    }

    /* renamed from: a */
    public static InterfaceC2558b m15995a(Class<?> cls) {
        Class<?> m15987a;
        InterfaceC2558b m15996a = m15996a(cls.getName());
        if (f13356d && (m15987a = C2567i.m15987a()) != null && m16001a(cls, m15987a)) {
            C2567i.m15993c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", m15996a.mo15929a(), m15987a.getName()));
            C2567i.m15993c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return m15996a;
    }

    /* renamed from: a */
    private static boolean m16001a(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    /* renamed from: b */
    public static InterfaceC2553a m16003b() {
        if (f13353a == 0) {
            synchronized (C2568c.class) {
                if (f13353a == 0) {
                    f13353a = 1;
                    m16006c();
                }
            }
        }
        switch (f13353a) {
            case 1:
                return f13354b;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return C2571c.m16020a().m16021b();
            case 4:
                return f13355c;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
