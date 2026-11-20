package jadx.core.p183c.p188c;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1646l;

/* compiled from: ConstClassNode.java */
/* renamed from: jadx.core.c.c.c */
/* loaded from: classes.dex */
public final class C1612c extends C1646l {

    /* renamed from: a */
    private final AbstractC1596a f10215a;

    public C1612c(AbstractC1596a abstractC1596a) {
        super(EnumC1621l.CONST_CLASS, 0);
        this.f10215a = abstractC1596a;
    }

    /* renamed from: f */
    public AbstractC1596a m12375f() {
        return this.f10215a;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: g */
    public C1646l mo12376g() {
        return m12583c(new C1612c(this.f10215a));
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1612c) || !super.mo12254a(c1646l)) {
            return false;
        }
        return this.f10215a.equals(((C1612c) c1646l).f10215a);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(super.toString()) + " " + this.f10215a;
    }
}
