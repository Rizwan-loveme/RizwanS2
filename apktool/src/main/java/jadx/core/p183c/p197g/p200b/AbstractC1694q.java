package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1644j;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: TracedRegionVisitor.java */
/* renamed from: jadx.core.c.g.b.q */
/* loaded from: classes.dex */
public abstract class AbstractC1694q implements InterfaceC1683f {

    /* renamed from: a */
    protected final Deque<InterfaceC1644j> f10529a = new ArrayDeque();

    /* renamed from: a */
    public abstract void mo12950a(C1648n c1648n, InterfaceC1640f interfaceC1640f, InterfaceC1644j interfaceC1644j);

    @Override // jadx.core.p183c.p197g.p200b.InterfaceC1683f
    /* renamed from: a */
    public boolean mo12881a(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
        this.f10529a.push(interfaceC1644j);
        return true;
    }

    @Override // jadx.core.p183c.p197g.p200b.InterfaceC1683f
    /* renamed from: a */
    public void mo12880a(C1648n c1648n, InterfaceC1640f interfaceC1640f) {
        mo12950a(c1648n, interfaceC1640f, this.f10529a.peek());
    }

    @Override // jadx.core.p183c.p197g.p200b.InterfaceC1683f
    /* renamed from: b */
    public void mo12882b(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
        this.f10529a.pop();
    }
}
