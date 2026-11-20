package com.p140g.p141a;

/* compiled from: Method.java */
/* renamed from: com.g.a.e */
/* loaded from: classes.dex */
public class C1280e {

    /* renamed from: a */
    private String f8179a;

    /* renamed from: b */
    private String f8180b;

    /* renamed from: c */
    private C1292g f8181c;

    /* renamed from: a */
    public C1292g m10396a() {
        return this.f8181c;
    }

    public C1280e(String str, String str2, String[] strArr, String str3) {
        this.f8180b = str;
        this.f8179a = str2;
        this.f8181c = new C1292g(strArr, str3);
    }

    public C1280e(String str, String str2, C1292g c1292g) {
        this.f8180b = str;
        this.f8179a = str2;
        this.f8181c = c1292g;
    }

    /* renamed from: b */
    public String m10397b() {
        return this.f8181c.m10472c();
    }

    /* renamed from: c */
    public String m10398c() {
        return this.f8179a;
    }

    /* renamed from: d */
    public String m10399d() {
        return this.f8180b;
    }

    /* renamed from: e */
    public String[] m10400e() {
        return this.f8181c.m10470a();
    }

    /* renamed from: f */
    public String m10401f() {
        return this.f8181c.m10471b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1280e c1280e = (C1280e) obj;
        if (this.f8179a != null) {
            if (!this.f8179a.equals(c1280e.f8179a)) {
                return false;
            }
        } else if (c1280e.f8179a != null) {
            return false;
        }
        if (this.f8180b != null) {
            if (!this.f8180b.equals(c1280e.f8180b)) {
                return false;
            }
        } else if (c1280e.f8180b != null) {
            return false;
        }
        return this.f8181c.equals(c1280e.f8181c);
    }

    public int hashCode() {
        return ((((this.f8179a != null ? this.f8179a.hashCode() : 0) * 31) + (this.f8180b != null ? this.f8180b.hashCode() : 0)) * 31) + this.f8181c.hashCode();
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m10399d()).append(".").toString()).append(m10398c()).toString()).append(m10397b()).toString();
    }
}
