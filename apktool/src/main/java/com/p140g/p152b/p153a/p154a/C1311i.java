package com.p140g.p152b.p153a.p154a;

import com.p140g.p141a.C1287f;
import com.p140g.p141a.C1292g;
import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: InvokeCustomExpr.java */
/* renamed from: com.g.b.a.a.i */
/* loaded from: classes.dex */
public class C1311i extends AbstractC1303a {

    /* renamed from: a */
    public String f8539a;

    /* renamed from: b */
    public C1292g f8540b;

    /* renamed from: c */
    public C1287f f8541c;

    /* renamed from: d */
    public Object[] f8542d;

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1303a
    /* renamed from: l_ */
    public C1292g mo10479l_() {
        return this.f8540b;
    }

    public C1311i(AbstractC1322t.e eVar, AbstractC1322t[] abstractC1322tArr, String str, C1292g c1292g, C1287f c1287f, Object[] objArr) {
        super(eVar, abstractC1322tArr);
        this.f8540b = c1292g;
        this.f8539a = str;
        this.f8541c = c1287f;
        this.f8542d = objArr;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1311i(this.f8563h, m10550l(), this.f8539a, this.f8540b, this.f8541c, this.f8542d);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1311i(this.f8563h, m10549b(c1339c), this.f8539a, this.f8540b, this.f8541c, this.f8542d);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        return "InvokeCustomExpr(....)";
    }
}
