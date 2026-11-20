package org.p226d.p233b.p264i.p266b;

import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p264i.InterfaceC2433j;

/* compiled from: FieldPool.java */
/* renamed from: org.d.b.i.b.k */
/* loaded from: classes.dex */
public class C2411k extends AbstractC2403c<InterfaceC2237b> implements InterfaceC2433j<CharSequence, CharSequence, InterfaceC2237b, InterfaceC2266g> {
    public C2411k(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: d */
    public void m15283d(InterfaceC2237b interfaceC2237b) {
        if (((Integer) this.f12766b.put(interfaceC2237b, 0)) == null) {
            ((C2422v) this.f12765a.f12827A).m15321a((CharSequence) interfaceC2237b.mo14225d());
            ((C2419s) this.f12765a.f12865z).m15310a((CharSequence) interfaceC2237b.mo14226e());
            ((C2422v) this.f12765a.f12827A).m15321a((CharSequence) interfaceC2237b.mo14227f());
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2433j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public CharSequence mo15280a(InterfaceC2237b interfaceC2237b) {
        return interfaceC2237b.mo14225d();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2433j
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public CharSequence mo15281b(InterfaceC2237b interfaceC2237b) {
        return interfaceC2237b.mo14227f();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2433j
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public CharSequence mo15282c(InterfaceC2237b interfaceC2237b) {
        return interfaceC2237b.mo14226e();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2433j
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo15279a(InterfaceC2266g interfaceC2266g) {
        return mo15172B(interfaceC2266g);
    }
}
