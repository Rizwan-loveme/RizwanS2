package org.p226d.p233b.p256f.p257a;

import com.p129f.p130a.p133c.AbstractC1208w;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p251a.InterfaceC2167b;
import org.p226d.p233b.p250e.p251a.InterfaceC2168c;
import org.p226d.p233b.p250e.p251a.InterfaceC2169d;
import org.p226d.p233b.p250e.p251a.InterfaceC2171f;
import org.p226d.p233b.p250e.p251a.InterfaceC2172g;
import org.p226d.p233b.p250e.p251a.InterfaceC2173h;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;
import org.p226d.p269d.AbstractC2455i;
import org.p226d.p269d.C2453g;

/* compiled from: ImmutableDebugItem.java */
/* renamed from: org.d.b.f.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2274a implements InterfaceC2166a {

    /* renamed from: b */
    private static final AbstractC2455i<AbstractC2274a, InterfaceC2166a> f12396b = new AbstractC2455i<AbstractC2274a, InterfaceC2166a>() { // from class: org.d.b.f.a.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2166a interfaceC2166a) {
            return interfaceC2166a instanceof AbstractC2274a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public AbstractC2274a mo14889a(InterfaceC2166a interfaceC2166a) {
            return AbstractC2274a.m14892a(interfaceC2166a);
        }
    };

    /* renamed from: a */
    protected final int f12397a;

    public AbstractC2274a(int i) {
        this.f12397a = i;
    }

    /* renamed from: a */
    public static AbstractC2274a m14892a(InterfaceC2166a interfaceC2166a) {
        if (interfaceC2166a instanceof AbstractC2274a) {
            return (AbstractC2274a) interfaceC2166a;
        }
        switch (interfaceC2166a.mo14464f()) {
            case 3:
                return C2281h.m14899a((InterfaceC2174i) interfaceC2166a);
            case 4:
            default:
                throw new C2453g("Invalid debug item type: %d", Integer.valueOf(interfaceC2166a.mo14464f()));
            case 5:
                return C2275b.m14893a((InterfaceC2167b) interfaceC2166a);
            case 6:
                return C2279f.m14897a((InterfaceC2172g) interfaceC2166a);
            case 7:
                return C2278e.m14896a((InterfaceC2171f) interfaceC2166a);
            case 8:
                return C2276c.m14894a((InterfaceC2168c) interfaceC2166a);
            case 9:
                return C2280g.m14898a((InterfaceC2173h) interfaceC2166a);
            case 10:
                return C2277d.m14895a((InterfaceC2169d) interfaceC2166a);
        }
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: a */
    public int mo14461a() {
        return this.f12397a;
    }

    /* renamed from: a */
    public static AbstractC1208w<AbstractC2274a> m14891a(Iterable<? extends InterfaceC2166a> iterable) {
        return f12396b.m15525a(iterable);
    }
}
