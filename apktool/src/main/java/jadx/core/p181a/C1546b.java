package jadx.core.p181a;

import jadx.core.p181a.C1550f;
import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.AbstractC1577k;
import jadx.core.p183c.p184a.p186b.C1569c;
import jadx.core.p183c.p184a.p186b.C1574h;
import jadx.core.p183c.p184a.p186b.C1575i;
import jadx.core.p183c.p184a.p186b.C1582p;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.EnumC1603h;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.p192a.C1632d;
import jadx.core.p203d.C1723b;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1745n;
import jadx.p180a.C1534b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.p226d.p233b.EnumC1959a;

/* compiled from: ClassGen.java */
/* renamed from: jadx.core.a.b */
/* loaded from: classes.dex */
public class C1546b {

    /* renamed from: a */
    private final C1636b f9902a;

    /* renamed from: b */
    private final C1546b f9903b;

    /* renamed from: c */
    private final C1545a f9904c;

    /* renamed from: d */
    private final boolean f9905d;

    /* renamed from: e */
    private final boolean f9906e;

    /* renamed from: f */
    private final boolean f9907f;

    /* renamed from: g */
    private final Set<C1590b> f9908g;

    /* renamed from: h */
    private int f9909h;

    public C1546b(C1636b c1636b, C1534b c1534b) {
        this(c1636b, null, c1534b.m11774i(), c1534b.m11772g(), c1534b.m11773h());
    }

    public C1546b(C1636b c1636b, C1546b c1546b) {
        this(c1636b, c1546b, c1546b.f9906e, c1546b.f9905d, c1546b.f9907f);
    }

    public C1546b(C1636b c1636b, C1546b c1546b, boolean z, boolean z2, boolean z3) {
        this.f9908g = new HashSet();
        this.f9902a = c1636b;
        this.f9903b = c1546b;
        this.f9905d = z2;
        this.f9906e = z;
        this.f9907f = z3;
        this.f9904c = new C1545a(c1636b, this);
    }

    /* renamed from: a */
    public C1636b m11862a() {
        return this.f9902a;
    }

