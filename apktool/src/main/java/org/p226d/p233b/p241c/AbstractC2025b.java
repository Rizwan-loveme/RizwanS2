package org.p226d.p233b.p241c;

import org.p226d.p233b.p238b.AbstractC2013c;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: BuilderExceptionHandler.java */
/* renamed from: org.d.b.c.b */
/* loaded from: classes.dex */
public abstract class AbstractC2025b extends AbstractC2013c {

    /* renamed from: b */
    protected final C2068h f11583b;

    private AbstractC2025b(C2068h c2068h) {
        this.f11583b = c2068h;
    }

    /* renamed from: a */
    static AbstractC2025b m14475a(final InterfaceC2243h interfaceC2243h, C2068h c2068h) {
        return interfaceC2243h == null ? m14474a(c2068h) : new AbstractC2025b(c2068h) { // from class: org.d.b.c.b.1
            @Override // org.p226d.p233b.p250e.InterfaceC2265f
            /* renamed from: b */
            public String mo14476b() {
                return interfaceC2243h.mo14205l();
            }

            @Override // org.p226d.p233b.p250e.InterfaceC2265f
            /* renamed from: c */
            public int mo14477c() {
                return this.f11583b.m14519a();
            }

            @Override // org.p226d.p233b.p238b.AbstractC2013c, org.p226d.p233b.p250e.InterfaceC2265f
            /* renamed from: a */
            public InterfaceC2243h mo14450a() {
                return interfaceC2243h;
            }
        };
    }

    /* renamed from: a */
    static AbstractC2025b m14474a(C2068h c2068h) {
        return new AbstractC2025b(c2068h) { // from class: org.d.b.c.b.2
            @Override // org.p226d.p233b.p250e.InterfaceC2265f
            /* renamed from: b */
            public String mo14476b() {
                return null;
            }

            @Override // org.p226d.p233b.p250e.InterfaceC2265f
            /* renamed from: c */
            public int mo14477c() {
                return this.f11583b.m14519a();
            }
        };
    }
}
