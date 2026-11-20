package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;
import com.p065b.p086b.p110h.InterfaceC1027r;

/* compiled from: ByteBlock.java */
/* renamed from: com.b.b.a.b.c */
/* loaded from: classes.dex */
public final class C0707c implements InterfaceC1027r {

    /* renamed from: a */
    private final int f4511a;

    /* renamed from: b */
    private final int f4512b;

    /* renamed from: c */
    private final int f4513c;

    /* renamed from: d */
    private final C1025p f4514d;

    /* renamed from: e */
    private final C0709e f4515e;

    public C0707c(int i, int i2, int i3, C1025p c1025p, C0709e c0709e) {
        if (i < 0) {
            throw new IllegalArgumentException("label < 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i3 <= i2) {
            throw new IllegalArgumentException("end <= start");
        }
        if (c1025p == null) {
            throw new NullPointerException("targets == null");
        }
        int m8568b = c1025p.m8568b();
        for (int i4 = 0; i4 < m8568b; i4++) {
            if (c1025p.m8569b(i4) < 0) {
                throw new IllegalArgumentException("successors[" + i4 + "] == " + c1025p.m8569b(i4));
            }
        }
        if (c0709e == null) {
            throw new NullPointerException("catches == null");
        }
        this.f4511a = i;
        this.f4512b = i2;
        this.f4513c = i3;
        this.f4514d = c1025p;
        this.f4515e = c0709e;
    }

    public String toString() {
        return '{' + C1022m.m8557c(this.f4511a) + ": " + C1022m.m8557c(this.f4512b) + ".." + C1022m.m8557c(this.f4513c) + '}';
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1027r
    /* renamed from: a */
    public int mo6568a() {
        return this.f4511a;
    }

    /* renamed from: b */
    public int m6569b() {
        return this.f4512b;
    }

    /* renamed from: c */
    public int m6570c() {
        return this.f4513c;
    }

    /* renamed from: d */
    public C1025p m6571d() {
        return this.f4514d;
    }

    /* renamed from: e */
    public C0709e m6572e() {
        return this.f4515e;
    }
}
