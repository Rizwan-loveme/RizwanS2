package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2208u;

/* compiled from: ImmutableInstruction30t.java */
/* renamed from: org.d.b.f.b.v */
/* loaded from: classes.dex */
public class C2315v extends AbstractC2295b implements InterfaceC2208u {

    /* renamed from: a */
    public static final EnumC2076d f12531a = EnumC2076d.Format30t;

    /* renamed from: b */
    protected final int f12532b;

    public C2315v(EnumC2272f enumC2272f, int i) {
        super(enumC2272f);
        this.f12532b = i;
    }

    /* renamed from: a */
    public static C2315v m14942a(InterfaceC2208u interfaceC2208u) {
        if (interfaceC2208u instanceof C2315v) {
            return (C2315v) interfaceC2208u;
        }
        return new C2315v(interfaceC2208u.mo14416a(), interfaceC2208u.mo14507e());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2222j
    /* renamed from: e */
    public int mo14507e() {
        return this.f12532b;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12531a;
    }
}
