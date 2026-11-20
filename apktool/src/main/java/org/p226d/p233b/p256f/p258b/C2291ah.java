package org.p226d.p233b.p256f.p258b;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2186ai;

/* compiled from: ImmutablePackedSwitchPayload.java */
/* renamed from: org.d.b.f.b.ah */
/* loaded from: classes.dex */
public class C2291ah extends AbstractC2295b implements InterfaceC2186ai {

    /* renamed from: a */
    public static final EnumC2272f f12461a = EnumC2272f.PACKED_SWITCH_PAYLOAD;

    /* renamed from: b */
    protected final AbstractC1208w<? extends C2293aj> f12462b;

    public C2291ah(List<? extends InterfaceC2227o> list) {
        super(f12461a);
        this.f12462b = C2293aj.m14915a(list);
    }

    /* renamed from: a */
    public static C2291ah m14913a(InterfaceC2186ai interfaceC2186ai) {
        if (interfaceC2186ai instanceof C2291ah) {
            return (C2291ah) interfaceC2186ai;
        }
        return new C2291ah(interfaceC2186ai.mo14496f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2228p
    /* renamed from: f */
    public List<? extends InterfaceC2227o> mo14496f() {
        return this.f12462b;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (this.f12462b.size() * 2) + 4;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12461a.f12386ei;
    }
}
