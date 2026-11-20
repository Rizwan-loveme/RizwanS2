package jadx.core.p183c.p188c.p189a;

/* compiled from: NamedArg.java */
/* renamed from: jadx.core.c.c.a.g */
/* loaded from: classes.dex */
public final class C1602g extends AbstractC1598c implements InterfaceC1601f {

    /* renamed from: b */
    private String f10164b;

    public C1602g(String str, AbstractC1596a abstractC1596a) {
        this.f10164b = str;
        this.f10191d = abstractC1596a;
    }

    @Override // jadx.core.p183c.p188c.p189a.InterfaceC1601f
    /* renamed from: m_ */
    public String mo12320m_() {
        return this.f10164b;
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: k */
    public boolean mo12313k() {
        return true;
    }

    @Override // jadx.core.p183c.p188c.p189a.InterfaceC1601f
    /* renamed from: a_ */
    public void mo12319a_(String str) {
        this.f10164b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1602g)) {
            return false;
        }
        return this.f10164b.equals(((C1602g) obj).f10164b);
    }

    public int hashCode() {
        return this.f10164b.hashCode();
    }

    public String toString() {
        return "(" + this.f10164b + " " + this.f10191d + ")";
    }
}
