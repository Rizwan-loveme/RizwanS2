package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1366g;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p154a.C1317o;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p156c.C1345b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DeadCodeTransformer.java */
/* renamed from: com.g.b.a.c.d */
/* loaded from: classes.dex */
public class C1348d {
    /* renamed from: a */
    public void m10669a(C1323b c1323b) {
        boolean z;
        boolean z2;
        C1345b.m10653c(c1323b);
        C1345b.m10644a(c1323b, (C1345b.a) null);
        if (c1323b.f8629h != null) {
            Iterator<C1366g> it = c1323b.f8629h.iterator();
            while (it.hasNext()) {
                C1366g next = it.next();
                AbstractC1333j abstractC1333j = next.f8802a;
                while (true) {
                    if (abstractC1333j == next.f8803b) {
                        z2 = true;
                        break;
                    }
                    if (abstractC1333j.f8643g && C1345b.m10652b(abstractC1333j)) {
                        z2 = false;
                        break;
                    }
                    abstractC1333j = abstractC1333j.m10559b();
                }
                if (z2) {
                    it.remove();
                } else {
                    boolean z3 = true;
                    boolean z4 = true;
                    for (C1329f c1329f : next.f8804c) {
                        if (c1329f.f8643g) {
                            z4 = false;
                        } else {
                            z3 = false;
                        }
                    }
                    if (z4) {
                        it.remove();
                    } else {
                        next.f8802a.f8643g = true;
                        next.f8803b.f8643g = true;
                        if (!z3) {
                            ArrayList arrayList = new ArrayList(next.f8804c.length);
                            ArrayList arrayList2 = new ArrayList(next.f8804c.length);
                            for (int i = 0; i < next.f8804c.length; i++) {
                                arrayList2.add(next.f8804c[i]);
                                arrayList.add(next.f8805d[i]);
                            }
                            next.f8804c = (C1329f[]) arrayList2.toArray(new C1329f[arrayList2.size()]);
                            next.f8805d = (String[]) arrayList.toArray(new String[arrayList.size()]);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator<AbstractC1333j> it2 = c1323b.f8628g.iterator();
        while (it2.hasNext()) {
            AbstractC1333j next2 = it2.next();
            if (!next2.f8643g) {
                it2.remove();
            } else if (next2.f8650n == AbstractC1333j.d.ASSIGN || next2.f8650n == AbstractC1333j.d.IDENTITY) {
                if (next2.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                    hashSet.add((C1314l) next2.mo10563d());
                }
            }
        }
        if (c1323b.f8631j != null) {
            Iterator<C1329f> it3 = c1323b.f8631j.iterator();
            while (it3.hasNext()) {
                C1329f next3 = it3.next();
                if (!next3.f8643g) {
                    it3.remove();
                } else if (next3.f8638c != null) {
                    Iterator<C1324a> it4 = next3.f8638c.iterator();
                    while (it4.hasNext()) {
                        hashSet.add((C1314l) it4.next().mo10563d());
                    }
                }
            }
        }
        c1323b.f8624c.clear();
        c1323b.f8624c.addAll(hashSet);
        HashSet hashSet2 = new HashSet();
        if (c1323b.f8631j != null) {
            for (C1329f c1329f2 : c1323b.f8631j) {
                if (c1329f2.f8638c != null) {
                    Iterator<C1324a> it5 = c1329f2.f8638c.iterator();
                    while (it5.hasNext()) {
                        C1317o c1317o = (C1317o) it5.next().mo10564e();
                        AbstractC1322t[] j = c1317o.mo10547j();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= j.length) {
                                z = false;
                                break;
                            } else {
                                if (!hashSet.contains(j[i2])) {
                                    z = true;
                                    break;
                                }
                                i2++;
                            }
                        }
                        if (z) {
                            for (AbstractC1322t abstractC1322t : c1317o.mo10547j()) {
                                if (hashSet.contains(abstractC1322t)) {
                                    hashSet2.add(abstractC1322t);
                                }
                            }
                            c1317o.mo10541a((AbstractC1322t[]) hashSet2.toArray(new AbstractC1322t[hashSet2.size()]));
                            hashSet2.clear();
                        }
                    }
                }
            }
        }
    }
}
