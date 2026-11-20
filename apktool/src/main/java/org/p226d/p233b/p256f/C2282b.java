package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1148aa;
import org.p226d.p233b.p238b.AbstractC1994b;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p256f.p261e.C2341h;
import org.p226d.p233b.p256f.p261e.InterfaceC2340g;
import org.p226d.p269d.AbstractC2455i;

/* compiled from: ImmutableAnnotationElement.java */
/* renamed from: org.d.b.f.b */
/* loaded from: classes.dex */
public class C2282b extends AbstractC1994b {

    /* renamed from: d */
    private static final AbstractC2455i<C2282b, InterfaceC2175b> f12416d = new AbstractC2455i<C2282b, InterfaceC2175b>() { // from class: org.d.b.f.b.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2175b interfaceC2175b) {
            return interfaceC2175b instanceof C2282b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2282b mo14889a(InterfaceC2175b interfaceC2175b) {
            return C2282b.m14901b(interfaceC2175b);
        }
    };

    /* renamed from: b */
    protected final String f12417b;

    /* renamed from: c */
    protected final InterfaceC2340g f12418c;

    public C2282b(String str, InterfaceC2251g interfaceC2251g) {
        this.f12417b = str;
        this.f12418c = C2341h.m14986a(interfaceC2251g);
    }

    public C2282b(String str, InterfaceC2340g interfaceC2340g) {
        this.f12417b = str;
        this.f12418c = interfaceC2340g;
    }

    /* renamed from: b */
    public static C2282b m14901b(InterfaceC2175b interfaceC2175b) {
        if (interfaceC2175b instanceof C2282b) {
            return (C2282b) interfaceC2175b;
        }
        return new C2282b(interfaceC2175b.mo14692a(), interfaceC2175b.mo14693b());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2175b
    /* renamed from: a */
    public String mo14692a() {
        return this.f12417b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2175b
    /* renamed from: b */
    public InterfaceC2251g mo14693b() {
        return this.f12418c;
    }

    /* renamed from: a */
    public static AbstractC1148aa<C2282b> m14900a(Iterable<? extends InterfaceC2175b> iterable) {
        return f12416d.m15526b(iterable);
    }
}
