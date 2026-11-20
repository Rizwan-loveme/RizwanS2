package org.p271f.p272a.p275c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2525q;

/* compiled from: TableSwitchInsnNode.java */
/* renamed from: org.f.a.c.v */
/* loaded from: classes.dex */
public class C2507v extends AbstractC2486a {

    /* renamed from: g */
    public int f13071g;

    /* renamed from: h */
    public int f13072h;

    /* renamed from: i */
    public C2497l f13073i;

    /* renamed from: j */
    public List<C2497l> f13074j;

    public C2507v(int i, int i2, C2497l c2497l, C2497l... c2497lArr) {
        super(170);
        this.f13071g = i;
        this.f13072h = i2;
        this.f13073i = c2497l;
        this.f13074j = new ArrayList();
        if (c2497lArr != null) {
            this.f13074j.addAll(Arrays.asList(c2497lArr));
        }
    }

    @Override // org.p271f.p272a.p275c.AbstractC2486a
    /* renamed from: a */
    public void mo15719a(AbstractC2526r abstractC2526r) {
        C2525q[] c2525qArr = new C2525q[this.f13074j.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < c2525qArr.length) {
                c2525qArr[i2] = this.f13074j.get(i2).m15734c();
                i = i2 + 1;
            } else {
                abstractC2526r.mo15742a(this.f13071g, this.f13072h, this.f13073i.m15734c(), c2525qArr);
                m15721b(abstractC2526r);
                return;
            }
        }
    }
}
