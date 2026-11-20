package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: SwitchData.java */
/* renamed from: com.b.b.c.b.ab */
/* loaded from: classes.dex */
public final class C0796ab extends AbstractC0798ad {

    /* renamed from: a */
    private final C0804f f4768a;

    /* renamed from: b */
    private final C1025p f4769b;

    /* renamed from: c */
    private final C0804f[] f4770c;

    /* renamed from: d */
    private final boolean f4771d;

    public C0796ab(C0940v c0940v, C0804f c0804f, C1025p c1025p, C0804f[] c0804fArr) {
        super(c0940v, C0935q.f5906a);
        if (c0804f == null) {
            throw new NullPointerException("user == null");
        }
        if (c1025p == null) {
            throw new NullPointerException("cases == null");
        }
        if (c0804fArr == null) {
            throw new NullPointerException("targets == null");
        }
        int m8568b = c1025p.m8568b();
        if (m8568b != c0804fArr.length) {
            throw new IllegalArgumentException("cases / targets mismatch");
        }
        if (m8568b > 65535) {
            throw new IllegalArgumentException("too many cases");
        }
        this.f4768a = c0804f;
        this.f4769b = c1025p;
        this.f4770c = c0804fArr;
        this.f4771d = m6987c(c1025p);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public int mo6964a() {
        return this.f4771d ? (int) m6985a(this.f4769b) : (int) m6986b(this.f4769b);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public void mo6967a(InterfaceC1007a interfaceC1007a) {
        int g;
        int i;
        int g2 = this.f4768a.m7040g();
        int mo6969a = C0810l.f4821S.m7058c().mo6969a();
        int length = this.f4770c.length;
        if (this.f4771d) {
            int m8569b = length == 0 ? 0 : this.f4769b.m8569b(0);
            int m8569b2 = ((length == 0 ? 0 : this.f4769b.m8569b(length - 1)) - m8569b) + 1;
            interfaceC1007a.mo8522b(256);
            interfaceC1007a.mo8522b(m8569b2);
            interfaceC1007a.mo8523d(m8569b);
            int i2 = 0;
            int i3 = 0;
            while (i2 < m8569b2) {
                if (this.f4769b.m8569b(i3) > m8569b + i2) {
                    g = mo6969a;
                    i = i3;
                } else {
                    g = this.f4770c[i3].m7040g() - g2;
                    i = i3 + 1;
                }
                interfaceC1007a.mo8523d(g);
                i2++;
                i3 = i;
            }
            return;
        }
        interfaceC1007a.mo8522b(512);
        interfaceC1007a.mo8522b(length);
        for (int i4 = 0; i4 < length; i4++) {
            interfaceC1007a.mo8523d(this.f4769b.m8569b(i4));
        }
        for (int i5 = 0; i5 < length; i5++) {
            interfaceC1007a.mo8523d(this.f4770c[i5].m7040g() - g2);
        }
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0796ab(m7042i(), this.f4768a, this.f4769b, this.f4770c);
    }

    /* renamed from: c */
    public boolean m6988c() {
        return this.f4771d;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.f4770c.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(this.f4769b.m8569b(i));
            stringBuffer.append(": ");
            stringBuffer.append(this.f4770c[i]);
        }
        return stringBuffer.toString();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    protected String mo6966a(boolean z) {
        int g = this.f4768a.m7040g();
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.f4770c.length;
        stringBuffer.append(this.f4771d ? "packed" : "sparse");
        stringBuffer.append("-switch-payload // for switch @ ");
        stringBuffer.append(C1022m.m8557c(g));
        for (int i = 0; i < length; i++) {
            int g2 = this.f4770c[i].m7040g();
            stringBuffer.append("\n  ");
            stringBuffer.append(this.f4769b.m8569b(i));
            stringBuffer.append(": ");
            stringBuffer.append(C1022m.m8552a(g2));
            stringBuffer.append(" // ");
            stringBuffer.append(C1022m.m8561g(g2 - g));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static long m6985a(C1025p c1025p) {
        int m8568b = c1025p.m8568b();
        long m8569b = (((c1025p.m8569b(m8568b - 1) - c1025p.m8569b(0)) + 1) * 2) + 4;
        if (m8569b <= 2147483647L) {
            return m8569b;
        }
        return -1L;
    }

    /* renamed from: b */
    private static long m6986b(C1025p c1025p) {
        return (c1025p.m8568b() * 4) + 2;
    }

    /* renamed from: c */
    private static boolean m6987c(C1025p c1025p) {
        if (c1025p.m8568b() < 2) {
            return true;
        }
        long m6985a = m6985a(c1025p);
        return m6985a >= 0 && m6985a <= (m6986b(c1025p) * 5) / 4;
    }
}
