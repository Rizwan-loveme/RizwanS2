package org.p210a.p211a.p212a.p213a;

import android.widget.ExpandableListView;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.p210a.p211a.p212a.p215c.C1840j;
import org.p210a.p211a.p212a.p215c.C1843m;

/* compiled from: ATNDeserializer.java */
/* renamed from: org.a.a.a.a.e */
/* loaded from: classes.dex */
public class C1795e {

    /* renamed from: b */
    public static final UUID f10780b;

    /* renamed from: i */
    private static /* synthetic */ int[] f10786i;

    /* renamed from: h */
    private final C1794d f10787h;

    /* renamed from: a */
    public static final int f10779a = 3;

    /* renamed from: c */
    private static final UUID f10781c = UUID.fromString("33761B2D-78BB-4A43-8B0B-4F5BEE8AACF3");

    /* renamed from: d */
    private static final UUID f10782d = UUID.fromString("1DA0C57D-6C06-438A-9B27-10BCB3CE0F61");

    /* renamed from: e */
    private static final UUID f10783e = UUID.fromString("AADB8D7E-AEEF-4415-AD2B-8204D6CF042E");

    /* renamed from: f */
    private static final UUID f10784f = UUID.fromString("59627784-3BE5-417A-B9EB-8131A7286089");

    /* renamed from: g */
    private static final List<UUID> f10785g = new ArrayList();

    /* compiled from: ATNDeserializer.java */
    /* renamed from: org.a.a.a.a.e$a */
    interface a {
        /* renamed from: a */
        int mo13627a();

        /* renamed from: a */
        int mo13628a(char[] cArr, int i);
    }

