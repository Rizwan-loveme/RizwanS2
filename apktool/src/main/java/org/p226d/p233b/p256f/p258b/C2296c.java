package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2189b;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction10t.java */
/* renamed from: org.d.b.f.b.c */
/* loaded from: classes.dex */
public class C2296c extends AbstractC2295b implements InterfaceC2189b {

    /* renamed from: a */
    public static final EnumC2076d f12473a = EnumC2076d.Format10t;

    /* renamed from: b */
    protected final int f12474b;

    public C2296c(EnumC2272f enumC2272f, int i) {
        super(enumC2272f);
        this.f12474b = C2388h.m15107h(i);
    }

    /* renamed from: a */
    public static C2296c m14920a(InterfaceC2189b interfaceC2189b) {
        if (interfaceC2189b instanceof C2296c) {
            return (C2296c) interfaceC2189b;
        }
        return new C2296c(interfaceC2189b.mo14416a(), interfaceC2189b.mo14507e());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2222j
    /* renamed from: e */
    public int mo14507e() {
        return this.f12474b;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12473a;
    }
}
