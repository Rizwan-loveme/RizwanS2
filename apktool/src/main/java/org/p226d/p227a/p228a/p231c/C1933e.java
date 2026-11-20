package org.p226d.p227a.p228a.p231c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p226d.p227a.p228a.C1939g;
import org.p226d.p227a.p228a.C1942j;
import org.p226d.p227a.p228a.C1943k;
import org.p226d.p227a.p232b.C1956f;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2186ai;
import org.p226d.p269d.C2457k;

/* compiled from: PackedSwitchMethodItem.java */
/* renamed from: org.d.a.a.c.e */
/* loaded from: classes.dex */
public class C1933e extends C1930b<InterfaceC2186ai> {

    /* renamed from: d */
    private final List<c> f11307d;

    /* renamed from: e */
    private final int f11308e;

    /* renamed from: g */
    private boolean f11309g;

    public C1933e(C1943k c1943k, int i, InterfaceC2186ai interfaceC2186ai) {
        super(c1943k, i, interfaceC2186ai);
        int i2;
        int m14153a = c1943k.m14153a(i);
        this.f11307d = new ArrayList();
        if (m14153a >= 0) {
            i2 = 0;
            boolean z = true;
            for (InterfaceC2227o interfaceC2227o : interfaceC2186ai.mo14496f()) {
                if (z) {
                    i2 = interfaceC2227o.mo14497a();
                    z = false;
                }
                this.f11307d.add(new a(c1943k.m14154a().m14160a(new C1942j(c1943k.f11328a.f11317a, interfaceC2227o.mo14498b() + m14153a, "pswitch_"))));
            }
        } else {
            this.f11309g = true;
            i2 = 0;
            boolean z2 = true;
            for (InterfaceC2227o interfaceC2227o2 : interfaceC2186ai.mo14496f()) {
                if (z2) {
                    i2 = interfaceC2227o2.mo14497a();
                    z2 = false;
                }
                this.f11307d.add(new b(interfaceC2227o2.mo14498b()));
            }
        }
        this.f11308e = i2;
    }

    @Override // org.p226d.p227a.p228a.p231c.C1930b, org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        if (this.f11309g) {
            c2457k = new C1939g(c2457k);
        }
        c2457k.write(".packed-switch ");
        C1956f.m14179a(c2457k, this.f11308e);
        c2457k.m15532a(4);
        c2457k.write(10);
        int i = this.f11308e;
        Iterator<c> it = this.f11307d.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                it.next().mo14120a(c2457k);
                m14104c(c2457k, i2);
                c2457k.write(10);
                i = i2 + 1;
            } else {
                c2457k.m15534b(4);
                c2457k.write(".end packed-switch");
                return true;
            }
        }
    }

    /* compiled from: PackedSwitchMethodItem.java */
    /* renamed from: org.d.a.a.c.e$c */
    private static abstract class c {
        /* renamed from: a */
        public abstract void mo14120a(C2457k c2457k);

        private c() {
        }
    }

    /* compiled from: PackedSwitchMethodItem.java */
    /* renamed from: org.d.a.a.c.e$a */
    private static class a extends c {

        /* renamed from: a */
        private final C1942j f11310a;

        public a(C1942j c1942j) {
            super();
            this.f11310a = c1942j;
        }

        @Override // org.p226d.p227a.p228a.p231c.C1933e.c
        /* renamed from: a */
        public void mo14120a(C2457k c2457k) {
            this.f11310a.mo14089a(c2457k);
        }
    }

    /* compiled from: PackedSwitchMethodItem.java */
    /* renamed from: org.d.a.a.c.e$b */
    private static class b extends c {

        /* renamed from: a */
        private final int f11311a;

        public b(int i) {
            super();
            this.f11311a = i;
        }

        @Override // org.p226d.p227a.p228a.p231c.C1933e.c
        /* renamed from: a */
        public void mo14120a(C2457k c2457k) {
            if (this.f11311a >= 0) {
                c2457k.write(43);
            }
            c2457k.m15536c(this.f11311a);
        }
    }
}
