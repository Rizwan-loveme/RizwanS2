package org.p226d.p233b.p256f.p259c;

import org.p226d.p233b.p238b.p239a.AbstractC1988b;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;

/* compiled from: ImmutableFieldReference.java */
/* renamed from: org.d.b.f.c.b */
/* loaded from: classes.dex */
public class C2322b extends AbstractC1988b implements InterfaceC2326f {

    /* renamed from: a */
    protected final String f12563a;

    /* renamed from: b */
    protected final String f12564b;

    /* renamed from: c */
    protected final String f12565c;

    public C2322b(String str, String str2, String str3) {
        this.f12563a = str;
        this.f12564b = str2;
        this.f12565c = str3;
    }

    /* renamed from: b */
    public static C2322b m14959b(InterfaceC2237b interfaceC2237b) {
        if (interfaceC2237b instanceof C2322b) {
            return (C2322b) interfaceC2237b;
        }
        return new C2322b(interfaceC2237b.mo14225d(), interfaceC2237b.mo14226e(), interfaceC2237b.mo14227f());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: d */
    public String mo14225d() {
        return this.f12563a;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: e */
    public String mo14226e() {
        return this.f12564b;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: f */
    public String mo14227f() {
        return this.f12565c;
    }
}
