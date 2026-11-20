package jadx.core.p183c.p193e;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: AbstractRegion.java */
/* renamed from: jadx.core.c.e.a */
/* loaded from: classes.dex */
public abstract class AbstractC1651a extends AbstractC1584d implements InterfaceC1644j {

    /* renamed from: a */
    private static final InterfaceC2558b f10415a = C2568c.m15995a((Class<?>) AbstractC1651a.class);

    /* renamed from: b */
    private InterfaceC1644j f10416b;

    public AbstractC1651a(InterfaceC1644j interfaceC1644j) {
        this.f10416b = interfaceC1644j;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: c */
    public InterfaceC1644j mo12574c() {
        return this.f10416b;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: a */
    public void mo12572a(InterfaceC1644j interfaceC1644j) {
        this.f10416b = interfaceC1644j;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: a */
    public boolean mo12573a(InterfaceC1642h interfaceC1642h, InterfaceC1642h interfaceC1642h2) {
        f10415a.mo15942c("Replace sub block not supported for class \"{}\"", getClass());
        return false;
    }

    /* renamed from: a */
    public void m12669a(InterfaceC1642h interfaceC1642h, InterfaceC1644j interfaceC1644j) {
        if (interfaceC1642h instanceof InterfaceC1644j) {
            ((InterfaceC1644j) interfaceC1642h).mo12572a(interfaceC1644j);
        }
    }
}
