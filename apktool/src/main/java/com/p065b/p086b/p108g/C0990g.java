package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p108g.p109a.C0981c;
import com.p065b.p086b.p110h.C1011b;
import java.util.ArrayList;

/* compiled from: InterferenceRegisterMapper.java */
/* renamed from: com.b.b.g.g */
/* loaded from: classes.dex */
public class C0990g extends C0978a {

    /* renamed from: a */
    private final ArrayList<C1011b> f6372a;

    /* renamed from: b */
    private final C0981c f6373b;

    public C0990g(C0981c c0981c, int i) {
        super(i);
        this.f6372a = new ArrayList<>();
        this.f6373b = c0981c;
    }

    @Override // com.p065b.p086b.p108g.C0978a
    /* renamed from: a */
    public void mo8142a(int i, int i2, int i3) {
        super.mo8142a(i, i2, i3);
        m8254a(i2, i);
        if (i3 == 2) {
            m8254a(i2 + 1, i);
        }
    }

    /* renamed from: b */
    public boolean m8257b(int i, int i2, int i3) {
        C1011b c1011b;
        if (i2 >= this.f6372a.size() || (c1011b = this.f6372a.get(i2)) == null) {
            return false;
        }
        if (i3 == 1) {
            return c1011b.mo8480b(i);
        }
        return c1011b.mo8480b(i) || m8257b(i, i2 + 1, i3 + (-1));
    }

    /* renamed from: a */
    public boolean m8255a(C0934p c0934p, int i) {
        return m8257b(c0934p.m7931g(), i, c0934p.m7935k());
    }

    /* renamed from: a */
    private void m8254a(int i, int i2) {
        this.f6372a.ensureCapacity(i + 1);
        while (i >= this.f6372a.size()) {
            this.f6372a.add(new C1011b(i + 1));
        }
        this.f6373b.m8188a(i2, this.f6372a.get(i));
    }

    /* renamed from: a */
    public boolean m8256a(C0935q c0935q, int i, int i2) {
        int f_ = c0935q.m8550f_();
        for (int i3 = 0; i3 < f_; i3++) {
            C0934p m7949b = c0935q.m7949b(i3);
            int a2 = m8140a(m7949b.m7931g());
            if (a2 == i || ((m7949b.m7935k() == 2 && a2 + 1 == i) || (i2 == 2 && a2 == i + 1))) {
                return true;
            }
        }
        return false;
    }
}
