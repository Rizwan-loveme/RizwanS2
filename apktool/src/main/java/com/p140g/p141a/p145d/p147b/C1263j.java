package com.p140g.p141a.p145d.p147b;

import com.p140g.p141a.C1287f;
import com.p140g.p141a.C1292g;
import com.p140g.p141a.p148e.EnumC1286f;
import com.p140g.p141a.p151g.C1296d;

/* compiled from: MethodCustomStmtNode.java */
/* renamed from: com.g.a.d.b.j */
/* loaded from: classes.dex */
public class C1263j extends AbstractC1254a {

    /* renamed from: b */
    public final String f8126b;

    /* renamed from: e */
    public final C1292g f8127e;

    /* renamed from: f */
    public final C1287f f8128f;

    /* renamed from: g */
    public final Object[] f8129g;

    public C1263j(EnumC1286f enumC1286f, int[] iArr, String str, C1292g c1292g, C1287f c1287f, Object[] objArr) {
        super(enumC1286f, iArr);
        this.f8127e = c1292g;
        this.f8126b = str;
        this.f8128f = c1287f;
        this.f8129g = objArr;
    }

    @Override // com.p140g.p141a.p145d.p147b.AbstractC1258e
    /* renamed from: a */
    public void mo10358a(C1296d c1296d) {
        c1296d.mo10376a(this.f8114c, this.f8108a, this.f8126b, this.f8127e, this.f8128f, this.f8129g);
    }

    @Override // com.p140g.p141a.p145d.p147b.AbstractC1254a
    /* renamed from: a */
    public C1292g mo10357a() {
        return this.f8127e;
    }
}
