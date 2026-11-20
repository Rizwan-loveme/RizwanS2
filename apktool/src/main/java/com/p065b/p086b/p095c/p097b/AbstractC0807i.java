package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p110h.C1008aa;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.BitSet;

/* compiled from: DalvInsn.java */
/* renamed from: com.b.b.c.b.i */
/* loaded from: classes.dex */
public abstract class AbstractC0807i {

    /* renamed from: a */
    private int f4793a;

    /* renamed from: b */
    private final C0809k f4794b;

    /* renamed from: c */
    private final C0940v f4795c;

    /* renamed from: d */
    private final C0935q f4796d;

    /* renamed from: a */
    public abstract int mo6964a();

    /* renamed from: a */
    public abstract AbstractC0807i mo6990a(C0809k c0809k);

    /* renamed from: a */
    public abstract AbstractC0807i mo6965a(C0935q c0935q);

    /* renamed from: a */
    protected abstract String mo6966a(boolean z);

    /* renamed from: a */
    public abstract void mo6967a(InterfaceC1007a interfaceC1007a);

    /* renamed from: b */
    protected abstract String mo6968b();

    /* renamed from: d */
    public abstract AbstractC0807i mo6995d(int i);

    /* renamed from: a */
    public static C0824z m7032a(C0940v c0940v, C0934p c0934p, C0934p c0934p2) {
        C0809k c0809k;
        boolean z = c0934p.m7935k() == 1;
        boolean m8132o = c0934p.mo6695a().m8132o();
        int m7931g = c0934p.m7931g();
        if ((c0934p2.m7931g() | m7931g) < 16) {
            if (m8132o) {
                c0809k = C0810l.f5044i;
            } else {
                c0809k = z ? C0810l.f4935c : C0810l.f5041f;
            }
        } else if (m7931g < 256) {
            c0809k = m8132o ? C0810l.f5045j : z ? C0810l.f4988d : C0810l.f5042g;
        } else {
            c0809k = m8132o ? C0810l.f5046k : z ? C0810l.f5040e : C0810l.f5043h;
        }
        return new C0824z(c0809k, c0940v, C0935q.m7945a(c0934p, c0934p2));
    }

    public AbstractC0807i(C0809k c0809k, C0940v c0940v, C0935q c0935q) {
        if (c0809k == null) {
            throw new NullPointerException("opcode == null");
        }
        if (c0940v == null) {
            throw new NullPointerException("position == null");
        }
        if (c0935q == null) {
            throw new NullPointerException("registers == null");
        }
        this.f4793a = -1;
        this.f4794b = c0809k;
        this.f4795c = c0940v;
        this.f4796d = c0935q;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(m7046m());
        stringBuffer.append(' ');
        stringBuffer.append(this.f4795c);
        stringBuffer.append(": ");
        stringBuffer.append(this.f4794b.m7060e());
        boolean z = false;
        if (this.f4796d.m8550f_() != 0) {
            stringBuffer.append(this.f4796d.m8547b(" ", ", ", null));
            z = true;
        }
        String mo6968b = mo6968b();
        if (mo6968b != null) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append(' ');
            stringBuffer.append(mo6968b);
        }
        return stringBuffer.toString();
    }

    /* renamed from: f */
    public final boolean m7039f() {
        return this.f4793a >= 0;
    }

    /* renamed from: g */
    public final int m7040g() {
        if (this.f4793a < 0) {
            throw new RuntimeException("address not yet known");
        }
        return this.f4793a;
    }

    /* renamed from: h */
    public final C0809k m7041h() {
        return this.f4794b;
    }

    /* renamed from: i */
    public final C0940v m7042i() {
        return this.f4795c;
    }

    /* renamed from: j */
    public final C0935q m7043j() {
        return this.f4796d;
    }

    /* renamed from: k */
    public final boolean m7044k() {
        return this.f4794b.m7059d();
    }

    /* renamed from: a */
    public final int m7033a(BitSet bitSet) {
        int i = 0;
        boolean m7044k = m7044k();
        int f_ = this.f4796d.m8550f_();
        int m7935k = (!m7044k || bitSet.get(0)) ? 0 : this.f4796d.m7949b(0).m7935k();
        int i2 = m7044k ? 1 : 0;
        while (i2 < f_) {
            int m7935k2 = !bitSet.get(i2) ? this.f4796d.m7949b(i2).m7935k() + i : i;
            i2++;
            i = m7935k2;
        }
        return Math.max(i, m7935k);
    }

    /* renamed from: l */
    public AbstractC0807i m7045l() {
        return mo6965a(this.f4796d.m7946a(0, m7044k(), (BitSet) null));
    }

    /* renamed from: b */
    public AbstractC0807i m7035b(BitSet bitSet) {
        C0935q c0935q = this.f4796d;
        boolean z = bitSet.get(0);
        if (m7044k()) {
            bitSet.set(0);
        }
        C0935q m7947a = c0935q.m7947a(bitSet);
        if (m7044k()) {
            bitSet.set(0, z);
        }
        if (m7947a.m8550f_() == 0) {
            return null;
        }
        return new C0812n(this.f4795c, m7947a);
    }

    /* renamed from: c */
    public AbstractC0807i m7036c(BitSet bitSet) {
        if (!m7044k() || bitSet.get(0)) {
            return null;
        }
        C0934p m7949b = this.f4796d.m7949b(0);
        return m7032a(this.f4795c, m7949b, m7949b.m7927b(0));
    }

    /* renamed from: d */
    public AbstractC0807i m7038d(BitSet bitSet) {
        return mo6965a(this.f4796d.m7946a(0, m7044k(), bitSet));
    }

    /* renamed from: m */
    public final String m7046m() {
        return this.f4793a != -1 ? String.format("%04x", Integer.valueOf(this.f4793a)) : C1022m.m8552a(System.identityHashCode(this));
    }

    /* renamed from: a */
    public final String m7034a(String str, int i, boolean z) {
        String mo6966a = mo6966a(z);
        if (mo6966a == null) {
            return null;
        }
        String str2 = str + m7046m() + ": ";
        int length = str2.length();
        return C1008aa.m8464a(str2, length, "", mo6966a, i == 0 ? mo6966a.length() : i - length);
    }

    /* renamed from: c */
    public final void m7037c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        }
        this.f4793a = i;
    }

    /* renamed from: n */
    public final int m7047n() {
        return m7040g() + mo6964a();
    }
}
