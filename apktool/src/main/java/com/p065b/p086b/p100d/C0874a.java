package com.p065b.p086b.p100d;

import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p110h.C1009ab;

/* compiled from: Annotation.java */
/* renamed from: com.b.b.d.a */
/* loaded from: classes.dex */
public final class C0874a implements Comparable<C0874a> {

    /* renamed from: a */
    private final C0898f f5326a;

    /* renamed from: b */
    private final byte f5327b;

    /* renamed from: c */
    private final int f5328c;

    /* renamed from: d */
    private final int[] f5329d;

    /* renamed from: e */
    private final C0900h[] f5330e;

    public C0874a(C0898f c0898f, byte b2, int i, int[] iArr, C0900h[] c0900hArr) {
        this.f5326a = c0898f;
        this.f5327b = b2;
        this.f5328c = i;
        this.f5329d = iArr;
        this.f5330e = c0900hArr;
    }

    /* renamed from: a */
    public byte m7441a() {
        return this.f5327b;
    }

    /* renamed from: b */
    public int m7444b() {
        return this.f5328c;
    }

    /* renamed from: c */
    public int[] m7445c() {
        return this.f5329d;
    }

    /* renamed from: d */
    public C0900h[] m7446d() {
        return this.f5330e;
    }

    /* renamed from: a */
    public void m7443a(C0898f.a aVar) {
        aVar.mo7631c(this.f5327b);
        aVar.m7637f(this.f5328c);
        aVar.m7637f(this.f5329d.length);
        for (int i = 0; i < this.f5329d.length; i++) {
            aVar.m7637f(this.f5329d[i]);
            this.f5330e[i].m7657a(aVar);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0874a c0874a) {
        if (this.f5328c != c0874a.f5328c) {
            return C1009ab.m8473a(this.f5328c, c0874a.f5328c);
        }
        int min = Math.min(this.f5329d.length, c0874a.f5329d.length);
        for (int i = 0; i < min; i++) {
            if (this.f5329d[i] != c0874a.f5329d[i]) {
                return C1009ab.m8473a(this.f5329d[i], c0874a.f5329d[i]);
            }
            int compareTo = this.f5330e[i].compareTo(c0874a.f5330e[i]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return this.f5329d.length - c0874a.f5329d.length;
    }

    public String toString() {
        if (this.f5326a == null) {
            return ((int) this.f5327b) + " " + this.f5328c;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((int) this.f5327b);
        sb.append(" ");
        sb.append(this.f5326a.m7603f().get(this.f5328c));
        sb.append("[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f5329d.length) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(this.f5326a.m7602e().get(this.f5329d[i2]));
                sb.append("=");
                sb.append(this.f5330e[i2]);
                i = i2 + 1;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
