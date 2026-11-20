package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: NewMutiArrayExpr.java */
/* renamed from: com.g.b.a.a.n */
/* loaded from: classes.dex */
public class C1316n extends AbstractC1322t.d {

    /* renamed from: a */
    public String f8550a;

    /* renamed from: b */
    public int f8551b;

    public C1316n(String str, int i, AbstractC1322t[] abstractC1322tArr) {
        super(AbstractC1322t.e.NEW_MUTI_ARRAY, abstractC1322tArr);
        this.f8550a = str;
        this.f8551b = i;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1316n(this.f8550a, this.f8551b, m10550l());
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1316n(this.f8550a, this.f8551b, m10549b(c1339c));
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        StringBuilder sb = new StringBuilder();
        sb.append("new ").append(C1368i.m10770a(this.f8550a));
        for (AbstractC1322t abstractC1322t : this.f8567i) {
            sb.append('[').append(abstractC1322t).append(']');
        }
        for (int length = this.f8567i.length; length < this.f8551b; length++) {
            sb.append("[]");
        }
        return sb.toString();
    }
}
