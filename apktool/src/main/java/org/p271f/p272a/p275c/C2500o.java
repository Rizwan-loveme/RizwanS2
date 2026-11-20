package org.p271f.p272a.p275c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2525q;
import org.p271f.p272a.C2530v;

/* compiled from: LocalVariableAnnotationNode.java */
/* renamed from: org.f.a.c.o */
/* loaded from: classes.dex */
public class C2500o extends C2509x {

    /* renamed from: e */
    public List<C2497l> f13028e;

    /* renamed from: f */
    public List<C2497l> f13029f;

    /* renamed from: g */
    public List<Integer> f13030g;

    public C2500o(int i, C2530v c2530v, C2497l[] c2497lArr, C2497l[] c2497lArr2, int[] iArr, String str) {
        this(327680, i, c2530v, c2497lArr, c2497lArr2, iArr, str);
    }

    public C2500o(int i, int i2, C2530v c2530v, C2497l[] c2497lArr, C2497l[] c2497lArr2, int[] iArr, String str) {
        super(i, i2, c2530v, str);
        this.f13028e = new ArrayList(c2497lArr.length);
        this.f13028e.addAll(Arrays.asList(c2497lArr));
        this.f13029f = new ArrayList(c2497lArr2.length);
        this.f13029f.addAll(Arrays.asList(c2497lArr2));
        this.f13030g = new ArrayList(iArr.length);
        for (int i3 : iArr) {
            this.f13030g.add(Integer.valueOf(i3));
        }
    }

    /* renamed from: a */
    public void m15736a(AbstractC2526r abstractC2526r, boolean z) {
        C2525q[] c2525qArr = new C2525q[this.f13028e.size()];
        C2525q[] c2525qArr2 = new C2525q[this.f13029f.size()];
        int[] iArr = new int[this.f13030g.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < c2525qArr.length) {
                c2525qArr[i2] = this.f13028e.get(i2).m15734c();
                c2525qArr2[i2] = this.f13029f.get(i2).m15734c();
                iArr[i2] = this.f13030g.get(i2).intValue();
                i = i2 + 1;
            } else {
                m15723a(abstractC2526r.mo15643a(this.f13081h, this.f13082i, c2525qArr, c2525qArr2, iArr, this.f13000c, true));
                return;
            }
        }
    }
}
