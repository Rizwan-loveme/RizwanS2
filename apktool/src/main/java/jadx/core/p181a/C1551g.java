package jadx.core.p181a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p185a.C1565c;
import jadx.core.p183c.p184a.p186b.AbstractC1577k;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1643i;
import jadx.core.p183c.p196f.C1664a;
import jadx.core.p183c.p197g.C1707g;
import jadx.core.p183c.p197g.C1711k;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.p205b.C1724a;
import jadx.core.p203d.p205b.C1725b;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.EnumC1959a;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: MethodGen.java */
/* renamed from: jadx.core.a.g */
/* loaded from: classes.dex */
public class C1551g {

    /* renamed from: a */
    private static final InterfaceC2558b f9939a = C2568c.m15995a((Class<?>) C1551g.class);

    /* renamed from: b */
    private final C1648n f9940b;

    /* renamed from: c */
    private final C1546b f9941c;

    /* renamed from: d */
    private final C1545a f9942d;

    /* renamed from: e */
    private final C1552h f9943e;

    public C1551g(C1546b c1546b, C1648n c1648n) {
        this.f9940b = c1648n;
        this.f9941c = c1546b;
        this.f9942d = c1546b.m11872d();
        this.f9943e = new C1552h(c1648n, c1546b.m11873e());
    }

    /* renamed from: a */
    public C1546b m11963a() {
        return this.f9941c;
    }

    /* renamed from: b */
    public C1552h m11965b() {
        return this.f9943e;
    }

    /* renamed from: c */
    public C1648n m11967c() {
        return this.f9940b;
    }

    /* renamed from: a */
    public boolean m11964a(C1548d c1548d) {
        if (this.f9940b.m12617O().m12250i()) {
            c1548d.m11887a((AbstractC1577k) this.f9940b);
            c1548d.m11886a("static");
            return true;
        }
        if (this.f9940b.mo12149b(EnumC1562a.ANONYMOUS_CONSTRUCTOR)) {
            c1548d.m11882a();
            c1548d.m11887a((AbstractC1577k) this.f9940b);
            return false;
        }
        this.f9942d.m11839a(c1548d, this.f9940b);
        C1589a m12539s = this.f9940b.m12640o().m12539s();
        C1589a m12615M = this.f9940b.m12615M();
        if (m12539s.m12176e()) {
            m12615M = m12615M.m12172b(EnumC1959a.ABSTRACT.m14191a()).m12172b(EnumC1959a.PUBLIC.m14191a());
        }
        if (m12539s.m12177f()) {
            m12615M = m12615M.m12172b(EnumC1959a.PUBLIC.m14191a());
        }
        if (this.f9940b.m12617O().m12252k() && !m12615M.m12181j()) {
            c1548d.m11886a("/* renamed from: ").m11897c(this.f9940b.m12638m()).m11897c(" */");
        }
        c1548d.m11884a(this.f9940b.m12122d());
        c1548d.m11897c(m12615M.m12189r());
        if (this.f9941c.m11866a(c1548d, this.f9940b.m12637l())) {
            c1548d.m11893b(' ');
        }
        if (m12615M.m12181j()) {
            c1548d.m11887a((AbstractC1577k) this.f9940b);
            c1548d.m11897c(this.f9941c.m11862a().m12546z());
        } else {
            this.f9941c.m11865a(c1548d, this.f9940b.m12636k());
            c1548d.m11893b(' ');
            c1548d.m11887a((AbstractC1577k) this.f9940b);
            c1548d.m11897c(this.f9940b.m12639n());
        }
        c1548d.m11893b('(');
        List<C1604i> m12620a = this.f9940b.m12620a(false);
        if (this.f9940b.m12617O().m12249h() && this.f9940b.m12640o().mo12145a((C1566b) C1566b.f10040n)) {
            if (m12620a.size() == 2) {
                m12620a.clear();
            } else if (m12620a.size() > 2) {
                m12620a = m12620a.subList(2, m12620a.size());
            } else {
                f9939a.mo15941c(C1735d.m13256a((InterfaceC1643i) this.f9940b, "Incorrect number of args for enum constructor: " + m12620a.size() + " (expected >= 2)"));
            }
        }
        m11962a(c1548d, m12620a);
        c1548d.m11893b(')');
        this.f9942d.m11841a(this.f9940b, c1548d);
        return true;
    }

