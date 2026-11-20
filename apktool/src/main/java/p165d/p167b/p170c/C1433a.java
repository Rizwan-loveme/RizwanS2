package p165d.p167b.p170c;

import java.security.AlgorithmParameters;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p173f.C1505e;

/* compiled from: MacData.java */
/* renamed from: d.b.c.a */
/* loaded from: classes.dex */
class C1433a {

    /* renamed from: a */
    private byte[] f9276a;

    /* renamed from: b */
    private String f9277b;

    /* renamed from: c */
    private AlgorithmParameters f9278c;

    /* renamed from: d */
    private byte[] f9279d;

    /* renamed from: e */
    private int f9280e;

    /* renamed from: f */
    private byte[] f9281f;

    C1433a(C1448k c1448k) {
        this.f9279d = null;
        C1450m[] m11364a = c1448k.m11364a(2);
        C1450m[] m11364a2 = new C1448k(m11364a[0].m11440u()).m11364a(2);
        C1505e m11630a = C1505e.m11630a(m11364a2[0]);
        this.f9277b = m11630a.m11642d();
        this.f9278c = m11630a.m11644f();
        this.f9276a = m11364a2[1].m11432m();
        this.f9281f = m11364a[1].m11432m();
        if (m11364a.length > 2) {
            this.f9280e = m11364a[2].m11430k();
        } else {
            this.f9280e = 1;
        }
    }

    C1433a(String str, byte[] bArr, byte[] bArr2, int i) {
        this.f9279d = null;
        if (str == null) {
            throw new NullPointerException("the algName parameter must be non-null");
        }
        C1505e m11631a = C1505e.m11631a(str);
        this.f9277b = m11631a.m11642d();
        this.f9278c = m11631a.m11644f();
        if (bArr == null) {
            throw new NullPointerException("the digest parameter must be non-null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("the digest parameter must not be empty");
        }
        this.f9276a = (byte[]) bArr.clone();
        this.f9281f = bArr2;
        this.f9280e = i;
        this.f9279d = null;
    }

    /* renamed from: b */
    String m11289b() {
        return this.f9277b;
    }

    /* renamed from: e */
    byte[] m11292e() {
        return this.f9281f;
    }

    /* renamed from: d */
    int m11291d() {
        return this.f9280e;
    }

    /* renamed from: a */
    byte[] m11288a() {
        return this.f9276a;
    }

    /* renamed from: c */
    public byte[] m11290c() {
        if (this.f9279d != null) {
            return (byte[]) this.f9279d.clone();
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        C1449l c1449l3 = new C1449l();
        C1505e.m11631a(this.f9277b).m11637a(c1449l3);
        c1449l3.m11405b(this.f9276a);
        c1449l2.m11388a((byte) 48, c1449l3);
        c1449l2.m11405b(this.f9281f);
        c1449l2.m11401b(this.f9280e);
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9279d = c1449l.toByteArray();
        return (byte[]) this.f9279d.clone();
    }
}
