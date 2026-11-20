package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p088a.C0697p;
import com.p065b.p086b.p087a.p090c.C0729a;
import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p087a.p092e.C0750k;
import com.p065b.p086b.p087a.p092e.InterfaceC0740a;
import com.p065b.p086b.p087a.p092e.InterfaceC0741b;
import com.p065b.p086b.p087a.p092e.InterfaceC0742c;
import com.p065b.p086b.p087a.p092e.InterfaceC0744e;
import com.p065b.p086b.p087a.p092e.InterfaceC0747h;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p106c.C0972z;
import com.p065b.p086b.p103f.p106c.InterfaceC0948b;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: DirectClassFile.java */
/* renamed from: com.b.b.a.d.f */
/* loaded from: classes.dex */
public class C0735f implements InterfaceC0742c {

    /* renamed from: a */
    private final String f4639a;

    /* renamed from: b */
    private final C1013d f4640b;

    /* renamed from: c */
    private final boolean f4641c;

    /* renamed from: d */
    private C0972z f4642d;

    /* renamed from: e */
    private int f4643e;

    /* renamed from: f */
    private C0971y f4644f;

    /* renamed from: g */
    private C0971y f4645g;

    /* renamed from: h */
    private InterfaceC0977e f4646h;

    /* renamed from: i */
    private InterfaceC0744e f4647i;

    /* renamed from: j */
    private InterfaceC0747h f4648j;

    /* renamed from: k */
    private C0750k f4649k;

    /* renamed from: l */
    private C0731b f4650l;

    /* renamed from: m */
    private InterfaceC0749j f4651m;

    /* renamed from: a */
    public static String m6831a(Object obj) {
        return obj == null ? "(none)" : obj.toString();
    }

    public C0735f(C1013d c1013d, String str, boolean z) {
        if (c1013d == null) {
            throw new NullPointerException("bytes == null");
        }
        if (str == null) {
            throw new NullPointerException("filePath == null");
        }
        this.f4639a = str;
        this.f4640b = c1013d;
        this.f4641c = z;
        this.f4643e = -1;
    }

    public C0735f(byte[] bArr, String str, boolean z) {
        this(new C1013d(bArr), str, z);
    }

