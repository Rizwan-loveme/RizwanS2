package jadx.core.p203d;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.InterfaceC1588h;
import jadx.core.p183c.p184a.p186b.C1574h;
import jadx.core.p183c.p184a.p186b.C1575i;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1643i;
import jadx.core.p203d.p205b.C1728e;
import java.util.HashSet;
import java.util.Set;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ErrorsCounter.java */
/* renamed from: jadx.core.d.d */
/* loaded from: classes.dex */
public class C1735d {

    /* renamed from: a */
    private static final InterfaceC2558b f10590a = C2568c.m15995a((Class<?>) C1735d.class);

    /* renamed from: c */
    private int f10592c;

    /* renamed from: e */
    private int f10594e;

    /* renamed from: b */
    private final Set<InterfaceC1588h> f10591b = new HashSet();

    /* renamed from: d */
    private final Set<InterfaceC1588h> f10593d = new HashSet();

    /* renamed from: a */
    private synchronized <N extends InterfaceC1643i & InterfaceC1588h> String m13257a(N n, String str, Throwable th) {
        String m13256a;
        this.f10591b.add(n);
        this.f10592c++;
        m13256a = m13256a(n, str);
        if (th == null) {
            f10590a.mo15945d(m13256a);
        } else if (th instanceof C1728e) {
            C1728e c1728e = new C1728e(th.getMessage());
            f10590a.mo15943c("{}, details: {}", m13256a, c1728e.getMessage());
            th = c1728e;
        } else {
            f10590a.mo15938b(m13256a, th);
        }
        n.mo12142a(C1566b.f10030d, new C1574h(str, th));
        n.mo12151c(EnumC1562a.INCONSISTENT_CODE);
        return m13256a;
    }

    /* renamed from: b */
    private synchronized <N extends InterfaceC1643i & InterfaceC1588h> String m13260b(N n, String str) {
        String m13256a;
        this.f10593d.add(n);
        this.f10594e++;
        n.mo12142a(C1566b.f10031e, new C1575i(str));
        if (!n.mo12145a(C1566b.f10030d)) {
            n.mo12141a(EnumC1562a.INCONSISTENT_CODE);
        }
        m13256a = m13256a(n, str);
        f10590a.mo15941c(m13256a);
        return m13256a;
    }

    /* renamed from: a */
    public static String m13255a(C1636b c1636b, String str, Throwable th) {
        return c1636b.mo12540t().mo12541u().m12662d().m13257a((C1735d) c1636b, str, th);
    }

    /* renamed from: a */
    public static String m13254a(C1636b c1636b, String str) {
        return c1636b.mo12540t().mo12541u().m12662d().m13260b(c1636b, str);
    }

    /* renamed from: a */
    public static String m13259a(C1648n c1648n, String str, Throwable th) {
        return c1648n.mo12541u().m12662d().m13257a((C1735d) c1648n, str, th);
    }

    /* renamed from: a */
    public static String m13258a(C1648n c1648n, String str) {
        return c1648n.mo12541u().m12662d().m13260b(c1648n, str);
    }

    /* renamed from: a */
    public static String m13256a(InterfaceC1643i interfaceC1643i, String str) {
        return String.valueOf(str) + " in " + interfaceC1643i.mo12542v() + ": " + interfaceC1643i + ", dex: " + interfaceC1643i.mo12540t().m12560d().m13247a();
    }
}
