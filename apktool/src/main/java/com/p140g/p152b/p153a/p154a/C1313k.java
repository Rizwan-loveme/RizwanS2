package com.p140g.p152b.p153a.p154a;

import com.p140g.p141a.C1280e;
import com.p140g.p141a.C1292g;
import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: InvokePolymorphicExpr.java */
/* renamed from: com.g.b.a.a.k */
/* loaded from: classes.dex */
public class C1313k extends AbstractC1303a {

    /* renamed from: a */
    public C1292g f8544a;

    /* renamed from: b */
    public C1280e f8545b;

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1303a
    /* renamed from: l_ */
    public C1292g mo10479l_() {
        return this.f8544a;
    }

    public C1313k(AbstractC1322t.e eVar, AbstractC1322t[] abstractC1322tArr, C1292g c1292g, C1280e c1280e) {
        super(eVar, abstractC1322tArr);
        this.f8544a = c1292g;
        this.f8545b = c1280e;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1313k(this.f8563h, m10550l(), this.f8544a, this.f8545b);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1313k(this.f8563h, m10549b(c1339c), this.f8544a, this.f8545b);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8567i[0]).append('.').append(this.f8545b.m10398c());
        String[] m10470a = mo10479l_().m10470a();
        sb.append('(');
        boolean z = true;
        int i = 0;
        int i2 = 1;
        while (i2 < this.f8567i.length) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append("(").append(C1368i.m10770a(m10470a[i])).append(")").append(this.f8567i[i2]);
            i2++;
            i++;
        }
        sb.append(')');
        return sb.toString();
    }
}
