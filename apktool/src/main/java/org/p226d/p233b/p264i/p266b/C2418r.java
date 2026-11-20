package org.p226d.p233b.p264i.p266b;

import java.util.Collection;
import java.util.List;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p263h.C2387g;
import org.p226d.p233b.p264i.InterfaceC2441r;
import org.p226d.p233b.p264i.p266b.C2421u;

/* compiled from: ProtoPool.java */
/* renamed from: org.d.b.i.b.r */
/* loaded from: classes.dex */
public class C2418r extends AbstractC2403c<InterfaceC2239d> implements InterfaceC2441r<CharSequence, CharSequence, InterfaceC2239d, C2421u.a<? extends Collection<? extends CharSequence>>> {
    public C2418r(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(InterfaceC2239d interfaceC2239d) {
        if (((Integer) this.f12766b.put(interfaceC2239d, 0)) == null) {
            ((C2419s) this.f12765a.f12865z).m15310a(mo15305a(interfaceC2239d));
            ((C2422v) this.f12765a.f12827A).m15321a((CharSequence) interfaceC2239d.mo14686b());
            ((C2421u) this.f12765a.f12834H).m15317a((Collection<? extends CharSequence>) interfaceC2239d.mo14685a());
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2441r
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CharSequence mo15305a(InterfaceC2239d interfaceC2239d) {
        return C2387g.m15090a(interfaceC2239d.mo14685a(), interfaceC2239d.mo14686b());
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2441r
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CharSequence mo15306b(InterfaceC2239d interfaceC2239d) {
        return interfaceC2239d.mo14686b();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2441r
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C2421u.a<List<? extends CharSequence>> mo15307c(InterfaceC2239d interfaceC2239d) {
        return new C2421u.a<>(interfaceC2239d.mo14685a());
    }
}
