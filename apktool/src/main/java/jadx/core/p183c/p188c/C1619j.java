package jadx.core.p183c.p188c;

import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1739h;

/* compiled from: IndexInsnNode.java */
/* renamed from: jadx.core.c.c.j */
/* loaded from: classes.dex */
public class C1619j extends C1646l {

    /* renamed from: a */
    private final Object f10235a;

    public C1619j(EnumC1621l enumC1621l, Object obj, int i) {
        super(enumC1621l, i);
        this.f10235a = obj;
    }

    /* renamed from: f */
    public Object m12394f() {
        return this.f10235a;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C1619j mo12376g() {
        return (C1619j) m12583c(new C1619j(this.f10370c, this.f10235a, m12590r()));
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1619j) || !super.mo12254a(c1646l)) {
            return false;
        }
        C1619j c1619j = (C1619j) c1646l;
        return this.f10235a == null ? c1619j.f10235a == null : this.f10235a.equals(c1619j.f10235a);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(super.toString()) + " " + C1739h.m13272a(this.f10235a);
    }
}
