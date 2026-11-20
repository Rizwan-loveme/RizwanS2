package jadx.core.p183c.p188c.p189a;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p191d.C1637c;

/* compiled from: Typed.java */
/* renamed from: jadx.core.c.c.a.l */
/* loaded from: classes.dex */
public abstract class AbstractC1607l extends AbstractC1584d {

    /* renamed from: d */
    protected AbstractC1596a f10191d;

    /* renamed from: s */
    public AbstractC1596a m12359s() {
        return this.f10191d;
    }

    /* renamed from: a */
    public void mo12293a(AbstractC1596a abstractC1596a) {
        this.f10191d = abstractC1596a;
    }

    /* renamed from: n_ */
    public boolean mo12356n_() {
        return false;
    }

    /* renamed from: a */
    public boolean m12357a(C1637c c1637c, AbstractC1596a abstractC1596a) {
        AbstractC1596a m12262a = AbstractC1596a.m12262a(c1637c, this.f10191d, abstractC1596a);
        if (m12262a == null || m12262a.equals(this.f10191d)) {
            return false;
        }
        mo12293a(m12262a);
        return true;
    }

    /* renamed from: a */
    public boolean m12358a(C1637c c1637c, AbstractC1598c abstractC1598c) {
        return m12357a(c1637c, abstractC1598c.m12359s());
    }
}
