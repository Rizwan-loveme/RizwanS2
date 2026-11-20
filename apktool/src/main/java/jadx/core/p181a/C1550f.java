package jadx.core.p181a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1571e;
import jadx.core.p183c.p184a.p186b.C1579m;
import jadx.core.p183c.p184a.p186b.C1580n;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1595a;
import jadx.core.p183c.p188c.C1612c;
import jadx.core.p183c.p188c.C1613d;
import jadx.core.p183c.p188c.C1614e;
import jadx.core.p183c.p188c.C1615f;
import jadx.core.p183c.p188c.C1616g;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.C1624o;
import jadx.core.p183c.p188c.C1626q;
import jadx.core.p183c.p188c.EnumC1609b;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.EnumC1623n;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1597b;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.InterfaceC1601f;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p188c.p190b.C1611b;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.C1650p;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1743l;
import jadx.core.p203d.p204a.C1722a;
import jadx.core.p203d.p205b.C1724a;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: InsnGen.java */
/* renamed from: jadx.core.a.f */
/* loaded from: classes.dex */
public class C1550f {

    /* renamed from: e */
    private static final InterfaceC2558b f9927e = C2568c.m15995a((Class<?>) C1550f.class);

    /* renamed from: f */
    private static /* synthetic */ int[] f9928f;

    /* renamed from: g */
    private static /* synthetic */ int[] f9929g;

    /* renamed from: h */
    private static /* synthetic */ int[] f9930h;

    /* renamed from: a */
    protected final C1551g f9931a;

    /* renamed from: b */
    protected final C1648n f9932b;

    /* renamed from: c */
    protected final C1650p f9933c;

    /* renamed from: d */
    protected final boolean f9934d;

