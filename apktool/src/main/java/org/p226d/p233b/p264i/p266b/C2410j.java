package org.p226d.p233b.p264i.p266b;

import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p264i.InterfaceC2431h;

/* compiled from: EncodedArrayPool.java */
/* renamed from: org.d.b.i.b.j */
/* loaded from: classes.dex */
public class C2410j extends AbstractC2405e<InterfaceC2246b> implements InterfaceC2431h<InterfaceC2246b, InterfaceC2251g> {
    public C2410j(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(InterfaceC2246b interfaceC2246b) {
        if (((Integer) this.f12766b.put(interfaceC2246b, 0)) == null) {
            Iterator<? extends InterfaceC2251g> it = interfaceC2246b.mo14733b().iterator();
            while (it.hasNext()) {
                this.f12765a.m15248a(it.next());
            }
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2431h
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<? extends InterfaceC2251g> mo15277a(InterfaceC2246b interfaceC2246b) {
        return interfaceC2246b.mo14733b();
    }
}
