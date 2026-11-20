package jadx.core.p183c.p191d;

import com.p163i.p164a.C1403a;
import jadx.core.p183c.p184a.p186b.AbstractC1577k;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1602g;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.C1742k;
import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;

/* compiled from: InsnNode.java */
/* renamed from: jadx.core.c.d.l */
/* loaded from: classes.dex */
public class C1646l extends AbstractC1577k {

    /* renamed from: a */
    private static final C1403a f10367a = new C1403a();

    /* renamed from: f */
    private static /* synthetic */ int[] f10368f;

    /* renamed from: b */
    private C1604i f10369b;

    /* renamed from: c */
    protected final EnumC1621l f10370c;

    /* renamed from: d */
    protected int f10371d = -1;

    /* renamed from: e */
    private final List<AbstractC1598c> f10372e;

    /* renamed from: w */
    static /* synthetic */ int[] m12577w() {
        int[] iArr = f10368f;
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
            f10368f = iArr;
        }
        return iArr;
    }

    static {
        f10367a.m11209b(AbstractC1596a.class, C1605j.class, C1600e.class, C1602g.class);
        f10367a.m11213c(C1604i.class);
    }

    public C1646l(EnumC1621l enumC1621l, int i) {
        this.f10370c = enumC1621l;
        if (i == 0) {
            this.f10372e = Collections.emptyList();
        } else {
            this.f10372e = new ArrayList(i);
        }
    }

    /* renamed from: b */
    public static C1646l m12576b(AbstractC1598c abstractC1598c) {
        C1646l c1646l = new C1646l(EnumC1621l.ONE_ARG, 1);
        c1646l.m12584c(abstractC1598c);
        return c1646l;
    }

    /* renamed from: b */
    public void m12581b(C1604i c1604i) {
        if (c1604i != null) {
            c1604i.mo12309a(this);
        }
        this.f10369b = c1604i;
    }

    /* renamed from: c */
    public void m12584c(AbstractC1598c abstractC1598c) {
        abstractC1598c.mo12309a(this);
        this.f10372e.add(abstractC1598c);
    }

    /* renamed from: o */
    public EnumC1621l m12587o() {
        return this.f10370c;
    }

    /* renamed from: p */
    public C1604i m12588p() {
        return this.f10369b;
    }

    /* renamed from: q */
    public Iterable<AbstractC1598c> m12589q() {
        return this.f10372e;
    }

    /* renamed from: r */
    public int m12590r() {
        return this.f10372e.size();
    }

    /* renamed from: d */
    public AbstractC1598c mo12426d(int i) {
        return this.f10372e.get(i);
    }

    /* renamed from: c */
    public boolean m12585c(C1604i c1604i) {
        for (AbstractC1598c abstractC1598c : this.f10372e) {
            if (abstractC1598c == c1604i || (abstractC1598c.mo12298h() && ((C1604i) abstractC1598c).m12330o() == c1604i.m12330o())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo12421a(int i, AbstractC1598c abstractC1598c) {
        abstractC1598c.mo12309a(this);
        this.f10372e.set(i, abstractC1598c);
    }

    /* renamed from: a */
    public boolean mo12424a(AbstractC1598c abstractC1598c, AbstractC1598c abstractC1598c2) {
        int m12590r = m12590r();
        for (int i = 0; i < m12590r; i++) {
            AbstractC1598c abstractC1598c3 = this.f10372e.get(i);
            if (abstractC1598c3 == abstractC1598c) {
                mo12421a(i, abstractC1598c2);
                return true;
            }
            if (abstractC1598c3.mo12312j() && ((C1599d) abstractC1598c3).m12316d().mo12424a(abstractC1598c, abstractC1598c2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected boolean mo12423a(AbstractC1598c abstractC1598c) {
        int m12590r = m12590r();
        for (int i = 0; i < m12590r; i++) {
            if (abstractC1598c == this.f10372e.get(i)) {
                this.f10372e.remove(i);
                if (abstractC1598c instanceof C1604i) {
                    C1604i c1604i = (C1604i) abstractC1598c;
                    c1604i.m12331p().m12342c(c1604i);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected void m12579a(InterfaceC2218f interfaceC2218f, int i, AbstractC1596a abstractC1596a) {
        m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, i, abstractC1596a));
    }

    /* renamed from: a */
    protected void m12578a(int i, AbstractC1596a abstractC1596a) {
        m12584c((AbstractC1598c) AbstractC1598c.m12302a(i, abstractC1596a));
    }

    /* renamed from: a */
    protected void m12580a(InterfaceC2218f interfaceC2218f, AbstractC1596a abstractC1596a) {
        m12584c(AbstractC1598c.m12301a(interfaceC2218f, abstractC1596a));
    }

    /* renamed from: s */
    public int m12591s() {
        return this.f10371d;
    }

    /* renamed from: e */
    public void m12586e(int i) {
        this.f10371d = i;
    }

    /* renamed from: a */
    public void mo12372a(Collection<C1604i> collection) {
        for (AbstractC1598c abstractC1598c : m12589q()) {
            if (abstractC1598c.mo12298h()) {
                collection.add((C1604i) abstractC1598c);
            } else if (abstractC1598c.mo12312j()) {
                ((C1599d) abstractC1598c).m12316d().mo12372a(collection);
            }
        }
    }

    /* renamed from: t */
    public boolean m12592t() {
        switch (m12577w()[m12587o().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: u */
    public boolean m12593u() {
        switch (m12577w()[m12587o().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 13:
            case 14:
            case 19:
            case 20:
            case 22:
            case 23:
            case 26:
            case 38:
            case 42:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: v */
    public boolean m12594v() {
        if (!m12593u()) {
            return false;
        }
        for (AbstractC1598c abstractC1598c : m12589q()) {
            if (abstractC1598c.mo12312j() && !((C1599d) abstractC1598c).m12316d().m12594v()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return String.valueOf(C1739h.m13270a(this.f10371d)) + ": " + C1739h.m13271a(this.f10370c) + (this.f10369b == null ? "" : this.f10369b + " = ") + C1745n.m13309a((Iterable) this.f10372e);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        int size;
        if (this == c1646l) {
            return true;
        }
        if (this.f10370c == c1646l.f10370c && (size = this.f10372e.size()) == c1646l.f10372e.size()) {
            for (int i = 0; i < size; i++) {
                AbstractC1598c abstractC1598c = this.f10372e.get(i);
                AbstractC1598c abstractC1598c2 = c1646l.f10372e.get(i);
                if (abstractC1598c.mo12312j() && !(abstractC1598c2.mo12312j() && ((C1599d) abstractC1598c).m12316d().mo12254a(((C1599d) abstractC1598c2).m12316d()))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m12582b(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        return mo12254a(c1646l) && C1742k.m13287a(this.f10369b, c1646l.f10369b) && C1742k.m13287a(this.f10372e, c1646l.f10372e);
    }

    /* renamed from: c */
    protected <T extends C1646l> T m12583c(T t) {
        t.m12581b(this.f10369b);
        if (t.m12590r() == 0) {
            for (AbstractC1598c abstractC1598c : m12589q()) {
                if (abstractC1598c.mo12312j()) {
                    t.m12584c(AbstractC1598c.m12306c(((C1599d) abstractC1598c).m12316d().mo12376g()));
                } else {
                    t.m12584c(abstractC1598c);
                }
            }
        }
        t.m12143a(this);
        t.m12119a(this);
        t.m12586e(m12591s());
        return t;
    }

    /* renamed from: g */
    public C1646l mo12376g() {
        return getClass() == C1646l.class ? m12583c(new C1646l(this.f10370c, m12590r())) : (C1646l) f10367a.m11202a((C1403a) this);
    }
}
