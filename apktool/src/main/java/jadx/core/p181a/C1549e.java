package jadx.core.p181a;

import jadx.core.p183c.p188c.C1595a;
import jadx.core.p183c.p188c.EnumC1609b;
import jadx.core.p183c.p188c.EnumC1618i;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p193e.p194a.C1652a;
import jadx.core.p183c.p193e.p194a.C1653b;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.p205b.C1729f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: ConditionGen.java */
/* renamed from: jadx.core.a.e */
/* loaded from: classes.dex */
public class C1549e extends C1550f {

    /* renamed from: e */
    private static /* synthetic */ int[] f9923e;

    /* renamed from: f */
    private static /* synthetic */ int[] f9924f;

    /* renamed from: g */
    private static /* synthetic */ int[] f9925g;

    /* renamed from: a */
    static /* synthetic */ int[] m11913a() {
        int[] iArr = f9923e;
        if (iArr == null) {
            iArr = new int[C1653b.a.valuesCustom().length];
            try {
                iArr[C1653b.a.AND.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1653b.a.COMPARE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1653b.a.NOT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C1653b.a.OR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C1653b.a.TERNARY.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            f9923e = iArr;
        }
        return iArr;
    }

    /* renamed from: b */
    static /* synthetic */ int[] m11915b() {
        int[] iArr = f9924f;
        if (iArr == null) {
            iArr = new int[EnumC1609b.valuesCustom().length];
            try {
                iArr[EnumC1609b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1609b.AND.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC1609b.DIV.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC1609b.MUL.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC1609b.OR.ordinal()] = 7;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumC1609b.REM.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EnumC1609b.SHL.ordinal()] = 9;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EnumC1609b.SHR.ordinal()] = 10;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EnumC1609b.SUB.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EnumC1609b.USHR.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EnumC1609b.XOR.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            f9924f = iArr;
        }
        return iArr;
    }

    /* renamed from: c */
    static /* synthetic */ int[] m11918c() {
        int[] iArr = f9925g;
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
            f9925g = iArr;
        }
        return iArr;
    }

    /* compiled from: ConditionGen.java */
    /* renamed from: jadx.core.a.e$a */
    private static class a {

        /* renamed from: a */
        private final Queue<C1653b> f9926a;

        private a() {
            this.f9926a = new LinkedList();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* renamed from: a */
        public Queue<C1653b> m11923a() {
            return this.f9926a;
        }

        /* renamed from: a */
        public void m11924a(C1653b c1653b) {
            this.f9926a.add(c1653b);
        }

        /* renamed from: b */
        public C1653b m11925b() {
            return this.f9926a.poll();
        }
    }

    public C1549e(C1550f c1550f) {
        super(c1550f.f9931a, c1550f.f9934d);
    }

    /* renamed from: a */
    void m11921a(C1548d c1548d, C1653b c1653b) {
        m11910a(c1548d, new a(null), c1653b);
    }

    /* renamed from: b */
    void m11922b(C1548d c1548d, C1653b c1653b) {
        m11914b(c1548d, new a(null), c1653b);
    }

    /* renamed from: a */
    private void m11910a(C1548d c1548d, a aVar, C1653b c1653b) {
        aVar.m11924a(c1653b);
        switch (m11913a()[c1653b.m12685a().ordinal()]) {
            case 1:
                m11909a(c1548d, aVar, c1653b.m12692g());
                break;
            case 2:
                m11916c(c1548d, aVar, c1653b);
                break;
            case 3:
                m11919d(c1548d, aVar, c1653b);
                break;
            case 4:
            case 5:
                m11920e(c1548d, aVar, c1653b);
                break;
            default:
                throw new C1729f("Unknown condition mode: " + c1653b.m12685a());
        }
        aVar.m11925b();
    }

