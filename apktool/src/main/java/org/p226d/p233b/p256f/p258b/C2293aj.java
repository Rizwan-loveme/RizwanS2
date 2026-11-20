package org.p226d.p233b.p256f.p258b;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p269d.AbstractC2455i;

/* compiled from: ImmutableSwitchElement.java */
/* renamed from: org.d.b.f.b.aj */
/* loaded from: classes.dex */
public class C2293aj implements InterfaceC2227o {

    /* renamed from: c */
    private static final AbstractC2455i<C2293aj, InterfaceC2227o> f12465c = new AbstractC2455i<C2293aj, InterfaceC2227o>() { // from class: org.d.b.f.b.aj.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2227o interfaceC2227o) {
            return interfaceC2227o instanceof C2293aj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2293aj mo14889a(InterfaceC2227o interfaceC2227o) {
            return C2293aj.m14916a(interfaceC2227o);
        }
    };

    /* renamed from: a */
    protected final int f12466a;

    /* renamed from: b */
    protected final int f12467b;

    public C2293aj(int i, int i2) {
        this.f12466a = i;
        this.f12467b = i2;
    }

    /* renamed from: a */
    public static C2293aj m14916a(InterfaceC2227o interfaceC2227o) {
        if (interfaceC2227o instanceof C2293aj) {
            return (C2293aj) interfaceC2227o;
        }
        return new C2293aj(interfaceC2227o.mo14497a(), interfaceC2227o.mo14498b());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2227o
    /* renamed from: a */
    public int mo14497a() {
        return this.f12466a;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2227o
    /* renamed from: b */
    public int mo14498b() {
        return this.f12467b;
    }

    /* renamed from: a */
    public static AbstractC1208w<C2293aj> m14915a(List<? extends InterfaceC2227o> list) {
        return f12465c.m15525a(list);
    }
}
