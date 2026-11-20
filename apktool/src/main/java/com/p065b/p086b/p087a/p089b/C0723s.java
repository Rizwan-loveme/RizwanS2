package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p087a.p089b.C0709e;
import com.p065b.p086b.p087a.p089b.C0716l;
import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0920b;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0927i;
import com.p065b.p086b.p103f.p105b.C0931m;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p105b.C0942x;
import com.p065b.p086b.p103f.p105b.C0943y;
import com.p065b.p086b.p103f.p105b.InterfaceC0944z;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1012c;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Ropper.java */
/* renamed from: com.b.b.a.b.s */
/* loaded from: classes.dex */
public final class C0723s {

    /* renamed from: a */
    private final C0712h f4557a;

    /* renamed from: b */
    private final C0708d f4558b;

    /* renamed from: c */
    private final int f4559c;

    /* renamed from: d */
    private final int f4560d;

    /* renamed from: e */
    private final C0724t f4561e;

    /* renamed from: f */
    private final C0726v f4562f;

    /* renamed from: g */
    private final C0714j[] f4563g;

    /* renamed from: h */
    private final ArrayList<C0920b> f4564h;

    /* renamed from: i */
    private final ArrayList<C1025p> f4565i;

    /* renamed from: j */
    private final C0975c[] f4566j;

    /* renamed from: k */
    private boolean f4567k;

    /* renamed from: l */
    private final b[] f4568l;

    /* renamed from: m */
    private boolean f4569m;

    /* compiled from: Ropper.java */
    /* renamed from: com.b.b.a.b.s$b */
    private class b {

        /* renamed from: b */
        private BitSet f4576b;

        /* renamed from: c */
        private BitSet f4577c;

        /* renamed from: d */
        private int f4578d;

        b(int i) {
            this.f4578d = i;
            this.f4577c = new BitSet(C0723s.this.f4560d);
            this.f4576b = new BitSet(C0723s.this.f4560d);
            C0723s.this.f4569m = true;
        }

        b(C0723s c0723s, int i, int i2) {
            this(i);
            m6747a(i2);
        }

        /* renamed from: a */
        int m6746a() {
            return this.f4578d;
        }

        /* renamed from: a */
        void m6747a(int i) {
            this.f4577c.set(i);
        }

        /* renamed from: b */
        void m6750b(int i) {
            this.f4576b.set(i);
        }

        /* renamed from: b */
        C1025p m6749b() {
            C1025p c1025p = new C1025p(this.f4576b.size());
            int nextSetBit = this.f4576b.nextSetBit(0);
            while (nextSetBit >= 0) {
                c1025p.m8571c(C0723s.this.m6725d(nextSetBit).m7847c().m8569b(0));
                nextSetBit = this.f4576b.nextSetBit(nextSetBit + 1);
            }
            c1025p.mo6683e_();
            return c1025p;
        }

        /* renamed from: a */
        void m6748a(C0714j c0714j, int[] iArr) {
            int nextSetBit = this.f4576b.nextSetBit(0);
            while (nextSetBit >= 0) {
                int m8569b = C0723s.this.m6725d(nextSetBit).m7847c().m8569b(0);
                C0714j m6634a = c0714j.m6634a(this.f4578d, nextSetBit);
                if (m6634a != null) {
                    C0723s.this.m6707a(m8569b, -1, null, m6634a, iArr);
                } else {
                    C1012c.m8490b(iArr, nextSetBit);
                }
                nextSetBit = this.f4576b.nextSetBit(nextSetBit + 1);
            }
        }
    }

    /* renamed from: a */
    public static C0938t m6706a(C0712h c0712h, InterfaceC0944z interfaceC0944z) {
        try {
            C0723s c0723s = new C0723s(c0712h, interfaceC0944z);
            c0723s.m6733i();
            return c0723s.m6732h();
        } catch (C0725u e2) {
            e2.m8540a("...while working on method " + c0712h.mo6603a().mo6681d());
            throw e2;
        }
    }

