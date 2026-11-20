package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p110h.C1021l;

/* compiled from: CstArray.java */
/* renamed from: com.b.b.f.c.d */
/* loaded from: classes.dex */
public final class C0950d extends AbstractC0945a {

    /* renamed from: a */
    private final a f6136a;

    public C0950d(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("list == null");
        }
        aVar.m8596m();
        this.f6136a = aVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0950d) {
            return this.f6136a.equals(((C0950d) obj).f6136a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6136a.hashCode();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        return this.f6136a.compareTo(((C0950d) abstractC0945a).f6136a);
    }

    public String toString() {
        return this.f6136a.m8545a("array{", ", ", "}");
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "array";
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public boolean mo8035g() {
        return false;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f6136a.m8547b("{", ", ", "}");
    }

    /* renamed from: a */
    public a m8041a() {
        return this.f6136a;
    }

    /* compiled from: CstArray.java */
    /* renamed from: com.b.b.f.c.d$a */
    public static final class a extends C1021l implements Comparable<a> {
        public a(int i) {
            super(i);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int f_ = m8550f_();
            int f_2 = aVar.m8550f_();
            int i = f_ < f_2 ? f_ : f_2;
            for (int i2 = 0; i2 < i; i2++) {
                int compareTo = ((AbstractC0945a) m8548e(i2)).compareTo((AbstractC0945a) aVar.m8548e(i2));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            if (f_ < f_2) {
                return -1;
            }
            return f_ > f_2 ? 1 : 0;
        }

        /* renamed from: a */
        public AbstractC0945a m8043a(int i) {
            return (AbstractC0945a) m8548e(i);
        }

        /* renamed from: a */
        public void m8044a(int i, AbstractC0945a abstractC0945a) {
            m8546a(i, (Object) abstractC0945a);
        }
    }
}
