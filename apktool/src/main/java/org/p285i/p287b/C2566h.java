package org.p285i.p287b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.p285i.InterfaceC2553a;
import org.p285i.InterfaceC2558b;
import org.p285i.p286a.C2557d;

/* compiled from: SubstituteLoggerFactory.java */
/* renamed from: org.i.b.h */
/* loaded from: classes.dex */
public class C2566h implements InterfaceC2553a {

    /* renamed from: a */
    boolean f13348a = false;

    /* renamed from: b */
    final Map<String, C2565g> f13349b = new HashMap();

    /* renamed from: c */
    final LinkedBlockingQueue<C2557d> f13350c = new LinkedBlockingQueue<>();

    @Override // org.p285i.InterfaceC2553a
    /* renamed from: a */
    public synchronized InterfaceC2558b mo15926a(String str) {
        C2565g c2565g;
        c2565g = this.f13349b.get(str);
        if (c2565g == null) {
            c2565g = new C2565g(str, this.f13350c, this.f13348a);
            this.f13349b.put(str, c2565g);
        }
        return c2565g;
    }

    /* renamed from: a */
    public List<C2565g> m15983a() {
        return new ArrayList(this.f13349b.values());
    }

    /* renamed from: b */
    public LinkedBlockingQueue<C2557d> m15984b() {
        return this.f13350c;
    }

    /* renamed from: c */
    public void m15985c() {
        this.f13348a = true;
    }

    /* renamed from: d */
    public void m15986d() {
        this.f13349b.clear();
        this.f13350c.clear();
    }
}
