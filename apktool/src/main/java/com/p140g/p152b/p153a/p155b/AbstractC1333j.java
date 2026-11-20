package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import java.util.Set;

/* compiled from: Stmt.java */
/* renamed from: com.g.b.a.b.j */
/* loaded from: classes.dex */
public abstract class AbstractC1333j {

    /* renamed from: e */
    public Set<AbstractC1333j> f8641e;

    /* renamed from: f */
    public Set<C1329f> f8642f;

    /* renamed from: g */
    public boolean f8643g;

    /* renamed from: h */
    public Object f8644h;

    /* renamed from: i */
    public final EnumC1302a f8645i;

    /* renamed from: j */
    public int f8646j;

    /* renamed from: k */
    C1334k f8647k;

    /* renamed from: l */
    AbstractC1333j f8648l;

    /* renamed from: m */
    AbstractC1333j f8649m;

    /* renamed from: n */
    public final d f8650n;

    /* renamed from: a */
    public abstract AbstractC1333j mo10554a(C1339c c1339c);

    /* renamed from: a */
    public void mo10558a(AbstractC1322t abstractC1322t) {
    }

    /* renamed from: b */
    public void mo10560b(AbstractC1322t abstractC1322t) {
    }

    /* renamed from: c */
    public void mo10562c(AbstractC1322t abstractC1322t) {
    }

    /* compiled from: Stmt.java */
    /* renamed from: com.g.b.a.b.j$a */
    public static abstract class a extends AbstractC1333j {
        public a(d dVar) {
            super(dVar, EnumC1302a.E0);
        }
    }

    /* compiled from: Stmt.java */
    /* renamed from: com.g.b.a.b.j$b */
    public static abstract class b extends AbstractC1333j {

        /* renamed from: d */
        public AbstractC1322t f8651d;

        public b(d dVar, AbstractC1322t abstractC1322t) {
            super(dVar, EnumC1302a.E1);
            this.f8651d = abstractC1322t;
        }

        @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
        /* renamed from: c */
        public AbstractC1322t mo10561c() {
            return this.f8651d;
        }

        @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
        /* renamed from: a */
        public void mo10558a(AbstractC1322t abstractC1322t) {
            this.f8651d = abstractC1322t;
        }
    }

    /* compiled from: Stmt.java */
    /* renamed from: com.g.b.a.b.j$c */
    public static abstract class c extends AbstractC1333j {

        /* renamed from: a */
        public AbstractC1322t f8652a;

        /* renamed from: b */
        public AbstractC1322t f8653b;

        public c(d dVar, AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
            super(dVar, EnumC1302a.E2);
            this.f8652a = abstractC1322t;
            this.f8653b = abstractC1322t2;
        }

        @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
        /* renamed from: d */
        public AbstractC1322t mo10563d() {
            return this.f8652a;
        }

        @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
        /* renamed from: e */
        public AbstractC1322t mo10564e() {
            return this.f8653b;
        }

        @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
        /* renamed from: b */
        public void mo10560b(AbstractC1322t abstractC1322t) {
            this.f8652a = abstractC1322t;
        }

        @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
        /* renamed from: c */
        public void mo10562c(AbstractC1322t abstractC1322t) {
            this.f8653b = abstractC1322t;
        }
    }

    /* compiled from: Stmt.java */
    /* renamed from: com.g.b.a.b.j$d */
    public enum d {
        LOCAL_START(1),
        LOCAL_END(1),
        ASSIGN(17),
        IDENTITY(1),
        LABEL(1),
        LOCK(9),
        NOP(1),
        UNLOCK(9),
        VOID_INVOKE(9),
        FILL_ARRAY_DATA(9),
        RETURN(16),
        RETURN_VOID(0),
        THROW(8),
        GOTO(2),
        IF(19),
        LOOKUP_SWITCH(20),
        TABLE_SWITCH(20);


        /* renamed from: s */
        private int f8672s;

        public static d valueOf(String str) {
            for (d dVar : values()) {
                if (dVar.name().equals(str)) {
                    return dVar;
                }
            }
            throw new IllegalArgumentException();
        }

        d(int i) {
            this.f8672s = i;
        }

        /* renamed from: a */
        public boolean m10567a() {
            return (this.f8672s & 2) != 0;
        }

        /* renamed from: b */
        public boolean m10568b() {
            return (this.f8672s & 1) != 0;
        }

        /* renamed from: c */
        public boolean m10569c() {
            return (this.f8672s & 4) != 0;
        }

        /* renamed from: d */
        public boolean m10570d() {
            return (this.f8672s & 16) != 0;
        }

        /* renamed from: e */
        public boolean m10571e() {
            return (this.f8672s & 8) != 0;
        }
    }

    protected AbstractC1333j(d dVar, EnumC1302a enumC1302a) {
        this.f8650n = dVar;
        this.f8645i = enumC1302a;
    }

    /* renamed from: b */
    public final AbstractC1333j m10559b() {
        return this.f8648l;
    }

    /* renamed from: c */
    public AbstractC1322t mo10561c() {
        return (AbstractC1322t) null;
    }

    /* renamed from: d */
    public AbstractC1322t mo10563d() {
        return (AbstractC1322t) null;
    }

    /* renamed from: e */
    public AbstractC1322t mo10564e() {
        return (AbstractC1322t) null;
    }

    /* renamed from: f */
    public AbstractC1322t[] m10565f() {
        return (AbstractC1322t[]) null;
    }

    /* renamed from: g */
    public final AbstractC1333j m10566g() {
        return this.f8649m;
    }
}
