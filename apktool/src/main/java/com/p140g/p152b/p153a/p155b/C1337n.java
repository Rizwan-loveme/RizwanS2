package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;

/* compiled from: UnopStmt.java */
/* renamed from: com.g.b.a.b.n */
/* loaded from: classes.dex */
public class C1337n extends AbstractC1333j.b {
    public C1337n(AbstractC1333j.d dVar, AbstractC1322t abstractC1322t) {
        super(dVar, abstractC1322t);
    }

    @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
    /* renamed from: a */
    public AbstractC1333j mo10554a(C1339c c1339c) {
        return new C1337n(this.f8650n, this.f8651d.mo10481a(c1339c));
    }

    public String toString() {
        AbstractC1333j.d dVar = this.f8650n;
        if (dVar == AbstractC1333j.d.LOCK) {
            return new StringBuffer().append("lock ").append(this.f8651d).toString();
        }
        if (dVar == AbstractC1333j.d.UNLOCK) {
            return new StringBuffer().append("unlock ").append(this.f8651d).toString();
        }
        if (dVar == AbstractC1333j.d.THROW) {
            return new StringBuffer().append("throw ").append(this.f8651d).toString();
        }
        if (dVar == AbstractC1333j.d.RETURN) {
            return new StringBuffer().append("return ").append(this.f8651d).toString();
        }
        if (dVar == AbstractC1333j.d.LOCAL_END) {
            return new StringBuffer().append(this.f8651d).append(" ::END").toString();
        }
        return super.toString();
    }
}
