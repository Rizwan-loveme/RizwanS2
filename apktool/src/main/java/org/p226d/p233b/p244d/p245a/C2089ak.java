package org.p226d.p233b.p244d.p245a;

import java.util.List;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.p248d.AbstractC2133d;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2187aj;

/* compiled from: DexBackedSparseSwitchPayload.java */
/* renamed from: org.d.b.d.a.ak */
/* loaded from: classes.dex */
public class C2089ak extends AbstractC2091b implements InterfaceC2187aj {

    /* renamed from: a */
    public final int f11820a;

    public C2089ak(C2153g c2153g, int i) {
        super(c2153g, EnumC2272f.SPARSE_SWITCH_PAYLOAD, i);
        this.f11820a = c2153g.m14617c(i + 2);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2228p
    /* renamed from: f */
    public List<? extends InterfaceC2227o> mo14496f() {
        return new AbstractC2133d<InterfaceC2227o>() { // from class: org.d.b.d.a.ak.1
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InterfaceC2227o mo14625b(final int i) {
                return new InterfaceC2227o() { // from class: org.d.b.d.a.ak.1.1
                    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2227o
                    /* renamed from: a */
                    public int mo14497a() {
                        return C2089ak.this.f11824d.m14621g(C2089ak.this.f11826f + 4 + (i * 4));
                    }

                    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2227o
                    /* renamed from: b */
                    public int mo14498b() {
                        return C2089ak.this.f11824d.m14621g(C2089ak.this.f11826f + 4 + (C2089ak.this.f11820a * 4) + (i * 4));
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2089ak.this.f11820a;
            }
        };
    }

    @Override // org.p226d.p233b.p244d.p245a.AbstractC2091b, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (this.f11820a * 4) + 2;
    }
}