    /* renamed from: a */
    public void m6839a(C0731b c0731b) {
        if (c0731b == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        this.f4650l = c0731b;
    }

    /* renamed from: a */
    public C1013d m6838a() {
        return this.f4640b;
    }

    /* renamed from: b */
    public int m6840b() {
        m6833o();
        return m6850l();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0742c
    /* renamed from: c */
    public int mo6841c() {
        m6833o();
        return this.f4643e;
    }

    /* renamed from: d */
    public C0971y m6842d() {
        m6833o();
        return this.f4644f;
    }

    /* renamed from: e */
    public C0971y m6843e() {
        m6833o();
        return this.f4645g;
    }

    /* renamed from: f */
    public InterfaceC0948b m6844f() {
        m6833o();
        return this.f4642d;
    }

    /* renamed from: g */
    public InterfaceC0977e m6845g() {
        m6833o();
        return this.f4646h;
    }

    /* renamed from: h */
    public InterfaceC0744e m6846h() {
        m6834p();
        return this.f4647i;
    }

    /* renamed from: i */
    public InterfaceC0747h m6847i() {
        m6834p();
        return this.f4648j;
    }

    /* renamed from: j */
    public InterfaceC0741b m6848j() {
        m6834p();
        return this.f4649k;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0742c
    /* renamed from: k */
    public C0970x mo6849k() {
        InterfaceC0740a mo6891a = m6848j().mo6891a("SourceFile");
        if (mo6891a instanceof C0697p) {
            return ((C0697p) mo6891a).m6509b();
        }
        return null;
    }

    /* renamed from: a */
    public InterfaceC0977e m6837a(int i, int i2) {
        if (i2 == 0) {
            return C0974b.f6209a;
        }
        if (this.f4642d == null) {
            throw new IllegalStateException("pool not yet initialized");
        }
        return new a(this.f4640b, i, i2, this.f4642d, this.f4651m);
    }

    /* renamed from: l */
    public int m6850l() {
        return this.f4640b.m8508c(0);
    }

    /* renamed from: m */
    public int m6851m() {
        return this.f4640b.m8512f(4);
    }

    /* renamed from: n */
    public int m6852n() {
        return this.f4640b.m8512f(6);
    }

    /* renamed from: o */
    private void m6833o() {
        if (this.f4643e == -1) {
            m6835q();
        }
    }

    /* renamed from: p */
    private void m6834p() {
        if (this.f4649k == null) {
            m6835q();
        }
    }

    /* renamed from: q */
    private void m6835q() {
        try {
            m6836r();
        } catch (C0748i e2) {
            e2.m8540a("...while parsing " + this.f4639a);
            throw e2;
        } catch (RuntimeException e3) {
            C0748i c0748i = new C0748i(e3);
            c0748i.m8540a("...while parsing " + this.f4639a);
            throw c0748i;
        }
    }

    /* renamed from: a */
    private boolean m6832a(int i, int i2, int i3) {
        if (i == -889275714 && i2 >= 0) {
            if (i3 == 50) {
                if (i2 <= 0) {
                    return true;
                }
            } else if (i3 < 50 && i3 >= 45) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    private void m6836r() {
        if (this.f4640b.m8502a() < 10) {
            throw new C0748i("severely truncated class file");
        }
        if (this.f4651m != null) {
            this.f4651m.m6900a(this.f4640b, 0, 0, "begin classfile");
            this.f4651m.m6900a(this.f4640b, 0, 4, "magic: " + C1022m.m8552a(m6850l()));
            this.f4651m.m6900a(this.f4640b, 4, 2, "minor_version: " + C1022m.m8557c(m6851m()));
            this.f4651m.m6900a(this.f4640b, 6, 2, "major_version: " + C1022m.m8557c(m6852n()));
        }
        if (this.f4641c && !m6832a(m6850l(), m6851m(), m6852n())) {
            throw new C0748i("bad class file magic (" + C1022m.m8552a(m6850l()) + ") or version (" + C1022m.m8557c(m6852n()) + "." + C1022m.m8557c(m6851m()) + ")");
        }
        C0729a c0729a = new C0729a(this.f4640b);
        c0729a.m6794a(this.f4651m);
        this.f4642d = c0729a.m6795b();
        this.f4642d.mo6683e_();
        int m6793a = c0729a.m6793a();
        int m8512f = this.f4640b.m8512f(m6793a);
        this.f4644f = (C0971y) this.f4642d.mo8038a(this.f4640b.m8512f(m6793a + 2));
        this.f4645g = (C0971y) this.f4642d.mo8039b(this.f4640b.m8512f(m6793a + 4));
        int m8512f2 = this.f4640b.m8512f(m6793a + 6);
        if (this.f4651m != null) {
            this.f4651m.m6900a(this.f4640b, m6793a, 2, "access_flags: " + C0919a.m7835a(m8512f));
            this.f4651m.m6900a(this.f4640b, m6793a + 2, 2, "this_class: " + this.f4644f);
            this.f4651m.m6900a(this.f4640b, m6793a + 4, 2, "super_class: " + m6831a(this.f4645g));
            this.f4651m.m6900a(this.f4640b, m6793a + 6, 2, "interfaces_count: " + C1022m.m8557c(m8512f2));
            if (m8512f2 != 0) {
                this.f4651m.m6900a(this.f4640b, m6793a + 8, 0, "interfaces:");
            }
        }
        int i = m6793a + 8;
        this.f4646h = m6837a(i, m8512f2);
        int i2 = (m8512f2 * 2) + i;
        if (this.f4641c) {
            String m8126i = this.f4644f.m8090i().m8126i();
            if (!this.f4639a.endsWith(".class") || !this.f4639a.startsWith(m8126i) || this.f4639a.length() != m8126i.length() + 6) {
                throw new C0748i("class name (" + m8126i + ") does not match path (" + this.f4639a + ")");
            }
        }
        this.f4643e = m8512f;
        C0736g c0736g = new C0736g(this, this.f4644f, i2, this.f4650l);
        c0736g.m6863a(this.f4651m);
        this.f4647i = c0736g.m6858a();
        C0738i c0738i = new C0738i(this, this.f4644f, c0736g.m6864d(), this.f4650l);
        c0738i.m6863a(this.f4651m);
        this.f4648j = c0738i.m6868a();
        C0732c c0732c = new C0732c(this, 0, c0738i.m6864d(), this.f4650l);
        c0732c.m6813a(this.f4651m);
        this.f4649k = c0732c.m6814b();
        this.f4649k.mo6683e_();
        int m6812a = c0732c.m6812a();
        if (m6812a != this.f4640b.m8502a()) {
            throw new C0748i("extra bytes at end of class file, at offset " + C1022m.m8552a(m6812a));
        }
        if (this.f4651m != null) {
            this.f4651m.m6900a(this.f4640b, m6812a, 0, "end classfile");
        }
    }

    /* compiled from: DirectClassFile.java */
    /* renamed from: com.b.b.a.d.f$a */
    private static class a implements InterfaceC0977e {

        /* renamed from: a */
        private final C1013d f4652a;

        /* renamed from: b */
        private final int f4653b;

        /* renamed from: c */
        private final C0972z f4654c;

        public a(C1013d c1013d, int i, int i2, C0972z c0972z, InterfaceC0749j interfaceC0749j) {
            if (i2 < 0) {
                throw new IllegalArgumentException("size < 0");
            }
            C1013d m8504a = c1013d.m8504a(i, (i2 * 2) + i);
            this.f4652a = m8504a;
            this.f4653b = i2;
            this.f4654c = c0972z;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 * 2;
                try {
                    C0971y c0971y = (C0971y) c0972z.mo8038a(m8504a.m8512f(i4));
                    if (interfaceC0749j != null) {
                        interfaceC0749j.m6900a(m8504a, i4, 2, "  " + c0971y);
                    }
                } catch (ClassCastException e2) {
                    throw new RuntimeException("bogus class cpi", e2);
                }
            }
        }

        @Override // com.p065b.p086b.p103f.p107d.InterfaceC0977e
        /* renamed from: d_ */
        public boolean mo6855d_() {
            return false;
        }

        @Override // com.p065b.p086b.p103f.p107d.InterfaceC0977e
        /* renamed from: f_ */
        public int mo6856f_() {
            return this.f4653b;
        }

        @Override // com.p065b.p086b.p103f.p107d.InterfaceC0977e
        /* renamed from: a */
        public C0975c mo6853a(int i) {
            return ((C0971y) this.f4654c.mo8038a(this.f4652a.m8512f(i * 2))).m8090i();
        }

        @Override // com.p065b.p086b.p103f.p107d.InterfaceC0977e
        /* renamed from: a */
        public InterfaceC0977e mo6854a(C0975c c0975c) {
            throw new UnsupportedOperationException("unsupported");
        }
    }
}
