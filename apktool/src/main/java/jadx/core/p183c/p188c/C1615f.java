package jadx.core.p183c.p188c;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1646l;

/* compiled from: FilledNewArrayNode.java */
/* renamed from: jadx.core.c.c.f */
/* loaded from: classes.dex */
public class C1615f extends C1646l {

    /* renamed from: a */
    private final AbstractC1596a f10220a;

    public C1615f(AbstractC1596a abstractC1596a, int i) {
        super(EnumC1621l.FILLED_NEW_ARRAY, i);
        this.f10220a = abstractC1596a;
    }

    /* renamed from: f */
    public AbstractC1596a m12382f() {
        return AbstractC1596a.m12258a(this.f10220a);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if ((c1646l instanceof C1615f) && super.mo12254a(c1646l)) {
            return this.f10220a == ((C1615f) c1646l).f10220a;
        }
        return false;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(super.toString()) + " elemType: " + this.f10220a;
    }
}
