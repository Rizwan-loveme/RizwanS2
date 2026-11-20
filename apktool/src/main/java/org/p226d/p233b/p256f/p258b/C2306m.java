package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2199l;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction21s.java */
/* renamed from: org.d.b.f.b.m */
/* loaded from: classes.dex */
public class C2306m extends AbstractC2295b implements InterfaceC2199l {

    /* renamed from: a */
    public static final EnumC2076d f12498a = EnumC2076d.Format21s;

    /* renamed from: b */
    protected final int f12499b;

    /* renamed from: c */
    protected final int f12500c;

    public C2306m(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12499b = C2388h.m15101b(i);
        this.f12500c = C2388h.m15105f(i2);
    }

    /* renamed from: a */
    public static C2306m m14932a(InterfaceC2199l interfaceC2199l) {
        if (interfaceC2199l instanceof C2306m) {
            return (C2306m) interfaceC2199l;
        }
        return new C2306m(interfaceC2199l.mo14416a(), interfaceC2199l.mo14495q_(), interfaceC2199l.mo14499f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12499b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f12500c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12500c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12498a;
    }
}
