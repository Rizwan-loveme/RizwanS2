package jadx.core.p183c.p188c.p189a;

import jadx.core.p181a.C1554j;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p203d.p205b.C1729f;

/* compiled from: LiteralArg.java */
/* renamed from: jadx.core.c.c.a.e */
/* loaded from: classes.dex */
public final class C1600e extends AbstractC1598c {

    /* renamed from: b */
    public static final C1600e f10161b = new C1600e(1, AbstractC1596a.f10126b);

    /* renamed from: c */
    public static final C1600e f10162c = new C1600e(0, AbstractC1596a.f10126b);

    /* renamed from: e */
    private final long f10163e;

    public C1600e(long j, AbstractC1596a abstractC1596a) {
        AbstractC1596a m12262a;
        if (j != 0) {
            if (abstractC1596a.mo12280f()) {
                throw new C1729f("Wrong literal type: " + abstractC1596a + " for value: " + j);
            }
            if (!abstractC1596a.mo12276b() && !abstractC1596a.mo12274a(EnumC1603h.LONG) && !abstractC1596a.mo12274a(EnumC1603h.DOUBLE) && (m12262a = AbstractC1596a.m12262a((C1637c) null, abstractC1596a, AbstractC1596a.f10142r)) != null) {
                abstractC1596a = m12262a;
            }
        }
        this.f10163e = j;
        this.f10191d = abstractC1596a;
    }

    /* renamed from: d */
    public long m12317d() {
        return this.f10163e;
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: i */
    public boolean mo12311i() {
        return true;
    }

    /* renamed from: e */
    public boolean m12318e() {
        EnumC1603h mo12277c = this.f10191d.mo12277c();
        return mo12277c == EnumC1603h.INT || mo12277c == EnumC1603h.BYTE || mo12277c == EnumC1603h.CHAR || mo12277c == EnumC1603h.SHORT || mo12277c == EnumC1603h.LONG;
    }

    public int hashCode() {
        return ((int) (this.f10163e ^ (this.f10163e >>> 32))) + (m12359s().hashCode() * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1600e c1600e = (C1600e) obj;
        return this.f10163e == c1600e.f10163e && m12359s().equals(c1600e.m12359s());
    }

    public String toString() {
        try {
            String m12002a = C1554j.m12002a(this.f10163e, m12359s());
            if (!m12359s().equals(AbstractC1596a.f10126b) || (!m12002a.equals("true") && !m12002a.equals("false"))) {
                return "(" + m12002a + " " + this.f10191d + ")";
            }
            return m12002a;
        } catch (C1729f e2) {
            return "(" + this.f10163e + " " + this.f10191d + ")";
        }
    }
}