    /* compiled from: InsnGen.java */
    /* renamed from: jadx.core.a.f$a */
    protected enum a {
        BODY_ONLY,
        BODY_ONLY_NOWRAP,
        INLINE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            int length = valuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    /* renamed from: d */
    static /* synthetic */ int[] m11944d() {
        int[] iArr = f9928f;
        if (iArr == null) {
            iArr = new int[C1571e.a.valuesCustom().length];
            try {
                iArr[C1571e.a.CLASS_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1571e.a.VAR.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f9928f = iArr;
        }
        return iArr;
    }

    /* renamed from: e */
    static /* synthetic */ int[] m11945e() {
        int[] iArr = f9929g;
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
            f9929g = iArr;
        }
        return iArr;
    }

    /* renamed from: f */
    static /* synthetic */ int[] m11946f() {
        int[] iArr = f9930h;
        if (iArr == null) {
            iArr = new int[EnumC1623n.valuesCustom().length];
            try {
                iArr[EnumC1623n.DIRECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1623n.INTERFACE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC1623n.STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC1623n.SUPER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC1623n.VIRTUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            f9930h = iArr;
        }
        return iArr;
    }

    public C1550f(C1551g c1551g, boolean z) {
        this.f9931a = c1551g;
        this.f9932b = c1551g.m11967c();
        this.f9933c = this.f9932b.mo12540t().mo12541u();
        this.f9934d = z;
    }

    /* renamed from: a */
    private boolean m11940a() {
        return this.f9934d;
    }

    /* renamed from: a */
    public void m11950a(C1548d c1548d, AbstractC1598c abstractC1598c) {
        int m11906i = c1548d.m11906i();
        m11951a(c1548d, abstractC1598c, true);
        if (m11906i != c1548d.m11906i()) {
            c1548d.m11893b('.');
        }
    }

    /* renamed from: b */
    public void m11958b(C1548d c1548d, AbstractC1598c abstractC1598c) {
        m11951a(c1548d, abstractC1598c, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m11951a(C1548d c1548d, AbstractC1598c abstractC1598c, boolean z) {
        if (abstractC1598c.mo12298h()) {
            c1548d.m11897c(this.f9931a.m11965b().m11984b((C1604i) abstractC1598c));
            return;
        }
        if (abstractC1598c.mo12311i()) {
            c1548d.m11897c(m11927a((C1600e) abstractC1598c));
            return;
        }
        if (abstractC1598c.mo12312j()) {
            m11956a(((C1599d) abstractC1598c).m12316d(), c1548d, z ? a.BODY_ONLY : a.BODY_ONLY_NOWRAP);
            return;
        }
        if (abstractC1598c.mo12313k()) {
            c1548d.m11897c(((InterfaceC1601f) abstractC1598c).mo12320m_());
            return;
        }
        if (abstractC1598c.mo12297g()) {
            C1597b c1597b = (C1597b) abstractC1598c;
            if (c1597b.m12296f()) {
                m11948a(c1548d, c1597b.m12294d());
                return;
            } else {
                m11929a(c1548d, c1597b.m12294d(), c1597b.m12295e());
                return;
            }
        }
        throw new C1724a("Unknown arg type " + abstractC1598c);
    }

    /* renamed from: a */
    public void m11953a(C1548d c1548d, C1646l c1646l) {
        C1604i m12588p = c1646l.m12588p();
        if (c1646l.mo12149b(EnumC1562a.DECLARE_VAR)) {
            m11952a(c1548d, m12588p);
        } else {
            m11951a(c1548d, (AbstractC1598c) m12588p, false);
        }
    }

    /* renamed from: a */
    public void m11952a(C1548d c1548d, C1604i c1604i) {
        if (c1604i.m12331p().mo12149b(EnumC1562a.FINAL)) {
            c1548d.m11897c("final ");
        }
        m11957b(c1548d, c1604i.m12359s());
        c1548d.m11893b(' ');
        c1548d.m11897c(this.f9931a.m11965b().m11983a(c1604i));
    }

    /* renamed from: a */
    private String m11927a(C1600e c1600e) {
        return C1554j.m12003a(c1600e.m12317d(), c1600e.m12359s(), this.f9932b);
    }

    /* renamed from: a */
    private void m11929a(C1548d c1548d, C1592d c1592d, AbstractC1598c abstractC1598c) {
        C1571e c1571e;
        C1639e m12652a = this.f9932b.m12640o().mo12540t().mo12541u().m12652a(c1592d);
        if (m12652a != null && (c1571e = (C1571e) m12652a.mo12146b(C1566b.f10038l)) != null) {
            switch (m11944d()[c1571e.m12107a().ordinal()]) {
                case 1:
                    m11947a(c1548d, c1571e.m12108c());
                    c1548d.m11897c(".this");
                    break;
                case 2:
                    m11958b(c1548d, c1571e.m12109d());
                    break;
            }
            return;
        }
        m11950a(c1548d, abstractC1598c);
        if (m12652a != null) {
            c1548d.m11891a((Object) m12652a);
        }
        if (m12652a == null) {
            c1548d.m11897c(c1592d.m12229d());
        } else {
            c1548d.m11897c(m12652a.m12568i());
        }
    }

    /* renamed from: a */
    public static void m11928a(C1548d c1548d, C1592d c1592d, C1546b c1546b) {
        C1590b m12228c = c1592d.m12228c();
        if (!c1546b.m11862a().m12544x().equals(m12228c)) {
            if (!C1722a.m13224a(c1548d, c1546b, m12228c)) {
                c1546b.m11864a(c1548d, m12228c);
            }
            c1548d.m11893b('.');
        }
        C1639e m12652a = c1546b.m11862a().mo12540t().mo12541u().m12652a(c1592d);
        if (m12652a != null) {
            c1548d.m11891a((Object) m12652a);
        }
        if (m12652a == null) {
            c1548d.m11897c(c1592d.m12229d());
        } else {
            c1548d.m11897c(m12652a.m12568i());
        }
    }

    /* renamed from: a */
    protected void m11948a(C1548d c1548d, C1592d c1592d) {
        m11928a(c1548d, c1592d, this.f9931a.m11963a());
    }

    /* renamed from: a */
    public void m11949a(C1548d c1548d, AbstractC1596a abstractC1596a) {
        this.f9931a.m11963a().m11869b(c1548d, abstractC1596a);
    }

    /* renamed from: a */
    public void m11947a(C1548d c1548d, C1590b c1590b) {
        this.f9931a.m11963a().m11864a(c1548d, c1590b);
    }

    /* renamed from: b */
    protected void m11957b(C1548d c1548d, AbstractC1596a abstractC1596a) {
        this.f9931a.m11963a().m11865a(c1548d, abstractC1596a);
    }

    /* renamed from: a */
    public boolean m11955a(C1646l c1646l, C1548d c1548d) {
        return m11956a(c1646l, c1548d, (a) null);
    }

    /* renamed from: a */
    protected boolean m11956a(C1646l c1646l, C1548d c1548d, a aVar) {
        try {
            EnumSet noneOf = EnumSet.noneOf(a.class);
            if (aVar == a.BODY_ONLY || aVar == a.BODY_ONLY_NOWRAP) {
                noneOf.add(aVar);
                m11931a(c1548d, c1646l, noneOf);
                return true;
            }
            if (aVar != a.INLINE) {
                c1548d.m11884a(c1646l.m12122d());
            }
            if (c1646l.m12588p() != null && !c1646l.mo12149b(EnumC1562a.ARITH_ONEARG)) {
                m11953a(c1548d, c1646l);
                c1548d.m11897c(" = ");
            }
            m11931a(c1548d, c1646l, noneOf);
            if (aVar != a.INLINE) {
                c1548d.m11893b(';');
                return true;
            }
            return true;
        } catch (Exception e2) {
            throw new C1724a(this.f9932b, "Error generate insn: " + c1646l, e2);
        }
    }

    /* renamed from: a */
    private void m11931a(C1548d c1548d, C1646l c1646l, Set<a> set) {
        int i = 0;
        switch (m11945e()[c1646l.m12587o().ordinal()]) {
            case 1:
                c1548d.m11897c(m11927a((C1600e) c1646l.mo12426d(0)));
                return;
            case 2:
                c1548d.m11897c(this.f9932b.mo12540t().mo12541u().m12665g().m13308a(((C1613d) c1646l).m12377f()));
                return;
            case 3:
                m11957b(c1548d, ((C1612c) c1646l).m12375f());
                c1548d.m11897c(".class");
                return;
            case 4:
                m11934a((C1595a) c1646l, c1548d, set);
                return;
            case 5:
                m11932a(c1548d, c1646l, set, '-');
                return;
            case 6:
                m11932a(c1548d, c1646l, set, '~');
                return;
            case 7:
                m11951a(c1548d, c1646l.mo12426d(0), false);
                return;
            case 8:
            case 19:
                boolean contains = set.contains(a.BODY_ONLY);
                if (contains) {
                    c1548d.m11893b('(');
                }
                c1548d.m11893b('(');
                m11957b(c1548d, (AbstractC1596a) ((C1619j) c1646l).m12394f());
                c1548d.m11897c(") ");
                m11951a(c1548d, c1646l.mo12426d(0), true);
                if (contains) {
                    c1548d.m11893b(')');
                    return;
                }
                return;
            case 9:
                if (c1646l.m12590r() != 0) {
                    c1548d.m11897c("return ");
                    m11951a(c1548d, c1646l.mo12426d(0), false);
                    return;
                } else {
                    c1548d.m11897c("return");
                    return;
                }
            case 10:
                m11939a(c1646l);
                c1548d.m11897c("goto ").m11897c(C1551g.m11960a(((C1616g) c1646l).mo12383f()));
                return;
            case 11:
                c1548d.m11897c("throw ");
                m11951a(c1548d, c1646l.mo12426d(0), true);
                return;
            case 12:
                m11939a(c1646l);
                c1548d.m11897c("move-exception");
                return;
            case 13:
            case 14:
                c1548d.m11893b('(');
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11897c(" > ");
                m11958b(c1548d, c1646l.mo12426d(1));
                c1548d.m11897c(" ? 1 : (");
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11897c(" == ");
                m11958b(c1548d, c1646l.mo12426d(1));
                c1548d.m11897c(" ? 0 : -1))");
                return;
            case 15:
                m11939a(c1646l);
                C1617h c1617h = (C1617h) c1646l;
                c1548d.m11897c("if (");
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11893b(' ');
                c1548d.m11897c(c1617h.m12387h().m12392a()).m11893b(' ');
                m11958b(c1548d, c1646l.mo12426d(1));
                c1548d.m11897c(") goto ").m11897c(C1551g.m11960a(c1617h.mo12383f()));
                return;
            case 16:
                m11939a(c1646l);
                C1626q c1626q = (C1626q) c1646l;
                c1548d.m11897c("switch(");
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11897c(") {");
                c1548d.m11899d();
                while (i < c1626q.m12427f()) {
                    c1548d.m11886a("case ").m11897c(c1626q.m12428h()[i].toString()).m11897c(": goto ");
                    c1548d.m11897c(C1551g.m11960a(c1626q.m12429i()[i])).m11893b(';');
                    i++;
                }
                c1548d.m11886a("default: goto ");
                c1548d.m11897c(C1551g.m11960a(c1626q.m12430j())).m11893b(';');
                c1548d.m11901e();
                c1548d.m11883a('}');
                return;
            case 17:
                if (m11940a()) {
                    c1548d.m11897c("monitor-enter(");
                    m11958b(c1548d, c1646l.mo12426d(0));
                    c1548d.m11893b(')');
                    return;
                }
                return;
            case 18:
                if (m11940a()) {
                    c1548d.m11897c("monitor-exit(");
                    m11958b(c1548d, c1646l.mo12426d(0));
                    c1548d.m11893b(')');
                    return;
                }
                return;
            case 20:
                boolean contains2 = set.contains(a.BODY_ONLY);
                if (contains2) {
                    c1548d.m11893b('(');
                }
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11897c(" instanceof ");
                m11957b(c1548d, (AbstractC1596a) ((C1619j) c1646l).m12394f());
                if (contains2) {
                    c1548d.m11893b(')');
                    return;
                }
                return;
            case 21:
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11897c(".length");
                return;
            case 22:
                m11939a(c1646l);
                c1548d.m11893b('{').m11897c(Arrays.toString(((C1614e) c1646l).m12379f()).substring(1, r0.length() - 1)).m11893b('}');
                return;
            case 23:
                m11937a((C1615f) c1646l, c1548d);
                return;
            case 24:
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11893b('[');
                m11951a(c1548d, c1646l.mo12426d(1), false);
                c1548d.m11893b(']');
                return;
            case 25:
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11893b('[');
                m11951a(c1548d, c1646l.mo12426d(1), false);
                c1548d.m11897c("] = ");
                m11951a(c1548d, c1646l.mo12426d(2), false);
                return;
            case 26:
                AbstractC1596a m12418f = ((C1624o) c1646l).m12418f();
                c1548d.m11897c("new ");
                m11957b(c1548d, m12418f.mo12289o());
                c1548d.m11893b('[');
                m11958b(c1548d, c1646l.mo12426d(0));
                c1548d.m11893b(']');
                int mo12287m = m12418f.mo12287m();
                while (i < mo12287m - 1) {
                    c1548d.m11897c("[]");
                    i++;
                }
                return;
            case 27:
                m11939a(c1646l);
                c1548d.m11897c("new ").m11897c(c1646l.m12588p().m12359s().toString());
                return;
            case 28:
                m11929a(c1548d, (C1592d) ((C1619j) c1646l).m12394f(), c1646l.mo12426d(0));
                return;
            case 29:
                m11929a(c1548d, (C1592d) ((C1619j) c1646l).m12394f(), c1646l.mo12426d(1));
                c1548d.m11897c(" = ");
                m11951a(c1548d, c1646l.mo12426d(0), false);
                return;
            case 30:
                m11948a(c1548d, (C1592d) ((C1619j) c1646l).m12394f());
                return;
            case 31:
                m11948a(c1548d, (C1592d) ((C1619j) c1646l).m12394f());
                c1548d.m11897c(" = ");
                m11951a(c1548d, c1646l.mo12426d(0), false);
                return;
            case 32:
                m11938a((C1622m) c1646l, c1548d);
                return;
            case 33:
            default:
                throw new C1724a(this.f9932b, "Unknown instruction: " + c1646l.m12587o());
            case 34:
                m11936a((C1611b) c1646l, c1548d, set);
                return;
            case 35:
                m11935a((C1610a) c1646l, c1548d);
                return;
            case 36:
                c1548d.m11897c("break");
                C1579m c1579m = (C1579m) c1646l.mo12146b(C1566b.f10047u);
                if (c1579m != null) {
                    c1548d.m11893b(' ').m11897c(this.f9931a.m11965b().m11981a(c1579m));
                    return;
                }
                return;
            case 37:
                c1548d.m11897c("continue");
                return;
            case 38:
                boolean contains3 = set.contains(a.BODY_ONLY);
                if (contains3) {
                    c1548d.m11893b('(');
                }
                Iterator<AbstractC1598c> it = c1646l.m12589q().iterator();
                while (it.hasNext()) {
                    m11958b(c1548d, it.next());
                    if (it.hasNext()) {
                        c1548d.m11897c(" + ");
                    }
                }
                if (contains3) {
                    c1548d.m11893b(')');
                    return;
                }
                return;
            case 39:
                m11958b(c1548d, c1646l.mo12426d(0));
                return;
            case 40:
            case 41:
                m11939a(c1646l);
                c1548d.m11897c(c1646l.m12587o().toString()).m11897c("(");
                Iterator<AbstractC1598c> it2 = c1646l.m12589q().iterator();
                while (it2.hasNext()) {
                    m11958b(c1548d, it2.next());
                    c1548d.m11893b(' ');
                }
                c1548d.m11897c(")");
                return;
        }
    }

    /* renamed from: a */
    private void m11932a(C1548d c1548d, C1646l c1646l, Set<a> set, char c2) {
        boolean contains = set.contains(a.BODY_ONLY);
        if (contains) {
            c1548d.m11893b('(');
        }
        c1548d.m11893b(c2);
        m11958b(c1548d, c1646l.mo12426d(0));
        if (contains) {
            c1548d.m11893b(')');
        }
    }

    /* renamed from: a */
    private void m11939a(C1646l c1646l) {
        if (!this.f9934d) {
            throw new C1724a(c1646l.m12587o() + " can be used only in fallback mode");
        }
    }

    /* renamed from: a */
    private void m11937a(C1615f c1615f, C1548d c1548d) {
        c1548d.m11897c("new ");
        m11957b(c1548d, c1615f.m12382f());
        c1548d.m11893b('{');
        int r = c1615f.m12590r();
        for (int i = 0; i < r; i++) {
            m11951a(c1548d, c1615f.mo12426d(i), false);
            if (i + 1 < r) {
                c1548d.m11897c(", ");
            }
        }
        c1548d.m11893b('}');
    }

    /* renamed from: a */
    private void m11935a(C1610a c1610a, C1548d c1548d) {
        C1636b m12557b = this.f9932b.mo12540t().m12557b(c1610a.m12365i());
        if (m12557b != null && m12557b.mo12149b(EnumC1562a.ANONYMOUS_CLASS) && !this.f9934d) {
            m11930a(c1548d, m12557b, c1610a);
            return;
        }
        if (c1610a.m12370n()) {
            throw new C1729f("Constructor 'self' invoke must be removed!");
        }
        if (c1610a.m12368l()) {
            c1548d.m11897c("super");
        } else if (c1610a.m12369m()) {
            c1548d.m11897c("this");
        } else {
            c1548d.m11897c("new ");
            m11947a(c1548d, c1610a.m12365i());
        }
        m11954a(c1548d, c1610a, 0, this.f9932b.mo12540t().m12553a(c1610a.m12363f()));
    }

    /* renamed from: a */
    private void m11930a(C1548d c1548d, C1636b c1636b, C1610a c1610a) {
        AbstractC1596a m12527g;
        if (c1636b.mo12149b(EnumC1562a.DONT_GENERATE)) {
            c1548d.m11897c("/* anonymous class already generated */");
            C1735d.m13258a(this.f9932b, "Anonymous class already generated: " + c1636b);
            return;
        }
        if (c1636b.m12528h().size() == 1) {
            m12527g = c1636b.m12528h().get(0);
        } else {
            m12527g = c1636b.m12527g();
        }
        c1636b.mo12141a(EnumC1562a.DONT_GENERATE);
        C1648n m12538r = c1636b.m12538r();
        if (m12538r != null) {
            if (C1743l.m13301h(m12538r.m12616N())) {
                m12538r.mo12141a(EnumC1562a.ANONYMOUS_CONSTRUCTOR);
            } else {
                m12538r.mo12141a(EnumC1562a.DONT_GENERATE);
            }
        }
        c1548d.m11897c("new ");
        if (m12527g == null) {
            c1548d.m11897c("Object");
        } else {
            m11949a(c1548d, m12527g);
        }
        m11954a(c1548d, c1610a, 0, this.f9932b.mo12540t().m12553a(c1610a.m12363f()));
        c1548d.m11893b(' ');
        new C1546b(c1636b, this.f9931a.m11963a().m11870c()).m11871c(c1548d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private void m11938a(C1622m c1622m, C1548d c1548d) {
        int i = 1;
        C1594f m12417h = c1622m.m12417h();
        C1648n m12653a = this.f9932b.mo12541u().m12653a(m12417h);
        if (m12653a != null) {
            if (!m11943a(m12653a, c1622m, c1548d)) {
                m12417h = m12653a.m12617O();
            } else {
                return;
            }
        }
        switch (m11946f()[c1622m.m12416f().ordinal()]) {
            case 1:
                C1590b m12545y = this.f9932b.m12640o().m12545y();
                C1590b m12245d = m12417h.m12245d();
                if (!m12545y.equals(m12245d)) {
                    m11947a(c1548d, m12245d);
                    c1548d.m11893b('.');
                }
                i = 0;
                break;
            case 2:
            case 3:
            case 4:
                AbstractC1598c d2 = c1622m.mo12426d(0);
                if (!d2.m12315m()) {
                    m11950a(c1548d, d2);
                    break;
                }
                break;
            case 5:
                c1548d.m11897c("super").m11893b('.');
                break;
            default:
                i = 0;
                break;
        }
        if (m12653a != null) {
            c1548d.m11891a((Object) m12653a);
        }
        c1548d.m11897c(m12417h.m12251j());
        m11954a(c1548d, c1622m, i, m12653a);
    }

    /* renamed from: a */
    void m11954a(C1548d c1548d, C1646l c1646l, int i, C1648n c1648n) {
        boolean z;
        int i2 = (c1648n == null || !c1648n.mo12149b(EnumC1562a.SKIP_FIRST_ARG)) ? i : i + 1;
        int m12590r = c1646l.m12590r();
        c1548d.m11893b('(');
        if (i2 < m12590r) {
            boolean z2 = c1648n != null && c1648n.m12609G();
            int i3 = i2;
            boolean z3 = true;
            while (i3 < m12590r) {
                AbstractC1598c mo12426d = c1646l.mo12426d(i3);
                if (mo12426d.mo12149b(EnumC1562a.SKIP_ARG)) {
                    z = z3;
                } else {
                    C1604i m11926a = m11926a(c1648n, i3 - i);
                    if (m11926a == null || !m11926a.mo12149b(EnumC1562a.SKIP_ARG)) {
                        if (!z3) {
                            c1548d.m11897c(", ");
                        }
                        if (!(z2 && m11942a(c1548d, c1648n, mo12426d, i3 - i)) && i3 == m12590r - 1 && m11941a(c1548d, c1648n, mo12426d)) {
                            z = z3;
                        } else {
                            m11951a(c1548d, mo12426d, false);
                            z = false;
                        }
                    } else {
                        z = z3;
                    }
                }
                i3++;
                z3 = z;
            }
        }
        c1548d.m11893b(')');
    }

    /* renamed from: a */
    private static C1604i m11926a(C1648n c1648n, int i) {
        List<C1604i> m12620a;
        if (c1648n == null || (m12620a = c1648n.m12620a(false)) == null || i >= m12620a.size()) {
            return null;
        }
        return m12620a.get(i);
    }

    /* renamed from: a */
    private boolean m11942a(C1548d c1548d, C1648n c1648n, AbstractC1598c abstractC1598c, int i) {
        AbstractC1596a abstractC1596a = c1648n.m12617O().m12247f().get(i);
        if (abstractC1598c.m12359s().equals(abstractC1596a)) {
            return false;
        }
        c1548d.m11893b('(');
        m11957b(c1548d, abstractC1596a);
        c1548d.m11897c(") ");
        return true;
    }

    /* renamed from: a */
    private boolean m11941a(C1548d c1548d, C1648n c1648n, AbstractC1598c abstractC1598c) {
        if (c1648n == null || !c1648n.m12615M().m12185n() || !abstractC1598c.m12359s().mo12286l() || !abstractC1598c.mo12312j()) {
            return false;
        }
        C1646l m12316d = ((C1599d) abstractC1598c).m12316d();
        if (m12316d.m12587o() != EnumC1621l.FILLED_NEW_ARRAY) {
            return false;
        }
        int m12590r = m12316d.m12590r();
        for (int i = 0; i < m12590r; i++) {
            m11951a(c1548d, m12316d.mo12426d(i), false);
            if (i < m12590r - 1) {
                c1548d.m11897c(", ");
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private boolean m11943a(C1648n c1648n, C1622m c1622m, C1548d c1548d) {
        C1580n c1580n = (C1580n) c1648n.mo12146b(C1566b.f10039m);
        if (c1580n == null) {
            return false;
        }
        C1646l m12134a = c1580n.m12134a();
        if (c1648n.m12617O().m12247f().isEmpty()) {
            m11956a(m12134a, c1548d, a.BODY_ONLY);
        } else {
            AbstractC1598c[] abstractC1598cArr = new AbstractC1598c[c1648n.m12612J()];
            List<C1604i> m12620a = c1648n.m12620a(true);
            for (int i = 0; i < m12620a.size(); i++) {
                abstractC1598cArr[m12620a.get(i).m12330o()] = c1622m.mo12426d(i);
            }
            C1646l mo12376g = m12134a.mo12376g();
            Collection<C1604i> arrayList = new ArrayList<>();
            mo12376g.mo12372a(arrayList);
            for (C1604i c1604i : arrayList) {
                int m12330o = c1604i.m12330o();
                if (m12330o >= abstractC1598cArr.length) {
                    f9927e.mo15939b("Unknown register number {} in method call: {} from {}", c1604i, c1648n, this.f9932b);
                } else {
                    AbstractC1598c abstractC1598c = abstractC1598cArr[m12330o];
                    if (abstractC1598c == null) {
                        f9927e.mo15939b("Not passed register {} in method call: {} from {}", c1604i, c1648n, this.f9932b);
                    } else {
                        mo12376g.mo12424a(c1604i, abstractC1598c);
                    }
                }
            }
            m11956a(mo12376g, c1548d, a.BODY_ONLY);
        }
        return true;
    }

    /* renamed from: a */
    private void m11936a(C1611b c1611b, C1548d c1548d, Set<a> set) {
        boolean contains = set.contains(a.BODY_ONLY);
        if (contains) {
            c1548d.m11893b('(');
        }
        AbstractC1598c d2 = c1611b.mo12426d(0);
        AbstractC1598c d3 = c1611b.mo12426d(1);
        C1549e c1549e = new C1549e(this);
        if (d2.equals(C1600e.f10161b) && d3.equals(C1600e.f10162c)) {
            c1549e.m11921a(c1548d, c1611b.m12373f());
        } else {
            c1549e.m11922b(c1548d, c1611b.m12373f());
            c1548d.m11897c(" ? ");
            m11951a(c1548d, d2, false);
            c1548d.m11897c(" : ");
            m11951a(c1548d, d3, false);
        }
        if (contains) {
            c1548d.m11893b(')');
        }
    }

    /* renamed from: a */
    private void m11934a(C1595a c1595a, C1548d c1548d, Set<a> set) {
        if (c1595a.mo12149b(EnumC1562a.ARITH_ONEARG)) {
            m11933a(c1595a, c1548d);
            return;
        }
        boolean z = set.contains(a.BODY_ONLY) && !c1595a.mo12149b(EnumC1562a.DONT_WRAP);
        if (z) {
            c1548d.m11893b('(');
        }
        m11958b(c1548d, c1595a.mo12426d(0));
        c1548d.m11893b(' ');
        c1548d.m11897c(c1595a.m12255f().m12362a());
        c1548d.m11893b(' ');
        m11958b(c1548d, c1595a.mo12426d(1));
        if (z) {
            c1548d.m11893b(')');
        }
    }

    /* renamed from: a */
    private void m11933a(C1595a c1595a, C1548d c1548d) {
        EnumC1609b m12255f = c1595a.m12255f();
        AbstractC1598c d2 = c1595a.mo12426d(1);
        if (d2.mo12311i() && (m12255f == EnumC1609b.ADD || m12255f == EnumC1609b.SUB)) {
            C1600e c1600e = (C1600e) d2;
            if (c1600e.m12318e() && c1600e.m12317d() == 1) {
                m11953a(c1548d, c1595a);
                String m12362a = m12255f.m12362a();
                c1548d.m11897c(m12362a).m11897c(m12362a);
                return;
            }
        }
        m11953a(c1548d, c1595a);
        c1548d.m11893b(' ').m11897c(m12255f.m12362a()).m11897c("= ");
        m11951a(c1548d, d2, false);
    }
}
