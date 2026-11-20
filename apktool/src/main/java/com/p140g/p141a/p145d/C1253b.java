package com.p140g.p141a.p145d;

import com.p140g.p141a.C1249d;
import com.p140g.p141a.C1280e;
import com.p140g.p141a.EnumC1301h;
import com.p140g.p141a.p151g.C1294b;
import com.p140g.p141a.p151g.C1295c;
import com.p140g.p141a.p151g.C1298f;
import com.p140g.p141a.p151g.C1300h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DexClassNode.java */
/* renamed from: com.g.a.d.b */
/* loaded from: classes.dex */
public class C1253b extends C1295c {

    /* renamed from: a */
    public int f8100a;

    /* renamed from: b */
    public List<C1250a> f8101b;

    /* renamed from: c */
    public String f8102c;

    /* renamed from: d */
    public List<C1276e> f8103d;

    /* renamed from: e */
    public String[] f8104e;

    /* renamed from: f */
    public List<C1278g> f8105f;

    /* renamed from: g */
    public String f8106g;

    /* renamed from: h */
    public String f8107h;

    public C1253b(int i, String str, String str2, String[] strArr) {
        this.f8100a = i;
        this.f8102c = str;
        this.f8107h = str2;
        this.f8104e = strArr;
    }

    @Override // com.p140g.p141a.p151g.C1295c, com.p140g.p141a.p151g.InterfaceC1293a
    /* renamed from: a */
    public C1294b mo10353a(String str, EnumC1301h enumC1301h) {
        if (this.f8101b == null) {
            this.f8101b = new ArrayList(5);
        }
        C1250a c1250a = new C1250a(str, enumC1301h);
        this.f8101b.add(c1250a);
        return c1250a;
    }

    @Override // com.p140g.p141a.p151g.C1295c
    /* renamed from: a */
    public C1298f mo10354a(int i, C1249d c1249d, Object obj) {
        if (this.f8103d == null) {
            this.f8103d = new ArrayList();
        }
        C1276e c1276e = new C1276e(i, c1249d, obj);
        this.f8103d.add(c1276e);
        return c1276e;
    }

    @Override // com.p140g.p141a.p151g.C1295c
    /* renamed from: a */
    public C1300h mo10355a(int i, C1280e c1280e) {
        if (this.f8105f == null) {
            this.f8105f = new ArrayList();
        }
        C1278g c1278g = new C1278g(i, c1280e);
        this.f8105f.add(c1278g);
        return c1278g;
    }

    @Override // com.p140g.p141a.p151g.C1295c
    /* renamed from: a */
    public void mo10356a(String str) {
        this.f8106g = str;
    }
}
