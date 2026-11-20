package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: StaticFieldExpr.java */
/* renamed from: com.g.b.a.a.q */
/* loaded from: classes.dex */
public class C1319q extends AbstractC1322t.a {

    /* renamed from: a */
    public String f8554a;

    /* renamed from: b */
    public String f8555b;

    /* renamed from: c */
    public String f8556c;

    public C1319q(String str, String str2, String str3) {
        super(AbstractC1322t.e.STATIC_FIELD);
        this.f8556c = str3;
        this.f8554a = str2;
        this.f8555b = str;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1319q(this.f8555b, this.f8554a, this.f8556c);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1319q(this.f8555b, this.f8554a, this.f8556c);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        return new StringBuffer().append(new StringBuffer().append(C1368i.m10770a(this.f8555b)).append(".").toString()).append(this.f8554a).toString();
    }
}
