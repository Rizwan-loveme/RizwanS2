package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: FieldExpr.java */
/* renamed from: com.g.b.a.a.g */
/* loaded from: classes.dex */
public class C1309g extends AbstractC1322t.b {

    /* renamed from: a */
    public String f8535a;

    /* renamed from: b */
    public String f8536b;

    /* renamed from: c */
    public String f8537c;

    public C1309g(AbstractC1322t abstractC1322t, String str, String str2, String str3) {
        super(AbstractC1322t.e.FIELD, abstractC1322t);
        this.f8537c = str3;
        this.f8535a = str2;
        this.f8536b = str;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1309g(this.f8564d.m10548k().mo10480a(), this.f8536b, this.f8535a, this.f8537c);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1309g(this.f8564d.mo10481a(c1339c), this.f8536b, this.f8535a, this.f8537c);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        return new StringBuffer().append(new StringBuffer().append(this.f8564d).append(".").toString()).append(this.f8535a).toString();
    }
}
