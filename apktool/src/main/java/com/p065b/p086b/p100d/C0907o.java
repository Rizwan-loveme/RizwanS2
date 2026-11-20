package com.p065b.p086b.p100d;

import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p110h.C1009ab;

/* compiled from: ProtoId.java */
/* renamed from: com.b.b.d.o */
/* loaded from: classes.dex */
public final class C0907o implements Comparable<C0907o> {

    /* renamed from: a */
    private final C0898f f5755a;

    /* renamed from: b */
    private final int f5756b;

    /* renamed from: c */
    private final int f5757c;

    /* renamed from: d */
    private final int f5758d;

    public C0907o(C0898f c0898f, int i, int i2, int i3) {
        this.f5755a = c0898f;
        this.f5756b = i;
        this.f5757c = i2;
        this.f5758d = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0907o c0907o) {
        return this.f5757c != c0907o.f5757c ? C1009ab.m8473a(this.f5757c, c0907o.f5757c) : C1009ab.m8473a(this.f5758d, c0907o.f5758d);
    }

    /* renamed from: a */
    public int m7696a() {
        return this.f5756b;
    }

    /* renamed from: b */
    public int m7699b() {
        return this.f5757c;
    }

    /* renamed from: c */
    public int m7700c() {
        return this.f5758d;
    }

    /* renamed from: a */
    public void m7698a(C0898f.a aVar) {
        aVar.m7635e(this.f5756b);
        aVar.m7635e(this.f5757c);
        aVar.m7635e(this.f5758d);
    }

    public String toString() {
        return this.f5755a == null ? this.f5756b + " " + this.f5757c + " " + this.f5758d : this.f5755a.m7602e().get(this.f5756b) + ": " + this.f5755a.m7603f().get(this.f5757c) + " " + this.f5755a.m7598b(this.f5758d);
    }
}
