package jadx.core.p183c.p193e.p194a;

import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.EnumC1618i;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: IfCondition.java */
/* renamed from: jadx.core.c.e.a.b */
/* loaded from: classes.dex */
public final class C1653b {

    /* renamed from: d */
    private static /* synthetic */ int[] f10418d;

    /* renamed from: a */
    private final a f10419a;

    /* renamed from: b */
    private final List<C1653b> f10420b;

    /* renamed from: c */
    private final C1652a f10421c;

    /* compiled from: IfCondition.java */
    /* renamed from: jadx.core.c.e.a.b$a */
    public enum a {
        COMPARE,
        TERNARY,
        NOT,
        AND,
        OR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            int length = valuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    /* renamed from: i */
    static /* synthetic */ int[] m12684i() {
        int[] iArr = f10418d;
        if (iArr == null) {
            iArr = new int[a.valuesCustom().length];
            try {
                iArr[a.AND.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.COMPARE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[a.NOT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[a.OR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[a.TERNARY.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            f10418d = iArr;
        }
        return iArr;
    }

    private C1653b(C1652a c1652a) {
        this.f10419a = a.COMPARE;
        this.f10421c = c1652a;
        this.f10420b = Collections.emptyList();
    }

    private C1653b(a aVar, List<C1653b> list) {
        this.f10419a = aVar;
        this.f10420b = list;
        this.f10421c = null;
    }

    private C1653b(C1653b c1653b) {
        this.f10419a = c1653b.f10419a;
        this.f10421c = c1653b.f10421c;
        if (c1653b.f10419a == a.COMPARE) {
            this.f10420b = Collections.emptyList();
        } else {
            this.f10420b = new ArrayList(c1653b.f10420b);
        }
    }

    /* renamed from: a */
    public static C1653b m12677a(C1628a c1628a) {
        if (c1628a == null) {
            return null;
        }
        return m12676a((C1617h) c1628a.mo12446j().get(0));
    }

    /* renamed from: a */
    public static C1653b m12676a(C1617h c1617h) {
        return new C1653b(new C1652a(c1617h));
    }

    /* renamed from: a */
    public static C1653b m12679a(C1653b c1653b, C1653b c1653b2, C1653b c1653b3) {
        return new C1653b(a.TERNARY, Arrays.asList(c1653b, c1653b2, c1653b3));
    }

    /* renamed from: a */
    public static C1653b m12678a(a aVar, C1653b c1653b, C1653b c1653b2) {
        if (c1653b.m12685a() != aVar) {
            return new C1653b(aVar, Arrays.asList(c1653b, c1653b2));
        }
        C1653b c1653b3 = new C1653b(c1653b);
        c1653b3.m12686a(c1653b2);
        return c1653b3;
    }

    /* renamed from: a */
    public a m12685a() {
        return this.f10419a;
    }

    /* renamed from: b */
    public List<C1653b> m12687b() {
        return this.f10420b;
    }

    /* renamed from: c */
    public C1653b m12688c() {
        return this.f10420b.get(0);
    }

    /* renamed from: d */
    public C1653b m12689d() {
        return this.f10420b.get(1);
    }

    /* renamed from: e */
    public C1653b m12690e() {
        return this.f10420b.get(2);
    }

    /* renamed from: a */
    public void m12686a(C1653b c1653b) {
        this.f10420b.add(c1653b);
    }

    /* renamed from: f */
    public boolean m12691f() {
        return this.f10419a == a.COMPARE;
    }

    /* renamed from: g */
    public C1652a m12692g() {
        return this.f10421c;
    }

    /* renamed from: b */
    public static C1653b m12681b(C1653b c1653b) {
        a m12685a = c1653b.m12685a();
        switch (m12684i()[m12685a.ordinal()]) {
            case 1:
                return new C1653b(c1653b.m12692g().m12674e());
            case 2:
                return m12679a(m12682c(c1653b.m12688c()), c1653b.m12690e(), c1653b.m12689d());
            case 3:
                return c1653b.m12688c();
            case 4:
            case 5:
                List<C1653b> m12687b = c1653b.m12687b();
                ArrayList arrayList = new ArrayList(m12687b.size());
                Iterator<C1653b> it = m12687b.iterator();
                while (it.hasNext()) {
                    arrayList.add(m12681b(it.next()));
                }
                return new C1653b(m12685a == a.AND ? a.OR : a.AND, arrayList);
            default:
                throw new C1729f("Unknown mode for invert: " + m12685a);
        }
    }

    /* renamed from: c */
    public static C1653b m12682c(C1653b c1653b) {
        return c1653b.m12685a() == a.NOT ? c1653b.m12688c() : new C1653b(a.NOT, Collections.singletonList(c1653b));
    }

    /* renamed from: d */
    public static C1653b m12683d(C1653b c1653b) {
        int size;
        ArrayList arrayList;
        int i = 0;
        if (c1653b.m12691f()) {
            C1652a m12692g = c1653b.m12692g();
            m12680a(m12692g);
            if (m12692g.m12670a() == EnumC1618i.EQ && m12692g.m12672c().mo12311i() && m12692g.m12672c().equals(C1600e.f10162c)) {
                c1653b = m12682c(new C1653b(m12692g.m12674e()));
            } else {
                m12692g.m12675f();
            }
        }
        ArrayList arrayList2 = null;
        int i2 = 0;
        while (i2 < c1653b.m12687b().size()) {
            C1653b c1653b2 = c1653b.m12687b().get(i2);
            C1653b m12683d = m12683d(c1653b2);
            if (m12683d != c1653b2) {
                arrayList = arrayList2 == null ? new ArrayList(c1653b.m12687b()) : arrayList2;
                arrayList.set(i2, m12683d);
            } else {
                arrayList = arrayList2;
            }
            i2++;
            arrayList2 = arrayList;
        }
        if (arrayList2 != null) {
            c1653b = new C1653b(c1653b.m12685a(), arrayList2);
        }
        if (c1653b.m12685a() == a.NOT && c1653b.m12688c().m12685a() == a.NOT) {
            c1653b = m12681b(c1653b.m12688c());
        }
        if (c1653b.m12685a() == a.TERNARY && c1653b.m12688c().m12685a() == a.NOT) {
            c1653b = m12681b(c1653b);
        }
        if ((c1653b.m12685a() == a.OR || c1653b.m12685a() == a.AND) && (size = c1653b.m12687b().size()) > 1) {
            for (C1653b c1653b3 : c1653b.m12687b()) {
                if (c1653b3.m12685a() == a.NOT || (c1653b3.m12691f() && c1653b3.m12692g().m12670a() == EnumC1618i.NE)) {
                    i++;
                }
            }
            if (i > size / 2) {
                return m12682c(m12681b(c1653b));
            }
            return c1653b;
        }
        return c1653b;
    }

    /* renamed from: a */
    private static void m12680a(C1652a c1652a) {
        if (c1652a.m12671b().mo12312j() && c1652a.m12672c().mo12311i() && ((C1600e) c1652a.m12672c()).m12317d() == 0) {
            C1646l m12316d = ((C1599d) c1652a.m12671b()).m12316d();
            EnumC1621l m12587o = m12316d.m12587o();
            if (m12587o == EnumC1621l.CMP_L || m12587o == EnumC1621l.CMP_G) {
                C1617h m12673d = c1652a.m12673d();
                m12673d.m12384a(m12673d.m12387h(), m12316d.mo12426d(0), m12316d.mo12426d(1));
            }
        }
    }

    /* renamed from: h */
    public List<C1604i> m12693h() {
        LinkedList linkedList = new LinkedList();
        if (this.f10419a == a.COMPARE) {
            this.f10421c.m12673d().mo12372a(linkedList);
        } else {
            Iterator<C1653b> it = this.f10420b.iterator();
            while (it.hasNext()) {
                linkedList.addAll(it.next().m12693h());
            }
        }
        return linkedList;
    }

    public String toString() {
        switch (m12684i()[this.f10419a.ordinal()]) {
            case 1:
                return this.f10421c.toString();
            case 2:
                return m12688c() + " ? " + m12689d() + " : " + m12690e();
            case 3:
                return "!(" + m12688c() + ")";
            case 4:
            case 5:
                String str = this.f10419a == a.OR ? " || " : " && ";
                StringBuilder sb = new StringBuilder();
                sb.append('(');
                Iterator<C1653b> it = this.f10420b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    if (it.hasNext()) {
                        sb.append(str);
                    }
                }
                sb.append(')');
                return sb.toString();
            default:
                return "??";
        }
    }
}
