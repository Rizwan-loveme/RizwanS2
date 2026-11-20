package jadx.core.p183c.p187b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.EnumC1603h;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.p192a.C1632d;
import jadx.core.p203d.C1735d;
import jadx.p180a.C1534b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ConstStorage.java */
/* renamed from: jadx.core.c.b.c */
/* loaded from: classes.dex */
public class C1591c {

    /* renamed from: e */
    private static /* synthetic */ int[] f10103e;

    /* renamed from: a */
    private final boolean f10104a;

    /* renamed from: b */
    private final a f10105b = new a(null);

    /* renamed from: c */
    private final Map<C1636b, a> f10106c = new HashMap();

    /* renamed from: d */
    private Map<Integer, String> f10107d = new HashMap();

    /* renamed from: a */
    static /* synthetic */ int[] m12215a() {
        int[] iArr = f10103e;
        if (iArr == null) {
            iArr = new int[EnumC1603h.valuesCustom().length];
            try {
                iArr[EnumC1603h.ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1603h.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC1603h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC1603h.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC1603h.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumC1603h.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EnumC1603h.INT.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EnumC1603h.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EnumC1603h.OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EnumC1603h.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EnumC1603h.VOID.ordinal()] = 11;
            } catch (NoSuchFieldError e12) {
            }
            f10103e = iArr;
        }
        return iArr;
    }

    /* compiled from: ConstStorage.java */
    /* renamed from: jadx.core.c.b.c$a */
    private static final class a {

        /* renamed from: a */
        private final Map<Object, C1639e> f10108a;

        /* renamed from: b */
        private final Set<Object> f10109b;

        private a() {
            this.f10108a = new HashMap();
            this.f10109b = new HashSet();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* renamed from: a */
        public C1639e m12220a(Object obj) {
            return this.f10108a.get(obj);
        }

        /* renamed from: a */
        public boolean m12221a(Object obj, C1639e c1639e) {
            if (this.f10108a.put(obj, c1639e) != null) {
                this.f10108a.remove(obj);
                this.f10109b.add(obj);
                return true;
            }
            if (this.f10109b.contains(obj)) {
                this.f10108a.remove(obj);
                return true;
            }
            return false;
        }

        /* renamed from: b */
        public boolean m12222b(Object obj) {
            return this.f10109b.contains(obj) || this.f10108a.containsKey(obj);
        }
    }

    public C1591c(C1534b c1534b) {
        this.f10104a = c1534b.m11782q();
    }

    /* renamed from: a */
    public void m12218a(C1636b c1636b, List<C1639e> list) {
        C1632d c1632d;
        if (this.f10104a && !list.isEmpty()) {
            for (C1639e c1639e : list) {
                C1589a m12566g = c1639e.m12566g();
                if (m12566g.m12179h() && m12566g.m12180i() && (c1632d = (C1632d) c1639e.mo12146b(C1566b.f10037k)) != null && c1632d.m12470a() != null && c1632d.m12472d() == C1632d.a.CONST && c1632d != C1632d.f10319a) {
                    m12214a(c1636b, c1639e, c1632d.m12470a(), m12566g.m12170a());
                }
            }
        }
    }

    /* renamed from: a */
    private void m12214a(C1636b c1636b, C1639e c1639e, Object obj, boolean z) {
        if (z) {
            this.f10105b.m12221a(obj, c1639e);
        } else {
            m12212a(c1636b).m12221a(obj, c1639e);
        }
    }

    /* renamed from: a */
    private a m12212a(C1636b c1636b) {
        a aVar = this.f10106c.get(c1636b);
        if (aVar == null) {
            a aVar2 = new a(null);
            this.f10106c.put(c1636b, aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* renamed from: a */
    public C1639e m12217a(C1636b c1636b, Object obj, boolean z) {
        C1639e m12220a;
        C1639e m12213a;
        if (!this.f10104a) {
            return null;
        }
        C1637c mo12540t = c1636b.mo12540t();
        if (!(obj instanceof Integer) || (m12213a = m12213a((Integer) obj, mo12540t)) == null) {
            boolean m12222b = this.f10105b.m12222b(obj);
            if (m12222b && !z) {
                return null;
            }
            while (c1636b != null) {
                a aVar = this.f10106c.get(c1636b);
                if (aVar != null && (m12220a = aVar.m12220a(obj)) != null) {
                    if (m12222b) {
                        return null;
                    }
                    return m12220a;
                }
                C1590b m12208j = c1636b.m12544x().m12208j();
                if (m12208j == null) {
                    break;
                }
                c1636b = mo12540t.m12557b(m12208j);
            }
            if (z) {
                return this.f10105b.m12220a(obj);
            }
            return null;
        }
        return m12213a;
    }

    /* renamed from: a */
    private C1639e m12213a(Integer num, C1637c c1637c) {
        C1636b m12664f;
        String str = this.f10107d.get(num);
        if (str != null && (m12664f = c1637c.mo12541u().m12664f()) != null) {
            String[] split = str.split("/", 2);
            if (split.length != 2) {
                return null;
            }
            String str2 = split[0];
            String str3 = split[1];
            for (C1636b c1636b : m12664f.m12534n()) {
                if (c1636b.m12546z().equals(str2)) {
                    return c1636b.m12524b(str3);
                }
            }
            C1735d.m13254a(m12664f, "Not found resource field with id: " + num + ", name: " + str.replace('/', '.'));
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public C1639e m12216a(C1636b c1636b, C1600e c1600e) {
        EnumC1603h mo12277c = c1600e.m12359s().mo12277c();
        if (mo12277c == null) {
            return null;
        }
        long m12317d = c1600e.m12317d();
        switch (m12215a()[mo12277c.ordinal()]) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                float intBitsToFloat = Float.intBitsToFloat((int) m12317d);
                break;
            case 7:
                break;
            case 8:
                double longBitsToDouble = Double.longBitsToDouble(m12317d);
                break;
        }
        return null;
    }

    /* renamed from: a */
    public void m12219a(Map<Integer, String> map) {
        this.f10107d = map;
    }
}
