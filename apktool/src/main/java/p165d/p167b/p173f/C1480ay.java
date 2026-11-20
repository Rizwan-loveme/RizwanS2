package p165d.p167b.p173f;

import java.p209io.IOException;
import java.util.Arrays;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: OtherName.java */
/* renamed from: d.b.f.ay */
/* loaded from: classes.dex */
public class C1480ay implements InterfaceC1466ak {

    /* renamed from: a */
    private InterfaceC1466ak f9453a;

    /* renamed from: b */
    private int f9454b = -1;

    /* renamed from: c */
    private String f9455c;

    /* renamed from: d */
    private byte[] f9456d;

    /* renamed from: e */
    private C1454q f9457e;

    public C1480ay(C1450m c1450m) {
        this.f9456d = null;
        this.f9453a = null;
        C1448k m11441v = c1450m.m11441v();
        this.f9457e = m11441v.m11376h();
        this.f9456d = m11441v.m11371d().m11440u();
        this.f9453a = m11525a(this.f9457e, this.f9456d);
        if (this.f9453a != null) {
            this.f9455c = this.f9453a.toString();
        } else {
            this.f9455c = "Unrecognized ObjectIdentifier: " + this.f9457e.toString();
        }
    }

    /* renamed from: a */
    private InterfaceC1466ak m11525a(C1454q c1454q, byte[] bArr) {
        try {
            Class<?> m11520a = C1478aw.m11520a(c1454q);
            if (m11520a == null) {
                return null;
            }
            return (InterfaceC1466ak) m11520a.getConstructor(Object.class).newInstance(bArr);
        } catch (Exception e2) {
            throw new IOException("Instantiation error: " + e2, e2);
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 0;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        if (this.f9453a != null) {
            this.f9453a.mo11479a(c1449l);
            return;
        }
        C1449l c1449l2 = new C1449l();
        c1449l2.m11394a(this.f9457e);
        c1449l2.m11389a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), this.f9456d);
        c1449l.m11388a((byte) 48, c1449l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1480ay) {
            C1480ay c1480ay = (C1480ay) obj;
            if (c1480ay.f9457e.equals(this.f9457e)) {
                try {
                    InterfaceC1466ak m11525a = m11525a(c1480ay.f9457e, c1480ay.f9456d);
                    if (m11525a == null) {
                        return Arrays.equals(this.f9456d, c1480ay.f9456d);
                    }
                    try {
                        return m11525a.mo11477a(this) == 0;
                    } catch (UnsupportedOperationException e2) {
                        return false;
                    }
                } catch (IOException e3) {
                    return false;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f9454b == -1) {
            this.f9454b = this.f9457e.hashCode() + 37;
            for (int i = 0; i < this.f9456d.length; i++) {
                this.f9454b = (this.f9454b * 37) + this.f9456d[i];
            }
        }
        return this.f9454b;
    }

    public String toString() {
        return "Other-Name: " + this.f9455c;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 0) {
            return -1;
        }
        throw new UnsupportedOperationException("Narrowing, widening, and matching are not supported for OtherName.");
    }
}
