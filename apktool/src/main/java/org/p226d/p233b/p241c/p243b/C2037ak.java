package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.p241c.AbstractC2065e;
import org.p226d.p233b.p241c.C2068h;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;

/* compiled from: BuilderSwitchElement.java */
/* renamed from: org.d.b.c.b.ak */
/* loaded from: classes.dex */
public class C2037ak implements InterfaceC2227o {

    /* renamed from: a */
    AbstractC2065e f11639a;

    /* renamed from: b */
    private final int f11640b;

    /* renamed from: c */
    private final C2068h f11641c;

    public C2037ak(AbstractC2065e abstractC2065e, int i, C2068h c2068h) {
        this.f11639a = abstractC2065e;
        this.f11640b = i;
        this.f11641c = c2068h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2227o
    /* renamed from: a */
    public int mo14497a() {
        return this.f11640b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2227o
    /* renamed from: b */
    public int mo14498b() {
        return this.f11641c.m14519a() - this.f11639a.m14510e().m14548b();
    }
}
