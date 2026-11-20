package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p191d.C1646l;

/* compiled from: MethodInlineAttr.java */
/* renamed from: jadx.core.c.a.b.n */
/* loaded from: classes.dex */
public class C1580n implements InterfaceC1587g<C1580n> {

    /* renamed from: a */
    private final C1646l f10081a;

    public C1580n(C1646l c1646l) {
        this.f10081a = c1646l;
    }

    /* renamed from: a */
    public C1646l m12134a() {
        return this.f10081a;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1580n> mo12085b() {
        return C1566b.f10039m;
    }

    public String toString() {
        return "INLINE: " + this.f10081a;
    }
}
