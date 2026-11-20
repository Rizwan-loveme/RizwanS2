package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p110h.C1025p;

/* compiled from: BasicRegisterMapper.java */
/* renamed from: com.b.b.g.a */
/* loaded from: classes.dex */
public class C0978a extends AbstractC0999p {

    /* renamed from: a */
    private C1025p f6279a;

    /* renamed from: b */
    private int f6280b;

    public C0978a(int i) {
        this.f6279a = new C1025p(i);
    }

    @Override // com.p065b.p086b.p108g.AbstractC0999p
    /* renamed from: a */
    public int mo8139a() {
        return this.f6280b;
    }

    @Override // com.p065b.p086b.p108g.AbstractC0999p
    /* renamed from: a */
    public C0934p mo8141a(C0934p c0934p) {
        int i;
        if (c0934p == null) {
            return null;
        }
        try {
            i = this.f6279a.m8569b(c0934p.m7931g());
        } catch (IndexOutOfBoundsException e2) {
            i = -1;
        }
        if (i < 0) {
            throw new RuntimeException("no mapping specified for register");
        }
        return c0934p.m7927b(i);
    }

    /* renamed from: a */
    public int m8140a(int i) {
        if (i >= this.f6279a.m8568b()) {
            return -1;
        }
        return this.f6279a.m8569b(i);
    }

    /* renamed from: a */
    public void mo8142a(int i, int i2, int i3) {
        if (i >= this.f6279a.m8568b()) {
            for (int m8568b = i - this.f6279a.m8568b(); m8568b >= 0; m8568b--) {
                this.f6279a.m8571c(-1);
            }
        }
        this.f6279a.m8570b(i, i2);
        if (this.f6280b < i2 + i3) {
            this.f6280b = i2 + i3;
        }
    }
}
