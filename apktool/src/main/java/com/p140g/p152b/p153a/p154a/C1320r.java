package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: TypeExpr.java */
/* renamed from: com.g.b.a.a.r */
/* loaded from: classes.dex */
public class C1320r extends AbstractC1322t.b {

    /* renamed from: a */
    public String f8557a;

    public C1320r(AbstractC1322t.e eVar, AbstractC1322t abstractC1322t, String str) {
        super(eVar, abstractC1322t);
        this.f8557a = str;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1320r(this.f8563h, this.f8564d.m10548k().mo10480a(), this.f8557a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1320r(this.f8563h, this.f8564d.mo10481a(c1339c), this.f8557a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        AbstractC1322t.e eVar = this.f8563h;
        if (eVar == AbstractC1322t.e.CHECK_CAST) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("((").append(C1368i.m10770a(this.f8557a)).toString()).append(")").toString()).append(this.f8564d).toString()).append(")").toString();
        }
        if (eVar == AbstractC1322t.e.INSTANCE_OF) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("(").append(this.f8564d).toString()).append(" instanceof ").toString()).append(C1368i.m10770a(this.f8557a)).toString()).append(")").toString();
        }
        if (eVar == AbstractC1322t.e.NEW_ARRAY) {
            if (this.f8557a.charAt(0) == '[') {
                int i = 1;
                while (this.f8557a.charAt(i) == '[') {
                    i++;
                }
                StringBuilder append = new StringBuilder("new ").append(C1368i.m10770a(this.f8557a.substring(i))).append("[").append(this.f8564d).append("]");
                for (int i2 = 0; i2 < i; i2++) {
                    append.append("[]");
                }
                return append.toString();
            }
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("new ").append(C1368i.m10770a(this.f8557a)).toString()).append("[").toString()).append(this.f8564d).toString()).append("]").toString();
        }
        return "UNKNOW";
    }
}
