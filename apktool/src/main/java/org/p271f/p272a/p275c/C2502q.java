package org.p271f.p272a.p275c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2525q;

/* compiled from: LookupSwitchInsnNode.java */
/* renamed from: org.f.a.c.q */
/* loaded from: classes.dex */
public class C2502q extends AbstractC2486a {

    /* renamed from: g */
    public C2497l f13037g;

    /* renamed from: h */
    public List<Integer> f13038h;

    /* renamed from: i */
    public List<C2497l> f13039i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2502q(C2497l c2497l, int[] iArr, C2497l[] c2497lArr) {
        super(171);
        this.f13037g = c2497l;
        this.f13038h = new ArrayList(iArr == null ? 0 : iArr.length);
        this.f13039i = new ArrayList(c2497lArr == null ? 0 : c2497lArr.length);
        if (iArr != null) {
            for (int i : iArr) {
                this.f13038h.add(new Integer(i));
            }
        }
        if (c2497lArr != null) {
            this.f13039i.addAll(Arrays.asList(c2497lArr));
        }
    }

    @Override // org.p271f.p272a.p275c.AbstractC2486a
    /* renamed from: a */
    public void mo15719a(AbstractC2526r abstractC2526r) {
        int[] iArr = new int[this.f13038h.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = this.f13038h.get(i).intValue();
        }
        C2525q[] c2525qArr = new C2525q[this.f13039i.size()];
        for (int i2 = 0; i2 < c2525qArr.length; i2++) {
            c2525qArr[i2] = this.f13039i.get(i2).m15734c();
        }
        abstractC2526r.mo15748a(this.f13037g.m15734c(), iArr, c2525qArr);
        m15721b(abstractC2526r);
    }
}
