package org.p226d.p233b.p256f.p257a;

import org.p226d.p233b.p250e.p251a.InterfaceC2167b;

/* compiled from: ImmutableEndLocal.java */
/* renamed from: org.d.b.f.a.b */
/* loaded from: classes.dex */
public class C2275b extends AbstractC2274a implements InterfaceC2167b {

    /* renamed from: b */
    protected final int f12398b;

    /* renamed from: c */
    protected final String f12399c;

    /* renamed from: d */
    protected final String f12400d;

    /* renamed from: e */
    protected final String f12401e;

    public C2275b(int i, int i2, String str, String str2, String str3) {
        super(i);
        this.f12398b = i2;
        this.f12399c = str;
        this.f12400d = str2;
        this.f12401e = str3;
    }

    /* renamed from: a */
    public static C2275b m14893a(InterfaceC2167b interfaceC2167b) {
        if (interfaceC2167b instanceof C2275b) {
            return (C2275b) interfaceC2167b;
        }
        return new C2275b(interfaceC2167b.mo14461a(), interfaceC2167b.mo14463e(), interfaceC2167b.mo14465l(), interfaceC2167b.mo14220b(), interfaceC2167b.mo14452c());
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2167b
    /* renamed from: e */
    public int mo14463e() {
        return this.f12398b;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: b */
    public String mo14220b() {
        return this.f12399c;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: l */
    public String mo14465l() {
        return this.f12400d;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: c */
    public String mo14452c() {
        return this.f12401e;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: f */
    public int mo14464f() {
        return 5;
    }
}
