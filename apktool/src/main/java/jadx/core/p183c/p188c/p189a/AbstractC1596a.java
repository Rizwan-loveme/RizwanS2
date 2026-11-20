package jadx.core.p183c.p188c.p189a;

import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.p192a.C1634f;
import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: ArgType.java */
/* renamed from: jadx.core.c.c.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1596a {

    /* renamed from: a */
    public static final AbstractC1596a f10125a = m12269c(EnumC1603h.INT);

    /* renamed from: b */
    public static final AbstractC1596a f10126b = m12269c(EnumC1603h.BOOLEAN);

    /* renamed from: c */
    public static final AbstractC1596a f10127c = m12269c(EnumC1603h.BYTE);

    /* renamed from: d */
    public static final AbstractC1596a f10128d = m12269c(EnumC1603h.SHORT);

    /* renamed from: e */
    public static final AbstractC1596a f10129e = m12269c(EnumC1603h.CHAR);

    /* renamed from: f */
    public static final AbstractC1596a f10130f = m12269c(EnumC1603h.FLOAT);

    /* renamed from: g */
    public static final AbstractC1596a f10131g = m12269c(EnumC1603h.DOUBLE);

    /* renamed from: h */
    public static final AbstractC1596a f10132h = m12269c(EnumC1603h.LONG);

    /* renamed from: i */
    public static final AbstractC1596a f10133i = m12269c(EnumC1603h.VOID);

    /* renamed from: j */
    public static final AbstractC1596a f10134j = m12263a("java.lang.Object");

    /* renamed from: k */
    public static final AbstractC1596a f10135k = m12263a("java.lang.Class");

    /* renamed from: l */
    public static final AbstractC1596a f10136l = m12263a("java.lang.String");

    /* renamed from: m */
    public static final AbstractC1596a f10137m = m12263a("java.lang.Enum");

    /* renamed from: n */
    public static final AbstractC1596a f10138n = m12263a("java.lang.Throwable");

    /* renamed from: o */
    public static final AbstractC1596a f10139o = m12265a(EnumC1603h.valuesCustom());

    /* renamed from: p */
    public static final AbstractC1596a f10140p = m12265a(EnumC1603h.OBJECT, EnumC1603h.ARRAY);

    /* renamed from: q */
    public static final AbstractC1596a f10141q = m12265a(EnumC1603h.INT, EnumC1603h.FLOAT, EnumC1603h.BOOLEAN, EnumC1603h.SHORT, EnumC1603h.BYTE, EnumC1603h.CHAR, EnumC1603h.OBJECT, EnumC1603h.ARRAY);

    /* renamed from: r */
    public static final AbstractC1596a f10142r = m12265a(EnumC1603h.INT, EnumC1603h.FLOAT, EnumC1603h.BOOLEAN, EnumC1603h.SHORT, EnumC1603h.BYTE, EnumC1603h.CHAR);

    /* renamed from: s */
    public static final AbstractC1596a f10143s = m12265a(EnumC1603h.LONG, EnumC1603h.DOUBLE);

    /* renamed from: t */
    protected int f10144t;

    /* renamed from: a */
    public abstract boolean mo12274a(EnumC1603h enumC1603h);

    /* renamed from: a */
    abstract boolean mo12275a(Object obj);

    /* renamed from: p */
    public abstract AbstractC1596a mo12290p();

    /* renamed from: q */
    public abstract EnumC1603h[] mo12291q();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static AbstractC1596a m12269c(EnumC1603h enumC1603h) {
        return new f(enumC1603h);
    }

    /* renamed from: a */
    public static AbstractC1596a m12263a(String str) {
        return new e(str);
    }

    /* renamed from: b */
    public static AbstractC1596a m12267b(String str) {
        return new c(str);
    }

    /* renamed from: a */
    public static AbstractC1596a m12256a() {
        return new h(f10134j, 0);
    }

    /* renamed from: a */
    public static AbstractC1596a m12259a(AbstractC1596a abstractC1596a, int i) {
        return new h(abstractC1596a, i);
    }

    /* renamed from: c */
    public static AbstractC1596a m12270c(String str) {
        return new C1634f(str).m12499a();
    }

    /* renamed from: a */
    public static AbstractC1596a m12264a(String str, AbstractC1596a[] abstractC1596aArr) {
        return new b(str, abstractC1596aArr);
    }

    /* renamed from: a */
    public static AbstractC1596a m12260a(AbstractC1596a abstractC1596a, String str, AbstractC1596a[] abstractC1596aArr) {
        return new b((b) abstractC1596a, str, abstractC1596aArr);
    }

    /* renamed from: a */
    public static AbstractC1596a m12258a(AbstractC1596a abstractC1596a) {
        return new a(abstractC1596a);
    }

    /* renamed from: a */
    public static AbstractC1596a m12265a(EnumC1603h... enumC1603hArr) {
        return new g(enumC1603hArr);
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$d */
    private static abstract class d extends AbstractC1596a {

        /* renamed from: u */
        private static final EnumC1603h[] f10149u = new EnumC1603h[0];

        private d() {
        }

        /* synthetic */ d(d dVar) {
            this();
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: b */
        public boolean mo12276b() {
            return true;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        public boolean mo12274a(EnumC1603h enumC1603h) {
            return mo12277c() == enumC1603h;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: p */
        public AbstractC1596a mo12290p() {
            return null;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: q */
        public EnumC1603h[] mo12291q() {
            return f10149u;
        }
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$f */
    private static final class f extends d {

        /* renamed from: u */
        private final EnumC1603h f10151u;

        public f(EnumC1603h enumC1603h) {
            super(null);
            this.f10151u = enumC1603h;
            this.f10144t = enumC1603h.hashCode();
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: c */
        public EnumC1603h mo12277c() {
            return this.f10151u;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: d */
        public boolean mo12278d() {
            return true;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        boolean mo12275a(Object obj) {
            return this.f10151u == ((f) obj).f10151u;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        public String toString() {
            return this.f10151u.toString();
        }
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$e */
    private static class e extends d {

        /* renamed from: u */
        private final String f10150u;

        public e(String str) {
            super(null);
            this.f10150u = C1745n.m13311a(str);
            this.f10144t = this.f10150u.hashCode();
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: e */
        public String mo12279e() {
            return this.f10150u;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: f */
        public boolean mo12280f() {
            return true;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: c */
        public EnumC1603h mo12277c() {
            return EnumC1603h.OBJECT;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        boolean mo12275a(Object obj) {
            return this.f10150u.equals(((e) obj).f10150u);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        public String toString() {
            return this.f10150u;
        }
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$c */
    private static final class c extends e {
        public c(String str) {
            super(str);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: h */
        public boolean mo12282h() {
            return true;
        }
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$h */
    private static final class h extends e {

        /* renamed from: u */
        private final AbstractC1596a f10153u;

        /* renamed from: v */
        private final int f10154v;

        public h(AbstractC1596a abstractC1596a, int i) {
            super(f10134j.mo12279e());
            this.f10153u = abstractC1596a;
            this.f10154v = i;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: g */
        public boolean mo12281g() {
            return true;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: j */
        public AbstractC1596a mo12284j() {
            return this.f10153u;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: k */
        public int mo12285k() {
            return this.f10154v;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a.e, jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        boolean mo12275a(Object obj) {
            return super.mo12275a(obj) && this.f10154v == ((h) obj).f10154v && this.f10153u.equals(((h) obj).f10153u);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a.e, jadx.core.p183c.p188c.p189a.AbstractC1596a
        public String toString() {
            if (this.f10154v == 0) {
                return "?";
            }
            return "? " + (this.f10154v == -1 ? "super" : "extends") + " " + this.f10153u;
        }
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$b */
    private static class b extends e {

        /* renamed from: u */
        private final AbstractC1596a[] f10147u;

        /* renamed from: v */
        private final b f10148v;

        public b(String str, AbstractC1596a[] abstractC1596aArr) {
            super(str);
            this.f10148v = null;
            this.f10147u = abstractC1596aArr;
            this.f10144t = str.hashCode() + (Arrays.hashCode(abstractC1596aArr) * 31);
        }

        public b(b bVar, String str, AbstractC1596a[] abstractC1596aArr) {
            super(String.valueOf(bVar.mo12279e()) + "$" + str);
            this.f10148v = bVar;
            this.f10147u = abstractC1596aArr;
            this.f10144t = bVar.hashCode() + (str.hashCode() * 31) + (Arrays.hashCode(abstractC1596aArr) * 961);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: g */
        public boolean mo12281g() {
            return true;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: i */
        public AbstractC1596a[] mo12283i() {
            return this.f10147u;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a.e, jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        boolean mo12275a(Object obj) {
            return super.mo12275a(obj) && Arrays.equals(this.f10147u, ((b) obj).f10147u);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a.e, jadx.core.p183c.p188c.p189a.AbstractC1596a
        public String toString() {
            return String.valueOf(super.toString()) + "<" + C1745n.m13313a(this.f10147u) + ">";
        }
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$a */
    private static final class a extends d {

        /* renamed from: u */
        private static final EnumC1603h[] f10145u = {EnumC1603h.ARRAY};

        /* renamed from: v */
        private final AbstractC1596a f10146v;

        public a(AbstractC1596a abstractC1596a) {
            super(null);
            this.f10146v = abstractC1596a;
            this.f10144t = abstractC1596a.hashCode();
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: n */
        public AbstractC1596a mo12288n() {
            return this.f10146v;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: l */
        public boolean mo12286l() {
            return true;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: c */
        public EnumC1603h mo12277c() {
            return EnumC1603h.ARRAY;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a.d, jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: b */
        public boolean mo12276b() {
            return this.f10146v.mo12276b();
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a.d, jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: p */
        public AbstractC1596a mo12290p() {
            return m12258a(this.f10146v.mo12290p());
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a.d, jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: q */
        public EnumC1603h[] mo12291q() {
            return f10145u;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: m */
        public int mo12287m() {
            return this.f10146v.mo12287m() + 1;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: o */
        public AbstractC1596a mo12289o() {
            return this.f10146v.mo12289o();
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        boolean mo12275a(Object obj) {
            return this.f10146v.equals(((a) obj).f10146v);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        public String toString() {
            return this.f10146v + "[]";
        }
    }

    /* compiled from: ArgType.java */
    /* renamed from: jadx.core.c.c.a.a$g */
    private static final class g extends AbstractC1596a {

        /* renamed from: u */
        private final EnumC1603h[] f10152u;

        public g(EnumC1603h[] enumC1603hArr) {
            this.f10152u = enumC1603hArr;
            this.f10144t = Arrays.hashCode(this.f10152u);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: q */
        public EnumC1603h[] mo12291q() {
            return this.f10152u;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: b */
        public boolean mo12276b() {
            return false;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        public boolean mo12274a(EnumC1603h enumC1603h) {
            for (EnumC1603h enumC1603h2 : this.f10152u) {
                if (enumC1603h2 == enumC1603h) {
                    return true;
                }
            }
            return false;
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: p */
        public AbstractC1596a mo12290p() {
            EnumC1603h enumC1603h = this.f10152u[0];
            if (mo12274a(EnumC1603h.OBJECT)) {
                return f10134j;
            }
            if (!mo12274a(EnumC1603h.ARRAY)) {
                return AbstractC1596a.m12269c(enumC1603h);
            }
            return m12258a(f10134j);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        /* renamed from: a */
        boolean mo12275a(Object obj) {
            return Arrays.equals(this.f10152u, ((g) obj).f10152u);
        }

        @Override // jadx.core.p183c.p188c.p189a.AbstractC1596a
        public String toString() {
            return this.f10152u.length == EnumC1603h.valuesCustom().length ? "?" : "?" + Arrays.toString(this.f10152u);
        }
    }

    /* renamed from: b */
    public boolean mo12276b() {
        return false;
    }

    /* renamed from: c */
    public EnumC1603h mo12277c() {
        return null;
    }

    /* renamed from: d */
    public boolean mo12278d() {
        return false;
    }

    /* renamed from: e */
    public String mo12279e() {
        throw new UnsupportedOperationException("ArgType.getObject(), call class: " + getClass());
    }

    /* renamed from: f */
    public boolean mo12280f() {
        return false;
    }

    /* renamed from: g */
    public boolean mo12281g() {
        return false;
    }

    /* renamed from: h */
    public boolean mo12282h() {
        return false;
    }

    /* renamed from: i */
    public AbstractC1596a[] mo12283i() {
        return null;
    }

    /* renamed from: j */
    public AbstractC1596a mo12284j() {
        return null;
    }

    /* renamed from: k */
    public int mo12285k() {
        return 0;
    }

    /* renamed from: l */
    public boolean mo12286l() {
        return false;
    }

    /* renamed from: m */
    public int mo12287m() {
        return 0;
    }

    /* renamed from: n */
    public AbstractC1596a mo12288n() {
        return null;
    }

    /* renamed from: o */
    public AbstractC1596a mo12289o() {
        return this;
    }

    /* renamed from: a */
    public static AbstractC1596a m12262a(C1637c c1637c, AbstractC1596a abstractC1596a, AbstractC1596a abstractC1596a2) {
        if (abstractC1596a == null || abstractC1596a2 == null) {
            return null;
        }
        if (!abstractC1596a.equals(abstractC1596a2)) {
            AbstractC1596a m12272d = m12272d(c1637c, abstractC1596a, abstractC1596a2);
            if (m12272d == null) {
                m12272d = m12272d(c1637c, abstractC1596a2, abstractC1596a);
            }
            return m12272d;
        }
        return abstractC1596a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private static AbstractC1596a m12272d(C1637c c1637c, AbstractC1596a abstractC1596a, AbstractC1596a abstractC1596a2) {
        String m13182b;
        if (abstractC1596a == f10139o) {
            return abstractC1596a2;
        }
        if (abstractC1596a.mo12286l()) {
            return m12261a(c1637c, (a) abstractC1596a, abstractC1596a2);
        }
        if (abstractC1596a2.mo12286l()) {
            return m12261a(c1637c, (a) abstractC1596a2, abstractC1596a);
        }
        if (!abstractC1596a.mo12276b()) {
            if (abstractC1596a2.mo12276b()) {
                if (abstractC1596a.mo12274a(abstractC1596a2.mo12277c())) {
                    return abstractC1596a2;
                }
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (EnumC1603h enumC1603h : abstractC1596a.mo12291q()) {
                if (abstractC1596a2.mo12274a(enumC1603h)) {
                    arrayList.add(enumC1603h);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            if (arrayList.size() == 1) {
                EnumC1603h enumC1603h2 = (EnumC1603h) arrayList.get(0);
                return (enumC1603h2 == EnumC1603h.OBJECT || enumC1603h2 == EnumC1603h.ARRAY) ? m12265a(enumC1603h2) : m12269c(enumC1603h2);
            }
            return m12265a((EnumC1603h[]) arrayList.toArray(new EnumC1603h[arrayList.size()]));
        }
        if (abstractC1596a.mo12282h()) {
            return abstractC1596a;
        }
        if (abstractC1596a2.mo12282h()) {
            return abstractC1596a2;
        }
        if (abstractC1596a.mo12280f() && abstractC1596a2.mo12280f()) {
            String mo12279e = abstractC1596a.mo12279e();
            String mo12279e2 = abstractC1596a2.mo12279e();
            if (mo12279e.equals(mo12279e2)) {
                if (abstractC1596a.mo12283i() == null) {
                    abstractC1596a = abstractC1596a2;
                }
                return abstractC1596a;
            }
            if (mo12279e.equals("java.lang.Object")) {
                return abstractC1596a2;
            }
            if (mo12279e2.equals("java.lang.Object")) {
                return abstractC1596a;
            }
            if (c1637c == null || (m13182b = c1637c.mo12541u().m12661c().m13182b(mo12279e, mo12279e2)) == null) {
                return null;
            }
            return m12263a(m13182b);
        }
        if (abstractC1596a.mo12278d() && abstractC1596a2.mo12278d() && abstractC1596a.m12292r() == abstractC1596a2.m12292r()) {
            return m12269c(EnumC1603h.m12321a(abstractC1596a.mo12277c(), abstractC1596a2.mo12277c()));
        }
        return null;
    }

    /* renamed from: a */
    private static AbstractC1596a m12261a(C1637c c1637c, a aVar, AbstractC1596a abstractC1596a) {
        if (abstractC1596a.mo12286l()) {
            AbstractC1596a mo12288n = aVar.mo12288n();
            AbstractC1596a mo12288n2 = abstractC1596a.mo12288n();
            if (mo12288n.mo12278d() && mo12288n2.mo12278d()) {
                return f10134j;
            }
            AbstractC1596a m12262a = m12262a(c1637c, mo12288n, mo12288n2);
            if (m12262a != null) {
                return m12258a(m12262a);
            }
            return null;
        }
        if (abstractC1596a.mo12274a(EnumC1603h.ARRAY)) {
            return aVar;
        }
        if (abstractC1596a.equals(f10134j)) {
            return f10134j;
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m12268b(C1637c c1637c, AbstractC1596a abstractC1596a, AbstractC1596a abstractC1596a2) {
        if (abstractC1596a.equals(abstractC1596a2)) {
            return false;
        }
        return (abstractC1596a.mo12280f() && abstractC1596a2.mo12280f() && c1637c.mo12541u().m12661c().m13181a(abstractC1596a.mo12279e(), abstractC1596a2.mo12279e())) ? false : true;
    }

    /* renamed from: c */
    public static boolean m12271c(C1637c c1637c, AbstractC1596a abstractC1596a, AbstractC1596a abstractC1596a2) {
        if (abstractC1596a.equals(abstractC1596a2)) {
            return true;
        }
        if (!abstractC1596a.mo12280f() || !abstractC1596a2.mo12280f()) {
            return false;
        }
        return c1637c.mo12541u().m12661c().m13181a(abstractC1596a.mo12279e(), abstractC1596a2.mo12279e());
    }

    /* renamed from: d */
    public static AbstractC1596a m12273d(String str) {
        char charAt = str.charAt(0);
        switch (charAt) {
            case 'L':
                return m12263a(str);
            case 'T':
                return m12267b(str.substring(1, str.length() - 1));
            case '[':
                return m12258a(m12273d(str.substring(1)));
            default:
                return m12257a(charAt);
        }
    }

    /* renamed from: a */
    public static AbstractC1596a m12257a(char c2) {
        switch (c2) {
            case 'B':
                return f10127c;
            case 'C':
                return f10129e;
            case 'D':
                return f10131g;
            case 'F':
                return f10130f;
            case 'I':
                return f10125a;
            case 'J':
                return f10132h;
            case 'S':
                return f10128d;
            case 'V':
                return f10133i;
            case 'Z':
                return f10126b;
            default:
                return null;
        }
    }

    /* renamed from: r */
    public int m12292r() {
        if (!mo12278d()) {
            return !mo12276b() ? 0 : 1;
        }
        EnumC1603h mo12277c = mo12277c();
        return (mo12277c == EnumC1603h.LONG || mo12277c == EnumC1603h.DOUBLE) ? 2 : 1;
    }

    public String toString() {
        return "ARG_TYPE";
    }

    public int hashCode() {
        return this.f10144t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && this.f10144t == obj.hashCode() && getClass() == obj.getClass()) {
            return mo12275a(obj);
        }
        return false;
    }
}
