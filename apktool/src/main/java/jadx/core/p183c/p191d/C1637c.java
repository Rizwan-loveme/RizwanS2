package jadx.core.p183c.p191d;

import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p203d.C1741j;
import jadx.core.p203d.InterfaceC1736e;
import jadx.core.p203d.p206c.C1733c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2264e;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: DexNode.java */
/* renamed from: jadx.core.c.d.c */
/* loaded from: classes.dex */
public class C1637c implements InterfaceC1643i {

    /* renamed from: a */
    private final C1650p f10353a;

    /* renamed from: b */
    private final InterfaceC2264e f10354b;

    /* renamed from: c */
    private final C1733c f10355c;

    /* renamed from: e */
    private final List<C1636b> f10357e = new ArrayList();

    /* renamed from: f */
    private final Map<C1590b, C1636b> f10358f = new HashMap();

    /* renamed from: d */
    private final Map<String, AbstractC1596a> f10356d = new HashMap();

    public C1637c(C1650p c1650p, C1733c c1733c) {
        this.f10353a = c1650p;
        this.f10355c = c1733c;
        this.f10354b = c1733c.m13248b();
    }

    /* renamed from: a */
    public void m12555a() {
        Iterator<? extends InterfaceC2244d> it = this.f10354b.mo14769c().iterator();
        while (it.hasNext()) {
            m12556a(new C1636b(this, it.next()));
        }
    }

    /* renamed from: a */
    public void m12556a(C1636b c1636b) {
        this.f10357e.add(c1636b);
        this.f10358f.put(c1636b.m12544x(), c1636b);
    }

    /* renamed from: a */
    public AbstractC1596a m12548a(InterfaceC2243h interfaceC2243h) {
        return m12547a(interfaceC2243h.mo14205l());
    }

    /* renamed from: a */
    public AbstractC1596a m12547a(String str) {
        return (AbstractC1596a) C1741j.m13285a(this.f10356d, str, new InterfaceC1736e<String, AbstractC1596a>() { // from class: jadx.core.c.d.c.1
            @Override // jadx.core.p203d.InterfaceC1736e
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public AbstractC1596a mo12561a(String str2) {
                return AbstractC1596a.m12273d(str2);
            }
        });
    }

    /* renamed from: b */
    void m12558b() {
        ArrayList<C1636b> arrayList = new ArrayList();
        for (C1636b c1636b : this.f10357e) {
            if (c1636b.m12544x().m12210l()) {
                arrayList.add(c1636b);
            }
        }
        for (C1636b c1636b2 : arrayList) {
            C1590b m12544x = c1636b2.m12544x();
            C1636b m12557b = m12557b(m12544x.m12208j());
            if (m12557b == null) {
                this.f10358f.remove(m12544x);
                m12544x.m12197a(this.f10353a);
                this.f10358f.put(m12544x, c1636b2);
            } else {
                m12557b.m12522a(c1636b2);
            }
        }
    }

    /* renamed from: c */
    public List<C1636b> m12559c() {
        return this.f10357e;
    }

    /* renamed from: a */
    C1636b m12549a(C1590b c1590b) {
        return this.f10358f.get(c1590b);
    }

    /* renamed from: b */
    public C1636b m12557b(C1590b c1590b) {
        return this.f10353a.m12650a(c1590b);
    }

    /* renamed from: a */
    public C1636b m12550a(AbstractC1596a abstractC1596a) {
        if (abstractC1596a.mo12281g()) {
            abstractC1596a = AbstractC1596a.m12263a(abstractC1596a.mo12279e());
        }
        return m12557b(C1590b.m12192a(this.f10353a, abstractC1596a));
    }

    @Deprecated
    /* renamed from: a */
    public C1648n m12553a(C1594f c1594f) {
        C1636b m12557b = m12557b(c1594f.m12245d());
        if (m12557b != null) {
            return m12557b.m12519a(c1594f);
        }
        return null;
    }

    /* renamed from: a */
    C1648n m12554a(C1636b c1636b, String str) {
        C1648n m12554a;
        C1636b m12550a;
        C1648n m12554a2;
        for (C1648n c1648n : c1636b.m12530j()) {
            if (c1648n.m12617O().m12244c().startsWith(str)) {
                return c1648n;
            }
        }
        AbstractC1596a m12527g = c1636b.m12527g();
        if (m12527g == null || (m12550a = m12550a(m12527g)) == null || (m12554a2 = m12554a(m12550a, str)) == null) {
            Iterator<AbstractC1596a> it = c1636b.m12528h().iterator();
            while (it.hasNext()) {
                C1636b m12550a2 = m12550a(it.next());
                if (m12550a2 != null && (m12554a = m12554a(m12550a2, str)) != null) {
                    return m12554a;
                }
            }
            return null;
        }
        return m12554a2;
    }

    @Deprecated
    /* renamed from: a */
    public C1639e m12551a(C1592d c1592d) {
        C1636b m12557b = m12557b(c1592d.m12228c());
        if (m12557b != null) {
            return m12557b.m12514a(c1592d);
        }
        return null;
    }

    /* renamed from: a */
    C1639e m12552a(C1636b c1636b, C1592d c1592d) {
        C1639e m12552a;
        C1636b m12550a;
        C1639e m12552a2;
        C1639e m12524b = c1636b.m12524b(c1592d.m12225a());
        if (m12524b == null) {
            AbstractC1596a m12527g = c1636b.m12527g();
            if (m12527g == null || (m12550a = m12550a(m12527g)) == null || (m12552a2 = m12552a(m12550a, c1592d)) == null) {
                Iterator<AbstractC1596a> it = c1636b.m12528h().iterator();
                while (it.hasNext()) {
                    C1636b m12550a2 = m12550a(it.next());
                    if (m12550a2 != null && (m12552a = m12552a(m12550a2, c1592d)) != null) {
                        return m12552a;
                    }
                }
                return null;
            }
            return m12552a2;
        }
        return m12524b;
    }

    /* renamed from: d */
    public C1733c m12560d() {
        return this.f10355c;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: u */
    public C1650p mo12541u() {
        return this.f10353a;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: t */
    public C1637c mo12540t() {
        return this;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: v */
    public String mo12542v() {
        return "dex";
    }

    public String toString() {
        return "DEX: " + this.f10355c;
    }
}
