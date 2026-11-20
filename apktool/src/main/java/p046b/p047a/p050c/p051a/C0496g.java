package p046b.p047a.p050c.p051a;

import java.util.LinkedHashMap;
import java.util.Map;
import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0460e;

/* compiled from: ResType.java */
/* renamed from: b.a.c.a.g */
/* loaded from: classes.dex */
public class C0496g {

    /* renamed from: a */
    private final C0468a f3455a;

    /* renamed from: b */
    private final Map<C0493d, C0494e> f3456b = new LinkedHashMap();

    public C0496g(C0468a c0468a) {
        this.f3455a = c0468a;
    }

    /* renamed from: a */
    public C0494e m3736a(C0493d c0493d) {
        C0494e c0494e = this.f3456b.get(c0493d);
        if (c0494e == null) {
            throw new C0460e(String.format("resource: spec=%s, config=%s", c0493d, this));
        }
        return c0494e;
    }

    /* renamed from: a */
    public C0468a m3735a() {
        return this.f3455a;
    }

    /* renamed from: a */
    public void m3737a(C0494e c0494e) {
        m3738a(c0494e, false);
    }

    /* renamed from: a */
    public void m3738a(C0494e c0494e, boolean z) {
        C0493d m3700c = c0494e.m3700c();
        if (this.f3456b.put(m3700c, c0494e) != null && !z) {
            throw new C0461b(String.format("Multiple resources: spec=%s, config=%s", m3700c, this));
        }
    }

    public String toString() {
        return this.f3455a.toString();
    }
}
