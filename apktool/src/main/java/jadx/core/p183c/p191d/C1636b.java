package jadx.core.p183c.p191d;

import com.p129f.p130a.p133c.AbstractC1208w;
import jadx.core.p181a.C1548d;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p184a.p185a.C1563a;
import jadx.core.p183c.p184a.p186b.AbstractC1577k;
import jadx.core.p183c.p184a.p186b.C1582p;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p191d.p192a.C1629a;
import jadx.core.p183c.p191d.p192a.C1632d;
import jadx.core.p183c.p191d.p192a.C1634f;
import jadx.core.p183c.p191d.p192a.C1635g;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ClassNode.java */
/* renamed from: jadx.core.c.d.b */
/* loaded from: classes.dex */
public class C1636b extends AbstractC1577k implements InterfaceC1643i {

    /* renamed from: a */
    private static final InterfaceC2558b f10338a = C2568c.m15995a((Class<?>) C1636b.class);

    /* renamed from: b */
    private final C1637c f10339b;

    /* renamed from: c */
    private final C1590b f10340c;

    /* renamed from: d */
    private final C1589a f10341d;

    /* renamed from: e */
    private AbstractC1596a f10342e;

    /* renamed from: f */
    private List<AbstractC1596a> f10343f;

    /* renamed from: g */
    private Map<AbstractC1596a, List<AbstractC1596a>> f10344g;

    /* renamed from: h */
    private final List<C1648n> f10345h;

    /* renamed from: i */
    private final List<C1639e> f10346i;

    /* renamed from: j */
    private List<C1636b> f10347j;

    /* renamed from: k */
    private C1548d f10348k;

    /* renamed from: l */
    private C1636b f10349l;

    /* renamed from: m */
    private EnumC1649o f10350m;

    /* renamed from: n */
    private final Set<C1636b> f10351n;

    /* renamed from: o */
    private Map<C1594f, C1648n> f10352o;

    public C1636b(C1637c c1637c, InterfaceC2244d interfaceC2244d) {
        int mo14194a;
        this.f10347j = new ArrayList();
        this.f10350m = EnumC1649o.NOT_LOADED;
        this.f10351n = new HashSet();
        this.f10352o = Collections.emptyMap();
        this.f10339b = c1637c;
        this.f10340c = C1590b.m12191a(c1637c, interfaceC2244d);
        try {
            this.f10342e = c1637c.m12547a(interfaceC2244d.mo14195b());
            this.f10343f = new ArrayList(interfaceC2244d.mo14196c().size());
            Iterator<String> it = interfaceC2244d.mo14196c().iterator();
            while (it.hasNext()) {
                this.f10343f.add(c1637c.m12547a(it.next()));
            }
            AbstractC1208w.a aVar = new AbstractC1208w.a();
            AbstractC1208w.a aVar2 = new AbstractC1208w.a();
            Iterator<? extends InterfaceC2267h> it2 = interfaceC2244d.mo14202i().iterator();
            while (it2.hasNext()) {
                aVar.mo9809a(new C1648n(this, it2.next(), false));
            }
            Iterator<? extends InterfaceC2267h> it3 = interfaceC2244d.mo14203j().iterator();
            while (it3.hasNext()) {
                aVar.mo9809a(new C1648n(this, it3.next(), true));
            }
            Iterator<? extends InterfaceC2266g> it4 = interfaceC2244d.mo14199f().iterator();
            while (it4.hasNext()) {
                aVar2.mo9809a(new C1639e(this, it4.next()));
            }
            m12507a(interfaceC2244d, aVar2.m10144a());
            Iterator<? extends InterfaceC2266g> it5 = interfaceC2244d.mo14200g().iterator();
            while (it5.hasNext()) {
                aVar2.mo9809a(new C1639e(this, it5.next()));
            }
            this.f10345h = aVar.m10144a();
            this.f10346i = aVar2.m10144a();
            m12506a(interfaceC2244d);
            m12503F();
            m12504G();
            String mo14197d = interfaceC2244d.mo14197d();
            if (mo14197d != null) {
                m12508d(mo14197d);
            }
            C1563a a2 = mo12139a("dalvik.annotation.InnerClass");
            if (a2 != null) {
                mo14194a = ((Integer) a2.m12081c().get("accessFlags")).intValue();
            } else {
                mo14194a = interfaceC2244d.mo14194a();
            }
            this.f10341d = new C1589a(mo14194a, C1589a.a.CLASS);
            m12505H();
        } catch (Exception e2) {
            throw new C1729f("Error decode class: " + this.f10340c, e2);
        }
    }

