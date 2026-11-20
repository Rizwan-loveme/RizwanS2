package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;

/* compiled from: TableSwitchStmt.java */
/* renamed from: com.g.b.a.b.m */
/* loaded from: classes.dex */
public class C1336m extends AbstractC1325b {

    /* renamed from: c */
    public int f8680c;

    public C1336m() {
        super(AbstractC1333j.d.TABLE_SWITCH, (AbstractC1322t) null);
    }

    public C1336m(AbstractC1322t abstractC1322t, int i, C1329f[] c1329fArr, C1329f c1329f) {
        super(AbstractC1333j.d.TABLE_SWITCH, abstractC1322t);
        this.f8680c = i;
        this.f8632a = c1329fArr;
        this.f8633b = c1329f;
    }

    @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
    /* renamed from: a */
    public AbstractC1333j mo10554a(C1339c c1339c) {
        C1329f[] c1329fArr = new C1329f[this.f8632a.length];
        for (int i = 0; i < c1329fArr.length; i++) {
            c1329fArr[i] = c1339c.mo10602a(this.f8632a[i]);
        }
        return new C1336m(this.f8651d.mo10481a(c1339c), this.f8680c, c1329fArr, c1339c.mo10602a(this.f8633b));
    }

    public String toString() {
        StringBuilder append = new StringBuilder("switch(").append(this.f8651d).append(") {");
        for (int i = 0; i < this.f8632a.length; i++) {
            append.append("\n case ").append(this.f8680c + i).append(": GOTO ").append(this.f8632a[i].m10556a()).append(";");
        }
        append.append("\n default : GOTO ").append(this.f8633b.m10556a()).append(";");
        append.append("\n}");
        return append.toString();
    }
}
