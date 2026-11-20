package org.p210a.p211a.p212a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p210a.p211a.p212a.p215c.C1839i;
import org.p210a.p211a.p212a.p216d.InterfaceC1847b;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import org.p210a.p211a.p212a.p216d.InterfaceC1850e;
import org.p210a.p211a.p212a.p216d.InterfaceC1854i;

/* compiled from: ParserRuleContext.java */
/* renamed from: org.a.a.a.v */
/* loaded from: classes.dex */
public class C1874v extends C1878z {

    /* renamed from: e */
    public List<InterfaceC1849d> f10999e;

    /* renamed from: f */
    public InterfaceC1819ac f11000f;

    /* renamed from: g */
    public InterfaceC1819ac f11001g;

    /* renamed from: h */
    public C1876x f11002h;

    public C1874v() {
    }

    /* renamed from: a */
    public void m13915a(C1874v c1874v) {
        this.f11016j = c1874v.f11016j;
        this.f11017k = c1874v.f11017k;
        this.f11000f = c1874v.f11000f;
        this.f11001g = c1874v.f11001g;
        if (c1874v.f10999e != null) {
            this.f10999e = new ArrayList();
            for (InterfaceC1849d interfaceC1849d : c1874v.f10999e) {
                if (interfaceC1849d instanceof InterfaceC1847b) {
                    m13912a((InterfaceC1854i) interfaceC1849d);
                }
            }
        }
    }

    public C1874v(C1874v c1874v, int i) {
        super(c1874v, i);
    }

    /* renamed from: a */
    public void m13914a(InterfaceC1850e interfaceC1850e) {
    }

    /* renamed from: b */
    public void m13917b(InterfaceC1850e interfaceC1850e) {
    }

    /* renamed from: a */
    public <T extends InterfaceC1849d> T m13910a(T t) {
        if (this.f10999e == null) {
            this.f10999e = new ArrayList();
        }
        this.f10999e.add(t);
        return t;
    }

    /* renamed from: a */
    public C1878z m13913a(C1878z c1878z) {
        return (C1878z) m13910a((C1874v) c1878z);
    }

    /* renamed from: a */
    public InterfaceC1854i m13912a(InterfaceC1854i interfaceC1854i) {
        interfaceC1854i.mo13786b(this);
        return (InterfaceC1854i) m13910a((C1874v) interfaceC1854i);
    }

    /* renamed from: a */
    public InterfaceC1847b m13908a(InterfaceC1847b interfaceC1847b) {
        interfaceC1847b.mo13786b(this);
        return (InterfaceC1847b) m13910a((C1874v) interfaceC1847b);
    }

    /* renamed from: j */
    public void m13919j() {
        if (this.f10999e != null) {
            this.f10999e.remove(this.f10999e.size() - 1);
        }
    }

    @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: b */
    public InterfaceC1849d mo13785b(int i) {
        if (this.f10999e == null || i < 0 || i >= this.f10999e.size()) {
            return null;
        }
        return this.f10999e.get(i);
    }

    /* renamed from: a */
    public <T extends InterfaceC1849d> T m13909a(Class<? extends T> cls, int i) {
        if (this.f10999e == null || i < 0 || i >= this.f10999e.size()) {
            return null;
        }
        int i2 = -1;
        for (InterfaceC1849d interfaceC1849d : this.f10999e) {
            if (cls.isInstance(interfaceC1849d) && (i2 = i2 + 1) == i) {
                return cls.cast(interfaceC1849d);
            }
        }
        return null;
    }

    /* renamed from: a */
    public InterfaceC1854i m13911a(int i, int i2) {
        if (this.f10999e == null || i2 < 0 || i2 >= this.f10999e.size()) {
            return null;
        }
        int i3 = -1;
        for (InterfaceC1849d interfaceC1849d : this.f10999e) {
            if (interfaceC1849d instanceof InterfaceC1854i) {
                InterfaceC1854i interfaceC1854i = (InterfaceC1854i) interfaceC1849d;
                if (interfaceC1854i.mo13792a().mo13672a() == i && (i3 = i3 + 1) == i2) {
                    return interfaceC1854i;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public List<InterfaceC1854i> m13918c(int i) {
        if (this.f10999e == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = null;
        for (InterfaceC1849d interfaceC1849d : this.f10999e) {
            if (interfaceC1849d instanceof InterfaceC1854i) {
                InterfaceC1854i interfaceC1854i = (InterfaceC1854i) interfaceC1849d;
                if (interfaceC1854i.mo13792a().mo13672a() == i) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(interfaceC1854i);
                }
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }

    /* renamed from: b */
    public <T extends C1874v> T m13916b(Class<? extends T> cls, int i) {
        return (T) m13909a(cls, i);
    }

    /* renamed from: a */
    public <T extends C1874v> List<T> m13907a(Class<? extends T> cls) {
        if (this.f10999e == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = null;
        for (InterfaceC1849d interfaceC1849d : this.f10999e) {
            if (cls.isInstance(interfaceC1849d)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cls.cast(interfaceC1849d));
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }

    @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1856k
    /* renamed from: k */
    public int mo13793k() {
        if (this.f10999e != null) {
            return this.f10999e.size();
        }
        return 0;
    }

    @Override // org.p210a.p211a.p212a.C1878z
    /* renamed from: l */
    public C1839i mo13920l() {
        if (this.f11000f == null) {
            return C1839i.f10899a;
        }
        if (this.f11001g == null || this.f11001g.mo13679h() < this.f11000f.mo13679h()) {
            return C1839i.m13746a(this.f11000f.mo13679h(), this.f11000f.mo13679h() - 1);
        }
        return C1839i.m13746a(this.f11000f.mo13679h(), this.f11001g.mo13679h());
    }
}
