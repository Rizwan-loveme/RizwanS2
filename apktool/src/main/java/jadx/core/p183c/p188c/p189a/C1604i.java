package jadx.core.p183c.p188c.p189a;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1742k;

/* compiled from: RegisterArg.java */
/* renamed from: jadx.core.c.c.a.i */
/* loaded from: classes.dex */
public class C1604i extends AbstractC1598c implements InterfaceC1601f {

    /* renamed from: b */
    protected final int f10179b;

    /* renamed from: c */
    private C1605j f10180c;

    public C1604i(int i) {
        this.f10179b = i;
    }

    public C1604i(int i, AbstractC1596a abstractC1596a) {
        this.f10191d = abstractC1596a;
        this.f10179b = i;
    }

    /* renamed from: o */
    public int m12330o() {
        return this.f10179b;
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: h */
    public boolean mo12298h() {
        return true;
    }

    /* renamed from: p */
    public C1605j m12331p() {
        return this.f10180c;
    }

    /* renamed from: a */
    void mo12326a(C1605j c1605j) {
        this.f10180c = c1605j;
    }

    @Override // jadx.core.p183c.p188c.p189a.InterfaceC1601f
    /* renamed from: m_ */
    public String mo12320m_() {
        if (m12315m()) {
            return "this";
        }
        if (this.f10180c == null) {
            return null;
        }
        return this.f10180c.m12354o();
    }

    @Override // jadx.core.p183c.p188c.p189a.InterfaceC1601f
    /* renamed from: a_ */
    public void mo12319a_(String str) {
        if (this.f10180c != null && str != null) {
            this.f10180c.m12341b(str);
        }
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: k */
    public boolean mo12313k() {
        return this.f10180c != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public boolean m12327a(AbstractC1598c abstractC1598c) {
        String mo12320m_ = mo12320m_();
        if (mo12320m_ == null || !(abstractC1598c instanceof InterfaceC1601f)) {
            return false;
        }
        return mo12320m_.equals(((InterfaceC1601f) abstractC1598c).mo12320m_());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public void m12329b(AbstractC1598c abstractC1598c) {
        if (abstractC1598c instanceof InterfaceC1601f) {
            InterfaceC1601f interfaceC1601f = (InterfaceC1601f) abstractC1598c;
            String mo12320m_ = interfaceC1601f.mo12320m_();
            String mo12320m_2 = mo12320m_();
            if (!C1742k.m13287a(mo12320m_2, mo12320m_)) {
                if (mo12320m_2 == null) {
                    mo12319a_(mo12320m_);
                } else if (mo12320m_ == null) {
                    interfaceC1601f.mo12319a_(mo12320m_2);
                }
            }
        }
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1607l
    /* renamed from: a */
    public void mo12293a(AbstractC1596a abstractC1596a) {
        if (this.f10180c != null) {
            this.f10180c.m12335a(abstractC1596a);
        }
    }

    /* renamed from: a */
    public void m12325a(AbstractC1596a abstractC1596a, String str) {
        mo12293a(abstractC1596a);
        mo12319a_(str);
    }

    /* renamed from: q */
    public C1604i m12332q() {
        return m12324a(m12330o(), this.f10180c);
    }

    /* renamed from: a */
    public C1604i m12324a(int i, C1605j c1605j) {
        C1604i c1604i = new C1604i(i, m12359s());
        if (c1605j != null) {
            c1604i.mo12326a(c1605j);
        }
        c1604i.m12143a((AbstractC1584d) this);
        return c1604i;
    }

    /* renamed from: r */
    public C1646l m12333r() {
        if (this.f10180c == null) {
            return null;
        }
        return this.f10180c.m12347h().m12314l();
    }

    /* renamed from: a */
    public boolean m12328a(C1604i c1604i) {
        return this.f10179b == c1604i.f10179b && this.f10191d.equals(c1604i.f10191d);
    }

    public int hashCode() {
        return this.f10179b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1604i)) {
            return false;
        }
        C1604i c1604i = (C1604i) obj;
        return this.f10179b == c1604i.f10179b && this.f10191d.equals(c1604i.f10191d) && C1742k.m13287a(this.f10180c, c1604i.m12331p());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(r");
        sb.append(this.f10179b);
        if (this.f10180c != null) {
            sb.append("_").append(this.f10180c.m12346g());
        }
        if (mo12320m_() != null) {
            sb.append(" '").append(mo12320m_()).append("'");
        }
        sb.append(" ");
        sb.append(this.f10191d);
        if (!m12153o_()) {
            sb.append(' ').append(m12147b());
        }
        sb.append(")");
        return sb.toString();
    }
}
