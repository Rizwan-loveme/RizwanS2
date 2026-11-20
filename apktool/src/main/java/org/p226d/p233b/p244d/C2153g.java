package org.p226d.p233b.p244d;

import com.p129f.p130a.p135e.C1213a;
import java.p209io.InputStream;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p244d.p246b.C2117a;
import org.p226d.p233b.p244d.p246b.C2118b;
import org.p226d.p233b.p244d.p248d.AbstractC2133d;
import org.p226d.p233b.p244d.p248d.AbstractC2134e;
import org.p226d.p233b.p250e.InterfaceC2264e;
import org.p226d.p233b.p263h.C2382b;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedDexFile.java */
/* renamed from: org.d.b.d.g */
/* loaded from: classes.dex */
public class C2153g extends C2077a implements InterfaceC2264e {

    /* renamed from: c */
    private final C2359g f12002c;

    /* renamed from: d */
    private final int f12003d;

    /* renamed from: e */
    private final int f12004e;

    /* renamed from: f */
    private final int f12005f;

    /* renamed from: g */
    private final int f12006g;

    /* renamed from: h */
    private final int f12007h;

    /* renamed from: i */
    private final int f12008i;

    /* renamed from: j */
    private final int f12009j;

    /* renamed from: k */
    private final int f12010k;

    /* renamed from: l */
    private final int f12011l;

    /* renamed from: m */
    private final int f12012m;

    /* renamed from: n */
    private final int f12013n;

    /* renamed from: o */
    private final int f12014o;

    /* renamed from: p */
    private final int f12015p;

    protected C2153g(C2359g c2359g, byte[] bArr, int i, boolean z) {
        super(bArr, i);
        int m14657b;
        if (z) {
            m14657b = C2382b.m15074a(bArr, i);
        } else {
            m14657b = C2117a.m14657b(bArr, i);
        }
        if (c2359g == null) {
            this.f12002c = C2359g.m15025c(m14657b);
        } else {
            this.f12002c = c2359g;
        }
        this.f12003d = m14615a(56);
        this.f12004e = m14615a(60);
        this.f12005f = m14615a(64);
        this.f12006g = m14615a(68);
        this.f12007h = m14615a(72);
        this.f12008i = m14615a(76);
        this.f12009j = m14615a(80);
        this.f12010k = m14615a(84);
        this.f12011l = m14615a(88);
        this.f12012m = m14615a(92);
        this.f12013n = m14615a(96);
        this.f12014o = m14615a(100);
        this.f12015p = m14615a(52);
    }

    public C2153g(C2359g c2359g, byte[] bArr, int i) {
        this(c2359g, bArr, i, false);
    }

    public C2153g(C2359g c2359g, byte[] bArr) {
        this(c2359g, bArr, 0, true);
    }

    /* renamed from: a */
    public static C2153g m14765a(C2359g c2359g, InputStream inputStream) {
        C2382b.m15073a(inputStream);
        return new C2153g(c2359g, C1213a.m10161a(inputStream), 0, false);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2264e
    /* renamed from: a */
    public C2359g mo14767a() {
        return this.f12002c;
    }

    /* renamed from: b */
    public boolean mo14768b() {
        return false;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2264e
    /* renamed from: c */
    public Set<? extends C2152f> mo14769c() {
        return new AbstractC2134e<C2152f>() { // from class: org.d.b.d.g.1
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2134e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C2152f mo14702b(int i) {
                return new C2152f(C2153g.this, C2153g.this.m14776o(i));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2153g.this.f12013n;
            }
        };
    }

    /* renamed from: j */
    public int m14771j(int i) {
        if (i < 0 || i >= this.f12003d) {
            throw new a(i, "String index out of bounds: %d", Integer.valueOf(i));
        }
        return this.f12004e + (i * 4);
    }

    /* renamed from: k */
    public int m14772k(int i) {
        if (i < 0 || i >= this.f12005f) {
            throw new a(i, "Type index out of bounds: %d", Integer.valueOf(i));
        }
        return this.f12006g + (i * 4);
    }

    /* renamed from: l */
    public int m14773l(int i) {
        if (i < 0 || i >= this.f12009j) {
            throw new a(i, "Field index out of bounds: %d", Integer.valueOf(i));
        }
        return this.f12010k + (i * 8);
    }

    /* renamed from: m */
    public int m14774m(int i) {
        if (i < 0 || i >= this.f12011l) {
            throw new a(i, "Method index out of bounds: %d", Integer.valueOf(i));
        }
        return this.f12012m + (i * 8);
    }

    /* renamed from: n */
    public int m14775n(int i) {
        if (i < 0 || i >= this.f12007h) {
            throw new a(i, "Proto index out of bounds: %d", Integer.valueOf(i));
        }
        return this.f12008i + (i * 12);
    }

    /* renamed from: o */
    public int m14776o(int i) {
        if (i < 0 || i >= this.f12013n) {
            throw new a(i, "Class index out of bounds: %d", Integer.valueOf(i));
        }
        return this.f12014o + (i * 32);
    }

    /* renamed from: p */
    public int m14777p(int i) {
        C2118b m14784w = m14784w(7);
        if (m14784w == null || i >= m14784w.m14663b()) {
            throw new a(i, "Call site index out of bounds: %d", Integer.valueOf(i));
        }
        return m14784w.m14664c() + (i * 4);
    }

    /* renamed from: q */
    public int m14778q(int i) {
        C2118b m14784w = m14784w(8);
        if (m14784w == null || i >= m14784w.m14663b()) {
            throw new a(i, "Method handle index out of bounds: %d", Integer.valueOf(i));
        }
        return m14784w.m14664c() + (i * 8);
    }

    /* renamed from: r */
    public String m14779r(int i) {
        C2161o m14783v = m14783v(m14615a(m14771j(i)));
        return m14783v.m14650h(m14783v.m14639c());
    }

    /* renamed from: s */
    public String m14780s(int i) {
        if (i == -1) {
            return null;
        }
        return m14779r(i);
    }

    /* renamed from: t */
    public String m14781t(int i) {
        return m14779r(m14615a(m14772k(i)));
    }

    /* renamed from: u */
    public String m14782u(int i) {
        if (i == -1) {
            return null;
        }
        return m14781t(i);
    }

    /* renamed from: v */
    public C2161o m14783v(int i) {
        return new C2161o(this, i);
    }

    /* renamed from: d */
    public List<C2118b> m14770d() {
        final int a2 = m14615a(this.f12015p);
        return new AbstractC2133d<C2118b>() { // from class: org.d.b.d.g.2
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C2118b mo14625b(int i) {
                return new C2118b(C2153g.this, C2153g.this.f12015p + 4 + (i * 12));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a2;
            }
        };
    }

    /* renamed from: w */
    public C2118b m14784w(int i) {
        for (C2118b c2118b : m14770d()) {
            if (c2118b.m14662a() == i) {
                return c2118b;
            }
        }
        return null;
    }

    /* compiled from: DexBackedDexFile.java */
    /* renamed from: org.d.b.d.g$b */
    public static class b extends RuntimeException {
        public b() {
        }

        public b(String str) {
            super(str);
        }
    }

    /* compiled from: DexBackedDexFile.java */
    /* renamed from: org.d.b.d.g$a */
    public static class a extends C2453g {

        /* renamed from: a */
        private final int f12019a;

        public a(int i, String str, Object... objArr) {
            super(str, objArr);
            this.f12019a = i;
        }

        /* renamed from: a */
        public int m14787a() {
            return this.f12019a;
        }
    }
}
