package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p256f.p257a.AbstractC2274a;
import org.p226d.p233b.p256f.p258b.AbstractC2295b;

/* compiled from: ImmutableMethodImplementation.java */
/* renamed from: org.d.b.f.h */
/* loaded from: classes.dex */
public class C2356h implements InterfaceC2268i {

    /* renamed from: a */
    protected final int f12623a;

    /* renamed from: b */
    protected final AbstractC1208w<? extends AbstractC2295b> f12624b;

    /* renamed from: c */
    protected final AbstractC1208w<? extends C2358j> f12625c;

    /* renamed from: d */
    protected final AbstractC1208w<? extends AbstractC2274a> f12626d;

    public C2356h(int i, Iterable<? extends InterfaceC2218f> iterable, List<? extends InterfaceC2271l<? extends InterfaceC2265f>> list, Iterable<? extends InterfaceC2166a> iterable2) {
        this.f12623a = i;
        this.f12624b = AbstractC2295b.m14918a(iterable);
        this.f12625c = C2358j.m15019a(list);
        this.f12626d = AbstractC2274a.m14891a(iterable2);
    }

    /* renamed from: a */
    public static C2356h m15013a(InterfaceC2268i interfaceC2268i) {
        if (interfaceC2268i == null) {
            return null;
        }
        if (interfaceC2268i instanceof C2356h) {
            return (C2356h) interfaceC2268i;
        }
        return new C2356h(interfaceC2268i.mo14611d(), interfaceC2268i.mo14608b(), interfaceC2268i.mo14612e(), interfaceC2268i.mo14601a());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: d */
    public int mo14611d() {
        return this.f12623a;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<? extends AbstractC2295b> mo14608b() {
        return this.f12624b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<? extends C2358j> mo14612e() {
        return this.f12625c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<? extends AbstractC2274a> mo14601a() {
        return this.f12626d;
    }
}
