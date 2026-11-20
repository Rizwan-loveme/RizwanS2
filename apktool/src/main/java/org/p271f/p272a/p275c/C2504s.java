package org.p271f.p272a.p275c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.p271f.p272a.AbstractC2473a;
import org.p271f.p272a.AbstractC2515g;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2512d;
import org.p271f.p272a.C2522n;
import org.p271f.p272a.C2525q;
import org.p271f.p272a.C2529u;
import org.p271f.p272a.C2530v;

/* compiled from: MethodNode.java */
/* renamed from: org.f.a.c.s */
/* loaded from: classes.dex */
public class C2504s extends AbstractC2526r {

    /* renamed from: c */
    public int f13044c;

    /* renamed from: d */
    public String f13045d;

    /* renamed from: e */
    public String f13046e;

    /* renamed from: f */
    public String f13047f;

    /* renamed from: g */
    public List<String> f13048g;

    /* renamed from: h */
    public List<C2506u> f13049h;

    /* renamed from: i */
    public List<C2487b> f13050i;

    /* renamed from: j */
    public List<C2487b> f13051j;

    /* renamed from: k */
    public List<C2509x> f13052k;

    /* renamed from: l */
    public List<C2509x> f13053l;

    /* renamed from: m */
    public List<C2512d> f13054m;

    /* renamed from: n */
    public Object f13055n;

    /* renamed from: o */
    public List<C2487b>[] f13056o;

    /* renamed from: p */
    public List<C2487b>[] f13057p;

    /* renamed from: q */
    public C2492g f13058q;

    /* renamed from: r */
    public List<C2508w> f13059r;

    /* renamed from: s */
    public int f13060s;

    /* renamed from: t */
    public int f13061t;

    /* renamed from: u */
    public List<C2501p> f13062u;

    /* renamed from: v */
    public List<C2500o> f13063v;

    /* renamed from: w */
    public List<C2500o> f13064w;

    /* renamed from: x */
    private boolean f13065x;

    public C2504s() {
        this(327680);
        if (getClass() != C2504s.class) {
            throw new IllegalStateException();
        }
    }

    public C2504s(int i) {
        super(i);
        this.f13058q = new C2492g();
    }

