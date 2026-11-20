package com.p140g.p141a.p143b;

import com.p140g.p141a.C1238b;
import com.p140g.p141a.C1241c;
import com.p140g.p141a.C1249d;
import com.p140g.p141a.C1280e;
import com.p140g.p141a.p145d.C1274c;
import com.p140g.p141a.p145d.C1279h;
import com.p140g.p141a.p145d.p146a.AbstractC1252b;
import com.p140g.p141a.p145d.p146a.C1251a;
import com.p140g.p141a.p145d.p147b.AbstractC1255b;
import com.p140g.p141a.p145d.p147b.AbstractC1258e;
import com.p140g.p141a.p145d.p147b.C1256c;
import com.p140g.p141a.p145d.p147b.C1257d;
import com.p140g.p141a.p145d.p147b.C1259f;
import com.p140g.p141a.p145d.p147b.C1260g;
import com.p140g.p141a.p145d.p147b.C1261h;
import com.p140g.p141a.p145d.p147b.C1262i;
import com.p140g.p141a.p145d.p147b.C1263j;
import com.p140g.p141a.p145d.p147b.C1264k;
import com.p140g.p141a.p145d.p147b.C1265l;
import com.p140g.p141a.p145d.p147b.C1266m;
import com.p140g.p141a.p145d.p147b.C1267n;
import com.p140g.p141a.p145d.p147b.C1270q;
import com.p140g.p141a.p145d.p147b.C1273t;
import com.p140g.p141a.p148e.EnumC1286f;
import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1366g;
import com.p140g.p152b.p153a.EnumC1367h;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1311i;
import com.p140g.p152b.p153a.p154a.C1312j;
import com.p140g.p152b.p153a.p154a.C1313k;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1334k;
import com.p140g.p152b.p153a.p155b.C1335l;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/* compiled from: Dex2IRConverter.java */
/* renamed from: com.g.a.b.a */
/* loaded from: classes.dex */
public class C1239a {

    /* renamed from: b */
    List<AbstractC1258e> f8033b;

    /* renamed from: c */
    int[] f8034c;

    /* renamed from: d */
    C1323b f8035d;

    /* renamed from: e */
    C1274c f8036e;

    /* renamed from: g */
    List<AbstractC1333j> f8038g;

    /* renamed from: j */
    private a[] f8041j;

    /* renamed from: k */
    private ArrayList<AbstractC1333j>[] f8042k;

    /* renamed from: a */
    Map<C1238b, C1257d> f8032a = new HashMap();

    /* renamed from: f */
    List<AbstractC1333j> f8037f = new ArrayList();

    /* renamed from: h */
    Map<C1238b, C1329f> f8039h = new HashMap();

    /* renamed from: i */
    boolean f8040i = true;

    /* renamed from: a */
    static int m10230a(String str) {
        char charAt = str.charAt(0);
        return (charAt == 'J' || charAt == 'D') ? 2 : 1;
    }

    /* compiled from: Dex2IRConverter.java */
    /* renamed from: com.g.a.b.a$a */
    static class a extends C1251a<b> {
        public a(int i) {
            super(i);
        }
    }

