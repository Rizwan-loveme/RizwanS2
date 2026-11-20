package org.p210a.p211a.p212a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.p210a.p211a.p212a.p213a.C1759a;
import org.p210a.p211a.p212a.p213a.C1771al;
import org.p210a.p211a.p212a.p215c.C1838h;
import org.p210a.p211a.p212a.p215c.C1840j;
import org.p210a.p211a.p212a.p216d.C1848c;
import org.p210a.p211a.p212a.p216d.C1855j;
import org.p210a.p211a.p212a.p216d.InterfaceC1847b;
import org.p210a.p211a.p212a.p216d.InterfaceC1850e;
import org.p210a.p211a.p212a.p216d.InterfaceC1854i;

/* compiled from: Parser.java */
/* renamed from: org.a.a.a.u */
/* loaded from: classes.dex */
public abstract class AbstractC1873u extends AbstractC1877y<InterfaceC1819ac, C1771al> {

    /* renamed from: a */
    private static final Map<String, C1759a> f10988a = new WeakHashMap();

    /* renamed from: b */
    private a f10989b;

    /* renamed from: i */
    protected InterfaceC1822af f10991i;

    /* renamed from: k */
    protected C1874v f10993k;

    /* renamed from: l */
    protected boolean f10994l;

    /* renamed from: m */
    protected List<InterfaceC1850e> f10995m;

    /* renamed from: n */
    protected int f10996n;

    /* renamed from: o */
    protected boolean f10997o;

    /* renamed from: h */
    protected InterfaceC1826b f10990h = new C1866n();

    /* renamed from: j */
    protected final C1838h f10992j = new C1838h();

    /* compiled from: Parser.java */
    /* renamed from: org.a.a.a.u$a */
    public class a implements InterfaceC1850e {
        public a() {
        }

        @Override // org.p210a.p211a.p212a.p216d.InterfaceC1850e
        /* renamed from: a */
        public void mo13790a(C1874v c1874v) {
            System.out.println("enter   " + AbstractC1873u.this.mo4048c()[c1874v.mo4288a()] + ", LT(1)=" + AbstractC1873u.this.f10991i.mo13689h(1).mo13673b());
        }

        @Override // org.p210a.p211a.p212a.p216d.InterfaceC1850e
        /* renamed from: a */
        public void mo13789a(InterfaceC1854i interfaceC1854i) {
            System.out.println("consume " + interfaceC1854i.mo13792a() + " rule " + AbstractC1873u.this.mo4048c()[AbstractC1873u.this.f10993k.mo4288a()]);
        }

        @Override // org.p210a.p211a.p212a.p216d.InterfaceC1850e
        /* renamed from: a */
        public void mo13788a(InterfaceC1847b interfaceC1847b) {
        }

        @Override // org.p210a.p211a.p212a.p216d.InterfaceC1850e
        /* renamed from: b */
        public void mo13791b(C1874v c1874v) {
            System.out.println("exit    " + AbstractC1873u.this.mo4048c()[c1874v.mo4288a()] + ", LT(1)=" + AbstractC1873u.this.f10991i.mo13689h(1).mo13673b());
        }
    }

    public AbstractC1873u(InterfaceC1822af interfaceC1822af) {
        this.f10992j.m13743d(0);
        this.f10994l = true;
        m13883a((InterfaceC1869q) interfaceC1822af);
    }

    /* renamed from: co */
    public void m13895co() {
        if (m13900ct() != null) {
            m13900ct().mo13718c(0);
        }
        this.f10990h.mo13696a(this);
        this.f10993k = null;
        this.f10996n = 0;
        this.f10997o = false;
        m13888a(false);
        this.f10992j.m13741c();
        this.f10992j.m13743d(0);
        C1771al cC = m13926cC();
        if (cC != null) {
            cC.mo13524a();
        }
    }

