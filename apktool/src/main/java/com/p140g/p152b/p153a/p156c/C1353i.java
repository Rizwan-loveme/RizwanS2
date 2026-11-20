package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1365f;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1312j;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p154a.C1315m;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1335l;
import com.p140g.p152b.p153a.p156c.C1345b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: NewTransformer.java */
/* renamed from: com.g.b.a.c.i */
/* loaded from: classes.dex */
public class C1353i {

    /* renamed from: a */
    static b f8732a = new b((a) null, true);

    /* renamed from: a */
    public void m10680a(C1323b c1323b) {
        m10682b(c1323b);
        m10684c(c1323b);
    }

    /* renamed from: b */
    void m10682b(C1323b c1323b) {
        HashMap hashMap = new HashMap();
        for (AbstractC1333j abstractC1333j : c1323b.f8628g) {
            if (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN && abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL && abstractC1333j.mo10564e().f8563h == AbstractC1322t.e.NEW) {
                C1314l c1314l = (C1314l) abstractC1333j.mo10563d();
                hashMap.put(c1314l, new a(c1314l, (C1324a) abstractC1333j));
            }
        }
        if (hashMap.size() > 0) {
            int m10654d = C1345b.m10654d(c1323b);
            m10683b(c1323b, hashMap, m10654d);
            if (hashMap.size() > 0) {
                m10681a(c1323b, hashMap, m10654d);
            }
            Iterator<AbstractC1333j> it = c1323b.f8628g.iterator();
            while (it.hasNext()) {
                it.next().f8644h = (Object) null;
            }
        }
    }

    /* renamed from: c */
    void m10684c(C1323b c1323b) {
        Iterator<AbstractC1333j> it = c1323b.f8628g.iterator();
        while (it.hasNext()) {
            AbstractC1333j next = it.next();
            C1312j m10679a = m10679a(next, (C1312j) null);
            if (m10679a != null && "<init>".equals(m10679a.m10538e()) && "V".equals(m10679a.m10537d())) {
                AbstractC1322t[] j = m10679a.mo10547j();
                if (j[0].f8563h == AbstractC1322t.e.NEW && ((C1315m) m10679a.mo10547j()[0]) != null) {
                    c1323b.f8628g.m10582c(next, C1335l.m10600e(C1308f.m10495a((AbstractC1322t[]) Arrays.copyOfRange(j, 1, j.length), m10679a.m10539f(), m10679a.m10536c())));
                    it.remove();
                }
            }
        }
    }

