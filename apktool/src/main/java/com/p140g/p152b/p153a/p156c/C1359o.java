package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p154a.C1317o;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1334k;
import com.p140g.p152b.p153a.p155b.C1335l;
import com.p140g.p152b.p153a.p155b.InterfaceC1328e;
import com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b;
import com.p140g.p152b.p153a.p156c.p157a.InterfaceC1341a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: UnSSATransformer.java */
/* renamed from: com.g.b.a.c.o */
/* loaded from: classes.dex */
public class C1359o {

    /* renamed from: a */
    protected static final Comparator<c> f8786a = new Comparator<c>() { // from class: com.g.b.a.c.o.1
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return m10756a(cVar, cVar2);
        }

        /* renamed from: a */
        public int m10756a(c cVar, c cVar2) {
            return cVar2.f8794a.size() - cVar.f8794a.size();
        }
    };

    /* compiled from: UnSSATransformer.java */
    /* renamed from: com.g.b.a.c.o$c */
    protected static class c {

        /* renamed from: a */
        public Set<c> f8794a = new HashSet();
    }

    /* renamed from: a */
    private void m10753a(C1323b c1323b, Collection<C1329f> collection) {
        boolean z;
        for (C1329f c1329f : collection) {
            for (C1324a c1324a : c1329f.f8638c) {
                C1314l c1314l = (C1314l) c1324a.mo10563d();
                C1317o c1317o = (C1317o) c1324a.mo10564e();
                c cVar = (c) c1314l.f8562g;
                AbstractC1322t[] j = c1317o.mo10547j();
                int i = 0;
                while (true) {
                    if (i >= j.length) {
                        z = false;
                        break;
                    }
                    if (cVar.f8794a.contains((c) ((C1314l) j[i]).f8562g)) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    C1314l c1314l2 = (C1314l) c1314l.mo10480a();
                    c1324a.f8652a = c1314l2;
                    c cVar2 = new c();
                    c1314l2.f8562g = cVar2;
                    c1323b.f8624c.add(c1314l2);
                    C1324a m10586a = C1335l.m10586a(c1314l, c1314l2);
                    AbstractC1333j b2 = c1329f.m10559b();
                    if (b2 != null && b2.f8650n == AbstractC1333j.d.IDENTITY && b2.mo10564e().f8563h == AbstractC1322t.e.EXCEPTION_REF) {
                        c1323b.f8628g.m10579b(b2, m10586a);
                    } else {
                        c1323b.f8628g.m10579b(c1329f, m10586a);
                    }
                    b[] bVarArr = (b[]) c1329f.f8644h;
                    bVarArr[c1314l.f8546a].f8789b = c1314l2;
                    for (b bVar : bVarArr) {
                        if (bVar != null && bVar.f8791d) {
                            c cVar3 = (c) bVar.f8789b.f8562g;
                            cVar3.f8794a.add(cVar2);
                            cVar2.f8794a.add(cVar3);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m10754b(C1323b c1323b, Collection<C1329f> collection) {
        ArrayList arrayList = new ArrayList();
        for (C1329f c1329f : collection) {
            List<C1324a> list = c1329f.f8638c;
            b[] bVarArr = (b[]) c1329f.f8644h;
            for (AbstractC1333j abstractC1333j : c1329f.f8641e) {
                if (abstractC1333j.f8643g) {
                    Iterator<C1324a> it = list.iterator();
                    while (it.hasNext()) {
                        C1314l c1314l = (C1314l) it.next().mo10563d();
                        C1314l c1314l2 = bVarArr[c1314l.f8546a].f8793f.get(abstractC1333j);
                        if (c1314l2 != c1314l) {
                            arrayList.add(C1335l.m10586a(c1314l, c1314l2));
                        }
                    }
                    m10751a(c1323b.f8628g, abstractC1333j, c1329f, arrayList);
                    arrayList.clear();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m10751a(C1334k c1334k, AbstractC1333j abstractC1333j, C1329f c1329f, List<C1324a> list) {
        boolean z;
        b bVar;
        if (abstractC1333j.f8642f == null || !abstractC1333j.f8642f.contains(c1329f)) {
            AbstractC1333j.d dVar = abstractC1333j.f8650n;
            if (dVar == AbstractC1333j.d.GOTO || dVar == AbstractC1333j.d.IF) {
                z = ((InterfaceC1328e) abstractC1333j).mo10555a().equals(c1329f);
            } else {
                z = dVar == AbstractC1333j.d.TABLE_SWITCH || dVar == AbstractC1333j.d.LOOKUP_SWITCH;
            }
        } else {
            z = true;
        }
        if (z) {
            Iterator<C1324a> it = list.iterator();
            while (it.hasNext()) {
                c1334k.m10582c(abstractC1333j, it.next());
            }
        } else {
            Iterator<C1324a> it2 = list.iterator();
            while (it2.hasNext()) {
                c1334k.m10579b(abstractC1333j, it2.next());
            }
        }
        b[] bVarArr = (b[]) abstractC1333j.f8644h;
        ArrayList arrayList = new ArrayList(list.size());
        for (C1324a c1324a : list) {
            C1314l c1314l = (C1314l) c1324a.mo10563d();
            b bVar2 = new b();
            bVar2.f8789b = c1314l;
            bVar2.f8791d = true;
            arrayList.add(bVar2);
            c cVar = (c) c1314l.f8562g;
            int i = ((C1314l) c1324a.mo10564e()).f8546a;
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                if (i2 != i && (bVar = bVarArr[i2]) != null && bVar.f8791d) {
                    c cVar2 = (c) bVar.f8789b.f8562g;
                    cVar2.f8794a.add(cVar);
                    cVar.f8794a.add(cVar2);
                }
            }
            Iterator<C1324a> it3 = list.iterator();
            while (it3.hasNext()) {
                c cVar3 = (c) ((C1314l) it3.next().mo10563d()).f8562g;
                cVar3.f8794a.add(cVar);
                cVar.f8794a.add(cVar3);
            }
        }
        b[] bVarArr2 = new b[bVarArr.length + arrayList.size()];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            bVarArr2[i3 + bVarArr.length] = (b) arrayList.get(i3);
        }
    }

    /* renamed from: a */
    public void m10755a(C1323b c1323b) {
        if (c1323b.f8631j != null && c1323b.f8631j.size() != 0) {
            for (C1329f c1329f : c1323b.f8631j) {
                AbstractC1333j b2 = c1329f.m10559b();
                if (b2.f8650n == AbstractC1333j.d.LABEL) {
                    C1329f c1329f2 = (C1329f) b2;
                    if (c1329f2.f8638c != null && c1329f2.f8638c.size() > 0) {
                        c1323b.f8628g.m10579b(c1329f, C1335l.m10594b());
                    }
                }
            }
            a aVar = new a(c1323b);
            aVar.m10626e();
            m10752a(c1323b, aVar);
            m10753a(c1323b, c1323b.f8631j);
            m10754b(c1323b, c1323b.f8631j);
            Iterator<C1314l> it = c1323b.f8624c.iterator();
            while (it.hasNext()) {
                it.next().f8562g = (Object) null;
            }
            Iterator<AbstractC1333j> it2 = c1323b.f8628g.iterator();
            while (it2.hasNext()) {
                it2.next().f8644h = (Object) null;
            }
            Iterator<C1329f> it3 = c1323b.f8631j.iterator();
            while (it3.hasNext()) {
                it3.next().f8638c = (List) null;
            }
            c1323b.f8631j = (List) null;
        }
    }

    /* renamed from: a */
    private void m10752a(C1323b c1323b, a aVar) {
        b bVar;
        Iterator<C1314l> it = c1323b.f8624c.iterator();
        while (it.hasNext()) {
            it.next().f8562g = new c();
        }
        HashSet<AbstractC1333j> hashSet = new HashSet();
        for (AbstractC1333j abstractC1333j : c1323b.f8628g) {
            if ((abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN || abstractC1333j.f8650n == AbstractC1333j.d.IDENTITY) && abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                C1314l c1314l = (C1314l) abstractC1333j.mo10563d();
                c cVar = (c) c1314l.f8562g;
                HashSet hashSet2 = new HashSet();
                C1345b.m10641a(abstractC1333j, hashSet);
                for (AbstractC1333j abstractC1333j2 : hashSet) {
                    b[] bVarArr = (b[]) abstractC1333j2.f8644h;
                    if (bVarArr != null) {
                        hashSet2.clear();
                        hashSet2.add(new Integer(c1314l.f8546a));
                        if (abstractC1333j2.f8650n == AbstractC1333j.d.LABEL) {
                            C1329f c1329f = (C1329f) abstractC1333j2;
                            if (c1329f.f8638c != null) {
                                Iterator<C1324a> it2 = c1329f.f8638c.iterator();
                                while (it2.hasNext()) {
                                    hashSet2.add(new Integer(((C1314l) it2.next().mo10563d()).f8546a));
                                }
                            }
                        }
                        for (int i = 0; i < bVarArr.length; i++) {
                            if (!hashSet2.contains(new Integer(i)) && (bVar = bVarArr[i]) != null && bVar.f8791d) {
                                c cVar2 = (c) bVar.f8789b.f8562g;
                                cVar.f8794a.add(cVar2);
                                cVar2.f8794a.add(cVar);
                            }
                        }
                    }
                }
                hashSet.clear();
            } else if (abstractC1333j.f8650n == AbstractC1333j.d.LABEL) {
                C1329f c1329f2 = (C1329f) abstractC1333j;
                if (c1329f2.f8638c != null) {
                    Iterator<C1324a> it3 = c1329f2.f8638c.iterator();
                    while (it3.hasNext()) {
                        c cVar3 = (c) ((C1314l) it3.next().mo10563d()).f8562g;
                        for (b bVar2 : (b[]) abstractC1333j.f8644h) {
                            if (bVar2 != null && bVar2.f8791d) {
                                c cVar4 = (c) bVar2.f8789b.f8562g;
                                cVar3.f8794a.add(cVar4);
                                cVar4.f8794a.add(cVar3);
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: UnSSATransformer.java */
    /* renamed from: com.g.b.a.c.o$a */
    protected static class a extends AbstractC1342b<b> {

        /* renamed from: a */
        static Comparator<b> f8787a = new Comparator<b>() { // from class: com.g.b.a.c.o.a.1
            @Override // java.util.Comparator
            public int compare(b bVar, b bVar2) {
                return m10762a(bVar, bVar2);
            }

            /* renamed from: a */
            public int m10762a(b bVar, b bVar2) {
                return bVar.f8788a - bVar2.f8788a;
            }
        };

        @Override // com.p140g.p152b.p153a.p156c.C1345b.b
        /* renamed from: a */
        public /* bridge */ Object mo10632a(Object obj, Object obj2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
            return m10759a((b[]) obj, (b[]) obj2, abstractC1333j, abstractC1333j2);
        }

        @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
        /* renamed from: a */
        protected /* bridge */ void mo10617a(b bVar, C1314l c1314l) {
            a2(bVar, c1314l);
        }

        @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
        /* renamed from: b */
        protected b mo10621b(C1314l c1314l, AbstractC1322t abstractC1322t) {
            return m10757a(c1314l, abstractC1322t);
        }

        @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
        /* renamed from: b */
        protected b[] mo10622b(int i) {
            return m10758a(i);
        }

        @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
        /* renamed from: d */
        protected b mo10625d() {
            return m10761c();
        }

        public a(C1323b c1323b) {
            super(c1323b);
        }

        @Override // com.p140g.p152b.p153a.p156c.p157a.AbstractC1342b
        /* renamed from: a */
        protected void mo10616a() {
            m10760b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        protected Set<b> m10760b() {
            HashSet hashSet = new HashSet(this.f8688b.size() / 2);
            C1360p c1360p = new C1360p();
            c1360p.addAll(this.f8688b);
            while (!c1360p.isEmpty()) {
                b bVar = (b) c1360p.poll();
                if (bVar.f8791d && !hashSet.contains(bVar)) {
                    hashSet.add(bVar);
                    b bVar2 = bVar.f8790c;
                    if (bVar2 != null && !bVar2.f8791d) {
                        bVar2.f8791d = true;
                        c1360p.add(bVar2);
                    }
                    List<b> list = bVar.f8792e;
                    if (list != null && list.size() > 0) {
                        for (b bVar3 : list) {
                            if (bVar3 != null && !bVar3.f8791d) {
                                bVar3.f8791d = true;
                                c1360p.add(bVar3);
                            }
                        }
                        bVar.f8792e = (List) null;
                    }
                }
            }
            Iterator it = this.f8688b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).f8790c = (b) null;
            }
            this.f8688b = (List) 0;
            return hashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @SuppressWarnings({"unchecked", "rawtypes"})
        /* renamed from: a */
        public b[] m10759a(b[] bVarArr, b[] bVarArr2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
            boolean z;
            b bVar;
            b bVar2;
            HashMap hashMap = new HashMap();
            if (abstractC1333j2.f8650n == AbstractC1333j.d.LABEL) {
                C1329f c1329f = (C1329f) abstractC1333j2;
                if (c1329f.f8638c != null) {
                    for (C1324a c1324a : c1329f.f8638c) {
                        hashMap.put(new Integer(((C1314l) c1324a.mo10563d()).f8546a), c1324a);
                    }
                }
            }
            if (bVarArr2 == null) {
                b[] i = m10630i();
                for (int i2 = 0; i2 < i.length; i2++) {
                    if (!hashMap.containsKey(new Integer(i2)) && (bVar2 = bVarArr[i2]) != null) {
                        b m10761c = m10761c();
                        this.f8688b.add(m10761c);
                        m10761c.f8790c = bVar2;
                        m10761c.f8788a = bVar2.f8788a + 1;
                        m10761c.f8789b = bVar2.f8789b;
                        i[i2] = m10761c;
                    }
                }
                z = true;
                bVarArr2 = i;
            } else {
                z = false;
            }
            if (!z) {
                for (int i3 = 0; i3 < bVarArr2.length; i3++) {
                    if (!hashMap.containsKey(new Integer(i3))) {
                        b bVar3 = bVarArr[i3];
                        b bVar4 = bVarArr2[i3];
                        if (bVar3 != null && bVar4 != null) {
                            if (bVar4.f8792e == null) {
                                bVar4.f8792e = new ArrayList(5);
                            }
                            bVar4.f8792e.add(bVar3);
                        }
                    }
                }
            }
            for (C1324a c1324a2 : hashMap.values()) {
                C1314l c1314l = (C1314l) c1324a2.mo10563d();
                if (z) {
                    bVar = new b();
                    bVar.f8789b = c1314l;
                    bVar.f8793f = new HashMap();
                    bVarArr2[c1314l.f8546a] = bVar;
                } else {
                    bVar = bVarArr2[c1314l.f8546a];
                }
                ArrayList arrayList = new ArrayList();
                b bVar5 = bVarArr[c1314l.f8546a];
                if (bVar5 != null) {
                    arrayList.add(bVar5);
                }
                for (AbstractC1322t abstractC1322t : c1324a2.mo10564e().mo10547j()) {
                    b bVar6 = bVarArr[((C1314l) abstractC1322t).f8546a];
                    if (bVar6 != null) {
                        arrayList.add(bVar6);
                    }
                }
                Collections.sort(arrayList, f8787a);
                b bVar7 = (b) arrayList.get(0);
                bVar7.f8791d = true;
                bVar.f8793f.put(abstractC1333j, bVar7.f8789b);
            }
            return bVarArr2;
        }

        /* renamed from: a */
        protected b[] m10758a(int i) {
            return new b[i];
        }

        /* renamed from: c */
        protected b m10761c() {
            return new b();
        }

        /* renamed from: a */
        protected b m10757a(C1314l c1314l, AbstractC1322t abstractC1322t) {
            b bVar = (b) super.mo10621b(c1314l, abstractC1322t);
            bVar.f8789b = c1314l;
            bVar.f8791d = true;
            return bVar;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        protected void a2(b bVar, C1314l c1314l) {
            bVar.f8791d = true;
        }
    }

    /* compiled from: UnSSATransformer.java */
    /* renamed from: com.g.b.a.c.o$b */
    private static class b implements InterfaceC1341a {

        /* renamed from: a */
        public int f8788a;

        /* renamed from: b */
        public C1314l f8789b;

        /* renamed from: c */
        public b f8790c;

        /* renamed from: d */
        public boolean f8791d;

        /* renamed from: e */
        public List<b> f8792e;

        /* renamed from: f */
        Map<AbstractC1333j, C1314l> f8793f;

        @Override // com.p140g.p152b.p153a.p156c.p157a.InterfaceC1341a
        /* renamed from: a */
        public char mo10613a() {
            return this.f8791d ? 'x' : '?';
        }

        public String toString() {
            return new StringBuffer().append(new StringBuffer().append(this.f8789b).append("|").toString()).append(this.f8788a).toString();
        }
    }
}
