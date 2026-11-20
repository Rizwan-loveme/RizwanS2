package org.p210a.p211a.p212a.p213a;

import java.util.Arrays;
import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerActionExecutor.java */
/* renamed from: org.a.a.a.a.x */
/* loaded from: classes.dex */
public class C1814x {

    /* renamed from: a */
    private final InterfaceC1813w[] f10834a;

    /* renamed from: b */
    private final int f10835b;

    public C1814x(InterfaceC1813w[] interfaceC1813wArr) {
        this.f10834a = interfaceC1813wArr;
        int m13770a = C1841k.m13770a();
        for (InterfaceC1813w interfaceC1813w : interfaceC1813wArr) {
            m13770a = C1841k.m13773a(m13770a, interfaceC1813w);
        }
        this.f10835b = C1841k.m13775b(m13770a, interfaceC1813wArr.length);
    }

    /* renamed from: a */
    public static C1814x m13666a(C1814x c1814x, InterfaceC1813w interfaceC1813w) {
        if (c1814x == null) {
            return new C1814x(new InterfaceC1813w[]{interfaceC1813w});
        }
        InterfaceC1813w[] interfaceC1813wArr = (InterfaceC1813w[]) Arrays.copyOf(c1814x.f10834a, c1814x.f10834a.length + 1);
        interfaceC1813wArr[interfaceC1813wArr.length - 1] = interfaceC1813w;
        return new C1814x(interfaceC1813wArr);
    }

    /* renamed from: a */
    public C1814x m13667a(int i) {
        InterfaceC1813w[] interfaceC1813wArr = null;
        for (int i2 = 0; i2 < this.f10834a.length; i2++) {
            if (this.f10834a[i2].mo13489a() && !(this.f10834a[i2] instanceof C1761ab)) {
                if (interfaceC1813wArr == null) {
                    interfaceC1813wArr = (InterfaceC1813w[]) this.f10834a.clone();
                }
                interfaceC1813wArr[i2] = new C1761ab(i, this.f10834a[i2]);
            }
        }
        return interfaceC1813wArr == null ? this : new C1814x(interfaceC1813wArr);
    }

    /* renamed from: a */
    public void m13668a(AbstractC1870r abstractC1870r, InterfaceC1858f interfaceC1858f, int i) {
        boolean z = false;
        int c2 = interfaceC1858f.mo13717c();
        try {
            boolean z2 = false;
            for (InterfaceC1813w interfaceC1813w : this.f10834a) {
                try {
                    if (interfaceC1813w instanceof C1761ab) {
                        int m13491b = ((C1761ab) interfaceC1813w).m13491b();
                        interfaceC1858f.mo13718c(i + m13491b);
                        interfaceC1813w = ((C1761ab) interfaceC1813w).m13492c();
                        z2 = m13491b + i != c2;
                    } else if (interfaceC1813w.mo13489a()) {
                        interfaceC1858f.mo13718c(c2);
                        z2 = false;
                    }
                    interfaceC1813w.mo13488a(abstractC1870r);
                } catch (Throwable th) {
                    th = th;
                    z = z2;
                    if (z) {
                        interfaceC1858f.mo13718c(c2);
                    }
                    throw th;
                }
            }
            if (z2) {
                interfaceC1858f.mo13718c(c2);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int hashCode() {
        return this.f10835b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1814x)) {
            return false;
        }
        C1814x c1814x = (C1814x) obj;
        return this.f10835b == c1814x.f10835b && Arrays.equals(this.f10834a, c1814x.f10834a);
    }
}
