package jadx.core.p183c.p188c;

import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1739h;
import java.util.Arrays;
import java.util.List;

/* compiled from: SwitchNode.java */
/* renamed from: jadx.core.c.c.q */
/* loaded from: classes.dex */
public class C1626q extends AbstractC1627r {

    /* renamed from: a */
    private final Object[] f10294a;

    /* renamed from: b */
    private final int[] f10295b;

    /* renamed from: e */
    private final int f10296e;

    /* renamed from: f */
    private C1628a[] f10297f;

    /* renamed from: g */
    private C1628a f10298g;

    public C1626q(AbstractC1598c abstractC1598c, Object[] objArr, int[] iArr, int i) {
        super(EnumC1621l.SWITCH, 1);
        this.f10294a = objArr;
        this.f10295b = iArr;
        this.f10296e = i;
        m12584c(abstractC1598c);
    }

    /* renamed from: f */
    public int m12427f() {
        return this.f10294a.length;
    }

    /* renamed from: h */
    public Object[] m12428h() {
        return this.f10294a;
    }

    /* renamed from: i */
    public int[] m12429i() {
        return this.f10295b;
    }

    /* renamed from: j */
    public int m12430j() {
        return this.f10296e;
    }

    /* renamed from: k */
    public C1628a[] m12431k() {
        return this.f10297f;
    }

    /* renamed from: l */
    public C1628a m12432l() {
        return this.f10298g;
    }

    @Override // jadx.core.p183c.p188c.AbstractC1627r
    /* renamed from: a */
    public void mo12385a(C1628a c1628a) {
        List<C1628a> m12442f = c1628a.m12442f();
        int length = this.f10295b.length;
        this.f10297f = new C1628a[length];
        for (int i = 0; i < length; i++) {
            this.f10297f[i] = C1721a.m13188a(this.f10295b[i], m12442f);
        }
        this.f10298g = C1721a.m13188a(this.f10296e, m12442f);
    }

    @Override // jadx.core.p183c.p188c.AbstractC1627r
    /* renamed from: a */
    public boolean mo12386a(C1628a c1628a, C1628a c1628a2) {
        int length = this.f10297f.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f10297f[i2] == c1628a) {
                this.f10297f[i2] = c1628a2;
                i++;
            }
        }
        if (this.f10298g == c1628a) {
            this.f10298g = c1628a2;
            i++;
        }
        return i > 0;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1626q) || !super.mo12254a(c1646l)) {
            return false;
        }
        C1626q c1626q = (C1626q) c1646l;
        return this.f10296e == c1626q.f10296e && Arrays.equals(this.f10294a, c1626q.f10294a) && Arrays.equals(this.f10295b, c1626q.f10295b);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < this.f10295b.length; i++) {
            sb.append(C1739h.m13270a(this.f10295b[i]));
            if (i < this.f10295b.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return String.valueOf(super.toString()) + " k:" + Arrays.toString(this.f10294a) + " t:" + ((Object) sb);
    }
}
