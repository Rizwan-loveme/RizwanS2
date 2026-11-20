package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1364e;
import com.p140g.p152b.p153a.C1365f;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1307e;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1335l;

/* compiled from: NpeTransformer.java */
/* renamed from: com.g.b.a.c.j */
/* loaded from: classes.dex */
public class C1354j extends AbstractC1357m {

    /* renamed from: a */
    private static final a f8748a = new a();

    /* renamed from: b */
    private static final a f8749b = new a();

    /* renamed from: c */
    private static final a f8750c = new a();

    /* compiled from: NpeTransformer.java */
    /* renamed from: com.g.b.a.c.j$a */
    private static class a extends RuntimeException {
    }

    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        boolean z = false;
        if (c1323b.f8624c.size() != 0) {
            C1364e c1364e = new C1364e(this) { // from class: com.g.b.a.c.j.1

                /* renamed from: a */
                private final C1354j f8751a;

                {
                    this.f8751a = this;
                }

                @Override // com.p140g.p152b.p153a.C1364e
                /* renamed from: a */
                public void mo10694a(AbstractC1333j abstractC1333j) {
                    if (abstractC1333j.f8650n == AbstractC1333j.d.FILL_ARRAY_DATA && C1354j.m10690a(abstractC1333j.mo10563d())) {
                        throw C1354j.f8748a;
                    }
                    super.mo10694a(abstractC1333j);
                }

                @Override // com.p140g.p152b.p153a.C1364e
                /* renamed from: a */
                public void mo10693a(AbstractC1322t abstractC1322t) {
                    AbstractC1322t.e eVar = abstractC1322t.f8563h;
                    if (eVar == AbstractC1322t.e.INVOKE_VIRTUAL || eVar == AbstractC1322t.e.INVOKE_SPECIAL || eVar == AbstractC1322t.e.INVOKE_INTERFACE) {
                        if (C1354j.m10690a(abstractC1322t.mo10547j()[0])) {
                            throw C1354j.f8748a;
                        }
                        return;
                    }
                    if (eVar == AbstractC1322t.e.ARRAY) {
                        if (C1354j.m10690a(abstractC1322t.mo10545h())) {
                            throw C1354j.f8748a;
                        }
                        return;
                    }
                    if (eVar == AbstractC1322t.e.FIELD) {
                        if (C1354j.m10690a(abstractC1322t.mo10544g())) {
                            throw C1354j.f8748a;
                        }
                        return;
                    }
                    if (eVar == AbstractC1322t.e.IDIV) {
                        if (abstractC1322t.mo10546i().f8563h == AbstractC1322t.e.CONSTANT && ((Number) ((C1307e) abstractC1322t.mo10546i()).f8534b).intValue() == 0) {
                            throw C1354j.f8749b;
                        }
                        return;
                    }
                    if (eVar == AbstractC1322t.e.LDIV) {
                        if (abstractC1322t.mo10546i().f8563h == AbstractC1322t.e.CONSTANT && ((Number) ((C1307e) abstractC1322t.mo10546i()).f8534b).longValue() == 0) {
                            throw C1354j.f8749b;
                        }
                    } else if (eVar == AbstractC1322t.e.NEW_ARRAY) {
                        if (abstractC1322t.mo10544g().f8563h == AbstractC1322t.e.CONSTANT && ((Number) ((C1307e) abstractC1322t.mo10544g()).f8534b).intValue() < 0) {
                            throw C1354j.f8750c;
                        }
                    } else if (eVar == AbstractC1322t.e.NEW_MUTI_ARRAY) {
                        for (AbstractC1322t abstractC1322t2 : abstractC1322t.mo10547j()) {
                            if (abstractC1322t2.f8563h == AbstractC1322t.e.CONSTANT && ((Number) ((C1307e) abstractC1322t2).f8534b).intValue() < 0) {
                                throw C1354j.f8750c;
                            }
                        }
                    }
                }
            };
            AbstractC1333j m10574a = c1323b.f8628g.m10574a();
            while (m10574a != null) {
                try {
                    c1364e.mo10694a(m10574a);
                    m10574a = m10574a.m10559b();
                } catch (a e2) {
                    m10689a(c1323b, m10574a);
                    AbstractC1333j m10559b = m10574a.m10559b();
                    c1323b.f8628g.m10583d(m10574a);
                    z = true;
                    m10574a = m10559b;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private void m10689a(C1323b c1323b, AbstractC1333j abstractC1333j) {
        C1365f c1365f = new C1365f(this, c1323b, abstractC1333j) { // from class: com.g.b.a.c.j.2

            /* renamed from: a */
            private final C1354j f8752a;

            /* renamed from: b */
            private final C1323b f8753b;

            /* renamed from: c */
            private final AbstractC1333j f8754c;

            {
                this.f8752a = this;
                this.f8753b = c1323b;
                this.f8754c = abstractC1333j;
            }

            @Override // com.p140g.p152b.p153a.C1365f
            /* renamed from: a */
            public AbstractC1322t mo10678a(AbstractC1322t abstractC1322t) {
                AbstractC1322t.e eVar = abstractC1322t.f8563h;
                if (eVar == AbstractC1322t.e.INVOKE_VIRTUAL || eVar == AbstractC1322t.e.INVOKE_SPECIAL || eVar == AbstractC1322t.e.INVOKE_INTERFACE) {
                    AbstractC1322t[] mo10547j = abstractC1322t.mo10547j();
                    if (C1354j.m10690a(mo10547j[0])) {
                        for (int i = 1; i < mo10547j.length; i++) {
                            mo10678a(mo10547j[i]);
                        }
                        throw C1354j.f8748a;
                    }
                } else if (eVar == AbstractC1322t.e.ARRAY) {
                    if (C1354j.m10690a(abstractC1322t.mo10545h())) {
                        mo10678a(abstractC1322t.mo10546i());
                        throw C1354j.f8748a;
                    }
                } else if (eVar == AbstractC1322t.e.FIELD) {
                    if (C1354j.m10690a(abstractC1322t.mo10544g())) {
                        throw C1354j.f8748a;
                    }
                } else if (eVar == AbstractC1322t.e.IDIV) {
                    if (abstractC1322t.mo10546i().f8563h == AbstractC1322t.e.CONSTANT && ((Number) ((C1307e) abstractC1322t.mo10546i()).f8534b).intValue() == 0) {
                        mo10678a(abstractC1322t.mo10545h());
                        throw C1354j.f8749b;
                    }
                } else if (eVar == AbstractC1322t.e.LDIV) {
                    if (abstractC1322t.mo10546i().f8563h == AbstractC1322t.e.CONSTANT && ((Number) ((C1307e) abstractC1322t.mo10546i()).f8534b).longValue() == 0) {
                        mo10678a(abstractC1322t.mo10545h());
                        throw C1354j.f8749b;
                    }
                } else if (eVar == AbstractC1322t.e.NEW_ARRAY) {
                    if (abstractC1322t.mo10544g().f8563h == AbstractC1322t.e.CONSTANT && ((Number) ((C1307e) abstractC1322t.mo10544g()).f8534b).intValue() < 0) {
                        throw C1354j.f8750c;
                    }
                } else if (eVar == AbstractC1322t.e.NEW_MUTI_ARRAY) {
                    for (AbstractC1322t abstractC1322t2 : abstractC1322t.mo10547j()) {
                        if (abstractC1322t2.f8563h == AbstractC1322t.e.CONSTANT) {
                            if (((Number) ((C1307e) abstractC1322t2).f8534b).intValue() < 0) {
                                throw C1354j.f8750c;
                            }
                            mo10678a(abstractC1322t2);
                        }
                    }
                }
                AbstractC1322t mo10678a = super.mo10678a(abstractC1322t);
                if (mo10678a.f8563h == AbstractC1322t.e.LOCAL || mo10678a.f8563h == AbstractC1322t.e.CONSTANT) {
                    return mo10678a;
                }
                C1314l c1314l = new C1314l();
                this.f8753b.f8624c.add(c1314l);
                this.f8753b.f8628g.m10582c(this.f8754c, C1335l.m10586a(c1314l, mo10678a));
                return c1314l;
            }
        };
        try {
            EnumC1302a enumC1302a = abstractC1333j.f8645i;
            if (enumC1302a != EnumC1302a.E0) {
                if (enumC1302a == EnumC1302a.E1) {
                    c1365f.mo10678a(abstractC1333j.mo10561c());
                    return;
                }
                if (enumC1302a == EnumC1302a.E2) {
                    if (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN) {
                        AbstractC1322t.e eVar = abstractC1333j.mo10563d().f8563h;
                        if (eVar == AbstractC1322t.e.ARRAY) {
                            c1365f.mo10678a(abstractC1333j.mo10563d().mo10545h());
                            c1365f.mo10678a(abstractC1333j.mo10563d().mo10546i());
                            c1365f.mo10678a(abstractC1333j.mo10564e());
                            return;
                        } else if (eVar == AbstractC1322t.e.FIELD) {
                            c1365f.mo10678a(abstractC1333j.mo10563d().mo10544g());
                            c1365f.mo10678a(abstractC1333j.mo10564e());
                            return;
                        } else {
                            if (eVar != AbstractC1322t.e.STATIC_FIELD && eVar != AbstractC1322t.e.LOCAL) {
                                return;
                            }
                            c1365f.mo10678a(abstractC1333j.mo10564e());
                            return;
                        }
                    }
                    if (abstractC1333j.f8650n == AbstractC1333j.d.FILL_ARRAY_DATA) {
                        if (m10690a(abstractC1333j.mo10563d())) {
                            throw f8748a;
                        }
                        c1365f.mo10678a(abstractC1333j.mo10563d());
                        return;
                    }
                    return;
                }
                if (enumC1302a == EnumC1302a.En) {
                }
            }
        } catch (a e2) {
            if (e2 == f8748a) {
                c1323b.f8628g.m10582c(abstractC1333j, C1335l.m10598c(C1308f.m10495a(new AbstractC1322t[0], new String[0], "Ljava/lang/NullPointerException;")));
            } else if (e2 == f8749b) {
                c1323b.f8628g.m10582c(abstractC1333j, C1335l.m10598c(C1308f.m10495a(new AbstractC1322t[]{C1308f.m10490a("divide by zero")}, new String[]{"Ljava/lang/String;"}, "Ljava/lang/ArithmeticException;")));
            } else if (e2 == f8750c) {
                c1323b.f8628g.m10582c(abstractC1333j, C1335l.m10598c(C1308f.m10495a(new AbstractC1322t[0], new String[0], "Ljava/lang/NegativeArraySizeException;")));
            }
        }
    }

    /* renamed from: a */
    static boolean m10690a(AbstractC1322t abstractC1322t) {
        if (abstractC1322t.f8563h == AbstractC1322t.e.CONSTANT) {
            C1307e c1307e = (C1307e) abstractC1322t;
            if (C1307e.f8533a.equals(c1307e.f8534b)) {
                return true;
            }
            if (c1307e.f8534b instanceof Number) {
                return ((Number) c1307e.f8534b).intValue() == 0;
            }
        }
        return false;
    }
}
