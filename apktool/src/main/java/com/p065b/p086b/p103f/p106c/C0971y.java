package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;
import java.util.HashMap;

/* compiled from: CstType.java */
/* renamed from: com.b.b.f.c.y */
/* loaded from: classes.dex */
public final class C0971y extends AbstractC0946aa {

    /* renamed from: t */
    private final C0975c f6191t;

    /* renamed from: u */
    private C0970x f6192u;

    /* renamed from: s */
    private static final HashMap<C0975c, C0971y> f6190s = new HashMap<>(100);

    /* renamed from: a */
    public static final C0971y f6172a = m8089b(C0975c.f6260o);

    /* renamed from: b */
    public static final C0971y f6173b = m8089b(C0975c.f6264s);

    /* renamed from: c */
    public static final C0971y f6174c = m8089b(C0975c.f6265t);

    /* renamed from: d */
    public static final C0971y f6175d = m8089b(C0975c.f6266u);

    /* renamed from: e */
    public static final C0971y f6176e = m8089b(C0975c.f6267v);

    /* renamed from: f */
    public static final C0971y f6177f = m8089b(C0975c.f6268w);

    /* renamed from: g */
    public static final C0971y f6178g = m8089b(C0975c.f6270y);

    /* renamed from: h */
    public static final C0971y f6179h = m8089b(C0975c.f6269x);

    /* renamed from: i */
    public static final C0971y f6180i = m8089b(C0975c.f6271z);

    /* renamed from: j */
    public static final C0971y f6181j = m8089b(C0975c.f6235A);

    /* renamed from: k */
    public static final C0971y f6182k = m8089b(C0975c.f6236B);

    /* renamed from: l */
    public static final C0971y f6183l = m8089b(C0975c.f6237C);

    /* renamed from: m */
    public static final C0971y f6184m = m8089b(C0975c.f6238D);

    /* renamed from: n */
    public static final C0971y f6185n = m8089b(C0975c.f6239E);

    /* renamed from: o */
    public static final C0971y f6186o = m8089b(C0975c.f6240F);

    /* renamed from: p */
    public static final C0971y f6187p = m8089b(C0975c.f6242H);

    /* renamed from: q */
    public static final C0971y f6188q = m8089b(C0975c.f6241G);

    /* renamed from: r */
    public static final C0971y f6189r = m8089b(C0975c.f6244J);

    /* renamed from: a */
    public static C0971y m8088a(C0975c c0975c) {
        switch (c0975c.mo6697c()) {
            case 0:
                return f6181j;
            case 1:
                return f6173b;
            case 2:
                return f6174c;
            case 3:
                return f6175d;
            case 4:
                return f6176e;
            case 5:
                return f6177f;
            case 6:
                return f6179h;
            case 7:
                return f6178g;
            case 8:
                return f6180i;
            default:
                throw new IllegalArgumentException("not primitive: " + c0975c);
        }
    }

    /* renamed from: b */
    public static C0971y m8089b(C0975c c0975c) {
        C0971y c0971y;
        synchronized (f6190s) {
            c0971y = f6190s.get(c0975c);
            if (c0971y == null) {
                c0971y = new C0971y(c0975c);
                f6190s.put(c0975c, c0971y);
            }
        }
        return c0971y;
    }

    public C0971y(C0975c c0975c) {
        if (c0975c == null) {
            throw new NullPointerException("type == null");
        }
        if (c0975c == C0975c.f6255j) {
            throw new UnsupportedOperationException("KNOWN_NULL is not representable");
        }
        this.f6191t = c0975c;
        this.f6192u = null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0971y) && this.f6191t == ((C0971y) obj).f6191t;
    }

    public int hashCode() {
        return this.f6191t.hashCode();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        return this.f6191t.m8125h().compareTo(((C0971y) abstractC0945a).f6191t.m8125h());
    }

    public String toString() {
        return "type{" + mo6681d() + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6258m;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "type";
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public boolean mo8035g() {
        return false;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f6191t.mo6681d();
    }

    /* renamed from: i */
    public C0975c m8090i() {
        return this.f6191t;
    }

    /* renamed from: j */
    public C0970x m8091j() {
        if (this.f6192u == null) {
            this.f6192u = new C0970x(this.f6191t.m8125h());
        }
        return this.f6192u;
    }
}
