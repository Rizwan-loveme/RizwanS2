package com.p065b.p086b.p108g.p109a;

import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p108g.AbstractC0999p;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C1002s;
import com.p065b.p086b.p108g.C1005v;
import com.p065b.p086b.p110h.InterfaceC1024o;
import java.util.ArrayList;

/* compiled from: RegisterAllocator.java */
/* renamed from: com.b.b.g.a.e */
/* loaded from: classes.dex */
public abstract class AbstractC0983e {

    /* renamed from: a */
    protected final C1005v f6313a;

    /* renamed from: b */
    protected final C0981c f6314b;

    /* renamed from: a */
    public abstract boolean mo8173a();

    /* renamed from: b */
    public abstract AbstractC0999p mo8174b();

    public AbstractC0983e(C1005v c1005v, C0981c c0981c) {
        this.f6313a = c1005v;
        this.f6314b = c0981c;
    }

    /* renamed from: a */
    protected final C0934p m8196a(int i) {
        AbstractC1004u m8418c = this.f6313a.m8418c(i);
        if (m8418c == null) {
            return null;
        }
        return m8418c.m8391o();
    }

    /* renamed from: a */
    protected final C0934p m8197a(AbstractC1004u abstractC1004u, C0934p c0934p) {
        C1002s m8392p = abstractC1004u.m8392p();
        ArrayList<AbstractC1004u> m8353c = m8392p.m8353c();
        int indexOf = m8353c.indexOf(abstractC1004u);
        if (indexOf < 0) {
            throw new IllegalArgumentException("specified insn is not in this block");
        }
        if (indexOf != m8353c.size() - 1) {
            throw new IllegalArgumentException("Adding move here not supported:" + abstractC1004u.mo6681d());
        }
        C0934p m7913a = C0934p.m7913a(this.f6313a.m8432o(), c0934p.m7932h());
        m8353c.add(indexOf, AbstractC1004u.m8385a(new C0932n(C0939u.m7982a(m7913a.mo6695a()), C0940v.f6128a, m7913a, C0935q.m7944a(c0934p)), m8392p));
        int m7931g = m7913a.m7931g();
        InterfaceC1024o mo8479b = m8392p.m8371q().mo8479b();
        while (mo8479b.mo8481a()) {
            this.f6314b.m8187a(m7931g, mo8479b.mo8482b());
        }
        C0935q mo8285b = abstractC1004u.mo8285b();
        int f_ = mo8285b.m8550f_();
        for (int i = 0; i < f_; i++) {
            this.f6314b.m8187a(m7931g, mo8285b.m7949b(i).m7931g());
        }
        this.f6313a.m8430m();
        return m7913a;
    }
}
