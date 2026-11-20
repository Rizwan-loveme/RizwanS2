package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0936r;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;
import java.util.BitSet;

/* compiled from: LocalVariableExtractor.java */
/* renamed from: com.b.b.g.i */
/* loaded from: classes.dex */
public class C0992i {

    /* renamed from: a */
    private final C1005v f6377a;

    /* renamed from: b */
    private final ArrayList<C1002s> f6378b;

    /* renamed from: c */
    private final C0993j f6379c;

    /* renamed from: d */
    private final BitSet f6380d;

    /* renamed from: a */
    public static C0993j m8267a(C1005v c1005v) {
        return new C0992i(c1005v).m8266a();
    }

    private C0992i(C1005v c1005v) {
        if (c1005v == null) {
            throw new NullPointerException("method == null");
        }
        ArrayList<C1002s> m8427j = c1005v.m8427j();
        this.f6377a = c1005v;
        this.f6378b = m8427j;
        this.f6379c = new C0993j(c1005v);
        this.f6380d = new BitSet(m8427j.size());
    }

    /* renamed from: a */
    private C0993j m8266a() {
        if (this.f6377a.m8424g() > 0) {
            int m8417c = this.f6377a.m8417c();
            while (m8417c >= 0) {
                this.f6380d.clear(m8417c);
                m8268a(m8417c);
                m8417c = this.f6380d.nextSetBit(0);
            }
        }
        this.f6379c.mo6683e_();
        return this.f6379c;
    }

    /* renamed from: a */
    private void m8268a(int i) {
        C0936r c0936r;
        C0936r m8273b = this.f6379c.m8273b(i);
        C1002s c1002s = this.f6378b.get(i);
        ArrayList<AbstractC1004u> m8353c = c1002s.m8353c();
        int size = m8353c.size();
        if (i != this.f6377a.m8421e()) {
            AbstractC1004u abstractC1004u = m8353c.get(size - 1);
            boolean z = (abstractC1004u.mo8288f().mo7876b().mo6856f_() != 0) && abstractC1004u.m8391o() != null;
            int i2 = size - 1;
            int i3 = 0;
            C0936r c0936r2 = m8273b;
            while (i3 < size) {
                if (z && i3 == i2) {
                    c0936r2.mo6683e_();
                    c0936r = c0936r2.m7967e();
                } else {
                    c0936r = c0936r2;
                }
                AbstractC1004u abstractC1004u2 = m8353c.get(i3);
                C0934p mo8289g = abstractC1004u2.mo8289g();
                if (mo8289g == null) {
                    C0934p m8391o = abstractC1004u2.m8391o();
                    if (m8391o != null && c0936r.m7956a(m8391o.m7931g()) != null) {
                        c0936r.m7964c(c0936r.m7956a(m8391o.m7931g()));
                    }
                } else {
                    C0934p m7938n = mo8289g.m7938n();
                    if (!m7938n.equals(c0936r.m7958a(m7938n))) {
                        C0934p m7957a = c0936r.m7957a(m7938n.m7933i());
                        if (m7957a != null && m7957a.m7931g() != m7938n.m7931g()) {
                            c0936r.m7964c(m7957a);
                        }
                        this.f6379c.m8272a(abstractC1004u2, m7938n);
                        c0936r.m7966d(m7938n);
                    }
                }
                i3++;
                c0936r2 = c0936r;
            }
            c0936r2.mo6683e_();
            C1025p m8364j = c1002s.m8364j();
            int m8568b = m8364j.m8568b();
            int m8365k = c1002s.m8365k();
            for (int i4 = 0; i4 < m8568b; i4++) {
                int m8569b = m8364j.m8569b(i4);
                if (this.f6379c.m8274b(m8569b, m8569b == m8365k ? c0936r2 : m8273b)) {
                    this.f6380d.set(m8569b);
                }
            }
        }
    }
}
