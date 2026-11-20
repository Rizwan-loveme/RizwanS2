package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p095c.p097b.C0802d;
import com.p065b.p086b.p095c.p097b.C0803e;
import com.p065b.p086b.p095c.p097b.C0806h;
import com.p065b.p086b.p110h.C1014e;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: CatchStructs.java */
/* renamed from: com.b.b.c.c.f */
/* loaded from: classes.dex */
public final class C0853f {

    /* renamed from: a */
    private final C0806h f5219a;

    /* renamed from: b */
    private C0803e f5220b = null;

    /* renamed from: c */
    private byte[] f5221c = null;

    /* renamed from: d */
    private int f5222d = 0;

    /* renamed from: e */
    private TreeMap<C0802d, Integer> f5223e = null;

    public C0853f(C0806h c0806h) {
        this.f5219a = c0806h;
    }

    /* renamed from: c */
    private void m7318c() {
        if (this.f5220b == null) {
            this.f5220b = this.f5219a.m7029g();
        }
    }

    /* renamed from: a */
    public int m7319a() {
        m7318c();
        return this.f5220b.m8550f_();
    }

    /* renamed from: a */
    public void m7322a(PrintWriter printWriter, String str) {
        m7317a(str, printWriter, null);
    }

    /* renamed from: a */
    public void m7320a(C0860m c0860m) {
        int i;
        m7318c();
        C0844ar m7407k = c0860m.m7407k();
        int f_ = this.f5220b.m8550f_();
        this.f5223e = new TreeMap<>();
        for (int i2 = 0; i2 < f_; i2++) {
            this.f5223e.put(this.f5220b.m7010a(i2).m7015c(), null);
        }
        if (this.f5223e.size() > 65535) {
            throw new UnsupportedOperationException("too many catch handlers");
        }
        C1014e c1014e = new C1014e();
        this.f5222d = c1014e.mo8524e(this.f5223e.size());
        for (Map.Entry<C0802d, Integer> entry : this.f5223e.entrySet()) {
            C0802d key = entry.getKey();
            int f_2 = key.m8550f_();
            boolean m7005e = key.m7005e();
            entry.setValue(Integer.valueOf(c1014e.mo8528g()));
            if (m7005e) {
                c1014e.m8526f(-(f_2 - 1));
                i = f_2 - 1;
            } else {
                c1014e.m8526f(f_2);
                i = f_2;
            }
            for (int i3 = 0; i3 < i; i3++) {
                C0802d.a m7002a = key.m7002a(i3);
                c1014e.mo8524e(m7407k.m7279b(m7002a.m7007a()));
                c1014e.mo8524e(m7002a.m7008b());
            }
            if (m7005e) {
                c1014e.mo8524e(key.m7002a(i).m7008b());
            }
        }
        this.f5221c = c1014e.m8527f();
    }

    /* renamed from: b */
    public int m7323b() {
        return (m7319a() * 8) + this.f5221c.length;
    }

    /* renamed from: a */
    public void m7321a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        m7318c();
        if (interfaceC1007a.mo8460a()) {
            m7317a("  ", null, interfaceC1007a);
        }
        int f_ = this.f5220b.m8550f_();
        for (int i = 0; i < f_; i++) {
            C0803e.a m7010a = this.f5220b.m7010a(i);
            int m7012a = m7010a.m7012a();
            int m7014b = m7010a.m7014b();
            int i2 = m7014b - m7012a;
            if (i2 >= 65536) {
                throw new UnsupportedOperationException("bogus exception range: " + C1022m.m8552a(m7012a) + ".." + C1022m.m8552a(m7014b));
            }
            interfaceC1007a.mo8523d(m7012a);
            interfaceC1007a.mo8522b(i2);
            interfaceC1007a.mo8522b(this.f5223e.get(m7010a.m7015c()).intValue());
        }
        interfaceC1007a.mo8520a(this.f5221c);
    }

    /* renamed from: a */
    private void m7317a(String str, PrintWriter printWriter, InterfaceC1007a interfaceC1007a) {
        int i = 0;
        m7318c();
        boolean z = interfaceC1007a != null;
        int i2 = z ? 6 : 0;
        int i3 = z ? 2 : 0;
        int f_ = this.f5220b.m8550f_();
        String str2 = str + "  ";
        if (z) {
            interfaceC1007a.mo8458a(0, str + "tries:");
        } else {
            printWriter.println(str + "tries:");
        }
        for (int i4 = 0; i4 < f_; i4++) {
            C0803e.a m7010a = this.f5220b.m7010a(i4);
            C0802d m7015c = m7010a.m7015c();
            String str3 = str2 + "try " + C1022m.m8558d(m7010a.m7012a()) + ".." + C1022m.m8558d(m7010a.m7014b());
            String m7003a = m7015c.m7003a(str2, "");
            if (z) {
                interfaceC1007a.mo8458a(i2, str3);
                interfaceC1007a.mo8458a(i3, m7003a);
            } else {
                printWriter.println(str3);
                printWriter.println(m7003a);
            }
        }
        if (z) {
            interfaceC1007a.mo8458a(0, str + "handlers:");
            interfaceC1007a.mo8458a(this.f5222d, str2 + "size: " + C1022m.m8557c(this.f5223e.size()));
            C0802d c0802d = null;
            for (Map.Entry<C0802d, Integer> entry : this.f5223e.entrySet()) {
                C0802d key = entry.getKey();
                int intValue = entry.getValue().intValue();
                if (c0802d != null) {
                    m7316a(c0802d, i, intValue - i, str2, printWriter, interfaceC1007a);
                }
                c0802d = key;
                i = intValue;
            }
            m7316a(c0802d, i, this.f5221c.length - i, str2, printWriter, interfaceC1007a);
        }
    }

    /* renamed from: a */
    private static void m7316a(C0802d c0802d, int i, int i2, String str, PrintWriter printWriter, InterfaceC1007a interfaceC1007a) {
        String m7003a = c0802d.m7003a(str, C1022m.m8557c(i) + ": ");
        if (printWriter != null) {
            printWriter.println(m7003a);
        }
        interfaceC1007a.mo8458a(i2, m7003a);
    }
}
