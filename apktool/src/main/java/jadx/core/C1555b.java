package jadx.core;

import jadx.core.p181a.C1547c;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.EnumC1649o;
import jadx.core.p183c.p197g.C1707g;
import jadx.core.p183c.p197g.InterfaceC1712l;
import jadx.core.p203d.C1735d;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProcessClass.java */
/* renamed from: jadx.core.b */
/* loaded from: classes.dex */
public final class C1555b {
    /* renamed from: a */
    public static void m12010a(C1636b c1636b, List<InterfaceC1712l> list, C1547c c1547c) {
        if (c1547c != null || c1636b.m12512D() != EnumC1649o.PROCESSED) {
            synchronized (m12008a(c1636b)) {
                try {
                    if (c1636b.m12512D() == EnumC1649o.NOT_LOADED) {
                        c1636b.m12526f();
                        c1636b.m12523a(EnumC1649o.STARTED);
                        Iterator<InterfaceC1712l> it = list.iterator();
                        while (it.hasNext()) {
                            C1707g.m13089a(it.next(), c1636b);
                        }
                        c1636b.m12523a(EnumC1649o.PROCESSED);
                    }
                    if (c1636b.m12512D() == EnumC1649o.PROCESSED && c1547c != null) {
                        m12009a(c1636b, list);
                        c1547c.m11875a(c1636b);
                    }
                } catch (Exception e2) {
                    C1735d.m13255a(c1636b, e2.getClass().getSimpleName(), (Throwable) e2);
                }
            }
        }
    }

    /* renamed from: a */
    public static Object m12008a(C1636b c1636b) {
        return c1636b.m12544x();
    }

    /* renamed from: a */
    private static void m12009a(C1636b c1636b, List<InterfaceC1712l> list) {
        Iterator<C1636b> it = c1636b.m12513E().iterator();
        while (it.hasNext()) {
            m12010a(it.next(), list, null);
        }
    }
}
