package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: CastExpr.java */
/* renamed from: com.g.b.a.a.d */
/* loaded from: classes.dex */
public class C1306d extends AbstractC1322t.b {

    /* renamed from: a */
    public String f8531a;

    /* renamed from: b */
    public String f8532b;

    public C1306d(AbstractC1322t abstractC1322t, String str, String str2) {
        super(AbstractC1322t.e.CAST, abstractC1322t);
        this.f8531a = str;
        this.f8532b = str2;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1306d(this.f8564d.m10548k().mo10480a(), this.f8531a, this.f8532b);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1306d(this.f8564d.mo10481a(c1339c), this.f8531a, this.f8532b);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("((").append(C1368i.m10770a(this.f8532b)).toString()).append(")").toString()).append(this.f8564d).toString()).append(")").toString();
    }
}
