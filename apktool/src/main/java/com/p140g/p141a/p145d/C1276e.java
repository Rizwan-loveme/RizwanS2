package com.p140g.p141a.p145d;

import com.p140g.p141a.C1249d;
import com.p140g.p141a.EnumC1301h;
import com.p140g.p141a.p151g.C1294b;
import com.p140g.p141a.p151g.C1298f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DexFieldNode.java */
/* renamed from: com.g.a.d.e */
/* loaded from: classes.dex */
public class C1276e extends C1298f {

    /* renamed from: a */
    public int f8162a;

    /* renamed from: b */
    public List<C1250a> f8163b;

    /* renamed from: c */
    public Object f8164c;

    /* renamed from: d */
    public C1249d f8165d;

    public C1276e(int i, C1249d c1249d, Object obj) {
        this.f8162a = i;
        this.f8165d = c1249d;
        this.f8164c = obj;
    }

    @Override // com.p140g.p141a.p151g.C1298f, com.p140g.p141a.p151g.InterfaceC1293a
    /* renamed from: a */
    public C1294b mo10353a(String str, EnumC1301h enumC1301h) {
        if (this.f8163b == null) {
            this.f8163b = new ArrayList(5);
        }
        C1250a c1250a = new C1250a(str, enumC1301h);
        this.f8163b.add(c1250a);
        return c1250a;
    }
}
