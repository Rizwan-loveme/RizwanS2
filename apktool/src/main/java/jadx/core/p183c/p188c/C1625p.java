package jadx.core.p183c.p188c;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1740i;
import jadx.core.p203d.C1745n;
import jadx.core.p203d.p205b.C1729f;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: PhiInsn.java */
/* renamed from: jadx.core.c.c.p */
/* loaded from: classes.dex */
public final class C1625p extends C1646l {

    /* renamed from: a */
    private final Map<C1604i, C1628a> f10293a;

    public C1625p(int i, int i2) {
        super(EnumC1621l.PHI, i2);
        this.f10293a = new LinkedHashMap(i2);
        m12581b(AbstractC1598c.m12302a(i, AbstractC1596a.f10139o));
        mo12141a(EnumC1562a.DONT_INLINE);
    }

    /* renamed from: a */
    public C1604i m12419a(C1628a c1628a) {
        C1604i m12302a = AbstractC1598c.m12302a(m12588p().m12330o(), m12588p().m12359s());
        m12422a(m12302a, c1628a);
        return m12302a;
    }

    /* renamed from: a */
    public void m12422a(C1604i c1604i, C1628a c1628a) {
        if (this.f10293a.containsValue(c1628a)) {
            throw new C1729f("Duplicate predecessors in PHI insn: " + c1628a + ", " + this);
        }
        m12584c((AbstractC1598c) c1604i);
        this.f10293a.put(c1604i, c1628a);
    }

    /* renamed from: a */
    public C1628a m12420a(C1604i c1604i) {
        return this.f10293a.get(c1604i);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C1604i mo12426d(int i) {
        return (C1604i) super.mo12426d(i);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12423a(AbstractC1598c abstractC1598c) {
        if (!(abstractC1598c instanceof C1604i)) {
            return false;
        }
        C1604i c1604i = (C1604i) abstractC1598c;
        if (!super.mo12423a((AbstractC1598c) c1604i)) {
            return false;
        }
        this.f10293a.remove(c1604i);
        C1740i.m13274a(c1604i);
        return true;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12424a(AbstractC1598c abstractC1598c, AbstractC1598c abstractC1598c2) {
        if (!(abstractC1598c instanceof C1604i) || !(abstractC1598c2 instanceof C1604i)) {
            return false;
        }
        C1628a m12420a = m12420a((C1604i) abstractC1598c);
        if (m12420a == null) {
            throw new C1729f("Unknown predecessor block by arg " + abstractC1598c + " in PHI: " + this);
        }
        if (mo12423a(abstractC1598c)) {
            m12422a((C1604i) abstractC1598c2, m12420a);
        }
        return true;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public void mo12421a(int i, AbstractC1598c abstractC1598c) {
        throw new C1729f("Unsupported operation for PHI node");
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return "PHI: " + m12588p() + " = " + C1745n.m13309a(m12589q()) + " binds: " + this.f10293a;
    }
}
