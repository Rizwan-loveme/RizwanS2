package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0914a;
import com.p065b.p086b.p103f.p104a.C0918e;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0964r;
import com.p065b.p086b.p103f.p106c.C0949c;
import com.p065b.p086b.p103f.p106c.C0950d;
import com.p065b.p086b.p103f.p106c.C0952f;
import com.p065b.p086b.p103f.p106c.C0953g;
import com.p065b.p086b.p103f.p106c.C0954h;
import com.p065b.p086b.p103f.p106c.C0955i;
import com.p065b.p086b.p103f.p106c.C0956j;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0958l;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0961o;
import com.p065b.p086b.p103f.p106c.C0965s;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0969w;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;

/* compiled from: ValueEncoder.java */
/* renamed from: com.b.b.c.c.av */
/* loaded from: classes.dex */
public final class C0848av {

    /* renamed from: a */
    private final C0860m f5200a;

    /* renamed from: b */
    private final InterfaceC1007a f5201b;

    public C0848av(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        if (c0860m == null) {
            throw new NullPointerException("file == null");
        }
        if (interfaceC1007a == null) {
            throw new NullPointerException("out == null");
        }
        this.f5200a = c0860m;
        this.f5201b = interfaceC1007a;
    }

    /* renamed from: a */
    public void m7295a(AbstractC0945a abstractC0945a) {
        int m7292c = m7292c(abstractC0945a);
        switch (m7292c) {
            case 0:
            case 2:
            case 4:
            case 6:
                m7287a(m7292c, ((AbstractC0964r) abstractC0945a).mo8065k());
                return;
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            default:
                throw new RuntimeException("Shouldn't happen");
            case 3:
                m7291b(m7292c, ((AbstractC0964r) abstractC0945a).mo8065k());
                return;
            case 16:
                m7293c(m7292c, ((C0958l) abstractC0945a).mo8065k() << 32);
                return;
            case 17:
                m7293c(m7292c, ((C0955i) abstractC0945a).mo8065k());
                return;
            case 23:
                m7291b(m7292c, this.f5200a.m7404h().m7274b((C0970x) abstractC0945a));
                return;
            case 24:
                m7291b(m7292c, this.f5200a.m7407k().m7279b((C0971y) abstractC0945a));
                return;
            case 25:
                m7291b(m7292c, this.f5200a.m7409m().m7432b((C0957k) abstractC0945a));
                return;
            case 26:
                m7291b(m7292c, this.f5200a.m7410n().m7223b((C0967u) abstractC0945a));
                return;
            case 27:
                m7291b(m7292c, this.f5200a.m7409m().m7432b(((C0956j) abstractC0945a).m8057i()));
                return;
            case 28:
                this.f5201b.mo7631c(m7292c);
                m7296a((C0950d) abstractC0945a, false);
                return;
            case 29:
                this.f5201b.mo7631c(m7292c);
                m7294a(((C0949c) abstractC0945a).m8040a(), false);
                return;
            case 30:
                this.f5201b.mo7631c(m7292c);
                return;
            case 31:
                this.f5201b.mo7631c(m7292c | (((C0952f) abstractC0945a).mo8064j() << 5));
                return;
        }
    }

    /* renamed from: c */
    private static int m7292c(AbstractC0945a abstractC0945a) {
        if (abstractC0945a instanceof C0953g) {
            return 0;
        }
        if (abstractC0945a instanceof C0969w) {
            return 2;
        }
        if (abstractC0945a instanceof C0954h) {
            return 3;
        }
        if (abstractC0945a instanceof C0959m) {
            return 4;
        }
        if (abstractC0945a instanceof C0965s) {
            return 6;
        }
        if (abstractC0945a instanceof C0958l) {
            return 16;
        }
        if (abstractC0945a instanceof C0955i) {
            return 17;
        }
        if (abstractC0945a instanceof C0970x) {
            return 23;
        }
        if (abstractC0945a instanceof C0971y) {
            return 24;
        }
        if (abstractC0945a instanceof C0957k) {
            return 25;
        }
        if (abstractC0945a instanceof C0967u) {
            return 26;
        }
        if (abstractC0945a instanceof C0956j) {
            return 27;
        }
        if (abstractC0945a instanceof C0950d) {
            return 28;
        }
        if (abstractC0945a instanceof C0949c) {
            return 29;
        }
        if (abstractC0945a instanceof C0961o) {
            return 30;
        }
        if (abstractC0945a instanceof C0952f) {
            return 31;
        }
        throw new RuntimeException("Shouldn't happen");
    }

