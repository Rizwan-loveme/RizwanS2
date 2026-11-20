package org.p271f.p272a.p275c;

import java.util.Iterator;
import java.util.List;
import org.p271f.p272a.AbstractC2526r;

/* compiled from: TryCatchBlockNode.java */
/* renamed from: org.f.a.c.w */
/* loaded from: classes.dex */
public class C2508w {

    /* renamed from: a */
    public C2497l f13075a;

    /* renamed from: b */
    public C2497l f13076b;

    /* renamed from: c */
    public C2497l f13077c;

    /* renamed from: d */
    public String f13078d;

    /* renamed from: e */
    public List<C2509x> f13079e;

    /* renamed from: f */
    public List<C2509x> f13080f;

    public C2508w(C2497l c2497l, C2497l c2497l2, C2497l c2497l3, String str) {
        this.f13075a = c2497l;
        this.f13076b = c2497l2;
        this.f13077c = c2497l3;
        this.f13078d = str;
    }

    /* renamed from: a */
    public void m15754a(int i) {
        int i2 = (i << 8) | 1107296256;
        if (this.f13079e != null) {
            Iterator<C2509x> it = this.f13079e.iterator();
            while (it.hasNext()) {
                it.next().f13081h = i2;
            }
        }
        if (this.f13080f != null) {
            Iterator<C2509x> it2 = this.f13080f.iterator();
            while (it2.hasNext()) {
                it2.next().f13081h = i2;
            }
        }
    }

    /* renamed from: a */
    public void m15755a(AbstractC2526r abstractC2526r) {
        abstractC2526r.mo15684a(this.f13075a.m15734c(), this.f13076b.m15734c(), this.f13077c == null ? null : this.f13077c.m15734c(), this.f13078d);
        int size = this.f13079e == null ? 0 : this.f13079e.size();
        for (int i = 0; i < size; i++) {
            C2509x c2509x = this.f13079e.get(i);
            c2509x.m15723a(abstractC2526r.mo15688c(c2509x.f13081h, c2509x.f13082i, c2509x.f13000c, true));
        }
        int size2 = this.f13080f == null ? 0 : this.f13080f.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C2509x c2509x2 = this.f13080f.get(i2);
            c2509x2.m15723a(abstractC2526r.mo15688c(c2509x2.f13081h, c2509x2.f13082i, c2509x2.f13000c, false));
        }
    }
}
