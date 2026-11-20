package com.p140g.p141a.p145d;

import com.p140g.p141a.C1238b;
import com.p140g.p141a.C1249d;
import com.p140g.p141a.C1280e;
import com.p140g.p141a.C1287f;
import com.p140g.p141a.C1292g;
import com.p140g.p141a.p145d.p147b.AbstractC1258e;
import com.p140g.p141a.p145d.p147b.C1256c;
import com.p140g.p141a.p145d.p147b.C1257d;
import com.p140g.p141a.p145d.p147b.C1259f;
import com.p140g.p141a.p145d.p147b.C1260g;
import com.p140g.p141a.p145d.p147b.C1261h;
import com.p140g.p141a.p145d.p147b.C1262i;
import com.p140g.p141a.p145d.p147b.C1263j;
import com.p140g.p141a.p145d.p147b.C1264k;
import com.p140g.p141a.p145d.p147b.C1265l;
import com.p140g.p141a.p145d.p147b.C1266m;
import com.p140g.p141a.p145d.p147b.C1267n;
import com.p140g.p141a.p145d.p147b.C1268o;
import com.p140g.p141a.p145d.p147b.C1269p;
import com.p140g.p141a.p145d.p147b.C1270q;
import com.p140g.p141a.p145d.p147b.C1271r;
import com.p140g.p141a.p145d.p147b.C1272s;
import com.p140g.p141a.p145d.p147b.C1273t;
import com.p140g.p141a.p148e.EnumC1286f;
import com.p140g.p141a.p151g.C1296d;
import com.p140g.p141a.p151g.C1297e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DexCodeNode.java */
/* renamed from: com.g.a.d.c */
/* loaded from: classes.dex */
public class C1274c extends C1296d {

    /* renamed from: a */
    public List<AbstractC1258e> f8147a;

    /* renamed from: b */
    public List<C1279h> f8148b;

    /* renamed from: c */
    public C1275d f8149c;

    /* renamed from: d */
    public int f8150d;

    public C1274c() {
        this.f8147a = new ArrayList();
        this.f8148b = (List) null;
        this.f8150d = -1;
    }

    public C1274c(C1296d c1296d) {
        super(c1296d);
        this.f8147a = new ArrayList();
        this.f8148b = (List) null;
        this.f8150d = -1;
    }

    /* renamed from: a */
    public void m10377a(C1296d c1296d) {
        C1297e mo10359a;
        if (this.f8148b != null) {
            Iterator<C1279h> it = this.f8148b.iterator();
            while (it.hasNext()) {
                it.next().m10395a(c1296d);
            }
        }
        if (this.f8149c != null && (mo10359a = c1296d.mo10359a()) != null) {
            this.f8149c.m10385a(mo10359a);
            mo10359a.m10475a();
        }
        if (this.f8150d >= 0) {
            c1296d.mo10360a(this.f8150d);
        }
        Iterator<AbstractC1258e> it2 = this.f8147a.iterator();
        while (it2.hasNext()) {
            it2.next().mo10358a(c1296d);
        }
    }

    /* renamed from: a */
    protected void m10363a(AbstractC1258e abstractC1258e) {
        this.f8147a.add(abstractC1258e);
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10371a(EnumC1286f enumC1286f, int i, Object obj) {
        m10363a(new C1256c(enumC1286f, i, obj));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: b */
    public void mo10379b(EnumC1286f enumC1286f, int i, Object obj) {
        m10363a(new C1260g(enumC1286f, i, obj));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10333a(EnumC1286f enumC1286f, int i, int i2, C1249d c1249d) {
        m10363a(new C1259f(enumC1286f, i, i2, c1249d));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10375a(EnumC1286f enumC1286f, int[] iArr, String str) {
        m10363a(new C1261h(enumC1286f, iArr, str));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10368a(EnumC1286f enumC1286f, int i, int i2, C1238b c1238b) {
        m10363a(new C1262i(enumC1286f, i, i2, c1238b));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10361a(C1238b c1238b) {
        m10363a(new C1257d(c1238b));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10373a(EnumC1286f enumC1286f, int[] iArr, C1280e c1280e) {
        m10363a(new C1265l(enumC1286f, iArr, c1280e));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10376a(EnumC1286f enumC1286f, int[] iArr, String str, C1292g c1292g, C1287f c1287f, Object... objArr) {
        m10363a(new C1263j(enumC1286f, iArr, str, c1292g, c1287f, objArr));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10374a(EnumC1286f enumC1286f, int[] iArr, C1280e c1280e, C1292g c1292g) {
        m10363a(new C1264k(enumC1286f, iArr, c1280e, c1292g));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10370a(EnumC1286f enumC1286f, int i, int i2, C1238b[] c1238bArr) {
        m10363a(new C1266m(enumC1286f, i, i2, c1238bArr));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10360a(int i) {
        this.f8150d = i;
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10372a(EnumC1286f enumC1286f, int i, int[] iArr, C1238b[] c1238bArr) {
        m10363a(new C1267n(enumC1286f, i, iArr, c1238bArr));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10364a(EnumC1286f enumC1286f) {
        m10363a(new C1268o(enumC1286f));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10365a(EnumC1286f enumC1286f, int i) {
        m10363a(new C1269p(enumC1286f, i));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10366a(EnumC1286f enumC1286f, int i, int i2) {
        m10363a(new C1271r(enumC1286f, i, i2));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10367a(EnumC1286f enumC1286f, int i, int i2, int i3) {
        m10363a(new C1270q(enumC1286f, i, i2, i3));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: b */
    public void mo10378b(EnumC1286f enumC1286f, int i, int i2, int i3) {
        m10363a(new C1272s(enumC1286f, i, i2, i3));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10362a(C1238b c1238b, C1238b c1238b2, C1238b[] c1238bArr, String[] strArr) {
        if (this.f8148b == null) {
            this.f8148b = new ArrayList(3);
        }
        this.f8148b.add(new C1279h(c1238b, c1238b2, c1238bArr, strArr));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public void mo10369a(EnumC1286f enumC1286f, int i, int i2, String str) {
        m10363a(new C1273t(enumC1286f, i, i2, str));
    }

    @Override // com.p140g.p141a.p151g.C1296d
    /* renamed from: a */
    public C1297e mo10359a() {
        C1275d c1275d = new C1275d();
        this.f8149c = c1275d;
        return c1275d;
    }
}
