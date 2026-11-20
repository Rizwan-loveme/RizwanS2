package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1334k;
import com.p140g.p152b.p153a.p156c.C1345b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: RemoveLocalFromSSA.java */
/* renamed from: com.g.b.a.c.l */
/* loaded from: classes.dex */
public class C1356l extends AbstractC1357m {

    /* compiled from: RemoveLocalFromSSA.java */
    /* renamed from: com.g.b.a.c.l$a */
    static class a {

        /* renamed from: c */
        C1314l f8762c;

        /* renamed from: a */
        Set<a> f8760a = new HashSet();

        /* renamed from: b */
        Set<a> f8761b = new HashSet();

        /* renamed from: d */
        boolean f8763d = false;
    }

    /* renamed from: a */
    static <T extends AbstractC1322t> void m10699a(List<C1324a> list, Map<C1314l, T> map) {
        for (C1324a c1324a : list) {
            T t = map.get(c1324a.mo10564e());
            if (t != null) {
                c1324a.mo10562c(t);
            }
        }
    }

    /* renamed from: a */
    private boolean m10702a(List<C1329f> list, List<C1324a> list2, Map<C1314l, C1314l> map, C1334k c1334k) {
        HashSet hashSet = new HashSet();
        if (list != null) {
            Iterator<C1329f> it = list.iterator();
            while (it.hasNext()) {
                Iterator<C1324a> it2 = it.next().f8638c.iterator();
                while (it2.hasNext()) {
                    hashSet.addAll(Arrays.asList(it2.next().mo10564e().mo10547j()));
                }
            }
        }
        Iterator<C1324a> it3 = list2.iterator();
        boolean z = false;
        while (it3.hasNext()) {
            C1324a next = it3.next();
            if (!hashSet.contains(next.mo10563d())) {
                it3.remove();
                c1334k.m10583d(next);
                map.put((C1314l) next.mo10563d(), (C1314l) next.mo10564e());
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    private void m10700a(List<C1329f> list, Map<C1314l, C1314l> map, Set<AbstractC1322t> set) {
        if (list != null) {
            Iterator<C1329f> it = list.iterator();
            while (it.hasNext()) {
                for (C1324a c1324a : it.next().f8638c) {
                    AbstractC1322t[] mo10547j = c1324a.mo10564e().mo10547j();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= mo10547j.length) {
                            break;
                        }
                        AbstractC1322t abstractC1322t = mo10547j[i2];
                        C1314l c1314l = map.get(abstractC1322t);
                        if (c1314l != null) {
                            set.add(c1314l);
                        } else {
                            set.add(abstractC1322t);
                        }
                        i = i2 + 1;
                    }
                    set.remove(c1324a.mo10563d());
                    c1324a.mo10564e().mo10541a((AbstractC1322t[]) set.toArray(new AbstractC1322t[set.size()]));
                    set.clear();
                }
            }
        }
    }

    /* renamed from: a */
    public static a m10696a(Map<C1314l, a> map, C1314l c1314l) {
        a aVar = map.get(c1314l);
        if (aVar == null) {
            a aVar2 = new a();
            aVar2.f8762c = c1314l;
            map.put(c1314l, aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* renamed from: a */
    public static void m10698a(a aVar, a aVar2) {
        aVar.f8761b.add(aVar2);
        aVar2.f8760a.add(aVar);
    }

    /* renamed from: b */
    private boolean m10704b(List<C1329f> list, Map<C1314l, C1314l> map, Set<AbstractC1322t> set) {
        if (list == null) {
            return false;
        }
        Iterator<C1329f> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            C1329f next = it.next();
            Iterator<C1324a> it2 = next.f8638c.iterator();
            boolean z2 = z;
            while (it2.hasNext()) {
                C1324a next2 = it2.next();
                set.addAll(Arrays.asList(next2.mo10564e().mo10547j()));
                set.remove(next2.mo10563d());
                if (set.size() == 1) {
                    it2.remove();
                    map.put((C1314l) next2.mo10563d(), (C1314l) set.iterator().next());
                    z2 = true;
                }
                set.clear();
            }
            if (next.f8638c.size() == 0) {
                next.f8638c = (List) null;
                it.remove();
            }
            z = z2;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private boolean m10703b(List<C1329f> list, Map<C1314l, C1314l> map) {
        C1314l c1314l;
        if (list == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Map<C1314l, a> m10697a = m10697a(list);
        C1360p c1360p = new C1360p();
        c1360p.addAll(m10697a.values());
        while (!c1360p.isEmpty()) {
            a aVar = (a) c1360p.poll();
            for (a aVar2 : aVar.f8761b) {
                if (aVar2.f8763d && aVar2.f8760a.addAll(aVar.f8760a)) {
                    c1360p.add(aVar2);
                }
            }
        }
        boolean z = false;
        for (a aVar3 : m10697a.values()) {
            if (aVar3.f8763d) {
                Iterator<a> it = aVar3.f8760a.iterator();
                C1314l c1314l2 = (C1314l) null;
                while (true) {
                    if (!it.hasNext()) {
                        c1314l = c1314l2;
                        break;
                    }
                    a next = it.next();
                    if (!next.f8763d) {
                        if (c1314l2 == null) {
                            c1314l2 = next.f8762c;
                        } else {
                            c1314l = (C1314l) null;
                            break;
                        }
                    }
                }
                if (c1314l != null) {
                    map.put(aVar3.f8762c, c1314l);
                    hashSet.add(aVar3.f8762c);
                    z = true;
                }
            }
        }
        Iterator<C1329f> it2 = list.iterator();
        while (it2.hasNext()) {
            C1329f next2 = it2.next();
            Iterator<C1324a> it3 = next2.f8638c.iterator();
            while (it3.hasNext()) {
                if (hashSet.contains(it3.next().mo10563d())) {
                    it3.remove();
                }
            }
            if (next2.f8638c.size() == 0) {
                next2.f8638c = (List) null;
                it2.remove();
            }
        }
        return z;
    }

    /* renamed from: a */
    private Map<C1314l, a> m10697a(List<C1329f> list) {
        HashMap hashMap = new HashMap();
        Iterator<C1329f> it = list.iterator();
        while (it.hasNext()) {
            for (C1324a c1324a : it.next().f8638c) {
                C1314l c1314l = (C1314l) c1324a.mo10563d();
                a m10696a = m10696a(hashMap, c1314l);
                m10696a.f8763d = true;
                AbstractC1322t[] mo10547j = c1324a.mo10564e().mo10547j();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < mo10547j.length) {
                        AbstractC1322t abstractC1322t = mo10547j[i2];
                        if (abstractC1322t != c1314l) {
                            m10698a(m10696a(hashMap, (C1314l) abstractC1322t), m10696a);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    static <T> void m10701a(Map<C1314l, T> map) {
        T t;
        ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<C1314l, T>>() { // from class: com.g.b.a.c.l.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                return m10705a((Map.Entry) obj, (Map.Entry) obj2);
            }

            /* renamed from: a */
            public int m10705a(Map.Entry<C1314l, T> entry, Map.Entry<C1314l, T> entry2) {
                return Integer.compare(entry.getKey().f8546a, entry2.getKey().f8546a);
            }
        });
        boolean z = true;
        while (z) {
            z = false;
            for (Map.Entry entry : arrayList) {
                Object value = entry.getValue();
                if ((value instanceof C1314l) && (t = map.get(value)) != null && value != t) {
                    entry.setValue(t);
                    z = true;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.g.b.a.b.j] */
    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        ArrayList arrayList = new ArrayList();
        List<C1329f> list = c1323b.f8631j;
        for (C1324a c1324a = c1323b.f8628g.m10574a(); c1324a != null; c1324a = c1324a.m10559b()) {
            if (c1324a.f8650n == AbstractC1333j.d.ASSIGN) {
                C1324a c1324a2 = c1324a;
                if (c1324a2.mo10563d().f8563h == AbstractC1322t.e.LOCAL && c1324a2.mo10564e().f8563h == AbstractC1322t.e.LOCAL) {
                    arrayList.add(c1324a2);
                }
            }
        }
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        boolean z = true;
        boolean z2 = false;
        while (z) {
            if (m10703b(list, hashMap)) {
                m10701a(hashMap);
                m10700a(list, hashMap, hashSet);
            }
            while (m10704b(list, hashMap, hashSet)) {
                m10701a(hashMap);
                m10700a(list, hashMap, hashSet);
            }
            z = false;
            while (m10702a(list, arrayList, hashMap, c1323b.f8628g)) {
                m10701a(hashMap);
                m10699a(arrayList, hashMap);
                z = true;
                z2 = true;
            }
            m10700a(list, hashMap, hashSet);
        }
        Iterator<C1314l> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            c1323b.f8624c.remove(it.next());
            z2 = true;
        }
        if (hashMap.size() > 0) {
            C1345b.m10650b(c1323b.f8628g, new C1345b.e(this, hashMap) { // from class: com.g.b.a.c.l.2

                /* renamed from: a */
                private final C1356l f8758a;

                /* renamed from: b */
                private final Map f8759b;

                {
                    this.f8758a = this;
                    this.f8759b = hashMap;
                }

                @Override // com.p140g.p152b.p153a.p156c.C1345b.c
                /* renamed from: a */
                public AbstractC1322t mo10612a(C1314l c1314l, C1324a c1324a3) {
                    return c1314l;
                }

                @Override // com.p140g.p152b.p153a.p156c.C1345b.d
                /* renamed from: a */
                public AbstractC1322t mo10611a(C1314l c1314l) {
                    C1314l c1314l2 = (C1314l) this.f8759b.get(c1314l);
                    return c1314l2 == null ? c1314l : c1314l2;
                }
            }, true);
        }
        return z2;
    }
}
