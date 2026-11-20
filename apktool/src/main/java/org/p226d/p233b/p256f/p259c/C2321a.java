package org.p226d.p233b.p256f.p259c;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p238b.p239a.AbstractC1987a;
import org.p226d.p233b.p250e.p254c.InterfaceC2236a;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p256f.p261e.C2341h;
import org.p226d.p233b.p256f.p261e.InterfaceC2340g;
import org.p226d.p269d.C2456j;

/* compiled from: ImmutableCallSiteReference.java */
/* renamed from: org.d.b.f.c.a */
/* loaded from: classes.dex */
public class C2321a extends AbstractC1987a implements InterfaceC2326f {

    /* renamed from: a */
    protected final String f12558a;

    /* renamed from: b */
    protected final C2323c f12559b;

    /* renamed from: c */
    protected final String f12560c;

    /* renamed from: d */
    protected final C2324d f12561d;

    /* renamed from: e */
    protected final AbstractC1208w<? extends InterfaceC2340g> f12562e;

    public C2321a(String str, C2323c c2323c, String str2, C2324d c2324d, AbstractC1208w<? extends InterfaceC2340g> abstractC1208w) {
        this.f12558a = str;
        this.f12559b = c2323c;
        this.f12560c = str2;
        this.f12561d = c2324d;
        this.f12562e = C2456j.m15529a(abstractC1208w);
    }

    /* renamed from: a */
    public static C2321a m14958a(InterfaceC2236a interfaceC2236a) {
        if (interfaceC2236a instanceof C2321a) {
            return (C2321a) interfaceC2236a;
        }
        return new C2321a(interfaceC2236a.mo14678a(), C2323c.m14960b(interfaceC2236a.mo14679b()), interfaceC2236a.mo14680c(), C2324d.m14961b(interfaceC2236a.mo14681d()), C2341h.m14984a(interfaceC2236a.mo14682e()));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: a */
    public String mo14678a() {
        return this.f12558a;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: b */
    public InterfaceC2238c mo14679b() {
        return this.f12559b;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: c */
    public String mo14680c() {
        return this.f12560c;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: d */
    public InterfaceC2239d mo14681d() {
        return this.f12561d;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: e */
    public List<? extends InterfaceC2251g> mo14682e() {
        return this.f12562e;
    }
}
