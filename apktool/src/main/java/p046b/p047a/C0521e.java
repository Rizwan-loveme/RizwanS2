package p046b.p047a;

import java.util.Properties;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: ApktoolProperties.java */
/* renamed from: b.a.e */
/* loaded from: classes.dex */
public class C0521e {

    /* renamed from: a */
    private static Properties f3616a;

    /* renamed from: a */
    public static String m3902a(String str) {
        return m3903a().getProperty(str);
    }

    /* renamed from: a */
    public static Properties m3903a() {
        if (f3616a == null) {
            m3904b();
        }
        return f3616a;
    }

    /* renamed from: b */
    private static void m3904b() {
        f3616a = new Properties();
        f3616a.put("application.version", C3102bd.f18294ab);
        f3616a.put("baksmaliVersion", "2.2.5");
        f3616a.put("smaliVersion", "2.2.5");
    }
}
