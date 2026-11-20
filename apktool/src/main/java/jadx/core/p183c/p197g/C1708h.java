package jadx.core.p183c.p197g;

import jadx.core.p181a.C1548d;
import jadx.core.p181a.C1551g;
import jadx.core.p183c.p184a.InterfaceC1588h;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.C1743l;
import jadx.core.p203d.C1744m;
import jadx.core.p203d.C1745n;
import java.p209io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: DotGraphVisitor.java */
/* renamed from: jadx.core.c.g.h */
/* loaded from: classes.dex */
public class C1708h extends C1669a {

    /* renamed from: a */
    private final boolean f10548a;

    /* renamed from: b */
    private final boolean f10549b;

    /* renamed from: a */
    public static C1708h m13091a() {
        return new C1708h(false, false);
    }

    /* renamed from: b */
    public static C1708h m13093b() {
        return new C1708h(false, true);
    }

    /* renamed from: c */
    public static C1708h m13095c() {
        return new C1708h(true, false);
    }

    private C1708h(boolean z, boolean z2) {
        this.f10548a = z;
        this.f10549b = z2;
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            new a(c1648n.mo12541u().m12668j().m11761b()).m13105a(c1648n);
        }
    }

    /* compiled from: DotGraphVisitor.java */
    /* renamed from: jadx.core.c.g.h$a */
    private class a {

        /* renamed from: b */
        private final C1548d f10551b = new C1548d();

        /* renamed from: c */
        private final C1548d f10552c = new C1548d();

        /* renamed from: d */
        private final File f10553d;

        public a(File file) {
            this.f10553d = file;
        }

        /* renamed from: a */
        public void m13105a(C1648n c1648n) {
            this.f10551b.m11886a("digraph \"CFG for");
            this.f10551b.m11897c(m13099a(c1648n.m12640o() + "." + c1648n.m12617O().m12244c()));
            this.f10551b.m11897c("\" {");
            if (C1708h.this.f10548a) {
                if (c1648n.m12616N() != null) {
                    m13104b(c1648n);
                } else {
                    return;
                }
            } else {
                Iterator<C1628a> it = c1648n.m12647y().iterator();
                while (it.hasNext()) {
                    m13101a(c1648n, it.next(), false);
                }
            }
            this.f10551b.m11886a("MethodNode[shape=record,label=\"{");
            this.f10551b.m11897c(m13099a(c1648n.m12615M().m12189r()));
            this.f10551b.m11897c(m13099a(c1648n.m12636k() + " " + c1648n.m12640o() + "." + c1648n.m12638m() + "(" + C1745n.m13309a((Iterable) c1648n.m12620a(true)) + ") "));
            String m13096a = m13096a((InterfaceC1588h) c1648n);
            if (!m13096a.isEmpty()) {
                this.f10551b.m11897c(" | ").m11897c(m13096a);
            }
            this.f10551b.m11897c("}\"];");
            this.f10551b.m11886a("MethodNode -> ").m11897c(m13097a((InterfaceC1642h) c1648n.m12648z())).m11893b(';');
            this.f10551b.m11897c(this.f10552c.toString());
            this.f10551b.m11883a('}');
            this.f10551b.m11882a();
            this.f10551b.m11890a(this.f10553d, String.valueOf(c1648n.m12640o().m12544x().m12201c()) + "_graphs", String.valueOf(C1744m.m13305b(c1648n.m12617O().m12244c())) + (C1708h.this.f10548a ? ".regions" : "") + (C1708h.this.f10549b ? ".raw" : "") + ".dot");
        }

        /* renamed from: b */
        private void m13104b(C1648n c1648n) {
            m13103a(c1648n, c1648n.m12616N());
            for (C1666c c1666c : c1648n.m12606D()) {
                if (c1666c.m12761f() != null) {
                    m13103a(c1648n, c1666c.m12761f());
                }
            }
            HashSet hashSet = new HashSet(c1648n.m12647y().size());
            C1743l.m13288a(c1648n.m12616N(), hashSet);
            Iterator<C1666c> it = c1648n.m12606D().iterator();
            while (it.hasNext()) {
                InterfaceC1642h m12761f = it.next().m12761f();
                if (m12761f != null) {
                    C1743l.m13288a(m12761f, hashSet);
                }
            }
            for (C1628a c1628a : c1648n.m12647y()) {
                if (!hashSet.contains(c1628a)) {
                    m13101a(c1648n, c1628a, true);
                }
            }
        }

        /* renamed from: a */
        private void m13103a(C1648n c1648n, InterfaceC1642h interfaceC1642h) {
            if (interfaceC1642h instanceof InterfaceC1644j) {
                InterfaceC1644j interfaceC1644j = (InterfaceC1644j) interfaceC1642h;
                this.f10551b.m11886a("subgraph " + m13097a(interfaceC1642h) + " {");
                this.f10551b.m11886a("label = \"").m11897c(interfaceC1644j.toString());
                String m13096a = m13096a((InterfaceC1588h) interfaceC1644j);
                if (!m13096a.isEmpty()) {
                    this.f10551b.m11897c(" | ").m11897c(m13096a);
                }
                this.f10551b.m11897c("\";");
                this.f10551b.m11886a("node [shape=record,color=blue];");
                Iterator<InterfaceC1642h> it = interfaceC1644j.mo12575d().iterator();
                while (it.hasNext()) {
                    m13103a(c1648n, it.next());
                }
                this.f10551b.m11883a('}');
                return;
            }
            if (interfaceC1642h instanceof C1628a) {
                m13101a(c1648n, (C1628a) interfaceC1642h, false);
            } else if (interfaceC1642h instanceof InterfaceC1640f) {
                m13102a(c1648n, (InterfaceC1640f) interfaceC1642h, false);
            }
        }

        /* renamed from: a */
        private void m13101a(C1648n c1648n, C1628a c1628a, boolean z) {
            String m13096a = m13096a((InterfaceC1588h) c1628a);
            this.f10551b.m11886a(m13097a((InterfaceC1642h) c1628a));
            this.f10551b.m11897c(" [shape=record,");
            if (z) {
                this.f10551b.m11897c("color=red,");
            }
            this.f10551b.m11897c("label=\"{");
            this.f10551b.m11897c(String.valueOf(c1628a.m12440d())).m11897c("\\:\\ ");
            this.f10551b.m11897c(C1739h.m13270a(c1628a.m12447k()));
            if (!m13096a.isEmpty()) {
                this.f10551b.m11893b('|').m11897c(m13096a);
            }
            String m13098a = m13098a(c1648n, (InterfaceC1640f) c1628a);
            if (!m13098a.isEmpty()) {
                this.f10551b.m11893b('|').m11897c(m13098a);
            }
            this.f10551b.m11897c("}\"];");
            C1628a c1628a2 = null;
            List<C1646l> mo12446j = c1628a.mo12446j();
            if (!mo12446j.isEmpty() && mo12446j.get(0).m12587o() == EnumC1621l.IF) {
                c1628a2 = ((C1617h) mo12446j.get(0)).m12390k();
            }
            Iterator<C1628a> it = c1628a.m12442f().iterator();
            while (it.hasNext()) {
                C1628a next = it.next();
                m13100a(c1628a, next, next == c1628a2 ? "[style=dashed]" : "");
            }
        }

        /* renamed from: a */
        private void m13102a(C1648n c1648n, InterfaceC1640f interfaceC1640f, boolean z) {
            String m13096a = m13096a((InterfaceC1588h) interfaceC1640f);
            this.f10551b.m11886a(m13097a((InterfaceC1642h) interfaceC1640f));
            this.f10551b.m11897c(" [shape=record,");
            if (z) {
                this.f10551b.m11897c("color=red,");
            }
            this.f10551b.m11897c("label=\"{");
            if (!m13096a.isEmpty()) {
                this.f10551b.m11897c(m13096a);
            }
            String m13098a = m13098a(c1648n, interfaceC1640f);
            if (!m13098a.isEmpty()) {
                this.f10551b.m11893b('|').m11897c(m13098a);
            }
            this.f10551b.m11897c("}\"];");
        }

        /* renamed from: a */
        private void m13100a(C1628a c1628a, C1628a c1628a2, String str) {
            this.f10552c.m11886a(m13097a((InterfaceC1642h) c1628a)).m11897c(" -> ").m11897c(m13097a((InterfaceC1642h) c1628a2));
            this.f10552c.m11897c(str);
            this.f10552c.m11893b(';');
        }

        /* renamed from: a */
        private String m13096a(InterfaceC1588h interfaceC1588h) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = interfaceC1588h.mo12140a().iterator();
            while (it.hasNext()) {
                sb.append(m13099a(it.next())).append("\\l");
            }
            return sb.toString();
        }

        /* renamed from: a */
        private String m13097a(InterfaceC1642h interfaceC1642h) {
            if (interfaceC1642h instanceof C1628a) {
                return "Node_" + ((C1628a) interfaceC1642h).m12440d();
            }
            if (interfaceC1642h instanceof InterfaceC1640f) {
                return "Node_" + interfaceC1642h.getClass().getSimpleName() + "_" + interfaceC1642h.hashCode();
            }
            return "cluster_" + interfaceC1642h.getClass().getSimpleName() + "_" + interfaceC1642h.hashCode();
        }

        /* renamed from: a */
        private String m13098a(C1648n c1648n, InterfaceC1640f interfaceC1640f) {
            if (C1708h.this.f10549b) {
                StringBuilder sb = new StringBuilder();
                for (C1646l c1646l : interfaceC1640f.mo12446j()) {
                    sb.append(m13099a(c1646l + " " + c1646l.m12147b()));
                    sb.append("\\l");
                }
                return sb.toString();
            }
            C1548d c1548d = new C1548d();
            C1551g.m11961a(c1548d, c1648n, (C1646l[]) interfaceC1640f.mo12446j().toArray(new C1646l[0]), false);
            String m13099a = m13099a(c1548d.m11892b().toString());
            if (m13099a.startsWith("\\l")) {
                return m13099a.substring("\\l".length());
            }
            return m13099a;
        }

        /* renamed from: a */
        private String m13099a(String str) {
            return str.replace("\\", "").replace("/", "\\/").replace(">", "\\>").replace("<", "\\<").replace("{", "\\{").replace("}", "\\}").replace("\"", "\\\"").replace("-", "\\-").replace("|", "\\|").replace("\n", "\\l");
        }
    }
}
