package org.p226d.p233b.p241c.p242a;

import org.p226d.p233b.p241c.AbstractC2017a;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: BuilderStartLocal.java */
/* renamed from: org.d.b.c.a.g */
/* loaded from: classes.dex */
public class C2024g extends AbstractC2017a implements InterfaceC2174i {

    /* renamed from: b */
    private final int f11579b;

    /* renamed from: c */
    private final InterfaceC2242g f11580c;

    /* renamed from: d */
    private final InterfaceC2243h f11581d;

    /* renamed from: e */
    private final InterfaceC2242g f11582e;

    public C2024g(int i, InterfaceC2242g interfaceC2242g, InterfaceC2243h interfaceC2243h, InterfaceC2242g interfaceC2242g2) {
        this.f11579b = i;
        this.f11580c = interfaceC2242g;
        this.f11581d = interfaceC2243h;
        this.f11582e = interfaceC2242g2;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: e */
    public int mo14470e() {
        return this.f11579b;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: g */
    public InterfaceC2242g mo14471g() {
        return this.f11580c;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: h */
    public InterfaceC2243h mo14472h() {
        return this.f11581d;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: i */
    public InterfaceC2242g mo14473i() {
        return this.f11582e;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: b */
    public String mo14220b() {
        if (this.f11580c == null) {
            return null;
        }
        return this.f11580c.mo14691a();
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: l */
    public String mo14465l() {
        if (this.f11581d == null) {
            return null;
        }
        return this.f11581d.mo14205l();
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: c */
    public String mo14452c() {
        if (this.f11582e == null) {
            return null;
        }
        return this.f11582e.mo14691a();
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: f */
    public int mo14464f() {
        return 3;
    }
}
