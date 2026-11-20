package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p188c.C1625p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: PhiListAttr.java */
/* renamed from: jadx.core.c.a.b.o */
/* loaded from: classes.dex */
public class C1581o implements InterfaceC1587g<C1581o> {

    /* renamed from: a */
    private final List<C1625p> f10082a = new LinkedList();

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1581o> mo12085b() {
        return C1566b.f10044r;
    }

    /* renamed from: a */
    public List<C1625p> m12135a() {
        return this.f10082a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PHI: ");
        Iterator<C1625p> it = this.f10082a.iterator();
        while (it.hasNext()) {
            sb.append('r').append(it.next().m12588p().m12330o()).append(" ");
        }
        return sb.toString();
    }
}
