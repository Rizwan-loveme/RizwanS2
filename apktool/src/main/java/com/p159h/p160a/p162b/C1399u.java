package com.p159h.p160a.p162b;

import com.p159h.p160a.p162b.AbstractC1381c;
import java.util.List;
import java.util.Vector;

/* compiled from: TextBuffer.java */
/* renamed from: com.h.a.b.u */
/* loaded from: classes.dex */
public class C1399u implements CharSequence {

    /* renamed from: a */
    protected char[] f9142a = new char[51];

    /* renamed from: b */
    protected int f9143b;

    /* renamed from: c */
    protected int f9144c;

    /* renamed from: d */
    protected int f9145d;

    /* renamed from: e */
    protected List<C1397s<AbstractC1381c.a>> f9146e;

    /* renamed from: f */
    private int f9147f;

    /* renamed from: g */
    private C1400v f9148g;

    /* renamed from: h */
    private C1402x f9149h;

    /* renamed from: i */
    private int f9150i;

    /* renamed from: a */
    private synchronized void m11137a() {
    }

    @Override // java.lang.CharSequence
    public int length() {
        return m11142d();
    }

    public C1399u() {
        this.f9142a[50] = 65535;
        this.f9147f = 1;
        this.f9143b = 0;
        this.f9144c = 50;
        this.f9145d = 1;
        this.f9148g = new C1400v();
        this.f9149h = new C1402x(this);
        this.f9150i = 1;
    }

    /* renamed from: g */
    public static int m11139g(int i) {
        long j = i + 50 + 1;
        if (j < Integer.MAX_VALUE) {
            return (int) j;
        }
        return -1;
    }

    /* renamed from: a */
    public synchronized void m11141a(char[] cArr, int i, int i2) {
        this.f9142a = cArr;
        m11156m(i);
        this.f9145d = i2;
        this.f9147f = 1;
        m11137a();
    }

    /* renamed from: h */
    public synchronized int m11146h(int i) {
        int intValue;
        if (i < 0) {
            intValue = -1;
        } else {
            C1397s<Integer> m11169a = this.f9148g.m11169a(i);
            int m11130a = m11169a.m11130a();
            intValue = m11169a.m11134b().intValue();
            if (i > m11130a) {
                intValue = m11136a(i, m11130a, intValue);
            } else if (i < m11130a) {
                intValue = m11138b(i, m11130a, intValue);
            }
            if (intValue >= 0) {
                this.f9148g.m11170a(i, intValue);
            }
        }
        return intValue;
    }

    /* renamed from: a */
    private int m11136a(int i, int i2, int i3) {
        int m11162p = m11162p(i3);
        C1401w.m11174a(m11161o(i3), "findCharOffsetBackward: Invalid startingOffset given");
        int i4 = i2;
        while (i4 < i && m11162p < this.f9142a.length) {
            if (this.f9142a[m11162p] == '\n') {
                i4++;
            }
            m11162p++;
            if (m11162p == this.f9143b) {
                m11162p = this.f9144c;
            }
        }
        if (i4 != i) {
            return -1;
        }
        return m11164q(m11162p);
    }

    /* renamed from: b */
    private int m11138b(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        C1401w.m11174a(m11161o(i3), "findCharOffsetBackward: Invalid startOffset given");
        int m11162p = m11162p(i3);
        while (i2 > i - 1 && m11162p >= 0) {
            if (m11162p == this.f9144c) {
                m11162p = this.f9143b;
            }
            m11162p--;
            if (this.f9142a[m11162p] == '\n') {
                i2--;
            }
        }
        if (m11162p >= 0) {
            return m11164q(m11162p) + 1;
        }
        C1401w.m11174a(false, "findCharOffsetBackward: Invalid cache entry or line arguments");
        return -1;
    }

