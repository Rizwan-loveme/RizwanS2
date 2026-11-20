package org.p226d.p233b.p264i.p266b;

import java.util.Collection;
import java.util.Map;
import org.p226d.p233b.p264i.InterfaceC2440q;
import org.p226d.p269d.C2453g;

/* compiled from: BaseOffsetPool.java */
/* renamed from: org.d.b.i.b.e */
/* loaded from: classes.dex */
public abstract class AbstractC2405e<Key> extends C2406f<Key, Integer> implements InterfaceC2440q<Key> {
    public AbstractC2405e(C2409i c2409i) {
        super(c2409i);
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2440q
    /* renamed from: a */
    public Collection<? extends Map.Entry<? extends Key, Integer>> mo15176a() {
        return this.f12766b.entrySet();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2440q
    /* renamed from: f */
    public int mo15177f(Key key) {
        Integer num = (Integer) this.f12766b.get(key);
        if (num == null) {
            throw new C2453g("Item not found.: %s", m15178g(key));
        }
        return num.intValue();
    }

    /* renamed from: g */
    protected String m15178g(Key key) {
        return key.toString();
    }
}
