package org.p226d.p233b.p264i.p266b;

import java.util.Collection;
import java.util.Map;
import org.p226d.p233b.p264i.InterfaceC2438o;
import org.p226d.p269d.C2453g;

/* compiled from: StringTypeBasePool.java */
/* renamed from: org.d.b.i.b.t */
/* loaded from: classes.dex */
public abstract class AbstractC2420t extends C2406f<String, Integer> implements InterfaceC2412l, InterfaceC2438o<CharSequence> {
    public AbstractC2420t(C2409i c2409i) {
        super(c2409i);
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2434k
    /* renamed from: b */
    public Collection<Map.Entry<String, Integer>> mo15173b() {
        return this.f12766b.entrySet();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2434k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int mo15172B(CharSequence charSequence) {
        Integer num = (Integer) this.f12766b.get(charSequence.toString());
        if (num == null) {
            throw new C2453g("Item not found.: %s", charSequence.toString());
        }
        return num.intValue();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2438o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int mo15313a(CharSequence charSequence) {
        if (charSequence == null) {
            return -1;
        }
        return mo15172B(charSequence);
    }
}
