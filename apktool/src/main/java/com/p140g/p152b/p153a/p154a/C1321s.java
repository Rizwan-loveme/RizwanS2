package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: UnopExpr.java */
/* renamed from: com.g.b.a.a.s */
/* loaded from: classes.dex */
public class C1321s extends AbstractC1322t.b {

    /* renamed from: a */
    public String f8558a;

    public C1321s(AbstractC1322t.e eVar, AbstractC1322t abstractC1322t, String str) {
        super(eVar, abstractC1322t);
        this.f8558a = str;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1321s(this.f8563h, this.f8564d.m10548k().mo10480a(), this.f8558a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1321s(this.f8563h, this.f8564d.mo10481a(c1339c), this.f8558a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        AbstractC1322t.e eVar = this.f8563h;
        if (eVar == AbstractC1322t.e.LENGTH) {
            return new StringBuffer().append(this.f8564d).append(".length").toString();
        }
        if (eVar == AbstractC1322t.e.NEG) {
            return new StringBuffer().append(new StringBuffer().append("(-").append(this.f8564d).toString()).append(")").toString();
        }
        if (eVar == AbstractC1322t.e.NOT) {
            return new StringBuffer().append(new StringBuffer().append("(!").append(this.f8564d).toString()).append(")").toString();
        }
        return super.toString();
    }
}
