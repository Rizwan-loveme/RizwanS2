package com.p140g.p152b.p153a.p154a;

import com.p140g.p141a.C1280e;
import com.p140g.p141a.C1292g;
import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: InvokeExpr.java */
/* renamed from: com.g.b.a.a.j */
/* loaded from: classes.dex */
public class C1312j extends AbstractC1303a {

    /* renamed from: a */
    public C1280e f8543a;

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1303a
    /* renamed from: l_ */
    public C1292g mo10479l_() {
        return this.f8543a.m10396a();
    }

    public C1312j(AbstractC1322t.e eVar, AbstractC1322t[] abstractC1322tArr, String str, String str2, String[] strArr, String str3) {
        super(eVar, abstractC1322tArr);
        this.f8543a = new C1280e(str, str2, strArr, str3);
    }

    public C1312j(AbstractC1322t.e eVar, AbstractC1322t[] abstractC1322tArr, C1280e c1280e) {
        super(eVar, abstractC1322tArr);
        this.f8543a = c1280e;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1312j(this.f8563h, m10550l(), this.f8543a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1312j(this.f8563h, m10549b(c1339c), this.f8543a);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        int i;
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        if (this.f8563h == AbstractC1322t.e.INVOKE_NEW) {
            sb.append("new ").append(C1368i.m10770a(this.f8543a.m10399d()));
            i = 0;
        } else if (this.f8563h == AbstractC1322t.e.INVOKE_STATIC) {
            sb.append(C1368i.m10770a(this.f8543a.m10399d())).append('.').append(this.f8543a.m10398c());
            i = 0;
        } else {
            sb.append(this.f8567i[0]).append('.').append(this.f8543a.m10398c());
            i = 1;
        }
        sb.append('(');
        while (i < this.f8567i.length) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f8567i[i]);
            i++;
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: c */
    public String m10536c() {
        return this.f8543a.m10399d();
    }

    /* renamed from: d */
    public String m10537d() {
        return this.f8543a.m10401f();
    }

    /* renamed from: e */
    public String m10538e() {
        return this.f8543a.m10398c();
    }

    /* renamed from: f */
    public String[] m10539f() {
        return this.f8543a.m10400e();
    }
}
