package org.p226d.p233b.p264i.p266b;

import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p264i.InterfaceC2436m;
import org.p226d.p269d.C2453g;

/* compiled from: MethodHandlePool.java */
/* renamed from: org.d.b.i.b.m */
/* loaded from: classes.dex */
public class C2413m extends AbstractC2403c<InterfaceC2238c> implements InterfaceC2436m<InterfaceC2238c, InterfaceC2237b, InterfaceC2240e> {
    public C2413m(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: c */
    public void m15289c(InterfaceC2238c interfaceC2238c) {
        if (((Integer) this.f12766b.put(interfaceC2238c, 0)) == null) {
            switch (interfaceC2238c.mo14683a()) {
                case 0:
                case 1:
                case 2:
                case 3:
                    ((C2411k) this.f12765a.f12829C).m15283d((InterfaceC2237b) interfaceC2238c.mo14684b());
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    ((C2414n) this.f12765a.f12830D).m15296d((InterfaceC2240e) interfaceC2238c.mo14684b());
                    return;
                default:
                    throw new C2453g("Invalid method handle type: %d", Integer.valueOf(interfaceC2238c.mo14683a()));
            }
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2436m
    /* renamed from: a */
    public InterfaceC2237b mo15287a(InterfaceC2238c interfaceC2238c) {
        return (InterfaceC2237b) interfaceC2238c.mo14684b();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2436m
    /* renamed from: b */
    public InterfaceC2240e mo15288b(InterfaceC2238c interfaceC2238c) {
        return (InterfaceC2240e) interfaceC2238c.mo14684b();
    }
}
