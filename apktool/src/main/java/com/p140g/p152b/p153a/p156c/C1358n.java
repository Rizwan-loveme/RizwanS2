package com.p140g.p152b.p153a.p156c;

import com.p140g.p141a.C1241c;
import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.EnumC1367h;
import com.p140g.p152b.p153a.p154a.AbstractC1303a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1304b;
import com.p140g.p152b.p153a.p154a.C1305c;
import com.p140g.p152b.p153a.p154a.C1306d;
import com.p140g.p152b.p153a.p154a.C1307e;
import com.p140g.p152b.p153a.p154a.C1309g;
import com.p140g.p152b.p153a.p154a.C1310h;
import com.p140g.p152b.p153a.p154a.C1315m;
import com.p140g.p152b.p153a.p154a.C1316n;
import com.p140g.p152b.p153a.p154a.C1318p;
import com.p140g.p152b.p153a.p154a.C1319q;
import com.p140g.p152b.p153a.p154a.C1320r;
import com.p140g.p152b.p153a.p154a.C1321s;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: TypeTransformer.java */
/* renamed from: com.g.b.a.c.n */
/* loaded from: classes.dex */
public class C1358n {

    /* renamed from: a */
    private static final String[] f8764a = {"B", "S", "C", "I"};

    /* renamed from: a */
    public void m10708a(C1323b c1323b) {
        for (c cVar : new b(c1323b).m10740a()) {
            String m10744a = cVar.m10744a();
            if (m10744a == null) {
                System.err.println(cVar);
            } else {
                if (cVar.f8775a.f8563h == AbstractC1322t.e.CONSTANT) {
                    C1307e c1307e = (C1307e) cVar.f8775a;
                    switch (m10744a.charAt(0)) {
                        case 'D':
                            if (!(c1307e.f8534b instanceof Double)) {
                                c1307e.f8534b = new Double(Double.longBitsToDouble(((Number) c1307e.f8534b).longValue()));
                                break;
                            }
                            break;
                        case 'F':
                            if (!(c1307e.f8534b instanceof Float)) {
                                c1307e.f8534b = new Float(Float.intBitsToFloat(((Number) c1307e.f8534b).intValue()));
                                break;
                            }
                            break;
                        case 'L':
                        case '[':
                            Integer num = 0;
                            if (num.equals(c1307e.f8534b)) {
                                c1307e.f8534b = C1307e.f8533a;
                            }
                            if (m10744a.equals("[F") && (c1307e.f8534b instanceof int[])) {
                                int[] iArr = (int[]) c1307e.f8534b;
                                float[] fArr = new float[iArr.length];
                                for (int i = 0; i < iArr.length; i++) {
                                    fArr[i] = Float.intBitsToFloat(iArr[i]);
                                }
                                c1307e.f8534b = fArr;
                            }
                            if (m10744a.equals("[D") && (c1307e.f8534b instanceof long[])) {
                                long[] jArr = (long[]) c1307e.f8534b;
                                double[] dArr = new double[jArr.length];
                                for (int i2 = 0; i2 < jArr.length; i2++) {
                                    dArr[i2] = Double.longBitsToDouble(jArr[i2]);
                                }
                                c1307e.f8534b = dArr;
                                break;
                            }
                            break;
                    }
                }
                AbstractC1322t abstractC1322t = cVar.f8775a;
                abstractC1322t.f8561f = m10744a;
                abstractC1322t.f8562g = (Object) null;
                cVar.m10749b();
            }
        }
    }

