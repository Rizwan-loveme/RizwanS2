package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.EnumC1302a;

/* compiled from: Value.java */
/* renamed from: com.g.b.a.a.t */
/* loaded from: classes.dex */
public abstract class AbstractC1322t implements Cloneable {

    /* renamed from: a */
    private AbstractC1322t f8559a;

    /* renamed from: e */
    public final EnumC1302a f8560e;

    /* renamed from: f */
    public String f8561f;

    /* renamed from: g */
    public Object f8562g;

    /* renamed from: h */
    public final e f8563h;

    /* renamed from: a */
    public abstract AbstractC1322t mo10480a();

    /* renamed from: a */
    public abstract AbstractC1322t mo10481a(C1339c c1339c);

    /* renamed from: a */
    public void mo10540a(AbstractC1322t abstractC1322t) {
    }

    /* renamed from: a */
    public void mo10541a(AbstractC1322t[] abstractC1322tArr) {
    }

    /* renamed from: b */
    protected abstract String mo10482b();

    /* renamed from: b */
    public void mo10542b(AbstractC1322t abstractC1322t) {
    }

    /* renamed from: c */
    public void mo10543c(AbstractC1322t abstractC1322t) {
    }

    public Object clone() {
        return mo10480a();
    }

    /* compiled from: Value.java */
    /* renamed from: com.g.b.a.a.t$a */
    public static abstract class a extends AbstractC1322t {
        public a(e eVar) {
            super(eVar, EnumC1302a.E0);
        }
    }

    /* compiled from: Value.java */
    /* renamed from: com.g.b.a.a.t$b */
    public static abstract class b extends AbstractC1322t {

        /* renamed from: d */
        public AbstractC1322t f8564d;

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: a */
        public void mo10540a(AbstractC1322t abstractC1322t) {
            this.f8564d = abstractC1322t;
        }

        public b(e eVar, AbstractC1322t abstractC1322t) {
            super(eVar, EnumC1302a.E1);
            this.f8564d = abstractC1322t;
        }

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: g */
        public AbstractC1322t mo10544g() {
            return this.f8564d;
        }
    }

    /* compiled from: Value.java */
    /* renamed from: com.g.b.a.a.t$c */
    public static abstract class c extends AbstractC1322t {

        /* renamed from: b */
        public AbstractC1322t f8565b;

        /* renamed from: c */
        public AbstractC1322t f8566c;

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: b */
        public void mo10542b(AbstractC1322t abstractC1322t) {
            this.f8565b = abstractC1322t;
        }

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: c */
        public void mo10543c(AbstractC1322t abstractC1322t) {
            this.f8566c = abstractC1322t;
        }

        public c(e eVar, AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
            super(eVar, EnumC1302a.E2);
            this.f8565b = abstractC1322t;
            this.f8566c = abstractC1322t2;
        }

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: h */
        public AbstractC1322t mo10545h() {
            return this.f8565b;
        }

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: i */
        public AbstractC1322t mo10546i() {
            return this.f8566c;
        }
    }

    /* compiled from: Value.java */
    /* renamed from: com.g.b.a.a.t$d */
    public static abstract class d extends AbstractC1322t {

        /* renamed from: i */
        public AbstractC1322t[] f8567i;

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: a */
        public void mo10541a(AbstractC1322t[] abstractC1322tArr) {
            this.f8567i = abstractC1322tArr;
        }

        public d(e eVar, AbstractC1322t[] abstractC1322tArr) {
            super(eVar, EnumC1302a.En);
            this.f8567i = abstractC1322tArr;
        }

        /* renamed from: l */
        protected AbstractC1322t[] m10550l() {
            AbstractC1322t[] abstractC1322tArr = new AbstractC1322t[this.f8567i.length];
            for (int i = 0; i < abstractC1322tArr.length; i++) {
                abstractC1322tArr[i] = this.f8567i[i].m10548k().mo10480a();
            }
            return abstractC1322tArr;
        }

