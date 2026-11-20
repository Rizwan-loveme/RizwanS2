package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p203d.C1745n;
import java.util.HashSet;
import java.util.Set;

/* compiled from: IgnoreEdgeAttr.java */
/* renamed from: jadx.core.c.a.b.g */
/* loaded from: classes.dex */
public class C1573g implements InterfaceC1587g<C1573g> {

    /* renamed from: a */
    private final Set<C1628a> f10067a = new HashSet(3);

    /* renamed from: a */
    public Set<C1628a> m12111a() {
        return this.f10067a;
    }

    /* renamed from: a */
    public boolean m12112a(C1628a c1628a) {
        return this.f10067a.contains(c1628a);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1573g> mo12085b() {
        return C1566b.f10048v;
    }

    public String toString() {
        return "IGNORE_EDGES: " + C1745n.m13309a(this.f10067a);
    }
}
