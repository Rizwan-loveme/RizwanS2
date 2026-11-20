package p165d.p167b.p173f;

import java.p209io.IOException;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: EDIPartyName.java */
/* renamed from: d.b.f.af */
/* loaded from: classes.dex */
public class C1461af implements InterfaceC1466ak {

    /* renamed from: a */
    private String f9395a;

    /* renamed from: b */
    private int f9396b = -1;

    /* renamed from: c */
    private String f9397c;

    public C1461af(C1450m c1450m) {
        this.f9395a = null;
        this.f9397c = null;
        C1450m[] m11364a = new C1448k(c1450m.m11440u()).m11364a(2);
        int length = m11364a.length;
        if (length < 1 || length > 2) {
            throw new IOException("Invalid encoding of EDIPartyName");
        }
        for (int i = 0; i < length; i++) {
            C1450m c1450m2 = m11364a[i];
            if (c1450m2.m11420b((byte) 0) && !c1450m2.m11437r()) {
                if (this.f9395a != null) {
                    throw new IOException("Duplicate nameAssigner found in EDIPartyName");
                }
                c1450m2 = c1450m2.f9356b.m11371d();
                this.f9395a = c1450m2.m11415a();
            }
            if (c1450m2.m11420b((byte) 1) && !c1450m2.m11437r()) {
                if (this.f9397c != null) {
                    throw new IOException("Duplicate partyName found in EDIPartyName");
                }
                this.f9397c = c1450m2.f9356b.m11371d().m11415a();
            }
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 5;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        C1449l c1449l3 = new C1449l();
        if (this.f9395a != null) {
            C1449l c1449l4 = new C1449l();
            c1449l4.m11407c(this.f9395a);
            c1449l2.m11388a(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 0), c1449l4);
        }
        if (this.f9397c == null) {
            throw new IOException("Cannot have null partyName");
        }
        c1449l3.m11407c(this.f9397c);
        c1449l2.m11388a(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 1), c1449l3);
        c1449l.m11388a((byte) 48, c1449l2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1461af)) {
            return false;
        }
        String str = ((C1461af) obj).f9395a;
        if (this.f9395a == null) {
            if (str != null) {
                return false;
            }
        } else if (!this.f9395a.equals(str)) {
            return false;
        }
        String str2 = ((C1461af) obj).f9397c;
        if (this.f9397c == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!this.f9397c.equals(str2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f9396b == -1) {
            this.f9396b = (this.f9397c == null ? 1 : this.f9397c.hashCode()) + 37;
            if (this.f9395a != null) {
                this.f9396b = (this.f9396b * 37) + this.f9395a.hashCode();
            }
        }
        return this.f9396b;
    }

    public String toString() {
        return "EDIPartyName: " + (this.f9395a == null ? "" : "  nameAssigner = " + this.f9395a + ",") + "  partyName = " + this.f9397c;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 5) {
            return -1;
        }
        throw new UnsupportedOperationException("Narrowing, widening, and matching of names not supported for EDIPartyName");
    }
}