    /* renamed from: b */
    private void m11914b(C1548d c1548d, a aVar, C1653b c1653b) {
        boolean m11912a = m11912a(c1653b);
        if (m11912a) {
            c1548d.m11893b('(');
        }
        m11910a(c1548d, aVar, c1653b);
        if (m11912a) {
            c1548d.m11893b(')');
        }
    }

    /* renamed from: c */
    private void m11917c(C1548d c1548d, AbstractC1598c abstractC1598c) {
        boolean m11911a = m11911a(abstractC1598c);
        if (m11911a) {
            c1548d.m11893b('(');
        }
        m11951a(c1548d, abstractC1598c, false);
        if (m11911a) {
            c1548d.m11893b(')');
        }
    }

    /* renamed from: a */
    private void m11909a(C1548d c1548d, a aVar, C1652a c1652a) {
        EnumC1618i m12670a = c1652a.m12670a();
        AbstractC1598c m12671b = c1652a.m12671b();
        AbstractC1598c m12672c = c1652a.m12672c();
        if (m12671b.m12359s().equals(AbstractC1596a.f10126b) && m12672c.mo12311i() && m12672c.m12359s().equals(AbstractC1596a.f10126b)) {
            EnumC1618i m12393b = ((C1600e) m12672c).m12317d() == 0 ? m12670a.m12393b() : m12670a;
            if (m12393b == EnumC1618i.EQ) {
                if (aVar.m11923a().size() == 1) {
                    m11951a(c1548d, m12671b, false);
                    return;
                } else {
                    m11917c(c1548d, m12671b);
                    return;
                }
            }
            if (m12393b == EnumC1618i.NE) {
                c1548d.m11893b('!');
                m11917c(c1548d, m12671b);
                return;
            } else {
                C1735d.m13258a(this.f9932b, "Unsupported boolean condition " + m12393b.m12392a());
                m12670a = m12393b;
            }
        }
        m11951a(c1548d, m12671b, m11911a(m12671b));
        c1548d.m11893b(' ').m11897c(m12670a.m12392a()).m11893b(' ');
        m11951a(c1548d, m12672c, m11911a(m12672c));
    }

    /* renamed from: c */
    private void m11916c(C1548d c1548d, a aVar, C1653b c1653b) {
        m11910a(c1548d, aVar, c1653b.m12688c());
        c1548d.m11897c(" ? ");
        m11910a(c1548d, aVar, c1653b.m12689d());
        c1548d.m11897c(" : ");
        m11910a(c1548d, aVar, c1653b.m12690e());
    }

    /* renamed from: d */
    private void m11919d(C1548d c1548d, a aVar, C1653b c1653b) {
        c1548d.m11893b('!');
        m11914b(c1548d, aVar, c1653b.m12687b().get(0));
    }

    /* renamed from: e */
    private void m11920e(C1548d c1548d, a aVar, C1653b c1653b) {
        String str = c1653b.m12685a() == C1653b.a.AND ? " && " : " || ";
        Iterator<C1653b> it = c1653b.m12687b().iterator();
        while (it.hasNext()) {
            m11914b(c1548d, aVar, it.next());
            if (it.hasNext()) {
                c1548d.m11897c(str);
            }
        }
    }

    /* renamed from: a */
    private boolean m11912a(C1653b c1653b) {
        return (c1653b.m12691f() || c1653b.m12685a() == C1653b.a.NOT) ? false : true;
    }

    /* renamed from: a */
    private static boolean m11911a(AbstractC1598c abstractC1598c) {
        if (!abstractC1598c.mo12312j()) {
            return false;
        }
        C1646l m12316d = ((C1599d) abstractC1598c).m12316d();
        EnumC1621l m12587o = m12316d.m12587o();
        if (m12587o == EnumC1621l.ARITH) {
            switch (m11915b()[((C1595a) m12316d).m12255f().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return false;
                default:
                    return true;
            }
        }
        switch (m11918c()[m12587o.ordinal()]) {
            case 1:
            case 21:
            case 24:
            case 28:
            case 30:
            case 32:
                return false;
            default:
                return true;
        }
    }
}
