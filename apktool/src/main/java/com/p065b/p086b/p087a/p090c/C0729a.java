package com.p065b.p086b.p087a.p090c;

import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0955i;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0958l;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0960n;
import com.p065b.p086b.p103f.p106c.C0965s;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p106c.C0972z;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;
import java.util.BitSet;

/* compiled from: ConstantPoolParser.java */
/* renamed from: com.b.b.a.c.a */
/* loaded from: classes.dex */
public final class C0729a {

    /* renamed from: a */
    private final C1013d f4614a;

    /* renamed from: b */
    private final C0972z f4615b;

    /* renamed from: c */
    private final int[] f4616c;

    /* renamed from: d */
    private int f4617d;

    /* renamed from: e */
    private InterfaceC0749j f4618e;

    public C0729a(C1013d c1013d) {
        int m8512f = c1013d.m8512f(8);
        this.f4614a = c1013d;
        this.f4615b = new C0972z(m8512f);
        this.f4616c = new int[m8512f];
        this.f4617d = -1;
    }

    /* renamed from: a */
    public void m6794a(InterfaceC0749j interfaceC0749j) {
        this.f4618e = interfaceC0749j;
    }

    /* renamed from: a */
    public int m6793a() {
        m6790c();
        return this.f4617d;
    }

    /* renamed from: b */
    public C0972z m6795b() {
        m6790c();
        return this.f4615b;
    }

    /* renamed from: c */
    private void m6790c() {
        if (this.f4617d < 0) {
            m6791d();
        }
    }

    /* renamed from: d */
    private void m6791d() {
        int i;
        m6792e();
        if (this.f4618e != null) {
            this.f4618e.m6900a(this.f4614a, 8, 2, "constant_pool_count: " + C1022m.m8557c(this.f4616c.length));
            this.f4618e.m6900a(this.f4614a, 10, 0, "\nconstant_pool:");
            this.f4618e.m6899a(1);
        }
        BitSet bitSet = new BitSet(this.f4616c.length);
        for (int i2 = 1; i2 < this.f4616c.length; i2++) {
            if (this.f4616c[i2] != 0 && this.f4615b.m8094c(i2) == null) {
                m6788a(i2, bitSet);
            }
        }
        if (this.f4618e != null) {
            for (int i3 = 1; i3 < this.f4616c.length; i3++) {
                AbstractC0945a m8094c = this.f4615b.m8094c(i3);
                if (m8094c != null) {
                    int i4 = this.f4616c[i3];
                    int i5 = this.f4617d;
                    int i6 = i3 + 1;
                    while (true) {
                        if (i6 >= this.f4616c.length) {
                            i = i5;
                            break;
                        }
                        int i7 = this.f4616c[i6];
                        if (i7 != 0) {
                            i = i7;
                            break;
                        }
                        i6++;
                    }
                    this.f4618e.m6900a(this.f4614a, i4, i - i4, bitSet.get(i3) ? C1022m.m8557c(i3) + ": utf8{\"" + m8094c.mo6681d() + "\"}" : C1022m.m8557c(i3) + ": " + m8094c.toString());
                }
            }
            this.f4618e.m6899a(-1);
            this.f4618e.m6900a(this.f4614a, this.f4617d, 0, "end constant_pool");
        }
    }

    /* renamed from: e */
    private void m6792e() {
        int i;
        int i2 = 10;
        int i3 = 1;
        while (i3 < this.f4616c.length) {
            this.f4616c[i3] = i2;
            int m8511e = this.f4614a.m8511e(i2);
            switch (m8511e) {
                case 1:
                    i2 += this.f4614a.m8512f(i2 + 1) + 3;
                    i = 1;
                    break;
                case 2:
                default:
                    C0748i c0748i = new C0748i("unknown tag byte: " + C1022m.m8559e(m8511e));
                    c0748i.m8540a("...while preparsing cst " + C1022m.m8557c(i3) + " at offset " + C1022m.m8552a(i2));
                    throw c0748i;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i2 += 5;
                    i = 1;
                    break;
                case 5:
                case 6:
                    i = 2;
                    i2 += 9;
                    break;
                case 7:
                case 8:
                    i2 += 3;
                    i = 1;
                    break;
            }
            i3 += i;
        }
        this.f4617d = i2;
    }

    /* renamed from: a */
    private AbstractC0945a m6788a(int i, BitSet bitSet) {
        AbstractC0945a m8094c = this.f4615b.m8094c(i);
        if (m8094c == null) {
            int i2 = this.f4616c[i];
            try {
                switch (this.f4614a.m8511e(i2)) {
                    case 1:
                        m8094c = m6789a(i2);
                        bitSet.set(i);
                        break;
                    case 3:
                        m8094c = C0959m.m8060a(this.f4614a.m8508c(i2 + 1));
                        break;
                    case 4:
                        m8094c = C0958l.m8059a(this.f4614a.m8508c(i2 + 1));
                        break;
                    case 5:
                        m8094c = C0965s.m8068a(this.f4614a.m8510d(i2 + 1));
                        break;
                    case 6:
                        m8094c = C0955i.m8056a(this.f4614a.m8510d(i2 + 1));
                        break;
                    case 7:
                        m8094c = new C0971y(C0975c.m8121c(((C0970x) m6788a(this.f4614a.m8512f(i2 + 1), bitSet)).m8084j()));
                        break;
                    case 8:
                        m8094c = m6788a(this.f4614a.m8512f(i2 + 1), bitSet);
                        break;
                    case 9:
                        m8094c = new C0957k((C0971y) m6788a(this.f4614a.m8512f(i2 + 1), bitSet), (C0968v) m6788a(this.f4614a.m8512f(i2 + 3), bitSet));
                        break;
                    case 10:
                        m8094c = new C0967u((C0971y) m6788a(this.f4614a.m8512f(i2 + 1), bitSet), (C0968v) m6788a(this.f4614a.m8512f(i2 + 3), bitSet));
                        break;
                    case 11:
                        m8094c = new C0960n((C0971y) m6788a(this.f4614a.m8512f(i2 + 1), bitSet), (C0968v) m6788a(this.f4614a.m8512f(i2 + 3), bitSet));
                        break;
                    case 12:
                        m8094c = new C0968v((C0970x) m6788a(this.f4614a.m8512f(i2 + 1), bitSet), (C0970x) m6788a(this.f4614a.m8512f(i2 + 3), bitSet));
                        break;
                }
                this.f4615b.m8093a(i, m8094c);
            } catch (C0748i e2) {
                e2.m8540a("...while parsing cst " + C1022m.m8557c(i) + " at offset " + C1022m.m8552a(i2));
                throw e2;
            } catch (RuntimeException e3) {
                C0748i c0748i = new C0748i(e3);
                c0748i.m8540a("...while parsing cst " + C1022m.m8557c(i) + " at offset " + C1022m.m8552a(i2));
                throw c0748i;
            }
        }
        return m8094c;
    }

    /* renamed from: a */
    private C0970x m6789a(int i) {
        int i2 = i + 3;
        try {
            return new C0970x(this.f4614a.m8504a(i2, this.f4614a.m8512f(i + 1) + i2));
        } catch (IllegalArgumentException e2) {
            throw new C0748i(e2);
        }
    }
}
