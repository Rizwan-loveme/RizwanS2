package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p154a.C1318p;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p156c.p157a.C1343c;
import com.p140g.p152b.p153a.p156c.p157a.C1344d;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Ir2JRegAssignTransformer.java */
/* renamed from: com.g.b.a.c.g */
/* loaded from: classes.dex */
public class C1351g {

    /* renamed from: a */
    private static final Comparator<a> f8725a = new Comparator<a>() { // from class: com.g.b.a.c.g.1
        @Override // java.util.Comparator
        public int compare(a aVar, a aVar2) {
            return m10677a(aVar, aVar2);
        }

        /* renamed from: a */
        public int m10677a(a aVar, a aVar2) {
            int size = aVar2.f8727b.size() - aVar.f8727b.size();
            if (size == 0) {
                return aVar2.f8726a.size() - aVar.f8726a.size();
            }
            return size;
        }
    };

    /* compiled from: Ir2JRegAssignTransformer.java */
    /* renamed from: com.g.b.a.c.g$a */
    public static class a {

        /* renamed from: a */
        public Set<a> f8726a = new HashSet(4);

        /* renamed from: b */
        public Set<a> f8727b = new HashSet(3);

        /* renamed from: c */
        int f8728c = -1;

        /* renamed from: d */
        public char f8729d;
    }

    /* renamed from: a */
    private a[] m10673a(C1323b c1323b, a[] aVarArr) {
        a[] aVarArr2;
        C1344d c1344d;
        if (c1323b.f8622a) {
            aVarArr2 = new a[c1323b.f8623b.length];
        } else {
            aVarArr2 = new a[c1323b.f8623b.length + 1];
        }
        HashSet hashSet = new HashSet();
        for (AbstractC1333j abstractC1333j : c1323b.f8628g) {
            if (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN || abstractC1333j.f8650n == AbstractC1333j.d.IDENTITY) {
                if (abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                    C1314l c1314l = (C1314l) abstractC1333j.mo10563d();
                    AbstractC1322t mo10564e = abstractC1333j.mo10564e();
                    int i = c1314l.f8546a;
                    a aVar = aVarArr[i];
                    C1345b.m10641a(abstractC1333j, hashSet);
                    Iterator<E> it = hashSet.iterator();
                    while (it.hasNext()) {
                        C1344d[] c1344dArr = (C1344d[]) ((AbstractC1333j) it.next()).f8644h;
                        if (c1344dArr != null) {
                            for (int i2 = 0; i2 < c1344dArr.length; i2++) {
                                if (i2 != i && (c1344d = c1344dArr[i2]) != null && c1344d.f8695a) {
                                    a aVar2 = aVarArr[i2];
                                    aVar.f8726a.add(aVar2);
                                    aVar2.f8726a.add(aVar);
                                }
                            }
                        }
                    }
                    hashSet.clear();
                    if (mo10564e.f8563h == AbstractC1322t.e.LOCAL) {
                        a aVar3 = aVarArr[((C1314l) mo10564e).f8546a];
                        aVar.f8727b.add(aVar3);
                        aVar3.f8727b.add(aVar);
                    }
                    if (mo10564e.f8563h == AbstractC1322t.e.THIS_REF) {
                        aVarArr2[0] = aVar;
                    } else if (mo10564e.f8563h == AbstractC1322t.e.PARAMETER_REF) {
                        C1318p c1318p = (C1318p) mo10564e;
                        if (c1323b.f8622a) {
                            aVarArr2[c1318p.f8552a] = aVar;
                        } else {
                            aVarArr2[c1318p.f8552a + 1] = aVar;
                        }
                    }
                }
            }
        }
        for (a aVar4 : aVarArr) {
            aVar4.f8726a.remove(aVar4);
            aVar4.f8727b.remove(aVar4);
        }
        return aVarArr2;
    }

