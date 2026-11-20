package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2196i;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p256f.p259c.C2327g;
import org.p226d.p233b.p256f.p259c.InterfaceC2326f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction21c.java */
/* renamed from: org.d.b.f.b.j */
/* loaded from: classes.dex */
public class C2303j extends AbstractC2295b implements InterfaceC2196i {

    /* renamed from: a */
    public static final EnumC2076d f12489a = EnumC2076d.Format21c;

    /* renamed from: b */
    protected final int f12490b;

    /* renamed from: c */
    protected final InterfaceC2326f f12491c;

    public C2303j(EnumC2272f enumC2272f, int i, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f12490b = C2388h.m15101b(i);
        this.f12491c = C2327g.m14964a(enumC2272f.f12385eh, interfaceC2241f);
    }

    /* renamed from: a */
    public static C2303j m14928a(InterfaceC2196i interfaceC2196i) {
        if (interfaceC2196i instanceof C2303j) {
            return (C2303j) interfaceC2196i;
        }
        return new C2303j(interfaceC2196i.mo14416a(), interfaceC2196i.mo14495q_(), interfaceC2196i.mo14489f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12490b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC2326f mo14489f() {
        return this.f12491c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f12471d.f12385eh;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12489a;
    }
}
