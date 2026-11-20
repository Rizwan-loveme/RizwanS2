package org.p226d.p233b.p244d.p247c;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p238b.p239a.AbstractC1990d;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.p248d.AbstractC2133d;

/* compiled from: DexBackedMethodProtoReference.java */
/* renamed from: org.d.b.d.c.d */
/* loaded from: classes.dex */
public class C2124d extends AbstractC1990d {

    /* renamed from: a */
    public final C2153g f11850a;

    /* renamed from: b */
    private final int f11851b;

    public C2124d(C2153g c2153g, int i) {
        this.f11850a = c2153g;
        this.f11851b = c2153g.m14775n(i);
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2239d
    /* renamed from: a */
    public List<String> mo14685a() {
        int a2 = this.f11850a.m14615a(this.f11851b + 8);
        if (a2 <= 0) {
            return AbstractC1208w.m10138g();
        }
        final int a3 = this.f11850a.m14615a(a2 + 0);
        final int i = a2 + 4;
        return new AbstractC2133d<String>() { // from class: org.d.b.d.c.d.1
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String mo14625b(int i2) {
                return C2124d.this.f11850a.m14781t(C2124d.this.f11850a.m14617c(i + (i2 * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a3;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2239d
    /* renamed from: b */
    public String mo14686b() {
        return this.f11850a.m14781t(this.f11850a.m14615a(this.f11851b + 4));
    }
}
