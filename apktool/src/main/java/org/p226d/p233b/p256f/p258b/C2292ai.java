package org.p226d.p233b.p256f.p258b;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2187aj;

/* compiled from: ImmutableSparseSwitchPayload.java */
/* renamed from: org.d.b.f.b.ai */
/* loaded from: classes.dex */
public class C2292ai extends AbstractC2295b implements InterfaceC2187aj {

    /* renamed from: a */
    public static final EnumC2272f f12463a = EnumC2272f.SPARSE_SWITCH_PAYLOAD;

    /* renamed from: b */
    protected final AbstractC1208w<? extends C2293aj> f12464b;

    public C2292ai(List<? extends InterfaceC2227o> list) {
        super(f12463a);
        this.f12464b = C2293aj.m14915a(list);
    }

    /* renamed from: a */
    public static C2292ai m14914a(InterfaceC2187aj interfaceC2187aj) {
        if (interfaceC2187aj instanceof C2292ai) {
            return (C2292ai) interfaceC2187aj;
        }
        return new C2292ai(interfaceC2187aj.mo14496f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2228p
    /* renamed from: f */
    public List<? extends InterfaceC2227o> mo14496f() {
        return this.f12464b;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (this.f12464b.size() * 4) + 2;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12463a.f12386ei;
    }
}
