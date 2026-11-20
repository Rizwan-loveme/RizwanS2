package org.p226d.p233b.p244d;

import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1988b;
import org.p226d.p233b.p244d.p248d.AbstractC2130a;
import org.p226d.p233b.p244d.p248d.AbstractC2132c;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: DexBackedField.java */
/* renamed from: org.d.b.d.i */
/* loaded from: classes.dex */
public class C2155i extends AbstractC1988b implements InterfaceC2266g {

    /* renamed from: a */
    public final C2153g f12020a;

    /* renamed from: b */
    public final InterfaceC2244d f12021b;

    /* renamed from: c */
    public final int f12022c;

    /* renamed from: d */
    public final InterfaceC2251g f12023d;

    /* renamed from: e */
    public final int f12024e;

    /* renamed from: f */
    public final int f12025f;

    /* renamed from: g */
    private final int f12026g;

    /* renamed from: h */
    private final int f12027h;

    /* renamed from: i */
    private int f12028i;

    public C2155i(C2161o c2161o, C2152f c2152f, int i, AbstractC2132c abstractC2132c, AbstractC2130a.a aVar) {
        this.f12020a = (C2153g) c2161o.f11828a;
        this.f12021b = c2152f;
        this.f12026g = c2161o.m14635a();
        this.f12025f = c2161o.m14641d() + i;
        this.f12022c = c2161o.m14639c();
        this.f12024e = aVar.mo14704a(this.f12025f);
        this.f12027h = abstractC2132c.mo14720c();
        this.f12023d = abstractC2132c.mo14718a();
    }

    public C2155i(C2161o c2161o, C2152f c2152f, int i, AbstractC2130a.a aVar) {
        this.f12020a = (C2153g) c2161o.f11828a;
        this.f12021b = c2152f;
        this.f12026g = c2161o.m14635a();
        this.f12025f = c2161o.m14641d() + i;
        this.f12022c = c2161o.m14639c();
        this.f12024e = aVar.mo14704a(this.f12025f);
        this.f12027h = 0;
        this.f12023d = null;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: e */
    public String mo14226e() {
        return this.f12020a.m14779r(this.f12020a.m14615a(m14789g() + 4));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: f */
    public String mo14227f() {
        return this.f12020a.m14781t(this.f12020a.m14617c(m14789g() + 2));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: d */
    public String mo14225d() {
        return this.f12021b.mo14205l();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: a */
    public int mo14222a() {
        return this.f12022c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: b */
    public InterfaceC2251g mo14223b() {
        return this.f12023d;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: c */
    public Set<? extends C2120c> mo14224c() {
        return AbstractC2130a.m14695b(this.f12020a, this.f12024e);
    }

    /* renamed from: a */
    public static void m14788a(C2161o c2161o, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            c2161o.m14646f();
            c2161o.m14646f();
        }
    }

    /* renamed from: g */
    private int m14789g() {
        if (this.f12028i == 0) {
            this.f12028i = this.f12020a.m14773l(this.f12025f);
        }
        return this.f12028i;
    }
}
