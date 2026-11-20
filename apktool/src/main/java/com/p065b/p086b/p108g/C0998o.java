package com.p065b.p086b.p108g;

import com.p065b.p086b.p087a.p089b.C0720p;
import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import java.util.BitSet;
import java.util.List;

/* compiled from: PhiTypeResolver.java */
/* renamed from: com.b.b.g.o */
/* loaded from: classes.dex */
public class C0998o {

    /* renamed from: a */
    C1005v f6407a;

    /* renamed from: b */
    private final BitSet f6408b;

    /* renamed from: a */
    public static void m8313a(C1005v c1005v) {
        new C0998o(c1005v).m8312a();
    }

    private C0998o(C1005v c1005v) {
        this.f6407a = c1005v;
        this.f6408b = new BitSet(c1005v.m8424g());
    }

    /* renamed from: a */
    private void m8312a() {
        int m8424g = this.f6407a.m8424g();
        for (int i = 0; i < m8424g; i++) {
            AbstractC1004u m8418c = this.f6407a.m8418c(i);
            if (m8418c != null && m8418c.m8391o().mo6697c() == 0) {
                this.f6408b.set(i);
            }
        }
        while (true) {
            int nextSetBit = this.f6408b.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.f6408b.clear(nextSetBit);
                if (m8315a((C0997n) this.f6407a.m8418c(nextSetBit))) {
                    List<AbstractC1004u> m8420d = this.f6407a.m8420d(nextSetBit);
                    int size = m8420d.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AbstractC1004u abstractC1004u = m8420d.get(i2);
                        C0934p m8391o = abstractC1004u.m8391o();
                        if (m8391o != null && (abstractC1004u instanceof C0997n)) {
                            this.f6408b.set(m8391o.m7931g());
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m8314a(C0928j c0928j, C0928j c0928j2) {
        return c0928j == c0928j2 || (c0928j != null && c0928j.equals(c0928j2));
    }

    /* renamed from: a */
    boolean m8315a(C0997n c0997n) {
        c0997n.m8310a(this.f6407a);
        C0935q mo8285b = c0997n.mo8285b();
        int i = -1;
        int f_ = mo8285b.m8550f_();
        int i2 = 0;
        C0934p c0934p = null;
        while (i2 < f_) {
            C0934p m7949b = mo8285b.m7949b(i2);
            if (m7949b.mo6697c() != 0) {
                i = i2;
            } else {
                m7949b = c0934p;
            }
            i2++;
            c0934p = m7949b;
        }
        if (c0934p == null) {
            return false;
        }
        C0928j m7933i = c0934p.m7933i();
        InterfaceC0976d mo6695a = c0934p.mo6695a();
        boolean z = true;
        for (int i3 = 0; i3 < f_; i3++) {
            if (i3 != i) {
                C0934p m7949b2 = mo8285b.m7949b(i3);
                if (m7949b2.mo6697c() != 0) {
                    z = z && m8314a(m7933i, m7949b2.m7933i());
                    mo6695a = C0720p.m6687a(mo6695a, m7949b2.mo6695a());
                }
            }
        }
        if (mo6695a == null) {
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < f_; i4++) {
                sb.append(mo8285b.m7949b(i4).toString());
                sb.append(' ');
            }
            throw new RuntimeException("Couldn't map types in phi insn:" + ((Object) sb));
        }
        C0928j c0928j = z ? m7933i : null;
        C0934p o = c0997n.m8391o();
        if (o.m7932h() == mo6695a && m8314a(c0928j, o.m7933i())) {
            return false;
        }
        c0997n.m8309a(mo6695a, c0928j);
        return true;
    }
}
