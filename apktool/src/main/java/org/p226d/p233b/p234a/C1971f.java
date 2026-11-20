package org.p226d.p233b.p234a;

import com.p129f.p130a.p131a.C1114i;
import com.p129f.p130a.p131a.C1124s;
import com.p129f.p130a.p133c.C1156ai;
import java.p209io.File;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.p234a.C1978m;
import org.p226d.p233b.p244d.C2158l;
import org.p226d.p233b.p244d.C2162p;
import org.p226d.p233b.p250e.InterfaceC2264e;
import org.p226d.p233b.p250e.InterfaceC2270k;

/* compiled from: ClassPathResolver.java */
/* renamed from: org.d.b.a.f */
/* loaded from: classes.dex */
public class C1971f {

    /* renamed from: a */
    private final Iterable<String> f11465a;

    /* renamed from: b */
    private final C1978m f11466b;

    public C1971f(List<String> list, List<String> list2, List<String> list3, InterfaceC2264e interfaceC2264e) {
        this(list, list2, list3, interfaceC2264e, true);
    }

    private C1971f(List<String> list, List<String> list2, List<String> list3, InterfaceC2264e interfaceC2264e, boolean z) {
        this.f11465a = list;
        this.f11466b = new C1978m(interfaceC2264e.mo14767a());
        for (String str : list2 == null ? m14282a(interfaceC2264e, interfaceC2264e.mo14767a().f12635a) : list2) {
            try {
                m14284b(str);
            } catch (a e2) {
                if (str.endsWith(".odex")) {
                    String str2 = str.substring(0, str.length() - 5) + ".jar";
                    try {
                        m14284b(str2);
                    } catch (a e3) {
                        throw new b(e2);
                    } catch (C1978m.a e4) {
                        throw new b("Neither %s nor %s contain a dex file", str, str2);
                    }
                } else {
                    throw new b(e2);
                }
            } catch (C1978m.a e5) {
                if (str.endsWith(".jar")) {
                    String str3 = str.substring(0, str.length() - 4) + ".odex";
                    try {
                        m14284b(str3);
                    } catch (a e6) {
                        throw new b(e5);
                    } catch (C1978m.a e7) {
                        throw new b("Neither %s nor %s contain a dex file", str, str3);
                    }
                } else {
                    throw new b(e5);
                }
            }
        }
        Iterator<String> it = list3.iterator();
        while (it.hasNext()) {
            try {
                m14283a(it.next());
            } catch (C1978m.a e8) {
                throw new b(e8);
            }
        }
        if (interfaceC2264e instanceof InterfaceC2270k.a) {
            InterfaceC2270k<? extends InterfaceC2270k.a> mo14827f = ((InterfaceC2270k.a) interfaceC2264e).mo14827f();
            Iterator<String> it2 = mo14827f.mo14511a().iterator();
            while (it2.hasNext()) {
                this.f11466b.m14407a().add(new C1974i(mo14827f.mo14513b(it2.next())));
            }
            return;
        }
        this.f11466b.m14407a().add(new C1974i(interfaceC2264e));
    }

    /* renamed from: a */
    public List<InterfaceC1973h> m14286a() {
        return this.f11466b.m14409b();
    }

    /* renamed from: a */
    private boolean m14283a(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        try {
            this.f11466b.m14408a(file, true);
            return true;
        } catch (C2016c.f e2) {
            throw new b(e2, "Couldn't load classpath entry %s", str);
        }
    }

