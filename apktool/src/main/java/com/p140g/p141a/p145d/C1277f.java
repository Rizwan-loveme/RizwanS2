package com.p140g.p141a.p145d;

import com.p140g.p141a.p151g.C1295c;
import com.p140g.p141a.p151g.C1299g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DexFileNode.java */
/* renamed from: com.g.a.d.f */
/* loaded from: classes.dex */
public class C1277f extends C1299g {

    /* renamed from: a */
    public List<C1253b> f8166a = new ArrayList();

    /* renamed from: b */
    public int f8167b = 3158837;

    @Override // com.p140g.p141a.p151g.C1299g
    /* renamed from: a */
    public void mo10392a(int i) {
        this.f8167b = i;
        super.mo10392a(i);
    }

    @Override // com.p140g.p141a.p151g.C1299g
    /* renamed from: a */
    public C1295c mo10391a(int i, String str, String str2, String[] strArr) {
        C1253b c1253b = new C1253b(i, str, str2, strArr);
        this.f8166a.add(c1253b);
        return c1253b;
    }
}
