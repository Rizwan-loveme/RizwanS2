package com.p140g.p152b.p153a;

import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.C1329f;

/* compiled from: LocalVar.java */
/* renamed from: com.g.b.a.d */
/* loaded from: classes.dex */
public class C1363d {

    /* renamed from: a */
    public C1329f f8796a;

    /* renamed from: b */
    public C1329f f8797b;

    /* renamed from: c */
    public String f8798c;

    /* renamed from: d */
    public String f8799d;

    /* renamed from: e */
    public String f8800e;

    /* renamed from: f */
    public C1314l f8801f;

    public C1363d(String str, String str2, String str3, C1329f c1329f, C1329f c1329f2, C1314l c1314l) {
        this.f8798c = str;
        this.f8796a = c1329f;
        this.f8797b = c1329f2;
        this.f8799d = str2;
        this.f8800e = str3;
        this.f8801f = c1314l;
    }

    /* renamed from: a */
    public C1363d m10763a(C1339c c1339c) {
        return new C1363d(this.f8798c, this.f8799d, this.f8800e, this.f8796a.m10557b(c1339c), this.f8797b.m10557b(c1339c), (C1314l) this.f8801f.mo10480a());
    }

    public String toString() {
        return String.format(".var %s ~ %s %s -> %s //%s", this.f8796a.m10556a(), this.f8797b.m10556a(), this.f8801f, this.f8798c, this.f8799d);
    }
}
