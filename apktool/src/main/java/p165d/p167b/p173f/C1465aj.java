package p165d.p167b.p173f;

import java.io.IOException;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: GeneralName.java */
/* renamed from: d.b.f.aj */
/* loaded from: classes.dex */
public class C1465aj {

    /* renamed from: a */
    private InterfaceC1466ak f9413a;

    public C1465aj(C1450m c1450m) {
        this(c1450m, false);
    }

    public C1465aj(C1450m c1450m, boolean z) {
        this.f9413a = null;
        byte b2 = (byte) (c1450m.f9357c & 31);
        switch (b2) {
            case 0:
                if (c1450m.m11438s() && c1450m.m11437r()) {
                    c1450m.m11422c((byte) 48);
                    this.f9413a = new C1480ay(c1450m);
                    return;
                }
                throw new IOException("Invalid encoding of Other-Name");
            case 1:
                if (c1450m.m11438s() && !c1450m.m11437r()) {
                    c1450m.m11422c((byte) 22);
                    this.f9413a = new C1488bf(c1450m);
                    return;
                }
                throw new IOException("Invalid encoding of RFC822 name");
            case 2:
                if (c1450m.m11438s() && !c1450m.m11437r()) {
                    c1450m.m11422c((byte) 22);
                    this.f9413a = new C1457ab(c1450m);
                    return;
                }
                throw new IOException("Invalid encoding of DNS name");
            case 3:
            default:
                throw new IOException("Unrecognized GeneralName tag, (" + ((int) b2) + ")");
            case 4:
                if (c1450m.m11438s() && c1450m.m11437r()) {
                    this.f9413a = new C1496bn(c1450m.m11425f());
                    return;
                }
                throw new IOException("Invalid encoding of Directory name");
            case 5:
                if (c1450m.m11438s() && c1450m.m11437r()) {
                    c1450m.m11422c((byte) 48);
                    this.f9413a = new C1461af(c1450m);
                    return;
                }
                throw new IOException("Invalid encoding of EDI name");
            case 6:
                if (c1450m.m11438s() && !c1450m.m11437r()) {
                    c1450m.m11422c((byte) 22);
                    this.f9413a = z ? C1493bk.m11548a(c1450m) : new C1493bk(c1450m);
                    return;
                }
                throw new IOException("Invalid encoding of URI");
            case 7:
                if (c1450m.m11438s() && !c1450m.m11437r()) {
                    c1450m.m11422c((byte) 4);
                    this.f9413a = new C1470ao(c1450m);
                    return;
                }
                throw new IOException("Invalid encoding of IP address");
            case 8:
                if (c1450m.m11438s() && !c1450m.m11437r()) {
                    c1450m.m11422c((byte) 6);
                    this.f9413a = new C1479ax(c1450m);
                    return;
                }
                throw new IOException("Invalid encoding of OID name");
        }
    }

    /* renamed from: a */
    public InterfaceC1466ak m11492a() {
        return this.f9413a;
    }

    public String toString() {
        return this.f9413a.toString();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof C1465aj)) {
                return false;
            }
            try {
                if (this.f9413a.mo11477a(((C1465aj) obj).f9413a) != 0) {
                    return false;
                }
            } catch (UnsupportedOperationException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f9413a.hashCode();
    }

    /* renamed from: a */
    public void m11493a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        this.f9413a.mo11479a(c1449l2);
        int mo11480b = this.f9413a.mo11480b();
        if (mo11480b == 0 || mo11480b == 3 || mo11480b == 5) {
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) mo11480b), c1449l2);
        } else if (mo11480b == 4) {
            c1449l.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) mo11480b), c1449l2);
        } else {
            c1449l.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) mo11480b), c1449l2);
        }
    }
}
