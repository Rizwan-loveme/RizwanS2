package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p087a.p089b.C0709e;
import com.p065b.p086b.p087a.p089b.C0711g;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0966t;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1012c;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;

/* compiled from: BasicBlocker.java */
/* renamed from: com.b.b.a.b.b */
/* loaded from: classes.dex */
public final class C0706b implements C0711g.c {

    /* renamed from: a */
    private final C0712h f4504a;

    /* renamed from: b */
    private final int[] f4505b;

    /* renamed from: c */
    private final int[] f4506c;

    /* renamed from: d */
    private final int[] f4507d;

    /* renamed from: e */
    private final C1025p[] f4508e;

    /* renamed from: f */
    private final C0709e[] f4509f;

    /* renamed from: g */
    private int f4510g;

    /* renamed from: a */
    public static C0708d m6553a(C0712h c0712h) {
        C0706b c0706b = new C0706b(c0712h);
        c0706b.m6558c();
        return c0706b.m6556b();
    }

    private C0706b(C0712h c0712h) {
        if (c0712h == null) {
            throw new NullPointerException("method == null");
        }
        this.f4504a = c0712h;
        int m6599b = c0712h.m6613k().m6599b() + 1;
        this.f4505b = C1012c.m8489a(m6599b);
        this.f4506c = C1012c.m8489a(m6599b);
        this.f4507d = C1012c.m8489a(m6599b);
        this.f4508e = new C1025p[m6599b];
        this.f4509f = new C0709e[m6599b];
        this.f4510g = -1;
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6561a(int i, int i2, int i3) {
        m6554a(i2, i3, true);
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6566a(int i, int i2, int i3, C0975c c0975c) {
        switch (i) {
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 190:
            case 194:
            case 195:
                m6554a(i2, i3, true);
                m6557b(i2, i3, true);
                break;
            case 108:
            case 112:
                m6554a(i2, i3, true);
                if (c0975c == C0975c.f6251f || c0975c == C0975c.f6252g) {
                    m6557b(i2, i3, true);
                    break;
                }
                break;
            case 172:
            case 177:
                m6554a(i2, i3, false);
                this.f4508e[i2] = C1025p.f6502a;
                break;
            case 191:
                m6554a(i2, i3, false);
                m6557b(i2, i3, false);
                break;
            default:
                m6554a(i2, i3, true);
                break;
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6563a(int i, int i2, int i3, int i4, C0975c c0975c, int i5) {
        if (i == 169) {
            m6554a(i2, i3, false);
            this.f4508e[i2] = C1025p.f6502a;
        } else {
            m6554a(i2, i3, true);
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6565a(int i, int i2, int i3, AbstractC0945a abstractC0945a, int i4) {
        m6554a(i2, i3, true);
        if ((abstractC0945a instanceof AbstractC0966t) || (abstractC0945a instanceof C0971y) || (abstractC0945a instanceof C0970x)) {
            m6557b(i2, i3, true);
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6562a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 167:
                m6554a(i2, i3, false);
                this.f4508e[i2] = C1025p.m8565a(i4);
                break;
            case 168:
                m6555a(i2, true);
            default:
                int i5 = i2 + i3;
                m6554a(i2, i3, true);
                m6555a(i5, true);
                this.f4508e[i2] = C1025p.m8566a(i5, i4);
                break;
        }
        m6555a(i4, true);
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6564a(int i, int i2, int i3, C0727w c0727w, int i4) {
        m6554a(i2, i3, false);
        m6555a(c0727w.m6782b(), true);
        int m6779a = c0727w.m6779a();
        for (int i5 = 0; i5 < m6779a; i5++) {
            m6555a(c0727w.m6783b(i5), true);
        }
        this.f4508e[i2] = c0727w.m6785d();
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6567a(int i, int i2, C0971y c0971y, ArrayList<AbstractC0945a> arrayList) {
        m6554a(i, i2, true);
        m6557b(i, i2, true);
    }

    /* renamed from: b */
    private C0708d m6556b() {
        int i;
        C0709e c0709e;
        C0707c[] c0707cArr = new C0707c[this.f4504a.m6613k().m6599b()];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int m8494d = C1012c.m8494d(this.f4507d, i2 + 1);
            if (m8494d < 0) {
                break;
            }
            if (C1012c.m8487a(this.f4506c, i2)) {
                C1025p c1025p = null;
                int i4 = m8494d - 1;
                while (true) {
                    if (i4 < i2) {
                        i4 = -1;
                        break;
                    }
                    c1025p = this.f4508e[i4];
                    if (c1025p != null) {
                        break;
                    }
                    i4--;
                }
                if (c1025p == null) {
                    c1025p = C1025p.m8565a(m8494d);
                    c0709e = C0709e.f4516a;
                } else {
                    c0709e = this.f4509f[i4];
                    if (c0709e == null) {
                        c0709e = C0709e.f4516a;
                    }
                }
                c0707cArr[i3] = new C0707c(i2, i2, m8494d, c1025p, c0709e);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2 = m8494d;
            i3 = i;
        }
        C0708d c0708d = new C0708d(i3);
        for (int i5 = 0; i5 < i3; i5++) {
            c0708d.m6574a(i5, c0707cArr[i5]);
        }
        return c0708d;
    }

    /* renamed from: c */
    private void m6558c() {
        C0711g m6613k = this.f4504a.m6613k();
        C0709e m6614l = this.f4504a.m6614l();
        int f_ = m6614l.m8550f_();
        C1012c.m8490b(this.f4505b, 0);
        C1012c.m8490b(this.f4507d, 0);
        while (!C1012c.m8491b(this.f4505b)) {
            try {
                m6613k.m6598a(this.f4505b, this);
                for (int i = 0; i < f_; i++) {
                    C0709e.a m6578a = m6614l.m6578a(i);
                    int m6584a = m6578a.m6584a();
                    int m6586b = m6578a.m6586b();
                    if (C1012c.m8488a(this.f4506c, m6584a, m6586b)) {
                        C1012c.m8490b(this.f4507d, m6584a);
                        C1012c.m8490b(this.f4507d, m6586b);
                        m6555a(m6578a.m6587c(), true);
                    }
                }
            } catch (IllegalArgumentException e2) {
                throw new C0725u("flow of control falls off end of method", e2);
            }
        }
    }

    /* renamed from: a */
    private void m6555a(int i, boolean z) {
        if (!C1012c.m8487a(this.f4506c, i)) {
            C1012c.m8490b(this.f4505b, i);
        }
        if (z) {
            C1012c.m8490b(this.f4507d, i);
        }
    }

    /* renamed from: a */
    private void m6554a(int i, int i2, boolean z) {
        C1012c.m8490b(this.f4506c, i);
        if (z) {
            m6555a(i + i2, false);
        } else {
            C1012c.m8490b(this.f4507d, i + i2);
        }
    }

    /* renamed from: b */
    private void m6557b(int i, int i2, boolean z) {
        int i3 = i + i2;
        if (z) {
            m6555a(i3, true);
        }
        C0709e m6581b = this.f4504a.m6614l().m6581b(i);
        this.f4509f[i] = m6581b;
        C1025p[] c1025pArr = this.f4508e;
        if (!z) {
            i3 = -1;
        }
        c1025pArr[i] = m6581b.m6582c(i3);
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6560a(int i) {
        this.f4510g = i;
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public int mo6559a() {
        return this.f4510g;
    }
}
