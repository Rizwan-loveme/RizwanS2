package jadx.core.p183c.p188c;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.EnumC1603h;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1739h;
import java.util.List;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2222j;
import org.p226d.p233b.p250e.p252b.InterfaceC2230r;

/* compiled from: IfNode.java */
/* renamed from: jadx.core.c.c.h */
/* loaded from: classes.dex */
public class C1617h extends C1616g {

    /* renamed from: e */
    private static final AbstractC1596a f10222e = AbstractC1596a.m12265a(EnumC1603h.INT, EnumC1603h.OBJECT, EnumC1603h.ARRAY, EnumC1603h.BOOLEAN, EnumC1603h.BYTE, EnumC1603h.SHORT, EnumC1603h.CHAR);

    /* renamed from: b */
    protected EnumC1618i f10223b;

    /* renamed from: f */
    private C1628a f10224f;

    /* renamed from: g */
    private C1628a f10225g;

    public C1617h(InterfaceC2218f interfaceC2218f, EnumC1618i enumC1618i, int i) {
        this(enumC1618i, ((InterfaceC2222j) interfaceC2218f).mo14507e() + i, AbstractC1598c.m12304a(interfaceC2218f, 0, f10222e), interfaceC2218f instanceof InterfaceC2230r ? AbstractC1598c.m12304a(interfaceC2218f, 1, f10222e) : AbstractC1598c.m12300a(0L, f10222e));
    }

    public C1617h(EnumC1618i enumC1618i, int i, AbstractC1598c abstractC1598c, AbstractC1598c abstractC1598c2) {
        super(EnumC1621l.IF, i, 2);
        this.f10223b = enumC1618i;
        m12584c(abstractC1598c);
        m12584c(abstractC1598c2);
    }

    /* renamed from: h */
    public EnumC1618i m12387h() {
        return this.f10223b;
    }

    /* renamed from: i */
    public void m12388i() {
        this.f10223b = this.f10223b.m12393b();
        C1628a c1628a = this.f10224f;
        this.f10224f = this.f10225g;
        this.f10225g = c1628a;
    }

    /* renamed from: a */
    public void m12384a(EnumC1618i enumC1618i, AbstractC1598c abstractC1598c, AbstractC1598c abstractC1598c2) {
        this.f10223b = enumC1618i;
        mo12421a(0, abstractC1598c);
        mo12421a(1, abstractC1598c2);
    }

    @Override // jadx.core.p183c.p188c.AbstractC1627r
    /* renamed from: a */
    public void mo12385a(C1628a c1628a) {
        List<C1628a> m12442f = c1628a.m12442f();
        this.f10224f = C1721a.m13188a(this.f10221a, m12442f);
        if (m12442f.size() == 1) {
            this.f10225g = this.f10224f;
        } else {
            this.f10225g = C1721a.m13189a(this.f10224f, m12442f);
        }
    }

    @Override // jadx.core.p183c.p188c.AbstractC1627r
    /* renamed from: a */
    public boolean mo12386a(C1628a c1628a, C1628a c1628a2) {
        boolean z = false;
        if (this.f10224f == c1628a) {
            this.f10224f = c1628a2;
            z = true;
        }
        if (this.f10225g != c1628a) {
            return z;
        }
        this.f10225g = c1628a2;
        return true;
    }

    /* renamed from: j */
    public C1628a m12389j() {
        return this.f10224f;
    }

    /* renamed from: k */
    public C1628a m12390k() {
        return this.f10225g;
    }

    @Override // jadx.core.p183c.p188c.C1616g
    /* renamed from: f */
    public int mo12383f() {
        return this.f10224f == null ? this.f10221a : this.f10224f.m12447k();
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if ((c1646l instanceof C1617h) && super.mo12254a(c1646l)) {
            return this.f10223b == ((C1617h) c1646l).f10223b;
        }
        return false;
    }

    @Override // jadx.core.p183c.p188c.C1616g, jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(C1739h.m13270a(this.f10371d)) + ": " + C1739h.m13271a(this.f10370c) + mo12426d(0) + " " + this.f10223b.m12392a() + " " + mo12426d(1) + "  -> " + (this.f10224f != null ? this.f10224f : C1739h.m13270a(this.f10221a));
    }
}
