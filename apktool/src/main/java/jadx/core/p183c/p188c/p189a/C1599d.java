package jadx.core.p183c.p188c.p189a;

import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.p205b.C1729f;

/* compiled from: InsnWrapArg.java */
/* renamed from: jadx.core.c.c.a.d */
/* loaded from: classes.dex */
public final class C1599d extends AbstractC1598c {

    /* renamed from: b */
    private final C1646l f10160b;

    public C1599d(C1646l c1646l) {
        C1604i m12588p = c1646l.m12588p();
        this.f10191d = m12588p != null ? m12588p.m12359s() : AbstractC1596a.f10133i;
        this.f10160b = c1646l;
    }

    /* renamed from: d */
    public C1646l m12316d() {
        return this.f10160b;
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: a */
    public void mo12309a(C1646l c1646l) {
        if (c1646l == this.f10160b) {
            throw new C1729f("Can't wrap instruction info itself: " + c1646l);
        }
        this.f10159a = c1646l;
    }

    @Override // jadx.core.p183c.p188c.p189a.AbstractC1598c
    /* renamed from: j */
    public boolean mo12312j() {
        return true;
    }

    public int hashCode() {
        return this.f10160b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1599d)) {
            return false;
        }
        C1646l c1646l = this.f10160b;
        C1646l c1646l2 = ((C1599d) obj).f10160b;
        if (!c1646l.mo12254a(c1646l2)) {
            return false;
        }
        int m12590r = c1646l.m12590r();
        for (int i = 0; i < m12590r; i++) {
            if (!c1646l.mo12426d(i).equals(c1646l2.mo12426d(i))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "(wrap: " + this.f10191d + "\n  " + this.f10160b + ")";
    }
}
