package jadx.core.p183c.p188c;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1646l;

/* compiled from: NewArrayNode.java */
/* renamed from: jadx.core.c.c.o */
/* loaded from: classes.dex */
public class C1624o extends C1646l {

    /* renamed from: a */
    private final AbstractC1596a f10292a;

    public C1624o(AbstractC1596a abstractC1596a, C1604i c1604i, AbstractC1598c abstractC1598c) {
        super(EnumC1621l.NEW_ARRAY, 1);
        this.f10292a = abstractC1596a;
        m12581b(c1604i);
        m12584c(abstractC1598c);
    }

    /* renamed from: f */
    public AbstractC1596a m12418f() {
        return this.f10292a;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if ((c1646l instanceof C1624o) && super.mo12254a(c1646l)) {
            return this.f10292a == ((C1624o) c1646l).f10292a;
        }
        return false;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(super.toString()) + " type: " + this.f10292a;
    }
}
