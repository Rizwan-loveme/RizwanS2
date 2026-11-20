package com.p140g.p141a.p145d;

import com.p140g.p141a.C1280e;
import com.p140g.p141a.EnumC1301h;
import com.p140g.p141a.p151g.C1294b;
import com.p140g.p141a.p151g.C1296d;
import com.p140g.p141a.p151g.C1300h;
import com.p140g.p141a.p151g.InterfaceC1293a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DexMethodNode.java */
/* renamed from: com.g.a.d.g */
/* loaded from: classes.dex */
public class C1278g extends C1300h {

    /* renamed from: a */
    public int f8168a;

    /* renamed from: b */
    public List<C1250a> f8169b;

    /* renamed from: c */
    public C1274c f8170c;

    /* renamed from: d */
    public C1280e f8171d;

    /* renamed from: e */
    public List<C1250a>[] f8172e;

    public C1278g(int i, C1280e c1280e) {
        this.f8168a = i;
        this.f8171d = c1280e;
    }

    @Override // com.p140g.p141a.p151g.C1300h, com.p140g.p141a.p151g.InterfaceC1293a
    /* renamed from: a */
    public C1294b mo10353a(String str, EnumC1301h enumC1301h) {
        if (this.f8169b == null) {
            this.f8169b = new ArrayList(5);
        }
        C1250a c1250a = new C1250a(str, enumC1301h);
        this.f8169b.add(c1250a);
        return c1250a;
    }

    @Override // com.p140g.p141a.p151g.C1300h
    /* renamed from: a */
    public C1296d mo10394a() {
        C1274c c1274c = new C1274c(super.mo10394a());
        this.f8170c = c1274c;
        return c1274c;
    }

    @Override // com.p140g.p141a.p151g.C1300h
    @SuppressWarnings("unchecked")
    /* renamed from: a */
    public InterfaceC1293a mo10393a(int i) {
        if (this.f8172e == null) {
            this.f8172e = new List[this.f8171d.m10400e().length];
        }
        return new InterfaceC1293a(this, i) { // from class: com.g.a.d.g.1

            /* renamed from: a */
            private final C1278g f8173a;

            /* renamed from: b */
            private final int f8174b;

            {
                this.f8173a = this;
                this.f8174b = i;
            }

            @Override // com.p140g.p141a.p151g.InterfaceC1293a
            /* renamed from: a */
            public C1294b mo10353a(String str, EnumC1301h enumC1301h) {
                List<C1250a> list = this.f8173a.f8172e[this.f8174b];
                if (list == null) {
                    list = new ArrayList<>(5);
                    this.f8173a.f8172e[this.f8174b] = list;
                }
                C1250a c1250a = new C1250a(str, enumC1301h);
                list.add(c1250a);
                return c1250a;
            }
        };
    }
}
