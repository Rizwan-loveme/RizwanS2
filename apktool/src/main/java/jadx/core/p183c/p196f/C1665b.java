package jadx.core.p183c.p196f;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;

/* compiled from: ExcHandlerAttr.java */
/* renamed from: jadx.core.c.f.b */
/* loaded from: classes.dex */
public class C1665b implements InterfaceC1587g<C1665b> {

    /* renamed from: a */
    private final C1668e f10464a;

    /* renamed from: b */
    private final C1666c f10465b;

    public C1665b(C1668e c1668e, C1666c c1666c) {
        this.f10464a = c1668e;
        this.f10465b = c1666c;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1665b> mo12085b() {
        return C1566b.f10033g;
    }

    /* renamed from: a */
    public C1668e m12748a() {
        return this.f10464a;
    }

    /* renamed from: c */
    public C1666c m12749c() {
        return this.f10465b;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ExcHandler: ");
        if (this.f10465b.m12764i()) {
            str = " FINALLY";
        } else {
            str = (this.f10465b.m12757b() ? "all" : this.f10465b.m12750a()) + " " + this.f10465b.m12762g();
        }
        return sb.append(str).toString();
    }
}
