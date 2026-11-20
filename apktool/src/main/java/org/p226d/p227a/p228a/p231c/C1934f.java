package org.p226d.p227a.p228a.p231c;

import java.util.ArrayList;
import java.util.List;
import org.p226d.p227a.p228a.C1939g;
import org.p226d.p227a.p228a.C1942j;
import org.p226d.p227a.p228a.C1943k;
import org.p226d.p227a.p232b.C1956f;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2187aj;
import org.p226d.p269d.C2457k;

/* compiled from: SparseSwitchMethodItem.java */
/* renamed from: org.d.a.a.c.f */
/* loaded from: classes.dex */
public class C1934f extends C1930b<InterfaceC2187aj> {

    /* renamed from: d */
    private final List<c> f11312d;

    /* renamed from: e */
    private boolean f11313e;

    public C1934f(C1943k c1943k, int i, InterfaceC2187aj interfaceC2187aj) {
        super(c1943k, i, interfaceC2187aj);
        int m14157b = c1943k.m14157b(i);
        this.f11312d = new ArrayList();
        if (m14157b >= 0) {
            for (InterfaceC2227o interfaceC2227o : interfaceC2187aj.mo14496f()) {
                this.f11312d.add(new a(interfaceC2227o.mo14497a(), c1943k.m14154a().m14160a(new C1942j(c1943k.f11328a.f11317a, interfaceC2227o.mo14498b() + m14157b, "sswitch_"))));
            }
            return;
        }
        this.f11313e = true;
        for (InterfaceC2227o interfaceC2227o2 : interfaceC2187aj.mo14496f()) {
            this.f11312d.add(new b(interfaceC2227o2.mo14497a(), interfaceC2227o2.mo14498b()));
        }
    }

    @Override // org.p226d.p227a.p228a.p231c.C1930b, org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        if (this.f11313e) {
            c2457k = new C1939g(c2457k);
        }
        c2457k.write(".sparse-switch\n");
        c2457k.m15532a(4);
        for (c cVar : this.f11312d) {
            C1956f.m14179a(c2457k, cVar.m14122a());
            c2457k.write(" -> ");
            cVar.mo14121a(c2457k);
            m14104c(c2457k, cVar.m14122a());
            c2457k.write(10);
        }
        c2457k.m15534b(4);
        c2457k.write(".end sparse-switch");
        return true;
    }

    /* compiled from: SparseSwitchMethodItem.java */
    /* renamed from: org.d.a.a.c.f$c */
    private static abstract class c {

        /* renamed from: a */
        private final int f11316a;

        /* renamed from: a */
        public abstract void mo14121a(C2457k c2457k);

        public c(int i) {
            this.f11316a = i;
        }

        /* renamed from: a */
        public int m14122a() {
            return this.f11316a;
        }
    }

    /* compiled from: SparseSwitchMethodItem.java */
    /* renamed from: org.d.a.a.c.f$a */
    private static class a extends c {

        /* renamed from: a */
        private final C1942j f11314a;

        public a(int i, C1942j c1942j) {
            super(i);
            this.f11314a = c1942j;
        }

        @Override // org.p226d.p227a.p228a.p231c.C1934f.c
        /* renamed from: a */
        public void mo14121a(C2457k c2457k) {
            this.f11314a.mo14089a(c2457k);
        }
    }

    /* compiled from: SparseSwitchMethodItem.java */
    /* renamed from: org.d.a.a.c.f$b */
    private static class b extends c {

        /* renamed from: a */
        private final int f11315a;

        public b(int i, int i2) {
            super(i);
            this.f11315a = i2;
        }

        @Override // org.p226d.p227a.p228a.p231c.C1934f.c
        /* renamed from: a */
        public void mo14121a(C2457k c2457k) {
            if (this.f11315a >= 0) {
                c2457k.write(43);
            }
            c2457k.m15536c(this.f11315a);
        }
    }
}
