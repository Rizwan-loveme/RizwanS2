package org.p226d.p233b.p256f.p257a;

import org.p226d.p233b.p250e.p251a.InterfaceC2172g;

/* compiled from: ImmutableRestartLocal.java */
/* renamed from: org.d.b.f.a.f */
/* loaded from: classes.dex */
public class C2279f extends AbstractC2274a implements InterfaceC2172g {

    /* renamed from: b */
    protected final int f12403b;

    /* renamed from: c */
    protected final String f12404c;

    /* renamed from: d */
    protected final String f12405d;

    /* renamed from: e */
    protected final String f12406e;

    public C2279f(int i, int i2, String str, String str2, String str3) {
        super(i);
        this.f12403b = i2;
        this.f12404c = str;
        this.f12405d = str2;
        this.f12406e = str3;
    }

    /* renamed from: a */
    public static C2279f m14897a(InterfaceC2172g interfaceC2172g) {
        if (interfaceC2172g instanceof C2279f) {
            return (C2279f) interfaceC2172g;
        }
        return new C2279f(interfaceC2172g.mo14461a(), interfaceC2172g.mo14467e(), interfaceC2172g.mo14465l(), interfaceC2172g.mo14220b(), interfaceC2172g.mo14452c());
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2172g
    /* renamed from: e */
    public int mo14467e() {
        return this.f12403b;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: b */
    public String mo14220b() {
        return this.f12404c;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: l */
    public String mo14465l() {
        return this.f12405d;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: c */
    public String mo14452c() {
        return this.f12406e;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: f */
    public int mo14464f() {
        return 6;
    }
}
