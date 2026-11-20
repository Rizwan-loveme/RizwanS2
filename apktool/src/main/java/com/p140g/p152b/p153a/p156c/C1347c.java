package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1363d;
import com.p140g.p152b.p153a.C1366g;
import com.p140g.p152b.p153a.p155b.AbstractC1325b;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1334k;
import com.p140g.p152b.p153a.p155b.InterfaceC1328e;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: CleanLabel.java */
/* renamed from: com.g.b.a.c.c */
/* loaded from: classes.dex */
public class C1347c {
    /* renamed from: a */
    public void m10668a(C1323b c1323b) {
        HashSet hashSet = new HashSet();
        m10667b(c1323b.f8629h, hashSet);
        m10665a(c1323b.f8630i, hashSet);
        m10666b(c1323b.f8628g, hashSet);
        m10664a(c1323b.f8628g, hashSet);
    }

    /* renamed from: a */
    private void m10665a(List<C1363d> list, Set<C1329f> set) {
        if (list != null) {
            for (C1363d c1363d : list) {
                set.add(c1363d.f8796a);
                set.add(c1363d.f8797b);
            }
        }
    }

    /* renamed from: a */
    private void m10664a(C1334k c1334k, Set<C1329f> set) {
        AbstractC1333j m10574a = c1334k.m10574a();
        while (m10574a != null) {
            if (m10574a.f8650n == AbstractC1333j.d.LABEL && !set.contains(m10574a)) {
                AbstractC1333j m10559b = m10574a.m10559b();
                c1334k.m10583d(m10574a);
                m10574a = m10559b;
            } else {
                m10574a = m10574a.m10559b();
            }
        }
    }

    /* renamed from: b */
    private void m10666b(C1334k c1334k, Set<C1329f> set) {
        for (AbstractC1333j m10574a = c1334k.m10574a(); m10574a != null; m10574a = m10574a.m10559b()) {
            if (m10574a instanceof InterfaceC1328e) {
                set.add(((InterfaceC1328e) m10574a).mo10555a());
            } else if (m10574a instanceof AbstractC1325b) {
                AbstractC1325b abstractC1325b = (AbstractC1325b) m10574a;
                set.add(abstractC1325b.f8633b);
                C1329f[] c1329fArr = abstractC1325b.f8632a;
                for (C1329f c1329f : c1329fArr) {
                    set.add(c1329f);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10667b(List<C1366g> list, Set<C1329f> set) {
        if (list != null) {
            for (C1366g c1366g : list) {
                set.add(c1366g.f8802a);
                set.add(c1366g.f8803b);
                C1329f[] c1329fArr = c1366g.f8804c;
                for (C1329f c1329f : c1329fArr) {
                    set.add(c1329f);
                }
            }
        }
    }
}
