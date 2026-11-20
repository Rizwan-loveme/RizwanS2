package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;

/* compiled from: GotoStmt.java */
/* renamed from: com.g.b.a.b.c */
/* loaded from: classes.dex */
public class C1326c extends AbstractC1333j.a implements InterfaceC1328e {

    /* renamed from: a */
    public C1329f f8634a;

    @Override // com.p140g.p152b.p153a.p155b.InterfaceC1328e
    /* renamed from: a */
    public C1329f mo10555a() {
        return this.f8634a;
    }

    public C1326c(C1329f c1329f) {
        super(AbstractC1333j.d.GOTO);
        this.f8634a = c1329f;
    }

    @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
    /* renamed from: a */
    public AbstractC1333j mo10554a(C1339c c1339c) {
        return new C1326c(c1339c.mo10602a(this.f8634a));
    }

    public String toString() {
        return new StringBuffer().append("GOTO ").append(this.f8634a.m10556a()).toString();
    }
}
