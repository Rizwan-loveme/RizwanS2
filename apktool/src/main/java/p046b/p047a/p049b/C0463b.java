package p046b.p047a.p049b;

import org.p270e.C2468c;

/* compiled from: PackageInfo.java */
/* renamed from: b.a.b.b */
/* loaded from: classes.dex */
public class C0463b {

    /* renamed from: a */
    public String f3295a;

    /* renamed from: b */
    public String f3296b;

    /* renamed from: a */
    public static C0463b m3535a(C2468c c2468c) {
        if (c2468c.m15619h("PackageInfo")) {
            return (C0463b) null;
        }
        C2468c m15616e = c2468c.m15616e("PackageInfo");
        C0463b c0463b = new C0463b();
        c0463b.f3295a = C0462a.m3522a(m15616e, "forcedPackageId");
        c0463b.f3296b = C0462a.m3522a(m15616e, "renameManifestPackage");
        return c0463b;
    }

    /* renamed from: b */
    public void m3536b(C2468c c2468c) {
        C2468c c2468c2 = new C2468c();
        C0462a.m3524a(c2468c2, "forcedPackageId", this.f3295a);
        C0462a.m3524a(c2468c2, "renameManifestPackage", this.f3296b);
        c2468c.m15608a("PackageInfo", c2468c2);
    }
}