    /* renamed from: a */
    Map<Character, List<a>> m10675a(a[] aVarArr) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aVarArr.length) {
                a aVar = aVarArr[i2];
                char c2 = aVar.f8729d;
                List list = (List) hashMap.get(new Character(c2));
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(new Character(c2), list);
                }
                list.add(aVar);
                Iterator<a> it = aVar.f8726a.iterator();
                while (it.hasNext()) {
                    if (it.next().f8729d != aVar.f8729d) {
                        it.remove();
                    }
                }
                Iterator<a> it2 = aVar.f8727b.iterator();
                while (it2.hasNext()) {
                    if (it2.next().f8729d != aVar.f8729d) {
                        it2.remove();
                    }
                }
                i = i2 + 1;
            } else {
                return hashMap;
            }
        }
    }

    /* renamed from: a */
    private void m10671a(BitSet bitSet, a aVar) {
        bitSet.clear();
        for (a aVar2 : aVar.f8726a) {
            if (aVar2.f8728c >= 0) {
                bitSet.set(aVar2.f8728c);
                if (aVar2.f8729d == 'J' || aVar2.f8729d == 'D') {
                    bitSet.set(aVar2.f8728c + 1);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10674b(BitSet bitSet, a aVar) {
        bitSet.clear();
        for (a aVar2 : aVar.f8727b) {
            if (aVar2.f8728c >= 0) {
                bitSet.set(aVar2.f8728c);
            }
        }
    }

    /* renamed from: a */
    public void m10676a(C1323b c1323b) {
        int i;
        int i2;
        int i3;
        if (c1323b.f8624c.size() != 0) {
            C1343c c1343c = new C1343c(c1323b, true);
            c1343c.m10626e();
            a[] aVarArr = new a[c1343c.m10636c()];
            for (C1314l c1314l : c1323b.f8624c) {
                a aVar = new a();
                char charAt = c1314l.f8561f.charAt(0);
                if (charAt == '[') {
                    charAt = 'L';
                }
                aVar.f8729d = charAt;
                c1314l.f8562g = aVar;
                aVarArr[c1314l.f8546a] = aVar;
            }
            a[] m10673a = m10673a(c1323b, aVarArr);
            if (!c1323b.f8622a) {
                a aVar2 = m10673a[0];
                for (a aVar3 : aVarArr) {
                    if (aVar3 != aVar2) {
                        aVar3.f8726a.add(aVar2);
                        aVar2.f8726a.add(aVar3);
                    }
                }
            }
            if (c1323b.f8622a) {
                i = 0;
                i2 = 0;
            } else {
                i2 = 1;
                i = 1;
                m10673a[0].f8728c = 0;
            }
            int i4 = 0;
            int i5 = i;
            int i6 = i2;
            while (i4 < c1323b.f8623b.length) {
                int i7 = i6 + 1;
                a aVar4 = m10673a[i6];
                String str = c1323b.f8623b[i4];
                if (aVar4 == null) {
                    i3 = i5 + 1;
                } else {
                    i3 = i5 + 1;
                    aVar4.f8728c = i5;
                }
                i4++;
                i5 = ("J".equals(str) || "D".equals(str)) ? i3 + 1 : i3;
                i6 = i7;
            }
            Map<Character, List<a>> m10675a = m10675a(aVarArr);
            BitSet bitSet = new BitSet();
            BitSet bitSet2 = new BitSet();
            BitSet bitSet3 = new BitSet();
            BitSet bitSet4 = new BitSet();
            for (Map.Entry<Character, List<a>> entry : m10675a.entrySet()) {
                List<a> value = entry.getValue();
                Collections.sort(value, f8725a);
                char charValue = entry.getKey().charValue();
                boolean z = charValue == 'J' || charValue == 'D';
                for (a aVar5 : value) {
                    if (aVar5.f8728c < 0) {
                        m10671a(bitSet, aVar5);
                        m10672a(bitSet, m10673a, charValue);
                        bitSet.mo13226or(bitSet3);
                        m10674b(bitSet2, aVar5);
                        int nextSetBit = bitSet2.nextSetBit(0);
                        while (true) {
                            if (nextSetBit < 0) {
                                break;
                            }
                            if (z) {
                                if (!bitSet.get(nextSetBit) && !bitSet.get(nextSetBit + 1)) {
                                    aVar5.f8728c = nextSetBit;
                                    break;
                                }
                                nextSetBit = bitSet2.nextSetBit(nextSetBit + 1);
                            } else if (bitSet.get(nextSetBit)) {
                                nextSetBit = bitSet2.nextSetBit(nextSetBit + 1);
                            } else {
                                aVar5.f8728c = nextSetBit;
                                break;
                            }
                        }
                        if (aVar5.f8728c < 0) {
                            if (z) {
                                int i8 = -1;
                                do {
                                    i8 = bitSet.nextClearBit(i8 + 1);
                                } while (bitSet.get(i8 + 1));
                                aVar5.f8728c = i8;
                            } else {
                                aVar5.f8728c = bitSet.nextClearBit(0);
                            }
                        }
                    }
                    bitSet4.set(aVar5.f8728c);
                    if (z) {
                        bitSet4.set(aVar5.f8728c + 1);
                    }
                }
                bitSet3.mo13226or(bitSet4);
                bitSet4.clear();
            }
            for (C1314l c1314l2 : c1323b.f8624c) {
                c1314l2.f8546a = ((a) c1314l2.f8562g).f8728c;
                c1314l2.f8562g = (Object) null;
            }
            Iterator<AbstractC1333j> it = c1323b.f8628g.iterator();
            while (it.hasNext()) {
                it.next().f8644h = (Object) null;
            }
        }
    }

    /* renamed from: a */
    private void m10672a(BitSet bitSet, a[] aVarArr, char c2) {
        for (a aVar : aVarArr) {
            if (aVar.f8729d != c2) {
                bitSet.set(aVar.f8728c);
                if (aVar.f8729d == 'J' || aVar.f8729d == 'D') {
                    bitSet.set(aVar.f8728c + 1);
                }
            }
        }
    }
}
