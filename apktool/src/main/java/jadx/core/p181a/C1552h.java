package jadx.core.p181a;

import android.icu.text.DateFormat;
import jadx.core.p182b.C1559d;
import jadx.core.p183c.p184a.p186b.C1579m;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1602g;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1744m;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: NameGen.java */
/* renamed from: jadx.core.a.h */
/* loaded from: classes.dex */
public class C1552h {

    /* renamed from: a */
    private static final Map<String, String> f9944a = new HashMap();

    /* renamed from: e */
    private static /* synthetic */ int[] f9945e;

    /* renamed from: b */
    private final Set<String> f9946b = new LinkedHashSet();

    /* renamed from: c */
    private final C1648n f9947c;

    /* renamed from: d */
    private final boolean f9948d;

    /* renamed from: a */
    static /* synthetic */ int[] m11973a() {
        int[] iArr = f9945e;
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
            f9945e = iArr;
        }
        return iArr;
    }

    static {
        f9944a.put("java.lang.String", "str");
        f9944a.put("java.lang.Class", "cls");
        f9944a.put("java.lang.Throwable", "th");
        f9944a.put("java.lang.Object", "obj");
        f9944a.put("java.util.Iterator", "it");
        f9944a.put("java.lang.Boolean", "bool");
        f9944a.put("java.lang.Short", "sh");
        f9944a.put("java.lang.Integer", "num");
        f9944a.put("java.lang.Character", "ch");
        f9944a.put("java.lang.Byte", "b");
        f9944a.put("java.lang.Float", "f");
        f9944a.put("java.lang.Long", "l");
        f9944a.put("java.lang.Double", DateFormat.DAY);
    }

    public C1552h(C1648n c1648n, boolean z) {
        this.f9947c = c1648n;
        this.f9948d = z;
    }

    /* renamed from: a */
    public String m11983a(C1604i c1604i) {
        String m11977c = m11977c(c1604i);
        if (!this.f9948d) {
            String m11972a = m11972a(m11977c);
            c1604i.mo12319a_(m11972a);
            return m11972a;
        }
        return m11977c;
    }

    /* renamed from: a */
    public String m11982a(C1602g c1602g) {
        String mo12320m_ = c1602g.mo12320m_();
        if (!this.f9948d) {
            String m11972a = m11972a(mo12320m_);
            c1602g.mo12319a_(m11972a);
            return m11972a;
        }
        return mo12320m_;
    }

    /* renamed from: b */
    public String m11984b(C1604i c1604i) {
        String mo12320m_ = c1604i.mo12320m_();
        if (mo12320m_ == null || this.f9948d) {
            return m11979d(c1604i);
        }
        return mo12320m_;
    }

    /* renamed from: a */
    public String m11981a(C1579m c1579m) {
        String str = "loop" + c1579m.m12133a().m12131f();
        this.f9946b.add(str);
        return str;
    }

    /* renamed from: a */
    private String m11972a(String str) {
        int i = 2;
        String str2 = str;
        while (this.f9946b.contains(str2)) {
            str2 = String.valueOf(str) + i;
            i++;
        }
        this.f9946b.add(str2);
        return str2;
    }

    /* renamed from: c */
    private String m11977c(C1604i c1604i) {
        if (this.f9948d) {
            return m11979d(c1604i);
        }
        if (c1604i.m12315m()) {
            return "this";
        }
        String mo12320m_ = c1604i.mo12320m_();
        if (mo12320m_ == null) {
            mo12320m_ = m11980e(c1604i);
        }
        if (C1559d.m12063a(mo12320m_)) {
            return String.valueOf(mo12320m_) + "R";
        }
        return mo12320m_;
    }

    /* renamed from: d */
    private String m11979d(C1604i c1604i) {
        return "r" + c1604i.m12330o();
    }

    /* renamed from: e */
    private String m11980e(C1604i c1604i) {
        C1604i m12347h;
        C1646l l;
        String m11971a;
        C1605j m12331p = c1604i.m12331p();
        if (m12331p == null || m12331p.m12354o() != null || (l = (m12347h = m12331p.m12347h()).m12314l()) == null || (m11971a = m11971a(l)) == null || C1559d.m12063a(m11971a)) {
            return m11970a(c1604i.m12359s());
        }
        m12347h.mo12319a_(m11971a);
        return m11971a;
    }

    /* renamed from: a */
    private String m11970a(AbstractC1596a abstractC1596a) {
        if (abstractC1596a.mo12278d()) {
            return m11974b(abstractC1596a);
        }
        if (abstractC1596a.mo12286l()) {
            return String.valueOf(m11970a(abstractC1596a.mo12289o())) + "Arr";
        }
        return m11976c(abstractC1596a);
    }

    /* renamed from: b */
    private static String m11974b(AbstractC1596a abstractC1596a) {
        return abstractC1596a.mo12277c().m12322a().toLowerCase();
    }

    /* renamed from: c */
    private String m11976c(AbstractC1596a abstractC1596a) {
        if (abstractC1596a.mo12280f()) {
            String m11978c = m11978c(abstractC1596a.mo12279e());
            if (m11978c == null) {
                String m12203e = C1590b.m12195b(this.f9947c.mo12541u(), abstractC1596a).m12203e();
                String m11975b = m11975b(m12203e);
                if (m11975b == null) {
                    if (m12203e != null) {
                        return C1744m.m13305b(m12203e.toLowerCase());
                    }
                } else {
                    return m11975b;
                }
            } else {
                return m11978c;
            }
        }
        return C1744m.m13305b(abstractC1596a.toString());
    }

    /* renamed from: b */
    private static String m11975b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.toUpperCase().equals(str)) {
            return str.toLowerCase();
        }
        String str2 = String.valueOf(Character.toLowerCase(str.charAt(0))) + str.substring(1);
        if (str2.equals(str)) {
            if (str.length() < 3) {
                return String.valueOf(str) + "Var";
            }
            return null;
        }
        return str2;
    }

    /* renamed from: c */
    private static String m11978c(String str) {
        return f9944a.get(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private String m11971a(C1646l c1646l) {
        String m11971a;
        switch (m11973a()[c1646l.m12587o().ordinal()]) {
            case 4:
            case 8:
            case 34:
                for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
                    if (abstractC1598c.mo12312j() && (m11971a = m11971a(((C1599d) abstractC1598c).m12316d())) != null) {
                        return m11971a;
                    }
                }
                return null;
            case 21:
                return "length";
            case 32:
                return m11969a(((C1622m) c1646l).m12417h());
            case 35:
                return m11976c(((C1610a) c1646l).m12365i().m12211m());
            default:
                return null;
        }
    }

    /* renamed from: a */
    private String m11969a(C1594f c1594f) {
        String m12239a = c1594f.m12239a();
        if (m12239a.startsWith("get") || m12239a.startsWith("set")) {
            return m11975b(m12239a.substring(3));
        }
        AbstractC1596a m12211m = c1594f.m12245d().m12199b().m12211m();
        if ("iterator".equals(m12239a)) {
            return "it";
        }
        if ("toString".equals(m12239a)) {
            return m11970a(m12211m);
        }
        if ("forName".equals(m12239a) && m12211m.equals(AbstractC1596a.f10135k)) {
            return f9944a.get("java.lang.Class");
        }
        return m12239a;
    }
}
