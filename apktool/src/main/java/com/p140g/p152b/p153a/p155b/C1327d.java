package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;

/* compiled from: IfStmt.java */
/* renamed from: com.g.b.a.b.d */
/* loaded from: classes.dex */
public class C1327d extends AbstractC1333j.b implements InterfaceC1328e {

    /* renamed from: a */
    public C1329f f8635a;

    @Override // com.p140g.p152b.p153a.p155b.InterfaceC1328e
    /* renamed from: a */
    public C1329f mo10555a() {
        return this.f8635a;
    }

    public C1327d(AbstractC1333j.d dVar, AbstractC1322t abstractC1322t, C1329f c1329f) {
        super(dVar, abstractC1322t);
        this.f8635a = c1329f;
    }

    @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
    /* renamed from: a */
    public AbstractC1333j mo10554a(C1339c c1339c) {
        return new C1327d(this.f8650n, this.f8651d.mo10481a(c1339c), c1339c.mo10602a(this.f8635a));
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("if ").append(this.f8651d).toString()).append(" GOTO ").toString()).append(this.f8635a.m10556a()).toString();
    }
}
