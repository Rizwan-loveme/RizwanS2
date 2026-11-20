package jadx.core.p183c.p191d;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1573g;
import jadx.core.p183c.p184a.p186b.C1578l;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1730c;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.C1745n;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: BlockNode.java */
/* renamed from: jadx.core.c.d.a */
/* loaded from: classes.dex */
public class C1628a extends AbstractC1584d implements InterfaceC1640f {

    /* renamed from: a */
    private int f10299a;

    /* renamed from: b */
    private final int f10300b;

    /* renamed from: f */
    private List<C1628a> f10304f;

    /* renamed from: h */
    private BitSet f10306h;

    /* renamed from: i */
    private C1628a f10307i;

    /* renamed from: c */
    private final List<C1646l> f10301c = new ArrayList(2);

    /* renamed from: d */
    private List<C1628a> f10302d = new ArrayList(1);

    /* renamed from: e */
    private List<C1628a> f10303e = new ArrayList(1);

    /* renamed from: g */
    private BitSet f10305g = C1730c.f10580a;

    /* renamed from: j */
    private List<C1628a> f10308j = new ArrayList(3);

    public C1628a(int i, int i2) {
        this.f10299a = i;
        this.f10300b = i2;
    }

    /* renamed from: a */
    public void m12434a(int i) {
        this.f10299a = i;
    }

    /* renamed from: d */
    public int m12440d() {
        return this.f10299a;
    }

    /* renamed from: e */
    public List<C1628a> m12441e() {
        return this.f10302d;
    }

    /* renamed from: f */
    public List<C1628a> m12442f() {
        return this.f10303e;
    }

    /* renamed from: g */
    public List<C1628a> m12443g() {
        return this.f10304f;
    }

    /* renamed from: h */
    public void m12444h() {
        this.f10304f = m12433d(this);
    }

    /* renamed from: i */
    public void m12445i() {
        this.f10304f = C1745n.m13314a((List) this.f10304f);
        this.f10303e = C1745n.m13314a((List) this.f10303e);
        this.f10302d = C1745n.m13314a((List) this.f10302d);
        this.f10308j = C1745n.m13314a((List) this.f10308j);
        if (this.f10306h == null) {
            throw new C1729f("Dominance frontier not set for block: " + this);
        }
    }

    /* renamed from: d */
    private static List<C1628a> m12433d(C1628a c1628a) {
        List<C1628a> m12442f = c1628a.m12442f();
        if (m12442f.isEmpty()) {
            return m12442f;
        }
        ArrayList arrayList = new ArrayList(m12442f.size());
        for (C1628a c1628a2 : m12442f) {
            if (C1721a.m13198a(c1628a2)) {
                arrayList.add(c1628a2);
            }
        }
        if (c1628a.mo12149b(EnumC1562a.LOOP_END)) {
            Iterator it = c1628a.mo12150c(C1566b.f10028b).iterator();
            while (it.hasNext()) {
                arrayList.add(((C1578l) it.next()).m12124a());
            }
        }
        C1573g c1573g = (C1573g) c1628a.mo12146b(C1566b.f10048v);
        if (c1573g != null) {
            arrayList.addAll(c1573g.m12111a());
        }
        if (arrayList.isEmpty()) {
            return m12442f;
        }
        ArrayList arrayList2 = new ArrayList(m12442f);
        arrayList2.removeAll(arrayList);
        return arrayList2;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1640f
    /* renamed from: j */
    public List<C1646l> mo12446j() {
        return this.f10301c;
    }

    /* renamed from: k */
    public int m12447k() {
        return this.f10300b;
    }

    /* renamed from: a */
    public boolean m12436a(C1628a c1628a) {
        return this.f10305g.get(c1628a.m12440d());
    }

    /* renamed from: l */
    public BitSet m12448l() {
        return this.f10305g;
    }

    /* renamed from: a */
    public void m12435a(BitSet bitSet) {
        this.f10305g = bitSet;
    }

    /* renamed from: m */
    public BitSet m12449m() {
        return this.f10306h;
    }

    /* renamed from: b */
    public void m12438b(BitSet bitSet) {
        this.f10306h = bitSet;
    }

    /* renamed from: n */
    public C1628a m12450n() {
        return this.f10307i;
    }

    /* renamed from: b */
    public void m12437b(C1628a c1628a) {
        this.f10307i = c1628a;
    }

    /* renamed from: o */
    public List<C1628a> m12451o() {
        return this.f10308j;
    }

    /* renamed from: c */
    public void m12439c(C1628a c1628a) {
        this.f10308j.add(c1628a);
    }

    /* renamed from: p */
    public boolean m12452p() {
        return mo12149b(EnumC1562a.SYNTHETIC);
    }

    /* renamed from: q */
    public boolean m12453q() {
        return mo12149b(EnumC1562a.RETURN);
    }

    public int hashCode() {
        return this.f10300b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1628a)) {
            return false;
        }
        C1628a c1628a = (C1628a) obj;
        return this.f10299a == c1628a.f10299a && this.f10300b == c1628a.f10300b;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        return Integer.toString(this.f10299a);
    }

    public String toString() {
        return "B:" + this.f10299a + ":" + C1739h.m13270a(this.f10300b);
    }
}
