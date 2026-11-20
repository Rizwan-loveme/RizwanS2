package org.p226d.p233b.p256f.p257a;

import org.p226d.p233b.p238b.p239a.AbstractC1992f;
import org.p226d.p233b.p250e.p251a.InterfaceC2173h;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;

/* compiled from: ImmutableSetSourceFile.java */
/* renamed from: org.d.b.f.a.g */
/* loaded from: classes.dex */
public class C2280g extends AbstractC2274a implements InterfaceC2173h {

    /* renamed from: b */
    protected final String f12407b;

    public C2280g(int i, String str) {
        super(i);
        this.f12407b = str;
    }

    /* renamed from: a */
    public static C2280g m14898a(InterfaceC2173h interfaceC2173h) {
        if (interfaceC2173h instanceof C2280g) {
            return (C2280g) interfaceC2173h;
        }
        return new C2280g(interfaceC2173h.mo14461a(), interfaceC2173h.mo14468b());
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2173h
    /* renamed from: b */
    public String mo14468b() {
        return this.f12407b;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2173h
    /* renamed from: c */
    public InterfaceC2242g mo14469c() {
        if (this.f12407b == null) {
            return null;
        }
        return new AbstractC1992f() { // from class: org.d.b.f.a.g.1
            @Override // org.p226d.p233b.p250e.p254c.InterfaceC2242g
            /* renamed from: a */
            public String mo14691a() {
                return C2280g.this.f12407b;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: f */
    public int mo14464f() {
        return 9;
    }
}
