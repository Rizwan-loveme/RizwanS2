package org.p226d.p233b.p241c;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction.java */
/* renamed from: org.d.b.c.c */
/* loaded from: classes.dex */
public abstract class AbstractC2063c implements InterfaceC2218f {

    /* renamed from: a */
    protected final EnumC2272f f11716a;

    /* renamed from: b */
    C2073m f11717b;

    /* renamed from: c */
    public abstract EnumC2076d mo14478c();

    protected AbstractC2063c(EnumC2272f enumC2272f) {
        C2388h.m15100a(enumC2272f, mo14478c());
        this.f11716a = enumC2272f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: a */
    public EnumC2272f mo14416a() {
        return this.f11716a;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return mo14478c().f11799L / 2;
    }

    /* renamed from: d */
    public C2073m m14505d() {
        if (this.f11717b == null) {
            throw new IllegalStateException("Cannot get the location of an instruction that hasn't been added to a method.");
        }
        return this.f11717b;
    }
}
