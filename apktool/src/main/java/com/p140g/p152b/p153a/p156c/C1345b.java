package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1366g;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1325b;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1331h;
import com.p140g.p152b.p153a.p155b.C1334k;
import com.p140g.p152b.p153a.p155b.C1335l;
import com.p140g.p152b.p153a.p155b.InterfaceC1328e;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/* compiled from: Cfg.java */
/* renamed from: com.g.b.a.c.b */
/* loaded from: classes.dex */
public class C1345b {

    /* compiled from: Cfg.java */
    /* renamed from: com.g.b.a.c.b$a */
    public interface a {
        /* renamed from: a */
        void mo10661a(AbstractC1333j abstractC1333j);
    }

    /* compiled from: Cfg.java */
    /* renamed from: com.g.b.a.c.b$b */
    public interface b<T> {
        /* renamed from: a */
        T mo10614a(AbstractC1333j abstractC1333j);

        /* renamed from: a */
        T mo10615a(T t, AbstractC1333j abstractC1333j);

        /* renamed from: a */
        T mo10632a(T t, T t2, AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2);
    }

    /* compiled from: Cfg.java */
    /* renamed from: com.g.b.a.c.b$c */
    public interface c {
        /* renamed from: a */
        AbstractC1322t mo10612a(C1314l c1314l, C1324a c1324a);
    }

    /* compiled from: Cfg.java */
    /* renamed from: com.g.b.a.c.b$d */
    public interface d {
        /* renamed from: a */
        AbstractC1322t mo10611a(C1314l c1314l);
    }

    /* compiled from: Cfg.java */
    /* renamed from: com.g.b.a.c.b$e */
    public interface e extends c, d {
    }

