package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1335l;

/* compiled from: VoidInvokeTransformer.java */
/* renamed from: com.g.b.a.c.q */
/* loaded from: classes.dex */
public class C1361q extends AbstractC1357m {
    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        AbstractC1333j abstractC1333j;
        boolean z = false;
        if (c1323b.f8624c.size() != 0) {
            int[] m10647a = C1345b.m10647a(c1323b);
            AbstractC1333j m10574a = c1323b.f8628g.m10574a();
            while (m10574a != null) {
                if (m10574a.f8650n == AbstractC1333j.d.ASSIGN && m10574a.mo10563d().f8563h == AbstractC1322t.e.LOCAL) {
                    C1314l c1314l = (C1314l) m10574a.mo10563d();
                    if (m10647a[c1314l.f8546a] == 0) {
                        AbstractC1322t.e eVar = m10574a.mo10564e().f8563h;
                        if (eVar == AbstractC1322t.e.INVOKE_INTERFACE || eVar == AbstractC1322t.e.INVOKE_NEW || eVar == AbstractC1322t.e.INVOKE_SPECIAL || eVar == AbstractC1322t.e.INVOKE_STATIC || eVar == AbstractC1322t.e.INVOKE_VIRTUAL) {
                            c1323b.f8624c.remove(c1314l);
                            abstractC1333j = C1335l.m10600e(m10574a.mo10564e());
                            c1323b.f8628g.m10584d(m10574a, abstractC1333j);
                            z = true;
                        } else {
                            abstractC1333j = m10574a;
                        }
                        m10574a = abstractC1333j.m10559b();
                    }
                }
                abstractC1333j = m10574a;
                m10574a = abstractC1333j.m10559b();
            }
        }
        return z;
    }

    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: b */
    public void mo10706b(C1323b c1323b) {
        mo10610a(c1323b);
    }
}
