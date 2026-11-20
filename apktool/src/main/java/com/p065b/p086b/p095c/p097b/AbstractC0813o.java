package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0963q;
import com.p065b.p086b.p103f.p106c.AbstractC0964r;
import com.p065b.p086b.p103f.p106c.C0961o;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.BitSet;

/* compiled from: InsnFormat.java */
/* renamed from: com.b.b.c.b.o */
/* loaded from: classes.dex */
public abstract class AbstractC0813o {

    /* renamed from: a */
    public static boolean f5063a = true;

    /* renamed from: a */
    public abstract int mo6969a();

    /* renamed from: a */
    public abstract String mo6970a(AbstractC0807i abstractC0807i);

    /* renamed from: a */
    public abstract void mo6971a(InterfaceC1007a interfaceC1007a, AbstractC0807i abstractC0807i);

    /* renamed from: b */
    public abstract String mo6973b(AbstractC0807i abstractC0807i, boolean z);

    /* renamed from: b */
    public abstract boolean mo6974b(AbstractC0807i abstractC0807i);

    /* renamed from: a */
    public final String m7097a(AbstractC0807i abstractC0807i, boolean z) {
        String m7060e = abstractC0807i.m7041h().m7060e();
        String mo6970a = mo6970a(abstractC0807i);
        String mo6973b = mo6973b(abstractC0807i, z);
        StringBuilder sb = new StringBuilder(100);
        sb.append(m7060e);
        if (mo6970a.length() != 0) {
            sb.append(' ');
            sb.append(mo6970a);
        }
        if (mo6973b.length() != 0) {
            sb.append(" // ");
            sb.append(mo6973b);
        }
        return sb.toString();
    }

    /* renamed from: c */
    public BitSet mo6975c(AbstractC0807i abstractC0807i) {
        return new BitSet();
    }

    /* renamed from: a */
    public boolean mo6972a(C0797ac c0797ac) {
        return false;
    }