    /* renamed from: a */
    void m10681a(C1323b c1323b, Map<C1314l, a> map, int i) {
        C1314l c1314l;
        HashSet hashSet = new HashSet();
        C1314l[] c1314lArr = new C1314l[i];
        for (C1314l c1314l2 : c1323b.f8624c) {
            c1314lArr[c1314l2.f8546a] = c1314l2;
        }
        for (a aVar : map.values()) {
            b[] bVarArr = (b[]) aVar.f8742a.f8644h;
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                b bVar = bVarArr[i2];
                if (bVar != null && bVar.f8747b == aVar) {
                    hashSet.add(c1314lArr[i2]);
                }
            }
        }
        Iterator<AbstractC1333j> it = c1323b.f8628g.iterator();
        while (it.hasNext()) {
            AbstractC1333j next = it.next();
            if (next.f8650n == AbstractC1333j.d.ASSIGN && next.mo10563d().f8563h == AbstractC1322t.e.LOCAL && hashSet.contains((C1314l) next.mo10563d())) {
                it.remove();
            }
        }
        for (a aVar2 : map.values()) {
            b[] bVarArr2 = (b[]) aVar2.f8742a.f8644h;
            for (int i3 = 0; i3 < bVarArr2.length; i3++) {
                b bVar2 = bVarArr2[i3];
                if (bVar2 != null && bVar2.f8747b == aVar2 && (c1314l = c1314lArr[i3]) != aVar2.f8743b) {
                    c1323b.f8628g.m10579b(aVar2.f8742a, C1335l.m10586a(c1314l, aVar2.f8743b));
                }
            }
            C1312j m10679a = m10679a(aVar2.f8742a, (C1312j) null);
            AbstractC1322t[] j = m10679a.mo10547j();
            c1323b.f8628g.m10584d(aVar2.f8742a, C1335l.m10586a(aVar2.f8743b, C1308f.m10495a((AbstractC1322t[]) Arrays.copyOfRange(j, 1, j.length), m10679a.m10539f(), m10679a.m10536c())));
        }
    }

    /* renamed from: b */
    void m10683b(C1323b c1323b, Map<C1314l, a> map, int i) {
        C1345b.m10653c(c1323b);
        C1345b.m10642a(c1323b.f8628g, new AnonymousClass1(this, i, map));
        Iterator<Map.Entry<C1314l, a>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            boolean z = value.f8744c ? false : true;
            if (value.f8742a == null) {
                z = false;
            }
            if (!z) {
                it.remove();
            }
        }
    }

    /* compiled from: NewTransformer.java */
    /* renamed from: com.g.b.a.c.i$1, reason: invalid class name */
    class AnonymousClass1 implements C1345b.b<b[]> {

        /* renamed from: a */
        boolean f8733a = false;

        /* renamed from: b */
        b[] f8734b;

        /* renamed from: c */
        C1365f f8735c;

        /* renamed from: d */
        private final C1353i f8736d;

        /* renamed from: e */
        private final int f8737e;

        /* renamed from: f */
        private final Map f8738f;

        AnonymousClass1(C1353i c1353i, int i, Map map) {
            this.f8736d = c1353i;
            this.f8737e = i;
            this.f8738f = map;
            this.f8734b = new b[this.f8737e];
            this.f8735c = new C1365f(this, this.f8738f) { // from class: com.g.b.a.c.i.1.1

                /* renamed from: a */
                AbstractC1333j f8739a;

                /* renamed from: b */
                private final AnonymousClass1 f8740b;

                /* renamed from: c */
                private final Map f8741c;

                {
                    this.f8740b = this;
                    this.f8741c = r2;
                }

                @Override // com.p140g.p152b.p153a.C1365f
                /* renamed from: a */
                public AbstractC1333j mo10687a(AbstractC1333j abstractC1333j) {
                    this.f8739a = abstractC1333j;
                    if (abstractC1333j.f8645i == EnumC1302a.E2 && abstractC1333j.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                        C1314l c1314l = (C1314l) abstractC1333j.mo10563d();
                        if (abstractC1333j.mo10564e().f8563h == AbstractC1322t.e.LOCAL) {
                            this.f8740b.f8734b[c1314l.f8546a] = this.f8740b.f8734b[((C1314l) abstractC1333j.mo10564e()).f8546a];
                            return abstractC1333j;
                        }
                        if (abstractC1333j.mo10564e().f8563h == AbstractC1322t.e.NEW) {
                            this.f8740b.f8734b[c1314l.f8546a] = new b((a) this.f8741c.get(c1314l), false);
                            return abstractC1333j;
                        }
                        mo10678a(abstractC1333j.mo10564e());
                        this.f8740b.f8734b[c1314l.f8546a] = C1353i.f8732a;
                        return abstractC1333j;
                    }
                    if (abstractC1333j.f8650n == AbstractC1333j.d.LABEL) {
                        C1329f c1329f = (C1329f) abstractC1333j;
                        if (c1329f.f8638c != null) {
                            Iterator<C1324a> it = c1329f.f8638c.iterator();
                            while (it.hasNext()) {
                                this.f8740b.f8734b[((C1314l) it.next().mo10563d()).f8546a] = C1353i.f8732a;
                            }
                            return abstractC1333j;
                        }
                        return abstractC1333j;
                    }
                    return super.mo10687a(abstractC1333j);
                }

                @Override // com.p140g.p152b.p153a.C1365f
                /* renamed from: a */
                public AbstractC1322t mo10678a(AbstractC1322t abstractC1322t) {
                    b bVar;
                    a aVar;
                    if (abstractC1322t.f8563h == AbstractC1322t.e.INVOKE_SPECIAL && abstractC1322t.mo10547j().length >= 1 && "<init>".equals(((C1312j) abstractC1322t).m10538e())) {
                        AbstractC1322t abstractC1322t2 = abstractC1322t.mo10547j()[0];
                        if (abstractC1322t2.f8563h == AbstractC1322t.e.LOCAL && (aVar = (bVar = this.f8740b.f8734b[((C1314l) abstractC1322t2).f8546a]).f8747b) != null) {
                            if (aVar.f8742a != null) {
                                aVar.f8744c = true;
                            } else {
                                bVar.f8746a = true;
                                aVar.f8742a = this.f8739a;
                                for (int i2 = 0; i2 < this.f8740b.f8734b.length; i2++) {
                                    b bVar2 = this.f8740b.f8734b[i2];
                                    if (bVar2 != null && bVar2.f8747b == aVar) {
                                        this.f8740b.f8734b[i2] = C1353i.f8732a;
                                    }
                                }
                                this.f8740b.f8733a = true;
                            }
                        }
                    }
                    AbstractC1322t mo10678a = super.mo10678a(abstractC1322t);
                    if (mo10678a.f8563h == AbstractC1322t.e.LOCAL) {
                        this.f8740b.m10685a((C1314l) mo10678a);
                    }
                    return mo10678a;
                }
            };
        }

        @Override // com.p140g.p152b.p153a.p156c.C1345b.b
        /* renamed from: a */
        public b[] mo10614a(AbstractC1333j abstractC1333j) {
            return m10686b(abstractC1333j);
        }

        @Override // com.p140g.p152b.p153a.p156c.C1345b.b
        /* renamed from: a */
        public /* bridge */ b[] mo10615a(b[] bVarArr, AbstractC1333j abstractC1333j) {
            return a2(bVarArr, abstractC1333j);
        }

        @Override // com.p140g.p152b.p153a.p156c.C1345b.b
        /* renamed from: a */
        public /* bridge */ b[] mo10632a(b[] bVarArr, b[] bVarArr2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
            return a2(bVarArr, bVarArr2, abstractC1333j, abstractC1333j2);
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        public b[] a2(b[] bVarArr, b[] bVarArr2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
            List<C1324a> list;
            a aVar;
            a aVar2;
            if (bVarArr2 == null) {
                bVarArr2 = new b[this.f8737e];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, this.f8737e);
            } else {
                for (int i = 0; i < this.f8737e; i++) {
                    b bVar = bVarArr[i];
                    b bVar2 = bVarArr2[i];
                    if (bVar != null) {
                        if (bVar2 == null) {
                            bVarArr2[i] = bVar;
                        } else if (bVar != bVar2) {
                            a aVar3 = bVar.f8747b;
                            if (aVar3 != null) {
                                aVar3.f8744c = true;
                            }
                            a aVar4 = bVar2.f8747b;
                            if (aVar4 != null) {
                                aVar4.f8744c = true;
                            }
                        }
                    }
                }
            }
            if (abstractC1333j2.f8650n == AbstractC1333j.d.LABEL && (list = ((C1329f) abstractC1333j2).f8638c) != null && list.size() > 0) {
                Iterator<C1324a> it = list.iterator();
                while (it.hasNext()) {
                    for (AbstractC1322t abstractC1322t : it.next().mo10564e().mo10547j()) {
                        int i2 = ((C1314l) abstractC1322t).f8546a;
                        b bVar3 = bVarArr[i2];
                        b bVar4 = bVarArr2[i2];
                        if (bVar4 != null) {
                            if (!bVar4.f8746a && (aVar2 = bVar4.f8747b) != null) {
                                aVar2.f8744c = true;
                            }
                        } else if (bVar3 != null && !bVar3.f8746a && (aVar = bVar3.f8747b) != null) {
                            aVar.f8744c = true;
                        }
                    }
                }
            }
            return bVarArr2;
        }

        /* renamed from: b */
        public b[] m10686b(AbstractC1333j abstractC1333j) {
            return new b[this.f8737e];
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        public b[] a2(b[] bVarArr, AbstractC1333j abstractC1333j) {
            this.f8733a = false;
            System.arraycopy(bVarArr, 0, this.f8734b, 0, this.f8737e);
            this.f8735c.mo10687a(abstractC1333j);
            if (abstractC1333j.f8641e.size() > 1) {
                this.f8733a = true;
            }
            if (!this.f8733a) {
                abstractC1333j.f8644h = (Object) null;
            }
            return this.f8734b;
        }

        /* renamed from: a */
        void m10685a(C1314l c1314l) {
            b bVar = this.f8734b[c1314l.f8546a];
            if (bVar.f8746a) {
                return;
            }
            a aVar = bVar.f8747b;
            if (aVar != null) {
                aVar.f8744c = true;
            }
            this.f8734b[c1314l.f8546a] = C1353i.f8732a;
        }
    }

    /* renamed from: a */
    C1312j m10679a(AbstractC1333j abstractC1333j, C1312j c1312j) {
        if (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN) {
            if (abstractC1333j.mo10564e().f8563h == AbstractC1322t.e.INVOKE_SPECIAL) {
                return (C1312j) abstractC1333j.mo10564e();
            }
        } else if (abstractC1333j.f8650n == AbstractC1333j.d.VOID_INVOKE) {
            return (C1312j) abstractC1333j.mo10561c();
        }
        return c1312j;
    }

    /* compiled from: NewTransformer.java */
    /* renamed from: com.g.b.a.c.i$a */
    static class a {

        /* renamed from: a */
        public AbstractC1333j f8742a;

        /* renamed from: b */
        C1314l f8743b;

        /* renamed from: c */
        boolean f8744c;

        /* renamed from: d */
        private C1324a f8745d;

        a(C1314l c1314l, C1324a c1324a) {
            this.f8743b = c1314l;
            this.f8745d = c1324a;
        }
    }

    /* compiled from: NewTransformer.java */
    /* renamed from: com.g.b.a.c.i$b */
    static class b {

        /* renamed from: a */
        boolean f8746a;

        /* renamed from: b */
        a f8747b;

        public b(a aVar, boolean z) {
            this.f8747b = aVar;
            this.f8746a = z;
        }
    }
}
