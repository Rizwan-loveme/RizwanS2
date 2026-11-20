package org.p226d.p233b.p264i.p266b;

import com.p129f.p130a.p133c.C1157aj;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BasePool.java */
/* renamed from: org.d.b.i.b.f */
/* loaded from: classes.dex */
public class C2406f<Key, Value> implements InterfaceC2412l {

    /* renamed from: a */
    protected final C2409i f12765a;

    /* renamed from: b */
    protected final Map<Key, Value> f12766b = C1157aj.m9936d();

    /* renamed from: c */
    private int f12767c = -1;

    public C2406f(C2409i c2409i) {
        this.f12765a = c2409i;
    }

    @Override // org.p226d.p233b.p264i.p266b.InterfaceC2412l
    /* renamed from: d */
    public void mo15180d() {
        this.f12767c = this.f12766b.size();
    }

    @Override // org.p226d.p233b.p264i.p266b.InterfaceC2412l
    /* renamed from: e */
    public void mo15181e() {
        if (this.f12767c < 0) {
            throw new IllegalStateException("mark() must be called before calling reset()");
        }
        if (this.f12767c != this.f12766b.size()) {
            Iterator<Key> it = this.f12766b.keySet().iterator();
            for (int i = 0; i < this.f12767c; i++) {
                it.next();
            }
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    /* renamed from: c */
    public int m15179c() {
        return this.f12766b.size();
    }
}
