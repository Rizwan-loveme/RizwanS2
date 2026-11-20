package org.p210a.p211a.p212a;

import java.util.List;
import org.p210a.p211a.p212a.p215c.C1839i;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import org.p210a.p211a.p212a.p216d.InterfaceC1851f;
import org.p210a.p211a.p212a.p216d.InterfaceC1852g;

/* compiled from: RuleContext.java */
/* renamed from: org.a.a.a.z */
/* loaded from: classes.dex */
public class C1878z implements InterfaceC1852g {

    /* renamed from: i */
    public static final C1874v f11015i = new C1874v();

    /* renamed from: j */
    public C1878z f11016j;

    /* renamed from: k */
    public int f11017k;

    public C1878z() {
        this.f11017k = -1;
    }

    public C1878z(C1878z c1878z, int i) {
        this.f11017k = -1;
        this.f11016j = c1878z;
        this.f11017k = i;
    }

    /* renamed from: m */
    public boolean m13934m() {
        return this.f11017k == -1;
    }

    /* renamed from: l */
    public C1839i mo13920l() {
        return C1839i.f10899a;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: n */
    public String mo13787n() {
        if (mo13793k() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mo13793k(); i++) {
            sb.append(mo13785b(i).mo13787n());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public int mo4288a() {
        return -1;
    }

    /* renamed from: d */
    public void m13933d(int i) {
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: b */
    public void mo13786b(C1878z c1878z) {
        this.f11016j = c1878z;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: b */
    public InterfaceC1849d mo13785b(int i) {
        return null;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1856k
    /* renamed from: k */
    public int mo13793k() {
        return 0;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: a */
    public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
        return interfaceC1851f.mo13782a(this);
    }

    public String toString() {
        return m13932a(null, null);
    }

    /* renamed from: a */
    public String m13932a(List<String> list, C1878z c1878z) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        C1878z c1878z2 = this;
        while (c1878z2 != null && c1878z2 != c1878z) {
            if (list == null) {
                if (!c1878z2.m13934m()) {
                    sb.append(c1878z2.f11017k);
                }
            } else {
                int mo4288a = c1878z2.mo4288a();
                sb.append((mo4288a < 0 || mo4288a >= list.size()) ? Integer.toString(mo4288a) : list.get(mo4288a));
            }
            if (c1878z2.f11016j != null && (list != null || !c1878z2.f11016j.m13934m())) {
                sb.append(" ");
            }
            c1878z2 = c1878z2.f11016j;
        }
        sb.append("]");
        return sb.toString();
    }
}
