package jadx.core.p182b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.p186b.C1582p;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1648n;
import jadx.p180a.C1534b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: Deobfuscator.java */
/* renamed from: jadx.core.b.c */
/* loaded from: classes.dex */
public class C1558c {

    /* renamed from: a */
    private static final InterfaceC2558b f9962a = C2568c.m15995a((Class<?>) C1558c.class);

    /* renamed from: b */
    private final C1534b f9963b;

    /* renamed from: c */
    private final List<C1637c> f9964c;

    /* renamed from: d */
    private final C1557b f9965d;

    /* renamed from: m */
    private final int f9974m;

    /* renamed from: n */
    private final int f9975n;

    /* renamed from: o */
    private final boolean f9976o;

    /* renamed from: e */
    private final Map<C1590b, C1556a> f9966e = new HashMap();

    /* renamed from: f */
    private final Map<C1592d, String> f9967f = new HashMap();

    /* renamed from: g */
    private final Map<C1594f, String> f9968g = new HashMap();

    /* renamed from: h */
    private final Map<C1594f, C1560e> f9969h = new HashMap();

    /* renamed from: i */
    private final List<C1560e> f9970i = new ArrayList();

    /* renamed from: j */
    private final C1561f f9971j = new C1561f("");

    /* renamed from: k */
    private final Set<String> f9972k = new TreeSet();

    /* renamed from: l */
    private final Set<String> f9973l = new HashSet();

    /* renamed from: p */
    private int f9977p = 0;

    /* renamed from: q */
    private int f9978q = 0;

    /* renamed from: r */
    private int f9979r = 0;

    /* renamed from: s */
    private int f9980s = 0;

    public C1558c(C1534b c1534b, List<C1637c> list, File file) {
        this.f9963b = c1534b;
        this.f9964c = list;
        this.f9975n = c1534b.m11779n();
        this.f9974m = c1534b.m11780o();
        this.f9976o = c1534b.m11778m();
        this.f9965d = new C1557b(this, file);
    }

    /* renamed from: a */
    public void m12051a() {
        if (!this.f9963b.m11777l()) {
            this.f9965d.m12021a();
            m12045g();
        }
        m12047i();
        this.f9965d.m12022a(this.f9963b.m11777l());
        m12057b();
    }

    /* renamed from: g */
    private void m12045g() {
        this.f9977p = this.f9972k.size();
        this.f9978q = this.f9965d.m12024c().size();
        this.f9979r = this.f9965d.m12025d().size();
        this.f9980s = this.f9965d.m12026e().size();
    }

    /* renamed from: h */
    private void m12046h() {
        Iterator<C1637c> it = this.f9964c.iterator();
        while (it.hasNext()) {
            Iterator<C1636b> it2 = it.next().m12559c().iterator();
            while (it2.hasNext()) {
                Collections.addAll(this.f9973l, it2.next().m12510B().split("\\."));
            }
        }
        Iterator<C1637c> it3 = this.f9964c.iterator();
        while (it3.hasNext()) {
            Iterator<C1636b> it4 = it3.next().m12559c().iterator();
            while (it4.hasNext()) {
                m12039c(it4.next());
            }
        }
    }

    /* renamed from: i */
    private void m12047i() {
        m12046h();
        Iterator<C1637c> it = this.f9964c.iterator();
        while (it.hasNext()) {
            Iterator<C1636b> it2 = it.next().m12559c().iterator();
            while (it2.hasNext()) {
                m12035b(it2.next());
            }
        }
        m12048j();
    }

    /* renamed from: j */
    private void m12048j() {
        int i = 1;
        for (C1560e c1560e : this.f9970i) {
            String str = null;
            boolean z = false;
            for (C1594f c1594f : c1560e.m12066a()) {
                if (c1594f.m12253l()) {
                    str = c1594f.m12251j();
                    z = true;
                }
            }
            for (C1594f c1594f2 : c1560e.m12066a()) {
                if (str == null) {
                    if (c1594f2.m12252k() && !c1594f2.m12253l()) {
                        c1594f2.m12241a(String.format("mo%d%s", Integer.valueOf(i), m12034b(c1594f2.m12239a())));
                    }
                    str = c1594f2.m12251j();
                }
                c1594f2.m12241a(str);
                c1594f2.m12243b(z);
            }
            i++;
        }
    }

