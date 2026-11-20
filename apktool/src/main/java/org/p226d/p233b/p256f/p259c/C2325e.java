package org.p226d.p233b.p256f.p259c;

import com.p129f.p130a.p133c.AbstractC1208w;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p256f.p260d.C2331a;

/* compiled from: ImmutableMethodReference.java */
/* renamed from: org.d.b.f.c.e */
/* loaded from: classes.dex */
public class C2325e extends AbstractC1991e implements InterfaceC2326f {

    /* renamed from: a */
    protected final String f12570a;

    /* renamed from: b */
    protected final String f12571b;

    /* renamed from: c */
    protected final AbstractC1208w<String> f12572c;

    /* renamed from: d */
    protected final String f12573d;

    public C2325e(String str, String str2, Iterable<? extends CharSequence> iterable, String str3) {
        this.f12570a = str;
        this.f12571b = str2;
        this.f12572c = C2331a.m14968a(iterable);
        this.f12573d = str3;
    }

    /* renamed from: b */
    public static C2325e m14962b(InterfaceC2240e interfaceC2240e) {
        if (interfaceC2240e instanceof C2325e) {
            return (C2325e) interfaceC2240e;
        }
        return new C2325e(interfaceC2240e.mo14209a(), interfaceC2240e.mo14210b(), interfaceC2240e.mo14211c(), interfaceC2240e.mo14212d());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: a */
    public String mo14209a() {
        return this.f12570a;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: b */
    public String mo14210b() {
        return this.f12571b;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<String> mo14211c() {
        return this.f12572c;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: d */
    public String mo14212d() {
        return this.f12573d;
    }
}
