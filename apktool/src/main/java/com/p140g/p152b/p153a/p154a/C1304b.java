package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: ArrayExpr.java */
/* renamed from: com.g.b.a.a.b */
/* loaded from: classes.dex */
public class C1304b extends AbstractC1322t.c {

    /* renamed from: a */
    public String f8529a;

    public C1304b() {
        super(AbstractC1322t.e.ARRAY, (AbstractC1322t) null, (AbstractC1322t) null);
    }

    public C1304b(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        super(AbstractC1322t.e.ARRAY, abstractC1322t, abstractC1322t2);
        this.f8529a = str;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1304b(this.f8565b.m10548k().mo10480a(), this.f8566c.m10548k().mo10480a(), this.f8529a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1304b(this.f8565b.mo10481a(c1339c), this.f8566c.mo10481a(c1339c), this.f8529a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f8565b).append("[").toString()).append(this.f8566c).toString()).append("]").toString();
    }
}