    /* renamed from: a */
    public InterfaceC1819ac m13878a(int i) {
        InterfaceC1819ac m13902cv = m13902cv();
        if (m13902cv.mo13672a() == i) {
            if (i == -1) {
                this.f10997o = true;
            }
            this.f10990h.mo13702e(this);
            m13903cw();
        } else {
            m13902cv = this.f10990h.mo13698b(this);
            if (this.f10994l && m13902cv.mo13679h() == -1) {
                this.f10993k.m13908a(m13890b(this.f10993k, m13902cv));
            }
        }
        return m13902cv;
    }

    /* renamed from: a */
    public void m13882a(InterfaceC1850e interfaceC1850e) {
        if (interfaceC1850e == null) {
            throw new NullPointerException("listener");
        }
        if (this.f10995m == null) {
            this.f10995m = new ArrayList();
        }
        this.f10995m.add(interfaceC1850e);
    }

    /* renamed from: b */
    public void m13891b(InterfaceC1850e interfaceC1850e) {
        if (this.f10995m != null && this.f10995m.remove(interfaceC1850e) && this.f10995m.isEmpty()) {
            this.f10995m = null;
        }
    }

    /* renamed from: cp */
    protected void m13896cp() {
        for (InterfaceC1850e interfaceC1850e : this.f10995m) {
            interfaceC1850e.mo13790a(this.f10993k);
            this.f10993k.m13914a(interfaceC1850e);
        }
    }

    /* renamed from: cq */
    protected void m13897cq() {
        for (int size = this.f10995m.size() - 1; size >= 0; size--) {
            InterfaceC1850e interfaceC1850e = this.f10995m.get(size);
            this.f10993k.m13917b(interfaceC1850e);
            interfaceC1850e.mo13791b(this.f10993k);
        }
    }

    /* renamed from: cr */
    public int m13898cr() {
        return this.f10996n;
    }

    /* renamed from: cs */
    public InterfaceC1820ad<?> m13899cs() {
        return this.f10991i.mo13687a().mo13682o();
    }

    /* renamed from: ct */
    public InterfaceC1822af m13900ct() {
        return m13901cu();
    }

    /* renamed from: a */
    public final void m13883a(InterfaceC1869q interfaceC1869q) {
        m13881a((InterfaceC1822af) interfaceC1869q);
    }

    /* renamed from: cu */
    public InterfaceC1822af m13901cu() {
        return this.f10991i;
    }

    /* renamed from: a */
    public void m13881a(InterfaceC1822af interfaceC1822af) {
        this.f10991i = null;
        m13895co();
        this.f10991i = interfaceC1822af;
    }

    /* renamed from: cv */
    public InterfaceC1819ac m13902cv() {
        return this.f10991i.mo13689h(1);
    }

    /* renamed from: a */
    public void m13880a(InterfaceC1819ac interfaceC1819ac, String str, C1876x c1876x) {
        this.f10996n++;
        m13929cF().mo13480a(this, interfaceC1819ac, interfaceC1819ac.mo13674c(), interfaceC1819ac.mo13675d(), str, c1876x);
    }

    /* renamed from: cw */
    public InterfaceC1819ac m13903cw() {
        InterfaceC1819ac m13902cv = m13902cv();
        if (m13902cv.mo13672a() != -1) {
            m13900ct().mo13715b();
        }
        boolean z = (this.f10995m == null || this.f10995m.isEmpty()) ? false : true;
        if (this.f10994l || z) {
            if (this.f10990h.mo13701d(this)) {
                InterfaceC1847b m13908a = this.f10993k.m13908a(m13890b(this.f10993k, m13902cv));
                if (this.f10995m != null) {
                    Iterator<InterfaceC1850e> it = this.f10995m.iterator();
                    while (it.hasNext()) {
                        it.next().mo13788a(m13908a);
                    }
                }
            } else {
                InterfaceC1854i m13912a = this.f10993k.m13912a(m13879a(this.f10993k, m13902cv));
                if (this.f10995m != null) {
                    Iterator<InterfaceC1850e> it2 = this.f10995m.iterator();
                    while (it2.hasNext()) {
                        it2.next().mo13789a(m13912a);
                    }
                }
            }
        }
        return m13902cv;
    }

    /* renamed from: a */
    public InterfaceC1854i m13879a(C1874v c1874v, InterfaceC1819ac interfaceC1819ac) {
        return new C1855j(interfaceC1819ac);
    }