    public C1636b(C1637c c1637c, String str, int i) {
        this.f10347j = new ArrayList();
        this.f10350m = EnumC1649o.NOT_LOADED;
        this.f10351n = new HashSet();
        this.f10352o = Collections.emptyMap();
        this.f10339b = c1637c;
        this.f10340c = C1590b.m12193a(c1637c.mo12541u(), str);
        this.f10343f = new ArrayList();
        this.f10345h = new ArrayList();
        this.f10346i = new ArrayList();
        this.f10341d = new C1589a(i, C1589a.a.CLASS);
        this.f10349l = this;
        c1637c.m12556a(this);
    }

    /* renamed from: a */
    private void m12506a(InterfaceC2244d interfaceC2244d) {
        try {
            new C1629a(this).m12457a(interfaceC2244d);
        } catch (Exception e2) {
            f10338a.mo15943c("Error parsing annotations in {}", this, e2);
        }
    }

    /* renamed from: a */
    private void m12507a(InterfaceC2244d interfaceC2244d, List<C1639e> list) {
        for (C1639e c1639e : list) {
            if (c1639e.m12566g().m12180i()) {
                c1639e.mo12144a(C1632d.f10319a);
            }
        }
        new C1635g(this.f10339b).m12502a(list, interfaceC2244d.mo14199f());
        mo12541u().m12666h().m12218a(this, list);
    }

    /* renamed from: F */
    private void m12503F() {
        AbstractC1596a m12499a;
        C1634f m12485a = C1634f.m12485a(this);
        if (m12485a != null) {
            try {
                this.f10344g = m12485a.m12500b();
                this.f10342e = m12485a.m12499a();
                for (int i = 0; i < this.f10343f.size() && (m12499a = m12485a.m12499a()) != null; i++) {
                    this.f10343f.set(i, m12499a);
                }
            } catch (Exception e2) {
                f10338a.mo15943c("Class signature parse error: {}", this, e2);
            }
        }
    }

    /* renamed from: G */
    private void m12504G() {
        AbstractC1596a m12499a;
        for (C1639e c1639e : this.f10346i) {
            try {
                C1634f m12485a = C1634f.m12485a(c1639e);
                if (m12485a != null && (m12499a = m12485a.m12499a()) != null) {
                    c1639e.m12564a(m12499a);
                }
            } catch (Exception e2) {
                f10338a.mo15944c("Field signature parse error: {}.{}", m12509A(), c1639e.m12567h(), e2);
            }
        }
    }

