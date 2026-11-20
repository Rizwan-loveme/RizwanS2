package jadx.core.p183c.p191d.p192a;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p203d.C1739h;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: LocalVar.java */
/* renamed from: jadx.core.c.d.a.e */
/* loaded from: classes.dex */
final class C1633e {

    /* renamed from: a */
    private static final InterfaceC2558b f10326a = C2568c.m15995a((Class<?>) C1633e.class);

    /* renamed from: b */
    private final int f10327b;

    /* renamed from: c */
    private String f10328c;

    /* renamed from: d */
    private AbstractC1596a f10329d;

    /* renamed from: e */
    private boolean f10330e;

    /* renamed from: f */
    private int f10331f;

    /* renamed from: g */
    private int f10332g;

    public C1633e(C1637c c1637c, int i, String str, String str2, String str3) {
        this.f10327b = i;
        m12474a(str, str2 == null ? null : c1637c.m12547a(str2), str3);
    }

    public C1633e(C1604i c1604i) {
        this.f10327b = c1604i.m12330o();
        m12474a(c1604i.mo12320m_(), c1604i.m12359s(), (String) null);
    }

    /* renamed from: a */
    private void m12474a(String str, AbstractC1596a abstractC1596a, String str2) {
        if (str2 != null) {
            try {
                AbstractC1596a m12270c = AbstractC1596a.m12270c(str2);
                if (m12475a(abstractC1596a, str2, m12270c)) {
                    abstractC1596a = m12270c;
                }
            } catch (Exception e2) {
                f10326a.mo15943c("Can't parse signature for local variable: {}", str2, e2);
            }
        }
        this.f10328c = str;
        this.f10329d = abstractC1596a;
    }

    /* renamed from: a */
    private boolean m12475a(AbstractC1596a abstractC1596a, String str, AbstractC1596a abstractC1596a2) {
        AbstractC1596a mo12289o = abstractC1596a2.mo12289o();
        if (mo12289o.mo12281g()) {
            if (!abstractC1596a.mo12289o().mo12279e().equals(mo12289o.mo12279e())) {
                f10326a.mo15937b("Generic type in debug info not equals: {} != {}", abstractC1596a, abstractC1596a2);
            }
            return true;
        }
        return mo12289o.mo12282h();
    }

    /* renamed from: a */
    public void m12477a(int i, int i2) {
        this.f10330e = false;
        this.f10331f = i;
    }

    /* renamed from: b */
    public boolean m12479b(int i, int i2) {
        if (this.f10330e) {
            return false;
        }
        this.f10330e = true;
        this.f10332g = i;
        return true;
    }

    /* renamed from: a */
    public int m12476a() {
        return this.f10327b;
    }

    /* renamed from: b */
    public String m12478b() {
        return this.f10328c;
    }

    /* renamed from: c */
    public AbstractC1596a m12480c() {
        return this.f10329d;
    }

    /* renamed from: d */
    public boolean m12481d() {
        return this.f10330e;
    }

    /* renamed from: e */
    public int m12482e() {
        return this.f10331f;
    }

    /* renamed from: f */
    public int m12483f() {
        return this.f10332g;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder(String.valueOf(super.toString())).append(" ");
        if (this.f10330e) {
            str = "end: " + C1739h.m13270a(this.f10331f) + "-" + C1739h.m13270a(this.f10332g);
        } else {
            str = "active: " + C1739h.m13270a(this.f10331f);
        }
        return append.append(str).toString();
    }
}