    /* renamed from: b */
    private void m14284b(String str) {
        if (!m14283a(str)) {
            List<String> m14285c = m14285c(str);
            C1114i m9520a = C1114i.m9520a(File.pathSeparatorChar);
            Iterator<String> it = this.f11465a.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    for (int i = 0; i < m14285c.size(); i++) {
                        File file2 = new File(file, m9520a.m9524a((Iterable<?>) m14285c.subList(i, m14285c.size())));
                        if (file2.exists() && file2.isFile()) {
                            this.f11466b.m14408a(file2, true);
                            return;
                        }
                    }
                }
            }
            throw new a("Could not find classpath entry %s", str);
        }
    }

    /* renamed from: c */
    private static List<String> m14285c(String str) {
        return C1156ai.m9910a(C1124s.m9565a('/').m9575a(str));
    }

    /* compiled from: ClassPathResolver.java */
    /* renamed from: org.d.b.a.f$a */
    static class a extends Exception {
        public a(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    /* compiled from: ClassPathResolver.java */
    /* renamed from: org.d.b.a.f$b */
    public static class b extends RuntimeException {
        public b(String str, Object... objArr) {
            super(String.format(str, objArr));
        }

        public b(Throwable th) {
            super(th);
        }

        public b(Throwable th, String str, Object... objArr) {
            super(String.format(str, objArr), th);
        }
    }

    /* renamed from: a */
    private static List<String> m14282a(InterfaceC2264e interfaceC2264e, int i) {
        if (interfaceC2264e instanceof C2162p.e) {
            return m14281a((C2162p.e) interfaceC2264e);
        }
        if (interfaceC2264e instanceof C2158l) {
            return ((C2158l) interfaceC2264e).m14803e();
        }
        return i <= 8 ? C1156ai.m9912a("/system/framework/core.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar") : i <= 11 ? C1156ai.m9912a("/system/framework/core.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/core-junit.jar") : i <= 13 ? C1156ai.m9912a("/system/framework/core.jar", "/system/framework/apache-xml.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/core-junit.jar") : i <= 15 ? C1156ai.m9912a("/system/framework/core.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar", "/system/framework/filterfw.jar") : i <= 17 ? C1156ai.m9912a("/system/framework/core.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar") : i <= 18 ? C1156ai.m9912a("/system/framework/core.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar") : i <= 19 ? C1156ai.m9912a("/system/framework/core.jar", "/system/framework/conscrypt.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/framework2.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/services.jar", "/system/framework/apache-xml.jar", "/system/framework/webviewchromium.jar") : i <= 22 ? C1156ai.m9912a("/system/framework/core-libart.jar", "/system/framework/conscrypt.jar", "/system/framework/okhttp.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/ims-common.jar", "/system/framework/mms-common.jar", "/system/framework/android.policy.jar", "/system/framework/apache-xml.jar") : i <= 23 ? C1156ai.m9912a("/system/framework/core-libart.jar", "/system/framework/conscrypt.jar", "/system/framework/okhttp.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/ims-common.jar", "/system/framework/apache-xml.jar", "/system/framework/org.apache.http.legacy.boot.jar") : C1156ai.m9912a("/system/framework/core-oj.jar", "/system/framework/core-libart.jar", "/system/framework/conscrypt.jar", "/system/framework/okhttp.jar", "/system/framework/core-junit.jar", "/system/framework/bouncycastle.jar", "/system/framework/ext.jar", "/system/framework/framework.jar", "/system/framework/telephony-common.jar", "/system/framework/voip-common.jar", "/system/framework/ims-common.jar", "/system/framework/apache-xml.jar", "/system/framework/org.apache.http.legacy.boot.jar");
    }

    /* renamed from: a */
    private static List<String> m14281a(C2162p.e eVar) {
        List<String> m14821d = eVar.mo14827f().m14821d();
        return m14821d.isEmpty() ? C1156ai.m9912a("boot.oat") : m14280a(m14821d, ".art", ".oat");
    }

    /* renamed from: a */
    private static List<String> m14280a(List<String> list, String str, String str2) {
        for (int i = 0; i < list.size(); i++) {
            String str3 = list.get(i);
            if (str3.endsWith(str)) {
                list.set(i, str3.substring(0, str3.length() - str.length()) + str2);
            }
        }
        return list;
    }
}
