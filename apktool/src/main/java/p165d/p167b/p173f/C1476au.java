package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: NameConstraintsExtension.java */
/* renamed from: d.b.f.au */
/* loaded from: classes.dex */
public class C1476au extends C1463ah implements InterfaceC1513m<String>, Cloneable {

    /* renamed from: d */
    private C1469an f9435d;

    /* renamed from: e */
    private boolean f9436e;

    /* renamed from: f */
    private C1469an f9437f;

    /* renamed from: b */
    private void m11517b() {
        this.f9436e = false;
        if (this.f9437f == null && this.f9435d == null) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        if (this.f9437f != null) {
            C1449l c1449l3 = new C1449l();
            this.f9437f.m11502a(c1449l3);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l3);
        }
        if (this.f9435d != null) {
            C1449l c1449l4 = new C1449l();
            this.f9435d.m11502a(c1449l4);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 1), c1449l4);
        }
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9412c = c1449l.toByteArray();
    }

    public C1476au(C1469an c1469an, C1469an c1469an2) {
        this.f9437f = null;
        this.f9435d = null;
        this.f9436e = false;
        this.f9437f = c1469an;
        this.f9435d = c1469an2;
        this.f9411b = C1481az.f9498q;
        this.f9410a = true;
        m11517b();
    }

    public C1476au(Boolean bool, Object obj) {
        this.f9437f = null;
        this.f9435d = null;
        this.f9436e = false;
        this.f9411b = C1481az.f9498q;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for NameConstraintsExtension.");
        }
        if (c1450m.f9356b != null) {
            while (c1450m.f9356b.m11362a() != 0) {
                C1450m m11371d = c1450m.f9356b.m11371d();
                if (m11371d.m11420b((byte) 0) && m11371d.m11437r()) {
                    if (this.f9437f != null) {
                        throw new IOException("Duplicate permitted GeneralSubtrees in NameConstraintsExtension.");
                    }
                    m11371d.m11422c((byte) 48);
                    this.f9437f = new C1469an(m11371d);
                } else if (m11371d.m11420b((byte) 1) && m11371d.m11437r()) {
                    if (this.f9435d != null) {
                        throw new IOException("Duplicate excluded GeneralSubtrees in NameConstraintsExtension.");
                    }
                    m11371d.m11422c((byte) 48);
                    this.f9435d = new C1469an(m11371d);
                } else {
                    throw new IOException("Invalid encoding of NameConstraintsExtension.");
                }
            }
            this.f9436e = false;
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + "NameConstraints: [" + (this.f9437f == null ? "" : "\n    Permitted:" + this.f9437f.toString()) + (this.f9435d == null ? "" : "\n    Excluded:" + this.f9435d.toString()) + "   ]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9498q;
            this.f9410a = true;
            m11517b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "NameConstraints";
    }

    public Object clone() {
        try {
            C1476au c1476au = (C1476au) super.clone();
            if (this.f9437f != null) {
                c1476au.f9437f = (C1469an) this.f9437f.clone();
            }
            if (this.f9435d != null) {
                c1476au.f9435d = (C1469an) this.f9435d.clone();
            }
            return c1476au;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException("CloneNotSupportedException while cloning NameConstraintsException. This should never happen.");
        }
    }
}
