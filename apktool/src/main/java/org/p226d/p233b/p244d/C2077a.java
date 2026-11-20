package org.p226d.p233b.p244d;

import org.p226d.p269d.C2453g;

/* compiled from: BaseDexBuffer.java */
/* renamed from: org.d.b.d.a */
/* loaded from: classes.dex */
public class C2077a {

    /* renamed from: a */
    final byte[] f11801a;

    /* renamed from: b */
    final int f11802b;

    public C2077a(byte[] bArr) {
        this(bArr, 0);
    }

    public C2077a(byte[] bArr, int i) {
        this.f11801a = bArr;
        this.f11802b = i;
    }

    /* renamed from: a */
    public int m14615a(int i) {
        byte[] bArr = this.f11801a;
        int i2 = this.f11802b + i;
        int i3 = (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        if (i3 < 0) {
            throw new C2453g("Encountered small uint that is out of range at offset 0x%x", Integer.valueOf(i2));
        }
        return i3;
    }

    /* renamed from: b */
    public int m14616b(int i) {
        byte[] bArr = this.f11801a;
        int i2 = this.f11802b + i;
        int i3 = (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        if (i3 < -1) {
            throw new C2453g("Encountered optional uint that is out of range at offset 0x%x", Integer.valueOf(i2));
        }
        return i3;
    }

    /* renamed from: c */
    public int m14617c(int i) {
        byte[] bArr = this.f11801a;
        int i2 = this.f11802b + i;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
    }

    /* renamed from: d */
    public int m14618d(int i) {
        return this.f11801a[this.f11802b + i] & 255;
    }

    /* renamed from: e */
    public long m14619e(int i) {
        byte[] bArr = this.f11801a;
        int i2 = this.f11802b + i;
        return (bArr[i2 + 7] << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* renamed from: f */
    public int m14620f(int i) {
        byte[] bArr = this.f11801a;
        int i2 = this.f11802b + i;
        long j = (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | (bArr[i2 + 7] << 56);
        if (j < 0 || j > 2147483647L) {
            throw new C2453g("Encountered out-of-range ulong at offset 0x%x", Integer.valueOf(i2));
        }
        return (int) j;
    }

    /* renamed from: g */
    public int m14621g(int i) {
        byte[] bArr = this.f11801a;
        int i2 = this.f11802b + i;
        return (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* renamed from: h */
    public int m14622h(int i) {
        byte[] bArr = this.f11801a;
        int i2 = this.f11802b + i;
        return (bArr[i2 + 1] << 8) | (bArr[i2] & 255);
    }

    /* renamed from: i */
    public int m14623i(int i) {
        return this.f11801a[this.f11802b + i];
    }
}
