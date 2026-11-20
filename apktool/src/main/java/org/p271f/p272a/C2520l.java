package org.p271f.p272a;

/* compiled from: FieldWriter.java */
/* renamed from: org.f.a.l */
/* loaded from: classes.dex */
final class C2520l extends AbstractC2519k {

    /* renamed from: c */
    private final C2516h f13162c;

    /* renamed from: d */
    private final int f13163d;

    /* renamed from: e */
    private final int f13164e;

    /* renamed from: f */
    private final int f13165f;

    /* renamed from: g */
    private int f13166g;

    /* renamed from: h */
    private int f13167h;

    /* renamed from: i */
    private C2481b f13168i;

    /* renamed from: j */
    private C2481b f13169j;

    /* renamed from: k */
    private C2481b f13170k;

    /* renamed from: l */
    private C2481b f13171l;

    /* renamed from: m */
    private C2512d f13172m;

    C2520l(C2516h c2516h, int i, String str, String str2, String str3, Object obj) {
        super(327680);
        if (c2516h.f13128r == null) {
            c2516h.f13128r = this;
        } else {
            c2516h.f13129s.f13161b = this;
        }
        c2516h.f13129s = this;
        this.f13162c = c2516h;
        this.f13163d = i;
        this.f13164e = c2516h.m15807a(str);
        this.f13165f = c2516h.m15807a(str2);
        if (str3 != null) {
            this.f13166g = c2516h.m15807a(str3);
        }
        if (obj != null) {
            this.f13167h = c2516h.m15814a(obj).f13192a;
        }
    }

    @Override // org.p271f.p272a.AbstractC2519k
    /* renamed from: a */
    public AbstractC2473a mo15673a(String str, boolean z) {
        C2513e c2513e = new C2513e();
        c2513e.m15770b(this.f13162c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13162c, true, c2513e, c2513e, 2);
        if (z) {
            c2481b.f12980c = this.f13168i;
            this.f13168i = c2481b;
        } else {
            c2481b.f12980c = this.f13169j;
            this.f13169j = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2519k
    /* renamed from: a */
    public AbstractC2473a mo15672a(int i, C2530v c2530v, String str, boolean z) {
        C2513e c2513e = new C2513e();
        C2481b.m15705a(i, c2530v, c2513e);
        c2513e.m15770b(this.f13162c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13162c, true, c2513e, c2513e, c2513e.f13089b - 2);
        if (z) {
            c2481b.f12980c = this.f13170k;
            this.f13170k = c2481b;
        } else {
            c2481b.f12980c = this.f13171l;
            this.f13171l = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2519k
    /* renamed from: a */
    public void mo15831a(C2512d c2512d) {
        c2512d.f13087c = this.f13172m;
        this.f13172m = c2512d;
    }

    @Override // org.p271f.p272a.AbstractC2519k
    /* renamed from: a */
    public void mo15830a() {
    }

    /* renamed from: b */
    int m15833b() {
        int i;
        int i2 = 8;
        if (this.f13167h != 0) {
            this.f13162c.m15807a("ConstantValue");
            i2 = 16;
        }
        if ((this.f13163d & 4096) != 0 && ((this.f13162c.f13115e & 65535) < 49 || (this.f13163d & 262144) != 0)) {
            this.f13162c.m15807a("Synthetic");
            i2 += 6;
        }
        if ((this.f13163d & 131072) != 0) {
            this.f13162c.m15807a("Deprecated");
            i2 += 6;
        }
        if (this.f13166g != 0) {
            this.f13162c.m15807a("Signature");
            i2 += 8;
        }
        if (this.f13168i != null) {
            this.f13162c.m15807a("RuntimeVisibleAnnotations");
            i2 += this.f13168i.m15708b() + 8;
        }
        if (this.f13169j != null) {
            this.f13162c.m15807a("RuntimeInvisibleAnnotations");
            i2 += this.f13169j.m15708b() + 8;
        }
        if (this.f13170k != null) {
            this.f13162c.m15807a("RuntimeVisibleTypeAnnotations");
            i2 += this.f13170k.m15708b() + 8;
        }
        if (this.f13171l != null) {
            this.f13162c.m15807a("RuntimeInvisibleTypeAnnotations");
            i = i2 + this.f13171l.m15708b() + 8;
        } else {
            i = i2;
        }
        if (this.f13172m != null) {
            return i + this.f13172m.m15760b(this.f13162c, null, 0, -1, -1);
        }
        return i;
    }

    /* renamed from: a */
    void m15832a(C2513e c2513e) {
        c2513e.m15770b(((393216 | ((this.f13163d & 262144) / 64)) ^ (-1)) & this.f13163d).m15770b(this.f13164e).m15770b(this.f13165f);
        int i = this.f13167h != 0 ? 1 : 0;
        if ((this.f13163d & 4096) != 0 && ((this.f13162c.f13115e & 65535) < 49 || (this.f13163d & 262144) != 0)) {
            i++;
        }
        if ((this.f13163d & 131072) != 0) {
            i++;
        }
        if (this.f13166g != 0) {
            i++;
        }
        if (this.f13168i != null) {
            i++;
        }
        if (this.f13169j != null) {
            i++;
        }
        if (this.f13170k != null) {
            i++;
        }
        if (this.f13171l != null) {
            i++;
        }
        if (this.f13172m != null) {
            i += this.f13172m.m15762c();
        }
        c2513e.m15770b(i);
        if (this.f13167h != 0) {
            c2513e.m15770b(this.f13162c.m15807a("ConstantValue"));
            c2513e.m15772c(2).m15770b(this.f13167h);
        }
        if ((this.f13163d & 4096) != 0 && ((this.f13162c.f13115e & 65535) < 49 || (this.f13163d & 262144) != 0)) {
            c2513e.m15770b(this.f13162c.m15807a("Synthetic")).m15772c(0);
        }
        if ((this.f13163d & 131072) != 0) {
            c2513e.m15770b(this.f13162c.m15807a("Deprecated")).m15772c(0);
        }
        if (this.f13166g != 0) {
            c2513e.m15770b(this.f13162c.m15807a("Signature"));
            c2513e.m15772c(2).m15770b(this.f13166g);
        }
        if (this.f13168i != null) {
            c2513e.m15770b(this.f13162c.m15807a("RuntimeVisibleAnnotations"));
            this.f13168i.m15707a(c2513e);
        }
        if (this.f13169j != null) {
            c2513e.m15770b(this.f13162c.m15807a("RuntimeInvisibleAnnotations"));
            this.f13169j.m15707a(c2513e);
        }
        if (this.f13170k != null) {
            c2513e.m15770b(this.f13162c.m15807a("RuntimeVisibleTypeAnnotations"));
            this.f13170k.m15707a(c2513e);
        }
        if (this.f13171l != null) {
            c2513e.m15770b(this.f13162c.m15807a("RuntimeInvisibleTypeAnnotations"));
            this.f13171l.m15707a(c2513e);
        }
        if (this.f13172m != null) {
            this.f13172m.m15758a(this.f13162c, (byte[]) null, 0, -1, -1, c2513e);
        }
    }
}
