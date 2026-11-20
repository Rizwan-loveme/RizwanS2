package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1312j;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p156c.C1345b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: AggTransformer.java */
/* renamed from: com.g.b.a.c.a */
/* loaded from: classes.dex */
public class C1340a extends AbstractC1357m {

    /* renamed from: a */
    private static a f8683a = new a();

    /* renamed from: b */
    private static a f8684b = new a();

    /* compiled from: AggTransformer.java */
    /* renamed from: com.g.b.a.c.a$a */
    static class a extends Throwable {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        HashSet hashSet = new HashSet();
        boolean m10608a = m10608a(c1323b, false, hashSet);
        if (hashSet.size() == 0) {
            return m10608a;
        }
        b bVar = new b();
        C1360p c1360p = new C1360p();
        c1360p.addAll(hashSet);
        while (!c1360p.isEmpty()) {
            AbstractC1333j abstractC1333j = (AbstractC1333j) c1360p.poll();
            C1314l c1314l = (C1314l) abstractC1333j.mo10563d();
            AbstractC1333j m10559b = abstractC1333j.m10559b();
            AbstractC1333j.d dVar = m10559b.f8650n;
            if (dVar != AbstractC1333j.d.LABEL && dVar != AbstractC1333j.d.GOTO && dVar != AbstractC1333j.d.IDENTITY && dVar != AbstractC1333j.d.FILL_ARRAY_DATA && dVar != AbstractC1333j.d.NOP && dVar != AbstractC1333j.d.RETURN_VOID) {
                try {
                    m10604a(c1314l, m10559b);
                    throw new RuntimeException();
                } catch (a e2) {
                    if (e2 == f8684b) {
                        bVar.f8693a = c1314l;
                        bVar.f8694b = abstractC1333j.mo10564e();
                        c1323b.f8624c.remove(c1314l);
                        c1323b.f8628g.m10583d(abstractC1333j);
                        C1345b.m10640a(m10559b, (C1345b.e) bVar, false);
                        AbstractC1333j m10566g = m10559b.m10566g();
                        if (m10566g != null && hashSet.contains(m10566g)) {
                            c1360p.add(m10566g);
                        }
                    }
                }
            }
        }
        return m10608a;
    }

    /* renamed from: a */
    private static void m10604a(C1314l c1314l, AbstractC1333j abstractC1333j) {
        EnumC1302a enumC1302a = abstractC1333j.f8645i;
        if (enumC1302a != EnumC1302a.E0 && enumC1302a != EnumC1302a.En) {
            if (enumC1302a == EnumC1302a.E1) {
                m10603a(c1314l, abstractC1333j.mo10561c());
            } else if (enumC1302a == EnumC1302a.E2) {
                C1324a c1324a = (C1324a) abstractC1333j;
                AbstractC1322t d2 = c1324a.mo10563d();
                AbstractC1322t e2 = c1324a.mo10564e();
                AbstractC1322t.e eVar = d2.f8563h;
                if (eVar == AbstractC1322t.e.LOCAL) {
                    m10603a(c1314l, e2);
                } else {
                    if (eVar == AbstractC1322t.e.FIELD) {
                        m10603a(c1314l, d2.mo10544g());
                    } else if (eVar != AbstractC1322t.e.STATIC_FIELD) {
                        if (eVar == AbstractC1322t.e.ARRAY) {
                            m10603a(c1314l, d2.mo10545h());
                            m10603a(c1314l, d2.mo10546i());
                            m10603a(c1314l, e2);
                        }
                    }
                    m10603a(c1314l, e2);
                }
            }
            throw f8683a;
        }
        throw f8683a;
    }

