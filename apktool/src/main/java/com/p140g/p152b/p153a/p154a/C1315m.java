package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: NewExpr.java */
/* renamed from: com.g.b.a.a.m */
/* loaded from: classes.dex */
public class C1315m extends AbstractC1322t.a {

    /* renamed from: a */
    public String f8549a;

    public C1315m(String str) {
        super(AbstractC1322t.e.NEW);
        this.f8549a = str;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1315m(this.f8549a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1315m(this.f8549a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        return new StringBuffer().append("NEW ").append(C1368i.m10770a(this.f8549a)).toString();
    }
}
