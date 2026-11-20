package com.p140g.p152b.p153a.p156c;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1366g;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1335l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExceptionHandlerTrim.java */
/* renamed from: com.g.b.a.c.f */
/* loaded from: classes.dex */
public class C1350f {
    @SuppressWarnings({"unchecked", "rawtypes"})
    /* renamed from: a */
    public void m10670a(C1323b c1323b) {
        List<C1366g> list = c1323b.f8629h;
        c1323b.f8629h = new ArrayList();
        C1339c c1339c = new C1339c(this) { // from class: com.g.b.a.c.f.1

            /* renamed from: c */
            private final C1350f f8724c;

            {
                this.f8724c = this;
            }

            @Override // com.p140g.p152b.p153a.C1339c
            /* renamed from: a */
            public C1329f mo10602a(C1329f c1329f) {
                return c1329f;
            }
        };
        for (C1366g c1366g : list) {
            C1366g m10766a = c1366g.m10766a(c1339c);
            boolean z = false;
            for (AbstractC1333j b2 = c1366g.f8802a.m10559b(); b2 != c1366g.f8803b; b2 = b2.m10559b()) {
                if (!C1345b.m10646a(b2)) {
                    if (!z) {
                        AbstractC1333j m10566g = b2.m10566g();
                        if (m10566g == null || m10566g.f8650n != AbstractC1333j.d.LABEL) {
                            m10566g = C1335l.m10589a();
                            c1323b.f8628g.m10582c(b2, m10566g);
                        }
                        m10766a.f8802a = (C1329f) m10566g;
                        z = true;
                    } else if (z) {
                    }
                } else if (z) {
                    AbstractC1333j m10566g2 = b2.m10566g();
                    if (m10566g2 == null || m10566g2.f8650n != AbstractC1333j.d.LABEL) {
                        m10566g2 = C1335l.m10589a();
                        c1323b.f8628g.m10582c(b2, m10566g2);
                    }
                    m10766a.f8803b = (C1329f) m10566g2;
                    c1323b.f8629h.add(m10766a);
                    m10766a = c1366g.m10766a(c1339c);
                    z = false;
                }
            }
            if (z) {
                m10766a.f8803b = c1366g.f8803b;
                c1323b.f8629h.add(m10766a);
            }
        }
    }
}
