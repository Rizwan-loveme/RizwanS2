package com.p065b.p086b.p100d;

import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p110h.C1009ab;

/* compiled from: MethodId.java */
/* renamed from: com.b.b.d.l */
/* loaded from: classes.dex */
public final class C0904l implements Comparable<C0904l> {

    /* renamed from: a */
    private final C0898f f5485a;

    /* renamed from: b */
    private final int f5486b;

    /* renamed from: c */
    private final int f5487c;

    /* renamed from: d */
    private final int f5488d;

    public C0904l(C0898f c0898f, int i, int i2, int i3) {
        this.f5485a = c0898f;
        this.f5486b = i;
        this.f5487c = i2;
        this.f5488d = i3;
    }

    /* renamed from: a */
    public int m7679a() {
        return this.f5486b;
    }

    /* renamed from: b */
    public int m7682b() {
        return this.f5487c;
    }

    /* renamed from: c */
    public int m7683c() {
        return this.f5488d;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0904l c0904l) {
        if (this.f5486b != c0904l.f5486b) {
            return C1009ab.m8473a(this.f5486b, c0904l.f5486b);
        }
        if (this.f5488d != c0904l.f5488d) {
            return C1009ab.m8473a(this.f5488d, c0904l.f5488d);
        }
        return C1009ab.m8473a(this.f5487c, c0904l.f5487c);
    }

    /* renamed from: a */
    public void m7681a(C0898f.a aVar) {
        aVar.m7633d(this.f5486b);
        aVar.m7633d(this.f5487c);
        aVar.m7635e(this.f5488d);
    }

    public String toString() {
        return this.f5485a == null ? this.f5486b + " " + this.f5487c + " " + this.f5488d : this.f5485a.m7603f().get(this.f5486b) + "." + this.f5485a.m7602e().get(this.f5488d) + this.f5485a.m7598b(this.f5485a.m7604g().get(this.f5487c).m7700c());
    }
}
