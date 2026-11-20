package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2203p;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction22cs.java */
/* renamed from: org.d.b.c.b.p */
/* loaded from: classes.dex */
public class C2052p extends AbstractC2063c implements InterfaceC2203p {

    /* renamed from: c */
    public static final EnumC2076d f11678c = EnumC2076d.Format22cs;

    /* renamed from: d */
    protected final int f11679d;

    /* renamed from: e */
    protected final int f11680e;

    /* renamed from: f */
    protected final int f11681f;

    public C2052p(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f11679d = C2388h.m15097a(i);
        this.f11680e = C2388h.m15097a(i2);
        this.f11681f = i3;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11679d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11680e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2214b
    /* renamed from: g */
    public int mo14503g() {
        return this.f11681f;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11678c;
    }
}