    /* renamed from: a */
    protected static String m7068a(C0935q c0935q) {
        int f_ = c0935q.m8550f_();
        StringBuffer stringBuffer = new StringBuffer((f_ * 5) + 2);
        stringBuffer.append('{');
        for (int i = 0; i < f_; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(c0935q.m7949b(i).m7937m());
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: b */
    protected static String m7085b(C0935q c0935q) {
        int f_ = c0935q.m8550f_();
        StringBuilder sb = new StringBuilder(30);
        sb.append("{");
        switch (f_) {
            case 0:
                break;
            case 1:
                sb.append(c0935q.m7949b(0).m7937m());
                break;
            default:
                C0934p m7949b = c0935q.m7949b(f_ - 1);
                if (m7949b.m7935k() == 2) {
                    m7949b = m7949b.m7930c(1);
                }
                sb.append(c0935q.m7949b(0).m7937m());
                sb.append("..");
                sb.append(m7949b.m7937m());
                break;
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    protected static String m7069a(AbstractC0964r abstractC0964r) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('#');
        if (abstractC0964r instanceof C0961o) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(abstractC0964r.mo8036h());
            stringBuffer.append(' ');
            stringBuffer.append(abstractC0964r.mo6681d());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected static String m7070a(AbstractC0964r abstractC0964r, int i) {
        long mo8064j;
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("#");
        if (abstractC0964r instanceof AbstractC0963q) {
            mo8064j = ((AbstractC0963q) abstractC0964r).mo8065k();
        } else {
            mo8064j = abstractC0964r.mo8064j();
        }
        switch (i) {
            case 4:
                stringBuffer.append(C1022m.m8560f((int) mo8064j));
                break;
            case 8:
                stringBuffer.append(C1022m.m8559e((int) mo8064j));
                break;
            case 16:
                stringBuffer.append(C1022m.m8557c((int) mo8064j));
                break;
            case 32:
                stringBuffer.append(C1022m.m8552a((int) mo8064j));
                break;
            case 64:
                stringBuffer.append(C1022m.m8553a(mo8064j));
                break;
            default:
                throw new RuntimeException("shouldn't happen");
        }
        return stringBuffer.toString();
    }

    /* renamed from: d */
    protected static String m7089d(AbstractC0807i abstractC0807i) {
        int m6992d = ((C0797ac) abstractC0807i).m6992d();
        return m6992d == ((char) m6992d) ? C1022m.m8557c(m6992d) : C1022m.m8552a(m6992d);
    }

    /* renamed from: e */
    protected static String m7091e(AbstractC0807i abstractC0807i) {
        int m6993e = ((C0797ac) abstractC0807i).m6993e();
        return m6993e == ((short) m6993e) ? C1022m.m8562h(m6993e) : C1022m.m8561g(m6993e);
    }

    /* renamed from: f */
    protected static String m7093f(AbstractC0807i abstractC0807i) {
        AbstractC0945a m7018c = ((C0805g) abstractC0807i).m7018c();
        return m7018c instanceof C0970x ? ((C0970x) m7018c).m8083i() : m7018c.mo6681d();
    }

    /* renamed from: g */
    protected static String m7095g(AbstractC0807i abstractC0807i) {
        C0805g c0805g = (C0805g) abstractC0807i;
        if (!c0805g.m7020e()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(20);
        int m7019d = c0805g.m7019d();
        sb.append(c0805g.m7018c().mo8036h());
        sb.append('@');
        if (m7019d < 65536) {
            sb.append(C1022m.m8557c(m7019d));
        } else {
            sb.append(C1022m.m8552a(m7019d));
        }
        return sb.toString();
    }

    /* renamed from: a */
    protected static boolean m7083a(int i) {
        return i >= -8 && i <= 7;
    }

    /* renamed from: b */
    protected static boolean m7086b(int i) {
        return i == (i & 15);
    }

    /* renamed from: c */
    protected static boolean m7087c(int i) {
        return ((byte) i) == i;
    }

    /* renamed from: d */
    protected static boolean m7090d(int i) {
        return i == (i & 255);
    }

    /* renamed from: e */
    protected static boolean m7092e(int i) {
        return ((short) i) == i;
    }

    /* renamed from: f */
    protected static boolean m7094f(int i) {
        return i == (65535 & i);
    }

    /* renamed from: c */
    protected static boolean m7088c(C0935q c0935q) {
        int f_ = c0935q.m8550f_();
        if (f_ < 2) {
            return true;
        }
        int m7931g = c0935q.m7949b(0).m7931g();
        for (int i = 0; i < f_; i++) {
            C0934p m7949b = c0935q.m7949b(i);
            if (m7949b.m7931g() != m7931g) {
                return false;
            }
            m7931g += m7949b.m7935k();
        }
        return true;
    }

    /* renamed from: a */
    protected static short m7073a(AbstractC0807i abstractC0807i, int i) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("arg out of range 0..255");
        }
        int m7056a = abstractC0807i.m7041h().m7056a();
        if ((m7056a & 255) != m7056a) {
            throw new IllegalArgumentException("opcode out of range 0..255");
        }
        return (short) (m7056a | (i << 8));
    }

    /* renamed from: h */
    protected static short m7096h(AbstractC0807i abstractC0807i) {
        int m7056a = abstractC0807i.m7041h().m7056a();
        if (m7056a < 255 || m7056a > 65535) {
            throw new IllegalArgumentException("extended opcode out of range 255..65535");
        }
        return (short) m7056a;
    }

    /* renamed from: a */
    protected static short m7071a(int i, int i2) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("low out of range 0..255");
        }
        if ((i2 & 255) != i2) {
            throw new IllegalArgumentException("high out of range 0..255");
        }
        return (short) ((i2 << 8) | i);
    }

    /* renamed from: a */
    protected static short m7072a(int i, int i2, int i3, int i4) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("n0 out of range 0..15");
        }
        if ((i2 & 15) != i2) {
            throw new IllegalArgumentException("n1 out of range 0..15");
        }
        if ((i3 & 15) != i3) {
            throw new IllegalArgumentException("n2 out of range 0..15");
        }
        if ((i4 & 15) != i4) {
            throw new IllegalArgumentException("n3 out of range 0..15");
        }
        return (short) ((i2 << 4) | i | (i3 << 8) | (i4 << 12));
    }

    /* renamed from: b */
    protected static int m7084b(int i, int i2) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("low out of range 0..15");
        }
        if ((i2 & 15) != i2) {
            throw new IllegalArgumentException("high out of range 0..15");
        }
        return (i2 << 4) | i;
    }

    /* renamed from: a */
    protected static void m7074a(InterfaceC1007a interfaceC1007a, short s) {
        interfaceC1007a.mo8522b(s);
    }

    /* renamed from: a */
    protected static void m7079a(InterfaceC1007a interfaceC1007a, short s, short s2) {
        interfaceC1007a.mo8522b(s);
        interfaceC1007a.mo8522b(s2);
    }

    /* renamed from: a */
    protected static void m7080a(InterfaceC1007a interfaceC1007a, short s, short s2, short s3) {
        interfaceC1007a.mo8522b(s);
        interfaceC1007a.mo8522b(s2);
        interfaceC1007a.mo8522b(s3);
    }

    /* renamed from: a */
    protected static void m7081a(InterfaceC1007a interfaceC1007a, short s, short s2, short s3, short s4) {
        interfaceC1007a.mo8522b(s);
        interfaceC1007a.mo8522b(s2);
        interfaceC1007a.mo8522b(s3);
        interfaceC1007a.mo8522b(s4);
    }

    /* renamed from: a */
    protected static void m7082a(InterfaceC1007a interfaceC1007a, short s, short s2, short s3, short s4, short s5) {
        interfaceC1007a.mo8522b(s);
        interfaceC1007a.mo8522b(s2);
        interfaceC1007a.mo8522b(s3);
        interfaceC1007a.mo8522b(s4);
        interfaceC1007a.mo8522b(s5);
    }

    /* renamed from: a */
    protected static void m7075a(InterfaceC1007a interfaceC1007a, short s, int i) {
        m7080a(interfaceC1007a, s, (short) i, (short) (i >> 16));
    }

    /* renamed from: a */
    protected static void m7076a(InterfaceC1007a interfaceC1007a, short s, int i, short s2) {
        m7081a(interfaceC1007a, s, (short) i, (short) (i >> 16), s2);
    }

    /* renamed from: a */
    protected static void m7077a(InterfaceC1007a interfaceC1007a, short s, int i, short s2, short s3) {
        m7082a(interfaceC1007a, s, (short) i, (short) (i >> 16), s2, s3);
    }

    /* renamed from: a */
    protected static void m7078a(InterfaceC1007a interfaceC1007a, short s, long j) {
        m7082a(interfaceC1007a, s, (short) j, (short) (j >> 16), (short) (j >> 32), (short) (j >> 48));
    }
}
