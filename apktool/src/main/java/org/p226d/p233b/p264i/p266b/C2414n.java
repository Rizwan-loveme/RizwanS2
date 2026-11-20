package org.p226d.p233b.p264i.p266b;

import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p264i.InterfaceC2437n;

/* compiled from: MethodPool.java */
/* renamed from: org.d.b.i.b.n */
/* loaded from: classes.dex */
public class C2414n extends AbstractC2403c<InterfaceC2240e> implements InterfaceC2437n<CharSequence, CharSequence, InterfaceC2239d, InterfaceC2240e, C2416p> {
    public C2414n(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: d */
    public void m15296d(InterfaceC2240e interfaceC2240e) {
        if (((Integer) this.f12766b.put(interfaceC2240e, 0)) == null) {
            ((C2422v) this.f12765a.f12827A).m15321a((CharSequence) interfaceC2240e.mo14209a());
            ((C2418r) this.f12765a.f12828B).a2((InterfaceC2239d) new C2417q(interfaceC2240e));
            ((C2419s) this.f12765a.f12865z).m15310a((CharSequence) interfaceC2240e.mo14210b());
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2437n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2240e mo15291a(C2416p c2416p) {
        return c2416p;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2437n
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public CharSequence mo15290a(InterfaceC2240e interfaceC2240e) {
        return interfaceC2240e.mo14209a();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2437n
    /* renamed from: b */
    public InterfaceC2239d mo15293b(InterfaceC2240e interfaceC2240e) {
        return new C2417q(interfaceC2240e);
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2437n
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2239d mo15292b(C2416p c2416p) {
        return new C2417q(c2416p);
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2437n
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public CharSequence mo15295c(InterfaceC2240e interfaceC2240e) {
        return interfaceC2240e.mo14210b();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2437n
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo15294c(C2416p c2416p) {
        return mo15172B(c2416p);
    }
}
