package com.p065b.p086b.p100d;

import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p110h.C1015f;
import com.p065b.p086b.p110h.InterfaceC1016g;

/* compiled from: EncodedValue.java */
/* renamed from: com.b.b.d.h */
/* loaded from: classes.dex */
public final class C0900h implements Comparable<C0900h> {

    /* renamed from: a */
    private final byte[] f5468a;

    public C0900h(byte[] bArr) {
        this.f5468a = bArr;
    }

    /* renamed from: a */
    public InterfaceC1016g m7656a() {
        return new C1015f(this.f5468a);
    }

    /* renamed from: a */
    public void m7657a(C0898f.a aVar) {
        aVar.m7625a(this.f5468a);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0900h c0900h) {
        int min = Math.min(this.f5468a.length, c0900h.f5468a.length);
        for (int i = 0; i < min; i++) {
            if (this.f5468a[i] != c0900h.f5468a[i]) {
                return (this.f5468a[i] & 255) - (c0900h.f5468a[i] & 255);
            }
        }
        return this.f5468a.length - c0900h.f5468a.length;
    }

    public String toString() {
        return Integer.toHexString(this.f5468a[0] & 255) + "...(" + this.f5468a.length + ")";
    }
}
