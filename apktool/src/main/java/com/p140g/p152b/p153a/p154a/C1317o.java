package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: PhiExpr.java */
/* renamed from: com.g.b.a.a.o */
/* loaded from: classes.dex */
public class C1317o extends AbstractC1322t.d {
    public C1317o(AbstractC1322t[] abstractC1322tArr) {
        super(AbstractC1322t.e.PHI, abstractC1322tArr);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1317o(m10550l());
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1317o(m10549b(c1339c));
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        StringBuilder sb = new StringBuilder("φ(");
        boolean z = true;
        for (AbstractC1322t abstractC1322t : this.f8567i) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(abstractC1322t);
        }
        sb.append(")");
        return sb.toString();
    }
}
