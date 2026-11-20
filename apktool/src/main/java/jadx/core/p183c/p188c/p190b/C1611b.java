package jadx.core.p183c.p188c.p190b;

import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p193e.p194a.C1653b;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.C1745n;
import java.util.Collection;

/* compiled from: TernaryInsn.java */
/* renamed from: jadx.core.c.c.b.b */
/* loaded from: classes.dex */
public final class C1611b extends C1646l {

    /* renamed from: a */
    private C1653b f10214a;

    public C1611b(C1653b c1653b, C1604i c1604i, AbstractC1598c abstractC1598c, AbstractC1598c abstractC1598c2) {
        super(EnumC1621l.TERNARY, 2);
        m12581b(c1604i);
        if (abstractC1598c.equals(C1600e.f10162c) && abstractC1598c2.equals(C1600e.f10161b)) {
            this.f10214a = C1653b.m12681b(c1653b);
            m12584c(abstractC1598c2);
            m12584c(abstractC1598c);
        } else {
            this.f10214a = c1653b;
            m12584c(abstractC1598c);
            m12584c(abstractC1598c2);
        }
    }

    /* renamed from: f */
    public C1653b m12373f() {
        return this.f10214a;
    }

    /* renamed from: h */
    public void m12374h() {
        this.f10214a = C1653b.m12683d(this.f10214a);
        if (this.f10214a.m12685a() == C1653b.a.NOT) {
            m12371i();
        }
    }

    /* renamed from: i */
    private void m12371i() {
        this.f10214a = C1653b.m12681b(this.f10214a);
        AbstractC1598c d2 = mo12426d(0);
        mo12421a(0, mo12426d(1));
        mo12421a(1, d2);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public void mo12372a(Collection<C1604i> collection) {
        super.mo12372a(collection);
        collection.addAll(this.f10214a.m12693h());
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1611b) || !super.mo12254a(c1646l)) {
            return false;
        }
        return this.f10214a.equals(((C1611b) c1646l).f10214a);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(C1739h.m13270a(this.f10371d)) + ": TERNARY" + m12588p() + " = " + C1745n.m13309a(m12589q());
    }
}