    private C0723s(C0712h c0712h, InterfaceC0944z interfaceC0944z) {
        if (c0712h == null) {
            throw new NullPointerException("method == null");
        }
        if (interfaceC0944z == null) {
            throw new NullPointerException("advice == null");
        }
        this.f4557a = c0712h;
        this.f4558b = C0706b.m6553a(c0712h);
        this.f4560d = this.f4558b.m8587j();
        this.f4559c = c0712h.m6612j();
        this.f4561e = new C0724t(this, c0712h, interfaceC0944z);
        this.f4562f = new C0726v(this.f4561e, c0712h);
        this.f4563g = new C0714j[this.f4560d];
        this.f4568l = new b[this.f4560d];
        this.f4564h = new ArrayList<>((this.f4558b.m8550f_() * 2) + 10);
        this.f4565i = new ArrayList<>((this.f4558b.m8550f_() * 2) + 10);
        this.f4566j = new C0975c[this.f4560d];
        this.f4567k = false;
        this.f4563g[0] = new C0714j(this.f4559c, c0712h.m6611i());
    }

    /* renamed from: a */
    int m6741a() {
        int m6729f = m6729f();
        return m6726d() ? m6729f + 1 : m6729f;
    }

    /* renamed from: a */
    private int m6701a(int i) {
        return this.f4560d + i;
    }

    /* renamed from: b */
    private int m6718b(int i) {
        return (this.f4560d * 2) + (i ^ (-1));
    }

    /* renamed from: b */
    private int m6717b() {
        return (this.f4560d * 2) + 7;
    }

    /* renamed from: c */
    private int m6722c() {
        int m6717b = m6717b();
        Iterator<C0920b> it = this.f4564h.iterator();
        while (true) {
            int i = m6717b;
            if (it.hasNext()) {
                int mo6568a = it.next().mo6568a();
                m6717b = mo6568a >= i ? mo6568a + 1 : i;
            } else {
                return i;
            }
        }
    }

    /* renamed from: d */
    private boolean m6726d() {
        return (this.f4557a.mo6606d() & 32) != 0;
    }

    /* renamed from: e */
    private boolean m6728e() {
        return (this.f4557a.mo6606d() & 8) != 0;
    }

    /* renamed from: f */
    private int m6729f() {
        return this.f4559c + this.f4557a.m6611i();
    }

    /* renamed from: g */
    private C0934p m6731g() {
        int m6729f = m6729f();
        return C0934p.m7913a(m6729f >= 1 ? m6729f : 1, C0975c.f6260o);
    }

