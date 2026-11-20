package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2195h;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction20t.java */
/* renamed from: org.d.b.f.b.i */
/* loaded from: classes.dex */
public class C2302i extends AbstractC2295b implements InterfaceC2195h {

    /* renamed from: a */
    public static final EnumC2076d f12487a = EnumC2076d.Format20t;

    /* renamed from: b */
    protected final int f12488b;

    public C2302i(EnumC2272f enumC2272f, int i) {
        super(enumC2272f);
        this.f12488b = C2388h.m15108i(i);
    }

    /* renamed from: a */
    public static C2302i m14927a(InterfaceC2195h interfaceC2195h) {
        if (interfaceC2195h instanceof C2302i) {
            return (C2302i) interfaceC2195h;
        }
        return new C2302i(interfaceC2195h.mo14416a(), interfaceC2195h.mo14507e());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2222j
    /* renamed from: e */
    public int mo14507e() {
        return this.f12488b;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12487a;
    }
}