    /* renamed from: b */
    public C1548d m11867b() {
        C1548d c1548d = new C1548d();
        m11863a(c1548d);
        C1548d c1548d2 = new C1548d();
        if (!"".equals(this.f9902a.m12510B())) {
            c1548d2.m11897c("package ").m11897c(this.f9902a.m12510B()).m11893b(';');
            c1548d2.m11892b();
        }
        if (this.f9908g.size() != 0) {
            ArrayList<C1590b> arrayList = new ArrayList(this.f9908g);
            Collections.sort(arrayList, new Comparator<C1590b>() { // from class: jadx.core.a.b.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(C1590b c1590b, C1590b c1590b2) {
                    return c1590b.m12199b().m12202d().compareTo(c1590b2.m12199b().m12202d());
                }
            });
            for (C1590b c1590b : arrayList) {
                c1548d2.m11886a("import ");
                C1636b m12650a = this.f9902a.mo12541u().m12650a(c1590b);
                if (m12650a != null) {
                    c1548d2.m11891a((Object) m12650a);
                }
                c1548d2.m11897c(c1590b.m12199b().m12202d());
                c1548d2.m11893b(';');
            }
            c1548d2.m11892b();
            this.f9908g.clear();
        }
        c1548d2.m11885a(c1548d);
        return c1548d2;
    }

    /* renamed from: a */
    public void m11863a(C1548d c1548d) {
        if (!this.f9902a.mo12149b(EnumC1562a.DONT_GENERATE)) {
            C1723b.m13225a(c1548d, this.f9902a);
            m11845a(c1548d, (AbstractC1584d) this.f9902a);
            m11868b(c1548d);
            m11871c(c1548d);
        }
    }

    /* renamed from: b */
    public void m11868b(C1548d c1548d) {
        C1589a m12539s = this.f9902a.m12539s();
        if (m12539s.m12176e()) {
            m12539s = m12539s.m12172b(EnumC1959a.ABSTRACT.m14191a()).m12169a(EnumC1959a.STATIC);
        } else if (m12539s.m12182k()) {
            m12539s = m12539s.m12169a(EnumC1959a.FINAL).m12169a(EnumC1959a.ABSTRACT).m12169a(EnumC1959a.STATIC);
        }
        if (!this.f9902a.m12545y().m12210l()) {
            m12539s = m12539s.m12169a(EnumC1959a.STATIC).m12169a(EnumC1959a.PRIVATE);
        }
        this.f9904c.m11836a(c1548d);
        m11851b(c1548d, (AbstractC1584d) this.f9902a);
        m11852b(c1548d, this.f9902a);
        c1548d.m11886a(m12539s.m12189r());
        if (m12539s.m12176e()) {
            if (m12539s.m12177f()) {
                c1548d.m11893b('@');
            }
            c1548d.m11897c("interface ");
        } else if (m12539s.m12182k()) {
            c1548d.m11897c("enum ");
        } else {
            c1548d.m11897c("class ");
        }
        c1548d.m11887a((AbstractC1577k) this.f9902a);
        c1548d.m11897c(this.f9902a.m12546z());
        m11866a(c1548d, this.f9902a.m12529i());
        c1548d.m11893b(' ');
        AbstractC1596a m12527g = this.f9902a.m12527g();
        if (m12527g != null && !m12527g.equals(AbstractC1596a.f10134j) && !m12527g.mo12279e().equals(AbstractC1596a.f10137m.mo12279e())) {
            c1548d.m11897c("extends ");
            m11869b(c1548d, m12527g);
            c1548d.m11893b(' ');
        }
        if (!this.f9902a.m12528h().isEmpty() && !m12539s.m12177f()) {
            if (this.f9902a.m12539s().m12176e()) {
                c1548d.m11897c("extends ");
            } else {
                c1548d.m11897c("implements ");
            }
            Iterator<AbstractC1596a> it = this.f9902a.m12528h().iterator();
            while (it.hasNext()) {
                m11869b(c1548d, it.next());
                if (it.hasNext()) {
                    c1548d.m11897c(", ");
                }
            }
            if (!this.f9902a.m12528h().isEmpty()) {
                c1548d.m11893b(' ');
            }
        }
    }

    /* renamed from: a */
    public boolean m11866a(C1548d c1548d, Map<AbstractC1596a, List<AbstractC1596a>> map) {
        int i = 0;
        if (map == null || map.isEmpty()) {
            return false;
        }
        c1548d.m11893b('<');
        Iterator<Map.Entry<AbstractC1596a, List<AbstractC1596a>>> it = map.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Map.Entry<AbstractC1596a, List<AbstractC1596a>> next = it.next();
                AbstractC1596a key = next.getKey();
                List<AbstractC1596a> value = next.getValue();
                if (i2 != 0) {
                    c1548d.m11897c(", ");
                }
                if (key.mo12282h()) {
                    c1548d.m11897c(key.mo12279e());
                } else {
                    m11869b(c1548d, key);
                }
                if (value != null && !value.isEmpty()) {
                    c1548d.m11897c(" extends ");
                    Iterator<AbstractC1596a> it2 = value.iterator();
                    while (it2.hasNext()) {
                        AbstractC1596a next2 = it2.next();
                        if (next2.mo12282h()) {
                            c1548d.m11897c(next2.mo12279e());
                        } else {
                            m11869b(c1548d, next2);
                        }
                        if (it2.hasNext()) {
                            c1548d.m11897c(" & ");
                        }
                    }
                }
                i = i2 + 1;
            } else {
                c1548d.m11893b('>');
                return true;
            }
        }
    }

    /* renamed from: c */
    public void m11871c(C1548d c1548d) {
        c1548d.m11893b('{');
        this.f9909h = c1548d.m11904g();
        c1548d.m11899d();
        m11856e(c1548d);
        m11846a(c1548d, this.f9902a);
        m11855d(c1548d);
        c1548d.m11901e();
        c1548d.m11883a('}');
    }

    /* renamed from: a */
    private void m11846a(C1548d c1548d, C1636b c1636b) {
        for (C1636b c1636b2 : c1636b.m12534n()) {
            if (!c1636b2.mo12149b(EnumC1562a.DONT_GENERATE) && !c1636b2.mo12149b(EnumC1562a.ANONYMOUS_CLASS)) {
                C1546b c1546b = new C1546b(c1636b2, m11870c());
                c1548d.m11892b();
                c1546b.m11863a(c1548d);
                this.f9908g.addAll(c1546b.m11861i());
            }
        }
    }

    /* renamed from: f */
    private boolean m11858f() {
        Iterator<C1636b> it = this.f9902a.m12534n().iterator();
        while (it.hasNext()) {
            if (!it.next().mo12149b(EnumC1562a.ANONYMOUS_CLASS)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private void m11855d(C1548d c1548d) {
        for (C1648n c1648n : m11844a(this.f9902a.m12530j())) {
            if (!c1648n.mo12149b(EnumC1562a.DONT_GENERATE)) {
                if (c1548d.m11904g() != this.f9909h) {
                    c1548d.m11892b();
                }
                int m11903f = c1548d.m11903f();
                try {
                    m11847a(c1548d, c1648n);
                } catch (Exception e2) {
                    c1548d.m11892b().m11897c("/*");
                    c1548d.m11892b().m11897c(C1735d.m13259a(c1648n, "Method generation error", (Throwable) e2));
                    c1548d.m11892b().m11897c(C1745n.m13312a(e2));
                    c1548d.m11892b().m11897c("*/");
                    c1548d.m11900d(m11903f);
                }
            }
        }
    }

    /* renamed from: a */
    private static List<C1648n> m11844a(List<C1648n> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: g */
    private boolean m11859g() {
        Iterator<C1648n> it = this.f9902a.m12530j().iterator();
        while (it.hasNext()) {
            if (!it.next().mo12149b(EnumC1562a.DONT_GENERATE)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m11847a(C1548d c1548d, C1648n c1648n) {
        Object m11835a;
        C1551g m11959a;
        if (c1648n.m12615M().m12175d() || c1648n.m12615M().m12178g()) {
            new C1551g(this, c1648n).m11964a(c1548d);
            if (this.f9902a.m12539s().m12177f() && (m11835a = this.f9904c.m11835a(c1648n.m12638m())) != null) {
                c1548d.m11897c(" default ");
                this.f9904c.m11840a(c1548d, m11835a);
            }
            c1548d.m11893b(';');
            return;
        }
        C1723b.m13225a(c1548d, c1648n);
        m11845a(c1548d, (AbstractC1584d) c1648n);
        boolean b2 = c1648n.mo12149b(EnumC1562a.INCONSISTENT_CODE);
        if (b2 && this.f9907f) {
            c1548d.m11886a("/* Code decompiled incorrectly, please refer to instructions dump. */");
            c1648n.mo12151c(EnumC1562a.INCONSISTENT_CODE);
            b2 = false;
        }
        if (b2 || c1648n.mo12145a(C1566b.f10030d) || this.f9905d) {
            m11959a = C1551g.m11959a(c1648n);
        } else {
            m11959a = new C1551g(this, c1648n);
        }
        if (m11959a.m11964a(c1548d)) {
            c1548d.m11893b(' ');
        }
        c1548d.m11893b('{');
        c1548d.m11899d();
        m11851b(c1548d, c1648n);
        if (this.f9905d) {
            m11959a.m11968c(c1548d);
        } else {
            m11959a.m11966b(c1548d);
        }
        c1548d.m11901e();
        c1548d.m11883a('}');
    }

    /* renamed from: a */
    private void m11845a(C1548d c1548d, AbstractC1584d abstractC1584d) {
        List<C1574h> mo12150c = abstractC1584d.mo12150c(C1566b.f10030d);
        List mo12150c2 = abstractC1584d.mo12150c(C1566b.f10031e);
        if (!mo12150c.isEmpty()) {
            for (C1574h c1574h : mo12150c) {
                c1548d.m11886a("/*  JADX ERROR: ").m11897c(c1574h.m12113a());
                Throwable m12114b = c1574h.m12114b();
                if (m12114b != null) {
                    c1548d.m11899d();
                    C1745n.m13315a(c1548d, m12114b);
                    c1548d.m11901e();
                }
                c1548d.m11897c("*/");
            }
        }
        if (!mo12150c2.isEmpty()) {
            Iterator it = mo12150c2.iterator();
            while (it.hasNext()) {
                c1548d.m11886a("/* JADX WARNING: ").m11894b(((C1575i) it.next()).m12115a()).m11897c(" */");
            }
        }
    }

    /* renamed from: e */
    private void m11856e(C1548d c1548d) {
        m11857f(c1548d);
        for (C1639e c1639e : this.f9902a.m12531k()) {
            if (!c1639e.mo12149b(EnumC1562a.DONT_GENERATE)) {
                C1723b.m13225a(c1548d, c1639e);
                this.f9904c.m11838a(c1548d, c1639e);
                if (c1639e.m12565f().m12231f()) {
                    c1548d.m11886a("/* renamed from: ").m11897c(c1639e.m12567h()).m11897c(" */");
                }
                c1548d.m11886a(c1639e.m12566g().m12189r());
                m11865a(c1548d, c1639e.m12569j());
                c1548d.m11893b(' ');
                c1548d.m11887a((AbstractC1577k) c1639e);
                c1548d.m11897c(c1639e.m12568i());
                C1632d c1632d = (C1632d) c1639e.mo12146b(C1566b.f10037k);
                if (c1632d != null) {
                    c1548d.m11897c(" = ");
                    if (c1632d.m12470a() == null) {
                        c1548d.m11897c(C1554j.m12003a(0L, c1639e.m12569j(), this.f9902a));
                    } else if (c1632d.m12472d() == C1632d.a.CONST) {
                        this.f9904c.m11840a(c1548d, c1632d.m12470a());
                    } else if (c1632d.m12472d() == C1632d.a.INSN) {
                        m11848a(m11842a(c1632d.m12473e()), c1548d, c1632d.m12471c());
                    }
                }
                c1548d.m11893b(';');
            }
        }
    }

    /* renamed from: h */
    private boolean m11860h() {
        Iterator<C1639e> it = this.f9902a.m12531k().iterator();
        while (it.hasNext()) {
            if (!it.next().mo12149b(EnumC1562a.DONT_GENERATE)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m11857f(C1548d c1548d) {
        C1569c c1569c = (C1569c) this.f9902a.mo12146b(C1566b.f10040n);
        if (c1569c != null) {
            C1550f c1550f = null;
            Iterator<C1569c.a> it = c1569c.m12094a().iterator();
            while (it.hasNext()) {
                C1569c.a next = it.next();
                c1548d.m11886a(next.m12097a().m12229d());
                C1610a m12099b = next.m12099b();
                if (m12099b.m12590r() > next.m12100c()) {
                    if (c1550f == null) {
                        c1550f = m11842a(c1569c.m12096c());
                    }
                    c1550f.m11954a(c1548d, m12099b, next.m12100c(), this.f9902a.mo12540t().m12553a(m12099b.m12363f()));
                }
                if (next.m12101d() != null) {
                    c1548d.m11893b(' ');
                    new C1546b(next.m12101d(), this).m11871c(c1548d);
                }
                if (it.hasNext()) {
                    c1548d.m11893b(',');
                }
            }
            if (m11859g() || m11860h() || m11858f()) {
                if (c1569c.m12094a().isEmpty()) {
                    c1548d.m11882a();
                }
                c1548d.m11893b(';');
                if (m11860h()) {
                    c1548d.m11882a();
                }
            }
        }
    }

    /* renamed from: a */
    private C1550f m11842a(C1648n c1648n) {
        return new C1550f(new C1551g(this, c1648n), false);
    }

    /* renamed from: a */
    private void m11848a(C1550f c1550f, C1548d c1548d, C1646l c1646l) {
        try {
            c1550f.m11956a(c1646l, c1548d, C1550f.a.BODY_ONLY_NOWRAP);
        } catch (Exception e2) {
            C1735d.m13255a(this.f9902a, "Failed to generate init code", (Throwable) e2);
        }
    }

    /* renamed from: a */
    public void m11865a(C1548d c1548d, AbstractC1596a abstractC1596a) {
        EnumC1603h mo12277c = abstractC1596a.mo12277c();
        if (mo12277c == null) {
            c1548d.m11897c(abstractC1596a.toString());
            return;
        }
        if (mo12277c == EnumC1603h.OBJECT) {
            if (abstractC1596a.mo12282h()) {
                c1548d.m11897c(abstractC1596a.mo12279e());
                return;
            } else {
                m11869b(c1548d, abstractC1596a);
                return;
            }
        }
        if (mo12277c == EnumC1603h.ARRAY) {
            m11865a(c1548d, abstractC1596a.mo12288n());
            c1548d.m11897c("[]");
        } else {
            c1548d.m11897c(mo12277c.m12323b());
        }
    }

    /* renamed from: b */
    public void m11869b(C1548d c1548d, AbstractC1596a abstractC1596a) {
        m11864a(c1548d, C1590b.m12195b(this.f9902a.mo12541u(), abstractC1596a));
        AbstractC1596a[] mo12283i = abstractC1596a.mo12283i();
        if (mo12283i != null) {
            c1548d.m11893b('<');
            int length = mo12283i.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    c1548d.m11897c(", ");
                }
                AbstractC1596a abstractC1596a2 = mo12283i[i];
                AbstractC1596a mo12284j = abstractC1596a2.mo12284j();
                if (mo12284j != null) {
                    c1548d.m11893b('?');
                    int mo12285k = abstractC1596a2.mo12285k();
                    if (mo12285k != 0) {
                        c1548d.m11897c(mo12285k == -1 ? " super " : " extends ");
                        m11865a(c1548d, mo12284j);
                    }
                } else {
                    m11865a(c1548d, abstractC1596a2);
                }
            }
            c1548d.m11893b('>');
        }
    }

    /* renamed from: a */
    public void m11864a(C1548d c1548d, C1590b c1590b) {
        C1636b m12557b = this.f9902a.mo12540t().m12557b(c1590b);
        if (m12557b != null) {
            c1548d.m11891a((Object) m12557b);
        }
        c1548d.m11897c(m11843a(this.f9902a.m12545y(), c1590b.m12199b()));
    }

    /* renamed from: a */
    private String m11843a(C1590b c1590b, C1590b c1590b2) {
        String m12202d = c1590b2.m12202d();
        if (!this.f9905d && this.f9906e) {
            String m12203e = c1590b2.m12203e();
            if ((!c1590b2.m12204f().equals("java.lang") || c1590b2.m12208j() != null) && !m11854c(c1590b, c1590b2) && !m11853b(c1590b, c1590b2)) {
                if (c1590b2.m12204f().equals(c1590b.m12204f()) && !c1590b2.m12210l()) {
                    return m12203e;
                }
                C1636b m12557b = this.f9902a.mo12540t().m12557b(c1590b2);
                if (m12557b != null && !m12557b.m12539s().m12170a()) {
                    return m12203e;
                }
                if (!m11850a(this.f9902a.mo12540t(), c1590b, c1590b2)) {
                    if (c1590b2.m12205g()) {
                        return m12203e;
                    }
                    String m12207i = c1590b2.m12204f().equals(c1590b.m12204f()) ? c1590b2.m12207i() : m12202d;
                    for (C1590b c1590b3 : m11861i()) {
                        if (!c1590b3.equals(c1590b2) && c1590b3.m12203e().equals(m12203e)) {
                            return c1590b2.m12210l() ? String.valueOf(m11843a(c1590b, c1590b2.m12208j().m12199b())) + "." + m12203e : m12207i;
                        }
                    }
                    m11849a(c1590b2);
                    return m12203e;
                }
                return m12202d;
            }
            return m12203e;
        }
        return m12202d;
    }

    /* renamed from: a */
    private void m11849a(C1590b c1590b) {
        if (this.f9903b != null) {
            this.f9903b.m11849a(c1590b.m12199b());
        } else {
            this.f9908g.add(c1590b);
        }
    }

    /* renamed from: i */
    private Set<C1590b> m11861i() {
        return this.f9903b != null ? this.f9903b.m11861i() : this.f9908g;
    }

    /* renamed from: b */
    private static boolean m11853b(C1590b c1590b, C1590b c1590b2) {
        C1590b m12209k = c1590b.m12209k();
        C1590b m12209k2 = c1590b2.m12209k();
        return m12209k != null ? m12209k.equals(m12209k2) : c1590b.equals(m12209k2);
    }

    /* renamed from: c */
    private static boolean m11854c(C1590b c1590b, C1590b c1590b2) {
        if (!c1590b.m12210l()) {
            return false;
        }
        C1590b m12208j = c1590b.m12208j();
        return m12208j.equals(c1590b2) || m11854c(m12208j, c1590b2);
    }

    /* renamed from: a */
    private static boolean m11850a(C1637c c1637c, C1590b c1590b, C1590b c1590b2) {
        if (c1590b == null) {
            return false;
        }
        String m12203e = c1590b2.m12203e();
        if (c1590b.m12203e().equals(m12203e)) {
            return true;
        }
        C1636b m12557b = c1637c.m12557b(c1590b);
        if (m12557b != null) {
            for (C1636b c1636b : m12557b.m12534n()) {
                if (c1636b.m12546z().equals(m12203e) && !c1636b.m12545y().equals(c1590b2)) {
                    return true;
                }
            }
        }
        return m11850a(c1637c, c1590b.m12208j(), c1590b2);
    }

    /* renamed from: b */
    private void m11851b(C1548d c1548d, AbstractC1584d abstractC1584d) {
        C1582p c1582p = (C1582p) abstractC1584d.mo12146b(C1566b.f10045s);
        if (c1582p != null) {
            c1548d.m11886a("/* compiled from: ").m11897c(c1582p.m12136a()).m11897c(" */");
        }
    }

    /* renamed from: b */
    private void m11852b(C1548d c1548d, C1636b c1636b) {
        C1590b m12544x = c1636b.m12544x();
        if (m12544x.m12198a()) {
            c1548d.m11886a("/* renamed from: ").m11897c(m12544x.m12211m().mo12279e()).m11897c(" */");
        }
    }

    /* renamed from: c */
    public C1546b m11870c() {
        return this.f9903b == null ? this : this.f9903b;
    }

    /* renamed from: d */
    public C1545a m11872d() {
        return this.f9904c;
    }

    /* renamed from: e */
    public boolean m11873e() {
        return this.f9905d;
    }
}
