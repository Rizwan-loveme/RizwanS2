package com.p140g.p152b.p153a.p154a;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: FilledArrayExpr.java */
/* renamed from: com.g.b.a.a.h */
/* loaded from: classes.dex */
public class C1310h extends AbstractC1322t.d {

    /* renamed from: a */
    public String f8538a;

    public C1310h(AbstractC1322t[] abstractC1322tArr, String str) {
        super(AbstractC1322t.e.FILLED_ARRAY, abstractC1322tArr);
        this.f8538a = str;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1310h(m10550l(), this.f8538a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1310h(m10549b(c1339c), this.f8538a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        StringBuilder append = new StringBuilder().append("new ").append(C1368i.m10770a(this.f8538a)).append("[]{");
        for (int i = 0; i < this.f8567i.length; i++) {
            append.append(this.f8567i[i]).append(", ");
        }
        if (this.f8567i.length > 0) {
            append.setLength(append.length() - 2);
        }
        append.append('}');
        return append.toString();
    }
}
