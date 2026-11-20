package org.p210a.p211a.p212a.p213a;

import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.p210a.p211a.p212a.p215c.AbstractC1831a;
import org.p210a.p211a.p212a.p215c.C1835e;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: PredictionMode.java */
/* renamed from: org.a.a.a.a.as */
/* loaded from: classes.dex */
public enum EnumC1778as {
    SLL,
    LL,
    LL_EXACT_AMBIG_DETECTION;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1778as[] valuesCustom() {
        EnumC1778as[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1778as[] enumC1778asArr = new EnumC1778as[length];
        System.arraycopy(valuesCustom, 0, enumC1778asArr, 0, length);
        return enumC1778asArr;
    }

    /* compiled from: PredictionMode.java */
    /* renamed from: org.a.a.a.a.as$b */
    static class b extends C1835e<C1786b, BitSet> {
        public b() {
            super(a.f10736a);
        }
    }

    /* compiled from: PredictionMode.java */
    /* renamed from: org.a.a.a.a.as$a */
    private static final class a extends AbstractC1831a<C1786b> {

        /* renamed from: a */
        public static final a f10736a = new a();

        private a() {
        }

        @Override // org.p210a.p211a.p212a.p215c.InterfaceC1834d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int mo13573a(C1786b c1786b) {
            return C1841k.m13775b(C1841k.m13773a(C1841k.m13772a(C1841k.m13771a(7), c1786b.f10755a.f10798c), c1786b.f10757c), 2);
        }

        @Override // org.p210a.p211a.p212a.p215c.InterfaceC1834d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo13575a(C1786b c1786b, C1786b c1786b2) {
            if (c1786b == c1786b2) {
                return true;
            }
            if (c1786b == null || c1786b2 == null) {
                return false;
            }
            return c1786b.f10755a.f10798c == c1786b2.f10755a.f10798c && c1786b.f10757c.equals(c1786b2.f10757c);
        }
    }

    /* renamed from: a */
    public static boolean m13561a(EnumC1778as enumC1778as, C1793c c1793c) {
        if (m13564b(c1793c)) {
            return true;
        }
        if (enumC1778as == SLL && c1793c.f10770f) {
            C1793c c1793c2 = new C1793c();
            Iterator<C1786b> it = c1793c.iterator();
            while (it.hasNext()) {
                c1793c2.add(new C1786b(it.next(), AbstractC1783ax.f10744a));
            }
            c1793c = c1793c2;
        }
        return m13568d(m13565c(c1793c)) && !m13570e(c1793c);
    }

    /* renamed from: a */
    public static boolean m13562a(C1793c c1793c) {
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            if (it.next().f10755a instanceof C1781av) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m13564b(C1793c c1793c) {
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            if (!(it.next().f10755a instanceof C1781av)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m13560a(Collection<BitSet> collection) {
        return m13572g(collection);
    }

    /* renamed from: b */
    public static boolean m13563b(Collection<BitSet> collection) {
        return !m13566c(collection);
    }

    /* renamed from: c */
    public static boolean m13566c(Collection<BitSet> collection) {
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().cardinality() == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m13568d(Collection<BitSet> collection) {
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().cardinality() > 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m13569e(Collection<BitSet> collection) {
        Iterator<BitSet> it = collection.iterator();
        BitSet next = it.next();
        while (it.hasNext()) {
            if (!it.next().equals(next)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static BitSet m13571f(Collection<BitSet> collection) {
        BitSet bitSet = new BitSet();
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            bitSet.mo13226or(it.next());
        }
        return bitSet;
    }

    /* renamed from: c */
    public static Collection<BitSet> m13565c(C1793c c1793c) {
        b bVar = new b();
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            C1786b next = it.next();
            BitSet bitSet = (BitSet) bVar.get(next);
            if (bitSet == null) {
                bitSet = new BitSet();
                bVar.put(next, bitSet);
            }
            bitSet.set(next.f10756b);
        }
        return bVar.values();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static Map<AbstractC1797g, BitSet> m13567d(C1793c c1793c) {
        HashMap hashMap = new HashMap();
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            C1786b next = it.next();
            BitSet bitSet = (BitSet) hashMap.get(next.f10755a);
            if (bitSet == null) {
                bitSet = new BitSet();
                hashMap.put(next.f10755a, bitSet);
            }
            bitSet.set(next.f10756b);
        }
        return hashMap;
    }

    /* renamed from: e */
    public static boolean m13570e(C1793c c1793c) {
        Iterator<BitSet> it = m13567d(c1793c).values().iterator();
        while (it.hasNext()) {
            if (it.next().cardinality() == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static int m13572g(Collection<BitSet> collection) {
        BitSet bitSet = new BitSet();
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().nextSetBit(0));
            if (bitSet.cardinality() > 1) {
                return 0;
            }
        }
        return bitSet.nextSetBit(0);
    }
}