    public C2504s(int i, int i2, String str, String str2, String str3, String[] strArr) {
        super(i);
        this.f13044c = i2;
        this.f13045d = str;
        this.f13046e = str2;
        this.f13047f = str3;
        this.f13048g = new ArrayList(strArr == null ? 0 : strArr.length);
        if (!((i2 & 1024) != 0)) {
            this.f13062u = new ArrayList(5);
        }
        this.f13059r = new ArrayList();
        if (strArr != null) {
            this.f13048g.addAll(Arrays.asList(strArr));
        }
        this.f13058q = new C2492g();
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15744a(String str, int i) {
        if (this.f13049h == null) {
            this.f13049h = new ArrayList(5);
        }
        this.f13049h.add(new C2506u(str, i));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15676a() {
        return new C2487b(new ArrayList<Object>(0) { // from class: org.f.a.c.s.1
            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean add(Object obj) {
                C2504s.this.f13055n = obj;
                return super.add(obj);
            }
        });
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15679a(String str, boolean z) {
        C2487b c2487b = new C2487b(str);
        if (z) {
            if (this.f13050i == null) {
                this.f13050i = new ArrayList(1);
            }
            this.f13050i.add(c2487b);
        } else {
            if (this.f13051j == null) {
                this.f13051j = new ArrayList(1);
            }
            this.f13051j.add(c2487b);
        }
        return c2487b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15678a(int i, C2530v c2530v, String str, boolean z) {
        C2509x c2509x = new C2509x(i, c2530v, str);
        if (z) {
            if (this.f13052k == null) {
                this.f13052k = new ArrayList(1);
            }
            this.f13052k.add(c2509x);
        } else {
            if (this.f13053l == null) {
                this.f13053l = new ArrayList(1);
            }
            this.f13053l.add(c2509x);
        }
        return c2509x;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15677a(int i, String str, boolean z) {
        C2487b c2487b = new C2487b(str);
        if (z) {
            if (this.f13056o == null) {
                this.f13056o = new List[C2529u.m15893d(this.f13046e).length];
            }
            if (this.f13056o[i] == null) {
                this.f13056o[i] = new ArrayList(1);
            }
            this.f13056o[i].add(c2487b);
        } else {
            if (this.f13057p == null) {
                this.f13057p = new List[C2529u.m15893d(this.f13046e).length];
            }
            if (this.f13057p[i] == null) {
                this.f13057p[i] = new ArrayList(1);
            }
            this.f13057p[i].add(c2487b);
        }
        return c2487b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15745a(C2512d c2512d) {
        if (this.f13054m == null) {
            this.f13054m = new ArrayList(1);
        }
        this.f13054m.add(c2512d);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15751b() {
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15644a(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        this.f13058q.m15728a(new C2489d(i, i2, objArr == null ? null : m15738a(objArr), i3, objArr2 != null ? m15738a(objArr2) : null));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15740a(int i) {
        this.f13058q.m15728a(new C2493h(i));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15741a(int i, int i2) {
        this.f13058q.m15728a(new C2494i(i, i2));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15648b(int i, int i2) {
        this.f13058q.m15728a(new C2511z(i, i2));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15680a(int i, String str) {
        this.f13058q.m15728a(new C2510y(i, str));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15681a(int i, String str, String str2, String str3) {
        this.f13058q.m15728a(new C2488c(i, str, str2, str3));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    @Deprecated
    /* renamed from: b */
    public void mo15686b(int i, String str, String str2, String str3) {
        if (this.f13213b_ >= 327680) {
            super.mo15686b(i, str, str2, str3);
        } else {
            this.f13058q.m15728a(new C2503r(i, str, str2, str3));
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15682a(int i, String str, String str2, String str3, boolean z) {
        if (this.f13213b_ < 327680) {
            super.mo15682a(i, str, str2, str3, z);
        } else {
            this.f13058q.m15728a(new C2503r(i, str, str2, str3, z));
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15683a(String str, String str2, C2522n c2522n, Object... objArr) {
        this.f13058q.m15728a(new C2495j(str, str2, c2522n, objArr));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15743a(int i, C2525q c2525q) {
        this.f13058q.m15728a(new C2496k(i, m15750b(c2525q)));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15747a(C2525q c2525q) {
        this.f13058q.m15728a(m15750b(c2525q));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo10229a(Object obj) {
        this.f13058q.m15728a(new C2498m(obj));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public void mo15649c(int i, int i2) {
        this.f13058q.m15728a(new C2490e(i, i2));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15742a(int i, int i2, C2525q c2525q, C2525q... c2525qArr) {
        this.f13058q.m15728a(new C2507v(i, i2, m15750b(c2525q), m15739a(c2525qArr)));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15748a(C2525q c2525q, int[] iArr, C2525q[] c2525qArr) {
        this.f13058q.m15728a(new C2502q(m15750b(c2525q), iArr, m15739a(c2525qArr)));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15687b(String str, int i) {
        this.f13058q.m15728a(new C2505t(str, i));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public AbstractC2473a mo15685b(int i, C2530v c2530v, String str, boolean z) {
        AbstractC2486a m15731b = this.f13058q.m15731b();
        while (m15731b.m15718a() == -1) {
            m15731b = m15731b.m15720b();
        }
        C2509x c2509x = new C2509x(i, c2530v, str);
        if (z) {
            if (m15731b.f12995b == null) {
                m15731b.f12995b = new ArrayList(1);
            }
            m15731b.f12995b.add(c2509x);
        } else {
            if (m15731b.f12996c == null) {
                m15731b.f12996c = new ArrayList(1);
            }
            m15731b.f12996c.add(c2509x);
        }
        return c2509x;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15684a(C2525q c2525q, C2525q c2525q2, C2525q c2525q3, String str) {
        this.f13059r.add(new C2508w(m15750b(c2525q), m15750b(c2525q2), m15750b(c2525q3), str));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public AbstractC2473a mo15688c(int i, C2530v c2530v, String str, boolean z) {
        C2508w c2508w = this.f13059r.get((16776960 & i) >> 8);
        C2509x c2509x = new C2509x(i, c2530v, str);
        if (z) {
            if (c2508w.f13079e == null) {
                c2508w.f13079e = new ArrayList(1);
            }
            c2508w.f13079e.add(c2509x);
        } else {
            if (c2508w.f13080f == null) {
                c2508w.f13080f = new ArrayList(1);
            }
            c2508w.f13080f.add(c2509x);
        }
        return c2509x;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15646a(String str, String str2, String str3, C2525q c2525q, C2525q c2525q2, int i) {
        this.f13062u.add(new C2501p(str, str2, str3, m15750b(c2525q), m15750b(c2525q2), i));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15643a(int i, C2530v c2530v, C2525q[] c2525qArr, C2525q[] c2525qArr2, int[] iArr, String str, boolean z) {
        C2500o c2500o = new C2500o(i, c2530v, m15739a(c2525qArr), m15739a(c2525qArr2), iArr, str);
        if (z) {
            if (this.f13063v == null) {
                this.f13063v = new ArrayList(1);
            }
            this.f13063v.add(c2500o);
        } else {
            if (this.f13064w == null) {
                this.f13064w = new ArrayList(1);
            }
            this.f13064w.add(c2500o);
        }
        return c2500o;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15752b(int i, C2525q c2525q) {
        this.f13058q.m15728a(new C2499n(i, m15750b(c2525q)));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: d */
    public void mo15650d(int i, int i2) {
        this.f13060s = i;
        this.f13061t = i2;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public void mo15753c() {
    }

    /* renamed from: b */
    protected C2497l m15750b(C2525q c2525q) {
        if (!(c2525q.f13201a instanceof C2497l)) {
            c2525q.f13201a = new C2497l();
        }
        return (C2497l) c2525q.f13201a;
    }

    /* renamed from: a */
    private C2497l[] m15739a(C2525q[] c2525qArr) {
        C2497l[] c2497lArr = new C2497l[c2525qArr.length];
        for (int i = 0; i < c2525qArr.length; i++) {
            c2497lArr[i] = m15750b(c2525qArr[i]);
        }
        return c2497lArr;
    }

    /* renamed from: a */
    private Object[] m15738a(Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < objArr.length) {
                Object obj = objArr[i2];
                if (obj instanceof C2525q) {
                    obj = m15750b((C2525q) obj);
                }
                objArr2[i2] = obj;
                i = i2 + 1;
            } else {
                return objArr2;
            }
        }
    }

    /* renamed from: a */
    public void m15746a(AbstractC2515g abstractC2515g) {
        String[] strArr = new String[this.f13048g.size()];
        this.f13048g.toArray(strArr);
        AbstractC2526r mo15667a = abstractC2515g.mo15667a(this.f13044c, this.f13045d, this.f13046e, this.f13047f, strArr);
        if (mo15667a != null) {
            m15749a(mo15667a);
        }
    }

    /* renamed from: a */
    public void m15749a(AbstractC2526r abstractC2526r) {
        int size = this.f13049h == null ? 0 : this.f13049h.size();
        for (int i = 0; i < size; i++) {
            C2506u c2506u = this.f13049h.get(i);
            abstractC2526r.mo15744a(c2506u.f13069a, c2506u.f13070b);
        }
        if (this.f13055n != null) {
            AbstractC2473a mo15676a = abstractC2526r.mo15676a();
            C2487b.m15722a(mo15676a, (String) null, this.f13055n);
            if (mo15676a != null) {
                mo15676a.mo15637a();
            }
        }
        int size2 = this.f13050i == null ? 0 : this.f13050i.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C2487b c2487b = this.f13050i.get(i2);
            c2487b.m15723a(abstractC2526r.mo15679a(c2487b.f13000c, true));
        }
        int size3 = this.f13051j == null ? 0 : this.f13051j.size();
        for (int i3 = 0; i3 < size3; i3++) {
            C2487b c2487b2 = this.f13051j.get(i3);
            c2487b2.m15723a(abstractC2526r.mo15679a(c2487b2.f13000c, false));
        }
        int size4 = this.f13052k == null ? 0 : this.f13052k.size();
        for (int i4 = 0; i4 < size4; i4++) {
            C2509x c2509x = this.f13052k.get(i4);
            c2509x.m15723a(abstractC2526r.mo15678a(c2509x.f13081h, c2509x.f13082i, c2509x.f13000c, true));
        }
        int size5 = this.f13053l == null ? 0 : this.f13053l.size();
        for (int i5 = 0; i5 < size5; i5++) {
            C2509x c2509x2 = this.f13053l.get(i5);
            c2509x2.m15723a(abstractC2526r.mo15678a(c2509x2.f13081h, c2509x2.f13082i, c2509x2.f13000c, false));
        }
        int length = this.f13056o == null ? 0 : this.f13056o.length;
        for (int i6 = 0; i6 < length; i6++) {
            List<C2487b> list = this.f13056o[i6];
            if (list != null) {
                for (int i7 = 0; i7 < list.size(); i7++) {
                    C2487b c2487b3 = list.get(i7);
                    c2487b3.m15723a(abstractC2526r.mo15677a(i6, c2487b3.f13000c, true));
                }
            }
        }
        int length2 = this.f13057p == null ? 0 : this.f13057p.length;
        for (int i8 = 0; i8 < length2; i8++) {
            List<C2487b> list2 = this.f13057p[i8];
            if (list2 != null) {
                for (int i9 = 0; i9 < list2.size(); i9++) {
                    C2487b c2487b4 = list2.get(i9);
                    c2487b4.m15723a(abstractC2526r.mo15677a(i8, c2487b4.f13000c, false));
                }
            }
        }
        if (this.f13065x) {
            this.f13058q.m15733d();
        }
        int size6 = this.f13054m == null ? 0 : this.f13054m.size();
        for (int i10 = 0; i10 < size6; i10++) {
            abstractC2526r.mo15745a(this.f13054m.get(i10));
        }
        if (this.f13058q.m15727a() > 0) {
            abstractC2526r.mo15751b();
            int size7 = this.f13059r == null ? 0 : this.f13059r.size();
            for (int i11 = 0; i11 < size7; i11++) {
                this.f13059r.get(i11).m15754a(i11);
                this.f13059r.get(i11).m15755a(abstractC2526r);
            }
            this.f13058q.m15729a(abstractC2526r);
            int size8 = this.f13062u == null ? 0 : this.f13062u.size();
            for (int i12 = 0; i12 < size8; i12++) {
                this.f13062u.get(i12).m15737a(abstractC2526r);
            }
            int size9 = this.f13063v == null ? 0 : this.f13063v.size();
            for (int i13 = 0; i13 < size9; i13++) {
                this.f13063v.get(i13).m15736a(abstractC2526r, true);
            }
            int size10 = this.f13064w == null ? 0 : this.f13064w.size();
            for (int i14 = 0; i14 < size10; i14++) {
                this.f13064w.get(i14).m15736a(abstractC2526r, false);
            }
            abstractC2526r.mo15650d(this.f13060s, this.f13061t);
            this.f13065x = true;
        }
        abstractC2526r.mo15753c();
    }
}