    /* renamed from: b */
    public InterfaceC1847b m13890b(C1874v c1874v, InterfaceC1819ac interfaceC1819ac) {
        return new C1848c(interfaceC1819ac);
    }

    /* renamed from: cx */
    protected void m13904cx() {
        C1874v c1874v = (C1874v) this.f10993k.f11016j;
        if (c1874v != null) {
            c1874v.m13913a((C1878z) this.f10993k);
        }
    }

    /* renamed from: a */
    public void m13886a(C1874v c1874v, int i, int i2) {
        m13931f(i);
        this.f10993k = c1874v;
        this.f10993k.f11000f = this.f10991i.mo13689h(1);
        if (this.f10994l) {
            m13904cx();
        }
        if (this.f10995m != null) {
            m13896cp();
        }
    }

    /* renamed from: cy */
    public void m13905cy() {
        if (this.f10997o) {
            this.f10993k.f11001g = this.f10991i.mo13689h(1);
        } else {
            this.f10993k.f11001g = this.f10991i.mo13689h(-1);
        }
        if (this.f10995m != null) {
            m13897cq();
        }
        m13931f(this.f10993k.f11017k);
        this.f10993k = (C1874v) this.f10993k.f11016j;
    }

    /* renamed from: a */
    public void m13885a(C1874v c1874v, int i) {
        C1874v c1874v2;
        c1874v.m13933d(i);
        if (this.f10994l && this.f10993k != c1874v && (c1874v2 = (C1874v) this.f10993k.f11016j) != null) {
            c1874v2.m13919j();
            c1874v2.m13913a((C1878z) c1874v);
        }
        this.f10993k = c1874v;
    }

    /* renamed from: cz */
    public final int m13906cz() {
        if (this.f10992j.m13737a()) {
            return -1;
        }
        return this.f10992j.m13745f();
    }

    /* renamed from: a */
    public void m13887a(C1874v c1874v, int i, int i2, int i3) {
        m13931f(i);
        this.f10992j.m13743d(i3);
        this.f10993k = c1874v;
        this.f10993k.f11000f = this.f10991i.mo13689h(1);
        if (this.f10995m != null) {
            m13896cp();
        }
    }

    /* renamed from: b */
    public void m13892b(C1874v c1874v, int i, int i2) {
        C1874v c1874v2 = this.f10993k;
        c1874v2.f11016j = c1874v;
        c1874v2.f11017k = i;
        c1874v2.f11001g = this.f10991i.mo13689h(-1);
        this.f10993k = c1874v;
        this.f10993k.f11000f = c1874v2.f11000f;
        if (this.f10994l) {
            this.f10993k.m13913a((C1878z) c1874v2);
        }
        if (this.f10995m != null) {
            m13896cp();
        }
    }

    /* renamed from: a */
    public void m13884a(C1874v c1874v) {
        this.f10992j.m13744e();
        this.f10993k.f11001g = this.f10991i.mo13689h(-1);
        C1874v c1874v2 = this.f10993k;
        if (this.f10995m != null) {
            while (this.f10993k != c1874v) {
                m13897cq();
                this.f10993k = (C1874v) this.f10993k.f11016j;
            }
        } else {
            this.f10993k = c1874v;
        }
        c1874v2.f11016j = c1874v;
        if (this.f10994l && c1874v != null) {
            c1874v.m13913a((C1878z) c1874v2);
        }
    }

    /* renamed from: cA */
    public C1874v m13893cA() {
        return this.f10993k;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: a */
    public boolean mo13889a(C1878z c1878z, int i) {
        return i >= this.f10992j.m13745f();
    }

    /* renamed from: cB */
    public C1840j m13894cB() {
        return mo4049d().m13484a(m13930cG(), m13893cA());
    }

    /* renamed from: a */
    public void m13888a(boolean z) {
        if (!z) {
            m13891b(this.f10989b);
            this.f10989b = null;
        } else {
            if (this.f10989b != null) {
                m13891b(this.f10989b);
            } else {
                this.f10989b = new a();
            }
            m13882a(this.f10989b);
        }
    }
}
