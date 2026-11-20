package org.p226d.p233b.p256f.p261e;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.util.Collection;
import org.p226d.p233b.p238b.p240b.AbstractC1995a;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;
import org.p226d.p233b.p256f.C2282b;

/* compiled from: ImmutableAnnotationEncodedValue.java */
/* renamed from: org.d.b.f.e.a */
/* loaded from: classes.dex */
public class C2334a extends AbstractC1995a implements InterfaceC2340g {

    /* renamed from: a */
    protected final String f12586a;

    /* renamed from: b */
    protected final AbstractC1148aa<? extends C2282b> f12587b;

    public C2334a(String str, Collection<? extends InterfaceC2175b> collection) {
        this.f12586a = str;
        this.f12587b = C2282b.m14900a(collection);
    }

    /* renamed from: a */
    public static C2334a m14975a(InterfaceC2245a interfaceC2245a) {
        if (interfaceC2245a instanceof C2334a) {
            return (C2334a) interfaceC2245a;
        }
        return new C2334a(interfaceC2245a.mo14672b(), interfaceC2245a.mo14673c());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2245a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: b */
    public String mo14672b() {
        return this.f12586a;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2245a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2282b> mo14673c() {
        return this.f12587b;
    }
}
