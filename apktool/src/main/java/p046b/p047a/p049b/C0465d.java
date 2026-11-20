package p046b.p047a.p049b;

import org.p270e.C2468c;

/* compiled from: VersionInfo.java */
/* renamed from: b.a.b.d */
/* loaded from: classes.dex */
public class C0465d {

    /* renamed from: a */
    public String f3299a;

    /* renamed from: b */
    public String f3300b;

    /* renamed from: a */
    public static void m3541a(C2468c c2468c, C0465d c0465d) {
        if (c0465d == null) {
            c2468c.m15608a("VersionInfo", C2468c.f12954b);
        } else {
            c0465d.m3542b(c2468c);
        }
    }

    /* renamed from: a */
    public static C0465d m3540a(C2468c c2468c) {
        C0465d c0465d = new C0465d();
        if (!c2468c.m15619h("VersionInfo")) {
            C2468c m15616e = c2468c.m15616e("VersionInfo");
            c0465d.f3299a = C0462a.m3522a(m15616e, "versionCode");
            c0465d.f3300b = C0462a.m3522a(m15616e, "versionName");
        }
        return c0465d;
    }

    /* renamed from: b */
    public void m3542b(C2468c c2468c) {
        C2468c c2468c2 = new C2468c();
        C0462a.m3524a(c2468c2, "versionCode", this.f3299a);
        C0462a.m3524a(c2468c2, "versionName", this.f3300b);
        c2468c.m15608a("VersionInfo", c2468c2);
    }
}
