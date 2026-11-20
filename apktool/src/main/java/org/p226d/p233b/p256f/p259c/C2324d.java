package org.p226d.p233b.p256f.p259c;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p238b.p239a.AbstractC1990d;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p256f.p260d.C2331a;

/* compiled from: ImmutableMethodProtoReference.java */
/* renamed from: org.d.b.f.c.d */
/* loaded from: classes.dex */
public class C2324d extends AbstractC1990d implements InterfaceC2326f {

    /* renamed from: a */
    protected final AbstractC1208w<String> f12568a;

    /* renamed from: b */
    protected final String f12569b;

    public C2324d(Iterable<? extends CharSequence> iterable, String str) {
        this.f12568a = C2331a.m14968a(iterable);
        this.f12569b = str;
    }

    /* renamed from: b */
    public static C2324d m14961b(InterfaceC2239d interfaceC2239d) {
        if (interfaceC2239d instanceof C2324d) {
            return (C2324d) interfaceC2239d;
        }
        return new C2324d(interfaceC2239d.mo14685a(), interfaceC2239d.mo14686b());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2239d
    /* renamed from: a */
    public List<? extends CharSequence> mo14685a() {
        return this.f12568a;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2239d
    /* renamed from: b */
    public String mo14686b() {
        return this.f12569b;
    }
}
