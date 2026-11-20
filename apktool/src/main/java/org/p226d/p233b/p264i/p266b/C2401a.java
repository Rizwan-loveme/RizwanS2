package org.p226d.p233b.p264i.p266b;

import java.util.Collection;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p264i.InterfaceC2394a;

/* compiled from: AnnotationPool.java */
/* renamed from: org.d.b.i.b.a */
/* loaded from: classes.dex */
public class C2401a extends AbstractC2405e<InterfaceC2165a> implements InterfaceC2394a<CharSequence, CharSequence, InterfaceC2165a, InterfaceC2175b, InterfaceC2251g> {
    public C2401a(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(InterfaceC2165a interfaceC2165a) {
        if (((Integer) this.f12766b.put(interfaceC2165a, 0)) == null) {
            ((C2422v) this.f12765a.f12827A).m15321a((CharSequence) interfaceC2165a.mo14672b());
            for (InterfaceC2175b interfaceC2175b : interfaceC2165a.mo14673c()) {
                ((C2419s) this.f12765a.f12865z).m15310a((CharSequence) interfaceC2175b.mo14692a());
                this.f12765a.m15248a(interfaceC2175b.mo14693b());
            }
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2394a
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo15154a(InterfaceC2165a interfaceC2165a) {
        return interfaceC2165a.mo14671a();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2394a
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CharSequence mo15155b(InterfaceC2165a interfaceC2165a) {
        return interfaceC2165a.mo14672b();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2394a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Collection<? extends InterfaceC2175b> mo15156c(InterfaceC2165a interfaceC2165a) {
        return interfaceC2165a.mo14673c();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2394a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CharSequence mo15157d(InterfaceC2175b interfaceC2175b) {
        return interfaceC2175b.mo14692a();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2394a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC2251g mo15158e(InterfaceC2175b interfaceC2175b) {
        return interfaceC2175b.mo14693b();
    }
}
