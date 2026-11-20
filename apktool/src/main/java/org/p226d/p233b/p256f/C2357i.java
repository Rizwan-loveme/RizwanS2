package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Set;
import org.p226d.p233b.p238b.AbstractC2014d;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p269d.AbstractC2455i;
import org.p226d.p269d.C2456j;

/* compiled from: ImmutableMethodParameter.java */
/* renamed from: org.d.b.f.i */
/* loaded from: classes.dex */
public class C2357i extends AbstractC2014d {

    /* renamed from: d */
    private static final AbstractC2455i<C2357i, InterfaceC2269j> f12627d = new AbstractC2455i<C2357i, InterfaceC2269j>() { // from class: org.d.b.f.i.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2269j interfaceC2269j) {
            return interfaceC2269j instanceof C2357i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2357i mo14889a(InterfaceC2269j interfaceC2269j) {
            return C2357i.m15018a(interfaceC2269j);
        }
    };

    /* renamed from: a */
    protected final String f12628a;

    /* renamed from: b */
    protected final AbstractC1148aa<? extends C2273a> f12629b;

    /* renamed from: c */
    protected final String f12630c;

    public C2357i(String str, Set<? extends InterfaceC2165a> set, String str2) {
        this.f12628a = str;
        this.f12629b = C2273a.m14886a(set);
        this.f12630c = str2;
    }

    public C2357i(String str, AbstractC1148aa<? extends C2273a> abstractC1148aa, String str2) {
        this.f12628a = str;
        this.f12629b = C2456j.m15527a(abstractC1148aa);
        this.f12630c = str2;
    }

    /* renamed from: a */
    public static C2357i m15018a(InterfaceC2269j interfaceC2269j) {
        if (interfaceC2269j instanceof C2357i) {
            return (C2357i) interfaceC2269j;
        }
        return new C2357i(interfaceC2269j.mo14465l(), interfaceC2269j.mo14219a(), interfaceC2269j.mo14220b());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: l */
    public String mo14205l() {
        return this.f12628a;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2269j
    /* renamed from: a */
    public Set<? extends InterfaceC2165a> mo14219a() {
        return this.f12629b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: b */
    public String mo14220b() {
        return this.f12630c;
    }

    @Override // org.p226d.p233b.p238b.AbstractC2014d, org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: c */
    public String mo14452c() {
        return null;
    }

    /* renamed from: a */
    public static AbstractC1208w<C2357i> m15017a(Iterable<? extends InterfaceC2269j> iterable) {
        return f12627d.m15525a(iterable);
    }
}
