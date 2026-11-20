package com.p065b.p086b.p095c.p099c;

import android.security.keystore.KeyProperties;
import com.p065b.p086b.p095c.C0765b;
import com.p065b.p086b.p095c.p099c.C0833ag;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0951e;
import com.p065b.p086b.p103f.p106c.C0956j;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1014e;
import com.p065b.p086b.p110h.C1019j;
import java.io.Writer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

/* compiled from: DexFile.java */
/* renamed from: com.b.b.c.c.m */
/* loaded from: classes.dex */
public final class C0860m {

    /* renamed from: a */
    private C0765b f5271a;

    /* renamed from: n */
    private final C0869v f5284n = new C0869v(this);

    /* renamed from: c */
    private final C0833ag f5273c = new C0833ag(null, this, 4, C0833ag.a.NONE);

    /* renamed from: b */
    private final C0833ag f5272b = new C0833ag("word_data", this, 4, C0833ag.a.TYPE);

    /* renamed from: e */
    private final C0833ag f5275e = new C0833ag("string_data", this, 1, C0833ag.a.INSTANCE);

    /* renamed from: l */
    private final C0833ag f5282l = new C0833ag(null, this, 1, C0833ag.a.NONE);

    /* renamed from: m */
    private final C0833ag f5283m = new C0833ag("byte_data", this, 1, C0833ag.a.TYPE);

    /* renamed from: f */
    private final C0842ap f5276f = new C0842ap(this);

    /* renamed from: g */
    private final C0844ar f5277g = new C0844ar(this);

    /* renamed from: h */
    private final C0837ak f5278h = new C0837ak(this);

    /* renamed from: i */
    private final C0867t f5279i = new C0867t(this);

    /* renamed from: j */
    private final C0832af f5280j = new C0832af(this);

    /* renamed from: k */
    private final C0856i f5281k = new C0856i(this);

    /* renamed from: d */
    private final C0833ag f5274d = new C0833ag("map", this, 4, C0833ag.a.NONE);

    /* renamed from: o */
    private final AbstractC0838al[] f5285o = {this.f5284n, this.f5276f, this.f5277g, this.f5278h, this.f5279i, this.f5280j, this.f5281k, this.f5272b, this.f5273c, this.f5275e, this.f5283m, this.f5282l, this.f5274d};

    /* renamed from: p */
    private int f5286p = -1;

    /* renamed from: q */
    private int f5287q = 79;

    public C0860m(C0765b c0765b) {
        this.f5271a = c0765b;
    }

    /* renamed from: a */
    public boolean m7395a() {
        return this.f5281k.mo7221a().isEmpty();
    }

    /* renamed from: b */
    public C0765b m7397b() {
        return this.f5271a;
    }

    /* renamed from: a */
    public void m7393a(C0855h c0855h) {
        this.f5281k.m7352a(c0855h);
    }

