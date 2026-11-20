package jadx.core.p181a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1588h;
import jadx.core.p183c.p184a.p185a.C1563a;
import jadx.core.p183c.p184a.p185a.C1564b;
import jadx.core.p183c.p184a.p185a.C1565c;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1744m;
import jadx.core.p203d.p205b.C1729f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: AnnotationGen.java */
/* renamed from: jadx.core.a.a */
/* loaded from: classes.dex */
public class C1545a {

    /* renamed from: a */
    private final C1636b f9900a;

    /* renamed from: b */
    private final C1546b f9901b;

    public C1545a(C1636b c1636b, C1546b c1546b) {
        this.f9900a = c1636b;
        this.f9901b = c1546b;
    }

    /* renamed from: a */
    public void m11836a(C1548d c1548d) {
        m11834a(this.f9900a, c1548d);
    }

    /* renamed from: a */
    public void m11839a(C1548d c1548d, C1648n c1648n) {
        m11834a((InterfaceC1588h) c1648n, c1548d);
    }

    /* renamed from: a */
    public void m11838a(C1548d c1548d, C1639e c1639e) {
        m11834a(c1639e, c1548d);
    }

    /* renamed from: a */
    public void m11837a(C1548d c1548d, C1565c c1565c, int i) {
        C1564b c1564b;
        List<C1564b> m12087a = c1565c.m12087a();
        if (i < m12087a.size() && (c1564b = m12087a.get(i)) != null && !c1564b.m12086c()) {
            Iterator<C1563a> it = c1564b.m12084a().iterator();
            while (it.hasNext()) {
                m11833a(c1548d, it.next());
                c1548d.m11893b(' ');
            }
        }
    }

    /* renamed from: a */
    private void m11834a(InterfaceC1588h interfaceC1588h, C1548d c1548d) {
        C1564b c1564b = (C1564b) interfaceC1588h.mo12146b(C1566b.f10042p);
        if (c1564b != null && !c1564b.m12086c()) {
            for (C1563a c1563a : c1564b.m12084a()) {
                if (!c1563a.m12080b().startsWith("dalvik.annotation.")) {
                    c1548d.m11882a();
                    m11833a(c1548d, c1563a);
                }
            }
        }
    }

    /* renamed from: a */
    private void m11833a(C1548d c1548d, C1563a c1563a) {
        c1548d.m11893b('@');
        this.f9901b.m11865a(c1548d, c1563a.m12079a());
        Map<String, Object> m12081c = c1563a.m12081c();
        if (!m12081c.isEmpty()) {
            c1548d.m11893b('(');
            if (m12081c.size() == 1 && m12081c.containsKey("value")) {
                m11840a(c1548d, m12081c.get("value"));
            } else {
                Iterator<Map.Entry<String, Object>> it = m12081c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Object> next = it.next();
                    c1548d.m11897c(next.getKey());
                    c1548d.m11897c(" = ");
                    m11840a(c1548d, next.getValue());
                    if (it.hasNext()) {
                        c1548d.m11897c(", ");
                    }
                }
            }
            c1548d.m11893b(')');
        }
    }

    /* renamed from: a */
    public void m11841a(C1648n c1648n, C1548d c1548d) {
        C1563a a2 = c1648n.mo12139a("dalvik.annotation.Throws");
        if (a2 != null) {
            Object m12082d = a2.m12082d();
            c1548d.m11897c(" throws ");
            Iterator it = ((List) m12082d).iterator();
            while (it.hasNext()) {
                this.f9901b.m11865a(c1548d, (AbstractC1596a) it.next());
                if (it.hasNext()) {
                    c1548d.m11897c(", ");
                }
            }
        }
    }

    /* renamed from: a */
    public Object m11835a(String str) {
        C1563a a2 = this.f9900a.mo12139a("dalvik.annotation.AnnotationDefault");
        if (a2 != null) {
            return ((C1563a) a2.m12082d()).m12081c().get(str);
        }
        return null;
    }

    /* renamed from: a */
    public void m11840a(C1548d c1548d, Object obj) {
        if (obj == null) {
            c1548d.m11897c("null");
            return;
        }
        if (obj instanceof String) {
            c1548d.m11897c(m11832a().m13308a((String) obj));
            return;
        }
        if (obj instanceof Integer) {
            c1548d.m11897c(C1554j.m12000a(((Integer) obj).intValue()));
            return;
        }
        if (obj instanceof Character) {
            c1548d.m11897c(m11832a().m13307a(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof Boolean) {
            c1548d.m11897c(Boolean.TRUE.equals(obj) ? "true" : "false");
            return;
        }
        if (obj instanceof Float) {
            c1548d.m11897c(C1554j.m11999a(((Float) obj).floatValue()));
            return;
        }
        if (obj instanceof Double) {
            c1548d.m11897c(C1554j.m11998a(((Double) obj).doubleValue()));
            return;
        }
        if (obj instanceof Long) {
            c1548d.m11897c(C1554j.m12001a(((Long) obj).longValue()));
            return;
        }
        if (obj instanceof Short) {
            c1548d.m11897c(C1554j.m12006a(((Short) obj).shortValue()));
            return;
        }
        if (obj instanceof Byte) {
            c1548d.m11897c(C1554j.m11997a(((Byte) obj).byteValue()));
            return;
        }
        if (obj instanceof AbstractC1596a) {
            this.f9901b.m11865a(c1548d, (AbstractC1596a) obj);
            c1548d.m11897c(".class");
            return;
        }
        if (obj instanceof C1592d) {
            C1550f.m11928a(c1548d, (C1592d) obj, this.f9901b);
            return;
        }
        if (obj instanceof Iterable) {
            c1548d.m11893b('{');
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                m11840a(c1548d, it.next());
                if (it.hasNext()) {
                    c1548d.m11897c(", ");
                }
            }
            c1548d.m11893b('}');
            return;
        }
        if (obj instanceof C1563a) {
            m11833a(c1548d, (C1563a) obj);
            return;
        }
        throw new C1729f("Can't decode value: " + obj + " (" + obj.getClass() + ")");
    }

    /* renamed from: a */
    private C1744m m11832a() {
        return this.f9900a.mo12540t().mo12541u().m12665g();
    }
}