    /* compiled from: ATNDeserializer.java */
    /* renamed from: org.a.a.a.a.e$b */
    enum b {
        UNICODE_BMP,
        UNICODE_SMP;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] valuesCustom = values();
            int length = valuesCustom.length;
            b[] bVarArr = new b[length];
            System.arraycopy(valuesCustom, 0, bVarArr, 0, length);
            return bVarArr;
        }
    }

    /* renamed from: a */
    static /* synthetic */ int[] m13616a() {
        int[] iArr = f10786i;
        if (iArr == null) {
            iArr = new int[EnumC1815y.valuesCustom().length];
            try {
                iArr[EnumC1815y.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1815y.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC1815y.MODE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC1815y.MORE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC1815y.POP_MODE.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumC1815y.PUSH_MODE.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EnumC1815y.SKIP.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EnumC1815y.TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            f10786i = iArr;
        }
        return iArr;
    }

    static {
        f10785g.add(f10781c);
        f10785g.add(f10782d);
        f10785g.add(f10783e);
        f10785g.add(f10784f);
        f10780b = f10784f;
    }

    /* renamed from: a */
    static a m13614a(b bVar) {
        return bVar == b.UNICODE_BMP ? new a() { // from class: org.a.a.a.a.e.1
            @Override // org.p210a.p211a.p212a.p213a.C1795e.a
            /* renamed from: a */
            public int mo13628a(char[] cArr, int i) {
                return C1795e.m13611a(cArr[i]);
            }

            @Override // org.p210a.p211a.p212a.p213a.C1795e.a
            /* renamed from: a */
            public int mo13627a() {
                return 1;
            }
        } : new a() { // from class: org.a.a.a.a.e.2
            @Override // org.p210a.p211a.p212a.p213a.C1795e.a
            /* renamed from: a */
            public int mo13628a(char[] cArr, int i) {
                return C1795e.m13612a(cArr, i);
            }

            @Override // org.p210a.p211a.p212a.p213a.C1795e.a
            /* renamed from: a */
            public int mo13627a() {
                return 2;
            }
        };
    }

    public C1795e() {
        this(C1794d.m13607a());
    }

    public C1795e(C1794d c1794d) {
        this.f10787h = c1794d == null ? C1794d.m13607a() : c1794d;
    }

    /* renamed from: a */
    protected static boolean m13615a(UUID uuid, UUID uuid2) {
        int indexOf = f10785g.indexOf(uuid);
        return indexOf >= 0 && f10785g.indexOf(uuid2) >= indexOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public C1759a m13619a(char[] cArr) {
        AbstractC1797g abstractC1797g;
        AbstractC1791be abstractC1791be;
        int i;
        char[] cArr2 = (char[]) cArr.clone();
        for (int i2 = 1; i2 < cArr2.length; i2++) {
            cArr2[i2] = (char) (cArr2[i2] - 2);
        }
        int m13611a = m13611a(cArr2[0]);
        if (m13611a != f10779a) {
            throw new UnsupportedOperationException(new InvalidClassException(C1759a.class.getName(), String.format(Locale.getDefault(), "Could not deserialize ATN with version %d (expected %d).", Integer.valueOf(m13611a), Integer.valueOf(f10779a))));
        }
        UUID m13618c = m13618c(cArr2, 1);
        if (!f10785g.contains(m13618c)) {
            throw new UnsupportedOperationException(new InvalidClassException(C1759a.class.getName(), String.format(Locale.getDefault(), "Could not deserialize ATN with UUID %s (expected %s or a legacy UUID).", m13618c, f10780b)));
        }
        boolean m13615a = m13615a(f10782d, m13618c);
        boolean m13615a2 = m13615a(f10783e, m13618c);
        C1759a c1759a = new C1759a(EnumC1798h.valuesCustom()[m13611a(cArr2[9])], m13611a(cArr2[10]));
        ArrayList<C1843m> arrayList = new ArrayList();
        ArrayList<C1843m> arrayList2 = new ArrayList();
        int m13611a2 = m13611a(cArr2[11]);
        int i3 = 0;
        int i4 = 12;
        while (i3 < m13611a2) {
            int i5 = i4 + 1;
            int m13611a3 = m13611a(cArr2[i4]);
            if (m13611a3 == 0) {
                c1759a.m13487b(null);
            } else {
                int i6 = i5 + 1;
                int m13611a4 = m13611a(cArr2[i5]);
                if (m13611a4 == 65535) {
                    m13611a4 = -1;
                }
                AbstractC1797g m13621a = m13621a(m13611a3, m13611a4);
                if (m13611a3 == 12) {
                    arrayList.add(new C1843m((C1768ai) m13621a, Integer.valueOf(m13611a(cArr2[i6]))));
                    i5 = i6 + 1;
                } else if (m13621a instanceof AbstractC1806p) {
                    arrayList2.add(new C1843m((AbstractC1806p) m13621a, Integer.valueOf(m13611a(cArr2[i6]))));
                    i5 = i6 + 1;
                } else {
                    i5 = i6;
                }
                c1759a.m13487b(m13621a);
            }
            i3++;
            i4 = i5;
        }
        for (C1843m c1843m : arrayList) {
            ((C1768ai) c1843m.f10912a).f10710h = c1759a.f10690a.get(((Integer) c1843m.f10913b).intValue());
        }
        for (C1843m c1843m2 : arrayList2) {
            ((AbstractC1806p) c1843m2.f10912a).f10814h = (C1805o) c1759a.f10690a.get(((Integer) c1843m2.f10913b).intValue());
        }
        int i7 = i4 + 1;
        int m13611a5 = m13611a(cArr2[i4]);
        int i8 = 0;
        while (i8 < m13611a5) {
            ((AbstractC1807q) c1759a.f10690a.get(m13611a(cArr2[i7]))).f10816j = true;
            i8++;
            i7++;
        }
        if (m13615a) {
            int m13611a6 = m13611a(cArr2[i7]);
            int i9 = 0;
            i7++;
            while (i9 < m13611a6) {
                ((C1780au) c1759a.f10690a.get(m13611a(cArr2[i7]))).f10740i = true;
                i9++;
                i7++;
            }
        }
        int i10 = i7 + 1;
        int m13611a7 = m13611a(cArr2[i7]);
        if (c1759a.f10695f == EnumC1798h.LEXER) {
            c1759a.f10697h = new int[m13611a7];
        }
        c1759a.f10692c = new C1780au[m13611a7];
        int i11 = 0;
        int i12 = i10;
        while (i11 < m13611a7) {
            int i13 = i12 + 1;
            c1759a.f10692c[i11] = (C1780au) c1759a.f10690a.get(m13611a(cArr2[i12]));
            if (c1759a.f10695f == EnumC1798h.LEXER) {
                int i14 = i13 + 1;
                int m13611a8 = m13611a(cArr2[i13]);
                if (m13611a8 == 65535) {
                    m13611a8 = -1;
                }
                c1759a.f10697h[i11] = m13611a8;
                if (m13615a(f10783e, m13618c)) {
                    i = i14;
                } else {
                    i = i14 + 1;
                    m13611a(cArr2[i14]);
                }
            } else {
                i = i13;
            }
            i11++;
            i12 = i;
        }
        c1759a.f10693d = new C1781av[m13611a7];
        for (AbstractC1797g abstractC1797g2 : c1759a.f10690a) {
            if (abstractC1797g2 instanceof C1781av) {
                C1781av c1781av = (C1781av) abstractC1797g2;
                c1759a.f10693d[abstractC1797g2.f10799d] = c1781av;
                c1759a.f10692c[abstractC1797g2.f10799d].f10739h = c1781av;
            }
        }
        int i15 = i12 + 1;
        int m13611a9 = m13611a(cArr2[i12]);
        int i16 = 0;
        while (i16 < m13611a9) {
            c1759a.f10699j.add((C1790bd) c1759a.f10690a.get(m13611a(cArr2[i15])));
            i16++;
            i15++;
        }
        List<C1840j> arrayList3 = new ArrayList<>();
        int m13613a = m13613a(cArr2, i15, arrayList3, m13614a(b.UNICODE_BMP));
        if (m13615a(f10784f, m13618c)) {
            m13613a = m13613a(cArr2, m13613a, arrayList3, m13614a(b.UNICODE_SMP));
        }
        int m13611a10 = m13611a(cArr2[m13613a]);
        int i17 = 0;
        int i18 = m13613a + 1;
        while (i17 < m13611a10) {
            int m13611a11 = m13611a(cArr2[i18]);
            c1759a.f10690a.get(m13611a11).m13633a(m13620a(c1759a, m13611a(cArr2[i18 + 2]), m13611a11, m13611a(cArr2[i18 + 1]), m13611a(cArr2[i18 + 3]), m13611a(cArr2[i18 + 4]), m13611a(cArr2[i18 + 5]), arrayList3));
            i17++;
            i18 += 6;
        }
        for (AbstractC1797g abstractC1797g3 : c1759a.f10690a) {
            int i19 = 0;
            while (true) {
                int i20 = i19;
                if (i20 < abstractC1797g3.m13630a()) {
                    AbstractC1791be m13631a = abstractC1797g3.m13631a(i20);
                    if (m13631a instanceof C1782aw) {
                        C1782aw c1782aw = (C1782aw) m13631a;
                        int i21 = -1;
                        if (c1759a.f10692c[c1782aw.f10764f.f10799d].f10740i && c1782aw.f10742b == 0) {
                            i21 = c1782aw.f10764f.f10799d;
                        }
                        c1759a.f10693d[c1782aw.f10764f.f10799d].m13633a(new C1809s(c1782aw.f10743c, i21));
                    }
                    i19 = i20 + 1;
                }
            }
        }
        for (AbstractC1797g abstractC1797g4 : c1759a.f10690a) {
            if (abstractC1797g4 instanceof AbstractC1806p) {
                if (((AbstractC1806p) abstractC1797g4).f10814h == null) {
                    throw new IllegalStateException();
                }
                if (((AbstractC1806p) abstractC1797g4).f10814h.f10813h != null) {
                    throw new IllegalStateException();
                }
                ((AbstractC1806p) abstractC1797g4).f10814h.f10813h = (AbstractC1806p) abstractC1797g4;
            }
            if (abstractC1797g4 instanceof C1773an) {
                C1773an c1773an = (C1773an) abstractC1797g4;
                int i22 = 0;
                while (true) {
                    int i23 = i22;
                    if (i23 < c1773an.m13630a()) {
                        AbstractC1797g abstractC1797g5 = c1773an.m13631a(i23).f10764f;
                        if (abstractC1797g5 instanceof C1772am) {
                            ((C1772am) abstractC1797g5).f10721k = c1773an;
                        }
                        i22 = i23 + 1;
                    }
                }
            } else if (abstractC1797g4 instanceof C1789bc) {
                C1789bc c1789bc = (C1789bc) abstractC1797g4;
                int i24 = 0;
                while (true) {
                    int i25 = i24;
                    if (i25 < c1789bc.m13630a()) {
                        AbstractC1797g abstractC1797g6 = c1789bc.m13631a(i25).f10764f;
                        if (abstractC1797g6 instanceof C1788bb) {
                            ((C1788bb) abstractC1797g6).f10760h = c1789bc;
                        }
                        i24 = i25 + 1;
                    }
                }
            }
        }
        int i26 = i18 + 1;
        int m13611a12 = m13611a(cArr2[i18]);
        int i27 = 1;
        while (i27 <= m13611a12) {
            AbstractC1807q abstractC1807q = (AbstractC1807q) c1759a.f10690a.get(m13611a(cArr2[i26]));
            c1759a.f10691b.add(abstractC1807q);
            abstractC1807q.f10815i = i27 - 1;
            i27++;
            i26++;
        }
        if (c1759a.f10695f == EnumC1798h.LEXER) {
            if (m13615a2) {
                int i28 = i26 + 1;
                c1759a.f10698i = new InterfaceC1813w[m13611a(cArr2[i26])];
                for (int i29 = 0; i29 < c1759a.f10698i.length; i29++) {
                    int i30 = i28 + 1;
                    EnumC1815y enumC1815y = EnumC1815y.valuesCustom()[m13611a(cArr2[i28])];
                    int i31 = i30 + 1;
                    int m13611a13 = m13611a(cArr2[i30]);
                    int i32 = m13611a13 == 65535 ? -1 : m13611a13;
                    i28 = i31 + 1;
                    int m13611a14 = m13611a(cArr2[i31]);
                    if (m13611a14 == 65535) {
                        m13611a14 = -1;
                    }
                    c1759a.f10698i[i29] = m13622a(enumC1815y, i32, m13611a14);
                }
            } else {
                ArrayList arrayList4 = new ArrayList();
                for (AbstractC1797g abstractC1797g7 : c1759a.f10690a) {
                    int i33 = 0;
                    while (true) {
                        int i34 = i33;
                        if (i34 < abstractC1797g7.m13630a()) {
                            AbstractC1791be m13631a2 = abstractC1797g7.m13631a(i34);
                            if (m13631a2 instanceof C1800j) {
                                int i35 = ((C1800j) m13631a2).f10806a;
                                C1760aa c1760aa = new C1760aa(i35, ((C1800j) m13631a2).f10807b);
                                abstractC1797g7.m13635b(i34, new C1800j(m13631a2.f10764f, i35, arrayList4.size(), false));
                                arrayList4.add(c1760aa);
                            }
                            i33 = i34 + 1;
                        }
                    }
                }
                c1759a.f10698i = (InterfaceC1813w[]) arrayList4.toArray(new InterfaceC1813w[arrayList4.size()]);
            }
        }
        m13623a(c1759a);
        if (this.f10787h.m13609c()) {
            m13626b(c1759a);
        }
        if (this.f10787h.m13610d() && c1759a.f10695f == EnumC1798h.PARSER) {
            c1759a.f10697h = new int[c1759a.f10692c.length];
            for (int i36 = 0; i36 < c1759a.f10692c.length; i36++) {
                c1759a.f10697h[i36] = c1759a.f10696g + i36 + 1;
            }
            int i37 = 0;
            while (true) {
                int i38 = i37;
                if (i38 < c1759a.f10692c.length) {
                    C1803m c1803m = new C1803m();
                    c1803m.f10799d = i38;
                    c1759a.m13487b(c1803m);
                    C1805o c1805o = new C1805o();
                    c1805o.f10799d = i38;
                    c1759a.m13487b(c1805o);
                    c1803m.f10814h = c1805o;
                    c1759a.m13482a((AbstractC1807q) c1803m);
                    c1805o.f10813h = c1803m;
                    if (c1759a.f10692c[i38].f10740i) {
                        abstractC1797g = null;
                        Iterator<AbstractC1797g> it = c1759a.f10690a.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            AbstractC1797g next = it.next();
                            if (next.f10799d == i38 && (next instanceof C1788bb)) {
                                AbstractC1797g abstractC1797g8 = next.m13631a(next.m13630a() - 1).f10764f;
                                if ((abstractC1797g8 instanceof C1768ai) && abstractC1797g8.f10800e && (abstractC1797g8.m13631a(0).f10764f instanceof C1781av)) {
                                    abstractC1797g = next;
                                    break;
                                }
                            }
                        }
                        if (abstractC1797g == null) {
                            throw new UnsupportedOperationException("Couldn't identify final state of the precedence rule prefix section.");
                        }
                        abstractC1791be = ((C1788bb) abstractC1797g).f10760h.m13631a(0);
                    } else {
                        abstractC1797g = c1759a.f10693d[i38];
                        abstractC1791be = null;
                    }
                    Iterator<AbstractC1797g> it2 = c1759a.f10690a.iterator();
                    while (it2.hasNext()) {
                        for (AbstractC1791be abstractC1791be2 : it2.next().f10801f) {
                            if (abstractC1791be2 != abstractC1791be && abstractC1791be2.f10764f == abstractC1797g) {
                                abstractC1791be2.f10764f = c1805o;
                            }
                        }
                    }
                    while (c1759a.f10692c[i38].m13630a() > 0) {
                        c1803m.m13633a(c1759a.f10692c[i38].m13634b(c1759a.f10692c[i38].m13630a() - 1));
                    }
                    c1759a.f10692c[i38].m13633a(new C1809s(c1803m));
                    c1805o.m13633a(new C1809s(abstractC1797g));
                    AbstractC1797g c1804n = new C1804n();
                    c1759a.m13487b(c1804n);
                    c1804n.m13633a(new C1802l(c1805o, c1759a.f10697h[i38]));
                    c1803m.m13633a(new C1809s(c1804n));
                    i37 = i38 + 1;
                } else if (this.f10787h.m13609c()) {
                    m13626b(c1759a);
                }
            }
        }
        return c1759a;
    }

    /* renamed from: a */
    private int m13613a(char[] cArr, int i, List<C1840j> list, a aVar) {
        int i2 = i + 1;
        int m13611a = m13611a(cArr[i]);
        for (int i3 = 0; i3 < m13611a; i3++) {
            int m13611a2 = m13611a(cArr[i2]);
            int i4 = i2 + 1;
            C1840j c1840j = new C1840j(new int[0]);
            list.add(c1840j);
            i2 = i4 + 1;
            if (m13611a(cArr[i4]) != 0) {
                c1840j.m13761b(-1);
            }
            for (int i5 = 0; i5 < m13611a2; i5++) {
                int mo13628a = aVar.mo13628a(cArr, i2);
                int mo13627a = i2 + aVar.mo13627a();
                int mo13628a2 = aVar.mo13628a(cArr, mo13627a);
                i2 = mo13627a + aVar.mo13627a();
                c1840j.m13762b(mo13628a, mo13628a2);
            }
        }
        return i2;
    }

    /* renamed from: a */
    protected void m13623a(C1759a c1759a) {
        for (AbstractC1797g abstractC1797g : c1759a.f10690a) {
            if ((abstractC1797g instanceof C1788bb) && c1759a.f10692c[abstractC1797g.f10799d].f10740i) {
                AbstractC1797g abstractC1797g2 = abstractC1797g.m13631a(abstractC1797g.m13630a() - 1).f10764f;
                if ((abstractC1797g2 instanceof C1768ai) && abstractC1797g2.f10800e && (abstractC1797g2.m13631a(0).f10764f instanceof C1781av)) {
                    ((C1788bb) abstractC1797g).f10761k = true;
                }
            }
        }
    }

    /* renamed from: b */
    protected void m13626b(C1759a c1759a) {
        for (AbstractC1797g abstractC1797g : c1759a.f10690a) {
            if (abstractC1797g != null) {
                m13624a(abstractC1797g.m13636c() || abstractC1797g.m13630a() <= 1);
                if (abstractC1797g instanceof C1772am) {
                    m13624a(((C1772am) abstractC1797g).f10721k != null);
                }
                if (abstractC1797g instanceof C1788bb) {
                    C1788bb c1788bb = (C1788bb) abstractC1797g;
                    m13624a(c1788bb.f10760h != null);
                    m13624a(c1788bb.m13630a() == 2);
                    if (c1788bb.m13631a(0).f10764f instanceof C1787ba) {
                        m13624a(c1788bb.m13631a(1).f10764f instanceof C1768ai);
                        m13624a(!c1788bb.f10816j);
                    } else if (c1788bb.m13631a(0).f10764f instanceof C1768ai) {
                        m13624a(c1788bb.m13631a(1).f10764f instanceof C1787ba);
                        m13624a(c1788bb.f10816j);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                if (abstractC1797g instanceof C1789bc) {
                    m13624a(abstractC1797g.m13630a() == 1);
                    m13624a(abstractC1797g.m13631a(0).f10764f instanceof C1788bb);
                }
                if (abstractC1797g instanceof C1768ai) {
                    m13624a(((C1768ai) abstractC1797g).f10710h != null);
                }
                if (abstractC1797g instanceof C1780au) {
                    m13624a(((C1780au) abstractC1797g).f10739h != null);
                }
                if (abstractC1797g instanceof AbstractC1806p) {
                    m13624a(((AbstractC1806p) abstractC1797g).f10814h != null);
                }
                if (abstractC1797g instanceof C1805o) {
                    m13624a(((C1805o) abstractC1797g).f10813h != null);
                }
                if (abstractC1797g instanceof AbstractC1807q) {
                    AbstractC1807q abstractC1807q = (AbstractC1807q) abstractC1797g;
                    m13624a(abstractC1807q.m13630a() <= 1 || abstractC1807q.f10815i >= 0);
                } else {
                    m13624a(abstractC1797g.m13630a() <= 1 || (abstractC1797g instanceof C1781av));
                }
            }
        }
    }

    /* renamed from: a */
    protected void m13624a(boolean z) {
        m13625a(z, (String) null);
    }

    /* renamed from: a */
    protected void m13625a(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    protected static int m13611a(char c2) {
        return c2;
    }

    /* renamed from: a */
    protected static int m13612a(char[] cArr, int i) {
        return cArr[i] | (cArr[i + 1] << 16);
    }

    /* renamed from: b */
    protected static long m13617b(char[] cArr, int i) {
        return (m13612a(cArr, i) & ExpandableListView.PACKED_POSITION_VALUE_NULL) | (m13612a(cArr, i + 2) << 32);
    }

    /* renamed from: c */
    protected static UUID m13618c(char[] cArr, int i) {
        return new UUID(m13617b(cArr, i + 4), m13617b(cArr, i));
    }

    /* renamed from: a */
    protected AbstractC1791be m13620a(C1759a c1759a, int i, int i2, int i3, int i4, int i5, int i6, List<C1840j> list) {
        AbstractC1797g abstractC1797g = c1759a.f10690a.get(i3);
        switch (i) {
            case 1:
                return new C1809s(abstractC1797g);
            case 2:
                if (i6 != 0) {
                    return new C1779at(abstractC1797g, -1, i5);
                }
                return new C1779at(abstractC1797g, i4, i5);
            case 3:
                return new C1782aw((C1780au) c1759a.f10690a.get(i4), i5, i6, abstractC1797g);
            case 4:
                return new C1775ap(abstractC1797g, i4, i5, i6 != 0);
            case 5:
                if (i6 != 0) {
                    return new C1802l(abstractC1797g, -1);
                }
                return new C1802l(abstractC1797g, i4);
            case 6:
                return new C1800j(abstractC1797g, i4, i5, i6 != 0);
            case 7:
                return new C1784ay(abstractC1797g, list.get(i4));
            case 8:
                return new C1769aj(abstractC1797g, list.get(i4));
            case 9:
                return new C1792bf(abstractC1797g);
            case 10:
                return new C1774ao(abstractC1797g, i4);
            default:
                throw new IllegalArgumentException("The specified transition type is not valid.");
        }
    }

    /* renamed from: a */
    protected AbstractC1797g m13621a(int i, int i2) {
        AbstractC1797g c1768ai;
        switch (i) {
            case 0:
                return null;
            case 1:
                c1768ai = new C1804n();
                break;
            case 2:
                c1768ai = new C1780au();
                break;
            case 3:
                c1768ai = new C1803m();
                break;
            case 4:
                c1768ai = new C1772am();
                break;
            case 5:
                c1768ai = new C1787ba();
                break;
            case 6:
                c1768ai = new C1790bd();
                break;
            case 7:
                c1768ai = new C1781av();
                break;
            case 8:
                c1768ai = new C1805o();
                break;
            case 9:
                c1768ai = new C1789bc();
                break;
            case 10:
                c1768ai = new C1788bb();
                break;
            case 11:
                c1768ai = new C1773an();
                break;
            case 12:
                c1768ai = new C1768ai();
                break;
            default:
                throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified state type %d is not valid.", Integer.valueOf(i)));
        }
        c1768ai.f10799d = i2;
        return c1768ai;
    }

    /* renamed from: a */
    protected InterfaceC1813w m13622a(EnumC1815y enumC1815y, int i, int i2) {
        switch (m13616a()[enumC1815y.ordinal()]) {
            case 1:
                return new C1816z(i);
            case 2:
                return new C1760aa(i, i2);
            case 3:
                return new C1762ac(i);
            case 4:
                return C1763ad.f10705a;
            case 5:
                return C1764ae.f10706a;
            case 6:
                return new C1765af(i);
            case 7:
                return C1766ag.f10708a;
            case 8:
                return new C1767ah(i);
            default:
                throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified lexer action type %d is not valid.", enumC1815y));
        }
    }
}
