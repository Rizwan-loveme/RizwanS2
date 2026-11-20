package jadx.core.p183c.p193e.p194a;

import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.EnumC1618i;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1600e;

/* compiled from: Compare.java */
/* renamed from: jadx.core.c.e.a.a */
/* loaded from: classes.dex */
public final class C1652a {

    /* renamed from: a */
    private final C1617h f10417a;

    public C1652a(C1617h c1617h) {
        this.f10417a = c1617h;
    }

    /* renamed from: a */
    public EnumC1618i m12670a() {
        return this.f10417a.m12387h();
    }

    /* renamed from: b */
    public AbstractC1598c m12671b() {
        return this.f10417a.mo12426d(0);
    }

    /* renamed from: c */
    public AbstractC1598c m12672c() {
        return this.f10417a.mo12426d(1);
    }

    /* renamed from: d */
    public C1617h m12673d() {
        return this.f10417a;
    }

    /* renamed from: e */
    public C1652a m12674e() {
        this.f10417a.m12388i();
        return this;
    }

    /* renamed from: f */
    public void m12675f() {
        if (m12670a() == EnumC1618i.NE && m12672c().mo12311i() && m12672c().equals(C1600e.f10162c)) {
            this.f10417a.m12384a(EnumC1618i.EQ, m12671b(), C1600e.f10161b);
        }
    }

    public String toString() {
        return m12671b() + " " + m12670a().m12392a() + " " + m12672c();
    }
}
