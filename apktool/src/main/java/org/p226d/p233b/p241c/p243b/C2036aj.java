package org.p226d.p233b.p241c.p243b;

import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1156ai;
import java.util.List;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2065e;
import org.p226d.p233b.p241c.C2075o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2187aj;

/* compiled from: BuilderSparseSwitchPayload.java */
/* renamed from: org.d.b.c.b.aj */
/* loaded from: classes.dex */
public class C2036aj extends AbstractC2065e implements InterfaceC2187aj {

    /* renamed from: d */
    public static final EnumC2272f f11635d = EnumC2272f.SPARSE_SWITCH_PAYLOAD;

    /* renamed from: e */
    protected final List<C2037ak> f11636e;

    public C2036aj(List<? extends C2075o> list) {
        super(f11635d);
        if (list == null) {
            this.f11636e = AbstractC1208w.m10138g();
        } else {
            this.f11636e = C1156ai.m9914a((List) list, (InterfaceC1112g) new InterfaceC1112g<C2075o, C2037ak>() { // from class: org.d.b.c.b.aj.1

                /* renamed from: a */
                static final /* synthetic */ boolean f11637a;

                static {
                    f11637a = !C2036aj.class.desiredAssertionStatus();
                }

                @Override // com.p129f.p130a.p131a.InterfaceC1112g
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public C2037ak mo9517a(C2075o c2075o) {
                    if (f11637a || c2075o != null) {
                        return new C2037ak(C2036aj.this, c2075o.f11759a, c2075o.f11760b);
                    }
                    throw new AssertionError();
                }
            });
        }
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2228p
    /* renamed from: f */
    public List<C2037ak> mo14496f() {
        return this.f11636e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (this.f11636e.size() * 4) + 2;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11635d.f12386ei;
    }
}
