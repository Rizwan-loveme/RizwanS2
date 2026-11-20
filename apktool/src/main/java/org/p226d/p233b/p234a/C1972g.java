package org.p226d.p233b.p234a;

import com.p129f.p130a.p131a.C1114i;
import com.p129f.p130a.p131a.C1122q;
import com.p129f.p130a.p131a.C1128w;
import com.p129f.p130a.p131a.InterfaceC1127v;
import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1203r;
import com.p129f.p130a.p133c.C1153af;
import com.p129f.p130a.p133c.C1156ai;
import com.p129f.p130a.p133c.C1157aj;
import com.p129f.p130a.p137g.C1219c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p234a.p237b.C1967a;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p263h.AbstractC2381a;
import org.p226d.p233b.p263h.C2387g;
import org.p226d.p269d.C2453g;
import org.p226d.p269d.C2462p;

/* compiled from: ClassProto.java */
/* renamed from: org.d.b.a.g */
/* loaded from: classes.dex */
public class C1972g implements InterfaceC1981p {

    /* renamed from: a */
    protected final C1970e f11467a;

    /* renamed from: b */
    protected final String f11468b;

    /* renamed from: c */
    protected boolean f11469c = true;

    /* renamed from: d */
    protected boolean f11470d = true;

    /* renamed from: e */
    protected Set<String> f11471e = null;