    /* renamed from: a */
    public static int[] m10647a(C1323b c1323b) {
        int[] iArr = new int[m10654d(c1323b)];
        m10643a(c1323b.f8628g, new e(iArr) { // from class: com.g.b.a.c.b.1

            /* renamed from: a */
            private final int[] f8698a;

            {
                this.f8698a = iArr;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.c
            /* renamed from: a */
            public AbstractC1322t mo10612a(C1314l c1314l, C1324a c1324a) {
                return c1314l;
            }

            @Override // com.p140g.p152b.p153a.p156c.C1345b.d
            /* renamed from: a */
            public AbstractC1322t mo10611a(C1314l c1314l) {
                int[] iArr2 = this.f8698a;
                int i = c1314l.f8546a;
                iArr2[i] = iArr2[i] + 1;
                return c1314l;
            }
        }, true);
        return iArr;
    }

    /* renamed from: a */
    public static boolean m10646a(AbstractC1333j abstractC1333j) {
        return !m10652b(abstractC1333j);
    }

    /* renamed from: b */
    public static boolean m10652b(AbstractC1333j abstractC1333j) {
        AbstractC1333j.d dVar = abstractC1333j.f8650n;
        if (dVar.m10571e()) {
            return true;
        }
        if (!dVar.m10570d()) {
            return false;
        }
        EnumC1302a enumC1302a = abstractC1333j.f8645i;
        if (enumC1302a == EnumC1302a.E1) {
            return m10645a(abstractC1333j.mo10561c());
        }
        if (enumC1302a == EnumC1302a.E2) {
            return m10645a(abstractC1333j.mo10563d()) || m10645a(abstractC1333j.mo10564e());
        }
        throw new RuntimeException();
    }

    /* renamed from: a */
    private static boolean m10645a(AbstractC1322t abstractC1322t) {
        AbstractC1322t.e eVar = abstractC1322t.f8563h;
        if (eVar.m10551a()) {
            return true;
        }
        if (!eVar.m10552b()) {
            return false;
        }
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a == EnumC1302a.E1) {
            return m10645a(abstractC1322t.mo10544g());
        }
        if (enumC1302a == EnumC1302a.E2) {
            return m10645a(abstractC1322t.mo10545h()) || m10645a(abstractC1322t.mo10546i());
        }
        if (enumC1302a != EnumC1302a.En && enumC1302a != EnumC1302a.E0) {
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static void m10651b(C1323b c1323b) {
        for (AbstractC1333j abstractC1333j : c1323b.f8628g) {
            abstractC1333j.f8644h = (Object) null;
            abstractC1333j.f8642f = (Set) null;
            if (abstractC1333j.f8641e == null) {
                abstractC1333j.f8641e = new TreeSet(c1323b.f8628g);
            } else {
                abstractC1333j.f8641e.clear();
            }
        }
        for (AbstractC1333j abstractC1333j2 : c1323b.f8628g) {
            if (abstractC1333j2.f8650n.m10567a()) {
                m10639a(abstractC1333j2, ((InterfaceC1328e) abstractC1333j2).mo10555a());
            }
            if (abstractC1333j2.f8650n.m10568b()) {
                m10639a(abstractC1333j2, abstractC1333j2.m10559b());
            }
            if (abstractC1333j2.f8650n.m10569c()) {
                AbstractC1325b abstractC1325b = (AbstractC1325b) abstractC1333j2;
                m10639a(abstractC1333j2, abstractC1325b.f8633b);
                C1329f[] c1329fArr = abstractC1325b.f8632a;
                for (C1329f c1329f : c1329fArr) {
                    m10639a(abstractC1333j2, c1329f);
                }
            }
        }
    }

    /* renamed from: c */
    public static void m10653c(C1323b c1323b) {
        m10651b(c1323b);
        for (C1366g c1366g : c1323b.f8629h) {
            for (AbstractC1333j abstractC1333j = c1366g.f8802a; abstractC1333j != c1366g.f8803b; abstractC1333j = abstractC1333j.m10559b()) {
                if (m10652b(abstractC1333j)) {
                    Set set = abstractC1333j.f8642f;
                    if (set == null) {
                        set = new TreeSet(c1323b.f8628g);
                        abstractC1333j.f8642f = set;
                    }
                    for (C1329f c1329f : c1366g.f8804c) {
                        m10639a(abstractC1333j, c1329f);
                        set.add(c1329f);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m10644a(C1323b c1323b, a aVar) {
        Iterator<AbstractC1333j> it = c1323b.f8628g.iterator();
        while (it.hasNext()) {
            it.next().f8643g = false;
        }
        Stack stack = new Stack();
        stack.add(c1323b.f8628g.m10574a());
        while (!stack.isEmpty()) {
            AbstractC1333j abstractC1333j = (AbstractC1333j) stack.pop();
            if (!abstractC1333j.f8643g) {
                abstractC1333j.f8643g = true;
                if (abstractC1333j.f8642f != null) {
                    Iterator<C1329f> it2 = abstractC1333j.f8642f.iterator();
                    while (it2.hasNext()) {
                        stack.push(it2.next());
                    }
                }
                if (aVar != null) {
                    aVar.mo10661a(abstractC1333j);
                }
                if (abstractC1333j.f8650n.m10569c()) {
                    AbstractC1325b abstractC1325b = (AbstractC1325b) abstractC1333j;
                    Collections.addAll(stack, abstractC1325b.f8632a);
                    stack.add(abstractC1325b.f8633b);
                }
                if (abstractC1333j.f8650n.m10567a()) {
                    stack.add(((InterfaceC1328e) abstractC1333j).mo10555a());
                }
                if (abstractC1333j.f8650n.m10568b()) {
                    stack.add(abstractC1333j.m10559b());
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressWarnings("unchecked")
    /* renamed from: a */
    public static <T> void m10642a(C1334k c1334k, b<T> bVar) {
        AbstractC1333j abstractC1333j;
        if (c1334k.m10578b() != 0) {
            for (AbstractC1333j abstractC1333j2 : c1334k) {
                abstractC1333j2.f8643g = false;
                abstractC1333j2.f8644h = (Object) null;
            }
            Stack stack = new Stack();
            AbstractC1333j m10574a = c1334k.m10574a();
            AbstractC1333j abstractC1333j3 = (AbstractC1333j) null;
            if (m10574a.f8650n != AbstractC1333j.d.LABEL || m10574a.f8641e.size() <= 0) {
                abstractC1333j = abstractC1333j3;
            } else {
                C1331h m10594b = C1335l.m10594b();
                m10574a.f8641e.add(m10594b);
                abstractC1333j = m10594b;
            }
            stack.add(m10574a);
            m10574a.f8644h = bVar.mo10614a(m10574a);
            while (!stack.isEmpty()) {
                AbstractC1333j abstractC1333j4 = (AbstractC1333j) stack.pop();
                if (abstractC1333j4 != 0 && !abstractC1333j4.f8643g) {
                    abstractC1333j4.f8643g = true;
                    Object obj = abstractC1333j4.f8644h;
                    if (abstractC1333j4.f8642f != null) {
                        for (C1329f c1329f : abstractC1333j4.f8642f) {
                            c1329f.f8644h = bVar.mo10632a(obj, c1329f.f8644h, abstractC1333j4, c1329f);
                            stack.push(c1329f);
                        }
                    }
                    Object mo10615a = bVar.mo10615a(obj, abstractC1333j4);
                    if (abstractC1333j4.f8650n.m10569c()) {
                        AbstractC1325b abstractC1325b = (AbstractC1325b) abstractC1333j4;
                        for (C1329f c1329f2 : abstractC1325b.f8632a) {
                            c1329f2.f8644h = bVar.mo10632a(mo10615a, c1329f2.f8644h, abstractC1333j4, c1329f2);
                            stack.push(c1329f2);
                        }
                        C1329f c1329f3 = abstractC1325b.f8633b;
                        c1329f3.f8644h = bVar.mo10632a(mo10615a, c1329f3.f8644h, abstractC1333j4, c1329f3);
                        stack.push(c1329f3);
                    }
                    if (abstractC1333j4.f8650n.m10567a()) {
                        C1329f mo10555a = ((InterfaceC1328e) abstractC1333j4).mo10555a();
                        mo10555a.f8644h = bVar.mo10632a(mo10615a, mo10555a.f8644h, abstractC1333j4, mo10555a);
                        stack.push(mo10555a);
                    }
                    if (abstractC1333j4.f8650n.m10568b()) {
                        AbstractC1333j m10559b = abstractC1333j4.m10559b();
                        m10559b.f8644h = bVar.mo10632a(mo10615a, m10559b.f8644h, abstractC1333j4, m10559b);
                        stack.push(m10559b);
                    }
                }
            }
            if (abstractC1333j != null) {
                m10574a.f8641e.remove(abstractC1333j);
            }
        }
    }

    /* renamed from: a */
    private static void m10639a(AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        if (abstractC1333j2 == null) {
            return;
        }
        abstractC1333j2.f8641e.add(abstractC1333j);
    }

    /* renamed from: a */
    public static AbstractC1322t m10638a(AbstractC1322t abstractC1322t, d dVar) {
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a == EnumC1302a.E0) {
            if (abstractC1322t.f8563h == AbstractC1322t.e.LOCAL) {
                return dVar.mo10611a((C1314l) abstractC1322t);
            }
            return abstractC1322t;
        }
        if (enumC1302a == EnumC1302a.E1) {
            abstractC1322t.mo10540a(m10638a(abstractC1322t.mo10544g(), dVar));
            return abstractC1322t;
        }
        if (enumC1302a == EnumC1302a.E2) {
            abstractC1322t.mo10542b(m10638a(abstractC1322t.mo10545h(), dVar));
            abstractC1322t.mo10543c(m10638a(abstractC1322t.mo10546i(), dVar));
            return abstractC1322t;
        }
        if (enumC1302a == EnumC1302a.En) {
            AbstractC1322t[] mo10547j = abstractC1322t.mo10547j();
            for (int i = 0; i < mo10547j.length; i++) {
                mo10547j[i] = m10638a(mo10547j[i], dVar);
            }
            return abstractC1322t;
        }
        return abstractC1322t;
    }

    /* renamed from: b */
    public static void m10648b(AbstractC1322t abstractC1322t, d dVar) {
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a == EnumC1302a.E0) {
            if (abstractC1322t.f8563h == AbstractC1322t.e.LOCAL) {
                dVar.mo10611a((C1314l) abstractC1322t);
            }
        } else {
            if (enumC1302a == EnumC1302a.E1) {
                m10648b(abstractC1322t.mo10544g(), dVar);
                return;
            }
            if (enumC1302a == EnumC1302a.E2) {
                m10648b(abstractC1322t.mo10545h(), dVar);
                m10648b(abstractC1322t.mo10546i(), dVar);
            } else if (enumC1302a == EnumC1302a.En) {
                for (AbstractC1322t abstractC1322t2 : abstractC1322t.mo10547j()) {
                    m10648b(abstractC1322t2, dVar);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10640a(AbstractC1333j abstractC1333j, e eVar, boolean z) {
        EnumC1302a enumC1302a = abstractC1333j.f8645i;
        if (enumC1302a == EnumC1302a.E1) {
            abstractC1333j.mo10558a(m10638a(abstractC1333j.mo10561c(), eVar));
            return;
        }
        if (enumC1302a == EnumC1302a.E2) {
            AbstractC1322t mo10563d = abstractC1333j.mo10563d();
            if (mo10563d.f8563h == AbstractC1322t.e.LOCAL && (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN || abstractC1333j.f8650n == AbstractC1333j.d.IDENTITY)) {
                abstractC1333j.mo10562c(m10638a(abstractC1333j.mo10564e(), eVar));
                abstractC1333j.mo10560b(eVar.mo10612a((C1314l) mo10563d, (C1324a) abstractC1333j));
                return;
            } else {
                abstractC1333j.mo10560b(m10638a(abstractC1333j.mo10563d(), eVar));
                abstractC1333j.mo10562c(m10638a(abstractC1333j.mo10564e(), eVar));
                return;
            }
        }
        if ((enumC1302a == EnumC1302a.En || enumC1302a == EnumC1302a.E0) && z && abstractC1333j.f8650n == AbstractC1333j.d.LABEL) {
            C1329f c1329f = (C1329f) abstractC1333j;
            if (c1329f.f8638c != null) {
                Iterator<C1324a> it = c1329f.f8638c.iterator();
                while (it.hasNext()) {
                    m10640a((AbstractC1333j) it.next(), eVar, false);
                }
            }
        }
    }

    /* renamed from: b */
    public static void m10649b(AbstractC1333j abstractC1333j, e eVar, boolean z) {
        EnumC1302a enumC1302a = abstractC1333j.f8645i;
        if (enumC1302a == EnumC1302a.E1) {
            m10648b(abstractC1333j.mo10561c(), eVar);
            return;
        }
        if (enumC1302a == EnumC1302a.E2) {
            AbstractC1322t mo10563d = abstractC1333j.mo10563d();
            if (mo10563d.f8563h == AbstractC1322t.e.LOCAL && (abstractC1333j.f8650n == AbstractC1333j.d.ASSIGN || abstractC1333j.f8650n == AbstractC1333j.d.IDENTITY)) {
                m10648b(abstractC1333j.mo10564e(), eVar);
                eVar.mo10612a((C1314l) mo10563d, (C1324a) abstractC1333j);
                return;
            } else {
                m10648b(abstractC1333j.mo10563d(), eVar);
                m10648b(abstractC1333j.mo10564e(), eVar);
                return;
            }
        }
        if ((enumC1302a == EnumC1302a.En || enumC1302a == EnumC1302a.E0) && z && abstractC1333j.f8650n == AbstractC1333j.d.LABEL) {
            C1329f c1329f = (C1329f) abstractC1333j;
            if (c1329f.f8638c != null) {
                Iterator<C1324a> it = c1329f.f8638c.iterator();
                while (it.hasNext()) {
                    m10649b((AbstractC1333j) it.next(), eVar, false);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10643a(C1334k c1334k, e eVar, boolean z) {
        for (AbstractC1333j m10574a = c1334k.m10574a(); m10574a != null; m10574a = m10574a.m10559b()) {
            m10649b(m10574a, eVar, z);
        }
    }

    /* renamed from: b */
    public static void m10650b(C1334k c1334k, e eVar, boolean z) {
        for (AbstractC1333j m10574a = c1334k.m10574a(); m10574a != null; m10574a = m10574a.m10559b()) {
            m10640a(m10574a, eVar, z);
        }
    }

    /* renamed from: d */
    public static int m10654d(C1323b c1323b) {
        int i = 0;
        Iterator<C1314l> it = c1323b.f8624c.iterator();
        while (it.hasNext()) {
            it.next().f8546a = i;
            i++;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m10641a(AbstractC1333j abstractC1333j, Set<AbstractC1333j> set) {
        if (abstractC1333j.f8650n.m10567a()) {
            set.add(((InterfaceC1328e) abstractC1333j).mo10555a());
        }
        if (abstractC1333j.f8650n.m10568b()) {
            set.add(abstractC1333j.m10559b());
        }
        if (abstractC1333j.f8650n.m10569c()) {
            AbstractC1325b abstractC1325b = (AbstractC1325b) abstractC1333j;
            set.add(abstractC1325b.f8633b);
            C1329f[] c1329fArr = abstractC1325b.f8632a;
            for (C1329f c1329f : c1329fArr) {
                set.add(c1329f);
            }
        }
        if (abstractC1333j.f8642f != null) {
            set.addAll(abstractC1333j.f8642f);
        }
    }
}
