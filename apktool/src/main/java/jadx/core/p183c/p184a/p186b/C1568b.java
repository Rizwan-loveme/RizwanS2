package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.C1583c;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;

/* compiled from: EdgeInsnAttr.java */
/* renamed from: jadx.core.c.a.b.b */
/* loaded from: classes.dex */
public class C1568b implements InterfaceC1587g<C1583c<C1568b>> {

    /* renamed from: a */
    private final C1628a f10050a;

    /* renamed from: b */
    private final C1628a f10051b;

    /* renamed from: c */
    private final C1646l f10052c;

    /* renamed from: a */
    public static void m12090a(C1628a c1628a, C1628a c1628a2, C1646l c1646l) {
        C1568b c1568b = new C1568b(c1628a, c1628a2, c1646l);
        c1628a.mo12142a(C1566b.f10029c, c1568b);
        c1628a2.mo12142a(C1566b.f10029c, c1568b);
    }

    public C1568b(C1628a c1628a, C1628a c1628a2, C1646l c1646l) {
        this.f10050a = c1628a;
        this.f10051b = c1628a2;
        this.f10052c = c1646l;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1583c<C1568b>> mo12085b() {
        return C1566b.f10029c;
    }

    /* renamed from: a */
    public C1628a m12091a() {
        return this.f10050a;
    }

    /* renamed from: c */
    public C1628a m12092c() {
        return this.f10051b;
    }

    /* renamed from: d */
    public C1646l m12093d() {
        return this.f10052c;
    }

    public String toString() {
        return "EDGE_INSN: " + this.f10050a + "->" + this.f10051b + " " + this.f10052c;
    }
}
