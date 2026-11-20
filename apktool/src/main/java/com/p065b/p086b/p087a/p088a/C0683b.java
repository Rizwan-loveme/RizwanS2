package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p087a.p089b.C0709e;
import com.p065b.p086b.p087a.p089b.C0711g;
import com.p065b.p086b.p087a.p092e.InterfaceC0741b;
import com.p065b.p086b.p110h.C1032w;

/* compiled from: AttCode.java */
/* renamed from: com.b.b.a.a.b */
/* loaded from: classes.dex */
public final class C0683b extends AbstractC0700s {

    /* renamed from: a */
    private final int f4465a;

    /* renamed from: b */
    private final int f4466b;

    /* renamed from: c */
    private final C0711g f4467c;

    /* renamed from: d */
    private final C0709e f4468d;

    /* renamed from: e */
    private final InterfaceC0741b f4469e;

    public C0683b(int i, int i2, C0711g c0711g, C0709e c0709e, InterfaceC0741b interfaceC0741b) {
        super("Code");
        if (i < 0) {
            throw new IllegalArgumentException("maxStack < 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("maxLocals < 0");
        }
        if (c0711g == null) {
            throw new NullPointerException("code == null");
        }
        try {
            if (c0709e.m8593d_()) {
                throw new C1032w("catches.isMutable()");
            }
            try {
                if (interfaceC0741b.m6893d_()) {
                    throw new C1032w("attributes.isMutable()");
                }
                this.f4465a = i;
                this.f4466b = i2;
                this.f4467c = c0711g;
                this.f4468d = c0709e;
                this.f4469e = interfaceC0741b;
            } catch (NullPointerException e2) {
                throw new NullPointerException("attributes == null");
            }
        } catch (NullPointerException e3) {
            throw new NullPointerException("catches == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return this.f4467c.m6600c() + 10 + this.f4468d.m6577a() + this.f4469e.mo6892b();
    }

    /* renamed from: b */
    public int m6497b() {
        return this.f4465a;
    }

    /* renamed from: c */
    public int m6498c() {
        return this.f4466b;
    }

    /* renamed from: d */
    public C0711g m6499d() {
        return this.f4467c;
    }

    /* renamed from: e */
    public C0709e m6500e() {
        return this.f4468d;
    }

    /* renamed from: f */
    public InterfaceC0741b m6501f() {
        return this.f4469e;
    }
}
