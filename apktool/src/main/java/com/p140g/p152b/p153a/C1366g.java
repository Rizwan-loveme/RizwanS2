package com.p140g.p152b.p153a;

import com.p140g.p152b.p153a.p155b.C1329f;

/* compiled from: Trap.java */
/* renamed from: com.g.b.a.g */
/* loaded from: classes.dex */
public class C1366g {

    /* renamed from: a */
    public C1329f f8802a;

    /* renamed from: b */
    public C1329f f8803b;

    /* renamed from: c */
    public C1329f[] f8804c;

    /* renamed from: d */
    public String[] f8805d;

    public C1366g() {
    }

    public C1366g(C1329f c1329f, C1329f c1329f2, C1329f[] c1329fArr, String[] strArr) {
        this.f8802a = c1329f;
        this.f8803b = c1329f2;
        this.f8804c = c1329fArr;
        this.f8805d = strArr;
    }

    /* renamed from: a */
    public C1366g m10766a(C1339c c1339c) {
        int length = this.f8804c.length;
        C1329f[] c1329fArr = new C1329f[length];
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            c1329fArr[i] = this.f8804c[i].m10557b(c1339c);
            strArr[i] = this.f8805d[i];
        }
        return new C1366g(this.f8802a.m10557b(c1339c), this.f8803b.m10557b(c1339c), c1329fArr, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.format(".catch %s - %s : ", this.f8802a.m10556a(), this.f8803b.m10556a()));
        for (int i = 0; i < this.f8804c.length; i++) {
            sb.append(this.f8805d[i] == null ? "all" : this.f8805d[i]).append(" > ").append(this.f8804c[i].m10556a()).append(",");
        }
        return sb.toString();
    }
}