    /* renamed from: f */
    private final InterfaceC1127v<InterfaceC2244d> f11472f = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<InterfaceC2244d>() { // from class: org.d.b.a.g.1
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC2244d mo9592a() {
            return C1972g.this.f11467a.m14274a(C1972g.this.f11468b);
        }
    });

    /* renamed from: g */
    private final InterfaceC1127v<LinkedHashMap<String, InterfaceC2244d>> f11473g = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<LinkedHashMap<String, InterfaceC2244d>>() { // from class: org.d.b.a.g.2
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LinkedHashMap<String, InterfaceC2244d> mo9592a() {
            HashSet hashSet = new HashSet(0);
            LinkedHashMap<String, InterfaceC2244d> m9936d = C1157aj.m9936d();
            try {
                for (String str : C1972g.this.m14304d().mo14196c()) {
                    if (!m9936d.containsKey(str)) {
                        try {
                            m9936d.put(str, C1972g.this.f11467a.m14274a(str));
                        } catch (C1983r e2) {
                            m9936d.put(str, null);
                            hashSet.add(str);
                            C1972g.this.f11470d = false;
                        }
                        C1972g c1972g = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) str);
                        for (String str2 : c1972g.m14305e().keySet()) {
                            if (!m9936d.containsKey(str2)) {
                                m9936d.put(str2, c1972g.m14305e().get(str2));
                            }
                        }
                        if (!c1972g.f11470d) {
                            hashSet.addAll(c1972g.m14306g());
                            C1972g.this.f11470d = false;
                        }
                    }
                }
            } catch (C1983r e3) {
                m9936d.put(C1972g.this.f11468b, null);
                hashSet.add(C1972g.this.f11468b);
                C1972g.this.f11470d = false;
            }
            if (C1972g.this.mo14267c() && !m9936d.containsKey(C1972g.this.mo14265b())) {
                m9936d.put(C1972g.this.mo14265b(), null);
            }
            String mo14270f = C1972g.this.mo14270f();
            if (mo14270f != null) {
                try {
                    C1972g c1972g2 = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) mo14270f);
                    for (String str3 : c1972g2.m14305e().keySet()) {
                        if (!m9936d.containsKey(str3)) {
                            m9936d.put(str3, null);
                        }
                    }
                    if (!c1972g2.f11470d) {
                        hashSet.addAll(c1972g2.m14306g());
                        C1972g.this.f11470d = false;
                    }
                } catch (C1983r e4) {
                    hashSet.add(mo14270f);
                    C1972g.this.f11470d = false;
                }
            }
            if (hashSet.size() > 0) {
                C1972g.this.f11471e = hashSet;
            }
            return m9936d;
        }
    });

    /* renamed from: h */
    private final InterfaceC1127v<LinkedHashMap<String, InterfaceC2244d>> f11474h = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<LinkedHashMap<String, InterfaceC2244d>>() { // from class: org.d.b.a.g.3
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LinkedHashMap<String, InterfaceC2244d> mo9592a() {
            HashSet hashSet = new HashSet(0);
            LinkedHashMap<String, InterfaceC2244d> m9936d = C1157aj.m9936d();
            String mo14270f = C1972g.this.mo14270f();
            if (mo14270f != null) {
                C1972g c1972g = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) mo14270f);
                Iterator<String> it = c1972g.m14305e().keySet().iterator();
                while (it.hasNext()) {
                    m9936d.put(it.next(), null);
                }
                if (!c1972g.f11470d) {
                    hashSet.addAll(c1972g.m14306g());
                    C1972g.this.f11470d = false;
                }
            }
            try {
                for (String str : C1972g.this.m14304d().mo14196c()) {
                    if (!m9936d.containsKey(str)) {
                        C1972g c1972g2 = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) str);
                        try {
                            for (Map.Entry<String, InterfaceC2244d> entry : c1972g2.m14305e().entrySet()) {
                                if (!m9936d.containsKey(entry.getKey())) {
                                    m9936d.put(entry.getKey(), entry.getValue());
                                }
                            }
                        } catch (C1983r e2) {
                            m9936d.put(str, null);
                            hashSet.add(str);
                            C1972g.this.f11470d = false;
                        }
                        if (!c1972g2.f11470d) {
                            hashSet.addAll(c1972g2.m14306g());
                            C1972g.this.f11470d = false;
                        }
                        try {
                            m9936d.put(str, C1972g.this.f11467a.m14274a(str));
                        } catch (C1983r e3) {
                            m9936d.put(str, null);
                            hashSet.add(str);
                            C1972g.this.f11470d = false;
                        }
                    }
                }
            } catch (C1983r e4) {
                m9936d.put(C1972g.this.f11468b, null);
                hashSet.add(C1972g.this.f11468b);
                C1972g.this.f11470d = false;
            }
            if (hashSet.size() > 0) {
                C1972g.this.f11471e = hashSet;
            }
            return m9936d;
        }
    });

    /* renamed from: i */
    private final InterfaceC1127v<C2462p<InterfaceC2237b>> f11475i = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<C2462p<InterfaceC2237b>>() { // from class: org.d.b.a.g.4

        /* renamed from: a */
        static final /* synthetic */ boolean f11483a;

        static {
            f11483a = !C1972g.class.desiredAssertionStatus();
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x00d3  */
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public C2462p<InterfaceC2237b> mo9592a() {
            int i;
            int i2;
            int i3;
            C2462p<InterfaceC2237b> c2462p;
            int i4;
            int i5;
            int i6;
            int i7;
            ArrayList<InterfaceC2266g> m14313a = m14313a(C1972g.this.m14304d());
            int size = m14313a.size();
            byte[] bArr = new byte[m14313a.size()];
            for (int i8 = 0; i8 < size; i8++) {
                bArr[i8] = C1972g.m14298b(m14313a.get(i8));
            }
            int size2 = m14313a.size() - 1;
            int i9 = 0;
            while (i9 < size) {
                if (bArr[i9] != 0) {
                    int i10 = size2;
                    while (true) {
                        if (i10 <= i9) {
                            size2 = i10;
                            break;
                        }
                        if (bArr[i10] == 0) {
                            size2 = i10 - 1;
                            m14314a(bArr, m14313a, i9, i10);
                            break;
                        }
                        i10--;
                    }
                }
                if (bArr[i9] != 0) {
                    break;
                }
                i9++;
            }
            String mo14270f = C1972g.this.mo14270f();
            C1972g c1972g = null;
            if (mo14270f != null) {
                c1972g = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) mo14270f);
                i = c1972g.m14303k();
            } else {
                i = 8;
            }
            int i11 = i % 8 == 0 ? 0 : 1;
            if (i9 < size && i9 % 2 != i11) {
                if (bArr[i9] == 1) {
                    for (int i12 = size - 1; i12 > i9; i12--) {
                        if (bArr[i12] == 2) {
                            i2 = i9 + 1;
                            m14314a(bArr, m14313a, i9, i12);
                            break;
                        }
                    }
                } else {
                    i2 = i9 + 1;
                }
                int i13 = size - 1;
                i3 = i2;
                while (i3 < size) {
                    if (bArr[i3] != 1) {
                        while (i13 > i3) {
                            if (bArr[i13] == 1) {
                                i7 = i13 - 1;
                                m14314a(bArr, m14313a, i3, i13);
                                break;
                            }
                            i13--;
                        }
                    }
                    i7 = i13;
                    if (bArr[i3] != 1) {
                        break;
                    }
                    i3++;
                    i13 = i7;
                }
                if (c1972g == null) {
                    c2462p = c1972g.m14308i();
                } else {
                    c2462p = new C2462p<>();
                }
                int m15545a = c2462p.m15545a();
                C2462p<InterfaceC2237b> c2462p2 = new C2462p<>(m15545a + size);
                if (c1972g != null || m15545a <= 0) {
                    i4 = 8;
                } else {
                    for (int i14 = 0; i14 < m15545a; i14++) {
                        c2462p2.m15552c(c2462p.m15548b(i14), c2462p.m15551c(i14));
                    }
                    int m15548b = c2462p2.m15548b(m15545a - 1);
                    char charAt = c2462p.m15551c(m15545a - 1).mo14227f().charAt(0);
                    if (charAt == 'J' || charAt == 'D') {
                        i4 = m15548b + 8;
                    } else {
                        i4 = m15548b + 4;
                    }
                }
                i5 = 0;
                boolean z = false;
                int i15 = i4;
                while (i5 < size) {
                    InterfaceC2266g interfaceC2266g = m14313a.get(i5);
                    if (bArr[i5] == 1 && !z) {
                        if (i15 % 8 != 0) {
                            if (!f11483a && i15 % 8 != 4) {
                                throw new AssertionError();
                            }
                            i15 += 4;
                        }
                        z = true;
                    }
                    c2462p2.m15552c(i15, interfaceC2266g);
                    if (bArr[i5] == 1) {
                        i6 = i15 + 8;
                    } else {
                        i6 = i15 + 4;
                    }
                    i5++;
                    i15 = i6;
                }
                return c2462p2;
            }
            i2 = i9;
            int i132 = size - 1;
            i3 = i2;
            while (i3 < size) {
            }
            if (c1972g == null) {
            }
            int m15545a2 = c2462p.m15545a();
            C2462p<InterfaceC2237b> c2462p22 = new C2462p<>(m15545a2 + size);
            if (c1972g != null) {
            }
            i4 = 8;
            i5 = 0;
            boolean z2 = false;
            int i152 = i4;
            while (i5 < size) {
            }
            return c2462p22;
        }

        /* renamed from: a */
        private ArrayList<InterfaceC2266g> m14313a(InterfaceC2244d interfaceC2244d) {
            ArrayList<InterfaceC2266g> m9910a = C1156ai.m9910a(interfaceC2244d.mo14200g());
            Collections.sort(m9910a);
            return m9910a;
        }

        /* renamed from: a */
        private void m14314a(byte[] bArr, List<InterfaceC2266g> list, int i, int i2) {
            byte b2 = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b2;
            list.set(i2, list.set(i, list.get(i2)));
        }
    });

    /* renamed from: j */
    private final InterfaceC1127v<C2462p<InterfaceC2237b>> f11476j = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<C2462p<InterfaceC2237b>>() { // from class: org.d.b.a.g.5
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2462p<InterfaceC2237b> mo9592a() {
            int i = 0;
            PriorityQueue<a> priorityQueue = new PriorityQueue<>();
            C2462p<InterfaceC2237b> c2462p = new C2462p<>();
            ArrayList<InterfaceC2266g> m14318a = m14318a(C1972g.this.m14304d());
            String mo14270f = C1972g.this.mo14270f();
            if (mo14270f != null) {
                C2462p<InterfaceC2237b> m14308i = ((C1972g) C1972g.this.f11467a.m14273a((CharSequence) mo14270f)).m14308i();
                InterfaceC2237b interfaceC2237b = null;
                int i2 = 0;
                for (int i3 = 0; i3 < m14308i.m15545a(); i3++) {
                    i2 = m14308i.m15548b(i3);
                    interfaceC2237b = m14308i.m15551c(i3);
                    c2462p.m15550b(i2, interfaceC2237b);
                }
                if (interfaceC2237b != null) {
                    i = i2 + m14320b(interfaceC2237b);
                }
            }
            Iterator<InterfaceC2266g> it = m14318a.iterator();
            while (it.hasNext()) {
                InterfaceC2266g next = it.next();
                int m14320b = m14320b(next);
                if (!AbstractC2381a.m15071b(i, m14320b)) {
                    int m15070a = AbstractC2381a.m15070a(i, m14320b);
                    m14319a(i, m15070a, priorityQueue);
                    i = m15070a;
                }
                a peek = priorityQueue.peek();
                if (peek != null && peek.f11495b >= m14320b) {
                    priorityQueue.poll();
                    c2462p.m15550b(peek.f11494a, next);
                    if (peek.f11495b > m14320b) {
                        m14319a(peek.f11494a + m14320b, peek.f11495b + peek.f11494a, priorityQueue);
                    }
                } else {
                    c2462p.m15552c(i, next);
                    i += m14320b;
                }
            }
            return c2462p;
        }

        /* renamed from: a */
        private void m14319a(int i, int i2, PriorityQueue<a> priorityQueue) {
            int i3;
            while (i < i2) {
                int i4 = i2 - i;
                if (i4 >= 4 && i % 4 == 0) {
                    priorityQueue.add(a.m14328a(i, 4, C1972g.this.f11467a.f11456a));
                    i3 = i + 4;
                } else if (i4 >= 2 && i % 2 == 0) {
                    priorityQueue.add(a.m14328a(i, 2, C1972g.this.f11467a.f11456a));
                    i3 = i + 2;
                } else {
                    priorityQueue.add(a.m14328a(i, 1, C1972g.this.f11467a.f11456a));
                    i3 = i + 1;
                }
                i = i3;
            }
        }

        /* renamed from: a */
        private ArrayList<InterfaceC2266g> m14318a(InterfaceC2244d interfaceC2244d) {
            ArrayList<InterfaceC2266g> m9910a = C1156ai.m9910a(interfaceC2244d.mo14200g());
            Collections.sort(m9910a, new Comparator<InterfaceC2266g>() { // from class: org.d.b.a.g.5.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(InterfaceC2266g interfaceC2266g, InterfaceC2266g interfaceC2266g2) {
                    int m10173a = C1219c.m10173a(m14317a(interfaceC2266g), m14317a(interfaceC2266g2));
                    if (m10173a == 0) {
                        int compareTo = interfaceC2266g.mo14226e().compareTo(interfaceC2266g2.mo14226e());
                        return compareTo == 0 ? interfaceC2266g.mo14227f().compareTo(interfaceC2266g2.mo14227f()) : compareTo;
                    }
                    return m10173a;
                }
            });
            return m9910a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m14317a(InterfaceC2237b interfaceC2237b) {
            switch (interfaceC2237b.mo14227f().charAt(0)) {
                case 'B':
                    return 8;
                case 'C':
                    return 5;
                case 'D':
                    return 2;
                case 'F':
                    return 4;
                case 'I':
                    return 3;
                case 'J':
                    return 1;
                case 'L':
                case '[':
                    return 0;
                case 'S':
                    return 6;
                case 'Z':
                    return 7;
                default:
                    throw new C2453g("Invalid field type: %s", interfaceC2237b.mo14227f());
            }
        }

        /* renamed from: b */
        private int m14320b(InterfaceC2237b interfaceC2237b) {
            return C1972g.m14299b(interfaceC2237b.mo14227f().charAt(0));
        }
    });

    /* renamed from: k */
    private final InterfaceC1127v<List<InterfaceC2267h>> f11477k = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<List<InterfaceC2267h>>() { // from class: org.d.b.a.g.6
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<InterfaceC2267h> mo9592a() {
            ArrayList m9909a = C1156ai.m9909a();
            try {
                String mo14270f = C1972g.this.mo14270f();
                if (mo14270f != null) {
                    C1972g c1972g = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) mo14270f);
                    m9909a.addAll(c1972g.m14309j());
                    if (!c1972g.f11469c) {
                        C1972g.this.f11469c = false;
                        return m9909a;
                    }
                }
                if (!C1972g.this.mo14267c()) {
                    C1972g.this.m14292a(C1972g.this.m14304d().mo14203j(), m9909a, true, true);
                    for (InterfaceC2244d interfaceC2244d : C1972g.this.m14307h()) {
                        ArrayList m9909a2 = C1156ai.m9909a();
                        Iterator<? extends InterfaceC2267h> it = interfaceC2244d.mo14203j().iterator();
                        while (it.hasNext()) {
                            m9909a2.add(new b(it.next(), C1972g.this.f11468b));
                        }
                        C1972g.this.m14292a(m9909a2, m9909a, false, true);
                    }
                }
                return m9909a;
            } catch (C1983r e2) {
                m9909a.addAll(((C1972g) C1972g.this.f11467a.m14273a((CharSequence) "Ljava/lang/Object;")).m14309j());
                C1972g.this.f11469c = false;
                return m9909a;
            }
        }
    });

    /* renamed from: l */
    private final InterfaceC1127v<List<InterfaceC2267h>> f11478l = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<List<InterfaceC2267h>>() { // from class: org.d.b.a.g.7
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<InterfaceC2267h> mo9592a() {
            InterfaceC2267h interfaceC2267h;
            ArrayList m9909a = C1156ai.m9909a();
            try {
                String mo14270f = C1972g.this.mo14270f();
                if (mo14270f != null) {
                    C1972g c1972g = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) mo14270f);
                    m9909a.addAll(c1972g.m14309j());
                    if (!c1972g.f11469c) {
                        C1972g.this.f11469c = false;
                        return m9909a;
                    }
                }
                if (!C1972g.this.mo14267c()) {
                    C1972g.this.m14292a(C1972g.this.m14304d().mo14203j(), m9909a, true, true);
                    ArrayList m9910a = C1156ai.m9910a(C1972g.this.m14305e().keySet());
                    ArrayList m9909a2 = C1156ai.m9909a();
                    ArrayList m9909a3 = C1156ai.m9909a();
                    ArrayList m9909a4 = C1156ai.m9909a();
                    final HashMap m9935c = C1157aj.m9935c();
                    for (int size = m9910a.size() - 1; size >= 0; size--) {
                        for (InterfaceC2267h interfaceC2267h2 : C1972g.this.f11467a.m14274a((String) m9910a.get(size)).mo14203j()) {
                            int m14300b = C1972g.this.m14300b(m9909a, interfaceC2267h2);
                            if (m14300b < 0) {
                                interfaceC2267h = null;
                            } else {
                                interfaceC2267h = (InterfaceC2267h) m9909a.get(m14300b);
                            }
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= m9909a.size()) {
                                    break;
                                }
                                InterfaceC2267h interfaceC2267h3 = (InterfaceC2267h) m9909a.get(i2);
                                if (C2387g.m15092a(interfaceC2267h3, interfaceC2267h2) && ((!C1972g.this.f11467a.m14277c() || C1968c.m14258a(C1972g.this, interfaceC2267h3, true, false, false)) && C1972g.this.m14297a(interfaceC2267h2, interfaceC2267h3))) {
                                    m9909a.set(i2, interfaceC2267h2);
                                }
                                i = i2 + 1;
                            }
                            if (m14300b < 0 || C1972g.this.m14296a((InterfaceC2267h) m9909a.get(m14300b))) {
                                int m14289a = C1972g.this.m14289a(m9909a2, interfaceC2267h2);
                                if (m14289a >= 0) {
                                    if (!EnumC1959a.ABSTRACT.m14192a(interfaceC2267h2.mo14214f()) && !((C1972g) C1972g.this.f11467a.m14273a((CharSequence) ((InterfaceC2267h) m9909a2.get(m14289a)).mo14209a())).mo14264a(interfaceC2267h2.mo14209a())) {
                                        m9909a3.add((InterfaceC2267h) m9909a2.remove(m14289a));
                                    }
                                } else if (C1972g.this.m14289a(m9909a3, interfaceC2267h2) < 0) {
                                    int m14289a2 = C1972g.this.m14289a(m9909a4, interfaceC2267h2);
                                    if (m14289a2 >= 0) {
                                        if (!EnumC1959a.ABSTRACT.m14192a(interfaceC2267h2.mo14214f()) && !((C1972g) C1972g.this.f11467a.m14273a((CharSequence) ((InterfaceC2267h) m9909a4.get(m14289a2)).mo14209a())).mo14264a(interfaceC2267h2.mo14209a())) {
                                            m9935c.put(interfaceC2267h2, Integer.valueOf(((Integer) m9935c.get((InterfaceC2267h) m9909a4.remove(m14289a2))).intValue()));
                                            m9909a2.add(interfaceC2267h2);
                                        }
                                    } else if (!EnumC1959a.ABSTRACT.m14192a(interfaceC2267h2.mo14214f())) {
                                        if (interfaceC2267h == null || C1972g.this.m14297a(interfaceC2267h2, interfaceC2267h)) {
                                            m9909a2.add(interfaceC2267h2);
                                            m9935c.put(interfaceC2267h2, Integer.valueOf(m9935c.size()));
                                        }
                                    } else if (interfaceC2267h == null) {
                                        m9909a4.add(interfaceC2267h2);
                                        m9935c.put(interfaceC2267h2, Integer.valueOf(m9935c.size()));
                                    }
                                }
                            }
                        }
                    }
                    Comparator<InterfaceC2240e> comparator = new Comparator<InterfaceC2240e>() { // from class: org.d.b.a.g.7.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(InterfaceC2240e interfaceC2240e, InterfaceC2240e interfaceC2240e2) {
                            return C1219c.m10173a(((Integer) m9935c.get(interfaceC2240e)).intValue(), ((Integer) m9935c.get(interfaceC2240e2)).intValue());
                        }
                    };
                    Collections.sort(m9909a4, comparator);
                    Collections.sort(m9909a2, comparator);
                    Collections.sort(m9909a3, comparator);
                    m9909a.addAll(m9909a4);
                    m9909a.addAll(m9909a2);
                    m9909a.addAll(m9909a3);
                }
                return m9909a;
            } catch (C1983r e2) {
                m9909a.addAll(((C1972g) C1972g.this.f11467a.m14273a((CharSequence) "Ljava/lang/Object;")).m14309j());
                C1972g.this.f11469c = false;
                return m9909a;
            }
        }
    });

    /* renamed from: m */
    private final InterfaceC1127v<List<InterfaceC2267h>> f11479m = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<List<InterfaceC2267h>>() { // from class: org.d.b.a.g.8
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<InterfaceC2267h> mo9592a() {
            ArrayList m9909a = C1156ai.m9909a();
            try {
                String mo14270f = C1972g.this.mo14270f();
                if (mo14270f != null) {
                    C1972g c1972g = (C1972g) C1972g.this.f11467a.m14273a((CharSequence) mo14270f);
                    m9909a.addAll(c1972g.m14309j());
                    if (!c1972g.f11469c) {
                        C1972g.this.f11469c = false;
                        return m9909a;
                    }
                }
                if (!C1972g.this.mo14267c()) {
                    C1972g.this.m14292a(C1972g.this.m14304d().mo14203j(), m9909a, true, true);
                    List m9913a = C1156ai.m9913a((List) C1156ai.m9910a(C1972g.this.m14307h()));
                    ArrayList m9909a2 = C1156ai.m9909a();
                    ArrayList m9909a3 = C1156ai.m9909a();
                    ArrayList m9909a4 = C1156ai.m9909a();
                    final HashMap m9935c = C1157aj.m9935c();
                    Iterator<E> it = m9913a.iterator();
                    while (it.hasNext()) {
                        for (InterfaceC2267h interfaceC2267h : ((InterfaceC2244d) it.next()).mo14203j()) {
                            int m14289a = C1972g.this.m14289a(m9909a, interfaceC2267h);
                            if (m14289a >= 0) {
                                if (C1972g.this.m14297a(interfaceC2267h, (InterfaceC2267h) m9909a.get(m14289a))) {
                                    m9909a.set(m14289a, interfaceC2267h);
                                }
                            } else {
                                int m14289a2 = C1972g.this.m14289a(m9909a2, interfaceC2267h);
                                if (m14289a2 >= 0) {
                                    if (!EnumC1959a.ABSTRACT.m14192a(interfaceC2267h.mo14214f()) && !((C1972g) C1972g.this.f11467a.m14273a((CharSequence) ((InterfaceC2267h) m9909a2.get(m14289a2)).mo14209a())).mo14264a(interfaceC2267h.mo14209a())) {
                                        m9909a3.add((InterfaceC2267h) m9909a2.remove(m14289a2));
                                    }
                                } else if (C1972g.this.m14289a(m9909a3, interfaceC2267h) < 0) {
                                    int m14289a3 = C1972g.this.m14289a(m9909a4, interfaceC2267h);
                                    if (m14289a3 >= 0) {
                                        if (!EnumC1959a.ABSTRACT.m14192a(interfaceC2267h.mo14214f()) && !((C1972g) C1972g.this.f11467a.m14273a((CharSequence) ((InterfaceC2267h) m9909a4.get(m14289a3)).mo14209a())).mo14264a(interfaceC2267h.mo14209a())) {
                                            m9935c.put(interfaceC2267h, Integer.valueOf(((Integer) m9935c.get((InterfaceC2267h) m9909a4.remove(m14289a3))).intValue()));
                                            m9909a2.add(interfaceC2267h);
                                        }
                                    } else if (!EnumC1959a.ABSTRACT.m14192a(interfaceC2267h.mo14214f())) {
                                        m9909a2.add(interfaceC2267h);
                                        m9935c.put(interfaceC2267h, Integer.valueOf(m9935c.size()));
                                    } else {
                                        m9909a4.add(interfaceC2267h);
                                        m9935c.put(interfaceC2267h, Integer.valueOf(m9935c.size()));
                                    }
                                }
                            }
                        }
                    }
                    Comparator<InterfaceC2240e> comparator = new Comparator<InterfaceC2240e>() { // from class: org.d.b.a.g.8.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(InterfaceC2240e interfaceC2240e, InterfaceC2240e interfaceC2240e2) {
                            return C1219c.m10173a(((Integer) m9935c.get(interfaceC2240e)).intValue(), ((Integer) m9935c.get(interfaceC2240e2)).intValue());
                        }
                    };
                    Collections.sort(m9909a2, comparator);
                    Collections.sort(m9909a3, comparator);
                    Collections.sort(m9909a4, comparator);
                    C1972g.this.m14292a(m9909a2, m9909a, false, false);
                    C1972g.this.m14292a(m9909a3, m9909a, false, false);
                    C1972g.this.m14292a(m9909a4, m9909a, false, false);
                }
                return m9909a;
            } catch (C1983r e2) {
                m9909a.addAll(((C1972g) C1972g.this.f11467a.m14273a((CharSequence) "Ljava/lang/Object;")).m14309j());
                C1972g.this.f11469c = false;
                return m9909a;
            }
        }
    });

    public C1972g(C1970e c1970e, String str) {
        if (str.charAt(0) != 'L') {
            throw new C2453g("Cannot construct ClassProto for non reference type: %s", str);
        }
        this.f11467a = c1970e;
        this.f11468b = str;
    }

    public String toString() {
        return this.f11468b;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public C1970e mo14261a() {
        return this.f11467a;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: b */
    public String mo14265b() {
        return this.f11468b;
    }

    /* renamed from: d */
    public InterfaceC2244d m14304d() {
        return this.f11472f.mo9592a();
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: c */
    public boolean mo14267c() {
        return (m14304d().mo14194a() & EnumC1959a.INTERFACE.m14191a()) != 0;
    }

    /* renamed from: e */
    protected LinkedHashMap<String, InterfaceC2244d> m14305e() {
        return (!this.f11467a.m14275a() || this.f11467a.f11456a < 72) ? this.f11473g.mo9592a() : this.f11474h.mo9592a();
    }

    /* renamed from: g */
    protected Set<String> m14306g() {
        return this.f11471e == null ? AbstractC1148aa.m9802i() : this.f11471e;
    }

    /* renamed from: h */
    protected Iterable<InterfaceC2244d> m14307h() {
        AbstractC1203r m10115a = AbstractC1203r.m10108a(m14305e().values()).m10115a(C1122q.m9563a());
        if (!this.f11470d) {
            throw new C1983r("Interfaces for class %s not fully resolved: %s", mo14265b(), C1114i.m9520a(',').m9524a((Iterable<?>) m14306g()));
        }
        return m10115a;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public boolean mo14264a(String str) {
        if (m14305e().containsKey(str)) {
            return true;
        }
        if (this.f11470d) {
            return false;
        }
        throw new C1983r("Interfaces for class %s not fully resolved", mo14265b());
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: f */
    public String mo14270f() {
        return m14304d().mo14195b();
    }

    /* renamed from: b */
    private boolean m14302b(C1972g c1972g) {
        boolean z;
        boolean z2;
        try {
            z = mo14267c();
            z2 = true;
        } catch (C1983r e2) {
            z = true;
            z2 = false;
        }
        if (z) {
            try {
                if (c1972g.mo14264a(mo14265b())) {
                    return true;
                }
            } catch (C1983r e3) {
                if (z2) {
                    throw e3;
                }
            }
        }
        return false;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public InterfaceC1981p mo14262a(InterfaceC1981p interfaceC1981p) {
        boolean z;
        boolean z2;
        if (!(interfaceC1981p instanceof C1972g)) {
            return interfaceC1981p.mo14262a(this);
        }
        if (this != interfaceC1981p && !mo14265b().equals(interfaceC1981p.mo14265b()) && !mo14265b().equals("Ljava/lang/Object;")) {
            if (interfaceC1981p.mo14265b().equals("Ljava/lang/Object;")) {
                return interfaceC1981p;
            }
            try {
            } catch (C1983r e2) {
                z = true;
            }
            if (!m14302b((C1972g) interfaceC1981p)) {
                z = false;
                try {
                } catch (C1983r e3) {
                    z2 = true;
                }
                if (((C1972g) interfaceC1981p).m14302b(this)) {
                    return interfaceC1981p;
                }
                z2 = z;
                if (z2) {
                    return this.f11467a.m14276b();
                }
                ArrayList m9912a = C1156ai.m9912a(this);
                C1153af.m9872a((Collection) m9912a, (Iterable) C1967a.m14254a(this));
                ArrayList m9912a2 = C1156ai.m9912a(interfaceC1981p);
                C1153af.m9872a((Collection) m9912a2, (Iterable) C1967a.m14254a(interfaceC1981p));
                List m9913a = C1156ai.m9913a((List) m9912a);
                List m9913a2 = C1156ai.m9913a((List) m9912a2);
                for (int min = Math.min(m9913a.size(), m9913a2.size()) - 1; min >= 0; min--) {
                    InterfaceC1981p interfaceC1981p2 = (InterfaceC1981p) m9913a.get(min);
                    if (interfaceC1981p2.mo14265b().equals(((InterfaceC1981p) m9913a2.get(min)).mo14265b())) {
                        return interfaceC1981p2;
                    }
                }
                return this.f11467a.m14276b();
            }
            return this;
        }
        return this;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public InterfaceC2237b mo14263a(int i) {
        if (m14308i().m15545a() == 0) {
            return null;
        }
        return m14308i().m15546a(i);
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: b */
    public InterfaceC2267h mo14266b(int i) {
        List<InterfaceC2267h> m14309j = m14309j();
        if (i < 0 || i >= m14309j.size()) {
            return null;
        }
        return m14309j.get(i);
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public int mo14260a(InterfaceC2240e interfaceC2240e) {
        return m14289a(m14309j(), interfaceC2240e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m14289a(List<InterfaceC2267h> list, InterfaceC2240e interfaceC2240e) {
        int i = 0;
        while (i < list.size()) {
            InterfaceC2267h interfaceC2267h = list.get(i);
            if (!C2387g.m15092a(interfaceC2267h, interfaceC2240e) || (this.f11467a.m14277c() && !C1968c.m14258a(this, interfaceC2267h, true, false, false))) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m14300b(List<InterfaceC2267h> list, InterfaceC2240e interfaceC2240e) {
        for (int size = list.size() - 1; size >= 0; size--) {
            InterfaceC2267h interfaceC2267h = list.get(size);
            if (C2387g.m15092a(interfaceC2267h, interfaceC2240e) && (!this.f11467a.m14277c() || C1968c.m14258a(this, interfaceC2267h, true, false, false))) {
                return size;
            }
        }
        return -1;
    }

    /* renamed from: i */
    public C2462p<InterfaceC2237b> m14308i() {
        return this.f11467a.m14275a() ? this.f11476j.mo9592a() : this.f11475i.mo9592a();
    }

    /* compiled from: ClassProto.java */
    /* renamed from: org.d.b.a.g$a */
    private static abstract class a implements Comparable<a> {

        /* renamed from: a */
        public final int f11494a;

        /* renamed from: b */
        public final int f11495b;

        /* renamed from: a */
        public static a m14328a(int i, int i2, int i3) {
            return i3 >= 67 ? new a(i, i2) { // from class: org.d.b.a.g.a.1
                @Override // java.lang.Comparable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compareTo(a aVar) {
                    int m10173a = C1219c.m10173a(aVar.f11495b, this.f11495b);
                    return m10173a != 0 ? m10173a : C1219c.m10173a(this.f11494a, aVar.f11494a);
                }
            } : new a(i, i2) { // from class: org.d.b.a.g.a.2
                @Override // java.lang.Comparable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compareTo(a aVar) {
                    int m10173a = C1219c.m10173a(this.f11495b, aVar.f11495b);
                    return m10173a != 0 ? m10173a : C1219c.m10173a(aVar.f11494a, this.f11494a);
                }
            };
        }

        private a(int i, int i2) {
            this.f11494a = i;
            this.f11495b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public int m14303k() {
        C2462p<InterfaceC2237b> m14308i = m14308i();
        if (m14308i.m15545a() == 0) {
            return this.f11467a.m14275a() ? 0 : 8;
        }
        int m15545a = m14308i.m15545a() - 1;
        int m15548b = m14308i.m15548b(m15545a);
        InterfaceC2237b m15551c = m14308i.m15551c(m15545a);
        if (this.f11467a.m14275a()) {
            return m14299b(m15551c.mo14227f().charAt(0)) + m15548b;
        }
        switch (m15551c.mo14227f().charAt(0)) {
            case 'D':
            case 'J':
                return m15548b + 8;
            default:
                return m15548b + 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static int m14299b(char c2) {
        switch (c2) {
            case 'B':
            case 'Z':
                return 1;
            case 'C':
            case 'S':
                return 2;
            case 'D':
            case 'J':
                return 8;
            case 'F':
            case 'I':
            case 'L':
            case '[':
                return 4;
            default:
                throw new C2453g("Invalid type: %s", Character.valueOf(c2));
        }
    }

    /* renamed from: j */
    public List<InterfaceC2267h> m14309j() {
        if (!this.f11467a.m14275a() || this.f11467a.f11456a < 72) {
            return this.f11477k.mo9592a();
        }
        if (this.f11467a.f11456a < 87) {
            return this.f11478l.mo9592a();
        }
        return this.f11479m.mo9592a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14292a(Iterable<? extends InterfaceC2267h> iterable, List<InterfaceC2267h> list, boolean z, boolean z2) {
        Iterable<? extends InterfaceC2267h> iterable2 = iterable;
        if (z2) {
            ArrayList m9910a = C1156ai.m9910a(iterable);
            Collections.sort(m9910a);
            iterable2 = m9910a;
        }
        for (InterfaceC2267h interfaceC2267h : iterable2) {
            int m14289a = m14289a(list, interfaceC2267h);
            if (m14289a >= 0) {
                if (z) {
                    list.set(m14289a, interfaceC2267h);
                }
            } else {
                list.add(interfaceC2267h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte m14298b(InterfaceC2237b interfaceC2237b) {
        switch (interfaceC2237b.mo14227f().charAt(0)) {
            case 'D':
            case 'J':
                return (byte) 1;
            case 'L':
            case '[':
                return (byte) 0;
            default:
                return (byte) 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m14296a(InterfaceC2267h interfaceC2267h) {
        return ((C1972g) this.f11467a.m14273a((CharSequence) interfaceC2267h.mo14209a())).mo14267c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m14297a(InterfaceC2267h interfaceC2267h, InterfaceC2267h interfaceC2267h2) {
        if (((C1972g) this.f11467a.m14273a((CharSequence) interfaceC2267h2.mo14209a())).mo14267c()) {
            return ((C1972g) this.f11467a.m14273a((CharSequence) interfaceC2267h.mo14209a())).mo14264a(interfaceC2267h2.mo14209a());
        }
        return false;
    }

    /* compiled from: ClassProto.java */
    /* renamed from: org.d.b.a.g$b */
    static class b extends AbstractC1991e implements InterfaceC2267h {

        /* renamed from: a */
        private final InterfaceC2267h f11496a;

        /* renamed from: b */
        private final String f11497b;

        public b(InterfaceC2267h interfaceC2267h, String str) {
            this.f11496a = interfaceC2267h;
            this.f11497b = str;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: a */
        public String mo14209a() {
            return this.f11497b;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: b */
        public String mo14210b() {
            return this.f11496a.mo14210b();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
        /* renamed from: c */
        public List<? extends CharSequence> mo14211c() {
            return this.f11496a.mo14211c();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: d */
        public String mo14212d() {
            return this.f11496a.mo14212d();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: e */
        public List<? extends InterfaceC2269j> mo14213e() {
            return this.f11496a.mo14213e();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: f */
        public int mo14214f() {
            return this.f11496a.mo14214f();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: g */
        public Set<? extends InterfaceC2165a> mo14215g() {
            return this.f11496a.mo14215g();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: h */
        public InterfaceC2268i mo14216h() {
            return this.f11496a.mo14216h();
        }
    }
}
