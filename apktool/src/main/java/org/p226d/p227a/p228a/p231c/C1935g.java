package org.p226d.p227a.p228a.p231c;

import org.p226d.p227a.p228a.C1943k;
import org.p226d.p233b.p234a.C1984s;
import org.p226d.p269d.C2457k;

/* compiled from: UnresolvedOdexInstructionMethodItem.java */
/* renamed from: org.d.a.a.c.g */
/* loaded from: classes.dex */
public class C1935g extends C1930b<C1984s> {
    public C1935g(C1943k c1943k, int i, C1984s c1984s) {
        super(c1943k, i, c1984s);
    }

    @Override // org.p226d.p227a.p228a.p231c.C1930b, org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        m14123p(c2457k);
        return true;
    }

    /* renamed from: p */
    private void m14123p(C2457k c2457k) {
        c2457k.write("#Replaced unresolvable odex instruction with a throw\n");
        c2457k.write("throw ");
        m14099a(c2457k, ((C1984s) this.f11284b).f11565b);
    }
}