    /* renamed from: a */
    private void m11962a(C1548d c1548d, List<C1604i> list) {
        C1565c c1565c = (C1565c) this.f9940b.mo12146b(C1566b.f10043q);
        int i = 0;
        Iterator<C1604i> it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                C1604i next = it.next();
                if (c1565c != null) {
                    this.f9942d.m11837a(c1548d, c1565c, i2);
                }
                C1605j m12331p = next.m12331p();
                if (m12331p != null && m12331p.mo12149b(EnumC1562a.FINAL)) {
                    c1548d.m11897c("final ");
                }
                if (!it.hasNext() && this.f9940b.m12615M().m12185n()) {
                    AbstractC1596a s = next.m12359s();
                    if (s.mo12286l()) {
                        this.f9941c.m11865a(c1548d, s.mo12288n());
                        c1548d.m11897c("...");
                    } else {
                        f9939a.mo15941c(C1735d.m13256a((InterfaceC1643i) this.f9940b, "Last argument in varargs method not array"));
                        this.f9941c.m11865a(c1548d, next.m12359s());
                    }
                } else {
                    this.f9941c.m11865a(c1548d, next.m12359s());
                }
                c1548d.m11893b(' ');
                c1548d.m11897c(this.f9943e.m11983a(next));
                i = i2 + 1;
                if (it.hasNext()) {
                    c1548d.m11897c(", ");
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public void m11966b(C1548d c1548d) {
        if (this.f9940b.mo12145a(C1566b.f10030d) || this.f9940b.mo12149b(EnumC1562a.INCONSISTENT_CODE) || this.f9940b.m12616N() == null) {
            c1548d.m11886a("/*");
            m11968c(c1548d);
            c1548d.m11886a("*/");
            c1548d.m11886a("throw new UnsupportedOperationException(\"Method not decompiled: ").m11897c(this.f9940b.toString()).m11897c("\");");
            return;
        }
        new C1553i(this).m11995a(c1548d, (InterfaceC1642h) this.f9940b.m12616N());
    }

    /* renamed from: c */
    public void m11968c(C1548d c1548d) {
        if (this.f9940b.m12643r() == null) {
            try {
                this.f9940b.m12631f();
                C1707g.m13090a(new C1711k(), this.f9940b);
            } catch (C1725b e2) {
                f9939a.mo15938b("Error reload instructions in fallback mode:", (Throwable) e2);
                c1548d.m11886a("// Can't load method instructions: " + e2.getMessage());
                return;
            }
        }
        C1646l[] m12643r = this.f9940b.m12643r();
        if (m12643r == null) {
            c1548d.m11886a("// Can't load method instructions.");
            return;
        }
        if (this.f9940b.m12635j() != null) {
            c1548d.m11886a(this.f9943e.m11984b(this.f9940b.m12635j())).m11897c(" = this;");
        }
        m11961a(c1548d, this.f9940b, m12643r, true);
    }

    /* renamed from: a */
    public static void m11961a(C1548d c1548d, C1648n c1648n, C1646l[] c1646lArr, boolean z) {
        C1664a c1664a;
        C1550f c1550f = new C1550f(m11959a(c1648n), true);
        for (C1646l c1646l : c1646lArr) {
            if (c1646l != null && c1646l.m12587o() != EnumC1621l.NOP) {
                if (z && (c1646l.mo12145a(C1566b.f10027a) || c1646l.mo12145a(C1566b.f10033g))) {
                    c1548d.m11901e();
                    c1548d.m11886a(String.valueOf(m11960a(c1646l.m12591s())) + ":");
                    c1548d.m11899d();
                }
                try {
                    if (c1550f.m11955a(c1646l, c1548d) && (c1664a = (C1664a) c1646l.mo12146b(C1566b.f10034h)) != null) {
                        c1548d.m11897c("\t " + c1664a);
                    }
                } catch (C1724a e2) {
                    f9939a.mo15933a("Error generate fallback instruction: ", e2.getCause());
                    c1548d.m11886a("// error: " + c1646l);
                }
            }
        }
    }

    /* renamed from: a */
    public static C1551g m11959a(C1648n c1648n) {
        return new C1551g(new C1546b(c1648n.m12640o(), null, true, true, true), c1648n);
    }

    /* renamed from: a */
    public static String m11960a(int i) {
        return "L_" + C1739h.m13270a(i);
    }
}
