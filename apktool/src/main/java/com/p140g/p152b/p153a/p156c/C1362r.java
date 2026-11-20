package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1307e;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1335l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ZeroTransformer.java */
/* renamed from: com.g.b.a.c.r */
/* loaded from: classes.dex */
public class C1362r extends AbstractC1357m {
    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        boolean z;
        int intValue;
        ArrayList<C1324a> arrayList = new ArrayList();
        for (AbstractC1333j m10574a = c1323b.f8628g.m10574a(); m10574a != null; m10574a = m10574a.m10559b()) {
            if (m10574a.f8650n == AbstractC1333j.d.ASSIGN) {
                C1324a c1324a = (C1324a) m10574a;
                if (c1324a.mo10563d().f8563h == AbstractC1322t.e.LOCAL && c1324a.mo10564e().f8563h == AbstractC1322t.e.CONSTANT) {
                    Object obj = ((C1307e) c1324a.mo10564e()).f8534b;
                    if ((obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Double) && ((intValue = ((Number) obj).intValue()) == 0 || intValue == 1)) {
                        arrayList.add(c1324a);
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            return false;
        }
        List<C1329f> list = c1323b.f8631j;
        if (list != null) {
            z = false;
            for (C1324a c1324a2 : arrayList) {
                C1314l c1314l = (C1314l) c1324a2.mo10563d();
                Iterator<C1329f> it = list.iterator();
                boolean z2 = true;
                while (it.hasNext()) {
                    Iterator<C1324a> it2 = it.next().f8638c.iterator();
                    while (it2.hasNext()) {
                        AbstractC1322t[] mo10547j = it2.next().mo10564e().mo10547j();
                        for (int i = 0; i < mo10547j.length; i++) {
                            if (mo10547j[i] == c1314l) {
                                if (z2) {
                                    z2 = false;
                                } else {
                                    C1314l m10508b = C1308f.m10508b(-1);
                                    c1323b.f8624c.add(m10508b);
                                    c1323b.f8628g.m10582c(c1324a2, C1335l.m10586a(m10508b, c1324a2.mo10564e().mo10480a()));
                                    mo10547j[i] = m10508b;
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            z = false;
        }
        return z;
    }
}
