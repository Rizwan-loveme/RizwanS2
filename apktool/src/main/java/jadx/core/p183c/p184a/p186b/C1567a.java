package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p203d.C1745n;
import java.util.LinkedList;
import java.util.List;

/* compiled from: DeclareVariablesAttr.java */
/* renamed from: jadx.core.c.a.b.a */
/* loaded from: classes.dex */
public class C1567a implements InterfaceC1587g<C1567a> {

    /* renamed from: a */
    private final List<C1604i> f10049a = new LinkedList();

    /* renamed from: a */
    public Iterable<C1604i> m12088a() {
        return this.f10049a;
    }

    /* renamed from: a */
    public void m12089a(C1604i c1604i) {
        this.f10049a.add(c1604i);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1567a> mo12085b() {
        return C1566b.f10046t;
    }

    public String toString() {
        return "DECL_VAR: " + C1745n.m13309a((Iterable) this.f10049a);
    }
}
