package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2205r;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction22t.java */
/* renamed from: org.d.b.f.b.s */
/* loaded from: classes.dex */
public class C2312s extends AbstractC2295b implements InterfaceC2205r {

    /* renamed from: a */
    public static final EnumC2076d f12520a = EnumC2076d.Format22t;

    /* renamed from: b */
    protected final int f12521b;

    /* renamed from: c */
    protected final int f12522c;

    /* renamed from: e */
    protected final int f12523e;

    public C2312s(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f12521b = C2388h.m15097a(i);
        this.f12522c = C2388h.m15097a(i2);
        this.f12523e = C2388h.m15108i(i3);
    }

    /* renamed from: a */
    public static C2312s m14939a(InterfaceC2205r interfaceC2205r) {
        if (interfaceC2205r instanceof C2312s) {
            return (C2312s) interfaceC2205r;
        }
        return new C2312s(interfaceC2205r.mo14416a(), interfaceC2205r.mo14495q_(), interfaceC2205r.mo14500r_(), interfaceC2205r.mo14507e());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12521b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12522c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2222j
    /* renamed from: e */
    public int mo14507e() {
        return this.f12523e;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12520a;
    }
}
