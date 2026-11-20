package jadx.core.p183c.p197g.p201c;

import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.p205b.C1729f;
import java.util.BitSet;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: LiveVarAnalysis.java */
/* renamed from: jadx.core.c.g.c.b */
/* loaded from: classes.dex */
public class C1697b {

    /* renamed from: a */
    private static final InterfaceC2558b f10539a = C2568c.m15995a((Class<?>) C1697b.class);

    /* renamed from: b */
    private final C1648n f10540b;

    /* renamed from: c */
    private BitSet[] f10541c;

    /* renamed from: d */
    private BitSet[] f10542d;

    /* renamed from: e */
    private BitSet[] f10543e;

    /* renamed from: f */
    private BitSet[] f10544f;

    public C1697b(C1648n c1648n) {
        this.f10540b = c1648n;
    }

    /* renamed from: a */
    public void m13040a() {
        int size = this.f10540b.m12647y().size();
        int m12612J = this.f10540b.m12612J();
        this.f10541c = m13037b(size, m12612J);
        this.f10542d = m13037b(size, m12612J);
        this.f10544f = m13037b(m12612J, size);
        m13036b();
        m13038c();
    }

    /* renamed from: a */
    public BitSet m13039a(int i) {
        return this.f10544f[i];
    }

    /* renamed from: a */
    public boolean m13041a(int i, int i2) {
        if (i < this.f10543e.length) {
            return this.f10543e[i].get(i2);
        }
        f10539a.mo15937b("LiveVarAnalysis: out of bounds block: {}, max: {}", Integer.valueOf(i), Integer.valueOf(this.f10543e.length));
        return false;
    }

    /* renamed from: a */
    public boolean m13042a(C1628a c1628a, int i) {
        return m13041a(c1628a.m12440d(), i);
    }

    /* renamed from: b */
    private void m13036b() {
        for (C1628a c1628a : this.f10540b.m12647y()) {
            int m12440d = c1628a.m12440d();
            BitSet bitSet = this.f10541c[m12440d];
            BitSet bitSet2 = this.f10542d[m12440d];
            for (C1646l c1646l : c1628a.mo12446j()) {
                for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
                    if (abstractC1598c.mo12298h()) {
                        int m12330o = ((C1604i) abstractC1598c).m12330o();
                        if (!bitSet2.get(m12330o)) {
                            bitSet.set(m12330o);
                        }
                    }
                }
                C1604i m12588p = c1646l.m12588p();
                if (m12588p != null) {
                    int m12330o2 = m12588p.m12330o();
                    bitSet2.set(m12330o2);
                    this.f10544f[m12330o2].set(m12440d);
                }
            }
        }
    }

    /* renamed from: c */
    private void m13038c() {
        boolean z;
        int size = this.f10540b.m12647y().size();
        int m12612J = this.f10540b.m12612J();
        BitSet[] m13037b = m13037b(size, m12612J);
        List<C1628a> m12647y = this.f10540b.m12647y();
        int size2 = m12647y.size();
        int i = 0;
        while (true) {
            int i2 = 0;
            boolean z2 = false;
            while (i2 < size2) {
                C1628a c1628a = m12647y.get(i2);
                int m12440d = c1628a.m12440d();
                BitSet bitSet = m13037b[m12440d];
                BitSet bitSet2 = new BitSet(m12612J);
                List<C1628a> m12442f = c1628a.m12442f();
                int size3 = m12442f.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    bitSet2.mo13226or(m13037b[m12442f.get(i3).m12440d()]);
                }
                bitSet2.andNot(this.f10542d[m12440d]);
                bitSet2.mo13226or(this.f10541c[m12440d]);
                if (bitSet.equals(bitSet2)) {
                    z = z2;
                } else {
                    z = true;
                    m13037b[m12440d] = bitSet2;
                }
                i2++;
                z2 = z;
            }
            int i4 = i + 1;
            if (i > 1000) {
                throw new C1729f("Live variable analysis reach iterations limit");
            }
            if (!z2) {
                this.f10543e = m13037b;
                return;
            }
            i = i4;
        }
    }

    /* renamed from: b */
    private static BitSet[] m13037b(int i, int i2) {
        BitSet[] bitSetArr = new BitSet[i];
        for (int i3 = 0; i3 < i; i3++) {
            bitSetArr[i3] = new BitSet(i2);
        }
        return bitSetArr;
    }
}
