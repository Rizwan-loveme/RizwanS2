package org.p226d.p227a.p228a.p229a;

import org.p226d.p233b.p250e.p251a.InterfaceC2173h;
import org.p226d.p269d.C2457k;
import org.p226d.p269d.C2464r;

/* compiled from: SetSourceFileMethodItem.java */
/* renamed from: org.d.a.a.a.h */
/* loaded from: classes.dex */
public class C1922h extends AbstractC1916b {

    /* renamed from: a */
    private final String f11275a;

    public C1922h(int i, int i2, InterfaceC2173h interfaceC2173h) {
        super(i, i2);
        this.f11275a = interfaceC2173h.mo14468b();
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        c2457k.write(".source");
        if (this.f11275a != null) {
            c2457k.write(" \"");
            C2464r.m15561a(c2457k, this.f11275a);
            c2457k.write(34);
            return true;
        }
        return true;
    }
}
