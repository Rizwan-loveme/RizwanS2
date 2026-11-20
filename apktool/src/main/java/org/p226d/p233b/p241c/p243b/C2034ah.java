package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2185ah;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction51l.java */
/* renamed from: org.d.b.c.b.ah */
/* loaded from: classes.dex */
public class C2034ah extends AbstractC2063c implements InterfaceC2185ah {

    /* renamed from: c */
    public static final EnumC2076d f11630c = EnumC2076d.Format51l;

    /* renamed from: d */
    protected final int f11631d;

    /* renamed from: e */
    protected final long f11632e;

    public C2034ah(EnumC2272f enumC2272f, int i, long j) {
        super(enumC2272f);
        this.f11631d = C2388h.m15101b(i);
        this.f11632e = j;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11631d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f11632e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11630c;
    }
}
