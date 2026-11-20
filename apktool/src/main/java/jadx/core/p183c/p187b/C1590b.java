package jadx.core.p183c.p187b;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1650p;
import jadx.core.p203d.p205b.C1729f;
import java.p209io.File;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: ClassInfo.java */
/* renamed from: jadx.core.c.b.b */
/* loaded from: classes.dex */
public final class C1590b {

    /* renamed from: a */
    private final AbstractC1596a f10097a;

    /* renamed from: b */
    private String f10098b;

    /* renamed from: c */
    private String f10099c;

    /* renamed from: d */
    private String f10100d;

    /* renamed from: e */
    private C1590b f10101e;

    /* renamed from: f */
    private C1590b f10102f;

    private C1590b(C1650p c1650p, AbstractC1596a abstractC1596a) {
        this(c1650p, abstractC1596a, true);
    }

    private C1590b(C1650p c1650p, AbstractC1596a abstractC1596a, boolean z) {
        if (!abstractC1596a.mo12280f() || abstractC1596a.mo12281g()) {
            throw new C1729f("Not class type: " + abstractC1596a);
        }
        this.f10097a = abstractC1596a;
        this.f10102f = this;
        m12194a(c1650p, z);
    }

    /* renamed from: a */
    public static C1590b m12192a(C1650p c1650p, AbstractC1596a abstractC1596a) {
        if (abstractC1596a.mo12286l()) {
            abstractC1596a = AbstractC1596a.f10134j;
        }
        C1590b m12234a = c1650p.m12667i().m12234a(abstractC1596a);
        if (m12234a == null) {
            return c1650p.m12667i().m12233a(new C1590b(c1650p, abstractC1596a));
        }
        return m12234a;
    }

    /* renamed from: a */
    public static C1590b m12191a(C1637c c1637c, InterfaceC2243h interfaceC2243h) {
        return m12192a(c1637c.mo12541u(), AbstractC1596a.m12263a(interfaceC2243h.mo14205l()));
    }

    /* renamed from: a */
    public static C1590b m12193a(C1650p c1650p, String str) {
        return m12192a(c1650p, AbstractC1596a.m12263a(str));
    }

    /* renamed from: b */
    public static C1590b m12195b(C1650p c1650p, AbstractC1596a abstractC1596a) {
        return m12193a(c1650p, abstractC1596a.mo12279e()).f10102f;
    }

    /* renamed from: b */
    public void m12200b(C1650p c1650p, String str) {
        C1590b c1590b = new C1590b(c1650p, AbstractC1596a.m12263a(str), m12210l());
        if (!this.f10102f.m12202d().equals(c1590b.m12202d())) {
            this.f10102f = c1590b;
        }
    }

    /* renamed from: a */
    public boolean m12198a() {
        return this.f10102f != this;
    }

    /* renamed from: b */
    public C1590b m12199b() {
        return this.f10102f;
    }

    /* renamed from: a */
    private void m12194a(C1650p c1650p, boolean z) {
        String mo12279e = this.f10097a.mo12279e();
        int lastIndexOf = mo12279e.lastIndexOf(46);
        if (lastIndexOf == -1) {
            this.f10098b = "";
        } else {
            this.f10098b = mo12279e.substring(0, lastIndexOf);
            mo12279e = mo12279e.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = mo12279e.lastIndexOf(36);
        if (z && lastIndexOf2 > 0 && lastIndexOf2 != mo12279e.length() - 1) {
            String str = String.valueOf(this.f10098b) + "." + mo12279e.substring(0, lastIndexOf2);
            if (this.f10098b.isEmpty()) {
                str = mo12279e.substring(0, lastIndexOf2);
            }
            this.f10101e = m12193a(c1650p, str);
            mo12279e = mo12279e.substring(lastIndexOf2 + 1);
        } else {
            this.f10101e = null;
        }
        this.f10099c = mo12279e;
        this.f10100d = m12196a(mo12279e, false);
    }

    /* renamed from: a */
    public String m12196a(String str, boolean z) {
        if (this.f10101e != null) {
            return String.valueOf(this.f10101e.m12196a(this.f10101e.m12203e(), z)) + (z ? "$" : ".") + str;
        }
        return !this.f10098b.isEmpty() ? String.valueOf(this.f10098b) + "." + str : str;
    }

    /* renamed from: c */
    public String m12201c() {
        C1590b m12199b = m12199b();
        return String.valueOf(m12199b.m12204f().replace('.', File.separatorChar)) + File.separatorChar + m12199b.m12207i().replace('.', '_');
    }

    /* renamed from: d */
    public String m12202d() {
        return this.f10100d;
    }

    /* renamed from: e */
    public String m12203e() {
        return this.f10099c;
    }

    /* renamed from: f */
    public String m12204f() {
        return this.f10098b;
    }

    /* renamed from: g */
    public boolean m12205g() {
        return this.f10098b.isEmpty();
    }

    /* renamed from: h */
    public String m12206h() {
        return this.f10097a.mo12279e();
    }

    /* renamed from: i */
    public String m12207i() {
        return this.f10101e == null ? this.f10099c : String.valueOf(this.f10101e.m12207i()) + "." + this.f10099c;
    }

    /* renamed from: j */
    public C1590b m12208j() {
        return this.f10101e;
    }

    /* renamed from: k */
    public C1590b m12209k() {
        if (this.f10101e != null) {
            C1590b m12209k = this.f10101e.m12209k();
            if (m12209k == null) {
                return this.f10101e;
            }
            return m12209k;
        }
        return null;
    }

    /* renamed from: l */
    public boolean m12210l() {
        return this.f10101e != null;
    }

    /* renamed from: a */
    public void m12197a(C1650p c1650p) {
        m12194a(c1650p, false);
    }

    /* renamed from: m */
    public AbstractC1596a m12211m() {
        return this.f10097a;
    }

    public String toString() {
        return this.f10100d;
    }

    public int hashCode() {
        return this.f10097a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1590b) {
            return this.f10097a.equals(((C1590b) obj).f10097a);
        }
        return false;
    }
}
