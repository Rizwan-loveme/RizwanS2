package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2182ae;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction3rms.java */
/* renamed from: org.d.b.f.b.af */
/* loaded from: classes.dex */
public class C2289af extends AbstractC2295b implements InterfaceC2182ae {

    /* renamed from: a */
    public static final EnumC2076d f12454a = EnumC2076d.Format3rms;

    /* renamed from: b */
    protected final int f12455b;

    /* renamed from: c */
    protected final int f12456c;

    /* renamed from: e */
    protected final int f12457e;

    public C2289af(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f12455b = C2388h.m15102c(i);
        this.f12456c = C2388h.m15110k(i2);
        this.f12457e = C2388h.m15112m(i3);
    }

    /* renamed from: a */
    public static C2289af m14911a(InterfaceC2182ae interfaceC2182ae) {
        if (interfaceC2182ae instanceof C2289af) {
            return (C2289af) interfaceC2182ae;
        }
        return new C2289af(interfaceC2182ae.mo14416a(), interfaceC2182ae.mo14491h(), interfaceC2182ae.mo14481e(), interfaceC2182ae.mo14488f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
    /* renamed from: h */
    public int mo14491h() {
        return this.f12455b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f12456c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2233u
    /* renamed from: f */
    public int mo14488f() {
        return this.f12457e;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12454a;
    }
}
