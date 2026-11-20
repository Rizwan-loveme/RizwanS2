package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2188ak;

/* compiled from: ImmutableUnknownInstruction.java */
/* renamed from: org.d.b.f.b.ak */
/* loaded from: classes.dex */
public class C2294ak extends AbstractC2295b implements InterfaceC2188ak {

    /* renamed from: a */
    public static final EnumC2076d f12468a = EnumC2076d.Format10x;

    /* renamed from: b */
    protected final int f12469b;

    public C2294ak(int i) {
        super(EnumC2272f.NOP);
        this.f12469b = i;
    }

    /* renamed from: a */
    public static C2294ak m14917a(InterfaceC2188ak interfaceC2188ak) {
        return interfaceC2188ak instanceof C2294ak ? (C2294ak) interfaceC2188ak : new C2294ak(interfaceC2188ak.mo14631s_());
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12468a;
    }

    @Override // org.p226d.p233b.p250e.p252b.p253a.InterfaceC2188ak
    /* renamed from: s_ */
    public int mo14631s_() {
        return this.f12469b;
    }
}
