package org.p226d.p233b.p264i.p266b;

import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p264i.InterfaceC2442s;
import org.p226d.p269d.C2453g;

/* compiled from: StringPool.java */
/* renamed from: org.d.b.i.b.s */
/* loaded from: classes.dex */
public class C2419s extends AbstractC2420t implements InterfaceC2442s<CharSequence, InterfaceC2242g> {
    public C2419s(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: a */
    public void m15310a(CharSequence charSequence) {
        this.f12766b.put(charSequence.toString(), 0);
    }

    /* renamed from: b */
    public void m15312b(CharSequence charSequence) {
        if (charSequence != null) {
            m15310a(charSequence);
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2442s
    /* renamed from: a */
    public int mo15309a(InterfaceC2242g interfaceC2242g) {
        Integer num = (Integer) this.f12766b.get(interfaceC2242g.toString());
        if (num == null) {
            throw new C2453g("Item not found.: %s", interfaceC2242g.toString());
        }
        return num.intValue();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2442s
    /* renamed from: a */
    public boolean mo15311a() {
        return this.f12766b.size() > 65536;
    }
}
