package com.p065b.p086b.p102e;

import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p110h.C1009ab;

/* compiled from: TypeList.java */
/* renamed from: com.b.b.e.f */
/* loaded from: classes.dex */
public final class C0913f implements Comparable<C0913f> {

    /* renamed from: a */
    public static final C0913f f5839a = new C0913f(null, new short[0]);

    /* renamed from: b */
    private final C0898f f5840b;

    /* renamed from: c */
    private final short[] f5841c;

    public C0913f(C0898f c0898f, short[] sArr) {
        this.f5840b = c0898f;
        this.f5841c = sArr;
    }

    /* renamed from: a */
    public short[] m7815a() {
        return this.f5841c;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0913f c0913f) {
        for (int i = 0; i < this.f5841c.length && i < c0913f.f5841c.length; i++) {
            if (this.f5841c[i] != c0913f.f5841c[i]) {
                return C1009ab.m8474a(this.f5841c[i], c0913f.f5841c[i]);
            }
        }
        return C1009ab.m8473a(this.f5841c.length, c0913f.f5841c.length);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int length = this.f5841c.length;
        for (int i = 0; i < length; i++) {
            sb.append(this.f5840b != null ? this.f5840b.m7603f().get(this.f5841c[i]) : Short.valueOf(this.f5841c[i]));
        }
        sb.append(")");
        return sb.toString();
    }
}