    /* renamed from: d */
    private void m12508d(String str) {
        if (str != null) {
            if (str.endsWith(".java")) {
                str = str.substring(0, str.length() - 5);
            }
            if (!str.isEmpty() && !str.equals("SourceFile") && !str.equals("\"")) {
                if (this.f10340c != null) {
                    String m12203e = this.f10340c.m12203e();
                    if (!str.equals(m12203e)) {
                        if (!str.contains("$") || !str.endsWith("$" + m12203e)) {
                            C1590b m12209k = this.f10340c.m12209k();
                            if (m12209k != null && str.equals(m12209k.m12203e())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                mo12144a((InterfaceC1587g) new C1582p(str));
            }
        }
    }

    /* renamed from: f */
    public void m12526f() {
        for (C1648n c1648n : m12530j()) {
            try {
                c1648n.m12631f();
            } catch (Exception e2) {
                c1648n.m12625a("Method load error", e2);
            }
        }
        Iterator<C1636b> it = m12534n().iterator();
        while (it.hasNext()) {
            it.next().m12526f();
        }
    }

    /* renamed from: H */
    private void m12505H() {
        this.f10352o = new HashMap(this.f10345h.size());
        for (C1648n c1648n : this.f10345h) {
            this.f10352o.put(c1648n.m12617O(), c1648n);
        }
    }

    /* renamed from: g */
    public AbstractC1596a m12527g() {
        return this.f10342e;
    }

    /* renamed from: h */
    public List<AbstractC1596a> m12528h() {
        return this.f10343f;
    }

    /* renamed from: i */
    public Map<AbstractC1596a, List<AbstractC1596a>> m12529i() {
        return this.f10344g;
    }

    /* renamed from: j */
    public List<C1648n> m12530j() {
        return this.f10345h;
    }

    /* renamed from: k */
    public List<C1639e> m12531k() {
        return this.f10346i;
    }

    /* renamed from: a */
    public C1639e m12516a(Object obj) {
        return m12517a(obj, true);
    }

    /* renamed from: a */
    public C1639e m12517a(Object obj, boolean z) {
        return mo12541u().m12666h().m12217a(this, obj, z);
    }

    /* renamed from: a */
    public C1639e m12515a(C1600e c1600e) {
        return mo12541u().m12666h().m12216a(this, c1600e);
    }

    /* renamed from: a */
    public C1639e m12518a(InterfaceC2266g interfaceC2266g) {
        return m12514a(C1592d.m12224a(this.f10339b, interfaceC2266g));
    }

    /* renamed from: a */
    public C1639e m12514a(C1592d c1592d) {
        for (C1639e c1639e : this.f10346i) {
            if (c1639e.m12565f().equals(c1592d)) {
                return c1639e;
            }
        }
        return null;
    }

    /* renamed from: b */
    public C1639e m12524b(String str) {
        for (C1639e c1639e : this.f10346i) {
            if (c1639e.m12567h().equals(str)) {
                return c1639e;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1648n m12519a(C1594f c1594f) {
        return this.f10352o.get(c1594f);
    }

    /* renamed from: c */
    public C1648n m12525c(String str) {
        for (C1648n c1648n : this.f10345h) {
            if (c1648n.m12617O().m12244c().equals(str)) {
                return c1648n;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1648n m12520a(InterfaceC2267h interfaceC2267h) {
        return m12525c(C1594f.m12238a(this.f10339b, interfaceC2267h).m12244c());
    }

    /* renamed from: l */
    public C1636b m12532l() {
        if (this.f10349l == null) {
            if (this.f10340c.m12210l()) {
                C1636b m12557b = mo12540t().m12557b(this.f10340c.m12208j());
                if (m12557b == null) {
                    m12557b = this;
                }
                this.f10349l = m12557b;
            } else {
                this.f10349l = this;
            }
        }
        return this.f10349l;
    }

    /* renamed from: m */
    public C1636b m12533m() {
        C1636b m12532l = m12532l();
        return m12532l == this ? this : m12532l.m12533m();
    }

    /* renamed from: n */
    public List<C1636b> m12534n() {
        return this.f10347j;
    }

    /* renamed from: a */
    public void m12522a(C1636b c1636b) {
        this.f10347j.add(c1636b);
        c1636b.f10349l = this;
    }

    /* renamed from: o */
    public boolean m12535o() {
        return m12539s().m12182k() && m12527g() != null && m12527g().mo12279e().equals(AbstractC1596a.f10137m.mo12279e());
    }

    /* renamed from: p */
    public boolean m12536p() {
        return this.f10340c.m12210l() && this.f10340c.m12199b().m12203e().startsWith("AnonymousClass") && m12538r() != null;
    }

    /* renamed from: q */
    public C1648n m12537q() {
        return m12525c("<clinit>()V");
    }

    /* renamed from: r */
    public C1648n m12538r() {
        for (C1648n c1648n : this.f10345h) {
            if (c1648n.m12610H()) {
                return c1648n;
            }
        }
        return null;
    }

    /* renamed from: s */
    public C1589a m12539s() {
        return this.f10341d;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: t */
    public C1637c mo12540t() {
        return this.f10339b;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: u */
    public C1650p mo12541u() {
        return this.f10339b.mo12541u();
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: v */
    public String mo12542v() {
        return "class";
    }

    /* renamed from: w */
    public String m12543w() {
        return this.f10340c.m12206h();
    }

    /* renamed from: x */
    public C1590b m12544x() {
        return this.f10340c;
    }

    /* renamed from: y */
    public C1590b m12545y() {
        return this.f10340c.m12199b();
    }

    /* renamed from: z */
    public String m12546z() {
        return this.f10340c.m12199b().m12203e();
    }

    /* renamed from: A */
    public String m12509A() {
        return this.f10340c.m12199b().m12202d();
    }

    /* renamed from: B */
    public String m12510B() {
        return this.f10340c.m12199b().m12204f();
    }

    /* renamed from: a */
    public void m12521a(C1548d c1548d) {
        this.f10348k = c1548d;
    }

    /* renamed from: C */
    public C1548d m12511C() {
        return this.f10348k;
    }

    /* renamed from: D */
    public EnumC1649o m12512D() {
        return this.f10350m;
    }

    /* renamed from: a */
    public void m12523a(EnumC1649o enumC1649o) {
        this.f10350m = enumC1649o;
    }

    /* renamed from: E */
    public Set<C1636b> m12513E() {
        return this.f10351n;
    }

    public int hashCode() {
        return this.f10340c.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1636b) {
            return this.f10340c.equals(((C1636b) obj).f10340c);
        }
        return false;
    }

    public String toString() {
        return this.f10340c.m12202d();
    }
}
