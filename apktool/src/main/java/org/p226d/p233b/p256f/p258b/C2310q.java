package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2203p;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction22cs.java */
/* renamed from: org.d.b.f.b.q */
/* loaded from: classes.dex */
public class C2310q extends AbstractC2295b implements InterfaceC2203p {

    /* renamed from: a */
    public static final EnumC2076d f12512a = EnumC2076d.Format22cs;

    /* renamed from: b */
    protected final int f12513b;

    /* renamed from: c */
    protected final int f12514c;

    /* renamed from: e */
    protected final int f12515e;

    public C2310q(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f12513b = C2388h.m15097a(i);
        this.f12514c = C2388h.m15097a(i2);
        this.f12515e = C2388h.m15111l(i3);
    }

    /* renamed from: a */
    public static C2310q m14937a(InterfaceC2203p interfaceC2203p) {
        if (interfaceC2203p instanceof C2310q) {
            return (C2310q) interfaceC2203p;
        }
        return new C2310q(interfaceC2203p.mo14416a(), interfaceC2203p.mo14495q_(), interfaceC2203p.mo14500r_(), interfaceC2203p.mo14503g());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12513b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12514c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2214b
    /* renamed from: g */
    public int mo14503g() {
        return this.f12515e;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12512a;
    }
}
