package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2204q;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction22s.java */
/* renamed from: org.d.b.f.b.r */
/* loaded from: classes.dex */
public class C2311r extends AbstractC2295b implements InterfaceC2204q {

    /* renamed from: a */
    public static final EnumC2076d f12516a = EnumC2076d.Format22s;

    /* renamed from: b */
    protected final int f12517b;

    /* renamed from: c */
    protected final int f12518c;

    /* renamed from: e */
    protected final int f12519e;

    public C2311r(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f12517b = C2388h.m15097a(i);
        this.f12518c = C2388h.m15097a(i2);
        this.f12519e = C2388h.m15105f(i3);
    }

    /* renamed from: a */
    public static C2311r m14938a(InterfaceC2204q interfaceC2204q) {
        if (interfaceC2204q instanceof C2311r) {
            return (C2311r) interfaceC2204q;
        }
        return new C2311r(interfaceC2204q.mo14416a(), interfaceC2204q.mo14495q_(), interfaceC2204q.mo14500r_(), interfaceC2204q.mo14499f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12517b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12518c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f12519e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12519e;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12516a;
    }
}
