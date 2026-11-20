package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;

/* compiled from: LookupSwitchStmt.java */
/* renamed from: com.g.b.a.b.g */
/* loaded from: classes.dex */
public class C1330g extends AbstractC1325b {

    /* renamed from: c */
    public int[] f8640c;

    public C1330g(AbstractC1322t abstractC1322t, int[] iArr, C1329f[] c1329fArr, C1329f c1329f) {
        super(AbstractC1333j.d.LOOKUP_SWITCH, abstractC1322t);
        this.f8640c = iArr;
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
        int[] iArr = new int[this.f8640c.length];
        System.arraycopy(this.f8640c, 0, iArr, 0, iArr.length);
        return new C1330g(this.f8651d.mo10481a(c1339c), iArr, c1329fArr, c1339c.mo10602a(this.f8633b));
    }

    public String toString() {
        StringBuilder append = new StringBuilder("switch(").append(this.f8651d).append(") {");
        for (int i = 0; i < this.f8640c.length; i++) {
            append.append("\n case ").append(this.f8640c[i]).append(": GOTO ").append(this.f8632a[i].m10556a()).append(";");
        }
        append.append("\n default : GOTO ").append(this.f8633b.m10556a()).append(";");
        append.append("\n}");
        return append.toString();
    }
}
