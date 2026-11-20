package jadx.core.p183c.p193e.p195b;

import jadx.core.p183c.p184a.p186b.C1578l;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.AbstractC1651a;
import jadx.core.p183c.p193e.p194a.C1653b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: LoopRegion.java */
/* renamed from: jadx.core.c.e.b.c */
/* loaded from: classes.dex */
public final class C1659c extends AbstractC1651a {

    /* renamed from: a */
    private final C1578l f10445a;

    /* renamed from: b */
    private C1653b f10446b;

    /* renamed from: c */
    private final C1628a f10447c;

    /* renamed from: d */
    private C1628a f10448d;

    /* renamed from: e */
    private InterfaceC1644j f10449e;

    /* renamed from: f */
    private final boolean f10450f;

    /* renamed from: g */
    private AbstractC1660d f10451g;

    public C1659c(InterfaceC1644j interfaceC1644j, C1578l c1578l, C1628a c1628a, boolean z) {
        super(interfaceC1644j);
        this.f10445a = c1578l;
        this.f10447c = c1628a;
        this.f10446b = C1653b.m12677a(c1628a);
        this.f10450f = z;
    }

    /* renamed from: e */
    public C1578l m12725e() {
        return this.f10445a;
    }

    /* renamed from: f */
    public C1653b m12726f() {
        return this.f10446b;
    }

    /* renamed from: a */
    public void m12722a(C1653b c1653b) {
        this.f10446b = c1653b;
    }

    /* renamed from: g */
    public C1628a m12727g() {
        return this.f10447c;
    }

    /* renamed from: h */
    public InterfaceC1644j m12728h() {
        return this.f10449e;
    }

    /* renamed from: b */
    public void m12724b(InterfaceC1644j interfaceC1644j) {
        this.f10449e = interfaceC1644j;
    }

    /* renamed from: i */
    public boolean m12729i() {
        return this.f10450f;
    }

    /* renamed from: a */
    public void m12721a(C1628a c1628a) {
        this.f10448d = c1628a;
    }

    /* renamed from: n */
    private C1617h m12720n() {
        return (C1617h) this.f10447c.mo12446j().get(0);
    }

    /* renamed from: j */
    public boolean m12730j() {
        List<C1646l> mo12446j = this.f10448d.mo12446j();
        if (mo12446j.isEmpty()) {
            return true;
        }
        C1617h m12720n = m12720n();
        int size = mo12446j.size();
        for (int i = 0; i < size; i++) {
            C1646l c1646l = mo12446j.get(i);
            if (c1646l.m12588p() == null) {
                return false;
            }
            C1604i m12588p = c1646l.m12588p();
            if (m12588p.m12331p().m12349j() > 1) {
                return false;
            }
            int i2 = i + 1;
            boolean z = false;
            while (i2 < size) {
                i2++;
                z = mo12446j.get(i).m12585c(m12588p) ? true : z;
            }
            if (!z && m12720n.m12585c(m12588p)) {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public void m12731k() {
        if (this.f10448d != null && this.f10447c != null) {
            List<C1646l> mo12446j = this.f10447c.mo12446j();
            List<C1646l> mo12446j2 = this.f10448d.mo12446j();
            mo12446j2.addAll(mo12446j);
            mo12446j.clear();
            mo12446j.addAll(mo12446j2);
            mo12446j2.clear();
            this.f10448d = null;
        }
    }

    /* renamed from: l */
    public int m12732l() {
        if (this.f10447c == null) {
            return 0;
        }
        List<C1646l> mo12446j = this.f10447c.mo12446j();
        if (mo12446j.isEmpty()) {
            return 0;
        }
        return mo12446j.get(0).m12122d();
    }

    /* renamed from: m */
    public AbstractC1660d m12733m() {
        return this.f10451g;
    }

    /* renamed from: a */
    public void m12723a(AbstractC1660d abstractC1660d) {
        this.f10451g = abstractC1660d;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: d */
    public List<InterfaceC1642h> mo12575d() {
        ArrayList arrayList = new ArrayList(3);
        if (this.f10448d != null) {
            arrayList.add(this.f10448d);
        }
        if (this.f10447c != null) {
            arrayList.add(this.f10447c);
        }
        if (this.f10449e != null) {
            arrayList.add(this.f10449e);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // jadx.core.p183c.p193e.AbstractC1651a, jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: a */
    public boolean mo12573a(InterfaceC1642h interfaceC1642h, InterfaceC1642h interfaceC1642h2) {
        return false;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        return this.f10449e == null ? "-" : this.f10449e.mo12454r();
    }

    public String toString() {
        return "LOOP:" + this.f10445a.m12131f() + ": " + mo12454r();
    }
}