    /* renamed from: b */
    void m12057b() {
        this.f9965d.m12023b();
        this.f9966e.clear();
        this.f9967f.clear();
        this.f9968g.clear();
        this.f9970i.clear();
        this.f9969h.clear();
    }

    /* renamed from: c */
    private void m12040c(C1648n c1648n) {
        C1560e c1560e;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m12031a(c1648n.m12640o(), linkedHashSet);
        String m12240a = c1648n.m12617O().m12240a(false);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator<C1636b> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            C1594f m12029a = m12029a(it.next().m12530j(), m12240a);
            if (m12029a != null) {
                linkedHashSet2.add(m12029a);
            }
        }
        if (!linkedHashSet2.isEmpty()) {
            C1560e m12027a = m12027a(linkedHashSet2);
            if (m12027a == null) {
                C1560e c1560e2 = new C1560e(linkedHashSet2);
                this.f9970i.add(c1560e2);
                c1560e = c1560e2;
            } else {
                c1560e = m12027a;
            }
            for (C1594f c1594f : linkedHashSet2) {
                if (!this.f9969h.containsKey(c1594f)) {
                    this.f9969h.put(c1594f, c1560e);
                    c1560e.m12067a(c1594f);
                }
            }
        }
    }

    /* renamed from: a */
    private C1560e m12027a(Set<C1594f> set) {
        Iterator<C1594f> it = set.iterator();
        while (it.hasNext()) {
            C1560e c1560e = this.f9969h.get(it.next());
            if (c1560e != null) {
                return c1560e;
            }
        }
        return null;
    }

    /* renamed from: a */
    private C1594f m12029a(List<C1648n> list, String str) {
        Iterator<C1648n> it = list.iterator();
        while (it.hasNext()) {
            C1594f m12617O = it.next().m12617O();
            if (m12617O.m12244c().startsWith(str)) {
                return m12617O;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m12031a(C1636b c1636b, Set<C1636b> set) {
        C1636b m12550a;
        if (set.add(c1636b)) {
            AbstractC1596a m12527g = c1636b.m12527g();
            if (m12527g != null && (m12550a = c1636b.mo12540t().m12550a(m12527g)) != null) {
                m12031a(m12550a, set);
            }
            Iterator<AbstractC1596a> it = c1636b.m12528h().iterator();
            while (it.hasNext()) {
                C1636b m12550a2 = c1636b.mo12540t().m12550a(it.next());
                if (m12550a2 != null) {
                    m12031a(m12550a2, set);
                }
            }
        }
    }

    /* renamed from: b */
    private void m12035b(C1636b c1636b) {
        C1590b m12544x = c1636b.m12544x();
        String m12036c = m12036c(m12544x);
        if (!m12036c.equals(m12544x.m12202d())) {
            m12544x.m12200b(c1636b.mo12540t().mo12541u(), m12036c);
        }
        Iterator<C1639e> it = c1636b.m12531k().iterator();
        while (it.hasNext()) {
            m12052a(it.next());
        }
        Iterator<C1648n> it2 = c1636b.m12530j().iterator();
        while (it2.hasNext()) {
            m12053a(it2.next());
        }
        Iterator<C1636b> it3 = c1636b.m12534n().iterator();
        while (it3.hasNext()) {
            m12035b(it3.next());
        }
    }

    /* renamed from: a */
    public void m12052a(C1639e c1639e) {
        C1592d m12565f = c1639e.m12565f();
        String m12037c = m12037c(c1639e);
        if (m12037c != null) {
            m12565f.m12226a(m12037c);
        }
    }

    /* renamed from: a */
    public void m12053a(C1648n c1648n) {
        String m12042d = m12042d(c1648n);
        if (m12042d != null) {
            c1648n.m12617O().m12241a(m12042d);
        }
        if (c1648n.m12611I()) {
            m12040c(c1648n);
        }
    }

    /* renamed from: a */
    public void m12054a(String str, String str2) {
        m12028a(str, true).m12071a(str2);
    }

    /* renamed from: a */
    private C1561f m12028a(String str, boolean z) {
        String str2;
        if (str.isEmpty() || str.equals(".")) {
            return this.f9971j;
        }
        C1561f c1561f = this.f9971j;
        while (true) {
            int indexOf = str.indexOf(".");
            if (indexOf > -1) {
                String substring = str.substring(0, indexOf);
                str2 = str.substring(indexOf + 1);
                str = substring;
            } else {
                str2 = "";
            }
            C1561f m12072b = c1561f.m12072b(str);
            if (m12072b == null && z) {
                C1561f c1561f2 = new C1561f(str);
                c1561f.m12070a(c1561f2);
                c1561f = c1561f2;
            } else {
                c1561f = m12072b;
            }
            if (str2.isEmpty() || c1561f == null) {
                return c1561f;
            }
            str = str2;
        }
    }

    /* renamed from: a */
    String m12049a(C1590b c1590b) {
        String str;
        String m12049a;
        C1590b m12208j = c1590b.m12208j();
        if (m12208j != null) {
            C1556a c1556a = this.f9966e.get(m12208j);
            if (c1556a != null) {
                m12049a = c1556a.m12011a();
            } else {
                m12049a = m12049a(m12208j);
            }
            str = String.valueOf(m12049a) + "$";
        } else {
            str = "";
        }
        return String.valueOf(str) + c1590b.m12203e();
    }

    /* renamed from: c */
    private void m12039c(C1636b c1636b) {
        C1590b m12544x = c1636b.m12544x();
        String m12204f = m12544x.m12204f();
        C1561f m12028a = m12028a(m12204f, true);
        m12030a(m12028a, m12204f);
        String m12018a = this.f9965d.m12018a(m12544x);
        if (m12018a != null) {
            this.f9966e.put(m12544x, new C1556a(this, c1636b, m12028a, m12018a));
        } else if (!this.f9966e.containsKey(m12544x)) {
            String m12203e = m12544x.m12203e();
            if (m12032a(m12203e) || this.f9973l.contains(m12203e)) {
                m12041d(c1636b);
            }
        }
        Iterator<C1636b> it = c1636b.m12534n().iterator();
        while (it.hasNext()) {
            m12039c(it.next());
        }
    }

    /* renamed from: a */
    public String m12050a(C1636b c1636b) {
        C1556a c1556a = this.f9966e.get(c1636b.m12544x());
        return c1556a != null ? c1556a.m12014d() : m12041d(c1636b);
    }

    /* renamed from: d */
    private String m12041d(C1636b c1636b) {
        C1590b m12544x = c1636b.m12544x();
        String str = null;
        if (this.f9976o) {
            str = m12044e(c1636b);
        }
        if (str == null) {
            String m12203e = m12544x.m12203e();
            int i = this.f9978q;
            this.f9978q = i + 1;
            str = String.format("C%04d%s", Integer.valueOf(i), m12034b(m12203e));
        }
        this.f9966e.put(m12544x, new C1556a(this, c1636b, m12028a(m12544x.m12204f(), true), str));
        return str;
    }

    /* renamed from: e */
    private String m12044e(C1636b c1636b) {
        String substring;
        C1582p c1582p = (C1582p) c1636b.mo12146b(C1566b.f10045s);
        if (c1582p != null && !c1636b.m12544x().m12210l()) {
            String m12136a = c1582p.m12136a();
            if (m12136a.endsWith(".java")) {
                substring = m12136a.substring(0, m12136a.length() - ".java".length());
            } else {
                substring = m12136a.endsWith(".kt") ? m12136a.substring(0, m12136a.length() - ".kt".length()) : m12136a;
            }
            if (!C1559d.m12064b(substring) || C1559d.m12063a(substring)) {
                return null;
            }
            Iterator<C1556a> it = this.f9966e.values().iterator();
            while (it.hasNext()) {
                if (it.next().m12014d().equals(substring)) {
                    return null;
                }
            }
            if (c1636b.mo12540t().mo12541u().m12651a(String.valueOf(c1636b.m12510B()) + "." + substring) != null) {
                return null;
            }
            c1636b.m12152d(C1566b.f10045s);
            return substring;
        }
        return null;
    }

    /* renamed from: c */
    private String m12037c(C1639e c1639e) {
        C1592d m12565f = c1639e.m12565f();
        String str = this.f9967f.get(m12565f);
        if (str == null) {
            String m12019a = this.f9965d.m12019a(m12565f);
            if (m12019a != null) {
                this.f9967f.put(m12565f, m12019a);
                return m12019a;
            }
            if (m12032a(c1639e.m12567h())) {
                return m12055b(c1639e);
            }
            return null;
        }
        return str;
    }

    /* renamed from: d */
    private String m12042d(C1648n c1648n) {
        C1594f m12617O = c1648n.m12617O();
        String str = this.f9968g.get(m12617O);
        if (str == null) {
            String m12020a = this.f9965d.m12020a(m12617O);
            if (m12020a != null) {
                this.f9968g.put(m12617O, m12020a);
                m12617O.m12243b(true);
                return m12020a;
            }
            if (m12032a(c1648n.m12638m())) {
                return m12056b(c1648n);
            }
            return null;
        }
        return str;
    }

    /* renamed from: b */
    public String m12055b(C1639e c1639e) {
        int i = this.f9979r;
        this.f9979r = i + 1;
        String format = String.format("f%d%s", Integer.valueOf(i), m12034b(c1639e.m12567h()));
        this.f9967f.put(c1639e.m12565f(), format);
        return format;
    }

    /* renamed from: b */
    public String m12056b(C1648n c1648n) {
        int i = this.f9980s;
        this.f9980s = i + 1;
        String format = String.format("m%d%s", Integer.valueOf(i), m12034b(c1648n.m12638m()));
        this.f9968g.put(c1648n.m12617O(), format);
        return format;
    }

    /* renamed from: a */
    private void m12030a(C1561f c1561f, String str) {
        if (!this.f9972k.contains(str)) {
            this.f9972k.add(str);
            for (C1561f m12077f = c1561f.m12077f(); !m12077f.m12069a().isEmpty(); m12077f = m12077f.m12077f()) {
                if (!m12077f.m12075d()) {
                    m12030a(m12077f, m12077f.m12073b());
                }
            }
            String m12069a = c1561f.m12069a();
            if (!c1561f.m12075d() && m12032a(m12069a)) {
                int i = this.f9977p;
                this.f9977p = i + 1;
                c1561f.m12071a(String.format("p%03d%s", Integer.valueOf(i), m12034b(m12069a)));
            }
        }
    }

    /* renamed from: a */
    private boolean m12032a(String str) {
        int length = str.length();
        return length < this.f9975n || length > this.f9974m || !C1559d.m12064b(str);
    }

    /* renamed from: b */
    private String m12034b(String str) {
        if (str.length() > this.f9974m) {
            return "x" + Integer.toHexString(str.hashCode());
        }
        if (!C1559d.m12065c(str)) {
            return m12038c(str);
        }
        return str;
    }

    /* renamed from: c */
    private String m12038c(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (C1559d.m12062a(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    private String m12043d(String str) {
        C1561f m12028a = m12028a(str, false);
        if (m12028a != null) {
            return m12028a.m12076e();
        }
        return str;
    }

    /* renamed from: b */
    private String m12033b(C1590b c1590b) {
        C1556a c1556a = this.f9966e.get(c1590b);
        return c1556a != null ? c1556a.m12011a() : m12049a(c1590b);
    }

    /* renamed from: c */
    private String m12036c(C1590b c1590b) {
        C1556a c1556a = this.f9966e.get(c1590b);
        return c1556a != null ? c1556a.m12012b() : String.valueOf(m12043d(c1590b.m12204f())) + "." + m12033b(c1590b);
    }

    /* renamed from: c */
    public Map<C1590b, C1556a> m12058c() {
        return this.f9966e;
    }

    /* renamed from: d */
    public Map<C1592d, String> m12059d() {
        return this.f9967f;
    }

    /* renamed from: e */
    public Map<C1594f, String> m12060e() {
        return this.f9968g;
    }

    /* renamed from: f */
    public C1561f m12061f() {
        return this.f9971j;
    }
}