    /* renamed from: i */
    public synchronized int m11148i(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (m11161o(i)) {
            C1397s<Integer> m11171b = this.f9148g.m11171b(i);
            int m11130a = m11171b.m11130a();
            int m11162p = m11162p(m11171b.m11134b().intValue());
            int m11162p2 = m11162p(i);
            if (m11162p2 > m11162p) {
                i2 = -1;
                i3 = -1;
                i4 = m11130a;
                while (m11162p < m11162p2 && m11162p < this.f9142a.length) {
                    if (this.f9142a[m11162p] == '\n') {
                        int i6 = i4 + 1;
                        i2 = m11164q(m11162p) + 1;
                        i3 = i6;
                        i5 = i6;
                    } else {
                        i5 = i4;
                    }
                    m11162p++;
                    if (m11162p == this.f9143b) {
                        m11162p = this.f9144c;
                        i4 = i5;
                    } else {
                        i4 = i5;
                    }
                }
            } else if (m11162p2 < m11162p) {
                i2 = -1;
                i3 = -1;
                i4 = m11130a;
                while (m11162p > m11162p2 && m11162p > 0) {
                    if (m11162p == this.f9144c) {
                        m11162p = this.f9143b;
                    }
                    m11162p--;
                    if (this.f9142a[m11162p] == '\n') {
                        i2 = m11164q(m11162p) + 1;
                        i3 = i4;
                        i4--;
                    }
                }
            } else {
                i2 = -1;
                i3 = -1;
                i4 = m11130a;
            }
            if (m11162p != m11162p2) {
                i4 = -1;
            } else if (i3 != -1) {
                this.f9148g.m11170a(i3, i2);
            }
        } else {
            i4 = -1;
        }
        return i4;
    }

    @Override // java.lang.CharSequence
    public synchronized char charAt(int i) {
        return this.f9142a[m11162p(i)];
    }

    @Override // java.lang.CharSequence
    public synchronized CharSequence subSequence(int i, int i2) {
        String str;
        if (!m11161o(i) || i2 <= 0) {
            str = new String();
        } else {
            if (i + i2 > m11142d()) {
                i2 = m11142d() - i;
            }
            int m11162p = m11162p(i);
            char[] cArr = new char[i2];
            int i3 = 0;
            while (i3 < i2) {
                cArr[i3] = this.f9142a[m11162p];
                int i4 = m11162p + 1;
                if (i4 == this.f9143b) {
                    i4 = this.f9144c;
                }
                i3++;
                m11162p = i4;
            }
            str = new String(cArr);
        }
        return str;
    }