    /* renamed from: a */
    static int m10231a(String[] strArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < strArr.length) {
                i = m10230a(strArr[i2]) + i3;
                i2++;
            } else {
                return i3;
            }
        }
    }

    /* renamed from: a */
    public C1323b m10247a(boolean z, C1280e c1280e, C1274c c1274c) {
        this.f8036e = c1274c;
        C1323b c1323b = new C1323b();
        c1323b.f8623b = c1280e.m10400e();
        c1323b.f8627f = c1280e.m10401f();
        c1323b.f8626e = c1280e.m10399d();
        c1323b.f8625d = c1280e.m10398c();
        c1323b.f8622a = z;
        this.f8035d = c1323b;
        this.f8033b = c1274c.f8147a;
        for (int i = 0; i < this.f8033b.size(); i++) {
            AbstractC1258e abstractC1258e = this.f8033b.get(i);
            abstractC1258e.f8115d = i;
            if (abstractC1258e instanceof C1257d) {
                C1257d c1257d = (C1257d) abstractC1258e;
                this.f8032a.put(c1257d.f8113a, c1257d);
            }
        }
        m10234a();
        BitSet[] bitSetArr = new BitSet[this.f8033b.size()];
        this.f8034c = new int[this.f8033b.size()];
        m10240a(this.f8034c);
        BitSet bitSet = new BitSet(this.f8033b.size());
        m10238a(c1274c, bitSetArr, bitSet);
        AbstractC1252b<b> m10244c = m10244c();
        this.f8041j = new a[this.f8033b.size()];
        this.f8042k = new ArrayList[this.f8033b.size()];
        BitSet bitSet2 = new BitSet(this.f8033b.size());
        m10241a(bitSetArr, bitSet, bitSet2, m10244c);
        C1334k c1334k = this.f8035d.f8628g;
        c1334k.m10577a(this.f8037f);
        for (int i2 = 0; i2 < this.f8033b.size(); i2++) {
            AbstractC1258e abstractC1258e2 = this.f8033b.get(i2);
            if (bitSet2.get(i2)) {
                ArrayList<AbstractC1333j> arrayList = this.f8042k[i2];
                if (arrayList != null) {
                    c1334k.m10577a(arrayList);
                }
            } else if (abstractC1258e2 instanceof C1257d) {
                c1334k.m10576a(m10246a(((C1257d) abstractC1258e2).f8113a));
            }
        }
        this.f8042k = (ArrayList[]) null;
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < this.f8041j.length; i3++) {
            a aVar = this.f8041j[i3];
            if (this.f8034c[i3] > 1 && aVar != null && bitSet2.get(i3)) {
                for (int i4 = 0; i4 < aVar.m10352b(); i4++) {
                    m10239a(linkedList, aVar.m10348a(i4));
                }
            }
        }
        while (!linkedList.isEmpty()) {
            b poll = linkedList.poll();
            m10245a(poll);
            if (poll.f8044a != null && poll.f8044a.f8046c == null) {
                linkedList.add(poll.f8044a);
            }
            if (poll.f8045b != null) {
                for (b bVar : poll.f8045b) {
                    if (bVar.f8046c == null) {
                        linkedList.add(bVar);
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < this.f8041j.length; i5++) {
            a aVar2 = this.f8041j[i5];
            if (this.f8034c[i5] > 1 && aVar2 != null && bitSet2.get(i5)) {
                C1329f m10246a = m10246a(((C1257d) this.f8033b.get(i5)).f8113a);
                ArrayList arrayList3 = new ArrayList();
                for (int i6 = 0; i6 < aVar2.m10352b(); i6++) {
                    m10237a(aVar2.m10348a(i6), hashSet, arrayList3);
                }
                m10246a.f8638c = arrayList3;
                arrayList2.add(m10246a);
            }
        }
        if (arrayList2.size() > 0) {
            this.f8035d.f8631j = arrayList2;
        }
        return this.f8035d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m10234a() {
        if (this.f8036e.f8148b == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        TreeSet treeSet = new TreeSet();
        Iterator<C1279h> it = this.f8036e.f8148b.iterator();
        while (it.hasNext()) {
            for (C1238b c1238b : it.next().f8177c) {
                int m10250b = m10250b(c1238b);
                linkedList.add(new Integer(m10250b + 1));
                treeSet.add(new Integer(m10250b));
            }
        }
        linkedList.add(new Integer(0));
        HashMap hashMap = new HashMap();
        BitSet bitSet = new BitSet(this.f8033b.size());
        while (!linkedList.isEmpty()) {
            Integer num = (Integer) linkedList.poll();
            int intValue = num.intValue();
            if (!bitSet.get(intValue)) {
                bitSet.set(intValue);
                if (treeSet.contains(num)) {
                    hashMap.put(num, (C1238b) null);
                }
                AbstractC1258e abstractC1258e = this.f8033b.get(num.intValue());
                if (abstractC1258e.f8114c == null) {
                    linkedList.add(new Integer(intValue + 1));
                } else {
                    EnumC1286f enumC1286f = abstractC1258e.f8114c;
                    if (enumC1286f.m10454b()) {
                        linkedList.add(new Integer(intValue + 1));
                    }
                    if (enumC1286f.m10453a()) {
                        linkedList.add(new Integer(m10250b(((C1262i) abstractC1258e).f8125e)));
                    }
                    if (enumC1286f.m10455c()) {
                        C1238b[] c1238bArr = ((AbstractC1255b) abstractC1258e).f8110b;
                        for (C1238b c1238b2 : c1238bArr) {
                            linkedList.add(new Integer(m10250b(c1238b2)));
                        }
                    }
                }
            }
        }
        if (hashMap.size() > 0) {
            Iterator<C1279h> it2 = this.f8036e.f8148b.iterator();
            while (it2.hasNext()) {
                C1238b[] c1238bArr2 = it2.next().f8177c;
                for (int i = 0; i < c1238bArr2.length; i++) {
                    C1238b c1238b3 = c1238bArr2[i];
                    int m10250b2 = m10250b(c1238b3);
                    if (hashMap.containsKey(new Integer(m10250b2))) {
                        C1238b c1238b4 = (C1238b) hashMap.get(new Integer(m10250b2));
                        if (c1238b4 == null) {
                            c1238b4 = new C1238b();
                            hashMap.put(new Integer(m10250b2), c1238b4);
                            C1257d c1257d = new C1257d(c1238b4);
                            c1257d.f8115d = this.f8033b.size();
                            this.f8033b.add(c1257d);
                            this.f8032a.put(c1238b4, c1257d);
                            C1262i c1262i = new C1262i(EnumC1286f.f8272O, 0, 0, c1238b3);
                            c1262i.f8115d = this.f8033b.size();
                            this.f8033b.add(c1262i);
                        }
                        c1238bArr2[i] = c1238b4;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m10238a(C1274c c1274c, BitSet[] bitSetArr, BitSet bitSet) {
        if (c1274c.f8148b != null) {
            for (C1279h c1279h : c1274c.f8148b) {
                this.f8035d.f8629h.add(new C1366g(m10246a(c1279h.f8175a), m10246a(c1279h.f8176b), m10242a(c1279h.f8177c), c1279h.f8178d));
                for (C1238b c1238b : c1279h.f8177c) {
                    bitSet.set(m10250b(c1238b));
                }
                int m10250b = m10250b(c1279h.f8176b);
                for (int m10250b2 = m10250b(c1279h.f8175a) + 1; m10250b2 < m10250b; m10250b2++) {
                    AbstractC1258e abstractC1258e = this.f8033b.get(m10250b2);
                    if (abstractC1258e.f8114c != null && abstractC1258e.f8114c.m10456d()) {
                        BitSet bitSet2 = bitSetArr[m10250b2];
                        if (bitSet2 == null) {
                            bitSet2 = new BitSet(this.f8033b.size());
                            bitSetArr[m10250b2] = bitSet2;
                        }
                        for (C1238b c1238b2 : c1279h.f8177c) {
                            int m10250b3 = m10250b(c1238b2);
                            bitSet2.set(m10250b3);
                            int[] iArr = this.f8034c;
                            iArr[m10250b3] = iArr[m10250b3] + 1;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m10237a(b bVar, Set<AbstractC1322t> set, List<C1324a> list) {
        if (bVar == null || bVar.f8046c == null) {
            return;
        }
        if (bVar.f8044a != null) {
            set.add(m10245a(bVar.f8044a));
        }
        if (bVar.f8045b != null) {
            Iterator<b> it = bVar.f8045b.iterator();
            while (it.hasNext()) {
                set.add(m10245a(it.next()));
            }
        }
        if (set.size() > 0) {
            list.add(C1335l.m10586a(bVar.f8046c, C1308f.m10498a((AbstractC1322t[]) set.toArray(new AbstractC1322t[set.size()]))));
            set.clear();
        }
    }

    /* renamed from: a */
    C1314l m10245a(b bVar) {
        C1314l c1314l = bVar.f8046c;
        if (c1314l == null) {
            C1314l m10243b = m10243b();
            bVar.f8046c = m10243b;
            return m10243b;
        }
        return c1314l;
    }

    /* renamed from: a */
    private void m10239a(Queue<b> queue, b bVar) {
        if (bVar == null || bVar.f8046c == null) {
            return;
        }
        if (bVar.f8044a != null && bVar.f8044a.f8046c == null) {
            queue.add(bVar.f8044a);
        }
        if (bVar.f8045b != null) {
            for (b bVar2 : bVar.f8045b) {
                if (bVar2.f8046c == null) {
                    queue.add(bVar2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m10235a(int i) {
        this.f8038g = this.f8042k[i];
        if (this.f8038g == null) {
            ArrayList<AbstractC1333j>[] arrayListArr = this.f8042k;
            ArrayList<AbstractC1333j> arrayList = new ArrayList<>(1);
            arrayListArr[i] = arrayList;
            this.f8038g = arrayList;
        }
    }

    /* renamed from: a */
    private void m10241a(BitSet[] bitSetArr, BitSet bitSet, BitSet bitSet2, AbstractC1252b<b> abstractC1252b) {
        this.f8038g = this.f8037f;
        a m10232a = m10232a(this.f8036e, this.f8035d);
        if (this.f8034c[0] > 1) {
            m10248a(m10232a, 0);
        } else {
            this.f8041j[0] = m10232a;
        }
        Stack stack = new Stack();
        stack.push(this.f8033b.get(0));
        a aVar = new a(this.f8036e.f8150d);
        while (!stack.isEmpty()) {
            AbstractC1258e abstractC1258e = (AbstractC1258e) stack.pop();
            int i = abstractC1258e.f8115d;
            if (!bitSet2.get(i)) {
                bitSet2.set(i);
                a aVar2 = this.f8041j[i];
                m10235a(i);
                if (abstractC1258e instanceof C1257d) {
                    m10249a(m10246a(((C1257d) abstractC1258e).f8113a));
                    if (bitSet.get(i)) {
                        C1314l m10243b = m10243b();
                        m10249a(C1335l.m10596c(m10243b, C1308f.m10509b("Ljava/lang/Throwable;")));
                        aVar2.m10351a((a) new b(m10243b));
                    }
                }
                if (bitSetArr[i] != null) {
                    for (int nextSetBit = r9.nextSetBit(0); nextSetBit >= 0; nextSetBit = r9.nextSetBit(nextSetBit + 1)) {
                        m10248a(aVar2, nextSetBit);
                        stack.push(this.f8033b.get(nextSetBit));
                    }
                }
                aVar.m10346a((C1251a) aVar2);
                try {
                    if (abstractC1258e.f8114c != null) {
                        EnumC1286f enumC1286f = abstractC1258e.f8114c;
                        if (enumC1286f == EnumC1286f.f8471o) {
                            m10249a(C1335l.m10597c());
                        } else if (enumC1286f == EnumC1286f.f8272O || enumC1286f == EnumC1286f.f8273P || enumC1286f == EnumC1286f.f8274Q) {
                            m10249a(C1335l.m10587a(m10246a(((C1262i) abstractC1258e).f8125e)));
                        } else if (enumC1286f == EnumC1286f.f8284a) {
                            m10249a(C1335l.m10594b());
                        } else if (enumC1286f == EnumC1286f.f8458do) {
                            m10249a(C1335l.m10598c(C1308f.m10495a(new AbstractC1322t[]{C1308f.m10490a("bad dex opcode")}, new String[]{"Ljava/lang/String;"}, "Ljava/lang/VerifyError;")));
                        } else {
                            aVar.m10350a(abstractC1258e, abstractC1252b);
                        }
                    }
                    if (abstractC1258e.f8114c != null) {
                        EnumC1286f enumC1286f2 = abstractC1258e.f8114c;
                        if (enumC1286f2.m10453a()) {
                            int m10250b = m10250b(((C1262i) abstractC1258e).f8125e);
                            stack.push(this.f8033b.get(m10250b));
                            m10248a(aVar, m10250b);
                        }
                        if (enumC1286f2.m10455c()) {
                            for (C1238b c1238b : ((AbstractC1255b) abstractC1258e).f8110b) {
                                int m10250b2 = m10250b(c1238b);
                                stack.push(this.f8033b.get(m10250b2));
                                m10248a(aVar, m10250b2);
                            }
                        }
                        if (enumC1286f2.m10454b()) {
                            stack.push(this.f8033b.get(i + 1));
                            m10248a(aVar, i + 1);
                        }
                    } else {
                        stack.push(this.f8033b.get(i + 1));
                        m10248a(aVar, i + 1);
                    }
                    if (this.f8034c[i] <= 1) {
                        this.f8041j[i] = (a) null;
                    }
                } catch (Exception e2) {
                    throw new RuntimeException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Fail on Op ").append(abstractC1258e.f8114c).toString()).append(" index ").toString()).append(i).toString(), e2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m10236a(b bVar, b bVar2) {
        if (bVar2.f8044a == null) {
            bVar2.f8044a = bVar;
        } else if (bVar2.f8044a != bVar) {
            if (bVar2.f8045b == null) {
                bVar2.f8045b = new HashSet(5);
            }
            bVar2.f8045b.add(bVar);
        }
    }

    /* renamed from: a */
    void m10248a(a aVar, int i) {
        a aVar2;
        a aVar3 = this.f8041j[i];
        if (aVar3 == null) {
            a[] aVarArr = this.f8041j;
            a aVar4 = new a(this.f8036e.f8150d);
            aVarArr[i] = aVar4;
            aVar2 = aVar4;
        } else {
            aVar2 = aVar3;
        }
        if (this.f8034c[i] > 1) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < aVar.m10352b()) {
                    b a2 = aVar.m10348a(i3);
                    b a3 = aVar2.m10348a(i3);
                    if (a2 != null) {
                        if (a3 == null) {
                            a3 = new b();
                            aVar2.m10349a(i3, (int) a3);
                        }
                        m10236a(a2, a3);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } else {
            aVar2.m10346a((C1251a) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public C1314l m10243b() {
        C1314l m10508b = C1308f.m10508b(this.f8035d.f8624c.size());
        this.f8035d.f8624c.add(m10508b);
        return m10508b;
    }

    /* renamed from: a */
    void m10249a(AbstractC1333j abstractC1333j) {
        this.f8038g.add(abstractC1333j);
    }

    /* renamed from: a */
    private a m10232a(C1274c c1274c, C1323b c1323b) {
        a aVar = new a(c1274c.f8150d);
        int m10231a = c1274c.f8150d - m10231a(c1323b.f8623b);
        if (!c1323b.f8622a) {
            C1314l m10243b = m10243b();
            m10249a(C1335l.m10596c(m10243b, C1308f.m10519d(c1323b.f8626e)));
            aVar.m10349a(m10231a - 1, (int) new b(m10243b));
        }
        for (int i = 0; i < c1323b.f8623b.length; i++) {
            C1314l m10243b2 = m10243b();
            m10249a(C1335l.m10596c(m10243b2, C1308f.m10499a(c1323b.f8623b[i], i)));
            aVar.m10349a(m10231a, (int) new b(m10243b2));
            m10231a += m10230a(c1323b.f8623b[i]);
        }
        if (this.f8040i) {
            for (int i2 = 0; i2 < aVar.m10352b(); i2++) {
                if (aVar.m10348a(i2) == null) {
                    C1314l m10243b3 = m10243b();
                    m10249a(C1335l.m10586a(m10243b3, C1308f.m10486a(0)));
                    aVar.m10349a(i2, (int) new b(m10243b3));
                }
            }
        }
        return aVar;
    }

    /* renamed from: c */
    private AbstractC1252b<b> m10244c() {
        return new AbstractC1252b<b>(this) { // from class: com.g.a.b.a.1

            /* renamed from: a */
            private final C1239a f8043a;

            {
                this.f8043a = this;
            }

            @Override // com.p140g.p141a.p145d.p146a.AbstractC1252b
            /* renamed from: a */
            public /* bridge */ b mo10254a(AbstractC1258e abstractC1258e, b bVar) {
                return a2(abstractC1258e, bVar);
            }

            @Override // com.p140g.p141a.p145d.p146a.AbstractC1252b
            /* renamed from: a */
            public /* bridge */ b mo10255a(AbstractC1258e abstractC1258e, b bVar, b bVar2) {
                return a2(abstractC1258e, bVar, bVar2);
            }

            @Override // com.p140g.p141a.p145d.p146a.AbstractC1252b
            /* renamed from: a */
            public /* bridge */ b mo10256a(AbstractC1258e abstractC1258e, b bVar, b bVar2, b bVar3) {
                return a2(abstractC1258e, bVar, bVar2, bVar3);
            }

            @Override // com.p140g.p141a.p145d.p146a.AbstractC1252b
            /* renamed from: b */
            public b mo10257b(AbstractC1258e abstractC1258e) {
                return m10251a(abstractC1258e);
            }

            @Override // com.p140g.p141a.p145d.p146a.AbstractC1252b
            /* renamed from: b */
            public /* bridge */ b mo10258b(AbstractC1258e abstractC1258e, b bVar) {
                return b2(abstractC1258e, bVar);
            }

            @Override // com.p140g.p141a.p145d.p146a.AbstractC1252b
            /* renamed from: b */
            public b mo10259b(AbstractC1258e abstractC1258e, List<? extends b> list) {
                return m10252a(abstractC1258e, list);
            }

            @Override // com.p140g.p141a.p145d.p146a.AbstractC1252b
            /* renamed from: c */
            public /* bridge */ void mo10261c(AbstractC1258e abstractC1258e, b bVar) {
                c2(abstractC1258e, bVar);
            }

            /* renamed from: a */
            b m10253a(AbstractC1322t abstractC1322t) {
                C1314l m10243b = this.f8043a.m10243b();
                this.f8043a.m10249a(C1335l.m10586a(m10243b, abstractC1322t));
                return new b(m10243b);
            }

            /* renamed from: a */
            public b m10251a(AbstractC1258e abstractC1258e) {
                EnumC1286f enumC1286f = abstractC1258e.f8114c;
                if (enumC1286f != EnumC1286f.f8477u && enumC1286f != EnumC1286f.f8476t && enumC1286f != EnumC1286f.f8475s && enumC1286f != EnumC1286f.f8478v) {
                    if (enumC1286f != EnumC1286f.f8481y && enumC1286f != EnumC1286f.f8479w && enumC1286f != EnumC1286f.f8480x && enumC1286f != EnumC1286f.f8482z) {
                        if (enumC1286f == EnumC1286f.f8260C) {
                            return m10253a(C1308f.m10488a((C1241c) ((C1256c) abstractC1258e).f8112b));
                        }
                        if (enumC1286f != EnumC1286f.f8258A && enumC1286f != EnumC1286f.f8259B) {
                            if (enumC1286f == EnumC1286f.f8297aM || enumC1286f == EnumC1286f.f8300aP || enumC1286f == EnumC1286f.f8301aQ || enumC1286f == EnumC1286f.f8302aR || enumC1286f == EnumC1286f.f8299aO || enumC1286f == EnumC1286f.f8303aS || enumC1286f == EnumC1286f.f8298aN) {
                                C1249d c1249d = ((C1259f) abstractC1258e).f8118e;
                                return m10253a(C1308f.m10500a(c1249d.m10337b(), c1249d.m10336a(), c1249d.m10338c()));
                            }
                            if (enumC1286f == EnumC1286f.f8266I) {
                                return m10253a(C1308f.m10514c(((C1273t) abstractC1258e).f8146e));
                            }
                            return (b) null;
                        }
                        return m10253a(C1308f.m10490a((String) ((C1256c) abstractC1258e).f8112b));
                    }
                    return m10253a(C1308f.m10487a(((Long) ((C1256c) abstractC1258e).f8112b).longValue()));
                }
                return m10253a(C1308f.m10486a(((Integer) ((C1256c) abstractC1258e).f8112b).intValue()));
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public b a2(AbstractC1258e abstractC1258e, b bVar) {
                if (bVar != null) {
                    return m10253a(this.f8043a.m10245a(bVar));
                }
                m10260c(abstractC1258e);
                return m10253a(C1308f.m10486a(0));
            }

            /* renamed from: b, reason: avoid collision after fix types in other method */
            public b b2(AbstractC1258e abstractC1258e, b bVar) {
                if (bVar == null) {
                    m10260c(abstractC1258e);
                    return m10253a(C1308f.m10486a(0));
                }
                C1314l m10245a = this.f8043a.m10245a(bVar);
                EnumC1286f enumC1286f = abstractC1258e.f8114c;
                if (enumC1286f == EnumC1286f.f8375bl) {
                    return m10253a(C1308f.m10520d(m10245a, "I"));
                }
                if (enumC1286f == EnumC1286f.f8377bn) {
                    return m10253a(C1308f.m10520d(m10245a, "J"));
                }
                if (enumC1286f == EnumC1286f.f8379bp) {
                    return m10253a(C1308f.m10515c(m10245a, "D"));
                }
                if (enumC1286f == EnumC1286f.f8378bo) {
                    return m10253a(C1308f.m10515c(m10245a, "F"));
                }
                if (enumC1286f == EnumC1286f.f8374bk) {
                    return m10253a(C1308f.m10515c(m10245a, "I"));
                }
                if (enumC1286f == EnumC1286f.f8376bm) {
                    return m10253a(C1308f.m10515c(m10245a, "J"));
                }
                if (enumC1286f == EnumC1286f.f8340bC) {
                    return m10253a(C1308f.m10485a(m10245a, "I", "B"));
                }
                if (enumC1286f == EnumC1286f.f8341bD) {
                    return m10253a(C1308f.m10485a(m10245a, "I", "C"));
                }
                if (enumC1286f == EnumC1286f.f8382bs) {
                    return m10253a(C1308f.m10485a(m10245a, "I", "D"));
                }
                if (enumC1286f == EnumC1286f.f8381br) {
                    return m10253a(C1308f.m10485a(m10245a, "I", "F"));
                }
                if (enumC1286f == EnumC1286f.f8380bq) {
                    return m10253a(C1308f.m10485a(m10245a, "I", "J"));
                }
                if (enumC1286f == EnumC1286f.f8342bE) {
                    return m10253a(C1308f.m10485a(m10245a, "I", "S"));
                }
                if (enumC1286f == EnumC1286f.f8388by) {
                    return m10253a(C1308f.m10485a(m10245a, "F", "D"));
                }
                if (enumC1286f == EnumC1286f.f8386bw) {
                    return m10253a(C1308f.m10485a(m10245a, "F", "I"));
                }
                if (enumC1286f == EnumC1286f.f8387bx) {
                    return m10253a(C1308f.m10485a(m10245a, "F", "J"));
                }
                if (enumC1286f == EnumC1286f.f8339bB) {
                    return m10253a(C1308f.m10485a(m10245a, "D", "F"));
                }
                if (enumC1286f == EnumC1286f.f8389bz) {
                    return m10253a(C1308f.m10485a(m10245a, "D", "I"));
                }
                if (enumC1286f == EnumC1286f.f8338bA) {
                    return m10253a(C1308f.m10485a(m10245a, "D", "J"));
                }
                if (enumC1286f == EnumC1286f.f8385bv) {
                    return m10253a(C1308f.m10485a(m10245a, "J", "D"));
                }
                if (enumC1286f == EnumC1286f.f8384bu) {
                    return m10253a(C1308f.m10485a(m10245a, "J", "F"));
                }
                if (enumC1286f == EnumC1286f.f8383bt) {
                    return m10253a(C1308f.m10485a(m10245a, "J", "I"));
                }
                if (enumC1286f == EnumC1286f.f8265H) {
                    return m10253a(C1308f.m10503a((AbstractC1322t) m10245a));
                }
                if (enumC1286f == EnumC1286f.f8315ae) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10522e(m10245a, C1308f.m10486a(0), EnumC1367h.ZIL.f8821o), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8318ah) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10523f(m10245a, C1308f.m10486a(0), "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8319ai) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10524g(m10245a, C1308f.m10486a(0), "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8320aj) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10525h(m10245a, C1308f.m10486a(0), "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8317ag) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10526i(m10245a, C1308f.m10486a(0), "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8316af) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10528k(m10245a, C1308f.m10486a(0), EnumC1367h.ZIL.f8821o), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8275R || enumC1286f == EnumC1286f.f8276S) {
                    C1238b[] c1238bArr = ((AbstractC1255b) abstractC1258e).f8110b;
                    C1329f[] c1329fArr = new C1329f[c1238bArr.length];
                    for (int i = 0; i < c1238bArr.length; i++) {
                        c1329fArr[i] = this.f8043a.m10246a(c1238bArr[i]);
                    }
                    C1329f c1329f = new C1329f();
                    if (abstractC1258e.f8114c == EnumC1286f.f8275R) {
                        this.f8043a.m10249a(C1335l.m10591a(m10245a, ((C1266m) abstractC1258e).f8133e, c1329fArr, c1329f));
                    } else {
                        this.f8043a.m10249a(C1335l.m10590a(m10245a, ((C1267n) abstractC1258e).f8134e, c1329fArr, c1329f));
                    }
                    this.f8043a.m10249a(c1329f);
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8304aT || enumC1286f == EnumC1286f.f8307aW || enumC1286f == EnumC1286f.f8308aX || enumC1286f == EnumC1286f.f8309aY || enumC1286f == EnumC1286f.f8306aV || enumC1286f == EnumC1286f.f8310aZ || enumC1286f == EnumC1286f.f8305aU) {
                    C1249d c1249d = ((C1259f) abstractC1258e).f8118e;
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10500a(c1249d.m10337b(), c1249d.m10336a(), c1249d.m10338c()), m10245a));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8335ay || enumC1286f == EnumC1286f.f8286aB || enumC1286f == EnumC1286f.f8287aC || enumC1286f == EnumC1286f.f8288aD || enumC1286f == EnumC1286f.f8285aA || enumC1286f == EnumC1286f.f8289aE || enumC1286f == EnumC1286f.f8336az) {
                    C1249d c1249d2 = ((C1259f) abstractC1258e).f8118e;
                    return m10253a(C1308f.m10491a(m10245a, c1249d2.m10337b(), c1249d2.m10336a(), c1249d2.m10338c()));
                }
                if (enumC1286f == EnumC1286f.f8264G) {
                    return m10253a(C1308f.m10510b(m10245a, ((C1273t) abstractC1258e).f8146e));
                }
                if (enumC1286f == EnumC1286f.f8267J) {
                    return m10253a(C1308f.m10502a(((C1273t) abstractC1258e).f8146e.substring(1), m10245a));
                }
                if (enumC1286f == EnumC1286f.f8263F) {
                    return m10253a(C1308f.m10501a(m10245a, ((C1273t) abstractC1258e).f8146e));
                }
                if (enumC1286f == EnumC1286f.f8261D) {
                    this.f8043a.m10249a(C1335l.m10592a(m10245a));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8262E) {
                    this.f8043a.m10249a(C1335l.m10599d(m10245a));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8271N) {
                    this.f8043a.m10249a(C1335l.m10598c(m10245a));
                    return (b) null;
                }
                if (enumC1286f != EnumC1286f.f8408cR && enumC1286f != EnumC1286f.f8416cZ) {
                    if (enumC1286f != EnumC1286f.f8444da && enumC1286f != EnumC1286f.f8409cS) {
                        if (enumC1286f != EnumC1286f.f8445db && enumC1286f != EnumC1286f.f8410cT) {
                            if (enumC1286f != EnumC1286f.f8411cU && enumC1286f != EnumC1286f.f8446dc) {
                                if (enumC1286f != EnumC1286f.f8412cV && enumC1286f != EnumC1286f.f8447dd) {
                                    if (enumC1286f == EnumC1286f.f8413cW || enumC1286f == EnumC1286f.f8448de) {
                                        return m10253a(C1308f.m10505b(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), (((C1270q) abstractC1258e).f8138e < 0 || ((C1270q) abstractC1258e).f8138e > 1) ? "I" : EnumC1367h.ZI.f8821o));
                                    }
                                    if (enumC1286f == EnumC1286f.f8414cX || enumC1286f == EnumC1286f.f8449df) {
                                        return m10253a(C1308f.m10529l(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), (((C1270q) abstractC1258e).f8138e < 0 || ((C1270q) abstractC1258e).f8138e > 1) ? "I" : EnumC1367h.ZI.f8821o));
                                    }
                                    if (enumC1286f == EnumC1286f.f8415cY || enumC1286f == EnumC1286f.f8450dg) {
                                        return m10253a(C1308f.m10535r(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), (((C1270q) abstractC1258e).f8138e < 0 || ((C1270q) abstractC1258e).f8138e > 1) ? "I" : EnumC1367h.ZI.f8821o));
                                    }
                                    if (enumC1286f == EnumC1286f.f8451dh) {
                                        return m10253a(C1308f.m10531n(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), "I"));
                                    }
                                    if (enumC1286f == EnumC1286f.f8452di) {
                                        return m10253a(C1308f.m10532o(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), "I"));
                                    }
                                    if (enumC1286f == EnumC1286f.f8453dj) {
                                        return m10253a(C1308f.m10534q(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), "I"));
                                    }
                                    if (enumC1286f == EnumC1286f.f8270M) {
                                        this.f8043a.m10249a(C1335l.m10593b(m10245a, C1308f.m10489a(((C1260g) abstractC1258e).f8120b)));
                                        return (b) null;
                                    }
                                    throw new RuntimeException();
                                }
                                return m10253a(C1308f.m10530m(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), "I"));
                            }
                            return m10253a(C1308f.m10517d(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), "I"));
                        }
                        return m10253a(C1308f.m10527j(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), "I"));
                    }
                    return m10253a(C1308f.m10533p(C1308f.m10486a(((C1270q) abstractC1258e).f8138e), m10245a, "I"));
                }
                return m10253a(C1308f.m10484a(m10245a, C1308f.m10486a(((C1270q) abstractC1258e).f8138e), "I"));
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public b a2(AbstractC1258e abstractC1258e, b bVar, b bVar2) {
                if (bVar == null || bVar2 == null) {
                    m10260c(abstractC1258e);
                    return m10253a(C1308f.m10486a(0));
                }
                C1314l m10245a = this.f8043a.m10245a(bVar);
                C1314l m10245a2 = this.f8043a.m10245a(bVar2);
                EnumC1286f enumC1286f = abstractC1258e.f8114c;
                if (enumC1286f == EnumC1286f.f8321ak) {
                    return m10253a(C1308f.m10511c(m10245a, m10245a2, EnumC1367h.IF.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8324an) {
                    return m10253a(C1308f.m10511c(m10245a, m10245a2, "Z"));
                }
                if (enumC1286f == EnumC1286f.f8325ao) {
                    return m10253a(C1308f.m10511c(m10245a, m10245a2, "B"));
                }
                if (enumC1286f == EnumC1286f.f8326ap) {
                    return m10253a(C1308f.m10511c(m10245a, m10245a2, "C"));
                }
                if (enumC1286f == EnumC1286f.f8323am) {
                    return m10253a(C1308f.m10511c(m10245a, m10245a2, "L"));
                }
                if (enumC1286f == EnumC1286f.f8327aq) {
                    return m10253a(C1308f.m10511c(m10245a, m10245a2, "S"));
                }
                if (enumC1286f == EnumC1286f.f8322al) {
                    return m10253a(C1308f.m10511c(m10245a, m10245a2, EnumC1367h.JD.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8281X) {
                    return m10253a(C1308f.m10521e(m10245a, m10245a2));
                }
                if (enumC1286f == EnumC1286f.f8280W) {
                    return m10253a(C1308f.m10483a(m10245a, m10245a2));
                }
                if (enumC1286f == EnumC1286f.f8278U) {
                    return m10253a(C1308f.m10512c(m10245a, m10245a2));
                }
                if (enumC1286f == EnumC1286f.f8279V) {
                    return m10253a(C1308f.m10504b(m10245a, m10245a2));
                }
                if (enumC1286f == EnumC1286f.f8277T) {
                    return m10253a(C1308f.m10516d(m10245a, m10245a2));
                }
                if (enumC1286f == EnumC1286f.f8423cg) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8418cb) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8343bF) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8354bQ) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8424ch) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8419cc) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8344bG) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8355bR) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8425ci) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8420cd) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8345bH) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8356bS) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8426cj) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8421ce) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8346bI) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8357bT) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8427ck) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8422cf) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8347bJ) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8358bU) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8348bK) {
                    return m10253a(C1308f.m10505b(m10245a, m10245a2, EnumC1367h.ZI.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8359bV) {
                    return m10253a(C1308f.m10505b(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8349bL) {
                    return m10253a(C1308f.m10529l(m10245a, m10245a2, EnumC1367h.ZI.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8360bW) {
                    return m10253a(C1308f.m10529l(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8350bM) {
                    return m10253a(C1308f.m10535r(m10245a, m10245a2, EnumC1367h.ZI.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8361bX) {
                    return m10253a(C1308f.m10535r(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8351bN) {
                    return m10253a(C1308f.m10531n(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8362bY) {
                    return m10253a(C1308f.m10531n(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8352bO) {
                    return m10253a(C1308f.m10532o(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8363bZ) {
                    return m10253a(C1308f.m10532o(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8353bP) {
                    return m10253a(C1308f.m10534q(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8417ca) {
                    return m10253a(C1308f.m10534q(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8282Y) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10522e(m10245a, m10245a2, EnumC1367h.ZIL.f8821o), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8312ab) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10523f(m10245a, m10245a2, "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8313ac) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10524g(m10245a, m10245a2, "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8314ad) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10525h(m10245a, m10245a2, "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8311aa) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10526i(m10245a, m10245a2, "I"), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8283Z) {
                    this.f8043a.m10249a(C1335l.m10588a(C1308f.m10528k(m10245a, m10245a2, EnumC1367h.ZIL.f8821o), this.f8043a.m10246a(((C1262i) abstractC1258e).f8125e)));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8290aF || enumC1286f == EnumC1286f.f8293aI || enumC1286f == EnumC1286f.f8294aJ || enumC1286f == EnumC1286f.f8295aK || enumC1286f == EnumC1286f.f8292aH || enumC1286f == EnumC1286f.f8296aL || enumC1286f == EnumC1286f.f8291aG) {
                    C1249d c1249d = ((C1259f) abstractC1258e).f8118e;
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10491a(m10245a, c1249d.m10337b(), c1249d.m10336a(), c1249d.m10338c()), m10245a2));
                    return (b) null;
                }
                if (enumC1286f == EnumC1286f.f8403cM) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8398cH) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8428cl) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8439cw) {
                    return m10253a(C1308f.m10484a(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8404cN) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8399cI) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8429cm) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8440cx) {
                    return m10253a(C1308f.m10533p(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8405cO) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8400cJ) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8430cn) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8441cy) {
                    return m10253a(C1308f.m10527j(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8406cP) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8401cK) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8431co) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8442cz) {
                    return m10253a(C1308f.m10517d(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8407cQ) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "D"));
                }
                if (enumC1286f == EnumC1286f.f8402cL) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "F"));
                }
                if (enumC1286f == EnumC1286f.f8432cp) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8391cA) {
                    return m10253a(C1308f.m10530m(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8433cq) {
                    return m10253a(C1308f.m10505b(m10245a, m10245a2, EnumC1367h.ZI.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8392cB) {
                    return m10253a(C1308f.m10505b(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8434cr) {
                    return m10253a(C1308f.m10529l(m10245a, m10245a2, EnumC1367h.ZI.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8393cC) {
                    return m10253a(C1308f.m10529l(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8435cs) {
                    return m10253a(C1308f.m10535r(m10245a, m10245a2, EnumC1367h.ZI.f8821o));
                }
                if (enumC1286f == EnumC1286f.f8394cD) {
                    return m10253a(C1308f.m10535r(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8436ct) {
                    return m10253a(C1308f.m10531n(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8395cE) {
                    return m10253a(C1308f.m10531n(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8437cu) {
                    return m10253a(C1308f.m10532o(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8396cF) {
                    return m10253a(C1308f.m10532o(m10245a, m10245a2, "J"));
                }
                if (enumC1286f == EnumC1286f.f8438cv) {
                    return m10253a(C1308f.m10534q(m10245a, m10245a2, "I"));
                }
                if (enumC1286f == EnumC1286f.f8397cG) {
                    return m10253a(C1308f.m10534q(m10245a, m10245a2, "J"));
                }
                throw new RuntimeException();
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public b a2(AbstractC1258e abstractC1258e, b bVar, b bVar2, b bVar3) {
                if (bVar == null || bVar2 == null || bVar3 == null) {
                    m10260c(abstractC1258e);
                    return m10253a(C1308f.m10486a(0));
                }
                C1314l m10245a = this.f8043a.m10245a(bVar);
                C1314l m10245a2 = this.f8043a.m10245a(bVar2);
                C1314l m10245a3 = this.f8043a.m10245a(bVar3);
                EnumC1286f enumC1286f = abstractC1258e.f8114c;
                if (enumC1286f == EnumC1286f.f8328ar) {
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(m10245a, m10245a2, EnumC1367h.IF.f8821o), m10245a3));
                } else if (enumC1286f == EnumC1286f.f8331au) {
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(m10245a, m10245a2, "Z"), m10245a3));
                } else if (enumC1286f == EnumC1286f.f8332av) {
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(m10245a, m10245a2, "B"), m10245a3));
                } else if (enumC1286f == EnumC1286f.f8333aw) {
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(m10245a, m10245a2, "C"), m10245a3));
                } else if (enumC1286f == EnumC1286f.f8330at) {
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(m10245a, m10245a2, "L"), m10245a3));
                } else if (enumC1286f == EnumC1286f.f8334ax) {
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(m10245a, m10245a2, "S"), m10245a3));
                } else if (enumC1286f == EnumC1286f.f8329as) {
                    this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(m10245a, m10245a2, EnumC1367h.JD.f8821o), m10245a3));
                }
                return (b) null;
            }

            /* renamed from: a */
            public b m10252a(AbstractC1258e abstractC1258e, List<? extends b> list) {
                C1312j m10494a;
                int i = 0;
                Iterator<? extends b> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        m10260c(abstractC1258e);
                        return m10253a(C1308f.m10486a(0));
                    }
                }
                EnumC1286f enumC1286f = abstractC1258e.f8114c;
                if (enumC1286f == EnumC1286f.f8268K || enumC1286f == EnumC1286f.f8269L) {
                    b bVar = new b();
                    String substring = ((C1261h) abstractC1258e).f8122b.substring(1);
                    this.f8043a.m10249a(C1335l.m10586a(this.f8043a.m10245a(bVar), C1308f.m10502a(substring, C1308f.m10486a(list.size()))));
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        this.f8043a.m10249a(C1335l.m10586a(C1308f.m10511c(this.f8043a.m10245a(bVar), C1308f.m10486a(i2), substring), this.f8043a.m10245a(list.get(i2))));
                    }
                    return bVar;
                }
                if (enumC1286f == EnumC1286f.f8456dm || enumC1286f == EnumC1286f.f8457dn) {
                    AbstractC1322t[] abstractC1322tArr = new AbstractC1322t[list.size()];
                    while (i < abstractC1322tArr.length) {
                        abstractC1322tArr[i] = this.f8043a.m10245a(list.get(i));
                        i++;
                    }
                    C1263j c1263j = (C1263j) abstractC1258e;
                    C1311i m10493a = C1308f.m10493a(abstractC1322tArr, c1263j.f8126b, c1263j.f8127e, c1263j.f8128f, c1263j.f8129g);
                    if ("V".equals(c1263j.mo10357a().m10471b())) {
                        this.f8043a.m10249a(C1335l.m10600e(m10493a));
                        return (b) null;
                    }
                    return m10253a(m10493a);
                }
                if (enumC1286f == EnumC1286f.f8454dk || enumC1286f == EnumC1286f.f8455dl) {
                    AbstractC1322t[] abstractC1322tArr2 = new AbstractC1322t[list.size()];
                    while (i < abstractC1322tArr2.length) {
                        abstractC1322tArr2[i] = this.f8043a.m10245a(list.get(i));
                        i++;
                    }
                    C1264k c1264k = (C1264k) abstractC1258e;
                    C1313k m10496a = C1308f.m10496a(abstractC1322tArr2, c1264k.f8131e, c1264k.f8130b);
                    if ("V".equals(c1264k.mo10357a().m10471b())) {
                        this.f8043a.m10249a(C1335l.m10600e(m10496a));
                        return (b) null;
                    }
                    return m10253a(m10496a);
                }
                EnumC1286f enumC1286f2 = abstractC1258e.f8114c;
                AbstractC1322t[] abstractC1322tArr3 = new AbstractC1322t[list.size()];
                while (i < abstractC1322tArr3.length) {
                    abstractC1322tArr3[i] = this.f8043a.m10245a(list.get(i));
                    i++;
                }
                C1280e c1280e = ((C1265l) abstractC1258e).f8132b;
                if (enumC1286f2 == EnumC1286f.f8369bf || enumC1286f2 == EnumC1286f.f8364ba) {
                    m10494a = C1308f.m10518d(abstractC1322tArr3, c1280e.m10399d(), c1280e.m10398c(), c1280e.m10400e(), c1280e.m10401f());
                } else if (enumC1286f2 == EnumC1286f.f8370bg || enumC1286f2 == EnumC1286f.f8371bh || enumC1286f2 == EnumC1286f.f8365bb || enumC1286f2 == EnumC1286f.f8366bc) {
                    m10494a = C1308f.m10507b(abstractC1322tArr3, c1280e.m10399d(), c1280e.m10398c(), c1280e.m10400e(), c1280e.m10401f());
                } else if (enumC1286f2 == EnumC1286f.f8372bi || enumC1286f2 == EnumC1286f.f8367bd) {
                    m10494a = C1308f.m10513c(abstractC1322tArr3, c1280e.m10399d(), c1280e.m10398c(), c1280e.m10400e(), c1280e.m10401f());
                } else if (enumC1286f2 == EnumC1286f.f8373bj || enumC1286f2 == EnumC1286f.f8368be) {
                    m10494a = C1308f.m10494a(abstractC1322tArr3, c1280e.m10399d(), c1280e.m10398c(), c1280e.m10400e(), c1280e.m10401f());
                } else {
                    throw new RuntimeException();
                }
                if ("V".equals(c1280e.m10401f())) {
                    this.f8043a.m10249a(C1335l.m10600e(m10494a));
                    return (b) null;
                }
                return m10253a(m10494a);
            }

            /* renamed from: c */
            void m10260c(AbstractC1258e abstractC1258e) {
                String stringBuffer;
                EnumC1286f enumC1286f = abstractC1258e.f8114c;
                if (enumC1286f == EnumC1286f.f8467k || enumC1286f == EnumC1286f.f8469m || enumC1286f == EnumC1286f.f8468l) {
                    stringBuffer = new StringBuffer().append(new StringBuffer().append("can't get operand(s) for ").append(abstractC1258e.f8114c).toString()).append(", wrong position ?").toString();
                } else {
                    stringBuffer = new StringBuffer().append(new StringBuffer().append("can't get operand(s) for ").append(abstractC1258e.f8114c).toString()).append(", out-of-range or not initialized ?").toString();
                }
                System.err.println(new StringBuffer().append("WARN: ").append(stringBuffer).toString());
                this.f8043a.m10249a(C1335l.m10598c(C1308f.m10495a(new AbstractC1322t[]{C1308f.m10490a(new StringBuffer().append("d2j: ").append(stringBuffer).toString())}, new String[]{"Ljava/lang/String;"}, "Ljava/lang/VerifyError;")));
            }

            /* renamed from: c, reason: avoid collision after fix types in other method */
            public void c2(AbstractC1258e abstractC1258e, b bVar) {
                if (bVar == null) {
                    m10260c(abstractC1258e);
                } else {
                    this.f8043a.m10249a(C1335l.m10595b(this.f8043a.m10245a(bVar)));
                }
            }
        };
    }

    /* renamed from: a */
    private C1329f[] m10242a(C1238b[] c1238bArr) {
        C1329f[] c1329fArr = new C1329f[c1238bArr.length];
        for (int i = 0; i < c1238bArr.length; i++) {
            c1329fArr[i] = m10246a(c1238bArr[i]);
        }
        return c1329fArr;
    }

    /* renamed from: a */
    C1329f m10246a(C1238b c1238b) {
        C1329f c1329f = this.f8039h.get(c1238b);
        if (c1329f == null) {
            C1329f m10589a = C1335l.m10589a();
            this.f8039h.put(c1238b, m10589a);
            return m10589a;
        }
        return c1329f;
    }

    /* renamed from: a */
    private void m10240a(int[] iArr) {
        iArr[0] = 1;
        for (AbstractC1258e abstractC1258e : this.f8033b) {
            EnumC1286f enumC1286f = abstractC1258e.f8114c;
            if (enumC1286f == null) {
                if (abstractC1258e.f8115d < iArr.length - 1) {
                    int i = abstractC1258e.f8115d + 1;
                    iArr[i] = iArr[i] + 1;
                }
            } else {
                if (enumC1286f.m10453a()) {
                    int m10250b = m10250b(((C1262i) abstractC1258e).f8125e);
                    iArr[m10250b] = iArr[m10250b] + 1;
                }
                if (enumC1286f.m10455c()) {
                    for (C1238b c1238b : ((AbstractC1255b) abstractC1258e).f8110b) {
                        int m10250b2 = m10250b(c1238b);
                        iArr[m10250b2] = iArr[m10250b2] + 1;
                    }
                }
                if (enumC1286f.m10454b()) {
                    int i2 = abstractC1258e.f8115d + 1;
                    iArr[i2] = iArr[i2] + 1;
                }
            }
        }
    }

    /* renamed from: b */
    int m10250b(C1238b c1238b) {
        return this.f8032a.get(c1238b).f8115d;
    }

    /* compiled from: Dex2IRConverter.java */
    /* renamed from: com.g.a.b.a$b */
    static class b {

        /* renamed from: a */
        public b f8044a;

        /* renamed from: b */
        public Set<b> f8045b;

        /* renamed from: c */
        C1314l f8046c;

        public b(C1314l c1314l) {
            this.f8046c = c1314l;
        }

        public b() {
        }
    }
}
