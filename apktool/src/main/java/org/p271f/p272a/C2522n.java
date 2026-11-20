package org.p271f.p272a;

/* compiled from: Handle.java */
/* renamed from: org.f.a.n */
/* loaded from: classes.dex */
public final class C2522n {

    /* renamed from: a */
    final int f13182a;

    /* renamed from: b */
    final String f13183b;

    /* renamed from: c */
    final String f13184c;

    /* renamed from: d */
    final String f13185d;

    public C2522n(int i, String str, String str2, String str3) {
        this.f13182a = i;
        this.f13183b = str;
        this.f13184c = str2;
        this.f13185d = str3;
    }

    /* renamed from: a */
    public int m15848a() {
        return this.f13182a;
    }

    /* renamed from: b */
    public String m15849b() {
        return this.f13183b;
    }

    /* renamed from: c */
    public String m15850c() {
        return this.f13184c;
    }

    /* renamed from: d */
    public String m15851d() {
        return this.f13185d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2522n)) {
            return false;
        }
        C2522n c2522n = (C2522n) obj;
        return this.f13182a == c2522n.f13182a && this.f13183b.equals(c2522n.f13183b) && this.f13184c.equals(c2522n.f13184c) && this.f13185d.equals(c2522n.f13185d);
    }

    public int hashCode() {
        return this.f13182a + (this.f13183b.hashCode() * this.f13184c.hashCode() * this.f13185d.hashCode());
    }

    public String toString() {
        return this.f13183b + '.' + this.f13184c + this.f13185d + " (" + this.f13182a + ')';
    }
}
