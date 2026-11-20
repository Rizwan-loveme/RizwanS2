package org.p226d.p233b.p241c;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p238b.AbstractC2015e;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: BuilderTryBlock.java */
/* renamed from: org.d.b.c.f */
/* loaded from: classes.dex */
public class C2066f extends AbstractC2015e<AbstractC2025b> {

    /* renamed from: a */
    public final AbstractC2025b f11725a;

    /* renamed from: b */
    public final C2068h f11726b;

    /* renamed from: c */
    public final C2068h f11727c;

    public C2066f(C2068h c2068h, C2068h c2068h2, InterfaceC2243h interfaceC2243h, C2068h c2068h3) {
        this.f11726b = c2068h;
        this.f11727c = c2068h2;
        this.f11725a = AbstractC2025b.m14475a(interfaceC2243h, c2068h3);
    }

    public C2066f(C2068h c2068h, C2068h c2068h2, C2068h c2068h3) {
        this.f11726b = c2068h;
        this.f11727c = c2068h2;
        this.f11725a = AbstractC2025b.m14474a(c2068h3);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: a */
    public int mo14514a() {
        return this.f11726b.m14519a();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: b */
    public int mo14515b() {
        return this.f11727c.m14519a() - this.f11726b.m14519a();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: c */
    public List<? extends AbstractC2025b> mo14516c() {
        return AbstractC1208w.m10130a(this.f11725a);
    }
}
