package jadx.core.p203d;

import jadx.core.p181a.C1548d;
import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.C1566b;
import java.util.Iterator;

/* compiled from: CodegenUtils.java */
/* renamed from: jadx.core.d.b */
/* loaded from: classes.dex */
public class C1723b {
    /* renamed from: a */
    public static void m13225a(C1548d c1548d, AbstractC1584d abstractC1584d) {
        Iterator it = abstractC1584d.mo12150c(C1566b.f10032f).iterator();
        while (it.hasNext()) {
            c1548d.m11886a("/* ").m11897c((String) it.next()).m11897c(" */");
        }
    }
}