        /* renamed from: b */
        protected AbstractC1322t[] m10549b(C1339c c1339c) {
            AbstractC1322t[] abstractC1322tArr = new AbstractC1322t[this.f8567i.length];
            for (int i = 0; i < abstractC1322tArr.length; i++) {
                abstractC1322tArr[i] = this.f8567i[i].mo10481a(c1339c);
            }
            return abstractC1322tArr;
        }

        @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
        /* renamed from: j */
        public AbstractC1322t[] mo10547j() {
            return this.f8567i;
        }
    }

    /* compiled from: Value.java */
    /* renamed from: com.g.b.a.a.t$e */
    public enum e {
        ADD("+", 16),
        AND("&", 16),
        ARRAY(16),
        CAST(16),
        CHECK_CAST(8),
        CONSTANT(0),
        DCMPG(16),
        DCMPL(16),
        IDIV("/", 8),
        LDIV("/", 8),
        FDIV("/", 16),
        DDIV("/", 16),
        EQ("==", 16),
        EXCEPTION_REF(0),
        FCMPG(16),
        FCMPL(16),
        FIELD(8),
        FILLED_ARRAY(8),
        GE(">=", 16),
        GT(">", 16),
        INSTANCE_OF(8),
        INVOKE_INTERFACE(8),
        INVOKE_NEW(8),
        INVOKE_SPECIAL(8),
        INVOKE_STATIC(8),
        INVOKE_VIRTUAL(8),
        INVOKE_CUSTOM(8),
        INVOKE_POLYMORPHIC(8),
        LCMP(16),
        LE("<=", 16),
        LENGTH(8),
        LOCAL(0),
        LT("<", 16),
        MUL("*", 16),
        NE("!=", 16),
        NEG(16),
        NEW(8),
        NEW_ARRAY(8),
        NEW_MUTI_ARRAY(8),
        NOT(16),
        OR("|", 16),
        PARAMETER_REF(0),
        PHI(0),
        REM("%", 16),
        SHL("<<", 16),
        SHR(">>", 16),
        STATIC_FIELD(8),
        SUB("-", 16),
        THIS_REF(16),
        USHR(">>>", 16),
        XOR("^", 16);


        /* renamed from: aa */
        private String f8620aa;

        /* renamed from: ab */
        private int f8621ab;

        public static e valueOf(String str) {
            for (e eVar : values()) {
                if (eVar.name().equals(str)) {
                    return eVar;
                }
            }
            throw new IllegalArgumentException();
        }

        e(int i) {
            this((String) null, i);
        }

        e(String str, int i) {
            this.f8620aa = str;
            this.f8621ab = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f8620aa == null ? super.toString() : this.f8620aa;
        }

        /* renamed from: a */
        public boolean m10551a() {
            return 8 == this.f8621ab;
        }

        /* renamed from: b */
        public boolean m10552b() {
            return 16 == this.f8621ab;
        }
    }

    protected AbstractC1322t(e eVar, EnumC1302a enumC1302a) {
        this.f8563h = eVar;
        this.f8560e = enumC1302a;
    }

    /* renamed from: g */
    public AbstractC1322t mo10544g() {
        return (AbstractC1322t) null;
    }

    /* renamed from: h */
    public AbstractC1322t mo10545h() {
        return (AbstractC1322t) null;
    }

    /* renamed from: i */
    public AbstractC1322t mo10546i() {
        return (AbstractC1322t) null;
    }

    /* renamed from: j */
    public AbstractC1322t[] mo10547j() {
        return (AbstractC1322t[]) null;
    }

    public final String toString() {
        return m10548k().mo10482b();
    }

    /* renamed from: k */
    public AbstractC1322t m10548k() {
        AbstractC1322t abstractC1322t = this;
        while (abstractC1322t.f8559a != null) {
            abstractC1322t = abstractC1322t.f8559a;
        }
        return abstractC1322t;
    }
}
