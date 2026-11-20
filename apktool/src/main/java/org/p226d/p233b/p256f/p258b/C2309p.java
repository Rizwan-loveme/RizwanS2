package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2202o;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p256f.p259c.C2327g;
import org.p226d.p233b.p256f.p259c.InterfaceC2326f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction22c.java */
/* renamed from: org.d.b.f.b.p */
/* loaded from: classes.dex */
public class C2309p extends AbstractC2295b implements InterfaceC2202o {

    /* renamed from: a */
    public static final EnumC2076d f12508a = EnumC2076d.Format22c;

    /* renamed from: b */
    protected final int f12509b;

    /* renamed from: c */
    protected final int f12510c;

    /* renamed from: e */
    protected final InterfaceC2326f f12511e;

    public C2309p(EnumC2272f enumC2272f, int i, int i2, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f12509b = C2388h.m15097a(i);
        this.f12510c = C2388h.m15097a(i2);
        this.f12511e = C2327g.m14964a(enumC2272f.f12385eh, interfaceC2241f);
    }

    /* renamed from: a */
    public static C2309p m14935a(InterfaceC2202o interfaceC2202o) {
        if (interfaceC2202o instanceof C2309p) {
            return (C2309p) interfaceC2202o;
        }
        return new C2309p(interfaceC2202o.mo14416a(), interfaceC2202o.mo14495q_(), interfaceC2202o.mo14500r_(), interfaceC2202o.mo14489f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12509b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12510c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC2326f mo14489f() {
        return this.f12511e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f12471d.f12385eh;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12508a;
    }
}
