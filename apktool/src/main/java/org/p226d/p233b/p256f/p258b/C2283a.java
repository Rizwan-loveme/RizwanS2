package org.p226d.p233b.p256f.p258b;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Collection;
import java.util.List;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;

/* compiled from: ImmutableArrayPayload.java */
/* renamed from: org.d.b.f.b.a */
/* loaded from: classes.dex */
public class C2283a extends AbstractC2295b implements InterfaceC2177a {

    /* renamed from: a */
    public static final EnumC2272f f12419a = EnumC2272f.ARRAY_PAYLOAD;

    /* renamed from: b */
    protected final int f12420b;

    /* renamed from: c */
    protected final AbstractC1208w<Number> f12421c;

    public C2283a(int i, List<Number> list) {
        super(f12419a);
        this.f12420b = i;
        this.f12421c = list == null ? AbstractC1208w.m10138g() : AbstractC1208w.m10132a((Collection) list);
    }

    /* renamed from: a */
    public static C2283a m14902a(InterfaceC2177a interfaceC2177a) {
        if (interfaceC2177a instanceof C2283a) {
            return (C2283a) interfaceC2177a;
        }
        return new C2283a(interfaceC2177a.mo14479e(), interfaceC2177a.mo14480f());
    }

    @Override // org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a
    /* renamed from: e */
    public int mo14479e() {
        return this.f12420b;
    }

    @Override // org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a
    /* renamed from: f */
    public List<Number> mo14480f() {
        return this.f12421c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (((this.f12420b * this.f12421c.size()) + 1) / 2) + 4;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12419a.f12386ei;
    }
}
