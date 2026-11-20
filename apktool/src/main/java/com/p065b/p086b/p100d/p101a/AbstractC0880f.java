package com.p065b.p086b.p100d.p101a;

import com.p065b.p086b.p100d.C0905m;
import com.p065b.p086b.p100d.C0906n;
import com.p065b.p086b.p100d.EnumC0903k;
import com.p065b.p086b.p110h.C1018i;
import com.p065b.p086b.p110h.C1022m;
import java.p209io.EOFException;

/* compiled from: DecodedInstruction.java */
/* renamed from: com.b.b.d.a.f */
/* loaded from: classes.dex */
public abstract class AbstractC0880f {

    /* renamed from: a */
    private final EnumC0884j f5334a;

    /* renamed from: b */
    private final int f5335b;

    /* renamed from: c */
    private final int f5336c;

    /* renamed from: d */
    private final EnumC0903k f5337d;

    /* renamed from: e */
    private final int f5338e;

    /* renamed from: f */
    private final long f5339f;

    /* renamed from: d */
    public abstract AbstractC0880f mo7476d(int i);

    /* renamed from: m */
    public abstract int mo7485m();

    /* renamed from: a */
    public static AbstractC0880f m7466a(InterfaceC0878d interfaceC0878d) {
        int mo7453c = interfaceC0878d.mo7453c();
        return C0905m.m7687c(C0906n.m7695c(mo7453c)).mo7535a(mo7453c, interfaceC0878d);
    }

    /* renamed from: a */
    public static AbstractC0880f[] m7467a(short[] sArr) {
        AbstractC0880f[] abstractC0880fArr = new AbstractC0880f[sArr.length];
        C0888n c0888n = new C0888n(sArr);
        while (c0888n.m7539f()) {
            try {
                abstractC0880fArr[c0888n.mo7449a()] = m7466a(c0888n);
            } catch (EOFException e2) {
                throw new AssertionError("shouldn't happen");
            }
        }
        return abstractC0880fArr;
    }

    public AbstractC0880f(EnumC0884j enumC0884j, int i, int i2, EnumC0903k enumC0903k, int i3, long j) {
        if (enumC0884j == null) {
            throw new NullPointerException("format == null");
        }
        if (!C0906n.m7693a(i)) {
            throw new IllegalArgumentException("invalid opcode");
        }
        this.f5334a = enumC0884j;
        this.f5335b = i;
        this.f5336c = i2;
        this.f5337d = enumC0903k;
        this.f5338e = i3;
        this.f5339f = j;
    }

    /* renamed from: a */
    public final EnumC0884j m7469a() {
        return this.f5334a;
    }

    /* renamed from: b */
    public final int m7471b() {
        return this.f5335b;
    }

    /* renamed from: c */
    public final short m7474c() {
        return (short) this.f5335b;
    }

    /* renamed from: d */
    public final int m7475d() {
        return this.f5336c;
    }

    /* renamed from: e */
    public final short m7477e() {
        return (short) this.f5336c;
    }

    /* renamed from: f */
    public final EnumC0903k m7478f() {
        return this.f5337d;
    }

    /* renamed from: g */
    public final int m7479g() {
        return this.f5338e;
    }

    /* renamed from: a */
    public final int m7468a(int i) {
        return this.f5338e - i;
    }

    /* renamed from: b */
    public final short m7472b(int i) {
        int m7468a = m7468a(i);
        if (m7468a != ((short) m7468a)) {
            throw new C1018i("Target out of range: " + C1022m.m8561g(m7468a));
        }
        return (short) m7468a;
    }

    /* renamed from: c */
    public final int m7473c(int i) {
        int m7468a = m7468a(i);
        if (m7468a != ((byte) m7468a)) {
            throw new C1018i("Target out of range: " + C1022m.m8561g(m7468a));
        }
        return m7468a & 255;
    }

    /* renamed from: h */
    public final long m7480h() {
        return this.f5339f;
    }

    /* renamed from: i */
    public final int m7481i() {
        if (this.f5339f != ((int) this.f5339f)) {
            throw new C1018i("Literal out of range: " + C1022m.m8553a(this.f5339f));
        }
        return (int) this.f5339f;
    }

    /* renamed from: j */
    public final short m7482j() {
        if (this.f5339f != ((short) this.f5339f)) {
            throw new C1018i("Literal out of range: " + C1022m.m8553a(this.f5339f));
        }
        return (short) this.f5339f;
    }

    /* renamed from: k */
    public final int m7483k() {
        if (this.f5339f != ((byte) this.f5339f)) {
            throw new C1018i("Literal out of range: " + C1022m.m8553a(this.f5339f));
        }
        return ((int) this.f5339f) & 255;
    }

    /* renamed from: l */
    public final int m7484l() {
        if (this.f5339f < -8 || this.f5339f > 7) {
            throw new C1018i("Literal out of range: " + C1022m.m8553a(this.f5339f));
        }
        return ((int) this.f5339f) & 15;
    }

    /* renamed from: n */
    public int mo7486n() {
        return 0;
    }

    /* renamed from: o */
    public int mo7487o() {
        return 0;
    }

    /* renamed from: p */
    public int mo7488p() {
        return 0;
    }

    /* renamed from: q */
    public int mo7489q() {
        return 0;
    }

    /* renamed from: r */
    public int mo7490r() {
        return 0;
    }

    /* renamed from: s */
    public final short m7491s() {
        int mo7485m = mo7485m();
        if (((-65536) & mo7485m) != 0) {
            throw new C1018i("Register count out of range: " + C1022m.m8553a(mo7485m));
        }
        return (short) mo7485m;
    }

    /* renamed from: t */
    public final short m7492t() {
        int mo7486n = mo7486n();
        if (((-65536) & mo7486n) != 0) {
            throw new C1018i("Register A out of range: " + C1022m.m8553a(mo7486n));
        }
        return (short) mo7486n;
    }

    /* renamed from: u */
    public final short m7493u() {
        int mo7487o = mo7487o();
        if (((-65536) & mo7487o) != 0) {
            throw new C1018i("Register B out of range: " + C1022m.m8553a(mo7487o));
        }
        return (short) mo7487o;
    }

    /* renamed from: v */
    public final short m7494v() {
        int mo7488p = mo7488p();
        if (((-65536) & mo7488p) != 0) {
            throw new C1018i("Register C out of range: " + C1022m.m8553a(mo7488p));
        }
        return (short) mo7488p;
    }

    /* renamed from: a */
    public final void m7470a(InterfaceC0879e interfaceC0879e) {
        this.f5334a.mo7536a(this, interfaceC0879e);
    }
}
