package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;
import com.p065b.p086b.p110h.InterfaceC1027r;

/* compiled from: BasicBlock.java */
/* renamed from: com.b.b.f.b.b */
/* loaded from: classes.dex */
public final class C0920b implements InterfaceC1027r {

    /* renamed from: a */
    private final int f5856a;

    /* renamed from: b */
    private final C0927i f5857b;

    /* renamed from: c */
    private final C1025p f5858c;

    /* renamed from: d */
    private final int f5859d;

    /* compiled from: BasicBlock.java */
    /* renamed from: com.b.b.f.b.b$a */
    public interface a {
        /* renamed from: a */
        void mo6742a(C0920b c0920b);
    }

    public C0920b(int i, C0927i c0927i, C1025p c1025p, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("label < 0");
        }
        try {
            c0927i.m8596m();
            int f_ = c0927i.m8550f_();
            if (f_ == 0) {
                throw new IllegalArgumentException("insns.size() == 0");
            }
            for (int i3 = f_ - 2; i3 >= 0; i3--) {
                if (c0927i.m7889a(i3).m7882f().m7971d() != 1) {
                    throw new IllegalArgumentException("insns[" + i3 + "] is a branch or can throw");
                }
            }
            if (c0927i.m7889a(f_ - 1).m7882f().m7971d() == 1) {
                throw new IllegalArgumentException("insns does not end with a branch or throwing instruction");
            }
            try {
                c1025p.m8596m();
                if (i2 < -1) {
                    throw new IllegalArgumentException("primarySuccessor < -1");
                }
                if (i2 >= 0 && !c1025p.m8581h(i2)) {
                    throw new IllegalArgumentException("primarySuccessor " + i2 + " not in successors " + c1025p);
                }
                this.f5856a = i;
                this.f5857b = c0927i;
                this.f5858c = c1025p;
                this.f5859d = i2;
            } catch (NullPointerException e2) {
                throw new NullPointerException("successors == null");
            }
        } catch (NullPointerException e3) {
            throw new NullPointerException("insns == null");
        }
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1027r
    /* renamed from: a */
    public int mo6568a() {
        return this.f5856a;
    }

    /* renamed from: b */
    public C0927i m7846b() {
        return this.f5857b;
    }

    /* renamed from: c */
    public C1025p m7847c() {
        return this.f5858c;
    }

    /* renamed from: d */
    public int m7848d() {
        return this.f5859d;
    }

    /* renamed from: e */
    public int m7849e() {
        if (this.f5858c.m8568b() != 2) {
            throw new UnsupportedOperationException("block doesn't have exactly two successors");
        }
        int m8569b = this.f5858c.m8569b(0);
        if (m8569b == this.f5859d) {
            return this.f5858c.m8569b(1);
        }
        return m8569b;
    }

    /* renamed from: f */
    public AbstractC0926h m7850f() {
        return this.f5857b.m7889a(0);
    }

    /* renamed from: g */
    public AbstractC0926h m7851g() {
        return this.f5857b.m7893e();
    }

    /* renamed from: h */
    public boolean m7852h() {
        return this.f5857b.m7893e().m7887k();
    }

    /* renamed from: i */
    public boolean m7853i() {
        return this.f5857b.m7893e().mo7876b().mo6856f_() != 0;
    }

    public String toString() {
        return '{' + C1022m.m8557c(this.f5856a) + '}';
    }
}
