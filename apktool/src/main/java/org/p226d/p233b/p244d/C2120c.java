package org.p226d.p233b.p244d;

import java.util.Set;
import org.p226d.p233b.p238b.AbstractC1986a;
import org.p226d.p233b.p244d.p248d.AbstractC2140k;

/* compiled from: DexBackedAnnotation.java */
/* renamed from: org.d.b.d.c */
/* loaded from: classes.dex */
public class C2120c extends AbstractC1986a {

    /* renamed from: b */
    public final C2153g f11835b;

    /* renamed from: c */
    public final int f11836c;

    /* renamed from: d */
    public final int f11837d;

    /* renamed from: e */
    private final int f11838e;

    public C2120c(C2153g c2153g, int i) {
        this.f11835b = c2153g;
        C2161o m14783v = c2153g.m14783v(i);
        this.f11836c = m14783v.m14651i();
        this.f11837d = m14783v.m14639c();
        this.f11838e = m14783v.m14635a();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2165a
    /* renamed from: a */
    public int mo14671a() {
        return this.f11836c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2165a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: b */
    public String mo14672b() {
        return this.f11835b.m14781t(this.f11837d);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2165a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: c */
    public Set<? extends C2129d> mo14673c() {
        C2161o m14783v = this.f11835b.m14783v(this.f11838e);
        return new AbstractC2140k<C2129d>(this.f11835b, m14783v.m14635a(), m14783v.m14639c()) { // from class: org.d.b.d.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2140k
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C2129d mo14675b(C2161o c2161o, int i) {
                return new C2129d(c2161o);
            }
        };
    }
}