    /* renamed from: a */
    private static void m10603a(C1314l c1314l, AbstractC1322t abstractC1322t) {
        boolean z = false;
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a == EnumC1302a.E0) {
            if (c1314l.f8563h == AbstractC1322t.e.LOCAL && abstractC1322t == c1314l) {
                throw f8684b;
            }
        } else if (enumC1302a == EnumC1302a.E1) {
            m10603a(c1314l, abstractC1322t.mo10544g());
        } else if (enumC1302a == EnumC1302a.E2) {
            m10603a(c1314l, abstractC1322t.mo10545h());
            m10603a(c1314l, abstractC1322t.mo10546i());
        } else if (enumC1302a == EnumC1302a.En) {
            for (AbstractC1322t abstractC1322t2 : abstractC1322t.mo10547j()) {
                m10603a(c1314l, abstractC1322t2);
            }
        }
        if (abstractC1322t.f8563h == AbstractC1322t.e.INVOKE_STATIC) {
            C1312j c1312j = (C1312j) abstractC1322t;
            if (c1312j.m10538e().equals("valueOf") && c1312j.m10536c().startsWith("Ljava/lang/") && c1312j.m10539f().length == 1 && c1312j.m10539f()[0].length() == 1) {
                z = true;
            }
        }
        if (!m10606a(abstractC1322t.f8563h) && !z) {
            throw f8683a;
        }
    }

    /* compiled from: AggTransformer.java */
    /* renamed from: com.g.b.a.c.a$b */
    static class b implements C1345b.e {

        /* renamed from: a */
        C1314l f8693a;

        /* renamed from: b */
        AbstractC1322t f8694b;

        @Override // com.p140g.p152b.p153a.p156c.C1345b.c
        /* renamed from: a */
        public AbstractC1322t mo10612a(C1314l c1314l, C1324a c1324a) {
            return c1314l;
        }

        @Override // com.p140g.p152b.p153a.p156c.C1345b.d
        /* renamed from: a */
        public AbstractC1322t mo10611a(C1314l c1314l) {
            if (c1314l == this.f8693a) {
                return this.f8694b;
            }
            return c1314l;
        }
    }

    /* renamed from: a */
    private boolean m10608a(C1323b c1323b, boolean z, Set<AbstractC1333j> set) {
        if (c1323b.f8624c.size() == 0) {
            return false;
        }
        int[] m10647a = C1345b.m10647a(c1323b);
        Set<C1314l> m10609c = m10609c(c1323b);
        HashMap hashMap = new HashMap();
        Iterator<AbstractC1333j> it = c1323b.f8628g.iterator();
        while (it.hasNext()) {
            AbstractC1333j next = it.next();
            if (next.f8650n == AbstractC1333j.d.ASSIGN && next.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                C1314l c1314l = (C1314l) next.mo10563d();
                if (!m10609c.contains(c1314l) && m10647a[c1314l.f8546a] < 2) {
                    AbstractC1322t mo10564e = next.mo10564e();
                    if (m10607a(mo10564e)) {
                        c1323b.f8624c.remove(c1314l);
                        hashMap.put(c1314l, mo10564e);
                        it.remove();
                        z = true;
                    } else {
                        set.add(next);
                    }
                }
            }
        }
        C1345b.e eVar = new C1345b.e(this, hashMap) { // from class: com.g.b.a.c.a.1

            /* renamed from: a */
            private final C1340a f8685a;

            /* renamed from: b */
            private final Map f8686b;

            {
                this.f8685a = this;
                this.f8686b = hashMap;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.c
            /* renamed from: a */
            public AbstractC1322t mo10612a(C1314l c1314l2, C1324a c1324a) {
                return c1314l2;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.d
            /* renamed from: a */
            public AbstractC1322t mo10611a(C1314l c1314l2) {
                AbstractC1322t abstractC1322t = (AbstractC1322t) this.f8686b.get(c1314l2);
                return abstractC1322t != null ? abstractC1322t : c1314l2;
            }
        };
        m10605a(hashMap, eVar);
        C1345b.m10650b(c1323b.f8628g, eVar, false);
        return z;
    }

    /* renamed from: c */
    private Set<C1314l> m10609c(C1323b c1323b) {
        HashSet hashSet = new HashSet();
        if (c1323b.f8631j != null) {
            for (C1329f c1329f : c1323b.f8631j) {
                if (c1329f.f8638c != null) {
                    for (C1324a c1324a : c1329f.f8638c) {
                        hashSet.add((C1314l) c1324a.mo10563d());
                        AbstractC1322t[] mo10547j = c1324a.mo10564e().mo10547j();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < mo10547j.length) {
                                hashSet.add((C1314l) mo10547j[i2]);
                                i = i2 + 1;
                            }
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private void m10605a(Map<C1314l, AbstractC1322t> map, C1345b.e eVar) {
        AbstractC1322t abstractC1322t;
        for (Map.Entry<C1314l, AbstractC1322t> entry : map.entrySet()) {
            AbstractC1322t value = entry.getValue();
            if (value.f8563h == AbstractC1322t.e.LOCAL) {
                while (true) {
                    abstractC1322t = value;
                    value = map.get(abstractC1322t);
                    if (value != null) {
                        if (value.f8563h != AbstractC1322t.e.LOCAL) {
                            abstractC1322t = value;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                entry.setValue(abstractC1322t);
            } else {
                C1345b.m10638a(value, eVar);
            }
        }
    }

    /* renamed from: a */
    static boolean m10606a(AbstractC1322t.e eVar) {
        if (eVar == AbstractC1322t.e.LOCAL || eVar == AbstractC1322t.e.CONSTANT || eVar == AbstractC1322t.e.ADD || eVar == AbstractC1322t.e.SUB || eVar == AbstractC1322t.e.MUL || eVar == AbstractC1322t.e.REM || eVar == AbstractC1322t.e.AND || eVar == AbstractC1322t.e.OR || eVar == AbstractC1322t.e.XOR || eVar == AbstractC1322t.e.SHL || eVar == AbstractC1322t.e.SHR || eVar == AbstractC1322t.e.USHR || eVar == AbstractC1322t.e.GE || eVar == AbstractC1322t.e.GT || eVar == AbstractC1322t.e.LE || eVar == AbstractC1322t.e.LT || eVar == AbstractC1322t.e.EQ || eVar == AbstractC1322t.e.NE || eVar == AbstractC1322t.e.DCMPG || eVar == AbstractC1322t.e.DCMPL || eVar == AbstractC1322t.e.LCMP || eVar == AbstractC1322t.e.FCMPG || eVar == AbstractC1322t.e.FCMPL || eVar == AbstractC1322t.e.NOT) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static boolean m10607a(AbstractC1322t abstractC1322t) {
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a == EnumC1302a.E0) {
            return m10606a(abstractC1322t.f8563h);
        }
        if (enumC1302a == EnumC1302a.E1) {
            return m10606a(abstractC1322t.f8563h) && m10607a(abstractC1322t.mo10544g());
        }
        if (enumC1302a == EnumC1302a.E2) {
            return m10606a(abstractC1322t.f8563h) && m10607a(abstractC1322t.mo10545h()) && m10607a(abstractC1322t.mo10546i());
        }
        if (enumC1302a != EnumC1302a.En) {
            return false;
        }
        if (abstractC1322t.f8563h == AbstractC1322t.e.INVOKE_STATIC) {
            C1312j c1312j = (C1312j) abstractC1322t;
            if (!c1312j.m10538e().equals("valueOf") || !c1312j.m10536c().startsWith("Ljava/lang/") || c1312j.m10539f().length != 1 || c1312j.m10539f()[0].length() != 1) {
                return false;
            }
            for (AbstractC1322t abstractC1322t2 : abstractC1322t.mo10547j()) {
                if (!m10607a(abstractC1322t2)) {
                    return false;
                }
            }
            return true;
        }
        if (!m10606a(abstractC1322t.f8563h)) {
            return false;
        }
        for (AbstractC1322t abstractC1322t3 : abstractC1322t.mo10547j()) {
            if (!m10607a(abstractC1322t3)) {
                return false;
            }
        }
        return true;
    }
}
