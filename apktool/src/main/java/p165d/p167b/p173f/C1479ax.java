package p165d.p167b.p173f;

import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: OIDName.java */
/* renamed from: d.b.f.ax */
/* loaded from: classes.dex */
public class C1479ax implements InterfaceC1466ak {

    /* renamed from: a */
    private C1454q f9452a;

    public C1479ax(C1450m c1450m) {
        this.f9452a = c1450m.m11431l();
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 8;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        c1449l.m11394a(this.f9452a);
    }

    public String toString() {
        return "OIDName: " + this.f9452a.toString();
    }

    /* renamed from: a */
    public C1454q m11524a() {
        return this.f9452a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1479ax)) {
            return false;
        }
        return this.f9452a.equals(((C1479ax) obj).f9452a);
    }

    public int hashCode() {
        return this.f9452a.hashCode();
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 8) {
            return -1;
        }
        if (equals((C1479ax) interfaceC1466ak)) {
            return 0;
        }
        throw new UnsupportedOperationException("Narrowing and widening are not supported for OIDNames");
    }
}