    /* renamed from: c */
    private int m6723c(int i) {
        int size = this.f4564h.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f4564h.get(i2).mo6568a() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public C0920b m6725d(int i) {
        int m6723c = m6723c(i);
        if (m6723c < 0) {
            throw new IllegalArgumentException("no such label " + C1022m.m8557c(i));
        }
        return this.f4564h.get(m6723c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6712a(C0920b c0920b, C1025p c1025p) {
        if (c0920b == null) {
            throw new NullPointerException("block == null");
        }
        this.f4564h.add(c0920b);
        c1025p.m8596m();
        this.f4565i.add(c1025p);
    }

    /* renamed from: b */
    private boolean m6721b(C0920b c0920b, C1025p c1025p) {
        boolean z;
        if (c0920b == null) {
            throw new NullPointerException("block == null");
        }
        int m6723c = m6723c(c0920b.mo6568a());
        if (m6723c < 0) {
            z = false;
        } else {
            m6727e(m6723c);
            z = true;
        }
        this.f4564h.add(c0920b);
        c1025p.m8596m();
        this.f4565i.add(c1025p);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m6724c(C0920b c0920b, C1025p c1025p) {
        boolean z;
        if (c0920b == null) {
            throw new NullPointerException("block == null");
        }
        int m6723c = m6723c(c0920b.mo6568a());
        if (m6723c < 0) {
            z = false;
        } else {
            this.f4564h.remove(m6723c);
            this.f4565i.remove(m6723c);
            z = true;
        }
        this.f4564h.add(c0920b);
        c1025p.m8596m();
        this.f4565i.add(c1025p);
        return z;
    }

    /* renamed from: e */
    private void m6727e(int i) {
        int m6717b = m6717b();
        C1025p m7847c = this.f4564h.get(i).m7847c();
        int m8568b = m7847c.m8568b();
        this.f4564h.remove(i);
        this.f4565i.remove(i);
        for (int i2 = 0; i2 < m8568b; i2++) {
            int m8569b = m7847c.m8569b(i2);
            if (m8569b >= m6717b) {
                int m6723c = m6723c(m8569b);
                if (m6723c < 0) {
                    throw new RuntimeException("Invalid label " + C1022m.m8557c(m8569b));
                }
                m6727e(m6723c);
            }
        }
    }

    /* renamed from: h */
    private C0938t m6732h() {
        int size = this.f4564h.size();
        C0921c c0921c = new C0921c(size);
        for (int i = 0; i < size; i++) {
            c0921c.m7856a(i, this.f4564h.get(i));
        }
        c0921c.mo6683e_();
        return new C0938t(c0921c, m6718b(-1));
    }

    /* renamed from: i */
    private void m6733i() {
        int[] m8489a = C1012c.m8489a(this.f4560d);
        C1012c.m8490b(m8489a, 0);
        m6735k();
        m6734j();
        while (true) {
            int m8494d = C1012c.m8494d(m8489a, 0);
            if (m8494d < 0) {
                break;
            }
            C1012c.m8493c(m8489a, m8494d);
            try {
                m6709a(this.f4558b.m6575b(m8494d), this.f4563g[m8494d], m8489a);
            } catch (C0725u e2) {
                e2.m8540a("...while working on block " + C1022m.m8557c(m8494d));
                throw e2;
            }
        }
        m6736l();
        m6737m();
        m6738n();
        if (this.f4569m) {
            m6739o();
        }
    }

    /* renamed from: j */
    private void m6734j() {
        this.f4563g[0].m6638a(this.f4557a.mo6609g().m8104c());
        this.f4563g[0].m6642b();
    }

    /* renamed from: a */
    private void m6709a(C0707c c0707c, C0714j c0714j, int[] iArr) {
        int i;
        C1025p c1025p;
        int i2;
        C1025p c1025p2;
        int m8569b;
        C1025p c1025p3;
        int i3;
        C1025p c1025p4;
        C0709e m6572e = c0707c.m6572e();
        this.f4561e.m6758a(m6572e.m6583c_());
        C0714j m6633a = c0714j.m6633a();
        this.f4562f.m6776a(c0707c, m6633a);
        m6633a.m6642b();
        int m6765s = this.f4561e.m6765s();
        ArrayList<AbstractC0926h> m6759m = this.f4561e.m6759m();
        int size = m6759m.size();
        int f_ = m6572e.m8550f_();
        C1025p m6571d = c0707c.m6571d();
        b bVar = null;
        if (this.f4561e.m6767u()) {
            i = 1;
            int m8569b2 = m6571d.m8569b(1);
            if (this.f4568l[m8569b2] == null) {
                this.f4568l[m8569b2] = new b(m8569b2);
            }
            this.f4568l[m8569b2].m6750b(c0707c.mo6568a());
            bVar = this.f4568l[m8569b2];
            c1025p = m6571d;
        } else if (this.f4561e.m6768v()) {
            int m6700g = this.f4561e.m6769w().m6700g();
            if (this.f4568l[m6700g] == null) {
                this.f4568l[m6700g] = new b(this, m6700g, c0707c.mo6568a());
            } else {
                this.f4568l[m6700g].m6747a(c0707c.mo6568a());
            }
            C1025p m6749b = this.f4568l[m6700g].m6749b();
            this.f4568l[m6700g].m6748a(m6633a, iArr);
            i = m6749b.m8568b();
            c1025p = m6749b;
        } else if (this.f4561e.m6762p()) {
            i = f_;
            c1025p = m6571d;
        } else {
            i = 0;
            c1025p = m6571d;
        }
        int m8568b = c1025p.m8568b();
        for (int i4 = i; i4 < m8568b; i4++) {
            int m8569b3 = c1025p.m8569b(i4);
            try {
                m6707a(m8569b3, c0707c.mo6568a(), bVar, m6633a, iArr);
            } catch (C0725u e2) {
                e2.m8540a("...while merging to block " + C1022m.m8557c(m8569b3));
                throw e2;
            }
        }
        if (m8568b == 0 && this.f4561e.m6763q()) {
            i2 = 1;
            c1025p2 = C1025p.m8565a(m6718b(-2));
        } else {
            i2 = m8568b;
            c1025p2 = c1025p;
        }
        if (i2 == 0) {
            m8569b = -1;
        } else {
            int m6764r = this.f4561e.m6764r();
            m8569b = m6764r >= 0 ? c1025p2.m8569b(m6764r) : m6764r;
        }
        boolean z = m6726d() && this.f4561e.m6766t();
        if (z || f_ != 0) {
            boolean z2 = false;
            C1025p c1025p5 = new C1025p(i2);
            int i5 = 0;
            while (i5 < f_) {
                C0709e.a m6578a = m6572e.m6578a(i5);
                C0971y m6588d = m6578a.m6588d();
                int m6587c = m6578a.m6587c();
                boolean z3 = z2 | (m6588d == C0971y.f6172a);
                try {
                    m6707a(m6587c, c0707c.mo6568a(), null, m6633a.m6637a(m6588d), iArr);
                    C0975c c0975c = this.f4566j[m6587c];
                    if (c0975c == null) {
                        this.f4566j[m6587c] = m6588d.m8090i();
                    } else if (c0975c != m6588d.m8090i()) {
                        this.f4566j[m6587c] = C0975c.f6260o;
                    }
                    c1025p5.m8571c(m6701a(m6587c));
                    i5++;
                    z2 = z3;
                } catch (C0725u e3) {
                    e3.m8540a("...while merging exception to block " + C1022m.m8557c(m6587c));
                    throw e3;
                }
            }
            if (z && !z2) {
                c1025p5.m8571c(m6718b(-6));
                this.f4567k = true;
                for (int i6 = (size - m6765s) - 1; i6 < size; i6++) {
                    AbstractC0926h abstractC0926h = m6759m.get(i6);
                    if (abstractC0926h.m7887k()) {
                        m6759m.set(i6, abstractC0926h.mo7874a(C0975c.f6260o));
                    }
                }
            }
            if (m8569b >= 0) {
                c1025p5.m8571c(m8569b);
            }
            c1025p5.mo6683e_();
            c1025p3 = c1025p5;
        } else {
            c1025p3 = c1025p2;
        }
        int m8577f = c1025p3.m8577f(m8569b);
        int i7 = m8569b;
        C1025p c1025p6 = c1025p3;
        int i8 = size;
        for (int i9 = m6765s; i9 > 0; i9--) {
            int i10 = i8 - 1;
            AbstractC0926h abstractC0926h2 = m6759m.get(i10);
            boolean z4 = abstractC0926h2.m7882f().m7971d() == 1;
            C0927i c0927i = new C0927i(z4 ? 2 : 1);
            c0927i.m7890a(0, abstractC0926h2);
            if (z4) {
                c0927i.m7890a(1, (AbstractC0926h) new C0932n(C0939u.f6120s, abstractC0926h2.m7883g(), (C0934p) null, C0935q.f5906a));
                c1025p4 = C1025p.m8565a(i7);
            } else {
                c1025p4 = c1025p6;
            }
            c0927i.mo6683e_();
            int m6722c = m6722c();
            m6712a(new C0920b(m6722c, c0927i, c1025p4, i7), m6633a.m6645e());
            c1025p6 = c1025p6.m8578f();
            c1025p6.m8570b(m8577f, m6722c);
            c1025p6.mo6683e_();
            i7 = m6722c;
            i8 = i10;
        }
        AbstractC0926h abstractC0926h3 = i8 == 0 ? null : m6759m.get(i8 - 1);
        if (abstractC0926h3 == null || abstractC0926h3.m7882f().m7971d() == 1) {
            m6759m.add(new C0932n(C0939u.f6120s, abstractC0926h3 == null ? C0940v.f6128a : abstractC0926h3.m7883g(), (C0934p) null, C0935q.f5906a));
            i3 = i8 + 1;
        } else {
            i3 = i8;
        }
        C0927i c0927i2 = new C0927i(i3);
        for (int i11 = 0; i11 < i3; i11++) {
            c0927i2.m7890a(i11, m6759m.get(i11));
        }
        c0927i2.mo6683e_();
        m6721b(new C0920b(c0707c.mo6568a(), c0927i2, c1025p6, i7), m6633a.m6645e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6707a(int i, int i2, b bVar, C0714j c0714j, int[] iArr) {
        C0714j m6635a;
        C0714j c0714j2 = this.f4563g[i];
        if (c0714j2 != null) {
            if (bVar != null) {
                m6635a = c0714j2.m6636a(c0714j, bVar.m6746a(), i2);
            } else {
                m6635a = c0714j2.m6635a(c0714j);
            }
            if (m6635a != c0714j2) {
                this.f4563g[i] = m6635a;
                C1012c.m8490b(iArr, i);
                return;
            }
            return;
        }
        if (bVar != null) {
            this.f4563g[i] = c0714j.m6641b(i, i2);
        } else {
            this.f4563g[i] = c0714j;
        }
        C1012c.m8490b(iArr, i);
    }

    /* renamed from: k */
    private void m6735k() {
        C0927i c0927i;
        C0716l m6615m = this.f4557a.m6615m();
        C0940v m6602a = this.f4557a.m6602a(0);
        C0974b m8104c = this.f4557a.mo6609g().m8104c();
        int f_ = m8104c.m8550f_();
        C0927i c0927i2 = new C0927i(f_ + 1);
        int i = 0;
        int i2 = 0;
        while (i < f_) {
            C0975c m8115b = m8104c.m8115b(i);
            C0716l.a m6656a = m6615m.m6656a(0, i2);
            c0927i2.m7890a(i, (AbstractC0926h) new C0931m(C0939u.m7989b(m8115b), m6602a, m6656a == null ? C0934p.m7913a(i2, m8115b) : C0934p.m7918b(i2, m8115b, m6656a.m6663a()), C0935q.f5906a, C0959m.m8060a(i2)));
            i++;
            i2 += m8115b.m8127j();
        }
        c0927i2.m7890a(f_, (AbstractC0926h) new C0932n(C0939u.f6120s, m6602a, (C0934p) null, C0935q.f5906a));
        c0927i2.mo6683e_();
        boolean m6726d = m6726d();
        int m6718b = m6726d ? m6718b(-4) : 0;
        m6712a(new C0920b(m6718b(-1), c0927i2, C1025p.m8565a(m6718b), m6718b), C1025p.f6502a);
        if (m6726d) {
            C0934p m6731g = m6731g();
            if (m6728e()) {
                C0942x c0942x = new C0942x(C0939u.f6118q, m6602a, C0935q.f5906a, C0974b.f6209a, this.f4557a.mo6608f());
                C0927i c0927i3 = new C0927i(1);
                c0927i3.m7890a(0, (AbstractC0926h) c0942x);
                c0927i = c0927i3;
            } else {
                C0927i c0927i4 = new C0927i(2);
                c0927i4.m7890a(0, (AbstractC0926h) new C0931m(C0939u.f6113l, m6602a, m6731g, C0935q.f5906a, C0959m.f6150b));
                c0927i4.m7890a(1, (AbstractC0926h) new C0932n(C0939u.f6120s, m6602a, (C0934p) null, C0935q.f5906a));
                c0927i = c0927i4;
            }
            int m6718b2 = m6718b(-5);
            c0927i.mo6683e_();
            m6712a(new C0920b(m6718b, c0927i, C1025p.m8565a(m6718b2), m6718b2), C1025p.f6502a);
            C0927i c0927i5 = new C0927i(m6728e() ? 2 : 1);
            if (m6728e()) {
                c0927i5.m7890a(0, (AbstractC0926h) new C0932n(C0939u.m7998e(m6731g), m6602a, m6731g, C0935q.f5906a));
            }
            c0927i5.m7890a(m6728e() ? 1 : 0, (AbstractC0926h) new C0943y(C0939u.f6005bE, m6602a, C0935q.m7944a(m6731g), C0974b.f6209a));
            c0927i5.mo6683e_();
            m6712a(new C0920b(m6718b2, c0927i5, C1025p.m8565a(0), 0), C1025p.f6502a);
        }
    }

    /* renamed from: l */
    private void m6736l() {
        int i;
        C0935q m7944a;
        C0937s m6760n = this.f4561e.m6760n();
        if (m6760n != null) {
            C0940v m6761o = this.f4561e.m6761o();
            int m6718b = m6718b(-2);
            if (m6726d()) {
                C0927i c0927i = new C0927i(1);
                c0927i.m7890a(0, (AbstractC0926h) new C0943y(C0939u.f6006bF, m6761o, C0935q.m7944a(m6731g()), C0974b.f6209a));
                c0927i.mo6683e_();
                i = m6718b(-3);
                m6712a(new C0920b(m6718b, c0927i, C1025p.m8565a(i), i), C1025p.f6502a);
            } else {
                i = m6718b;
            }
            C0927i c0927i2 = new C0927i(1);
            InterfaceC0977e m7970c = m6760n.m7970c();
            if (m7970c.mo6856f_() == 0) {
                m7944a = C0935q.f5906a;
            } else {
                m7944a = C0935q.m7944a(C0934p.m7913a(0, m7970c.mo6853a(0)));
            }
            c0927i2.m7890a(0, (AbstractC0926h) new C0932n(m6760n, m6761o, (C0934p) null, m7944a));
            c0927i2.mo6683e_();
            m6712a(new C0920b(i, c0927i2, C1025p.f6502a, -1), C1025p.f6502a);
        }
    }

    /* renamed from: m */
    private void m6737m() {
        if (this.f4567k) {
            C0940v m6602a = this.f4557a.m6602a(0);
            C0934p m7913a = C0934p.m7913a(0, C0975c.f6263r);
            C0927i c0927i = new C0927i(2);
            c0927i.m7890a(0, (AbstractC0926h) new C0932n(C0939u.m7992c(C0975c.f6263r), m6602a, m7913a, C0935q.f5906a));
            c0927i.m7890a(1, (AbstractC0926h) new C0943y(C0939u.f6006bF, m6602a, C0935q.m7944a(m6731g()), C0974b.f6209a));
            c0927i.mo6683e_();
            int m6718b = m6718b(-7);
            m6712a(new C0920b(m6718b(-6), c0927i, C1025p.m8565a(m6718b), m6718b), C1025p.f6502a);
            C0927i c0927i2 = new C0927i(1);
            c0927i2.m7890a(0, (AbstractC0926h) new C0943y(C0939u.f6004bD, m6602a, C0935q.m7944a(m7913a), C0974b.f6209a));
            c0927i2.mo6683e_();
            m6712a(new C0920b(m6718b, c0927i2, C1025p.f6502a, -1), C1025p.f6502a);
        }
    }

    /* renamed from: n */
    private void m6738n() {
        int length = this.f4566j.length;
        for (int i = 0; i < length; i++) {
            C0975c c0975c = this.f4566j[i];
            if (c0975c != null) {
                C0940v m7883g = m6725d(i).m7850f().m7883g();
                C0927i c0927i = new C0927i(2);
                c0927i.m7890a(0, (AbstractC0926h) new C0932n(C0939u.m7992c(c0975c), m7883g, C0934p.m7913a(this.f4559c, c0975c), C0935q.f5906a));
                c0927i.m7890a(1, (AbstractC0926h) new C0932n(C0939u.f6120s, m7883g, (C0934p) null, C0935q.f5906a));
                c0927i.mo6683e_();
                m6712a(new C0920b(m6701a(i), c0927i, C1025p.m8565a(i), i), this.f4563g[i].m6645e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6716a(C0920b c0920b) {
        C1025p m7847c = c0920b.m7847c();
        if (m7847c.m8568b() < 2) {
            return false;
        }
        int m8569b = m7847c.m8569b(1);
        return m8569b < this.f4568l.length && this.f4568l[m8569b] != null;
    }

    /* renamed from: o */
    private void m6739o() {
        final C1025p c1025p = new C1025p(4);
        m6708a(0, new C0920b.a() { // from class: com.b.b.a.b.s.1
            @Override // com.p065b.p086b.p103f.p105b.C0920b.a
            /* renamed from: a */
            public void mo6742a(C0920b c0920b) {
                if (C0723s.this.m6716a(c0920b)) {
                    c1025p.m8571c(c0920b.mo6568a());
                }
            }
        });
        int m6722c = m6722c();
        ArrayList arrayList = new ArrayList(m6722c);
        for (int i = 0; i < m6722c; i++) {
            arrayList.add(null);
        }
        for (int i2 = 0; i2 < this.f4564h.size(); i2++) {
            C0920b c0920b = this.f4564h.get(i2);
            if (c0920b != null) {
                arrayList.set(c0920b.mo6568a(), this.f4565i.get(i2));
            }
        }
        int m8568b = c1025p.m8568b();
        for (int i3 = 0; i3 < m8568b; i3++) {
            new c(new a(m6722c()), arrayList).m6754a(m6725d(c1025p.m8569b(i3)));
        }
        m6740p();
    }

    /* renamed from: p */
    private void m6740p() {
        final C1025p c1025p = new C1025p(this.f4564h.size());
        this.f4565i.clear();
        m6708a(m6718b(-1), new C0920b.a() { // from class: com.b.b.a.b.s.2
            @Override // com.p065b.p086b.p103f.p105b.C0920b.a
            /* renamed from: a */
            public void mo6742a(C0920b c0920b) {
                c1025p.m8571c(c0920b.mo6568a());
            }
        });
        c1025p.m8580g();
        for (int size = this.f4564h.size() - 1; size >= 0; size--) {
            if (c1025p.m8577f(this.f4564h.get(size).mo6568a()) < 0) {
                this.f4564h.remove(size);
            }
        }
    }

    /* compiled from: Ropper.java */
    /* renamed from: com.b.b.a.b.s$a */
    private static class a {

        /* renamed from: a */
        int f4574a;

        a(int i) {
            this.f4574a = i;
        }

        /* renamed from: a */
        int m6743a() {
            int i = this.f4574a;
            this.f4574a = i + 1;
            return i;
        }
    }

    /* compiled from: Ropper.java */
    /* renamed from: com.b.b.a.b.s$c */
    private class c {

        /* renamed from: b */
        private final HashMap<Integer, Integer> f4580b = new HashMap<>();

        /* renamed from: c */
        private final BitSet f4581c;

        /* renamed from: d */
        private int f4582d;

        /* renamed from: e */
        private int f4583e;

        /* renamed from: f */
        private final a f4584f;

        /* renamed from: g */
        private final ArrayList<C1025p> f4585g;

        c(a aVar, ArrayList<C1025p> arrayList) {
            this.f4581c = new BitSet(C0723s.this.f4560d);
            this.f4584f = aVar;
            this.f4585g = arrayList;
        }

        /* renamed from: a */
        void m6754a(C0920b c0920b) {
            this.f4583e = c0920b.m7847c().m8569b(0);
            this.f4582d = c0920b.m7847c().m8569b(1);
            int m6751a = m6751a(this.f4582d);
            int nextSetBit = this.f4581c.nextSetBit(0);
            while (nextSetBit >= 0) {
                this.f4581c.clear(nextSetBit);
                int intValue = this.f4580b.get(Integer.valueOf(nextSetBit)).intValue();
                m6752a(nextSetBit, intValue);
                if (C0723s.this.m6716a(C0723s.this.m6725d(nextSetBit))) {
                    C0723s.this.new c(this.f4584f, this.f4585g).m6754a(C0723s.this.m6725d(intValue));
                }
                nextSetBit = this.f4581c.nextSetBit(0);
            }
            C0723s.this.m6724c(new C0920b(c0920b.mo6568a(), c0920b.m7846b(), C1025p.m8565a(m6751a), m6751a), this.f4585g.get(c0920b.mo6568a()));
        }

        /* renamed from: a */
        private void m6752a(int i, int i2) {
            C1025p c1025p;
            C0920b m6725d = C0723s.this.m6725d(i);
            C1025p m7847c = m6725d.m7847c();
            int i3 = -1;
            if (!C0723s.this.m6716a(m6725d)) {
                b m6730f = C0723s.this.m6730f(i);
                if (m6730f != null) {
                    if (m6730f.f4578d != this.f4582d) {
                        throw new RuntimeException("ret instruction returns to label " + C1022m.m8557c(m6730f.f4578d) + " expected: " + C1022m.m8557c(this.f4582d));
                    }
                    c1025p = C1025p.m8565a(this.f4583e);
                    i3 = this.f4583e;
                } else {
                    int m7848d = m6725d.m7848d();
                    int m8568b = m7847c.m8568b();
                    C1025p c1025p2 = new C1025p(m8568b);
                    int i4 = 0;
                    while (i4 < m8568b) {
                        int m8569b = m7847c.m8569b(i4);
                        int m6751a = m6751a(m8569b);
                        c1025p2.m8571c(m6751a);
                        if (m7848d != m8569b) {
                            m6751a = i3;
                        }
                        i4++;
                        i3 = m6751a;
                    }
                    c1025p2.mo6683e_();
                    c1025p = c1025p2;
                }
            } else {
                c1025p = C1025p.m8566a(m6751a(m7847c.m8569b(0)), m7847c.m8569b(1));
            }
            C0723s.this.m6712a(new C0920b(i2, C0723s.this.m6705a(m6725d.m7846b()), c1025p, i3), this.f4585g.get(i2));
        }

        /* renamed from: b */
        private boolean m6753b(int i, int i2) {
            C1025p c1025p = this.f4585g.get(i);
            return c1025p != null && c1025p.m8568b() > 0 && c1025p.m8573d() == i2;
        }

        /* renamed from: a */
        private int m6751a(int i) {
            Integer num = this.f4580b.get(Integer.valueOf(i));
            if (num != null) {
                return num.intValue();
            }
            if (m6753b(i, this.f4582d)) {
                int m6743a = this.f4584f.m6743a();
                this.f4581c.set(i);
                this.f4580b.put(Integer.valueOf(i), Integer.valueOf(m6743a));
                while (this.f4585g.size() <= m6743a) {
                    this.f4585g.add(null);
                }
                this.f4585g.set(m6743a, this.f4585g.get(i));
                return m6743a;
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public b m6730f(int i) {
        for (int length = this.f4568l.length - 1; length >= 0; length--) {
            if (this.f4568l[length] != null) {
                b bVar = this.f4568l[length];
                if (bVar.f4577c.get(i)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C0927i m6705a(C0927i c0927i) {
        int i;
        int f_ = c0927i.m8550f_();
        int i2 = 0;
        for (int i3 = 0; i3 < f_; i3++) {
            if (c0927i.m7889a(i3).m7882f() != C0939u.f6108g) {
                i2++;
            }
        }
        if (i2 != f_) {
            C0927i c0927i2 = new C0927i(i2);
            int i4 = 0;
            int i5 = 0;
            while (i4 < f_) {
                AbstractC0926h m7889a = c0927i.m7889a(i4);
                if (m7889a.m7882f() != C0939u.f6108g) {
                    i = i5 + 1;
                    c0927i2.m7890a(i5, m7889a);
                } else {
                    i = i5;
                }
                i4++;
                i5 = i;
            }
            c0927i2.mo6683e_();
            return c0927i2;
        }
        return c0927i;
    }

    /* renamed from: a */
    private void m6708a(int i, C0920b.a aVar) {
        m6711a(m6725d(i), aVar, new BitSet(this.f4560d));
    }

    /* renamed from: a */
    private void m6711a(C0920b c0920b, C0920b.a aVar, BitSet bitSet) {
        int m6723c;
        aVar.mo6742a(c0920b);
        bitSet.set(c0920b.mo6568a());
        C1025p m7847c = c0920b.m7847c();
        int m8568b = m7847c.m8568b();
        for (int i = 0; i < m8568b; i++) {
            int m8569b = m7847c.m8569b(i);
            if (!bitSet.get(m8569b) && ((!m6716a(c0920b) || i <= 0) && (m6723c = m6723c(m8569b)) >= 0)) {
                m6711a(this.f4564h.get(m6723c), aVar, bitSet);
            }
        }
    }
}
