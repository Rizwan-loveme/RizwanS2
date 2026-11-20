package jadx.core.p183c.p187b;

import jadx.core.p181a.C1554j;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;

/* compiled from: MethodInfo.java */
/* renamed from: jadx.core.c.b.f */
/* loaded from: classes.dex */
public final class C1594f {

    /* renamed from: a */
    private final String f10117a;

    /* renamed from: b */
    private final AbstractC1596a f10118b;

    /* renamed from: c */
    private final List<AbstractC1596a> f10119c;

    /* renamed from: d */
    private final C1590b f10120d;

    /* renamed from: e */
    private final String f10121e;

    /* renamed from: f */
    private String f10122f;

    /* renamed from: g */
    private boolean f10123g = false;

    private C1594f(C1637c c1637c, InterfaceC2240e interfaceC2240e) {
        this.f10117a = interfaceC2240e.mo14210b();
        this.f10122f = this.f10117a;
        this.f10120d = C1590b.m12193a(c1637c.mo12541u(), interfaceC2240e.mo14209a());
        this.f10118b = c1637c.m12547a(interfaceC2240e.mo14212d());
        List<? extends CharSequence> mo14211c = interfaceC2240e.mo14211c();
        this.f10119c = new ArrayList(mo14211c.size());
        Iterator<? extends CharSequence> it = mo14211c.iterator();
        while (it.hasNext()) {
            this.f10119c.add(c1637c.m12547a(it.next().toString()));
        }
        this.f10121e = m12240a(true);
    }

    /* renamed from: a */
    public static C1594f m12238a(C1637c c1637c, InterfaceC2240e interfaceC2240e) {
        C1594f m12236a = c1637c.mo12541u().m12667i().m12236a(c1637c, interfaceC2240e);
        if (m12236a == null) {
            return c1637c.mo12541u().m12667i().m12237a(c1637c, interfaceC2240e, new C1594f(c1637c, interfaceC2240e));
        }
        return m12236a;
    }

    /* renamed from: a */
    public String m12240a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10117a);
        sb.append('(');
        Iterator<AbstractC1596a> it = this.f10119c.iterator();
        while (it.hasNext()) {
            sb.append(C1554j.m12005a(it.next()));
        }
        sb.append(')');
        if (z) {
            sb.append(C1554j.m12005a(this.f10118b));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m12239a() {
        return this.f10117a;
    }

    /* renamed from: b */
    public String m12242b() {
        return String.valueOf(this.f10120d.m12202d()) + "." + this.f10121e;
    }

    /* renamed from: c */
    public String m12244c() {
        return this.f10121e;
    }

    /* renamed from: d */
    public C1590b m12245d() {
        return this.f10120d;
    }

    /* renamed from: e */
    public AbstractC1596a m12246e() {
        return this.f10118b;
    }

    /* renamed from: f */
    public List<AbstractC1596a> m12247f() {
        return this.f10119c;
    }

    /* renamed from: g */
    public int m12248g() {
        return this.f10119c.size();
    }

    /* renamed from: h */
    public boolean m12249h() {
        return this.f10117a.equals("<init>");
    }

    /* renamed from: i */
    public boolean m12250i() {
        return this.f10117a.equals("<clinit>");
    }

    /* renamed from: j */
    public String m12251j() {
        return this.f10122f;
    }

    /* renamed from: a */
    public void m12241a(String str) {
        this.f10122f = str;
    }

    /* renamed from: k */
    public boolean m12252k() {
        return !this.f10117a.equals(this.f10122f);
    }

    /* renamed from: l */
    public boolean m12253l() {
        return this.f10123g;
    }

    /* renamed from: b */
    public void m12243b(boolean z) {
        this.f10123g = z;
    }

    public int hashCode() {
        return (((this.f10120d.hashCode() * 31) + this.f10118b.hashCode()) * 31) + this.f10121e.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1594f)) {
            return false;
        }
        C1594f c1594f = (C1594f) obj;
        return this.f10121e.equals(c1594f.f10121e) && this.f10118b.equals(c1594f.f10118b) && this.f10120d.equals(c1594f.f10120d);
    }

    public String toString() {
        return String.valueOf(this.f10120d.m12202d()) + "." + this.f10117a + "(" + C1745n.m13309a((Iterable) this.f10119c) + "):" + this.f10118b;
    }
}
