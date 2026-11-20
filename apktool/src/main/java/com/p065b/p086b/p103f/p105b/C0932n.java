package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;

/* compiled from: PlainInsn.java */
/* renamed from: com.b.b.f.b.n */
/* loaded from: classes.dex */
public final class C0932n extends AbstractC0926h {
    public C0932n(C0937s c0937s, C0940v c0940v, C0934p c0934p, C0935q c0935q) {
        super(c0937s, c0940v, c0934p, c0935q);
        switch (c0937s.m7971d()) {
            case 5:
            case 6:
                throw new IllegalArgumentException("bogus branchingness");
            default:
                if (c0934p != null && c0937s.m7971d() != 1) {
                    throw new IllegalArgumentException("can't mix branchingness with result");
                }
                return;
        }
    }

    public C0932n(C0937s c0937s, C0940v c0940v, C0934p c0934p, C0934p c0934p2) {
        this(c0937s, c0940v, c0934p, C0935q.m7944a(c0934p2));
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: b */
    public InterfaceC0977e mo7876b() {
        return C0974b.f6209a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public void mo7875a(AbstractC0926h.b bVar) {
        bVar.mo7178a(this);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7874a(C0975c c0975c) {
        throw new UnsupportedOperationException("unsupported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: l */
    public AbstractC0926h mo7888l() {
        AbstractC0945a abstractC0945a;
        C0935q j = m7886j();
        int f_ = j.m8550f_();
        if (f_ != 0) {
            InterfaceC0976d m7932h = j.m7949b(f_ - 1).m7932h();
            if (!m7932h.mo6699f()) {
                InterfaceC0976d m7932h2 = j.m7949b(0).m7932h();
                if (f_ == 2 && m7932h2.mo6699f()) {
                    AbstractC0945a abstractC0945a2 = (AbstractC0945a) m7932h2;
                    C0935q m7954f = j.m7954f();
                    return new C0931m(C0939u.m7980a(m7882f().m7968a(), m7884h(), m7954f, abstractC0945a2), m7883g(), m7884h(), m7954f, abstractC0945a2);
                }
                return this;
            }
            AbstractC0945a abstractC0945a3 = (AbstractC0945a) m7932h;
            C0935q m7955g = j.m7955g();
            try {
                int m7968a = m7882f().m7968a();
                if (m7968a == 15 && (abstractC0945a3 instanceof C0959m)) {
                    m7968a = 14;
                    abstractC0945a = C0959m.m8060a(-((C0959m) abstractC0945a3).m8061k_());
                } else {
                    abstractC0945a = abstractC0945a3;
                }
                return new C0931m(C0939u.m7980a(m7968a, m7884h(), m7955g, abstractC0945a), m7883g(), m7884h(), m7955g, abstractC0945a);
            } catch (IllegalArgumentException e2) {
                return this;
            }
        }
        return this;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7873a(C0934p c0934p, C0935q c0935q) {
        return new C0932n(m7882f(), m7883g(), c0934p, c0935q);
    }
}
