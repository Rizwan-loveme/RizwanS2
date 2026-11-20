package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1208w;
import org.p226d.p233b.p238b.AbstractC2013c;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p269d.AbstractC2455i;

/* compiled from: ImmutableExceptionHandler.java */
/* renamed from: org.d.b.f.e */
/* loaded from: classes.dex */
public class C2333e extends AbstractC2013c implements InterfaceC2265f {

    /* renamed from: d */
    private static final AbstractC2455i<C2333e, InterfaceC2265f> f12583d = new AbstractC2455i<C2333e, InterfaceC2265f>() { // from class: org.d.b.f.e.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2265f interfaceC2265f) {
            return interfaceC2265f instanceof C2333e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2333e mo14889a(InterfaceC2265f interfaceC2265f) {
            return C2333e.m14974b(interfaceC2265f);
        }
    };

    /* renamed from: b */
    protected final String f12584b;

    /* renamed from: c */
    protected final int f12585c;

    public C2333e(String str, int i) {
        this.f12584b = str;
        this.f12585c = i;
    }

    /* renamed from: b */
    public static C2333e m14974b(InterfaceC2265f interfaceC2265f) {
        if (interfaceC2265f instanceof C2333e) {
            return (C2333e) interfaceC2265f;
        }
        return new C2333e(interfaceC2265f.mo14476b(), interfaceC2265f.mo14477c());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2265f
    /* renamed from: b */
    public String mo14476b() {
        return this.f12584b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2265f
    /* renamed from: c */
    public int mo14477c() {
        return this.f12585c;
    }

    /* renamed from: a */
    public static AbstractC1208w<C2333e> m14973a(Iterable<? extends InterfaceC2265f> iterable) {
        return f12583d.m15525a(iterable);
    }
}
