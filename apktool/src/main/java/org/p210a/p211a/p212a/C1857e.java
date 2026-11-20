package org.p210a.p211a.p212a;

import java.util.ArrayList;
import java.util.List;
import org.p210a.p211a.p212a.p215c.C1839i;

/* compiled from: BufferedTokenStream.java */
/* renamed from: org.a.a.a.e */
/* loaded from: classes.dex */
public class C1857e implements InterfaceC1822af {

    /* renamed from: e */
    static final /* synthetic */ boolean f10916e;

    /* renamed from: a */
    protected InterfaceC1821ae f10917a;

    /* renamed from: b */
    protected List<InterfaceC1819ac> f10918b = new ArrayList(100);

    /* renamed from: c */
    protected int f10919c = -1;

    /* renamed from: d */
    protected boolean f10920d;

    static {
        f10916e = !C1857e.class.desiredAssertionStatus();
    }

    public C1857e(InterfaceC1821ae interfaceC1821ae) {
        if (interfaceC1821ae == null) {
            throw new NullPointerException("tokenSource cannot be null");
        }
        this.f10917a = interfaceC1821ae;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1822af
    /* renamed from: a */
    public InterfaceC1821ae mo13687a() {
        return this.f10917a;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: c */
    public int mo13717c() {
        return this.f10919c;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: e */
    public int mo13720e() {
        return 0;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: b */
    public void mo13716b(int i) {
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: c */
    public void mo13718c(int i) {
        m13801f();
        this.f10919c = mo13805i(i);
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: d */
    public int mo13719d() {
        return this.f10918b.size();
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: b */
    public void mo13715b() {
        boolean z = false;
        if (this.f10919c >= 0) {
            if (this.f10920d) {
                if (this.f10919c < this.f10918b.size() - 1) {
                    z = true;
                }
            } else if (this.f10919c < this.f10918b.size()) {
                z = true;
            }
        }
        if (!z && mo13711a(1) == -1) {
            throw new IllegalStateException("cannot consume EOF");
        }
        if (m13799d(this.f10919c + 1)) {
            this.f10919c = mo13805i(this.f10919c + 1);
        }
    }

    /* renamed from: d */
    protected boolean m13799d(int i) {
        if (!f10916e && i < 0) {
            throw new AssertionError();
        }
        int size = (i - this.f10918b.size()) + 1;
        return size <= 0 || m13800e(size) >= size;
    }

    /* renamed from: e */
    protected int m13800e(int i) {
        if (this.f10920d) {
            return 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            InterfaceC1819ac mo4722f = this.f10917a.mo4722f();
            if (mo4722f instanceof InterfaceC1825ai) {
                ((InterfaceC1825ai) mo4722f).mo13695c(this.f10918b.size());
            }
            this.f10918b.add(mo4722f);
            if (mo4722f.mo13672a() == -1) {
                this.f10920d = true;
                return i2 + 1;
            }
        }
        return i;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1822af
    /* renamed from: f */
    public InterfaceC1819ac mo13688f(int i) {
        if (i < 0 || i >= this.f10918b.size()) {
            throw new IndexOutOfBoundsException("token index " + i + " out of range 0.." + (this.f10918b.size() - 1));
        }
        return this.f10918b.get(i);
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: a */
    public int mo13711a(int i) {
        return mo13689h(i).mo13672a();
    }

    /* renamed from: g */
    protected InterfaceC1819ac mo13802g(int i) {
        if (this.f10919c - i < 0) {
            return null;
        }
        return this.f10918b.get(this.f10919c - i);
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1822af
    /* renamed from: h */
    public InterfaceC1819ac mo13689h(int i) {
        m13801f();
        if (i == 0) {
            return null;
        }
        if (i < 0) {
            return mo13802g(-i);
        }
        int i2 = (this.f10919c + i) - 1;
        m13799d(i2);
        if (i2 >= this.f10918b.size()) {
            return this.f10918b.get(this.f10918b.size() - 1);
        }
        return this.f10918b.get(i2);
    }

    /* renamed from: i */
    protected int mo13805i(int i) {
        return i;
    }

    /* renamed from: f */
    protected final void m13801f() {
        if (this.f10919c == -1) {
            m13803g();
        }
    }

    /* renamed from: g */
    protected void m13803g() {
        m13799d(0);
        this.f10919c = mo13805i(0);
    }

    /* renamed from: a */
    public void m13797a(InterfaceC1821ae interfaceC1821ae) {
        this.f10917a = interfaceC1821ae;
        this.f10918b.clear();
        this.f10919c = -1;
        this.f10920d = false;
    }

    /* renamed from: a */
    protected int m13794a(int i, int i2) {
        m13799d(i);
        if (i >= mo13719d()) {
            return mo13719d() - 1;
        }
        InterfaceC1819ac interfaceC1819ac = this.f10918b.get(i);
        while (true) {
            InterfaceC1819ac interfaceC1819ac2 = interfaceC1819ac;
            if (interfaceC1819ac2.mo13676e() != i2 && interfaceC1819ac2.mo13672a() != -1) {
                i++;
                m13799d(i);
                interfaceC1819ac = this.f10918b.get(i);
            } else {
                return i;
            }
        }
    }

    /* renamed from: b */
    protected int m13798b(int i, int i2) {
        m13799d(i);
        if (i >= mo13719d()) {
            return mo13719d() - 1;
        }
        int i3 = i;
        while (i3 >= 0) {
            InterfaceC1819ac interfaceC1819ac = this.f10918b.get(i3);
            if (interfaceC1819ac.mo13672a() == -1 || interfaceC1819ac.mo13676e() == i2) {
                return i3;
            }
            i3--;
        }
        return i3;
    }

    /* renamed from: a */
    public String m13795a(C1839i c1839i) {
        int i = c1839i.f10905c;
        int i2 = c1839i.f10906d;
        if (i < 0 || i2 < 0) {
            return "";
        }
        m13804h();
        int size = i2 >= this.f10918b.size() ? this.f10918b.size() - 1 : i2;
        StringBuilder sb = new StringBuilder();
        while (i <= size) {
            InterfaceC1819ac interfaceC1819ac = this.f10918b.get(i);
            if (interfaceC1819ac.mo13672a() == -1) {
                break;
            }
            sb.append(interfaceC1819ac.mo13673b());
            i++;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m13796a(C1878z c1878z) {
        return m13795a(c1878z.mo13920l());
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1822af
    /* renamed from: a */
    public String mo13686a(InterfaceC1819ac interfaceC1819ac, InterfaceC1819ac interfaceC1819ac2) {
        return (interfaceC1819ac == null || interfaceC1819ac2 == null) ? "" : m13795a(C1839i.m13746a(interfaceC1819ac.mo13679h(), interfaceC1819ac2.mo13679h()));
    }

    /* renamed from: h */
    public void m13804h() {
        m13801f();
        while (m13800e(1000) >= 1000) {
        }
    }
}
