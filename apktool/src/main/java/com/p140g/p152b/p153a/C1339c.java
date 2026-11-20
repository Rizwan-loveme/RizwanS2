package com.p140g.p152b.p153a;

import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1335l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LabelAndLocalMapper.java */
/* renamed from: com.g.b.a.c */
/* loaded from: classes.dex */
public class C1339c {

    /* renamed from: a */
    Map<C1329f, C1329f> f8681a = new HashMap();

    /* renamed from: b */
    Map<C1314l, C1314l> f8682b = new HashMap();

    /* renamed from: a */
    public C1329f mo10602a(C1329f c1329f) {
        C1329f c1329f2 = this.f8681a.get(c1329f);
        if (c1329f2 == null) {
            C1329f m10589a = C1335l.m10589a();
            this.f8681a.put(c1329f, m10589a);
            return m10589a;
        }
        return c1329f2;
    }

    /* renamed from: a */
    public C1314l mo10601a(C1314l c1314l) {
        C1314l c1314l2 = this.f8682b.get(c1314l);
        if (c1314l2 == null) {
            C1314l c1314l3 = (C1314l) c1314l.mo10480a();
            this.f8682b.put(c1314l, c1314l3);
            return c1314l3;
        }
        return c1314l2;
    }
}
