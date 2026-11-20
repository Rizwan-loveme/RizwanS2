package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;

/* compiled from: AssignStmt.java */
/* renamed from: com.g.b.a.b.a */
/* loaded from: classes.dex */
public class C1324a extends AbstractC1333j.c {
    public C1324a(AbstractC1333j.d dVar, AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
        super(dVar, abstractC1322t, abstractC1322t2);
    }

    @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
    /* renamed from: a */
    public AbstractC1333j mo10554a(C1339c c1339c) {
        return new C1324a(this.f8650n, this.f8652a.mo10481a(c1339c), this.f8653b.mo10481a(c1339c));
    }

    public String toString() {
        AbstractC1333j.d dVar = this.f8650n;
        if (dVar == AbstractC1333j.d.ASSIGN) {
            return new StringBuffer().append(new StringBuffer().append(this.f8652a).append(" = ").toString()).append(this.f8653b).toString();
        }
        if (dVar != AbstractC1333j.d.LOCAL_START && dVar != AbstractC1333j.d.IDENTITY) {
            if (dVar == AbstractC1333j.d.FILL_ARRAY_DATA) {
                return new StringBuffer().append(new StringBuffer().append(this.f8652a).append(" <- ").toString()).append(this.f8653b).toString();
            }
            return super.toString();
        }
        return new StringBuffer().append(new StringBuffer().append(this.f8652a).append(" := ").toString()).append(this.f8653b).toString();
    }
}
