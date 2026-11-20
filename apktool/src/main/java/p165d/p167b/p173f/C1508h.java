package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: BasicConstraintsExtension.java */
/* renamed from: d.b.f.h */
/* loaded from: classes.dex */
public class C1508h extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private boolean f9707d;

    /* renamed from: e */
    private int f9708e;

    /* renamed from: b */
    private void m11648b() {
        if (!this.f9707d && this.f9708e < 0) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        if (this.f9707d) {
            c1449l2.m11398a(this.f9707d);
        }
        if (this.f9708e >= 0) {
            c1449l2.m11401b(this.f9708e);
        }
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9412c = c1449l.toByteArray();
    }

    public C1508h(boolean z, int i) {
        this(Boolean.valueOf(z), z, i);
    }

    public C1508h(Boolean bool, boolean z, int i) {
        this.f9707d = false;
        this.f9708e = -1;
        this.f9707d = z;
        this.f9708e = i;
        this.f9411b = C1481az.f9484c;
        this.f9410a = bool.booleanValue();
        m11648b();
    }

    public C1508h(Boolean bool, Object obj) {
        this.f9707d = false;
        this.f9708e = -1;
        this.f9411b = C1481az.f9484c;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding of BasicConstraints");
        }
        if (c1450m.f9356b != null) {
            C1450m m11371d = c1450m.f9356b.m11371d();
            if (m11371d.f9357c == 1) {
                this.f9707d = m11371d.m11424e();
                if (c1450m.f9356b.m11362a() == 0) {
                    this.f9708e = Integer.MAX_VALUE;
                    return;
                }
                C1450m m11371d2 = c1450m.f9356b.m11371d();
                if (m11371d2.f9357c != 2) {
                    throw new IOException("Invalid encoding of BasicConstraints");
                }
                this.f9708e = m11371d2.m11430k();
            }
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        String str;
        String str2 = String.valueOf(String.valueOf(super.toString()) + "BasicConstraints:[\n") + (this.f9707d ? "  CA:true" : "  CA:false") + "\n";
        if (this.f9708e >= 0) {
            str = String.valueOf(str2) + "  PathLen:" + this.f9708e + "\n";
        } else {
            str = String.valueOf(str2) + "  PathLen: undefined\n";
        }
        return String.valueOf(str) + "]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9484c;
            if (this.f9707d) {
                this.f9410a = true;
            } else {
                this.f9410a = false;
            }
            m11648b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public Object m11649a(String str) {
        if (str.equalsIgnoreCase("is_ca")) {
            return Boolean.valueOf(this.f9707d);
        }
        if (str.equalsIgnoreCase("path_len")) {
            return Integer.valueOf(this.f9708e);
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:BasicConstraints.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "BasicConstraints";
    }
}
