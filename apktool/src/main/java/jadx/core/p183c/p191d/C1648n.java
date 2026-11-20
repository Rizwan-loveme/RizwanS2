package jadx.core.p183c.p191d;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.C1583c;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.AbstractC1577k;
import jadx.core.p183c.p184a.p186b.C1576j;
import jadx.core.p183c.p184a.p186b.C1578l;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1616g;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.C1620k;
import jadx.core.p183c.p188c.C1626q;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p188c.p189a.C1606k;
import jadx.core.p183c.p191d.p192a.C1634f;
import jadx.core.p183c.p193e.C1656b;
import jadx.core.p183c.p196f.C1665b;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p183c.p196f.C1668e;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1745n;
import jadx.core.p203d.p205b.C1725b;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: MethodNode.java */
/* renamed from: jadx.core.c.d.n */
/* loaded from: classes.dex */
public class C1648n extends AbstractC1577k implements InterfaceC1643i {

    /* renamed from: a */
    private static final InterfaceC2558b f10374a = C2568c.m15995a((Class<?>) C1648n.class);

    /* renamed from: w */
    private static /* synthetic */ int[] f10375w;

    /* renamed from: b */
    private final C1594f f10376b;

    /* renamed from: c */
    private final C1636b f10377c;

    /* renamed from: d */
    private final C1589a f10378d;

    /* renamed from: e */
    private final InterfaceC2268i f10379e;

    /* renamed from: f */
    private int f10380f;

    /* renamed from: g */
    private C1646l[] f10381g;

    /* renamed from: h */
    private int f10382h;

    /* renamed from: i */
    private boolean f10383i;

    /* renamed from: j */
    private boolean f10384j;

    /* renamed from: k */
    private AbstractC1596a f10385k;

    /* renamed from: l */
    private C1604i f10386l;

    /* renamed from: m */
    private List<C1604i> f10387m;

    /* renamed from: n */
    private final List<? extends InterfaceC2269j> f10388n;

    /* renamed from: p */
    private Map<AbstractC1596a, List<AbstractC1596a>> f10390p;

    /* renamed from: q */
    private List<C1628a> f10391q;

    /* renamed from: r */
    private C1628a f10392r;

    /* renamed from: s */
    private List<C1628a> f10393s;

    /* renamed from: t */
    private C1656b f10394t;

    /* renamed from: o */
    private List<C1605j> f10389o = Collections.emptyList();

    /* renamed from: u */
    private List<C1666c> f10395u = Collections.emptyList();

    /* renamed from: v */
    private List<C1578l> f10396v = Collections.emptyList();

