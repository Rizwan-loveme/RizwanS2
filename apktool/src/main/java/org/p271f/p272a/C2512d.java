package org.p271f.p272a;

/* compiled from: Attribute.java */
/* renamed from: org.f.a.d */
/* loaded from: classes.dex */
public class C2512d {

    /* renamed from: a */
    public final String f13085a;

    /* renamed from: b */
    byte[] f13086b;

    /* renamed from: c */
    C2512d f13087c;

    protected C2512d(String str) {
        this.f13085a = str;
    }

    /* renamed from: a */
    public boolean m15759a() {
        return false;
    }

    /* renamed from: b */
    protected C2525q[] m15761b() {
        return null;
    }

    /* renamed from: a */
    protected C2512d m15756a(C2514f c2514f, int i, int i2, char[] cArr, int i3, C2525q[] c2525qArr) {
        C2512d c2512d = new C2512d(this.f13085a);
        c2512d.f13086b = new byte[i2];
        System.arraycopy(c2514f.f13090a, i, c2512d.f13086b, 0, i2);
        return c2512d;
    }

    /* renamed from: a */
    protected C2513e m15757a(C2516h c2516h, byte[] bArr, int i, int i2, int i3) {
        C2513e c2513e = new C2513e();
        c2513e.f13088a = this.f13086b;
        c2513e.f13089b = this.f13086b.length;
        return c2513e;
    }

    /* renamed from: c */
    final int m15762c() {
        int i = 0;
        while (this != null) {
            i++;
            this = this.f13087c;
        }
        return i;
    }

    /* renamed from: b */
    final int m15760b(C2516h c2516h, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        C2512d c2512d = this;
        while (c2512d != null) {
            c2516h.m15807a(c2512d.f13085a);
            int i5 = c2512d.m15757a(c2516h, bArr, i, i2, i3).f13089b + 6 + i4;
            c2512d = c2512d.f13087c;
            i4 = i5;
        }
        return i4;
    }

    /* renamed from: a */
    final void m15758a(C2516h c2516h, byte[] bArr, int i, int i2, int i3, C2513e c2513e) {
        for (C2512d c2512d = this; c2512d != null; c2512d = c2512d.f13087c) {
            C2513e m15757a = c2512d.m15757a(c2516h, bArr, i, i2, i3);
            c2513e.m15770b(c2516h.m15807a(c2512d.f13085a)).m15772c(m15757a.f13089b);
            c2513e.m15769a(m15757a.f13088a, 0, m15757a.f13089b);
        }
    }
}
