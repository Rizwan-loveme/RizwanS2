package org.p226d.p233b.p244d.p247c;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.p248d.AbstractC2133d;

/* compiled from: DexBackedMethodReference.java */
/* renamed from: org.d.b.d.c.e */
/* loaded from: classes.dex */
public class C2125e extends AbstractC1991e {

    /* renamed from: a */
    public final C2153g f11855a;

    /* renamed from: b */
    public final int f11856b;

    /* renamed from: c */
    private int f11857c;

    public C2125e(C2153g c2153g, int i) {
        this.f11855a = c2153g;
        this.f11856b = c2153g.m14774m(i);
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: a */
    public String mo14209a() {
        return this.f11855a.m14781t(this.f11855a.m14617c(this.f11856b + 0));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: b */
    public String mo14210b() {
        return this.f11855a.m14779r(this.f11855a.m14615a(this.f11856b + 4));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
    /* renamed from: c */
    public List<String> mo14211c() {
        int a2 = this.f11855a.m14615a(m14688e() + 8);
        if (a2 <= 0) {
            return AbstractC1208w.m10138g();
        }
        final int a3 = this.f11855a.m14615a(a2 + 0);
        final int i = a2 + 4;
        return new AbstractC2133d<String>() { // from class: org.d.b.d.c.e.1
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String mo14625b(int i2) {
                return C2125e.this.f11855a.m14781t(C2125e.this.f11855a.m14617c(i + (i2 * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a3;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: d */
    public String mo14212d() {
        return this.f11855a.m14781t(this.f11855a.m14615a(m14688e() + 4));
    }

    /* renamed from: e */
    private int m14688e() {
        if (this.f11857c == 0) {
            this.f11857c = this.f11855a.m14775n(this.f11855a.m14617c(this.f11856b + 2));
        }
        return this.f11857c;
    }
}
