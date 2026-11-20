package jadx.core.p183c.p188c;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.EnumC1603h;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.List;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;

/* compiled from: FillArrayNode.java */
/* renamed from: jadx.core.c.c.e */
/* loaded from: classes.dex */
public final class C1614e extends C1646l {

    /* renamed from: a */
    private final Number[] f10217a;

    /* renamed from: b */
    private final int f10218b;

    /* renamed from: e */
    private AbstractC1596a f10219e;

    public C1614e(int i, InterfaceC2177a interfaceC2177a) {
        super(EnumC1621l.FILL_ARRAY, 0);
        AbstractC1596a m12265a;
        switch (interfaceC2177a.mo14479e()) {
            case 1:
                m12265a = AbstractC1596a.m12265a(EnumC1603h.BOOLEAN, EnumC1603h.BYTE);
                break;
            case 2:
                m12265a = AbstractC1596a.m12265a(EnumC1603h.SHORT, EnumC1603h.CHAR);
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new C1729f("Unknown array element width: " + interfaceC2177a.mo14479e());
            case 4:
                m12265a = AbstractC1596a.m12265a(EnumC1603h.INT, EnumC1603h.FLOAT);
                break;
            case 8:
                m12265a = AbstractC1596a.m12265a(EnumC1603h.LONG, EnumC1603h.DOUBLE);
                break;
        }
        m12581b(AbstractC1598c.m12302a(i, AbstractC1596a.m12258a(m12265a)));
        List<Number> mo14480f = interfaceC2177a.mo14480f();
        int size = mo14480f.size();
        Number[] numberArr = new Number[size];
        mo14480f.toArray(numberArr);
        this.f10217a = numberArr;
        this.f10218b = size;
        this.f10219e = m12265a;
    }

    /* renamed from: f */
    public Number[] m12379f() {
        return this.f10217a;
    }

    /* renamed from: h */
    public AbstractC1596a m12380h() {
        return this.f10219e;
    }

    /* renamed from: a */
    public void m12378a(C1637c c1637c, AbstractC1596a abstractC1596a) {
        AbstractC1596a m12262a = AbstractC1596a.m12262a(c1637c, this.f10219e, abstractC1596a);
        if (m12262a != null) {
            this.f10219e = m12262a;
        }
    }

    /* renamed from: i */
    public List<C1600e> m12381i() {
        ArrayList arrayList = new ArrayList(this.f10218b);
        for (Number number : this.f10217a) {
            arrayList.add(AbstractC1598c.m12300a(number.longValue(), this.f10219e));
        }
        return arrayList;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1614e) || !super.mo12254a(c1646l)) {
            return false;
        }
        C1614e c1614e = (C1614e) c1646l;
        return this.f10219e.equals(c1614e.f10219e) && this.f10217a == c1614e.f10217a;
    }
}
