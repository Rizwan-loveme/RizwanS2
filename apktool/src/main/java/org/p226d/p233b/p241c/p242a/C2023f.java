package org.p226d.p233b.p241c.p242a;

import org.p226d.p233b.p241c.AbstractC2017a;
import org.p226d.p233b.p250e.p251a.InterfaceC2173h;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;

/* compiled from: BuilderSetSourceFile.java */
/* renamed from: org.d.b.c.a.f */
/* loaded from: classes.dex */
public class C2023f extends AbstractC2017a implements InterfaceC2173h {

    /* renamed from: b */
    private final InterfaceC2242g f11578b;

    public C2023f(InterfaceC2242g interfaceC2242g) {
        this.f11578b = interfaceC2242g;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: f */
    public int mo14464f() {
        return 9;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2173h
    /* renamed from: b */
    public String mo14468b() {
        if (this.f11578b == null) {
            return null;
        }
        return this.f11578b.mo14691a();
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2173h
    /* renamed from: c */
    public InterfaceC2242g mo14469c() {
        return this.f11578b;
    }
}
