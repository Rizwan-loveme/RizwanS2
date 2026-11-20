package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p110h.C1025p;
import com.p065b.p086b.p110h.C1031v;

/* compiled from: SwitchList.java */
/* renamed from: com.b.b.a.b.w */
/* loaded from: classes.dex */
public final class C0727w extends C1031v {

    /* renamed from: a */
    private final C1025p f4611a;

    /* renamed from: b */
    private final C1025p f4612b;

    /* renamed from: c */
    private int f4613c;

    public C0727w(int i) {
        super(true);
        this.f4611a = new C1025p(i);
        this.f4612b = new C1025p(i + 1);
        this.f4613c = i;
    }

    @Override // com.p065b.p086b.p110h.C1031v
    /* renamed from: e_ */
    public void mo6683e_() {
        this.f4611a.mo6683e_();
        this.f4612b.mo6683e_();
        super.mo6683e_();
    }

    /* renamed from: a */
    public int m6779a() {
        return this.f4613c;
    }

    /* renamed from: a */
    public int m6780a(int i) {
        return this.f4611a.m8569b(i);
    }

    /* renamed from: b */
    public int m6783b(int i) {
        return this.f4612b.m8569b(i);
    }

    /* renamed from: b */
    public int m6782b() {
        return this.f4612b.m8569b(this.f4613c);
    }

    /* renamed from: d */
    public C1025p m6785d() {
        return this.f4612b;
    }

    /* renamed from: e */
    public C1025p m6786e() {
        return this.f4611a;
    }

    /* renamed from: c */
    public void m6784c(int i) {
        m8595l();
        if (i < 0) {
            throw new IllegalArgumentException("target < 0");
        }
        if (this.f4612b.m8568b() != this.f4613c) {
            throw new RuntimeException("non-default elements not all set");
        }
        this.f4612b.m8571c(i);
    }

    /* renamed from: a */
    public void m6781a(int i, int i2) {
        m8595l();
        if (i2 < 0) {
            throw new IllegalArgumentException("target < 0");
        }
        this.f4611a.m8571c(i);
        this.f4612b.m8571c(i2);
    }

    /* renamed from: f */
    public void m6787f() {
        m8595l();
        int i = this.f4613c;
        if (i != this.f4612b.m8568b() - 1) {
            throw new IllegalArgumentException("incomplete instance");
        }
        int m8569b = this.f4612b.m8569b(i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int m8569b2 = this.f4612b.m8569b(i3);
            if (m8569b2 != m8569b) {
                if (i3 != i2) {
                    this.f4612b.m8570b(i2, m8569b2);
                    this.f4611a.m8570b(i2, this.f4611a.m8569b(i3));
                }
                i2++;
            }
        }
        if (i2 != i) {
            this.f4611a.m8576e(i2);
            this.f4612b.m8570b(i2, m8569b);
            this.f4612b.m8576e(i2 + 1);
            this.f4613c = i2;
        }
    }
}
