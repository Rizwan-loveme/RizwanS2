package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.util.Collection;
import org.p226d.p233b.p238b.AbstractC1986a;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p269d.AbstractC2455i;
import org.p226d.p269d.C2456j;

/* compiled from: ImmutableAnnotation.java */
/* renamed from: org.d.b.f.a */
/* loaded from: classes.dex */
public class C2273a extends AbstractC1986a {

    /* renamed from: e */
    private static final AbstractC2455i<C2273a, InterfaceC2165a> f12389e = new AbstractC2455i<C2273a, InterfaceC2165a>() { // from class: org.d.b.f.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2165a interfaceC2165a) {
            return interfaceC2165a instanceof C2273a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2273a mo14889a(InterfaceC2165a interfaceC2165a) {
            return C2273a.m14887b(interfaceC2165a);
        }
    };

    /* renamed from: b */
    protected final int f12390b;

    /* renamed from: c */
    protected final String f12391c;

    /* renamed from: d */
    protected final AbstractC1148aa<? extends C2282b> f12392d;

    public C2273a(int i, String str, Collection<? extends InterfaceC2175b> collection) {
        this.f12390b = i;
        this.f12391c = str;
        this.f12392d = C2282b.m14900a(collection);
    }

    public C2273a(int i, String str, AbstractC1148aa<? extends C2282b> abstractC1148aa) {
        this.f12390b = i;
        this.f12391c = str;
        this.f12392d = C2456j.m15527a(abstractC1148aa);
    }

    /* renamed from: b */
    public static C2273a m14887b(InterfaceC2165a interfaceC2165a) {
        if (interfaceC2165a instanceof C2273a) {
            return (C2273a) interfaceC2165a;
        }
        return new C2273a(interfaceC2165a.mo14671a(), interfaceC2165a.mo14672b(), interfaceC2165a.mo14673c());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2165a
    /* renamed from: a */
    public int mo14671a() {
        return this.f12390b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2165a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: b */
    public String mo14672b() {
        return this.f12391c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2165a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2282b> mo14673c() {
        return this.f12392d;
    }

    /* renamed from: a */
    public static AbstractC1148aa<C2273a> m14886a(Iterable<? extends InterfaceC2165a> iterable) {
        return f12389e.m15526b(iterable);
    }
}
