package p165d.p167b.p173f;

import java.p209io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CRLReasonCodeExtension.java */
/* renamed from: d.b.f.l */
/* loaded from: classes.dex */
public class C1512l extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private int f9717d;

    /* renamed from: b */
    private void m11661b() {
        if (this.f9717d == 0) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        c1449l.m11391a(this.f9717d);
        this.f9412c = c1449l.toByteArray();
    }

    public C1512l(int i) {
        this(false, i);
    }

    public C1512l(boolean z, int i) {
        this.f9717d = 0;
        this.f9411b = C1481az.f9502u;
        this.f9410a = z;
        this.f9717d = i;
        m11661b();
    }

    public C1512l(Boolean bool, Object obj) {
        this.f9717d = 0;
        this.f9411b = C1481az.f9502u;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        this.f9717d = new C1450m(this.f9412c).m11427h();
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        String str = String.valueOf(super.toString()) + "    Reason Code: ";
        switch (this.f9717d) {
            case 0:
                return String.valueOf(str) + "Unspecified";
            case 1:
                return String.valueOf(str) + "Key Compromise";
            case 2:
                return String.valueOf(str) + "CA Compromise";
            case 3:
                return String.valueOf(str) + "Affiliation Changed";
            case 4:
                return String.valueOf(str) + "Superseded";
            case 5:
                return String.valueOf(str) + "Cessation Of Operation";
            case 6:
                return String.valueOf(str) + "Certificate Hold";
            case 7:
            default:
                return String.valueOf(str) + "Unrecognized reason code (" + this.f9717d + ")";
            case 8:
                return String.valueOf(str) + "Remove from CRL";
            case 9:
                return String.valueOf(str) + "Privilege Withdrawn";
            case 10:
                return String.valueOf(str) + "AA Compromise";
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9502u;
            this.f9410a = false;
            m11661b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "CRLReasonCode";
    }
}
