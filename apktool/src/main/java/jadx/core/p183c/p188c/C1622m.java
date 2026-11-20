package jadx.core.p183c.p188c;

import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.C1745n;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2226n;

/* compiled from: InvokeNode.java */
/* renamed from: jadx.core.c.c.m */
/* loaded from: classes.dex */
public class C1622m extends C1646l {

    /* renamed from: a */
    private final EnumC1623n f10284a;

    /* renamed from: b */
    private final C1594f f10285b;

    public C1622m(C1594f c1594f, InterfaceC2218f interfaceC2218f, EnumC1623n enumC1623n, boolean z, int i) {
        super(EnumC1621l.INVOKE, (enumC1623n != EnumC1623n.STATIC ? 1 : 0) + c1594f.m12248g());
        this.f10285b = c1594f;
        this.f10284a = enumC1623n;
        if (i >= 0) {
            m12581b(AbstractC1598c.m12302a(i, c1594f.m12246e()));
        }
        int mo14491h = z ? ((InterfaceC2226n) interfaceC2218f).mo14491h() : 0;
        if (enumC1623n != EnumC1623n.STATIC) {
            m12578a(z ? mo14491h : C1739h.m13268a(interfaceC2218f, mo14491h), c1594f.m12245d().m12211m());
            mo14491h++;
        }
        for (AbstractC1596a abstractC1596a : c1594f.m12247f()) {
            m12578a(z ? mo14491h : C1739h.m13268a(interfaceC2218f, mo14491h), abstractC1596a);
            mo14491h += abstractC1596a.m12292r();
        }
    }

    private C1622m(C1594f c1594f, EnumC1623n enumC1623n, int i) {
        super(EnumC1621l.INVOKE, i);
        this.f10285b = c1594f;
        this.f10284a = enumC1623n;
    }

    /* renamed from: f */
    public EnumC1623n m12416f() {
        return this.f10284a;
    }

    /* renamed from: h */
    public C1594f m12417h() {
        return this.f10285b;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: g */
    public C1646l mo12376g() {
        return m12583c(new C1622m(this.f10285b, this.f10284a, m12590r()));
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1622m) || !super.mo12254a(c1646l)) {
            return false;
        }
        C1622m c1622m = (C1622m) c1646l;
        return this.f10284a == c1622m.f10284a && this.f10285b.equals(c1622m.f10285b);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(C1739h.m13270a(this.f10371d)) + ": " + C1739h.m13271a(this.f10370c) + (m12588p() == null ? "" : m12588p() + " = ") + C1745n.m13309a(m12589q()) + " " + this.f10285b + " type: " + this.f10284a;
    }
}
