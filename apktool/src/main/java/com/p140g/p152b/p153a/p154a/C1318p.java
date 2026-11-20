package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: RefExpr.java */
/* renamed from: com.g.b.a.a.p */
/* loaded from: classes.dex */
public class C1318p extends AbstractC1322t.a {

    /* renamed from: a */
    public int f8552a;

    /* renamed from: b */
    public String f8553b;

    public C1318p(AbstractC1322t.e eVar, String str, int i) {
        super(eVar);
        this.f8553b = str;
        this.f8552a = i;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1318p(this.f8563h, this.f8553b, this.f8552a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1318p(this.f8563h, this.f8553b, this.f8552a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        AbstractC1322t.e eVar = this.f8563h;
        if (eVar == AbstractC1322t.e.THIS_REF) {
            return "@this";
        }
        if (eVar == AbstractC1322t.e.PARAMETER_REF) {
            return new StringBuffer().append("@parameter_").append(this.f8552a).toString();
        }
        if (eVar == AbstractC1322t.e.EXCEPTION_REF) {
            return "@Exception";
        }
        return super.toString();
    }
}
