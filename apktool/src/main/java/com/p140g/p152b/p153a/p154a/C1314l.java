package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: Local.java */
/* renamed from: com.g.b.a.a.l */
/* loaded from: classes.dex */
public class C1314l extends AbstractC1322t.a {

    /* renamed from: a */
    public int f8546a;

    /* renamed from: b */
    public String f8547b;

    /* renamed from: c */
    public String f8548c;

    public C1314l() {
        super(AbstractC1322t.e.LOCAL);
    }

    public C1314l(int i) {
        super(AbstractC1322t.e.LOCAL);
        this.f8546a = i;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        C1314l c1314l = new C1314l(this.f8546a);
        c1314l.f8548c = this.f8548c;
        c1314l.f8547b = this.f8547b;
        c1314l.f8561f = this.f8561f;
        return c1314l;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return c1339c.mo10601a(this);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        return this.f8548c == null ? new StringBuffer().append("a").append(this.f8546a).toString() : new StringBuffer().append(new StringBuffer().append(this.f8548c).append("_").toString()).append(this.f8546a).toString();
    }
}
