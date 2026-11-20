package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2198k;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction21lh.java */
/* renamed from: org.d.b.f.b.l */
/* loaded from: classes.dex */
public class C2305l extends AbstractC2295b implements InterfaceC2198k {

    /* renamed from: a */
    public static final EnumC2076d f12495a = EnumC2076d.Format21lh;

    /* renamed from: b */
    protected final int f12496b;

    /* renamed from: c */
    protected final long f12497c;

    public C2305l(EnumC2272f enumC2272f, int i, long j) {
        super(enumC2272f);
        this.f12496b = C2388h.m15101b(i);
        this.f12497c = C2388h.m15098a(j);
    }

    /* renamed from: a */
    public static C2305l m14931a(InterfaceC2198k interfaceC2198k) {
        if (interfaceC2198k instanceof C2305l) {
            return (C2305l) interfaceC2198k;
        }
        return new C2305l(interfaceC2198k.mo14416a(), interfaceC2198k.mo14495q_(), interfaceC2198k.mo14494g());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12496b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12497c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2216d
    /* renamed from: h */
    public short mo14502h() {
        return (short) (this.f12497c >>> 48);
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12495a;
    }
}
