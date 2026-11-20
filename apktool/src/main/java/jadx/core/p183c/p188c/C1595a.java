package jadx.core.p183c.p188c;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1739h;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2229q;
import org.p226d.p233b.p250e.p252b.InterfaceC2230r;

/* compiled from: ArithNode.java */
/* renamed from: jadx.core.c.c.a */
/* loaded from: classes.dex */
public class C1595a extends C1646l {

    /* renamed from: a */
    private final EnumC1609b f10124a;

    public C1595a(InterfaceC2218f interfaceC2218f, EnumC1609b enumC1609b, AbstractC1596a abstractC1596a, boolean z) {
        super(EnumC1621l.ARITH, 2);
        this.f10124a = enumC1609b;
        m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, abstractC1596a));
        if (z) {
            if (interfaceC2218f instanceof InterfaceC2230r) {
                m12579a(interfaceC2218f, 1, abstractC1596a);
                m12580a(interfaceC2218f, abstractC1596a);
                return;
            } else {
                m12579a(interfaceC2218f, 0, abstractC1596a);
                m12580a(interfaceC2218f, abstractC1596a);
                return;
            }
        }
        if (interfaceC2218f instanceof InterfaceC2229q) {
            m12579a(interfaceC2218f, 1, abstractC1596a);
            m12579a(interfaceC2218f, 2, abstractC1596a);
        } else if (interfaceC2218f instanceof InterfaceC2230r) {
            m12579a(interfaceC2218f, 0, abstractC1596a);
            m12579a(interfaceC2218f, 1, abstractC1596a);
        }
    }

    public C1595a(EnumC1609b enumC1609b, C1604i c1604i, AbstractC1598c abstractC1598c, AbstractC1598c abstractC1598c2) {
        super(EnumC1621l.ARITH, 2);
        this.f10124a = enumC1609b;
        m12581b(c1604i);
        m12584c(abstractC1598c);
        m12584c(abstractC1598c2);
    }

    public C1595a(EnumC1609b enumC1609b, C1604i c1604i, AbstractC1598c abstractC1598c) {
        this(enumC1609b, c1604i, c1604i, abstractC1598c);
        mo12141a(EnumC1562a.ARITH_ONEARG);
    }

    /* renamed from: f */
    public EnumC1609b m12255f() {
        return this.f10124a;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if ((c1646l instanceof C1595a) && super.mo12254a(c1646l)) {
            return this.f10124a == ((C1595a) c1646l).f10124a;
        }
        return false;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(C1739h.m13270a(this.f10371d)) + ": " + C1739h.m13271a(this.f10370c) + m12588p() + " = " + mo12426d(0) + " " + this.f10124a.m12362a() + " " + mo12426d(1);
    }
}
