package org.p226d.p233b.p264i.p266b;

import java.util.Collection;
import java.util.Map;
import org.p226d.p233b.p264i.InterfaceC2434k;
import org.p226d.p269d.C2453g;

/* compiled from: BaseIndexPool.java */
/* renamed from: org.d.b.i.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC2403c<Key> extends C2406f<Key, Integer> implements InterfaceC2434k<Key> {
    public AbstractC2403c(C2409i c2409i) {
        super(c2409i);
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2434k
    /* renamed from: b */
    public Collection<? extends Map.Entry<? extends Key, Integer>> mo15173b() {
        return this.f12766b.entrySet();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2434k
    /* renamed from: B */
    public int mo15172B(Key key) {
        Integer num = (Integer) this.f12766b.get(key);
        if (num == null) {
            throw new C2453g("Item not found.: %s", m15174d(key));
        }
        return num.intValue();
    }

    /* renamed from: d */
    protected String m15174d(Key key) {
        return key.toString();
    }
}
