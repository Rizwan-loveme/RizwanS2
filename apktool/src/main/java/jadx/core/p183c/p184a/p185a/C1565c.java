package jadx.core.p183c.p184a.p185a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MethodParameters.java */
/* renamed from: jadx.core.c.a.a.c */
/* loaded from: classes.dex */
public class C1565c implements InterfaceC1587g<C1565c> {

    /* renamed from: a */
    private final List<C1564b> f10026a;

    public C1565c(int i) {
        this.f10026a = new ArrayList(i);
    }

    /* renamed from: a */
    public List<C1564b> m12087a() {
        return this.f10026a;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1565c> mo12085b() {
        return C1566b.f10043q;
    }

    public String toString() {
        return C1745n.m13309a((Iterable) this.f10026a);
    }
}
