package org.p226d.p233b.p256f.p259c;

import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p226d.p269d.AbstractC2455i;

/* compiled from: ImmutableTypeReference.java */
/* renamed from: org.d.b.f.c.i */
/* loaded from: classes.dex */
public class C2329i extends AbstractC1993g implements InterfaceC2326f {

    /* renamed from: b */
    private static final AbstractC2455i<C2329i, InterfaceC2243h> f12575b = new AbstractC2455i<C2329i, InterfaceC2243h>() { // from class: org.d.b.f.c.i.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2243h interfaceC2243h) {
            return interfaceC2243h instanceof C2329i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2329i mo14889a(InterfaceC2243h interfaceC2243h) {
            return C2329i.m14966a(interfaceC2243h);
        }
    };

    /* renamed from: a */
    protected final String f12576a;

    public C2329i(String str) {
        this.f12576a = str;
    }

    /* renamed from: a */
    public static C2329i m14966a(InterfaceC2243h interfaceC2243h) {
        return interfaceC2243h instanceof C2329i ? (C2329i) interfaceC2243h : new C2329i(interfaceC2243h.mo14205l());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: l */
    public String mo14205l() {
        return this.f12576a;
    }
}