    /* compiled from: TypeTransformer.java */
    /* renamed from: com.g.b.a.c.n$a */
    enum a {
        R_sameValues { // from class: com.g.b.a.c.n.a.1
            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            Set<c> mo10709a(c cVar) {
                return cVar.f8776b;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            void mo10710a(c cVar, Set<c> set) {
                cVar.f8776b = set;
            }
        },
        R_gArrayValues { // from class: com.g.b.a.c.n.a.2
            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            Set<c> mo10709a(c cVar) {
                return cVar.f8777c;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            void mo10710a(c cVar, Set<c> set) {
                cVar.f8777c = set;
            }
        },
        R_sArrayValues { // from class: com.g.b.a.c.n.a.3
            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            Set<c> mo10709a(c cVar) {
                return cVar.f8778d;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            void mo10710a(c cVar, Set<c> set) {
                cVar.f8778d = set;
            }
        },
        R_arrayRoots { // from class: com.g.b.a.c.n.a.4
            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            Set<c> mo10709a(c cVar) {
                return cVar.f8779e;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            void mo10710a(c cVar, Set<c> set) {
                cVar.f8779e = set;
            }
        },
        R_parents { // from class: com.g.b.a.c.n.a.5
            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            Set<c> mo10709a(c cVar) {
                return cVar.f8780f;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            void mo10710a(c cVar, Set<c> set) {
                cVar.f8780f = set;
            }
        },
        R_children { // from class: com.g.b.a.c.n.a.6
            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            Set<c> mo10709a(c cVar) {
                return cVar.f8781g;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1358n.a
            /* renamed from: a */
            void mo10710a(c cVar, Set<c> set) {
                cVar.f8781g = set;
            }
        };

        /* renamed from: a */
        abstract Set<c> mo10709a(c cVar);

        /* renamed from: a */
        abstract void mo10710a(c cVar, Set<c> set);

        public static a valueOf(String str) {
            for (a aVar : values()) {
                if (aVar.name().equals(str)) {
                    return aVar;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: TypeTransformer.java */
    /* renamed from: com.g.b.a.c.n$c */
    public static class c {

        /* renamed from: l */
        private static boolean f8774l;

        /* renamed from: a */
        public final AbstractC1322t f8775a;

        /* renamed from: b */
        public Set<c> f8776b = (Set) null;

        /* renamed from: c */
        public Set<c> f8777c = (Set) null;

        /* renamed from: d */
        public Set<c> f8778d = (Set) null;

        /* renamed from: e */
        public Set<c> f8779e = (Set) null;

        /* renamed from: f */
        public Set<c> f8780f = (Set) null;

        /* renamed from: g */
        public Set<c> f8781g = (Set) null;

        /* renamed from: h */
        public EnumC1367h f8782h = EnumC1367h.UNKNOWN;

        /* renamed from: i */
        public String f8783i = (String) null;

        /* renamed from: j */
        public Set<String> f8784j;

        /* renamed from: k */
        private c f8785k;

        static {
            try {
                f8774l = !Class.forName("com.g.b.a.c.n$c").desiredAssertionStatus();
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }

        /* renamed from: a */
        public void m10745a(c cVar) {
            if (!f8774l && this.f8785k != null) {
                throw new AssertionError();
            }
            c m10743d = cVar.m10743d();
            if (this != m10743d) {
                m10743d.f8785k = this;
                m10741a(this, m10743d, a.R_sameValues);
                m10741a(this, m10743d, a.R_gArrayValues);
                m10741a(this, m10743d, a.R_sArrayValues);
                m10741a(this, m10743d, a.R_arrayRoots);
                m10741a(this, m10743d, a.R_parents);
                m10741a(this, m10743d, a.R_children);
                if (this.f8783i == null) {
                    this.f8783i = m10743d.f8783i;
                } else if (m10743d.f8783i != null) {
                    this.f8783i = b.m10738d(this.f8783i, m10743d.f8783i);
                }
                m10743d.f8783i = (String) null;
                if (m10743d.f8784j != null) {
                    if (this.f8784j == null) {
                        this.f8784j = m10743d.f8784j;
                    } else {
                        this.f8784j.addAll(m10743d.f8784j);
                    }
                    m10743d.f8784j = (Set) null;
                }
            }
        }

        /* renamed from: a */
        private static void m10741a(c cVar, c cVar2, a aVar) {
            Set<c> mo10709a = aVar.mo10709a(cVar2);
            if (mo10709a != null) {
                Set<c> mo10709a2 = aVar.mo10709a(cVar);
                if (mo10709a2 == null) {
                    aVar.mo10710a(cVar, mo10709a);
                } else {
                    mo10709a2.addAll(mo10709a);
                    mo10709a = mo10709a2;
                }
                mo10709a.remove(cVar);
                mo10709a.remove(cVar2);
                aVar.mo10710a(cVar2, (Set) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public c m10743d() {
            c cVar = this;
            while (cVar.f8785k != null) {
                cVar = cVar.f8785k;
            }
            if (cVar != this) {
                this.f8785k = cVar;
            }
            return cVar;
        }

        public c(AbstractC1322t abstractC1322t) {
            this.f8775a = abstractC1322t;
        }

        public String toString() {
            c m10743d = m10743d();
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m10743d.f8782h).append("::").toString()).append(this.f8775a).toString()).append(": ").toString()).append(m10743d.f8783i).toString()).append(" > {").toString()).append((m10743d.f8784j == null ? "[]" : m10743d.f8784j.toString()).substring(1, r0.length() - 1)).toString()).append("}").toString();
        }

        /* renamed from: a */
        public String m10744a() {
            c m10743d = m10743d();
            EnumC1367h enumC1367h = m10743d.f8782h;
            if (enumC1367h == EnumC1367h.OBJECT) {
                if (m10743d.f8783i.length() == 1) {
                    return "Ljava/lang/Object;";
                }
                return m10743d.f8783i;
            }
            if (enumC1367h.f8822p && enumC1367h != EnumC1367h.INT) {
                if (m10743d.f8783i == null) {
                    throw new RuntimeException();
                }
                return m10743d.f8783i;
            }
            if (enumC1367h == EnumC1367h.JD) {
                return "J";
            }
            if (m10743d.f8784j != null) {
                for (String str : C1358n.f8764a) {
                    if (m10743d.f8784j.contains(str)) {
                        return str;
                    }
                }
            }
            if (enumC1367h == EnumC1367h.ZI) {
                return "I";
            }
            if (enumC1367h != EnumC1367h.ZIFL && enumC1367h != EnumC1367h.ZIF && enumC1367h != EnumC1367h.ZIL) {
                if (enumC1367h == EnumC1367h.INT || enumC1367h == EnumC1367h.IF) {
                    return "I";
                }
                throw new RuntimeException();
            }
            return "Z";
        }

        /* renamed from: a */
        public boolean m10746a(EnumC1367h enumC1367h) {
            if (!f8774l && this.f8785k != null) {
                throw new AssertionError();
            }
            EnumC1367h enumC1367h2 = this.f8782h;
            EnumC1367h m10767a = EnumC1367h.m10767a(enumC1367h2, enumC1367h);
            if (m10767a == enumC1367h2) {
                return false;
            }
            this.f8782h = m10767a;
            return true;
        }

        /* renamed from: b */
        public void m10749b() {
            this.f8778d = (Set) null;
            this.f8777c = (Set) null;
            this.f8779e = (Set) null;
            this.f8780f = (Set) null;
            this.f8781g = (Set) null;
            this.f8776b = (Set) null;
        }

        /* renamed from: c */
        String m10750c() {
            return m10743d().f8783i;
        }

        /* renamed from: a */
        public boolean m10747a(String str) {
            if (!f8774l && this.f8785k != null) {
                throw new AssertionError();
            }
            if (this.f8784j != null) {
                return this.f8784j.add(str);
            }
            this.f8784j = new HashSet();
            return this.f8784j.add(str);
        }

        /* renamed from: a */
        public boolean m10748a(Set<String> set) {
            if (!f8774l && this.f8785k != null) {
                throw new AssertionError();
            }
            if (set != null) {
                return set.addAll(set);
            }
            HashSet hashSet = new HashSet();
            return hashSet.addAll(hashSet);
        }
    }

    /* compiled from: TypeTransformer.java */
    /* renamed from: com.g.b.a.c.n$b */
    private static class b {

        /* renamed from: a */
        protected C1323b f8772a;

        /* renamed from: b */
        private List<c> f8773b = new ArrayList();

        public b(C1323b c1323b) {
            this.f8772a = c1323b;
        }

        /* renamed from: a */
        public List<c> m10740a() {
            m10736c();
            m10731b();
            return this.f8773b;
        }

        /* renamed from: b */
        private void m10731b() {
            HashSet hashSet = new HashSet();
            Iterator<c> it = this.f8773b.iterator();
            while (it.hasNext()) {
                c m10743d = it.next().m10743d();
                if (m10743d.f8777c != null || m10743d.f8778d != null) {
                    hashSet.add(m10743d);
                }
                m10725a(m10743d, a.R_gArrayValues);
                m10725a(m10743d, a.R_sArrayValues);
                m10725a(m10743d, a.R_arrayRoots);
            }
            C1360p<c> c1360p = new C1360p<>();
            c1360p.addAll(this.f8773b);
            while (!c1360p.isEmpty()) {
                while (!c1360p.isEmpty()) {
                    m10726a(c1360p, c1360p.poll());
                }
                Iterator<E> it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    c m10743d2 = ((c) it2.next()).m10743d();
                    String str = m10743d2.f8783i;
                    if (str != null && str.charAt(0) == '[') {
                        String substring = str.substring(1);
                        EnumC1367h m10768a = EnumC1367h.m10768a(substring);
                        if (m10743d2.f8777c != null) {
                            Iterator<c> it3 = m10743d2.f8777c.iterator();
                            while (it3.hasNext()) {
                                c m10743d3 = it3.next().m10743d();
                                if (m10743d3.m10746a(m10768a)) {
                                    c1360p.add(m10743d3);
                                }
                                m10727a(substring, m10743d3, c1360p);
                            }
                        }
                        if (m10743d2.f8778d != null) {
                            Iterator<c> it4 = m10743d2.f8778d.iterator();
                            while (it4.hasNext()) {
                                c m10743d4 = it4.next().m10743d();
                                if (m10743d4.m10746a(m10768a)) {
                                    c1360p.add(m10743d4);
                                }
                                if (m10743d4.m10747a(substring)) {
                                    c1360p.add(m10743d4);
                                }
                            }
                        }
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        private void m10725a(c cVar, a aVar) {
            Set<c> mo10709a = aVar.mo10709a(cVar);
            if (mo10709a == null || mo10709a.size() <= 1) {
                return;
            }
            ArrayList arrayList = new ArrayList(mo10709a);
            c m10743d = ((c) arrayList.get(0)).m10743d();
            for (int i = 1; i < arrayList.size(); i++) {
                m10743d.m10745a((c) arrayList.get(i));
            }
        }

        /* renamed from: a */
        private static void m10727a(String str, c cVar, C1360p<c> c1360p) {
            c m10743d = cVar.m10743d();
            if (m10743d.f8783i == null) {
                m10743d.f8783i = str;
                c1360p.add(m10743d);
                return;
            }
            String m10730b = m10730b(str, m10743d.f8783i);
            if (!m10730b.equals(m10743d.f8783i)) {
                m10743d.f8783i = m10730b;
                c1360p.add(m10743d);
            }
        }

        /* renamed from: b */
        private static void m10734b(String str, c cVar, C1360p<c> c1360p) {
            if (cVar.f8783i == null) {
                cVar.f8783i = str;
                c1360p.add(cVar);
                return;
            }
            String m10738d = m10738d(str, cVar.f8783i);
            if (!m10738d.equals(cVar.f8783i)) {
                cVar.f8783i = m10738d;
                c1360p.add(cVar);
            }
        }

        /* renamed from: b */
        private static String m10730b(String str, String str2) {
            int m10711a;
            int m10711a2;
            String str3;
            if (!str.equals(str2) && (m10711a = m10711a(str)) <= (m10711a2 = m10711a(str2))) {
                if (m10711a2 > m10711a) {
                    return str2;
                }
                String substring = str.substring(m10711a);
                String substring2 = str.substring(m10711a2);
                EnumC1367h m10768a = EnumC1367h.m10768a(substring);
                EnumC1367h m10768a2 = EnumC1367h.m10768a(substring2);
                if (!m10768a.f8822p || m10768a2.f8822p) {
                    if (!m10768a.f8822p && m10768a2.f8822p) {
                        return str2;
                    }
                    if (m10768a.f8822p && m10768a2.f8822p) {
                        if (m10768a != m10768a2) {
                            if (m10711a == 0) {
                                throw new RuntimeException();
                            }
                            return m10712a(m10711a - 1, "L");
                        }
                        if (m10768a == EnumC1367h.INT) {
                            int length = C1358n.f8764a.length - 1;
                            while (true) {
                                if (length < 0) {
                                    str3 = "I";
                                    break;
                                }
                                str3 = C1358n.f8764a[length];
                                if (str.equals(str3) || str2.equals(str3)) {
                                    break;
                                }
                                length--;
                            }
                            return m10712a(m10711a, str3);
                        }
                        return m10712a(m10711a, "L");
                    }
                    return m10712a(m10711a, EnumC1367h.m10767a(m10768a, m10768a2).f8821o);
                }
                return str;
            }
            return str;
        }

        /* renamed from: a */
        private void m10726a(C1360p<c> c1360p, c cVar) {
            c m10743d = cVar.m10743d();
            EnumC1367h enumC1367h = m10743d.f8782h;
            if (enumC1367h == EnumC1367h.BOOLEAN || enumC1367h == EnumC1367h.FLOAT || enumC1367h == EnumC1367h.LONG || enumC1367h == EnumC1367h.DOUBLE || enumC1367h == EnumC1367h.VOID) {
                m10743d.f8783i = enumC1367h.f8821o;
            }
            String str = m10743d.f8783i;
            if (str == null && m10743d.f8780f != null && m10743d.f8780f.size() > 1 && m10728a(m10743d)) {
                str = m10714a(m10743d.f8780f);
                m10743d.f8783i = str;
            }
            String str2 = str;
            if (m10743d.f8780f != null) {
                Iterator<c> it = m10743d.f8780f.iterator();
                while (it.hasNext()) {
                    c m10743d2 = it.next().m10743d();
                    if (m10743d2.m10746a(enumC1367h)) {
                        c1360p.add(m10743d2);
                    }
                    if (m10743d.f8784j != null && m10743d2.m10748a(m10743d.f8784j)) {
                        c1360p.add(m10743d2);
                    }
                }
            }
            if (m10743d.f8781g != null) {
                Iterator<c> it2 = m10743d.f8781g.iterator();
                while (it2.hasNext()) {
                    c m10743d3 = it2.next().m10743d();
                    if (m10743d3.m10746a(enumC1367h)) {
                        c1360p.add(m10743d3);
                    }
                    if (str2 != null) {
                        m10734b(str2, m10743d3, c1360p);
                    }
                }
            }
            if (m10743d.f8776b != null) {
                Iterator<c> it3 = m10743d.f8776b.iterator();
                while (it3.hasNext()) {
                    c m10743d4 = it3.next().m10743d();
                    if (m10743d4.m10746a(enumC1367h)) {
                        c1360p.add(m10743d4);
                    }
                }
            }
        }

        /* renamed from: a */
        private boolean m10728a(c cVar) {
            Iterator<c> it = cVar.f8780f.iterator();
            while (it.hasNext()) {
                if (it.next().m10750c() == null) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: c */
        private static String m10735c(String str, String str2) {
            if (str.equals(str2)) {
                return str;
            }
            return "L".endsWith(str) ? str2 : ("L".equals(str2) || str.compareTo(str2) > 0) ? str : str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static String m10738d(String str, String str2) {
            if (!str.equals(str2)) {
                EnumC1367h m10768a = EnumC1367h.m10768a(str);
                EnumC1367h m10768a2 = EnumC1367h.m10768a(str2);
                if (!m10768a.f8822p || m10768a2.f8822p) {
                    if (!m10768a.f8822p && m10768a2.f8822p) {
                        return str2;
                    }
                    if (m10768a.f8822p && m10768a2.f8822p) {
                        if ((m10768a == EnumC1367h.INT && m10768a2 == EnumC1367h.BOOLEAN) || (m10768a2 == EnumC1367h.INT && m10768a == EnumC1367h.BOOLEAN)) {
                            return "I";
                        }
                        if (m10768a != m10768a2) {
                            throw new RuntimeException();
                        }
                        if (m10768a == EnumC1367h.INT) {
                            for (int length = C1358n.f8764a.length - 1; length >= 0; length--) {
                                String str3 = C1358n.f8764a[length];
                                if (str.equals(str3) || str2.equals(str3)) {
                                    return str3;
                                }
                            }
                            return "I";
                        }
                        if (m10768a == EnumC1367h.OBJECT) {
                            int m10711a = m10711a(str);
                            int m10711a2 = m10711a(str2);
                            if (m10711a == 0 || m10711a2 == 0) {
                                return m10735c(str, str2);
                            }
                            String substring = str.substring(m10711a);
                            String substring2 = str.substring(m10711a2);
                            if (m10711a < m10711a2) {
                                if (substring2.charAt(0) != 'L') {
                                    m10711a2--;
                                }
                                return m10712a(m10711a2, "L");
                            }
                            if (m10711a2 > m10711a) {
                                return m10712a(substring.charAt(0) == 'L' ? m10711a : m10711a - 1, "L");
                            }
                            if (substring.charAt(0) != 'L' || substring2.charAt(0) != 'L') {
                                return m10712a(m10711a - 1, "L");
                            }
                            return m10712a(m10711a, "L");
                        }
                        throw new RuntimeException();
                    }
                    return EnumC1367h.m10767a(m10768a, m10768a2).f8821o;
                }
                return str;
            }
            return str;
        }

        /* renamed from: a */
        private static String m10712a(int i, String str) {
            if (i != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < i; i2++) {
                    sb.append('[');
                }
                sb.append(str);
                return sb.toString();
            }
            return str;
        }

        /* renamed from: a */
        private static int m10711a(String str) {
            int i = 0;
            while (str.charAt(i) == '[') {
                i++;
            }
            return i;
        }

        /* renamed from: a */
        private String m10714a(Set<c> set) {
            Iterator<c> it = set.iterator();
            String m10750c = it.next().m10750c();
            while (true) {
                String str = m10750c;
                if (it.hasNext()) {
                    m10750c = m10738d(str, it.next().m10750c());
                } else {
                    return str;
                }
            }
        }

        /* renamed from: a */
        private void m10715a(AbstractC1322t.a aVar, boolean z) {
            AbstractC1322t.e eVar = aVar.f8563h;
            if (eVar != AbstractC1322t.e.LOCAL) {
                if (eVar == AbstractC1322t.e.NEW) {
                    C1315m c1315m = (C1315m) aVar;
                    m10721a(c1315m, c1315m.f8549a);
                    return;
                }
                if (eVar == AbstractC1322t.e.THIS_REF || eVar == AbstractC1322t.e.PARAMETER_REF || eVar == AbstractC1322t.e.EXCEPTION_REF) {
                    C1318p c1318p = (C1318p) aVar;
                    String str = c1318p.f8553b;
                    if (str == null && aVar.f8563h == AbstractC1322t.e.EXCEPTION_REF) {
                        str = "Ljava/lang/Throwable;";
                    }
                    m10721a(c1318p, str);
                    return;
                }
                if (eVar == AbstractC1322t.e.STATIC_FIELD) {
                    C1319q c1319q = (C1319q) aVar;
                    if (z) {
                        m10721a(c1319q, c1319q.f8556c);
                        return;
                    } else {
                        m10733b(c1319q, c1319q.f8556c);
                        return;
                    }
                }
                if (eVar == AbstractC1322t.e.CONSTANT) {
                    C1307e c1307e = (C1307e) aVar;
                    Object obj = c1307e.f8534b;
                    if (obj instanceof String) {
                        m10721a(c1307e, "Ljava/lang/String;");
                        return;
                    }
                    if (obj instanceof C1241c) {
                        m10721a(c1307e, "Ljava/lang/Class;");
                        return;
                    }
                    if (obj instanceof Number) {
                        if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
                            int intValue = ((Number) obj).intValue();
                            if (intValue == 0) {
                                m10721a(c1307e, EnumC1367h.ZIFL.f8821o);
                                return;
                            } else if (intValue == 1) {
                                m10721a(c1307e, EnumC1367h.ZIF.f8821o);
                                return;
                            } else {
                                m10721a(c1307e, EnumC1367h.IF.f8821o);
                                return;
                            }
                        }
                        if (obj instanceof Long) {
                            m10721a(c1307e, "w");
                            return;
                        } else if (obj instanceof Float) {
                            m10721a(c1307e, "F");
                            return;
                        } else {
                            if (obj instanceof Double) {
                                m10721a(c1307e, "D");
                                return;
                            }
                            return;
                        }
                    }
                    if (obj instanceof Character) {
                        m10721a(c1307e, "C");
                    } else {
                        m10721a(c1307e, "L");
                    }
                }
            }
        }

        /* renamed from: a */
        private void m10716a(AbstractC1322t.b bVar, boolean z) {
            AbstractC1322t abstractC1322t = bVar.f8564d;
            AbstractC1322t.e eVar = bVar.f8563h;
            if (eVar == AbstractC1322t.e.CAST) {
                C1306d c1306d = (C1306d) bVar;
                if (c1306d.f8532b.equals("B")) {
                    m10733b(abstractC1322t, EnumC1367h.ZI.f8821o);
                    m10721a(bVar, EnumC1367h.ZI.f8821o);
                } else {
                    m10733b(abstractC1322t, c1306d.f8531a);
                    m10721a(bVar, c1306d.f8532b);
                }
            } else if (eVar == AbstractC1322t.e.FIELD) {
                C1309g c1309g = (C1309g) bVar;
                if (z) {
                    m10721a(c1309g, c1309g.f8537c);
                } else {
                    m10733b(c1309g, c1309g.f8537c);
                }
                if (abstractC1322t != null) {
                    m10733b(abstractC1322t, c1309g.f8536b);
                }
            } else if (eVar == AbstractC1322t.e.CHECK_CAST) {
                C1320r c1320r = (C1320r) bVar;
                m10721a(c1320r, c1320r.f8557a);
                m10733b(abstractC1322t, "L");
            } else if (eVar == AbstractC1322t.e.INSTANCE_OF) {
                m10721a((C1320r) bVar, "Z");
                m10733b(abstractC1322t, "L");
            } else if (eVar == AbstractC1322t.e.NEW_ARRAY) {
                C1320r c1320r2 = (C1320r) bVar;
                m10721a(c1320r2, new StringBuffer().append("[").append(c1320r2.f8557a).toString());
                m10733b(abstractC1322t, "I");
            } else if (eVar == AbstractC1322t.e.LENGTH) {
                m10721a((C1321s) bVar, "I");
                m10733b(abstractC1322t, "[?");
            } else if (eVar == AbstractC1322t.e.NEG || eVar == AbstractC1322t.e.NOT) {
                C1321s c1321s = (C1321s) bVar;
                m10721a(c1321s, c1321s.f8558a);
                m10733b(abstractC1322t, c1321s.f8558a);
            }
            if (abstractC1322t != null) {
                m10719a(abstractC1322t);
            }
        }

        /* renamed from: a */
        private void m10717a(AbstractC1322t.c cVar, boolean z) {
            AbstractC1322t m10548k = cVar.f8565b.m10548k();
            AbstractC1322t m10548k2 = cVar.f8566c.m10548k();
            AbstractC1322t.e eVar = cVar.f8563h;
            if (eVar == AbstractC1322t.e.ARRAY) {
                m10733b(m10548k2, "I");
                String str = ((C1304b) cVar).f8529a;
                m10733b(m10548k, new StringBuffer().append("[").append(str).toString());
                if (z) {
                    m10721a(cVar, str);
                    m10732b(m10548k, cVar);
                } else {
                    m10733b(cVar, str);
                    m10737c(m10548k, cVar);
                }
            } else if (eVar == AbstractC1322t.e.LCMP || eVar == AbstractC1322t.e.FCMPG || eVar == AbstractC1322t.e.FCMPL || eVar == AbstractC1322t.e.DCMPG || eVar == AbstractC1322t.e.DCMPL) {
                C1305c c1305c = (C1305c) cVar;
                m10733b(m10548k, c1305c.f8530a);
                m10733b(m10548k2, c1305c.f8530a);
                m10721a(cVar, "I");
            } else if (eVar == AbstractC1322t.e.EQ || eVar == AbstractC1322t.e.NE) {
                m10733b(cVar.mo10546i(), EnumC1367h.ZIL.f8821o);
                m10733b(cVar.mo10545h(), EnumC1367h.ZIL.f8821o);
                m10720a(cVar.mo10545h(), cVar.mo10546i());
                m10721a(cVar, "Z");
            } else if (eVar == AbstractC1322t.e.GE || eVar == AbstractC1322t.e.GT || eVar == AbstractC1322t.e.LE || eVar == AbstractC1322t.e.LT) {
                C1305c c1305c2 = (C1305c) cVar;
                m10733b(m10548k, c1305c2.f8530a);
                m10733b(m10548k2, c1305c2.f8530a);
                m10721a(cVar, "Z");
            } else if (eVar == AbstractC1322t.e.ADD || eVar == AbstractC1322t.e.SUB || eVar == AbstractC1322t.e.IDIV || eVar == AbstractC1322t.e.LDIV || eVar == AbstractC1322t.e.FDIV || eVar == AbstractC1322t.e.DDIV || eVar == AbstractC1322t.e.MUL || eVar == AbstractC1322t.e.REM) {
                C1305c c1305c3 = (C1305c) cVar;
                m10733b(m10548k, c1305c3.f8530a);
                m10733b(m10548k2, c1305c3.f8530a);
                m10721a(cVar, c1305c3.f8530a);
            } else if (eVar == AbstractC1322t.e.OR || eVar == AbstractC1322t.e.AND || eVar == AbstractC1322t.e.XOR) {
                C1305c c1305c4 = (C1305c) cVar;
                m10733b(m10548k, c1305c4.f8530a);
                m10733b(m10548k2, c1305c4.f8530a);
                if ("J".equals(c1305c4.f8530a) || "w".equals(c1305c4.f8530a)) {
                    m10721a(cVar, c1305c4.f8530a);
                } else {
                    m10721a(cVar, EnumC1367h.ZI.f8821o);
                }
            } else if (eVar == AbstractC1322t.e.SHL || eVar == AbstractC1322t.e.SHR || eVar == AbstractC1322t.e.USHR) {
                C1305c c1305c5 = (C1305c) cVar;
                m10733b(m10548k, c1305c5.f8530a);
                m10733b(m10548k2, "I");
                m10721a(cVar, c1305c5.f8530a);
            } else {
                throw new UnsupportedOperationException();
            }
            if (m10548k != null) {
                m10719a(m10548k);
            }
            if (m10548k2 != null) {
                m10719a(m10548k2);
            }
        }

        /* renamed from: a */
        private void m10720a(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
            c m10729b = m10729b(abstractC1322t);
            c m10729b2 = m10729b(abstractC1322t2);
            if (m10729b.f8776b == null) {
                m10729b.f8776b = new HashSet(3);
            }
            if (m10729b2.f8776b == null) {
                m10729b2.f8776b = new HashSet(3);
            }
            m10729b.f8776b.add(m10729b2);
            m10729b2.f8776b.add(m10729b);
        }

        /* renamed from: a */
        private void m10718a(AbstractC1322t.d dVar) {
            AbstractC1322t[] abstractC1322tArr = dVar.f8567i;
            AbstractC1322t.e eVar = dVar.f8563h;
            if (eVar == AbstractC1322t.e.INVOKE_NEW || eVar == AbstractC1322t.e.INVOKE_INTERFACE || eVar == AbstractC1322t.e.INVOKE_SPECIAL || eVar == AbstractC1322t.e.INVOKE_STATIC || eVar == AbstractC1322t.e.INVOKE_VIRTUAL || eVar == AbstractC1322t.e.INVOKE_POLYMORPHIC || eVar == AbstractC1322t.e.INVOKE_CUSTOM) {
                AbstractC1303a abstractC1303a = (AbstractC1303a) dVar;
                String m10471b = abstractC1303a.mo10479l_().m10471b();
                m10721a(dVar, m10471b);
                m10733b(dVar, m10471b);
                String[] m10470a = abstractC1303a.mo10479l_().m10470a();
                if (m10470a.length == abstractC1322tArr.length) {
                    for (int i = 0; i < abstractC1322tArr.length; i++) {
                        m10733b(abstractC1322tArr[i], m10470a[i]);
                    }
                } else if (m10470a.length + 1 == abstractC1322tArr.length) {
                    m10733b(abstractC1322tArr[0], "L");
                    for (int i2 = 1; i2 < abstractC1322tArr.length; i2++) {
                        m10733b(abstractC1322tArr[i2], m10470a[i2 - 1]);
                    }
                } else {
                    throw new RuntimeException();
                }
            } else if (eVar == AbstractC1322t.e.FILLED_ARRAY) {
                C1310h c1310h = (C1310h) dVar;
                for (AbstractC1322t abstractC1322t : abstractC1322tArr) {
                    m10733b(abstractC1322t, c1310h.f8538a);
                }
                m10721a(c1310h, new StringBuffer().append("[").append(c1310h.f8538a).toString());
            } else if (eVar == AbstractC1322t.e.NEW_MUTI_ARRAY) {
                C1316n c1316n = (C1316n) dVar;
                for (AbstractC1322t abstractC1322t2 : abstractC1322tArr) {
                    m10733b(abstractC1322t2, "I");
                }
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < c1316n.f8551b; i3++) {
                    sb.append('[');
                }
                sb.append(c1316n.f8550a);
                m10721a(c1316n, sb.toString());
            } else if (eVar == AbstractC1322t.e.PHI) {
                for (AbstractC1322t abstractC1322t3 : abstractC1322tArr) {
                    m10739d(abstractC1322t3, dVar);
                }
            }
            for (AbstractC1322t abstractC1322t4 : dVar.f8567i) {
                m10719a(abstractC1322t4);
            }
        }

        /* renamed from: a */
        private void m10719a(AbstractC1322t abstractC1322t) {
            m10722a(abstractC1322t, true);
        }

        /* renamed from: a */
        private void m10722a(AbstractC1322t abstractC1322t, boolean z) {
            EnumC1302a enumC1302a = abstractC1322t.f8560e;
            if (enumC1302a == EnumC1302a.E0) {
                m10715a((AbstractC1322t.a) abstractC1322t, z);
                return;
            }
            if (enumC1302a == EnumC1302a.E1) {
                m10716a((AbstractC1322t.b) abstractC1322t, z);
            } else if (enumC1302a == EnumC1302a.E2) {
                m10717a((AbstractC1322t.c) abstractC1322t, z);
            } else if (enumC1302a == EnumC1302a.En) {
                m10718a((AbstractC1322t.d) abstractC1322t);
            }
        }

        /* renamed from: b */
        private c m10729b(AbstractC1322t abstractC1322t) {
            Object obj = abstractC1322t.f8562g;
            if (obj == null || !(obj instanceof c)) {
                c cVar = new c(abstractC1322t);
                this.f8773b.add(cVar);
                abstractC1322t.f8562g = cVar;
                return cVar;
            }
            return (c) obj;
        }

        /* renamed from: b */
        private void m10732b(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
            c m10729b = m10729b(abstractC1322t);
            c m10729b2 = m10729b(abstractC1322t2);
            if (m10729b.f8777c == null) {
                m10729b.f8777c = new HashSet(3);
            }
            m10729b.f8777c.add(m10729b2);
            if (m10729b2.f8779e == null) {
                m10729b2.f8779e = new HashSet(3);
            }
            m10729b2.f8779e.add(m10729b);
        }

        /* renamed from: c */
        private void m10737c(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
            c m10729b = m10729b(abstractC1322t);
            c m10729b2 = m10729b(abstractC1322t2);
            if (m10729b.f8778d == null) {
                m10729b.f8778d = new HashSet(3);
            }
            m10729b.f8778d.add(m10729b2);
            if (m10729b2.f8779e == null) {
                m10729b2.f8779e = new HashSet(3);
            }
            m10729b2.f8779e.add(m10729b);
        }

        /* renamed from: d */
        private void m10739d(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
            c m10729b = m10729b(abstractC1322t);
            c m10729b2 = m10729b(abstractC1322t2);
            if (m10729b.f8781g == null) {
                m10729b.f8781g = new HashSet();
            }
            m10729b.f8781g.add(m10729b2);
            if (m10729b2.f8780f == null) {
                m10729b2.f8780f = new HashSet();
            }
            m10729b2.f8780f.add(m10729b);
        }

        /* renamed from: a */
        private void m10721a(AbstractC1322t abstractC1322t, String str) {
            c m10743d = m10729b(abstractC1322t).m10743d();
            m10743d.f8783i = str;
            m10743d.m10746a(EnumC1367h.m10768a(str));
        }

        /* renamed from: a */
        private void m10723a(AbstractC1333j.b bVar) {
            if (bVar.f8650n != AbstractC1333j.d.GOTO) {
                AbstractC1322t abstractC1322t = bVar.f8651d;
                AbstractC1333j.d dVar = bVar.f8650n;
                if (dVar == AbstractC1333j.d.LOOKUP_SWITCH || dVar == AbstractC1333j.d.TABLE_SWITCH) {
                    m10733b(abstractC1322t, "I");
                } else if (dVar != AbstractC1333j.d.GOTO) {
                    if (dVar == AbstractC1333j.d.IF) {
                        m10733b(abstractC1322t, "Z");
                    } else if (dVar == AbstractC1333j.d.LOCK || dVar == AbstractC1333j.d.UNLOCK) {
                        m10733b(abstractC1322t, "L");
                    } else if (dVar == AbstractC1333j.d.THROW) {
                        m10733b(abstractC1322t, "Ljava/lang/Throwable;");
                    } else if (dVar == AbstractC1333j.d.RETURN) {
                        m10733b(abstractC1322t, this.f8772a.f8627f);
                    }
                }
                m10719a(abstractC1322t);
            }
        }

        /* renamed from: a */
        private void m10724a(AbstractC1333j.c cVar) {
            if (cVar.f8650n == AbstractC1333j.d.FILL_ARRAY_DATA) {
                m10739d(cVar.f8652a, cVar.f8653b);
                return;
            }
            AbstractC1322t abstractC1322t = cVar.f8653b;
            AbstractC1322t abstractC1322t2 = cVar.f8652a;
            m10739d(abstractC1322t, abstractC1322t2);
            m10719a(abstractC1322t);
            m10722a(abstractC1322t2, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.g.b.a.b.j] */
        /* renamed from: c */
        private void m10736c() {
            for (AbstractC1333j.c cVar = this.f8772a.f8628g.m10574a(); cVar != null; cVar = cVar.m10559b()) {
                EnumC1302a enumC1302a = cVar.f8645i;
                if (enumC1302a == EnumC1302a.E0) {
                    if (cVar.f8650n == AbstractC1333j.d.LABEL) {
                        C1329f c1329f = (C1329f) cVar;
                        if (c1329f.f8638c != null) {
                            Iterator<C1324a> it = c1329f.f8638c.iterator();
                            while (it.hasNext()) {
                                m10724a(it.next());
                            }
                        }
                    }
                } else if (enumC1302a == EnumC1302a.E1) {
                    m10723a((AbstractC1333j.b) cVar);
                } else if (enumC1302a == EnumC1302a.E2) {
                    m10724a(cVar);
                } else if (enumC1302a == EnumC1302a.En) {
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<c> it = this.f8773b.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append("\n");
            }
            return sb.toString();
        }

        /* renamed from: b */
        private void m10733b(AbstractC1322t abstractC1322t, String str) {
            c m10729b = m10729b(abstractC1322t);
            m10729b.m10747a(str);
            m10729b.m10746a(EnumC1367h.m10768a(str));
        }
    }
}
