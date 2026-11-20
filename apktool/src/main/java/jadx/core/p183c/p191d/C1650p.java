package jadx.core.p183c.p191d;

import jadx.core.clsp.C1719a;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1591c;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1593e;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1744m;
import jadx.core.p203d.p204a.C1722a;
import jadx.core.p203d.p205b.C1727d;
import jadx.core.p203d.p205b.C1729f;
import jadx.core.p203d.p206c.C1732b;
import jadx.core.p203d.p206c.C1733c;
import jadx.core.p207e.C1754e;
import jadx.core.p207e.C1755f;
import jadx.core.p207e.C1756g;
import jadx.p180a.C1534b;
import jadx.p180a.C1541i;
import jadx.p180a.C1543k;
import jadx.p180a.EnumC1542j;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: RootNode.java */
/* renamed from: jadx.core.c.d.p */
/* loaded from: classes.dex */
public class C1650p {

    /* renamed from: a */
    private static final InterfaceC2558b f10403a = C2568c.m15995a((Class<?>) C1650p.class);

    /* renamed from: c */
    private final C1534b f10405c;

    /* renamed from: d */
    private final C1744m f10406d;

    /* renamed from: e */
    private final C1591c f10407e;

    /* renamed from: g */
    private C1719a f10409g;

    /* renamed from: h */
    private List<C1637c> f10410h;

    /* renamed from: i */
    private String f10411i;

    /* renamed from: j */
    private C1636b f10412j;

    /* renamed from: b */
    private final C1735d f10404b = new C1735d();

    /* renamed from: f */
    private final C1593e f10408f = new C1593e();

    public C1650p(C1534b c1534b) {
        this.f10405c = c1534b;
        this.f10406d = new C1744m(c1534b);
        this.f10407e = new C1591c(c1534b);
    }

    /* renamed from: a */
    public void m12657a(List<C1732b> list) {
        this.f10410h = new ArrayList();
        Iterator<C1732b> it = list.iterator();
        while (it.hasNext()) {
            for (C1733c c1733c : it.next().m13246b()) {
                try {
                    f10403a.mo15931a("Load: {}", c1733c);
                    this.f10410h.add(new C1637c(this, c1733c));
                } catch (Exception e2) {
                    throw new C1729f("Error decode file: " + c1733c, e2);
                }
            }
        }
        Iterator<C1637c> it2 = this.f10410h.iterator();
        while (it2.hasNext()) {
            it2.next().m12555a();
        }
        m12649k();
    }

    /* renamed from: b */
    public void m12660b(List<C1541i> list) {
        C1541i c1541i;
        Iterator<C1541i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                c1541i = null;
                break;
            } else {
                c1541i = it.next();
                if (c1541i.m11818b() == EnumC1542j.ARSC) {
                    break;
                }
            }
        }
        if (c1541i == null) {
            f10403a.mo15930a("'.arsc' file not found");
            return;
        }
        final C1755f c1755f = new C1755f();
        try {
            C1543k.m11824a(c1541i, new C1543k.a() { // from class: jadx.core.c.d.p.1
                @Override // jadx.p180a.C1543k.a
                /* renamed from: a */
                public C1754e mo11829a(long j, InputStream inputStream) {
                    c1755f.m13373a(inputStream);
                    return null;
                }
            });
            m12656a(c1755f.m13374c());
        } catch (C1727d e2) {
            f10403a.mo15938b("Failed to parse '.arsc' file", (Throwable) e2);
        }
    }

    /* renamed from: a */
    public void m12656a(C1756g c1756g) {
        this.f10407e.m12219a(c1756g.m13385d());
        this.f10411i = c1756g.m13384c();
        this.f10412j = C1722a.m13221a(this, c1756g);
    }

    /* renamed from: a */
    public void m12655a() {
        try {
            if (this.f10409g == null) {
                C1719a c1719a = new C1719a();
                c1719a.m13178a();
                ArrayList arrayList = new ArrayList();
                Iterator<C1637c> it = this.f10410h.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next().m12559c());
                }
                c1719a.m13180a(arrayList);
                this.f10409g = c1719a;
            }
        } catch (Exception e2) {
            throw new C1729f("Error loading classpath", e2);
        }
    }

    /* renamed from: k */
    private void m12649k() {
        Iterator<C1637c> it = this.f10410h.iterator();
        while (it.hasNext()) {
            it.next().m12558b();
        }
    }

    /* renamed from: a */
    public List<C1636b> m12654a(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (C1637c c1637c : this.f10410h) {
            if (z) {
                arrayList.addAll(c1637c.m12559c());
            } else {
                for (C1636b c1636b : c1637c.m12559c()) {
                    if (!c1636b.m12544x().m12210l()) {
                        arrayList.add(c1636b);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1636b m12650a(C1590b c1590b) {
        Iterator<C1637c> it = this.f10410h.iterator();
        while (it.hasNext()) {
            C1636b m12549a = it.next().m12549a(c1590b);
            if (m12549a != null) {
                return m12549a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1636b m12651a(String str) {
        return m12650a(C1590b.m12193a(this, str));
    }

    /* renamed from: b */
    public List<C1636b> m12659b(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<C1637c> it = this.f10410h.iterator();
        while (it.hasNext()) {
            for (C1636b c1636b : it.next().m12559c()) {
                if (c1636b.m12544x().m12203e().equals(str)) {
                    arrayList.add(c1636b);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1648n m12653a(C1594f c1594f) {
        C1636b m12650a = m12650a(c1594f.m12245d());
        if (m12650a == null) {
            return null;
        }
        return m12650a.mo12540t().m12554a(m12650a, c1594f.m12240a(false));
    }

    /* renamed from: a */
    public C1639e m12652a(C1592d c1592d) {
        C1636b m12650a = m12650a(c1592d.m12228c());
        if (m12650a == null) {
            return null;
        }
        return m12650a.mo12540t().m12552a(m12650a, c1592d);
    }

    /* renamed from: b */
    public List<C1637c> m12658b() {
        return this.f10410h;
    }

    /* renamed from: c */
    public C1719a m12661c() {
        return this.f10409g;
    }

    /* renamed from: d */
    public C1735d m12662d() {
        return this.f10404b;
    }

    /* renamed from: e */
    public String m12663e() {
        return this.f10411i;
    }

    /* renamed from: f */
    public C1636b m12664f() {
        return this.f10412j;
    }

    /* renamed from: g */
    public C1744m m12665g() {
        return this.f10406d;
    }

    /* renamed from: h */
    public C1591c m12666h() {
        return this.f10407e;
    }

    /* renamed from: i */
    public C1593e m12667i() {
        return this.f10408f;
    }

    /* renamed from: j */
    public C1534b m12668j() {
        return this.f10405c;
    }
}
