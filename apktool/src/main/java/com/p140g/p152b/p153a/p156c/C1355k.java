package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1307e;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p156c.C1345b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RemoveConstantFromSSA.java */
/* renamed from: com.g.b.a.c.k */
/* loaded from: classes.dex */
public class C1355k extends AbstractC1357m {

    /* renamed from: a */
    public static final Comparator<C1314l> f8755a = new Comparator<C1314l>() { // from class: com.g.b.a.c.k.1
        @Override // java.util.Comparator
        public int compare(C1314l c1314l, C1314l c1314l2) {
            return m10695a(c1314l, c1314l2);
        }

        /* renamed from: a */
        public int m10695a(C1314l c1314l, C1314l c1314l2) {
            return Integer.compare(c1314l.f8546a, c1314l2.f8546a);
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (AbstractC1333j m10574a = c1323b.f8628g.m10574a(); m10574a != null; m10574a = m10574a.m10559b()) {
            if (m10574a.f8650n == AbstractC1333j.d.ASSIGN) {
                C1324a c1324a = (C1324a) m10574a;
                if (c1324a.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                    if (c1324a.mo10564e().f8563h == AbstractC1322t.e.CONSTANT) {
                        arrayList.add(c1324a);
                        hashMap.put((C1314l) c1324a.mo10563d(), ((C1307e) c1324a.mo10564e()).f8534b);
                    } else if (c1324a.mo10564e().f8563h == AbstractC1322t.e.LOCAL) {
                        hashMap.put((C1314l) c1324a.mo10563d(), c1324a.mo10564e());
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            return false;
        }
        C1356l.m10701a(hashMap);
        HashMap hashMap2 = new HashMap();
        HashSet hashSet = new HashSet();
        List<C1329f> list = c1323b.f8631j;
        if (list == null) {
            z = false;
        } else {
            boolean z3 = true;
            z = false;
            while (z3) {
                hashSet.clear();
                Iterator<C1329f> it = list.iterator();
                z3 = false;
                while (it.hasNext()) {
                    C1329f next = it.next();
                    if (next.f8638c != null) {
                        Iterator<C1324a> it2 = next.f8638c.iterator();
                        boolean z4 = z3;
                        boolean z5 = z;
                        while (it2.hasNext()) {
                            C1324a next2 = it2.next();
                            AbstractC1322t[] mo10547j = next2.mo10564e().mo10547j();
                            int i = 0;
                            AbstractC1322t abstractC1322t = (Object) 0;
                            while (true) {
                                if (i >= mo10547j.length) {
                                    z2 = true;
                                    break;
                                }
                                Object obj = hashMap.get(mo10547j[i]);
                                if (obj == null) {
                                    z2 = false;
                                    break;
                                }
                                if (abstractC1322t != null) {
                                    if (!abstractC1322t.equals(obj)) {
                                        z2 = false;
                                        break;
                                    }
                                } else {
                                    abstractC1322t = obj;
                                }
                                i++;
                            }
                            if (z2) {
                                hashMap.put((C1314l) next2.mo10563d(), abstractC1322t);
                                if (abstractC1322t instanceof C1314l) {
                                    next2.mo10562c(abstractC1322t);
                                } else {
                                    next2.mo10562c(C1308f.m10506b(abstractC1322t));
                                    arrayList.add(next2);
                                }
                                it2.remove();
                                c1323b.f8628g.m10579b(next, next2);
                                z5 = true;
                                z4 = true;
                            } else {
                                hashSet.addAll(Arrays.asList(next2.mo10564e().mo10547j()));
                            }
                        }
                        if (next.f8638c.size() == 0) {
                            it.remove();
                        }
                        z3 = z4;
                        z = z5;
                    }
                }
            }
        }
        Iterator<E> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            C1324a c1324a2 = (C1324a) it3.next();
            if (!hashSet.contains(c1324a2.mo10563d())) {
                it3.remove();
                c1323b.f8628g.m10583d(c1324a2);
                c1323b.f8624c.remove(c1324a2.mo10563d());
                z = true;
            }
            hashMap2.put((C1314l) c1324a2.mo10563d(), c1324a2.mo10564e());
        }
        C1345b.m10650b(c1323b.f8628g, new C1345b.e(this, hashMap2) { // from class: com.g.b.a.c.k.2

            /* renamed from: a */
            private final C1355k f8756a;

            /* renamed from: b */
            private final Map f8757b;

            {
                this.f8756a = this;
                this.f8757b = hashMap2;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.c
            /* renamed from: a */
            public AbstractC1322t mo10612a(C1314l c1314l, C1324a c1324a3) {
                return c1314l;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.d
            /* renamed from: a */
            public AbstractC1322t mo10611a(C1314l c1314l) {
                AbstractC1322t abstractC1322t2 = (AbstractC1322t) this.f8757b.get(c1314l);
                return abstractC1322t2 == null ? c1314l : abstractC1322t2.mo10480a();
            }
        }, false);
        return z;
    }
}