    /* renamed from: P */
    static /* synthetic */ int[] m12596P() {
        int[] iArr = f10375w;
        if (iArr == null) {
            iArr = new int[EnumC1621l.valuesCustom().length];
            try {
                iArr[EnumC1621l.AGET.ordinal()] = 24;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1621l.APUT.ordinal()] = 25;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC1621l.ARITH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC1621l.ARRAY_LENGTH.ordinal()] = 21;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC1621l.BREAK.ordinal()] = 36;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumC1621l.CAST.ordinal()] = 8;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EnumC1621l.CHECK_CAST.ordinal()] = 19;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EnumC1621l.CMP_G.ordinal()] = 14;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EnumC1621l.CMP_L.ordinal()] = 13;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EnumC1621l.CONST.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EnumC1621l.CONSTRUCTOR.ordinal()] = 35;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[EnumC1621l.CONST_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[EnumC1621l.CONST_STR.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[EnumC1621l.CONTINUE.ordinal()] = 37;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[EnumC1621l.FILLED_NEW_ARRAY.ordinal()] = 23;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[EnumC1621l.FILL_ARRAY.ordinal()] = 22;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[EnumC1621l.GOTO.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[EnumC1621l.IF.ordinal()] = 15;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[EnumC1621l.IGET.ordinal()] = 28;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[EnumC1621l.INSTANCE_OF.ordinal()] = 20;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[EnumC1621l.INVOKE.ordinal()] = 32;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[EnumC1621l.IPUT.ordinal()] = 29;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[EnumC1621l.MERGE.ordinal()] = 41;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[EnumC1621l.MONITOR_ENTER.ordinal()] = 17;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[EnumC1621l.MONITOR_EXIT.ordinal()] = 18;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[EnumC1621l.MOVE.ordinal()] = 7;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[EnumC1621l.MOVE_EXCEPTION.ordinal()] = 12;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[EnumC1621l.NEG.ordinal()] = 5;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[EnumC1621l.NEW_ARRAY.ordinal()] = 26;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[EnumC1621l.NEW_INSTANCE.ordinal()] = 27;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[EnumC1621l.NEW_MULTIDIM_ARRAY.ordinal()] = 42;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr[EnumC1621l.NOP.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr[EnumC1621l.NOT.ordinal()] = 6;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr[EnumC1621l.ONE_ARG.ordinal()] = 39;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr[EnumC1621l.PHI.ordinal()] = 40;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr[EnumC1621l.RETURN.ordinal()] = 9;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr[EnumC1621l.SGET.ordinal()] = 30;
            } catch (NoSuchFieldError e38) {
            }
            try {
                iArr[EnumC1621l.SPUT.ordinal()] = 31;
            } catch (NoSuchFieldError e39) {
            }
            try {
                iArr[EnumC1621l.STR_CONCAT.ordinal()] = 38;
            } catch (NoSuchFieldError e40) {
            }
            try {
                iArr[EnumC1621l.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError e41) {
            }
            try {
                iArr[EnumC1621l.TERNARY.ordinal()] = 34;
            } catch (NoSuchFieldError e42) {
            }
            try {
                iArr[EnumC1621l.THROW.ordinal()] = 11;
            } catch (NoSuchFieldError e43) {
            }
            f10375w = iArr;
        }
        return iArr;
    }

    public C1648n(C1636b c1636b, InterfaceC2267h interfaceC2267h, boolean z) {
        this.f10376b = C1594f.m12238a(c1636b.mo12540t(), interfaceC2267h);
        this.f10377c = c1636b;
        this.f10378d = new C1589a(interfaceC2267h.mo14214f(), C1589a.a.METHOD);
        this.f10388n = interfaceC2267h.mo14213e();
        InterfaceC2268i mo14216h = interfaceC2267h.mo14216h();
        this.f10383i = mo14216h == null;
        this.f10379e = mo14216h;
        this.f10384j = z;
    }

    /* renamed from: f */
    public void m12631f() {
        try {
            if (this.f10383i) {
                this.f10380f = 0;
                this.f10382h = 0;
                m12597Q();
                return;
            }
            InterfaceC2268i interfaceC2268i = this.f10379e;
            this.f10380f = interfaceC2268i.mo14611d();
            m12597Q();
            C1620k c1620k = new C1620k(this);
            c1620k.m12414a(interfaceC2268i.mo14608b());
            this.f10381g = c1620k.m12415a();
            this.f10382h = this.f10381g.length;
            m12602b(interfaceC2268i.mo14612e());
            m12599S();
        } catch (Exception e2) {
            if (!this.f10383i) {
                this.f10383i = true;
                m12631f();
                this.f10383i = false;
            }
            throw new C1725b(this, "Load method exception: " + e2.getMessage(), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public void m12632g() {
        ArrayList arrayList = new ArrayList();
        for (C1646l c1646l : this.f10381g) {
            if (c1646l != null) {
                arrayList.clear();
                C1604i m12588p = c1646l.m12588p();
                if (m12588p != null) {
                    arrayList.add(m12588p);
                }
                c1646l.mo12372a(arrayList);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (((C1604i) arrayList.get(i)).m12330o() >= this.f10380f) {
                        throw new C1729f("Incorrect register number in instruction: " + c1646l + ", expected to be less than " + this.f10380f);
                    }
                }
            }
        }
    }

    /* renamed from: Q */
    private void m12597Q() {
        if (!m12598R()) {
            this.f10385k = this.f10376b.m12246e();
            m12600a(this.f10376b.m12247f());
        }
    }

    /* renamed from: h */
    public void m12633h() {
        if (!this.f10383i) {
            this.f10381g = null;
            this.f10391q = null;
            this.f10392r = null;
            this.f10393s = null;
            this.f10395u = Collections.emptyList();
            this.f10389o.clear();
            this.f10394t = null;
            this.f10396v = Collections.emptyList();
        }
    }

    /* renamed from: R */
    private boolean m12598R() {
        C1634f m12485a = C1634f.m12485a(this);
        if (m12485a == null) {
            return false;
        }
        try {
            this.f10390p = m12485a.m12500b();
            List<AbstractC1596a> m12501c = m12485a.m12501c();
            this.f10385k = m12485a.m12499a();
            List<AbstractC1596a> m12247f = this.f10376b.m12247f();
            if (m12501c.size() != m12247f.size()) {
                if (m12501c.isEmpty()) {
                    return false;
                }
                if (!this.f10376b.m12249h()) {
                    f10374a.mo15939b("Wrong signature parse result: {} -> {}, not generic version: {}", m12485a, m12501c, m12247f);
                    return false;
                }
                if (m12640o().m12539s().m12182k()) {
                    m12501c.add(0, m12247f.get(0));
                    m12501c.add(1, m12247f.get(1));
                } else {
                    m12501c.add(0, m12247f.get(0));
                }
                if (m12501c.size() != m12247f.size()) {
                    return false;
                }
            }
            m12600a(m12501c);
            return true;
        } catch (C1729f e2) {
            f10374a.mo15943c("Method signature parse error: {}", this, e2);
            return false;
        }
    }

    /* renamed from: a */
    private void m12600a(List<AbstractC1596a> list) {
        int i;
        if (this.f10383i) {
            i = 1;
        } else {
            int i2 = this.f10380f;
            Iterator<AbstractC1596a> it = list.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                } else {
                    i2 = i - it.next().m12292r();
                }
            }
        }
        if (this.f10378d.m12179h()) {
            this.f10386l = null;
        } else {
            C1606k m12305b = AbstractC1598c.m12305b(i - 1, this.f10377c.m12544x().m12211m());
            m12305b.mo12141a(EnumC1562a.THIS);
            this.f10386l = m12305b;
        }
        if (list.isEmpty()) {
            this.f10387m = Collections.emptyList();
            return;
        }
        this.f10387m = new ArrayList(list.size());
        Iterator<AbstractC1596a> it2 = list.iterator();
        int i3 = 0;
        while (true) {
            int i4 = i;
            if (it2.hasNext()) {
                AbstractC1596a next = it2.next();
                C1606k m12305b2 = AbstractC1598c.m12305b(i4, next);
                m12305b2.mo12319a_(this.f10388n.get(i3).mo14220b());
                this.f10387m.add(m12305b2);
                i = i4 + next.m12292r();
                i3++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public List<C1604i> m12620a(boolean z) {
        if (!z || this.f10386l == null) {
            return this.f10387m;
        }
        ArrayList arrayList = new ArrayList(this.f10387m.size() + 1);
        arrayList.add(this.f10386l);
        arrayList.addAll(this.f10387m);
        return arrayList;
    }

    /* renamed from: i */
    public C1604i m12634i() {
        mo12141a(EnumC1562a.SKIP_FIRST_ARG);
        return this.f10387m.remove(0);
    }

    /* renamed from: j */
    public C1604i m12635j() {
        return this.f10386l;
    }

    /* renamed from: k */
    public AbstractC1596a m12636k() {
        return this.f10385k;
    }

    /* renamed from: l */
    public Map<AbstractC1596a, List<AbstractC1596a>> m12637l() {
        return this.f10390p;
    }

    /* renamed from: b */
    private void m12602b(List<? extends InterfaceC2271l<? extends InterfaceC2265f>> list) {
        C1646l[] c1646lArr = this.f10381g;
        if (!list.isEmpty()) {
            HashSet hashSet = new HashSet();
            ArrayList<C1668e> arrayList = new ArrayList(list.size());
            int i = 0;
            for (InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l : list) {
                C1668e c1668e = new C1668e();
                arrayList.add(c1668e);
                Iterator<? extends Object> it = interfaceC2271l.mo14516c().iterator();
                int i2 = i;
                while (it.hasNext()) {
                    InterfaceC2265f interfaceC2265f = (InterfaceC2265f) it.next();
                    int mo14477c = interfaceC2265f.mo14477c();
                    c1668e.m12768a(this, mo14477c, interfaceC2265f.mo14450a() == null ? null : C1590b.m12191a(this.f10377c.mo12540t(), interfaceC2265f.mo14450a()));
                    hashSet.add(Integer.valueOf(mo14477c));
                    i2++;
                }
                int mo14514a = interfaceC2271l.mo14514a();
                int mo14515b = (interfaceC2271l.mo14515b() + mo14514a) - 1;
                C1646l c1646l = c1646lArr[mo14514a];
                c1646l.mo12141a(EnumC1562a.TRY_ENTER);
                while (mo14514a <= mo14515b && mo14514a >= 0) {
                    c1646l = c1646lArr[mo14514a];
                    c1668e.m12770a(c1646l);
                    mo14514a = C1620k.m12396a(c1646lArr, mo14514a);
                }
                if (c1646lArr[mo14515b] != null) {
                    c1646lArr[mo14515b].mo12141a(EnumC1562a.TRY_LEAVE);
                    i = i2;
                } else {
                    c1646l.mo12141a(EnumC1562a.TRY_LEAVE);
                    i = i2;
                }
            }
            if (i > 0 && i != hashSet.size()) {
                for (C1668e c1668e2 : arrayList) {
                    for (C1668e c1668e3 : arrayList) {
                        if (c1668e2 != c1668e3 && c1668e3.m12775a(c1668e2)) {
                            for (C1666c c1666c : c1668e2.m12769a()) {
                                c1668e3.m12773a(this, c1666c);
                                c1666c.m12754a(c1668e2);
                            }
                        }
                    }
                }
            }
            hashSet.clear();
            for (C1668e c1668e4 : arrayList) {
                for (C1666c c1666c2 : c1668e4.m12769a()) {
                    c1646lArr[c1666c2.m12758c()].mo12144a(new C1665b(c1668e4, c1666c2));
                }
            }
        }
    }

    /* renamed from: S */
    private void m12599S() {
        C1646l[] c1646lArr = this.f10381g;
        for (int i = 0; i < c1646lArr.length; i++) {
            C1646l c1646l = c1646lArr[i];
            if (c1646l != null) {
                switch (m12596P()[c1646l.m12587o().ordinal()]) {
                    case 10:
                        m12601a(c1646lArr, i, ((C1616g) c1646l).mo12383f());
                        break;
                    case 15:
                        int m12396a = C1620k.m12396a(c1646lArr, i);
                        if (m12396a != -1) {
                            m12601a(c1646lArr, i, m12396a);
                        }
                        m12601a(c1646lArr, i, ((C1617h) c1646l).mo12383f());
                        break;
                    case 16:
                        int[] m12429i = ((C1626q) c1646l).m12429i();
                        for (int i2 : m12429i) {
                            m12601a(c1646lArr, i, i2);
                        }
                        int m12396a2 = C1620k.m12396a(c1646lArr, i);
                        if (m12396a2 != -1) {
                            m12601a(c1646lArr, i, m12396a2);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12601a(C1646l[] c1646lArr, int i, int i2) {
        c1646lArr[i2].mo12142a((C1566b<C1583c<C1566b<C1583c<C1576j>>>>) C1566b.f10027a, (C1566b<C1583c<C1576j>>) new C1576j(i, i2));
    }

    /* renamed from: m */
    public String m12638m() {
        return this.f10376b.m12239a();
    }

    /* renamed from: n */
    public String m12639n() {
        return this.f10376b.m12251j();
    }

    /* renamed from: o */
    public C1636b m12640o() {
        return this.f10377c;
    }

    /* renamed from: p */
    public boolean m12641p() {
        return this.f10383i;
    }

    /* renamed from: q */
    public int m12642q() {
        return this.f10382h;
    }

    /* renamed from: r */
    public C1646l[] m12643r() {
        return this.f10381g;
    }

    /* renamed from: s */
    public void m12644s() {
        this.f10381g = null;
    }

    /* renamed from: w */
    public void m12645w() {
        this.f10391q = new ArrayList();
        this.f10393s = new ArrayList(1);
    }

    /* renamed from: x */
    public void m12646x() {
        this.f10391q = C1745n.m13314a((List) this.f10391q);
        this.f10393s = C1745n.m13314a((List) this.f10393s);
        this.f10396v = C1745n.m13314a((List) this.f10396v);
        Iterator<C1628a> it = this.f10391q.iterator();
        while (it.hasNext()) {
            it.next().m12445i();
        }
    }

    /* renamed from: y */
    public List<C1628a> m12647y() {
        return this.f10391q;
    }

    /* renamed from: z */
    public C1628a m12648z() {
        return this.f10392r;
    }

    /* renamed from: a */
    public void m12623a(C1628a c1628a) {
        this.f10392r = c1628a;
    }

    /* renamed from: A */
    public List<C1628a> m12603A() {
        return this.f10393s;
    }

    /* renamed from: b */
    public void m12626b(C1628a c1628a) {
        this.f10393s.add(c1628a);
    }

    /* renamed from: a */
    public void m12621a(C1578l c1578l) {
        if (this.f10396v.isEmpty()) {
            this.f10396v = new ArrayList(5);
        }
        c1578l.m12125a(this.f10396v.size());
        this.f10396v.add(c1578l);
    }

    /* renamed from: c */
    public C1578l m12629c(C1628a c1628a) {
        if (this.f10396v.isEmpty()) {
            return null;
        }
        for (C1578l c1578l : this.f10396v) {
            if (c1578l.m12128c().contains(c1628a)) {
                return c1578l;
            }
        }
        return null;
    }

    /* renamed from: d */
    public List<C1578l> m12630d(C1628a c1628a) {
        if (this.f10396v.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f10396v.size());
        for (C1578l c1578l : this.f10396v) {
            if (c1578l.m12128c().contains(c1628a)) {
                arrayList.add(c1578l);
            }
        }
        return arrayList;
    }

    /* renamed from: B */
    public int m12604B() {
        return this.f10396v.size();
    }

    /* renamed from: C */
    public Iterable<C1578l> m12605C() {
        return this.f10396v;
    }

    /* renamed from: a */
    public C1666c m12619a(C1666c c1666c) {
        if (this.f10395u.isEmpty()) {
            this.f10395u = new ArrayList(2);
        } else {
            Iterator<C1666c> it = this.f10395u.iterator();
            while (it.hasNext()) {
                C1666c next = it.next();
                if (next == c1666c || next.m12758c() == c1666c.m12758c()) {
                    return next;
                }
            }
        }
        this.f10395u.add(c1666c);
        return c1666c;
    }

    /* renamed from: D */
    public Iterable<C1666c> m12606D() {
        return this.f10395u;
    }

    /* renamed from: E */
    public boolean m12607E() {
        return this.f10395u.isEmpty();
    }

    /* renamed from: F */
    public int m12608F() {
        return this.f10395u.size();
    }

    /* renamed from: G */
    public boolean m12609G() {
        int size = this.f10376b.m12247f().size();
        if (size == 0) {
            return false;
        }
        String m12638m = m12638m();
        for (C1648n c1648n : this.f10377c.m12530j()) {
            C1594f c1594f = c1648n.f10376b;
            if (this != c1648n && c1594f.m12247f().size() == size && c1594f.m12239a().equals(m12638m)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: H */
    public boolean m12610H() {
        int i;
        if (!this.f10378d.m12181j() || !this.f10376b.m12249h()) {
            return false;
        }
        if (this.f10377c.m12544x().m12210l() && !this.f10377c.m12539s().m12179h()) {
            C1636b m12532l = this.f10377c.m12532l();
            if (this.f10387m != null && !this.f10387m.isEmpty() && this.f10387m.get(0).m12359s().equals(m12532l.m12544x().m12211m())) {
                i = 1;
                return this.f10387m != null || this.f10387m.size() == i;
            }
        }
        i = 0;
        if (this.f10387m != null) {
        }
    }

    /* renamed from: I */
    public boolean m12611I() {
        return this.f10384j;
    }

    /* renamed from: J */
    public int m12612J() {
        return this.f10380f;
    }

    /* renamed from: K */
    public Iterable<? extends InterfaceC2166a> m12613K() {
        return this.f10379e.mo14601a();
    }

    /* renamed from: a */
    public C1605j m12618a(int i, int i2, C1604i c1604i) {
        C1605j c1605j = new C1605j(i, i2, c1604i);
        if (this.f10389o.isEmpty()) {
            this.f10389o = new ArrayList();
        }
        this.f10389o.add(c1605j);
        return c1605j;
    }

    /* renamed from: c */
    public int m12628c(int i) {
        int i2 = -1;
        for (C1605j c1605j : this.f10389o) {
            if (c1605j.m12345f() == i) {
                i2 = Math.max(i2, c1605j.m12346g());
            }
        }
        return i2 + 1;
    }

    /* renamed from: a */
    public void m12622a(C1605j c1605j) {
        this.f10389o.remove(c1605j);
    }

    /* renamed from: L */
    public List<C1605j> m12614L() {
        return this.f10389o;
    }

    /* renamed from: M */
    public C1589a m12615M() {
        return this.f10378d;
    }

    /* renamed from: N */
    public C1656b m12616N() {
        return this.f10394t;
    }

    /* renamed from: a */
    public void m12624a(C1656b c1656b) {
        this.f10394t = c1656b;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: t */
    public C1637c mo12540t() {
        return this.f10377c.mo12540t();
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: u */
    public C1650p mo12541u() {
        return mo12540t().mo12541u();
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1643i
    /* renamed from: v */
    public String mo12542v() {
        return "method";
    }

    /* renamed from: b */
    public void m12627b(String str) {
        C1735d.m13258a(this, str);
    }

    /* renamed from: a */
    public void m12625a(String str, Exception exc) {
        C1735d.m13259a(this, str, (Throwable) exc);
    }

    /* renamed from: O */
    public C1594f m12617O() {
        return this.f10376b;
    }

    public int hashCode() {
        return this.f10376b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10376b.equals(((C1648n) obj).f10376b);
    }

    public String toString() {
        return this.f10377c + "." + this.f10376b.m12239a() + "(" + C1745n.m13309a((Iterable) this.f10376b.m12247f()) + "):" + this.f10385k;
    }
}