    /* renamed from: a */
    public void m7296a(C0950d c0950d, boolean z) {
        boolean z2 = z && this.f5201b.mo8460a();
        C0950d.a m8041a = c0950d.m8041a();
        int f_ = m8041a.m8550f_();
        if (z2) {
            this.f5201b.mo8459a("  size: " + C1022m.m8552a(f_));
        }
        this.f5201b.mo8524e(f_);
        for (int i = 0; i < f_; i++) {
            AbstractC0945a m8043a = m8041a.m8043a(i);
            if (z2) {
                this.f5201b.mo8459a("  [" + Integer.toHexString(i) + "] " + m7290b(m8043a));
            }
            m7295a(m8043a);
        }
        if (z2) {
            this.f5201b.mo8462c();
        }
    }

    /* renamed from: a */
    public void m7294a(C0914a c0914a, boolean z) {
        int i;
        boolean z2 = z && this.f5201b.mo8460a();
        C0842ap m7404h = this.f5200a.m7404h();
        C0844ar m7407k = this.f5200a.m7407k();
        C0971y m7818b = c0914a.m7818b();
        int m7279b = m7407k.m7279b(m7818b);
        if (z2) {
            this.f5201b.mo8459a("  type_idx: " + C1022m.m8552a(m7279b) + " // " + m7818b.mo6681d());
        }
        this.f5201b.mo8524e(m7407k.m7279b(c0914a.m7818b()));
        Collection<C0918e> m7821f = c0914a.m7821f();
        int size = m7821f.size();
        if (z2) {
            this.f5201b.mo8459a("  size: " + C1022m.m8552a(size));
        }
        this.f5201b.mo8524e(size);
        int i2 = 0;
        for (C0918e c0918e : m7821f) {
            C0970x m7833a = c0918e.m7833a();
            int m7274b = m7404h.m7274b(m7833a);
            AbstractC0945a m7834b = c0918e.m7834b();
            if (z2) {
                this.f5201b.mo8458a(0, "  elements[" + i2 + "]:");
                i = i2 + 1;
                this.f5201b.mo8459a("    name_idx: " + C1022m.m8552a(m7274b) + " // " + m7833a.mo6681d());
            } else {
                i = i2;
            }
            this.f5201b.mo8524e(m7274b);
            if (z2) {
                this.f5201b.mo8459a("    value: " + m7290b(m7834b));
            }
            m7295a(m7834b);
            i2 = i;
        }
        if (z2) {
            this.f5201b.mo8462c();
        }
    }

    /* renamed from: b */
    public static String m7290b(AbstractC0945a abstractC0945a) {
        if (m7292c(abstractC0945a) == 30) {
            return "null";
        }
        return abstractC0945a.mo8036h() + ' ' + abstractC0945a.mo6681d();
    }

    /* renamed from: a */
    private void m7287a(int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j >> 63) ^ j)) + 7) >> 3;
        this.f5201b.mo7631c(((numberOfLeadingZeros - 1) << 5) | i);
        while (numberOfLeadingZeros > 0) {
            this.f5201b.mo7631c((byte) j);
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    /* renamed from: b */
    private void m7291b(int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        int i2 = (numberOfLeadingZeros + 7) >> 3;
        this.f5201b.mo7631c(((i2 - 1) << 5) | i);
        while (i2 > 0) {
            this.f5201b.mo7631c((byte) j);
            j >>= 8;
            i2--;
        }
    }

    /* renamed from: c */
    private void m7293c(int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        int i2 = (numberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (i2 * 8));
        this.f5201b.mo7631c(((i2 - 1) << 5) | i);
        while (i2 > 0) {
            this.f5201b.mo7631c((byte) j2);
            j2 >>= 8;
            i2--;
        }
    }

    /* renamed from: a */
    public static void m7288a(C0860m c0860m, C0914a c0914a) {
        C0844ar m7407k = c0860m.m7407k();
        C0842ap m7404h = c0860m.m7404h();
        m7407k.m7276a(c0914a.m7818b());
        for (C0918e c0918e : c0914a.m7821f()) {
            m7404h.m7272a(c0918e.m7833a());
            m7289a(c0860m, c0918e.m7834b());
        }
    }

    /* renamed from: a */
    public static void m7289a(C0860m c0860m, AbstractC0945a abstractC0945a) {
        if (abstractC0945a instanceof C0949c) {
            m7288a(c0860m, ((C0949c) abstractC0945a).m8040a());
            return;
        }
        if (abstractC0945a instanceof C0950d) {
            C0950d.a m8041a = ((C0950d) abstractC0945a).m8041a();
            int f_ = m8041a.m8550f_();
            for (int i = 0; i < f_; i++) {
                m7289a(c0860m, m8041a.m8043a(i));
            }
            return;
        }
        c0860m.m7394a(abstractC0945a);
    }
}
