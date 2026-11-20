package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2202o;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction22c.java */
/* renamed from: org.d.b.c.b.o */
/* loaded from: classes.dex */
public class C2051o extends AbstractC2063c implements InterfaceC2202o {

    /* renamed from: c */
    public static final EnumC2076d f11674c = EnumC2076d.Format22c;

    /* renamed from: d */
    protected final int f11675d;

    /* renamed from: e */
    protected final int f11676e;

    /* renamed from: f */
    protected final InterfaceC2241f f11677f;

    public C2051o(EnumC2272f enumC2272f, int i, int i2, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f11675d = C2388h.m15097a(i);
        this.f11676e = C2388h.m15097a(i2);
        this.f11677f = interfaceC2241f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11675d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11676e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return this.f11677f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f11716a.f12385eh;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11674c;
    }
}
