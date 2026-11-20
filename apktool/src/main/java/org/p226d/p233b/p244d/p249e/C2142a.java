package org.p226d.p233b.p244d.p249e;

import java.util.Set;
import org.p226d.p233b.p238b.p240b.AbstractC1995a;
import org.p226d.p233b.p244d.C2129d;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p244d.p248d.AbstractC2140k;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;

/* compiled from: DexBackedAnnotationEncodedValue.java */
/* renamed from: org.d.b.d.e.a */
/* loaded from: classes.dex */
public class C2142a extends AbstractC1995a implements InterfaceC2245a {

    /* renamed from: a */
    public final C2153g f11925a;

    /* renamed from: b */
    public final String f11926b;

    /* renamed from: c */
    private final int f11927c;

    /* renamed from: d */
    private final int f11928d;

    public C2142a(C2161o c2161o) {
        this.f11925a = (C2153g) c2161o.f11828a;
        this.f11926b = this.f11925a.m14781t(c2161o.m14639c());
        this.f11927c = c2161o.m14639c();
        this.f11928d = c2161o.m14635a();
        m14729a(c2161o, this.f11927c);
    }

    /* renamed from: a */
    public static void m14728a(C2161o c2161o) {
        c2161o.m14646f();
        m14729a(c2161o, c2161o.m14639c());
    }

    /* renamed from: a */
    private static void m14729a(C2161o c2161o, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            c2161o.m14646f();
            AbstractC2144c.m14736b(c2161o);
        }
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2245a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: b */
    public String mo14672b() {
        return this.f11926b;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2245a, org.p226d.p233b.p250e.InterfaceC2235c
    /* renamed from: c */
    public Set<? extends C2129d> mo14673c() {
        return new AbstractC2140k<C2129d>(this.f11925a, this.f11928d, this.f11927c) { // from class: org.d.b.d.e.a.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2140k
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C2129d mo14675b(C2161o c2161o, int i) {
                return new C2129d(c2161o);
            }
        };
    }
}
