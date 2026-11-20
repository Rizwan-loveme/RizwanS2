package jadx.core.p183c.p197g.p202d;

import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1735d;
import java.util.Iterator;

/* compiled from: CheckTypeVisitor.java */
/* renamed from: jadx.core.c.g.d.a */
/* loaded from: classes.dex */
public class C1700a {
    /* renamed from: a */
    public static void m13067a(C1648n c1648n, C1646l c1646l) {
        if (c1646l.m12588p() != null && !c1646l.m12588p().m12359s().mo12276b()) {
            m13068a("Wrong return type", c1648n, c1646l);
            return;
        }
        Iterator<AbstractC1598c> it = c1646l.m12589q().iterator();
        while (it.hasNext()) {
            if (!it.next().m12359s().mo12276b()) {
                m13068a("Wrong type", c1648n, c1646l);
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m13068a(String str, C1648n c1648n, C1646l c1646l) {
        C1735d.m13258a(c1648n, String.valueOf(str) + ": " + c1646l);
    }
}
