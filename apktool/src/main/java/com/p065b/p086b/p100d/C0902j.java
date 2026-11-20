package com.p065b.p086b.p100d;

import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p110h.C1009ab;

/* compiled from: FieldId.java */
/* renamed from: com.b.b.d.j */
/* loaded from: classes.dex */
public final class C0902j implements Comparable<C0902j> {

    /* renamed from: a */
    private final C0898f f5470a;

    /* renamed from: b */
    private final int f5471b;

    /* renamed from: c */
    private final int f5472c;

    /* renamed from: d */
    private final int f5473d;

    public C0902j(C0898f c0898f, int i, int i2, int i3) {
        this.f5470a = c0898f;
        this.f5471b = i;
        this.f5472c = i2;
        this.f5473d = i3;
    }

    /* renamed from: a */
    public int m7674a() {
        return this.f5471b;
    }

    /* renamed from: b */
    public int m7677b() {
        return this.f5472c;
    }

    /* renamed from: c */
    public int m7678c() {
        return this.f5473d;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0902j c0902j) {
        if (this.f5471b != c0902j.f5471b) {
            return C1009ab.m8473a(this.f5471b, c0902j.f5471b);
        }
        if (this.f5473d != c0902j.f5473d) {
            return C1009ab.m8473a(this.f5473d, c0902j.f5473d);
        }
        return C1009ab.m8473a(this.f5472c, c0902j.f5472c);
    }

    /* renamed from: a */
    public void m7676a(C0898f.a aVar) {
        aVar.m7633d(this.f5471b);
        aVar.m7633d(this.f5472c);
        aVar.m7635e(this.f5473d);
    }

    public String toString() {
        return this.f5470a == null ? this.f5471b + " " + this.f5472c + " " + this.f5473d : this.f5470a.m7603f().get(this.f5472c) + "." + this.f5470a.m7602e().get(this.f5473d);
    }
}
