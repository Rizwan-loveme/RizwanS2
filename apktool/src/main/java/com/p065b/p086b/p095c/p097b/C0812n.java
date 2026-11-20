package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: HighRegisterPrefix.java */
/* renamed from: com.b.b.c.b.n */
/* loaded from: classes.dex */
public final class C0812n extends AbstractC0798ad {

    /* renamed from: a */
    private C0824z[] f5062a;

    public C0812n(C0940v c0940v, C0935q c0935q) {
        super(c0940v, c0935q);
        if (c0935q.m8550f_() == 0) {
            throw new IllegalArgumentException("registers.size() == 0");
        }
        this.f5062a = null;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public int mo6964a() {
        m7067c();
        C0824z[] c0824zArr = this.f5062a;
        int length = c0824zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int a2 = c0824zArr[i].mo6964a() + i2;
            i++;
            i2 = a2;
        }
        return i2;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public void mo6967a(InterfaceC1007a interfaceC1007a) {
        m7067c();
        for (C0824z c0824z : this.f5062a) {
            c0824z.mo6967a(interfaceC1007a);
        }
    }

    /* renamed from: c */
    private void m7067c() {
        if (this.f5062a == null) {
            C0935q j = m7043j();
            int f_ = j.m8550f_();
            this.f5062a = new C0824z[f_];
            int i = 0;
            for (int i2 = 0; i2 < f_; i2++) {
                C0934p m7949b = j.m7949b(i2);
                this.f5062a[i2] = m7066a(m7949b, i);
                i += m7949b.m7935k();
            }
        }
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0812n(m7042i(), c0935q);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        return null;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    protected String mo6966a(boolean z) {
        C0935q j = m7043j();
        int f_ = j.m8550f_();
        StringBuffer stringBuffer = new StringBuffer(100);
        int i = 0;
        for (int i2 = 0; i2 < f_; i2++) {
            C0934p m7949b = j.m7949b(i2);
            C0824z m7066a = m7066a(m7949b, i);
            if (i2 != 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(m7066a.mo6966a(z));
            i += m7949b.m7935k();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static C0824z m7066a(C0934p c0934p, int i) {
        return AbstractC0807i.m7032a(C0940v.f6128a, C0934p.m7913a(i, c0934p.mo6695a()), c0934p);
    }
}
