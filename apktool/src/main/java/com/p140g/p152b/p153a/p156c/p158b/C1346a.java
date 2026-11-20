package com.p140g.p152b.p153a.p156c.p158b;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1304b;
import com.p140g.p152b.p153a.p154a.C1307e;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1310h;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p154a.C1320r;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1335l;
import com.p140g.p152b.p153a.p156c.AbstractC1357m;
import com.p140g.p152b.p153a.p156c.C1345b;
import com.p140g.p152b.p153a.p156c.C1360p;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: FillArrayTransformer.java */
/* renamed from: com.g.b.a.c.b.a */
/* loaded from: classes.dex */
public class C1346a extends AbstractC1357m {

    /* compiled from: FillArrayTransformer.java */
    /* renamed from: com.g.b.a.c.b.a$a */
    private static class a {

        /* renamed from: a */
        int f8712a;

        /* renamed from: b */
        String f8713b;

        /* renamed from: c */
        C1324a f8714c;

        /* renamed from: d */
        List<AbstractC1333j> f8715d = new ArrayList();

        /* renamed from: e */
        List<AbstractC1333j> f8716e = new ArrayList();

        a(int i, String str, C1324a c1324a) {
            this.f8712a = i;
            this.f8713b = str;
            this.f8714c = c1324a;
        }
    }

    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        Map<C1314l, a> m10658c = m10658c(c1323b);
        if (m10658c.size() == 0) {
            return false;
        }
        m10656a(m10658c);
        if (m10658c.size() == 0) {
            return false;
        }
        m10657b(c1323b, m10658c);
        if (m10658c.size() == 0) {
            return false;
        }
        m10655a(c1323b, m10658c);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m10655a(C1323b c1323b, Map<C1314l, a> map) {
        AbstractC1322t abstractC1322t;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<C1314l, a> entry : map.entrySet()) {
            C1314l key = entry.getKey();
            a value = entry.getValue();
            AbstractC1322t[] abstractC1322tArr = new AbstractC1322t[value.f8712a];
            for (AbstractC1333j abstractC1333j : value.f8715d) {
                if (abstractC1333j.f8650n == AbstractC1333j.d.FILL_ARRAY_DATA) {
                    if (((C1314l) abstractC1333j.mo10563d()) == key) {
                        Object obj = ((C1307e) abstractC1333j.mo10564e()).f8534b;
                        int length = Array.getLength(obj);
                        for (int i = 0; i < length; i++) {
                            abstractC1322tArr[i] = C1308f.m10506b(Array.get(obj, i));
                        }
                    }
                } else {
                    C1304b c1304b = (C1304b) abstractC1333j.mo10563d();
                    if (((C1314l) c1304b.mo10545h()) == key) {
                        int intValue = ((Number) ((C1307e) c1304b.mo10546i()).f8534b).intValue();
                        AbstractC1322t mo10564e = abstractC1333j.mo10564e();
                        if (mo10564e.f8563h == AbstractC1322t.e.LOCAL || mo10564e.f8563h == AbstractC1322t.e.CONSTANT) {
                            abstractC1322t = mo10564e;
                        } else {
                            C1314l c1314l = new C1314l(-1);
                            c1323b.f8624c.add(c1314l);
                            c1323b.f8628g.m10582c(abstractC1333j, C1335l.m10586a(c1314l, mo10564e));
                            abstractC1322t = c1314l;
                        }
                        abstractC1322tArr[intValue] = abstractC1322t;
                    }
                }
            }
            c1323b.f8624c.remove(key);
            c1323b.f8628g.m10583d(value.f8714c);
            Iterator<AbstractC1333j> it = value.f8715d.iterator();
            while (it.hasNext()) {
                c1323b.f8628g.m10583d(it.next());
            }
            C1345b.e eVar = new C1345b.e(this, key, value, abstractC1322tArr, arrayList) { // from class: com.g.b.a.c.b.a.1

                /* renamed from: a */
                private final C1346a f8699a;

                /* renamed from: b */
                private final C1314l f8700b;

                /* renamed from: c */
                private final a f8701c;

                /* renamed from: d */
                private final AbstractC1322t[] f8702d;

                /* renamed from: e */
                private final List f8703e;

                {
                    this.f8699a = this;
                    this.f8700b = key;
                    this.f8701c = value;
                    this.f8702d = abstractC1322tArr;
                    this.f8703e = arrayList;
                }

                @Override // com.p140g.p152b.p153a.p156c.C1345b.c
                /* renamed from: a */
                public AbstractC1322t mo10612a(C1314l c1314l2, C1324a c1324a) {
                    return c1314l2;
                }

                @Override // com.p140g.p152b.p153a.p156c.C1345b.d
                /* renamed from: a */
                public AbstractC1322t mo10611a(C1314l c1314l2) {
                    if (this.f8700b == c1314l2) {
                        C1310h m10492a = C1308f.m10492a(this.f8701c.f8713b, this.f8702d);
                        this.f8703e.add(m10492a);
                        return m10492a;
                    }
                    return c1314l2;
                }
            };
            if (value.f8716e.size() == 1) {
                AbstractC1333j abstractC1333j2 = value.f8716e.get(0);
                if (c1323b.f8628g.m10580b(abstractC1333j2)) {
                    C1345b.m10640a(abstractC1333j2, eVar, false);
                } else {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        C1345b.m10638a((C1310h) arrayList.get(i2), eVar);
                    }
                }
            } else if (value.f8716e.size() != 0) {
                throw new RuntimeException("array is used multiple times");
            }
        }
    }

    /* renamed from: b */
    private void m10657b(C1323b c1323b, Map<C1314l, a> map) {
        Iterator<C1314l> it = c1323b.f8624c.iterator();
        while (it.hasNext()) {
            it.next().f8546a = -1;
        }
        if (map.size() < 50) {
            m10659c(c1323b, map);
        } else {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList = new ArrayList(50);
            Iterator<Map.Entry<C1314l, a>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                for (int i = 0; i < 50 && it2.hasNext(); i++) {
                    Map.Entry<C1314l, a> next = it2.next();
                    hashMap2.put(next.getKey(), next.getValue());
                    it2.remove();
                    arrayList.add(next.getKey());
                }
                m10659c(c1323b, hashMap2);
                Iterator<E> it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((C1314l) it3.next()).f8546a = -1;
                }
                arrayList.clear();
                hashMap.putAll(hashMap2);
                hashMap2.clear();
            }
            map.putAll(hashMap);
        }
        C1345b.m10654d(c1323b);
    }

    /* renamed from: c */
    private void m10659c(C1323b c1323b, Map<C1314l, a> map) {
        Iterator<C1314l> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next().f8546a = i;
            i++;
        }
        ArrayList arrayList = new ArrayList();
        C1345b.m10642a(c1323b.f8628g, new C1345b.b<b[]>(this, i, arrayList, map) { // from class: com.g.b.a.c.b.a.2

            /* renamed from: a */
            b[] f8704a = m10663b((AbstractC1333j) null);

            /* renamed from: b */
            AbstractC1333j f8705b;

            /* renamed from: c */
            private final C1346a f8706c;

            /* renamed from: d */
            private final int f8707d;

            /* renamed from: e */
            private final List f8708e;

            /* renamed from: f */
            private final Map f8709f;

            {
                this.f8706c = this;
                this.f8707d = i;
                this.f8708e = arrayList;
                this.f8709f = map;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.b
            /* renamed from: a */
            public b[] mo10614a(AbstractC1333j abstractC1333j) {
                return m10663b(abstractC1333j);
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.b
            /* renamed from: a */
            public /* bridge */ b[] mo10615a(b[] bVarArr, AbstractC1333j abstractC1333j) {
                return a2(bVarArr, abstractC1333j);
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.b
            /* renamed from: a */
            public /* bridge */ b[] mo10632a(b[] bVarArr, b[] bVarArr2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
                return a2(bVarArr, bVarArr2, abstractC1333j, abstractC1333j2);
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public b[] a2(b[] bVarArr, b[] bVarArr2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
                int i2 = 0;
                if (bVarArr2 == null) {
                    bVarArr2 = new b[this.f8707d];
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.f8707d) {
                            break;
                        }
                        b bVar = bVarArr[i3];
                        if (bVar != null) {
                            b bVar2 = new b(bVar.f8718b);
                            this.f8708e.add(bVar2);
                            bVar2.f8719c = bVar.f8719c;
                            bVar2.f8720d = bVar;
                            bVar2.f8717a = (BitSet) bVar.f8717a.clone();
                            bVarArr2[i3] = bVar2;
                        }
                        i2 = i3 + 1;
                    }
                } else {
                    while (i2 < this.f8707d) {
                        b bVar3 = bVarArr[i2];
                        b bVar4 = bVarArr2[i2];
                        if (bVar3 != null && bVar4 != null) {
                            if (bVar4.f8721e == null) {
                                bVar4.f8721e = new HashSet();
                            }
                            bVar4.f8721e.add(bVar3);
                        }
                        i2++;
                    }
                }
                return bVarArr2;
            }

            /* renamed from: b */
            public b[] m10663b(AbstractC1333j abstractC1333j) {
                return new b[this.f8707d];
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public b[] a2(b[] bVarArr, AbstractC1333j abstractC1333j) {
                this.f8705b = abstractC1333j;
                System.arraycopy(bVarArr, 0, this.f8704a, 0, this.f8707d);
                if (abstractC1333j.f8650n == AbstractC1333j.d.FILL_ARRAY_DATA) {
                    if (abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                        C1314l c1314l = (C1314l) abstractC1333j.mo10563d();
                        if (c1314l.f8546a >= 0) {
                            b bVar = this.f8704a[c1314l.f8546a];
                            bVar.f8717a.set(0, Array.getLength(((C1307e) abstractC1333j.mo10564e()).f8534b));
                        }
                    } else {
                        m10662a(abstractC1333j.mo10563d());
                    }
                } else if (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN && abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.ARRAY) {
                    m10662a(abstractC1333j.mo10564e());
                    C1304b c1304b = (C1304b) abstractC1333j.mo10563d();
                    if (c1304b.mo10545h().f8563h == AbstractC1322t.e.LOCAL) {
                        C1314l c1314l2 = (C1314l) c1304b.mo10545h();
                        if (c1314l2.f8546a >= 0) {
                            this.f8704a[c1314l2.f8546a].f8717a.set(((Number) ((C1307e) c1304b.mo10546i()).f8534b).intValue());
                        } else {
                            m10662a(c1304b);
                        }
                    } else {
                        m10662a(c1304b);
                    }
                } else if (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN && abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                    C1314l c1314l3 = (C1314l) abstractC1333j.mo10563d();
                    m10662a(abstractC1333j.mo10564e());
                    if (c1314l3.f8546a >= 0) {
                        b bVar2 = new b(c1314l3);
                        bVar2.f8719c = (a) this.f8709f.get(c1314l3);
                        bVar2.f8717a = new BitSet();
                        this.f8708e.add(bVar2);
                        this.f8704a[c1314l3.f8546a] = bVar2;
                    }
                } else {
                    EnumC1302a enumC1302a = abstractC1333j.f8645i;
                    if (enumC1302a != EnumC1302a.E0) {
                        if (enumC1302a == EnumC1302a.E1) {
                            m10662a(abstractC1333j.mo10561c());
                        } else if (enumC1302a == EnumC1302a.E2) {
                            m10662a(abstractC1333j.mo10563d());
                            m10662a(abstractC1333j.mo10564e());
                        } else if (enumC1302a == EnumC1302a.En) {
                            throw new RuntimeException();
                        }
                    }
                }
                return this.f8704a;
            }

            /* renamed from: a */
            private void m10662a(AbstractC1322t abstractC1322t) {
                EnumC1302a enumC1302a = abstractC1322t.f8560e;
                if (enumC1302a == EnumC1302a.E0) {
                    if (abstractC1322t.f8563h == AbstractC1322t.e.LOCAL) {
                        C1314l c1314l = (C1314l) abstractC1322t;
                        if (c1314l.f8546a >= 0) {
                            b bVar = this.f8704a[c1314l.f8546a];
                            bVar.f8719c.f8716e.add(this.f8705b);
                            bVar.f8722f = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (enumC1302a == EnumC1302a.E1) {
                    m10662a(abstractC1322t.mo10544g());
                    return;
                }
                if (enumC1302a == EnumC1302a.E2) {
                    m10662a(abstractC1322t.mo10545h());
                    m10662a(abstractC1322t.mo10546i());
                } else if (enumC1302a == EnumC1302a.En) {
                    for (AbstractC1322t abstractC1322t2 : abstractC1322t.mo10547j()) {
                        m10662a(abstractC1322t2);
                    }
                }
            }
        });
        for (b bVar : m10660a(arrayList)) {
            if (bVar.f8719c.f8716e.size() > 1) {
                map.remove(bVar.f8718b);
            } else if (bVar.f8720d != null && bVar.f8721e != null) {
                BitSet bitSet = bVar.f8720d.f8717a;
                Iterator<b> it2 = bVar.f8721e.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!bitSet.equals(it2.next().f8717a)) {
                            map.remove(bVar.f8718b);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        Iterator<Map.Entry<C1314l, a>> it3 = map.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry<C1314l, a> next = it3.next();
            C1314l key = next.getKey();
            a value = next.getValue();
            Iterator<AbstractC1333j> it4 = value.f8716e.iterator();
            while (it4.hasNext()) {
                BitSet bitSet2 = ((b[]) it4.next().f8644h)[key.f8546a].f8717a;
                if (bitSet2.nextClearBit(0) < value.f8712a || bitSet2.nextSetBit(value.f8712a) >= 0) {
                    it3.remove();
                    break;
                }
            }
        }
        Iterator<AbstractC1333j> it5 = c1323b.f8628g.iterator();
        while (it5.hasNext()) {
            it5.next().f8644h = (Object) null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    protected Set<b> m10660a(Collection<b> collection) {
        HashSet hashSet = new HashSet(collection.size() / 2);
        C1360p c1360p = new C1360p();
        c1360p.addAll(collection);
        collection.clear();
        while (!c1360p.isEmpty()) {
            b bVar = (b) c1360p.poll();
            if (bVar.f8722f && !hashSet.contains(bVar)) {
                hashSet.add(bVar);
                b bVar2 = bVar.f8720d;
                if (bVar2 != null && !bVar2.f8722f) {
                    bVar2.f8722f = true;
                    c1360p.add(bVar2);
                }
                if (bVar.f8721e != null) {
                    for (b bVar3 : bVar.f8721e) {
                        if (!bVar3.f8722f) {
                            bVar3.f8722f = true;
                            c1360p.add(bVar3);
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private void m10656a(Map<C1314l, a> map) {
        boolean z;
        BitSet bitSet = new BitSet();
        Iterator<Map.Entry<C1314l, a>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            Iterator<AbstractC1333j> it2 = value.f8715d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                AbstractC1333j next = it2.next();
                if (next.f8650n == AbstractC1333j.d.FILL_ARRAY_DATA) {
                    int length = Array.getLength(((C1307e) next.mo10564e()).f8534b);
                    int nextSetBit = bitSet.nextSetBit(0);
                    if (nextSetBit >= 0 && nextSetBit < length) {
                        z = true;
                        break;
                    }
                    bitSet.set(0, length);
                } else {
                    int intValue = ((Number) ((C1307e) ((C1304b) next.mo10563d()).mo10546i()).f8534b).intValue();
                    if (bitSet.get(intValue)) {
                        z = true;
                        break;
                    }
                    bitSet.set(intValue);
                }
            }
            if (z || bitSet.nextClearBit(0) < value.f8712a || bitSet.nextSetBit(value.f8712a) >= 0) {
                it.remove();
            }
            bitSet.clear();
        }
    }

    /* renamed from: c */
    private Map<C1314l, a> m10658c(C1323b c1323b) {
        HashMap hashMap = new HashMap();
        if (c1323b.f8624c.size() == 0) {
            return hashMap;
        }
        C1345b.m10653c(c1323b);
        C1345b.m10644a(c1323b, new C1345b.a(this, hashMap) { // from class: com.g.b.a.c.b.a.3

            /* renamed from: a */
            private final C1346a f8710a;

            /* renamed from: b */
            private final Map f8711b;

            {
                this.f8710a = this;
                this.f8711b = hashMap;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.a
            /* renamed from: a */
            public void mo10661a(AbstractC1333j abstractC1333j) {
                int intValue;
                if (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN) {
                    if (abstractC1333j.mo10564e().f8563h == AbstractC1322t.e.NEW_ARRAY && abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                        C1320r c1320r = (C1320r) abstractC1333j.mo10564e();
                        if (c1320r.mo10544g().f8563h == AbstractC1322t.e.CONSTANT && (intValue = ((Number) ((C1307e) c1320r.mo10544g()).f8534b).intValue()) >= 0) {
                            this.f8711b.put((C1314l) abstractC1333j.mo10563d(), new a(intValue, c1320r.f8557a, (C1324a) abstractC1333j));
                            return;
                        }
                        return;
                    }
                    if (abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.ARRAY) {
                        C1304b c1304b = (C1304b) abstractC1333j.mo10563d();
                        if (c1304b.mo10545h().f8563h == AbstractC1322t.e.LOCAL) {
                            C1314l c1314l = (C1314l) c1304b.mo10545h();
                            a aVar = (a) this.f8711b.get(c1314l);
                            if (aVar != null) {
                                if (c1304b.mo10546i().f8563h == AbstractC1322t.e.CONSTANT) {
                                    aVar.f8715d.add(abstractC1333j);
                                    return;
                                } else {
                                    this.f8711b.remove(c1314l);
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (abstractC1333j.f8650n == AbstractC1333j.d.FILL_ARRAY_DATA && abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                    a aVar2 = (a) this.f8711b.get((C1314l) abstractC1333j.mo10563d());
                    if (aVar2 != null) {
                        aVar2.f8715d.add(abstractC1333j);
                    }
                }
            }
        });
        if (hashMap.size() > 0) {
            HashSet hashSet = new HashSet();
            if (c1323b.f8631j != null) {
                for (C1329f c1329f : c1323b.f8631j) {
                    if (c1329f.f8638c != null) {
                        for (C1324a c1324a : c1329f.f8638c) {
                            hashSet.add((C1314l) c1324a.mo10563d());
                            AbstractC1322t[] mo10547j = c1324a.mo10564e().mo10547j();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < mo10547j.length) {
                                    hashSet.add((C1314l) mo10547j[i2]);
                                    i = i2 + 1;
                                }
                            }
                        }
                    }
                }
            }
            if (hashSet.size() > 0) {
                Iterator<E> it = hashSet.iterator();
                while (it.hasNext()) {
                    hashMap.remove((C1314l) it.next());
                }
            }
        }
        return hashMap;
    }

    /* compiled from: FillArrayTransformer.java */
    /* renamed from: com.g.b.a.c.b.a$b */
    static class b {

        /* renamed from: a */
        BitSet f8717a;

        /* renamed from: b */
        C1314l f8718b;

        /* renamed from: c */
        a f8719c;

        /* renamed from: d */
        b f8720d;

        /* renamed from: e */
        Set<b> f8721e;

        /* renamed from: f */
        boolean f8722f;

        public b(C1314l c1314l) {
            this.f8718b = c1314l;
        }
    }
}
