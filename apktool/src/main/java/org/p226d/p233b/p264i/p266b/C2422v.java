package org.p226d.p233b.p264i.p266b;

import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p226d.p233b.p264i.InterfaceC2444u;

/* compiled from: TypePool.java */
/* renamed from: org.d.b.i.b.v */
/* loaded from: classes.dex */
public class C2422v extends AbstractC2420t implements InterfaceC2444u<CharSequence, CharSequence, InterfaceC2243h> {
    public C2422v(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: a */
    public void m15321a(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        if (((Integer) this.f12766b.put(charSequence2, 0)) == null) {
            ((C2419s) this.f12765a.f12865z).m15310a((CharSequence) charSequence2);
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(CharSequence charSequence) {
        if (charSequence != null) {
            m15321a(charSequence);
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2444u
    /* renamed from: a */
    public int mo15320a(InterfaceC2243h interfaceC2243h) {
        return mo15172B(interfaceC2243h.mo14205l());
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2444u
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public CharSequence mo15322b(CharSequence charSequence) {
        return charSequence;
    }
}