    /* renamed from: a */
    public C0855h m7391a(String str) {
        try {
            return (C0855h) this.f5281k.m7351a(new C0971y(C0975c.m8121c(str)));
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public byte[] m7396a(Writer writer, boolean z) {
        boolean z2 = writer != null;
        C1014e m7388a = m7388a(z2, z);
        if (z2) {
            m7388a.m8519a(writer);
        }
        return m7388a.m8525e();
    }

    /* renamed from: a */
    public void m7392a(int i) {
        if (i < 40) {
            throw new IllegalArgumentException("dumpWidth < 40");
        }
        this.f5287q = i;
    }

    /* renamed from: c */
    int m7399c() {
        if (this.f5286p < 0) {
            throw new RuntimeException("file size not yet known");
        }
        return this.f5286p;
    }

    /* renamed from: d */
    C0833ag m7400d() {
        return this.f5275e;
    }

    /* renamed from: e */
    C0833ag m7401e() {
        return this.f5272b;
    }

    /* renamed from: f */
    C0833ag m7402f() {
        return this.f5273c;
    }

    /* renamed from: g */
    C0833ag m7403g() {
        return this.f5274d;
    }

    /* renamed from: h */
    C0842ap m7404h() {
        return this.f5276f;
    }

    /* renamed from: i */
    C0856i m7405i() {
        return this.f5281k;
    }

    /* renamed from: j */
    C0833ag m7406j() {
        return this.f5282l;
    }

    /* renamed from: k */
    C0844ar m7407k() {
        return this.f5277g;
    }

    /* renamed from: l */
    C0837ak m7408l() {
        return this.f5278h;
    }

    /* renamed from: m */
    C0867t m7409m() {
        return this.f5279i;
    }

    /* renamed from: n */
    C0832af m7410n() {
        return this.f5280j;
    }

    /* renamed from: o */
    C0833ag m7411o() {
        return this.f5283m;
    }

    /* renamed from: p */
    AbstractC0838al m7412p() {
        return this.f5272b;
    }

    /* renamed from: q */
    AbstractC0838al m7413q() {
        return this.f5274d;
    }

    /* renamed from: a */
    void m7394a(AbstractC0945a abstractC0945a) {
        if (abstractC0945a instanceof C0970x) {
            this.f5276f.m7272a((C0970x) abstractC0945a);
            return;
        }
        if (abstractC0945a instanceof C0971y) {
            this.f5277g.m7276a((C0971y) abstractC0945a);
            return;
        }
        if (abstractC0945a instanceof AbstractC0951e) {
            this.f5280j.m7219a((AbstractC0951e) abstractC0945a);
            return;
        }
        if (abstractC0945a instanceof C0957k) {
            this.f5279i.m7429a((C0957k) abstractC0945a);
        } else if (abstractC0945a instanceof C0956j) {
            this.f5279i.m7429a(((C0956j) abstractC0945a).m8057i());
        } else if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
    }

    /* renamed from: b */
    AbstractC0871x m7398b(AbstractC0945a abstractC0945a) {
        if (abstractC0945a instanceof C0970x) {
            return this.f5276f.m7273a(abstractC0945a);
        }
        if (abstractC0945a instanceof C0971y) {
            return this.f5277g.m7278a(abstractC0945a);
        }
        if (abstractC0945a instanceof AbstractC0951e) {
            return this.f5280j.m7220a(abstractC0945a);
        }
        if (abstractC0945a instanceof C0957k) {
            return this.f5279i.m7430a(abstractC0945a);
        }
        return null;
    }

    /* renamed from: a */
    private C1014e m7388a(boolean z, boolean z2) {
        C1019j c1019j;
        this.f5281k.m7258h();
        this.f5282l.m7258h();
        this.f5272b.m7258h();
        this.f5283m.m7258h();
        this.f5280j.m7258h();
        this.f5279i.m7258h();
        this.f5278h.m7258h();
        this.f5273c.m7258h();
        this.f5277g.m7258h();
        this.f5276f.m7258h();
        this.f5275e.m7258h();
        this.f5284n.m7258h();
        int length = this.f5285o.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            AbstractC0838al abstractC0838al = this.f5285o[i];
            int m7251b = abstractC0838al.m7251b(i2);
            if (m7251b < i2) {
                throw new RuntimeException("bogus placement for section " + i);
            }
            try {
                if (abstractC0838al == this.f5274d) {
                    C0827aa.m7206a(this.f5285o, this.f5274d);
                    this.f5274d.m7258h();
                }
                if (abstractC0838al instanceof C0833ag) {
                    ((C0833ag) abstractC0838al).m7230d();
                }
                i++;
                i2 = m7251b + abstractC0838al.mo7231h_();
            } catch (RuntimeException e2) {
                throw C1019j.m8537a(e2, "...while writing section " + i);
            }
        }
        this.f5286p = i2;
        byte[] bArr = new byte[this.f5286p];
        C1014e c1014e = new C1014e(bArr);
        if (z) {
            c1014e.m8516a(this.f5287q, z2);
        }
        for (int i3 = 0; i3 < length; i3++) {
            try {
                AbstractC0838al abstractC0838al2 = this.f5285o[i3];
                int m7257g = abstractC0838al2.m7257g() - c1014e.mo8528g();
                if (m7257g < 0) {
                    throw new C1019j("excess write of " + (-m7257g));
                }
                c1014e.mo8529g(abstractC0838al2.m7257g() - c1014e.mo8528g());
                abstractC0838al2.m7253c(c1014e);
            } catch (RuntimeException e3) {
                if (e3 instanceof C1019j) {
                    c1019j = (C1019j) e3;
                } else {
                    c1019j = new C1019j(e3);
                }
                c1019j.m8540a("...while writing section " + i3);
                throw c1019j;
            }
        }
        if (c1014e.mo8528g() != this.f5286p) {
            throw new RuntimeException("foreshortened write");
        }
        m7389a(bArr);
        m7390b(bArr);
        if (z) {
            this.f5272b.m7226a(c1014e, EnumC0873z.TYPE_CODE_ITEM, "\nmethod code index:\n\n");
            m7414r().m7264a(c1014e);
            c1014e.m8530h();
        }
        return c1014e;
    }

    /* renamed from: r */
    public C0839am m7414r() {
        C0839am c0839am = new C0839am();
        for (AbstractC0838al abstractC0838al : this.f5285o) {
            c0839am.m7262a(abstractC0838al);
        }
        return c0839am;
    }

    /* renamed from: a */
    private static void m7389a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyProperties.DIGEST_SHA1);
            messageDigest.update(bArr, 32, bArr.length - 32);
            try {
                int digest = messageDigest.digest(bArr, 12, 20);
                if (digest != 20) {
                    throw new RuntimeException("unexpected digest write: " + digest + " bytes");
                }
            } catch (DigestException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: b */
    private static void m7390b(byte[] bArr) {
        Adler32 adler32 = new Adler32();
        adler32.update(bArr, 12, bArr.length - 12);
        int value = (int) adler32.getValue();
        bArr[8] = (byte) value;
        bArr[9] = (byte) (value >> 8);
        bArr[10] = (byte) (value >> 16);
        bArr[11] = (byte) (value >> 24);
    }
}
