package org.p226d.p233b.p256f.p261e;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Collection;
import org.p226d.p233b.p238b.p240b.AbstractC1996b;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: ImmutableArrayEncodedValue.java */
/* renamed from: org.d.b.f.e.b */
/* loaded from: classes.dex */
public class C2335b extends AbstractC1996b implements InterfaceC2340g {

    /* renamed from: a */
    protected final AbstractC1208w<? extends InterfaceC2340g> f12588a;

    public C2335b(Collection<? extends InterfaceC2251g> collection) {
        this.f12588a = C2341h.m14984a(collection);
    }

    public C2335b(AbstractC1208w<InterfaceC2340g> abstractC1208w) {
        this.f12588a = abstractC1208w;
    }

    /* renamed from: a */
    public static C2335b m14977a(InterfaceC2246b interfaceC2246b) {
        return interfaceC2246b instanceof C2335b ? (C2335b) interfaceC2246b : new C2335b(interfaceC2246b.mo14733b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2246b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<? extends InterfaceC2340g> mo14733b() {
        return this.f12588a;
    }
}
