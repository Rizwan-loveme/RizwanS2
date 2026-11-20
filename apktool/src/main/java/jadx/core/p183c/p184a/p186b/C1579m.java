package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;

/* compiled from: LoopLabelAttr.java */
/* renamed from: jadx.core.c.a.b.m */
/* loaded from: classes.dex */
public class C1579m implements InterfaceC1587g<C1579m> {

    /* renamed from: a */
    private final C1578l f10080a;

    public C1579m(C1578l c1578l) {
        this.f10080a = c1578l;
    }

    /* renamed from: a */
    public C1578l m12133a() {
        return this.f10080a;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1579m> mo12085b() {
        return C1566b.f10047u;
    }

    public String toString() {
        return "LOOP_LABEL: " + this.f10080a;
    }
}