    /* renamed from: j */
    char[] m11151j(int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f9143b + i2;
            if (i3 >= this.f9142a.length) {
                break;
            }
            cArr[i2] = this.f9142a[i3];
        }
        return cArr;
    }

    /* renamed from: a */
    public synchronized void mo11024a(char[] cArr, int i, long j, boolean z) {
        if (z) {
            this.f9149h.m11180a(i, cArr.length, j);
        }
        int m11162p = m11162p(i);
        if (m11162p != this.f9144c) {
            if (m11165r(m11162p)) {
                m11153k(m11162p);
            } else {
                m11154l(m11162p);
            }
        }
        if (cArr.length >= m11144f()) {
            m11159n(cArr.length - m11144f());
        }
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (cArr[i2] == '\n') {
                this.f9145d++;
            }
            this.f9142a[this.f9143b] = cArr[i2];
            this.f9143b++;
        }
        this.f9148g.m11172c(i);
        m11137a();
    }

    /* renamed from: a */
    public synchronized void mo11020a(int i, int i2, long j, boolean z) {
        if (z) {
            this.f9149h.m11182b(i, i2, j);
        }
        int i3 = i + i2;
        if (i3 != this.f9143b) {
            if (m11165r(i3)) {
                m11153k(i3);
            } else {
                m11154l(i3 + m11144f());
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f9143b--;
            if (this.f9142a[this.f9143b] == '\n') {
                this.f9145d--;
            }
        }
        this.f9148g.m11172c(i);
        m11137a();
    }

    /* renamed from: a */
    synchronized void mo11019a(int i) {
        if (i >= 0) {
            this.f9145d += m11135a(this.f9143b, i);
        } else {
            this.f9145d -= m11135a(this.f9143b + i, -i);
        }
        this.f9143b += i;
        this.f9148g.m11172c(m11164q(this.f9143b - 1) + 1);
        m11137a();
    }

    /* renamed from: a */
    private int m11135a(int i, int i2) {
        int i3 = 0;
        if (i >= 0) {
            for (int i4 = i; i4 < i + i2; i4++) {
                if (this.f9142a[i4] == '\n') {
                    i3++;
                }
            }
        }
        return i3;
    }

    /* renamed from: k */
    protected final void m11153k(int i) {
        if (this.f9143b < 0) {
            this.f9143b = 0;
        }
        if (this.f9144c < 0) {
            this.f9144c = 0;
        }
        while (this.f9143b > i) {
            this.f9144c--;
            this.f9143b--;
            this.f9142a[this.f9144c] = this.f9142a[this.f9143b];
        }
    }

    /* renamed from: l */
    protected final void m11154l(int i) {
        if (this.f9143b < 0) {
            this.f9143b = 0;
        }
        if (this.f9144c < 0) {
            this.f9144c = 0;
        }
        while (this.f9144c < i) {
            this.f9142a[this.f9143b] = this.f9142a[this.f9144c];
            this.f9143b++;
            this.f9144c++;
        }
    }

    /* renamed from: m */
    protected void m11156m(int i) {
        int length = this.f9142a.length - 1;
        int i2 = length - 1;
        this.f9142a[length] = 65535;
        int i3 = i - 1;
        int i4 = i2;
        while (i3 >= 0) {
            this.f9142a[i4] = this.f9142a[i3];
            i3--;
            i4--;
        }
        this.f9143b = 0;
        this.f9144c = i4 + 1;
    }

    /* renamed from: n */
    protected void m11159n(int i) {
        int i2 = i + (this.f9147f * 50);
        char[] cArr = new char[this.f9142a.length + i2];
        for (int i3 = 0; i3 < this.f9143b; i3++) {
            cArr[i3] = this.f9142a[i3];
        }
        for (int i4 = this.f9144c; i4 < this.f9142a.length; i4++) {
            cArr[i4 + i2] = this.f9142a[i4];
        }
        this.f9144c += i2;
        this.f9142a = cArr;
        this.f9147f <<= 1;
    }

    /* renamed from: d */
    public final synchronized int m11142d() {
        return this.f9142a.length - m11144f();
    }

    /* renamed from: e */
    public synchronized int m11143e() {
        return this.f9145d;
    }

    /* renamed from: o */
    public final synchronized boolean m11161o(int i) {
        int m11142d;
        m11142d = m11142d();
        return (i == 0 && m11142d == 0) || (i >= 0 && i < m11142d);
    }

    /* renamed from: f */
    protected final int m11144f() {
        return this.f9144c - this.f9143b;
    }

    /* renamed from: p */
    protected final int m11162p(int i) {
        return m11165r(i) ? i : i + m11144f();
    }

    /* renamed from: q */
    protected final int m11164q(int i) {
        return m11165r(i) ? i : i - m11144f();
    }

    /* renamed from: r */
    protected final boolean m11165r(int i) {
        return i < this.f9143b;
    }

    /* renamed from: g */
    public void m11145g() {
        this.f9146e = new Vector();
        this.f9146e.add(new C1397s<>(0, AbstractC1381c.a.f9005k));
    }

    /* renamed from: h */
    public List<C1397s<AbstractC1381c.a>> m11147h() {
        return this.f9146e;
    }

    /* renamed from: a */
    public void m11140a(List<C1397s<AbstractC1381c.a>> list) {
        this.f9146e = list;
    }

    /* renamed from: i */
    public boolean m11149i() {
        return this.f9149h.m11186f();
    }

    /* renamed from: j */
    public void m11150j() {
        this.f9149h.m11187g();
    }

    /* renamed from: k */
    public void m11152k() {
        this.f9149h.m11188h();
    }

    /* renamed from: l */
    public boolean m11155l() {
        return this.f9149h.m11184d();
    }

    /* renamed from: m */
    public boolean m11157m() {
        return this.f9149h.m11185e();
    }

    /* renamed from: n */
    public int m11158n() {
        return this.f9149h.m11179a();
    }

    /* renamed from: o */
    public int m11160o() {
        return this.f9149h.m11181b();
    }

    /* renamed from: p */
    public void m11163p() {
        this.f9149h.m11183c();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        int m11142d = m11142d();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < m11142d; i++) {
            char charAt = charAt(i);
            if (charAt == 65535) {
                break;
            }
            stringBuffer.append(charAt);
        }
        return new String(stringBuffer);
    }
}
