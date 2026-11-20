package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import java.util.Iterator;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: IssuerAlternativeNameExtension.java */
/* renamed from: d.b.f.aq */
/* loaded from: classes.dex */
public class C1472aq extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    C1467al f9426d;

    /* renamed from: b */
    private void m11508b() {
        if (this.f9426d == null || this.f9426d.m11497a()) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        this.f9426d.m11496a(c1449l);
        this.f9412c = c1449l.toByteArray();
    }

    public C1472aq(C1467al c1467al) {
        this.f9426d = null;
        this.f9426d = c1467al;
        this.f9411b = C1481az.f9495n;
        this.f9410a = false;
        m11508b();
    }

    public C1472aq() {
        this.f9426d = null;
        this.f9411b = C1481az.f9495n;
        this.f9410a = false;
        this.f9426d = new C1467al();
    }

    public C1472aq(Boolean bool, Object obj) {
        this.f9426d = null;
        this.f9411b = C1481az.f9495n;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9356b == null) {
            this.f9426d = new C1467al();
        } else {
            this.f9426d = new C1467al(c1450m);
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        String str;
        String str2 = String.valueOf(super.toString()) + "IssuerAlternativeName [\n";
        if (this.f9426d == null) {
            str = String.valueOf(str2) + "  null\n";
        } else {
            Iterator<C1465aj> it = this.f9426d.m11498b().iterator();
            while (it.hasNext()) {
                str2 = String.valueOf(str2) + "  " + it.next() + "\n";
            }
            str = str2;
        }
        return String.valueOf(str) + "]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9495n;
            this.f9410a = false;
            m11508b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public C1467al m11509a(String str) {
        if (str.equalsIgnoreCase("issuer_name")) {
            return this.f9426d;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:IssuerAlternativeName.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "IssuerAlternativeName";
    }
}
