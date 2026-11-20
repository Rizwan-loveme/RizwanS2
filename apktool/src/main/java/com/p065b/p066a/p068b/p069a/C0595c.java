package com.p065b.p066a.p068b.p069a;

import com.p065b.p066a.C0668c;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ApkSignerInfo.java */
/* renamed from: com.b.a.b.a.c */
/* loaded from: classes.dex */
public class C0595c {

    /* renamed from: c */
    public int f4049c;

    /* renamed from: d */
    public long f4050d;

    /* renamed from: b */
    public List<X509Certificate> f4048b = new ArrayList();

    /* renamed from: a */
    public List<X509Certificate> f4047a = new ArrayList();

    /* renamed from: f */
    private final List<C0668c> f4052f = new ArrayList();

    /* renamed from: e */
    private final List<C0668c> f4051e = new ArrayList();

    /* renamed from: a */
    public void m5929a(int i, Object... objArr) {
        this.f4052f.add(new C0668c(i, objArr));
    }

    /* renamed from: a */
    public boolean mo5930a() {
        return !this.f4051e.isEmpty();
    }

    /* renamed from: b */
    public boolean mo5931b() {
        return !this.f4052f.isEmpty();
    }

    /* renamed from: c */
    public List<? extends C0668c> mo5932c() {
        return this.f4051e;
    }

    /* renamed from: d */
    public List<? extends C0668c> mo5933d() {
        return this.f4052f;
    }
}
