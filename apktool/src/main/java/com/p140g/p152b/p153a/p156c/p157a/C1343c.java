package com.p140g.p152b.p153a.p156c.p157a;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p156c.C1360p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: SimpleLiveAnalyze.java */
/* renamed from: com.g.b.a.c.a.c */
/* loaded from: classes.dex */
public class C1343c extends AbstractC1342b<C1344d> {
    @Override // com.p140g.p152b.p153a.p156c.C1345b.b
    /* renamed from: a */
    public /* bridge */ Object mo10632a(Object obj, Object obj2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        return m10634a((C1344d[]) obj, (C1344d[]) obj2, abstractC1333j, abstractC1333j2);
    }

    @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
    /* renamed from: a */
    protected /* bridge */ void mo10617a(C1344d c1344d, C1314l c1314l) {
        a2(c1344d, c1314l);
    }

    @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
    /* renamed from: b */
    protected C1344d mo10621b(C1314l c1314l, AbstractC1322t abstractC1322t) {
        return m10631a(c1314l, abstractC1322t);
    }

    @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
    /* renamed from: b */
    protected C1344d[] mo10622b(int i) {
        return m10633a(i);
    }

    @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
    /* renamed from: d */
    protected C1344d mo10625d() {
        return m10637j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    protected Set<C1344d> m10635b() {
        HashSet hashSet = new HashSet(this.f8688b.size() / 2);
        C1360p c1360p = new C1360p();
        for (C1344d c1344d : this.f8688b) {
            if (c1344d.f8695a) {
                c1360p.add(c1344d);
                while (!c1360p.isEmpty()) {
                    C1344d c1344d2 = (C1344d) c1360p.poll();
                    if (c1344d2.f8695a && !hashSet.contains(c1344d2)) {
                        hashSet.add(c1344d2);
                        C1344d c1344d3 = c1344d2.f8696b;
                        if (c1344d3 != null && !c1344d3.f8695a) {
                            c1344d3.f8695a = true;
                            c1360p.add(c1344d3);
                        }
                        if (c1344d2.f8697c != null) {
                            for (C1344d c1344d4 : c1344d2.f8697c) {
                                if (!c1344d4.f8695a) {
                                    c1344d4.f8695a = true;
                                    c1360p.add(c1344d4);
                                }
                            }
                            c1344d2.f8697c = (List) null;
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
    /* renamed from: a */
    protected void mo10616a() {
        m10635b();
    }

    /* renamed from: c */
    public int m10636c() {
        return this.f8689c;
    }

    public C1343c(C1323b c1323b, boolean z) {
        super(c1323b, z);
    }

    /* renamed from: a */
    protected C1344d m10631a(C1314l c1314l, AbstractC1322t abstractC1322t) {
        C1344d c1344d = (C1344d) super.mo10621b(c1314l, abstractC1322t);
        c1344d.f8695a = true;
        return c1344d;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C1344d c1344d, C1314l c1314l) {
        c1344d.f8695a = true;
        super.mo10617a((C1343c) c1344d, c1314l);
    }

    /* renamed from: a */
    public C1344d[] m10634a(C1344d[] c1344dArr, C1344d[] c1344dArr2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        int i = 0;
        if (c1344dArr2 == null) {
            c1344dArr2 = new C1344d[this.f8689c];
            while (i < c1344dArr.length) {
                C1344d c1344d = c1344dArr[i];
                if (c1344d != null) {
                    C1344d c1344d2 = new C1344d();
                    this.f8688b.add(c1344d2);
                    c1344d2.f8696b = c1344d;
                    c1344dArr2[i] = c1344d2;
                }
                i++;
            }
        } else {
            while (i < c1344dArr.length) {
                C1344d c1344d3 = c1344dArr[i];
                C1344d c1344d4 = c1344dArr2[i];
                if (c1344d3 != null && c1344d4 != null) {
                    List list = c1344d4.f8697c;
                    if (list == null) {
                        list = new ArrayList(3);
                        c1344d4.f8697c = list;
                    }
                    list.add(c1344d3);
                }
                i++;
            }
        }
        return c1344dArr2;
    }

    /* renamed from: a */
    protected C1344d[] m10633a(int i) {
        return new C1344d[i];
    }

    /* renamed from: j */
    protected C1344d m10637j() {
        return new C1344d();
    }
}
